package com.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.DriverManager;
import com.utility.WaitUtils;



public class LoginPage extends DriverManager {

	
	
	
	
	
	//Elements 
	
	@FindBy(xpath= "//input[@id='Email' or @id='email' or @placeholder='Enter your email']")
	WebElement email;
	
	
	@FindBy(xpath= "//input[@id='password' or @type='password' or @placeholder='Enter your password']")
	WebElement password;
	
	
	
	@FindBy(xpath="//span[text()='Login']")
	WebElement logIn;
	
	@FindBy(xpath="//h1[contains(text(),'Welcome Back!')]")
	WebElement headingElement;
	
	public LoginPage(){
		PageFactory.initElements(webDriver.get(), this);
	}
	
	
	
	//Action methods
	
	public void verifyLoginPage(String userEmail, String userPassword) {
	    WaitUtils.safeSendKeys(email, userEmail);
	    WaitUtils.safeSendKeys(password, userPassword);
	    
	}

	public void clickOnButton() {
		WaitUtils.safeClick(logIn);
		
	}
	
	public boolean isLoginPageDisplayed() {
	    WaitUtils.waitUntilVisible(headingElement);
	    return headingElement.isDisplayed();
	}
	
}
