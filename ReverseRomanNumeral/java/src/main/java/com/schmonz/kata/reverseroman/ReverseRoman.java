package com.schmonz.kata.reverseroman;

import java.util.HashMap;
import java.util.Map;

public class ReverseRoman {

	public int roman2decimal(String roman) {
		int decimal = 0;

		char[] romanDigits = roman.toCharArray();
		for (char thisDigit : romanDigits) {
			decimal += digit2decimal(thisDigit);
		}
	
		return decimal;
	}

	private int digit2decimal(char romanDigit) {
		Map<Character, Integer> knownDigits = new HashMap<Character, Integer>();
		knownDigits.put('I',  1);
		knownDigits.put('V',  5);

		if (knownDigits.containsKey(romanDigit)) {
			return knownDigits.get(romanDigit);
		} else {
			return 0;
		}
	}

}
