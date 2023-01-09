package com.nagarro.SeleniumJava.tests;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.nagarro.SeleniumJava.pages.HomePage;
import com.nagarro.SeleniumJava.pages.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class Test01_HomePage extends BaseTest {

	String productname = "iPhone";
	Logger log=LogManager.getLogger(Test01_HomePage.class);

	@Test(priority = 0,groups = {"smoke","sanity"})
	public void verifyHomePageTitleTest() throws IOException {
		if (DataDriven.isExecuteCase("verifyHomePageTitleTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		log.info("******************CLICK HOMEPAGE TITLE*******************");
		setExtent();
		extentTest = extent.startTest("testHomePageTitle");
		String title = homepage.getTitle();
		Assert.assertEquals(title,
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 1, groups = {"smoke","sanity"})
	public void verifyFlipkartLogoTest() {
		
		if (DataDriven.isExecuteCase("verifyFlipkartLogoTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		log.info("******************CLICK FLIPKART LOGO*******************");
		setExtent();
		extentTest = extent.startTest("testFlipkartLogo");
		homepage = new HomePage(driver);
		boolean b = homepage.checkFlipkartLogoIsPresent();
		Assert.assertTrue(b);
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");

	}

	@Test(priority = 2,groups = {"smoke"})
	public void verifyLoginTabTest() {
		if (DataDriven.isExecuteCase("verifyLoginTabTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("checkLogin");
		log.info("******************Click Login *******************");
		homepage = new HomePage(driver);
		LoginPage loginpage = homepage.clickOnLoginTab();
		boolean b = loginpage.checkLoginPageIsVisible();
		Assert.assertTrue(b);
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 3,groups = {"smoke","sanity"})
	public void verifyBecomeASellerTabTest() {
		if (DataDriven.isExecuteCase("verifyBecomeASellerTabTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("Check Become a SellerTab");
		log.info("******************Click To Become a Seller *******************");
		boolean b = homepage.validateBecomeASellerTab();
		Assert.assertTrue(b);
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 4,groups = {"smoke","sanity"})
	public void verifySearchProductTest() {
		if (DataDriven.isExecuteCase("verifySearchProductTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("checkSearchBar");
		log.info("*****************Search a Product *******************");
		homepage.enterProductName(productname);
		homepage.clickOnSearchIcon();
		boolean b = homepage.validateSearchResults(productname);
		Assert.assertTrue(b);
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 5,groups = {"smoke"})
	public void ClickNextSlide() {
		if (DataDriven.isExecuteCase("ClickNextSlide").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		log.info("******************CLICK NEXT SLIDE*******************");
		setExtent();
		extentTest = extent.startTest("ClickNextSlide");
		homepage.clickNextSlide();
		homepage.clickNextSlide();
		homepage.clickNextSlide();
		homepage.clickNextSlide();
		boolean b = homepage.validateNextSlideTab();
		Assert.assertTrue(b);
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 6,groups = {"smoke","sanity"})
	public void ClickBackSlide() {
		if (DataDriven.isExecuteCase("ClickBackSlide").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		log.info("******************CLICK BACK SLIDE*******************");
		setExtent();
		extentTest = extent.startTest("ClickBackSlide");
		homepage.clickBackSlide();
		homepage.clickBackSlide();
		homepage.clickBackSlide();
		homepage.clickBackSlide();
		boolean b = homepage.validateBackSlideTab();
		Assert.assertTrue(b);
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}
}
