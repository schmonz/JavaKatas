package com.schmonz.kata.gildedrose;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRose {

	private static List<Item> items = null;
	static boolean inTestMode = false;
	
	private List<ReasonableItem> pleasantlyNonStaticItems;

	public GildedRose() {
		this(items);
	}

	public GildedRose(List<Item> someItems) {
		this.pleasantlyNonStaticItems = someItems.stream().map(
				o -> ReasonableItem.create(o)
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
			each.updateQuality();
		}
	}

	public List<ReasonableItem> getItems() {
		return pleasantlyNonStaticItems;
	}
	
}
