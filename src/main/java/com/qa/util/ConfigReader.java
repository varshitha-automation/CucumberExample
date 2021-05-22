package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	private String desc = "C:\\Users\\VARSHITHA\\eclipse-workspace\\PracticeCucumber\\scr\\test\\resources\\config\\config.properties";
	
	 public Properties init_prop() throws IOException
	 {
		 prop = new Properties();
		 FileInputStream ip = new FileInputStream("C:\\Users\\VARSHITHA\\eclipse-workspace\\PracticeCucumber\\scr\\test\\resources\\config\\config.properties");
		 prop.load(ip);
		 
		 return prop;
	 }
	 
	 public String getReportConfigPath() throws IOException{
		 prop = new Properties();
		 FileInputStream ip = new FileInputStream(desc);
		 prop.load(ip);
		 String reportConfigPath = prop.getProperty("reportConfigPath");
		 if(reportConfigPath!= null) return reportConfigPath;
		 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
		}

}
