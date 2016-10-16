# Speaker background
* Saw first Java presentation in 1996 ACM at UT
* Programming in Java since 1999
* Scala (seriously in November 2012, Martin Odersky, Functional Programming in Scala, Coursera)
* Big data processing Hadoop since 2010, Spark since 2014
* Teaching JHU grad comp sci, Hadoop for UMBC Training, Spark for Databricks

# Scala to Java bytecode
* JIT
* JVMs for most OS and Android Dalvik(old) now Android Runtime (ART)

# Functional Programming
* declarative: expressions - operators, functions, constants (focus on what)
* imperative programming - statements that change program state (focus on how)
* first class: no restrictions on their use, anywhere in program, highest level
* can create and capture reference, pass around
* higher-order functions - function can take function args or return functions
* Pure functions - no side effects, eventually I/O is needed

# Scala Shell
```
:cp /home/medale/Downloads/config-1.3.1.jar

import com.typesafe.config.ConfigFactory

val configStr = """{ s3 :
  |{ inputBucket : my-input-bucket,
    |  outputBucket : my-output-bucket
    |}}""".stripMargin

val config = ConfigFactory.parseString(configStr)

val inputBucket = if (config.hasPath("s3.inputBucket")) {
      config.getString("s3.inputBucket")
} else {
        "my-input-bucket-default"
}
```
