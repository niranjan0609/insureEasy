package com.gmc.pageobjects.member;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MemberUploadCertificatePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MemberUploadCertificatePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	private By chooseFileLink = By.id("ContentPlaceHolder1_fupMarCer");
	private By uploadBtn = By.id("ContentPlaceHolder1_btnFileSave");
	private By cancelBtn = By.id("ContentPlaceHolder1_Button1");
	private By nextBtn = By.id("ContentPlaceHolder1_btnAccpet");
	
	String uploadFilepath = "D://131231.pdf";

	
	public MemberUploadCertificatePage NavigateToUploadCertificatePage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(nextBtn));
		driver.findElement(nextBtn).click();
		return new MemberUploadCertificatePage (driver);
	}

	
	public void uploadFile() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(chooseFileLink));
		WebElement fileupload = driver.findElement(chooseFileLink);
		fileupload.sendKeys(uploadFilepath);
		Thread.sleep(2000);
	}
	
	public void clickUploadBtn() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(uploadBtn));
		driver.findElement(uploadBtn).click();
		Thread.sleep(5000);
		//driver.switchTo().alert().accept();
	}


	public void clickCancelBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(cancelBtn));
		driver.findElement(cancelBtn).click();
	}
	
		
}
