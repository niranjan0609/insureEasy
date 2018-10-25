package com.gmc.tests.member;

import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gmc.base.ExtentTestManager;
import com.gmc.base.TestBase;
import com.gmc.pageobjects.member.MemberEnrollmentPage;
import com.gmc.pageobjects.member.MemberHomePage;
import com.gmc.pageobjects.member.MemberLoginPage;
import com.gmc.utils.ExcelReader;

public class MemberEnrollmentTest extends TestBase {

	private WebDriver driver;
	private MemberEnrollmentPage enrollPage;
	public MemberLoginPage loginPage;
	public MemberHomePage homePage;
	 Object[][] data;
	 Object[][] excelData;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
		String URL = driver.getCurrentUrl();
		driver.get(URL);
		loginPage = new MemberLoginPage(driver);
		loginPage.enterUserId("19007");
		loginPage.enterPassword("06061995");
		homePage = loginPage.NavigateToHomePage();
		homePage.clickNextBtnAfterLogin();
	}


	@Test(enabled = false)
	public void DownloadEcard() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Started Download E-card Test");
		enrollPage = homePage.NavigateEnrollmentPage();
		enrollPage.clickEcard();
		
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Download E-card");
	}

	@Test(enabled = false)
	public void VerifyNetworkHospitalsLink() throws InterruptedException {
		ExtentTestManager.getTest().log(Status.INFO, "Started Network Hospitals List");
		enrollPage = homePage.NavigateEnrollmentPage();
		String parentWindow = driver.getWindowHandle();
		enrollPage.clickNetworkHospitals();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Network Hospitals");
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				driver.close(); // closing child window
				driver.switchTo().window(parentWindow);
			}
			Thread.sleep(3000);
		}
	}

	@Test(enabled = false)
	public void VerifyPolicyDetailsLink() throws InterruptedException {
		enrollPage = homePage.NavigateEnrollmentPage();
		String parentWindow = driver.getWindowHandle();
		enrollPage.clickPolicyDetailsBtn();
		Thread.sleep(3000);
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Policy Details");
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				driver.close(); // closing child window
				driver.switchTo().window(parentWindow);
			}
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 0 ,enabled = false)
	public void VerifyGuidelinesLink() throws InterruptedException {
		enrollPage = homePage.NavigateEnrollmentPage();
		enrollPage.clickGuidelinesBtn();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Guidelines" );
		}
	
	@Test(priority = 1 ,enabled = false)
	public void VerifyFAQLink() throws InterruptedException {
		enrollPage = homePage.NavigateEnrollmentPage();
		enrollPage.clickFAQBtn();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on FAQ" );
		}
	
	@Test(priority = 2 ,enabled = false)
	public void VerifyContactUsLink() throws InterruptedException {
		enrollPage = homePage.NavigateEnrollmentPage();
		enrollPage.clickContactUsBtn();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Contact Us" );
		}
	@Test(priority = 3 , enabled = true)
	public void VerifyLogoutLink() throws InterruptedException {
		enrollPage = homePage.NavigateEnrollmentPage();
		enrollPage.clickLogoutBtn();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Log Out" );
		String message  = enrollPage.getSuccessMessageForLogout();
        assertTrue(message.equals("Employee GEID:"));
        ExtentTestManager.getTest().log(Status.INFO, "Successfully logged off" );
		}
	
	
	String xlFilePath = "D://Dependents_data.xlsx";
	ExcelReader sheet = null;

	public Object[][] testData(String xlFilePath, String sheetName) throws Exception {
		excelData = null;
		sheet = new ExcelReader(xlFilePath);
		int rows = sheet.getRowCount(sheetName);
		int columns = sheet.getColumnCount(sheetName);

		excelData = new Object[rows - 1][columns];

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				excelData[i - 1][j] = sheet.getCellData(sheetName, j, i);
			}
		}
		return excelData;
	}


	@Test(enabled = false)
	public void addDependents() throws Exception {
		enrollPage = homePage.NavigateEnrollmentPage();
		excelData = testData(xlFilePath, "Sheet1");
		int excelDataSize = excelData.length;
		int dependentsRowSize = enrollPage.getDependentsRowCount();
		ExtentTestManager.getTest().log(Status.INFO, "Adding dependents data");
		if (excelDataSize <= dependentsRowSize) {
			for(int i=0; i<excelDataSize; i++) {
				enrollPage.enterDependentName(i, excelData[i][0].toString());
				enrollPage.enterDependentDateOfBirth(i, excelData[i][1].toString());
				enrollPage.enterDependentMonthOfBirth(i, excelData[i][2].toString());
				enrollPage.enterDependentYearOfBirth(i, excelData[i][3].toString());
				enrollPage.enterDependentRelationship(i, excelData[i][4].toString());
			}

		} else {
			System.out.println("Excel data should not exceed dependents row count");
		}

	}


	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
