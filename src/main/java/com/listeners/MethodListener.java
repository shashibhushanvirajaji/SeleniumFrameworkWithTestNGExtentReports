package com.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.home.utils.ExcelUtil;

public class MethodListener implements IMethodInterceptor{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		List<Map<String, String>> list = ExcelUtil.getTestDetails("TestRunner");
		
		for(int i=0;i<methods.size();i++) {
			for(int j=0;j<list.size();j++) {
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testcasename"))) {
					if(list.get(j).get("Run").equalsIgnoreCase("yes"))
					{
						result.add(methods.get(i));
					}
//					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));					
	
				}
			}
		}
		return result;
	}

}
