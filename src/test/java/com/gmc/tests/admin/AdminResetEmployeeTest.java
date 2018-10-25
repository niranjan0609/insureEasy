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
import com.gmc.pageobjects.admin.AdminResetEmployeePage;
import com.gmc.utils.PropertyFileReader;


public class AdminResetEmployeeTest extends TestBase {
	private WebDriver driver;

	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
    public AdminResetEmployeePage resetPage;
    
    String adminURL = PropertyFileReader.getInstance().getAdminURL();
    String validUsername = PropertyFileReader.getInstance().getUsername();
    String validPassword = PropertyFileReader.getInstance().getPassword();
    String usernameToReset = PropertyFileReader.getInstance().getUserNameToReset();
		
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
		public void searchEmp() throws InterruptedException  {
			resetPage = homePage.clickToResetEmployee();
			ExtentTestManager.getTest().log(Status.INFO, "After Successful Login, Clicked on Reset Employee");
			resetPage.enterEmployeeID(usernameToReset);
			ExtentTestManager.getTest().log(Status.INFO, "Enter Employee ID to Reset");
			Thread.sleep(2000);
			resetPage.clickSearchbtn();
			ExtentTestManager.getTest().log(Status.INFO, "Clicked on Search Button");
			resetPage.clickViewbtn();
			ExtentTestManager.getTest().log(Status.INFO, "After record is fetched, Clicked on View Button");
			//resetPage.clickResetbtn();
			Thread.sleep(3000);
			}
		
		@AfterClass
		public void tearDown() {
			if(driver!=null) {
				driver.quit();
				}
                }

}
