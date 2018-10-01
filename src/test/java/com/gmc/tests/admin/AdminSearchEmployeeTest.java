package com.gmc.tests.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;
import com.gmc.pageobjects.admin.AdminSearchEmployeePage;


public class AdminSearchEmployeeTest extends TestBase{

	
	private WebDriver driver;

	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
    public AdminSearchEmployeePage searchPage;
		
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
    
	@Test(priority = 0,  enabled = false)
		public void searchEmp() throws InterruptedException {
			searchPage = homePage.clickSearchEmployee();
			searchPage.enterEmployeeID("9005");
			Thread.sleep(2000);
			searchPage.clickSearchbtn();
			searchPage.clickViewbtn();
			Thread.sleep(3000);
			}
		
	@Test(priority = 1, enabled = false) //enabled = false;
	public void downloadEcard() throws InterruptedException {
		searchPage = homePage.clickSearchEmployee();
		searchPage.enterEmployeeID("9005");
		Thread.sleep(2000);
		searchPage.clickSearchbtn();
		searchPage.clickViewbtn();
		Thread.sleep(2000);
		searchPage.ClickDownloadEcard();
		Thread.sleep(3000);
		}
	
	@Test(priority = 2, enabled = false)
	public void ChangeMobileNo() throws InterruptedException {
		searchPage = homePage.clickSearchEmployee();
		searchPage.enterEmployeeID("9005");
		Thread.sleep(2000);
		searchPage.clickSearchbtn();
		searchPage.clickViewbtn();
		Thread.sleep(2000);
		searchPage.InsertCountryCode("91");
		searchPage.InsertMobileNo("9823465631");
		searchPage.clickChangeMobileNoBtn();
		Thread.sleep(3000);
		}
	
	@Test(priority = 2)
	public void ChangeEmailID() throws InterruptedException {
		searchPage = homePage.clickSearchEmployee();
		searchPage.enterEmployeeID("9005");
		Thread.sleep(2000);
		searchPage.clickSearchbtn();
		searchPage.clickViewbtn();
		Thread.sleep(2000);
		searchPage.InsertEmailId("praveen.b@isbsindia.in");
		searchPage.clickUpdateEmailIDBtn();
		Thread.sleep(3000);
		}
	
		@AfterClass
		public void tearDown() {
			if(driver!=null) {
				driver.quit();
				}
                }
}