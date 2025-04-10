package com.example;

import com.example.Order;
import com.example.Pizza;
import com.example.Burger;
import java.io.IOException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;

public class SecondaryController {

    @FXML
    private TextArea receiptDisplay;

    @FXML
    private Label totalLabel;

    @FXML
    public void initialize() {
        Order order = App.getOrder();
        if (order != null) {
            List<Object> sortedItems = order.getSortedItemsByPrice();
            StringBuilder sb = new StringBuilder();
            for (Object item : sortedItems) {
                if (item instanceof Pizza) {
                    Pizza pizza = (Pizza) item;
                    sb.append("Pizza: Crust: ").append(pizza.getCrust())
                            .append(", Sauce: ").append(pizza.getSauce())
                            .append(", Toppings: ").append(pizza.getToppings())
                            .append(" - Price: $").append(String.format("%.2f", pizza.getPrice()))
                            .append("\n");
                } else if (item instanceof Burger) {
                    Burger burger = (Burger) item;
                    sb.append("Burger - Price: $")
                            .append(String.format("%.2f", burger.getPrice()))
                            .append("\n");
                }
            }
            receiptDisplay.setText(sb.toString());
            totalLabel.setText("Grand Total: $" + String.format("%.2f", order.getTotal()));
        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}
