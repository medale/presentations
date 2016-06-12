// Databricks notebook source exported at Sun, 12 Jun 2016 17:59:59 UTC
// MAGIC %md # Compare Spark 1.6.x vs. Spark 2.0.x for processing Wikipedia Clickstream from .tsv file

// COMMAND ----------

// MAGIC %md The clickstream.tsv file looks like this - we'll use [spark-csv](https://spark-packages.org/package/databricks/spark-csv) to process:
// MAGIC 
// MAGIC ```
// MAGIC prev    curr    type    n
// MAGIC !_(disambiguation)      Factorial       link    84
// MAGIC (225088)_2007_OR10      Haumea  link    54
// MAGIC (Do_the)_Mashed_Potatoes        Mashed_Potato_(dance)   link    16
// MAGIC ...
// MAGIC ```

// COMMAND ----------

val clickstreamDf = sqlContext.read.format("com.databricks.spark.csv")
  .option("header", "true")
  .option("delimiter", "\\t")
  .option("mode", "PERMISSIVE")
  .option("inferSchema", "true")
  .load("/mnt/markus/2016_04_en_clickstream.tsv")

// COMMAND ----------

// MAGIC %md ## Processing with Spark 1.6.x cluster:

// COMMAND ----------

import org.apache.spark.sql.functions.sum

val hillaryClicks = clickstreamDf.filter($"curr" === "Hillary_Clinton").
   select(sum($"n")).
   first(). //returns Row object to driver
   getLong(0)

val trumpClicks = clickstreamDf.filter($"curr" === "Donald_Trump").
   select(sum($"n")).
   first().
   getLong(0)

// COMMAND ----------

// MAGIC %md ## Processing with Spark 2.0 cluster:

// COMMAND ----------

import org.apache.spark.sql.functions.sum

val hillaryClicks = clickstreamDf.filter($"curr" === "Hillary_Clinton").
   select(sum($"n")).
   first(). //returns Row object to driver
   getLong(0)

val trumpClicks = clickstreamDf.filter($"curr" === "Donald_Trump").
   select(sum($"n")).
   first().
   getLong(0)

// COMMAND ----------

// MAGIC %md ## Explain() augmented with * for Whole Stage Code Generated

// COMMAND ----------

clickstreamDf.filter($"curr" === "Hillary_Clinton").
   select(sum($"n")).
   explain()
