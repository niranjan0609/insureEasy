package com.gmc.pageobjects.member;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	
}
