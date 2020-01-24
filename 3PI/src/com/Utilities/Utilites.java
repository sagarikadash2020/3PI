package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilites {
	
	public WebDriver driver;
	public static int i,j,rowcount,GetrowCount,K,L;
	public static String uname,pwd,GetTestCaseName,GetMethodName;
	//public static String GetTestCaseName,GetMethodName,GetValue;
	public static String GetValue;
	static XSSFRow row;
	static XSSFWorkbook wb;
	static XSSFSheet sh1;
    static String file=PathConstants.testDataPath+"TestDataByMethod.xlsx";
	static String Excel =PathConstants.testDataPath+"TestDataByMethod.xlsx";
	static String PassSnapShots =PathConstants.reportPath+"passedsnaps" ;
    static String FailedSnapShops=PathConstants.reportPath+"failedsnaps";
    Connection conn=null;
    Statement stmt=null;
    String sql="";
    ResultSet rs=null;
    String Value=null;
   
    //public Static String testcasename;
    //public Static String methodname;
			
	
	
	public Utilites(WebDriver driver) 
	{
		this.driver = driver;
	}
	public static void readexcel(int sheetnum, int row, int column) throws Exception
	{
		FileInputStream fis = new FileInputStream(Excel);
		wb = new XSSFWorkbook(fis);
		sh1=wb.getSheetAt(sheetnum);
		
		rowcount = sh1.getLastRowNum();
			
		uname = sh1.getRow(row).getCell(column).getStringCellValue();
		//System.out.println(uname);
		pwd = sh1.getRow(row).getCell(column).getStringCellValue();
		 
//		System.out.println(uname);
//		System.out.println(pwd +"Is the password");
		
	}
	//Get Data based on the method
	public static String GetData_Method(String TestCaseName,String MethodName)
	{
		try {
		LogGeneration.GenerateLog("ExpectedTestcasename and ExpectedMethodname: "+TestCaseName +" and "+MethodName);		
		FileInputStream inputStream = new FileInputStream(file);
		wb = new XSSFWorkbook(inputStream);		
		sh1=wb.getSheetAt(0);
		//Find number of rows in excel file
	    GetrowCount = sh1.getLastRowNum()-sh1.getFirstRowNum();	
	    LogGeneration.GenerateLog("Total no of rows:"+GetrowCount);
	    outerloop:
		for(K=1;K < GetrowCount+1;K++)
		{
			for (L = 0; L <2; L++) 
			{
				GetTestCaseName=sh1.getRow(K).getCell(L).getStringCellValue();
				GetTestCaseName=GetTestCaseName.trim();
				 LogGeneration.GenerateLog("TestCaseName:"+GetTestCaseName);
				 if (TestCaseName.equals(GetTestCaseName))
				   {
					 GetMethodName=sh1.getRow(K).getCell(L=L+1).getStringCellValue();
					 GetMethodName.trim();
					 LogGeneration.GenerateLog("L val:"+L);
					 LogGeneration.GenerateLog("MethodName:"+GetMethodName);
					 if(MethodName.equals(GetMethodName))
					 {
						 
						 GetValue=sh1.getRow(K).getCell(L=L+1).getStringCellValue();
						 LogGeneration.GenerateLog("TestCase Name:"+GetTestCaseName+" MethodName:"+GetMethodName +" and Value:"+GetValue ); 
						 break outerloop;
					 }
					 break;
				    }
				
			}
			
			
		}
		
	}
	 catch(Exception e)
	 {
		 System.out.println(e); 
	 }
		return GetValue;
			
		}
	
	
		
			
		
	public void passsnaps(WebDriver driver) throws Exception
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(PassSnapShots + timestamp()+".jpg");
		FileUtils.copyFile(scr,dest);
	}
	public void failsnaps(WebDriver driver) throws Exception
	{
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(FailedSnapShops + timestamp()+".jpg");
		FileUtils.copyFile(scr,dest);
	}
	public static String timestamp() 
	{
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new java.util.Date());
	}

//	public static void main(String[] args) throws Exception 
//	{
//		Utilites.readexcel();
//	}
	
	
	public Connection GetConnection() throws Exception
    {
		LogGeneration.GenerateLog("Entered GetConnection1");

        //The connection string to the excel file
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		LogGeneration.GenerateLog("Entered GetConnection2");
		conn=DriverManager.getConnection("jdbc:odbc:excel","","");
		LogGeneration.GenerateLog("Entered GetConnection2");
		return conn;
		 //sql="select * from [Sheet1$]";
		 
        
    }
	
	public String GetData(String testcasename,String methodname) throws SQLException, Exception
    {   LogGeneration.GenerateLog("Entered GetData");
		stmt=GetConnection().createStatement();
    
		String QueryRows="Select * FROM [Sheet1$] where TestCaseName ='"+testcasename.trim().toLowerCase()+ "' AND " + "MethodName = '" + methodname.trim().toLowerCase() + "'";
        rs=stmt.executeQuery(QueryRows);
        while(rs.next()){
       	 Value=rs.getString("TestData");
       	 
       	 
        }
        return Value;
}
	
}

