package com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BillPay {
@FindBy(xpath="//input[@ng-model='payee.name']")WebElement payee;
@FindBy(xpath="//input[@ng-model='payee.address.street']")WebElement address;
@FindBy(xpath="//input[@ng-model='payee.address.city']")WebElement city;
@FindBy(xpath="//input[@ng-model='payee.address.state']")WebElement state;
@FindBy(xpath="//input[@ng-model='payee.address.zipCode']")WebElement pinCode;
@FindBy(xpath="//input[@ng-model='payee.phoneNumber']")WebElement phoneNo;
@FindBy(xpath="//input[@ng-model='payee.accountNumber']")WebElement account;
@FindBy(xpath="//input[@ng-model='verifyAccount']")WebElement  verifyAccount;
@FindBy(xpath="//input[@ng-model='amount']")WebElement billAmmount;
@FindBy(xpath="//select[@ng-model='accountId']")WebElement accountID;
@FindBy(xpath="//input[@value='Send Payment']")WebElement payBill;	
public BillPay(WebDriver driver) {PageFactory.initElements(driver, this);}
public void enterpayee(){payee.sendKeys("pranay Barde");}
public void enterAddress(){address.sendKeys("Lachpat Nagar, pune");}
public void entercity(){city.sendKeys("pune");}
public void enterstate(){state.sendKeys("Maharashtra");}
public void enterpinCode(){pinCode.sendKeys("442508");}
public void enterphoneNo(){phoneNo.sendKeys("8789016457");}
public void enteraccount(){account.sendKeys("13344");}
public void enterverifyAccount(){verifyAccount.sendKeys("13344");}
public void enterbillAmmount(){billAmmount.sendKeys("5000");}
public void enteraccountID(){Select e=new Select(accountID);
e.selectByIndex(0);}

public void enterpayBill(){payBill.click();	}
	
	
	
	
}
