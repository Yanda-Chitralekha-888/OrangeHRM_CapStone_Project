package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_pagefactory {
    
    
  

	

    // Elements
    @FindBy(name="username")
    WebElement uname;

    @FindBy(name="password")
    WebElement pword;
//
//    @FindBy(xpath="//button[@type='submit']")
//    WebElement loginbutton;
    @FindBy(xpath="//*[@id=\"login\"]/button/i")
    WebElement loginbutton;

    // Actions
    public void enterusername(String username) {
        uname.sendKeys(username);
    }

    public void enterpassword(String password) {
        pword.sendKeys(password);
    }

    public void clickonlogin() {
        loginbutton.click();
    }
}