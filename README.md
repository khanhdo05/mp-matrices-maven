# Matrices (two-dimensional arrays)

A project for CSC-207-02.

## Authors:

- Khanh Do
- Samuel A. Rebelsky (starter code)

## Overview:

This project focuses on building a more complex Abstract Data Type (ADT) for handling two-dimensional arrays, or matrices, in Java. I will implement a matrix structure with operations such as inserting, deleting rows and columns, resizing, and filling regions, exploring multiple ways to handle these matrices, including array of arrays, single arrays, and associative arrays.

## Running the Program

### Prerequisites

Before running the code, make sure you have the following installed:

1. **Java Development Kit (JDK) 8 or higher**

   - Download and install from [Oracle's JDK page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or [OpenJDK](https://openjdk.java.net/).
   - Verify installation by running `java -version` and `javac -version` in your terminal.

2. **Apache Maven**

   - Download and install Maven from [Maven's official website](https://maven.apache.org/download.cgi).
   - Set up environment variables `M2_HOME` and add Maven's `bin` directory to your `PATH`.
   - Verify installation by running `mvn -version` in your terminal.

3. **Text Editor or Integrated Development Environment (IDE)**

   - **Visual Studio Code** or any other text editor/IDE of your choice for editing and managing code files.

4. **Build Tools**

   - Maven will handle project dependencies and building. Ensure Maven is configured correctly as described above.

5. **Compile**
   ```bash
   mvn compile -q
   ```

### To run test

```bash
mvn test -q
```

### To check style

```bash
mvn checkstyle:check -q
```

## Citations:

- This code may be found at <https://github.com/khanhdo05/mp-matrices-maven>.

- The original code may be found at <https://github.com/Grinnell-CSC207/mp-matrices-maven>.
