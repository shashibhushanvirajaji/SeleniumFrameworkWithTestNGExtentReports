package com.home.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

public final class DataProviderUtils {

	private  DataProviderUtils() {

	}

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider(parallel = true)
	public static Object[] getTestData(Method m) {
		String testCaseName = m.getName();
		if(list.isEmpty())
		{
			list = ExcelUtil.getTestDetails("TestData");
		}
		List<Map<String, String>> toBeExecutedList =  new ArrayList<>();

		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("testcasename").equalsIgnoreCase(testCaseName) && 
				list.get(i).get("Run").equalsIgnoreCase("yes"))
			    {
					toBeExecutedList.add(list.get(i));
				}			
		}	
		return toBeExecutedList.toArray();

	}

}
