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
import com.gmc.utils.PropertyFileReader;

public class AdminBulkEmailsTest extends TestBase {
	private WebDriver driver;
	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
	public AdminBulkEmailsPage bulkPage;
	
	String validUsername = PropertyFileReader.getInstance().getUsername();
	String validPassword = PropertyFileReader.getInstance().getPassword();
    String adminURL = PropertyFileReader.getInstance().getAdminURL();
    String companyNameBulk = PropertyFileReader.getInstance().getCompanyNameBulk();
    String lotNoBulk = PropertyFileReader.getInstance().getlotNoBulk();
    String emailType = PropertyFileReader.getInstance().getEmailType();
    
	
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
 	 public void excelImport() throws InterruptedException {
    	 bulkPage = homePage.clickBulkEmail();
    	 ExtentTestManager.getTest().log(Status.INFO, "Clicked on Bulk Email Link");
    	 bulkPage.selectCompany(companyNameBulk);
    	 ExtentTestManager.getTest().log(Status.INFO, "Selected the Company");
    	 bulkPage.selectLotno(lotNoBulk);
    	 ExtentTestManager.getTest().log(Status.INFO, "Selected Lot No:");
    	 bulkPage.selectEmailType(emailType);
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
