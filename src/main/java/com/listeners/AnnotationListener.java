package com.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.home.utils.DataProviderUtils;

public class AnnotationListener implements IAnnotationTransformer {

	public void transform(

			ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
				annotation.setDataProvider("getTestData");
				annotation.setDataProviderClass(DataProviderUtils.class);
				annotation.setRetryAnalyzer(RetryAnalyzerListener.class);
	}
}
