package com.gmc.tests.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gmc.base.ExtentTestManager;
import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminExcelImportDepPage;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;

public class AdminExcelImportDepTest extends TestBase{

	private WebDriver driver;
	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
	public AdminExcelImportDepPage excelDepPage;
	
	
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
    	 excelDepPage = homePage.clickExcelDep();
    	 ExtentTestManager.getTest().log(Status.INFO, "From HomePage, Clicked on Import Excel Dependents");
    	 excelDepPage.selectCompany("CITIBANK N A");
    	 ExtentTestManager.getTest().log(Status.INFO, "Selected the Entity");
    	 excelDepPage.selectLotno("10539(30-Jul-2018-to-30-Sep-2018)");
    	 ExtentTestManager.getTest().log(Status.INFO, "Selected Lot No");
    	 excelDepPage.uploadExcelFile();
    	 excelDepPage.clickUploadBtn();
    	 ExtentTestManager.getTest().log(Status.INFO, "Clicked on Upload Button");
    	
    	}
     
  
@AfterClass
public void tearDown() {
	if(driver!=null) {
		driver.quit();
            }
                 }
}
