package com.schmonz.kata.reverseroman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

public class ReverseRomanSteps {
	String roman;
	int actualDecimal;

	@Given("^the Roman numeral (.+)$")
	public void theRomanNumeral(String romanNumeral) throws Throwable {
		roman = romanNumeral;
	}
	
	@When("^it is converted to decimal$")
	public void itIsConvertedToDecimal() throws Throwable {
		actualDecimal = new ReverseRoman().roman2decimal(roman);
	}
	
	@Then("^its value is (\\d+)$")
	public void itsValueIs(int expectedDecimal) throws Throwable {
	    assertEquals(expectedDecimal, actualDecimal);
	}
	
}
