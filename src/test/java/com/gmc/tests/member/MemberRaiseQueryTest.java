package com.gmc.tests.member;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gmc.base.ExtentTestManager;
import com.gmc.base.TestBase;
import com.gmc.pageobjects.member.MemberHomePage;
import com.gmc.pageobjects.member.MemberLoginPage;
import com.gmc.pageobjects.member.MemberRaiseQueryPage;


public class MemberRaiseQueryTest extends TestBase {
	private WebDriver driver;
	private MemberRaiseQueryPage queryPage;
	public MemberLoginPage loginPage;
	public MemberHomePage homePage;

		@BeforeClass
		public void setUp() {
			driver=getDriver();
			String URL = driver.getCurrentUrl();
			driver.get(URL);
			loginPage = new MemberLoginPage(driver);
			loginPage.enterUserId("131231");
			loginPage.enterPassword("Qazxsw@221");
			homePage = loginPage.NavigateToHomePage();
			homePage.clickNextBtnAfterLogin();
			}
		
	@Test(groups = { "smoke", "regression" })
	public void raiseAQuery() throws InterruptedException{
		queryPage = homePage.clickRaiseAQuery();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Raise a Query");
		Thread.sleep(2000);
		queryPage.enterQueryHeading("Vidal ID not Generating");
		ExtentTestManager.getTest().log(Status.INFO, "Entered Query Heading");
		queryPage.enterQueryDescription("I have enrolled to CITI policy but my vidal ID is still not generated. can you tell me what the issue is");
		ExtentTestManager.getTest().log(Status.INFO, "Entered Query Description");
		queryPage.clickSubmitQueryBtn();
	    Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Submit Query Button");
	}
	

	@AfterClass
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
        }

}
