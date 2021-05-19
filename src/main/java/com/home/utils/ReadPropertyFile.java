package com.home.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.home.enums.ConfigProperties;
import com.home.frameworkconstants.FrameworkConstants;

public final class ReadPropertyFile {

	private ReadPropertyFile()
	{

	}
	
	private static  Properties property = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<String, String>();
	
	static
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream(FrameworkConstants.getConfigpropertiespath());
			property.load(fis);
			// usage of streams and lamba expressions
			property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));			
			
		} catch (IOException e) {		
			e.printStackTrace();
		}
	}
	
	public static String get(String key) throws Exception
	{
		if(Objects.isNull(property.getProperty(key)) || Objects.isNull(CONFIGMAP.get(key)))
		{			throw new Exception("Property named "+key+" is not available in config.properties file, please check");
		}		
		return CONFIGMAP.get(key);
	}

}
