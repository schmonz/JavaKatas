
public class Diamond {

	public String print(String letter) {
		if ("B".equals(letter)) {
			return printLine(1, "A", " A\n")
				+ printLine(2, "B", "B B\n")
				+ printLine(1, "A", " A");
		} else {
			return printLine(1, "A", "A");
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
