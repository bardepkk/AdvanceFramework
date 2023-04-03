package com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath="//select[@id='type']")private WebElement openNewAccount ;
	@FindBy(xpath="//a[text()='Accounts Overview']")private WebElement accountsOverview ;
	@FindBy(xpath="(//a[text()='Transfer Funds'])[1]")private WebElement transferFunds ;
	@FindBy(xpath="(//a[text()='Bill Pay'])[1]")private WebElement billPay ;
	@FindBy(xpath="//a[text()='Find Transactions']")private WebElement findTransactions ;
	@FindBy(xpath="//a[text()='Update Contact Info']")private WebElement updateContactInf ;
	@FindBy(xpath="//a[text()='Request Loan']")private WebElement  requestLoan ;
	@FindBy(xpath="//a[text()='Log Out']")private WebElement logOut ;
	public HomePage(WebDriver driver){PageFactory.initElements(driver, this);}
	public void openNewAccount(){openNewAccount.click();}
	public void accountsOverview (){accountsOverview .click();}
	public void  transferFunds(){ transferFunds.click();}
	public void billPay (){billPay .click();}
	public void findTransactions(){findTransactions.click();}
	public void updateContactInf(){updateContactInf.click();}
	public void  requestLoan (){ requestLoan.click();}
	public void logOut(){logOut.click();}
	
}
