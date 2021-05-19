package com.home.pages;

import org.openqa.selenium.By;

import com.home.driver.DriverManager;
import com.reports.ExtentLogger;

// for writing keywords
public class BasePage {
	
	protected void click(By by, String element) 
	{
		DriverManager.getDriver().findElement(by).click();		
		try {
			ExtentLogger.pass("Clicked on "+element, true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	protected void sendKeys(By by, String value,String element) 
	{
		DriverManager.getDriver().findElement(by).sendKeys(value);
		try {
			ExtentLogger.pass(value+ " is set to "+element,true);
		} catch (Exception e) {		
			e.printStackTrace();
		}
	}

}
