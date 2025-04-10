package com.example.domain.topping;

public class SausageTopping extends MeatTopping {
	public void adjustSpiciness() {
		spiciness = spiciness * 2;
	}

	public String toString() {
		return "Sausage Topping";
	}

	public SausageTopping() {
		this.setPrice(5.50);
	}
}
