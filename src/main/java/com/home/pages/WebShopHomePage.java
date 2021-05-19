package com.home.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;
import com.home.driver.DriverManager;
import com.home.frameworkconstants.FrameworkConstants;

public class WebShopHomePage {

	private final By email = By.xpath("//a[normalize-space()='shashi.virajaji@gmail.com']");
	
	public boolean isEmailDisplayed()
	{
		
		//Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);  /// another way of using Thread.sleep with out throwing exception
		
		new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
		.until(ExpectedConditions.visibilityOfElementLocated(email));		
		
//		new WebDriverWait(DriverManager.getDriver(), 10)  // Java 8 Way
//		.until(e->e.findElement(email).isEnabled());
		
		return DriverManager.getDriver().findElement(email).isDisplayed();
	}
	public String validateTitle() {
		
		String strTitle = DriverManager.getDriver().getTitle();
		return strTitle;
	}
	
	
}
