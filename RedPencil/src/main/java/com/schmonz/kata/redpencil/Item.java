package com.schmonz.kata.redpencil;

public class Item {
	private double price;
	private int daysSincePriceUpdate;
	private boolean isRedPenciled;
	
	private static final int TOO_RECENT_DAYS_AGO = 30;

	public Item(double price) {
		this.price = price;
		updateRedPencilness(0);
		daysSincePriceUpdate = 0;
	}
	
	private void updateRedPencilness(double percentChange) {
		if ((daysSincePriceUpdate < TOO_RECENT_DAYS_AGO)
			|| (percentChange <= -30 || percentChange >= -5)) {
			isRedPenciled = false;
		} else {
			isRedPenciled = true;
		}
	}

	public boolean isRedPenciled() {
		return isRedPenciled;
	}

	public void setPrice(double newPrice) {
		double percentChange = 100 * (newPrice - price) / price;
		
		price = newPrice;
		updateRedPencilness(percentChange);
		daysSincePriceUpdate = 0;
	}
	
	public void letSomeDaysPass(int numberOfDays) {
		daysSincePriceUpdate += numberOfDays;
	}
}