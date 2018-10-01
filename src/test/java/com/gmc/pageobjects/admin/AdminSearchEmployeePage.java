package com.gmc.pageobjects.admin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminSearchEmployeePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public AdminSearchEmployeePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	private By empIdText = By.name("ctl00$ContentPlaceHolder1$txtSearchEmpId");
	private By emailID = By.name("ctl00$ContentPlaceHolder1$txtEmail");
	private By searchBtn = By.name("ctl00$ContentPlaceHolder1$btnSearch");
	private By viewBtn = By.xpath("/html/body/form/div[3]/div[2]/div[2]/div/div/div/table[2]/tbody[2]/tr/td[5]/a");
	private By dwnldBtn = By.id("ContentPlaceHolder1_rptCardData_lnkGetEcard_0");
	private By countrycodeText = By.id("ContentPlaceHolder1_txtCountryCode");
	private By mobNoText = By.id("ContentPlaceHolder1_txtMobileNo1");
	private By ChangeMobilenoBtn = By.id("ContentPlaceHolder1_btnUpdateMobileNo1");
	private By ChangeEmailText = By.id("ContentPlaceHolder1_txtEmpEmail");
    private By updatEmailBtn = By.id("ContentPlaceHolder1_btnAltEmail");
    
	public void enterEmployeeID(String empID) {
		wait.until(ExpectedConditions.presenceOfElementLocated(empIdText));
		WebElement empId = driver.findElement(empIdText);
		empId.sendKeys(empID);
	}
	
	public void enterEmailID(String strEmailID) {
		wait.until(ExpectedConditions.presenceOfElementLocated(emailID));
		WebElement empId = driver.findElement(emailID);
		empId.sendKeys(strEmailID);
	}  
	
	public void clickSearchbtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(searchBtn));
		driver.findElement(searchBtn).click();
	}
	
	public void clickViewbtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(viewBtn));
		driver.findElement(viewBtn).click();
	}
	
public void ClickDownloadEcard() throws InterruptedException{
	wait.until(ExpectedConditions.presenceOfElementLocated(dwnldBtn));
	driver.findElement(dwnldBtn).click();
	Thread.sleep(3000);
	Alert alert = driver.switchTo().alert();
	alert.accept();
}

public void InsertCountryCode(String ccode){
	wait.until(ExpectedConditions.presenceOfElementLocated(countrycodeText));
	WebElement empId = driver.findElement(countrycodeText);
	empId.sendKeys(ccode);
	
}

public void InsertMobileNo(String mNo){
	wait.until(ExpectedConditions.presenceOfElementLocated(mobNoText));
	WebElement empId = driver.findElement(mobNoText);
	empId.sendKeys(mNo);
	
}

public void clickChangeMobileNoBtn() throws InterruptedException {
	wait.until(ExpectedConditions.presenceOfElementLocated(ChangeMobilenoBtn));
	driver.findElement(ChangeMobilenoBtn).click();
	Thread.sleep(2000);
	
}

public void InsertEmailId(String EmailID){
	wait.until(ExpectedConditions.presenceOfElementLocated(ChangeEmailText));
	WebElement empId = driver.findElement(ChangeEmailText);
	empId.sendKeys(EmailID);
	
}

public void clickUpdateEmailIDBtn() throws InterruptedException {
	wait.until(ExpectedConditions.presenceOfElementLocated(updatEmailBtn));
	driver.findElement(updatEmailBtn).click();
	Thread.sleep(2000);
	
}


}
