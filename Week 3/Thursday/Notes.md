# QC questions

1. Be able to explain exceptions

    An exception is an object representing an abnormal event that disrupts the normal flow
    of a program's instructions. In Java, all exceptions derive from
    `java.lang.Throwable`, which splits into `Error` (which can throw errors such
    as`OutOfMemoryError` ) and `Exception` (recoverable application-level problems).

2. **Error vs Exception, with examples:** `Error` represents serious problems that come
   from the JVM itself, not the application, and a normal program is not expected to catch
   or recover from them — examples are `OutOfMemoryError` and `StackOverflowError`.
   `Exception` represents conditions an application can reasonably anticipate and handle,
   like `IOException` (a missing file) or `ArithmeticException` (divide by zero). The
   memorable line interviewers want to hear: "you catch Exceptions, you don't catch
   Errors" — catching an `Error` rarely helps because the JVM itself is usually in a
   broken state (e.g., out of memory) when one is thrown.

3. Checked vs Unchecked exceptions, what is their differences, mention a few of the
   subclasses, just a few.

    Checked exceptions are subclasses of `Exception` (excluding `RuntimeException`) that
    the compiler forces you to either catch or declare with `throws`, because they
    represent recoverable conditions external to the program, like a missing file or a
    network failure. Unchecked exceptions extend `RuntimeException` and are not checked at
    compile time; they typically represent programmer errors like bad logic or invalid
    arguments, so forcing a `catch` everywhere would just clutter code without adding real
    safety. Common checked examples include `IOException` and `SQLException`; common
    unchecked examples include `NullPointerException`, `ArrayIndexOutOfBoundsException`,
    and `IllegalArgumentException`.

4. Be able to talk about try, catch and finally

    The `try` block wraps code that might throw an exception; `catch` blocks follow it and
    handle specific exception types, with more specific exception types needing to be
    caught before more general ones (e.g., catch `FileNotFoundException` before
    `IOException`). The `finally` block runs after the try/catch regardless of whether an
    exception was thrown, caught, or even if the try block returns early, making it the
    standard place to release resources like closing streams or connections. One nuance
    interviewers like to probe: if both a `try` block and its `finally` block contain a
    `return` or the `finally` throws an exception, the `finally`'

5. Be able to explain Custom Exceptions

    A custom exception is a user-defined class that extends `Exception` (for a checked
    exception) or `RuntimeException` (for unchecked) to represent a domain-specific error
    condition that Java's built-in exceptions don't capture well, like
    `InsufficientFundsException` in a banking app. You create one by extending the
    appropriate base class and typically providing constructors that pass a message (and
    optionally a cause) up to `super()`, which lets the exception carry meaningful context
    instead of a generic message. Developers commonly cite custom exceptions as improving
    code readability and API clarity, since catching `InsufficientFundsException` is far
    more expressive to a caller than catching a generic `RuntimeException` and inspecting
    a message string.

6. Why creating a custom checked exception vs a custom unchecked exception?

    Make it a custom **checked** exception when the caller has a real, recoverable path
    forward and should be forced to deal with the failure — e.g.,
    `InsufficientFundsException` in a banking app, where the caller can prompt for a
    different payment method. Make it a custom **unchecked** exception when the failure is
    a programming/logic error the caller can't meaningfully recover from and shouldn't
    have to clutter every call site with a `try/catch` for — e.g.,
    `InvalidConfigurationException` extending `RuntimeException` when a required config
    value is missing at startup, which should just fail fast. The rule of thumb
    interviewers want: checked = "the caller can and should recover, force them to handle
    it"; unchecked = "this is a bug or unrecoverable state, don't force ceremony on every
    caller." Many modern codebases (including Spring) lean toward unchecked custom
    exceptions specifically to avoid `throws` clutter up the call stack.

7. Probably questions about Maven. What it is? What does it do? Explain the POM file? Why
   do we use it? How do I add a dependency to a Maven Project? Dependency nodes, artifact
   coordinates -- > the overall structure. Know what Maven Central is. Maven LifeCycle

    Maven is a build automation and project management tool for Java that standardizes how
    projects are built, tested, packaged, and managed by relying on convention over
    configuration and a declarative project model. The POM (`pom.xml`, Project Object
    Model) is the XML file at the root of a Maven project that declares the project's
    coordinates, dependencies, plugins, build settings, and metadata; Maven reads it to
    know exactly what to build and with what. Teams use Maven because it makes builds
    reproducible and portable across machines and CI systems, developers just run
    `mvn install` and Maven resolves the exact dependency versions from the POM rather
    than relying on locally installed JARs.

    To add a dependency, you add a `<dependency>` node inside the `<dependencies>` section
    of the POM, specifying its artifact coordinates: `groupId` (organization/namespace),
    `artifactId` (the library name), and `version`. On the next build, Maven checks your
    local `~/.m2` repository cache first, and if the dependency isn't there, downloads it
    from a remote repository, most commonly Maven Central, the default public repository
    hosting the vast majority of open-source Java libraries.

8. Please explain the Maven build lifecycle?

    A Maven build lifecycle is an ordered sequence of phases that define the stages a
    project goes through to be built and distributed. Maven has three built-in lifecycles
    — `default` (build and deploy), `clean` (removes build artifacts), and `site`
    (generates project documentation) — but interviewers almost always mean `default` when
    they ask this. The key mechanic to state up front: phases execute sequentially, and
    invoking any phase runs every phase before it first. Running `mvn install` therefore
    triggers validate, compile, test, package, and verify along the way — you don't invoke
    phases individually in normal use.

    The core phases of the `default` lifecycle, in order:
    - **validate** — checks that the project structure and POM are correct and all
      necessary information is available (dependencies resolvable, config present) before
      doing any real work.
    - **compile** — compiles the project's main source code (`src/main/java`) into
      bytecode, output to `target/classes`.
    - **test** — runs unit tests against the compiled code using a testing framework like
      JUnit, via the Surefire plugin. Test source (`src/test/java`) is compiled first.
      This does not package the code, so it's the fast feedback loop.
    - **package** — takes the compiled code and packages it into its distributable format,
      typically a `JAR` or `WAR`, placed in `target/`.
    - **verify** — runs checks against integration test results (via Failsafe) or other
      quality gates to ensure the package meets criteria and is valid.
    - **install** — installs the package into the local repository (`~/.m2`), making it
      available as a dependency for other projects built locally on the same machine.
    - **deploy** — copies the final package to a remote repository (e.g., Nexus,
      Artifactory, or Maven Central) for sharing with other developers or teams; done in a
      build/release environment, not typically on a dev machine.

    A common follow-up interviewers ask: "What's the difference between `install` and
    `deploy`?" — `install` only affects your local `.m2` cache so other local projects can
    use the artifact; `deploy` pushes it to a shared remote repo so other machines and CI
    pipelines can pull it too. Another common one: "What does `mvn clean install` do?" —
    `clean` is from a separate lifecycle (it deletes `target/`), so chaining it with
    `install` just guarantees you're building from a fresh state rather than stale
    compiled artifacts, before running the full default lifecycle up through install.

9. Basic knowledge of the Reflection API

    The Reflection API (`java.lang.reflect`) lets a running Java program inspect and
    manipulate its own classes, methods, fields, and constructors at runtime, even ones it
    didn't know about at compile time. Starting from a `Class<?>` object (obtained via
    `.getClass()`, `ClassName.class`, or `Class.forName("...")`), you can enumerate a
    class's methods and fields, invoke methods dynamically with `Method.invoke()`, or even
    access private members by calling `setAccessible(true)`.
