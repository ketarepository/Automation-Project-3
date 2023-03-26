package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseDAClass {

     public static     Properties prop=new Properties();
        public static  WebDriver driver;

          public BaseDAClass() {
        	  
        	  try {
        	  FileInputStream file=new FileInputStream("C:\\Users\\nikun\\OneDrive\\Desktop\\Eclipse IDE\\DemoApp\\src\\test\\java\\environmentvariables\\Config.properties");
         prop.load(file);
        	  }
 catch (FileNotFoundException e) {
	 e.printStackTrace();
 }
       catch (IOException a) {
    	   a.printStackTrace();
       }}
       
	
	public static void initiate() {
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		
   String browsername= 	prop.getProperty("browser");
    	
   if (browsername.equals("Chrome")) {
	   System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	   
	   driver=new ChromeDriver(co);}
	   else if (browsername.equals("Firefox")) {
		   System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		   driver=new FirefoxDriver();
		   
	   }
   driver.manage().window() .maximize(); 
   driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
   driver.get(prop.getProperty("url"));
   }
       }
          
          


		
			
		
