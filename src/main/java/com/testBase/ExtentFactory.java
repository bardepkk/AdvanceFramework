package com.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

/**
 * @author: pranay barde
 * 
 */
public class ExtentFactory {
	//Singleton design Pattern
	//private constructor so that no one else can create object of this class
	private ExtentFactory() {
		
	}
	
	private static ExtentFactory instance  = new ExtentFactory();
	
	public static ExtentFactory getInstance() {
		return instance;
	}
	
	
	//factory design pattern --> define separate factory methods for creating objects and create objects by calling that methods
	ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
	
	public ExtentTest getExtent() {
		return extent.get();
	}
	
	public void setExtent(ExtentTest extentTestObject) {
		extent.set(extentTestObject);
	}
	
	public void removeExtentObject() {
		extent.remove();
	}
	
	public String captureScreen(WebDriver driver,String  screenshotPath) {
		try {
			File src = ((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
			Date date = new Date();
			String actualDate = format.format(date);
		
			File dest = new File(screenshotPath);
			
			
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return screenshotPath;
	}

	public String addScreenShot(WebDriver d, String screenshotPath) throws Exception {
		String image = "";
		FileInputStream imageFile;
		try {
			File imgfile = new File(captureScreen(d, screenshotPath));
			imageFile = new FileInputStream(screenshotPath);
			byte imageData[] = new byte[(int) imgfile.length()];
			imageFile.read(imageData);
			byte[] base64EncodedByteArray = org.apache.commons.codec.binary.Base64.encodeBase64(imageData);
			image = new String(base64EncodedByteArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "data:image/png;base64," + image;
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

}
