package everydayhealth.pages.registrations;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.platform.UserEH;
import framework.platform.html.WebObject;
import framework.platform.utilities.StringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object for registration page - step one
 */
public class MainRegistrationStepOne extends BasicPageEH {

	public MainRegistrationStepOne(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "registrations";
		String CLASS_NAME = "MainRegistrationStepOne";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject email;
	protected WebObject emailInputValidationError;
	protected WebObject emailInputValidationSuccess;
	protected WebObject emailErrorMessage;
	protected WebObject emailSubscribedErrorMessage;
	protected WebObject emailConfirm;
	protected WebObject emailConfirmInputValidationError;
	protected WebObject emailConfirmInputValidationSuccess;
	protected WebObject emailConfirmErrorMessage;
	protected WebObject firstName;
	protected WebObject firstNameErrorMessage;
	protected WebObject lastName;
	protected WebObject lastNameErrorMessage;
	protected WebObject screenName;
	protected WebObject screenNameErrorMessage;
	protected WebObject screenNameTaken;
	protected WebObject password;
	protected WebObject passwordInputValidationError;
	protected WebObject passwordInputValidationSuccess;
	protected WebObject passwordErrorMessage;
	protected WebObject passwordConfirm;
	protected WebObject passwordConfirmInputValidationError;
	protected WebObject passwordConfirmInputValidationSuccess;
	protected WebObject passwordConfirmErrorMessage;
	protected WebObject genderRadioButton;
	protected WebObject genderRadioButtonErrorMessage;
	protected WebObject dobMM;
	protected WebObject dobMMErrorMessage;
	protected WebObject dobDD;
	protected WebObject dobDDErrorMessage;
	protected WebObject dobYYYY;
	protected WebObject dobYYYYErrorMessage;
	protected WebObject country;
	protected WebObject zipCode;
	protected WebObject zipCodeErrorMessage;
	protected WebObject interests;
	protected WebObject interestsButtons;
	protected WebObject termsAgree;
	protected WebObject termsAgreeErrorMessage;
	protected WebObject privecyTermsText;
	protected WebObject submitButton;

	@Override
	public void waitForPageToLoad() {
		submitButton.waitUntilVisibleOnPage(this);
	}

	public boolean isEmailVisible() {
		Logger.info("Verifying email field is visible");
		return email.isVisible();
	}

	public boolean isEmailConfirmationVisible() {
		Logger.info("Verifying email confirmation field is visible");
		return emailConfirm.isVisible();
	}

	public boolean isFirstNameVisible() {
		Logger.info("Verifying first name field is visible");
		return firstName.isVisible();
	}

	public boolean isLastNameVisible() {
		Logger.info("Verifying last name field is visible");
		return lastName.isVisible();
	}

	public boolean isScreenNameVisible() {
		Logger.info("Verifying screen name field is visible");
		return screenName.isVisible();
	}

	public boolean isPasswordVisible() {
		Logger.info("Verifying password field is visible");
		return password.isVisible();
	}

	public boolean isPasswordConfirmVisible() {
		Logger.info("Verifying password confirmation field is visible");
		return emailConfirm.isVisible();
	}

	public int getGenderButtons() {
		genderRadioButton.scrollToElement();
		return genderRadioButton.getVisibleElementsCount();
	}

	public boolean isDobMonthVisible() {
		Logger.info("Verifying dob month field is visible");
		return dobMM.isVisible();
	}

	public boolean isDobDayVisible() {
		Logger.info("Verifying dob day field is visible");
		return dobDD.isVisible();
	}

	public boolean isDobYearVisible() {
		Logger.info("Verifying dob year field is visible");
		return dobYYYY.isVisible();
	}

	public boolean isCountryVisible() {
		Logger.info("Verifying country select field is visible");
		return country.isVisible();
	}

	public boolean isZipCodeVisible() {
		Logger.info("Verifying zip code field is visible");
		return zipCode.isVisible();
	}

	public boolean isPrivacyTermsTextVisible() {
		Logger.info("Checking the Privacy terms text is visible");
		return privecyTermsText.isVisible();
	}
	
	public String getPrivacyTermsText() {
		Logger.info("Getting the privacy terms text");
		return privecyTermsText.getText();
	}

	public boolean isTermsAgreeVisible() {
		Logger.info("Verifying agree terms of service is visible");
		return termsAgree.isVisible();
	}

	public int getNumberOfInterests() {
		Logger.info("Getting total number of interests");
		submitButton.scrollToElement();
		termsAgree.waitUntilVisible();
		return interests.getElementsCount();
	}
	
	public int getNumberOfInterestsButtons() {
		Logger.info("Getting the total number of interests input buttons");
		submitButton.scrollToElement();
		termsAgree.waitUntilVisible();
		return interestsButtons.getElementsCount();
	}

	public void setEmail(String value) {
		email.scrollToElement();
		email.type(value);
	}

	public void setEmailConfirm(String value) {
		emailConfirm.scrollToElement();
		emailConfirm.type(value);
	}

	public void setFirstName(String value) {
		firstName.scrollToElement();
		firstName.type(value);
	}

	public void setLastName(String value) {
		lastName.scrollToElement();
		lastName.type(value);
	}

	public void setScreenName(String value) {
		screenName.scrollToElement();
		screenName.type(value);
	}

	public void setPassword(String value) {
		password.scrollToElement();
		password.type(value);
	}

	public void setPasswordConfirm(String value) {
		passwordConfirm.scrollToElement();
		passwordConfirm.type(value);
	}

	public void setGender() {
		genderRadioButton.scrollToElement();
		int selection = StringUtils.generateRandomInt(1);
		genderRadioButton.clickOnElementNumber(selection);
	}

	public void setDOBMonth(String month) {
		dobMM.scrollToElement();
		dobMM.selectByValue(month);
	}

	public void setDOBDay(String day) {
		dobDD.selectByText(day);
	}

	public void setDOBYear(String year) {
		dobYYYY.selectByText(year);
	}

	public void setZipCode(String value) {
		zipCode.scrollToElement();
		zipCode.type(value);
	}

	public void clickTermsAgree() {
		termsAgree.scrollToElement();
		termsAgree.click();
	}

	public MainRegistrationStepTwo clickSubmitButton() {
		Logger.info("Click 'submit' button to proceed to step two");
		submitButton.click();
		waitForAjaxRequestToBeFinished();
			if (WebDriverManager.getDriver().getCurrentUrl().contains("offers")) {
				OffersPage offersPage = new OffersPage(basedriver);
				offersPage.clickSkipOffer();
			}
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(basedriver, MainRegistrationStepTwo.class);
	}

	public MainRegistrationStepTwo fillAndSubmitFirstRegistrationForm(UserEH newUser, String newUserEmail) {
		Logger.info("Filling registration form creating new user");
		setEmail(newUserEmail);
		setEmailConfirm(newUserEmail);
		setFirstName(newUser.getFirstName());
		setLastName(newUser.getLastName());
		setScreenName(newUser.getScreenName());
		setPassword(newUser.getPassword());
		setPasswordConfirm(newUser.getPassword());
		setGender();
		setDOBMonth(newUser.getDobMM());
		setDOBDay(newUser.getDobDD());
		setDOBYear(newUser.getDobYYYY());
		setZipCode(newUser.getZip());
		clickTermsAgree();
		return clickSubmitButton();
	}

	public void clickSubmitButtonWithoutData() {
		Logger.info("Clicking on 'submit' button to verify error messaging");
		submitButton.click();
	}

	public boolean isEmailErrorMessageVisible() {
		Logger.info("Verifying the form validation email error message is visible");
		email.scrollToElement();
		return emailErrorMessage.isVisible();
	}

	public boolean isEmailConfirmErrorMessageVisible() {
		Logger.info("Verifying the form validation confirmation email error message is visible");
		email.scrollToElement();
		return emailConfirmErrorMessage.isVisible();
	}

	public boolean isFirstNameErrorMessageVisible() {
		Logger.info("Verifying the form validation first name error message is visible");
		firstName.scrollToElement();
		return firstNameErrorMessage.isVisible();
	}

	public boolean isLastNameErrorMessageVisible() {
		Logger.info("Verifying the form validation last name error message is visible");
		lastName.scrollToElement();
		return lastNameErrorMessage.isVisible();
	}

	public boolean isScreenNameErrorMessageVisible() {
		Logger.info("Verifying the form validation screen name error message is visible");
		screenName.scrollToElement();
		return screenNameErrorMessage.isVisible();
	}

	public boolean isPasswordErrorMessageVisible() {
		Logger.info("Verifying the form validation password error message is visible");
		password.scrollToElement();
		return passwordErrorMessage.isVisible();
	}

	public boolean isPasswordConfirmErrorMessageVisible() {
		Logger.info("Verifying the form validation password confirmation error message is visible");
		passwordConfirm.scrollToElement();
		return passwordConfirmErrorMessage.isVisible();
	}

	public boolean isGenderRadioButtonErrorMessageVisible() {
		Logger.info("Verifying the form validation gender radio button error message is visible");
		genderRadioButton.scrollToElement();
		return genderRadioButtonErrorMessage.isVisible();
	}

	public boolean isDobMMErrorMessageVisible() {
		Logger.info("Verifying the form validation dob MM error message is visible");
		dobMM.scrollToElement();
		return dobMMErrorMessage.isVisible();
	}

	public boolean isDobDDErrorMessageVisible() {
		Logger.info("Verifying the form validation dob DD error message is visible");
		dobDD.scrollToElement();
		return dobDDErrorMessage.isVisible();
	}

	public boolean isDobYYYYErrorMessageVisible() {
		Logger.info("Verifying the form validation dob YYYY error message is visible");
		dobYYYY.scrollToElement();
		return dobYYYYErrorMessage.isVisible();
	}

	public boolean isZipCodeErrorMessageVisible() {
		Logger.info("Verifying the form validation zip code error message is visible");
		zipCode.scrollToElement();
		return zipCodeErrorMessage.isVisible();
	}

	public boolean isTermsAgreeErrorMessageVisible() {
		Logger.info("Verifying the form validation terms agreement error message is visible");
		submitButton.scrollIntoView();
		return termsAgreeErrorMessage.isVisible();
	}

	public boolean isEmailInputValidationErrorVisible() {
		Logger.info("Verifying the inline form validation email error message is visible");
		email.scrollToElement();
		return emailInputValidationError.isVisible();
	}

	public boolean isEmailInputValidationSuccessVisible() {
		Logger.info("Verifying the inline form validation email success message is visible");
		email.scrollToElement();
		return emailInputValidationSuccess.isVisible();
	}

	public boolean isEmailConfirmInputValidationErrorVisible() {
		Logger.info("Verifying the inline form validation email confirmation error message is visible");
		emailConfirm.scrollToElement();
		return emailConfirmInputValidationError.isVisible();
	}

	public boolean isEmailConfirmInputValidationSuccessVisible() {
		Logger.info("Verifying the inline form validation email confirmation success message is visible");
		emailConfirm.scrollToElement();
		return emailConfirmInputValidationSuccess.isVisible();
	}

	public MainRegistrationStepOne waitForEmailSubscribedValidationError() {
		email.scrollToElement();
		emailSubscribedErrorMessage.waitUntilVisible();
		return this;
	}

	public boolean isEmailAlreadySubscribedErrorVisible() {
		Logger.info("Verifying the 'user email is already subscribed' error message");
		return emailSubscribedErrorMessage.getText().contains("email address is already subscribed");
	}

	public MainRegistrationStepOne waitForScreenNameTakenValidationError() {
		screenName.scrollToElement();
		screenNameTaken.waitUntilVisible();
		return this;
	}

	public boolean isScreenNameAlreadyTakenErrorMessageVisible() {
		Logger.info("Verifying the 'screen name is already taken' error message");
		return screenNameTaken.getText().contains("JohnSmithAutomation");
	}

	public MainRegistrationStepOne waitForScreenNameAvailable() {
		screenName.scrollToElement();
		screenNameTaken.waitUntilInvisible();
		return this;
	}

	public boolean isScreenNameAvailable() {
		Logger.info("Verifying the 'scren name is already taken' error message is removed");
		return screenNameTaken.isVisible();
	}

	public MainRegistrationStepOne waitForPasswordInputValidationError() {
		password.scrollToElement();
		passwordInputValidationError.waitUntilVisible();
		return this;
	}

	public boolean isPasswordInputValidationErrorVisible() {
		Logger.info("Verifying the inline form validation password error message is visible");
		return passwordInputValidationError.isVisible();
	}

	public MainRegistrationStepOne waitForPasswordInputValidationSuccess() {
		password.scrollToElement();
		passwordInputValidationSuccess.waitUntilVisible();
		return this;
	}

	public boolean isPasswordInputValidationSuccessVisible() {
		Logger.info("Verifying the inline form validation password success message is visible");
		return passwordInputValidationSuccess.isVisible();
	}

	public MainRegistrationStepOne waitForPasswordConfirmInputValidationError() {
		passwordConfirm.scrollToElement();
		passwordConfirmInputValidationError.waitUntilVisible();
		return this;
	}

	public boolean isPasswordConfirmInputValidationErrorVisible() {
		Logger.info("Verifying the inline form validation password confirmation error message is visible");
		return passwordConfirmInputValidationError.isVisible();
	}

	public MainRegistrationStepOne waitForPasswordConfirmInputValidationSuccess() {
		passwordConfirm.scrollToElement();
		passwordConfirmInputValidationSuccess.waitUntilVisible();
		return this;
	}

	public boolean isPasswordConfirmInputValidationSuccessVisible() {
		Logger.info("Verifying the inline form validation password confirmation success message is visible");
		return passwordConfirmInputValidationSuccess.isVisible();
	}
}
