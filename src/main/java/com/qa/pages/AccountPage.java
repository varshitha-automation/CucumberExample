package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AccountPage {
	
	WebDriver driver;
	
	private By accCategory = By.xpath("//div[@class='row addresses-lists']//li");
	private By searchBox = By.id("search_query_top");
	private By searchButton = By.name("submit_search");
	private By searchList = By.xpath("//div[@class='ac_results']/ul/li");
	private By errorMsg = By.xpath("//p[@class='alert alert-warning']");
	private By categoryTab = By.xpath("//div[@id='block_top_menu']/ul/li");
	private By women = By.xpath("//div[@id='block_top_menu']/ul/li[1]");
	private By dresses = By.xpath("//div[@id='block_top_menu']/ul/li[2]");
	private By T_shirts = By.xpath("//div[@id='block_top_menu']/ul/li[3]");
	private By womenCategory = By.xpath("//a[text()='Women']/../ul/li/a");
	private By dressCategory = By.xpath("//li[@class='sfHoverForce sfHover']/ul/li");
	private By highestProd = By.xpath("(//span[@class='price product-price'])[2]");
	private By searchResultProduct = By.xpath("//p[@class='product-desc']/following-sibling::div[@itemprop='offers']/span[@itemprop='price']");
	private By searchMsg = By.xpath("//span[@class='heading-counter']");
	private By productName = By.xpath("//h5[@itemprop='name']/a");
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public List<String> descProd()
	{
		List<String> productList = new ArrayList();
		List<WebElement> name= driver.findElements(productName);
		for(int i=0;i<name.size();i++)
		{
			String prodName=name.get(i).getAttribute("title");
			productList.add(prodName);
		}
		return productList; 
	}
	
	public void searchTextBox(String text)
	{
		driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys(text);
	}
	
	public Integer searchMsg()
	{
		String text=driver.findElement(searchMsg).getText();
		String value=text.replaceAll("[^0-9]", "");
		Integer newValue=Integer.parseInt(value);
		return newValue;
	}
	
	public int countOfProduct()
	{
		return driver.findElements(searchResultProduct).size();
	}
	
	public void clickOnHighestPrice()
	{
		Select sel=new Select(driver.findElement(By.id("selectProductSort")));
		sel.selectByValue("price:desc");
	}
	
	public void clickOnZtoA()
	{
		Select sel=new Select(driver.findElement(By.id("selectProductSort")));
		sel.selectByValue("name:desc");
	}
	
	/*public List<WebElement> highestResult()
	{
		WebElement high = driver.findElement(highestProd);
		String n=high.getText();
		String bigNum=n.replace("$", "");
		Double highNumber=Double.parseDouble(bigNum); //55
		List<WebElement> searchResult=driver.findElements(searchResultProduct);//25,56,58,57
		for(int i=0;i<searchResult.size();i++)
		{
			String g=searchResult.get(i).getText();
			String allNum=g.replace("$", ""); //25
			Double allnumber=Double.parseDouble(allNum);
			if(highNumber<=allnumber)  //55<25
			{
				return searchResult;
			}
		}
		return null;
	}*/
	
	public Double highestValue()
	{
		WebElement high = driver.findElement(highestProd);
		String n=high.getText();
		String bigNum=n.replace("$", "");
		Double highNumber=Double.parseDouble(bigNum); 
		return highNumber;
	}
	
	public List<WebElement> allValue()
	{
		return driver.findElements(searchResultProduct);
	}
	
	public List<String> accountCategory()
	{
		List<String> list = new ArrayList();
		List<WebElement> accList=driver.findElements(accCategory);
		for(int i=0;i<accList.size();i++)
		{
			String acc=accList.get(i).getText();
			list.add(acc);
		}
		return list;
	}
	
	public int getAccountCount()
	{
		int accSize=driver.findElements(accCategory).size();
		return accSize;
	}
	
	public String accTitle()
	{
		return driver.getTitle();
	}
	
	public void searchbtn()
	{
		driver.findElement(searchButton).click();
	}
	
	public boolean errorMsg()
	{
		return driver.findElement(errorMsg).isDisplayed();
	}
	
	public List<WebElement> searchList()
	{
		List<WebElement> searchListBox=driver.findElements(searchList);
		return searchListBox;
	}
	
	public List<String> categoryTab()
	{
		List<String> list = new ArrayList();
		List<WebElement> t=driver.findElements(categoryTab);
		for(int i=0;i<t.size();i++)
		{
			String acc=t.get(i).getText();
			list.add(acc);
		}
		return list;
	}
	
	public int getCategoryCount()
	{
		int catSize=driver.findElements(categoryTab).size();
		return catSize;
	}
	

	public void wCategory()
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(women)).build().perform();
	}
	
	public void dCategory()
	{
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(dresses)).build().perform();
	}
	
	public List<String> womenCat()
	{
		List<String> list = new ArrayList();
		List<WebElement> accList=driver.findElements(womenCategory);
		for(int i=0;i<accList.size();i++)
		{
			String acc=accList.get(i).getText();
			list.add(acc);
		}
		return list;
	}
	
	public List<String> dressCat()
	{
		List<String> list = new ArrayList();
		List<WebElement> accList=driver.findElements(dressCategory);
		for(int i=0;i<accList.size();i++)
		{
			String acc=accList.get(i).getText();
			list.add(acc);
		}
		return list;
	}
	
	public T_ShirtPage T_shirt()
	{
		driver.findElement(T_shirts).click();
		return new T_ShirtPage();
	}
	
	
}
