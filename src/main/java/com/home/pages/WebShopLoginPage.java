package com.home.pages;

import org.openqa.selenium.By;

import com.home.driver.DriverManager;
import com.reports.ExtentLogger;
import com.reports.ExtentManager;
import com.reports.ExtentReporter;

public class WebShopLoginPage extends BasePage {

	private final By txtusername = By.xpath("//input[@id='username-inputEl']");
	private final By txtpassword = By.xpath("//input[@id='password-inputEl']");
	private final By btnlogin = By.xpath("//span[@class='g-btn-text']");
	
	public WebShopLoginPage inputUsername(String username) throws Exception
	{
		
		sendKeys(txtusername, username,"User name");			
		return this;
	}
	
	public WebShopLoginPage inputPassword(String password) throws Exception
	{
		sendKeys(txtpassword, password,"Password");		
		return this;
	}
	
	public WebShopHomePage clickLogin() throws Exception
	{
		click(btnlogin,"Login button");		
		return new WebShopHomePage();
	}

	
	
	
}
