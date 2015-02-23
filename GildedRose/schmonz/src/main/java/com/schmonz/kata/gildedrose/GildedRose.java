package com.schmonz.kata.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<Item> items = null;
	static boolean inTestMode = false;
	
	public static final int QUALITY_MAX = 50;
	public static final int QUALITY_MIN = 0;
	
	private List<Item> pleasantlyNonStaticItems;

	public GildedRose() {
		this.pleasantlyNonStaticItems = items;
	}

	public GildedRose(List<Item> someItems) {
		this.pleasantlyNonStaticItems = someItems;
	}
	
	public static void main(String[] args) {
		System.out.println("OMGHAI!");

		items = initializeInventory();

		GildedRose mindTheStore = new GildedRose(items);
		if (!inTestMode) {
			mindTheStore.updateQuality();
		}
	}
	
	private static List<Item> initializeInventory() {
		List<Item> defaultItems = new ArrayList<Item>();
		defaultItems.add(new Item("+5 Dexterity Vest", 10, 20));
		defaultItems.add(new Item("Aged Brie", 2, 0));
		defaultItems.add(new Item("Elixir of the Mongoose", 5, 7));
		defaultItems.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		defaultItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		defaultItems.add(new Item("Conjured Mana Cake", 3, 6));
		return defaultItems;
	}

	public void updateQuality() {
		for (Item each : pleasantlyNonStaticItems) {
			if (isBrie(each)) {
				incrementQualityBy1UntilMax(each);
			} else if (isPasses(each)) {
				if (each.getQuality() < QUALITY_MAX) {
					incrementQualityBy(each, 1);

					if (each.getSellIn() < 11) {
						incrementQualityBy1UntilMax(each);
					}

					if (each.getSellIn() < 6) {
						incrementQualityBy1UntilMax(each);
					}
				}
			} else if (!isLegendary(each)) {
				decrementQualityBy1UntilMin(each);
			}

			if (!isLegendary(each)) {
				each.setSellIn(each.getSellIn() - 1);
			}

			if (each.getSellIn() < 0) {
				if (isPasses(each)) {
					each.setQuality(each.getQuality() - each.getQuality());
				} else if (isBrie(each)) {
					incrementQualityBy1UntilMax(each);
				} else if (!isLegendary(each)) {
					decrementQualityBy1UntilMin(each);
				}
			}
		}
	}

	public List<Item> getItems() {
		return pleasantlyNonStaticItems;
	}
	
	private void incrementQualityBy(Item item, int increment) {
		item.setQuality(item.getQuality() + increment);
	}

	private void incrementQualityBy1UntilMax(Item each) {
		if (each.getQuality() < QUALITY_MAX) {
			incrementQualityBy(each, 1);
		}
	}

	private void decrementQualityBy1UntilMin(Item each) {
		if (each.getQuality() > QUALITY_MIN) {
			incrementQualityBy(each, -1);
		}
	}

	public boolean isBrie(Item item) {
		return "Aged Brie".equals(item.name);
	}
	
	public boolean isPasses(Item item) {
		return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
	}
	
	public boolean isSulfuras(Item item) {
		return "Sulfuras, Hand of Ragnaros".equals(item.name);
	}
	
	private boolean isLegendary(Item item) {
		return isSulfuras(item);
	}
	
}
