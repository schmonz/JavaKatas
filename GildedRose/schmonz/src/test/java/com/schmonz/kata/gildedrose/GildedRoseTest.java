package com.schmonz.kata.gildedrose;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GildedRoseTest {
	
	@BeforeClass
	public static void superHackyStartup() {
		GildedRose.main(null);
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
		assertEquals(9, firstItem.getSellIn());
		assertEquals(19, firstItem.getQuality());
		
		GildedRose.updateQuality();
		
		assertEquals(8, firstItem.getSellIn());
		assertEquals(18, firstItem.getQuality());
	}
	
	@Test
	public void canUpdateQualityAndSellInForAgedBrieNeverExceeding50() {
		Item theBrie = findTheBrie(new GildedRose().getItems());
		int previousQuality;
		int currentQuality;

		assertEquals(0, theBrie.getSellIn());
		assertEquals(2, previousQuality = theBrie.getQuality());
		
		GildedRose.updateQuality();
		
		assertEquals(-1, theBrie.getSellIn());
		assertEquals(4, currentQuality = theBrie.getQuality());
		
		int qualityImprovementRate = currentQuality - previousQuality;
		int EXPECTED_MAX_QUALITY = 50;
		int iterationsToTryExceedingMaxQuality = 1 + EXPECTED_MAX_QUALITY / qualityImprovementRate;
		for (int i = 0; i <= iterationsToTryExceedingMaxQuality; i++) {
			GildedRose.updateQuality();
			assertTrue(theBrie.getQuality() <= EXPECTED_MAX_QUALITY);
		}
		
		// XXX seems like Brie _improves_ twice as fast after sell-by date
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
	 * "Aged Brie" _increases_ in quality on each update
	 * "Aged Brie"'s quality never goes over 50
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