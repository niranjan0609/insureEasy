package com.gmc.pageobjects.member;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MemberMyProfilePage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public MemberMyProfilePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	private By newPswdLink = By.id("ContentPlaceHolder1_txtPassword");
	private By confirmPswdLink = By.id("ContentPlaceHolder1_txtConfirmPwd");
	private By updatePswdBtn = By.id("ContentPlaceHolder1_btnUpdatePassword");
	private By mobileNoLink = By.id("ContentPlaceHolder1_txtMobileNo");
	private By updateMobileBtn = By.id("ContentPlaceHolder1_btnUpdateMobileNo");
	private By alternateEmailLink = By.id("ContentPlaceHolder1_txtAltEmail");
	private By updateemailBtn = By.id("ContentPlaceHolder1_btnAltEmail");
	private By nextBtn = By.id("ContentPlaceHolder1_btnAccpet");
	
	
	
	public MemberMyProfilePage NavigateToProfilePage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(nextBtn));
		driver.findElement(nextBtn).click();
		return new MemberMyProfilePage (driver);
	}

	
	public void enterNewPassword(String newPassword) {
		wait.until(ExpectedConditions.presenceOfElementLocated(newPswdLink));
		WebElement mob = driver.findElement(newPswdLink);
		mob.sendKeys(newPassword);
	}
	
	public void confirmNewPassword(String confirmPassword) {
		wait.until(ExpectedConditions.presenceOfElementLocated(confirmPswdLink));
		WebElement mob = driver.findElement(confirmPswdLink);
		mob.sendKeys(confirmPassword);
	}
	
	public void clickUpdatePasswordBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(updatePswdBtn));
		driver.findElement(updatePswdBtn).click();
	}

	public void enterMobileNo(String mobNo) {
		wait.until(ExpectedConditions.presenceOfElementLocated(mobileNoLink));
		WebElement dname = driver.findElement(mobileNoLink);
		dname.sendKeys(mobNo);
	}
	
	public void clickUpdateMobileNoBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(updateMobileBtn));
		driver.findElement(updateMobileBtn).click();
	}
	
	public void enterAlternateEmail(String emailID) {
		wait.until(ExpectedConditions.presenceOfElementLocated(alternateEmailLink));
		WebElement eid = driver.findElement(alternateEmailLink);
		eid.sendKeys(emailID);
	}
	
	public void clickUpdateAlternateEmailBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(updateemailBtn));
		driver.findElement(updateemailBtn).click();
	}
		
}


