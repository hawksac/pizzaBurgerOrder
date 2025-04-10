package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.domain.crust.ThinCrust;
import com.example.domain.sauce.TomatoSauce;
import com.example.domain.topping.PepperoniTopping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Order class.
 */
public class OrderTest {

    private Order order;

    /**
     * Sets up a new Order instance before each test.
     */
    @BeforeEach
    public void setUp() {
        order = new Order();
    }

    /**
     * Test that the total price of the order is increased by the correct amount
     * after assembling a pizza.
     */
    @Test
    public void testOrderPriceAfterPizza() {
        // Create and configure a pizza.
        Pizza pizza = new Pizza();
        ThinCrust crust = new ThinCrust();
        crust.setPrice(2.50);
        TomatoSauce sauce = new TomatoSauce();
        sauce.setPrice(1.00);
        PepperoniTopping topping = new PepperoniTopping();
        topping.setPrice(1.50);

        pizza.setCrust(crust);
        pizza.setSauce(sauce);
        pizza.addTopping(topping);

        // Add the pizza to the order.
        order.addPizza(pizza);

        double expectedTotal = crust.getPrice() + sauce.getPrice() + topping.getPrice();
        assertEquals(expectedTotal, order.getTotal(), 0.001,
                "Order total should equal the pizza's total price");
    }

    /**
     * Test that the total price of the order is increased by the correct amount
     * after assembling a burger.
     */
    @Test
    public void testOrderPriceAfterBurger() {
        // Create a burger with a set price.
        Burger burger = new Burger();
        burger.setPrice(5.99);

        // Add the burger to the order.
        order.addBurger(burger);

        double expectedTotal = 5.99;
        assertEquals(expectedTotal, order.getTotal(), 0.001,
                "Order total should equal the burger's price");
    }

    /**
     * Test that the total price of the order is increased correctly after
     * assembling two pizzas.
     */
    @Test
    public void testOrderPriceAfterTwoPizzas() {
        // Create first pizza.
        Pizza pizza1 = new Pizza();
        ThinCrust crust1 = new ThinCrust();
        crust1.setPrice(2.00);
        TomatoSauce sauce1 = new TomatoSauce();
        sauce1.setPrice(1.00);
        pizza1.setCrust(crust1);
        pizza1.setSauce(sauce1);

        // Create second pizza.
        Pizza pizza2 = new Pizza();
        ThinCrust crust2 = new ThinCrust();
        crust2.setPrice(3.00);
        TomatoSauce sauce2 = new TomatoSauce();
        sauce2.setPrice(1.50);
        PepperoniTopping topping = new PepperoniTopping();
        topping.setPrice(2.00);
        pizza2.setCrust(crust2);
        pizza2.setSauce(sauce2);
        pizza2.addTopping(topping);

        // Add both pizzas to the order.
        order.addPizza(pizza1);
        order.addPizza(pizza2);

        double expectedTotal = (crust1.getPrice() + sauce1.getPrice())
                + (crust2.getPrice() + sauce2.getPrice() + topping.getPrice());
        assertEquals(expectedTotal, order.getTotal(), 0.001,
                "Order total should equal the sum of both pizzas' prices");
    }
}
