package com.example;

import com.example.domain.factory.CrustFactory;
import com.example.domain.factory.SauceFactory;
import com.example.domain.factory.ToppingFactory;
import com.example.domain.factory.CrustFactoryImpl;
import com.example.domain.factory.SauceFactoryImpl;
import com.example.domain.factory.ToppingFactoryImpl;

public class PizzaMain {
    public static void main(String[] args) {
        // Create your factories once
        CrustFactory crustFactory = new CrustFactoryImpl();
        SauceFactory sauceFactory = new SauceFactoryImpl();
        ToppingFactory toppingFactory = new ToppingFactoryImpl();

        // Example: build a custom pizza
        Pizza pizza = new Pizza();
        pizza.setCrust(crustFactory.createCrust("thin"));
        pizza.setSauce(sauceFactory.createSauce("tomato"));

        // Suppose these come from user input:
        String[] toppings = { "pepperoni", "mushrooms", "asiago" };
        for (String t : toppings) {
            pizza.addTopping(toppingFactory.createTopping(t));
        }

        // Display result
        System.out.println(pizza.toNiceString());
        System.out.println("Total: $" + String.format("%.2f", pizza.getPrice()));
    }
}
