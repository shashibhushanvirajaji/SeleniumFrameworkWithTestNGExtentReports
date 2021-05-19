package com.home.frameworkconstants;

import com.home.utils.ReadPropertyFile;

public final class FrameworkConstants {
	
	private FrameworkConstants()
	{
		
	}
	private static final String CHROMEDRIVERPATH = "";
	private static final String CONFIGPROPERTIESPATH ="./src/test/resources/config/config.properties";
	private static final String EXTENTREPORTSFFOLDERPATH = System.getProperty("user.dir")+"/extentreports-test-output/";
	private static String extentReportFilePath="";
	
	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty())
		{
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
	
	public static String createReportPath() throws Exception {
		if(ReadPropertyFile.get("overridereports").equalsIgnoreCase("no"))
		{
			return EXTENTREPORTSFFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else
		{
			return EXTENTREPORTSFFOLDERPATH+"/index.html";
		}
	}
	private static final int EXPLICITWAIT = 10;
	
	

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigpropertiespath() {
		return CONFIGPROPERTIESPATH;
	}
	

}
