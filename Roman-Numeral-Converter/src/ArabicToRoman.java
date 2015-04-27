/* Smithson said: see Jim Weirich's Ruby implementation */

import java.util.LinkedHashMap;
import java.util.Map;

public class ArabicToRoman {
	private Map<String, Integer> arabicFor;
	
	public ArabicToRoman() {
		arabicFor = new LinkedHashMap<String, Integer>();
		arabicFor.put( "M", 1000);
		arabicFor.put("CM",  900);
		arabicFor.put( "D",  500);
		arabicFor.put("CD",  400);
		arabicFor.put( "C",  100);
		arabicFor.put("XC",   90);
		arabicFor.put( "L",   50);
		arabicFor.put("XL",   40);
		arabicFor.put( "X",   10);
		arabicFor.put("IX",    9);
		arabicFor.put( "V",    5);
		arabicFor.put("IV",    4);
		arabicFor.put( "I",    1);
	}
	
	public String convert(int arabic) {
		StringBuilder sb = new StringBuilder();
		
		if (arabic <= 0) {
			return sb.toString();
		} else {
			String romanAtom = largestRomanAtomIn(arabic);			
			return sb.append(
					romanAtom +
					convert(arabic - arabicForRomanAtom(romanAtom))
			).toString();
		}
	}
	
	private String largestRomanAtomIn(int arabic) {
		for (Map.Entry<String, Integer> entry : arabicFor.entrySet()) {
			if (entry.getValue() <= arabic) {
				return entry.getKey();
			}
		}
		
		return "";
	}
	
	private int arabicForRomanAtom(String romanAtom) {
		for (Map.Entry<String, Integer> entry : arabicFor.entrySet()) {
			if (entry.getKey().equals(romanAtom)) {
				return entry.getValue();
			}
		}
		
		return 0;
	}
}