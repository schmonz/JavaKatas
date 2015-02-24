package com.schmonz.kata.gildedrose;

public class ReasonableItem {
	private Item item;

	public static final int QUALITY_MAX = 50;
	public static final int QUALITY_MIN = 0;

	public static ReasonableItem create(Item item) {
		if ("Aged Brie".equals(item.getName())) {
			return new Brie(item);
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
		if (isPasses()) {
			if (getSellIn() <= 5) {
				incrementQualityBy(3);
			} else if (getSellIn() <= 10) {
				incrementQualityBy(2);
			} else {
				incrementQualityBy(1);
			}
		} else {
			decrementQualityBy1UntilMin();
		}

		if (!isLegendary()) {
			decrementSellBy();
		}

		if (isPastSellByDate()) {
			if (isPasses()) {
				setQuality(QUALITY_MIN);
			} else {
				decrementQualityBy1UntilMin();
			}
		}
	}
	
	protected void incrementQualityBy(int increment) {
		int newQuality = getQuality() + increment;
		if (newQuality <= QUALITY_MAX) {
			item.setQuality(newQuality);
		}
	}

	private void decrementQualityBy1UntilMin() {
		if (!isLegendary()) {
			if (getQuality() > QUALITY_MIN) {
				incrementQualityBy(-1);
			}
		}
	}

	protected void decrementSellBy() {
		setSellIn(getSellIn() - 1);
	}
	
	public boolean isBrie() {
		return "com.schmonz.kata.gildedrose.Brie".equals(getClass().getName());
	}
	
	public boolean isPasses() {
		return "Backstage passes to a TAFKAL80ETC concert".equals(getName());
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