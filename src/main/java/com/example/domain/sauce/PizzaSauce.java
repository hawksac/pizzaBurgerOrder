package com.example.domain.sauce;

import com.example.domain.AbstractMenuItem;

public abstract class PizzaSauce extends AbstractMenuItem {
	// Each concrete sauce will define its own toString method.
	public abstract String toString();

	@Override
	public String toNiceString() {
		return "Sauce: " + toString();
	}

	// Do not override getPrice() here, so the inherited behavior via price is used.
}
