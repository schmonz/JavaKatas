package com.schmonz.kata.redpencil;

public class Item {
	private double price;
	private boolean isRedPenciled = false;

	public Item(double price) {
		this.price = price;
	}

	public boolean isRedPenciled() {
		return isRedPenciled;
	}

	public void setPrice(double newPrice) {
		double percentChange = 100 * (price - newPrice) / price;
		if (percentChange >= 5 && percentChange <= 30) {
			isRedPenciled = true;
		}
		price = newPrice;
	}

}