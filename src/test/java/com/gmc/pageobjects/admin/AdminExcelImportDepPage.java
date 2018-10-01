package com.gmc.pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminExcelImportDepPage {

	private WebDriver driver;
	private WebDriverWait wait;
    public String returnComp;
	public AdminExcelImportDepPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
}

	private By compDropdown = By.id("ContentPlaceHolder1_ddlCompany");
	private By lotno = By.id("ContentPlaceHolder1_ddlLotNo");
	private By chooseFileLink = By.id("ContentPlaceHolder1_fupEnroll");
	private By uploadBtn = By.name("ContentPlaceHolder1_btnUpload");


	String filePath = "D://ExcelImportDep.xlsx";
	

    public void selectCompany(String CompanyName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(compDropdown));
		Select compname = new Select(driver.findElement(compDropdown));
	    compname.selectByVisibleText(CompanyName);
	    
	}
	
    public void selectLotno(String lotnumber) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(lotno));
		Select lnum = new Select(driver.findElement(lotno));
		lnum.selectByVisibleText(lotnumber);
		
		Thread.sleep(3000);
	}
    
	public void uploadExcelFile() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(chooseFileLink));
		WebElement fileupload = driver.findElement(chooseFileLink);
		fileupload.sendKeys(filePath);
		Thread.sleep(2000);

	}

    public void clickUploadBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(uploadBtn));
		WebElement sendbtn = driver.findElement(uploadBtn);
		sendbtn.click();
	}

		
	}


