package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
	public WebDriver ldriver;

	public Register(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

@FindBy(id = "email")
@CacheLookup
WebElement txtEmail;	

@FindBy(id = "pass")
@CacheLookup
WebElement txtPass;

@FindBy(xpath = "//button[@type='submit']")
@CacheLookup
WebElement loginButton;

	
	

public void user_TextBox(String Email){
txtEmail.clear();
txtEmail.sendKeys(Email);
}
	
public void pass_TextBox(String Password){
txtPass.clear();
txtPass.sendKeys(Password);
}	
public void loginButton(){
loginButton.click();
}
	
}
