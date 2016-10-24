% The Scala programming ecosystem
% Leveraging functional, OO, libraries and frameworks
% Markus Dale, 2016

# The Scala Programming Language
* Martin Odersky, EPFL, Switzerland
     * Worked on javac (1.3)
     * Java Generics
* Lightbend (formerly Typesafe)
* Multi-paradigm language
     * Functional and Object-Oriented
* Statically typed
* Scalable language - script to large program
* Stretch your mind - functions and immutability


# Sca\(lable\) la\(nguage\)

* Apache Spark (Databricks)
* Apache Kafka (LinkedIn)
* Akka (Lightbend)
* Play Web Framework
     * [Lichess Online Chess](https://en.lichess.org/)
* Lightbend customers: Walmart, Verizon, Twitter, LinkedIn, Coursera, The Guardian, Airbnb...


# Scala to Java bytecode
* Leverage Java Virtual Machine (JVM)
     * Over 20 years of optimizations
     * Java Interpreter and Just-in-time (JIT) compilers
     * Portability and Security
     * Ever-evolving garbage collectors
* Full interoperability with Java and Java libraries

# Exploration - Scala Shell and Worksheet
* Scala shell
* IDEA Scala Worksheet
* Scala IDE

# Whirlwind Tour
* Java compatibility and extensions
* Conciseness
* Functional Programming

# Java Compatibility and extensions
```scala
> val age = "42"
age: String = 42
> age.toInt
res0: Int = 42

> val myInts = Array(1,2,4,7)
myInts: Array[Int] = Array(1, 2, 4, 7)
> myInts.filter(_ % 2 == 0)
res2: Array[Int] = Array(2, 4)
```

# Java <=> Scala
```scala
import scala.collection.JavaConverters._
val utilList = new java.util.ArrayList[String]()
utilList.add("hello")
utilList.add("world")

> val buffer = utilList.asScala
buffer: scala.collection.mutable.Buffer[String] = Buffer(hello, world)
> val list = buffer.toList
list: List[String] = List(hello, world)

val javaList = list.asJava
javaList: java.util.List[String] = [hello, world]
```

# Conciseness
```scala
case class Person(firstName: String, lastName: String, age: Int)

val bob = Person("Bob", "Dylan", 75)
val bobby = Person("Bob", "Dylan", 75)

println(bob)
println(bob.age)
val same = bob == bobby //eq
bob.hashCode

val youngBob = bob.copy(firstName = "Robert", age = 7)

> val Person(first,last,age) = youngBob
first: String = Robert
last: String = Dylan
age: Int = 7
```

# Functional Programming
* Computation as mathematical functions
     * Function outcome depends only on arguments, idempotent invocations
* Avoid state changes and mutable data structures
* Declarative programming style - expressions
* Functions are first-class
* Can have higher-order functions - take or return functions
* Pure functions - no side effects

# Functions are first class objects
* L01 examples
* Function literals
* Higher-order functions - take function as argument or return a function

# Scripting
```bash
#!/bin/bash
exec scala "$0" "$@"
!#

println("Here is Scala")

```

```
def factorial(x: BigInt): BigInt =     if (x == 0) 1 else x * factorial(x - 1)

```
# Resources
* Coursera/EPFL [Functional Programming in Scala Specialization](https://www.coursera.org/specializations/scala)
