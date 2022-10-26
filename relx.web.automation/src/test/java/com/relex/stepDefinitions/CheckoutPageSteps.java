package com.relex.stepDefinitions;

import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.relx.factory.DriverFactory;
import com.relx.pages.SwagLabs;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CheckoutPageSteps {
	
	private SwagLabs swagLabs = new SwagLabs(DriverFactory.getDriver());

	@Then("I enter below personal details")
	public void i_enter_below_personal_details(DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String firstName = credList.get(0).get("FirstName");
		String lastName = credList.get(0).get("LastName");
		String postalCode = credList.get(0).get("PostalCode");
		
		swagLabs.checkoutPage.enterPersonalDetails(firstName, lastName, postalCode);		
	}
	
	@Given("I validate navigation to checkout page with header {string}")
	public void i_validate_navigation_to_checkout_page_with_header(String expectedHeader) {
		String actualHeader = swagLabs.header.pageHeaderValue();
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@Then("I click continue button")
	public void i_click_continue_button() {
	   swagLabs.checkoutPage.clickContinueBtn();
	}
}
