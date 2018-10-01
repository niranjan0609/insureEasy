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
	private AdminLoginPage loginPage;

		@BeforeClass
		public void setUp() {
			driver=getDriver();
			String URL = driver.getCurrentUrl() + "admin";
			driver.get(URL);
			loginPage = new AdminLoginPage(driver);
		}
	
	@Test(groups = { "smoke", "regression" })
	public void validloginTest() throws InterruptedException{
		loginPage.enterLoginName("citibr");
		loginPage.enterPassword("qaz456dd");
		AdminHomePage homePage = loginPage.NavigateToHomePage();
		String hometext = homePage.getHomePageText();
		Assert.assertTrue(hometext.contains("BR LOGIN"), "user not navigated to home page");
	}
	
	@Test(groups="regression")
	public void invalidUsername() {
		loginPage.enterLoginName("45467437567844767865684");
		loginPage.enterPassword("qa456");
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
