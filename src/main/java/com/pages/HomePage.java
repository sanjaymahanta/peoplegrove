package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.DriverManager;
import com.utility.WaitUtils;



public class HomePage extends DriverManager{

	
	
	
	// Elements
		@FindBy(xpath = "//button[contains(normalize-space(text()),'Sign In')]")
		WebElement signIn;

		
		
		public HomePage(){
			PageFactory.initElements(webDriver.get(), this);
		}
		
		
		//Action Methods
		
		
		public void clickOnSignIn() {
			WaitUtils.safeClick(signIn);
	
			
		
		}
		
		

		

}
