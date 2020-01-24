package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Headers
{
	public WebDriver driver;
	
	/*************Header Locator**************/
	By Actiontab = By.xpath("(//*[@class='appian-menu-item'])[4]");
	By Tasktab = By.xpath("(//*[@class='appian-menu-item'])[1]");
	By Records = By.xpath("(//*[@class='appian-menu-item'])[2]");
	By Reportstab = By.xpath("(//*[@class='appian-menu-item'])[3]");
	
	/*********Task Locator***************/
	By firsttask = By.xpath("(//*[@class='gwt-Anchor appian-feed-entry-author'])[1]");
	By acceptbtn = By.xpath("(//*[@class='Button---btn Button---default_direction Button---primary Button---small appian-context-first-in-list Button---inSideBySide'])[1]");
	By firstprovidedemandtask = By.xpath("(//*[contains(text(),'Provide')])[1]");
	By addnewposition = By.xpath("(//*[@class='LinkedItem---richtext_link elements---global_a'])[4]");
	
	public Headers(WebDriver driver){
		this.driver=driver;
	}
	
	public void clickaction() throws InterruptedException
	{
		driver.findElement(Actiontab).click();
		Thread.sleep(2000);
	}
	public void clicktasktab() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Tasktab).click();
	}
	public void recordstab() throws InterruptedException
	{
		driver.findElement(Records).click();
		Thread.sleep(2000);
	}
	public void reports() throws InterruptedException
	{
		driver.findElement(Reportstab).click();
		Thread.sleep(2000);
	}
	
	/****************Functions for selecting Tasks under task Tab ********************/
	
	/***Click on demand task under task tab******/
	
	public void clickfirsttask() throws InterruptedException 
	{
		Thread.sleep(2000);
		driver.findElement(firsttask).click();
	}
	
	public void clickacptbtn() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(acceptbtn).click();
	}
	
	public void clickdemandtask() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(firstprovidedemandtask).click();
	}
	
	public void addNewPosition() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(addnewposition).click();
	}

	
	
	
//public static void main(String[] args) throws InterruptedException {
//	Headers h = new Headers();
//	h.clicktasktab();
//}
}
