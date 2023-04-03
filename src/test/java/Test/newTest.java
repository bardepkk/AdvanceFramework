package Test;

import org.testng.annotations.Test;

import com.pageObject.Loginpage;
import com.testBase.DriverFactory;
import com.testBase.MyLogger;
import com.testBase.TestBase;

public class newTest extends TestBase {
	@Test
	public void loginTest1() throws Throwable  {
	System.out.println("First test case");
	MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
	MyLogger.info("Test1");
	Loginpage loginpage=new Loginpage(DriverFactory.getInstance().getDriver());
	
	loginpage.ragisterNewUser("ram","dhok","abcd","pune","Maharashra","456","8823455675","456","Raju","Raju123", "Raju123");
}
	@Test
	public void loginTest2() throws Throwable
	{
		System.out.println("Second test case");
		MyLogger.startTestCase(new Throwable().getStackTrace()[0].getMethodName());
		MyLogger.info("Test2");
		Loginpage loginpage=new Loginpage(DriverFactory.getInstance().getDriver());
		loginpage.ragisterNewUser("Prashant","Dar","rtf","Nagpur","Maharashra","256","8523455675","985","Prash","Prasha123@", "Prasha123@");
	}
}
