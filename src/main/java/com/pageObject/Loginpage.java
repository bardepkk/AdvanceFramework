package com.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.testBase.DriverFactory;
import com.testBase.ExtentFactory;
import com.utility.ActionEngine;

public class Loginpage extends ActionEngine {
	
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement ragister;
	@FindBy(xpath = "//b[text()='0']")
	private WebElement a;
	@FindBy(xpath = "//input[@id='customer.firstName']")
	private WebElement fname;
	@FindBy(xpath = "//input[@id='customer.lastName']")
	private WebElement lname;
	@FindBy(xpath = "//input[@id='customer.address.street']")
	private WebElement address;
	@FindBy(xpath = "//input[@id='customer.address.city']")
	private WebElement city;
	@FindBy(xpath = "//input[@id='customer.address.state']")
	private WebElement state;
	@FindBy(xpath = "//input[@id='customer.address.zipCode']")
	private WebElement zipcode;
	@FindBy(xpath = "//input[@id='customer.phoneNumber']")
	private WebElement phoneNumber;
	@FindBy(xpath = "//input[@id='customer.ssn']")
	private WebElement ssn;
	@FindBy(xpath = "//input[@id='customer.username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@id='customer.password']")
	private WebElement password;
	@FindBy(xpath = "//input[@id='repeatedPassword']")
	private WebElement conformPassword;
	@FindBy(xpath = "//input[@value='Register']")
	private WebElement proced;
	@FindBy(xpath = "//input[@name='username']")
	
	private WebElement userName1;
	@FindBy(xpath = "//div[@id='rightPanel']")
	private WebElement message__sucess;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password1;
	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement login;

	@FindBy(xpath = "//input[@value='Lo']")
	private WebElement log;
	
	public void selectragister() {
		ragister.click();
	}

	public void enterFirstName() {
		fname.sendKeys("ram");
	}

	public void enterLastName() {
		lname.sendKeys("dhok");
	}

	public void enterAddress() {
		address.sendKeys("abcd");
	}

	public void entercity() {
		city.sendKeys("pune");
	}

	public void enterStsteName() {
		lname.sendKeys("dhok");
	}

	public void enterzipcode() {
		address.sendKeys("abcd");
	}

	public void enterPhoneNumber() {
		phoneNumber.sendKeys("8823455675");
	}

	public void enterssn() {
		ssn.sendKeys("456");
	}

	public void creatUserName() {
		userName.sendKeys("raju");
	}

	public void creatpassword() {
		password.sendKeys("raju123");
	}

	public void enterconformPassword() {
		conformPassword.sendKeys("raju123");
	}

	public void selectProcead() {
		proced.click();
	}

	public void ragisterUser(String fnames, String lnames, String addres, String citys, String states, String zipcodes, String phoneNumbers, String ssns, String userNames, String passwords, String conformPasswords  ) {
		ragister.click();
		fname.sendKeys(fnames);
		lname.sendKeys(lnames);
		address.sendKeys(addres);
		city.sendKeys(citys);
		state.sendKeys(states);
		zipcode.sendKeys(zipcodes);
		phoneNumber.sendKeys(phoneNumbers);
		ssn.sendKeys(ssns);
		userName.sendKeys(userNames);
		password.sendKeys(passwords);
		conformPassword.sendKeys(conformPasswords);
		proced.click();
	}
	public void ragisterNewUser(String name, String LastName, String add, String cityName, String stateName, String code, String number, String ssnCode, String uname, String pass, String cPassword) throws Throwable
	{
		//ragister.click();
		try {
			click_custom(ragister,"Ragister");
		String names=getcharacterString(5);
		System.out.println(names);
		String lName=getcharacterString(5);
		System.out.println(lName);
		String uName=getAlphaNumericString(8);
		System.out.println(uName);
		String passw=getAlphaNumericString(8);
		System.out.println(passw);
		sendKeys_custom(fname, "FirstName",names );
		sendKeys_custom(lname,  "LastName",lName);
		sendKeys_custom(address,  "LastName",add);
		sendKeys_custom(city,  "City",cityName);
		sendKeys_custom(state,  "State",stateName);
		Thread.sleep(1000);
		sendKeys_custom(zipcode,  "ZipCode",code);
		sendKeys_custom(phoneNumber,  "Phone Number",number);
		sendKeys_custom(ssn,  "SSN",ssnCode);
		sendKeys_custom(userName,  "UserName",uName);
		sendKeys_custom(password,  "Password",passw);
		sendKeys_custom(conformPassword,  "conformPassword",passw);
		Thread.sleep(1000);
		click_custom(proced,"Proced");
		waitForElement(message__sucess, 20);
		
		assertEqualsString_custom("Welcome "+ uName +" Your account was created successfully. You are now logged in.",getText_custom(message__sucess, "sucessful Registeration"),"sucess message");
	//	Your account was created successfully. You are now logged in.
		ExtentFactory.getInstance().getExtent().log(Status.PASS, "<b><span style='color:MidnightBlue'></span></b>");
	} catch (Exception e) {
		//log failure in extent
	//logEventToReport(DriverFactory.getInstance().getDriver(), "FAIL", "<b><span style='color:red'>"+"Value enter in field: "+fieldName + " is failed due to exception: "+e+ "</span></b>");
	ExtentFactory.getInstance().getExtent().log(Status.FAIL, "<b><span style='color:red'></span></b>");
	}
	//	fname.sendKeys(name);
//		lname.sendKeys(LastName);
//		address.sendKeys(add);
//		city.sendKeys(cityName);
//		state.sendKeys(stateName);
//		zipcode.sendKeys(code);
//		phoneNumber.sendKeys(number);
//	ssn.sendKeys(ssnCode);
//	userName.sendKeys(uname);
//	password.sendKeys(pass);
//		conformPassword.sendKeys(cPassword);
//	proced.click();
	}

	public Loginpage enteruserName() throws Exception {
//		WebDriverWait wait=new WebDriverWait(20,TimeUnit.SECONDS);
//		wait.until("Exception".visibilityOfElementLocated(true),"userName1");
		//userName1.sendKeys("Raju");
		sendKeys_custom(userName1,"userName","Raju");
		return new Loginpage(DriverFactory.getInstance().getDriver());
	}

	public Loginpage enterPassword() throws Exception {
	//	password1.sendKeys("Raju123");
		sendKeys_custom(password1,"password","Raju123");
		return new Loginpage(DriverFactory.getInstance().getDriver());
	}

	public Loginpage enterlogin() {
		//login.click();
		//click_custom(log,"login");
		Assert.assertEquals(click_customs(log,"login"), true);
		return new Loginpage(DriverFactory.getInstance().getDriver());
	}
}
