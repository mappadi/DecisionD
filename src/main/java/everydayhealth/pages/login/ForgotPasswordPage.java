package everydayhealth.pages.login;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * Global Site Secure Forgot Password Page
 */
public class ForgotPasswordPage extends BasicPageEH {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "loginpage";
		String CLASS_NAME = "ForgotPasswordPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject forgotPasswordTitle;
	protected WebObject forgotPasswordInputEmail;
	protected WebObject forgotPasswordInputValidationError;
	protected WebObject forgotPasswordInputValidationSuccess;
	protected WebObject forgotPasswordSubmitButton;
	protected WebObject forgotPasswordSuccessMessage;
	protected WebObject forgotPasswordErrorMessage;
	protected WebObject forgotPasswordErrorMessageContacts;

	@Override
	public void waitForPageToLoad() {
		forgotPasswordSubmitButton.waitUntilVisibleOnPage(this);
	}

	public boolean isForgotPasswordTitleVisible() {
		Logger.info("Verifying forgot password title");
		return forgotPasswordTitle.isVisible();
	}

	public void enterForgotPasswordEmail(String email) {
		Logger.info("Entering data into email field");
		forgotPasswordInputEmail.type(email);
	}

	public boolean isForgotPasswordInputValidationErrorVisible() {
		Logger.info("Verifying email input validation error is visible");
		return forgotPasswordInputValidationError.isVisible();
	}

	public boolean isForgotPasswordInputValidationSuccessVisible() {
		Logger.info("Verifying email input validation success is visible");
		return forgotPasswordInputValidationSuccess.isVisible();
	}

	public boolean isForgotPasswordSubmitButtonEnabled() {
		Logger.info("Verifying if submit button is clickable");
		return forgotPasswordSubmitButton.isCurrentlyEnabled();
	}

	public void clickForgotPasswordSubmitButton() {
		Logger.info("Clicking the forgot password submit button");
		forgotPasswordSubmitButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isForgotPasswordSuccssMessageCorrect() {
		Logger.info("Verifying forgot password success message text");
		return forgotPasswordSuccessMessage.getText().equalsIgnoreCase("Check your email for a link to reset your password.");
	}

	public boolean isForgotPasswordSuccessMessageVisible() {
		Logger.info("Verifying forgot password success messaging");
		return forgotPasswordSuccessMessage.isVisible();
	}

	public boolean isForgotPasswordErrorMessageVisible() {
		Logger.info("Verifying forgot password error message is visible");
		return forgotPasswordErrorMessage.isVisible();
	}

	public boolean isForgotPasswordErrorMessageCorrect() {
		Logger.info("Verifying forgot password error message text");
		return forgotPasswordErrorMessage.getText().contains("trouble emailing the reset password link");
	}

	public int getForgotPasswordErrorMessageContacts() {
		Logger.info("Getting the forgot password error message contact support");
		return forgotPasswordErrorMessageContacts.getVisibleElementsCount();
	}

	public String getForgotPasswordErrorMessageContactLinks(int elementNumber) {
		Logger.info("Verifying the contact link from " + elementNumber);
		return forgotPasswordErrorMessageContacts.getTextFromElementNumber(elementNumber);
	}

}
