package com.gmc.tests.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gmc.base.ExtentTestManager;
import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminBulkEmailsPage;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;

public class AdminBulkEmailsTest extends TestBase {
	private WebDriver driver;
	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
	public AdminBulkEmailsPage bulkPage;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
		String URL = driver.getCurrentUrl() + "admin";
		driver.get(URL);
		loginPage = new AdminLoginPage(driver);
		loginPage.enterLoginName("citibr");
		loginPage.enterPassword("qaz456");
		homePage = loginPage.NavigateToHomePage();
	}



     @Test
 	 public void excelImport() throws InterruptedException {
    	 bulkPage = homePage.clickBulkEmail();
    	 ExtentTestManager.getTest().log(Status.INFO, "Clicked on Bulk Email Link");
    	 bulkPage.selectCompany("CITIBANK N A");
    	 ExtentTestManager.getTest().log(Status.INFO, "Selected the Company");
    	 bulkPage.selectLotno("10539(30-Jul-2018-to-30-Sep-2018)");
    	 ExtentTestManager.getTest().log(Status.INFO, "Selected Lot No:");
    	 bulkPage.selectEmailType("Welcome Mails");
    	 ExtentTestManager.getTest().log(Status.INFO, "Selected Mailer Type");
    	 bulkPage.selectTestOption();
    	 bulkPage.SampleEmailAddress("niranjan.reddy@isbsindia.in");
    	 bulkPage.clickSendMail();
    	 ExtentTestManager.getTest().log(Status.INFO, "Clicked on Send Mail");
    	 Thread.sleep(3000);
    	     	}
     
  
@AfterClass
public void tearDown() {
	if(driver!=null) {
		driver.quit();
            }
                 }
}
