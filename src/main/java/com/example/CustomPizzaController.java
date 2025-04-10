package com.example;

import com.example.domain.PizzaBuilder;
import com.example.domain.crust.ThickCrust;
import com.example.domain.crust.ThinCrust;
import com.example.domain.sauce.AlfredoSauce;
import com.example.domain.sauce.TomatoSauce;
import com.example.domain.sauce.PizzaSauce;
import com.example.domain.topping.PepperoniTopping;
import com.example.domain.topping.MushroomTopping;
import com.example.domain.topping.SausageTopping;
import com.example.domain.topping.MozzarellaTopping;
import com.example.domain.topping.AsiagoTopping;
import com.example.domain.topping.PizzaTopping;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.io.IOException;

public class CustomPizzaController {

    @FXML
    private ComboBox<String> crustCombo;
    @FXML
    private ComboBox<String> sauceCombo;
    @FXML
    private CheckBox toppingPepperoni;
    @FXML
    private CheckBox toppingMushroom;
    @FXML
    private CheckBox toppingSausage;
    @FXML
    private CheckBox toppingMozzarella;
    @FXML
    private CheckBox toppingAsiago;

    // This reference could be passed in or obtained via a shared model
    // For simplicity, assume App holds a current Order.
    @FXML
    private void submitCustomPizza() {
        if (App.getCurrentOrder() == null) {
            App.setCurrentOrder(new Order());
        }

        PizzaBuilder builder = new PizzaBuilder();

        // Determine crust
        String crustChoice = crustCombo.getValue();
        if ("Thin Crust".equalsIgnoreCase(crustChoice)) {
            builder.setCrust(new ThinCrust());
        } else if ("Thick Crust".equalsIgnoreCase(crustChoice)) {
            builder.setCrust(new ThickCrust());
        } else {
            showError("Please select a crust.");
            return;
        }

        // Determine sauce
        String sauceChoice = sauceCombo.getValue();
        if ("Tomato Sauce".equalsIgnoreCase(sauceChoice)) {
            builder.setSauce(new TomatoSauce());
        } else if ("Alfredo Sauce".equalsIgnoreCase(sauceChoice)) {
            builder.setSauce(new AlfredoSauce());
        } else {
            showError("Please select a sauce.");
            return;
        }

        // Toppings (check each, add if selected)
        int toppingCount = 0;
        if (toppingPepperoni.isSelected()) {
            builder.addTopping(new PepperoniTopping());
            toppingCount++;
        }
        if (toppingMushroom.isSelected()) {
            builder.addTopping(new MushroomTopping());
            toppingCount++;
        }
        if (toppingSausage.isSelected()) {
            builder.addTopping(new SausageTopping());
            toppingCount++;
        }
        if (toppingMozzarella.isSelected()) {
            // Assume you have a corresponding class for MozzarellaTopping
            builder.addTopping(new MozzarellaTopping());
            toppingCount++;
        }
        if (toppingAsiago.isSelected()) {
            builder.addTopping(new AsiagoTopping());
            toppingCount++;
        }

        if (toppingCount > 4) {
            showError("Please select no more than 4 toppings.");
            return;
        }

        Pizza customPizza = builder.build();
        // Add customPizza to the order. For example, if your App class holds the
        // current order:
        App.getCurrentOrder().addPizza(customPizza);

        // Optionally, close the custom pizza window and refresh the main order screen.
        try {
            App.setRoot("primary"); // or use your navigation strategy
        } catch (IOException e) {
            showError("Failed to load the main order screen.");
        }
    }

    @FXML
    private void cancel() {
        try {
            // Just return to the main order screen
            App.setRoot("primary");
        } catch (IOException e) {
            showError("Failed to load the main order screen.");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Order Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
