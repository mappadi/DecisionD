package org.mayoclinicdiet.tests;


import com.testrail.framework.platform.annotations.TestRail;
import framework.Settings;
import framework.platform.SiteNavigatorMCD;
import mayoclinicdiet.pages.HomePage;
import mayoclinicdiet.pages.ReActivation999Page;
import mayoclinicdiet.pages.WelcomePage;
import org.testng.annotations.Test;

public class ReActivation999Test {

	@Test(groups = {"reActivation999", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54319")
	public void reactivationPageLoad() {
		SiteNavigatorMCD.navigateToReActivation999Page()
				.checkReActivationPageUrl()
				.checkHeaderDisplayed();
	}

	@Test(groups = {"reActivation999", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54320")
	public void bannerAd() {
		SiteNavigatorMCD.navigateToReActivation999Page()
				.checkHeaderDisplayed();
	}

	@Test(groups = {"reActivation999", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54321")
	public void fieldValidation() {
		SiteNavigatorMCD.navigateToReActivation999Page()
				.switchToFrame()
				.clickSignUpNowButton(ReActivation999Page.class)
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

	@Test(groups = {"reActivation999", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54322")
	public void fieldValidationCCNumber() {
		SiteNavigatorMCD.navigateToReActivation999Page()
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
				.clickSignUpNowButton(ReActivation999Page.class)
				.checkCardNumberErrorDisplayed();
	}

	@Test(groups = {"reActivation999", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54323")
	public void fieldValidationValidInput() {
		SiteNavigatorMCD.navigateToReActivation999Page()
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

	@Test(groups = {"reActivation999", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54324")
	public void termOfUseLink() {
		SiteNavigatorMCD.navigateToReActivation999Page()
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

	@Test(groups = {"reActivation999", "MayoClinicDiet", "regressionSet", "C54325"})
	@TestRail(id = "C54325")
	public void signUpNowButtonForNewRegisteredUser() {
		ReActivation999Page reActivation999Page = SiteNavigatorMCD.navigateToReActivation999Page()
				.switchToFrame()
				.enterNewEmail();
		String email = reActivation999Page.getNewEmailValue();
		reActivation999Page.confirmEmail(email)
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

	@Test(groups = {"reActivation999", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C54327")
	public void signUpButtonForActiveUser() {
		SiteNavigatorMCD.navigateToReActivation999Page()
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
