package com.example.domain.factory;

import com.example.domain.topping.PizzaTopping;
import com.example.domain.topping.PepperoniTopping;
import com.example.domain.topping.MushroomTopping;
import com.example.domain.topping.SausageTopping;
import com.example.domain.topping.MozzarellaTopping;
import com.example.domain.topping.AsiagoTopping;

public class ToppingFactoryImpl implements ToppingFactory {
    @Override
    public PizzaTopping createTopping(String type) {
        switch (type.toLowerCase()) {
            case "pepperoni":
                return new PepperoniTopping();
            case "mushrooms":
                return new MushroomTopping();
            case "sausage":
                return new SausageTopping();
            case "mozzarella":
                return new MozzarellaTopping();
            case "asiago":
                return new AsiagoTopping();
            default:
                throw new IllegalArgumentException("Unknown topping: " + type);
        }
    }
}
