public class FizzBuzz {

	public String convert(int number) {
		String numberAsString = "";
		
		if ( ((number % 3) == 0) && ((number % 5) == 0) ) {
			numberAsString = "FizzBuzz";
		} else if ((number % 3) == 0) {
			numberAsString = "Fizz";
		} else if ((number % 5) == 0) {
			numberAsString = "Buzz";
		} else {
			numberAsString = Integer.toString(number);
		}
		
		return numberAsString;
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= 100; i++) {
			System.out.println(new FizzBuzz().convert(i));
		}
	}

}
