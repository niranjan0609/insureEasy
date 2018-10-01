package com.gmc.tests.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;
import com.gmc.pageobjects.admin.SendWelcomeEmailPage;
import com.gmc.utils.ExcelReader;

public class SendWelcomeEmailTest extends TestBase{
	
	private WebDriver driver;
	private String pageHeadertext = "Welcome Mail";
	private String errorMessage = "Mail not sent";
	private String SuccessMessage = "Mail sent successfully.";
	public AdminLoginPage loginPage;
	public AdminHomePage homePage;

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

	String xlFilePath = "D://EmpData.xlsx";
	ExcelReader sheet = null;

	public Object[][] testData(String xlFilePath, String sheetName) throws Exception {
		Object[][] excelData = null;
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

	@DataProvider(name="userData")
    public Object[][] userFormData() throws Exception  {
        Object[][] data = testData(xlFilePath, "Sheet1");
        return data;
    }

	
	@Test(dataProvider = "userData")
	public void sendEmail(String employeeId) {
		SendWelcomeEmailPage emailPage = homePage.clickResendWelcomeEmail();
		String pageText = emailPage.welcomeEmailPageText();
		Assert.assertTrue(pageHeadertext.equals(pageText), "Welcome Email Page is not correct");
		emailPage.enterEmployeeID(employeeId);
		emailPage.clickSearchbtn();
		emailPage.sendEmail();
		String actualMsg = emailPage.getMessage();
		Assert.assertTrue(actualMsg.equals(SuccessMessage), "Failure message");
	}
	
	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
