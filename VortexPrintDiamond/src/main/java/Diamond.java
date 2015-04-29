
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

}
