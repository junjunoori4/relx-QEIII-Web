package com.relx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	private By loginLogo = By.xpath("//div[@class='login_logo']");
	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void getLoginPageTitle()
	{
		driver.findElement(loginLogo).isDisplayed();
	}

	public void enterUserName(String username)
	{
		driver.findElement(userName).sendKeys(username);
	}
	
	public void enterPassword(String passWord)
	{
		driver.findElement(password).sendKeys(passWord);
	}
	
	public void clickLogin()
	{
		driver.findElement(loginButton).click();
	}
	
	public void doLogin(String username, String password)
	{
		enterUserName(username);
		enterPassword(password);
		clickLogin();
	}
	
}
