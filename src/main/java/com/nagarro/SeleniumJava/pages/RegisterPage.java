package com.nagarro.SeleniumJava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(how=How.CLASS_NAME,using="_14Me7y")
	public WebElement createAnAccount;
	
	@FindBy(how=How.XPATH,using="//input[@class='_2IX_2- VJZDxU']")
	public WebElement enterMobileNumber;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'✕')]")
	public WebElement NavToHome;
	
	
	

	public void clickToCreateAcc() {
		createAnAccount.click();
	}	
	
	public void clickToMobileNo(String value) {
		enterMobileNumber.sendKeys(value);
	}
	
	public void ClickToCross() {
		NavToHome.click();
	}
	
	
	
}
