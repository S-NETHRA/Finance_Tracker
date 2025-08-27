package com.financetracker.model;

public class Income extends Transaction {
    private String source;

    public Income(int id, String date, double amount, String category, String source) {
        super(id, date, amount, category);
        this.source = source;
    }

    @Override
    public String getDetails() {
        return "Income | " + date + " | " + amount + " | " + category + " | " + source;
    }
}
