package com.pages;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Utilities.LogGeneration;
import com.Utilities.Utilites;
import com.test.TestBase;

public class ActionsPage extends Utilities {
	
	public WebDriver driver;
	static By CostCollectorLink=By.xpath("//a[text()='Submit Cost Collector Request']");
	
	public ActionsPage(WebDriver driver) {
		this.driver = driver;
	}
	public ActionsPage Click_CostCollectorNewRequestLink()
	{
	try 
		{
		driver.findElement(CostCollectorLink).click();
		TestBase.test.pass("Clicked on Submit Request Link");
		}
	catch(Exception e)
	{
		TestBase.test.error("Error Displayed"+e.getMessage());
	}
	return this;
	}

	

}
