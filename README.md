
# README for CSD214 Lab 1

---

**Project Name:** CSD214 Lab 1 - Bookstore Application & Java Concepts

**Course:** CSD214 - Programming Concepts 2  
**Instructor:** Fred Carella  
**Institution:** Sault College of Applied Arts and Technology

---

### **Author**
- **Name:** Nikita
- **Date:** 10/8/2024

---

### **Project Description**

This project consists of multiple Java programming exercises focused on implementing object-oriented principles such as classes, constructors, enums, methods, and testing. It also includes a basic **Bookstore** application implementing CRUD functionality for managing books using arrays.

The following sections describe the different components of the lab:

---

### **Lab Components**

1. **Person Class (Question 3)**
   - Implements a `Person` class with the following attributes: `firstName`, `lastName`, `gender`, `SIN`, and a static `COUNT` to track the number of `Person` objects.
   - Includes methods like `toString()`, `equals()`, `hashCode()`, getters, and setters.
   - The `finalize()` method has been replaced with a `cleanup()` method to manually decrement the `COUNT`.

2. **Book Class (Question 4)**
   - Implements a `Book` class with attributes: `title`, `author` (of type `Person`), `ISBN`, and others.
   - Contains constructors, `toString()`, `equals()`, `hashCode()`, and appropriate getters and setters.

3. **Unit Tests (Question 5)**
   - Includes JUnit test cases for the `equals()` methods of both `Person` and `Book` classes to verify equality based on specific attributes.

4. **Bookstore Application (Question 6)**
   - Implements a simple bookstore application that allows adding, editing, deleting, and selling books using a menu-driven approach.
   - Books are managed using arrays to store both unsold and sold books.
   - Includes basic CRUD operations and a menu system to interact with the user.

---

### **How to Run the Project**

1. **Set Up the Project:**
   - Make sure **Java SDK 18** is installed.
   - Import the project into IntelliJ IDEA or your preferred IDE.
   - Ensure all dependencies (JUnit and logging implementations) are properly set up.

2. **Run the Application:**
   - The application can be started by running the `Main` class located in `lab1.q3`.
   - A menu will appear in the console, allowing you to add, edit, delete, and sell books.

3. **Unit Tests:**
   - Run the JUnit tests located in `AppTest.java` under the `test` package to verify the functionality of the `Person` and `Book` classes.

---

### **Repository URL**
- https://github.com/kuznetsovhelloworld/-CSD214-Lab-1---Bookstore-Application-Java-Concepts

---

### **Deliverables**

- **Source Code:** Java files implementing the required functionality.
- **Unit Tests:** JUnit tests for `Person` and `Book`.
- **README:** Project overview and setup guide.

---


