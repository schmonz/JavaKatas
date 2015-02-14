package com.schmonz.kata.gildedrose;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

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
	
	/* TEST LIST:
	 * XXX
	 */
	
	/* MENTAL STACK:
	 * extract initializeInventory() from main()
	 * deconstruct updateQuality()
	 * stop needing superHackyStartup()
	 */
}

/*

# Background

- Every COB, for every item, the system reduces quality and sellIn
	- Except "Aged Brie" increases in quality
	- And "Backstage passes" increases in quality, thus:
		- With 10 days or less, quality increases by 2
		- With 5 days or less, quality increases by 3
		- After the concert, quality drops to 0
- After an item's sell-by date, quality degrades twice as fast
- An item's quality is never:
	- negative
	- more than 50
- Items which are "legendary" never:
	- need to be sold
	- decrease in quality
- "Sulfuras" is one such "legendary" item and its quality is always 80


# Constraints

- Can't change the Item class
- Can't change the items property
- Can change updateQuality(), provided nothing breaks


# Assignment

- Track "conjured" items, whose quality degrades twice as fast

*/