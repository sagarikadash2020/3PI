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

public class Login extends Utilities {
	
	public WebDriver driver;
	
//	@FindBy(xpath = "//input[@id='un']")
//	static
//	WebElement username;
	
//	@FindBy(xpath="(//*[@id='pw'])")
//	static
//	WebElement password;
	
//	@FindBy(xpath="(//*[@class='btn primary'])[2]")
//	static
//	WebElement loginbtn;

	static By username1 = By.xpath("//*[@placeholder=\"Username\"]");
	static By password = By.xpath("//*[@id=\"pw\"]");
	static By SignIn_btn = By.xpath("(//*[@type='submit'])");
	static By error1 = By.xpath("//*[@class='message']");
	String error = "The username/password entered is invalid. Usernames and passwords are case sensitive.";
	static By Newstab=By.xpath("//a[text()='News']");
	//String s = driver.findElement(error1).getText();
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	public Login SetUsername(String Username) throws Exception
	{ 
		try {
			LogGeneration.GenerateLog("Enter Username"); 
			Thread.sleep(3000);
			driver.findElement(username1).sendKeys(Username);
			TestBase.test.pass("Entered Username");
		    }
		catch(Exception e)
		   {
			TestBase.test.error("Error Displayed"+e.getMessage());
		   }
		
		return this;
	}
	public Login SetPassword(String Password)
	{
	  try {
		driver.findElement(password).sendKeys(Password);
		TestBase.test.pass("Entered Password");
	      }
	  catch(Exception e)
	      {
		    TestBase.test.error("Error Displayed"+e.getMessage());
	      }
		return this;
	}
	public Login ClickSignInButton() throws InterruptedException
	{
		try {
		//Thread.sleep(2000);
		driver.findElement(SignIn_btn).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Newstab));
		String ActualText=driver.findElement(Newstab).getText();
		Assert.assertEquals("News",ActualText,"The username/password entered is invalid"); 
		TestBase.test.pass("Login successful.");
		LogGeneration.GenerateLog("Login successful."); 			
		}
		catch(Exception e)
		{
			TestBase.test.error("Error Displayed"+e.getMessage());
		}
		return this;
	}
	
//	public static void main(String[] args) throws Exception 
//	{
//		Login l = new Login(driver);
//		l.username(0, 1, 0);
//	}
}
