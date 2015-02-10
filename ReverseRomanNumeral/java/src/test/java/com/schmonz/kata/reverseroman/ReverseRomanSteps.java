package com.schmonz.kata.reverseroman;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertEquals;

public class ReverseRomanSteps {
	String roman;
	int actual_decimal;

	@Given("^the Roman numeral (.+)$")
	public void the_roman_numeral(String roman_numeral) throws Throwable {
		roman = roman_numeral;
	}
	
	@When("^it is converted to decimal$")
	public void it_is_converted_to_decimal() throws Throwable {
		actual_decimal = new ReverseRoman().roman2decimal(roman);
	}
	
	@Then("^its value is (\\d+)$")
	public void its_value_is(int expected_decimal) throws Throwable {
	    assertEquals(expected_decimal, actual_decimal);
	}
	
}