# What's in Apache Spark 2.0.0?

* Dataset evolution: SparkSession (entry to Dataset/DataFrame - not SQLContext(sc))

# Project Tungsten - Closer to bare metal
* Memory management and binary processing
     * JVM GC, 2 bytes UTF-16 encoding, header, hash code
     * C-style memory access - sun.misc.Unsafe
     * Spark manages memory
* Code generation: Don't create object, compare binary

# Project Tungsten 2.0 - reduce CPU bottlenecks
* virtual function calls
* Use CPU registers instead of cache/memory

# Simple aggregate query with filter
* count how many items have the sk 1000

# Pre-2.0 Apache Spark: Volcano Iterator Model 
* Graefe, 1994 paper "Volcano" - iterator, virtual function call
* "elegantly compose arbitrary combinations of operators"


