package com.qa.util;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class ElementUtil {
	WebDriver driver;
	
	public ElementUtil(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	//check if string is in reverse order 1--> zoo  2--> hassan 
	public static boolean isSorted(List<String> listOfStrings) {
	    
		Iterator<String> iter = listOfStrings.iterator();
	    String current, previous = iter.next();
	    while (iter.hasNext()) {
	        current = iter.next();
	        if (previous.compareTo(current) < 0) {
	            return false;
	        }
	        previous = current;
	    }
	    return true;
	}
}
