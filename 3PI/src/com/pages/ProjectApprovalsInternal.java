package com.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.ActionDefinition;
import com.test.TestBase;

public class ProjectApprovalsInternal extends ActionDefinition {

	public static WebDriver driver;

	static By Record_tab = By.xpath("//a[text()='Records']");
	static By ThreePIprojectbudget_link = By.xpath("//a[text()='3PI Project Budget']");
	static By Searchproject = By.xpath("//*[@id='cb8292e004bc2fa22bec1437e667b85a']");
	static By Search_button = By.xpath("//button[text()='Search']");
	static By ProjectLink = By.xpath("//a[@class='LinkedItem---richtext_link elements---global_a'][1]");
	static By Active_task = By.xpath("//*[text()='Active Tasks']");
	static By Task = By.xpath("(//a[@class ='elements---global_a'])[9]");
	static By Accept1 = By.xpath("//*[text()='Accept']");
    static By ProjectManager=By.xpath("//span[text()='Project Manager']/parent::div/following-sibling::div//input");
    static By Comment=By.xpath("//*[@class='ParagraphWidget---textarea ParagraphWidget---align_start']");
    static By Approve=By.xpath("//button[text()='Approve']");
    
    
    
	public ProjectApprovalsInternal(WebDriver driver) {
		this.driver = driver;
	}

	public void Click_Record_tab() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(Record_tab));
			driver.findElement(Record_tab).click();
			TestBase.test.pass("Clicked on Record Tab");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}
	}
	
	public void Click_ThreePIprojectbudget_link() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ThreePIprojectbudget_link));
			driver.findElement(ThreePIprojectbudget_link).click();
			TestBase.test.pass("Clicked on 3PI Application Link");
		} catch (Exception e) {
			TestBase.test.error("Could not click on 3PI Application Link and Error Displayed as :" + e.getMessage());
		}
	}

	public ProjectApprovalsInternal Enter_Searchproject(String ProjectID) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Searchproject));
			driver.findElement(Searchproject).sendKeys(ProjectID);
			TestBase.test.pass("Entered Project ID");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}
		return this;
	}

	public void Click_Search_button() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(Search_button));
			driver.findElement(Search_button).click();
			TestBase.test.pass("Clicked on Search Button");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}
	}

	public void Click_ProjectLink() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(ProjectLink));
			driver.findElement(ProjectLink).click();
			TestBase.test.pass("Clicked on the Project Link");
			Thread.sleep(20000);
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}
	}

	public void Click_Active_task() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(Active_task));
			driver.findElement(Active_task).click();
			TestBase.test.pass("Clicked on the Active Task");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}
	}

	public void Click_Task() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(Task));
			driver.findElement(Task).click();
			TestBase.test.pass("Clicked on the Task");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}
	}

//public ProjectApprovalsInternal Taskdetails(int NumOfRows, String TaskName) throws InterruptedException {
//	String[] iTaskName = TaskName.split(";");
//	for(int i=1;i<=NumOfRows;i++) {
//		Task();

		//Click Accept
		
	
	public void Click_Accept1() throws InterruptedException {
		try {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(Accept1));
		driver.findElement(Accept1).click();
		TestBase.test.pass("Clicked on the Accept");
	} catch (Exception e) {
		TestBase.test.error("Error Displayed" + e.getMessage());
	}
}
	//Enter Project Manager
	public ProjectApprovalsInternal Enter_ProjectManager(String PMName)  {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ProjectManager));
			//driver.findElement(ProjectManager).sendKeys(PMName + Keys.TAB);
			driver.findElement(ProjectManager).sendKeys(PMName);
			Thread.sleep(2000);
			driver.findElement(ProjectManager).sendKeys(""+ Keys.TAB);
			TestBase.test.pass("Entered Project Manager");
					} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}
		return this;
	}
	
	//Enter Comment;
		public ProjectApprovalsInternal Enter_Comment () {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(Comment));
			Random objGenerator = new Random(); 
			int randomNumber = objGenerator.nextInt(100);
			String rndNum = Integer.toString(randomNumber);
			driver.findElement(Comment).sendKeys("");
			driver.findElement(Comment).sendKeys("comment" + rndNum + Keys.TAB);
			Thread.sleep(1000);
			TestBase.test.pass("Entered Comment");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}
		return this;
	}
	
			public void Click_Approve() throws InterruptedException {
			try {
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(Approve));
			driver.findElement(Approve).click();
			TestBase.test.pass("Clicked on the Accept");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}		
		
			}
			
			
			
			
}




