package com.test;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Utilities.FilesOperations;
import com.Utilities.LogGeneration;
import com.Utilities.Utilites;
import com.pages.ThreePINewProject;
import com.pages.PCOrderCreation;
import com.pages.ProjectApprovalsInternal;
import com.pages.Headers;
import com.pages.Login;

public class MyTest extends TestBase {
	Login login; // Initialize class
	Headers headers;
	// ExtentReport report;
	// ExtentTest test;
	Utilites utilities;
	ThreePINewProject threePINewProject;
	ProjectApprovalsInternal projectApprovalsInternal ;
	PCOrderCreation BUapproval;
	PCOrderCreation pcordercreation;

	@BeforeClass
	public static void SetupXML() {
		// loading log4j.xml file
		DOMConfigurator.configure("log4j.xml");

	}
//	@Test(priority = 0)
//	public void CreateNewRequestTest() throws Exception {
//		// LogGeneration.GenerateLogfile("CreateNewRequest");
//
//		LogGeneration.GenerateLog("<<<<<<< Start Test Case Execution-CreateNewRequest>>>>>>>>");
//		test = extent.createTest("CreateNewRequest");
//		test.info("<<<<<<< Start Test Case Execution-CreateNewRequest>>>>>>>>");
//		driver.get(urlTest);
//		login = new Login(driver);
//		login.SetUsername(utilities.GetData_Method("CreateNewRequest", "SetUsername"));
//		login.SetPassword(utilities.GetData_Method("CreateNewRequest", "SetPassword"));
//		login.ClickSignInButton();
//		ThreePINewProject threePINewProject = new ThreePINewProject(driver);
//		LogGeneration.GenerateLog("ThreePINewProject initiated");
//		threePINewProject.Click_ActionsTab();
//		LogGeneration.GenerateLog("Clicked Actions");
//		}

	@Test
	public void CreateNewRequest() throws Exception {
       //	LogGeneration.GenerateLogfile("CreateNewRequest");

		LogGeneration.GenerateLog("<<<<<<< Start Test Case Execution-CreateNewRequest>>>>>>>>");
		test = extent.createTest("CreateNewRequest");
		test.info("<<<<<<< Start Test Case Execution-CreateNewRequest>>>>>>>>");
		driver.get(urlTest);
		login = new Login(driver);
		login.SetUsername(utilities.GetData_Method("CreateNewRequest", "SetUsername"));
		login.SetPassword(utilities.GetData_Method("CreateNewRequest", "SetPassword"));
		login.ClickSignInButton();
//     	ThreePINewProject threePINewProject = new ThreePINewProject(driver);
//      LogGeneration.GenerateLog("ThreePINewProject initiated");
//		ProjectApprovalsInternal projectApprovalsInternal = new ProjectApprovalsInternal(driver);
//		LogGeneration.GenerateLog("Project Approvals Internal initiated");
		PCOrderCreation pcordercreation = new PCOrderCreation(driver);
		LogGeneration.GenerateLog("New PC Order initiated");
	
		
		
		
//		
//		threePINewProject.Click_ActionsTab();
//		LogGeneration.GenerateLog("Clicked Actions");
//		threePINewProject.Click_ThreePIApplication_Link();
//		
//		threePINewProject.Click_ThreePIProjectBudgetSetUp_Link();
//		LogGeneration.GenerateLog("Clicked 3PI Project Budget Set Up");
//		
//		//SubmitNewRequest.Select_ProjectID();
//		threePINewProject.Enter_PMTID(utilities.GetData_Method("CreateNewRequest", "Enter_PMTID"));
//		
//		threePINewProject.Click_Search();
//		
//		threePINewProject.Select_FundedBy();
//		LogGeneration.GenerateLog("Selected Funded By Internal ITSS Project ");
//		
//		threePINewProject.Select_BudgetType_dropdown();
//		LogGeneration.GenerateLog("Selected Budget Type ");	
//		
//		threePINewProject.Click_Setupprojectbudget();		
//		threePINewProject.Click_Next();
//		
//		threePINewProject.Enter_aCARNumber_text();
//		LogGeneration.GenerateLog("Entered aCARNumber");	
//		
//		threePINewProject.Enter_aCARTitle_text();
//		LogGeneration.GenerateLog("Entered aCARTitle");	
//		
//		threePINewProject.TotalCARCapexBudget_text(utilities.GetData_Method("CreateNewRequest", "CapitalUSD"));
//		threePINewProject.TotalCARExpenseBudget_text(utilities.GetData_Method("CreateNewRequest", "ExpenseUSD"));
//		
//		int NRows = Integer.parseInt(utilities.GetData_Method("CreateNewRequest", "NumberOfRows"));
//		threePINewProject.EnterCountryBudgetInformation(NRows, (utilities.GetData_Method("CreateNewRequest", "Region")),(utilities.GetData_Method("CreateNewRequest", "Country")),(utilities.GetData_Method("CreateNewRequest", "FiscalYear")),(utilities.GetData_Method("CreateNewRequest", "Capital")),(utilities.GetData_Method("CreateNewRequest", "Expense")));
//		
//		threePINewProject.Click_Next2();
//		
//		threePINewProject.CARDocument_upload();
//		LogGeneration.GenerateLog("Upload document");
//		
//		threePINewProject.Click_Next3();
//		
//		threePINewProject.Click_Submit();
//		LogGeneration.GenerateLog("Submitted");
//		
//		threePINewProject.Click_Yes();
//		LogGeneration.GenerateLog("Project Created");
		
//		//Approvals for Project(Internal)
//		
//		projectApprovalsInternal.Click_Record_tab();
//		projectApprovalsInternal.Click_ThreePIprojectbudget_link();
//		projectApprovalsInternal.Enter_Searchproject(utilities.GetData_Method("CreateNewRequest", "SearchProjectID"));
//		projectApprovalsInternal.Click_Search_button();
//		projectApprovalsInternal.Click_ProjectLink();
//		projectApprovalsInternal.Click_Active_task();
//		projectApprovalsInternal.Click_Task();
//		projectApprovalsInternal.Click_Accept1();
//		projectApprovalsInternal.Enter_ProjectManager(utilities.GetData_Method("CreateNewRequest", "ProjectManager"));
//		projectApprovalsInternal.Enter_Comment();
//		projectApprovalsInternal.Click_Approve();
//	}
	

		//Creation of PC Orders
		
		
		pcordercreation.Click_ActionsTab();
		pcordercreation.Click_ThreePIApplication_Link();
		pcordercreation.Click_PCOrdersCreation_link();
//pcordercreation.Select_Ordertype_dropbox("PC - Standard Break-Fix /New hire PC Order");
		pcordercreation.Select_Ordertype_dropdown();
		pcordercreation.Click_Next_button();
		pcordercreation.Select_Neworder();
		pcordercreation.Click_Next_button_2();
		pcordercreation.Enter_ProjectID(utilities.GetData_Method("CreateNewRequest", "ProjectID"));
		pcordercreation.Click_Search_Button();
		pcordercreation.Click_Projectid_checkbox();
		pcordercreation.Enter_BusinessJust_text();
		pcordercreation.Click_Next_Button_3();
		pcordercreation.Select_Country_Exp_Del_Yr_dropdown();
        pcordercreation.AddItem_Link();
		//int NRows = Integer.parseInt(utilities.GetData_Method("CreateNewRequest", "NumberOfRows"));
		//pcordercreation.StandardItemsRequired(NRows, (utilities.GetData_Method("CreateNewRequest", "Category")),(utilities.GetData_Method("CreateNewRequest", "ShortDesc")),(utilities.GetData_Method("CreateNewRequest", "ProductCate")),(utilities.GetData_Method("CreateNewRequest", "AccountType")),(utilities.GetData_Method("CreateNewRequest", "OrderablePN")),(utilities.GetData_Method("CreateNewRequest", "Cost")),(utilities.GetData_Method("CreateNewRequest", "Quantity")));
	
		pcordercreation.Select_StandardItemsRequired();
		pcordercreation.Click_Next_Button_4();
		
		pcordercreation.Select_TaxIncluded();
        LogGeneration.GenerateLog("Tax Included is selected as No");
        pcordercreation.Select_Supplier();
        pcordercreation.Click_Next_Button5();
        pcordercreation.Select_Shippingmaterials();
        pcordercreation.Enter_Region_Country();
        pcordercreation.Select_Site();
        pcordercreation.Select_Street();
        pcordercreation.Select_eDelivery();
        pcordercreation.Click_Next_Button6();
        pcordercreation.Click_Submit();     
        
	}	
	

}
