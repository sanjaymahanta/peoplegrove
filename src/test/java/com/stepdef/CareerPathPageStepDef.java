package com.stepdef;



import com.baseclass.DriverManager;
import com.pages.CareerPathPage;

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
	   cpp.careerPath();
	   
	}

	@When("the user selects any career path")
	public void the_user_selects_any_career_path() {
	    cpp.selectCarrerPath();
	}

	@Then("the selected career path detail page should open")
	public void the_selected_career_path_detail_page_should_open() {
	    cpp.verifyUniqueElementDisplayed(cpp.actorCareerPage);
	   
	}

	@When("the user clicks the browser back button")
	public void the_user_clicks_the_browser_back_button() {
		DriverManager.webDriver.get().navigate().back();
		System.out.println("Navigated back to Career Path list");
	}

	@Then("the user should be navigated back to the Career Paths page")
	public void the_user_should_be_navigated_back_to_the_career_paths_page() {
		cpp.verifyUniqueElementDisplayed(cpp.updateProfile);
	}

	@When("the user selects two more different career paths of their choice")
	public void the_user_selects_two_more_different_career_paths_of_their_choice() {
	    cpp.selectSecondCareerPaths();
	    cpp.verifyUniqueElementDisplayed(cpp.advertisingCareerPage);
	    DriverManager.webDriver.get().navigate().back();
		System.out.println("Navigated back to Career Path list");
		cpp.selectThirdCareerPaths();cpp.verifyUniqueElementDisplayed(cpp.agriculturalCareerPage);
	    DriverManager.webDriver.get().navigate().back();
		System.out.println("Navigated back to Career Path list");
	}

	@When("the user clicks on {string} from the top navbar")
	public void the_user_clicks_on_from_the_top_navbar(String string) {
	    cpp.navigateHomePage();
	   
	}

	@Then("the homepage should be displayed")
	public void the_homepage_should_be_displayed() {
		 cpp.verifyUniqueElementDisplayed(cpp.homePageElement);
	}

	@Then("in the {string} section")
	public void in_the_section(String string) {
	System.out.println("Skipping for some time");
	}

	@Then("the most recently viewed career path should appear first")
	public void the_most_recently_viewed_career_path_should_appear_first() {
	    cpp.verifyRecentlyViewedOrder();
	}
}
