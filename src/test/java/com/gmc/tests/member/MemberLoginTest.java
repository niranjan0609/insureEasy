package com.gmc.tests.member;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


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
		loginPage.enterUserId("131231");
		loginPage.enterPassword("Qazxsw@123");
		MemberHomePage homePage = loginPage.NavigateToHomePage();
		/*String hometext = homePage.getHomePageText();
		Assert.assertTrue(hometext.contains("Harish"), "user not navigated to home page");*/
		
	}
	
	@Test(groups="regression")
	public void invalidUsername() {
		loginPage.enterUserId("45467437567844767865684");
		loginPage.enterPassword("qa456");
		loginPage.clickLoginBtn();
		String error = loginPage.getErrorMessage();
		Assert.assertEquals(error, usernameErrorMessage, "Error message is not correct");
	}
	
	@Test(groups="regression")
	public void invalidPassword() {
		loginPage.enterUserId("131231");
		loginPage.enterPassword("qa456");
		loginPage.clickLoginBtn();
		String error = loginPage.getErrorMessage();
		Assert.assertEquals(error, passwordErrorMessage, "Error message is not correct");
	}
	
	@AfterClass
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
	}

}
