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

public class MotivatePage extends PublicHeaderMCD {

	public MotivatePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "motivate";
		String CLASS_NAME = "MotivatePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject landingTitle;
	protected WebObject mindAndBodySection;
	protected WebObject obstaclesSection;
	protected WebObject successStoriesSection;
	protected WebObject supportSection;
	protected WebObject mindAndBodyImage;
	protected WebObject mindAndBodySectionName;
	protected WebObject obstaclesImage;
	protected WebObject obstaclesSectionName;
	protected WebObject successStoriesImage;
	protected WebObject successStoriesSectionName;
	protected WebObject supportImage;
	protected WebObject supportSectionName;
	protected WebObject breadcrumb;

	public MotivatePage checkMotivateUrl() {
		Logger.info("Check 'Motivate' url");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/diet/members/motivate"), "URL doesn't contain '/diet/members/motivate'");
		return this;
	}

	public MotivatePage checkLandingTitleDisplayed() {
		Logger.info("Check the 'Motivate' landing title is displayed");
		if (BrowserType.IE != null) {
			WebElement el = (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.visibilityOfElementLocated(By.className("landing-title")));
			el.isDisplayed();

		} else {
			boolean isTitleDisplayed =
					landingTitle
							.waitElementsReady()
							.isElementPresent();
			assertTrue(isTitleDisplayed, "The 'Motivate' landing title is not displayed");
		}
		return this;
	}

	public MotivatePage checkMindAndBodySectionDisplayed() {
		Logger.info("Check the 'Mind & Body' section is displayed");
		boolean isMindAndBodyDisplayed =
				mindAndBodySection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isMindAndBodyDisplayed, "The 'Mind & Body' section is not displayed");
		return this;
	}

	public MotivatePage checkObstaclesSectionDisplayed() {
		Logger.info("Check the 'Obstacles' section is displayed");
		boolean isObstaclesSectionDisplayed =
				obstaclesSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isObstaclesSectionDisplayed, "The 'Obstacles' section is not displayed");
		return this;
	}

	public MotivatePage checkSuccessStoriesSectionDisplayed() {
		Logger.info("Check the 'Success Stories' section is displayed");
		boolean isSuccessStoriesSectionDisplayed =
				successStoriesSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isSuccessStoriesSectionDisplayed, "The 'Success Stories' section is not displayed");
		return this;
	}

	public MotivatePage checkSupportSectionDisplayed() {
		Logger.info("Check the 'Support' section is displayed");
		boolean isSupportSectionDisplayed =
				supportSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isSupportSectionDisplayed, "The 'Support' section is not displayed");
		return this;
	}

	public MotivatePage checkMindAndBodySection() {
		Logger.info("Check the image of 'Mind & Body' section is displayed");
		boolean isImageDisplayed =
				mindAndBodyImage
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isImageDisplayed, "The image of 'Mind & Body' section is not displayed");

		Logger.info("Check the name of 'Mind & Body' section is displayed");
		boolean isNameDisplayed =
				mindAndBodySectionName
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNameDisplayed, "The name of 'Mind & Body' section is not displayed");
		return this;
	}

	public MotivatePage checkObstaclesSection() {
		Logger.info("Check the image of 'Obstacles' section is displayed");
		boolean isImageDisplayed =
				obstaclesImage
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isImageDisplayed, "The image of 'Obstacles' section is not displayed");

		Logger.info("Check the name of 'Obstacles' section is displayed");
		boolean isNameDisplayed =
				obstaclesSectionName
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNameDisplayed, "The name of 'Obstacles' section is not displayed");
		return this;
	}

	public MotivatePage checkSuccessStoriesSection() {
		Logger.info("Check the image of 'Success Stories' section is displayed");
		boolean isImageDisplayed =
				successStoriesImage
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isImageDisplayed, "The image of 'Success Stories' section is not displayed");

		Logger.info("Check the name of 'Success Stories' section is displayed");
		boolean isNameDisplayed =
				successStoriesSectionName
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNameDisplayed, "The name of 'Success Stories' section is not displayed");
		return this;
	}

	public MotivatePage checkSupportSection() {
		Logger.info("Check the image of 'Support' section is displayed");
		boolean isImageDisplayed =
				supportImage
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isImageDisplayed, "The image of 'Support' section is not displayed");

		Logger.info("Check the name of 'Support' section is displayed");
		boolean isNameDisplayed =
				supportSectionName
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNameDisplayed, "The name of 'Support' section is not displayed");
		return this;
	}

	public MotivatePage changeMindAndBodySectionNameColourOnHover() {
		Logger.info("Check the 'Mind & Body' section name turns orange on hover");
		String colour = mindAndBodySectionName
				.waitElementsReady()
				.getCssValue("background-color");
		if (colour != "rgba(252, 252, 255, 0.9)") {
		} else {
			String splitColour = colour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 252, 255, 0.9)", "Default colour of the 'Mind & Body' section name is not correct");
		}

		WebElement mindAndBodySectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mayodiet/images/motivate-mind-body-main-landing.jpg']+h2"));
		withActions().moveToElement(mindAndBodySectionName).build().perform();
		String hoverColour = mindAndBodySectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 94, 21, 0.9)", "The 'Mind & Body' section name is not turn Orange on hover");
		}
		return this;
	}

	public MotivatePage changeObstaclesSectionNameColourOnHover() {
		Logger.info("Check the 'Obstacles' section name turns orange on hover");
		String colour = obstaclesSectionName
				.waitElementsReady()
				.getCssValue("background-color");
		if (colour != "rgba(252, 252, 255, 0.9)") {
		} else {
			String splitColour = colour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 252, 255, 0.9)", "Default colour of the 'Obstacles' section name is not correct");
		}

		WebElement obstaclesSectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mayodiet/images/motivate-obstacles-main-landing.jpg']+h2"));
		withActions().moveToElement(obstaclesSectionName).build().perform();
		String hoverColour = obstaclesSectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 94, 21, 0.9)", "The 'Obstacles' section name is not turn Orange on hover");
		}
		return this;
	}

	public MotivatePage changeSuccessStoriesSectionNameColourOnHover() {
		Logger.info("Check the 'Success Stories' section name turns orange on hover");
		String colour = successStoriesSectionName
				.waitElementsReady()
				.getCssValue("background-color");
		if (colour != "rgba(252, 252, 255, 0.9)") {
		} else {
			String splitColour = colour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 252, 255, 0.9)", "Default colour of the 'Success Stories' section name is not correct");
		}

		WebElement successStoriesSectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mayodiet/images/motivate-success-stories-main-landing.jpg?clearcache-true']+h2"));
		withActions().moveToElement(successStoriesSectionName).build().perform();
		String hoverColour = successStoriesSectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 94, 21, 0.9)", "The 'Success Stories' section name is not turn Orange on hover");
		}
		return this;
	}

	public MotivatePage changeSupportSectionNameColourOnHover() {
		Logger.info("Check the 'Support' section name turns orange on hover");
		String colour = supportSectionName
				.waitElementsReady()
				.getCssValue("background-color");
		if (colour != "rgba(252, 252, 255, 0.9)") {
		} else {
			String splitColour = colour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 252, 255, 0.9)", "Default colour of the 'Support' section name is not correct");
		}

		WebElement supportSectionName = basedriver.findElement(By.cssSelector("img[src='http://content.everydayhealth.com/mayodiet/images/motivate-support-main-landing.jpg?clearcache=true']+h2"));
		withActions().moveToElement(supportSectionName).build().perform();
		String hoverColour = supportSectionName.getCssValue("background-color");
		if (hoverColour != "rgba(252, 94, 21, 0.9)") {
		} else {
			String splitColour = hoverColour.split("01961")[0];
			String actualColour = splitColour + ")";
			assertEquals(actualColour, "rgba(252, 94, 21, 0.9)", "The 'Support' section name is not turn Orange on hover");
		}
		return this;
	}

	public MotivateMindAndBodyPage clickMindAndBodyName() {
		Logger.info("Click on 'Mind & Body' section name");
		mindAndBodySectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MotivateMindAndBodyPage.class);
	}

	public MotivateObstaclesPage clickObstaclesName() {
		Logger.info("Click on 'Obstacles' section name");
		obstaclesSectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MotivateObstaclesPage.class);
	}

	public MotivateSuccessStoriesPage clickSuccessStoriesName() {
		Logger.info("Click on 'Success Stories' section name");
		successStoriesSectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MotivateSuccessStoriesPage.class);
	}

	public MotivateSupportPage clickSupportName() {
		Logger.info("Click on 'Support' section name");
		supportSectionName
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MotivateSupportPage.class);
	}

	public MotivatePage checkMotivateBreadcrumb() {
		Logger.info("Check the breadcrumb");
		String breadcrumbs = breadcrumb
				.waitElementsReady()
				.getText();
		assertEquals(breadcrumbs, "HOMEMOTIVATE", "The breadcrumb is not correct");
		return this;
	}

}
