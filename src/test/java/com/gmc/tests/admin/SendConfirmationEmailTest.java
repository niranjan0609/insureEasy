package com.gmc.tests.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.gmc.base.ExtentTestManager;
import com.gmc.base.TestBase;
import com.gmc.pageobjects.admin.AdminHomePage;
import com.gmc.pageobjects.admin.AdminLoginPage;
import com.gmc.pageobjects.admin.SendConfirmationEmailPage;
import com.gmc.utils.ExcelReader;
import com.gmc.utils.PropertyFileReader;

public class SendConfirmationEmailTest extends TestBase {
	private WebDriver driver;
	private String pageHeadertext = "Welcome Mail";
	private String errorMessage = "Mail not sent";
	private String SuccessMessage = "Mail sent successfully.";
	public AdminLoginPage loginPage;
	public AdminHomePage homePage;
	public SendConfirmationEmailPage emailPage;
	
	String validUsername = PropertyFileReader.getInstance().getUsername();
	String validPassword = PropertyFileReader.getInstance().getPassword();
    String adminURL = PropertyFileReader.getInstance().getAdminURL();
    String xlFilePath = PropertyFileReader.getInstance().getExcelFile();
    String lotNoBulk = PropertyFileReader.getInstance().getlotNoBulk();
    String emailType = PropertyFileReader.getInstance().getEmailType();

		@BeforeClass
		public void setUp() {
			driver=getDriver();
			driver.get(adminURL);
			loginPage = new AdminLoginPage(driver);
			loginPage.enterLoginName(validUsername);
			loginPage.enterPassword(validPassword);
			homePage = loginPage.NavigateToHomePage();
		}

	//String xlFilePath = "D://EmpData.xlsx";
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
		SendConfirmationEmailPage emailPage = homePage.clickResendConfirmationemail();
		ExtentTestManager.getTest().log(Status.INFO, "Clicked on Resend Confirmation  Email after successful Login ");
		emailPage.enterEmployeeID(employeeId);
		ExtentTestManager.getTest().log(Status.INFO, "Entered Emp ID's to send Confirmation Email");
		emailPage.clickSearchbtn();
		emailPage.sendEmail();
	    ExtentTestManager.getTest().log(Status.INFO, "Confirmation Emails sent to the selected Employees");
	}
	
	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			driver.quit();

                 }
}
}