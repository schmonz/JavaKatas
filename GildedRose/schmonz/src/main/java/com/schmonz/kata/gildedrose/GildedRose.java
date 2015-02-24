package com.schmonz.kata.gildedrose;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRose {

	private static List<Item> items = null;
	static boolean inTestMode = false;
	
	public static final int QUALITY_MAX = 50;
	public static final int QUALITY_MIN = 0;
	
	private List<ReasonableItem> pleasantlyNonStaticItems;

	public GildedRose() {
		this(items);
	}

	public GildedRose(List<Item> someItems) {
		this.pleasantlyNonStaticItems = someItems.stream().map(
				o -> new ReasonableItem(o)
		).collect(Collectors.toList());
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
		for (ReasonableItem each : pleasantlyNonStaticItems) {
			if (isBrie(each)) {
				incrementQualityBy(each, 1);
			} else if (isPasses(each)) {
				if (each.getSellIn() <= 5) {
					incrementQualityBy(each, 3);
				} else if (each.getSellIn() <= 10) {
					incrementQualityBy(each, 2);
				} else {
					incrementQualityBy(each, 1);
				}
			} else {
				decrementQualityBy1UntilMin(each);
			}

			if (!isLegendary(each)) {
				decrementSellBy(each);
			}

			if (isPastSellByDate(each)) {
				if (isPasses(each)) {
					each.setQuality(QUALITY_MIN);
				} else if (isBrie(each)) {
					incrementQualityBy(each, 1);
				} else {
					decrementQualityBy1UntilMin(each);
				}
			}
		}
	}

	public List<ReasonableItem> getItems() {
		return pleasantlyNonStaticItems;
	}
	
	private void incrementQualityBy(ReasonableItem item, int increment) {
		int newQuality = item.getQuality() + increment;
		if (newQuality <= QUALITY_MAX) {
			item.setQuality(newQuality);
		}
	}

	private void decrementQualityBy1UntilMin(ReasonableItem item) {
		if (!isLegendary(item)) {
			if (item.getQuality() > QUALITY_MIN) {
				incrementQualityBy(item, -1);
			}
		}
	}

	private void decrementSellBy(ReasonableItem item) {
		item.setSellIn(item.getSellIn() - 1);
	}

	public boolean isBrie(ReasonableItem item) {
		return "Aged Brie".equals(item.getName());
	}
	
	public boolean isPasses(ReasonableItem item) {
		return "Backstage passes to a TAFKAL80ETC concert".equals(item.getName());
	}
	
	public boolean isSulfuras(ReasonableItem item) {
		return "Sulfuras, Hand of Ragnaros".equals(item.getName());
	}
	
	private boolean isLegendary(ReasonableItem item) {
		return isSulfuras(item);
	}
	
	private boolean isPastSellByDate(ReasonableItem item) {
		return item.getSellIn() < 0;
	}

}
