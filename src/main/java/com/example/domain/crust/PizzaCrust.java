package com.example.domain.crust;

import com.example.domain.AbstractMenuItem;

public abstract class PizzaCrust extends AbstractMenuItem {
	// Extra property, for example, ingredient details.
	protected String ingredient;

	// Each crust must provide its own string representation.
	public abstract String toString();

	@Override
	public String toNiceString() {
		return "Crust: " + toString() + (ingredient != null ? " (" + ingredient + ")" : "");
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
}
