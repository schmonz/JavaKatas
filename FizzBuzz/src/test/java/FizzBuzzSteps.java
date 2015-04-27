import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

public class FizzBuzzSteps {
	private int number;
	private String numberForDisplay;

	@Given("^the number (\\d+)$")
	public void theNumber(int number) throws Throwable {
		this.number = number;
	}
	
	@When("^it is displayed$")
	public void itIsDisplayed() throws Throwable {
		numberForDisplay = new FizzBuzz().convert(number);
	}
	
	@Then("^it is shown as (.+)$")
	public void itsValueIs(String expectedOutput) throws Throwable {
	    assertEquals(expectedOutput, numberForDisplay);
	}
	
}
