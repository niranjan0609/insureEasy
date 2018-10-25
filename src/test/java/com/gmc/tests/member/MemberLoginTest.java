package com.gmc.tests.member;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gmc.base.ExtentTestManager;
import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;
import com.gmc.pageobjects.member.MemberHomePage;
import com.gmc.pageobjects.member.MemberLoginPage;

public class MemberLoginTest extends TestBase{
	private WebDriver driver;
	private String usernameErrorMessage = "Your Employee Id is not found in our database. This could be because that the enrollment window is not yet activated for you or some other delay in updating our database. Hence request you to Kindly contact respective HR.";
	private String passwordErrorMessage = "Invalid Password.Please click on forgot password link to generate new password123.";
	private MemberLoginPage loginPage;


		@BeforeClass
		public void setUp() {
			driver=getDriver();
			String URL = driver.getCurrentUrl();
			driver.get(URL);
			loginPage = new MemberLoginPage(driver);
		}

	
		
	@Test(groups = { "smoke", "regression" })
	public void validloginTest() throws InterruptedException{
		ExtentTestManager.getTest().log(Status.INFO, "valid login test started....");
		loginPage.enterUserId("131231");
		ExtentTestManager.getTest().log(Status.INFO, "Entered Valid User ID");
		loginPage.enterPassword("Qazxsw@123");
		ExtentTestManager.getTest().log(Status.INFO, "Entered Valid Password");
		loginPage.clickLoginBtn();
		 
		MemberHomePage homePage = loginPage.NavigateToHomePage();
		/*String hometext = homePage.getHomePageText();
		Assert.assertTrue(hometext.contains("Harish"), "User not navigated to home page");*/
		ExtentTestManager.getTest().log(Status.INFO, "User Successfully Logged in");
	}
	
	@Test(groups="regression")
	public void invalidUsername() {
		ExtentTestManager.getTest().log(Status.INFO, "Invalid UserName Test started");
		loginPage.enterUserId("45467437567844767865684");
		ExtentTestManager.getTest().log(Status.INFO, "Entered invalid User ID");
		loginPage.enterPassword("qa456");
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on valid Password");
        loginPage.clickLoginBtn();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Login Button");
        String error = loginPage.getErrorMessage();
		Assert.assertEquals(error, usernameErrorMessage, "Error message is not correct");
		ExtentTestManager.getTest().log(Status.INFO, "User couldn't login with invalid username");
	}
	
	@Test(groups="regression")
	public void invalidPassword() {
		ExtentTestManager.getTest().log(Status.INFO, "Invalid Password Test started");
		loginPage.enterUserId("131231");
		ExtentTestManager.getTest().log(Status.INFO, "Entered valid User ID");
		loginPage.enterPassword("qa456");
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on invalid Password");
		loginPage.clickLoginBtn();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Login Button");
		String error = loginPage.getErrorMessage();
		Assert.assertEquals(error, passwordErrorMessage, "Error message is not correct");
		ExtentTestManager.getTest().log(Status.INFO, "User couldn't login with invalid password");
	}
	
	@AfterClass
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
	}

}
