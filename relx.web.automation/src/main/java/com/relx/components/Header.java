package com.relx.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

	private WebDriver driver;
	private By pageHeader = By.xpath("//div[@class='header_secondary_container']/span");
	
	public Header(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String pageHeaderValue()
	{
		String header = driver.findElement(pageHeader).getText();
		return header;
	}
}
