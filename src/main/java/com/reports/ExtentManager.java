package com.reports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private static ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
	static ExtentTest getExtentTest() 
	{
		return extent.get();		
	}

	static void setExtentTest(ExtentTest test)
	{
		extent.set(test);
	}

	static void unload()
	{
		extent.remove();
	}
}

