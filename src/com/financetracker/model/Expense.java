package com.financetracker.model;

public class Expense extends Transaction {
    private String purpose;

    public Expense(int id, String date, double amount, String category, String purpose) {
        super(id, date, amount, category);
        this.purpose = purpose;
    }

    @Override
    public String getDetails() {
        return "Expense | " + date + " | " + amount + " | " + category + " | " + purpose;
    }
}
