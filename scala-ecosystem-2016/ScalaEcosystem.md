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
* Stretch your mind - better programming

#
* Big industry projects


# Scala to Java bytecode
* Leverage Java Virtual Machine (JVM)
     * Over 20 years of optimizations
     * Java Interpreter and Just-in-time (JIT) compilers
     * Portability and Security
     * Ever-evolving garbage collectors
* Full interoperability with Java and Java libraries

# Functional Programming
* Computation as mathematical functions
     * Function outcome depends only on arguments, idempotent invocations
* Avoid state changes and mutable data structures
* Declarative programming style - expressions
* Functions are first-class
* Can have higher-order functions - take or return functions
* Pure functions - no side effects

# Exploration - Scala Shell

# Scripting
```
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
