package com.schmonz.kata.gildedrose;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {
	
	private int EXPECTED_MAX_QUALITY = 50;
	private int EXPECTED_MIN_QUALITY = 0;

	@Before
	public void superHackySetup() {
		GildedRose.inTestMode = true;
		GildedRose.main(null);
	}

	@Test
	public void initialState() {
		List<Item> expectedItems = new ArrayList<Item>();
		expectedItems.add(new Item("+5 Dexterity Vest", 10, 20));
		expectedItems.add(new Item("Aged Brie", 2, 0));
		expectedItems.add(new Item("Elixir of the Mongoose", 5, 7));
		expectedItems.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		expectedItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		expectedItems.add(new Item("Conjured Mana Cake", 3, 6));

		List<Item> initialItems = new GildedRose().getItems();
		assertNotNull(initialItems);
		assertEquals(expectedItems.size(), initialItems.size());
		
		for (int i = 0; i < expectedItems.size(); i++) {
			Item expected = expectedItems.get(i);
			Item actual = initialItems.get(i);
			
			assertEquals(expected.getName(), actual.getName());
			assertEquals(expected.getSellIn(), actual.getSellIn());
			assertEquals(expected.getQuality(), actual.getQuality());
			
			assertTrue(actual.getQuality() >= EXPECTED_MIN_QUALITY);
		}
	}

	@Test
	public void canUpdateQualityAndSellIn() {
		Item ordinaryVest = new GildedRose().getItems().get(0);
		
		updateBeforeSellBy(ordinaryVest, -1, -1);
	}
	
	@Test
	public void canUpdateAgedBrie() {
		Item theBrie = findTheBrie(new GildedRose().getItems());

		updateBeforeSellBy(theBrie, -1, 1);
		updateBeforeSellBy(theBrie, -1, 1);
		
		updateBeforeSellBy(theBrie, -1, 2);
		
		assertEquals(-1, theBrie.getSellIn());
		assertEquals(4, theBrie.getQuality());
	}
	
	@Test
	public void canUpdateBackstagePasses() {
		Item thePasses = findThePasses(new GildedRose().getItems());
		
		updateBeforeSellBy(thePasses, -1, 1);
		updateBeforeSellBy(thePasses, -1, 1);
		updateBeforeSellBy(thePasses, -1, 1);
		updateBeforeSellBy(thePasses, -1, 1);
		updateBeforeSellBy(thePasses, -1, 1);
		assertEquals(10, thePasses.getSellIn());
		assertEquals(25, thePasses.getQuality());
		
		updateBeforeSellBy(thePasses, -1, 2);
		updateBeforeSellBy(thePasses, -1, 2);
		updateBeforeSellBy(thePasses, -1, 2);
		updateBeforeSellBy(thePasses, -1, 2);
		updateBeforeSellBy(thePasses, -1, 2);
		assertEquals(5, thePasses.getSellIn());
		assertEquals(35, thePasses.getQuality());

		updateBeforeSellBy(thePasses, -1, 3);
		updateBeforeSellBy(thePasses, -1, 3);
		updateBeforeSellBy(thePasses, -1, 3);
		updateBeforeSellBy(thePasses, -1, 3);
		updateBeforeSellBy(thePasses, -1, 3);
		assertEquals(0, thePasses.getSellIn());
		assertEquals(50, thePasses.getQuality());

		updateBeforeSellBy(thePasses, -1, -50);
		assertEquals(-1, thePasses.getSellIn());
		assertEquals(0, thePasses.getQuality());
	}
	
	@Test
	public void cannotUpdateQualityTooHighOrTooLow() {
		List<Item> items = new GildedRose().getItems();
		
		for (int i = 0; i < 2 * EXPECTED_MAX_QUALITY; i++) {
			GildedRose.updateQuality();
			for (Item item : items) {
				if (isSulfuras(item)) {
					assertTrue(item.getQuality() == 80);
				} else {
					assertTrue(item.getQuality() <= EXPECTED_MAX_QUALITY);
					assertTrue(item.getQuality() >= EXPECTED_MIN_QUALITY);
				}
			}
		}
	}
	
	private void updateBeforeSellBy(Item item, int sellInChange, int qualityChange) {
		int previousSellIn = item.getSellIn();
		int previousQuality = item.getQuality();
		GildedRose.updateQuality();
		assertEquals(previousSellIn + sellInChange, item.getSellIn());
		assertEquals(previousQuality + qualityChange, item.getQuality());
	}
	
	private Item findThePasses(List<Item> items) {
	    return items.stream().filter(o -> isPasses(o)).findFirst().get();
	}

	private Item findTheBrie(List<Item> items) {
	    return items.stream().filter(o -> isBrie(o)).findFirst().get();
	}
	
	private boolean isBrie(Item item) {
		return "Aged Brie".equals(item.name);
	}
	
	private boolean isPasses(Item item) {
		return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
	}
	
	private boolean isSulfuras(Item item) {
		return "Sulfuras, Hand of Ragnaros".equals(item.name);
	}
	
	/* MENTAL STACK:
	 * extract initializeInventory() from main()
	 * deconstruct updateQuality()
	 * stop needing superHackyStartup()
	 */
}

/*

# Background

- After an item's sell-by date, quality degrades twice as fast
- Items which are "legendary" never:
	- need to be sold
	- decrease in quality
- "Sulfuras" is one such "legendary" item and its quality is always 80


# Constraints

- Can't change the Item class
- Can't change the items property
- Can change updateQuality(), provided nothing breaks


# Assignment

- Track "conjured" items, whose quality degrades twice as fast to begin with

*/