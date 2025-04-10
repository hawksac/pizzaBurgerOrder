package com.example.domain.sauce;

public class AlfredoSauce extends PizzaSauce {
	@Override
	public String toString() {
		return "Alfredo Sauce";
	}

	public AlfredoSauce() {
		this.setPrice(1.00);
	}
}
