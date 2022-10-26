package com.relx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	private WebDriver driver;
	
	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By postalCode = By.id("postal-code");
	private By continueBtn = By.id("continue");
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void enterPersonalDetails(String firstname, String lastname, String postalcode)
	{
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(postalCode).sendKeys(postalcode);
	}
	
	public void clickContinueBtn()
	{
		driver.findElement(continueBtn).click();
	}
}
