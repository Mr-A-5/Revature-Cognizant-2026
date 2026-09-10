# Question Prompt:

## 1. Describe Java and its core components.

Java is a high-level, object-oriented, statically typed programming language with
automatic memory management. Object-oriented means the program is organized around classes
and the objects created from them rather than around simple procedures. Statically typed
means every variable, parameter, and return value has a declared type that the compiler
checks at compile time, which catches a large class of errors before the program ever
runs. Automatic memory management means the garbage collector, running inside the JVM,
reclaims heap memory occupied by objects that are no longer reachable from the running
program, so developers never free memory manually. Java is also known for "write once, run
anywhere": the compiler (javac) turns source files into platform-independent bytecode
stored in .class files rather than into native machine code, and the JVM then executes
that bytecode, bytecode is platform-independent while the JVM itself is
platform-dependent, thus each operating system needs its own build of the JVM, and that is
precisely what makes portability possible.

The three core components are the JVM, the JRE, and the JDK. The JVM is the abstract
machine that provides the runtime environment and converts bytecode into machine-readable
code; the JRE packages the JVM together with the standard class libraries needed to run a
Java program; and the JDK adds the compiler, debugger, and other development tools on top
of the JRE.

## 2. Describe OOP and how it's implemented in Java.

Object-oriented programming is a practice that structures a program around objects, which
are units that bundle data together with the behavior that operates on it. In Java,
objects are defined by classes, which act are similar to blueprints. OOP rests on four
principles. Encapsulation, the idea of binding data and methods together while restricting
direct access to that data, implemented in Java by declaring fields private and exposing
controlled getters and setters. Abstraction exposes only what a caller needs while hiding
the implementation behind it, achieved through abstract classes and interfaces.
Inheritance lets a class acquire the fields and behavior of a parent class, which reduces
duplication and keeps related types consistent. Polymorphism means the same interface can
take many forms, and Java supports two kinds: method overloading, which is compile-time
polymorphism where several methods share a name but differ in their parameter lists, and
method overriding, which is runtime polymorphism where a subclass supplies its own
implementation of a method already defined in its parent.
