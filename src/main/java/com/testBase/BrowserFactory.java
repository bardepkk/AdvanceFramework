package com.testBase;

import static org.openqa.selenium.remote.CapabilityType.BROWSER_VERSION;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public WebDriver createBrowserInstance(String browser)
	{
		WebDriver driver=null;
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--incognito");
			option.addArguments("--disable-popup-blocking");
			option.addArguments("--start-maximized");
			option.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(option);
			DesiredCapabilities chrome = new DesiredCapabilities();
			  chrome.setCapability("browserName", "chrome");
			  chrome.setCapability("timezone","UTC+05:30");
			  chrome.setCapability("geoLocation","IN");
			 
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions foptions=new FirefoxOptions();
			foptions.addArguments("-private");
			DesiredCapabilities fiefox = new DesiredCapabilities();
			fiefox.setCapability("browserName", "fiefox");
			fiefox.setCapability("timezone","UTC+05:30");
			fiefox.setCapability("geoLocation","IN");
			driver=new FirefoxDriver(foptions);
			
		} if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup(); 
			EdgeOptions eOption=new EdgeOptions();
			eOption.addArguments("--private");
			DesiredCapabilities edge = new DesiredCapabilities();
			edge.setCapability("browserName", "edge");
			edge.setCapability("timezone","UTC+05:30");
			edge.setCapability("geoLocation","IN");
			driver=new EdgeDriver(eOption);
		}
		return driver;
		
	}
}
