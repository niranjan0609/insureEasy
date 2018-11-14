package com.gmc.pageobjects.member;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gmc.pageobjects.admin.SendConfirmationEmailPage;
import com.gmc.utils.ExcelReader;

public class MemberAddDependentsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MemberAddDependentsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	private By addSpouseLink = By.xpath("/html/body/form/div[3]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[1]/td/a");
	private By addChildLink = By.xpath("/html/body/form/div[3]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[2]/td/a");
	private By dateofMarriageLink = By.id("ContentPlaceHolder1_ddlDOMDate");
	private By marriageMonthLink = By.id("ContentPlaceHolder1_ddlDOMMon");
	private By marriageYearLink = By.id("ContentPlaceHolder1_ddlDOMYear");
	private By dependentSpouseNameLink = By.id("ContentPlaceHolder1_txtSpouseName");
    private By dateofBirthSpouseLink = By.id("ContentPlaceHolder1_ddlSpouseDepDate");
	private By birthMonthSpouseLink = By.id("ContentPlaceHolder1_ddlSpouseDepMon");
	private By birthYearSpouseLink = By.id("ContentPlaceHolder1_ddlSpouseDepYear");
	private By relationSpouseLink = By.id("ContentPlaceHolder1_ddlSpouseDepRel");
    private By chooseFileSpouseBtn = By.id("ContentPlaceHolder1_fupMarCer");
	private By addSpouseBtn = By.id("ContentPlaceHolder1_btnSubmit");
	
	private By dependntChildNameLink = By.id("ContentPlaceHolder1_txtChildName");
	private By dateofBirthChildLink = By.id("ContentPlaceHolder1_ddlChildDepDate");
	private By birthMonthChildLink = By.id("ContentPlaceHolder1_ddlChildDepMon");
	private By birthYearChildLink = By.id("ContentPlaceHolder1_ddlChildDepYear");
	private By relationChildLink = By.id("ContentPlaceHolder1_ddlChildDepRel");
    private By chooseFileChildBtn = By.id("ContentPlaceHolder1_fupDOB");
	private By addChildBtn = By.id("ContentPlaceHolder1_btnAddChild");
	
	public void clickOnAddSpouse() {
		wait.until(ExpectedConditions.presenceOfElementLocated(addSpouseLink));
		driver.findElement(addSpouseLink).click();
	}
	
	public void clickOnAddChild() {
		wait.until(ExpectedConditions.presenceOfElementLocated(addChildLink));
		driver.findElement(addChildLink).click();
	}
	
	public void selectDateDOM(String dayDOM) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dateofMarriageLink));
		Select dd = new Select(driver.findElement(dateofMarriageLink));
		dd.selectByVisibleText(dayDOM);
}
	
	public void selectMonthDOM(String monthDOM) {
		wait.until(ExpectedConditions.presenceOfElementLocated(marriageMonthLink));
		Select mon = new Select(driver.findElement(marriageMonthLink));
		mon.selectByVisibleText(monthDOM);
}
	
	public void selectYearDOM(String yearDOM) {
		wait.until(ExpectedConditions.presenceOfElementLocated(marriageYearLink));
		Select yyyy = new Select(driver.findElement(marriageYearLink));
		yyyy.selectByVisibleText(yearDOM);
		}
	
	public void enterSpouseName(String name) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dependentSpouseNameLink));
		WebElement Sname = driver.findElement(dependentSpouseNameLink);
		Sname.sendKeys(name);
	}
	public void selectDateDOB(String dayDOB) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dateofBirthSpouseLink));
		Select dd = new Select(driver.findElement(dateofBirthSpouseLink));
		dd.selectByVisibleText(dayDOB);
}
	
	public void selectMonthDOB(String monthDOB) {
		wait.until(ExpectedConditions.presenceOfElementLocated(birthMonthSpouseLink));
		Select mon = new Select(driver.findElement(birthMonthSpouseLink));
		mon.selectByVisibleText(monthDOB);
}
	
	public void selectYearDOB(String yearDOB) {
		wait.until(ExpectedConditions.presenceOfElementLocated(birthYearSpouseLink));
		Select yyyy = new Select(driver.findElement(birthYearSpouseLink));
		yyyy.selectByVisibleText(yearDOB);
		}
	
	public void selectRelationship(String relation) {
		wait.until(ExpectedConditions.presenceOfElementLocated(relationSpouseLink));
		Select dd = new Select(driver.findElement(relationSpouseLink));
		dd.selectByVisibleText(relation);
}
	
}
