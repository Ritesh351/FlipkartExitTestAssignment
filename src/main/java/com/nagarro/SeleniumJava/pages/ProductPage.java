package com.nagarro.SeleniumJava.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search for products, brands and more']")
	public WebElement enterProductName;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']//*[name()='svg']")
	public WebElement clickToSearchBar;

	@FindBy(how = How.CSS, using = "._4rR01T")
	public List<WebElement> products;

	@FindBy(how = How.XPATH, using = "//div[normalize-space()='APPLE iPhone 14 (Purple, 128 GB)']")
	public WebElement clickToProduct;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Add to cart']")
	public WebElement AddToCartBtn;
	
	@FindBy(how = How.CSS, using = "._2Kn22P")
	public List<WebElement> CartProducts;

	public void enterProductName(String value) {
		enterProductName.sendKeys(value);
	}

	public void clickToSearchBar() throws InterruptedException {
		clickToSearchBar.click();
		Thread.sleep(3000);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void selectProduct(String productname) {
		for (WebElement product : products) {
			String text = product.getText();
			if (text.trim().equalsIgnoreCase(productname.trim())) {
				product.click();
			}
		}
	}	
	
	public void addToCart() throws InterruptedException {
		Thread.sleep(3000);
		String parentwindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
		String childwindow = it.next();
		if(parentwindow!=childwindow){
		driver.switchTo().window(childwindow);
		}
		}
		AddToCartBtn.click();
	}
	
	public boolean checkProductAddedToCart(String productname) throws InterruptedException {
		Thread.sleep(6000);
		for (WebElement product : CartProducts) {
			String text = product.getText();
			System.out.println(text);
			System.out.println(productname);
			if (text.trim().equalsIgnoreCase(productname.trim())) {
				return true;
			}
		}
		return false;
	}

}
