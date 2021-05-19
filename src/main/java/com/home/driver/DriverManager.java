package com.home.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager()
	{
		
	}
	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	public static WebDriver getDriver()
	{
		return tldriver.get();		
	}

	public static void setDriver(WebDriver driverref)
	{
		tldriver.set(driverref);
	}

	public static void unload()
	{
		tldriver.remove();
	}
}
