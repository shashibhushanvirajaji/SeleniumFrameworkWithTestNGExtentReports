package com.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.home.driver.DriverManager;
import com.home.utils.ReadPropertyFile;
import com.home.utils.ScreenshotUtils;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {

	private ExtentLogger() {
		
	}
	
	public static void pass(String message)
	{
		ExtentManager.getExtentTest().pass(message);
	}
	
	public static void pass(String message, boolean isScreenshotRequired) throws Exception
	{
		if(ReadPropertyFile.get("screenshotsforpassedsteps").equalsIgnoreCase("yes") && isScreenshotRequired)
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		else
			{
			ExtentManager.getExtentTest().pass(message);
			ExtentManager.getExtentTest().assignAuthor("Shashibhushan");
			}
	}
	
	public static void fail(String message)
	{
		ExtentManager.getExtentTest().fail(message);
	}
	
	public static void fail(String message, boolean isScreenshotRequired) throws Exception
	{
		if(ReadPropertyFile.get("screenshotsforfailedsteps").equalsIgnoreCase("yes") && isScreenshotRequired)
			ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		else
			{
			ExtentManager.getExtentTest().fail(message);
			ExtentManager.getExtentTest().assignAuthor("Shashibhushan");
			}
	}
	
	
	public static void skip(String message)
	{
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void skip(String message, boolean isScreenshotRequired) throws Exception
	{
		if(ReadPropertyFile.get("screenshotsforskippedsteps").equalsIgnoreCase("yes") && isScreenshotRequired)
			ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		else
			{
			ExtentManager.getExtentTest().skip(message);			
			}
	}
	
	
}
