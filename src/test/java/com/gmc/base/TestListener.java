package com.gmc.base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.gmc.utils.Util;


public class TestListener extends TestBase implements ITestListener {
	private WebDriver driver;
	
	@Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("***** Error "+result.getName()+" test has failed *****");
    	String methodName=result.getName().toString().trim();
    	this.driver=(WebDriver) result.getInstance();
    	takeScreenShot(methodName);
    }
    
    public void takeScreenShot(String methodName) {
    	//get the driver
    	String workingDir = System.getProperty("user.dir") + "\\reports\\";
    	System.out.println("Screnshots working directory - " +workingDir );
    	String dateF = Util.getDateTime();
    	 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 System.out.println(workingDir+methodName+dateF);
         //The below method will save the screen shot in d drive with test method name 
            try {
				FileUtils.copyFile(scrFile, new File(workingDir+methodName+dateF+".png"));
				System.out.println("***Placed screen shot in "+workingDir+" ***");
			} catch (IOException e) {
				e.printStackTrace();
			}
    }
	public void onFinish(ITestContext context) {}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}  