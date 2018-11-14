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

import com.gmc.pageobjects.admin.AdminUpdateDependentsPage;
import com.gmc.utils.PropertyFileReader;

public class AdminUpdateDependentsTest extends TestBase
{
	private WebDriver driver;

	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
    public AdminUpdateDependentsPage updatePage;
    
    String validUsername = PropertyFileReader.getInstance().getUsername();
	String validPassword = PropertyFileReader.getInstance().getPassword();
    String adminURL = PropertyFileReader.getInstance().getAdminURL();
    String usernameToSearch = PropertyFileReader.getInstance().getUserNameToSearch();
    String changeName = PropertyFileReader.getInstance().getName();
    String changeDay = PropertyFileReader.getInstance().getDayDOB();
    String changeMon = PropertyFileReader.getInstance().getMOnDOB();
    String changeYear = PropertyFileReader.getInstance().getYearDOB();
    String changeRelationship = PropertyFileReader.getInstance().getRelationship();
    String enterRemarks = PropertyFileReader.getInstance().getRemarks();


    
		
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
		public void searchEmp() throws InterruptedException {
			updatePage = homePage.clickToUpdateDependents();
			ExtentTestManager.getTest().log(Status.INFO, "Clicked on Update Dependents after successful login");
			updatePage.enterEmployeeID(usernameToSearch);
			Thread.sleep(2000);
			ExtentTestManager.getTest().log(Status.INFO, "Entered Emp ID to edit dependents after successful Login ");
			updatePage.clickSearchbtn();
			updatePage.clickViewbtn();
			Thread.sleep(3000);
			ExtentTestManager.getTest().log(Status.INFO, "Clicking on Search Employee after successful Login ");
			updatePage.clickEditdependent();
			updatePage.changeName(changeName);
			updatePage.changeDay(changeDay);
			updatePage.changeMon(changeMon);
			updatePage.changeYear(changeYear);
			updatePage.changeRelationship(changeRelationship);
			updatePage.EnterCorrectionRemarks(enterRemarks);
			updatePage.clickOnSubmit();
			ExtentTestManager.getTest().log(Status.INFO, "After editing dependents, entered correction remarks and submitted ");
			}
		
		@AfterClass
		public void tearDown() {
			if(driver!=null) {
				driver.quit();
				}
		}
}
