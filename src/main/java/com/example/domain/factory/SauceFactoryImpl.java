package com.example.domain.factory;

import com.example.domain.sauce.PizzaSauce;
import com.example.domain.sauce.TomatoSauce;
import com.example.domain.sauce.AlfredoSauce;

public class SauceFactoryImpl implements SauceFactory {
    @Override
    public PizzaSauce createSauce(String type) {
        switch (type.toLowerCase()) {
            case "tomato":
                return new TomatoSauce();
            case "alfredo":
                return new AlfredoSauce();
            default:
                throw new IllegalArgumentException("Unknown sauce type: " + type);
        }
    }
}
