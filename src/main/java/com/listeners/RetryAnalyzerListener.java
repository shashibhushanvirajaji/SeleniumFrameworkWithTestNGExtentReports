package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.home.utils.ReadPropertyFile;

public class RetryAnalyzerListener implements IRetryAnalyzer{

	private int counter = 0;
	private int retries = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if(ReadPropertyFile.get("retryfailedtests").equalsIgnoreCase("yes"))
			{
			if(counter<retries)
			{
				counter++;
				value = true;
			}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}	

		return false;
	}

}
