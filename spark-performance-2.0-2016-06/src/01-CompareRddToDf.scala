// Databricks notebook source exported at Sun, 12 Jun 2016 17:58:08 UTC
// MAGIC %md #![Wikipedia Logo Tiny](http://curriculum-release.s3-website-us-west-2.amazonaws.com/wiki-book/general/logo_wikipedia_tiny.png) ![Spark Logo Tiny](http://curriculum-release.s3-website-us-west-2.amazonaws.com/wiki-book/general/logo_spark_tiny.png) Wikipedia Clickstream
// MAGIC 
// MAGIC Downloaded following links to March 2016 dataset from https://datahub.io/dataset/wikipedia-clickstream. 318MB compressed (959MB uncompressed).
// MAGIC 
// MAGIC ![Clickstream articles](http://curriculum-release.s3-website-us-west-2.amazonaws.com/wiki-book/clickstream/clickstream_articles.png)
// MAGIC 
// MAGIC ## Schema details
// MAGIC 
// MAGIC Note: Field descriptions from https://meta.wikimedia.org/wiki/Research:Wikipedia_clickstream:
// MAGIC 
// MAGIC * **prev**: the result of mapping the referer URL
// MAGIC      * an article in the main namespace -> the article title
// MAGIC      * a page from any other Wikimedia project -> other-internal
// MAGIC      * an external search engine -> other-search
// MAGIC      * any other external site -> other-external
// MAGIC      * an empty referer -> other-empty
// MAGIC      * anything else -> other-other
// MAGIC * **curr**: the title of the article the client requested
// MAGIC * **type**: describes (prev, curr)
// MAGIC      * **link**: if the referer and request are both articles and the referer links to the request
// MAGIC      * **external**: if the referer host is not en(.m)?.wikipedia.org
// MAGIC      * **other**: if the referer and request are both articles but the referer does not link to the request. This can happen when clients search or spoof their refer.
// MAGIC * **n**: the number of occurrences of the (referer, resource) pair

// COMMAND ----------

// MAGIC %fs ls /mnt/markus/2016_04_en_clickstream.tsv

// COMMAND ----------

// MAGIC %md 959MB uncompressed...

// COMMAND ----------

// MAGIC %md Create Parser and Entry case class (thanks to Brian Clapper for similiar example on Wikipedia page count!)

// COMMAND ----------

case class Entry(previous: String, current: String, refererType: String, count: Long)

object LineParser {

  def parseLine(line: String) = {
    line.split("""\t""") match {
      case Array(previous, current, refererType, count) =>
        if (count.forall(_.isDigit)) {
           Some(Entry(previous, current, refererType, count.toLong))
        } else {
          None //discard header line
        }
      case _ =>
        None
    }
  }
}

// COMMAND ----------

// MAGIC %md ## Creating an RDD of lines (String) and RDD of Entry objects

// COMMAND ----------

// MAGIC %md SparkSession - new entry point to Datasets (and Dataset\[Row\] == DataFrame)

// COMMAND ----------

spark

// COMMAND ----------

val clickstreamLinesRdd = spark.sparkContext.textFile("/mnt/markus/2016_04_en_clickstream.tsv")  //or sc.textFile...

// COMMAND ----------

clickstreamLinesRdd.setName("clickstreamLinesRdd").cache().count()

// COMMAND ----------

val clickstreamEntriesRdd = spark.sparkContext.textFile("/mnt/markus/2016_04_en_clickstream.tsv").flatMap(line => LineParser.parseLine(line))

// COMMAND ----------

clickstreamEntriesRdd.setName("clickstreamEntriesRdd").cache().count()

// COMMAND ----------

// MAGIC %md ## DataFrame of Lines (String) and DataFrame of Entry objects

// COMMAND ----------

val clickstreamLinesDf = spark.read.text("/mnt/markus/2016_04_en_clickstream.tsv")

// COMMAND ----------

//No setName on Dataset - https://issues.apache.org/jira/browse/SPARK-8480
//Must run this on Spark 2.0.0 or later
clickstreamLinesDf.createOrReplaceTempView("clickstreamLinesDf")
sqlContext.cacheTable("clickstreamLinesDf")
clickstreamLinesDf.count()

// COMMAND ----------

// MAGIC %md Note: DataFrame flatMap before 2.0 returned RDD of Row - now Dataset

// COMMAND ----------

val clickstreamEntriesDf = spark.read.text("/mnt/markus/2016_04_en_clickstream.tsv").flatMap(line => LineParser.parseLine(line)).toDF

// COMMAND ----------

clickstreamEntriesDf.cache()
clickstreamEntriesDf.count()

// COMMAND ----------

// MAGIC %md ## Compare String RDD vs. Entry RDD vs. String DataFrame
// MAGIC 
// MAGIC * String RDD: 2.8 GB
// MAGIC * Entry RDD: 5.0 GB
// MAGIC * String DF: In-memory table 1021.5 MB (String only)
// MAGIC * Entries DF: 789.8 MB (String, String, int, long)
