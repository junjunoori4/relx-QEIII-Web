package com.relex.stepDefinitions;

import com.relx.factory.DriverFactory;
import com.relx.pages.SwagLabs;
import com.relx.util.GlobalDataVariables;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartPageSteps {
	
	private SwagLabs swagLabs = new SwagLabs(DriverFactory.getDriver());
	public GlobalDataVariables dataVariables;
	
	public CartPageSteps(GlobalDataVariables dataVariables)
	{
		this.dataVariables = dataVariables;
	}
	
	@Given("I validate navigation to cart page with header {string}")
	public void i_validate_navigation_to_cart_page_with_header(String expectedHeader) {
		String actualHeader = swagLabs.header.pageHeaderValue();
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@Given("I validate the items in cart")
	public void i_validate_the_items_in_cart() {
		 String item1Price = swagLabs.cartPage.getItem1Price();
		 Assert.assertEquals(dataVariables.getItem1Price(), item1Price);
		 String item2Price = swagLabs.cartPage.getItem2Price();
		 Assert.assertEquals(dataVariables.getItem2Price(), item2Price);
	}

	@Then("I click checkout button")
	public void i_click_checkout_button() {
	  swagLabs.cartPage.clickCheckout();
	}
}
