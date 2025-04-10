package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.domain.crust.ThinCrust;
import com.example.domain.sauce.TomatoSauce;
import com.example.domain.topping.PepperoniTopping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Pizza class.
 */
public class PizzaTest {

    private Pizza pizza;

    /**
     * Sets up a new Pizza instance before each test.
     */
    @BeforeEach
    public void setUp() {
        pizza = new Pizza();
    }

    /**
     * Test that setting the crust works correctly.
     */
    @Test
    public void testSetCrust() {
        ThinCrust thinCrust = new ThinCrust();
        pizza.setCrust(thinCrust);
        assertEquals(thinCrust, pizza.getCrust(), "Crust should be set correctly");
    }

    /**
     * Test that setting the sauce works correctly.
     */
    @Test
    public void testSetSauce() {
        TomatoSauce tomatoSauce = new TomatoSauce();
        pizza.setSauce(tomatoSauce);
        assertEquals(tomatoSauce, pizza.getSauce(), "Sauce should be set correctly");
    }

    /**
     * Test that adding a topping stores the topping in the pizza's list.
     */
    @Test
    public void testAddTopping() {
        PepperoniTopping topping = new PepperoniTopping();
        pizza.addTopping(topping);
        assertTrue(pizza.getToppings().contains(topping), "Pizza should contain the topping");
    }

    /**
     * Test that the total price of a pizza matches the sum of its crust, sauce, and
     * toppings.
     */
    @Test
    public void testPriceCalculation() {
        // Set prices for individual components.
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
        assertEquals(expectedTotal, pizza.getPrice(), 0.001,
                "Total price should be the sum of crust, sauce, and toppings");
    }

    /**
     * Test that the total price of a pizza is increased by the correct amount when
     * a topping is added.
     */
    @Test
    public void testPizzaPriceIncreasesWithTopping() {
        // Setup with initial components.
        ThinCrust crust = new ThinCrust();
        crust.setPrice(2.00);
        TomatoSauce sauce = new TomatoSauce();
        sauce.setPrice(1.00);
        pizza.setCrust(crust);
        pizza.setSauce(sauce);

        double basePrice = pizza.getPrice(); // Should be 2.00 + 1.00 = 3.00

        // Add a topping.
        PepperoniTopping topping = new PepperoniTopping();
        topping.setPrice(1.50);
        pizza.addTopping(topping);

        double newPrice = pizza.getPrice();
        assertEquals(basePrice + 1.50, newPrice, 0.001,
                "Pizza price should be increased by the topping price");
    }
}
