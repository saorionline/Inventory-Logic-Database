# Desktop Inventory Management Application

## Overview

This project is a **desktop application** designed to manage **product stock, categories, and suppliers** through a robust **relational database architecture**. While presented as a mockup and functional prototype, the design intentionally mirrors **real-world, complex relational data systems** found in enterprise environments.

The application emphasizes **Object-Oriented Programming (OOP)** principles and **database connectivity**, showcasing how clean domain modeling maps to normalized database schemas and scalable data access patterns.

---

## Purpose & Goals

* Demonstrate a **solid understanding of database architecture** and relational modeling
* Translate **business entities** into normalized relational tables
* Apply **OOP concepts** (Encapsulation and Inheritance) to data-driven applications
* Implement reliable **CRUD operations** using Java and Oracle Database
* Showcase **version control discipline** using Git branching

This repository serves both as a **learning artifact** and a **portfolio project** for roles involving backend logic, database interaction, and enterprise software development.

---

## Database Architecture & Design Intricacies

### Relational Data Modeling

At the core of the application is a **relational database design** that reflects real operational constraints:

* **Products** are stored independently but linked to:

  * One **Category** (many-to-one)
  * One **Supplier** (many-to-one)
* **Categories** can contain multiple products
* **Suppliers** can provide multiple products

This structure enforces:

* **Referential integrity** through foreign keys
* **Data normalization** to reduce redundancy
* **Scalable relationships** that can grow without structural rewrites

### Why This Matters

Although the UI may appear simple, the underlying schema mirrors enterprise systems where:

* A single change in one table impacts multiple dependent entities
* Queries must join multiple tables efficiently
* Data consistency is critical across the system

The mockup intentionally reflects these complexities to demonstrate readiness for **larger, production-grade databases**.

---

## Mapping the Mockup to Complex Relational Data

The UI mockup is not just visual — it is a **representation of relational logic**:

* Product creation screens correspond to **INSERT operations across linked tables**
* Category and supplier selectors reflect **foreign key relationships**
* Update flows simulate **transactional integrity**, ensuring partial updates do not corrupt data
* Delete actions respect **relational constraints** (e.g., preventing deletion of referenced records)

This approach reinforces the idea that **frontend actions are tightly coupled to backend data rules**, a key concept in database-driven applications.

---

## Key Features

* **CRUD Operations**

  * Create, Read, Update, and Delete products, categories, and suppliers
* **Java JDBC Integration**

  * Direct connectivity to an **Oracle Database** using JDBC
* **Data Integrity Enforcement**

  * Proper handling of primary keys and foreign keys
* **Modular Codebase**

  * Separation of concerns between UI, business logic, and data access layers

---

## Technical Highlights

### Object-Oriented Programming

* **Encapsulation**

  * Domain entities (Product, Category, Supplier) manage their own state
  * Database access is abstracted through DAO layers

* **Inheritance**

  * Shared behaviors and properties are abstracted into base classes
  * Promotes reusability and cleaner code organization

### Database Connectivity

* **Java JDBC** used for:

  * Secure database connections
  * Prepared statements to prevent SQL injection
  * Efficient execution of complex queries and joins

### Version Control

* **Git Branching Strategy**

  * Feature branches for isolated development
  * Clean merge history to track incremental improvements

---

## Technologies Used

* **Java (Desktop Application)**
* **Oracle Database**
* **JDBC**
* **Git & GitHub**

---

## What This Project Demonstrates

* Practical understanding of **relational database architecture**
* Ability to translate **business requirements into data models**
* Strong foundation in **OOP applied to data-centric systems**
* Readiness to work with **enterprise-grade databases and workflows**

---

## Future Improvements

* Add transaction management (commit/rollback)
* Introduce indexing and query optimization
* Implement role-based access control
* Migrate to ORM frameworks (e.g., Hibernate) for comparison

---

## Final Note

This project goes beyond a basic CRUD demo. It intentionally reflects the **intricacies, dependencies, and constraints** of real database-driven systems, making it a strong foundation for scaling into more advanced enterprise applications.
