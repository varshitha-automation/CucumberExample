package AppHooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.google.common.io.Files;
import com.qa.factory.driverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class hooks {
	
	private driverFactory factory;
	private WebDriver driver;
	private ConfigReader reader;
	Properties p;
	
	@Before
	public void launchBrowser() throws IOException
	{
		reader = new ConfigReader();
	    p=reader.init_prop();
		String browsername=p.getProperty("browser");
		factory=new driverFactory();
		driver=factory.init_driver(browsername);
	}
	
	/*@Before(order=1)
	/*public void beforeScenario(Scenario scenario) {
		Reporter.assignAuthor("Testing - Varshitha");
	}*/
	
	@After
	public void browserQuit()
	{
		
		driver.quit();
	}
	
	/*@After(order = 1)
	/*public void screenShot(Scenario scenario)
	{
		if (scenario.isFailed()) {
			 String screenshotName = scenario.getName().replaceAll(" ", "_");
			 try {
			 //This takes a screenshot from the driver at save it to the specified location
			 File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 
			 //Building up the destination path for the screenshot to save
			 //Also make sure to create a folder 'screenshots' with in the cucumber-report folder
			 File destinationPath = new File(System.getProperty("user.dir") + "\\Screenshot\\" + screenshotName + ".png");
			 
			 //Copy taken screenshot from source location to destination location
			 Files.copy(sourcePath, destinationPath);   
			 
			 //This attach the specified screenshot to the test
			// Reporter.addScreenCaptureFromPath(destinationPath.toString());
			 } catch (IOException e) {
			 } 
		}
	}*/
}
