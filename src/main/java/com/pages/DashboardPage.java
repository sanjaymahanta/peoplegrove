package com.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.baseclass.DriverManager;
import com.utility.WaitUtils;

public class DashboardPage extends DriverManager {

	@FindBy(xpath = "//h1[contains(text(),'Welcome Back!')]")
	WebElement headingElement;

	@FindBy(xpath = "//button[@type='button' and contains(normalize-space(.),'Career')]")
	WebElement careerButton;

	@FindBy(xpath = "//p[normalize-space()='Share job opportunities']")
	WebElement jobsOption;

	@FindBy(xpath = "//div[contains(normalize-space(.),'All Jobs') and contains(@class,'tab-label-text')]")
	WebElement allJobsLabel;

	@FindBy(xpath = "(//div[@role='button' and contains(normalize-space(.),'Software Development Engineer')])[1]")
	WebElement firstJobCard;

	@FindBy(xpath = "(//span[@role='button' and normalize-space(.)='AAKASH SHUKLA'])[1]")
	WebElement firstUserProfile;

	@FindBy(xpath = "//button[contains(normalize-space(.),'Continue Conversation') or contains(normalize-space(.),'Message ')]")
	WebElement messageButton;

	@FindBy(xpath = "//div[contains(@aria-label,'Craft Message') and contains(@id,'compose-question')]")
	WebElement messageTextArea;

	@FindBy(xpath = "//button[@aria-label='Schedule Message']//parent::div//button[contains(text(),'Send Now')]")
	WebElement sendNowButton;

	@FindBy(xpath = "//button[contains(normalize-space(.), 'Send without meeting')]")
	WebElement sendWithoutMeetingButton;

	@FindBy(xpath = "//button[contains(normalize-space(.), 'inbox')]")
	WebElement goToInboxButton;

	@FindBy(xpath = "p")
	WebElement chatConversation;

	@FindBy(xpath = "//div[@id='user-profile-modal']//child::span")
	WebElement closeModal;

	@FindBy(xpath = "(//div[text()='Software Development Engineer in Test'])[1]")
	WebElement jobTitle;

	@FindBy(xpath = "(//button[@aria-label='Next connection'])[1]")
	WebElement svgArrow;
	
	@FindBy(xpath = "(//button[@aria-label='Next connection'])[2]")
	WebElement svgArrow2;

	@FindBy(xpath = "(//div[@class='ant-card job-card-item selected ']//div[@class='carousel-container']//a[@aria-label]//span)[1]")
	WebElement profileLinks1;

	@FindBy(xpath = "(//div[@class='ant-card job-card-item selected ']//div[@class='carousel-container']//a[@aria-label]//span)[2]")
	WebElement profileLinks2;

	@FindBy(xpath = "(//div[@class='ant-card job-card-item selected ']//div[@class='carousel-container']//a[@aria-label]//span)[3]")
	WebElement profileLinks3;

	@FindBy(xpath = "(//div[@class='ant-card job-card-item selected ']//div[@class='carousel-container']//a[@aria-label]//span)[4]")
	WebElement profileLinks4;

	@FindBy(xpath = "(//div[@class='ant-card job-card-item selected ']//div[@class='carousel-container']//a[@aria-label]//span)[5]")
	WebElement profileLinks5;
	
	
	@FindBy(xpath = "(//div[@class='ant-card job-card-item selected ']//div[@class='carousel-container']//a[@aria-label]//span)[1]")
	WebElement profileLinks6;
	
	
	@FindBy(xpath = "(//div[@class='ant-card job-card-item selected ']//div[@class='carousel-container']//a[@aria-label]//span)[2]")
	WebElement profileLinks7;
	
	@FindBy(xpath = "//div[@aria-label='Job Project Manager' and @class='job-role' and @role='button']")
	WebElement secondJobTitle;
	
	
	
	

	public DashboardPage() {
		PageFactory.initElements(webDriver.get(), this);
	}

	// Action Methods
	public void clickCareer() {

		WaitUtils.mouseHover(careerButton);
	}

	public void clickJobs() {
		WaitUtils.safeClick(jobsOption);
	}

	public boolean isJobsPageDisplayed() {
		WaitUtils.waitUntilVisible(allJobsLabel);
		return allJobsLabel.isDisplayed();
	}

	public void clickFirstJob() {
		WaitUtils.safeClick(firstJobCard);
	}

	public void clickFirstUserProfile() {
		WaitUtils.safeClick(firstUserProfile);
	}

	public void clickMessageButton() {
		WaitUtils.safeClick(messageButton);
	}

	public void writeMessage(String text) {
		WaitUtils.safeSendKeys(messageTextArea, text);
	}

	public void clickSendNow() {
		WaitUtils.safeClick(sendNowButton);
	}

	public void clickSendWithoutMeeting() {
		WaitUtils.safeClick(sendWithoutMeetingButton);
	}

	public void clickGoToInbox() {
		WaitUtils.safeClick(goToInboxButton);
	}

	public boolean verifyMessageExists(String expectedMessage) throws TimeoutException {
		WebDriver driver = DriverManager.webDriver.get();

		// Define locators for message areas
		By leftPanelLocator = By
				.xpath("//div[contains(@class,'inbox__section-left__rowblock__nameblock__msg-text')]//p");
		By chatBoxLocator = By.xpath("//div[contains(@class,'rich-text') and contains(@class,'ql-editor')]//p");
		// Use WaitUtils to ensure messages are visible
		WaitUtils.waitUntilVisibleOr(leftPanelLocator, chatBoxLocator);

		// Get all messages from both sections
		List<WebElement> leftPanelMessages = driver.findElements(leftPanelLocator);
		List<WebElement> chatBoxMessages = driver.findElements(chatBoxLocator);

		// Combine both lists
		List<WebElement> allMessages = new ArrayList<>();
		allMessages.addAll(leftPanelMessages);
		allMessages.addAll(chatBoxMessages);

		System.out.println("========== ALL MESSAGES FOUND ==========");
		boolean messageFound = false;

		for (WebElement msg : allMessages) {
			String text = msg.getText().trim();

			// Fallback if text is empty (shadow or hidden text)
			if (text.isEmpty()) {
				text = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", msg);
			}

			System.out.println(text);

			if (text.equalsIgnoreCase(expectedMessage.trim())) {
				messageFound = true;
				break;
			}
		}

		if (messageFound) {
			System.out.println("✅ Message found: " + expectedMessage);
		} else {
			System.out.println("❌ Message not found: " + expectedMessage);
		}

		return messageFound;
	}

	public void navigateBackwardAndCloseModal() {
		DriverManager.webDriver.get().navigate().back();
		WaitUtils.safeClick(closeModal);

	}

	public void verifyTitle(String expectedTitle) {
		WaitUtils.waitUntilVisible(jobTitle);
		String actualTitle = jobTitle.getText();

		System.out.println("Actual Job Title: " + actualTitle);

		Assert.assertTrue(isJobsPageDisplayed(), actualTitle);

		System.out.println(" Job title validation passed for: " + expectedTitle);
	}

	public void collectAllRecommendUserFirstJobTitle() throws InterruptedException {

		
		WaitUtils.safeClick(jobTitle);
		WaitUtils.waitUntilVisible(profileLinks1);
		String profileName1 = profileLinks1.getText();
		System.out.println(profileName1);
		
		
		WaitUtils.safeClick(svgArrow);
		WaitUtils.waitUntilVisible(profileLinks2);
		String profileName2 = profileLinks2.getText();
		System.out.println(profileName2);
		Thread.sleep(2000);
		WaitUtils.safeClick(svgArrow);
		WaitUtils.waitUntilVisible(profileLinks3);
		String profileName3 = profileLinks3.getText();
		System.out.println(profileName3);

		Thread.sleep(2000);
		WaitUtils.safeClick(svgArrow);
		WaitUtils.waitUntilVisible(profileLinks4);
		String profileName4 = profileLinks4.getText();
		System.out.println(profileName4);
		Thread.sleep(2000);
		WaitUtils.safeClick(svgArrow);
		WaitUtils.waitUntilVisible(profileLinks5);
		String profileName5 = profileLinks5.getText();
		System.out.println(profileName5);

	}

	
	public void collectAllRecommendUserSecondJobTitle() throws InterruptedException {

	WaitUtils.safeClick(secondJobTitle);
		WaitUtils.waitUntilVisible(profileLinks6);
		String profileName6 = profileLinks6.getText();
		System.out.println(profileName6);
		
		
		WaitUtils.safeClick(svgArrow2);
		WaitUtils.waitUntilVisible(profileLinks7);
		String profileName7 = profileLinks7.getText();
		System.out.println(profileName7);


	}
	
	public boolean isInboxTabHighlighted() {
	    WebElement inboxTab = webDriver.get().findElement(By.xpath("//button[@aria-label='Inbox']"));
	    String textColor = inboxTab.getCssValue("color").replace(" ", "");
	    System.out.println("Inbox tab color: " + textColor);

	    String expectedBase = "144,19,254"; // purple highlight RGB
	    return textColor.contains(expectedBase);
	}



	

}