package com.stepdef;

import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;

import io.cucumber.java.en.*;

public class HomepageStepDef {

	
	HomePage hp;
	LoginPage lp;
	
	
	
	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
	 hp = new HomePage();
	
	}

	@When("user clicks on signIn")
	public void user_clicks_on_sign_in() {
		 hp.clickOnSignIn();
	}

	@Then("user should be redirected to login page")
	public void user_should_be_redirected_to_login_page() {
		 lp = new LoginPage();
		    Assert.assertTrue(lp.isLoginPageDisplayed(), "Login page is not displayed!");
	}
}
