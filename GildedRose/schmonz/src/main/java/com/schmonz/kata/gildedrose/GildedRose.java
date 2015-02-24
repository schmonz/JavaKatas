package com.schmonz.kata.gildedrose;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRose {

	private List<Item> items;
	
	private List<ReasonableItem> reasonableItems;

	public GildedRose() {
		items = defaultItems();
		this.reasonableItems = items2reasonable(items);
	}
	
	protected List<Item> defaultItems() {
		List<Item> someItems = new ArrayList<Item>();
		someItems.add(new Item("+5 Dexterity Vest", 10, 20));
		someItems.add(new Item("Aged Brie", 2, 0));
		someItems.add(new Item("Elixir of the Mongoose", 5, 7));
		someItems.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		someItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		someItems.add(new Item("Conjured Mana Cake", 3, 6));
		return someItems;
	}
	
	private List<ReasonableItem> items2reasonable(List<Item> someItems) {
		return someItems.stream().map(
				o -> ReasonableItem.create(o)
		).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		System.out.println("OMGHAI!");

		new GildedRose().updateQuality();
	}
	
	public void updateQuality() {
		for (ReasonableItem each : reasonableItems) {
			each.updateQuality();
		}
	}

	public List<ReasonableItem> getItems() {
		return reasonableItems;
	}
}
