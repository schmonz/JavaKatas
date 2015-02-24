package com.schmonz.kata.gildedrose;

public class ManaCake extends ReasonableItem {
	public ManaCake(Item item) {
		super(item);
	}
	
	public void updateQuality() {
		incrementQualityBy(-2);
		
		decrementSellBy();
		
		if (isPastSellByDate()) {
			incrementQualityBy(-2);
		}
	}
}
