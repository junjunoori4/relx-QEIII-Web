package com.relx.pages;

import org.openqa.selenium.WebDriver;

import com.relx.components.Header;

public class SwagLabs {
	
	public WebDriver driver;
	public LoginPage loginPage;
	public HomePage homePage;
	public CartPage cartPage;
	public CheckoutPage checkoutPage;
	public OverviewPage overViewPage;
	public Header header;
	
	public SwagLabs(WebDriver driver)
	{
		this.driver = driver;
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);
		overViewPage = new OverviewPage(driver);
		header = new Header(driver);
	}

}
