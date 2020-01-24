package com.pages;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.ActionDefinition;
import com.Utilities.LogGeneration;
import com.test.TestBase;

public class PCOrderCreation extends ActionDefinition {
	
	public static WebDriver driver;
	
	
	
	static By  ActionsTab=By.xpath("//a[@class='appian-menu-item'][contains(text(),'Actions')]");
	static By  ThreePIApplication_link=By.xpath("(//span[text()='3PI Application'])[last()]");
	static By  PCOrdersCreation_link=By.xpath("//a[text()='3PI Submit Order Request']");
	static By  Ordertype=By.xpath("//div[text()='--- Select a Value ---']");
	static By  Next_button =By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']");
	static By  Neworder_Radiobutton =By.xpath("//*[text()='New Order Request (PC Refresh or Project Based)']");
	static By  Next_button_2=By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']");
	static By  ProjectID=By.xpath("//label[text()='Project ID']/following::input[1]");
	static By  Search_Button=By.xpath("//*[text()='Search']");
	static By  Projectid_Checkbox= By.xpath("(//Label[@class='CheckboxGroup---choice_label'])[last()]");	
	static By  BusinessJust_text= By.xpath("//label[text()='Business Justification']/following::div[2]/textarea");
    static By  Next_Button_3=By.xpath("//*[text()='Next']");
	static By  Country_Exp_Del_Yr=By.xpath("//span[text()='Country and Expected Delivery Year']/following::div[3]");
    static By  AddItem_Link=By.xpath("//a[text()='+Add Item']");
    static By  Next_button4 =By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']");
    static By  TaxIncluded_radiobutton=By.xpath("//input[@value='No']");
    static By  Next_button5=By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']");
    static By  Shippingmaterial=By.xpath("(//input[@value='No'])[1]");
    static By  eDelivery=By.xpath("(//input[@value='No'])[last()]");
    static By  Next_button6=By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']");
    static By  Submit_Button=By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']");
    
	public PCOrderCreation(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void Click_ActionsTab() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ActionsTab));
			driver.findElement(ActionsTab).click();
			TestBase.test.pass("Clicked on Actions Tab");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}
	}

	
	public void Click_ThreePIApplication_Link() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ThreePIApplication_link));
			driver.findElement(ThreePIApplication_link).click();
			TestBase.test.pass("Clicked on 3PI Application Link");
		} catch (Exception e) {
			TestBase.test.error("Could not click on 3PI Application Link and Error Displayed as :" + e.getMessage());
		}
	}

	
	public PCOrderCreation Click_PCOrdersCreation_link() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(PCOrdersCreation_link));
			driver.findElement(PCOrdersCreation_link).click();
			TestBase.test.pass("Clicked on New Order  Link");
		} catch (Exception e) {
			TestBase.test.error(
					"Could not click on New PC order  and Error Displayed as :" + e.getMessage());
		}
		return this;
	}
	
	       
                        
                  
	    public void Select_Ordertype_dropdown() throws InterruptedException {
    	By Next_button  = By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']");
		WebElement element = driver.findElement(By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		WebElement Ordertype_dropdown = driver.findElement(Ordertype);
		Ordertype_dropdown.click();
//		Thread.sleep(2000);
		Ordertype_dropdown.sendKeys(Keys.ARROW_DOWN);
		Ordertype_dropdown.sendKeys(Keys.ARROW_DOWN);
		Ordertype_dropdown.sendKeys(Keys.ARROW_DOWN);
		Ordertype_dropdown.sendKeys(Keys.ARROW_DOWN);
//		Thread.sleep(1000);
		Ordertype_dropdown.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
        }
	    
	    
	    public void Click_Next_button() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(Next_button));
			driver.findElement(Next_button).click();
		}
		

	    
	    
	    public void Select_Neworder() {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				WebElement element = driver.findElement(By.xpath("//*[text()='New Order Request (PC Refresh or Project Based)']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(Neworder_Radiobutton));
				Thread.sleep(1000);
				WebElement element1 = driver.findElement(Neworder_Radiobutton);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element1);

				TestBase.test.pass("New Order Request (PC Refresh or Project Based)");
			} catch (Exception e) {
			}
		}
	   
	    
	 
	    public void Click_Next_button_2() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(Next_button_2));
			driver.findElement(Next_button_2).click();
		}
		
	    public PCOrderCreation Enter_ProjectID(String InstantisID) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(ProjectID));
				driver.findElement(ProjectID).sendKeys(InstantisID);
				TestBase.test.pass("Entered PMT ID");
			} catch (Exception e) {
				TestBase.test.error("Error Displayed" + e.getMessage());
			}
			return this;
		}
	    
	    public void Click_Search_Button() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(Search_Button));
			driver.findElement(Search_Button).click();
		}
		
	             
	    
	    
	      public void Click_Projectid_checkbox() throws InterruptedException {
	    	
	         //Identifying Terms and Condition checkbox using its ID as an locator
	       System.out.println(driver.findElement(By.xpath("(//Label[@class='CheckboxGroup---choice_label']/..)[last()]")).isSelected());
	       WebElement Projectid_checkbox = driver.findElement(By.xpath("(//Label[@class='CheckboxGroup---choice_label']/..)[last()]"));
	       
	       if(!Projectid_checkbox.isSelected())
	    	   Projectid_checkbox.click();
	      	 System.out.println(driver.findElement(By.xpath("(//Label[@class='CheckboxGroup---choice_label']/..)[last()]")).isSelected());
	        }

	     
	      
	      public PCOrderCreation Enter_BusinessJust_text() throws InterruptedException {
	  		try {
	  			WebDriverWait wait = new WebDriverWait(driver, 30);
	  			wait.until(ExpectedConditions.visibilityOfElementLocated(BusinessJust_text));
	  			Random objGenerator = new Random();
	  			int randomNumber = objGenerator.nextInt(100);
	  			String rndNum = Integer.toString(randomNumber);
	  			System.out.println("Random Number Generated"+rndNum);
	  			Thread.sleep(500);
	  			driver.findElement(BusinessJust_text).click();
	  			driver.findElement(BusinessJust_text).sendKeys("Test" + rndNum);
	  			driver.findElement(BusinessJust_text).sendKeys(""+ Keys.TAB);
	  			TestBase.test.pass("Entered Business Justification text");
	  		} catch (Exception e) {
	  			TestBase.test.error("Error Displayed" + e.getMessage());
	  		}
	  		return this;
	  	}
	    
	     
	          
	      
	      public void Click_Next_Button_3() throws InterruptedException {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(Next_Button_3));
				driver.findElement(Next_Button_3).click();
			}
			
	      
	      public void Select_Country_Exp_Del_Yr_dropdown() throws InterruptedException {
//	      	By Next_button  = By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']");
//	  		WebElement element = driver.findElement(By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']"));
//	  		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//	  		Thread.sleep(1000);
	  		WebElement Country_Exp_Del_Yr_dropdown = driver.findElement(Country_Exp_Del_Yr);
	  		Country_Exp_Del_Yr_dropdown.click();
//	  		Thread.sleep(2000);
	  		Country_Exp_Del_Yr_dropdown.sendKeys(Keys.ARROW_DOWN);
	  		Country_Exp_Del_Yr_dropdown.sendKeys(Keys.ARROW_DOWN);
	  		Thread.sleep(1000);
	  		Country_Exp_Del_Yr_dropdown.sendKeys(Keys.ENTER);
	  		Thread.sleep(2000);
	          }
	      
	      
	      public void AddItem_Link() throws InterruptedException {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(AddItem_Link));
				driver.findElement(AddItem_Link).click();
			}
				      
	      	      
	      
	      public  PCOrderCreation Select_StandardItemsRequired() throws InterruptedException {
	      
	    		  			WebElement elementCategory = driver.findElement(By.xpath("//table[@class='EditableGridLayout---table EditableGridLayout---striped EditableGridLayout---distribute EditableGridLayout---scrollable']/tbody/tr[1]/td[1]/div/div"));
	  			elementCategory .click();
            	Thread.sleep(1000);
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
				action.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(1000);
				action.sendKeys(Keys.TAB).build().perform();
					
				
	  		// Select Short Description
  			WebElement elementShortDesc = driver.findElement(By.xpath(
	  					"//div[@class='EditableGridLayout---scrollable_content']/table/tbody/tr[1]/td[2]/div/div"));
	  			elementShortDesc.click();
	  			Thread.sleep(1000);
	  			Actions action1 = new Actions(driver);
	  			action1.sendKeys(Keys.ARROW_DOWN).build().perform();
				action1.sendKeys(Keys.ARROW_DOWN).build().perform();
				action1.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(1000);
				action1.sendKeys(Keys.TAB).build().perform();

				// Select Product Category
	  			WebElement elementProductCate = driver.findElement(By.xpath("//div[@class='EditableGridLayout---scrollable_content']/table/tbody/tr[1]/td[3]/div/div"));
	  			elementProductCate.click();
	  			Thread.sleep(1000);
	  			Actions action2 = new Actions(driver);
	  			action2.sendKeys(Keys.ARROW_DOWN).build().perform();
				action2.sendKeys(Keys.ARROW_DOWN).build().perform();
				action2.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(1000);
				action2.sendKeys(Keys.TAB).build().perform();
	  			
            	// Select Account Type
	  			WebElement elementAccountType = driver.findElement(By.xpath("//div[@class='EditableGridLayout---scrollable_content']/table/tbody/tr[1]/td[4]/div/div"));
	  			elementAccountType.click();
	  			Thread.sleep(1000);
	  			Actions action3 = new Actions(driver);
	  			action3.sendKeys(Keys.ARROW_DOWN).build().perform();
				action3.sendKeys(Keys.ARROW_DOWN).build().perform();
				action3.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(1000);
				action3.sendKeys(Keys.TAB).build().perform();

//	  		// Select Orderable PN
   			WebElement elementOrderablePN = driver.findElement(By.xpath("//div[@class='EditableGridLayout---scrollable_content']/table/tbody/tr[1]/td[5]/div/input"));
	  			elementOrderablePN.sendKeys("1123");
	  			Thread.sleep(1000);
	  			action.sendKeys(Keys.TAB).build().perform();
//	  			
//	  		// Select Cost
	  			WebElement elementCost = driver
	  					.findElement(By.xpath("//div[@class='EditableGridLayout---scrollable_content']/table/tbody/tr[1]/td[6]/div/input"));
	  			elementCost.sendKeys("1000");
	  			Thread.sleep(1000);

//	  			
//	  		// Select Quantity
	  			WebElement elementQuantity = driver
	  					.findElement(By.xpath("//div[@class='EditableGridLayout---scrollable_content']/table/tbody/tr[1]/td[7]/div/input"));
	  			elementQuantity.sendKeys("1");
	  			Thread.sleep(1000);	
	  			action.sendKeys(Keys.TAB).build().perform();
	  				  		
	  		return this;
	  	}

		
	      public void Click_Next_Button_4() throws InterruptedException {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(Next_button4));
				driver.findElement(Next_button4).click();
			}	
	      
	      public void Select_TaxIncluded() {
	  		try {
	  			WebDriverWait wait = new WebDriverWait(driver, 20);
	  			WebElement element = driver.findElement(By.xpath("//input[@value='No']"));
	  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	  			wait.until(ExpectedConditions.elementToBeClickable(TaxIncluded_radiobutton));
	  			Thread.sleep(1000);
	  			WebElement element1 = driver.findElement(TaxIncluded_radiobutton);
	  			JavascriptExecutor executor = (JavascriptExecutor) driver;
	  			executor.executeScript("arguments[0].click();", element1);

	  			TestBase.test.pass("Tax Included is selected as No");
	  		} catch (Exception e) {
	  		}
	  	}
	
	      public  void  Select_Supplier() throws InterruptedException {
	      
	    		WebElement Supplier = driver.findElement(By.xpath(
	  					"(//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder'])[2]"));
	    		Supplier.click();
	  			Thread.sleep(1000);
	  			Actions action = new Actions(driver);
	  			action.sendKeys(Keys.ARROW_DOWN).build().perform();
				//action.sendKeys(Keys.ARROW_DOWN).build().perform();
				action.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(1000);
				action.sendKeys(Keys.TAB).build().perform(); 
	    }
	    
	      public void Click_Next_Button5() throws InterruptedException {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(Next_button5));
				driver.findElement(Next_button5).click();
			}	
	   
	      public void Select_Shippingmaterials() {
		  		try {
		  			WebDriverWait wait = new WebDriverWait(driver, 20);
		  			WebElement element = driver.findElement(By.xpath("//input[@value='No'][1]"));
		  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		  			wait.until(ExpectedConditions.elementToBeClickable(Shippingmaterial));
		  			Thread.sleep(1000);
		  			WebElement element1 = driver.findElement(Shippingmaterial);
		  			JavascriptExecutor executor = (JavascriptExecutor) driver;
		  			executor.executeScript("arguments[0].click();", element1);

		  			TestBase.test.pass("Shipping materials is selected as No");
		  		} catch (Exception e) {
		  		}
		  	}
	      
	      
	      
	      public PCOrderCreation Enter_Region_Country() throws InterruptedException {
				WebElement dropboxValueRegion = driver.findElement(By.xpath("(//*[@class ='DropdownWidget---dropdown_value DropdownWidget---placeholder'])[1]"));
				dropboxValueRegion.click();
				dropboxValueRegion.sendKeys("EMEA");
				dropboxValueRegion.sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				
				
				WebElement dropboxValueCountry = driver.findElement(By.xpath("//*[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']"));
				dropboxValueCountry.click();
				Thread.sleep(500);
				dropboxValueCountry.sendKeys("France");
				dropboxValueCountry.sendKeys(Keys.ENTER);
				Thread.sleep(1000);

	  				return this;	
} 
	    
	      
	      public  void  Select_Site() throws InterruptedException {
		      
	    		WebElement Site = driver.findElement(By.xpath(
	  					"(//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder'])[text()='--Select Site--']"));
	    		Site.click();
	  			Thread.sleep(1000);
	  			Actions action = new Actions(driver);
	  			action.sendKeys(Keys.ARROW_DOWN).build().perform();
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
				action.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(1000);
				action.sendKeys(Keys.TAB).build().perform(); 
	    }
	      
	      public  void  Select_Street() throws InterruptedException {
		      
	    		WebElement Street = driver.findElement(By.xpath(
	  					"(//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder'])[text()='--Select Address--']"));
	    		Street.click();
	  			Thread.sleep(1000);
	  			Actions action = new Actions(driver);
	  			action.sendKeys(Keys.ARROW_DOWN).build().perform();
				//action.sendKeys(Keys.ARROW_DOWN).build().perform();
				action.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(1000);
				action.sendKeys(Keys.TAB).build().perform(); 
	    }      
	    
	      public void Select_eDelivery() {
		  		try {
		  			WebDriverWait wait = new WebDriverWait(driver, 20);
		  			WebElement element = driver.findElement(By.xpath("(//input[@value='No'])[last()]"));
		  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		  			wait.until(ExpectedConditions.elementToBeClickable(Shippingmaterial));
		  			Thread.sleep(1000);
		  			WebElement element1 = driver.findElement(eDelivery);
		  			JavascriptExecutor executor = (JavascriptExecutor) driver;
		  			executor.executeScript("arguments[0].click();", element1);

		  			TestBase.test.pass("e-Delivery is selected as No");
		  		} catch (Exception e) {
		  		}
		  	}   
	      
	      public void Click_Next_Button6() throws InterruptedException {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(Next_button6));
				driver.findElement(Next_button6).click();
			}	
	    
	      	      
	      public void Click_Submit() throws InterruptedException {
	  		WebDriverWait wait = new WebDriverWait(driver, 30);
	  		wait.until(ExpectedConditions.elementToBeClickable(Submit_Button));
	  		driver.findElement(Submit_Button).click();
	  		Thread.sleep(3000);
	  	}     
	      
}	      
	      
	 
	    
	    




