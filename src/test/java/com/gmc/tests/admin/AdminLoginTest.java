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
			String URL = driver.getCurrentUrl() + "admin";
			driver.get(URL);
		}
	
	@Test
	public void validloginTest() throws InterruptedException{
		AdminLoginPage loginPage = new AdminLoginPage(driver);
		loginPage.enterLoginName("citibr");
		loginPage.enterPassword("qaz456");
		AdminHomePage homePage = loginPage.NavigateToHomePage();
		//homePage.verifySuccessfullLogin("BR LOGIN");
		//Thread.sleep(1000);
		
	}
	
	@Test void invalidUsername() {
		AdminLoginPage loginPage = new AdminLoginPage(driver);
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
