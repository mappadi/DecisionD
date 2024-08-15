package mayoclinicdiet.pages;

import framework.Logger;
import framework.Settings;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class RegistrationPage extends BasicPage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "registration";
		String CLASS_NAME = "RegistrationPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		settings = new Settings();
	}

	protected WebObject registrationTitle;
	protected WebObject textFields;
	protected WebObject passwordFields;
	protected WebObject firstNameField;
	protected WebObject lastNameField;
	protected WebObject emailAddressField;
	protected WebObject passwordField;
	protected WebObject confirmPasswordField;
	protected WebObject cardNumberField;
	protected WebObject securityCodeField;
	protected WebObject zipCodeField;
	protected WebObject termsOfUseCheckbox;
	protected WebObject signUpNowButton;
	protected WebObject cardTypeDefaultValue;
	protected WebObject monthDefaultValue;
	protected WebObject yearDefaultValue;
	protected WebObject countryDefaultValue;
	protected WebObject errorMessage;
	protected WebObject enterFirstNameMessage;
	protected WebObject enterLastNameMessage;
	protected WebObject enterEmailMessage;
	protected WebObject enterPasswordMessage;
	protected WebObject confirmPasswordMessage;
	protected WebObject enterCardNumberMessage;
	protected WebObject enterCodeMessage;
	protected WebObject selectMonthMessage;
	protected WebObject selectYearMessage;
	protected WebObject enterBillingZipCodeMessage;
	protected WebObject errorMessageForTermsOfUse;
	protected WebObject expirationDateMessage;
	protected WebObject billingPlan;
	protected WebObject confirmEmailField;
	protected String rememberBillingPlan;
	protected String emailAddress;
	protected Settings settings;

	public RegistrationPage rememberBillingPlan() {
		rememberBillingPlan = billingPlan.getText();
		return this;
	}

	public RegistrationPage enterFirstName(String firstName) {
		Logger.info("Enter first name");
		firstNameField
				.waitUntilVisible()
				.type(firstName);
		return this;
	}

	public RegistrationPage enterLastName(String lastName) {
		Logger.info("Enter last name");
		lastNameField
				.waitUntilVisible()
				.type(lastName);
		return this;
	}

	public RegistrationPage enterNewEmail() {
		Random random = new Random();
		emailAddress = String.format("test%s@mailinator.com", String.valueOf(random.nextInt()));
		Logger.info("Enter email address");
		emailAddressField
				.waitUntilVisible()
				.type(emailAddress);
		return this;
	}

	public RegistrationPage confirmEmailAddress() {
		Logger.info("Confirm email address" + emailAddress);
		confirmEmailField.type(emailAddress);
		return this;
	}

	public RegistrationPage enterIncorrectNewEmail(String email) {
		Logger.info("Enter incorrect email address");
		emailAddressField
				.waitUntilVisible()
				.type(email);
		return this;
	}

	public RegistrationPage enterNewPassword(String password) {
		Logger.info("Enter password");
		passwordField
				.waitUntilVisible()
				.type(password);
		return this;
	}

	public RegistrationPage confirmNewPassword(String password) {
		Logger.info("Enter password one more time");
		confirmPasswordField
				.waitUntilVisible()
				.type(password);
		return this;
	}

	public RegistrationPage selectCreditCard(String card) {
		Logger.info("Select Credit Card");
		WebElement cardType = basedriver.findElement(By.id("CardType"));
		Select creditCard = new Select(cardType);
		creditCard.selectByValue(card);
		return this;
	}

	public RegistrationPage enterCardNumber(String cardNumber) {
		Logger.info("Enter card number");
		cardNumberField
				.waitUntilVisible()
				.type(cardNumber);
		return this;
	}

	public RegistrationPage enterSecurityCode(String securityCode) {
		Logger.info("Enter security code");
		securityCodeField
				.waitUntilVisible()
				.type(securityCode);
		return this;
	}

	public RegistrationPage selectMonth(String month) {
		Logger.info("Select month");
		WebElement monthDropdown = basedriver.findElement(By.id("ExpirationDateMonth"));
		Select expirationMonth = new Select(monthDropdown);
		expirationMonth.selectByVisibleText(month);
		return this;
	}

	public RegistrationPage selectYear(String year) {
		Logger.info("Select year");
		WebElement yearDropdown = basedriver.findElement(By.id("ExpirationDateYear"));
		Select expirationYear = new Select(yearDropdown);
		expirationYear.selectByValue(year);
		return this;
	}

	public RegistrationPage selectCountry(String country) {
		Logger.info("Select country");
		WebElement countryDropdown = basedriver.findElement(By.id("BillingCountry"));
		Select billingCountry = new Select(countryDropdown);
		billingCountry.selectByVisibleText(country);
		return this;
	}

	public RegistrationPage enterZipCode(String zip) {
		Logger.info("Enter Zip code");
		zipCodeField
				.waitUntilVisible()
				.type(zip);
		return this;
	}

	public RegistrationPage termsOfUseCheck() {
		Logger.info("Select 'Terms of use' checkbox");
		termsOfUseCheckbox
				.waitUntilVisible()
				.click();
		assertTrue(termsOfUseCheckbox.isSelected(), "'Terms of use' checkbox is not selected");
		return this;
	}

	public WelcomePage submitRegistration() {
		Logger.info("Submit registration");
		signUpNowButton
				.waitUntilVisible()
				.click();
		return PageFactory.initElements(basedriver, WelcomePage.class);
	}

	public RegistrationPage submitErrorRegistration() {
		Logger.info("Submit error registration");
		signUpNowButton
				.waitUntilVisible()
				.click();
		return PageFactory.initElements(basedriver, RegistrationPage.class);
	}

	public RegistrationPage checkSharedRegistrationUrl() {
		Logger.info("Check 'Shared Registration' url");
		String currentURL = basedriver.getCurrentUrl();
		assertTrue(currentURL.contains("/sharedregistration"), "URL doesn't contain '/sharedregistration'");
		return this;
	}

	public RegistrationPage checkSubheaderDisplayed() {
		Logger.info("Check registration title is presented");
		boolean isSubHeaderPresent =
				registrationTitle
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isSubHeaderPresent, "Subheader is not present");
		return this;
	}

	public RegistrationPage checkInputFieldsEmpty() {
		Logger.info("Check text fields are empty");
		assertEquals(textFields.getText(), "", "Input field is not empty");

		Logger.info("Check password fields are empty");
		assertEquals(passwordFields.getText(), "", "Input field is not empty");

		Logger.info("Check 'Card Type' selector is empty");
		assertTrue(cardTypeDefaultValue.isSelected(), "Card type selector is not empty");

		Logger.info("Check 'Month' selector is empty");
		assertTrue(monthDefaultValue.isSelected(), "Month selector is not empty");

		Logger.info("Check 'Year' selector is empty");
		assertTrue(yearDefaultValue.isSelected(), "Year selector is not empty");

		Logger.info("Check 'Country' selector is empty");
		assertTrue(countryDefaultValue.isSelected(), "Country selector is not empty");
		return this;
	}

	public RegistrationPage checkTermsOfUseCheckboxDisplayed() {
		Logger.info("Check 'Terms Of Use' checkbox is presented");
		boolean termsOfUseCheckboxDisplayed =
				termsOfUseCheckbox
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(termsOfUseCheckboxDisplayed, "'Terms of use' checkbox is not displayed");
		return this;
	}

	public RegistrationPage checkErrorMessageDisplayed() {
		Logger.info("Check error message is presented");
		boolean isErrorMessageDisplayed =
				errorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message is not displayed");
		return this;
	}

	public RegistrationPage navigateToNextField() {
		Logger.info("Navigate to next field");
		withActions().sendKeys(Keys.TAB).build().perform();
		return this;
	}

	public RegistrationPage checkErrorMessageUnderTermsOfUseCheckbox() {
		Logger.info("Check error message under 'Terms of use' checkbox is presented");
		boolean isMessageDisplayed =
				errorMessageForTermsOfUse
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMessageDisplayed, "Error message is not displayed");
		return this;
	}

	public RegistrationPage checkErrorMessageForFirstNameFieldDisplayed() {
		Logger.info("Check error message under 'First Name' field is presented");
		boolean isErrorMessageDisplayed =
				enterFirstNameMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'First Name' field is not displayed");
		return this;
	}

	public RegistrationPage checkErrorMessageForLastNameFieldDisplayed() {
		Logger.info("Check error message under 'Last Name' field is presented");
		boolean isErrorMessageDisplayed =
				enterLastNameMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Last Name' field is not displayed");
		return this;
	}

	public RegistrationPage checkErrorMessageForEmailAddressFieldDisplayed() {
		Logger.info("Check error message under 'Email Address' field is presented");
		boolean isErrorMessageDisplayed =
				enterEmailMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Email Address' field is not displayed");
		return this;
	}

	public RegistrationPage checkErrorMessageForPasswordFieldDisplayed() {
		Logger.info("Check error message under 'Password' field is presented");
		boolean isErrorMessageDisplayed =
				enterPasswordMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Password' field is not displayed");
		return this;
	}

	public RegistrationPage checkErrorMessageForConfirmPasswordFieldDisplayed() {
		Logger.info("Check error message under 'Confirm Password' field is presented");
		boolean isErrorMessageDisplayed =
				confirmPasswordMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Confirm Password' field is not displayed");
		return this;
	}

	public RegistrationPage checkErrorMessageForCardNumberFieldDisplayed() {
		Logger.info("Check error message under 'Card number' field is presented");
		boolean isErrorMessageDisplayed =
				enterCardNumberMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Card Number' field is not displayed");
		return this;
	}

	public RegistrationPage checkErrorMessageForSecurityCodeFieldDisplayed() {
		Logger.info("Check error message under 'Security Code' field is presented");
		boolean isErrorMessageDisplayed =
				enterCodeMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Security Code' field is not displayed");
		return this;
	}

	public RegistrationPage checkErrorMessageForMonthDropdownDisplayed() {
		Logger.info("Check error message under 'Month' dropdown is presented");
		boolean isErrorMessageDisplayed =
				selectMonthMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Month' dropdown is not displayed");
		return this;
	}

	public RegistrationPage checkErrorMessageForYearDropdownDisplayed() {
		Logger.info("Check error message under 'Year' dropdown is presented");
		boolean isErrorMessageDisplayed =
				selectYearMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Year' dropdown is not displayed");
		return this;
	}

	public RegistrationPage checkErrorMessageForZipCodeFieldDisplayed() {
		Logger.info("Check error message under 'Zip/Postel Code' field is presented");
		boolean isErrorMessageDisplayed =
				enterBillingZipCodeMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Zip/Postal Code' field is not displayed");
		return this;
	}

	public RegistrationPage checkExpirationDateMessageDisplayed() {
		Logger.info("Check error message under 'Month' dropdown is presented");
		boolean isErrorMessageDisplayed =
				expirationDateMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Month' dropdown is not displayed");
		return this;
	}

	@Override
	public void waitForPageToLoad() {
		registrationTitle.waitUntilVisible();
	}
}
