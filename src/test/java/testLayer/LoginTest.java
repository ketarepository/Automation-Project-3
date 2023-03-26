package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.BaseDAClass;
import pompackage.PomLogin;

public class LoginTest extends BaseDAClass {

	PomLogin Log;
	public LoginTest() {
		
		super();
	}
	@BeforeMethod
	public void initsetup() {
		initiate();
		
	Log=new PomLogin();
	}
	
	@Test (priority=1)
	public void Title() {
	String actual=Log.verify();
	System.out.println(actual);
		Assert.assertEquals(actual,"ACME demo app" );
		
	}
	@Test (priority=2)
	public void Login() {
		Log.typeusername(prop.getProperty("Username"));
		Log.typepassword(prop.getProperty("Password"));
		Log.clickbtn();
	}
	
	@AfterMethod
	public void close() {
		driver.close();
	}
}
