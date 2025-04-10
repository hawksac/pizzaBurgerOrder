package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.domain.crust.ThinCrust;
import com.example.domain.sauce.TomatoSauce;
import com.example.domain.topping.PepperoniTopping;

public class PizzaTest {

    private Pizza pizza;

    @BeforeEach
    public void setUp() {
        // Create a new Pizza instance before each test.
        pizza = new Pizza();
    }

    @Test
    public void testSetCrust() {
        ThinCrust thinCrust = new ThinCrust();
        pizza.setCrust(thinCrust);
        assertEquals(thinCrust, pizza.getCrust(), "Crust should be set correctly");
    }

    @Test
    public void testSetSauce() {
        TomatoSauce tomatoSauce = new TomatoSauce();
        pizza.setSauce(tomatoSauce);
        assertEquals(tomatoSauce, pizza.getSauce(), "Sauce should be set correctly");
    }

    @Test
    public void testAddTopping() {
        PepperoniTopping topping = new PepperoniTopping();
        pizza.addTopping(topping);
        assertTrue(pizza.getToppings().contains(topping), "Pizza should contain the topping");
    }

    @Test
    public void testPriceCalculation() {
        // Assume each component has a price. Set prices and verify the total.
        ThinCrust crust = new ThinCrust();
        crust.setPrice(2.50);
        TomatoSauce sauce = new TomatoSauce();
        sauce.setPrice(1.00);
        PepperoniTopping topping = new PepperoniTopping();
        topping.setPrice(1.50);

        pizza.setCrust(crust);
        pizza.setSauce(sauce);
        pizza.addTopping(topping);

        double expectedTotal = 2.50 + 1.00 + 1.50;
        assertEquals(expectedTotal, pizza.getPrice(), 0.001, "Total price should be the sum of its components");
    }
}
