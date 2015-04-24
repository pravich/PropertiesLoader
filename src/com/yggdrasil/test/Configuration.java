package com.yggdrasil.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

public class Configuration {
	public static final String prop1;
	public static final String prop2;
	public static final String prop3;
	public static final Hashtable<String, String> properties;
	
	static {
		Properties prop = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream("./config.properties");
			prop.load(inputStream);
		} catch(FileNotFoundException excp) {
			System.out.println("Cannot find config.properties");
		} catch(IOException excp) {
			System.out.println("IOException");
		} finally {
			if(inputStream != null) {
				try {
					inputStream.close();
				} catch(IOException excp) {
					excp.printStackTrace();
				}
			}
		}
		
		prop1 = prop.getProperty("config.prop1");
		prop2 = prop.getProperty("config.prop2");
		prop3 = prop.getProperty("config.prop3");
		
		properties = new Hashtable<String, String>();
		Enumeration<?> keys = prop.propertyNames();
		while(keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			properties.put(key, prop.getProperty(key));
		}
	}

}
