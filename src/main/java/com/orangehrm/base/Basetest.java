package com.orangehrm.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
    public void setupreport() {
        extent = ExtentManager.getinstance();
    }

    @BeforeMethod
    public void setup() {
        System.out.println("Before method");

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Add Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");   // required for latest Chrome
        // options.addArguments("--headless=new");          // uncomment if you need headless mode (Jenkins/CI)

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void navigateurl(String url) {
        driver.get(url);
    }

    @AfterMethod
    public void teardown() {
        System.out.println("After method");
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushreport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
