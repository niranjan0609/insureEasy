package com.gmc.pageobjects.member;

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
	
	private By GetEcardLink = By.id("EmpControl_lnkGetEcard");
	private By mobNo = By.id("txtMobileNo");
	private By AlternateemailID = By.id("txtAltEmail");
	private By dependentName = By.id("txtDepName0");
	private By dependentDate = By.id("ddlDateDep0");
	private By dependentMonth = By.id("ddlMonthDep0");
	private By dependentYear = By.id("ddlYearDep0");
	private By relationship = By.id("ddlRelationDep0"); 
	
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
	private By nextBtn = By.id("ContentPlaceHolder1_btnAccpet");
	
	/*public void clickNextBtnAfterLogin() {
		wait.until(ExpectedConditions.presenceOfElementLocated(nextBtn));
		driver.findElement(nextBtn).click();
	}*/
	
	public MemberEnrollmentPage NavigateEnrollmentPage() {
		wait.until(ExpectedConditions.presenceOfElementLocated(nextBtn));
		driver.findElement(nextBtn).click();
		return new MemberEnrollmentPage (driver);
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
	
	public void enterDependentName(String name) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dependentName));
		WebElement dname = driver.findElement(dependentName);
		dname.sendKeys(name);
	}
	
	public void enterDependentDateOfBirth(String dd) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dependentDate));
		Select day = new Select(driver.findElement(dependentDate));
		day.selectByVisibleText(dd);

	}
	
	public void enterDependentMonthOfBirth(String month) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dependentMonth));
		Select mon = new Select(driver.findElement(dependentMonth));
		mon.selectByVisibleText(month);
      }
	
	public void enterDependentYearOfBirth(String year) {
		wait.until(ExpectedConditions.presenceOfElementLocated(dependentYear));
		Select yyyy = new Select(driver.findElement(dependentYear));
		yyyy.selectByVisibleText(year);
     }
	
	public void enterDependentRelationship(String relation) {
		wait.until(ExpectedConditions.presenceOfElementLocated(relationship));
		Select rel = new Select(driver.findElement(relationship));
		rel.selectByVisibleText(relation);
	 }
		
		public void selectTopUpPlan(String SI){
			wait.until(ExpectedConditions.presenceOfElementLocated(topUpSumInsured));
			Select sum = new Select(driver.findElement(topUpSumInsured));
			sum.selectByVisibleText(SI);
	 }
		
		public String getTopUpPremium(){
			wait.until(ExpectedConditions.presenceOfElementLocated(topUpPremium));
			return driver.findElement(topUpPremium).getText();
		}
		
		
		public String getTotalParentalPremium(){
			wait.until(ExpectedConditions.presenceOfElementLocated(totalParentalPremium));
			return driver.findElement(totalParentalPremium).getText();
		}
		
		public String getTotalTopUpPremium(){
			wait.until(ExpectedConditions.presenceOfElementLocated(totalTopUpPremium));
			return driver.findElement(totalTopUpPremium).getText();
		}
		public String getTotalPremiumPayable(){
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
			wait.until(ExpectedConditions.presenceOfElementLocated(GetEcardLink));
			driver.findElement(GetEcardLink).click();
		}


		public void clickNetworkHospitals() {
			// TODO Auto-generated method stub
			wait.until(ExpectedConditions.presenceOfElementLocated(networkHospLink));
			driver.findElement(networkHospLink).click();
		}


		/*public void clickNetworkHospitals() {
			// TODO Auto-generated method stub
			wait.until(ExpectedConditions.presenceOfElementLocated(networkHospLink));
			driver.findElement(networkHospLink).click();
		}*/

		
}

