package mayoclinicdiet.pages;


import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ReActivation2499Page extends PublicHeaderMCD {

	public ReActivation2499Page(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "reActivation24.99";
		String CLASS_NAME = "ReActivation2499Page";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject headerImage;
	protected WebObject signUpNowButton;
	protected WebObject passwordFieldErrorMessage;
	protected WebObject confirmPasswordFieldErrorMessage;
	protected WebObject firstNameFieldErrorMessage;
	protected WebObject lastNameFieldErrorMessage;
	protected WebObject cardTypeFieldErrorMessage;
	protected WebObject cardNumberFieldErrorMessage;
	protected WebObject cardIdNumberFieldErrorMessage;
	protected WebObject expirationMonthFieldErrorMessage;
	protected WebObject expirationYearFieldErrorMessage;
	protected WebObject zipCodeFieldErrorMessage;
	protected WebObject firstNameField;
	protected WebObject lastNameField;
	protected WebObject passwordField;
	protected WebObject confirmPasswordField;
	protected WebObject cardNumberField;
	protected WebObject securityCodeField;
	protected WebObject zipCodeField;
	protected WebObject termsOfUseCheckbox;
	protected WebObject cardNumberError;
	protected WebObject termOfUsePopup;
	protected WebObject termsOfUseLink;
	protected WebObject emailAddressField;
	protected WebObject iFrame;
	protected WebObject confirmEmailField;
	protected WebObject confirmEmailFieldErrorMessage;
	private static String mainFrameLocator = "LoginUrl";
	private static String billingCountryLocator = "BillingCountry";
	private static String expirationYearLocator = "ExpirationDateYear";
	private static String expirationMonthLocator = "ExpirationDateMonth";
	private static String cardTypeLocator = "CardType";

	public ReActivation2499Page checkReActivationPageUrl() {
		Logger.info("Check '24.99 Re-Activation' page url");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("MCDSpecialOffer24"), "URL doesn't contain 'MCDSpecialOffer24'");
		return this;
	}

	public ReActivation2499Page checkHeaderDisplayed() {
		Logger.info("Check '24.99 Re-Activation' page header is displayed");
		boolean isHeaderDisplayed = headerImage
				.waitUntilVisible()
				.isPresent();
		assertTrue(isHeaderDisplayed, "'24.99 Re-Activation' page header is not displayed");
		return this;
	}

	public <T> T clickSignUpNowButton(Class<T> expectedPage) {
		Logger.info("Click 'Sign Up Now' button");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1580");
		signUpNowButton
				.waitUntilVisible()
				.then()
				.click();
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public ReActivation2499Page checkErrorMessageForPasswordFieldDisplayed() {
		Logger.info("Check error message under 'Password' field is presented");
		boolean isErrorMessageDisplayed =
				passwordFieldErrorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Password' field is not displayed");
		return this;
	}

	public ReActivation2499Page checkErrorMessageForConfirmPasswordFieldDisplayed() {
		Logger.info("Check error message under 'Confirm Password' field is presented");
		boolean isErrorMessageDisplayed =
				confirmPasswordFieldErrorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Confirm Password' field is not displayed");
		return this;
	}

	public ReActivation2499Page checkErrorMessageForFirstNameFieldDisplayed() {
		Logger.info("Check error message under 'First Name' field is presented");
		boolean isErrorMessageDisplayed =
				firstNameFieldErrorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'First Name' field is not displayed");
		return this;
	}

	public ReActivation2499Page checkErrorMessageForLastNameFieldDisplayed() {
		Logger.info("Check error message under 'Last Name' field is presented");
		boolean isErrorMessageDisplayed =
				lastNameFieldErrorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Last Name' field is not displayed");
		return this;
	}

	public ReActivation2499Page checkErrorMessageForCardTypeFieldDisplayed() {
		Logger.info("Check error message under 'Card Type' field is presented");
		boolean isErrorMessageDisplayed =
				cardTypeFieldErrorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Card Type' field is not displayed");
		return this;
	}

	public ReActivation2499Page checkErrorMessageForCardNumberFieldDisplayed() {
		Logger.info("Check error message under 'Card Number' field is presented");
		boolean isErrorMessageDisplayed =
				cardNumberFieldErrorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Card Number' field is not displayed");
		return this;
	}

	public ReActivation2499Page checkErrorMessageForSecurityCodeFieldDisplayed() {
		Logger.info("Check error message under 'Security Code' field is presented");
		boolean isErrorMessageDisplayed =
				cardIdNumberFieldErrorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Security Code' field is not displayed");
		return this;
	}

	public ReActivation2499Page checkErrorMessageForExpirationMonthFieldDisplayed() {
		Logger.info("Check error message under 'Expiration Month' field is presented");
		boolean isErrorMessageDisplayed =
				expirationMonthFieldErrorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Expiration Month' field is not displayed");
		return this;
	}

	public ReActivation2499Page checkErrorMessageForExpirationYearFieldDisplayed() {
		Logger.info("Check error message under 'Expiration Year' field is presented");
		boolean isErrorMessageDisplayed =
				expirationYearFieldErrorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Expiration Year' field is not displayed");
		return this;
	}

	public ReActivation2499Page checkErrorMessageForZipCodeFieldDisplayed() {
		Logger.info("Check error message under 'Zip Code' field is presented");
		boolean isErrorMessageDisplayed =
				zipCodeFieldErrorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Zip Code' field is not displayed");
		return this;
	}

	public ReActivation2499Page enterNewPassword(String password) {
		Logger.info("Enter password");
		passwordField
				.waitUntilVisible()
				.type(password);
		return this;
	}

	public ReActivation2499Page confirmNewPassword(String password) {
		Logger.info("Enter password one more time");
		confirmPasswordField
				.waitUntilVisible()
				.type(password);
		return this;
	}

	public ReActivation2499Page enterFirstName(String firstName) {
		Logger.info("Enter first name");
		firstNameField
				.waitUntilVisible()
				.type(firstName);
		return this;
	}

	public ReActivation2499Page enterLastName(String lastName) {
		Logger.info("Enter last name");
		lastNameField
				.waitUntilVisible()
				.type(lastName);
		return this;
	}

	public ReActivation2499Page selectCreditCard(String card) {
		Logger.info("Select Credit Card");
		WebElement cardType = basedriver.findElement(By.id(cardTypeLocator));
		Select creditCard = new Select(cardType);
		creditCard.selectByValue(card);
		return this;
	}

	public ReActivation2499Page enterCardNumber(String cardNumber) {
		Logger.info("Enter card number");
		cardNumberField.clear();
		cardNumberField
				.waitUntilVisible()
				.type(cardNumber);
		return this;
	}

	public ReActivation2499Page enterSecurityCode(String securityCode) {
		Logger.info("Enter security code");
		securityCodeField
				.waitUntilVisible()
				.type(securityCode);
		return this;
	}

	public ReActivation2499Page selectMonth(String month) {
		Logger.info("Select month");
		WebElement monthDropdown = basedriver.findElement(By.id(expirationMonthLocator));
		Select expirationMonth = new Select(monthDropdown);
		expirationMonth.selectByVisibleText(month);
		return this;
	}

	public ReActivation2499Page selectYear(String year) {
		Logger.info("Select year");
		WebElement yearDropdown = basedriver.findElement(By.id(expirationYearLocator));
		Select expirationYear = new Select(yearDropdown);
		expirationYear.selectByValue(year);
		return this;
	}

	public ReActivation2499Page selectCountry(String country) {
		Logger.info("Select country");
		WebElement countryDropdown = basedriver.findElement(By.id(billingCountryLocator));
		Select billingCountry = new Select(countryDropdown);
		billingCountry.selectByVisibleText(country);
		return this;
	}

	public ReActivation2499Page enterZipCode(String zip) {
		Logger.info("Enter Zip code");
		zipCodeField
				.waitUntilVisible()
				.type(zip);
		return this;
	}

	public ReActivation2499Page termsOfUseCheck() {
		Logger.info("Select 'Terms of use' checkbox");
		termsOfUseCheckbox
				.waitUntilVisible()
				.click();
		assertTrue(termsOfUseCheckbox.isSelected(), "'Terms of use' checkbox is not selected");
		return this;
	}

	public ReActivation2499Page checkCardNumberErrorDisplayed() {
		Logger.info("Check card number error is presented");
		boolean isErrorMessageDisplayed =
				cardNumberError
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message regarding card number is not displayed");
		return this;
	}

	public ReActivation2499Page switchToFrame() {
		Logger.info("Switching to iframe");
		basedriver.switchTo().frame((WebElement) basedriver.findElement(By.id(mainFrameLocator)));
		return this;
	}

	public ReActivation2499Page checkTermOfUsePopupDisplayed() {
		Logger.info("Check Term Of Use popup is present");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1581");
		boolean isTermOfUsePopupDisplayed =
				termOfUsePopup
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isTermOfUsePopupDisplayed, "Term Of Use popup is not displayed");
		return this;
	}

	public ReActivation2499Page clickTermsOfUseLink() {
		Logger.info("Click 'Terms Of Use' link");
		termsOfUseLink
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public ReActivation2499Page switchToTermsOfUse() {
		Logger.info("Switching to iframe");
		waitFor(2000);
		iFrame.waitUntilVisible();
		basedriver.switchTo().frame((WebElement) basedriver.findElement(By.cssSelector(".cboxIframe")));
		return this;
	}

	public ReActivation2499Page enterNewEmail() {
		Logger.info("Enter email address");
		Random random = new Random();
		emailAddressField.clear();
		emailAddressField
				.waitUntilVisible()
				.type(String.format("test%s@mailinator.com", String.valueOf(random.nextInt())));
		return this;
	}

	public ReActivation2499Page confirmEmail(String email) {
		Logger.info("Enter email address one more time");
		confirmEmailField
				.waitUntilVisible()
				.type(email);
		return this;
	}

	public String getNewEmailValue() {
		Logger.info("Get new email address value");
		return emailAddressField.getValue();
	}

	public ReActivation2499Page checkErrorMessageForConfirmEmailFieldDisplayed() {
		Logger.info("Check error message under 'Confirm Email Address' field is presented");
		boolean isErrorMessageDisplayed =
				confirmPasswordFieldErrorMessage
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isErrorMessageDisplayed, "Error message under 'Confirm Email Address' field is not displayed");
		return this;
	}
}
