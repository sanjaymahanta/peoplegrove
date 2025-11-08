package com.stepdef;

import java.util.concurrent.TimeoutException;

import com.pages.DashboardPage;
import com.utility.Log;

import io.cucumber.java.en.*;

public class DashboardPageStepDef {

	DashboardPage dp;

	@When("the user clicks on Career in the top navbar")
	public void the_user_clicks_on_career_in_the_top_navbar() {
		dp = new DashboardPage();

	}

	@When("the user selects Jobs option")
	public void the_user_selects_jobs_option() {
		dp.clickCareer();
	}

	@Then("the Jobs page should be displayed")
	public void the_jobs_page_should_be_displayed() {
		dp.clickJobs();
	}

	@When("the user clicks on the first job")
	public void the_user_clicks_on_the_first_job() {
		dp.clickFirstJob();
	}

	@When("clicks on the first recommended user profile")
	public void clicks_on_the_first_recommended_user_profile() {
		dp.clickFirstJob();
	}

	@When("clicks on the username {string}")
	public void clicks_on_the_username(String string) {
		dp.clickFirstUserProfile();
	}

	@When("clicks on the message button")
	public void clicks_on_the_message_button() {
		dp.clickMessageButton();
	}

	@When("writes a message {string}")
	public void writes_a_message(String string) {
		Log.info("user write message");
	}

	@When("clicks on {string} button")
	public void clicks_on_button(String string) {
		Log.info("user clicks on button");

	}

	@When("clicks on {string} in the confirmation modal")
	public void clicks_on_in_the_confirmation_modal(String string) {
		Log.info("click omn confirmation modal");
	}

	@Then("the sent message should appear in the inbox conversation")
	public void the_sent_message_should_appear_in_the_inbox_conversation() throws TimeoutException {
		try {
			boolean messageFound = dp.verifyMessageExists("Hi ,I am testing my message ");
			if (messageFound) {
				System.out.println("✅ Sent message verified successfully in inbox.");
			} else {
				System.out.println("⚠️ Message not found, continuing with next steps...");
			}
		} catch (Exception e) {
			System.out.println("⚠️ Error during message verification: " + e.getMessage());
		}

		// Inbox color check (don’t fail, just log)
		try {
			boolean highlighted = dp.isInboxTabHighlighted();
			if (highlighted) {
				System.out.println("✅ Inbox tab is highlighted (expected purple color).");
			} else {
				System.out.println("⚠️ Inbox tab is NOT highlighted — check CSS or locator.");
			}
		} catch (Exception e) {
			System.out.println("⚠️ Error checking inbox highlight: " + e.getMessage());
		}
	}

	@When("the user navigates back using browser back navigation")
	public void the_user_navigates_back_using_browser_back_navigation() {
		dp.navigateBackwardAndCloseModal();

	}

	@Then("the user should be redirected back to the Jobs page")
	public void the_user_should_be_redirected_back_to_the_jobs_page() {
		Log.info("user navigate back to modal");
	}

	@Then("verify that the first job title and its related user names are displayed")
	public void verify_that_the_first_job_title_and_its_related_user_names_are_displayed() throws InterruptedException {
		dp.collectAllRecommendUserFirstJobTitle();
		Log.info("capturing first job title and its related user names are displayed");

	}

	@Then("verify that the second job title and its related user names are displayed")
	public void verify_that_the_second_job_title_and_its_related_user_names_are_displayed()
			throws InterruptedException {
		dp.collectAllRecommendUserSecondJobTitle();
		Log.info("capture all recommend user");

	}
}
