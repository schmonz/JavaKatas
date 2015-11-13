package com.schmonz.trend;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class CalculatorTests {

	@Test
	public void giveNullGetNull() {
		assertNull(new Calculator().computeTrend(null));
	}

	@Test
	public void giveEmptyGetNull() {
		assertNull(new Calculator().computeTrend());
	}

	@Test
	public void giveSingleValueGetZero() {
		assertTrendEquals(0.0, 5.7);
	}

	@Test
	public void giveTwoValuesGetInSameOrderAsDoubles() {
		assertEquals("[[5.0, 7.7]]", new Calculator().generatePairs(5, 7.7).toString());
	}

	@Test
	public void giveThreeValuesGetTwoPairsInSameOrder() {
		assertEquals("[[5.0, 7.7], [7.7, 9.0]]", new Calculator().generatePairs(5, 7.7, 9).toString());
	}

	@Test
	public void pairWhereElement1IsZeroAndElement2IsGreaterThanZero() {
		assertPairEquals(1.0, 0.0, 5.7);
	}

	@Test
	public void pairWhereElement1EqualsElement2() {
		assertPairEquals(0.0, 5.7, 5.7);
	}

	@Test
	public void pairOfAnyOtherKind() {
		assertPairEquals(1.32258064516129, 3.1, 7.2);
	}

	@Test
	public void rjoExample1() {
		assertTrendEquals(0.0, 1, 1);
	}

	@Test
	public void rjoExample2() {
		assertTrendEquals(1.0, 0, 0.01);
	}

	@Test
	public void rjoExample3() {
		assertTrendEquals(1.0, 1, 2);
	}

	@Test
	public void rjoExample4() {
		assertTrendEquals(11.0 / 6.0, 1, 2, 3, 4);
	}

	private void assertTrendEquals(double expected, Object... varargs) {
		assertEquals(expected, new Calculator().computeTrend(varargs), Calculator.TOLERANCE);
	}

	private void assertPairEquals(double expected, double one, double two) {
		assertEquals(expected, new Calculator().computePairValue(one, two), Calculator.TOLERANCE);
	}
}