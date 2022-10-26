package com.relx.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	private WebDriver driver;
	
	private By sortDropdown = By.xpath("//select[@class = 'product_sort_container']");
	private By noOfItems = By.xpath("//div[@class='inventory_item']");
	private By cartIcon = By.xpath("//a[@class='shopping_cart_link']");
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void filterFromHightoLow()
	{
		Select sort = new Select(driver.findElement(sortDropdown));
		sort.selectByValue("hilo");		
	}
	
	public String getSelectedFilter()
	{
		return new Select(driver.findElement(sortDropdown)).getFirstSelectedOption().getText();
	}
	
	public void addToCart()
	{
		List<WebElement> prices = driver.findElements(noOfItems);
		
		for(int i=1; i<=prices.size(); i++)
		{
			if(i==2)
			{
				driver.findElement(By.xpath("//div[@class='inventory_item']["+(i)+"]//div[@class='inventory_item_price']/following-sibling::button")).click();						
			}
			else if(i==prices.size())
			{
				driver.findElement(By.xpath("//div[@class='inventory_item']["+(i)+"]//div[@class='inventory_item_price']/following-sibling::button")).click();						
			}
		}
	}
	
	public String getItem1Price()
	{
		String Item1Price = driver.findElement(By.xpath("//div[@class='inventory_item'][2]//div[@class='inventory_item_price']")).getText().substring(1);
		return Item1Price;
	}
	
	public String getItem2Price()
	{
		List<WebElement> prices = driver.findElements(noOfItems);
		int count = prices.size();
		String Item2Price = driver.findElement(By.xpath("//div[@class='inventory_item']["+count+"]//div[@class='inventory_item_price']")).getText().substring(1);
		return Item2Price;
	}
	
	public void clickCartIcon() {
		driver.findElement(cartIcon).click();
	}
}
