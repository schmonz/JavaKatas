package com.schmonz.kata.gildedrose;

public class ReasonableItem {
	Item item;
	
    public ReasonableItem(String name, int sellIn, int quality) {
    	item = new Item(name, sellIn, quality);
    }
    
    public ReasonableItem(Item unreasonableItem) {
    	item = unreasonableItem;
    }

	public int getSellIn() {
		return item.getSellIn();
	}

	public void setQuality(int quality) {
		item.setQuality(quality);
	}

	public int getQuality() {
		return item.getQuality();
	}

	public void setSellIn(int sellIn) {
		item.setSellIn(sellIn);
	}

	public String getName() {
		return item.getName();
	}
}