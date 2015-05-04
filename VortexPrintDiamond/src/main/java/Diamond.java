
public class Diamond {
	
	private static final String A_DIAMOND = "A";
	private static final String B_DIAMOND = " A\nB B\n A";

	public String print(String letter) {
		if ("B".equals(letter)) {
			return B_DIAMOND;
		} else {
			return A_DIAMOND;
		}
	}

	public String printFirstLine(String letter) {
		StringBuffer firstLine = new StringBuffer();

		int howManyLeadingSpaces = positionInAlphabet(letter) - 1;
		for (int i = 0; i < howManyLeadingSpaces; i++) {
			firstLine.append(' ');
		}
		firstLine.append('A');
		
		return firstLine.toString();
	}

	private int positionInAlphabet(String letter) {
		char justTheLetter = letter.toCharArray()[0];
		int letterPositionMaybe = (int)justTheLetter - 64;
		return letterPositionMaybe;
	}

}
