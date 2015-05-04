import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class DiamondSteps {
	String letter;
	String actualOutput;

	@Given("^the letter ([A-Z])$")
	public void the_letter(String inputLetter) throws Throwable {
		letter = inputLetter;
	}
	
	@When("^printing a diamond$")
	public void printing_a_diamond() throws Throwable {
		Diamond diamond = new Diamond();
		actualOutput = diamond.print(letter);
	}
	
	@When("^printing the first line$")
	public void printing_the_first_line() throws Throwable {
		Diamond diamond = new Diamond();
		actualOutput = diamond.printLine(1, letter, "A");
	}
	
	@When("^printing the second line$")
	public void printing_the_second_line() throws Throwable {
		Diamond diamond = new Diamond();
		actualOutput = diamond.printLine(2, letter, "B B");
	}

	@When("^printing the second-to-last line$")
	public void printing_the_second_to_last_line() throws Throwable {
		Diamond diamond = new Diamond();
		actualOutput = diamond.printLine(2, letter, "B B");;
	}
	
	@When("^printing the last line$")
	public void printing_the_last_line() throws Throwable {
		Diamond diamond = new Diamond();
		actualOutput = diamond.printLine(1, letter, "A");
	}


	
	@Then("^it should look like$")
	public void it_should_look_like(String expectedOutput) throws Throwable {
		assertEquals(expectedOutput, actualOutput);
	}
	
	//seems like the number of spaces preceding "A"
	// is one less than the position of the given letter
	// in the alphabet
	//to test this, I need to know:
	// - given a letter of the alphabet, what position is it?
	// - given the same letter, what does our first line look like?
		
}
