import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestArabicToRoman {
	
	private void assertArabicGivesRoman(int arabic, String roman) {
		assertThat(new ArabicToRoman().convert(arabic), is(roman));
	}
	
	@Test
	public void test0() {
		assertArabicGivesRoman(0, "");
	}
	
	@Test
	public void test1() {
		assertArabicGivesRoman(1, "I");
	}
	
	@Test
	public void test2() {
		assertArabicGivesRoman(2, "II");
	}
	
	@Test
	public void test6() {
		assertArabicGivesRoman(6, "VI");
	}

	@Test
	public void test4() {
		assertArabicGivesRoman(4, "IV");
	}
	
	@Test
	public void test9() {
		assertArabicGivesRoman(9, "IX");
	}
	
	@Test
	public void test90() {
		assertArabicGivesRoman(90, "XC");
	}
	
	@Test
	public void test1990() {
		assertArabicGivesRoman(1990, "MCMXC");
	}
	
	@Test
	public void test2008() {
		assertArabicGivesRoman(2008, "MMVIII");
	}
	
	@Test
	public void test47() {
		assertArabicGivesRoman(47, "XLVII");
	}
	
}