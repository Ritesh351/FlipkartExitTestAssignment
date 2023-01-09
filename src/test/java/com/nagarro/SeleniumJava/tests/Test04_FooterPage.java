package com.nagarro.SeleniumJava.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.nagarro.SeleniumJava.pages.FooterPage;
import com.nagarro.SeleniumJava.pages.HomePage;
import com.nagarro.SeleniumJava.tests.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test04_FooterPage extends BaseTest {
	
	Logger log=LogManager.getLogger(Test04_FooterPage.class);	

	@Test(priority = 0,groups = {"smoke"})
	public void clickToCopyRight() {
		if (DataDriven.isExecuteCase("clickToCopyRight").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("click To Copyright");
		log.info("******************CLICK Copyright*******************");
		FooterPage footer = new FooterPage(driver);
		footer.clickToCopyRight();
		String title = driver.findElement(By.xpath("//span[@class='z3ht-w']")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "© 2007-2023 Flipkart.com");
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 1,groups = {"smoke","sanity"})
	public void verifyFooterLogoTest() {
		if (DataDriven.isExecuteCase("verifyFooterLogoTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("testFooterLogo");

		log.info("******************CLICK Footer LOGO*******************");
		FooterPage footer = new FooterPage(driver);
		boolean b = footer.checkGateWayLogoIsPresent();
		Assert.assertTrue(b);
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");

	}

	@Test(priority = 2,groups = {"smoke"})
	public void verifyHelpCenterTest() {
		if (DataDriven.isExecuteCase("verifyHelpCenterTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("Check Help Center Tab");
		log.info("******************Click To Help Center Tab *******************");
		FooterPage footer = new FooterPage(driver);
		boolean b = footer.validateHelpTab();
		Assert.assertTrue(b);
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 3,groups = {"smoke"})
	public void verifyContactUsTest() throws InterruptedException {
		if (DataDriven.isExecuteCase("verifyContactUsTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("Check Help Center Tab");
		log.info("******************Click To Help Center Tab *******************");
		FooterPage footer = new FooterPage(driver);
		footer.verifyContactUs();
		String title = driver
				.findElement(By.xpath("//h1[normalize-space()='Flipkart Help Center | 24x7 Customer Care Support']"))
				.getText();
		System.out.println(title);
		Assert.assertEquals(title, "Flipkart Help Center | 24x7 Customer Care Support");
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 4,groups = {"smoke","sanity"})
	public void verifyGiftCardTest() {
		if (DataDriven.isExecuteCase("verifyGiftCardTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("Check GiftCard Tab");
		log.info("******************Click GiftCard Tab *******************");
		FooterPage footer = new FooterPage(driver);
		boolean b = footer.validateGiftCardTab();
		Assert.assertTrue(b);
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 5,groups = {"smoke"})
	public void verifyAdvertiseTest() {
		if (DataDriven.isExecuteCase("verifyAdvertiseTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("Check Help Center Tab");
		log.info("******************Click To Help Center Tab *******************");
		FooterPage footer = new FooterPage(driver);
		boolean b = footer.validateAdvertiseTab();
		Assert.assertTrue(b);
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 6,groups = {"smoke"})
	public void verifyBecomeASellerTest() {
		if (DataDriven.isExecuteCase("verifyBecomeASellerTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("Check BecomeASeller Tab");
		log.info("******************Click To BecomeASeller Tab *******************");
		FooterPage footer = new FooterPage(driver);
		boolean b = footer.validateBecomeASellerTab();
		Assert.assertTrue(b);
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 7,groups = {"smoke"})
	public void verifyPaymentTest() throws InterruptedException {
		if (DataDriven.isExecuteCase("verifyPaymentTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("Check Payment");
		log.info("******************Click Payment *******************");
		FooterPage footer = new FooterPage(driver);
		footer.verifyPayment();
		String title = driver.findElement(By.xpath("//h2[@id='payments']")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "Payments");
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 8,groups = {"smoke","sanity"})
	public void verifyFacebookTest() throws InterruptedException {
		if (DataDriven.isExecuteCase("verifyFacebookTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("Check Facebook");
		log.info("******************Click To Facebook *******************");
		FooterPage footer = new FooterPage(driver);
		footer.verifyFacebook();
		String title = driver.findElement(By.xpath("//a[normalize-space()='Facebook']")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "");
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

	@Test(priority = 7,groups = {"smoke","sanity"})
	public void verifyShippingTest() throws InterruptedException {
		if (DataDriven.isExecuteCase("verifyShippingTest").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		setExtent();
		extentTest = extent.startTest("Check Shipping");
		log.info("******************Click Shipping *******************");
		FooterPage footer = new FooterPage(driver);
		footer.verifyPayment();
		String title = driver.findElement(By.xpath("//a[normalize-space()='Shipping']")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "hipping");
		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
	}

}
