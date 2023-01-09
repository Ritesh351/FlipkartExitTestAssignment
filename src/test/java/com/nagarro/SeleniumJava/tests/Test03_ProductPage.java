package com.nagarro.SeleniumJava.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.nagarro.SeleniumJava.pages.HomePage;
import com.nagarro.SeleniumJava.pages.ProductPage;
import com.relevantcodes.extentreports.LogStatus;

public class Test03_ProductPage extends BaseTest {

	Logger log=LogManager.getLogger(Test03_ProductPage.class);
	
	@Test(priority = 0,groups = {"smoke"})
	public void productSearch() throws InterruptedException {
		if (DataDriven.isExecuteCase("productSearch").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		log.info("****************** Product Search *******************");
		extentTest = extent.startTest("LoginToFlipkart");
		ProductPage productpage = new ProductPage(driver);
		productpage.enterProductName(prop.getProperty("SearchInput"));
		productpage.clickToSearchBar();
		String title = productpage.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,
				"IPhone 14- Buy Products Online at Best Price in India - All Categories | Flipkart.com");
		extentTest.log(LogStatus.PASS, "Search Product");
		log.error("****************** Product *******************");
	}

	@Test(priority = 1,groups = {"smoke"})
	public void productAddToCart() throws InterruptedException {
		if (DataDriven.isExecuteCase("productAddToCart").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		log.info("****************** Product Add To Cart *******************");
		setExtent();
		extentTest = extent.startTest("Product Add To cart");
		ProductPage productpage = new ProductPage(driver);
		productpage.enterProductName(prop.getProperty("SearchInput"));
		productpage.clickToSearchBar();
		Thread.sleep(3000);
		productpage.selectProduct(prop.getProperty("productName"));
		productpage.addToCart();
		boolean b = productpage.checkProductAddedToCart(prop.getProperty("productName"));
		Assert.assertTrue(b, "");
		extentTest.log(LogStatus.PASS, "Add Product");
		log.error("****************** Product *******************");
	}

}
