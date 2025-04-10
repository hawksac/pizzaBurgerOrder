package com.example;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class CustomBurgerController {

    @FXML
    private ComboBox<String> bunTypeCombo;

    @FXML
    private ComboBox<String> cheeseCombo;

    // This method is called after the FXML is loaded.
    @FXML
    public void initialize() {
        // Populate ComboBoxes (could also be done in FXML if preferred)
        bunTypeCombo.getItems().addAll("Sesame", "Whole Wheat", "Brioche");
        cheeseCombo.getItems().addAll("American", "Cheddar", "Swiss", "No Cheese");
    }

    @FXML
    private void submitBurger() throws IOException {
        // For a simple implementation, we create a burger with a default price.
        Burger burger = new Burger();

        // You might later want to customize the burger based on selections.
        // For example:
        // String bunType = bunTypeCombo.getValue();
        // String cheese = cheeseCombo.getValue();
        // burger.setBunType(bunType);
        // burger.setCheese(cheese);

        // Get current order; create one if it doesn't exist.
        Order currentOrder = App.getCurrentOrder();
        if (currentOrder == null) {
            currentOrder = new Order();
            App.setCurrentOrder(currentOrder);
        }
        currentOrder.addBurger(burger);

        // Navigate back to the primary order view after adding the burger.
        App.setRoot("primary");
    }

    @FXML
    private void cancel() throws IOException {
        // Simply return to the primary view without adding a burger.
        App.setRoot("primary");
    }
}
