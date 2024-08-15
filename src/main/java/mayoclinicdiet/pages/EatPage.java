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

public class EatPage extends PublicHeaderMCD {

	public EatPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "eat";
		String CLASS_NAME = "EatPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject landingTitle;
	protected WebObject getStartedSection;
	protected WebObject smartFoodChoicesSection;
	protected WebObject mealsMadeEasySection;
	protected WebObject eatingOutSection;
	protected WebObject getStartedImage;
	protected WebObject getStartedSectionName;
	protected WebObject smartFoodChoicesImage;
	protected WebObject smartFoodChoicesSectionName;
	protected WebObject mealsMadeEasyImage;
	protected WebObject mealsMadeEasySectionName;
	protected WebObject eatingOutImage;
	protected WebObject eatingOutSectionName;
	protected WebObject breadcrumb;

	public EatPage checkEatUrl() {
		Logger.info("Check 'Eat' url");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/diet/members/eat"), "URL doesn't contain '/diet/members/eat'");
		return this;
	}

	public EatPage checkLandingTitleDisplayed() {
		Logger.info("Check the 'Eat' landing title is displayed");
		if (BrowserType.IE != null) {
			WebElement el = (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("landing-title")));
			el.isDisplayed();

		} else {
			boolean isTitleDisplayed =
					landingTitle
							.waitUntilVisible()
							.then()
							.isElementPresent();
			assertTrue(isTitleDisplayed, "The 'Eat' landing title is not displayed");
		}
		return this;
	}

	public EatPage checkGetStartedSectionDisplayed() {
		Logger.info("Check the 'Get Started' section is displayed");
		boolean isGetStartedDisplayed =
				getStartedSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isGetStartedDisplayed, "The 'Get Started' section is not displayed");
		return this;
	}

	public EatPage checkSmartFoodChoicesSectionDisplayed() {
		Logger.info("Check the 'Smart Food Choices' section is displayed");
		boolean isSmartFoodChoicesSectionDisplayed =
				smartFoodChoicesSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isSmartFoodChoicesSectionDisplayed, "The 'Smart Food Choices' section is not displayed");
		return this;
	}

	public EatPage checkMealsMadeEasySectionDisplayed() {
		Logger.info("Check the 'Meals Made Easy' section is displayed");
		boolean isMealsMadeEasySectionDisplayed =
				mealsMadeEasySection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isMealsMadeEasySectionDisplayed, "The 'Meals Made Easy' section is not displayed");
		return this;
	}

	public EatPage checkEatingOutSectionDisplayed() {
		Logger.info("Check the 'Eating Out' section is displayed");
		boolean isEatingOutSectionDisplayed =
				eatingOutSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isEatingOutSectionDisplayed, "The 'Eating Out' section is not displayed");
		return this;
	}

	public EatPage checkGetStartedSection() {
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

	public EatPage checkSmartFoodChoicesSection() {
		Logger.info("Check the image of 'Smart Food Choices' section is displayed");
		boolean isImageDisplayed =
				smartFoodChoicesImage
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isImageDisplayed, "The image of 'Smart Food Choices' section is not displayed");

		Logger.info("Check the name of 'Smart Food Choices' section is displayed");
		boolean isNameDisplayed =
				smartFoodChoicesSectionName
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNameDisplayed, "The name of 'Smart Food Choices' section is not displayed");
		return this;
	}

	public EatPage checkMealsMadeEasySection() {
		Logger.info("Check the image of 'Meals Made Easy' section is displayed");
		boolean isImageDisplayed =
				mealsMadeEasyImage
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isImageDisplayed, "The image of 'Meals Made Easy' section is not displayed");

		Logger.info("Check the name of 'Meals Made Easy' section is displayed");
		boolean isNameDisplayed =
				mealsMadeEasySectionName
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNameDisplayed, "The name of 'Meals Made Easy' section is not displayed");
		return this;
	}

	public EatPage checkEatingOutSection() {
		Logger.info("Check the image of 'Eating Out' section is displayed");
		boolean isImageDisplayed =
				eatingOutImage
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isImageDisplayed, "The image of 'Eating Out' section is not displayed");

		Logger.info("Check the name of 'Eating Out' section is displayed");
		boolean isNameDisplayed =
				eatingOutSectionName
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNameDisplayed, "The name of 'Eating Out' section is not displayed");
		return this;
	}

	public EatPage changeGetStartedSectionNameColourOnHover() {
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

		WebElement getStartedSectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mayodiet/images/eat-get-started-main-landing.jpg']+h2"));
		withActions().moveToElement(getStartedSectionName).build().perform();
		String hoverColour = getStartedSectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 94, 21, 0.9)", "Default colour of the 'Get Started' section name is not correct");
		}
		return this;
	}

	public EatPage changeSmartFoodChoicesSectionNameColourOnHover() {
		Logger.info("Check the 'Smart Food Choices' section name turns orange on hover");
		String colour = smartFoodChoicesSectionName
				.waitElementsReady()
				.getCssValue("background-color");
		if (colour != "rgba(252, 252, 255, 0.9)") {
		} else {
			String splitColour = colour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 252, 255, 0.9)", "Default colour of the 'Smart Food Choices' section name is not correct");
		}

		WebElement smartFoodChoicesSectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mayodiet/images/smart-food-choices-main-landing.jpg']+h2"));
		withActions().moveToElement(smartFoodChoicesSectionName).build().perform();
		String hoverColour = smartFoodChoicesSectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 94, 21, 0.9)", "The 'Smart Food Choices' section name is not turn Orange on hover");
		}
		return this;
	}

	public EatPage changeMealsMadeEasySectionNameColourOnHover() {
		Logger.info("Check the 'Meals Made Easy' section name turns orange on hover");
		String colour = mealsMadeEasySectionName
				.waitElementsReady()
				.getCssValue("background-color");
		if (colour != "rgba(252, 252, 255, 0.9)") {
		} else {
			String splitColour = colour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 252, 255, 0.9)", "Default colour of the 'Meals Made Easy' section name is not correct");
		}

		WebElement mealsMadeEasySectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mcd/cms/meals.jpg']+h2"));
		withActions().moveToElement(mealsMadeEasySectionName).build().perform();
		String hoverColour = mealsMadeEasySectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 94, 21, 0.9)", "The 'Meals Made Easy' section name is not turn Orange on hover");
		}
		return this;
	}

	public EatPage changeEatingOutSectionNameColourOnHover() {
		Logger.info("Check the 'Eating Out' section name turns orange on hover");
		String colour = eatingOutSectionName
				.waitElementsReady()
				.getCssValue("background-color");
		if (colour != "rgba(252, 252, 255, 0.9)") {
		} else {
			String splitColour = colour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 252, 255, 0.9)", "Default colour of the 'Eating Out' section name is not correct");
		}

		WebElement eatingOutSectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mayodiet/images/eating-out-main-landing.jpg']+h2"));
		withActions().moveToElement(eatingOutSectionName).build().perform();
		String hoverColour = eatingOutSectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 94, 21, 0.9)", "The 'Eating Out' section name is not turn Orange on hover");
		}
		return this;
	}

	public EatGetStartedPage clickGetStartedName() {
		Logger.info("Click on 'Get Started' section name");
		getStartedSectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, EatGetStartedPage.class);
	}

	public EatSmartFoodChoicesPage clickSmartFoodChoicesName() {
		Logger.info("Click on 'Smart Food Choices' section name");
		smartFoodChoicesSectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, EatSmartFoodChoicesPage.class);
	}

	public EatMealsMadeEasyPage clickMealsMadeEasyName() {
		Logger.info("Click on 'Meals Made Easy' section name");
		mealsMadeEasySectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, EatMealsMadeEasyPage.class);
	}

	public EatingOutPage clickEatingOutName() {
		Logger.info("Click on 'Eating Out' section name");
		eatingOutSectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, EatingOutPage.class);
	}

	public EatPage checkEatBreadcrumb() {
		Logger.info("Check the breadcrumb");
		String breadcrumbs = breadcrumb
				.waitElementsReady()
				.getText();
		assertEquals(breadcrumbs, "HOMEEAT", "The breadcrumb is not correct");
		return this;
	}
}
