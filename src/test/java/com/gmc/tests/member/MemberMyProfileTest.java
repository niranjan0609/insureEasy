package com.gmc.tests.member;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gmc.base.ExtentTestManager;
import com.gmc.base.TestBase;
import com.gmc.pageobjects.member.MemberEnrollmentPage;
import com.gmc.pageobjects.member.MemberHomePage;
import com.gmc.pageobjects.member.MemberLoginPage;
import com.gmc.pageobjects.member.MemberMyProfilePage;

public class MemberMyProfileTest extends TestBase {

	private WebDriver driver;
	private MemberMyProfilePage profilePage;
	public MemberLoginPage loginPage;
	public MemberHomePage homePage;

		@BeforeClass
		public void setUp() {
			driver=getDriver();
			String URL = driver.getCurrentUrl();
			driver.get(URL);
			loginPage = new MemberLoginPage(driver);
			loginPage.enterUserId("131231");
			loginPage.enterPassword("Qazxsw@123");
			homePage = loginPage.NavigateToHomePage();
			homePage.clickNextBtnAfterLogin();
			}
		
	@Test
	public void updatePassword() throws InterruptedException{
		profilePage = homePage.clickMyProfile();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on My profile");
		profilePage.enterNewPassword("Qazxsw@221");
		ExtentTestManager.getTest().log(Status.INFO, "Entered New Password");
		profilePage.confirmNewPassword("Qazxsw@221");
		ExtentTestManager.getTest().log(Status.INFO, "Confirmed the New Password");
		profilePage.clickUpdatePasswordBtn();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Update Password Button");
	}
	
	
	@Test
	public void updateMobileNo() throws InterruptedException{
		profilePage = homePage.clickMyProfile();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on My profile");
		profilePage.enterMobileNo("9832535411");
		ExtentTestManager.getTest().log(Status.INFO, "Entered Mobile Number");
		profilePage.clickUpdateMobileNoBtn();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Update Mobile Number Button");
		}
	

	@Test
	public void updateAlteranateEmail() throws InterruptedException{
		profilePage = homePage.clickMyProfile();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on My profile");
		profilePage.enterAlternateEmail("niranjan.reddy@isbsindia.in");
		ExtentTestManager.getTest().log(Status.INFO, "Entered Alternate Email ID");
		profilePage.clickUpdateAlternateEmailBtn();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Update Email Id Button");
		}
	
	@AfterClass
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
        }
}
