package com.gmc.pageobjects.admin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendWelcomeEmailPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public SendWelcomeEmailPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	private By welcomeText = By.id("ContentPlaceHolder1_lblHeader");
	private By empIdText = By.id("ContentPlaceHolder1_txtSearchEmpId");
	private By emailID = By.id("ContentPlaceHolder1_txtEmail");
	private By searchBtn = By.id("ContentPlaceHolder1_btnSearch");
	private By sendmailLink = By.cssSelector("tbody td a:contains('send mail')");
	private By successMsg = By.cssSelector("");
	private By failureMsg = By.cssSelector("");
	
	public String welcomeEmailPageText() {
		wait.until(ExpectedConditions.presenceOfElementLocated(welcomeText));
		return driver.findElement(welcomeText).getText();
	}
	
	public void enterEmployeeID(String empID) {
		wait.until(ExpectedConditions.presenceOfElementLocated(empIdText));
		WebElement empId = driver.findElement(empIdText);
		empId.sendKeys(empID);
	}
	
	public void enterEmailID(String strEmailID) {
		wait.until(ExpectedConditions.presenceOfElementLocated(emailID));
		WebElement empId = driver.findElement(empIdText);
		empId.sendKeys(strEmailID);
	}
	
	public void clickSearchbtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(searchBtn));
		driver.findElement(searchBtn).click();
	}
	
	public void sendEmail() {
		wait.until(ExpectedConditions.presenceOfElementLocated(sendmailLink));
		driver.findElement(sendmailLink).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public String getMessage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(successMsg));
		return driver.findElement(successMsg).getText();
	}

}
