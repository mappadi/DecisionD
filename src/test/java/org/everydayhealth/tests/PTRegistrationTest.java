package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.personalizedTracker.DiabetesPTRegistrationPage;
import everydayhealth.pages.personalizedTracker.PTRegistrationPage;
import everydayhealth.pages.personalizedTracker.PersonalizedTrackerPage;
import framework.Logger;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserActionsEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * PTRegistrationTest
 */
public class PTRegistrationTest {

	String PHONE_DO_NOT_RECEIVE_SMS = "7259999999";
	String PHONE_INVALID = "9999999999";
	String PHONE_SUBSCRIBED = "9292779467";
	String ENCODED_NEW_USER_EMAIL = "2293221c62969da54bd84bbfdd51901a9d3a5eaf199b69524339f4f101c8fdff";

	@BeforeGroups(groups = {"RANewUser", "RANewsletterNewUser", "CrohnsNewUser", "CrohnsNewsletterNewUser", "DiabetesNewUser", "DiabetesNewsletterNewUser"}, alwaysRun = true)
	public void beforeNewUserTests() {
		Utils.releasePhoneNumber(Utils.updatePhoneNumberViaPOSTRequest());
		UserActionsEH.releaseEmailAddress();
	}

	@BeforeGroups(groups = {"RAExistingUser", "RANewsletterExistingUser", "CrohnsExistingUser", "CrohnsNewsletterExistingUser", "CrohnsAsSecondProgram", "RAAsSecondProgram", "DiabetesExistingUser", "DiabetesNewsletterExistingUser"}, alwaysRun = true)
	public void beforeExistingUserTests() {
		Utils.releasePhoneNumber(Utils.updatePhoneNumberViaPOSTRequest());
		UserActionsEH.releaseEmailAddress();
		UserActionsEH.registerUserWithDefaultData(UserCacheEH.PT_REGISTRATION_USER.getEmail(), UserCacheEH.PT_REGISTRATION_USER.getPassword());
	}

	@Test(groups = {"PTRegistrationTest", "RANewUser", "C278416"}, priority = 1)
	@TestRail(id = "C278416")
	public void verifyOnSiteRegistrationNewUserRA() {
		verifyRegistrationProcess(false, false, false);
	}

	@Test(groups = {"PTRegistrationTest", "RAExistingUser", "C278417"}, priority = 2)
	@TestRail(id = "C278417")
	public void verifyOnSiteRegistrationExistingUserRA() {
		verifyRegistrationProcess(false, true, false);
	}

	@Test(groups = {"PTRegistrationTest", "RANewsletterNewUser", "C278418"}, priority = 3)
	@TestRail(id = "C278418")
	public void verifyNewsletterRegistrationNewUserRA() {
		verifyRegistrationProcess(false, false, true);
	}

	@Test(groups = {"PTRegistrationTest", "RANewsletterExistingUser", "C278419"}, priority = 4)
	@TestRail(id = "C278419")
	public void verifyNewsletterRegistrationExistingUserRA() {
		verifyRegistrationProcess(false, true, true);
	}

	@Test(groups = {"PTRegistrationTest", "CrohnsNewUser", "C287078"}, priority = 5)
	@TestRail(id = "C287078")
	public void verifyOnSiteRegistrationNewUserCrohns() {
		verifyRegistrationProcess(true, false, false);
	}

	@Test(groups = {"PTRegistrationTest", "CrohnsExistingUser", "C287079"}, priority = 6)
	@TestRail(id = "C287079")
	public void verifyOnSiteRegistrationExistingUserCrohns() {
		verifyRegistrationProcess(true, true, false);
	}

	@Test(groups = {"PTRegistrationTest", "CrohnsNewsletterNewUser", "C287080"}, priority = 7)
	@TestRail(id = "C287080")
	public void verifyNewsletterRegistrationNewUserCrohns() {
		verifyRegistrationProcess(true, false, true);
	}

	@Test(groups = {"PTRegistrationTest", "CrohnsNewsletterExistingUser", "C287081"}, priority = 8)
	@TestRail(id = "C287081")
	public void verifyNewsletterRegistrationExistingUserCrohns() {
		verifyRegistrationProcess(true, true, true);
	}

	@Test(groups = {"PTRegistrationTest", "CrohnsAsSecondProgram", "C287085"}, priority = 9)
	@TestRail(id = "C287085")
	public void verifySubscriptionToCrohnsAsSecondProgram() {
		registerForProgramAndVerifyRegistrationForAnotherProgram(false);
	}

	@Test(groups = {"PTRegistrationTest", "RAAsSecondProgram", "C287156"}, priority = 10)
	@TestRail(id = "C287156")
	public void verifySubscriptionToRAAsSecondProgram() {
		registerForProgramAndVerifyRegistrationForAnotherProgram(true);
	}

	@Test(groups = {"PTRegistrationTest", "DiabetesNewUser", "C306668"}, priority = 11)
	@TestRail(id = "C306668")
	public void verifyOnSiteRegistrationNewUserDiabetes() {
		verifyDiabetesPTRegistration(true, false);
	}

	@Test(groups = {"PTRegistrationTest", "DiabetesExistingUser", "C306669"}, priority = 12)
	@TestRail(id = "C306669")
	public void verifyOnSiteRegistrationExistingUserDiabetes() {
		verifyDiabetesPTRegistration(false, false);
	}

	@Test(groups = {"PTRegistrationTest", "DiabetesNewsletterNewUser", "C311873"}, priority = 13)
	@TestRail(id = "C311873")
	public void verifyNewsletterRegistrationNewUserDiabetes() {
		verifyDiabetesPTRegistration(true, true);
	}

	@Test(groups = {"PTRegistrationTest", "DiabetesNewsletterExistingUser", "C311874"}, priority = 14)
	@TestRail(id = "C311874")
	public void verifyNewsletterRegistrationExistingUserDiabetes() {
		verifyDiabetesPTRegistration(false, true);
	}

	private void verifyRegistrationProcess(boolean isCrohnsPT, boolean isExistingUser, boolean isNewsletterRegistration) {
		PTRegistrationPage ptRegistrationPage;
		if (isNewsletterRegistration) {
			ptRegistrationPage = isCrohnsPT ?
					SiteNavigatorEH.goToCrohnsPTRegistrationPageViaNewsletterUrl(ENCODED_NEW_USER_EMAIL) :
					SiteNavigatorEH.goToRAPTRegistrationPageViaNewsletterUrl(ENCODED_NEW_USER_EMAIL);
		} else {
			ptRegistrationPage = isCrohnsPT ?
					SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PTRegistrationPage.class) :
					SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PTRegistrationPage.class);
			assertTrue(ptRegistrationPage.isSignUpFormVisible(), "Sign up form should be visible");
			assertTrue(ptRegistrationPage.isEmailInputFieldVisible(), "'Email' input field should be visible");
			ptRegistrationPage.typeEmail(UserCacheEH.PT_REGISTRATION_USER.getEmail()).clickNextButton();
			if (isExistingUser) {
				assertTrue(ptRegistrationPage.isMessageForEHMemberVisible(),
						"Message for already existing EH profile should be visible");
			}
			assertEquals(ptRegistrationPage.getEmailInputFieldValue(),
					UserCacheEH.PT_REGISTRATION_USER.getEmail(),
					"Email should be equal to the one entered in first step");
			assertTrue(ptRegistrationPage.isEditEmailButtonVisible(), "'Edit' email button should be visible");
		}

		assertTrue(ptRegistrationPage.isEmailInputFieldVisible(), "'Email' input field should be visible");
		assertFalse(ptRegistrationPage.isEmailInputFieldEnabled(), "'Email' input field should not be enabled");
		assertTrue(ptRegistrationPage.isPasswordInputFieldVisible(), "'Password' input field should be visible");
		assertTrue(ptRegistrationPage.isMobilePhoneNumberInputFieldVisible(),
				"'Mobile phone #' input field should be visible");
		assertTrue(Utils.isConnectionHTTPS(), "Connection should be secured");
		if (isExistingUser) {
			ptRegistrationPage.typePassword(Settings.config.getPtUserPassword());
		} else {
			verifyPasswordRequirements(ptRegistrationPage);
		}
		ptRegistrationPage.typePhoneNumber(PHONE_INVALID);
		assertTrue(ptRegistrationPage.isPhoneNumberErrorMessageVisible(),
				"Incorrect phone number error message should be visible");
		if (!ptRegistrationPage.isTechnicalIssuesErrorMessageVisible()) {
			assertEquals(ptRegistrationPage.getPhoneNumberErrorMessageText(),
					"Sorry, this phone number is invalid. Please try another.",
					"Error message for invalid phone number should appear");
		}
		ptRegistrationPage.typePhoneNumber(PHONE_DO_NOT_RECEIVE_SMS);
		assertTrue(ptRegistrationPage.isPhoneNumberErrorMessageVisible(),
				"Incorrect phone number error message should be visible");
		if (!ptRegistrationPage.isTechnicalIssuesErrorMessageVisible()) {
			assertEquals(ptRegistrationPage.getPhoneNumberErrorMessageText(),
					"This phone number cannot receive text messages. Please try another.",
					"Error message for phone number that cannot receive messages should appear");
		}
		ptRegistrationPage.typePhoneNumber(PHONE_SUBSCRIBED);
		if (ptRegistrationPage.isTechnicalIssuesErrorMessageVisible()) {
			ptRegistrationPage.avoidTechnicalIssuesMessage();
		}
		assertFalse(ptRegistrationPage.isSignUpNowButtonEnabled(), "'Sign up now' button should be disabled");
		if (!isExistingUser) {
			ptRegistrationPage.clickTermsAndConditionsCheckbox();
		}
		ptRegistrationPage.clickConsentCheckbox();
		assertTrue(ptRegistrationPage.isSignUpNowButtonEnabled(), "'Sign up now' button should be enabled");
		ptRegistrationPage.clickSignUpButton(PTRegistrationPage.class);
		assertTrue(ptRegistrationPage.isPhoneNumberErrorMessageVisible(),
				"Incorrect phone number error message should be visible");
//		will be uncommented if this message is still valid
//		assertEquals(ptRegistrationPage.getPhoneNumberErrorMessageText(), "This phone number is already subscribed to My Daily RA.", "Error message for phone number that already subscribed to program should appear");
		ptRegistrationPage.typePhoneNumber("9292777091");
		if (ptRegistrationPage.isTechnicalIssuesErrorMessageVisible()) {
			ptRegistrationPage.avoidTechnicalIssuesMessage();
		}
		PersonalizedTrackerPage personalizedTrackerPage = ptRegistrationPage.clickSignUpButton(PersonalizedTrackerPage.class);
		assertTrue(personalizedTrackerPage.isActiveDaySectionVisible(),
				"User should land on dashboard and see welcome pop up");
	}

	private void verifyPasswordRequirements(PTRegistrationPage ptRegistrationPage) {
		ptRegistrationPage.typePassword(StringUtils.generateRandomStrAlphaNumeric(7));
		assertTrue(ptRegistrationPage.isPasswordRequirementsBoxVisible(), "Password requirements Box should be displayed");
		assertEquals(ptRegistrationPage.getRequirementsBoxHeaderText(), "Requirements", "Requirements should be visible");
		assertEquals(ptRegistrationPage.getPasswordRequirementsText(1), "8-10", "Requirements should be visible");
		assertEquals(ptRegistrationPage.getPasswordRequirementsText(2), "A", "Requirements should be visible");
		assertEquals(ptRegistrationPage.getPasswordRequirementsText(3), "a", "Requirements should be visible");
		assertEquals(ptRegistrationPage.getPasswordRequirementsText(4), "0-9 or !&?", "Requirements should be visible");
		ptRegistrationPage.typePassword("abc123$5");
		assertTrue(ptRegistrationPage.isPasswordValidationPointRequired(2), "Capital letter validation should be enabled");
		ptRegistrationPage.typePassword("ABcd12#");
		assertTrue(ptRegistrationPage.isPasswordValidationPointRequired(1), "8-10 validation should be enabled");
		ptRegistrationPage.typePassword("ABCD12345");
		assertTrue(ptRegistrationPage.isPasswordValidationPointRequired(3), "Lowercase validation should be enabled");
		ptRegistrationPage.typePassword("ABCDabcde");
		assertTrue(ptRegistrationPage.isPasswordValidationPointRequired(4),
				"Number or special character validation should be enabled");
		ptRegistrationPage.typePassword(UserCacheEH.PT_REGISTRATION_USER.getPassword());
		int numberOfValidationPoints = ptRegistrationPage.getNumberOfPasswordValidations();
		for (int point = 1; point <= numberOfValidationPoints; point++) {
			assertFalse(ptRegistrationPage.isPasswordValidationPointRequired(point), "Password should meet requirement");
		}
		assertEquals(ptRegistrationPage.getRequirementsBoxHeaderText(),
				"Success!",
				"Password box header should have 'Success' text");
	}

	private void registerForProgramAndVerifyRegistrationForAnotherProgram(boolean isCrohns) {
		PTRegistrationPage ptRegistrationPage = isCrohns ?
				SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PTRegistrationPage.class) :
				SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PTRegistrationPage.class);
		ptRegistrationPage.typeEmail(UserCacheEH.PT_REGISTRATION_USER.getEmail()).clickNextButton();
		assertTrue(ptRegistrationPage.isMessageForEHMemberVisible(),
				"Message for already existing EH profile should be visible");
		ptRegistrationPage.typePassword(UserCacheEH.PT_REGISTRATION_USER.getPassword());
		ptRegistrationPage.typePhoneNumber("9292777091");
		if (ptRegistrationPage.isTechnicalIssuesErrorMessageVisible()) {
			ptRegistrationPage.avoidTechnicalIssuesMessage();
		}
		ptRegistrationPage.clickConsentCheckbox();
		PersonalizedTrackerPage personalizedTrackerPage = ptRegistrationPage.clickSignUpButton(PersonalizedTrackerPage.class);
		assertTrue(personalizedTrackerPage.isActiveDaySectionVisible(), "User should land on program dashboard");
		Logger.info("Verify that user, registered for one program can successfully register for the second with the same email/phone number");
		ptRegistrationPage = isCrohns ?
				SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PTRegistrationPage.class) :
				SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PTRegistrationPage.class);
		ptRegistrationPage.typePhoneNumber("9292777091");
		if (ptRegistrationPage.isTechnicalIssuesErrorMessageVisible()) {
			ptRegistrationPage.avoidTechnicalIssuesMessage();
		}
		ptRegistrationPage.clickConsentCheckbox();
		personalizedTrackerPage = ptRegistrationPage.clickSignUpButton(PersonalizedTrackerPage.class);
		assertTrue(personalizedTrackerPage.isActiveDaySectionVisible(), "User should land on program dashboard");
	}

	private void verifyDiabetesPTRegistration(boolean isNewUser, boolean isNewsletterRegistration) {
		DiabetesPTRegistrationPage diabetesPTRegistrationPage;
		if (isNewsletterRegistration) {
			diabetesPTRegistrationPage = SiteNavigatorEH.goToDiabetesPTRegistrationPageViaNewsletterUrl(ENCODED_NEW_USER_EMAIL);
		} else {
			diabetesPTRegistrationPage = SiteNavigatorEH.goToPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, DiabetesPTRegistrationPage.class);
			assertTrue(diabetesPTRegistrationPage.isSignUpFormVisible(), "Sign up form should be visible");
			assertTrue(diabetesPTRegistrationPage.isEmailInputFieldVisible(), "'Email' input field should be visible");
			diabetesPTRegistrationPage.typeEmail(UserCacheEH.PT_REGISTRATION_USER.getEmail()).clickNextButton();
		}
		if (!isNewUser) {
			assertTrue(diabetesPTRegistrationPage.isMessageForEHMemberVisible(), "Message for existing EH user should be visible");
		}
		assertTrue(diabetesPTRegistrationPage.isEmailInputFieldVisible(), "'Email' input field should be visible");
		assertFalse(diabetesPTRegistrationPage.isEmailInputFieldEnabled(), "'Email' input field should not be enabled");
		assertEquals(diabetesPTRegistrationPage.getEmailInputFieldValue(),
				UserCacheEH.PT_REGISTRATION_USER.getEmail(),
				"Email should be equal to the one entered in first step");
		if (!isNewsletterRegistration) {
			assertTrue(diabetesPTRegistrationPage.isEditEmailButtonVisible(),
					"'Edit' button should be visible near 'Email' input");
		}
		assertTrue(diabetesPTRegistrationPage.isPasswordInputFieldVisible(),
				"'Password' input field should be visible");
		if (isNewUser) {
			verifyPasswordRequirements(diabetesPTRegistrationPage);
		} else {
			diabetesPTRegistrationPage.typePassword(Settings.config.getPtUserPassword());
		}
		assertTrue(diabetesPTRegistrationPage.isAgeRangeModuleVisible(), "'Age range' module should be visible");
		assertTrue(diabetesPTRegistrationPage.isAgeRangeValuePresentInDropdown("Under 18"),
				"'Under 18' value should be present in dropdown");
		assertTrue(diabetesPTRegistrationPage.isAgeRangeValuePresentInDropdown("18-34"),
				"'18-34' value should be present in dropdown");
		assertTrue(diabetesPTRegistrationPage.isAgeRangeValuePresentInDropdown("35-49"),
				"'35-49' value should be present in dropdown");
		assertTrue(diabetesPTRegistrationPage.isAgeRangeValuePresentInDropdown("50-64"),
				"'50-64' value should be present in dropdown");
		assertTrue(diabetesPTRegistrationPage.isAgeRangeValuePresentInDropdown("65+"),
				"'65+' value should be present in dropdown");
		diabetesPTRegistrationPage.chooseAgeRange("Under 18");
		assertTrue(diabetesPTRegistrationPage.isUnder18ErrorMessageVisible(),
				"'Sorry, you must be over 18 to be eligible for this program.' should be visible");
		diabetesPTRegistrationPage.chooseAgeRange("18-34");
		assertTrue(diabetesPTRegistrationPage.isMedicareQuestionModuleVisible(),
				"Medicare question module should be visible");
		assertTrue(diabetesPTRegistrationPage.isMedicareAnswerYesCheckboxVisible(),
				"Medicare answer checkbox 'Yes' should be visible");
		assertTrue(diabetesPTRegistrationPage.isMedicareAnswerNoCheckboxVisible(),
				"Medicare answer checkbox 'No' should be visible");
		diabetesPTRegistrationPage.clickMedicareAnswerNoCheckbox();
		assertTrue(diabetesPTRegistrationPage.isMedicareAnswerNoCheckboxChecked(),
				"'No' answer checkbox should be checked");
		assertTrue(diabetesPTRegistrationPage.isMedicationModuleVisible(),
				"'Type 2 diabetes medication' module should be visible");
		diabetesPTRegistrationPage.chooseMedicationOptionNumber(StringUtils.generateRandomInt(diabetesPTRegistrationPage.getNumberOfMedicationOptions()));
		if (isNewUser) {
			diabetesPTRegistrationPage.clickTermsAndConditionsCheckbox();
		}
		diabetesPTRegistrationPage.clickConsentCheckbox();
		assertTrue(diabetesPTRegistrationPage.isSignUpNowButtonEnabled(), "'Sign up' button should be enabled");
		diabetesPTRegistrationPage.clickSignUpButton(PersonalizedTrackerPage.class);
	}
}