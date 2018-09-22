package com.gmc.tests.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;

public class AdminLoginTest extends TestBase{
	
	private WebDriver driver;
	private String errorMessage = "please enter valid password.";

		@BeforeClass
		public void setUp() {
			driver=getDriver();
		}
	
	@Test
	public void validloginTest(){
		AdminLoginPage loginPage = new AdminLoginPage(driver);
		loginPage.enterLoginName("sahana");
		loginPage.enterPassword("sahana123");
		AdminHomePage homePage = loginPage.NavigateToHomePage();
		homePage.verifySuccessfullLogin("SAHANA");
	}
	
	@Test void invalidUsername() {
		AdminLoginPage loginPage = new AdminLoginPage(driver);
		loginPage.enterLoginName("1234567890998877766612");
		loginPage.enterPassword("sahana123");
		loginPage.clickLoginBtn();
		String error = loginPage.getErrorMessage();
		Assert.assertEquals(error, errorMessage, "Error message is not correct");
	}
	
	@AfterClass
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
	}

}
