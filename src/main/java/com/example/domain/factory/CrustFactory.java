package com.example.domain.factory;

import com.example.domain.crust.PizzaCrust;

public interface CrustFactory {
    PizzaCrust createCrust(String type);
}
