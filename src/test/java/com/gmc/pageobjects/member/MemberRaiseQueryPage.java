package com.gmc.pageobjects.member;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MemberRaiseQueryPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MemberRaiseQueryPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	private By queryHeadingLink = By.id("ContentPlaceHolder1_txtQuery");
	private By queryDescLink = By.id("ContentPlaceHolder1_txtQueryDetails");
	private By submitBtn = By.id("ContentPlaceHolder1_btnRaiseQuery");
	private By nextBtn = By.id("ContentPlaceHolder1_btnAccpet");
	
	
	
	public MemberRaiseQueryPage NavigateToProfilePage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(nextBtn));
		driver.findElement(nextBtn).click();
		return new MemberRaiseQueryPage (driver);
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
