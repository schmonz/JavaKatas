package com.schmonz.kata.gildedrose;

import static org.junit.Assert.*;

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
		List<ReasonableItem> items = new GildedRose(
			new Item("Blueberry Frumpkin", 7, 90),
			new Item("Ancient Novelty Bracelet", 12, 5)
		).getItems();
		
		assertEquals(2, items.size());
	}
	
	private void assertUpdatedItem(ReasonableItem item, int sellIn, int quality) {
		assertEquals(sellIn, item.getSellIn());
		assertEquals(quality, item.getQuality());
	}
	
	@Test
	public void insertOneOrdinaryItem() {
		GildedRose mindTheStore = new GildedRose(new Item("Nothing Special", 11, 17));
		ReasonableItem ordinaryItem = mindTheStore.getItems().get(0);
		
		assertUpdatedItem(ordinaryItem, 11, 17);
	}
	
	@Test
	public void updateOneOrdinaryItem() {
		GildedRose mindTheStore = new GildedRose(new Item("Nothing Special", 11, 17));
		ReasonableItem ordinaryItem = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(ordinaryItem, 10, 16);
	}
	
	@Test
	public void updateOneOrdinaryItemPastSellByDate() {
		GildedRose mindTheStore = new GildedRose(new Item("Nothing Special", 4, 2));
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
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.AGED_BRIE, 5, 7));
		ReasonableItem agedBrie = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(agedBrie, 4, 8);
	}
	
	@Test
	public void updateOneBriePastSellByDate() {
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.AGED_BRIE, 2, 0));
		ReasonableItem agedBrie = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(agedBrie, -1, 4);
	}
	
	@Test
	public void updateOneBriePastSellByDateToMaxQuality() {
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.AGED_BRIE, 2, 48));
		ReasonableItem agedBrie = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(agedBrie, -1, 50);
	}
	
	@Test
	public void updateOneBriePastSellByDateToMaxQualityUnlessInexact() {
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.AGED_BRIE, 2, 47));
		ReasonableItem agedBrie = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(agedBrie, -1, 49);
	}
	
	@Test
	public void updateOnePasses() {
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.BACKSTAGE_PASSES, 11, 13));
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(backstagePasses, 10, 14);
	}
	
	@Test
	public void updateOnePassesPast10DaysLeft() {
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.BACKSTAGE_PASSES, 11, 13));
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(backstagePasses, 9, 16);
	}
	
	@Test
	public void updateOnePassesPast5DaysLeft() {
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.BACKSTAGE_PASSES, 6, 13));
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(backstagePasses, 4, 18);
	}
	
	@Test
	public void updateOnePassesPast5DaysLeftToMaxQuality() {
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.BACKSTAGE_PASSES, 3, 47));
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(backstagePasses, 1, 50);
	}
	
	@Test
	public void updateOnePassesPastSellByDate() {
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.BACKSTAGE_PASSES, 1, 13));
		ReasonableItem backstagePasses = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(backstagePasses, -1, 0);
	}
	
	@Test
	public void updateOneSulfuras() {
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.SULFURAS, 0, 77));
		ReasonableItem sulfuras = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(sulfuras, 0, 77);
	}
	
	@Test
	public void updateOneManaCake() {
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.MANA_CAKE, 7, 15));
		ReasonableItem cake = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(cake, 6, 13);
	}
	
	@Test
	public void updateOneManaCakePastSellByDate() {
		GildedRose mindTheStore = new GildedRose(new Item(ReasonableItem.MANA_CAKE, 1, 9));
		ReasonableItem cake = mindTheStore.getItems().get(0);
		mindTheStore.updateQuality();
		mindTheStore.updateQuality();
		
		assertUpdatedItem(cake, -1, 3);
	}
	
	@Test
	public void updateSeveralItemsAsTypical() {
		GildedRose mindTheStore = new GildedRose(
			new Item(ReasonableItem.AGED_BRIE, 5, 7),
			new Item("Nothing Special", 11, 17),
			new Item(ReasonableItem.MANA_CAKE, 7, 15)
		);
		mindTheStore.updateQuality();
		
		assertUpdatedItem(mindTheStore.getItems().get(0), 4, 8);
		assertUpdatedItem(mindTheStore.getItems().get(1), 10, 16);
		assertUpdatedItem(mindTheStore.getItems().get(2), 6, 13);
	}
}
