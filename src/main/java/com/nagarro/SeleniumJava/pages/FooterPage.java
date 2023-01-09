package com.nagarro.SeleniumJava.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {
	WebDriver driver;
	public FooterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//span[@class='z3ht-w']")
	public WebElement verifyCopyRight;
	
	@FindBy(how = How.XPATH, using = "//body/div[@id='container']/div/footer[@class='_3voSl0']/div[@class='_3rc_xQ']/div/div/div[@class='_2uz0vJ']/img[1]")
	public WebElement GateWayLogo;
	
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Help Center']")
	public WebElement HelpTab;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Contact Us']")
	public WebElement clickToContactUs;
	
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Gift Cards']")
	public WebElement GiftCardTab;
	
	@FindBy(how = How.XPATH, using = "//a[@href='https://brands.flipkart.com']")
	public WebElement AdvertiseTab;
	
	@FindBy(how = How.XPATH, using = "//span[@class='hDTmm5'][normalize-space()='Become a Seller']")
	public WebElement SellerTab;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Payments']")
	public WebElement clickToPayment;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Facebook']")
	public WebElement clickToFacebook;
	
	@FindBy(how = How.XPATH, using = "//a[normalize-space()='Shipping']")
	public WebElement clickToShipping;
	
	public void clickToCopyRight() {
		verifyCopyRight.click();
	}
	
	public boolean checkGateWayLogoIsPresent() {
		return GateWayLogo.isDisplayed();
	}
	
	public boolean validateHelpTab() {
		return HelpTab.isDisplayed();
	}
	
	public void verifyContactUs() throws InterruptedException {
		clickToContactUs.click();
		Thread.sleep(3000);
	}
	 
	public boolean validateGiftCardTab() {
		return GiftCardTab.isDisplayed();
	}
	
	public boolean validateAdvertiseTab() {
		return AdvertiseTab.isDisplayed();
	}
	
	public boolean validateBecomeASellerTab() {
		return SellerTab.isDisplayed();
	}
	
	public void verifyPayment() throws InterruptedException {
		clickToPayment.click();
		Thread.sleep(3000);
	}
	
	public void verifyFacebook() throws InterruptedException {
		clickToFacebook.click();
		Thread.sleep(3000);
	}
	
	public void verifyShipping() throws InterruptedException {
		clickToShipping.click();
		Thread.sleep(3000);
	}


}
