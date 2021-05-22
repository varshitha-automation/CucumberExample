package StepDefinitions;


import java.io.IOException;

import com.qa.factory.driverFactory;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class LoginSteps {
	
	LoginPage loginpage = new LoginPage(driverFactory.getDriver());
	private String mainTitle;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() throws IOException{
		loginpage.getURL();
	}

	@When("^user gets the title of login page$")
	public void user_gets_the_title_of_login_page()  {
		 mainTitle=loginpage.title();
	}

	@Then("^title of the page should be \"([^\"]*)\"$")
	public void title_of_the_page_should_be(String arg1) throws InterruptedException{
	    Thread.sleep(5000);
	    mainTitle=loginpage.title();
		Assert.assertEquals(arg1, mainTitle);
	  
	}

	@Then("^forgot password should be displayed$")
	public void forgot_password_should_be_displayed()  {
		Assert.assertTrue(loginpage.forgotPassword());
	}

	@When("^user enters username \"([^\"]*)\"$")
	public void user_enters_username(String uname)  {
		loginpage.enterUsername(uname);
	}

	@When("^user enters password \"([^\"]*)\"$")
	public void user_enters_password(String passwrd) {
		loginpage.enterPassword(passwrd);
	}

	@When("^user clicks on login button$")
	public void user_clicks_on_login_button(){
		loginpage.clickOnLoginBtn();
	}
}
