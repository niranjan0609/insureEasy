package com.gmc.tests.admin;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmc.base.ExtentTestManager;
import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;
import com.gmc.utils.PropertyFileReader;
import com.aventstack.extentreports.Status;

public class AdminLoginTest extends TestBase {

	private WebDriver driver;
	private String errorMessage = "please enter valid password.";
	private AdminLoginPage loginPage;
	
    //Test Data
    String validUsername = PropertyFileReader.getInstance().getUsername();
    String validPassword = PropertyFileReader.getInstance().getPassword();
    String adminURL = PropertyFileReader.getInstance().getAdminURL();
    String Invalidusername = PropertyFileReader.getInstance().getInvalidUsername();
    //String InvalidPassword = PropertyFileReader.getInstance().getPassword();

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		driver.get(adminURL);
		loginPage = new AdminLoginPage(driver);
	}

	@Test(groups = { "smoke", "regression" })
	public void validloginTest() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "valid login test started....");
		loginPage.enterLoginName(validUsername);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Valid admin UserName");
		loginPage.enterPassword(validPassword);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Valid admin Password");
		AdminHomePage homePage = loginPage.NavigateToHomePage();
		String hometext = homePage.getHomePageText();
		Assert.assertTrue(hometext.contains("BR LOGIN"), "user not navigated to home page");
		ExtentTestManager.getTest().log(Status.INFO, "valid login test completed");
	}

	@Test(groups = "regression")
	public void invalidUsername() {
		ExtentTestManager.getTest().log(Status.INFO, "Invalid Username test started...");
		loginPage.enterLoginName(Invalidusername);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Username which is invalid (citi5423554254)");
		loginPage.enterPassword(validPassword);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Password");
		loginPage.clickLoginBtn();
		ExtentTestManager.getTest().log(Status.INFO, "Clicking login button...");
		String error = loginPage.getErrorMessage();
		Assert.assertEquals(error, errorMessage, "Error message is not correct");
		ExtentTestManager.getTest().log(Status.INFO, "Unable to login with  invalid Username hence the Test is Passed");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
