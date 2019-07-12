package com.ieasy.tests;

import com.ieasy.base.TestBase;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.ieasy.base.ExtentTestManager;
import com.ieasy.pageobjects.HealthPage;
import com.ieasy.pageobjects.HomePage;

import com.ieasy.utils.ExcelReader;

public class HealthTest extends TestBase {
	private WebDriver driver;
	private static ExtentTest test;


	@BeforeClass
	public void setUp() {
		driver = getDriver();
		String URL = driver.getCurrentUrl();
		driver.get(URL);
		test = ExtentTestManager.getTest();
	}

	String xlFilePath = "E:/Selenium/InsureEasy_ABHI_Data.xlsx";
	ExcelReader sheet = null;

	public ArrayList<HealthPOJO> testData(String xlFilePath, String sheetName) throws Exception {
		HealthPOJO hPojo = new HealthPOJO();
		ArrayList<HealthPOJO> dataList = new ArrayList<HealthPOJO>();
		// Object[][] excelData = null;
		sheet = new ExcelReader(xlFilePath);
		int rows = sheet.getRowCount(sheetName);
		int columns = sheet.getColumnCount(sheetName);

		// excelData = new Object[rows - 1][columns];

		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				// excelData[i - 1][j] = sheet.getCellData(sheetName, j, i);
				if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("PinCode")) {
					hPojo.setPinCode(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Mobile Number")) {
					hPojo.setMobileNumber(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Email ID")) {
					hPojo.setEmailId(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("Self Age")) {
					hPojo.setSelfAge(sheet.getCellData(sheetName, j, i));
				} 
            }
			dataList.add(hPojo);
		}
		return dataList;
	}
	
	  @DataProvider(name="abhiinsuranceData")
	  public Object[][] healthDataProvider() throws Exception {
		  ArrayList<HealthPOJO> healthDataList = testData(xlFilePath, "Sheet1");
		  int j = healthDataList.size();
		  Object[][] obj = new Object[j][1];
		  for (int i=0;i<j;j++) {
			  obj[i][0] = healthDataList.get(i);
		  }
		return obj;
		  
	  }

	@Test(dataProvider = "abhiinsuranceData")
	public void testHealth(HealthPOJO pojoData) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		HealthPage healthPage = homePage.clickHealth();

		healthPage.clickHealthInsurance();
		Thread.sleep(3000);
		healthPage.enterPinCode(pojoData.getPinCode());
		Thread.sleep(3000);
		healthPage.enterMobileNo(pojoData.getMobileNumber());
		healthPage.emailId(pojoData.getEmailId());
		
		healthPage.clickNextBtn();
		healthPage.CloseSonOption();
		healthPage.CloseDaughterOption();
		healthPage.CloseWifeOption();
		Thread.sleep(3000);
		healthPage.enterSelfAge(pojoData.getSelfAge());
		
		healthPage.clickGetQuote();
	}
		
		


}
