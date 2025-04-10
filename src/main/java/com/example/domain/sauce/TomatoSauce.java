package com.example.domain.sauce;

public class TomatoSauce extends PizzaSauce {
	@Override
	public String toString() {
		return "Tomato Sauce";
	}

	public TomatoSauce() {
		this.setPrice(1.00);
	}
}
