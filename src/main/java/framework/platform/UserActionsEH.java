package framework.platform;

import everydayhealth.pages.EHPublicPage;
import everydayhealth.pages.SettingsPage;
import everydayhealth.pages.personalizedTracker.DiabetesPTRegistrationPage;
import everydayhealth.pages.personalizedTracker.DiabetesPersonalizedTrackerPage;
import everydayhealth.pages.personalizedTracker.PTRegistrationPage;
import everydayhealth.pages.personalizedTracker.PersonalizedTrackerPage;
import everydayhealth.pages.registrations.MainRegistrationStepOne;
import everydayhealth.pages.registrations.MainRegistrationStepTwo;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

/**
 * UserActionsEH
 */
public class UserActionsEH {

	private static String PT_REG_PHONE_NUMBER = "9292777091";

	public static void verifyTrackingAccountIDsInPageSource() {
		Logger.info("Verifying all core marketing pixels on page: " + WebDriverManager.getDriver().getCurrentUrl());
		assertTrue(Utils.isPageSourceContains("UA-30535-1"), "Google Analytics account value should be present");
		assertTrue(Utils.isPageSourceContains("optimizely"), "Optimizely not present on page");
		assertTrue(Utils.isPageSourceContains(".scorecardresearch.com/beacon.js", "EHA-1467"), "Comscore not present on page");
	}

	public static boolean verifyComScoreSettingsC1() {
		Logger.info("Verifying comScore settings for var 'c1' = 2");
		if (WebDriverManager.getDriver().getCurrentUrl().contains("/columns/")) {
			return Utils.getJSResult("return EH.Global.comscore.c1").equalsIgnoreCase("2");
		} else if (Utils.isPageSourceContains("EH.Settings.comscore")) {
			return Utils.getJSResult("return EH.Settings.comscore.c1").equalsIgnoreCase("2");
		} else {
			return Utils.getJSResult("return comscoreSettings.c1").equalsIgnoreCase("2");
		}
	}

	public static boolean verifyComScoreSettingsC2() {
		Logger.info("Verifying comScore settings for var 'c2' = 6035818");
		if (WebDriverManager.getDriver().getCurrentUrl().contains("/columns/")) {
			return Utils.getJSResult("return EH.Global.comscore.c2").equalsIgnoreCase("6035818");
		} else if (Utils.isPageSourceContains("EH.Settings.comscore")) {
			return Utils.getJSResult("return EH.Settings.comscore.c2").equalsIgnoreCase("6035818");
		} else {
			return Utils.getJSResult("return comscoreSettings.c2").equalsIgnoreCase("6035818");
		}
	}

	public static boolean verifyComScoreSettingsC4() {
		Logger.info("Verifying comScore settings for var 'c4' contains everydayhealth.com/");
		if (WebDriverManager.getDriver().getCurrentUrl().contains("/columns/")) {
			return Utils.getJSResult("return EH.Global.comscore.c4").contains("everydayhealth.com/");
		} else if (Utils.isPageSourceContains("EH.Settings.comscore")) {
			return Utils.getJSResult("return EH.Settings.comscore.c4").contains("everydayhealth.com/");
		} else {
			return Utils.getJSResult("return comscoreSettings.c4").contains("window.location.host");
		}
	}

	public static EHPublicPage loginWithUser(UserEH user, boolean isGlobalNavHeader) {
		if (isGlobalNavHeader) {
			return SiteNavigatorEH.goToMainPageEH().onGlobalNavHeader().clickLogin().enterCredentialsAndSubmitForm(user, EHPublicPage.class);
		} else {
			return SiteNavigatorEH.goToMainPageEH().onHeaderCCR().loginWithUserAndOpenPage(user, EHPublicPage.class);
		}
	}

	public static void logout(boolean isGlobalNav) {
		if (isGlobalNav) {
			SiteNavigatorEH.goToMainPageEH().onGlobalNavHeader().userLogOut();
		} else {
			SiteNavigatorEH.goToMainPageEH().onHeaderCCR().userLogOut();
		}
	}

	public static MainRegistrationStepTwo registerUserWithDefaultData(String email, String password) {
		MainRegistrationStepOne registrationPage = SiteNavigatorEH.goToMainPageEH().onGlobalNavHeader().clickLogin().clickRegisterNow();
		registrationPage.setEmail(email);
		registrationPage.setEmailConfirm(email);
		registrationPage.setFirstName("John" + StringUtils.generateRandomStrAlphabetic(5));
		registrationPage.setLastName("Smith" + StringUtils.generateRandomStrAlphabetic(5));
		registrationPage.setScreenName("JohnSmith" + StringUtils.generateRandomStrAlphabetic(8));
		registrationPage.setPassword(password);
		registrationPage.setPasswordConfirm(password);
		registrationPage.setGender();
		registrationPage.setDOBMonth("5");
		registrationPage.setDOBDay("5");
		registrationPage.setDOBYear("1985");
		registrationPage.setZipCode("10014");
		registrationPage.clickTermsAgree();
		registrationPage.clickSubmitButton();
		return PageFactory.initElements(WebDriverManager.getDriver(), MainRegistrationStepTwo.class);
	}

	public static void releaseEmailAddress() {
		/*
		 * To make email address available for registration as a new user - changes should be done in existing profile
		 */
		UserActionsEH.loginWithUser(UserCacheEH.PT_REGISTRATION_USER, true);
		String randomEmail = StringUtils.generateRandomEmail();
		SettingsPage settingsPage = SiteNavigatorEH.goToSettingsPage();
		settingsPage.clickEditEmailButton()
				.typePassword(Settings.config.getPtUserPassword())
				.typeNewEmail(randomEmail)
				.typeConfirmNewEmail(randomEmail)
				.clickUpdateEmailButton();
		UserActionsEH.logout(true);
	}

	public static PersonalizedTrackerPage registerNewPTUser(boolean isCrohnsPT, UserEH user) {
		PTRegistrationPage ptRegistrationPage = isCrohnsPT ?
				SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PTRegistrationPage.class) :
				SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PTRegistrationPage.class);
		ptRegistrationPage.typeEmail(user.getEmail()).clickNextButton();
		ptRegistrationPage.typePassword(user.getPassword());
		ptRegistrationPage.typePhoneNumber(PT_REG_PHONE_NUMBER);
		if (!ptRegistrationPage.isMessageForEHMemberVisible()) {
			ptRegistrationPage.clickTermsAndConditionsCheckbox();
		}
		ptRegistrationPage.clickConsentCheckbox();
		return ptRegistrationPage.clickSignUpButton(PersonalizedTrackerPage.class);
	}

	public static PersonalizedTrackerPage registerExistingEHUserAsNewPTUser(boolean isCrohnsPT, UserEH user) {
		loginWithUser(user, true);
		PTRegistrationPage ptRegistrationPage = isCrohnsPT ?
				SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PTRegistrationPage.class) :
				SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PTRegistrationPage.class);
		ptRegistrationPage.typePhoneNumber(PT_REG_PHONE_NUMBER);
		ptRegistrationPage.clickConsentCheckbox();
		return ptRegistrationPage.clickSignUpButton(PersonalizedTrackerPage.class);
	}

	public static DiabetesPersonalizedTrackerPage registerExistingEHUserAsNewPTUser(UserEH user) {
		loginWithUser(user, true);
		DiabetesPTRegistrationPage ptRegistrationPage = SiteNavigatorEH.goToPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, DiabetesPTRegistrationPage.class);
		ptRegistrationPage.chooseAgeRange("18-34");
		ptRegistrationPage.clickMedicareAnswerNoCheckbox();
		ptRegistrationPage.chooseMedicationOptionNumber(2);
		ptRegistrationPage.clickConsentCheckbox();
		return ptRegistrationPage.clickSignUpButton(DiabetesPersonalizedTrackerPage.class);
	}
}
