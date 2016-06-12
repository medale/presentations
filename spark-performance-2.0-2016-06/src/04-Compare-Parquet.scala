// Databricks notebook source exported at Sun, 12 Jun 2016 18:00:50 UTC
// MAGIC %md # Compare Spark 1.6.x vs. Spark 2.0.x for processing Wikipedia Clickstream from Parquet

// COMMAND ----------

val clickstreamDf = sqlContext.read.parquet("/mnt/markus/clickstream-en-2016-04")

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
