package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.PageFactory;
public class BrowserTest {
 
	public static WebDriver ldriver;

//	public BrowserTest(WebDriver bdriver){
//		ldriver = bdriver;
//		PageFactory.initElements(bdriver, this);
//	}
 
@BeforeClass
public static void before() {   

    String browserName=System.getenv("browserName");
    if (browserName
            .equalsIgnoreCase("Chrome")) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver.exe");
        ldriver=new ChromeDriver(); 
    } else if (browserName
            .equalsIgnoreCase("Firefox")) {
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\Downloads\\geckodriver.exe");
    } else if (browserName
            .equalsIgnoreCase("IE")) {
    	System.setProperty("webdriver.ie.driver", "C:\\Users\\Admin\\Downloads\\IEDriverServer.exe");
    } else {
        System.out.println("Error Message----> "
                + "browser name not mentioned properly");
        System.exit(0);
    }
           ldriver.manage().window().maximize();
      ldriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
 }
}