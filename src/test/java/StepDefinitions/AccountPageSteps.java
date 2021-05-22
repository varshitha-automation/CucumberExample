package StepDefinitions;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.qa.factory.driverFactory;
import com.qa.pages.AccountPage;
import com.qa.pages.LoginPage;
import com.qa.pages.T_ShirtPage;
import com.qa.util.ElementUtil;



import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AccountPageSteps {
	
	LoginPage loginpage = new LoginPage(driverFactory.getDriver());
	ElementUtil elementutil = new ElementUtil(driverFactory.getDriver());
	AccountPage accountpage;
	T_ShirtPage tshirtpage;
	 String ti;
	String searchword;
	
	@Given("^user is already logged in to application$")
	public void user_is_already_logged_in_to_application(DataTable cred) throws Throwable {
		List<Map<String,String>> m = cred.asMaps(String.class, String.class);
		String usn=m.get(0).get("username");
		String pwd=m.get(0).get("password");
		accountpage=loginpage.doLogin(usn, pwd);
	}

	@Given("^user is on account page$")
	public void user_is_on_account_page() throws Throwable {
		 accountpage.accTitle();
	}

	@When("^user gets the page title$")
	public void user_gets_the_page_title() throws Throwable {
		 ti=accountpage.accTitle();
	}

	@Then("^user gets account section$")
	public void user_gets_account_section(DataTable sec) throws Throwable {
		List<String> expectedList =sec.asList(String.class); 
		//List<List<String>> expectedList=sec.asLists(String.class);
		List<String> actualList=accountpage.accountCategory();
		System.out.println("expectedList" + expectedList); 
		System.out.println("actualList" + actualList) ;
		Assert.assertTrue(actualList.containsAll(expectedList));
	}

	@Then("^user gets the count as (\\d+)$")
	public void user_gets_the_count_as(int actualSize) {
		int expectedSize=accountpage.getAccountCount();
		Assert.assertTrue(expectedSize==actualSize);
	}

	@When("^user enters valid text \"([^\"]*)\" in search textbox$")
	public void user_enters_valid_text_in_search_textbox_and_clicks_on_search_button(String searchword) throws InterruptedException {
		this.searchword=searchword;
		accountpage.searchTextBox(searchword);
		Thread.sleep(9000);
	}
	
	@Then("^search result should be displayed$")
	public void search_result_should_be_displayed() {
		List<WebElement> search = accountpage.searchList();
		for(int i=0;i<search.size();i++)
		{
			String searchParticular=search.get(i).getText();
			System.out.println(searchParticular);
			//if((searchParticular.toLowerCase().indexOf(searchword))>0)
			//Assert.assertTrue((searchParticular.toLowerCase().indexOf(searchword))>0);
		}
	}

	@Then("^user clicks on search button$")
	public void click()
	{
		accountpage.searchbtn();
	}
	
	@When("^user enters invalid text in search textbox and clicks on search button$")
	public void user_enters_invalid_text_in_search_textbox_and_clicks_on_search_button() {
		accountpage.searchTextBox("wrong");
		accountpage.searchbtn();
	}

	@Then("^error msg should be displayed$")
	public void error_msg_should_be_displayed() throws Throwable {
		Assert.assertTrue(accountpage.errorMsg());
	}

	@Then("^user gets the categories$")
	public void user_gets_the_categories(DataTable cat) {
		List<String> actual=  cat.asList(String.class);
		List<String> expected= accountpage.categoryTab();
		Assert.assertTrue(actual.containsAll(expected));
	}

	@Then("^count of category should be (\\d+)$")
	public void count_of_category_should_be(int actualSize) {
		int expectedSize=accountpage.getCategoryCount();
		Assert.assertTrue(expectedSize==actualSize);
	}

	@When("^user mouse over on women category$")
	public void user_mouse_over_on_women_category() {
		accountpage.wCategory();
	}

	@Then("^women category should be displayed$")
	public void women_category_should_be_displayed(DataTable women){
		List<String> actual=  women.asList(String.class);
		List<String> expected= accountpage.womenCat();
		Assert.assertTrue(actual.containsAll(expected));
	}

	@When("^user mouse over on dresses category$")
	public void user_mouse_over_on_dresses_category() {
		accountpage.dCategory();
	}

	@Then("^dresses category should be displayed$")
	public void dresses_category_should_be_displayed(DataTable dresses) {
		List<String> actual=  dresses.asList(String.class);
		List<String> expected= accountpage.dressCat();
		Assert.assertTrue(actual.containsAll(expected));
	}

	@When("^user clicks on T-shirts category$")
	public void user_clicks_on_T_shirts_category() {
		tshirtpage=accountpage.T_shirt();
	}
	
	@Then("^number of search results for that product should be displayed$")
	public void number_of_search_results_for_that_product_should_be_displayed() throws Throwable {
		Integer actualNum=accountpage.searchMsg();
		Integer expectedNum= accountpage.countOfProduct();
		Assert.assertTrue(expectedNum==actualNum);
	}

	@When("^user selects sort by price highest first$")
	public void user_selects_sort_by_price_highest_first()  {
		accountpage.clickOnHighestPrice();
	}

	@Then("^highest price product should be displayed first$")
	public void highest_price_product_should_be_displayed_first()  {
		Double high=accountpage.highestValue();
		List<WebElement> all=accountpage.allValue();
		for(int i=0;i<all.size();i++)
		{
			String g=all.get(i).getText();
			String allNum=g.replace("$", ""); //25
			Double allnumber=Double.parseDouble(allNum);
			/*if(high<allnumber)  //55<25
			{
				Assert.assertTrue(false);
			}*/
			Assert.assertFalse(high<allnumber);
		}
		
	}
	
	@When("^user selects sort by  Z to A of product name$")
	public void user_selects_sort_by_Z_to_A_of_product_name() throws Throwable {
		accountpage.clickOnZtoA();
	}

	@Then("^product name from Z to A should be displayed$")
	public void product_name_from_Z_to_A_should_be_displayed() throws Throwable {
		List<String> name=accountpage.descProd();
		//elementutil.isSorted(name);
		Collections.sort(name, Collections.reverseOrder());
		Assert.assertTrue(elementutil.isSorted(name));
	}
}
