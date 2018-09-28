package com.gmc.pageobjects.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class AdminExcelImportPage {
	private WebDriver driver;
	private WebDriverWait wait;
	public String returnComp;

	public AdminExcelImportPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	private By excelImportText = By.id("BrokerControl_lnkExcelImport");
	private By compDropdown = By.name("ctl00$ContentPlaceHolder1$ddlCompany");
	private By enrollFromDate = By.name("ctl00$ContentPlaceHolder1$txtEnrollFrom");
	private By datepicker = By.xpath("/html/body/div[@id='ui-datepicker-div']/table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[@class=' '][1]/a[@class='ui-state-default ui-state-hover']");
	private By enrollToDate = By.name("ctl00$ContentPlaceHolder1$txtEnrollTo");
	private By chooseFileLink = By.name("ctl00$ContentPlaceHolder1$fupEnroll");
	private By uploadBtnLink = By.name("ctl00$ContentPlaceHolder1$btnUpload");
	String filePath = "D://ExcelImport.xlsx";

	public String getExcelImportPageText() {
		wait.until(ExpectedConditions.presenceOfElementLocated(excelImportText));
		return driver.findElement(excelImportText).getText();
	}

	public void selectCompany(String CompanyName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(compDropdown));
		Select compname = new Select(driver.findElement(compDropdown));
		compname.selectByVisibleText(CompanyName);

	}

	public void enterEnrollFromDate(String enrollfrom) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(enrollFromDate));
		WebElement eFrom = driver.findElement(enrollFromDate);
		eFrom.click();
		selectDate(enrollfrom);
		Thread.sleep(3000);
	}

	public void enterEnrollToDate(String enToDate) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(enrollToDate));
		WebElement eTo = driver.findElement(enrollToDate);
		eTo.click();
		selectDate(enToDate);
		Thread.sleep(3000);
	}

	public void uploadExcelFile() throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(chooseFileLink));
		WebElement fileupload = driver.findElement(chooseFileLink);
		fileupload.sendKeys(filePath);
		Thread.sleep(2000);

	}

	public void clickuploadbtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(uploadBtnLink));
		WebElement upldbtn = driver.findElement(uploadBtnLink);
		upldbtn.click();
	}

	public void selectDate(String strdate) {
		Date current = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
			Date selected = sdf.parse(strdate);
			String date = sdf.format(selected);
			System.out.println(date);

			String day = new SimpleDateFormat("dd").format(selected);
			String month = new SimpleDateFormat("MMMM").format(selected);
			String year = new SimpleDateFormat("yyyy").format(selected);

			String desiredMonthYear = month + " " + year;
			System.out.println(desiredMonthYear);

			while (true) {
				String displayedMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"))
						.getText();
				if (desiredMonthYear.equals(displayedMonthYear)) {

					List<WebElement> list_AllDateToBook = driver
							.findElements(By.xpath("//td[@data-handler='selectDay']"));

					list_AllDateToBook.get(Integer.parseInt(day) - 1).click();

					break;
				} else {
					if (selected.compareTo(current) > 0)
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
					else if (selected.compareTo(current) < 0)
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
