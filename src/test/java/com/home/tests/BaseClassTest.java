package com.home.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.home.driver.Driver;
import com.reports.ExtentReporter;

public class BaseClassTest {

	protected BaseClassTest() {}
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) throws Exception	
	{	
		Map<String,String> map = (Map<String, String>) data[0];
		Driver.setupDriver(map.get("browser"));
	}

	@AfterMethod()
	protected void tearDown()
	{	
		Driver.quitDriver();
	}
}
