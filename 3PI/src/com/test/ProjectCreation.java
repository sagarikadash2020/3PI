package com.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Utilities.LogGeneration;
import com.Utilities.Utilites;
import com.pages.Login;


public class ProjectCreation  extends TestBase {
	Login login; // Initialize class
	Utilites utilities;


	@BeforeClass
	public static void SetupXML() {
		// loading log4j.xml file
		DOMConfigurator.configure("log4j.xml");

	}


	@Test(priority = 0)
	public void CreateNewProject() throws Exception {
		// LogGeneration.GenerateLogfile("CreateNewRequest");

		LogGeneration.GenerateLog("<<<<<<< Start Test Case Execution-CreateNewRequest>>>>>>>>");
		test = extent.createTest("CreateNewRequest");
		test.info("<<<<<<< Start Test Case Execution-CreateNewRequest>>>>>>>>");
		driver.get(urlTrain);
		login = new Login(driver);
		login.SetUsername(utilities.GetData_Method("CreateNewProject", "SetUsername"));
		login.SetPassword(utilities.GetData_Method("CreateNewProject", "SetPassword"));
		login.ClickSignInButton();
		
	}
}
