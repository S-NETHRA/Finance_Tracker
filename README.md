# Personal Finance Tracker

## Project Overview

A comprehensive Java console application for tracking personal finances, managing expenses, and monitoring income. This project demonstrates core Object-Oriented Programming concepts with a clean, interactive command-line interface.

## Project Description
The Personal Finance Tracker helps users manage their financial life by providing tools to:
- Track daily expenses and income with categorization
- Add, view, search, and delete transactions
- Generate detailed financial summaries with category breakdowns
- Monitor spending patterns and financial balance
- Interactive console-based menu system

## Problem Statement
Many people struggle with financial management due to lack of proper tracking tools. Existing solutions are often complex, expensive, or require internet connectivity. This application provides a simple, free, and comprehensive solution for personal finance management that works offline.

## Target Users
- Young professionals starting their financial journey
- Students managing limited budgets
- Anyone wanting to gain better control over their spending habits
- Small business owners tracking business expenses
- Individuals preferring simple, distraction-free financial tools

## Current Features (Review 1 Implementation)
###  Core OOP Design & Console Application
- **Interactive Menu System**: 8 comprehensive options for complete financial management
- **Transaction Management**: Add income/expenses with predefined categories
- **Smart Input**: Auto-date functionality and category selection
- **Financial Summary**: Detailed breakdown with percentages and balance analysis
- **Search & Filter**: Find transactions by any criteria
- **Data Management**: View, search, and delete transactions
- **Category System**: Predefined income (5) and expense (8) categories

###  Planned for Review 2: Advanced Java Features
- Multithreading for data processing and background operations
- Enhanced Collections (List, Map, Set) for complex data management
- Custom exception handling for robust error management
- File I/O operations for data persistence

### Planned for Review 3: GUI Implementation
- JavaFX-based graphical user interface
- Data visualization charts and graphs
- Enhanced user experience with forms and validation
- Export functionality and reporting features

## Technology Stack
- **Language**: Java 11+
- **Architecture**: Object-Oriented Programming with MVC principles
- **Data Storage**: In-memory collections (ArrayList, HashMap)
- **User Interface**: Console-based interactive menu
- **Design Patterns**: Inheritance, Polymorphism, Encapsulation, Abstraction

## Installation and Setup
1. Clone this repository: `git clone https://github.com/S-NETHRA/Finance_Tracker.git`
2. Navigate to project directory: `cd Finance_Tracker`
3. Compile the project: `javac src/com/financetracker/model/*.java`
4. Run the application: `java -cp src com.financetracker.model.Main`

## Project Structure
```
Finance_Tracker/
├── README.md                           # Project documentation
├── CLASS_DIAGRAM.md                    # UML class diagram
└── src/com/financetracker/model/
    ├── Main.java                       # Main application with UI
    ├── Transaction.java                # Abstract base class
    ├── Income.java                     # Income transaction class
    └── Expense.java                    # Expense transaction class
```

## OOP Concepts Demonstrated

### 1. **Inheritance** 
- **Transaction** (abstract parent class) → **Income** and **Expense** (child classes)
- Child classes inherit common properties: `id`, `date`, `amount`, `category`
- Specialized behavior in each subclass while maintaining common interface

### 2. **Polymorphism** 
- **Method Overriding**: `getDetails()` implemented differently in Income and Expense classes
- **Runtime Polymorphism**: `List<Transaction>` can hold both Income and Expense objects
- **Uniform Interface**: Same method calls produce different behaviors based on object type

### 3. **Encapsulation** 
- **Protected Fields**: Class attributes controlled with appropriate access modifiers
- **Public Getters**: Controlled access to private data through getter methods
- **Data Integrity**: Constructor validation ensures proper object creation

### 4. **Abstraction** 
- **Abstract Class**: Transaction defines common structure without complete implementation
- **Abstract Methods**: `getDetails()` must be implemented by concrete subclasses
- **Interface Consistency**: Clean separation between what classes do vs how they do it

### 5. **Composition** 
- **HAS-A Relationships**: Main class contains List of Transaction objects
- **Modular Design**: Each class has single responsibility
- **Loose Coupling**: Components interact through well-defined interfaces

## Application Features

###  **Main Menu Options:**
1. **Add Income** - Record income with source and category
2. **Add Expense** - Track expenses with purpose and category  
3. **View All Transactions** - Formatted table display
4. **View Financial Summary** - Detailed analysis with percentages
5. **View by Category** - Filter transactions by specific category
6. **Search Transactions** - Find transactions by any criteria
7. **Delete Transaction** - Remove unwanted entries
8. **Exit** - Clean application shutdown

###  **Predefined Categories:**
- **Income**: Salary, Freelance, Investment, Business, Other
- **Expenses**: Food, Transport, Entertainment, Utilities, Healthcare, Education, Shopping, Other

### **Financial Summary Includes:**
- Total income and expenses with formatting
- Current balance with financial advice
- Category-wise expense breakdown with percentages
- Professional formatting and clear insights

## Sample Application Flow
```
===== PERSONAL FINANCE TRACKER =====
1. Add Income
2. Add Expense  
3. View All Transactions
4. View Financial Summary
5. View by Category
6. Search Transactions
7. Delete Transaction
8. Exit

Enter your choice (1-8): 1

ADD INCOME
Enter date (YYYY-MM-DD or press Enter for today): 
Enter amount ($): 5000
Select income category:
   1. Salary
   2. Freelance
   [...]
SUCCESS: Income of $5000.00 added successfully!
```



## Author
**Nethra S**  
Java Programming Course Project  
Review 1: Object-Oriented Design & Console Application

## License
MIT License - Feel free to use and modify for educational purposes.

---
