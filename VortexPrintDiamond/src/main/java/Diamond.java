
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
	
	public String printLine(int whichLine, String letter, String whatToPrint) {
		StringBuffer firstLine = new StringBuffer();

		int howManyLeadingSpaces = positionInAlphabet(letter) - whichLine;
		for (int i = 0; i < howManyLeadingSpaces; i++) {
			firstLine.append(' ');
		}
		firstLine.append(whatToPrint);
		
		return firstLine.toString();
	}

	private int positionInAlphabet(String letter) {
		char justTheLetter = letter.toCharArray()[0];
		int letterPositionMaybe = (int)justTheLetter - 64;
		return letterPositionMaybe;
	}

}
