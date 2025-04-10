package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.domain.AbstractMenuItem;
import com.example.domain.MenuItem;
import com.example.domain.crust.PizzaCrust;
import com.example.domain.sauce.PizzaSauce;
import com.example.domain.topping.PizzaTopping;

public class Pizza extends AbstractMenuItem {
	private PizzaCrust crust;
	private PizzaSauce sauce;
	private List<PizzaTopping> toppings;
	private List<AbstractMenuItem> components;

	// Constructor that could be used if needed (currently using builder pattern)
	public Pizza(String crustString, String sauceString, List<String> toppingStrings) {
		// Call default constructor to initialize lists
		this();
		// You could add conversion from strings to objects here if desired.
	}

	// Default constructor initializing the lists
	public Pizza() {
		this.toppings = new ArrayList<>();
		this.components = new ArrayList<>();
	}

	public PizzaCrust getCrust() {
		return crust;
	}

	public void setCrust(PizzaCrust crust) {
		this.crust = crust;
		addComponent(crust);
	}

	public PizzaSauce getSauce() {
		return sauce;
	}

	public void setSauce(PizzaSauce sauce) {
		this.sauce = sauce;
		addComponent(sauce);
	}

	public List<PizzaTopping> getToppings() {
		return toppings;
	}

	public void setToppings(List<PizzaTopping> toppings) {
		this.toppings = new ArrayList<>(toppings);
		this.components.addAll(toppings);
	}

	public void addTopping(PizzaTopping topping) {
		this.toppings.add(topping);
		addComponent(topping);
	}

	public List<AbstractMenuItem> getComponents() {
		return components;
	}

	public void addComponent(AbstractMenuItem item) {
		// Although components is initialized in the constructor,
		// this check ensures it's not null if this method is called unexpectedly.
		if (components == null) {
			components = new ArrayList<>();
		}
		components.add(item);
	}

	public String toNiceString() {
		return "Pizza: " + toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (crust != null) {
			sb.append(crust.toString());
		}
		if (sauce != null) {
			sb.append(", ").append(sauce.toString());
		}
		for (PizzaTopping topping : toppings) {
			sb.append(", ").append(topping.toString());
		}
		return sb.toString();
	}

	public void display() {
		for (AbstractMenuItem m : components) {
			System.out.printf("%s $%.2f\n", m.toNiceString(), m.getPrice());
		}
	}

	public void displaySorted() {
		Collections.sort(components);
		display();
	}

	@Override
	public Double getPrice() {
		double total = 0.0;
		for (AbstractMenuItem m : components) {
			total += m.getPrice();
		}
		return total;
	}
}
