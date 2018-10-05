package com.gmc.pageobjects.member;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gmc.pageobjects.admin.AdminExcelImportPage;



public class MemberHomePage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	//private By welcomeText = By.xpath("//*[@id="lblUserName"]");
	private By GetEcardLink = By.id("EmpControl_lnkGetEcard");
	private By uploadcertificateLink = By.id("EmpControl_lnkUpload");
	private By networkhospitalLink = By.id("EmpControl_lnkNetworkHos");
	private By raisequeryLink = By.id("EmpControl_lnkRaiseQuery");
	private By adddependentLink = By.id("EmpControl_lnkAddDependents");
	private By DOBLink = By.id("LeftBanner_lblDOB");
	private By myprofileLink = By.id("lnkBtnMyProfile");
	private By policydetailsLink = By.id("lnkPolicyDetails");
	private By guidelinesLink = By.id("lnkGuideLines");
	private By FAQLink = By.id("lnkBtnFAQ");
	private By contactusLink = By.id("lnkConactUs");
	private By logoutLink = By.id("lnkLogout");
	private By nextBtn = By.id("ContentPlaceHolder1_btnAccpet");

	public MemberHomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	/*public String getHomePageText() {
		wait.until(ExpectedConditions.presenceOfElementLocated(welcomeText));
		return driver.findElement(welcomeText).getText();
	}*/
	public MemberEnrollmentPage clickNextBtnAfterLogin() {
		wait.until(ExpectedConditions.presenceOfElementLocated(nextBtn));
		driver.findElement(nextBtn).click();
		return new MemberEnrollmentPage(driver);
	}
	
	
	
	public void clickOnGetEcard() {
		wait.until(ExpectedConditions.presenceOfElementLocated(GetEcardLink));
		driver.findElement(GetEcardLink).click();
	}
	public void clickOnNetworkHospitals() {
		wait.until(ExpectedConditions.presenceOfElementLocated(networkhospitalLink));
		driver.findElement(networkhospitalLink).click();
	}
	public MemberMyProfilePage clickMyProfile() {
		wait.until(ExpectedConditions.presenceOfElementLocated(myprofileLink));
		driver.findElement(myprofileLink).click();
		return new MemberMyProfilePage(driver);
	}

	public MemberEnrollmentPage NavigateEnrollmentPage() {
		
		return new MemberEnrollmentPage (driver);
	}

	public MemberMyProfilePage NavigateMyProfilePage() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(nextBtn));
		driver.findElement(nextBtn).click();
		return new MemberMyProfilePage (driver);
	}

	public MemberUploadCertificatePage clickUploadCertificate() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(uploadcertificateLink));
		driver.findElement(uploadcertificateLink).click();
		return new MemberUploadCertificatePage (driver);
	}

	public MemberRaiseQueryPage clickRaiseAQuery() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.presenceOfElementLocated(raisequeryLink));
		driver.findElement(raisequeryLink).click();
		return new MemberRaiseQueryPage (driver);
	}
	
	
}
                     