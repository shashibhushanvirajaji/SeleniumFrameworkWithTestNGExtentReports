package com.home.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.home.enums.ConfigProperties;
import com.home.utils.ReadPropertyFile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static void setupDriver(String browser) throws Exception {

		if(Objects.isNull(DriverManager.getDriver()))
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
			WebDriverManager.chromedriver().setup();			
			DriverManager.setDriver(new ChromeDriver());
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			}
			
			DriverManager.getDriver().get(ReadPropertyFile.get("url"));	
		}
	}
	public static void quitDriver() {

		if(Objects.nonNull(DriverManager.getDriver()))
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}

	}

}
