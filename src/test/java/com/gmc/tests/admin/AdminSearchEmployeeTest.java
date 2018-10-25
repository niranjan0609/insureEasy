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
import com.gmc.pageobjects.admin.AdminSearchEmployeePage;
import com.gmc.utils.PropertyFileReader;


public class AdminSearchEmployeeTest extends TestBase{

	
	private WebDriver driver;

	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
    public AdminSearchEmployeePage searchPage;
    
    String adminURL = PropertyFileReader.getInstance().getAdminURL();
    String validUsername = PropertyFileReader.getInstance().getUsername();
    String validPassword = PropertyFileReader.getInstance().getPassword();
    String usernameToSearch = PropertyFileReader.getInstance().getUserNameToSearch();
    String countryCode = PropertyFileReader.getInstance().getCountryCode();
    String mobileNo = PropertyFileReader.getInstance().getMobileNo();
    String changeEmailID = PropertyFileReader.getInstance().getEmailID();
    
		
    @BeforeClass
		public void setUp() {
			driver=getDriver();
			driver.get(adminURL);
			loginPage = new AdminLoginPage(driver);
			loginPage.enterLoginName(validUsername);
			loginPage.enterPassword(validPassword);
			homePage = loginPage.NavigateToHomePage();
		}
    
	@Test(priority = 0,  enabled = true)
		public void searchEmp() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Clicking on Search Employee after successful login");
		    searchPage = homePage.clickSearchEmployee();
			searchPage.enterEmployeeID(usernameToSearch);
			ExtentTestManager.getTest().log(Status.INFO, "Entered Employee ID to be searched");
			Thread.sleep(2000);
			searchPage.clickSearchbtn();
			ExtentTestManager.getTest().log(Status.INFO, "Clicking on View Button");
			searchPage.clickViewbtn();
			Thread.sleep(3000);
			}
		
	@Test(priority = 1, enabled = false) 
	public void downloadEcard() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Clicking on Search Employee after successful Login");
		searchPage = homePage.clickSearchEmployee();
		searchPage.enterEmployeeID(usernameToSearch);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Emp ID to search");
		Thread.sleep(2000);
		searchPage.clickSearchbtn();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on search Button");
		searchPage.clickViewbtn();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on View Employee");
		searchPage.ClickDownloadEcard();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "E-card is Downloaded Successfully");
		}
	
	@Test(priority = 2, enabled = false)
	public void ChangeMobileNo() throws InterruptedException {
		searchPage = homePage.clickSearchEmployee();
		ExtentTestManager.getTest().log(Status.INFO, "Clicking on Search Employee after successful Login");
		searchPage.enterEmployeeID(usernameToSearch);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Emp ID to search");
		Thread.sleep(2000);
		searchPage.clickSearchbtn();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on search Button");
		searchPage.clickViewbtn();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on View Employee");
		searchPage.InsertCountryCode(countryCode);
		searchPage.InsertMobileNo(mobileNo);
		searchPage.clickChangeMobileNoBtn();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Valid Mobile number along with the Country code and Confirm");
		}
	
	@Test(priority = 2)
	public void ChangeEmailID() throws InterruptedException {
		searchPage = homePage.clickSearchEmployee();
		ExtentTestManager.getTest().log(Status.INFO, "Clicking on Search Employee after successful Login");
		searchPage.enterEmployeeID(usernameToSearch);
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Emp ID to search");
		searchPage.clickSearchbtn();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on search Button");
		searchPage.clickViewbtn();
		Thread.sleep(2000);
		ExtentTestManager.getTest().log(Status.INFO, "Click on View Employee");
		searchPage.InsertEmailId(changeEmailID);
		searchPage.clickUpdateEmailIDBtn();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Valid Email ID and Confirm");

		}
	
		@AfterClass
		public void tearDown() {
			if(driver!=null) {
				driver.quit();
				}
                }
}