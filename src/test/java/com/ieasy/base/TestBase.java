package com.gmc.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.testng.annotations.Optional;


public class TestBase{

	private WebDriver driver;
	static String driverPath = "D:/drivers/";
	
	public WebDriver getDriver() {
		return driver;
	}

	private WebDriver setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		case "ie":
			driver = initInternetExplorer(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
		return driver;
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching firefox browser..");
		System.setProperty("webdriver.gecko.driver", driverPath
				+ "geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}
	
	private static WebDriver initInternetExplorer(String appURL) {
		System.out.println("Launching firefox browser..");
		System.setProperty("webdriver.chrome.driver", driverPath
				+ "chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeTest
	public void initializeTestBaseSetup(@Optional("chrome") String browserType, @Optional("http://dev.isbsindia.in/mmenroll/") String appURL, ITestContext context) {		try {
		//test.log(Status.INFO, "Opening browser "+browserType);
		    System.out.println("Intializing browser...." + browserType);
			driver = setDriver(browserType, appURL);
			context.setAttribute("driver", driver);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
