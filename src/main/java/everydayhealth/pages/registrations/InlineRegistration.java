package everydayhealth.pages.registrations;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Page object for inline registration page
 */
public class InlineRegistration extends BasicPageEH {

	public InlineRegistration(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "registrations";
		String CLASS_NAME = "InlineRegistration";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject inlineRegistrationSection;
	protected WebObject emailidTextBox;
	protected WebObject passwordTextBox;
	protected WebObject signupButton;
	protected WebObject warningMessage;
	protected WebObject termsAndConditionsCheckBox;
	protected WebObject passwordRequirementsBox;
	protected WebObject passwordRequirementsStatus;
	protected WebObject termsAndConditionsPrivacyPolicy;
	protected WebObject formHeader;

	@Override
	public void waitForPageToLoad() {
		signupButton.waitUntilVisibleOnPage(this);
	}

	public boolean isInlineRegistrationSectionVisible() {
		Logger.info("Checking if Inline Registration section is visible");
		return inlineRegistrationSection.isVisible();
	}

	public void createNewInlineRegistration(String email, String password) {
		Logger.info("Creating an inline registration");
		enterEmailAndTabOut(email);
		enterPassword(password);
		termsAndConditionsCheckBox.scrollToElement();
		termsAndConditionsCheckBox.click();
		signupButton.click();
		if (!Settings.isDesktop()) {
			waitFor(5000); //Wait for new page to start loading
		}
		waitForAjaxRequestToBeFinished();
	}

	public void enterEmailAndTabOut(String email) {
		Logger.info("Entering email as " + email);
		emailidTextBox.type(email);
		if (Settings.isDesktop()) {
			emailidTextBox.sendKeys(Keys.TAB);
		} else {
			formHeader.click();
		}
		waitForAjaxRequestToBeFinished(750);
	}

	public boolean isWarningMessageWithTextVisible(String text) {
		Logger.info("Check if warning message visible");
		waitForAjaxRequestToBeFinished(1250);
		return warningMessage.isElementWithTextVisible(text);
	}

	public boolean isSignupButtonClickable() {
		Logger.info("Checking submit button is not clickable when no data entered");
		return signupButton.isCurrentlyEnabled();
	}

	public boolean isPasswordRequirementsTipsVisible() {
		Logger.info("Checking the password requirements box is visible");
		return passwordRequirementsBox.isVisible();
	}

	public void enterPassword(String password) {
		Logger.info("Entering password as " + password);
		passwordTextBox.type(password);
		waitForAjaxRequestToBeFinished(750);
	}

	public String getPasswordRequirementsText(int elementNumber) {
		String tipText = passwordRequirementsBox.getTextFromElementNumber(elementNumber);
		Logger.info("Getting the requirments tips text - " + tipText);
		return tipText;
	}

	public String getTermsAndConditionsLinkText(int elementNumber) {
		String termsAndConditionsLinkText = termsAndConditionsPrivacyPolicy.getTextFromElementNumber(elementNumber);
		Logger.info("Getting the Terms and conditions link text" + termsAndConditionsLinkText);
		return termsAndConditionsLinkText;
	}

	public String getTermsAndConditionsHrefValue() {
		Logger.info("Check Terms and conditions link 'href' attribute");
		return termsAndConditionsPrivacyPolicy.getAttributeOfElementNumber(1, "href");
	}

	public String getPrivacyPolicyHrefValue() {
		Logger.info("Check Privacy Policy link 'href' attribute");
		return termsAndConditionsPrivacyPolicy.getAttributeOfElementNumber(2, "href");
	}

	public boolean isPasswordValidationPointRequired(int validationNumber) {
		Logger.info("Verify if password meets requirement #" + validationNumber);
		return passwordRequirementsBox.isAttributePresentForElementNumber("disabled", validationNumber);
	}

	public String getRequirementsBoxHeaderText() {
		Logger.info("Get requirements box header text");
		return passwordRequirementsStatus.getText();
	}

	public int getNumberOfPasswordValidations() {
		Logger.info("Get number of password validation points");
		return passwordRequirementsBox.getVisibleElementsCount();
	}
}