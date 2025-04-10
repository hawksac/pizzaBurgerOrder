package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

public class PrimaryController implements Initializable {

    private Order currentOrder;

    @FXML
    private TextArea orderDisplay;
    @FXML
    private Label subtotalLabel;

    // This method will be automatically called when the FXML is loaded.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Use the shared order in App; if it's null, create one.
        currentOrder = App.getCurrentOrder();
        if (currentOrder == null) {
            currentOrder = new Order();
            App.setCurrentOrder(currentOrder);
        }
        updateDisplay();
    }

    // Method for ordering a custom pizza
    @FXML
    private void orderCustomPizza() throws IOException {
        App.setRoot("customPizza");
    }

    // New method for ordering a custom burger
    @FXML
    private void orderCustomBurger() throws IOException {
        App.setRoot("customBurger");
    }

    private void updateDisplay() {
        StringBuilder sb = new StringBuilder();
        // Display pizzas
        for (Pizza pizza : currentOrder.getPizzas()) {
            sb.append("Pizza: Crust: ").append(pizza.getCrust())
                    .append(", Sauce: ").append(pizza.getSauce())
                    .append(", Toppings: ").append(pizza.getToppings())
                    .append(" - Price: $").append(String.format("%.2f", pizza.getPrice()))
                    .append("\n");
        }
        // Display burgers
        for (Burger burger : currentOrder.getBurgers()) {
            sb.append("Burger - Price: $")
                    .append(String.format("%.2f", burger.getPrice()))
                    .append("\n");
        }
        orderDisplay.setText(sb.toString());
        subtotalLabel.setText("Total: $" + String.format("%.2f", currentOrder.getTotal()));
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setOrder(currentOrder);
        App.setRoot("secondary");
    }
}
