package com.orangehrm.test;

import org.testng.annotations.Test;

import com.microsoft.schemas.compatibility.AlternateContentDocument.AlternateContent.Fallback;
import com.orangehrm.base.Basetest;
import com.orangehrm.pages.Loginpage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.assertj.core.api.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.orangehrm.base.Basetest;
import com.orangehrm.pages.Loginpage;
import com.orangehrm.utilities.Excelutilities;
import com.orangehrm.utilities.Screenshot;
import java.util.List;
import org.openqa.selenium.WebElement;
public class OrangeHRMTestCases extends Basetest {


	Loginpage login;
	static String projectpath = System.getProperty("user.dir");

	@Test(dataProvider = "loginData", enabled = false)
	public void verifyloginTestcase1(String username, String password) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
		navigateurl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		test = extent.createTest("Login with the user: " + username);
		login = new Loginpage(driver); 
		login.EnterUserName(username);
		login.Enterpassword(password);

		login.Clickonlogin();
		Thread.sleep(3000);


		Thread.sleep(2000);
		String actualtitle = driver.getTitle();
		if (actualtitle.equalsIgnoreCase("OrangeHRM")) {
			test.pass("Login Successful and title is matched: " + actualtitle);
		} else {
			String screenpath = Screenshot.Capture(driver, "Login_Failed_" + username);
			test.fail("Login Unsuccessful and title is not matched: " + actualtitle)
			.addScreenCaptureFromPath(screenpath); 
		}

		if (login.verifyDashboard()) {
			test.pass("Dashboard is visible after login.");
		} else {
			String screenPath = Screenshot.Capture(driver, "Dashboard_Not_Visible_" + username);
			test.fail("Dashboard not visible after login.")
			.addScreenCaptureFromPath(screenPath);
		}
		if (login.verifyTimeAtWorkWidget()) {
			test.pass("Time at Work widget is displayed.");
		} else {
			String screenPath = Screenshot.Capture(driver, "TimeWidget_Not_Visible_" + username);
			test.fail("Time at Work widget not found.")
			.addScreenCaptureFromPath(screenPath);
		}

		login.selectDropdownforlogout();
	}
	@Test(dataProvider = "addUserData", enabled = false)
	public void AddingEmployeeTestCase2(String userRole, String employeeName, String status, 
			String username, String password, String confirmPassword) 
					throws IOException, ParserConfigurationException, SAXException, InterruptedException {

		navigateurl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		test = extent.createTest("Add System User: " + username);  // Better test name
		login = new Loginpage(driver); 

		// Step 1: Login
		login.EnterUserName("Admin");      
		login.Enterpassword("admin123");   
		login.Clickonlogin();
		login.NavigateTOAdmin();
		login.ClickAddOption();

		login.AddSystemUser(userRole);          
		Thread.sleep(1000);

		login.SelectUserStatus(status);          
		Thread.sleep(1000);

		login.AddEmployeeName(employeeName);     
		Thread.sleep(2000);

		login.EnterUsername(username);          
		Thread.sleep(1000);

		login.EnterPassword(password);           
		Thread.sleep(1000);

		login.EnterConfirmPassword(confirmPassword);  
		Thread.sleep(3000);

		login.ClickSaveButton();                 
		Thread.sleep(3000);

		test.pass("User created successfully: " + username);


		login.selectDropdownforlogout();
	}

	@Test(dataProvider = "EmployeeData", enabled = false)
	public void searchEmployeeQuickTest(String employeeName, String employeeId, String supervisorName) 
			throws IOException, InterruptedException {

		navigateurl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		test = extent.createTest("Search Employee Data: " + employeeName);  // Better test name
		login = new Loginpage(driver); 

		// Step 1: Login
		login.EnterUserName("Admin");      
		login.Enterpassword("admin123");   
		login.Clickonlogin();
		login.NavigateTOPIM();
		login.EnterEmpname(employeeName);
		login.EnterEmployeeID(employeeId);
		login.EnterSuperViserName(supervisorName);

		test.pass("Employee Data Fetched successfully: " + employeeName);

		login.selectDropdownforlogout();
	}
	@Test(dataProvider = "loginData1",enabled = false)
	public void searchEmployeeLeaveList(String username, String password) throws IOException, ParserConfigurationException, SAXException, InterruptedException {
		navigateurl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		test = extent.createTest("Leave Search - Data Display or Screenshot");
		login = new Loginpage(driver); 

		login = new Loginpage(driver); 
		login.EnterUserName(username);
		login.Enterpassword(password);
		login.Clickonlogin();

		try {
			// Step 2: Navigate to Leave and search
			System.out.println("Starting leave search...");
			login.NavigateToLeave("2024-01-01", "2024-12-31");

			// Wait for results to load
			Thread.sleep(4000);

			// Step 3: Check results and handle accordingly
			List<WebElement> resultRows = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border']"));

			if (resultRows.size() > 0) {
				// DATA FOUND - Display it
				System.out.println("LEAVE RECORDS FOUND!");
				System.out.println("Total Records: " + resultRows.size());

				// Display first 5 records
				for (int i = 0; i < Math.min(resultRows.size(), 5); i++) {
					try {
						WebElement row = resultRows.get(i);

						// Get data from each column
						String date = row.findElement(By.xpath(".//div[2]//div")).getText().trim();
						String employee = row.findElement(By.xpath(".//div[3]//div")).getText().trim();
						String leaveType = row.findElement(By.xpath(".//div[4]//div")).getText().trim();
						String status = row.findElement(By.xpath(".//div[7]//div")).getText().trim();

						System.out.println((i+1) + ". " + employee + " - " + leaveType + " (" + date + ") - " + status);

					} catch (Exception e) {
						System.out.println((i+1) + ". Error reading row data");
					}
				}


				if (resultRows.size() > 5) {
					System.out.println("... and " + (resultRows.size() - 5) + " more records");
				}

				// Report success to ExtentTest
				if (test != null) {
					test.pass("SUCCESS: Found " + resultRows.size() + " leave records and displayed data");
				}

			} else {
				// NO DATA FOUND - Take screenshot using your Screenshot class
				System.out.println("NO RECORDS FOUND - Taking screenshot...");

				// Use your existing Screenshot.Capture method
				String screenPath = Screenshot.Capture(driver, "NoLeaveRecords_2024");

				System.out.println("SCREENSHOT DETAILS:");
				System.out.println("Search Period: 2024-01-01 to 2024-12-31");
				System.out.println("Screenshot saved: " + screenPath);
				System.out.println("Screenshot capture completed!");


				if (test != null) {
					test.warning(" No Records Found for 2024 - Screenshot captured")
					.addScreenCaptureFromPath(screenPath);
				}
			}

		} catch (Exception e) {
			System.out.println("Error in test: " + e.getMessage());


			String errorScreenPath = Screenshot.Capture(driver, "LeaveSearch_Exception");

			if (test != null) {
				test.fail("Test failed with exception: " + e.getMessage())
				.addScreenCaptureFromPath(errorScreenPath);
			}

			e.printStackTrace();

		} finally {

			login.selectDropdownforlogout();
			System.out.println("Logout completed");
		}
	}
	@Test(dataProvider = "projectdata")
	public void searchProject(String customer, String project) throws IOException, InterruptedException {

		// Navigate to login page
		navigateurl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Create test entry in Extent Report
		test = extent.createTest("Search Project Data: " + project);

		// Initialize Loginpage object
		login = new Loginpage(driver);

		// Step 1: Login
		login.EnterUserName("Admin");
		login.Enterpassword("admin123");
		login.Clickonlogin();

		// Step 2: Navigate and search project
		login.navigateToProjectSearch();
		login.enterCustomerName(customer);
		login.enterProjectName(project);
		login.clickSearchButton();

		// Log success
		test.pass("Project search completed for Customer: " + customer + ", Project: " + project);

		// Step 3: Logout
		login.selectDropdownforlogout();
	}

	@DataProvider(name = "loginData1")
	public Object[][] loginDataProvider1() throws IOException {
		String path = "E:\\Eclipse\\Project-OrangeHRM-master\\Project-OrangeHRM-master\\LoginDetails.xlsx";
		return Excelutilities.getdata(path, "Sheet2");
	}

	@DataProvider(name = "addUserData")
	public Object[][] addUserDataProvider() throws IOException {
		String path = "E:\\Eclipse\\Project-OrangeHRM-master\\Project-OrangeHRM-master\\LoginDetails.xlsx";  // Use new file
		return Excelutilities.getdata(path, "AddUserData");  // Use new sheet name
	}

	@DataProvider(name = "EmployeeData")
	public Object[][] employeeSearchDataProvide() throws IOException {
		String path = "E:\\Eclipse\\Project-OrangeHRM-master\\Project-OrangeHRM-master\\LoginDetails.xlsx";
		return Excelutilities.getdata(path, "Sheet1");
	}

	@DataProvider(name = "projectdata")
	public Object[][] projectdata() throws IOException {
		String path = "E:\\Eclipse\\Project-OrangeHRM-master\\Project-OrangeHRM-master\\LoginDetails.xlsx";
		return Excelutilities.getdata(path, "Sheet1");
	}


}
