package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class InstantisIDSelection {
	public WebDriver driver;
	//Locators
		static By ProjectID_RadioButton=By.xpath("//label[text()='Project ID']");
		static By SearchInstantis_Button=By.xpath("//button[text()='Search Instantis']");
		
		public InstantisIDSelection(WebDriver driver) 
		{
			this.driver = driver;
		}
		
		public void Select_ProjectID() throws InterruptedException
		{
			//Thread.sleep(5000);
			driver.findElement(ProjectID_RadioButton).click();
		}
		
		public void Click_SearchInstantis() throws InterruptedException
		{
			//Thread.sleep(5000);
			driver.findElement(SearchInstantis_Button).click();
		}	
		

}
