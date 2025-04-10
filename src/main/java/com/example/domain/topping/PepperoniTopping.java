package com.example.domain.topping;

public class PepperoniTopping extends PizzaTopping {
	@Override
	public String toString() {
		return "Pepperoni";
	}

	public PepperoniTopping() {
		this.setPrice(1.50);
	}
}
