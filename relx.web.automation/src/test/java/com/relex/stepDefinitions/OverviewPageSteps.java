package com.relex.stepDefinitions;

import org.testng.Assert;

import com.relx.factory.DriverFactory;
import com.relx.pages.SwagLabs;
import com.relx.util.GlobalDataVariables;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class OverviewPageSteps {
	
	private SwagLabs swagLabs = new SwagLabs(DriverFactory.getDriver());
	private GlobalDataVariables dataVariables;
	
	public OverviewPageSteps(GlobalDataVariables dataVariables)
	{
		this.dataVariables = dataVariables;
	}

	@Given("I validate navigation to overview page with header {string}")
	public void i_validate_navigation_to_overview_page_with_header(String expectedHeader) {
		String actualHeader = swagLabs.header.pageHeaderValue();
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@Given("I validate total price in cart")
	public void i_validate_total_price_in_cart() {
	    float actualSubTotal =   Float.parseFloat(swagLabs.overViewPage.returnTotalPrice());
	    System.out.println("Item 1 Price:" + dataVariables.getItem1Price());
	    float expectedSubTotal = Float.parseFloat(dataVariables.getItem1Price()) + Float.parseFloat(dataVariables.getItem2Price());
	    Assert.assertEquals(actualSubTotal, expectedSubTotal);
	}
	
	@When("I click on finish button")
	public void i_click_on_finish_button() {
	    swagLabs.overViewPage.clickFinishBtn();
	}
}
