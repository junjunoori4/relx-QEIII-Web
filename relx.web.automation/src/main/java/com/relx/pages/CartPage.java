package com.relx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	private WebDriver driver;
	
	private By checkoutBtn = By.xpath("//button[@id='checkout']");
	
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void clickCheckout()
	{
		driver.findElement(checkoutBtn).click();
	}
	
	public void verifyCartPage()
	{
		driver.findElement(checkoutBtn).isDisplayed();
	}
	
	public String getItem1Price()
	{
		String item1Price = driver.findElement(By.xpath("//div[@class='cart_item'][1]//div[@class='inventory_item_price']")).getText().substring(1);
		return item1Price;
	}
	
	public String getItem2Price()
	{
		String item2Price = driver.findElement(By.xpath("//div[@class='cart_item'][2]//div[@class='inventory_item_price']")).getText().substring(1);
		return item2Price;
	}
}
