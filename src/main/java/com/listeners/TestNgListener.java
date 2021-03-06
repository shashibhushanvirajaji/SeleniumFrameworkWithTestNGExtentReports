package com.listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.home.utils.ELKUtils;
import com.reports.ExtentLogger;
import com.reports.ExtentReporter;

public class TestNgListener implements ITestListener, ISuiteListener{

	 @Override
	    public void onStart(ISuite suite) {
		  try {
			ExtentReporter.initializeReports();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	    }
	 
	    @Override
	    public void onFinish(ISuite suite) {
	    	try {
				ExtentReporter.flushReports();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    
	@Override  
	public void onTestStart(ITestResult result) {  
		ExtentReporter.createTest(result.getMethod().getMethodName());
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed ");
		ELKUtils.postResultsToELK(result.getMethod().getDescription(), "pass");
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
		
	//	ExtentLogger.fail(result.getMethod().getMethodName() + " is failed "+ result.getThrowable().getMessage());
		try {
			ExtentLogger.fail(result.getMethod().getMethodName() + " is failed "+ result.getThrowable().getMessage(),
					true);		
			ELKUtils.postResultsToELK(result.getMethod().getDescription(), "fail");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
		ExtentLogger.skip(result.getMethod().getMethodName());
		ELKUtils.postResultsToELK(result.getMethod().getDescription(), "skip");
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onStart(ITestContext context) {  
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
		System.out.println(" from OnFinish method");
	}  
}
