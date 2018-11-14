package com.gmc.tests.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gmc.base.ExtentTestManager;
import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminExcelImportPage;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;
import com.gmc.utils.PropertyFileReader;


public class AdminExcelImportTest extends TestBase {
	private String excelPageHeadertext = "Excel Import";
	private WebDriver driver;
	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
	public AdminExcelImportPage excelPage;
	
	String FilePath = "D://ExcelImport.xlsx";
	String fileDownloadPath = "C:\\Users\\niranjan\\Downloads";
	String downloadedFilename = "EXCEL_IMPORT_TEMPLATE";
	String validUsername = PropertyFileReader.getInstance().getUsername();
	String validPassword = PropertyFileReader.getInstance().getPassword();
    String adminURL = PropertyFileReader.getInstance().getAdminURL();
    String companyName = PropertyFileReader.getInstance().getCompanyName();
    String enrollFrom = PropertyFileReader.getInstance().getenrollFromDate();
    String enrollTo = PropertyFileReader.getInstance().getenrollToDate();
	
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
    	 excelPage = homePage.clickExcelImport();
    	 ExtentTestManager.getTest().log(Status.INFO, "From HomePage, Clicked on Excel Import");
    	 excelPage.selectCompany(companyName);
    	 ExtentTestManager.getTest().log(Status.INFO, "Selected the Entity");
       	 excelPage.uploadExcelFile();
    	 excelPage.enterEnrollFromDate(enrollFrom);
    	 excelPage.enterEnrollToDate(enrollTo);
    	 ExtentTestManager.getTest().log(Status.INFO, "Selected Enroll From & Enroll To Dates");
         excelPage.clickuploadbtn();
    	 ExtentTestManager.getTest().log(Status.INFO, "Clicked On UPLOAD Button");
         Thread.sleep(3000);
         excelPage.clickNextBtn();
         ExtentTestManager.getTest().log(Status.INFO, "After Lot No is generated, Clicking On NEXT Button");
         Thread.sleep(3000);
         String message  = excelPage.getSuccessMessage();
         
         Assert.assertEquals(message, "Successfully uploaded.");
         
    	}
     
     /*try{
         String error = browser.findElement(By.id("Your id")).getText();
         assertTrue(error.contains("The username or password you entered is incorrect."));

        }catch (NoSuchElementException e){
          //something else
           * 
           * // Here driver will try to find out My Account link on the application
 
      WebElement myAccount = driver.findElement(By.xpath(".//*[@id='account']/a"));
 
      //Test will only continue, if the below statement is true
 
      //This is to check whether the link is displayed or not
 
      Assert.assertTrue(myAccount.isDisplayed());
 
      //My Account will be clicked only if the above condition is true
 
      myAccount.click();
 
        }*/
     
     @Test(enabled = false)
 	public void VerifyExcelFileDownload() throws InterruptedException  {
    	 excelPage = homePage.clickExcelImport();
    	 ExtentTestManager.getTest().log(Status.INFO, "From HomePage, Clicked on Excel Import");
    	 excelPage.clickDownloadExcel();
    	 ExtentTestManager.getTest().log(Status.INFO, " Clicked On DownLoad Excel Template");
 	    //Assert.assertTrue(excelPage.verifyIfFileDownloaded(fileDownloadPath, downloadedFilename), "Failed downloaded failed");
 	}
     
  
@AfterClass
public void tearDown() {
	if(driver!=null) {
		driver.quit();
}
}

}
