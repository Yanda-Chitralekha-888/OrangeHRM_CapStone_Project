package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.v136CdpInfo;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;



public class Loginpage {

	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	

    public Loginpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }




	By uname = 	By.xpath("//input[@name='username']");

	By pword = 	By.xpath("//input[@name='password']");
	By loginbutton = By.xpath("//button[@type='submit']");

	By seach = By.xpath("//*[@id=\"twotabsearchtextbox\"]");
	By submit =By.xpath("//*[@id=\"nav-search-submit-button\"]");
	By  dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	By timeAtWorkWidget = By.xpath("//p[text()='Time at Work']");
	By selectDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span");
	By logoutOption = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a");

	By adminlogin = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
	By clickadd = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button");
	By userRoleDropdown = By.xpath("//label[text()='User Role']/following::div[@class='oxd-select-wrapper'][1]//div[contains(@class,'oxd-select-text')]");
	By userRoleOptions = By.xpath("//div[@role='listbox']//div[@role='option']");
	By selectStatus = By.xpath("//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]");
	By chooseStatus = By.xpath("//div[@role='listbox']//div[@role='option']");

	By addEmployeeName  = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
	By usernameField = By.xpath("//label[text()='Username']/following::input[1]");
	By passwordField = By.xpath("//label[text()='Password']/following::input[@type='password'][1]");
	By confirmPasswordField = By.xpath("//label[text()='Confirm Password']/following::input[@type='password'][1]");
	By saveButton = By.xpath("//button[@type='submit' and text()=' Save ']");

	By NavPim       = By.xpath("//span[text()='PIM']");
	By NavEmpName   = By.xpath("//label[text()='Employee Name']/following::input[1]");
	By NavEmpId     = By.xpath("//label[text()='Employee Id']/following::input[1]");
	By NavSupName   = By.xpath("//label[text()='Supervisor Name']/following::input[1]");
	By NavSubmit    = By.xpath("//button[@type='submit' and normalize-space(text())='Search']");
	By NavLeave   = By.xpath("//span[text()='Leave']");
	By FromDate   = By.xpath("//label[text()='From Date']/following::input[1]");
	By ToDate     = By.xpath("//label[text()='To Date']/following::input[1]");
	By Submit = By.xpath("//button[@type='submit' and contains(., 'Search')]");
	By ResultRows = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-row oxd-table-row--with-border']");
	By NoRecordsFound = By.xpath("//span[text()='No Records Found']");


	By navTime        = By.xpath("//span[text()='Time']");
	By navProjectInfo = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span");
	By projects       = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[4]/ul/li[2]");
	By customerInput  = By.xpath("//label[text()='Customer Name']/following::input[1]");
	By projectInput   = By.xpath("//label[text()='Project']/following::input[1]");
	By searchButton   = By.xpath("//button[@type='submit' and contains(., 'Search')]");

	


	public void EnterUserName(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(uname));
		userField.sendKeys(username);
	}

	public void Enterpassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(pword));
		passField.sendKeys(password);
	}

	public void Clickonlogin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
		loginBtn.click();
	}




	public void enterusernam(String username) {
		driver.findElement(uname).sendKeys(username);
	}


	public void enterpassword(String password)
	{
		driver.findElement(pword).sendKeys(password);
	}


	public void clickonlogin()
	{
		driver.findElement(loginbutton).click();
	}

	public void searchitem(String item) {
		driver.findElement(seach).sendKeys(item);
	}
	public void submititem() {
		driver.findElement(submit).click();
	}
	public boolean verifyDashboard() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
		return dashboard.isDisplayed();
	}

	public boolean verifyTimeAtWorkWidget() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement timeWidget = wait.until(ExpectedConditions.visibilityOfElementLocated(timeAtWorkWidget));
		return timeWidget.isDisplayed();
	}


	public void NavigateTOAdmin() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement adminwidget = wait.until(ExpectedConditions.elementToBeClickable(adminlogin));
		adminwidget.click();

	}
	public void ClickAddOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement adminwidget = wait.until(ExpectedConditions.elementToBeClickable(clickadd));
		adminwidget.click();
	}


	// MODIFY YOUR EXISTING AddSystemUser METHOD:
	public void AddSystemUser(String userRole) {  // Add parameter
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown));
		dropdown.click();

		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(userRoleOptions));
		for (WebElement option : options) {
			System.out.println("Option: " + option.getText());
			if (option.getText().equals(userRole)) {  // Use parameter instead of hardcoded "Admin"
				option.click();
				break;
			}
		}
	}

	// MODIFY YOUR EXISTING SelectUserStatus METHOD:
	public void SelectUserStatus(String status) {  // Add parameter
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(selectStatus));
		dropdown.click();

		List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(chooseStatus));
		for (WebElement option : options) {
			System.out.println("Option: " + option.getText());
			if (option.getText().equals(status)) {  // Use parameter instead of hardcoded "Enabled"
				option.click();
				break;
			}
		}
	}

	public void AddEmployeeName(String name) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(addEmployeeName));
		userField.sendKeys(name);

	}


	public void EnterUsername(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement usernameFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
		usernameFieldElement.clear();
		usernameFieldElement.sendKeys(username);
	}

	// Password field  

	public void EnterPassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement passwordFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
		passwordFieldElement.clear();
		passwordFieldElement.sendKeys(password);
	}

	// Confirm Password field

	public void EnterConfirmPassword(String confirmPassword) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement confirmPasswordFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField));
		confirmPasswordFieldElement.clear();
		confirmPasswordFieldElement.sendKeys(confirmPassword);
	}

	// Save button


	public void ClickSaveButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveBtn.click();
	}



	public void NavigateTOPIM() throws InterruptedException {
		driver.findElement(NavPim).click();
		Thread.sleep(2000);
	}// Navigate to PIM

	public void EnterEmpname(String employeeName) throws InterruptedException {
		driver.findElement(NavEmpName).sendKeys(employeeName);
		Thread.sleep(1000);
	}

	// Fill search form
	public void EnterEmployeeID(String employeeID) throws InterruptedException {
		driver.findElement(NavEmpId).sendKeys(employeeID);
		Thread.sleep(1000);
	}

	public void EnterSuperViserName(String SuperViser) throws InterruptedException {
		driver.findElement(NavSupName).sendKeys(SuperViser);
		Thread.sleep(1000);
	}

	public void EnterSubmit() throws InterruptedException {
		driver.findElement(NavSubmit).click();
		Thread.sleep(3000);
	}
	public void NavigateToLeave(String from, String to) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(NavLeave)).click();

		WebElement fromDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(FromDate));
		fromDateField.clear();
		fromDateField.sendKeys(from);

		WebElement toDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(ToDate));
		toDateField.clear();
		toDateField.sendKeys(to);

		WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(Submit));
		searchBtn.click();
	}
	public void navigateToProjectSearch() {
	    wait.until(ExpectedConditions.elementToBeClickable(navTime)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(navProjectInfo)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(projects)).click();
	}

	public void enterCustomerName(String customer) {
	    WebElement customerField = wait.until(ExpectedConditions.visibilityOfElementLocated(customerInput));
	    customerField.clear();
	    customerField.sendKeys(customer);
	}

	public void enterProjectName(String project) {
	    WebElement projectField = wait.until(ExpectedConditions.visibilityOfElementLocated(projectInput));
	    projectField.clear();
	    projectField.sendKeys(project);
	}

	public void clickSearchButton() {
	    WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
	    searchBtn.click();
	}



	public void selectDropdownforlogout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


		WebElement dropdownIcon = wait.until(ExpectedConditions.elementToBeClickable(selectDropdown));
		dropdownIcon.click();

		// Wait and click on Logout option
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutOption));
		logout.click();

		System.out.println("Logout option clicked successfully.");
	}






}



