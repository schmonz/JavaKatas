package com.schmonz.kata.gildedrose;

public class Passes extends ReasonableItem {
	public Passes(Item item) {
		super(item);
	}
	
	public void updateQuality() {
		if (getSellIn() <= 5) {
			qualityIncrement = 3;
		} else if (getSellIn() <= 10) {
			qualityIncrement = 2;
		} else {
			qualityIncrement = 1;
		}
		super.updateQuality();
	}
	
	protected void updateQualityIncrement() {
		if (isPastSellByDate()) {
			qualityIncrement = 0 - getQuality();
		}
	}
}