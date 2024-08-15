package mayoclinicdiet.pages;

import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * TwoStepRegistrationPage
 */

public class TwoStepRegistrationPage extends BasicPage {

	public TwoStepRegistrationPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "registration";
		String CLASS_NAME = "TwoStepRegistrationPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject firstStepIFrame;
	protected WebObject secondStepIFrame;
	protected WebObject firstNameField;
	protected WebObject firstNameErrorMessage;
	protected WebObject lastNameField;
	protected WebObject lastNameErrorMessage;
	protected WebObject emailAddressField;
	protected WebObject emailAddressErrorMessage;
	protected WebObject confirmEmailField;
	protected WebObject confirmEmailErrorMessage;
	protected WebObject passwordField;
	protected WebObject passwordRequirementsContainer;
	protected WebObject requirementCapitalLetter;
	protected WebObject requirementNumber;
	protected WebObject requirementLowercaseLetter;
	protected WebObject requirementLength;
	protected WebObject confirmPasswordField;
	protected WebObject confirmPasswordErrorMessage;
	protected WebObject tosCheckbox;
	protected WebObject tosCheckboxErrorMessage;
	protected WebObject tosLabel;
	protected WebObject tosLink;
	protected WebObject programText;
	protected WebObject continueButton;
	protected WebObject progressBar;
	protected WebObject progressBarStep1;
	protected WebObject step1Info;
	protected WebObject progressBarStep2;
	protected WebObject step2Info;
	protected WebObject paymentFirstNameLabel;
	protected WebObject paymentFirstNameInput;
	protected WebObject paymentLastNameLabel;
	protected WebObject paymentLasttNameInput;
	protected WebObject paymentZipCodeLabel;
	protected WebObject paymentZipCodeInput;
	protected WebObject paymentBillingCountryLabel;
	protected WebObject paymentBillingCountryDropdown;
	protected WebObject paymentBillingCountryDropdownUSA;
	protected WebObject paymentCardTypeLabel;
	protected WebObject paymentCardTypeVisaRadiobutton;
	protected WebObject paymentCardTypeVisaImage;
	protected WebObject paymentCardTypeMastercardRadiobutton;
	protected WebObject paymentCardTypeMastercardImage;
	protected WebObject paymentCardTypeAmericanExpressRadiobutton;
	protected WebObject paymentCardTypeAmericanExpressImage;
	protected WebObject paymentCardTypeMaestroRadiobutton;
	protected WebObject paymentCardTypeMaestroImage;
	protected WebObject paymentCardNumberLabel;
	protected WebObject paymentCardNumberInput;
	protected WebObject paymentCVVNumberLabel;
	protected WebObject paymentCVVNumberInput;
	protected WebObject paymentNortonSecuredLogo;
	protected WebObject paymentExpiryDateLabel;
	protected WebObject paymentExpiryMonthDropdown;
	protected WebObject paymentExpiryMonthDropdownOption;
	protected WebObject paymentExpiryYearDropdown;
	protected WebObject paymentExpiryYearDropdownOption;
	protected WebObject paymentContinueButton;
	protected WebObject paymentErrorMessage;
	protected WebObject paymentErrorMessageFields;

	@Override
	public void waitForPageToLoad() {
		progressBar.waitUntilVisibleOnPage(this);
	}

	public void switchToFirstStepIFrame() {
		WebDriverManager.getDriver().switchTo().frame(firstStepIFrame.getElement());
	}

	public void switchToSecondStepIFrame() {
		WebDriverManager.getDriver().switchTo().frame(secondStepIFrame.getElement());
	}

	public void switchToMainWindow(){
		WebDriverManager.getDriver().switchTo().defaultContent();
	}

	public boolean isFirstNameFieldVisible() {
		Logger.info("Verify if 'First name' text input is visible");
		return firstNameField.isVisible();
	}

	public TwoStepRegistrationPage typeFirstName(String text) {
		Logger.info("Type data into 'First Name' field");
		firstNameField.type(text);
		return this;
	}

	public boolean isFirstNameErrorMessageVisible() {
		Logger.info("Verify if error message for incorrect first name is visible");
		return firstNameErrorMessage.isVisible();
	}

	public boolean isLastNameFieldVisible() {
		Logger.info("Verify if 'Last name' text input is visible");
		return lastNameField.isVisible();
	}

	public TwoStepRegistrationPage typeLastName(String text) {
		Logger.info("Type data into 'Last Name' field");
		lastNameField.type(text);
		return this;
	}

	public boolean isLastNameErrorMessageVisible() {
		Logger.info("Verify if error message for incorrect last name is visible");
		return lastNameErrorMessage.isVisible();
	}

	public boolean isEmailFieldVisible() {
		Logger.info("Verify if 'Email' text input is visible");
		return emailAddressField.isVisible();
	}

	public TwoStepRegistrationPage typeEmailAddress(String email) {
		Logger.info("Type data into 'Email' field");
		emailAddressField.type(email);
		return this;
	}

	public boolean isEmailErrorMessageVisible() {
		Logger.info("Verify if error message for incorrect email is visible");
		return emailAddressErrorMessage.isVisible();
	}

	public boolean isConfirmEmailFieldVisible() {
		Logger.info("Verify if 'Confirm Email' text input is visible");
		return confirmEmailField.isVisible();
	}

	public TwoStepRegistrationPage typeConfirmationEmailAddress(String email) {
		Logger.info("Type data into 'Confirm Email' field");
		confirmEmailField.type(email);
		return this;
	}

	public boolean isConfirmationEmailErrorMessageVisible() {
		Logger.info("Verify if error message for incorrect email confirmation is visible");
		return confirmEmailErrorMessage.isVisible();
	}

	public boolean isPasswordFieldVisible() {
		Logger.info("Verify if 'Password' text input is visible");
		return passwordField.isVisible();
	}

	public TwoStepRegistrationPage typePassword(String password) {
		Logger.info("Type data into 'Password' field");
		passwordField.type(password);
		return this;
	}

	public boolean isPasswordRequirementsBoxVisible() {
		Logger.info("Verify if password requirements box is visible");
		return passwordRequirementsContainer.isVisible();
	}

	public boolean isCapitalLetterPresentInPassword() {
		Logger.info("Verify if capital letter is present in password");
		return requirementCapitalLetter.getAttribute("class").contains("yes");
	}

	public boolean isNumberPresentInPassword() {
		Logger.info("Verify if number is present in password");
		return requirementNumber.getAttribute("class").contains("yes");
	}

	public boolean isLowecaseLetterPresentInPassword() {
		Logger.info("Verify if lowercase letter is present in password");
		return requirementLowercaseLetter.getAttribute("class").contains("yes");
	}

	public boolean isPasswordLengthCorrect() {
		Logger.info("Verify if password has correct length");
		return requirementLength.getAttribute("class").contains("yes");
	}

	public boolean isConfirmPasswordFieldVisible() {
		Logger.info("Verify if 'Confirm Password' text input is visible");
		return confirmPasswordField.isVisible();
	}

	public TwoStepRegistrationPage typeConfirmationPassword(String password) {
		Logger.info("Type data into 'Confirm Password' field");
		confirmPasswordField.type(password);
		return this;
	}

	public boolean isConfirmationPasswordErrorMessageVisible() {
		Logger.info("Verify if error message for incorrect password confirmation is visible");
		return confirmPasswordErrorMessage.isVisible();
	}

	public boolean isTermsOfUseCheckboxVisible() {
		Logger.info("Verify if 'Terms of Use' checkbox is visible");
		return tosCheckbox.isVisible();
	}

	public TwoStepRegistrationPage clickTosCheckbox() {
		Logger.info("Click on 'Terms of Use' checkbox");
		tosCheckbox.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isTermsOfServiceErrorMessageVisible() {
		Logger.info("Verify if Terms of Service error message is visible");
		return tosCheckboxErrorMessage.isVisible();
	}

	public String getTermsOfUseLinkHrefAttributeValue() {
		Logger.info("Get 'Terms of use' link 'href' attribute value");
		return tosLink.getAttribute("href");
	}

	public boolean isProgramDescriptionVisible() {
		Logger.info("Verify if program description text is visible");
		return programText.isVisible();
	}

	public boolean isFirstStepContinueButtonVisible() {
		Logger.info("Verify if 'Continue' button is visible for 1st step");
		return continueButton.isVisible();
	}

	public TwoStepRegistrationPage clickFirstStepContinueButton() {
		Logger.info("Click 'Continue' button for 1st step");
		continueButton.click();
		return this;
	}

	public boolean isProgressBarVisible() {
		Logger.info("Verify if progress bar is visible");
		return progressBar.isVisible();
	}

	public boolean isFirstStepBarHighlighted() {
		Logger.info("Verify if progress bar 'Step 1' is highlighted");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/TR-237");
		return progressBarStep1.getAttribute("class").contains("on");
	}

	public boolean isFirstStepDescriptionVisible() {
		Logger.info("Verify if 1st step description is visible");
		return step1Info.isVisible();
	}

	public boolean isSecondStepBarHighlighted() {
		Logger.info("Verify if progress bar 'Step 2' is highlighted");
		return progressBarStep2.getAttribute("class").contains("on");
	}

	public boolean isSecondStepDescriptionVisible() {
		Logger.info("Verify if 2nd step description is visible");
		return step2Info.isVisible();
	}

	public boolean isFirstNameLabelVisible() {
		Logger.info("Verify if 'First name' label is visible");
		return paymentFirstNameLabel.isVisible();
	}

	public String getFirstNameInputText() {
		Logger.info("Get text from 'First Name' input");
		return paymentFirstNameInput.getValue();
	}

	public boolean isLastNameLabelVisible() {
		Logger.info("Verify if 'Last name' label is visible");
		return paymentLastNameLabel.isVisible();
	}

	public String getLastNameInputText() {
		Logger.info("Get text from 'Last Name' input");
		return paymentLasttNameInput.getValue();
	}

	public boolean isZipCodeLabelVisible() {
		Logger.info("Verify if 'Zip code' label is visible");
		return paymentZipCodeLabel.isVisible();
	}

	public TwoStepRegistrationPage typeZipCode(String zipCode) {
		Logger.info("Type zip code");
		paymentZipCodeInput.type(zipCode);
		return this;
	}

	public boolean isCountryLabelVisible() {
		Logger.info("Verify if 'Country' label is visible");
		return paymentBillingCountryLabel.isVisible();
	}

	public boolean isCountryDropdownVisible() {
		Logger.info("Verify if 'Country' dropdown is visible");
		return paymentBillingCountryDropdown.isVisible();
	}

	public TwoStepRegistrationPage chooseCountryAsUSA() {
		Logger.info("Choose 'USA' from dropdown");
		paymentBillingCountryDropdownUSA.click();
		return this;
	}

	public boolean isCardTypeLabelVisible() {
		Logger.info("Verify if 'Card type' label is visible");
		return paymentCardTypeLabel.isVisible();
	}

	public boolean isVisaImageVisible() {
		Logger.info("Verify if 'Visa' image is visible");
		return paymentCardTypeVisaImage.isVisible();
	}

	public boolean isMastercardImageVisible() {
		Logger.info("Verify if 'Mastercard' image is visible");
		return paymentCardTypeMastercardImage.isVisible();
	}

	public boolean isAmericanExpressImageVisible() {
		Logger.info("Verify if 'AmericanExpress' image is visible");
		return paymentCardTypeAmericanExpressImage.isVisible();
	}

	public boolean isMaestroImageVisible() {
		Logger.info("Verify if 'Maestro' image is visible");
		return paymentCardTypeMaestroImage.isVisible();
	}

	public TwoStepRegistrationPage clickVisaRadiobutton() {
		Logger.info("Click on 'Visa' radiobutton");
		paymentCardTypeVisaRadiobutton.click();
		return this;
	}

	public boolean isCardNumberLabelVisible() {
		Logger.info("Verify if 'Card Number' label is visible");
		return paymentCardNumberLabel.isVisible();
	}

	public TwoStepRegistrationPage typeCardNumber(String number) {
		Logger.info("Type card number");
		paymentCardNumberInput.type(number);
		return this;
	}

	public boolean isCVVLabelVisible() {
		Logger.info("Verify if 'CVV' label is visible");
		return paymentCVVNumberLabel.isVisible();
	}

	public TwoStepRegistrationPage typeCVVNumber(String cvv) {
		Logger.info("Type CVV number");
		paymentCVVNumberInput.type(cvv);
		return this;
	}

	public boolean isNortonSecuredImageVisible() {
		Logger.info("Verify if 'Norton Secured' image is visible");
		return paymentNortonSecuredLogo.isVisible();
	}

	public boolean isExpiryDateLabelVisible() {
		Logger.info("Verify if 'Expiry Date' label visible");
		return paymentExpiryDateLabel.isVisible();
	}

	public TwoStepRegistrationPage chooseExpiryDateMonth(String month) {
		Logger.info("Choose expiry month - " + month);
		paymentExpiryMonthDropdownOption.clickOnElementWithValue(month);
		return this;
	}

	public TwoStepRegistrationPage chooseExpiryDateYear(String year) {
		Logger.info("Choose expiry year - " + year);
		paymentExpiryYearDropdownOption.clickOnElementWithValue(year);
		return this;
	}

	public boolean isContinueButtonVisible() {
		Logger.info("Verify if 'Continue' button is visible");
		return paymentContinueButton.isVisible();
	}

	public TwoStepRegistrationPage clickPaymentContinueButton(){
		Logger.info("Click 'Continue' button for 2nd step");
		paymentContinueButton.click();
		return this;
	}

	public boolean isErrorBlockVisible() {
		Logger.info("Verify if error block is visible");
		return paymentErrorMessage.isVisible();
	}

	public TwoStepRegistrationPage clickContinueButton() {
		Logger.info("Click 'Continue' button");
		continueButton.click();
		return this;
	}

	public WelcomePage clickContinue() {
		Logger.info("Click 'Continue' button and proceed to welcome page");
		paymentContinueButton.click();
		return new WelcomePage(basedriver);
	}
}
