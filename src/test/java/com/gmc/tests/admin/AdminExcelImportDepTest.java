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
import com.gmc.utils.PropertyFileReader;

public class AdminExcelImportDepTest extends TestBase{

	private WebDriver driver;
	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
	public AdminExcelImportDepPage excelDepPage;
	
	String validUsername = PropertyFileReader.getInstance().getUsername();
	String validPassword = PropertyFileReader.getInstance().getPassword();
    String adminURL = PropertyFileReader.getInstance().getAdminURL();
    String companyNameDep = PropertyFileReader.getInstance().getCompanyNameDep();
    String lotNo = PropertyFileReader.getInstance().getlotNo();

	
	
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
    	 excelDepPage = homePage.clickExcelDep();
    	 ExtentTestManager.getTest().log(Status.INFO, "From HomePage, Clicked on Import Excel Dependents");
    	 excelDepPage.selectCompany(companyNameDep);
    	 ExtentTestManager.getTest().log(Status.INFO, "Selected the Entity");
    	 excelDepPage.selectLotno(lotNo);
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
