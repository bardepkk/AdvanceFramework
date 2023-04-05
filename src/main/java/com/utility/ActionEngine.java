package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.testBase.DriverFactory;
import com.testBase.ExtentFactory;

public class ActionEngine {

	//Customized sendkeys method-> To log sendkeys message for every occ.
	public void sendKeys_custom(WebElement element, String fieldName, String valueToBeSent) throws Exception {
		try {
//	WebDriverWait wait =new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(10));
	waitForElement(element,20);
	     isElementPresent_custom(element, fieldName);
			element.sendKeys(valueToBeSent);
			//log success message in exgent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS,"<b>["+element+"]"+ "<span style='color:blue'>[" + fieldName+"]==> Ented value as: "+valueToBeSent+ "</span></b>");
		} catch (Exception e) {
			//log failure in extent
		//logEventToReport(DriverFactory.getInstance().getDriver(), "FAIL", "<b><span style='color:red'>"+"Value enter in field: "+fieldName + " is failed due to exception: "+e+ "</span></b>");
		ExtentFactory.getInstance().getExtent().log(Status.FAIL,"<b>["+element+"]"+ "<span style='color:red'>"+"Value enter in field: ["+fieldName + "] is failed due to exception: "+e+ "</span></b>");
		}
	}


	//custom click method to log evey click action in to extent report
	public void click_custom(WebElement element, String fieldName) {
	//	boolean flag = false;
		try {
		
			element.click();
			//log success message in exgent report
			ExtentFactory.getInstance().getExtent().log(Status.PASS,"<b>["+element+"]"+"<span style='color:MidnightBlue'>"+ fieldName+"==> Clicked Successfully! "+ "</span></b>");
		//	flag = true;
		} catch (Exception e) {
			//log failure in extent
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,"<b>["+element+"]"+"<span style='color:red'>"+"Unable to click on field: " +fieldName +" due to exception: "+e+ "</span></b>");
		
			//	flag = false;
		}
	}
	public boolean click_customs(WebElement element, String fieldName) {
			boolean flag = false;
			try {
			
				element.click();
				//log success message in exgent report
				ExtentFactory.getInstance().getExtent().log(Status.PASS,"<b>["+element+"]"+"<span style='color:MidnightBlue'>"+ fieldName+"==> Clicked Successfully! "+ "</span></b>");
				flag = true;
			} catch (Exception e) {
				//log failure in extent
				ExtentFactory.getInstance().getExtent().log(Status.FAIL,"<b>["+element+"]"+"<span style='color:red'>"+"Unable to click on field: " +fieldName +" due to exception: "+e+ "</span></b>");
			
					flag = false;
			}
			return flag;
		}

	//clear data from field
	public void clear_custom(WebElement element,String fieldName) {
		try {
			element.clear();
			Thread.sleep(250);
			ExtentFactory.getInstance().getExtent().log(Status.PASS,"["+element+"]"+ fieldName+"==> Data Cleared Successfully! ");
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "["+element+"]"+"Unable to clear Data on field: " +fieldName +" due to exception: "+e);

		} 
	}

	//custom mouseHover 
	public void moveToElement_custom(WebElement element,String fieldName){
		try{
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(DriverFactory.getInstance().getDriver());		
			actions.moveToElement(element).build().perform();
			ExtentFactory.getInstance().getExtent().log(Status.PASS,"["+element+"]"+ fieldName+"==> Mouse hovered Successfully! ");
			Thread.sleep(1000);
		}catch(Exception e){
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "["+element+"]"+"Unable to hover mouse on field: " +fieldName +" due to exception: "+e);

		}
	}


	//check if element is Present
	public boolean isElementPresent_custom(WebElement element,String fieldName){
		boolean flag = false;
		try {
			flag = element.isDisplayed();
			ExtentFactory.getInstance().getExtent().log(Status.PASS,"<b>["+element+"]"+"<span style='color:green'>-[" + fieldName+"]==> Presence of field is: "+ flag+"</span></b>");
			return flag;
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL,"<b>["+element+"]"+"<b><span style='color:red'>"+ "Checking for presence of field:[ " +fieldName +"] not tested due to exception: "+e+"</span></b>");
			return flag;
		}
	}


	//Select dropdown value value by visibleText
	public void selectDropDownByVisibleText_custom(WebElement element, String fieldName, String ddVisibleText) throws Throwable {
		try {
			Select s = new Select(element);
			s.selectByVisibleText(ddVisibleText);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Dropdown Value Selected by visible text: "+ ddVisibleText);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " +fieldName +"  due to exception: "+e);
		}
	}

	//Select dropdown value value by value
	public void selectDropDownByValue_custom(WebElement element, String fieldName, String ddValue) throws Throwable {
		try {
			Select s = new Select(element);
			s.selectByValue(ddValue);
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Dropdown Value Selected by visible text: "+ ddValue);
		} catch (Exception e) {
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " +fieldName +"  due to exception: "+e);
		}
	}

	//String Asserts
	public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName) throws Throwable {
		try {String expected = expvalue.replaceAll("\\n"," ");
		     String actual = actualValue.replaceAll("\\n"," ");
		Assert.assertEquals(expected.trim(),actual.trim());
			if(actual.equals(expected)) {
				ExtentFactory.getInstance().getExtent().log(Status.PASS, "<b><span style='color:green'>String Assertion is successful on field "+ locatorName + " EXPECTED value was: <<< "+ expected + " ACTUAL IS <<: "+actual+"</span></b>");
			}else {
				ExtentFactory.getInstance().getExtent().log(Status.FAIL, "<b><span style='color:red'>String Assertion FAILED on field "+ locatorName + " EXPECTED value was:<<< "+ expected + " ACTUAL IS: <<"+actual+"</span></b>");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(false, e.toString());
		}
	}

	//Get text from webelement
	public String getText_custom(WebElement element, String fieldName) {
		String text = "";
		try {
			text = element.getText();
			ExtentFactory.getInstance().getExtent().log(Status.PASS, fieldName+"==> Text retried is: "+ text);
			return text;
		} catch (Exception e) {		
			ExtentFactory.getInstance().getExtent().log(Status.FAIL, fieldName+"==> Text not retried due to exception: "+ e);

		}
		return text;
	}

	
	
	public void logEventToReport(WebDriver d, String status, String description) throws Exception {
		try {
			if (status.equalsIgnoreCase("pass")) {
				ExtentFactory.getInstance().getExtent().log(Status.PASS,
						"<b><span style='color:green'>" + StringUtils.capitalize(description) + "</span></b>");
			} else if (status.equalsIgnoreCase("fail")) {
				ExtentFactory.getInstance().getExtent().log(Status.FAIL,
						"<b><span style='color:red'>" + StringUtils.capitalize(description) + "</span></b>");
				ExtentFactory.getInstance().getExtent().log(Status.INFO ,"<b><span style='color:orange'>"+
						  ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(addScreenShot())+ "</span></b>");
			} else if (status.equalsIgnoreCase("WARNING")) {
				ExtentFactory.getInstance().getExtent().log(Status.WARNING,"<b><span style='color:pink'>"+ description+"</span></b>");
				
				ExtentFactory.getInstance().getExtent().log(Status.INFO ,
						(Markup) ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(addScreenShot()));


			}
		} catch (Exception e) {
			System.out.println("error block report");
			ExtentFactory.getInstance().getExtent().log(Status.INFO, e.getMessage());
			ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(addScreenShot(), "Test case INFO screenshot");

			e.printStackTrace();
		}
	}
public String addScreenShot()
{
	File src = ((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
	Date date = new Date();
	String actualDate = format.format(date);
	
	String screenshotPath = System.getProperty("user.dir")+
			"/Reports/Screenshots/"+actualDate+".png";
	File dest = new File(screenshotPath);
	
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		e.printStackTrace();
	}	
	return  dest.toString();
}
public void waitForElement(WebElement element , int i) {
	WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),Duration.ofSeconds(i) );
	wait.until(ExpectedConditions.visibilityOf(element));
}

public boolean isElementPresent(WebElement element) throws Exception {
	boolean flag = false;
	try {
		
		waitForElement(element,20);
		element.isDisplayed();
		logEventToReport(DriverFactory.getInstance().getDriver(), "pass",  " "+element+" is presented");
		flag = true;

	} catch (Exception e) {
	  logEventToReport(DriverFactory.getInstance().getDriver(), "error",  ""+element+""+e.getMessage());
		throw new Exception("Unable to determine if the element is present.", e);
	}
	return flag;
}

public String getcharacterString(int n) 
{ 

    // chose a Character random from this String 
    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "abcdefghijklmnopqrstuvxyz";; 

    // create StringBuffer size of AlphaNumericString 
    StringBuilder sb = new StringBuilder(n); 

    for (int i = 0; i < n; i++) { 

        // generate a random number between 
        // 0 to AlphaNumericString variable length 
        int index 
            = (int)(AlphaNumericString.length() 
                    * Math.random()); 

        // add Character one by one in end of sb 
        sb.append(AlphaNumericString 
                      .charAt(index)); 
    } 

    return sb.toString(); 
}
public String getAlphaNumericString(int n) 
{ 

    // chose a Character random from this String 
    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                + "0123456789"
                                + "abcdefghijklmnopqrstuvxyz"; 

    // create StringBuffer size of AlphaNumericString 
    StringBuilder sb = new StringBuilder(n); 

    for (int i = 0; i < n; i++) { 

        // generate a random number between 
        // 0 to AlphaNumericString variable length 
        int index 
            = (int)(AlphaNumericString.length() 
                    * Math.random()); 

        // add Character one by one in end of sb 
        sb.append(AlphaNumericString 
                      .charAt(index)); 
    } 

    return sb.toString(); 
}
}
