package com.schmonz.kata.gildedrose;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GildedRoseTest {
	
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

		List<ReasonableItem> initialItems = new GildedRose().getItems();
		assertNotNull(initialItems);
		assertEquals(expectedItems.size(), initialItems.size());
		
		for (int i = 0; i < expectedItems.size(); i++) {
			Item expected = expectedItems.get(i);
			ReasonableItem actual = initialItems.get(i);
			
			assertEquals(expected.getName(), actual.getName());
			assertEquals(expected.getSellIn(), actual.getSellIn());
			assertEquals(expected.getQuality(), actual.getQuality());
			
			assertTrue(actual.getQuality() >= ReasonableItem.QUALITY_MIN);
		}
	}

	@Test
	public void canUpdateQualityAndSellIn() {
		GildedRose mindTheStore = new GildedRose();
		ReasonableItem ordinaryVest = mindTheStore.getItems().get(0);
		
		updateAllAndAssertOne(mindTheStore, ordinaryVest, -1, -1);
	}
	
	@Test
	public void canUpdateAgedBrie() {
		GildedRose mindTheStore = new GildedRose();
		ReasonableItem theBrie = findTheBrie(mindTheStore.getItems());

		updateAllAndAssertOne(mindTheStore, theBrie, -1, 1);
		updateAllAndAssertOne(mindTheStore, theBrie, -1, 1);
		
		updateAllAndAssertOne(mindTheStore, theBrie, -1, 2);
		
		assertEquals(-1, theBrie.getSellIn());
		assertEquals(4, theBrie.getQuality());
	}
	
	@Test
	public void canUpdateBackstagePasses() {
		GildedRose mindTheStore = new GildedRose();
		ReasonableItem thePasses = findThePasses(mindTheStore.getItems());
		
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 1);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 1);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 1);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 1);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 1);
		assertEquals(10, thePasses.getSellIn());
		assertEquals(25, thePasses.getQuality());
		
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 2);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 2);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 2);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 2);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 2);
		assertEquals(5, thePasses.getSellIn());
		assertEquals(35, thePasses.getQuality());

		updateAllAndAssertOne(mindTheStore, thePasses, -1, 3);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 3);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 3);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 3);
		updateAllAndAssertOne(mindTheStore, thePasses, -1, 3);
		assertEquals(0, thePasses.getSellIn());
		assertEquals(50, thePasses.getQuality());

		updateAllAndAssertOne(mindTheStore, thePasses, -1, -50);
		assertEquals(-1, thePasses.getSellIn());
		assertEquals(0, thePasses.getQuality());
	}
	
	@Test
	public void cannotUpdateQualityTooHighOrTooLow() {
		GildedRose mindTheStore = new GildedRose();
		List<ReasonableItem> items = mindTheStore.getItems();
		
		for (int i = 0; i < 2 * ReasonableItem.QUALITY_MAX; i++) {
			mindTheStore.updateQuality();
			for (ReasonableItem item : items) {
				if (item.isSulfuras()) {
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
		return items.stream().filter(o -> o.isPasses()).findFirst().get();
	}

	private ReasonableItem findTheBrie(List<ReasonableItem> items) {
		return items.stream().filter(o -> o.isBrie()).findFirst().get();
	}
	
	/* MENTAL STACK:
	 * deconstruct updateQuality()
	 * stop needing superHackySetup()
	 * the doubling of quality change after sell-by goes for Brie, too
	 */
}

/*

# Constraints

- Can't change the Item class
- Can't change the items property
- Can change updateQuality(), provided nothing breaks


# Assignment

- Track "conjured" items, whose quality degrades twice as fast to begin with

*/