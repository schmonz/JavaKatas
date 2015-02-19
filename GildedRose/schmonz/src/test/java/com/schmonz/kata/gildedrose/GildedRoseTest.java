package com.schmonz.kata.gildedrose;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GildedRoseTest {
	
	@Before
	public void superHackySetup() {
		GildedRose.inTestMode = true;
		GildedRose.main(null);
	}

	@Test
	public void a1_initialState() {
		List<Item> expectedItems = new ArrayList<Item>();
		expectedItems.add(new Item("+5 Dexterity Vest", 10, 20));
		expectedItems.add(new Item("Aged Brie", 2, 0));
		expectedItems.add(new Item("Elixir of the Mongoose", 5, 7));
		expectedItems.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		expectedItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		expectedItems.add(new Item("Conjured Mana Cake", 3, 6));

		List<Item> initialItems = new GildedRose().getItems();
		
		for (int i = 0; i < expectedItems.size(); i++) {
			Item expected = expectedItems.get(i);
			Item actual = initialItems.get(i);
			assertEquals(expected.getName(), actual.getName());
			assertEquals(expected.getSellIn(), actual.getSellIn());
			assertEquals(expected.getQuality(), actual.getQuality());
		}
	}

	@Test
	public void canInitializeInventory() {
		assertNotNull(new GildedRose().getItems());
	}
	
	@Test
	public void canEnumerateInventory() {
		assertEquals(6, new GildedRose().getItems().size());
	}
	
	@Test
	public void canInspectItemSellIn() {
		assertNotNull(new GildedRose().getItems().get(0).getSellIn());
	}
	
	@Test
	public void canInspectItemQuality() {
		assertNotNull(new GildedRose().getItems().get(0).getQuality());
	}
	
	@Test
	public void canUpdateQualityAndSellIn() {
		Item firstItem = new GildedRose().getItems().get(0);
		
		GildedRose.updateQuality();
		
		assertEquals(9, firstItem.getSellIn());
		assertEquals(19, firstItem.getQuality());
	}
	
	private void updateBeforeSellBy(Item item, int sellInChange, int qualityChange) {
		int previousSellIn = item.getSellIn();
		int previousQuality = item.getQuality();
		GildedRose.updateQuality();
		assertEquals(previousSellIn + sellInChange, item.getSellIn());
		assertEquals(previousQuality + qualityChange, item.getQuality());
	}
	
	@Test
	public void canUpdateQualityAndSellInForAgedBrieNeverExceeding50() {
		Item theBrie = findTheBrie(new GildedRose().getItems());

		updateBeforeSellBy(theBrie, -1, 1);
		updateBeforeSellBy(theBrie, -1, 1);
		updateBeforeSellBy(theBrie, -1, 2);
		
		assertEquals(-1, theBrie.getSellIn());
		assertEquals(4, theBrie.getQuality());
		
		int expectedQualityImprovementRate = 2;
		int EXPECTED_MAX_QUALITY = 50;
		int iterationsToTryExceedingMaxQuality = 1 + EXPECTED_MAX_QUALITY / expectedQualityImprovementRate;
		for (int i = 0; i <= iterationsToTryExceedingMaxQuality; i++) {
			GildedRose.updateQuality();
			assertTrue(theBrie.getQuality() <= EXPECTED_MAX_QUALITY);
		}
		
	}
	
	private Item findTheBrie(List<Item> items) {
		for (Item each : items) {
			if ("Aged Brie".equals(each.name)) {
				return each;
			}
		}
		return null;
	}
	
	/* TEST LIST:
	 * For all items, quality is not negative to begin with
	 * For all items, quality is still not negative after this update
	 * For all items, quality never moves over 50
	 * 
	 * "Backstage passes" _increases_ in quality:
	 * - With 10 days or less, quality increases by 2
	 * - With 5 days or less, quality increases by 3
	 * - After the concert, quality drops to 0
	 */
	
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