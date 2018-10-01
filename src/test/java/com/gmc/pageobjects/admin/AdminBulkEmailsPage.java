package com.gmc.pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminBulkEmailsPage {

	private WebDriver driver;
	private WebDriverWait wait;
    public String returnComp;
	public AdminBulkEmailsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
}
	private By bulkemailPageText = By.xpath("/html/body/form/div[3]/div[2]/div[2]/div/div/h2");
	private By compDropdown = By.name("ctl00$ContentPlaceHolder1$ddlCompany");
	private By lotno = By.name("ctl00$ContentPlaceHolder1$ddlLotNo");
	private By emailTypeLink = By.id("ContentPlaceHolder1_ddlTypeOfMail");
	private By chooseFileLink = By.name("ctl00$ContentPlaceHolder1$fupEnroll");
	private By clickTestLink = By.id("ContentPlaceHolder1_rdbTest");
	private By sendSampleEmailLink = By.id("ContentPlaceHolder1_txtEmail");
	private By sendMailLink = By.name("ctl00$ContentPlaceHolder1$btnSendMail");


	

	public String getBulkemailPageText() {
		wait.until(ExpectedConditions.presenceOfElementLocated(bulkemailPageText));
		return driver.findElement(bulkemailPageText).getText();
	}
	
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

    public void selectEmailType(String emailType) throws InterruptedException {
 		wait.until(ExpectedConditions.presenceOfElementLocated(emailTypeLink));
 		Select eType = new Select(driver.findElement(emailTypeLink));
 		eType.selectByVisibleText(emailType);
 		
 		Thread.sleep(3000);
 	}
    
    public void selectTestOption(){
 		wait.until(ExpectedConditions.presenceOfElementLocated(clickTestLink));
        WebElement tBtn = driver.findElement(clickTestLink);
		tBtn.click();
    	
    }

    public void SampleEmailAddress(String SampleEmailId){
    	wait.until(ExpectedConditions.presenceOfElementLocated(sendSampleEmailLink));
        WebElement sMail = driver.findElement(sendSampleEmailLink);
        sMail.sendKeys(SampleEmailId);
    }
    
    public void clickSendMail() {
		wait.until(ExpectedConditions.presenceOfElementLocated(sendMailLink));
		WebElement sendbtn = driver.findElement(sendMailLink);
		sendbtn.click();
	}
}
