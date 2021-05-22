package Runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.qa.factory.FileReaderManager;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\VARSHITHA\\eclipse-workspace\\PracticeCucumber\\scr\\test\\resources\\Features\\LoginPage.feature",
		glue={"StepDefinitions","AppHooks"},
		monochrome=true,//the path of the step definition files
		dryRun=false,     
		
		//format={"pretty","html:test-output"}
		//plugin = {"pretty","html:target/cucumber-html-report", "json:target/cucumber-json-report.json" }
				
		//plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reports/cucumber-reports/report.html"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class Parallel01Test {
	
	@AfterClass
	 public static void writeExtentReport() throws IOException {
	// Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	 }

}
