package com.example.domain;

public abstract class AbstractMenuItem implements MenuItem, Comparable<AbstractMenuItem> {
    // A protected price field available to subclasses.
    protected double price;

    @Override
    public Double getPrice() {
        return price;
    }

    // This lets you externally modify the price.
    public void setPrice(double price) {
        this.price = price;
    }

    // Enables sorting items by price.
    @Override
    public int compareTo(AbstractMenuItem other) {
        return Double.compare(this.price, other.price);
    }

    // Subclasses must provide a descriptive string.
    public abstract String toNiceString();
}
