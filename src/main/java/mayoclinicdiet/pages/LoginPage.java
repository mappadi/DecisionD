package mayoclinicdiet.pages;

import framework.BrowserType;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.components.BasicPage;
import framework.platform.UserMCD;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "login";
		String CLASS_NAME = "LoginPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject emailField;
	protected WebObject passwordField;
	protected WebObject submitButton;
	protected WebObject loginTitle;
	protected WebObject forgotYourPasswordLink;
	protected WebObject rememberMeCheckbox;
	protected WebObject errorMessage;

	public <T> T submitLogin(Class<T> expectedPage) {
		Logger.info("Click Log In");
		typeEmail(Settings.config.getAdminEmail());
		typePassword(Settings.config.getAdminPassword());
		clickLoginButtonAndGoToMainPage();
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public HomePage submitLogin() {
		Logger.info("Click Log In");
		typeEmail(Settings.config.getAdminEmail());
		typePassword(Settings.config.getAdminPassword());
		return clickLoginButtonAndGoToMainPage();
	}

	public HomePage submitLogin(UserMCD user) {
		Logger.info("Click Log In");
		typeEmail(user.getEmail());
		typePassword(user.getPassword());
		return clickLoginButtonAndGoToMainPage();
	}

	public LoginPage typeEmail(String email) {
		Logger.info("Enter email");
		emailField
				.waitUntilVisible()
				.then()
				.type(email);
		return this;
	}

	public LoginPage typePassword(String password) {
		Logger.info("Enter password");
		passwordField
				.waitUntilVisible()
				.then()
				.type(password);
		return this;
	}

	public <T> T clickLoginButtonAndGoToMainPage(Class<T> expectedPage) {
		Logger.info("Click Log In");
		clickLoginButton();
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public HomePage clickLoginButtonAndGoToMainPage() {
		clickLoginButton();
		return PageFactory.initElements(basedriver, HomePage.class);
	}

	public LoginPage clickLoginButtonAndStayOnTheSamePage() {
		clickLoginButton();
		return this;
	}

	private void clickLoginButton() {
		Logger.info("Click 'Log In' button");
		submitButton
				.waitUntilVisible()
				.then()
				.click();
	}

	public LoginPage checkEmailFieldPresent() {
		Logger.info("Check 'Email Field' is presented");
		boolean isEmailInputFieldPresent =
				emailField
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isEmailInputFieldPresent, "Email input field is not present");
		return this;
	}

	public LoginPage checkPasswordFieldPresent() {
		Logger.info("Check 'Password Field' is presented");
		boolean isPasswordInputFieldPresent =
				passwordField
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isPasswordInputFieldPresent, "Password input field is not present");
		return this;
	}

	public LoginPage checkErrorMessagePresent() {
		Logger.info("Check 'Error message' is presented");
		boolean isErrorMessagePresent =
				errorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessagePresent, "Error message is not present");
		return this;
	}

	public LoginPage checkLoginTitlePresent() {
		Logger.info("Check 'Login Title' is presented");
		if (BrowserType.IE != null) {
			WebElement el = (new WebDriverWait(WebDriverManager.getDriver(), 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("login-title")));
			assertTrue(el.isDisplayed(), "Login title is not present");
		} else {
			boolean isLoginTitlePresent =
					loginTitle
							.waitUntilVisible()
							.then()
							.isElementPresent();
			assertTrue(isLoginTitlePresent, "Login title is not present");
		}
		return this;
	}

	public LoginPage checkLogInButtonPresent() {
		Logger.info("Check 'Log In' button is presented");
		boolean isLogInButtonPresent =
				submitButton
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isLogInButtonPresent, "'Log in' button is not present");
		return this;
	}

	public LoginPage checkForgotYourPasswordLinkPresent() {
		Logger.info("Check 'Forgot Your Password' link is presented");
		boolean isForgotYourPasswordLinkPresent =
				forgotYourPasswordLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isForgotYourPasswordLinkPresent, "'Forgot your password?' link is not present");
		return this;
	}

	public LoginPage checkRememberMeCheckboxPresent() {
		Logger.info("Check 'Remember Me' is presented");
		boolean isRememberMeCheckboxPresent =
				rememberMeCheckbox
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isRememberMeCheckboxPresent, "'Remember me' checkbox is not present");
		return this;
	}

	public LoginPage checkTextInPasswordField() {
		Logger.info("Check text in 'Password' field");
		boolean isPasswordEncrypted =
				passwordField
						.getAttribute("type")
						.equals("password");
		assertTrue(isPasswordEncrypted, "Password is not encrypted");
		return this;
	}

	public LoginPage checkTextInEmailField() {
		Logger.info("Check text in 'Email Address' field");
		String isCorrectTextInEmailFieldPresent =
				emailField
						.getValue();
		String expectedText = Settings.config.getAdminEmail();
		assertEquals(isCorrectTextInEmailFieldPresent, expectedText, "Email text is not displayed correctly");
		return this;
	}

	public LoginPage hoverMouseOverLogInButton() {
		Logger.info("Hover mouse over 'Log In' button");
		Actions action = new Actions(basedriver);
		WebElement subButton = basedriver.findElement(By.id("Submit"));
		action.moveToElement(subButton).build().perform();
		return this;
	}

	public LoginPage checkLogInButtonDefaultColour() {
		Logger.info("Check 'Log In' button default colour");
		String buttonColour =
				submitButton
						.getCssValue("background-color");
		assertEquals(buttonColour, "rgba(254, 80, 0, 1)", "Default colour of the 'LOG IN' button is not Orange");
		return this;
	}

	public LoginPage checkHoverOverLogInButtonColour() {
		Logger.info("Check hover over 'Log In' button colour");
		String buttonColour =
				submitButton
						.getCssValue("background-color");
		assertEquals(buttonColour, "rgba(210, 65, 2, 1)", "The colour of the 'LOG IN' button is not change to Dark Orange on mouse hover");
		return this;
	}

	public LoginPage checkLoginButtonCss() {
		Logger.info("Check 'Log In' button colour");
		String buttonColor = submitButton
				.getCssValue("background-color");
		assertEquals(buttonColor, "rgba(254, 80, 0, 1)", "The colour of the 'LOG IN' button is not correspond to mock-up");

		Logger.info("Check 'Log In' button font-size");
		String fontSize = submitButton
				.getCssValue("font-size");
		assertEquals(fontSize, "13px", "The font-size of the 'LOG IN' button is not correspond to mock-up");

		Logger.info("Check hover over 'Log In' button text alignment");
		String textAlign = submitButton
				.getCssValue("text-align");
		assertEquals(textAlign, "center", "The text-align of the 'LOG IN' button is not correspond to mock-up");

		Logger.info("Check hover over 'Log In' button text transform");
		String textTransform = submitButton
				.getCssValue("text-transform");
		assertEquals(textTransform, "uppercase", "The text-transform of the 'LOG IN' button is not correspond to mock-up");

		Logger.info("Check 'Log In' button top left radius");
		String borderTopLeftRadius = submitButton
				.getCssValue("border-top-left-radius");
		assertEquals(borderTopLeftRadius, "20px", "The border-top-left-radius of the 'LOG IN' button is not correspond to mock-up");

		Logger.info("Check 'Log In' button top right radius");
		String borderTopRightRadius = submitButton
				.getCssValue("border-top-right-radius");
		assertEquals(borderTopRightRadius, "20px", "The border-top-right-radius of the 'LOG IN' button is not correspond to mock-up");

		Logger.info("Check 'Log In' button bottom right radius");
		String borderBottomRihgtRadius = submitButton
				.getCssValue("border-bottom-right-radius");
		assertEquals(borderBottomRihgtRadius, "20px", "The border-bottom-right-radius of the 'LOG IN' button is not correspond to mock-up");

		Logger.info("Check 'Log In' button bottom left radius");
		String borderBottomLeftRadius = submitButton
				.getCssValue("border-bottom-left-radius");
		assertEquals(borderBottomLeftRadius, "20px", "The border-bottom-left-radius of the 'LOG IN' button is not correspond to mock-up");
		return this;
	}

	public LoginPage checkHttpsStatusConnection() {
		Logger.info("Check 'https' status connection");
		String currentURL = basedriver.
				getCurrentUrl();
		assertTrue(currentURL.contains("https"), "URL doesn't contain https");
		return this;
	}

	public ForgotPasswordPage clickForgotPasswordLink() {
		Logger.info("Click on 'Forgot your password?' link");
		forgotYourPasswordLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, ForgotPasswordPage.class);
	}

	@Override
	public void waitForPageToLoad() {

	}
}
