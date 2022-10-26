package com.relex.stepDefinitions;

import org.testng.Assert;

import com.relx.factory.DriverFactory;
import com.relx.pages.SwagLabs;

import io.cucumber.java.en.Then;

public class OrderConfirmationPageSteps {

	private SwagLabs swagLabs = new SwagLabs(DriverFactory.getDriver());
	
	@Then("I should navigate to order confirmation page with header {string}")
	public void i_should_navigate_to_order_confirmation_page_with_header(String expectedHeader) {
		String actualHeader = swagLabs.header.pageHeaderValue();
		Assert.assertEquals(actualHeader, expectedHeader);
	}
}
