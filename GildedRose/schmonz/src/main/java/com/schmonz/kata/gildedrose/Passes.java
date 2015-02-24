package com.schmonz.kata.gildedrose;

public class Passes extends ReasonableItem {
	public Passes(Item item) {
		super(item);
		qualityIncrement = 1;
	}
	
	protected void updateQualityIncrement() {
		if (getSellIn() < 0) {
			qualityIncrement = 0 - getQuality();
		} else if (getSellIn() <= 4) {
			qualityIncrement = 3;
		} else if (getSellIn() <= 9) {
			System.err.println("Setting increment to 2 because sellIn == " + getSellIn());
			qualityIncrement = 2;
		}
	}
}