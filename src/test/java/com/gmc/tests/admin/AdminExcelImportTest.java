package com.gmc.tests.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminExcelImportPage;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;


public class AdminExcelImportTest extends TestBase {
	private String excelPageHeadertext = "Excel Import";
	private WebDriver driver;
	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
	public AdminExcelImportPage excelPage;
	
	@BeforeClass
	public void setUp() {
		driver=getDriver();
		String URL = driver.getCurrentUrl() + "admin";
		driver.get(URL);
		loginPage = new AdminLoginPage(driver);
		loginPage.enterLoginName("citibr");
		loginPage.enterPassword("qaz456");
		homePage = loginPage.NavigateToHomePage();
		homePage.verifySuccessfullLogin("BR LOGIN");
	}

String FilePath = "D://ExcelImport.xlsx";

     @Test
 	 public void excelImport() throws InterruptedException {
    	 excelPage = homePage.clickExcelImport();
    	 excelPage.selectCompany("CITIBANK N A");
       	 excelPage.uploadExcelFile();
    	 excelPage.enterEnrollFromDate("09-26-2018");
    	 excelPage.enterEnrollToDate("10-10-2018");
         excelPage.clickuploadbtn();
    	 Thread.sleep(3000);
    	 
    	}
     
  
@AfterClass
public void tearDown() {
	if(driver!=null) {
		driver.quit();
}
}

}
