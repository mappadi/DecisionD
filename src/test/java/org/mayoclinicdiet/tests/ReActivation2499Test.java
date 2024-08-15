package org.mayoclinicdiet.tests;


import com.testrail.framework.platform.annotations.TestRail;
import framework.Settings;
import framework.platform.SiteNavigatorMCD;
import mayoclinicdiet.pages.HomePage;
import mayoclinicdiet.pages.ReActivation2499Page;
import mayoclinicdiet.pages.WelcomePage;
import org.testng.annotations.Test;

public class ReActivation2499Test {

	@Test(groups = {"reActivation2499", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54329")
	public void reactivationPageLoad() {
		SiteNavigatorMCD.navigateToReActivation2499Page()
				.checkReActivationPageUrl()
				.checkHeaderDisplayed();
	}

	@Test(groups = {"reActivation2499", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54330")
	public void bannerAd() {
		SiteNavigatorMCD.navigateToReActivation2499Page()
				.checkHeaderDisplayed();
	}

	@Test(groups = {"reActivation2499", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54331")
	public void fieldValidation() {
		SiteNavigatorMCD.navigateToReActivation2499Page()
				.switchToFrame()
				.clickSignUpNowButton(ReActivation2499Page.class)
				.checkErrorMessageForConfirmEmailFieldDisplayed()
				.checkErrorMessageForPasswordFieldDisplayed()
				.checkErrorMessageForConfirmPasswordFieldDisplayed()
				.checkErrorMessageForFirstNameFieldDisplayed()
				.checkErrorMessageForLastNameFieldDisplayed()
				.checkErrorMessageForCardTypeFieldDisplayed()
				.checkErrorMessageForCardNumberFieldDisplayed()
				.checkErrorMessageForSecurityCodeFieldDisplayed()
				.checkErrorMessageForExpirationMonthFieldDisplayed()
				.checkErrorMessageForExpirationYearFieldDisplayed()
				.checkErrorMessageForZipCodeFieldDisplayed();
	}

	@Test(groups = {"reActivation2499", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54332")
	public void fieldValidationCCNumber() {
		SiteNavigatorMCD.navigateToReActivation2499Page()
				.switchToFrame()
				.confirmEmail(Settings.config.getAdminEmail())
				.enterNewPassword(Settings.config.getAdminPassword())
				.confirmNewPassword(Settings.config.getAdminPassword())
				.enterFirstName("Test")
				.enterLastName("Name")
				.selectCreditCard("visa")
				.enterCardNumber("378282246310005")
				.enterSecurityCode("123")
				.selectMonth("05 - May")
				.selectYear("2017")
				.selectCountry("Canada")
				.enterZipCode("12345")
				.termsOfUseCheck()
				.clickSignUpNowButton(ReActivation2499Page.class)
				.checkCardNumberErrorDisplayed();
	}

	@Test(groups = {"reActivation2499", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54333")
	public void fieldValidationValidInput() {
		SiteNavigatorMCD.navigateToReActivation2499Page()
				.switchToFrame()
				.confirmEmail(Settings.config.getAdminEmail())
				.enterNewPassword(Settings.config.getAdminPassword())
				.confirmNewPassword(Settings.config.getAdminPassword())
				.enterFirstName("Test")
				.enterLastName("Name")
				.selectCreditCard("visa")
				.enterCardNumber("4111111111111111")
				.enterSecurityCode("123")
				.selectMonth("05 - May")
				.selectYear("2017")
				.selectCountry("Canada")
				.enterZipCode("12345")
				.termsOfUseCheck()
				.clickSignUpNowButton(HomePage.class)
				.checkWelcomeTextDisplayed();
	}

	@Test(groups = {"reActivation2499", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54334")
	public void termOfUseLink() {
		SiteNavigatorMCD.navigateToReActivation2499Page()
				.switchToFrame()
				.confirmEmail(Settings.config.getAdminEmail())
				.enterNewPassword(Settings.config.getAdminPassword())
				.confirmNewPassword(Settings.config.getAdminPassword())
				.enterFirstName("Test")
				.enterLastName("Name")
				.selectCreditCard("visa")
				.enterCardNumber("4111111111111111")
				.enterSecurityCode("123")
				.selectMonth("05 - May")
				.selectYear("2017")
				.selectCountry("Canada")
				.enterZipCode("12345")
				.termsOfUseCheck()
				.clickTermsOfUseLink()
				.switchToTermsOfUse()
				.checkTermOfUsePopupDisplayed();
	}

	@Test(groups = {"reActivation2499", "MayoClinicDiet", "regressionSet", "C54335"})
	@TestRail(id = "C54335")
	public void signUpNowButtonForNewRegisteredUser() {
		ReActivation2499Page reActivation2499Page = SiteNavigatorMCD.navigateToReActivation2499Page()
				.switchToFrame()
				.enterNewEmail();
		String email = reActivation2499Page.getNewEmailValue();
		reActivation2499Page.confirmEmail(email)
				.enterNewPassword(Settings.config.getAdminPassword())
				.confirmNewPassword(Settings.config.getAdminPassword())
				.enterFirstName("Test")
				.enterLastName("Name")
				.selectCreditCard("visa")
				.enterCardNumber("4111111111111111")
				.enterSecurityCode("123")
				.selectMonth("05 - May")
				.selectYear("2017")
				.selectCountry("Canada")
				.enterZipCode("12345")
				.termsOfUseCheck()
				.clickSignUpNowButton(WelcomePage.class)
				.checkWelcomeHeaderPresent();
	}

	@Test(groups = {"reActivation2499", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54337")
	public void signUpButtonForActiveUser() {
		SiteNavigatorMCD.navigateToReActivation2499Page()
				.switchToFrame()
				.confirmEmail(Settings.config.getAdminEmail())
				.enterNewPassword(Settings.config.getAdminPassword())
				.confirmNewPassword(Settings.config.getAdminPassword())
				.enterFirstName("Test")
				.enterLastName("Name")
				.selectCreditCard("visa")
				.enterCardNumber("4111111111111111")
				.enterSecurityCode("123")
				.selectMonth("05 - May")
				.selectYear("2017")
				.selectCountry("Canada")
				.enterZipCode("12345")
				.termsOfUseCheck()
				.clickSignUpNowButton(HomePage.class)
				.checkWelcomeTextDisplayed();
	}

}
