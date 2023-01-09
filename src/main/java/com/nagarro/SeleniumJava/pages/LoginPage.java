package com.nagarro.SeleniumJava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.SeleniumJava.abstractcomponents.BasePage;

public class LoginPage extends BasePage{

	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver=driver;
}
	
	@FindBy(how=How.XPATH,using="//a[normalize-space()='Login']")
	public WebElement LoginBtn;
	
	@FindBy(how=How.XPATH,using="//input[@class='_2IX_2- VJZDxU']")
	public WebElement EnterMobileNo;
	
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Request OTP']")
	public WebElement RequestOtp;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Login')]")
	public WebElement LoginTitle;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Get access to your Orders, Wishlist and Recommenda')]")
	public WebElement LoginSubTitle;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Get access to your Orders, Wishlist and Recommenda')]")
	public WebElement alertmessage1;
	
	public void clickLoginBtn() {
		LoginBtn.click();
	}
	
	public void sendMaildId(String value) {
		EnterMobileNo.sendKeys(value);
	}
	
	public void clickContinue() {
		RequestOtp.click();
	}
	
	public void loginTitle() {
		LoginTitle.click();
	}
	
	public void loginSubTitle() {
		LoginSubTitle.click();
	}
	
	public boolean checkLoginPageIsVisible()
	{
		return EnterMobileNo.isDisplayed();
	}
	
}
