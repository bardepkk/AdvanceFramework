package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateContactInf {

	@FindBy(xpath="//input[@id='customer.firstName']")WebElement name;
	@FindBy(xpath="//input[@id='customer.lastName']")WebElement lname;
	@FindBy(xpath="//input[@id='customer.address.street']")WebElement address;
	@FindBy(xpath="//input[@id='customer.address.city']")WebElement city;
	@FindBy(xpath="//input[@id='customer.address.state']")WebElement state;
	@FindBy(xpath="//input[@id='customer.address.zipCode']")WebElement zipCode;
	@FindBy(xpath="//input[@id='customer.phoneNumber']")WebElement phNO;
	@FindBy(xpath="//input[@value='Update Profile']")WebElement update;
	
	public UpdateContactInf(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterName()
	{name.clear();
	name.sendKeys("ram");}
	public void enterLname() 
	{lname.clear();
	lname.sendKeys("dhok");}
	public void enterAddress() 
	{address.clear();
	address.sendKeys("Lachpat nagar pune");}
	public void entercity()
	{	city.clear();
	city.sendKeys("pune");}
	public void enterState() 
	{
		state.clear();
		state.sendKeys("maharashtra");}
	public void enterZipCode() 
	{zipCode.clear();
	zipCode.sendKeys("447523");}
	public void enterphNo()
	{phNO.clear();
	phNO.sendKeys("4512768392");}
	public void enterUpdate() 
	{update.click();}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
