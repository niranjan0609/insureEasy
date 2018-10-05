package com.gmc.tests.member;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminLoginPage;
import com.gmc.pageobjects.member.MemberEnrollmentPage;
import com.gmc.pageobjects.member.MemberHomePage;
import com.gmc.pageobjects.member.MemberLoginPage;

public class MemberEnrollmentTest extends TestBase{

	private WebDriver driver;
	private MemberEnrollmentPage enrollPage;
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
		
	@Test(enabled=false)
	public void DependentDetailsTest() throws InterruptedException{
		enrollPage = homePage.NavigateEnrollmentPage();
	    enrollPage.enterDependentName("Priya");
		enrollPage.enterDependentDateOfBirth("12");
		enrollPage.enterDependentMonthOfBirth("Sep");
		enrollPage.enterDependentYearOfBirth("1970");
		enrollPage.enterDependentRelationship("WIFE");
		}
	
	@Test(enabled=false)
	public void DownloadEcard() throws InterruptedException{
		enrollPage = homePage.NavigateEnrollmentPage();
		enrollPage.clickEcard();
		Thread.sleep(3000);
		
	}
	

	@Test(enabled=true)
	public void VerifyNetworkHospitalsLink() throws InterruptedException{
		enrollPage = homePage.NavigateEnrollmentPage();
		enrollPage.clickNetworkHospitals();
		Thread.sleep(3000);
		
	}
	@AfterClass
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
        }
}
