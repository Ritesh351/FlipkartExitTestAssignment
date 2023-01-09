package com.nagarro.SeleniumJava.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;
import com.nagarro.SeleniumJava.pages.HomePage;
import com.nagarro.SeleniumJava.util.Screenshots;
import com.nagarro.SeleniumJava.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	static File file = new File("./Resources/config.properties");
	static FileInputStream fis = null;
	static Properties prop = new Properties();
	Logger log = Logger.getLogger(BaseTest.class);
	HomePage homepage;

	static {

		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public static void setExtent() {
		extent = new ExtentReports("./Reports/ExtentReport.html");
	//	extent.config();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
		extent.close();
	}

	public void initialization() {
		log.info("******************LAUNCH BROWSER*******************");
	//	System.setProperty(prop.getProperty("chromedriverProperty"), prop.getProperty("chromedriverPath"));
		String browser = prop.getProperty("browser");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver();
			//Below code for headless mode
			ChromeOptions options=new ChromeOptions();
			options.addArguments("Headless");
			 driver = new ChromeDriver(options);
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//div[@class=\"_2QfC02\"]/button")).click();
	}

	@BeforeMethod(alwaysRun=true)
	public void setup( ) {
		log.info("******************Launch Browser*******************");
		initialization();
		homepage = new HomePage(driver);
		
	}

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		log.info("******************CLOSE BROWSER*******************");
		driver.quit();
	}

	@AfterMethod(alwaysRun=true)
	public void attachScreenshot(ITestResult result) {
		log.info("******************ATTACH FAILED SCCREENSHOTS*******************");
		if (result.getStatus() == ITestResult.FAILURE) {
			String scrPath = Screenshots.captureScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(scrPath));
		}
	}

}
