package com.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Utilities.FilesOperations;
import com.Utilities.LogGeneration;
import com.Utilities.Utilites;
import com.pages.ASApproval;
import com.pages.ASOECostColectorRequest;
import com.pages.ASOESubmitNewRequest;
import com.pages.ActionsPage;
import com.pages.AddNewPosition;
import com.pages.PCOrderCreation;
import com.pages.BUFinance;
import com.pages.CreateSOW;
import com.pages.Headers;
import com.pages.Login;

public class CostCollectorTest extends TestBase {
	Login login; // Initialize class
	Headers headers;
	// ExtentReport report;
	// ExtentTest test;
	Utilites utilities;
	AddNewPosition newposition;
	ActionsPage actionsPage;
	CreateSOW SOWCreationProcess;
	ASOESubmitNewRequest SubmitNewRequest;
	FilesOperations Operations;
	ASApproval ASapproval;
	PCOrderCreation BUapproval;
	BUFinance BUfinance;
	ASOESubmitNewRequest aSOESubmitNewRequest;
	ASOECostColectorRequest aSOECostColectorRequest;

	@BeforeClass
	public static void SetupXML() {
		// loading log4j.xml file
		DOMConfigurator.configure("log4j.xml");

	}


	@Test(priority = 0)
	public void CreateCostCollectorNewRequest() throws Exception {
		// LogGeneration.GenerateLogfile("CreateNewRequest");

		LogGeneration.GenerateLog("<<<<<<< Start Test Case Execution-CreateNewRequest>>>>>>>>");
		test = extent.createTest("CreateCostCollectorNewRequest");
		test.info("<<<<<<< Start Test Case Execution-CreateNewRequest>>>>>>>>");
		driver.get(urlTrain);
		login = new Login(driver);
		actionsPage = new ActionsPage(driver);
		aSOECostColectorRequest = new ASOECostColectorRequest(driver);
		login.SetUsername(utilities.GetData_Method("CreateCostCollectorNewRequest", "SetUsername"));
		login.SetPassword(utilities.GetData_Method("CreateCostCollectorNewRequest", "SetPassword"));		
		login.ClickSignInButton();
		SubmitNewRequest = new ASOESubmitNewRequest(driver);
		LogGeneration.GenerateLog("SubmitCostCollectorNewRequest initiated");
		// SubmitNewRequest.Uname(utilities.GetData_Method("CreateSOW","Uname"));
		// SubmitNewRequest.Password(utilities.GetData_Method("CreateSOW","Password"));
		SubmitNewRequest.Click_ActionsTab();
		LogGeneration.GenerateLog("Clicked Actions");
		actionsPage.Click_CostCollectorNewRequestLink();
		// SubmitNewRequest.Select_ProjectID();
		aSOESubmitNewRequest = new ASOESubmitNewRequest(driver);		
		aSOESubmitNewRequest.Enter_ProjectID(utilities.GetData_Method("CreateCostCollectorNewRequest", "Enter_ProjectID"));
		aSOESubmitNewRequest.Click_SearchPMT();
		aSOECostColectorRequest.clickMakeNewRequestRadioButton()
								.clickNextButton();
								
		
	}
}
