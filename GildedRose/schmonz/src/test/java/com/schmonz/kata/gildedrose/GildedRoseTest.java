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

	@Test
	public void insertOneOrdinaryItem() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Nothing Special", 11, 17));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem ordinaryItem = mindTheStore.getItems().get(0);
		
		assertEquals(11, ordinaryItem.getSellIn());
		assertEquals(17, ordinaryItem.getQuality());
	}
	
	@Test
	public void updateOneOrdinaryItem() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Nothing Special", 11, 17));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem ordinaryItem = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertEquals(10, ordinaryItem.getSellIn());
		assertEquals(16, ordinaryItem.getQuality());
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
		
		assertEquals(-1, ordinaryItem.getSellIn());
		assertEquals(0, ordinaryItem.getQuality());
	}
	
	@Test
	public void insertOneBrie() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Aged Brie", 5, 7));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem agedBrie = mindTheStore.getItems().get(0);
		
		assertEquals(5, agedBrie.getSellIn());
		assertEquals(7, agedBrie.getQuality());
	}
	
	@Test
	public void updateOneBrie() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Aged Brie", 5, 7));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem agedBrie = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertEquals(4, agedBrie.getSellIn());
		assertEquals(8, agedBrie.getQuality());
	}
	
	@Test
	public void updateOneBriePastSellByDate() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Aged Brie", 2, 0));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem agedBrie = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertEquals(-1, agedBrie.getSellIn());
		assertEquals(4, agedBrie.getQuality());
	}
	
	@Test
	public void insertOnePasses() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 13));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		
		assertEquals(11, backstagePasses.getSellIn());
		assertEquals(13, backstagePasses.getQuality());
	}
	
	@Test
	public void updateOnePasses() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 13));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertEquals(10, backstagePasses.getSellIn());
		assertEquals(14, backstagePasses.getQuality());
	}
	
	@Test
	public void updateOnePassesPast10DaysLeft() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 13));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertEquals(9, backstagePasses.getSellIn());
		assertEquals(16, backstagePasses.getQuality());
	}
	
	@Test
	public void updateOnePassesPast5DaysLeft() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 13));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertEquals(4, backstagePasses.getSellIn());
		assertEquals(18, backstagePasses.getQuality());
	}
	
	@Test
	public void updateOnePassesPastSellByDate() {
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 13));
		
		GildedRose mindTheStore = new GildedRose(customItems);
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertEquals(-1, backstagePasses.getSellIn());
		assertEquals(0, backstagePasses.getQuality());
	}
	
	@Test
	public void canUpdateConjuredThingy() {
		GildedRose mindTheStore = new GildedRose();
		ReasonableItem conjuredThingy = mindTheStore.getItems().get(5);
		
		updateAllAndAssertOne(mindTheStore, conjuredThingy, -1, -2);
		updateAllAndAssertOne(mindTheStore, conjuredThingy, -1, -2);
		updateAllAndAssertOne(mindTheStore, conjuredThingy, -1, -2);
		assertEquals(0, conjuredThingy.getSellIn());
		assertEquals(0, conjuredThingy.getQuality());
		
		List<Item> customItems = new ArrayList<Item>();
		customItems.add(new Item("Conjured Mana Cake", 3, 15));
		mindTheStore = new GildedRose(customItems);
		conjuredThingy = mindTheStore.getItems().get(0);
		
		updateAllAndAssertOne(mindTheStore, conjuredThingy, -1, -2);
		updateAllAndAssertOne(mindTheStore, conjuredThingy, -1, -2);
		updateAllAndAssertOne(mindTheStore, conjuredThingy, -1, -2);
		assertEquals(0, conjuredThingy.getSellIn());
		assertEquals(9, conjuredThingy.getQuality());

		updateAllAndAssertOne(mindTheStore, conjuredThingy, -1, -4);
	}
	
	@Test
	public void cannotUpdateQualityTooHighOrTooLow() {
		GildedRose mindTheStore = new GildedRose();
		List<ReasonableItem> items = mindTheStore.getItems();
		
		for (int i = 0; i < 2 * ReasonableItem.QUALITY_MAX; i++) {
			mindTheStore.updateQuality();
			for (ReasonableItem item : items) {
				if (item instanceof Sulfuras) {
					assertTrue(item.getQuality() == 80);
				} else {
					assertTrue(item.getQuality() <= ReasonableItem.QUALITY_MAX);
					assertTrue(item.getQuality() >= ReasonableItem.QUALITY_MIN);
				}
			}
		}
	}
	
	@Test
	public void canDegradeQuality2xAfterSellByDate() {
		GildedRose mindTheStore = new GildedRose();
		ReasonableItem ordinaryElixir = mindTheStore.getItems().get(2);

		updateAllAndAssertOne(mindTheStore, ordinaryElixir, -1, -1);
		updateAllAndAssertOne(mindTheStore, ordinaryElixir, -1, -1);
		updateAllAndAssertOne(mindTheStore, ordinaryElixir, -1, -1);
		updateAllAndAssertOne(mindTheStore, ordinaryElixir, -1, -1);
		updateAllAndAssertOne(mindTheStore, ordinaryElixir, -1, -1);
		assertEquals(0, ordinaryElixir.getSellIn());
		assertEquals(2, ordinaryElixir.getQuality());
		
		updateAllAndAssertOne(mindTheStore, ordinaryElixir, -1, -2);
		assertEquals(-1, ordinaryElixir.getSellIn());
		assertEquals(0, ordinaryElixir.getQuality());

		updateAllAndAssertOne(mindTheStore, ordinaryElixir, -1, 0);
		assertEquals(-2, ordinaryElixir.getSellIn());
		assertTrue(ordinaryElixir.getQuality() >= 0);
	}

	private void updateAllAndAssertOne(GildedRose store, ReasonableItem ordinaryElixir, int sellInChange, int qualityChange) {
		int previousSellIn = ordinaryElixir.getSellIn();
		int previousQuality = ordinaryElixir.getQuality();
		store.updateQuality();
		assertEquals(previousSellIn + sellInChange, ordinaryElixir.getSellIn());
		assertEquals(previousQuality + qualityChange, ordinaryElixir.getQuality());
	}
	
	private ReasonableItem findThePasses(List<ReasonableItem> items) {
		return items.stream().filter(o -> o instanceof Passes).findFirst().get();
	}

	private ReasonableItem findTheBrie(List<ReasonableItem> items) {
		return items.stream().filter(o -> o instanceof Brie).findFirst().get();
	}
}
