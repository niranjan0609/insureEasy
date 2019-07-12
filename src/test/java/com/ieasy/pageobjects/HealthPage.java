package com.ieasy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HealthPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	

	String imageNameHDFC = "hdfc.jpg";
	String imageAltHDFC = "hdfc";
	
	private By healthI = By.xpath("//select-policy/div/div[1]/div[1]/div/label/img");
	private By pinTxt = By.xpath("//input[@formcontrolname='pinarea']");
	private By mobileTxt = By.xpath("//input[@formcontrolname='mobile']");
	private By emailTxt = By.xpath("//input[@formcontrolname='email']");
	private By nxtBtn = By.xpath("//*[@id=\"healthNext\"]");
	private By sonTxt = By.xpath("//*[@id=\"member-list\"]/div[4]/div[4]/a/i");
	private By daugTxt = By.xpath("//*[@id=\"member-list\"]/div[3]/div[4]/a/i");
	private By wifeTxt = By.xpath("//*[@id=\"member-list\"]/div[2]/div[4]/a/i");
	private By ageTxt = By.xpath("//div[text()='Self']/parent::div//input[@id='age']");
	private By quoteTxt = By.xpath("//*[@id=\"policyadityabirla\"]/div/div[5]/div/div/button[1]");

	
	public HealthPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, 60);
	}

	public void clickHealthInsurance() {
		driver.findElement(healthI).click();
		
	}

	public void enterPinCode(String pinCode) {
		// TODO Auto-generated method stub
		driver.findElement(pinTxt).sendKeys(pinCode);
	}

	public void enterMobileNo(String mobileNumber) {
		// TODO Auto-generated method stub
		driver.findElement(mobileTxt).sendKeys(mobileNumber);
	}

	public void emailId(String emailId) {
		// TODO Auto-generated method stub
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
		driver.findElement(ageTxt).sendKeys(selfAge);
	}

	public void clickGetQuote() {
		// TODO Auto-generated method stub
		driver.findElement(quoteTxt).click();
	}

}
