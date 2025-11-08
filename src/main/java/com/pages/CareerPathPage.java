package com.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.baseclass.DriverManager;
import com.utility.WaitUtils;

public class CareerPathPage extends DriverManager {

	@FindBy(xpath = "//button[@type='button' and contains(normalize-space(.),'Career')]")
	WebElement careerButton;

	@FindBy(xpath = "//p[normalize-space()='Career Paths']")
	WebElement carrerPath;

	@FindBy(xpath = "//button[@type='button' and normalize-space()='Update profile']")
	public WebElement updateProfile;

	@FindBy(xpath = "//button[contains(normalize-space(.),'View all career paths')]")
	WebElement allCarrerPath;

	@FindBy(xpath = "//a[@title='Art Directors' and contains(normalize-space(.),'Art Directors')]")
	WebElement artDirector;

	@FindBy(xpath = "//a[@title='Athletes and Sports Competitors' and contains(normalize-space(text()), 'Athletes and Sports Competitors')]")
	WebElement atheletsAnsSports;

	@FindBy(xpath = "//a[@title='Budget Analysts' and contains(normalize-space(text()), 'Budget Analysts')]")
	WebElement budgetAnalysts;

	@FindBy(xpath = "//h2[@class='career-title' and contains(normalize-space(.),'Art Directors') ]")
	public WebElement artDirectorCareerPage;

	@FindBy(xpath = "//h2[@class='career-title' and contains(normalize-space(.),'Athletes and Sports Competitors') ]")
	public WebElement atheletCareerPage;

	@FindBy(xpath = "//h2[@class='career-title' and contains(normalize-space(.),'Budget Analysts') ]")
	public WebElement budgetAnalystCareerPage;

	@FindBy(xpath = "(//div[@class='Carousel-module_slider__XQtIN'])[2]")
	WebElement recentVistorSection;

	@FindBy(xpath = "//h2[contains(normalize-space(.), 'Recently viewed careers')]")
	WebElement recentlyViewedHeading;

	@FindBy(xpath = "//div[@id='navlist-ele-0']//child::button")
	WebElement homeButton;

	@FindBy(xpath = "//div[@id='JTBDHomePage']//child::h2[contains(normalize-space(.),'Create your network')]")
	public WebElement homePageElement;

	public CareerPathPage() {
		PageFactory.initElements(webDriver.get(), this);
	}

	public void hoverCarrer() {
		WaitUtils.mouseHover(careerButton);
		Assert.assertTrue(careerButton.isDisplayed(), "Career button not visible to hover");

	}

	public void selectCarrerPathOption() {
		WaitUtils.clickWithFluentWait(carrerPath);
		 System.out.println(" Career Path option clicked safely with FluentWait");
		  
	}

	public void verifyUniqueElementDisplayed(WebElement element) {
		WaitUtils.waitUntilVisible(element);
		Assert.assertTrue(element.isDisplayed(), "❌ Career Path page is not displayed!");
		System.out.println("Unique element is found .");
	}

	public void clickCareerPath() {
		WaitUtils.clickWithFluentWait(allCarrerPath);
		
	}

	public void selectCarrerPath() {
		WaitUtils.clickWithFluentWait(artDirector);
		

	}

	public void selectSecondCareerPaths() {
		WaitUtils.clickWithFluentWait(atheletsAnsSports);
		

	}

	public void selectThirdCareerPaths() {
		WaitUtils.clickWithFluentWait(budgetAnalysts);
		

	}

	public void navigateHomePage() {
		WaitUtils.clickWithFluentWait(homeButton);
		System.out.println(" Navigated to Home Page for verification");
	}

	public void verifyRecentlyViewedOrder() {
		List<String> selectedCareerPaths = new ArrayList<>();
		selectedCareerPaths.add("Art Directors");
		selectedCareerPaths.add("Athletes and Sports Competitors");
		selectedCareerPaths.add("Budget Analysts");

		// ✅ Step 3: Scroll to Recently Viewed Careers heading
		WaitUtils.scrollToElement(recentlyViewedHeading);
		WaitUtils.waitUntilVisible(recentlyViewedHeading);
		System.out.println("🔍 Scrolled to 'Recently Viewed Careers' section");

		// ✅ Step 4: Find the correct container (2nd carousel)
		WebElement section = webDriver.get().findElement(By.xpath(
				"(//div[@class='Carousel-module_slider__XQtIN' and @aria-live='polite'])[2]"));
		WaitUtils.waitUntilVisible(section);

		// ✅ Step 5: Fetch all visible career names
		List<WebElement> elements = section.findElements(By.xpath(".//a[contains(@class,'title__NqdfV')]"));
		List<String> actualOrder = new ArrayList<>();
		for (WebElement e : elements) {
			actualOrder.add(e.getText().trim());
		}

		System.out.println("🧩 Actual recently viewed careers on homepage: " + actualOrder);

		// ✅ Step 6: Reverse expected list (last viewed should appear first)
		Collections.reverse(selectedCareerPaths);
		System.out.println("📋 Expected recently viewed careers order: " + selectedCareerPaths);

		// ✅ Step 7: Compare order safely
		boolean isSameOrder = true;
		int compareSize = Math.min(actualOrder.size(), selectedCareerPaths.size());
		for (int i = 0; i < compareSize; i++) {
			if (!actualOrder.get(i).equalsIgnoreCase(selectedCareerPaths.get(i))) {
				isSameOrder = false;
				System.out.println("❌ Mismatch at position " + i + ": expected '" + selectedCareerPaths.get(i)
						+ "' but found '" + actualOrder.get(i) + "'");
			}
		}

		// ✅ Step 8: Final assertion
		Assert.assertTrue(isSameOrder, "❌ Recently viewed careers are not in correct order!");
		System.out.println("✅ Recently viewed careers displayed in correct order on homepage.");
	}

}
