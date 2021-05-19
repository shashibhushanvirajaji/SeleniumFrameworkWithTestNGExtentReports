package com.home.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.home.driver.Driver;
import com.home.driver.DriverManager;
import com.home.frameworkconstants.FrameworkConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class LoginPageTest extends BaseClassTest {
	
	private  LoginPageTest() {
		
	}

	@Test
	public void test1()
	{
		WebDriverManager.chromedriver().setup();		
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("shashi bhushan virajaji",Keys.ENTER);
		
	}
	
	
	
	
}
