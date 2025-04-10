package com.example;

public class Burger {
    private double price;
    // You can add more properties like: patty type, condiments, size, etc.

    public Burger() {
        // Set a default price - you can later modify this with custom logic.
        this.price = 5.99;
    }

    public Burger(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Optional: override toString() for easy display in lists
    @Override
    public String toString() {
        return "Burger - $" + String.format("%.2f", price);
    }
}
