package mayoclinicdiet.pages;

import framework.BrowserType;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static framework.adapters.WebDriverManager.getDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LogoutPage extends PublicHeaderMCD {

	public LogoutPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "logout";
		String CLASS_NAME = "LogoutPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		settings = new Settings();
	}

	protected WebObject textTopModule;
	protected WebObject firstRowTextModule;
	protected WebObject secondRowTextModule;
	protected WebObject logInAgainButton;
	protected WebObject promoBanner;
	protected WebObject bottomText;
	protected WebObject logOutBlock;
	protected Settings settings;

	public LogoutPage checkLogoutUrl() {
		Logger.info("Check 'Log Out' url");
		WebElement el = (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sign-in-out.signout-block.expand-mobile")));
		if (el.isDisplayed()) {
			String currentUrl = basedriver.getCurrentUrl();
			assertTrue(currentUrl.contains("/loggedout"), "URL doesn't contain '/loggedout'");
		}
		return this;
	}

	public LogoutPage checkLogoutPage() {
		Logger.info("Check 'Log Out' page is presented");
		boolean islogOutBlockDisplayed =
				logOutBlock
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(islogOutBlockDisplayed, "Log Out block is not present");
		return this;
	}

	public LogoutPage checkFirstTextRow() {
		Logger.info("Check first row text displaying");
		String firstRow =
				firstRowTextModule
						.waitUntilVisible()
						.getText();
		assertEquals(firstRow, "Come back soon!", "The first row of the text module is not displayed correctly");

		Logger.info("Check second row text displaying");
		String isFirstRowSize =
				firstRowTextModule
						.getCssValue("font-size");
		assertEquals(isFirstRowSize, "55px", "The font-size of the first row text is not displayed correctly");
		return this;
	}

	public LogoutPage checkSecondTextRow() {
		Logger.info("Check second row text");
		String secondRow =
				secondRowTextModule
						.waitUntilVisible()
						.getText();
		assertEquals(secondRow, "Eat well. Enjoy life.\n" +
				"Lose weight.", "The second row of the text module is not displayed correctly");

		Logger.info("Check second row text font size");
		String isSecondRowSize =
				secondRowTextModule
						.getCssValue("font-size");
		assertEquals(isSecondRowSize, "34px", "The font-size of the second row text is not displayed correctly");
		return this;
	}

	public LogoutPage checkHeaderAlignment() {
		Logger.info("Check text module alignment");
		String align =
				textTopModule
						.getCssValue("text-align");
		assertEquals(align, "left", "Element is not displayed correctly");
		return this;
	}

	public LogoutPage checkTextAlignment() {
		Logger.info("Check first row text alignment");
		String alignFirstRow =
				firstRowTextModule
						.getCssValue("text-align");
		assertEquals(alignFirstRow, "center", "Element is not displayed correctly");

		Logger.info("Check second row text alignment");
		String alignSecondRow =
				secondRowTextModule
						.getCssValue("text-align");
		assertEquals(alignSecondRow, "center", "Element is not displayed correctly");
		return this;
	}

	public LogoutPage checkPromoBannerAlignment() {
		Logger.info("Check Log Out Promo Banner 'padding-top' css value");
		String paddingTop =
				promoBanner
						.getCssValue("padding-top");
		assertEquals(paddingTop, "37px", "Element is not displayed correctly");

		Logger.info("Check Log Out Promo Banner 'padding-bottom' css value");
		String paddingBottom =
				promoBanner
						.getCssValue("padding-bottom");
		assertEquals(paddingBottom, "31px", "Element is not displayed correctly");

		Logger.info("Check Log Out Promo Banner 'padding-left' css value");
		String paddingLeft =
				promoBanner
						.getCssValue("padding-left");
		assertEquals(paddingLeft, "80px", "Element is not displayed correctly");

		Logger.info("Check Log Out Promo Banner 'padding-right' css value");
		String paddingRight =
				promoBanner
						.getCssValue("padding-right");
		assertEquals(paddingRight, "0px", "Element is not displayed correctly");

		Logger.info("Check Log Out Promo Banner 'display' css value");
		String bottomTextDisplayed =
				bottomText
						.getCssValue("display");
		assertEquals(bottomTextDisplayed, "inline-block", "Element is not displayed correctly");

		Logger.info("Check 'Log In Again' button 'display' css value");
		String logInAgainButtonDisplayed =
				logInAgainButton
						.getCssValue("display");
		assertEquals(logInAgainButtonDisplayed, "inline-block", "Element is not displayed correctly");
		return this;
	}

	public LogoutPage checkBackgroundImage() {
		Logger.info("Check Log Out image is presented");
		String logoutImage =
				logOutBlock
						.getCssValue("background-image");
		assertTrue(logoutImage.contains("/loggedout_image.jpg"), "Back Ground image is not displayed");
		return this;
	}

	public LogoutPage checkLogInAgainButtonCss() {
		Logger.info("Check 'Log In Again' button 'background-color' css value");
		String buttonColor =
				logInAgainButton
						.getCssValue("background-color");
		assertEquals(buttonColor, "rgba(254, 80, 0, 1)", "The colour of the 'LOG IN AGAIN' button is not correspond to mock-up");

		Logger.info("Check 'Log In Again' button 'font-size' css value");
		String fontSize =
				logInAgainButton
						.getCssValue("font-size");
		assertEquals(fontSize, "13px", "The font-size of the 'LOG IN AGAIN' button is not correspond to mock-up");

		Logger.info("Check 'Log In Again' button 'text-align' css value");
		String textAlign =
				logInAgainButton
						.getCssValue("text-align");
		assertEquals(textAlign, "center", "The text-align of the 'LOG IN AGAIN' button is not correspond to mock-up");

		Logger.info("Check 'Log In Again' button 'text-transform' css value");
		String textTransform =
				logInAgainButton
						.getCssValue("text-transform");
		assertEquals(textTransform, "uppercase", "The text-transform of the 'LOG IN AGAIN' button is not correspond to mock-up");

		Logger.info("Check 'Log In Again' button 'border-top-left-radius' css value");
		String borderTopLeftRadius =
				logInAgainButton
						.getCssValue("border-top-left-radius");
		assertEquals(borderTopLeftRadius, "20px", "The border-top-left-radius of the 'LOG IN AGAIN' button is not correspond to mock-up");

		Logger.info("Check 'Log In Again' button 'border-top-right-radius' css value");
		String borderTopRightRadius =
				logInAgainButton
						.getCssValue("border-top-right-radius");
		assertEquals(borderTopRightRadius, "20px", "The border-top-right-radius of the 'LOG IN AGAIN' button is not correspond to mock-up");

		Logger.info("Check 'Log In Again' button 'border-bottom-right-radius' css value");
		String borderBottomRihgtRadius =
				logInAgainButton
						.getCssValue("border-bottom-right-radius");
		assertEquals(borderBottomRihgtRadius, "20px", "The border-bottom-right-radius of the 'LOG IN AGAIN' button is not correspond to mock-up");

		Logger.info("Check 'Log In Again' button 'border-bottom-left-radius' css value");
		String borderBottomLeftRadius =
				logInAgainButton
						.getCssValue("border-bottom-left-radius");
		assertEquals(borderBottomLeftRadius, "20px", "The border-bottom-left-radius of the 'LOG IN AGAIN' button is not correspond to mock-up");
		return this;
	}

	public LogoutPage checkLogInAgainButtonColour() {
		Logger.info("Check 'Log In Again' button default colour");
		String buttonColor =
				logInAgainButton
						.waitUntilVisible()
						.getCssValue("background-color");
		assertEquals(buttonColor, "rgba(254, 80, 0, 1)", "Default colour of the 'LOG IN AGAIN' button is not Orange");
		return this;
	}

	public LogoutPage hoverMouseOverLogInAgainButton() {
		Logger.info("Hover mouse over 'Log In Again' button");
		Actions action = new Actions(basedriver);
		WebElement subButton = basedriver.findElement(By.cssSelector(".button"));
		action.moveToElement(subButton).build().perform();
		return this;
	}

	public LogoutPage checkHoverOverLogInAgainButtonColour() {
		Logger.info("Check hover over 'Log In Again' button colour");
		String buttonColor =
				logInAgainButton
						.getCssValue("background-color");
		assertEquals(buttonColor, "rgba(210, 65, 2, 1)", "The colour of the 'LOG IN AGAIN' button is not changed to Dark Orange on mouse hover");
		return this;
	}

	public LoginPage clickLogInAgainButton() {
		Logger.info("Click 'Log In Again' button");
		if (Settings.browser.equals(BrowserType.IE)) {
			WebElement logInAgainButton = basedriver.findElement(By.cssSelector(".button"));
			logInAgainButton.isDisplayed();
			withActions().doubleClick(logInAgainButton).build().perform();
		} else {
			WebDriverWait wait = new WebDriverWait(basedriver, 10);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button")));
			element.click();
		}
		return PageFactory.initElements(basedriver, LoginPage.class);
	}

}
