package com.schmonz.kata.gildedrose;

public class Passes extends ReasonableItem {
	public Passes(Item item) {
		super(item);
	}
	
	public void updateQuality() {
		if (getSellIn() <= 5) {
			incrementQualityBy(3);
		} else if (getSellIn() <= 10) {
			incrementQualityBy(2);
		} else {
			incrementQualityBy(1);
		}
		
		decrementSellBy();

		if (isPastSellByDate()) {
			setQuality(QUALITY_MIN);
		}
	}
}