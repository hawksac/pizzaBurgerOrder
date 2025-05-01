package com.example.domain.factory;

import com.example.domain.topping.PizzaTopping;

public interface ToppingFactory {
    PizzaTopping createTopping(String type);
}
