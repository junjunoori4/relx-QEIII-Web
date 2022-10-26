package com.relx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {

	private WebDriver driver;
	
	private By finishBtn = By.id("finish");
	private By subTotal = By.xpath("//div[@class='summary_subtotal_label']");
	
	public OverviewPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String returnTotalPrice()
	{
		String subTotalCost = driver.findElement(subTotal).getText();
		String total = subTotalCost.substring(subTotalCost.lastIndexOf("$")+1);
		return total;
	}
	
	public void clickFinishBtn()
	{
		driver.findElement(finishBtn).click();
	}
}
