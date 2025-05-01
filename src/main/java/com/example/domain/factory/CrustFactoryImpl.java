package com.example.domain.factory;

import com.example.domain.crust.PizzaCrust;
import com.example.domain.crust.ThinCrust;
import com.example.domain.crust.ThickCrust;

public class CrustFactoryImpl implements CrustFactory {
    @Override
    public PizzaCrust createCrust(String type) {
        switch (type.toLowerCase()) {
            case "thin":
                return new ThinCrust();
            case "thick":
                return new ThickCrust();
            default:
                throw new IllegalArgumentException("Unknown crust type: " + type);
        }
    }
}
