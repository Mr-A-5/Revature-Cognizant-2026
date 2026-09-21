1. What is tha Java Collections Framework?

The Java Collections Framework is a unified architecture of ready-to-use classes and interfaces designed to store, retrieve, and manipulate groups of objects efficiently. Located in the java.util package, it provides high-performance data structures so developers do not have to write custom data-handling code from scratch.

2. What are some differences between map/set/list?

List, Set, and Map are the three main data structures in the Java Collections Framework, and each one is suited to a different kind of problem. It is important to note that List and Set both extend the Collection interface. Collection defines common methods like add(), remove(), contains(), size(), and iterator(). Map does not extend Collection, because it stores key-value pairs rather than single elements. While these 3 structures are part of the Collections framework they are different on implementation.

A List, such as ArrayList or LinkedList, is ordered, allows duplicates, and lets you access elements by index. You'd use a List for something like the items in a shopping cart, where order matters and the same product can appear twice. There are two main implementations of Lists, ArrayList and LinkedList. The primary difference between ArrayList and LinkedList is their underlying data structure and how they manage memory. ArrayList uses a dynamically resizing array to store elements in contiguous memory locations, making it excellent for fast lookups. Conversely, LinkedList uses a doubly linked list where individual nodes are scattered in memory and connected via pointers, making it efficient for adding or removing items from the ends.

A Set does not allow duplicates. HashSet has no guaranteed order, LinkedHashSet keeps insertion order, and TreeSet keeps elements sorted. A Set is useful for storing unique values, such as the email addresses of registered users, where duplicates shouldn't exist.

A Map, such as HashMap or TreeMap, stores unique keys, each mapped to a value, and the values can repeat. You'd use a Map when you need fast lookup by a key, for example finding a user's details by their user ID.

2. Explain lambda expressions?

A lambda is a short way to write an anonymous function. It was introduced in Java 8. The syntax is (parameters) -> expression or (parameters) -> { statements; }.

Lambdas only work with functional interfaces, which are interfaces with exactly one abstract method, such as Runnable, Comparator, Predicate, and Function. They replace verbose anonymous inner classes and make code shorter and more readable, especially together with streams.

3. Explain stream API? The Stream API, added in Java 8, lets you process collections in a functional style: you describe what you want instead of writing loops. It doesn't change the original collection, and a stream can only be used once.

A stream pipeline has three parts. First is a source, like list.stream(). Next are intermediate operations like filter(), map(), and sorted(), which are lazy and don't run until the end. Last is a terminal operation like collect() or count(), which triggers the pipeline and returns the result.

For example, to get the sorted names of all employees in the IT department, you'd filter by department, map to names, sort, and collect into a list. That's one short, readable line instead of a loop with if-statements.

```java
List<String> itNames = employees.stream()
    .filter(e -> e.getDepartment().equals("IT"))
    .map(Employee::getName)
    .sorted()
    .collect(Collectors.toList());
```

4. explain singleton vs factory?

Singleton and Factory are both creational design patterns, but they solve different problems.

Singleton guarantees that a class has exactly one instance and gives global access to it. You build it with a private constructor, a static instance field, and a static getInstance() method. It's typically used for a logger, a configuration manager, or a connection pool, where one shared instance makes sense.

Factory hides the logic of which object to create. The caller asks the factory for an object, usually by passing a type or parameter, and the factory decides which concrete class to instantiate and returns it through a common interface. The main benefit is loose coupling: the calling code depends only on the interface, not on specific classes. If you add a new type or change how objects are built, you only update the factory, and the rest of the code stays the same. It also keeps creation logic in one place instead of scattering new statements and if-else checks across the codebase. For example, a payment system could have a factory that returns a CreditCardPayment, PayPalPayment, or BankTransferPayment based on the user's choice. When you later add a new payment method, only the factory changes.

In short, Singleton controls how many instances exist, and Factory controls which class gets instantiated.

5. what is JDBC?

JDBC (Java Database Connectivity) is the standard Java API for connecting to relational databases and running SQL. It gives you one common set of interfaces, and each database vendor supplies a driver that implements them. That means the same Java code works with PostgreSQL, MySQL, Oracle, and others; only the driver and connection URL change.

This connects back to your AWS slides: to query the RDS Postgres database from Java, you would use JDBC with the endpoint, port 5432, and the master credentials.

6. some jdbc class examples?

DriverManager: a class that creates connections from a URL, username, and password. Connection: represents an open session with the database. It also manages transactions through commit() and rollback(). Statement: runs static SQL strings. Avoid it for user input because it's vulnerable to SQL injection. PreparedStatement: runs precompiled SQL with ? placeholders. It's safer and faster, and it's the one you should use. CallableStatement: calls stored procedures. ResultSet: holds the rows returned by a query. SQLException: the checked exception that JDBC operations throw. DataSource: the preferred alternative to DriverManager in real applications. It supports connection pooling.

7. How to launch a query with jdbc?

The steps are:

Get a Connection. Create a PreparedStatement with your SQL. Set the parameters. Call executeQuery(), which returns a ResultSet.

Use try-with-resources so the connection, statement, and result set close automatically.

8. what about create/update/delete?

For INSERT, UPDATE, and DELETE you use executeUpdate() instead of executeQuery(). It returns an int with the number of rows affected. The same method also runs DDL statements like CREATE TABLE, which return 0. Plain execute() can run any SQL statement and returns a boolean indicating whether a ResultSet came back.

9. how can I traverse a resultset?

A ResultSet has a cursor that starts before the first row. Calling next() moves the cursor forward one row and returns false when there are no more rows, so the standard pattern is while (rs.next()). Inside the loop you read columns with getters like getString(), getInt(), or getDate(), using either the column name or the column index. Column indexes start at 1, not 0, which is a classic interview detail.

```java
while (rs.next()) {
    int id = rs.getInt("id");        // by name
    String name = rs.getString(2);   // by index, starting at 1
}
```
