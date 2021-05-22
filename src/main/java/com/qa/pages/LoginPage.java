package com.qa.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.util.ConfigReader;

public class LoginPage {
	
	private WebDriver driver;
	private ConfigReader configreader = new ConfigReader();
	
	//1.By Locator
	private By username = By.id("email");
	private By password = By.id("passwd");
	private By loginBtn = By.id("SubmitLogin");
	private By forgotPassword = By.linkText("Forgot your password?");
	
	//2.Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//3.Actions
	
	public void getURL() throws IOException
	{
		//Properties p= configreader.init_prop();
		//String url = p.getProperty("url");
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	
	public String title()
	{
		return driver.getTitle();
	}
	
	public boolean forgotPassword()
	{
		return driver.findElement(forgotPassword).isDisplayed();
	}
	
	public void enterUsername(String usn)
	{
		driver.findElement(username).sendKeys(usn);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickOnLoginBtn()
	{
		driver.findElement(loginBtn).click();
	}
	
	public AccountPage doLogin(String usn,String pwd)
	{
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(username).sendKeys(usn);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new AccountPage(driver);
	}
	
}
