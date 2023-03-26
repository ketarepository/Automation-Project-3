package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseDAClass;

public class PomLogin extends BaseDAClass {

	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="log-in")
	WebElement Signin;
	
	
	public PomLogin() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	
	public void clickbtn() {
		Signin.click();
	}
	public String verify() {
		return driver.getTitle();
	}

	
}
