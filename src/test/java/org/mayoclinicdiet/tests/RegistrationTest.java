package org.mayoclinicdiet.tests;


import com.testrail.framework.platform.annotations.TestRail;
import framework.Logger;
import framework.platform.SiteNavigatorMCD;
import framework.platform.utilities.StringUtils;
import mayoclinicdiet.pages.HomePage;
import mayoclinicdiet.pages.OrderPage;
import mayoclinicdiet.pages.ProfileSettingsPage;
import mayoclinicdiet.pages.TwoStepRegistrationPage;
import mayoclinicdiet.pages.WelcomePage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class RegistrationTest {

	private String FIRST_NAME = "John" + StringUtils.generateRandomStrAlphabetic(5);
	private String LAST_NAME = "Smith" + StringUtils.generateRandomStrAlphabetic(5);
	private String EMAIL_ADDRESS = StringUtils.generateRandomEmail();
	private String INCORRECT_DATA = "J0hnn13!!";
	private String INCORRECT_DATA_2 = "B@k3r";
	private String ZIP_CODE = "10014";
	private String VISA_CARD_1 = "4532519909164608";
	private String EXP_MONTH = "07";
	private String EXP_YEAR = "2022";

	@Test(groups = {"registration", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43055")
	public void confirmPasswordValidation() {
		SiteNavigatorMCD.openSharedRegistration()
				.enterFirstName("Test")
				.enterLastName("Name")
				.enterNewEmail()
				.confirmEmailAddress()
				.enterNewPassword("Password1")
				.confirmNewPassword("Password")
				.navigateToNextField()
				.checkErrorMessageDisplayed();
	}

	@Test(groups = {"registration", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43055")
	public void expirationDateValidation() {
		SiteNavigatorMCD.openSharedRegistration()
				.enterFirstName("Test")
				.enterLastName("Name")
				.enterNewEmail()
				.confirmEmailAddress()
				.enterNewPassword("Password1")
				.confirmNewPassword("Password1")
				.selectCreditCard("visa")
				.enterCardNumber("4111111111111111")
				.enterSecurityCode("123")
				.selectMonth("01 - Jan")
				.selectYear("2015")
				.selectCountry("Canada")
				.enterZipCode("12345")
				.termsOfUseCheck()
				.submitErrorRegistration()
				.checkExpirationDateMessageDisplayed();
	}

	@Test(groups = {"registration", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43055")
	public void emptyFieldsValidation() {
		SiteNavigatorMCD.openSharedRegistration()
				.submitErrorRegistration()
				.checkErrorMessageForFirstNameFieldDisplayed()
				.checkErrorMessageForLastNameFieldDisplayed()
				.checkErrorMessageForEmailAddressFieldDisplayed()
				.checkErrorMessageForPasswordFieldDisplayed()
				.checkErrorMessageForConfirmPasswordFieldDisplayed()
				.checkErrorMessageForCardNumberFieldDisplayed()
				.checkErrorMessageForSecurityCodeFieldDisplayed()
				.checkErrorMessageForMonthDropdownDisplayed()
				.checkErrorMessageForYearDropdownDisplayed()
				.checkErrorMessageForZipCodeFieldDisplayed()
				.checkErrorMessageUnderTermsOfUseCheckbox();
	}

	@Test(groups = {"registration", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43055")
	public void fieldsValidationNegativeScenario() {
		SiteNavigatorMCD.openSharedRegistration()
				.enterFirstName("Test")
				.enterLastName("Name")
				.enterIncorrectNewEmail("incorrectemail.com")
				.navigateToNextField()
				.checkErrorMessageDisplayed()
				.enterNewEmail()
				.confirmEmailAddress()
				.enterNewPassword("Password1")
				.confirmNewPassword("Password1")
				.selectCreditCard("visa")
				.enterCardNumber("41111111111111fd")
				.navigateToNextField()
				.checkErrorMessageDisplayed()
				.enterCardNumber("4111111111111111")
				.enterSecurityCode("1j3")
				.navigateToNextField()
				.checkErrorMessageDisplayed()
				.enterSecurityCode("123")
				.selectMonth("05 - May")
				.selectYear("2017")
				.selectCountry("Canada")
			   /* .enterZipCode("@#$%^")
				.navigateToNextField()
                .checkErrorMessageDisplayed()*/
				.enterZipCode("12345")
				.termsOfUseCheck()
				.submitRegistration()
				.checkWelcomeTitlePresent();
	}

	@Test(groups = {"registration", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43056")
	public void termsOfUseCheckbox() {
		SiteNavigatorMCD.openSharedRegistration()
				.checkSharedRegistrationUrl()
				.checkTermsOfUseCheckboxDisplayed()
				.termsOfUseCheck();
	}

	@Test(groups = {"registration", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43055")
	public void fieldsValidationPositiveScenario() {
		SiteNavigatorMCD.openSharedRegistration()
				.enterFirstName("Test")
				.enterLastName("Name")
				.enterNewEmail()
				.confirmEmailAddress()
				.enterNewPassword("Password1")
				.confirmNewPassword("Password1")
				.selectCreditCard("visa")
				.enterCardNumber("4111111111111111")
				.enterSecurityCode("123")
				.selectMonth("05 - May")
				.selectYear("2017")
				.selectCountry("Canada")
				.enterZipCode("12345")
				.termsOfUseCheck()
				.submitRegistration()
				.checkWelcomeTitlePresent()
				.clickGetStartedButton()
				.clickGetStartedButtonOnQuiz()
				.completeQuiz()
				.clickSeeYourResultsButton()
				.clickGetStartedHereButton();
	}

	@Test(groups = {"registration", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43054")
	public void sharedRegistration() {
		SiteNavigatorMCD.openSharedRegistration()
				.checkSharedRegistrationUrl()
				.checkSubheaderDisplayed()
				.checkInputFieldsEmpty();
	}

	@Test(groups = {"registration", "MayoClinicDiet", "regressionSet", "C52992"})
	@TestRail(id = "C52992")
	public void emailConfirmation() {
		SiteNavigatorMCD.openSharedRegistration()
				.enterFirstName("Test")
				.enterLastName("Name")
				.enterNewEmail()
				.confirmEmailAddress()
				.enterNewPassword("Password1")
				.confirmNewPassword("Password1")
				.selectCreditCard("visa")
				.enterCardNumber("4111111111111111")
				.enterSecurityCode("123")
				.selectMonth("05 - May")
				.selectYear("2017")
				.selectCountry("Canada")
				.enterZipCode("12345")
				.termsOfUseCheck()
				.submitRegistration()
				.clickGetStartedButton()
				.checkLoseItPopUpDisplayed()
				.clickGetStartedButtonOnQuiz()
				.completeQuiz()
				.clickSeeYourResultsButton()
				.clickGetStartedHereButton()
				.clickOnSettingLink()
				.expandAccountInformation()
				.rememberValues();

		SiteNavigatorMCD.navigateToMailinator()
				.enterEmail()
				.clickCheckItButton()
				.checkEmailDisplayed()
				.checkConfirmationEmail();
	}

	@Test(groups = {"registration", "MayoClinicDiet", "regressionSet"}, enabled = false)
	//TODO enable after ticket #45597 will be closed
	@TestRail(id = "C52995")
	public void samEntry() {
		SiteNavigatorMCD.openSharedRegistration()
				.enterFirstName("Test")
				.enterLastName("Name")
				.enterNewEmail()
				.confirmEmailAddress()
				.enterNewPassword("Password1")
				.confirmNewPassword("Password1")
				.selectCreditCard("visa")
				.enterCardNumber("4111111111111111")
				.enterSecurityCode("123")
				.selectMonth("05 - May")
				.selectYear("2017")
				.selectCountry("Canada")
				.enterZipCode("12345")
				.rememberBillingPlan()
				.termsOfUseCheck()
				.submitRegistration()
				.clickGetStartedButton()
				.clickGetStartedButtonOnQuiz()
				.completeQuiz()
				.clickSeeYourResultsButton()
				.clickGetStartedHereButton()
				.clickOnSettingLink()
				.expandAccountInformation()
				.rememberValues();

		SiteNavigatorMCD.navigateToSam()
				.typeValueForNewUser()
				.chooseMayoOption()
				.clickFindButton()
				.checkUserAccountDetailsDisplayed();
	}

	@Test(groups = {"TwoStepRegistration", "MayoClinicDiet", "C308388"})
	@TestRail(id = "C308388")
	public void twoStepRegistrationTestWithoutAdditionalOrders() {
		TwoStepRegistrationPage registrationPage = SiteNavigatorMCD.navigateToRegistrationPage();
		WelcomePage welcomePage = verifyTwoStepsRegistrationAndNavigateToWelcomePage(registrationPage);
		HomePage homePage = welcomePage.clickNoThanksButton().clickGetStartedButton().clickCloseButtonOnPopUp();
		assertTrue(homePage.isTrackerContentVisible(), "Tracker content should be visible on homepage");
	}

	@Test(groups = {"TwoStepRegistration", "MayoClinicDiet", "C308476"})
	@TestRail(id = "C308476")
	public void twoStepRegistrationTestWithAdditionalOrders() {
		TwoStepRegistrationPage registrationPage = SiteNavigatorMCD.navigateToRegistrationPage();
		WelcomePage welcomePage = verifyTwoStepsRegistrationAndNavigateToWelcomePage(registrationPage);
		welcomePage.clickDietCookBookAddToCartButton();
		assertTrue(welcomePage.isDietCookBookAddedToCart(), "Diet cook book should be added to cart");
		String orderPrice = welcomePage.getCookBookPrice();
		OrderPage orderPage = welcomePage.clickCheckoutButton();
		assertTrue(orderPage.isCardInformationVisible(), "Card information should be visible");
		assertTrue(orderPage.isShippingInformationVisible(), "Shipping information should be visible");
		assertTrue(orderPage.isProductDetailsBlockVisible(), "Product details block should be visible");
		assertTrue(orderPage.isOrderSummaryVisible(), "Order summary block should be visible");
		assertTrue(orderPage.getProductName().contains("Mayo Clinic Cookbook"));
		assertEquals(orderPage.getPrice(), orderPrice, "Total value should be equal to the value on welcome page");
		assertTrue(orderPage.getCardDetailLineNumber(1).endsWith("4608"));
		String expInformation = orderPage.getCardDetailLineNumber(1).split(" ")[1];
		assertTrue(expInformation.split("//")[0].equals(EXP_MONTH), "Expiration month should be correct");
		assertTrue(expInformation.split("//")[1].equals(EXP_YEAR), "Expiration month should be correct");
		String[] cardHolderData = orderPage.getCardDetailLineNumber(2).split(" ");
		assertEquals(cardHolderData[0], FIRST_NAME, "First name of card holder should be visible");
		assertEquals(cardHolderData[1], LAST_NAME, "Last name of card holder should be visible");
		assertEquals(orderPage.getCardDetailLineNumber(4), ZIP_CODE, "Zip code value should be correct");
	}

	@Test(groups = {"TwoStepRegistration", "MayoClinicDiet", "C308477"})
	@TestRail(id = "C308477")
	public void verifyInformationIsSavedInProfileMenu() {
		TwoStepRegistrationPage registrationPage = SiteNavigatorMCD.navigateToRegistrationPage();
		WelcomePage welcomePage = verifyTwoStepsRegistrationAndNavigateToWelcomePage(registrationPage);
		ProfileSettingsPage profileSettingsPage = welcomePage.clickNoThanksButton()
				.clickGetStartedButton()
				.clickCloseButtonOnPopUp()
				.clickOnSettingLink()
				.expandAccountInformation();
		Logger.info("Verifying payment information");
		assertEquals(profileSettingsPage.getEmail(), EMAIL_ADDRESS, "Email address should be present in 'Profile' menu");
		assertEquals(profileSettingsPage.getFirstName(), FIRST_NAME, "First name should be present in 'Profile' menu");
		assertEquals(profileSettingsPage.getLastName(), LAST_NAME, "Last name should be present in 'Profile' menu");
	}

	private WelcomePage verifyTwoStepsRegistrationAndNavigateToWelcomePage(TwoStepRegistrationPage registrationPage) {
		Logger.info("Verify 1st step");
		assertTrue(registrationPage.isProgressBarVisible(), "Progress bar should be visible");
		assertTrue(registrationPage.isFirstStepBarHighlighted(), "First step arrow should be highlighted");
		assertTrue(registrationPage.isFirstStepDescriptionVisible(), "First step description should be visible");
		assertFalse(registrationPage.isSecondStepBarHighlighted(), "Second step arrow should not be highlighted");
		registrationPage.switchToFirstStepIFrame();
		assertTrue(registrationPage.isFirstNameFieldVisible(), "'First name' input should be visible");
		assertTrue(registrationPage.isLastNameFieldVisible(), "'Last name' input should be visible");
		assertTrue(registrationPage.isEmailFieldVisible(), "'Email Address' input should be visible");
		assertTrue(registrationPage.isConfirmEmailFieldVisible(), "'Confirm Email Address' input should be visible");
		assertTrue(registrationPage.isPasswordFieldVisible(), "'Create Password' input should be visible");
		assertTrue(registrationPage.isConfirmPasswordFieldVisible(), "'Confirm Password' input should be visible");
		assertTrue(registrationPage.isTermsOfUseCheckboxVisible(), "Terms of service checkbox should be visible");
		assertFalse(registrationPage.getTermsOfUseLinkHrefAttributeValue().isEmpty(), "'Terms of use' should be hyperlink");
		assertTrue(registrationPage.isProgramDescriptionVisible(), "Program description block should be present");
		assertTrue(registrationPage.isFirstStepContinueButtonVisible(), "'Continue' button should be visible");

		registrationPage.typeFirstName(INCORRECT_DATA).clickFirstStepContinueButton();
		assertTrue(registrationPage.isFirstNameErrorMessageVisible(), "Error message for incorrect first name should be visible");
		registrationPage.typeFirstName(FIRST_NAME).typeLastName(INCORRECT_DATA_2).clickFirstStepContinueButton();
		assertFalse(registrationPage.isFirstNameErrorMessageVisible(), "Error message for incorrect first name should not be visible");
		assertTrue(registrationPage.isLastNameErrorMessageVisible(), "Error message for incorrect last name should be visible");
		registrationPage.typeLastName(LAST_NAME).typeEmailAddress(INCORRECT_DATA_2).clickFirstStepContinueButton();
		assertFalse(registrationPage.isFirstNameErrorMessageVisible(), "Error message for incorrect first name should not be visible");
		assertFalse(registrationPage.isLastNameErrorMessageVisible(), "Error message for incorrect last name should not be visible");
		assertTrue(registrationPage.isEmailErrorMessageVisible(), "Error message for incorrect email address should be visible");
		System.out.println(EMAIL_ADDRESS);
		registrationPage.typeEmailAddress(EMAIL_ADDRESS).typeConfirmationEmailAddress(INCORRECT_DATA_2).clickFirstStepContinueButton();
		assertFalse(registrationPage.isEmailErrorMessageVisible(), "Error message for incorrect email address should not be visible");
		assertTrue(registrationPage.isConfirmationEmailErrorMessageVisible(), "Error message for email confirmation should be visible");
		registrationPage.typeConfirmationEmailAddress(EMAIL_ADDRESS).typePassword("P");
		assertFalse(registrationPage.isConfirmationEmailErrorMessageVisible(), "Error message for email confirmation should not be visible");
		assertTrue(registrationPage.isPasswordRequirementsBoxVisible(), "Password requirements box should be visible");
		assertTrue(registrationPage.isCapitalLetterPresentInPassword(), "Capital letter should be accepted");
		assertFalse(registrationPage.isLowecaseLetterPresentInPassword(), "Lowercase letter should not be accepted");
		assertFalse(registrationPage.isNumberPresentInPassword(), "Number should not be accepted");
		assertFalse(registrationPage.isPasswordLengthCorrect(), "Password length should not be accepted");
		registrationPage.typePassword("Pass");
		assertTrue(registrationPage.isLowecaseLetterPresentInPassword(), "Lowercase letter should be accepted");
		assertFalse(registrationPage.isNumberPresentInPassword(), "Number should not be accepted");
		assertFalse(registrationPage.isPasswordLengthCorrect(), "Password length should not be accepted");
		registrationPage.typePassword("Pass1");
		assertTrue(registrationPage.isNumberPresentInPassword(), "Number should be accepted");
		assertFalse(registrationPage.isPasswordLengthCorrect(), "Password length should not be accepted");
		registrationPage.typePassword("Pass@123");
		assertTrue(registrationPage.isPasswordLengthCorrect(), "Password length should be accepted");
		registrationPage.typeConfirmationPassword(INCORRECT_DATA).clickFirstStepContinueButton();
		assertTrue(registrationPage.isConfirmationPasswordErrorMessageVisible(), "Error message should be visible for password confirmation");
		registrationPage.typeConfirmationPassword("Pass@123").clickFirstStepContinueButton();
		assertFalse(registrationPage.isConfirmationPasswordErrorMessageVisible(), "Error message should not be visible for password confirmation");
		assertTrue(registrationPage.isTermsOfServiceErrorMessageVisible(), "Error message for 'Terms of Service' checkbox should be visible");
		registrationPage.clickTosCheckbox();
		registrationPage.clickFirstStepContinueButton();
		assertFalse(registrationPage.isTermsOfServiceErrorMessageVisible(), "Error message for 'Terms of Service' checkbox should not be visible");

		Logger.info("Verify 2nd step");
		registrationPage.switchToMainWindow();
		assertTrue(registrationPage.isProgressBarVisible(), "Progress bar should be visible");
		assertFalse(registrationPage.isFirstStepBarHighlighted(), "First step arrow should not be highlighted");
		assertFalse(registrationPage.isFirstStepDescriptionVisible(), "First step description should not be visible");
		assertTrue(registrationPage.isSecondStepBarHighlighted(), "Second step arrow should be highlighted");
		assertTrue(registrationPage.isSecondStepDescriptionVisible(), "Second step description should be visible");
		registrationPage.switchToFirstStepIFrame();
		registrationPage.switchToSecondStepIFrame();
		assertTrue(registrationPage.isFirstNameLabelVisible(), "First Name' label should be visible");
		assertEquals(registrationPage.getFirstNameInputText(), FIRST_NAME, "Text in 'First Name' input should be equal to the name from 1st step");
		assertTrue(registrationPage.isLastNameLabelVisible(), "'Last Name' label should be visible");
		assertEquals(registrationPage.getLastNameInputText(), LAST_NAME, "Text in 'Last Name' input should be equal to the last name from 1st step");
		assertTrue(registrationPage.isZipCodeLabelVisible(), "'Zip Code/Post Code'label should be visible");
		assertTrue(registrationPage.isContinueButtonVisible(), "'Continue' button should be visible");
		registrationPage.clickPaymentContinueButton();
		assertTrue(registrationPage.isErrorBlockVisible(), "Error block should be visible");
		registrationPage.typeZipCode(ZIP_CODE).clickPaymentContinueButton();
		assertTrue(registrationPage.isErrorBlockVisible(), "Error block should be visible");
		assertTrue(registrationPage.isCountryLabelVisible(), "'Country' label should be visible");
		assertTrue(registrationPage.isCardTypeLabelVisible(), "'Card Type' label should be visible");
		assertTrue(registrationPage.isVisaImageVisible(), "'Visa' card image should be visible");
		assertTrue(registrationPage.isMastercardImageVisible(), "'Mastercard' card image should be visible");
		assertTrue(registrationPage.isAmericanExpressImageVisible(), "'American Express' card image should be visible");
		assertTrue(registrationPage.isMaestroImageVisible(), "'Maestro' card image should be visible");
		assertTrue(registrationPage.isCardNumberLabelVisible(), "'Card Number' label should be visible");
		registrationPage.typeCardNumber(VISA_CARD_1).clickPaymentContinueButton();
		assertTrue(registrationPage.isErrorBlockVisible(), "Error block should be visible");
		assertTrue(registrationPage.isCVVLabelVisible(), "'CVV' label should be visible");
		assertTrue(registrationPage.isNortonSecuredImageVisible(), "'Norton Secured' image should be visible");
		registrationPage.clickVisaRadiobutton().typeCVVNumber("112").clickPaymentContinueButton();
		assertTrue(registrationPage.isErrorBlockVisible(), "Error block should be visible");
		assertTrue(registrationPage.isExpiryDateLabelVisible(), "'Expiry Date' should be visible");
		registrationPage.chooseExpiryDateMonth(EXP_MONTH).clickPaymentContinueButton();
		assertTrue(registrationPage.isErrorBlockVisible(), "Error block should be visible");
		WelcomePage welcomePage = registrationPage.chooseExpiryDateYear(EXP_YEAR).clickContinue();
		assertFalse(registrationPage.isErrorBlockVisible(), "Error block should not be visible");
		assertTrue(welcomePage.isCoachingOfferVisible(), "Coaching offer should be visible");
		assertTrue(welcomePage.isDietBookOfferVisible(), "Diet book offer should be visible");
		assertTrue(welcomePage.isDietCookBookOfferVisible(), "Diet cook book offer should be visible");

		return welcomePage;
	}
}


