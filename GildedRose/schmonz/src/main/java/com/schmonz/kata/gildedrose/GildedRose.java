package com.schmonz.kata.gildedrose;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRose {

	@SuppressWarnings("unused") private List<Item> items;
	private List<ReasonableItem> reasonableItems;

	public GildedRose() {
		this.reasonableItems = items2reasonable(defaultItems());
		items = Arrays.asList(defaultItems());
	}
	
	public GildedRose(Item...items) {
		this.reasonableItems = items2reasonable(items);
	}
	
	protected Item[] defaultItems() {
		return new Item[] {
			new Item("+5 Dexterity Vest", 10, 20),
			new Item(ReasonableItem.AGED_BRIE, 2, 0),
			new Item("Elixir of the Mongoose", 5, 7),
			new Item(ReasonableItem.SULFURAS, 0, 80),
			new Item(ReasonableItem.BACKSTAGE_PASSES, 15, 20),
			new Item(ReasonableItem.MANA_CAKE, 3, 6)
		};
	}
	
	private List<ReasonableItem> items2reasonable(Item[] someItems) {
		return Arrays.asList(someItems).stream().map(o -> ReasonableItem.create(o)).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		new GildedRose().updateQuality();
	}
	
	public void updateQuality() {
		reasonableItems.stream().forEach(o -> o.updateQuality());
	}

	public List<ReasonableItem> getItems() {
		return reasonableItems;
	}
}
