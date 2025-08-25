# Personal Finance Tracker

## Project Overview

A comprehensive Java application for tracking personal finances, managing expenses, and monitoring financial goals. This project demonstrates advanced Object-Oriented Programming concepts, multithreading, collections framework, and JavaFX GUI development.

## Project Description
The Personal Finance Tracker helps users manage their financial life by providing tools to:
- Track daily expenses and income
- Categorize transactions
- Set and monitor financial goals
- Generate expense reports
- Visualize spending patterns

## Problem Statement
Many people struggle with financial management due to lack of proper tracking tools. Existing solutions are often complex or expensive. This application provides a simple, free, and comprehensive solution for personal finance management.

## Target Users
- Young professionals starting their financial journey
- Students managing limited budgets
- Anyone wanting to gain better control over their spending habits
- Small business owners tracking business expenses

## Features (Planned Implementation)
### Review 1: Core OOP Design
- ✅ Class hierarchy with inheritance
- ✅ Polymorphism implementation
- ✅ Encapsulation and abstraction
- ✅ UML class diagram

### Review 2: Advanced Java Features
- ✅ Multithreading for data processing
- ✅ Collections (List, Map, Set) for data management
- ✅ Custom exception handling
- ✅ File I/O operations

### Review 3: GUI Implementation
- ✅ JavaFX-based user interface
- ✅ Event handling
- ✅ Data visualization
- ✅ User input validation

## Technology Stack
- **Language**: Java 11+
- **GUI Framework**: JavaFX
- **Collections**: ArrayList, HashMap, TreeSet
- **Concurrency**: Threads and Runnables
- **File Format**: JSON/CSV for data persistence
- **Build Tool**: Maven (optional)

## Installation and Setup
1. Clone this repository
2. Ensure Java 11+ is installed
3. Import project into your IDE
4. Run the main application class

## Project Structure
```
src/
├── com/financetracker/
│   ├── model/           # Data models and business logic
│   ├── view/            # JavaFX GUI components
│   ├── controller/      # Application controllers
│   ├── service/         # Business services
│   ├── util/            # Utility classes
│   └── exception/       # Custom exceptions
```

## OOP Concepts Demonstrated

### 1. Inheritance
- **Transaction** (abstract parent class) → **Income** and **Expense** (child classes)
- Child classes inherit common properties (id, amount, date, description, category)
- Child classes override abstract methods with specific implementations

### 2. Polymorphism
- **Method Overriding**: `processTransaction()` implemented differently in Income and Expense
- **Runtime Polymorphism**: Transaction references can point to Income or Expense objects
- **Interface Segregation**: Different transaction types handled uniformly

### 3. Encapsulation
- **Private Fields**: All class attributes are private with controlled access
- **Public Methods**: Getters and setters provide controlled access to private data
- **Data Validation**: Setters include validation logic to maintain data integrity

### 4. Abstraction
- **Abstract Classes**: Transaction class defines common behavior without implementation
- **Abstract Methods**: `processTransaction()` must be implemented by subclasses
- **Interface Design**: Clean separation between what a class does vs how it does it

### 5. Composition
- **HAS-A Relationships**: Transaction has a Category, FinanceTracker has Transactions
- **Loose Coupling**: Objects interact through well-defined interfaces
- **Modular Design**: Components can be modified independently

## Class Structure Overview
```
Transaction (Abstract)
├── Income (extends Transaction)
└── Expense (extends Transaction)

Category (with CategoryType enum)
FinanceTrackerDemo (Main application class)
```

## Author
Nethra S
Java Programming Course Project

## License
MIT License - Feel free to use and modify for educational purposes.