package com.Utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FilesOperations {
	
	public static void OpenOrderPricingFile() throws Exception
	{
	File file = new File("cmd.exe","C:\\Users\\moneecasinha\\Downloads\\OrderPricingInput(14).xlsx");
	//"cmd.exe","/c","D:\\prog file\\090422.xls"
	FileInputStream fileinfo = new FileInputStream(file);
	XSSFWorkbook workbook = new XSSFWorkbook(fileinfo);
	if (file.isFile() && file.exists()) { 
        LogGeneration.GenerateLog("OrderPricingInput(14).xlsx is open"); 
    } 
    else { 
    	LogGeneration.GenerateLog("OrderPricingInput(14).xlsx either not exist");
                          
    } 
}
	public static void Import() throws Exception
	{
	try {//"cmd.exe","/c","D:\\prog file\\090422.xls"
		String[] cmdarray=new String[]{"cmd.exe","/c","C:\\Users\\moneecasinha\\Downloads\\OrderPricingInput(14).xlsx"};
		Runtime.getRuntime().exec(cmdarray);
		Runtime.getRuntime().exec("C:\\Users\\moneecasinha\\Desktop\\Tools for Selenium with Java\\Appian_ASOE\\RunMacro.vbs");
		} catch (IOException e) {
			LogGeneration.GenerateLog("Exception:"+e); 
		//System.exit(0);
		}
	}
	public static void main(String[] args) throws Exception 
	{
		//OpenOrderPricingFile();
		Import();
	}
}
