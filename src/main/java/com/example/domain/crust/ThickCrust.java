package com.example.domain.crust;

public class ThickCrust extends PizzaCrust {
	// Additional attribute specific to thick crust, e.g., whether it is deep-dish.
	private Boolean isDeepDish;

	public ThickCrust() {
		this.setPrice(1.20);
	}

	@Override
	public String toString() {
		return "Thick Crust";
	}

	public Boolean getIsDeepDish() {
		return isDeepDish;
	}

	public void setIsDeepDish(Boolean isDeepDish) {
		this.isDeepDish = isDeepDish;
	}

	// Optionally, override toNiceString for extra details:
	@Override
	public String toNiceString() {
		return super.toNiceString() + (isDeepDish != null && isDeepDish ? " (Deep Dish)" : "");
	}
}
