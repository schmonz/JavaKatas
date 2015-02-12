package com.schmonz.kata.reverseroman;

import java.util.HashMap;
import java.util.Map;

public class ReverseRoman {

	public int roman2decimal(String roman) {
		int decimal = 0;

		int previous = 0;
		char[] reversedRomanDigits = new StringBuffer(roman).reverse().toString().toCharArray();
		for (char thisDigit : reversedRomanDigits) {
			int decimalDigit = digit2decimal(thisDigit);
			if (decimalDigit < previous) {
				decimal -= decimalDigit;
			} else {
				decimal += decimalDigit;
			}
			previous = decimalDigit;
		}

		return decimal;
	}

	private int digit2decimal(char romanDigit) {
		Map<Character, Integer> knownDigits = new HashMap<Character, Integer>();
		knownDigits.put('I',  1);
		knownDigits.put('V',  5);
		knownDigits.put('X',  10);
		knownDigits.put('L',  50);
		knownDigits.put('C',  100);
		knownDigits.put('M',  1000);

		if (knownDigits.containsKey(romanDigit)) {
			return knownDigits.get(romanDigit);
		} else {
			return 0;
		}
	}

}
