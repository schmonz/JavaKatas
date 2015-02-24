package com.schmonz.kata.gildedrose;

public class ReasonableItem {
	private Item item;

	public static final int QUALITY_MAX = 50;
	public static final int QUALITY_MIN = 0;

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
	
	public void updateQuality() {
		if (isBrie()) {
			incrementQualityBy(1);
		} else if (isPasses()) {
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
			} else if (isBrie()) {
				incrementQualityBy(1);
			} else {
				decrementQualityBy1UntilMin();
			}
		}
	}
	
	private void incrementQualityBy(int increment) {
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

	private void decrementSellBy() {
		setSellIn(getSellIn() - 1);
	}
	
	public boolean isBrie() {
		return "Aged Brie".equals(getName());
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
	
	private boolean isPastSellByDate() {
		return getSellIn() < 0;
	}
}