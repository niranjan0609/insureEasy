package com.gmc.pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUploadCertificatePage {
	private WebDriver driver;
	private WebDriverWait wait;
	public String returnComp;

	public AdminUploadCertificatePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	private By chooseFileLink = By.id("ContentPlaceHolder1_fupMarCer");
	private By uploadBtnLink = By.id("ContentPlaceHolder1_btnFileSave");
	private By cancelBtnLink = By.id("ContentPlaceHolder1_btnCancel");
	
	String filePath = "D://sample.pdf";


	public void clickcancelbtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(cancelBtnLink));
		WebElement upldbtn = driver.findElement(cancelBtnLink);
		upldbtn.click();
	}

	public void uploadFile() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(chooseFileLink));
		WebElement fileupload = driver.findElement(chooseFileLink);
		fileupload.sendKeys(filePath);
		Thread.sleep(2000);
		
	}

	public void clickuploadbtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(uploadBtnLink));
		WebElement upldbtn = driver.findElement(uploadBtnLink);
		upldbtn.click();
	}

}
