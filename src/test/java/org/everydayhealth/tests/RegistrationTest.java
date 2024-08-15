package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.articles.ArticleNewTemplatePage;
import everydayhealth.pages.registrations.MainRegistrationStepOne;
import everydayhealth.pages.registrations.MainRegistrationStepTwo;
import everydayhealth.pages.registrations.ToolsRegistrationPage;
import everydayhealth.pages.tools.DashboardPage;
import framework.Logger;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserCacheEH;
import framework.platform.UserEH;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Registration Page and Offers Pages Test Positive and Negative
 * Registration Tests from the 'Tools' Section
 * 'Calorie Counter'
 * 'Meal Planner'
 */
public class RegistrationTest {

	UserEH newUser = new UserEH();
	UserEH user = UserCacheEH.MAIN_USER;
	private static final String weightCurrent = "175";
	private static final String weightGoal = "155";

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "EverydayHealthSmoke", "Registration", "C187491"})
	@TestRail(id = "C187491")
	public void registrationPositive() {
		String newUserEmail = StringUtils.generateRandomEmail();
		Logger.info("Verifying the registration pages creating new user, positive scenario");
		MainRegistrationStepOne mainRegistrationStepOne = SiteNavigatorEH.goToMainPageEH().onGlobalNavHeader().clickLogin().clickRegisterNow();
		verifyMainRegistrationStepOneItems(mainRegistrationStepOne);
		Logger.info("Completing first registration step");
		MainRegistrationStepTwo mainRegistrationPageStepTwo = mainRegistrationStepOne.fillAndSubmitFirstRegistrationForm(newUser, newUserEmail);
		verifyMainRegistrationStepTwoItems(mainRegistrationPageStepTwo);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "EverydayHealthSmoke", "Registration", "C187492"})
	@TestRail(id = "C187492")
	public void registrationNegative() {
		Logger.info("Verifying the registration pages form validation new user, negative data scenario");
		MainRegistrationStepOne mainRegistrationStepOne = SiteNavigatorEH.goToMainPageEH().onGlobalNavHeader().clickLogin().clickRegisterNow();
		verifyMainRegistrationStepOneItems(mainRegistrationStepOne);
		mainRegistrationStepOne.clickSubmitButtonWithoutData();
		assertTrue(mainRegistrationStepOne.isEmailErrorMessageVisible(), "Email error message should be visible");
		assertTrue(mainRegistrationStepOne.isEmailConfirmErrorMessageVisible(), "Email confirmation error message should be visible");
		assertTrue(mainRegistrationStepOne.isFirstNameErrorMessageVisible(), "First name error message should be visible");
		assertTrue(mainRegistrationStepOne.isLastNameErrorMessageVisible(), "Last name error message should be visible");
		assertTrue(mainRegistrationStepOne.isScreenNameErrorMessageVisible(), "Screen name error message should be visible");
		assertTrue(mainRegistrationStepOne.isPasswordErrorMessageVisible(), "Password error message should be visible");
		assertTrue(mainRegistrationStepOne.isPasswordConfirmErrorMessageVisible(), "Password confirmation error message should be visible");
		assertTrue(mainRegistrationStepOne.isGenderRadioButtonErrorMessageVisible(), "Gender radio button error message should be visible");
		assertTrue(mainRegistrationStepOne.isDobMMErrorMessageVisible(), "Birth MM error message should be visible");
		assertTrue(mainRegistrationStepOne.isDobDDErrorMessageVisible(), "Birth DD error message should be visible");
		assertTrue(mainRegistrationStepOne.isDobYYYYErrorMessageVisible(), "Birth YYYY error message should be visible");
		assertTrue(mainRegistrationStepOne.isZipCodeErrorMessageVisible(), "Zip code error message should be visible");
		assertTrue(mainRegistrationStepOne.isTermsAgreeErrorMessageVisible(), "Terms agreement error message should be visible");
		Logger.info("Verify the error messaging permutations: email and email confirmation fields display correct inline form validation");
		mainRegistrationStepOne.setEmail(user.getEmail());
		mainRegistrationStepOne.setEmailConfirm(user.getEmail());
		mainRegistrationStepOne.setFirstName(newUser.getFirstName());
		mainRegistrationStepOne.waitForEmailSubscribedValidationError();
		assertTrue(mainRegistrationStepOne.isEmailAlreadySubscribedErrorVisible(), "Existing user 'email address is already subscribed' error should be visible");
		mainRegistrationStepOne.setEmail("testusermain@mail");
		assertTrue(mainRegistrationStepOne.isEmailInputValidationErrorVisible(), "Email inline form error message should be visible");
		mainRegistrationStepOne.setEmail(newUser.getEmail());
		assertTrue(mainRegistrationStepOne.isEmailInputValidationSuccessVisible(), "Email inline form success message should be visible");
		mainRegistrationStepOne.setEmailConfirm("testusermain@mail");
		assertTrue(mainRegistrationStepOne.isEmailConfirmInputValidationErrorVisible(), "Email confirmation inline form error message should be visible");
		mainRegistrationStepOne.setEmailConfirm(newUser.getEmail());
		assertTrue(mainRegistrationStepOne.isEmailConfirmInputValidationSuccessVisible(), "Email confirmation inline form success message should be visible");
		mainRegistrationStepOne.setLastName(newUser.getLastName());
		Logger.info("Verify the error messaging permutations: screen name confirmation fields display correct inline form validation");
		mainRegistrationStepOne.setScreenName("JohnSmithAutomation");
		mainRegistrationStepOne.setPassword(newUser.getPassword());
		mainRegistrationStepOne.waitForScreenNameTakenValidationError();
		assertTrue(mainRegistrationStepOne.isScreenNameAlreadyTakenErrorMessageVisible(), "Existing user 'JohnSmithAutomation has already been taken' error should be visible");
		mainRegistrationStepOne.setScreenName(newUser.getScreenName());
		mainRegistrationStepOne.waitForScreenNameAvailable();
		assertFalse(mainRegistrationStepOne.isScreenNameAvailable(), "Existing user error message should not be visible");
		Logger.info("Verify the error messaging permutations: password and password confirmation fields display correct inline form validation");
		mainRegistrationStepOne.setPassword("123");
		mainRegistrationStepOne.waitForPasswordInputValidationError();
		assertTrue(mainRegistrationStepOne.isPasswordInputValidationErrorVisible(), "Password inline form error message should be visible");
		mainRegistrationStepOne.setPassword(newUser.getPassword());
		mainRegistrationStepOne.waitForPasswordInputValidationSuccess();
		assertTrue(mainRegistrationStepOne.isPasswordInputValidationSuccessVisible(), "Password inline form success message should be visible");
		mainRegistrationStepOne.setPasswordConfirm("123");
		mainRegistrationStepOne.waitForPasswordConfirmInputValidationError();
		assertTrue(mainRegistrationStepOne.isPasswordConfirmInputValidationErrorVisible(), "Password confirmation inline form error message should be visible");
		mainRegistrationStepOne.setPasswordConfirm(newUser.getPassword());
		mainRegistrationStepOne.waitForPasswordConfirmInputValidationSuccess();
		assertTrue(mainRegistrationStepOne.isPasswordConfirmInputValidationSuccessVisible(), "Password confirmation inline form success message should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "Registration", "C194916"})
	@TestRail(id = "C194916")
	public void toolsCalorieCounterRegistrationPositive() {
		String newUserEmail = StringUtils.generateRandomEmail();
		Logger.info("Verifying the registration process from the 'calorie counter' tool");
		ToolsRegistrationPage toolsCalorieCounterRegistrationPage = SiteNavigatorEH.goToToolsRegistrationPage("/calorie-counter/");
		verifyRegistrationLandingItems(toolsCalorieCounterRegistrationPage);
		MainRegistrationStepOne mainRegistrationStepOne = toolsCalorieCounterRegistrationPage.completeToolsRegistration(newUser, weightCurrent, weightGoal, newUserEmail);
		verifyMainRegistrationStepOneItems(mainRegistrationStepOne);
		Logger.info("Completing first registration step");
		MainRegistrationStepTwo mainRegistrationPageStepTwo = mainRegistrationStepOne.fillAndSubmitFirstRegistrationForm(newUser, newUserEmail);
		verifyMainRegistrationStepTwoItems(mainRegistrationPageStepTwo);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "Registration", "C194939"})
	@TestRail(id = "C194939")
	public void toolsMealPlannerRegistrationPositive() {
		String newUserEmail = StringUtils.generateRandomEmail();
		Logger.info("Verifying the registration process from the 'meal planner' tool");
		ToolsRegistrationPage toolsMealPlannerRegistrationPage = SiteNavigatorEH.goToToolsRegistrationPage("/meal-planner/");
		verifyRegistrationLandingItems(toolsMealPlannerRegistrationPage);
		MainRegistrationStepOne mainRegistrationStepOne = toolsMealPlannerRegistrationPage.completeToolsRegistration(newUser, weightCurrent, weightGoal, newUserEmail);
		verifyMainRegistrationStepOneItems(mainRegistrationStepOne);
		Logger.info("Completing first registration step");
		MainRegistrationStepTwo mainRegistrationStepTwo = mainRegistrationStepOne.fillAndSubmitFirstRegistrationForm(newUser, newUserEmail);
		verifyMainRegistrationStepTwoItems(mainRegistrationStepTwo);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "Registration", "C214971"})
	@TestRail(id = "C214971")
	public void verifySlashInURL() {
		ArticleNewTemplatePage articlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3, ArticleNewTemplatePage.class);

		assertTrue(Utils.getCurrentURL().replace("?isautomation=true", "").endsWith("/"), "Url should contain '/' as last symbol");
		articlePage.onGlobalNavHeader().clickLogin();
		assertEquals(StringUtils.getLastCharacterOfString(Utils.getCurrentURL()), "/", "Url should contain '/' as last symbol");
		assertTrue(Utils.isConnectionHTTPS(), "Connection should be secured");
	}

	private void verifyMainRegistrationStepOneItems(MainRegistrationStepOne mainRegistrationStepOne) {
		Logger.info("Verifying the visibility of all form fields");
		assertTrue(Utils.isConnectionHTTPS(), "Registration page should be secure 'https:'");
		assertEquals(Utils.getJSResult("return EH.Settings.omniture.event"), "event5", "Omniture event value is incorrect");
		assertTrue(mainRegistrationStepOne.isEmailVisible(), "Email field should be visible");
		assertTrue(mainRegistrationStepOne.isEmailConfirmationVisible(), "Email confirmation field should be visible");
		assertTrue(mainRegistrationStepOne.isFirstNameVisible(), "First name field should be visible");
		assertTrue(mainRegistrationStepOne.isLastNameVisible(), "Last name field should be visible");
		assertTrue(mainRegistrationStepOne.isScreenNameVisible(), "Screen name field should be visible");
		assertTrue(mainRegistrationStepOne.isPasswordVisible(), "Password field should be visible");
		assertTrue(mainRegistrationStepOne.isPasswordConfirmVisible(), "Password confirmation field should be visible");
		assertEquals(mainRegistrationStepOne.getGenderButtons(), 2, "There should be 2 gender buttons visible");
		assertTrue(mainRegistrationStepOne.isDobMonthVisible(), "DOB month field should be visible");
		assertTrue(mainRegistrationStepOne.isDobDayVisible(), "DOB day field should be visible");
		assertTrue(mainRegistrationStepOne.isDobYearVisible(), "DOB year field should be visible");
		assertTrue(mainRegistrationStepOne.isCountryVisible(), "Country select field should be visible");
		assertTrue(mainRegistrationStepOne.isZipCodeVisible(), "Zip code field should be visible");
		if (mainRegistrationStepOne.isPrivacyTermsTextVisible()) {
			assertTrue(mainRegistrationStepOne.getPrivacyTermsText().equals("We collect information to customize your experience and make our sites valuable and relevant to you. When you share information about yourself, we can provide you with content and advertising based on your interests. For more information, see our Privacy Policy. You can modify your profile at any time by visiting your profile page."), "Text does not match");
		}
		assertEquals(mainRegistrationStepOne.getNumberOfInterests(), mainRegistrationStepOne.getNumberOfInterestsButtons(), "There should be an equal number of interests and '+' buttons visible");
		assertTrue(mainRegistrationStepOne.isTermsAgreeVisible(), "Agree 'Terms or Service' should be visible");
	}

	private void verifyMainRegistrationStepTwoItems(MainRegistrationStepTwo mainRegistrationStepTwo) {
		assertTrue(mainRegistrationStepTwo.isNewsletterRecommendationTitleVisible(), "Recommended newsletters title should be visible");
		assertTrue(Utils.isConnectionHTTPS(), "Registration page should be secure 'https:'");
		mainRegistrationStepTwo.selectMainSuggestedNewsletter(); //main recommended newsletters with images
		mainRegistrationStepTwo.selectMoreSuggestedNewsletter(); //more suggested newsletters list
		assertEquals(mainRegistrationStepTwo.getNumberOfSuggestedNewsletterChecks(), 2, "Both newsletters checks should be visible");
		DashboardPage dashboardPage = mainRegistrationStepTwo.clickGoToDashboardButton();
		assertTrue(dashboardPage.onGlobalNavHeader().isLoggedIn(), "New user should be logged in");
	}

	private void verifyRegistrationLandingItems(ToolsRegistrationPage toolsRegistrationPage) {
		Logger.info("Verifying the landing page items");
		assertTrue(toolsRegistrationPage.isIntroContentVisible(), "Intro content should be visible");
		assertEquals(toolsRegistrationPage.getNumberOfTips(), 3, "There should be three tips visible");
		assertTrue(toolsRegistrationPage.areFeaturesVisible(), "Features section should be visible");
		if (!Settings.isMobile()) {
			assertTrue(toolsRegistrationPage.isFeatureImageVisible(), "Features image should be visible");
		}
	}
}

