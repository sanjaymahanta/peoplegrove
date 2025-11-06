package com.stepdef;

import com.pages.DashboardPage;
import com.pages.LoginPage;

import io.cucumber.java.en.*;

public class LoginStepDef {

	LoginPage lp;
	DashboardPage dp;
	
	
	@When("the user logs in with valid credentials")
	public void the_user_logs_in_with_valid_credentials() {
		lp = new LoginPage();
		lp.verifyLoginPage("sanjaykmahanta28@gmail.com", "Ilovepeoplegrove@123");
	}

	@When("clicks on loginButton")
	public void clicks_on_login_button() {
	  lp.clickOnButton();
	}

	@Then("the user should be redirected to the dashboard page")
	public void the_user_should_be_redirected_to_the_dashboard_page() {
		dp = new DashboardPage();
	    
	    System.out.println("User is on Dashboard Page");
	}
}
