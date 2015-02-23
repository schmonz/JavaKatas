package com.schmonz.kata.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<Item> items = null;
	static boolean inTestMode = false;
	
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
			if ((!isBrie(each)) && !isPasses(each)) {
				if (each.getQuality() > 0) {
					if (!isSulfuras(each)) {
						incrementQualityBy(each, -1);
					}
				}
			} else {
				if (each.getQuality() < 50) {
					incrementQualityBy(each, 1);

					if (isPasses(each)) {
						if (each.getSellIn() < 11) {
							if (each.getQuality() < 50) {
								incrementQualityBy(each, 1);
							}
						}

						if (each.getSellIn() < 6) {
							if (each.getQuality() < 50) {
								incrementQualityBy(each, 1);
							}
						}
					}
				}
			}

			if (!isSulfuras(each)) {
				each.setSellIn(each.getSellIn() - 1);
			}

			if (each.getSellIn() < 0) {
				if (!isBrie(each)) {
					if (!isPasses(each)) {
						if (each.getQuality() > 0) {
							if (!isSulfuras(each)) {
								incrementQualityBy(each, -1);
							}
						}
					} else {
						each.setQuality(each.getQuality() - each.getQuality());
					}
				} else {
					if (each.getQuality() < 50) {
						incrementQualityBy(each, 1);
					}
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

	public boolean isBrie(Item item) {
		return "Aged Brie".equals(item.name);
	}
	
	public boolean isPasses(Item item) {
		return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
	}
	
	public boolean isSulfuras(Item item) {
		return "Sulfuras, Hand of Ragnaros".equals(item.name);
	}
	
}
