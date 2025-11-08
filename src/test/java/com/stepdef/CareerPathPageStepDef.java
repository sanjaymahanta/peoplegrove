package com.stepdef;





import com.baseclass.DriverManager;
import com.pages.CareerPathPage;
import com.utility.Log;

import io.cucumber.java.en.*;

public class CareerPathPageStepDef {

	CareerPathPage cpp;
	
	@When("the user mouse hovers over Career in the top navbar")
	public void the_user_mouse_hovers_over_career_in_the_top_navbar() {
	   cpp = new CareerPathPage();
			   cpp.hoverCarrer();
	}

	@When("the user click {string} option")
	public void the_user_click_option(String string) {
	   cpp.selectCarrerPathOption();
	}
	
	
	@Then("the Career Paths page should be displayed")
	public void the_career_paths_page_should_be_displayed() {
	   cpp.verifyUniqueElementDisplayed(cpp.updateProfile);
	}

	@When("the user scrolls down to the {string} section")
	public void the_user_scrolls_down_to_the_section(String string) {
	   cpp.clickCareerPath();
	   
	}

	@When("the user selects any career path")
	public void the_user_selects_any_career_path() throws InterruptedException {
		cpp.selectCarrerPath();
		Log.info("Navigate back Select Career Path page");
	}

	@Then("the selected career path detail page should open")
	public void the_selected_career_path_detail_page_should_open() throws InterruptedException {
		cpp.verifyUniqueElementDisplayed(cpp.artDirectorCareerPage);
	    Log.info("art director page is opened");
	   
	}

	@When("the user clicks the browser back button")
	public void the_user_clicks_the_browser_back_button() throws InterruptedException {
		DriverManager.webDriver.get().navigate().back();
		Log.info("Navigate back Career Path page");
	}

	@Then("the user should be navigated back to the Career Paths page")
	public void the_user_should_be_navigated_back_to_the_career_paths_page() {
		cpp.verifyUniqueElementDisplayed(cpp.updateProfile);
		Log.info("naviagte back to career path page");
	}

	@When("the user selects two more different career paths of their choice")
	public void the_user_selects_two_more_different_career_paths_of_their_choice() throws InterruptedException {
		Log.info("Select second career path");
	    cpp.selectSecondCareerPaths();
	    Log.info("Verifying atheleteCareer page is opened");
	    cpp.verifyUniqueElementDisplayed(cpp.atheletCareerPage);
	    DriverManager.webDriver.get().navigate().back();
		Log.info("Navigat eback to career page");
		cpp.selectThirdCareerPaths();
		Log.info("budgetAnalyst page is opened");
		cpp.verifyUniqueElementDisplayed(cpp.budgetAnalystCareerPage);
	    DriverManager.webDriver.get().navigate().back();
		Log.info("Navigate back to career page");
	}

	@When("the user clicks on {string} from the top navbar")
	public void the_user_clicks_on_from_the_top_navbar(String string) throws InterruptedException {
	 cpp.navigateHomePage();
	   
	}

	@Then("the homepage should be displayed")
	public void the_homepage_should_be_displayed() throws InterruptedException {
	
		Log.info("Homepage is displayed");
	}

	@Then("in the {string} section")
	public void in_the_section(String string) {
	Log.info("navigat eto reviewed section");
	}

	@Then("the most recently viewed career path should appear first")
	public void the_most_recently_viewed_career_path_should_appear_first() {
	    cpp.verifyRecentlyViewedOrder();
	}
}
