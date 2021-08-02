package com.home.tests;


import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.annotation.FrameworkAnnotation;
import com.home.pages.WebShopHomePage;
import com.home.pages.WebShopLoginPage;
import com.home.utils.DataProviderUtils;
import com.listeners.RetryAnalyzerListener;

public final class WebShopTest extends BaseClassTest{
	 
	
	@Test(description = "loginpagetest")
	public void loginPage_LoginTest(Map<String, String> data) throws Exception 
	{		
		WebShopLoginPage wslp = new WebShopLoginPage();
		WebShopHomePage wshp = wslp.inputUsername(data.get("username")).inputPassword(data.get("password")).clickLogin();
		String title = wshp.validateTitle();
		Assertions.assertThat(title)
		.isEqualToIgnoringCase("duck creek technologies");
	}
	
	@Test(description = "newtest")
	public void NewTest(Map<String, String> data) throws Exception 
	{		
		WebShopLoginPage wslp = new WebShopLoginPage();
		WebShopHomePage wshp = wslp.inputUsername(data.get("username")).inputPassword(data.get("password")).clickLogin();			
		String title = wshp.validateTitle();
		Assertions.assertThat(title)
		.isEqualToIgnoringCase("duck creek technologies");
	}
}
