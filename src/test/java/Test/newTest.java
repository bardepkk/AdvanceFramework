package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObject.Loginpage;
import com.testBase.DriverFactory;
import com.testBase.ExtentFactory;
import com.testBase.MyLogger;
import com.testBase.TestBase;

public class newTest extends TestBase {
	@Test
	public void loginTest1() throws Throwable  {
	try
	{System.out.println("First test case");
	MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
	MyLogger.info("TEST_001");
	Loginpage loginpage=new Loginpage(DriverFactory.getInstance().getDriver());
	
	loginpage.ragisterNewUser("ram","dhok","abcd","pune","Maharashra","456","8823455675","456","Raju","Raju123", "Raju123");
	ExtentFactory.getInstance().logEventToReport(DriverFactory.getInstance().getDriver(), "pass", "All Test steps has been completed");
}catch(Exception | AssertionError e)	{
	ExtentFactory.getInstance().logEventToReport(DriverFactory.getInstance().getDriver(), "fail", "Test steps has not been completed");
	Assert.fail(e.getMessage());
	e.printStackTrace();
}}
	@Test
	public void loginTest2() throws AssertionError, Exception {
	try{
		System.out.println("Second test case");
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.info("TEST_002");
		Loginpage loginpage=new Loginpage(DriverFactory.getInstance().getDriver());
		loginpage.ragisterNewUser("Prashant","Dar","rtf","Nagpur","Maharashra","256","8523455675","985","Prash","Prasha123@", "Prasha123@");
		ExtentFactory.getInstance().logEventToReport(DriverFactory.getInstance().getDriver(), "pass", "All Test steps has been completed");
	}catch(Throwable e)	{
		ExtentFactory.getInstance().logEventToReport(DriverFactory.getInstance().getDriver(), "fail", "Test steps has not been completed");
		Assert.fail(e.getMessage());
		e.printStackTrace();
	}
	}
	@Test
	
	public void login3() throws Exception {
	
	try{
		Loginpage loginpage=new Loginpage(DriverFactory.getInstance().getDriver());
	    loginpage.enteruserName().enterPassword().enterlogin();
	 
	 ExtentFactory.getInstance().logEventToReport(DriverFactory.getInstance().getDriver(), "pass", "All Test steps has been completed");
	}catch(Exception | AssertionError e)	{
		ExtentFactory.getInstance().logEventToReport(DriverFactory.getInstance().getDriver(), "fail", "Test steps has not been completed");
		Assert.fail(e.getMessage());
		e.printStackTrace();
	}
}
}