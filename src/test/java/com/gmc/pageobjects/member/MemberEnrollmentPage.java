package com.gmc.pageobjects.member;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmc.pageobjects.admin.SendWelcomeEmailPage;

public class MemberEnrollmentPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public MemberEnrollmentPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	
	private By mobNo = By.id("txtMobileNo");
	private By AlternateemailID = By.id("txtAltEmail");
	private By dependentName = By.name("txtDepName");
	private By dependentDate = By.name("ddlDateDep");
	private By dependentMonth = By.name("ddlMonthDep");
	private By dependentYear = By.name("ddlYearDep");
	private By relationship = By.name("ddlRelationDep");
    private By topUpSumInsured = By.id("ddlTopup");
	private By topUpPremium = By.id("txtTopupPremiumServTax");
	private By totalParentalPremium = By.id("spnEntryParentalPremium");
	private By totalTopUpPremium = By.id("spnEntryTotalTopupPremium");
	private By totalPremiumPayable = By.id("spnEntryTotalPremiumPayable");
	private By submitBtn = By.id("btnSubmit");
	private By confirmBtn = By.id("btnSubmit");
	private By gobackBtn = By.id("btnSubmit");
	private By getEcardLink = By.id("EmpControl_lnkGetEcard");
	private By networkHospLink = By.id("EmpControl_lnkNetworkHos");
	private By guidelinesBtn = By.id("lnkGuideLines");
	private By policyDetailsBtn = By.id("lnkPolicyDetails");
	private By faqBtn = By.id("lnkBtnFAQ");
	private By contactUsBtn = By.id("lnkConactUs");
	private By logoutBtn = By.id("lnkLogout");
    private By nextBtn = By.id("ContentPlaceHolder1_btnAccpet");
	private By afterlogoutMsg = By.xpath("/html/body/form/div[3]/div[2]/div[1]/div/div/table[1]/tbody/tr[2]/td[1]");


	public MemberEnrollmentPage NavigateEnrollmentPage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(nextBtn));
		driver.findElement(nextBtn).click();
		return new MemberEnrollmentPage(driver);
	}

	public int getDependentsRowCount() {
		return driver.findElements(dependentName).size();
	}

	public List<WebElement> getDependentNameWebElements() {
		return driver.findElements(dependentName);
	}

	public void enterMobileNo(String MobileNumber) {
		wait.until(ExpectedConditions.presenceOfElementLocated(mobNo));
		WebElement mob = driver.findElement(mobNo);
		mob.sendKeys(MobileNumber);
	}

	public void enterAlternateEmail(String emailID) {
		wait.until(ExpectedConditions.presenceOfElementLocated(AlternateemailID));
		WebElement eid = driver.findElement(AlternateemailID);
		eid.sendKeys(emailID);
	}

	public void enterDependentName(int i, String name) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dependentName));
		WebElement dname = driver.findElements(dependentName).get(i);
		dname.sendKeys(name);
	}

	public void enterDependentDateOfBirth(int i, String dd) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dependentDate));
		Select day = new Select(driver.findElements(dependentDate).get(i));
		day.selectByVisibleText(dd);

	}

	public void enterDependentMonthOfBirth(int i, String month) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dependentMonth));
		Select mon = new Select(driver.findElements(dependentMonth).get(i));
		mon.selectByVisibleText(month);
	}

	public void enterDependentYearOfBirth(int i, String year) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dependentYear));
		Select yyyy = new Select(driver.findElements(dependentYear).get(i));
		yyyy.selectByVisibleText(year);
	}

	public void enterDependentRelationship(int i, String relation) {
		wait.until(ExpectedConditions.presenceOfElementLocated(relationship));
		Select rel = new Select(driver.findElements(relationship).get(i));
		rel.selectByVisibleText(relation);
	}

	public void selectTopUpPlan(String SI) {
		wait.until(ExpectedConditions.presenceOfElementLocated(topUpSumInsured));
		Select sum = new Select(driver.findElement(topUpSumInsured));
		sum.selectByVisibleText(SI);
	}

	public String getTopUpPremium() {
		wait.until(ExpectedConditions.presenceOfElementLocated(topUpPremium));
		return driver.findElement(topUpPremium).getText();
	}

	public String getTotalParentalPremium() {
		wait.until(ExpectedConditions.presenceOfElementLocated(totalParentalPremium));
		return driver.findElement(totalParentalPremium).getText();
	}

	public String getTotalTopUpPremium() {
		wait.until(ExpectedConditions.presenceOfElementLocated(totalTopUpPremium));
		return driver.findElement(totalTopUpPremium).getText();
	}

	public String getTotalPremiumPayable() {
		wait.until(ExpectedConditions.presenceOfElementLocated(totalPremiumPayable));
		return driver.findElement(totalPremiumPayable).getText();
	}

	public void clickSubmitBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(submitBtn));
		driver.findElement(submitBtn).click();
	}

	public void clickToConfirmBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(confirmBtn));
		driver.findElement(confirmBtn).click();
	}

	public void clickToGobackBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(gobackBtn));
		driver.findElement(gobackBtn).click();
	}

	public void clickNextBtnAfterLogin() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(nextBtn));
		driver.findElement(nextBtn).click();
	}

	public void clickEcard() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(getEcardLink));
		driver.findElement(getEcardLink).click();
	}

	public void clickNetworkHospitals() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(networkHospLink));
		driver.findElement(networkHospLink).click();
	}

	public void clickGuidelinesBtn(){
		wait.until(ExpectedConditions.presenceOfElementLocated(guidelinesBtn));
		driver.findElement(guidelinesBtn).click();
	}
	
	public void clickPolicyDetailsBtn(){
		wait.until(ExpectedConditions.presenceOfElementLocated(policyDetailsBtn));
		driver.findElement(policyDetailsBtn).click();
	}
	
	public void clickFAQBtn(){
		wait.until(ExpectedConditions.presenceOfElementLocated(faqBtn));
		driver.findElement(faqBtn).click();
	}
	
	public void clickContactUsBtn(){
		wait.until(ExpectedConditions.presenceOfElementLocated(contactUsBtn));
		driver.findElement(contactUsBtn).click();
	}
	
	public void clickLogoutBtn(){
		wait.until(ExpectedConditions.presenceOfElementLocated(logoutBtn));
		driver.findElement(logoutBtn).click();
	}

	public String getSuccessMessageForLogout() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(afterlogoutMsg));
		return driver.findElement(afterlogoutMsg).getText();
	}
}
