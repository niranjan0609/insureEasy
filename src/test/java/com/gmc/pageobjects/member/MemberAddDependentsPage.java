package com.gmc.pageobjects.member;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MemberAddDependentsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MemberAddDependentsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	private By addSpouseLink = By.xpath("/html/body/form/div[3]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[1]/td/a");
	private By addChildLink = By.xpath("/html/body/form/div[3]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[2]/td/a");
	private By dateofMarriageLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By marriageMonthLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By marriageYearLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By dependentSpouseNameLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
    private By dateofBirthSpouseLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By birthMonthSpouseLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By birthYearSpouseLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By relationSpouseLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
    private By chooseFileSpouseBtn = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By addSpouseBtn = By.id("ContentPlaceHolder1_btnAccpet");
	
	private By dependntChildNameLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By dateofBirthChildLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By birthMonthChildLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By birthYearChildLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By relationChildLink = By.id("ContentPlaceHolder1_btnRaiseQuery");
    private By chooseFileChildBtn = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By addChildBtn = By.id("ContentPlaceHolder1_btnAccpet");
	
	
	public MemberAddDependentsPage NavigateToProfilePage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(nextBtn));
		driver.findElement(nextBtn).click();
		return new MemberAddDependentsPage (driver);
	}

	
	public void enterQueryHeading(String heading) {
		wait.until(ExpectedConditions.presenceOfElementLocated(queryHeadingLink));
		WebElement qh = driver.findElement(queryHeadingLink);
		qh.sendKeys(heading);
	}
	
	public void enterQueryDescription(String description) {
		wait.until(ExpectedConditions.presenceOfElementLocated(queryDescLink));
		WebElement qd = driver.findElement(queryDescLink);
		qd.sendKeys(description);
	}

	
	public void clickSubmitQueryBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(submitBtn));
		driver.findElement(submitBtn).click();
	}

}
