package com.nagarro.SeleniumJava.tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.nagarro.SeleniumJava.pages.HomePage;
import com.nagarro.SeleniumJava.pages.RegisterPage;
import com.relevantcodes.extentreports.LogStatus;

public class Test02_RegisterPage extends BaseTest {

	Logger log=LogManager.getLogger(Test02_RegisterPage.class);
	
	@Test(priority = 0,groups = {"smoke"})
	public void CreateNewuser() throws InterruptedException {
		if (DataDriven.isExecuteCase("CreateNewuser").equalsIgnoreCase("no"))
			throw new SkipException("Skiped");
		log.info("******************NEW USER REGISTER*******************");
		setExtent();
		extentTest = extent.startTest("CreateNewuser");
		HomePage homepage = new HomePage(driver);
		homepage.clickOnLogin();
		RegisterPage register = new RegisterPage(driver);
		register.clickToCreateAcc();
		System.out.println("AccCreate");
		register.clickToMobileNo("mobileno");
		String text = driver
				.findElement(By.xpath("//span[normalize-space()='Sign up with your mobile number to get started']"))
				.getText();
		Assert.assertEquals(text, "Sign up with your mobile number to get started");
		Thread.sleep(3000);
		register.ClickToCross();

		extentTest.log(LogStatus.PASS, "Test case Passed sucessfully");
		log.info("******************USER REGISTER SUCESSFULLY*******************");

	}

}
