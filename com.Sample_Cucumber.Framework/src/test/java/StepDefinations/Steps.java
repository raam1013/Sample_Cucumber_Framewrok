package StepDefinations;

import io.cucumber.messages.internal.com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;






import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import PageObjects.AdminPage;
import PageObjects.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	public WebDriver driver;
	public LoginPage log; // Import the Login Page Class into StepDef Class
	public AdminPage ad;

	
	 
    
	
	@Given("^User Launch the Chrome Browser$")
	public void user_Launch_the_Browser() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	driver = new ChromeDriver();
    

	log = new LoginPage(driver);
	ad = new AdminPage(driver);// Initialize the Login Page WebDriver for handle the Login Class
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Before
	@Given("^User Launch the \"([^\"]*)\"$")
	public void user_Launch_the_Browsers(String Browsers) throws Throwable {
		Reporter.assignAuthor("Selenium Automation - Raam Lakshsman");
		
		//String browserName=System.getenv("Browsers");
		
	    if (Browsers.equals("Chrome")) {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	        driver=new ChromeDriver();
	        Reporter.addStepLog("Chrome Browser Successfully Opened");
	        driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    } else if (Browsers.equals("Firefox")) {
	    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Downloads\\geckodriver.exe");
	    	driver=new FirefoxDriver();
	    	Reporter.addStepLog("Firefox Browser Successfully Opened");
	    } else if (Browsers.equals("IE")) {
	    	System.setProperty("webdriver.ie.driver", "C:\\Users\\Admin\\Downloads\\IEDriverServer.exe");
	    	driver=new InternetExplorerDriver();
	    	Reporter.addStepLog("IE Browser Successfully Opened");
	    } else {
	        System.out.println("Error Message----> "
	                + "browser name not mentioned properly");
	        System.exit(0);
	    }
 

		log = new LoginPage(driver);
		ad = new AdminPage(driver);// Initialize the Login Page WebDriver for handle the Login Class
		
	}
	

	@When("^User Open the Application URL \"([^\"]*)\"$")
	public void user_Open_the_Application_URL(String url) throws Throwable {
    driver.get(url);
    Reporter.addStepLog("Application Launched Successfully");
	}

	@When("^User enter UserName as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enter_UserName_as_and_Password_as(String user, String pass) throws Throwable {
	log.user_TextBox(user);
	Reporter.addStepLog("User Name Entered Successfully");
    Thread.sleep(4000);
    log.pass_TextBox(pass);
    Reporter.addStepLog("Password Entered Successfully");
    Thread.sleep(4000);
    
	}
		
	@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String user, String pass) throws Throwable {
		ad.user_TextBox(user);
		Reporter.addStepLog("User Name Entered Successfully");
	    Thread.sleep(4000);
	    ad.pass_TextBox(pass);
	    Reporter.addStepLog("Password Entered Successfully");
	    Thread.sleep(4000);
	}

	@Then("^Click on Login Button$")
	public void click_on_Login_Button() throws Throwable {
    ad.loginButton();
  
    Reporter.addStepLog("Login Button Click Successfully");
    Thread.sleep(7000);
    
    try {
    	    //String text =driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
    	    //System.out.println(text+"\n");
    	    
    	    String text1 =driver.findElement(By.xpath("//div[@class='_5v-0 _53in']")).getText();
    	    System.out.println(text1+"\n");
    	    Reporter.addStepLog("PopUp Message getting Successfully");
    	    
    	    Thread.sleep(4000);
    			
	} catch (Exception e) {
		System.out.println(e);
		
		// TODO: handle exception
	}
	}
    @After
	@Then("^Close the Browser$")
	public void close_the_Browser() throws Throwable {
	driver.close();
	Reporter.addStepLog("Browser Closed Successfully");
}
    
// Using Data Table in Ccucumber
    
    @Given("^the user on the user registration page\\.$")
    public void the_user_on_the_user_registration_page() throws Throwable {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.navigate().to("https://www.facebook.com/");
    }

    @When("^user enter valid data on the page$")
    public void user_enter_valid_data_on_the_page(DataTable table) throws Throwable {
    	List<List<String>> data= table.raw();
        System.out.println(data.get(1).get(1));
        
        driver.findElement(By.name("email")).sendKeys(data.get(1).get(1));
        driver.findElement(By.name("pass")).sendKeys(data.get(2).get(1));
    }

    @Then("^the user registration should be successful\\.$")
    public void the_user_registration_should_be_successful() throws Throwable {
   
    }
















}
