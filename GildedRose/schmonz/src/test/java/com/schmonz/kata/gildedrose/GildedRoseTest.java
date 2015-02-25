package com.schmonz.kata.gildedrose;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GildedRoseTest {
	
	@Test
	public void noArgsConstructorProvidesDefaultItems() {
		List<ReasonableItem> items = new GildedRose().getItems();
		
		assertEquals(6, items.size());
	}
	
	@Test
	public void oneArgConstructorSpecifiesItems() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Blueberry Frumpkin", 7, 90));
		customItems.add(new Item("Ancient Novelty Bracelet", 12, 5));
		
		List<ReasonableItem> items = new GildedRose(customItems).getItems();
		
		assertEquals(2, items.size());
	}
	
	private void assertUpdatedItem(ReasonableItem item, int sellIn, int quality) {
		assertEquals(sellIn, item.getSellIn());
		assertEquals(quality, item.getQuality());
	}
	
	@Test
	public void insertOneOrdinaryItem() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Nothing Special", 11, 17));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem ordinaryItem = mindTheStore.getItems().get(0);
		
		assertUpdatedItem(ordinaryItem, 11, 17);
	}
	
	@Test
	public void updateOneOrdinaryItem() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Nothing Special", 11, 17));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem ordinaryItem = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(ordinaryItem, 10, 16);
	}
	
	@Test
	public void updateOneOrdinaryItemPastSellByDate() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Nothing Special", 4, 2));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem ordinaryItem = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(ordinaryItem, -1, 0);
	}
	
	@Test
	public void updateOneBrie() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.AGED_BRIE, 5, 7));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem agedBrie = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(agedBrie, 4, 8);
	}
	
	@Test
	public void updateOneBriePastSellByDate() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.AGED_BRIE, 2, 0));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem agedBrie = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(agedBrie, -1, 4);
	}
	
	@Test
	public void updateOneBriePastSellByDateToMaxQuality() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.AGED_BRIE, 2, 48));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem agedBrie = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(agedBrie, -1, 50);
	}
	
	@Test
	public void updateOneBriePastSellByDateToMaxQualityUnlessInexact() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.AGED_BRIE, 2, 47));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem agedBrie = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(agedBrie, -1, 49);
	}
	
	@Test
	public void updateOnePasses() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.BACKSTAGE_PASSES, 11, 13));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(backstagePasses, 10, 14);
	}
	
	@Test
	public void updateOnePassesPast10DaysLeft() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.BACKSTAGE_PASSES, 11, 13));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(backstagePasses, 9, 16);
	}
	
	@Test
	public void updateOnePassesPast5DaysLeft() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.BACKSTAGE_PASSES, 6, 13));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(backstagePasses, 4, 18);
	}
	
	@Test
	public void updateOnePassesPast5DaysLeftToMaxQuality() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.BACKSTAGE_PASSES, 3, 47));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(backstagePasses, 1, 50);
	}
	
	@Test
	public void updateOnePassesPastSellByDate() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.BACKSTAGE_PASSES, 1, 13));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(backstagePasses, -1, 0);
	}
	
	@Test
	public void updateOneSulfuras() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.SULFURAS, 0, 77));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem sulfuras = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(sulfuras, 0, 77);
	}
	
	@Test
	public void updateOneManaCake() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.MANA_CAKE, 7, 15));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem cake = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(cake, 6, 13);
	}
	
	@Test
	public void updateOneManaCakePastSellByDate() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.MANA_CAKE, 1, 9));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem cake = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(cake, -1, 3);
	}
	
	@Test
	public void updateSeveralItemsAsTypical() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item(ReasonableItem.AGED_BRIE, 5, 7));
		customItems.add(new Item("Nothing Special", 11, 17));
		customItems.add(new Item(ReasonableItem.MANA_CAKE, 7, 15));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(mindTheStore.getItems().get(0), 4, 8);
		assertUpdatedItem(mindTheStore.getItems().get(1), 10, 16);
		assertUpdatedItem(mindTheStore.getItems().get(2), 6, 13);
	}
}
