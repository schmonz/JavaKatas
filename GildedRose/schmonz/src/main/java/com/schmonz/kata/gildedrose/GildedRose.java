package com.schmonz.kata.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {

	private static List<Item> items = null;
	static boolean inTestMode = false;

	public static void main(String[] args) {
		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));

		if (!inTestMode) {
			updateQuality();
		}
	}

	public static void updateQuality() {
		for (Item each : items) {
			if ((!isBrie(each)) && !"Backstage passes to a TAFKAL80ETC concert".equals(each.getName())) {
				if (each.getQuality() > 0) {
					if (!"Sulfuras, Hand of Ragnaros".equals(each.getName())) {
						incrementQualityBy(each, -1);
					}
				}
			} else {
				if (each.getQuality() < 50) {
					incrementQualityBy(each, 1);

					if ("Backstage passes to a TAFKAL80ETC concert".equals(each.getName())) {
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

			if (!"Sulfuras, Hand of Ragnaros".equals(each.getName())) {
				each.setSellIn(each.getSellIn() - 1);
			}

			if (each.getSellIn() < 0) {
				if (!isBrie(each)) {
					if (!"Backstage passes to a TAFKAL80ETC concert".equals(each.getName())) {
						if (each.getQuality() > 0) {
							if (!"Sulfuras, Hand of Ragnaros".equals(each.getName())) {
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
		return items;
	}
	
	private static void incrementQualityBy(Item item, int increment) {
		item.setQuality(item.getQuality() + increment);
	}

	public static boolean isBrie(Item item) {
		return "Aged Brie".equals(item.name);
	}
	
}
