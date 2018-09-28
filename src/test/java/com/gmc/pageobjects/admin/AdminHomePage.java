package com.gmc.pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AdminHomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	private By welcomeText = By.cssSelector("#column-left h5");
	//private By passText = By.id("txtPassword");
	private By 	resendWelcomeEmailLink = By.id("BrokerControl_lnkIndWelcomeMail");
	private By excelImportLink = By.id("BrokerControl_lnkExcelImport");
	private By searchEmpLink = By.id("BrokerControl_lnkGetCard");
	private By searchToResetLink = By.id("BrokerControl_lnkEditEmployee");
	private By resendConfirmationEmailLink = By.id("BrokerControl_lnkBRCnfMail");
	private By bulkEmailLink = By.id("BrokerControl_lnkMails");
	private By excelDepLink = By.id("BrokerControl_lnkExcelDependents");
	private By uploadCertificateLink = By.id("BrokerControl_lnkUpload");
	
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	public void verifySuccessfullLogin(String username) {
		wait.until(ExpectedConditions.presenceOfElementLocated(welcomeText));
		String getWelcomeText = driver.findElement(welcomeText).getText();
		System.out.println("Welcome text - " +getWelcomeText);
		String expectedText = "Welcome "+username;
		System.out.println("Expected Welcome text - " +expectedText);
		Assert.assertEquals(getWelcomeText, expectedText, "Welcome username not correct");
	}
	
	public SendWelcomeEmailPage clickResendWelcomeEmail() {
		wait.until(ExpectedConditions.presenceOfElementLocated(resendWelcomeEmailLink));
		driver.findElement(resendWelcomeEmailLink).click();
		return new SendWelcomeEmailPage(driver);
	}
	public AdminExcelImportPage clickExcelImport() {
		wait.until(ExpectedConditions.presenceOfElementLocated(excelImportLink));
		driver.findElement(excelImportLink).click();
		return new AdminExcelImportPage(driver);
	}
	public AdminSearchEmployeePage clickSearchEmployee() {
		wait.until(ExpectedConditions.presenceOfElementLocated(searchEmpLink));
		driver.findElement(searchEmpLink).click();
		return new AdminSearchEmployeePage(driver);
	}
	public AdminResetEmployeePage clickToResetEmployee() {
		wait.until(ExpectedConditions.presenceOfElementLocated(searchToResetLink));
		driver.findElement(searchToResetLink).click();
		return new AdminResetEmployeePage(driver);
	}
	
	public AdminUpdateDependentsPage clickToUpdateDependents() {
		wait.until(ExpectedConditions.presenceOfElementLocated(searchToResetLink));
		driver.findElement(searchToResetLink).click();
		return new AdminUpdateDependentsPage(driver);
	}
	
	public SendConfirmationEmailPage clickResendConfirmationemail() {
		wait.until(ExpectedConditions.presenceOfElementLocated(resendConfirmationEmailLink));
		driver.findElement(resendConfirmationEmailLink).click();
		return new SendConfirmationEmailPage(driver);
}
	
	public AdminBulkEmailsPage clickBulkEmail() {
		wait.until(ExpectedConditions.presenceOfElementLocated(bulkEmailLink));
		driver.findElement(bulkEmailLink).click();
		return new AdminBulkEmailsPage(driver);
	}
	

	public AdminExcelImportDepPage clickExcelDep() {
		wait.until(ExpectedConditions.presenceOfElementLocated(excelDepLink));
		driver.findElement(excelDepLink).click();
		return new AdminExcelImportDepPage(driver);
	}

	public AdminUploadCertificatePage clickUploadCertificate() {
		wait.until(ExpectedConditions.presenceOfElementLocated(uploadCertificateLink));
		driver.findElement(uploadCertificateLink).click();
		return new AdminUploadCertificatePage(driver);
	}

	
	/*public AdminUploadCertificatePage clickUploadCertificate() {
		wait.until(ExpectedConditions.presenceOfElementLocated(uploadCertificateLink));
		driver.findElement(uploadCertificateLink).click();
		return new AdminUploadCertificatePage(driver);
	}*/
	
}