package com.example.domain.topping;

public class VeggieTopping extends PizzaTopping {
	@Override
	public String toString() {
		return "Veggie Topping";
	}

	public VeggieTopping() {
		this.setPrice(1.50);
	}
}
