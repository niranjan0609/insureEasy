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
	
}
