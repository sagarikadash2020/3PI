package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utilities.ActionDefinition;
import com.Utilities.LogGeneration;
import com.test.TestBase;

public class ThreePINewprojectCapital {

	public static WebDriver driver;
		
	
	// Locators
		static By ActionsTab = By.xpath("//a[@class='appian-menu-item'][contains(text(),'Actions')]");
		static By ThreePIApplication_link = By.xpath("(//span[text()='3PI Application'])[last()]");
		static By ThreePIProjectBudgetSetUp_link = By.xpath("//a[@class='aui-ActionLink GOCE5N3CNN'][text()='3PI Project Budget Set Up']");
		static By PMTID_text = By.xpath("//*[@class='TextInput---text TextInput---align_start']");
		static By Search_Button = By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']");
		static By FundedBy_radiobutton1 = By.xpath("//input[@value='Capital Transfer from OpCo']");
		static By Setupprojectbudget = By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-last-in-list']");
		static By Next_Button = By.xpath("//button[contains(text(),'Next')]");
		
		
		public ThreePINewprojectCapital(WebDriver driver) {
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

		public ThreePINewprojectCapital Click_ThreePIProjectBudgetSetUp_Link() throws InterruptedException {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.elementToBeClickable(ThreePIProjectBudgetSetUp_link));
				driver.findElement(ThreePIProjectBudgetSetUp_link).click();
				TestBase.test.pass("Clicked on 3PI Project Budget Set Up Link");
			} catch (Exception e) {
				TestBase.test.error(
						"Could not click on 3PI Project Budget Set Up Link and Error Displayed as :" + e.getMessage());
			}
			return this;
		}

		public ThreePINewprojectCapital Enter_PMTID(String InstantisID) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(PMTID_text));
				driver.findElement(PMTID_text).sendKeys(InstantisID);
				TestBase.test.pass("Entered PMT ID");
			} catch (Exception e) {
				TestBase.test.error("Error Displayed" + e.getMessage());
			}
			return this;
		}

		public void Click_Search() throws InterruptedException {
			try {
				// Thread.sleep(5000);
				driver.findElement(Search_Button).click();
			} catch (Exception e) {
				TestBase.test.error("Error Displayed" + e.getMessage());
			}
		}

		public void Select_FundedBy() {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 20);
				WebElement element = driver.findElement(By.xpath("//*[@value='Internal ITSS Project']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				wait.until(ExpectedConditions.elementToBeClickable(FundedBy_radiobutton1));
				Thread.sleep(1000);
				WebElement element1 = driver.findElement(FundedBy_radiobutton1);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element1);

				TestBase.test.pass("Funded By 'Internal ITSS Project' is selected");
			} catch (Exception e) {
			}
		}

		public void Click_Setupprojectbudget() throws InterruptedException {
			try {
				driver.findElement(Setupprojectbudget).click();
			} catch (Exception e) {
				TestBase.test.error("Error Displayed" + e.getMessage());
			}
		}
		
		public void Click_Next() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(Next_Button));
			driver.findElement(Next_Button).click();
		}
		
		
	}

