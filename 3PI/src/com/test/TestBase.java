package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.Utilities.ExtentManager;
import com.Utilities.LogGeneration;
import com.Utilities.PathConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class TestBase extends ExtentManager{
	//protected WebDriver driver;
	protected String urlTrain,urlTest;
	
	protected String executingTestScenarioName;
	protected ExtentReports extentInstance;
	protected ExtentTest parentTestInstance;
	protected ExtentTest testInstance;
	public final String getCurrentlyLoggedInUser = System.getProperty("user.name");
	protected WebDriver driver = null;
	protected String runOnBrowser = null;
	private int proxyType = ProxyType.AUTODETECT.ordinal();
	//static ExtentTest test;
	 //static ExtentReports report;
	public  static ExtentHtmlReporter htmlreporter;
	public  static ExtentReports extent;
	public static ExtentTest test;

	
	
	@BeforeSuite
	public void setup()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\satheeshnair\\Desktop\\infocampus\\Softwares\\Selenium Jars\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", PathConstants.chromeDriverPath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		urlTrain="https://jnjtest.appiancloud.com/suite/portal/login.jsp";
		urlTest="https://jnjtest.appiancloud.com/suite/portal/login.jsp";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LogGeneration.GenerateLogfile("ASOE");
		htmlreporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
		
		//initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports(); 
		extent.attachReporter(htmlreporter);	
				//configuration items to change the look and feel
		        //add content, manage tests etc
				htmlreporter.config().setChartVisibilityOnOpen(true);
			    htmlreporter.config().setDocumentTitle("GenerateTestReport");
			    htmlreporter.config().setReportName("Test Report");
			    htmlreporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
			    htmlreporter.config().setTheme(Theme.STANDARD);
			    
		//report = new ExtentReports (System.getProperty("user.dir")+"/test-output/STMExtentReport.html", false);
		
		//test = report.startTest("ExtentDemo");
		//LogGeneration.GenerateLog("Login Window opens Up Test#2");
		
	}
	/*@BeforeTest
	public static void startTest()
	{
	report = new ExtentReports (System.getProperty("user.dir")+"/test-output/STMExtentReport.html", false);
	
	test = report.startTest("ExtentDemo");
	}*/

	
	@AfterSuite
	public void teardown() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterMethod
	
	public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }
	
	@AfterTest
	public void endReport()
      {
	   //report.endTest(test);
	   extent.flush();
      }


	
	//--------------------------------------------------------------------------------------------------------//
	
	/*@BeforeSuite
	/**
	 * Function to change the Error Screenshot folder name before the Suite starts
	 * 
	 * 
	 */
	/*public void CreateErrorRepFolder() throws Exception {
		PathConstants.setDateFormatSettings(); // set the date format before starting each test
		LogGeneration.GenerateLogfile("ASOE");
	}

	/**
	 * This is to create an extent manager instance before every new class
	 * 
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	//@Parameters({ "BrowserType" })
	//@BeforeClass
	/*public void createExtentInstance(@Optional("chrome") String browser) throws IOException, InterruptedException {
		ExtentManager xtentMgr = new ExtentManager();
		//extentInstance = xtentMgr.createExtentRep();
		// Initialize the excel report
		Thread.sleep(PathConstants.minWaitTime);
		urlTrain="https://jnjtrain.appiancloud.com/suite/portal/login.jsp";
		urlTest="https://jnjtest.appiancloud.com/suite/portal/login.jsp";
		//String baseURL = "https://jnjtest.appiancloud.com/suite/portal/login.jsp";
		runOnBrowser = browser;
		driver = new ChromeDriver(createChromeCapabilites());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		//driver.get(baseURL);
		// Initialize the error manager instance
		executingTestScenarioName = super.getClass().getSimpleName();
		// Create testInstance
		parentTestInstance = extentInstance.createTest(executingTestScenarioName,
				"'" + executingTestScenarioName + "' is used to check details in Application.");
		parentTestInstance.assignAuthor(getCurrentlyLoggedInUser);
		parentTestInstance.assignCategory("Regression_" + executingTestScenarioName);
	}*/

	/**
	 * Function to create chrome capabilities
	 * 
	 * 
	 * @returns chromeoptions
	 */
	/*public ChromeOptions createChromeCapabilites() {
		ChromeOptions chromeOptions = new ChromeOptions();
		LinkedHashMap<String, Object> chromePrefs = new LinkedHashMap<String, Object>();
		// Set ACCEPT_SSL_CERTS variable to true
		chromePrefs.put(CapabilityType.ACCEPT_SSL_CERTS, true);
		chromePrefs.put(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.extensions_to_open", "pdf");
		chromePrefs.put("--always-authorize-plugins", false);
		chromePrefs.put("download.prompt_for_download", true);
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		//chromeOptions.setCapability("network.proxy.type", proxyType);
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.addArguments("disable-infobars");
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		System.setProperty("webdriver.chrome.driver", PathConstants.chromeDriverPath);
		System.setProperty("webdriver.chrome.args", "--disable-logging");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		return chromeOptions;
	}

	/**
	 * Function to return browser version
	 * 
	 * 
	 * @return browser name and version
	 */
	/*public String getBrowserVersion() {
		String browser_version;
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browsername = cap.getBrowserName();
		String GetuAgent = (String) ((JavascriptExecutor) driver).executeScript("return navigator.userAgent;");
		// This block to find out IE Version number
		if ("internet explorer".equalsIgnoreCase(browsername)) {
			// uAgent return as "MSIE 8.0 Windows" for IE8
			if (GetuAgent.contains("MSIE") && GetuAgent.contains("Windows")) {
				browser_version = GetuAgent.substring(GetuAgent.indexOf("MSIE") + 5, GetuAgent.indexOf("Windows") - 2);
			} else if (GetuAgent.contains("Trident/7.0")) {
				browser_version = "11.0";
			} else {
				browser_version = "0.0";
			}
		} else if ("firefox".equalsIgnoreCase(browsername)) {
			browser_version = GetuAgent.substring(GetuAgent.indexOf("Firefox")).split(" ")[0].replace("/", "-");
			browser_version = browser_version.replace("Firefox-", "");
		} else { // Browser version for Chrome and Opera
			browser_version = cap.getVersion();
		}
		String browserversion = browser_version.substring(0, browser_version.indexOf('.'));
		return browsername + " browser (Version: " + browserversion + " )";
	}


	/**
	 * Function to initialize Extent report and it must be called only @Test
	 * annotation
	 * 
	 * 
	 */
	/*public void initializeExtentReport(String stepName) {
		// Instantiating the ExtentReports
		// Create testInstance
		testInstance = parentTestInstance.createNode(stepName,
				"'" + stepName + "' is being executed.");
		
	}


	//@AfterClass
	public void tearDownFunction() {
		if (driver != null) {
			driver.close();
		}
		Runtime rt = Runtime.getRuntime();
		try {
			rt.exec("taskkill /F /IM chromedriver.exe");
		} catch (IOException e) {
			// clean up state...
			Thread.currentThread().interrupt();
		}
		// write all resources to report file
		extentInstance.flush();
	}

	/**
	 * Capture the operations on Test completion @param testResult @author
	 * @throws AWTException @throws IOException @throws
	 */
	//@AfterMethod
	/*public void operationsOnTestCompletion(ITestResult testResult) throws AWTException, IOException {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			Reporter.log(" - FAILED.", true);
			// Extent Reports error message
			testInstance.log(Status.FAIL, "Failure Stack Trace: " + testResult.getThrowable().getMessage());
			// adding screenshots to log
		} else if (testResult.getStatus() == ITestResult.SKIP) {
			Reporter.log(" - SKIPPED.", false);
			testInstance.log(Status.SKIP, "Test skipped: " + testResult.getThrowable().getMessage());
		} else {
			Reporter.log(" - PASSED.", false);
			testInstance.log(Status.PASS, "'" + executingTestScenarioName + "' is passed based on the test criteria.");
		}

	}*/


}
