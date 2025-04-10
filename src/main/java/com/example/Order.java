package com.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Pizza> pizzas;
    private List<Burger> burgers;

    public Order() {
        pizzas = new ArrayList<>();
        burgers = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addBurger(Burger burger) {
        burgers.add(burger);
    }

    public double getTotal() {
        double total = 0;
        for (Pizza p : pizzas) {
            total += p.getPrice();
        }
        for (Burger b : burgers) {
            total += b.getPrice();
        }
        return total;
    }

    public List<Object> getSortedItemsByPrice() {
        List<Object> items = new ArrayList<>();
        items.addAll(pizzas);
        items.addAll(burgers);
        items.sort((a, b) -> {
            double priceA = (a instanceof Pizza) ? ((Pizza) a).getPrice() : ((Burger) a).getPrice();
            double priceB = (b instanceof Pizza) ? ((Pizza) b).getPrice() : ((Burger) b).getPrice();
            return Double.compare(priceA, priceB);
        });
        return items;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public List<Burger> getBurgers() {
        return burgers;
    }
}
