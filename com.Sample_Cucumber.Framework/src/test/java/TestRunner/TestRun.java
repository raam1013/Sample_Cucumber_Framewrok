package TestRunner;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


//import ConfigFileRead.FileReaderManager;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;


@RunWith(Cucumber.class)
@CucumberOptions(
		features={".//Features/Admin.feature"
				
		},
		//tags = {"~@Add_Customer","@Search_Customer_By_Name"},
		glue="StepDefinations",
		dryRun=false,
		strict = true,
		monochrome=true,
 plugin = {
	    "pretty:target/prettyReport.txt", 
        "html:target/cucumber", 
        "json:target/cucumber.json", 
        "rerun:target/rerun.txt",
	    "junit:target/junit-report.xml", 
        "testng:target/testng-output.xml",
		    //"com.aventstack.extentreports.ExtentCucumberFormatter:target/html/ExtentReport.html",
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"}		
		
	
		
		)

public class TestRun {
	static ExtentReports extent;
	ExtentTest logger;
	
@BeforeClass
public static void setup(){
	ExtentProperties prof = ExtentProperties.INSTANCE;
	prof.setReportPath("target/html/Results/Automation.html");
}
@AfterClass
public static void teardown()
	{
	//Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	//Reporter.loadXMLConfig(new File(".//extent-config.xml"));
	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	
	//Reporter.loadXMLConfig(new File(".//extent-config.xml"));
	Reporter.setSystemInfo("user", System.getProperty("user.name"));
	Reporter.setSystemInfo("Application Name", "FaceBook");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Testing");
	Reporter.setSystemInfo("Framework", "BDD Cucumber Framework");
	
	}
	}	


