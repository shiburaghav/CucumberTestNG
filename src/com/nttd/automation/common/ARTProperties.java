package com.nttd.automation.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ARTProperties {
	private static Properties prop;
	private static ARTProperties artProperties;
	String folder_Delimiter = File.separator;
	
	private ARTProperties() {
		prop = new Properties();
		initialize();
	}
	
	public static ARTProperties getInstance() {
		if(artProperties ==  null) {
			artProperties = new ARTProperties();
		} 
		return artProperties;
	}
	
	private void initialize() {
		try {
			FileInputStream input = new FileInputStream("art.properties");
			prop.load(input);
		}catch(Exception ex) {
			
		}
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
