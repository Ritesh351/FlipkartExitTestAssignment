package com.nagarro.SeleniumJava.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nagarro.SeleniumJava.abstractcomponents.BasePage;

public class HomePage extends BasePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//img[@title='Flipkart']")
	public WebElement FlipkartLogo;

	@FindBy(how = How.CLASS_NAME, using = "_1_3w1N")
	public WebElement Login;

	@FindBy(how = How.XPATH, using = "//a[@class='_3-PJz-']//span[contains(text(),'Become a Seller')]")
	public WebElement SellerTab;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search for products, brands and more']")
	public WebElement SearchBox;

	@FindBy(xpath = "//button[@type=\"submit\"]//*[name()=\"svg\"]")
	public WebElement SearchIcon;
	
	@FindBy(css = "._4rR01T")
	public List<WebElement> products;
	
	@FindBy(how=How.CLASS_NAME,using="_2-wzdc")
	public WebElement NextSlide;
	
	@FindBy(how=How.CLASS_NAME,using="FXox6K")
	public WebElement BackSlide;

	public boolean checkFlipkartLogoIsPresent() {
		return FlipkartLogo.isDisplayed();
	}

	public LoginPage clickOnLoginTab() {
		Login.click();
		return new LoginPage(driver);
	}

	public void clickOnLogin() {
		Login.click();
	}

	public boolean validateBecomeASellerTab() {
		return SellerTab.isDisplayed();
	}

	public void enterProductName(String value) {
		SearchBox.sendKeys(value);
	}

	public void clickOnSearchIcon() {
		SearchIcon.click();
	}

	public boolean validateSearchResults(String productname) {
		for (WebElement product : products) {
			if(!product.getText().toLowerCase().contains(productname.toLowerCase()))
			{
				System.out.println(product.getText());
				return false;
			}
		}
		return true;
	}

	public void clickNextSlide() {
		NextSlide.click();
	}
	public void clickBackSlide() {
		BackSlide.click();
	}
	
	public boolean validateNextSlideTab() {
		return NextSlide.isDisplayed();
	}
	
	public boolean validateBackSlideTab() {
		return BackSlide.isDisplayed();
	}
	

}
