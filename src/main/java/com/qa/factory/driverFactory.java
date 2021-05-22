package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverFactory {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tl = new ThreadLocal();
	
	public WebDriver init_driver(String browser)
	{
		if(browser.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver());
		}
		else if(browser.contains("fireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tl.set(new FirefoxDriver());
		}
		else {
			System.out.println("browser name is wrong" + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static WebDriver getDriver()
	{
		return tl.get();
	}
	
	
}