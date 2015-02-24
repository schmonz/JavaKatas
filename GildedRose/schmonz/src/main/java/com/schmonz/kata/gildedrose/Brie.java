package com.schmonz.kata.gildedrose;

public class Brie extends ReasonableItem {
	public Brie(Item item) {
		super(item);
	}
	
	public void updateQuality() {
		incrementQualityBy(1);
		
		decrementSellBy();
		
		if (isPastSellByDate()) {
			incrementQualityBy(1);
		}
	}
}