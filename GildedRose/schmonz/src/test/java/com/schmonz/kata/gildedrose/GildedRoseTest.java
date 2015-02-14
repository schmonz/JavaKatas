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
	
	/* TEST LIST:
	 * can inspect sellIn
	 * can inspect quality
	 * can update sellIn and quality (so our system tracks reality)
	 */
	
	/* MENTAL STACK:
	 * extract initializeInventory() from main()
	 */
}

/*

# Background

- Items have a "sellIn" (number of days left to sell it)
- Items have a "quality" (how valuable it is)
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