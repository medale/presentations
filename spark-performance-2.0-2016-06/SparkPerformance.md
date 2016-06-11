% Performance Improvements in Apache Spark 2.0
% Whole Stage Code Generation and Vectorization
% Markus Dale, Databricks, June 2016

# What's in Apache Spark 2.0.0?

* [Over 2,000 JIRA tickets](https://issues.apache.org/jira/browse/SPARK-15839?jql=project%20%3D%20SPARK%20AND%20%22Target%20Version%2Fs%22%20%3D%202.0.0)
* Some examples: 
     * [(Dataset-oriented) API evolution in Spark 2.0](https://issues.apache.org/jira/browse/SPARK-13485) 
     * [Create a full-fledged built-in SQL parser](https://issues.apache.org/jira/browse/SPARK-12362)
     * [Add support for off-heap caching](https://issues.apache.org/jira/browse/SPARK-13992)
     * [Umbrella for Model export/import for Pipeline API](https://issues.apache.org/jira/browse/SPARK-6725)
     * [Epic: Whole stage codegen](https://issues.apache.org/jira/browse/SPARK-12795)

# Project Tungsten - Closer to bare metal
* Tungsten 1.0:
     * Memory management and binary processing
     * Code generation for expression evaluation
     * See Project Tungsten: Bringing Apache Spark Closer to Bare Metal, @xin_project_2015

# Project Tungsten 2.0 - reduce CPU bottlenecks
* virtual function calls
* reading or writing intermediate data to CPU cache or memory
* all following graphs from @agarwal_apache_2016

# Simple aggregate query with filter

![Filtered count query](images/FilteredCount.png)

# Pre-2.0 Apache Spark: Volcano Iterator Model

![](images/VolcanoFilter.png)

See @graefe_volcano-extensible_1994

# Handwritten Code

```scala
var count = 0
for (ss_item_sk in store_sales) {
   if (ss_item_sk == 1000) {
      count += 1
   }
}
```

# Handwritten vs. Volcano
* Single threaded data from Parquet on disk

![](images/HandcodedVsVolcano.png)

# Whole Stage Code Generation
* No virtual function dispatches
* Intermediate data in CPU registers
* Loop unrolling and SIMD

# Whole Stage Code Generation

![](images/WholeStageCodeGeneration.png)

# explain()
* Mark with *

# Vectorization



# Demo

org.apache.spark.sql.execution.vectorized.ColumnarBatch.Row

spark.sql("select count(a) from df").explain()

SparkSession SparkSession.builder.getOrCreate()

# References {.allowframebreaks}
