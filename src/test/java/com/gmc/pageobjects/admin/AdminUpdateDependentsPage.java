package com.gmc.pageobjects.admin;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUpdateDependentsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public AdminUpdateDependentsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	private By empIdText = By.name("ctl00$ContentPlaceHolder1$txtSearchEmpId");
	private By emailID = By.name("ctl00$ContentPlaceHolder1$txtEmail");
	private By searchBtn = By.name("ctl00$ContentPlaceHolder1$btnSearch");
	private By viewBtn = By.xpath("/html/body/form[@id='form1']/div[@id='wrapper']/div[@id='container']/div[@id='content']/div[@id='content']/div[@class='boxFull']/div[@class='datagrid']/table[2]/tbody[2]/tr/td[5]/a");
	private By editBtn = By.xpath("//*[@id='ContentPlaceHolder1_grdEmployee_lnkBtnEdit_0']/img");
	private By nameText = By.name("ctl00$ContentPlaceHolder1$grdEmployee$ctl02$txtEmpName");
    private By dayText = By.id("ContentPlaceHolder1_grdEmployee_ddlDay_0");
    private By monText = By.id("ContentPlaceHolder1_grdEmployee_ddlMonth_0");
    private By yearText = By.id("ContentPlaceHolder1_grdEmployee_ddlYear_0");
    private By relationText = By.id("ContentPlaceHolder1_grdEmployee_ddlRelation_0");
    private By correctionBoxText = By.id("ContentPlaceHolder1_txtCorrectionRemarks");
    private By SubmitBtn = By.id("ContentPlaceHolder1_btnSubmit");
    
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
	
	public void clickEditdependent() {
		wait.until(ExpectedConditions.presenceOfElementLocated(editBtn));
		driver.findElement(editBtn).click();
	}
	
	public void changeName(String name) {
		wait.until(ExpectedConditions.presenceOfElementLocated(nameText));
		WebElement dname = driver.findElement(nameText);
		dname.sendKeys(name);
	
			}
	
	public void changeDay(String day) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dayText));
		Select selectDay = new Select(driver.findElement(dayText));
		selectDay.selectByVisibleText(day);
		
	}
	
	public void changeMon(String month) {
			wait.until(ExpectedConditions.presenceOfElementLocated(monText));
			Select selectMon = new Select(driver.findElement(monText));
			selectMon.selectByVisibleText(month);
			}
	
	public void changeYear(String year) {
		wait.until(ExpectedConditions.presenceOfElementLocated(yearText));
		Select selectYear = new Select(driver.findElement(yearText));
		selectYear.selectByVisibleText(year);
		}

	public void changeRelationship(String str) {
		wait.until(ExpectedConditions.presenceOfElementLocated(relationText));
		Select selectRelation = new Select(driver.findElement(relationText));
		selectRelation.selectByVisibleText(str);
		}
	
	public void EnterCorrectionRemarks(String remark) {
		wait.until(ExpectedConditions.presenceOfElementLocated(correctionBoxText));
		WebElement empId = driver.findElement(correctionBoxText);
		empId.sendKeys(remark);
	}
	
	public void clickOnSubmit() {
		wait.until(ExpectedConditions.presenceOfElementLocated(SubmitBtn));
		driver.findElement(SubmitBtn).click();
		/*wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();*/
	}
}
