package everydayhealth.pages.personalizedTracker;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * PTRegistrationPage
 */
public class PTRegistrationPage extends BasicPageEH {

	public PTRegistrationPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "personalizedTracker";
		String CLASS_NAME = "PTRegistrationPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject signUpForm;
	protected WebObject emailInputField;
	protected WebObject nextButton;
	protected WebObject editEmailButton;
	protected WebObject passwordInputField;
	protected WebObject mobilePhoneNumberInputField;
	protected WebObject termsAndConditionsCheckbox;
	protected WebObject consentCheckbox;
	protected WebObject signUpNowButton;
	protected WebObject passwordRequirementsBox;
	protected WebObject passwordRequirementsStatus;
	protected WebObject phoneNumberErrorMessage;
	protected WebObject alreadyEhMemberMessage;
	protected WebObject errorMessageTryAgainLink;

	@Override
	public void waitForPageToLoad() {
		signUpForm.waitUntilVisibleOnPage(this);
	}

	public boolean isSignUpFormVisible() {
		Logger.info("Check if 'Sign up' form is visible");
		return signUpForm.isVisible();
	}

	public boolean isEmailInputFieldVisible() {
		Logger.info("Check if 'Email' input field is visible");
		return emailInputField.isVisible();
	}

	public String getEmailInputFieldValue() {
		Logger.info("Get 'Email' input field value");
		return emailInputField.getValue();
	}

	public boolean isEmailInputFieldEnabled() {
		Logger.info("Check if 'Email' input field is enabled");
		return emailInputField.isEnabled();
	}

	public PTRegistrationPage typeEmail(String email) {
		Logger.info("Type email");
		emailInputField.type(email);
		return this;
	}

	public void clickNextButton() {
		Logger.info("Click 'Next' button");
		nextButton.click();
		passwordInputField.waitUntilVisible();
	}

	public boolean isPasswordInputFieldVisible() {
		Logger.info("Check if 'Password' input field is visible");
		return passwordInputField.isVisible();
	}

	public boolean isMobilePhoneNumberInputFieldVisible() {
		Logger.info("Check if 'Mobile phone #' input field is visible");
		return mobilePhoneNumberInputField.isVisible();
	}

	public PTRegistrationPage typePhoneNumber(String phoneNumber) {
		Logger.info("Type phone number");
		mobilePhoneNumberInputField.clear();
		mobilePhoneNumberInputField.type(phoneNumber);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public void typePassword(String password) {
		Logger.info("Type password");
		passwordInputField.type(password);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isPasswordRequirementsBoxVisible() {
		Logger.info("Check if password requirements box is visible");
		return passwordRequirementsBox.isVisible();
	}

	public int getNumberOfPasswordValidations() {
		Logger.info("Get number of password validation points");
		return passwordRequirementsBox.getVisibleElementsCount();
	}

	public String getPasswordRequirementsText(int elementNumber) {
		String tipText = passwordRequirementsBox.getTextFromElementNumber(elementNumber);
		Logger.info("Getting the requirments tips text - " + tipText);
		return tipText;
	}

	public boolean isPasswordValidationPointRequired(int validationNumber) {
		Logger.info("Verify if password meets requirement #" + validationNumber);
		return passwordRequirementsBox.isAttributePresentForElementNumber("disabled", validationNumber);
	}

	public String getRequirementsBoxHeaderText() {
		Logger.info("Get requirements box header text");
		return passwordRequirementsStatus.getText();
	}

	public boolean isPhoneNumberErrorMessageVisible() {
		Logger.info("Check if phone number error message is visible");
		phoneNumberErrorMessage.waitUntilVisible();
		return phoneNumberErrorMessage.isVisible();
	}

	public String getPhoneNumberErrorMessageText() {
		Logger.info("Get phone number error message text");
		return phoneNumberErrorMessage.getText();
	}

	public boolean isTechnicalIssuesErrorMessageVisible() {
		Logger.info("Check if 'We are experiencing technical issues. Please try again.' error message is visible");
		return errorMessageTryAgainLink.isVisible();
	}

	public void avoidTechnicalIssuesMessage() {
		Logger.info("Trying to avoid technical issues message");
		int tryNumber = 1;
		while (tryNumber <= 7 && isTechnicalIssuesErrorMessageVisible()) {
			errorMessageTryAgainLink.click();
			Utils.waitFor(1500);
			tryNumber++;
		}
	}

	public boolean isSignUpNowButtonEnabled() {
		Logger.info("Check if 'Sign up now' button is enabled");
		waitForAjaxRequestToBeFinished();
		return signUpNowButton.isEnabled();
	}

	public <T> T clickSignUpButton(Class<T> expectedPage) {
		Logger.info("Click 'Sign up now' button");
		signUpNowButton.click();
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public void clickTermsAndConditionsCheckbox() {
		Logger.info("Click 'Terms and conditions' checkbox");
		termsAndConditionsCheckbox.click();
		waitForAjaxRequestToBeFinished();
	}

	public void clickConsentCheckbox() {
		Logger.info("Click 'Consent' checkbox");
		consentCheckbox.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isEditEmailButtonVisible() {
		Logger.info("Check if 'Edit' button is visible near input field");
		return editEmailButton.isVisible();
	}

	public boolean isMessageForEHMemberVisible() {
		Logger.info("Check if message for existing EH user email is visible");
		return alreadyEhMemberMessage.isVisible();
	}
}
