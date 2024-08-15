package mayoclinicdiet.pages;


import framework.Logger;
import framework.Settings;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class WelcomePage extends BasicPage {

	public WelcomePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "welcome";
		String CLASS_NAME = "WelcomePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		settings = new Settings();
	}

	protected WebObject welcomeTitle;
	protected Settings settings;
	protected WebObject getStartedButton;
	protected WebObject specialOffer;
	protected WebObject checkoutButton;
	protected WebObject noThanksButton;
	protected WebObject coachingOffer;
	protected WebObject coachingOfferUpgradeButton;
	protected WebObject dietBookOffer;
	protected WebObject dietBookOfferAddToCartButton;
	protected WebObject dietCookBookOffer;
	protected WebObject dietCookBookPrice;
	protected WebObject dietCookBookOfferAddToCartButton;
	protected WebObject dietCookBookGreenMark;

	public WelcomePage checkWelcomeTitlePresent() {
		Logger.info("Check welcome title is presented");
		boolean isWelcomeTitlePresent =
				welcomeTitle
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isWelcomeTitlePresent, "Welcome title is not present");
		return this;
	}

	public WelcomePage checkWelcomeHeaderPresent() {
		basedriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		if (specialOffer.isVisible()) {
			checkoutButton.click();
		}
		welcomeTitle.waitUntilElementIsVisible();
		WebElement element = basedriver.findElement(By.cssSelector(".onBoardingTitle h1"));
		assertTrue(element.isDisplayed(), "Welcome title is not present");
		Logger.info("Check welcome title is presented");
		return this;
	}

	public HomePage clickGetStartedButton() {
		Logger.info("Click 'Get Started' button");
		if (specialOffer.isVisible()) {
			noThanksButton.click();
		}
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1882");
		getStartedButton.waitUntilVisible();
		getStartedButton.click();
		return PageFactory.initElements(basedriver, HomePage.class);
	}

	public boolean isCoachingOfferVisible() {
		Logger.info("Verify if 'Coaching' offer is visible");
		return coachingOffer.isVisible();
	}

	public boolean isDietBookOfferVisible() {
		Logger.info("Verify if 'Diet Book' offer is visible");
		return dietBookOffer.isVisible();
	}

	public boolean isDietCookBookOfferVisible() {
		Logger.info("Verify if 'Diet Cook Book' offer is visible");
		return dietCookBookOffer.isVisible();
	}

	public WelcomePage clickDietCookBookAddToCartButton() {
		Logger.info("Click 'Add to cart' button for 'Diet cook book' offer");
		dietCookBookOfferAddToCartButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isDietCookBookAddedToCart() {
		Logger.info("Verify if 'Diet cook book' added to cart");
		return dietCookBookGreenMark.getAttribute("class").contains("added");
	}

	public WelcomePage clickNoThanksButton() {
		Logger.info("Click 'No, thanks' button");
		noThanksButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public OrderPage clickCheckoutButton() {
		Logger.info("Click 'Checkout' button");
		checkoutButton.click();
		return new OrderPage(basedriver);
	}

	public String getCookBookPrice() {
		Logger.info("Get price of 'Mayo Clinic Diet Cookbook'");
		return dietCookBookPrice.getText();
	}

	@Override
	public void waitForPageToLoad() {
		welcomeTitle.waitUntilVisible();
	}
}
