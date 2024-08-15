package everydayhealth.pages.login;

import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.registrations.MainRegistrationStepOne;
import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.platform.UserEH;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Global Site Secure Login Page
 */
public class LoginPageEH extends BasicPageEH {

	public LoginPageEH(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "loginpage";
		String CLASS_NAME = "LoginPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject inputEmailId;
	protected WebObject inputPassword;
	protected WebObject submitButton;
	protected WebObject submitButtonDisabled;
	protected WebObject errorMessage;
	protected WebObject forgotPassword;
	protected WebObject registerNow;
	protected WebObject loginForm;

	@Override
	public void waitForPageToLoad() {
		submitButtonDisabled.waitUntilVisibleOnPage(this);
	}

	public boolean isSubmitButtonDisabled() {
		Logger.info("Validating submit button is disabled");
		return submitButtonDisabled.isVisible();
	}

	public BasicPageEH enterCredentialsAndSubmitForm(UserEH user) {
		Logger.info("Logging in with User: " + user.getEmail());
		enterCredentialsAndSubmitForm(user.getEmail(), user.getPassword());
		waitForAjaxRequestToBeFinished();
		return new BasicPageEH(WebDriverManager.getDriver());
	}

	public void enterCredentialsAndSubmitForm(String email, String password) {
		Logger.info("Entering credentials 'email', 'password' and submitting form");
		inputEmailId.type(email);
		inputPassword.type(password);
		clickSubmitButton();
	}

	public LoginPageEH setEmail(String email) {
		Logger.info("Setting email by typing " + email);
		inputEmailId.type(email);
		return this;
	}

	public LoginPageEH setPassword(String password) {
		Logger.info("Setting password by typing " + password);
		inputPassword.type(password);
		return this;
	}

	public void clickSubmitButton() {
		Logger.info("Clicking the 'submit' button");
		submitButton.click();
		Utils.waitFor(4000);//Wait for page to load
		waitForAjaxRequestToBeFinished();
	}

	public boolean isErrorMessageVisible() {
		Logger.info("Verifying the form validation error message is visible");
		return errorMessage.isVisible();
	}

	public LoginPageEH waitForErrorMessageVisible() {
		Logger.info("Wait for error message visible");
		errorMessage.waitUntilVisible();
		return this;
	}

	public MainRegistrationStepOne clickRegisterNow() {
		Logger.info("Clicking the 'Register Now!' link");
		registerNow.click();
		return PageFactory.initElements(WebDriverManager.getDriver(), MainRegistrationStepOne.class);
	}

	public ForgotPasswordPage clickForgotPassword() {
		Logger.info("Clicking the 'forgot password' link");
		forgotPassword.click();
		return PageFactory.initElements(WebDriverManager.getDriver(), ForgotPasswordPage.class);
	}

	public <T> T enterCredentialsAndSubmitForm(UserEH user, Class<T> expectedPage) {
		Logger.info("Logging in with User: " + user.getEmail());
		enterCredentialsAndSubmitForm(user.getEmail(), user.getPassword());
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public boolean isLoginFormVisible() {
		Logger.info("Check if login form is visible");
		return loginForm.isVisible();
	}
}