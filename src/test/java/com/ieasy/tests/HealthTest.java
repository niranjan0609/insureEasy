package com.ieasy.tests;

import com.ieasy.base.TestBase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.ieasy.base.ExtentTestManager;
import com.ieasy.pageobjects.HealthPage;
import com.ieasy.pageobjects.HomePage;

import com.ieasy.utils.ExcelReader;
import org.testng.asserts.SoftAssert;

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

	String xlFilePath = "E:\\Selenium\\New IEA\\InsureEasyAutomation\\src\\test\\java\\resources\\InsureEasy_ABHI_Data.xlsx";
	ExcelReader sheet = null;

	public ArrayList<HealthPOJO> testData(String xlFilePath, String sheetName) throws Exception {

		ArrayList<HealthPOJO> dataList = new ArrayList<HealthPOJO>();
		// Object[][] excelData = null;
		sheet = new ExcelReader(xlFilePath);
		int rows = sheet.getRowCount(sheetName);
		int columns = sheet.getColumnCount(sheetName);

		// excelData = new Object[rows - 1][columns];

		for (int i = 1; i < rows; i++) {
			HealthPOJO hPojo = new HealthPOJO();
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
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("300000 SI")) {
					hPojo.set3LacSumInsured(sheet.getCellData(sheetName, j, i));
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("300000 Premium")) {
					hPojo.set3LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("400000 SI")) {
					hPojo.set4lacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("400000 Premium")) {
					hPojo.set4LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("500000 SI")) {
					hPojo.set5LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("500000 Premium")) {
					hPojo.set5LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("700000 SI")) {
					hPojo.set7LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("700000 Premium")) {
					hPojo.set7LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("1000000 SI")) {
					hPojo.set10LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("1000000 Premium")) {
					hPojo.set10LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("1500000 SI")) {
					hPojo.set15LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("1500000 Premium")) {
					hPojo.set15LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("2000000 SI")) {
					hPojo.set20LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("2000000 Premium")) {
					hPojo.set20LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("2500000 SI")) {
					hPojo.set25LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("2500000 Premium")) {
					hPojo.set25LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("3000000 SI")) {
					hPojo.set30LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("3000000 Premium")) {
					hPojo.set30LacPremium(sheet.getCellData(sheetName, j, i));	
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("4000000 SI")) {
					hPojo.set40LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("4000000 Premium")) {
					hPojo.set40LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("5000000 SI")) {
					hPojo.set50LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("5000000 Premium")) {
					hPojo.set50LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("7500000 SI")) {
					hPojo.set75LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("7500000 Premium")) {
					hPojo.set75LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("10000000 SI")) {
					hPojo.set100LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("10000000 Premium")) {
					hPojo.set100LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("15000000 SI")) {
					hPojo.set150LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("15000000 Premium")) {
					hPojo.set150LacPremium(sheet.getCellData(sheetName, j, i));
				}else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("20000000 SI")) {
					hPojo.set200LacSumInsured(sheet.getCellData(sheetName, j, i));	
				} else if (sheet.getCellData(sheetName, j, 0).equalsIgnoreCase("20000000 Premium")) {
					hPojo.set200LacPremium(sheet.getCellData(sheetName, j, i));
				}
				
			}
			dataList.add(hPojo);
		}
		return dataList;
	}

	@DataProvider(name = "abhiinsuranceData")
	public Object[][] healthDataProvider() throws Exception {
		ArrayList<HealthPOJO> healthDataList = testData(xlFilePath, "Sheet1");
		int j = healthDataList.size();
		Object[][] obj = new Object[j][1];
		for (int i = 0; i < j; i++) {
			obj[i][0] = healthDataList.get(i);
		}
		return obj;
	}

	@Test(dataProvider = "abhiinsuranceData")
	public void diamondPlanIndividual(HealthPOJO pojoData) throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		Actions action = new Actions(driver);
		HealthPage healthPage = homePage.clickHealth();
		healthPage.clickHealthInsurance();
		String part1 = pojoData.getPinCode().substring(0, 4);
		String part2 = pojoData.getPinCode().substring(4);
		healthPage.enterPinCode(part1, true);
		Thread.sleep(3000);
		healthPage.enterPinCode(part2, false);
		healthPage.selectFirstPinValue();
		action.sendKeys(Keys.ESCAPE).perform();
		Thread.sleep(3000);
		healthPage.enterMobileNo(pojoData.getMobileNumber());
		healthPage.emailId(pojoData.getEmailId());
		healthPage.clickNextBtn();
		Thread.sleep(3000);
		healthPage.CloseSonOption();
		healthPage.CloseDaughterOption();
		healthPage.CloseWifeOption();
		healthPage.enterSelfAge(pojoData.getSelfAge());
		healthPage.clickGetQuote();
	
		String sumI = healthPage.getSumAssuredValue();
		String SumInsuredValue = sumI.trim();
		String premiumValue = healthPage.getQuoteValue();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(SumInsuredValue, pojoData.get3LacSumInsured(), "Sum insured value not correct");
		softAssert.assertEquals(premiumValue, pojoData.get3LacPremium(), "Actual premium value not matching with expected");
		
		healthPage.changeSI("400000");
	    String SI = healthPage.getSumAssuredValue();
		String SumInsured4lac = SI.trim();
		String premium4lac = healthPage.getQuoteValue();
		SoftAssert softAssert1 = new SoftAssert();
		
		softAssert1.assertEquals(SumInsured4lac, pojoData.get4LacSumInsured(), "Sum insured value not correct");
		softAssert1.assertEquals(premium4lac, pojoData.get4LacPremium(), "Actual premium value not matching with expected");
		
		healthPage.deleteAllCookies();
		healthPage.backHome();
	
		
		healthPage.startFrom();
		softAssert.assertAll();
	}
}
