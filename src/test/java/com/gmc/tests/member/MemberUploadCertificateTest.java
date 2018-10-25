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
import com.gmc.pageobjects.member.MemberUploadCertificatePage;

public class MemberUploadCertificateTest extends TestBase{

	private WebDriver driver;
	private MemberUploadCertificatePage uploadPage;
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
	public void uploadCertificate() throws InterruptedException{
		uploadPage = homePage.clickUploadCertificate();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Upload Certificate");
	    uploadPage.uploadFile();
	    ExtentTestManager.getTest().log(Status.INFO, "Chose valid certificate by browsing Local Drive");
	    uploadPage.clickUploadBtn();
	    Thread.sleep(3000);
	    ExtentTestManager.getTest().log(Status.INFO, "Clicked on Upload Button after file is selected");
	}
	
	
	@Test(groups = { "regression" } , enabled = false)
	public void verifyCancelBtn() throws InterruptedException{
		uploadPage = homePage.clickUploadCertificate();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Upload Certificate");
	    uploadPage.uploadFile();
	    ExtentTestManager.getTest().log(Status.INFO, "Chose valid certificate by browsing Local Drive");
		Thread.sleep(3000);
		uploadPage.clickCancelBtn();
	    ExtentTestManager.getTest().log(Status.INFO, "Clicked on Cancel Button & User redirected to previous page");
	}
	


	@AfterClass
	public void tearDown(){
		if(driver!=null) {
			driver.quit();
		}
        }
}
