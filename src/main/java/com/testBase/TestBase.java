package com.testBase;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.utility.PropertiesOperations;

public class TestBase {
	BrowserFactory bf = new BrowserFactory();

	@BeforeMethod
	public void LaunchApplication() throws Exception {
		String browser = PropertiesOperations.getPropertyValueByKey("browser");
		String url = 	PropertiesOperations.getPropertyValueByKey("url");

		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));

		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	DriverFactory.getInstance().getDriver().navigate().to(url);
		DriverFactory.getInstance().getDriver().navigate().to("https://parabank.parasoft.com/parabank/index.htm");
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.getInstance().closeDriver();
	}

}
