package com.gmc.pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminExcelImportPage {
	private WebDriver driver;
	private WebDriverWait wait;
    public String returnComp;
	public AdminExcelImportPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
}
	private By excelImportText = By.id("BrokerControl_lnkExcelImport");
	private By compDropdown = By.name("ctl00$ContentPlaceHolder1$ddlCompany");
	private By enrollFromDate = By.name("ContentPlaceHolder1_txtEmail");
	private By enrollToDate = By.name("ctl00$ContentPlaceHolder1$txtEnrollTo");
	private By chooseFileLink = By.name("ctl00$ContentPlaceHolder1$fupEnroll");
	private By uploadBtnLink = By.name("ctl00$ContentPlaceHolder1$btnUpload");
	

	public String getExcelImportPageText() {
		wait.until(ExpectedConditions.presenceOfElementLocated(excelImportText));
		return driver.findElement(excelImportText).getText();
	}
	
    public void selectCompany(String CompanyName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(compDropdown));
		Select compname = new Select(driver.findElement(compDropdown));
	    compname.selectByVisibleText(CompanyName);
	    
	}
	
    public void enterEnrollFromDate(String enFromDate) {
		wait.until(ExpectedConditions.presenceOfElementLocated(enrollFromDate));
		WebElement empId = driver.findElement(enrollFromDate);
		empId.sendKeys(enFromDate);
	}

    public void enterEnrollToDate(String enToDate) {
		wait.until(ExpectedConditions.presenceOfElementLocated(enrollToDate));
		WebElement empId = driver.findElement(enrollToDate);
		empId.sendKeys(enToDate);
	}
    
    public void uploadExcelFile( String filepath){
    	wait.until(ExpectedConditions.presenceOfElementLocated(chooseFileLink));
    	WebElement fileupload = driver.findElement(chooseFileLink);
    	fileupload.sendKeys(filepath);
    }

    public void clickuploadbtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(uploadBtnLink));
		driver.findElement(uploadBtnLink).click();
	}


}
