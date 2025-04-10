package com.example.domain.topping;

public class CheeseTopping extends PizzaTopping {
	@Override
	public String toString() {
		return "Cheese Topping";
	}

	public CheeseTopping() {
		this.setPrice(1.50);
	}
}
