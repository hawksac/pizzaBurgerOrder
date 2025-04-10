package com.example.domain.crust;

public class ThinCrust extends PizzaCrust {
	public ThinCrust() {
		this.setPrice(0.75);
	}

	@Override
	public String toString() {
		return "Thin Crust";
	}
}
