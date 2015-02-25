package com.schmonz.kata.gildedrose;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GildedRose {

	@SuppressWarnings("unused") private List<Item> items;
	private List<ReasonableItem> reasonableItems;

	public GildedRose() {
		this.reasonableItems = items2reasonable(items = defaultItems());
	}
	
	public GildedRose(List<Item> someItems) {
		this.reasonableItems = items2reasonable(someItems);
	}
	
	protected List<Item> defaultItems() {
		List<Item> someItems = new ArrayList<Item>();
		someItems.add(new Item("+5 Dexterity Vest", 10, 20));
		someItems.add(new Item(ReasonableItem.AGED_BRIE, 2, 0));
		someItems.add(new Item("Elixir of the Mongoose", 5, 7));
		someItems.add(new Item(ReasonableItem.SULFURAS, 0, 80));
		someItems.add(new Item(ReasonableItem.BACKSTAGE_PASSES, 15, 20));
		someItems.add(new Item(ReasonableItem.MANA_CAKE, 3, 6));
		return someItems;
	}
	
	private List<ReasonableItem> items2reasonable(List<Item> someItems) {
		return someItems.stream().map(o -> ReasonableItem.create(o)).collect(Collectors.toList());
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
