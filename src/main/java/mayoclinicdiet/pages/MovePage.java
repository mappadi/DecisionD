package mayoclinicdiet.pages;

import framework.BrowserType;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static framework.adapters.WebDriverManager.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MovePage extends PublicHeaderMCD {

	public MovePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "move";
		String CLASS_NAME = "MovePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject landingTitle;
	protected WebObject getStartedSection;
	protected WebObject healthyBodyBenefitsSection;
	protected WebObject challengeYourselfSection;
	protected WebObject fitnessTipsSection;
	protected WebObject getStartedImage;
	protected WebObject getStartedSectionName;
	protected WebObject healthyBodyBenefitsImage;
	protected WebObject healthyBodyBenefitsSectionName;
	protected WebObject challengeYourselfImage;
	protected WebObject challengeYourselfSectionName;
	protected WebObject fitnessTipsImage;
	protected WebObject fitnessTipsSectionName;
	protected WebObject breadcrumb;

	public MovePage checkMoveUrl() {
		Logger.info("Check 'Move' url");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/diet/members/move"), "URL doesn't contain '/diet/members/move'");
		return this;
	}

	public MovePage checkLandingTitleDisplayed() {
		Logger.info("Check the 'Move' landing title is displayed");
		if (BrowserType.IE != null) {
			WebElement el = (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("landing-title")));
			el.isDisplayed();

		} else {
			boolean isTitleDisplayed =
					landingTitle
							.waitElementsReady()
							.isElementPresent();
			assertTrue(isTitleDisplayed, "The 'Move' landing title is not displayed");
		}
		return this;
	}

	public MovePage checkGetStartedSectionDisplayed() {
		Logger.info("Check the 'Get Started' section is displayed");
		boolean isGetStartedDisplayed =
				getStartedSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isGetStartedDisplayed, "The 'Get Started' section is not displayed");
		return this;
	}

	public MovePage checkHealthyBodyBenefitsSectionDisplayed() {
		Logger.info("Check the 'Healthy Body Benefits' section is displayed");
		boolean isHealthyBodyBenefitsSectionDisplayed =
				healthyBodyBenefitsSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isHealthyBodyBenefitsSectionDisplayed, "The 'Healthy Body Benefits' section is not displayed");
		return this;
	}

	public MovePage checkChallengeYourselfSectionDisplayed() {
		Logger.info("Check the 'Challenge Yourself' section is displayed");
		boolean isChallengeYourselfSectionDisplayed =
				challengeYourselfSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isChallengeYourselfSectionDisplayed, "The 'Challenge Yourself' section is not displayed");
		return this;
	}

	public MovePage checkFitnessTipsSectionDisplayed() {
		Logger.info("Check the 'FitnessTips' section is displayed");
		boolean isFitnessTipsSectionDisplayed =
				fitnessTipsSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isFitnessTipsSectionDisplayed, "The 'FitnessTips' section is not displayed");
		return this;
	}

	public MovePage checkGetStartedSection() {
		Logger.info("Check the image of 'Get Started' section is displayed");
		boolean isImageDisplayed =
				getStartedImage
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isImageDisplayed, "The image of 'Get Started' section is not displayed");

		Logger.info("Check the name of 'Get Started' section is displayed");
		boolean isNameDisplayed =
				getStartedSectionName
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNameDisplayed, "The name of 'Get Started' section is not displayed");
		return this;
	}

	public MovePage checkHealthyBodyBenefitsSection() {
		Logger.info("Check the image of 'Healthy Body Benefits' section is displayed");
		boolean isImageDisplayed =
				healthyBodyBenefitsImage
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isImageDisplayed, "The image of 'Healthy Body Benefits' section is not displayed");

		Logger.info("Check the name of 'Healthy Body Benefits' section is displayed");
		boolean isNameDisplayed =
				healthyBodyBenefitsSectionName
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNameDisplayed, "The name of 'HealthyBodyBenefits' section is not displayed");
		return this;
	}

	public MovePage checkChallengeYourselfSection() {
		Logger.info("Check the image of 'Challenge Yourself' section is displayed");
		boolean isImageDisplayed =
				challengeYourselfImage
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isImageDisplayed, "The image of 'Challenge Yourself' section is not displayed");

		Logger.info("Check the name of 'Challenge Yourself' section is displayed");
		boolean isNameDisplayed =
				challengeYourselfSectionName
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNameDisplayed, "The name of 'Challenge Yourself' section is not displayed");
		return this;
	}

	public MovePage checkFitnessTipsSection() {
		Logger.info("Check the image of 'Fitness Tips' section is displayed");
		boolean isImageDisplayed =
				fitnessTipsImage
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isImageDisplayed, "The image of 'Fitness Tips' section is not displayed");

		Logger.info("Check the name of 'Fitness Tips' section is displayed");
		boolean isNameDisplayed =
				fitnessTipsSectionName
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNameDisplayed, "The name of 'Fitness Tips' section is not displayed");
		return this;
	}

	public MovePage changeGetStartedSectionNameColourOnHover() {
		Logger.info("Check the 'Get Started' section name turns orange on hover");
		String colour = getStartedSectionName
				.waitElementsReady()
				.getCssValue("background-color");
		if (colour != "rgba(252, 252, 255, 0.9)") {
		} else {
			String splitColour = colour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 252, 255, 0.9)", "Default colour of the 'Get Started' section name is not correct");
		}

		WebElement getStartedSectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mayodiet/images/move-get-started-main-landing.jpg']"));
		withActions().moveToElement(getStartedSectionName).build().perform();
		String hoverColour = getStartedSectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "transparent", "The 'Get Started' section name is not turn Orange on hover");
		}
		return this;
	}

	public MovePage changeHealthyBodyBenefitsSectionNameColourOnHover() {
		Logger.info("Check the 'Healthy Body Benefits' section name turns orange on hover");
		String colour = healthyBodyBenefitsSectionName
				.waitElementsReady()
				.getCssValue("background-color");
		if (colour != "rgba(252, 252, 255, 0.9)") {
		} else {
			String splitColour = colour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 252, 255, 0.9)", "Default colour of the 'Healthy Body Benefits' section name is not correct");
		}

		WebElement healthyBodyBenefitsSectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mayodiet/images/move-healthy-body-benefits-main-landing.jpg']+h2"));
		withActions().moveToElement(healthyBodyBenefitsSectionName).build().perform();
		String hoverColour = healthyBodyBenefitsSectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 94, 21, 0.9)", "The 'Healthy Body Benefits' section name is not turn Orange on hover");
		}
		return this;
	}

	public MovePage changeChallengeYourselfSectionNameColourOnHover() {
		Logger.info("Check the 'Challenge Yourself' section name turns orange on hover");
		String colour = challengeYourselfSectionName
				.waitElementsReady()
				.getCssValue("background-color");
		if (colour != "rgba(252, 252, 255, 0.9)") {
		} else {
			String splitColour = colour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 252, 255, 0.9)", "Default colour of the 'Challenge Yourself' section name is not correct");
		}

		WebElement challengeYourselfSectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mayodiet/images/move-challenge-yourself-main-landing.jpg']+h2"));
		withActions().moveToElement(challengeYourselfSectionName).build().perform();
		String hoverColour = challengeYourselfSectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 94, 21, 0.9)", "The 'Challenge Yourself' section name is not turn Orange on hover");
		}
		return this;
	}

	public MovePage changeFitnessTipsSectionNameColourOnHover() {
		Logger.info("Check the 'Fitness Tips' section name turns orange on hover");
		String colour = fitnessTipsSectionName
				.waitElementsReady()
				.getCssValue("background-color");
		if (colour != "rgba(252, 252, 255, 0.9)") {
		} else {
			String splitColour = colour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 252, 255, 0.9)", "Default colour of the 'Fitness Tips' section name is not correct");
		}

		WebElement fitnessTipsSectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mayodiet/images/move-fitness-tips-main-landing.jpg']+h2"));
		withActions().moveToElement(fitnessTipsSectionName).build().perform();
		String hoverColour = fitnessTipsSectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			assertEquals(hoverColour, "rgba(252, 94, 21, 0.9)", "The 'Fitness Tips' section name is not turn Orange on hover");
		}
		return this;
	}

	public MoveGetStartedPage clickGetStartedName() {
		Logger.info("Click on 'Get Started' section name");
		getStartedSectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MoveGetStartedPage.class);
	}

	public MoveHealthyBodyBenefitsPage clickHealthyBodyBenefitsName() {
		Logger.info("Click on 'Healthy Body Benefits' section name");
		healthyBodyBenefitsSectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MoveHealthyBodyBenefitsPage.class);
	}

	public MoveChallengeYourselfPage clickChallengeYourselfName() {
		Logger.info("Click on 'Challenge Yourself' section name");
		challengeYourselfSectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MoveChallengeYourselfPage.class);
	}

	public MoveFitnessTipsPage clickFitnessTipsName() {
		Logger.info("Click on 'Fitness Tips' section name");
		fitnessTipsSectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MoveFitnessTipsPage.class);
	}

	public MovePage checkMoveBreadcrumb() {
		Logger.info("Check the breadcrumb");
		String breadcrumbs = breadcrumb
				.waitElementsReady()
				.getText();
		assertEquals(breadcrumbs, "HOMEMOVE", "The breadcrumb is not correct");
		return this;
	}
}
