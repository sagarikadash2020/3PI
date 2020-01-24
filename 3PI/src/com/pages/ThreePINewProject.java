package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Random;

import com.Utilities.ActionDefinition;
import com.Utilities.LogGeneration;
import com.test.TestBase;

public class ThreePINewProject extends ActionDefinition {


	public static WebDriver driver;
	
	// Locators
	static By ActionsTab = By.xpath("//a[@class='appian-menu-item'][contains(text(),'Actions')]");
	static By ThreePIApplication_link = By.xpath("(//span[text()='3PI Application'])[last()]");
	static By ThreePIProjectBudgetSetUp_link = By.xpath("//a[text()='3PI Project Budget Set Up']");
	static By PMTID_text = By.xpath("//*[@class='TextInput---text TextInput---align_start']");
	static By Search_Button = By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']");
	static By FundedBy_radiobutton1 = By.xpath("//input[@value='Internal ITSS Project']");
	static By BudgetType = By.xpath("//div[@class='DropdownWidget---dropdown_value DropdownWidget---placeholder']");
	static By ProjectSetUpDropdown = By.xpath("//div[contains(@class, 'TetherComponent')]/span[text()='Project Budget']");
	static By Setupprojectbudget = By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-last-in-list']");
	static By Next_Button = By.xpath("//button[contains(text(),'Next')]");
	static By aCARNumber_text = By.xpath("//label[text()='aCAR Number']/following::input[1]");
	static By aCARTitle_text = By.xpath("//label[text()='aCAR Title']/following::input[1]");
	static By TotalCARCapexBudget_text = By.xpath("//label[text()='Total CAR Capex Budget in USD']/following::input[1]");
	static By TotalCARExpenseBudget_text = By.xpath("//label[text()='Total CAR Expense Budget in USD']/following::input[1]");
	static By AddNewCountryYear_link = By.xpath("//a[text()='+Add New Country/Year']");
	static By Next2_Button = By.xpath("//button[contains(text(),'Next')]");
	static By Next3_Button = By.xpath("//button[contains(text(),'Next')]");
	static By Submit_Button = By.xpath("//*[@class='Button---btn Button---default_direction Button---primary appian-context-first-in-list appian-context-last-in-list']");
	static By Yes_button = By.xpath("(//button[text()='Yes'])[last()]");
	//static By Upload_button = By.xpath("//button[text()='Upload'])[1]");

	public ThreePINewProject(WebDriver driver) {
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

	public ThreePINewProject Click_ThreePIProjectBudgetSetUp_Link() throws InterruptedException {
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

	public ThreePINewProject Enter_PMTID(String InstantisID) {
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

	public void Select_BudgetType_dropdown() throws InterruptedException {
		By SetupButton = By.xpath("//button[text()='Setup Project Budget']");
		WebElement element = driver.findElement(By.xpath("//button[text()='Setup Project Budget']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		WebElement BudgetType_dropdown = driver.findElement(BudgetType);
		BudgetType_dropdown.click();
		Thread.sleep(2000);
		BudgetType_dropdown.sendKeys(Keys.DOWN);
		BudgetType_dropdown.sendKeys(Keys.DOWN);
		BudgetType_dropdown.sendKeys(Keys.DOWN);
		Thread.sleep(1000);
		BudgetType_dropdown.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

	}

	public void Click_Setupprojectbudget() throws InterruptedException {
		try {
//		Thread.sleep(2000);
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

	public ThreePINewProject Enter_aCARNumber_text() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(aCARNumber_text));
			Random objGenerator = new Random();
			int randomNumber = objGenerator.nextInt(100);
			String rndNum = Integer.toString(randomNumber);
			driver.findElement(aCARNumber_text).sendKeys(rndNum + Keys.TAB);
			TestBase.test.pass("Entered aCAR Number");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}
		return this;
	}

	public ThreePINewProject Enter_aCARTitle_text() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(aCARTitle_text));
			Random objGenerator = new Random();
			int randomNumber = objGenerator.nextInt(100);
			String rndNum = Integer.toString(randomNumber);
			driver.findElement(aCARTitle_text).sendKeys("");
			driver.findElement(aCARTitle_text).sendKeys("AutoTitle" + rndNum + Keys.TAB);
			Thread.sleep(1000);
			TestBase.test.pass("Entered aCAR Title");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}
		return this;
	}

	public ThreePINewProject TotalCARCapexBudget_text(String BudgetInUSD) {
		try {
			LogGeneration.GenerateLog("Enter Total CAR Capex Budget");
			Thread.sleep(3000);
			driver.findElement(TotalCARCapexBudget_text).sendKeys(BudgetInUSD + Keys.TAB);
			Thread.sleep(1000);
			TestBase.test.pass("Entered Total CAR Capex Budget");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}

		return this;
	}

	public ThreePINewProject TotalCARExpenseBudget_text(String ExpenseInUSD) throws InterruptedException {
		try {
			LogGeneration.GenerateLog("Enter Total CAR Expense Budget");
			Thread.sleep(3000);
			driver.findElement(TotalCARExpenseBudget_text).sendKeys(ExpenseInUSD + Keys.TAB);
			Thread.sleep(1000);
			TestBase.test.pass("Entered Total CAR Expense Budget");
		} catch (Exception e) {
			TestBase.test.error("Error Displayed" + e.getMessage());
		}

		return this;
	}

	public ThreePINewProject AddNewCountryYear_link() throws InterruptedException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(AddNewCountryYear_link));
			driver.findElement(AddNewCountryYear_link).click();
			TestBase.test.pass("Clicked on +Add New Country Year Link");
		} catch (Exception e) {
			TestBase.test.error("Could not click on +Add New Country Year and Error Displayed as :" + e.getMessage());
		}
		return this;
	}

	public ThreePINewProject EnterCountryBudgetInformation(int NumOfRows, String Region, String Country,
			String FiscalYear, String CapitalUSD, String ExpenseUSD) throws InterruptedException {
		String[] iRegion = Region.split(";");
		String[] iCountry = Country.split(";");
		String[] iFiscalYear = FiscalYear.split(";");
		String[] iCapitalUSD = CapitalUSD.split(";");
		String[] iExpenseUSD = ExpenseUSD.split(";");
		for (int i = 1; i <= NumOfRows; i++) {
			AddNewCountryYear_link();
			// Select Region
			WebElement elementRegion = driver.findElement(By.xpath(
					"//div[@class='EditableGridLayout---scrollable_content']/table/tbody/tr[" + i + "]/td[1]/div"));
			String expRegion = iRegion[i - 1];
			elementRegion.click();
			Thread.sleep(1000);
			WebElement dropboxValueRegion = driver.findElement(By.xpath("(//*[text()='" + expRegion + "'])[last()]"));
			dropboxValueRegion.click();
			Thread.sleep(1000);

			// Select Country
			WebElement elementCountry = driver.findElement(By.xpath(
					"//div[@class='EditableGridLayout---scrollable_content']/table/tbody/tr[" + i + "]/td[2]/div"));
			String expCountry = iCountry[i - 1];
			elementCountry.click();
			Thread.sleep(1000);
			WebElement dropboxValueCountry = driver.findElement(By.xpath("(//*[text()='" + expCountry + "'])[last()]"));
			dropboxValueCountry.click();
			Thread.sleep(1000);

			// Select FiscalYear
			WebElement elementFiscalYear = driver.findElement(By.xpath(
					"//div[@class='EditableGridLayout---scrollable_content']/table/tbody/tr[" + i + "]/td[3]/div"));
			String expFiscalYear = iFiscalYear[i - 1];
			elementFiscalYear.click();
			Thread.sleep(1000);
			WebElement dropboxValueFiscalYear = driver
					.findElement(By.xpath("(//*[text()='" + expFiscalYear + "'])[last()]"));
			dropboxValueFiscalYear.click();
			Thread.sleep(1000);

			// Select CapitalUSD
			WebElement elementCapitalUSD = driver
					.findElement(By.xpath("//div[@class='EditableGridLayout---scrollable_content']/table/tbody/tr[" + i
							+ "]/td[4]/div/input"));
			String expCapitalUSD = iCapitalUSD[i - 1];
			elementCapitalUSD.sendKeys(expCapitalUSD);
			Thread.sleep(1000);

			// Select ExpenseUSD
			WebElement elementExpenseUSD = driver
					.findElement(By.xpath("//div[@class='EditableGridLayout---scrollable_content']/table/tbody/tr[" + i
							+ "]/td[5]/div/input"));
			String expExpenseUSD = iExpenseUSD[i - 1];
			elementExpenseUSD.sendKeys(expExpenseUSD);
			Thread.sleep(1000);

		}
		return this;
	}

	public void Click_Next2() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Next2_Button));
		driver.findElement(Next2_Button).click();
		Thread.sleep(3000);
	}

	public ThreePINewProject CARDocument_upload() throws InterruptedException {
		try {
			WebElement fileInput1 = driver.findElement(By.xpath("(//div[@class='FileUploadWidget---drag_drop_zone_wrapper']//input)[last()-1]"));
			String strFile1 =System.getProperty("user.dir")+File.separator+"AutomationUpload.txt";
			fileInput1.sendKeys(strFile1);
			Thread.sleep(1000);
		} catch (Exception e) {
			TestBase.test.error("Cannot upload file :" + e.getMessage());
		}
		return this;
	}

	public void Click_Next3() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Next3_Button));
		driver.findElement(Next3_Button).click();
		Thread.sleep(3000);
	}

	public void Click_Submit() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Submit_Button));
		driver.findElement(Submit_Button).click();
		Thread.sleep(3000);
	}

	public void Click_Yes() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(Yes_button));
		driver.findElement(Yes_button).click();
		Thread.sleep(3000);
	}

}
