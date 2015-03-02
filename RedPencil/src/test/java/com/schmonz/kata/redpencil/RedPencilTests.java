package com.schmonz.kata.redpencil;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RedPencilTests {
	private Item item;
	
	@Before
	public void setup() {
		item = new Item(43.21);
		item.letSomeDaysPass(29);
	}

	@Test
	public void initialStateIsNotRedPencil() {
		assertFalse(item.isRedPenciled());
	}
	
	@Test
	public void priceReducedButNotEnough() {
		item.letSomeDaysPass(1);
		item.setPrice(41.05);
		assertFalse(item.isRedPenciled());
	}
	
	@Test
	public void priceReducedJustEnough() {
		item.letSomeDaysPass(1);
		item.setPrice(41.04);
		assertTrue(item.isRedPenciled());
	}
	
	@Test
	public void priceReducedButTooMuch() {
		item.letSomeDaysPass(1);
		item.setPrice(30.24);
		assertFalse(item.isRedPenciled());
	}
	
	@Test
	public void priceReducedJustBarelyNotTooMuch() {
		item.letSomeDaysPass(1);
		item.setPrice(30.25);
		assertTrue(item.isRedPenciled());
	}

	@Test
	public void priceReducedEnoughButTooRecently() {
		item.letSomeDaysPass(0);
		item.setPrice(36.99);
		assertFalse(item.isRedPenciled());
	}
	
}

/*

We provide a shopping portal, where dealers can offer their goods
(similar to Amazon marketplace). We want to support red pencil
promotions for reduced prices. During the red pencil promotion
the old price is crossed out in red and the new reduced price
is written next to it.

To avoid misuse of red pencil promotions the red pencil promotions
are activated and deactivated automatically.

The scope of the Code Kata is the implementations of the rules for
activation and end of red pencil promotions.

- A red pencil promotion lasts 30 days as the maximum length.

- If the price is further reduced during the red pencil promotion
  the promotion will not be prolonged by that reduction.

- If the price is increased during the red pencil promotion the
  promotion will be ended immediately.

- If the price if reduced during the red pencil promotion so that
  the overall reduction is more than 30% with regard to the
  original price, the promotion is ended immediately.

- After a red pencil promotion is ended additional red pencil
  promotions may follow – as long as the start condition is
  valid: the price was stable for 30 days and these 30 days
  don't intersect with a previous red pencil promotion.

*/