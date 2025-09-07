package com.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.orangehrm.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	protected WebDriver driver;
	protected ExtentReports extent;
	protected ExtentTest test;
	@BeforeSuite
	public void setupreport()
	{
		extent=ExtentManager.getinstance();
	}


	@BeforeMethod
	public void setup() {
		System.out.println("Before method");
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	public void navigateurl(String url)
	{
		driver.get(url);
	}
	@AfterMethod
	public void teardown() {
		System.out.println("After method");
		driver.quit();
	}

	@AfterSuite
	public void flushreport()

	{
		extent.flush();
	}
}