package com.gmc.tests.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;
import com.gmc.pageobjects.admin.AdminResetEmployeePage;


public class AdminResetEmployeeTest extends TestBase {
	private WebDriver driver;

	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
    public AdminResetEmployeePage resetPage;
		
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
		public void searchEmp() throws InterruptedException  {
			resetPage = homePage.clickToResetEmployee();
			resetPage.enterEmployeeID("inc3248");
			Thread.sleep(2000);
			resetPage.clickSearchbtn();
			resetPage.clickViewbtn();
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
