package com.ieasy.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ieasy.tests.Dp1APlan;

import java.util.List;

public class HealthPage {

	private static final Logger log = LogManager.getLogger(HealthPage.class);

	private WebDriver driver;
	private WebDriverWait wait;


	private By healthI = By.xpath("//select-policy/div/div[1]/div[1]/div/label/img");
	private By healthGrid = By.cssSelector("#policyContent .health-pitem");
	private By getQuoteCard = By.cssSelector("#aboutContent");
	private By pinTxt = By.xpath("//input[@formcontrolname='pinarea']");
	private By pinValue = By.cssSelector(".dropdown.open ul.dropdown-menu li:first-child");
	private By mobileTxt = By.xpath("//input[@formcontrolname='mobile']");
	private By emailTxt = By.xpath("//input[@formcontrolname='email']");
	private By nxtBtn = By.xpath("//*[@id=\"healthNext\"]");
	private By sonTxt = By.xpath("//*[@id=\"member-list\"]/div[4]/div[4]/a/i");
	private By daugTxt = By.xpath("//*[@id=\"member-list\"]/div[3]/div[4]/a/i");
	private By daughTxt = By.xpath("//div[text()='Daughter']/parent::div//input[@id='age']");
	private By wifeTxt = By.xpath("//*[@id=\"member-list\"]/div[2]/div[4]/a/i");
	private By wifeeTxt = By.xpath("//div[text()='Wife']/parent::div//input[@id='age']");
	private By ageTxt = By.xpath("//div[text()='Self']/parent::div//input[@id='age']");
	private By viewQuote = By.cssSelector("#coverContent .member-section .ie-health-btn");
	private By quoteSumAssured = By.cssSelector("#policyadityabirla #sumInsuredFilter");
	private By quoteValue = By.xpath("//*[@id=\"policyadityabirla\"]/div/div[5]/div/div/button[1]");
	private By listingDetails = By.cssSelector("#listingBody .health-listing");
	private By homeBack = By.cssSelector("#healthSearch .filter-header .btn-orange");
	private By SearchBarLink = By.cssSelector(".header-search .header-search-input");
	private By searchPopup = By.id("searchPopup");
	private By healthSelectDropdown = By.cssSelector(".health-filter-dropdown ");
	private By applySearch = By.cssSelector("#searchPopup .modal-footer .btn");
	private By progressbar = By.cssSelector(".progress.progress-line-primary");
	private By SILink = By.xpath("add");
	private By addMemb = By.xpath("//*[@id=\"coverContent\"]/coverages/div[2]/div[1]/a/i");
	private By addSonTxt = By.xpath("//*[@id=\"relationList\"]/div[4]/li[1]/a");
	private By addDaughterTxt = By.xpath("//*[@id=\"relationList\"]/div[3]/li/a");
	
	private By daug2Txt = By.cssSelector("#member-list .row member-item:last-child");
	

	private By son2Txt = By.xpath("//div[text()='Son']/parent::div//input[@class='form-control age ng-pristine ng-valid ng-touched']");

	public HealthPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, 120);
	}

	public void clickHealthInsurance() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(healthGrid)));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(healthI)));
		driver.findElement(healthI).click();
	}

	public void enterPinCode(String pinCode, boolean val) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(getQuoteCard)));

		if (val) {
			driver.findElement(pinTxt).clear();
		}
		driver.findElement(pinTxt).sendKeys(pinCode);
	}

	public void selectFirstPinValue() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(pinValue)));
		driver.findElement(pinValue).click();
	}

	public void enterMobileNo(String mobileNumber) {
		// TODO Auto-generated method stub
		driver.findElement(mobileTxt).clear();
		driver.findElement(mobileTxt).sendKeys(mobileNumber);
	}

	public void emailId(String emailId) {
		// TODO Auto-generated method stub
		driver.findElement(emailTxt).clear();
		driver.findElement(emailTxt).sendKeys(emailId);
	}

	public void clickNextBtn() {
		driver.findElement(nxtBtn).click();

	}

	public void CloseSonOption() {
		// TODO Auto-generated method stub
		driver.findElement(sonTxt).click();
	}

	public void CloseDaughterOption() {
		// TODO Auto-generated method stub
		driver.findElement(daugTxt).click();
	}

	public void CloseWifeOption() {
		// TODO Auto-generated method stub
		driver.findElement(wifeTxt).click();
	}

	public void enterSelfAge(String selfAge) {
		// TODO Auto-generated method stub
		driver.findElement(ageTxt).clear();
		driver.findElement(ageTxt).sendKeys(selfAge);
	}

	public void enterWifeAge(String wifeAge) {
		// TODO Auto-generated method stub
		driver.findElement(wifeeTxt).clear();
		driver.findElement(wifeeTxt).sendKeys(wifeAge);
	}

	public void enterSonAge(String sonAge) {
		// TODO Auto-generated method stub
		driver.findElement(sonTxt).clear();
		driver.findElement(sonTxt).sendKeys(sonAge);
	}

	public void enterDaughterAge(String daughterAge) {
		// TODO Auto-generated method stub
		driver.findElement(daugTxt).clear();
		driver.findElement(daugTxt).sendKeys(daughterAge);
	}

	public void clickAddMembers() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(addMemb)));
		driver.findElement(addMemb).click();
	}

	public void clickAddSon() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(addSonTxt)));
		driver.findElement(addSonTxt).click();
	}

	public void clickAddDaughter() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(addDaughterTxt)));
		driver.findElement(addDaughterTxt).click();
	}

	public void clickGetQuote() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(viewQuote).click();
		Thread.sleep(3000);
	}

	public String getSumAssuredValue() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(quoteSumAssured)));
		Select select = new Select(driver.findElement(quoteSumAssured));
		WebElement selectedElement = select.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String getQuoteValue() {
		return driver.findElement(quoteValue).getText();
	}

	public HomePage backHome() {
		driver.navigate().to("https://test.insureeasy.in/");
		return new HomePage(driver);
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	public void deleteCookieQuoteId() {
		driver.manage().deleteCookieNamed("hi_quoteId");
	}

	public void changeSI(String SumInsured) throws InterruptedException {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(quoteSumAssured)));
		Select select = new Select(driver.findElement(quoteSumAssured));
		Thread.sleep(4000);
		select.selectByValue(SumInsured);
	}

	public void selectSumInsuredFromSearchInput(String sumInsuredValue) throws InterruptedException {
		log.debug("Waiting for progress bar to disappear...");
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(progressbar)));
		driver.findElement(SearchBarLink).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchPopup)));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(healthSelectDropdown)));
		Select select = new Select(driver.findElement(healthSelectDropdown));
		select.selectByValue(sumInsuredValue);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(applySearch)));
     
		driver.findElement(applySearch).click();
		/*
		 * //Thread.sleep(1000); log.debug("Waiting for search popup to disappear...");
		 * wait.until(ExpectedConditions.invisibilityOf(driver.findElement(searchPopup))
		 * );
		 */
	}

	public void enterDaughter2Age(String daughter2Age) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(daug2Txt)));
		WebElement ele = driver.findElement(daug2Txt);
		ele.findElement(daug2Txt).clear();
	
		driver.findElement(daug2Txt).sendKeys(daughter2Age);
	}

	public void enterSon2Age(String son2Age) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(son2Txt)));
		driver.findElement(son2Txt).clear();
		driver.findElement(son2Txt).sendKeys(son2Age);
	}

}
