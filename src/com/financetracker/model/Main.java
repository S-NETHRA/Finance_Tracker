package com.financetracker.model;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;

public class Main {
    private static List<Transaction> transactions = new ArrayList<>();
    private static final String[] INCOME_CATEGORIES = {"Salary", "Freelance", "Investment", "Business", "Other"};
    private static final String[] EXPENSE_CATEGORIES = {"Food", "Transport", "Entertainment", "Utilities", "Healthcare", "Education", "Shopping", "Other"};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, id = 1;

        do {
            displayMainMenu();
            System.out.print("Enter your choice (1-8): ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    addIncome(sc, id++);
                    break;
                case 2:
                    addExpense(sc, id++);
                    break;
                case 3:
                    showAllTransactions();
                    break;
                case 4:
                    showSummary();
                    break;
                case 5:
                    showByCategory(sc);
                    break;
                case 6:
                    searchTransactions(sc);
                    break;
                case 7:
                    deleteTransaction(sc);
                    break;
                case 8:
                    System.out.println("Thank you for using Personal Finance Tracker!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-8.");
            }
        } while (choice != 8);

        sc.close();
    }
    
    private static void displayMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("        PERSONAL FINANCE TRACKER");
        System.out.println("=".repeat(50));
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. View All Transactions");
        System.out.println("4. View Financial Summary");
        System.out.println("5. View by Category");
        System.out.println("6. Search Transactions");
        System.out.println("7. Delete Transaction");
        System.out.println("8. Exit");
        System.out.println("=".repeat(50));
    }
    
    private static void addIncome(Scanner sc, int id) {
        System.out.println("\nADD INCOME");
        System.out.println("-".repeat(30));
        
        System.out.print("Enter date (YYYY-MM-DD or press Enter for today): ");
        String dateInput = sc.nextLine().trim();
        String date = dateInput.isEmpty() ? LocalDate.now().toString() : dateInput;
        
        System.out.print("Enter amount ($): ");
        double amount = sc.nextDouble();
        sc.nextLine();
        
        System.out.println("Select income category:");
        for (int i = 0; i < INCOME_CATEGORIES.length; i++) {
            System.out.println("   " + (i + 1) + ". " + INCOME_CATEGORIES[i]);
        }
        
        System.out.print("Enter category number (1-" + INCOME_CATEGORIES.length + "): ");
        int categoryChoice = sc.nextInt();
        sc.nextLine();
        
        String category = (categoryChoice > 0 && categoryChoice <= INCOME_CATEGORIES.length) 
                         ? INCOME_CATEGORIES[categoryChoice - 1] : "Other";
        
        System.out.print("Enter income source (e.g., Company Name, Client): ");
        String source = sc.nextLine();
        
        transactions.add(new Income(id, date, amount, category, source));
        System.out.println("SUCCESS: Income of $" + String.format("%.2f", amount) + " added successfully!");
    }
    
    private static void addExpense(Scanner sc, int id) {
        System.out.println("\nADD EXPENSE");
        System.out.println("-".repeat(30));
        
        System.out.print("Enter date (YYYY-MM-DD or press Enter for today): ");
        String dateInput = sc.nextLine().trim();
        String date = dateInput.isEmpty() ? LocalDate.now().toString() : dateInput;
        
        System.out.print("Enter amount ($): ");
        double amount = sc.nextDouble();
        sc.nextLine();
        
        System.out.println("Select expense category:");
        for (int i = 0; i < EXPENSE_CATEGORIES.length; i++) {
            System.out.println("   " + (i + 1) + ". " + EXPENSE_CATEGORIES[i]);
        }
        
        System.out.print("Enter category number (1-" + EXPENSE_CATEGORIES.length + "): ");
        int categoryChoice = sc.nextInt();
        sc.nextLine();
        
        String category = (categoryChoice > 0 && categoryChoice <= EXPENSE_CATEGORIES.length) 
                         ? EXPENSE_CATEGORIES[categoryChoice - 1] : "Other";
        
        System.out.print("Enter purpose/description: ");
        String purpose = sc.nextLine();
        
        transactions.add(new Expense(id, date, amount, category, purpose));
        System.out.println("SUCCESS: Expense of $" + String.format("%.2f", amount) + " added successfully!");
    }
    
    private static void showByCategory(Scanner sc) {
        System.out.println("\nVIEW BY CATEGORY");
        System.out.println("-".repeat(30));
        System.out.print("Enter category name: ");
        String category = sc.nextLine();
        
        boolean found = false;
        for (Transaction transaction : transactions) {
            if (transaction.getCategory().equalsIgnoreCase(category)) {
                if (!found) {
                    System.out.println("\nTransactions in category '" + category + "':");
                    found = true;
                }
                System.out.println("  " + transaction.getDetails());
            }
        }
        
        if (!found) {
            System.out.println("ERROR: No transactions found in category '" + category + "'");
        }
    }
    
    private static void searchTransactions(Scanner sc) {
        System.out.println("\nSEARCH TRANSACTIONS");
        System.out.println("-".repeat(30));
        System.out.print("Enter search term (amount, date, or description): ");
        String searchTerm = sc.nextLine().toLowerCase();
        
        boolean found = false;
        for (Transaction transaction : transactions) {
            String details = transaction.getDetails().toLowerCase();
            if (details.contains(searchTerm)) {
                if (!found) {
                    System.out.println("\nSearch results:");
                    found = true;
                }
                System.out.println("  " + transaction.getDetails());
            }
        }
        
        if (!found) {
            System.out.println("ERROR: No transactions found matching '" + searchTerm + "'");
        }
    }
    
    private static void deleteTransaction(Scanner sc) {
        if (transactions.isEmpty()) {
            System.out.println("ERROR: No transactions to delete.");
            return;
        }
        
        System.out.println("\nDELETE TRANSACTION");
        System.out.println("-".repeat(30));
        System.out.println("Current transactions:");
        
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + ". " + transactions.get(i).getDetails());
        }
        
        System.out.print("Enter transaction number to delete (1-" + transactions.size() + "): ");
        int choice = sc.nextInt();
        sc.nextLine();
        
        if (choice > 0 && choice <= transactions.size()) {
            Transaction removed = transactions.remove(choice - 1);
            System.out.println("SUCCESS: Transaction deleted: " + removed.getDetails());
        } else {
            System.out.println("ERROR: Invalid transaction number.");
        }
    }
    
    private static void showAllTransactions() {
        System.out.println("\nALL TRANSACTIONS");
        System.out.println("-".repeat(50));
        
        if (transactions.isEmpty()) {
            System.out.println("ERROR: No transactions found. Add some transactions first!");
            return;
        }
        
        System.out.println("ID | Type    | Date       | Amount   | Category     | Details");
        System.out.println("-".repeat(70));
        
        for (Transaction transaction : transactions) {
            String type = transaction instanceof Income ? "Income " : "Expense";
            String[] parts = transaction.getDetails().split(" \\| ");
            String details = parts.length > 4 ? parts[4] : "";
            
            System.out.printf("%-2d | %-7s | %-10s | $%-7.2f | %-12s | %s%n",
                transaction.getId(), type, transaction.getDate(), 
                transaction.getAmount(), transaction.getCategory(), details);
        }
        
        System.out.println("-".repeat(70));
        System.out.println("Total Transactions: " + transactions.size());
    }
    
    private static void showSummary() {
        System.out.println("\nFINANCIAL SUMMARY");
        System.out.println("=".repeat(50));
        
        if (transactions.isEmpty()) {
            System.out.println("ERROR: No transactions available for summary.");
            return;
        }
        
        double totalIncome = transactions.stream()
            .filter(t -> t instanceof Income)
            .mapToDouble(Transaction::getAmount)
            .sum();
            
        double totalExpenses = transactions.stream()
            .filter(t -> t instanceof Expense)
            .mapToDouble(Transaction::getAmount)
            .sum();
            
        double netBalance = totalIncome - totalExpenses;
        
        System.out.println("Total Income:      $" + String.format("%,.2f", totalIncome));
        System.out.println("Total Expenses:    $" + String.format("%,.2f", totalExpenses));
        System.out.println("-".repeat(30));
        
        if (netBalance >= 0) {
            System.out.println("Net Balance:       $" + String.format("%,.2f", netBalance));
            System.out.println("   (You're in the positive!)");
        } else {
            System.out.println("Net Balance:       -$" + String.format("%,.2f", Math.abs(netBalance)));
            System.out.println("   (Consider reducing expenses!)");
        }
        
        System.out.println("\nExpense Breakdown by Category:");
        Map<String, Double> categoryExpenses = new HashMap<>();
        
        for (Transaction transaction : transactions) {
            if (transaction instanceof Expense) {
                categoryExpenses.put(transaction.getCategory(), 
                    categoryExpenses.getOrDefault(transaction.getCategory(), 0.0) + transaction.getAmount());
            }
        }
        
        if (!categoryExpenses.isEmpty()) {
            for (Map.Entry<String, Double> entry : categoryExpenses.entrySet()) {
                double percentage = (entry.getValue() / totalExpenses) * 100;
                System.out.printf("   %-12s: $%-8.2f (%.1f%%)%n", 
                    entry.getKey(), entry.getValue(), percentage);
            }
        }
        
        System.out.println("=".repeat(50));
    }
}