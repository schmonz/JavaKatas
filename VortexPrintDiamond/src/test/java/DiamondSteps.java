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
	
	@Then("^it should look like$")
	public void it_should_look_like(String expectedOutput) throws Throwable {
		assertEquals(expectedOutput, actualOutput);
	}
		
}
