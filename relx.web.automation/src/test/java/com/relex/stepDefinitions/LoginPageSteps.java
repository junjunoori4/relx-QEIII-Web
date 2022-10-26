package com.relex.stepDefinitions;

import com.relx.factory.DriverFactory;
import com.relx.pages.SwagLabs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private SwagLabs swagLabs = new SwagLabs(DriverFactory.getDriver());
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	  DriverFactory.getDriver().get("https://www.saucedemo.com/");
	}

	@When("user enters username {string}")
	public void user_enters_username(String userName) {
	  swagLabs.loginPage.enterUserName(userName);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
	  swagLabs.loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	   swagLabs.loginPage.clickLogin();
	}
}
