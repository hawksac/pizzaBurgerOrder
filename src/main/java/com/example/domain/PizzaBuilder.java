package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.Pizza;
import com.example.domain.crust.PizzaCrust;
import com.example.domain.sauce.PizzaSauce;
import com.example.domain.topping.PizzaTopping;

public class PizzaBuilder {
    private PizzaCrust crust;
    private PizzaSauce sauce;
    private List<PizzaTopping> toppings = new ArrayList<>();

    public PizzaBuilder setCrust(PizzaCrust crust) {
        this.crust = crust;
        return this;
    }

    public PizzaBuilder setSauce(PizzaSauce sauce) {
        this.sauce = sauce;
        return this;
    }

    public PizzaBuilder addTopping(PizzaTopping topping) {
        if (toppings.size() < 4) { // enforce up to 4 toppings
            toppings.add(topping);
        }
        return this;
    }

    public Pizza build() {
        Pizza pizza = new Pizza();
        pizza.setCrust(crust);
        pizza.setSauce(sauce);
        for (PizzaTopping topping : toppings) {
            pizza.addTopping(topping);
        }
        return pizza;
    }
}
