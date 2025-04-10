package com.example.domain.topping;

import com.example.domain.AbstractMenuItem;

public abstract class PizzaTopping extends AbstractMenuItem {
	public abstract String toString();

	@Override
	public String toNiceString() {
		return "Topping: " + toString();
	}
}
