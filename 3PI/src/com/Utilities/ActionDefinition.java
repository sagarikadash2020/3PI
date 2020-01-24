package com.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionDefinition {
	public WebDriver driver;
	 public void Click_xpath(String Xpath)
     {
         try
         {
             Boolean IsElement = driver.findElement(By.xpath(Xpath)).isDisplayed();
             //KPMG_ABB_LogGeneration.GenerateLog("IsElement" + IsElement);
             if (IsElement)
             {
                
            	 driver.findElement(By.xpath(Xpath)).click();
                 Thread.sleep(5000);
                 //LogGeneration.GenerateLog("Verify Element Passed: " + "xpath: |" + Xpath + " is displayed on UI.");
             }
             else
             {
            	 System.out.print("Element not displayed");
            
                 
                //LogGeneration.GenerateLog("Verify Element Failed: " + "xpath: |" + Xpath + " is not displayed on UI.");
             }

         }
         catch(Exception e)
         {
            
            LogGeneration.GenerateLog(": Failed ---> Button Click with xpath Path |" + Xpath + "|");
         }
     }
	 
	/* public void Select_DropdownByText(String csspath, String Text)
	 {
		 try
		 {
			 
		 }
		 catch 
		 {
			 
		 }
	 }*/
}


