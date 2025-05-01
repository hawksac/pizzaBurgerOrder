package com.example.domain.factory;

import com.example.domain.sauce.PizzaSauce;

public interface SauceFactory {
    PizzaSauce createSauce(String type);
}
