package com.schmonz.kata.gildedrose;

public class ReasonableItem {
	private Item item;

	public static final int QUALITY_MAX = 50;
	public static final int QUALITY_MIN = 0;

	public static ReasonableItem create(Item item) {
		if ("Aged Brie".equals(item.getName())) {
			return new Brie(item);
		} else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.getName())) {
			return new Passes(item);
		} else if ("Conjured Mana Cake".equals(item.getName())) {
			return new ManaCake(item);
		} else {
			return new ReasonableItem(item);
		}
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
	
	public void updateQuality() {
		incrementQualityBy(-1);

		if (!isLegendary()) {
			decrementSellBy();
		}

		if (isPastSellByDate()) {
			incrementQualityBy(-1);
		}
	}
	
	protected void incrementQualityBy(int increment) {
		if (isLegendary()) {
			return;
		}
		int newQuality = getQuality() + increment;
		if ((QUALITY_MIN <= newQuality) && (newQuality <= QUALITY_MAX)) {
			setQuality(newQuality);
		}
	}

	protected void decrementSellBy() {
		setSellIn(getSellIn() - 1);
	}
	
	public boolean isBrie() {
		return this instanceof Brie;
	}
	
	public boolean isPasses() {
		return this instanceof Passes;
	}
	
	public boolean isSulfuras() {
		return "Sulfuras, Hand of Ragnaros".equals(getName());
	}
	
	private boolean isLegendary() {
		return isSulfuras();
	}
	
	protected boolean isPastSellByDate() {
		return getSellIn() < 0;
	}
}