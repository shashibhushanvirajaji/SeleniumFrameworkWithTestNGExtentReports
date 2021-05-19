package com.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.home.frameworkconstants.FrameworkConstants;

import java.util.Objects;

public final class ExtentReporter {

	private ExtentReporter() {

	}
	private static ExtentReports extent;
	public static ExtentTest test;
	
	public static void initializeReports() throws Exception {
		if(Objects.isNull(extent))
		{
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setDocumentTitle("Test Report");
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setReportName("Test Report");
		}


	}

	public static void flushReports() throws Exception {
		if(Objects.nonNull(extent))
		{
			extent.flush();
			ExtentManager.unload();
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		}
	}

	public static void createTest(String testcasename)
	{
		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}
}
