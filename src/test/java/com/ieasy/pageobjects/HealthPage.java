package com.ieasy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HealthPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	

	String imageNameHDFC = "hdfc.jpg";
	String imageAltHDFC = "hdfc";
	
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
	private By wifeTxt = By.xpath("//*[@id=\"member-list\"]/div[2]/div[4]/a/i");
	private By ageTxt = By.xpath("//div[text()='Self']/parent::div//input[@id='age']");
	private By viewQuote = By.cssSelector("#coverContent .member-section .ie-health-btn");
	private By quoteSumAssured =By.cssSelector("#policyadityabirla #sumInsuredFilter");
	private By quoteValue = By.xpath("//*[@id=\"policyadityabirla\"]/div/div[5]/div/div/button[1]");
	private By listingDetails = By.cssSelector("#listingBody .health-listing");
	private By homeBack = By.cssSelector("#healthSearch .filter-header .btn-orange");
	private By SearchBarLink = By.xpath("");
	private By SILink = By.xpath("");
	private By ApplySearchLink = By.xpath("");
	private By addMemb = By.xpath("");
	private By addSonTxt = By.xpath("");
	private By addDaughterTxt = By.xpath("");
	
	public HealthPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}

	public void clickHealthInsurance() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(healthGrid)));
		driver.findElement(healthI).click();
	}

	public void enterPinCode(String pinCode, boolean val) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(getQuoteCard)));

		if(val) {
			driver.findElement(pinTxt).clear();
		}
		driver.findElement(pinTxt).sendKeys(pinCode);
	}

	public void selectFirstPinValue(){
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
		driver.findElement(wifeTxt).clear();
		driver.findElement(wifeTxt).sendKeys(wifeAge);
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
		
		driver.findElement(addMemb).click();
	}
	
	public void clickAddSon() {
		
		driver.findElement(addSonTxt).click();
	}
	
public void clickDaughter() {
		
		driver.findElement(addDaughterTxt).click();
	}
	
	
	public void clickGetQuote() throws InterruptedException{
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

	public void backHome() {
		driver.findElement(homeBack).click();
		//return new HealthPage(driver);
		driver.navigate().to("https://test.insureeasy.in/");
	}

	public HomePage startFrom() {
		/*List<WebElement> list = driver.findElements(By.cssSelector("ul.navbar-center li>a"));
		for ( WebElement ele: list) {
			if ( ele.getText().contains( "HOME" ))
				ele.click();
		}*/
		driver.findElement(By.linkText("HOME")).click();
		return new HomePage(driver);
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}
	
	public void deleteCookie() {
		driver.manage().deleteCookieNamed("hi_quoteId");
	}
	

	public void changeSI(String SumInsured) {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(quoteSumAssured)));
		Select select = new Select(driver.findElement(quoteSumAssured));
		select.selectByValue(SumInsured);
		}


	public void changeSIAbove7Lac(String SumInsured) {
		
	driver.findElement(SearchBarLink).click();
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(SILink)));
		Select select = new Select(driver.findElement(SILink));
		select.selectByValue(SumInsured);
		}
	
	public void clickApplySearch() throws InterruptedException{
	
		driver.findElement(ApplySearchLink).click();
		
	}
}
