package com.schmonz.kata.gildedrose;

public class ReasonableItem {
	private Item item;
	protected int qualityIncrement;
	
	public static final int QUALITY_MAX = 50;
	public static final int QUALITY_MIN = 0;
	
	public static final String AGED_BRIE = "Aged Brie";
	public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	public static final String MANA_CAKE = "Conjured Mana Cake";
	public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

	public static ReasonableItem create(Item item) {
		if (AGED_BRIE.equals(item.getName())) {
			return new Brie(item);
		} else if (BACKSTAGE_PASSES.equals(item.getName())) {
			return new Passes(item);
		} else if (MANA_CAKE.equals(item.getName())) {
			return new ManaCake(item);
		} else if (SULFURAS.equals(item.getName())) {
			return new Sulfuras(item);
		} else {
			return new ReasonableItem(item);
		}
	}

	public ReasonableItem(Item unreasonableItem) {
		item = unreasonableItem;
		qualityIncrement = -1;
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
	
	public void updateQuality() {
		decrementSellBy();
		updateQualityIncrement();
		incrementQualityBy(qualityIncrement);
	}

	protected void updateQualityIncrement() {
		if (getSellIn() < 0) {
			qualityIncrement = 2 * qualityIncrement;
		}
	}
	
	private void incrementQualityBy(int increment) {
		int newQuality = getQuality() + increment;
		if ((QUALITY_MIN <= newQuality) && (newQuality <= QUALITY_MAX)) {
			setQuality(newQuality);
		}
	}

	private void decrementSellBy() {
		setSellIn(getSellIn() - 1);
	}
}