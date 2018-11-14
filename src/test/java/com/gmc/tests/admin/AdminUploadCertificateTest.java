package com.gmc.tests.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gmc.base.ExtentTestManager;
import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;
import com.gmc.pageobjects.admin.AdminUploadCertificatePage;
import com.gmc.utils.PropertyFileReader;

public class AdminUploadCertificateTest extends TestBase{
	private WebDriver driver;
	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
	public AdminUploadCertificatePage uploadCertiPage;
	
	String validUsername = PropertyFileReader.getInstance().getUsername();
	String validPassword = PropertyFileReader.getInstance().getPassword();
    String adminURL = PropertyFileReader.getInstance().getAdminURL();

    
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
		driver.get(adminURL);
		loginPage = new AdminLoginPage(driver);
		loginPage.enterLoginName(validUsername);
		loginPage.enterPassword(validPassword);
		homePage = loginPage.NavigateToHomePage();
	}

     @Test
 	 public void uploadCertificate() throws InterruptedException {
    	 uploadCertiPage = homePage.clickUploadCertificate();
    	 ExtentTestManager.getTest().log(Status.INFO, "Clicked on Upload Certificate after successful Login ");
    	 uploadCertiPage.uploadFile();
    	 Thread.sleep(3000);
    	 uploadCertiPage.clickuploadbtn();
    	 ExtentTestManager.getTest().log(Status.INFO, "Ceritificate Upload successful ");
    	
    	}
       
@AfterClass
public void tearDown() {
	if(driver!=null) {
		driver.quit();
            }
           }
}
