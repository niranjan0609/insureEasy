package com.gmc.pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLoginPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	private By emailText = By.id("txtUserName");
	private By passwordText = By.id("txtPassword");
	private By loginBtn = By.id("btnLogin");
	//private By logoImg = By.cssSelector(".logo");
	private By errorMsg = By.id("lblMessage");
	
	public void enterLoginName(String username) {
		wait.until(ExpectedConditions.presenceOfElementLocated(emailText));
		WebElement loginText = driver.findElement(emailText);
				loginText.sendKeys(username);
	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.presenceOfElementLocated(passwordText));
		WebElement passwordElement = driver.findElement(passwordText);
		passwordElement.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));
		driver.findElement(loginBtn).click();
	}

	public AdminHomePage NavigateToHomePage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(loginBtn));
		driver.findElement(loginBtn).click();
		return new AdminHomePage(driver);
	}
	
	public String getErrorMessage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(errorMsg));
		return driver.findElement(errorMsg).getText();
	}
}
