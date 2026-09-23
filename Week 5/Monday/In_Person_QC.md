2. What are some differences between map/set/list?

All 3 are data structures from the Collections Framework. A List is ordered, allows duplicates, and lets you access elements by index. On the other hand, a Set does not allow duplicates. A Set is useful for storing unique values, such as the email addresses of registered users, where duplicates shouldn't exist. Finally, a Map, stores unique keys, each mapped to a value, and the values can repeat. You'd use a Map when you need fast lookup by a key, for example finding a user's details by their user ID.

2. Explain lambda expressions?

A lambda is a short way to write an anonymous function. The syntax is (parameters) -> expression or (parameters) -> { statements; }. They replace verbose verbose functions and make code shorter and more readable, especially together with streams.

3. Explain stream API?

The Stream API lets you process collections in a functional style that avoids writing verbose and hard to read loops. A stream pipeline has three parts. First is a source, like a list connection. You would use list.stream() to get the stream. Next are intermediate operations like filter(), map(), and sorted(). Last is a terminal operation like collect() or count(), which triggers the pipeline and returns the result. For example, you could use a stream to get the sorted names of all employees in the IT department, you'd filter by department, map to names, sort, and collect into a list. That's one short, readable line instead of a loop with if-statements.

```java
List<String> itNames = employees.stream()
    .filter(e -> e.getDepartment().equals("IT"))
    .map(Employee::getName)
    .sorted()
    .collect(Collectors.toList());
```

4. explain singleton vs factory?

Singleton and Factory are both creational design patterns, but they solve different problems.

Singleton guarantees that a class has exactly one instance and gives global access to it. You build it with a private constructor, a static instance field, and a static getInstance() method. It's typically used for classes such as a logger, or a connection pool.

Factory hides the logic of which object to create. The caller asks the factory for an object, usually by passing a type or parameter, and the factory decides which concrete class to instantiate and returns it through a common interface.

In short, Singleton controls how many instances exist, and Factory controls which class gets instantiated.

5. what is JDBC?

JDBC (Java Database Connectivity) is the standard Java API for connecting to relational databases and running SQL. It gives you one common set of interfaces, and each database vendor supplies a driver that implements them. That means the same Java code works with PostgreSQL, MySQL, Oracle, and others; only the driver and connection URL change.

6. some jdbc class examples?

- DriverManager: a class that creates connections from a URL, username, and password.
- Connection: represents an open session with the database. It also manages transactions through commit() and rollback().
- PreparedStatement: runs precompiled SQL with ? placeholders. It's safer and faster, and it's the one you should use.
- ResultSet: holds the rows returned by a query.

7. How to launch a query with jdbc?

The steps are:

Get a Connection. Create a PreparedStatement with your SQL. Set the parameters. Call executeQuery(), which returns a ResultSet. You can then iterate through the values returned.

Use try-with-resources so the connection, statement, and result set close automatically.

8. what about create/update/delete?

For INSERT, UPDATE, and DELETE you use executeUpdate() instead of executeQuery(). It returns an int with the number of rows affected.

9. how can I traverse a resultset?

A ResultSet has a cursor that starts before the first row. Calling next() moves the cursor forward one row and returns false when there are no more rows, so the standard pattern is while (rs.next()). Inside the loop you read columns with getters like getString(), getInt(), or getDate(), using either the column name or the column index. Column indexes start at 1, not 0, which is a classic interview detail.

```java
while (rs.next()) {
    int id = rs.getInt("id");        // by name
    String name = rs.getString(2);   // by index, starting at 1
}
```
