package com.financetracker.model;

public abstract class Transaction {
    protected int id;
    protected String date;
    protected double amount;
    protected String category;

    public Transaction(int id, String date, double amount, String category) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    public abstract String getDetails();
    
    // Essential getter methods
    public int getId() { return id; }
    public String getDate() { return date; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
}
