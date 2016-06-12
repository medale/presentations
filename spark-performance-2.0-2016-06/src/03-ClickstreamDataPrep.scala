// Databricks notebook source exported at Sun, 12 Jun 2016 18:00:24 UTC
// MAGIC %md #![Wikipedia Logo Tiny](http://curriculum-release.s3-website-us-west-2.amazonaws.com/wiki-book/general/logo_wikipedia_tiny.png) ![Spark Logo Tiny](http://curriculum-release.s3-website-us-west-2.amazonaws.com/wiki-book/general/logo_spark_tiny.png) Wikipedia Clickstream from .tsv to parquet

// COMMAND ----------

val clickstreamDf = sqlContext.read.format("com.databricks.spark.csv")
  .option("header", "true")
  .option("delimiter", "\\t")
  .option("mode", "PERMISSIVE")
  .option("inferSchema", "true")
  .load("/mnt/markus/2016_04_en_clickstream.tsv").repartition(8)

// COMMAND ----------

clickstreamDf.first()

// COMMAND ----------

// MAGIC %md # Output into efficient Parquet storage
// MAGIC 
// MAGIC * Pushdown predicates
// MAGIC * Could also use partitioning for frequently used filters, for example: .partitionBy("type")

// COMMAND ----------

clickstreamDf.write.
    mode(SaveMode.Overwrite).
    parquet("/mnt/markus/clickstream-en-2016-04")

// COMMAND ----------

// MAGIC %fs ls /mnt/markus/clickstream-en-2016-04
