package com.relex.stepDefinitions;

import java.util.List;
import java.util.Map;
import org.testng.Assert;
import com.relx.factory.DriverFactory;
import com.relx.pages.SwagLabs;
import com.relx.util.GlobalDataVariables;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomePageSteps {
	
	private SwagLabs swagLabs = new SwagLabs(DriverFactory.getDriver());
	
	public GlobalDataVariables dataVariables;
	public HomePageSteps(GlobalDataVariables dataVariables)
	{
		this.dataVariables = dataVariables;
	}
		
	@Given("user has logged into application")
	public void user_has_logged_into_application(DataTable dataTable) {
	   List<Map<String, String>> credList = dataTable.asMaps();
	   String userName = credList.get(0).get("Username");
	   String password = credList.get(0).get("Password");
	   
	   DriverFactory.getDriver().get("https://www.saucedemo.com/");
	   swagLabs.loginPage.doLogin(userName, password);
	}
		
	@Given("user navigates to homepage with header {string}")
	public void user_navigates_to_homepage_with_header(String expectedHeader) {
		String actualHeader = swagLabs.header.pageHeaderValue();
		Assert.assertEquals(actualHeader, expectedHeader);
	}

	@Then("I filter price from high to low")
	public void i_filter_price_from_high_to_low() {
	   swagLabs.homePage.filterFromHightoLow();
	}
	
	@Then("I validate the selected filter {string}")
	public void i_validate_the_selected_filter(String expectedFilter) {
	    String actualFilter = swagLabs.homePage.getSelectedFilter();
	    Assert.assertEquals(actualFilter, expectedFilter);
	}
	
	@Given("I add cheapest and second costliest items to basket")
	public void i_add_cheapest_and_second_costliest_items_to_basket() {
		swagLabs.homePage.addToCart();
		   String item1Price = swagLabs.homePage.getItem1Price();
		   dataVariables.setItem1Price(item1Price);
		   String item2Price = swagLabs.homePage.getItem2Price();
		   dataVariables.setItem2Price(item2Price);
	}
	
	@Then("I click on cart icon")
	public void i_click_on_cart_icon() {
	   swagLabs.homePage.clickCartIcon();
	}
}
