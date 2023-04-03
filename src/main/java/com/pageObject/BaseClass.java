package com.pageObject;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public  WebDriver driver;
	 @Parameters("browserName")
	 @BeforeTest
		public void openBrowser(String browser) throws InterruptedException
		{
		 if(browser.equals("chrome"))
			{ WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			}
		 
		 if(browser.equals("firefox"))
			{ driver = new FirefoxDriver();
			}
		 
		if(browser.equals("edge"))
			{driver = new EdgeDriver();}
			
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		   
		}
	    
		   @AfterTest
		   public void closeBrowser()
		   {
			  driver.close();
		    
		     System.gc();
		   }
}
