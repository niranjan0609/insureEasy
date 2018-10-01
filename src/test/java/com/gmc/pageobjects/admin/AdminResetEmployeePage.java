package com.gmc.pageobjects.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminResetEmployeePage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public AdminResetEmployeePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	private By empIdText = By.name("ctl00$ContentPlaceHolder1$txtSearchEmpId");
	private By emailID = By.name("ctl00$ContentPlaceHolder1$txtEmail");
	private By searchBtn = By.name("ctl00$ContentPlaceHolder1$btnSearch");
	private By viewBtn = By.xpath("/html/body/form[@id='form1']/div[@id='wrapper']/div[@id='container']/div[@id='content']/div[@id='content']/div[@class='boxFull']/div[@class='datagrid']/table[2]/tbody[2]/tr/td[5]/a");
	private By resetBtn = By.xpath("");

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

	public void clickResetbtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(resetBtn));
		driver.findElement(resetBtn).click();
	}
	

}
