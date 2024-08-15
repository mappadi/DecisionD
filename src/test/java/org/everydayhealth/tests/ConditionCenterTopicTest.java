package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.GlobalNavHeader;
import everydayhealth.pages.conditions.ConditionCenterTopicPage;
import everydayhealth.pages.registrations.InlineRegistration;
import framework.DebugMode;
import framework.GoogleAdValue;
import framework.Logger;
import framework.Settings;
import framework.platform.CookieName;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class ConditionCenterTopicTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C204585"})
	@TestRail(id = "C204585")
	public void verifyCCRTopicLandingPageElements() {
		Logger.info("Verify the CCR Topic page elements");
		ConditionCenterTopicPage ccrTopicPage = SiteNavigatorEH.goToCCRTopicPageEH(TemplatesEH.TOPIC_LANDING);

		String category = ccrTopicPage.getCategoryForPage().replace(" ", "-").toLowerCase();
		String subCategory = ccrTopicPage.getSubCategoryForPage().replace(" ", "-").toLowerCase();
		verifyBreadcrumbs(ccrTopicPage, category, subCategory);

		verifyMiniContentCardContent(ccrTopicPage);
		verifyContentCardElements(ccrTopicPage);
		assertTrue(ccrTopicPage.isTopicNameVisible(), "Topic page name not available");
		assertTrue(ccrTopicPage.isFollowButtonVisible(), "Follow button not visible");
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C204600"})
	@TestRail(id = "C204600")
	public void verifyFollowButtonForLoggedInUser() {
		ConditionCenterTopicPage ccrTopicPage = SiteNavigatorEH.goToCCRTopicPageEH(TemplatesEH.TOPIC_LANDING);
		ccrTopicPage.onGlobalNavHeader().loginWithUserAndOpenPage(UserCacheEH.MAIN_USER, ConditionCenterTopicPage.class);
		assertTrue(ccrTopicPage.isFollowButtonVisible(), "'Follow' button should be visible");
		assertEquals(ccrTopicPage.getFollowButtonBackgroundColor(), "#ffffff", "'Follow' button should have white background");
		assertEquals(ccrTopicPage.getFollowButtonText(), "Follow", "'Follow' button text should be 'Follow'");
		ccrTopicPage.clickFollowButton();
		assertTrue(ccrTopicPage.isFollowingButtonVisible(), "'Following' button should be visible");
		assertEquals(ccrTopicPage.getFollowButtonText(), "Following", "'Follow' button should change text to 'Following'");
		assertEquals(ccrTopicPage.getFollowButtonBackgroundColor(), "#e8fcca", "'Follow' button color should change to '#e8fcca'");

		verifyTopicIsAddedToFollowing(ccrTopicPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C204598"})
	@TestRail(id = "C204598")
	public void verifyFollowButtonForNonLoggedUser() {
		ConditionCenterTopicPage ccrTopicPage = SiteNavigatorEH.goToCCRTopicPageEH(TemplatesEH.TOPIC_LANDING);
		assertTrue(ccrTopicPage.isFollowButtonVisible(), "'Follow' button should be visible");
		assertEquals(ccrTopicPage.getFollowButtonBackgroundColor(), "#ffffff", "'Follow' button should have white background");
		assertEquals(ccrTopicPage.getFollowButtonText(), "Follow", "'Follow' button text should be 'Follow'");
		ccrTopicPage.clickFollowButton();
		InlineRegistration inlineRegistration = ccrTopicPage.onInlineRegistration();

		Logger.info("Verify email address requirements");
		assertFalse(inlineRegistration.isSignupButtonClickable(), "Signup button enabled");
		inlineRegistration.enterEmailAndTabOut("test1@mailinator.com");
		assertTrue(inlineRegistration.isWarningMessageWithTextVisible("This email address already exists."), "Warning message for existing email should have appeared");
		inlineRegistration.enterEmailAndTabOut(StringUtils.generateRandomStrAlphabetic(10));
		assertTrue(inlineRegistration.isWarningMessageWithTextVisible("You must enter a valid email address."), "Warning message for invalid email should have appeared");

		Logger.info("Verify password requirements");
		inlineRegistration.enterPassword(StringUtils.generateRandomStrAlphaNumeric(7));
		assertTrue(inlineRegistration.isPasswordRequirementsTipsVisible(), "Password requirements Box should be displayed");
		assertEquals(inlineRegistration.getRequirementsBoxHeaderText(), "Requirements", "Requirements should be visible");
		assertEquals(inlineRegistration.getPasswordRequirementsText(1), "8-10", "Requirements should be visible");
		assertEquals(inlineRegistration.getPasswordRequirementsText(2), "A", "Requirements should be visible");
		assertEquals(inlineRegistration.getPasswordRequirementsText(3), "a", "Requirements should be visible");
		assertEquals(inlineRegistration.getPasswordRequirementsText(4), "0-9 or !&?", "Requirements should be visible");
		inlineRegistration.enterPassword("abc123$5");
		assertTrue(inlineRegistration.isPasswordValidationPointRequired(2), "Capital letter validation should be enabled");
		inlineRegistration.enterPassword("ABcd12#");
		assertTrue(inlineRegistration.isPasswordValidationPointRequired(1), "8-10 validation should be enabled");
		inlineRegistration.enterPassword("ABCD12345");
		assertTrue(inlineRegistration.isPasswordValidationPointRequired(3), "Lowercase validation should be enabled");
		inlineRegistration.enterPassword("ABCDabcde");
		assertTrue(inlineRegistration.isPasswordValidationPointRequired(4), "Number or special character validation should be enabled");
		inlineRegistration.enterPassword("asdQWE123");
		int numberOfValidationPoints = inlineRegistration.getNumberOfPasswordValidations();
		for (int point = 1; point <= numberOfValidationPoints; point++) {
			assertFalse(inlineRegistration.isPasswordValidationPointRequired(point), "Password should meet requirement");
		}
		assertEquals(inlineRegistration.getRequirementsBoxHeaderText(), "Success!", "Password box header should have 'Success' text");

		Logger.info("Verify 'Terms & Conditions' and 'Privacy Policy' hyperlinks");
		assertTrue(inlineRegistration.getTermsAndConditionsLinkText(1).contains("Terms & Conditions"), "'Terms & Conditions' text should be a hyperlink");
		assertTrue(inlineRegistration.getTermsAndConditionsHrefValue().contains("terms-of-use"), "'Terms and conditions' link should lead to correct page");
		assertTrue(inlineRegistration.getTermsAndConditionsLinkText(2).contains("Privacy Policy"), "'Privacy Policy' text should be a hyperlink");
		assertTrue(inlineRegistration.getPrivacyPolicyHrefValue().contains("privacy-policy"), "'Privacy Policy' link should lead to correct page");

		Logger.info("Registering user with valid data");
		inlineRegistration.createNewInlineRegistration(StringUtils.generateRandomEmail(), "EHtopic11");
		assertTrue(inlineRegistration.onGlobalNavHeader().isLoggedIn(), "User is not registered");
		assertTrue(ccrTopicPage.isFollowingButtonVisible(), "'Following' button should be visible");
		assertEquals(ccrTopicPage.getFollowButtonText(), "Following", "'Follow' button should change text to 'Following'");
		assertEquals(ccrTopicPage.getFollowButtonBackgroundColor(), "#e8fcca", "'Follow' button color should change to '#e8fcca'");

		verifyTopicIsAddedToFollowing(ccrTopicPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C216783"})
	@TestRail(id = "C216783")
	public void verifyAdPosition() {
		ConditionCenterTopicPage ccrTopicPage = SiteNavigatorEH.goToCCRTopicPageEH(TemplatesEH.TOPIC_LANDING);

		int numberOfCards = ccrTopicPage.getTotalNumberOfContentCards();
		assertTrue(ccrTopicPage.isContentCardSlotContainsAdBlock(3), "Ad block should be shown on 3rd position");
		if (numberOfCards >= 7) {
			assertTrue(ccrTopicPage.isContentCardSlotContainsAdBlock(7), "Ad block should be shown on 7th position");
			ccrTopicPage.clickSeeMoreButton();
			assertTrue(ccrTopicPage.isContentCardSlotContainsAdBlock(14), "Ad block should be shown on 14th position");
		}

		DebugMode debugMode = ccrTopicPage.inDebugMode();
		Utils.waitFor(1500);
		if (numberOfCards >= 7) {
			ccrTopicPage.clickSeeMoreButton();
		}

		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 1), "300x250", "Size of 1st ad block should be 300x250");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 2), "300x250", "Size of 2nd ad block should be 300x250");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 3), "300x250", "Size of 3rd ad block should be 300x250");
		} else {
			if (numberOfCards >= 7) {
				debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			} else {
				debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			}
		}

		if (Settings.isDesktop()) {
			String adSize = debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 1);
			assertTrue(adSize.equals("728x90") || adSize.equals("970x90") || adSize.equals("970x250"), "Wrong size of top ad block");
		}

		if (Settings.isTablet()) {
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 1), "728x90", "Wrong size of top ad block");
		}

		if (Settings.isDesktop() || Settings.isTablet()) {
			assertTrue(debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 2).contains("300x"), "Width of 2nd ad block should be 300");
			if (numberOfCards >= 7) {
				assertTrue(debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 3).contains("300x"), "Width of 2nd ad block should be 300");
				assertTrue(debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 4).contains("300x"), "Width of 2nd ad block should be 300");
				assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 5), "728x90", "Wrong size of bottom ad block");
			} else {
				assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 3), "728x90", "Wrong size of bottom ad block");
			}
		}
	}

	private void verifyMiniContentCardContent(ConditionCenterTopicPage ccrTopicPage) {
		int miniContentCardCount = ccrTopicPage.getMiniContentCardCount();
		assertEquals(ccrTopicPage.getMiniContentCardBorderCount(), miniContentCardCount, "Mini content card border does not exist");
		for (int elementNumber = 1; elementNumber <= miniContentCardCount; elementNumber++) {
			ccrTopicPage.clickMiniContentCardRightArrow(elementNumber);
			assertTrue(ccrTopicPage.isMiniContentCardContainsHref(elementNumber), "Href does not exist");
			assertTrue(ccrTopicPage.isMiniContentCardContainsImage(elementNumber), "Image does not exist");
			assertFalse(ccrTopicPage.isMiniContentCardContainsHeader(elementNumber), "Header does not exist");
		}
		if (ccrTopicPage.isMiniContentCardLeftArrowVisible()) {
			ccrTopicPage.clickMiniContentCardLeftArrow();
		}
	}

	private void verifyContentCardElements(ConditionCenterTopicPage ccrTopicPage) {
		int contentCardCount = ccrTopicPage.getContentCardCount();
		for (int elementNumber = 1; elementNumber <= contentCardCount; elementNumber++) {
			Logger.info("element number is " + elementNumber);
			assertTrue(ccrTopicPage.isContentCardImageWidth(elementNumber, 400), "Width is not 400");
			assertTrue(ccrTopicPage.isContentCardImageContainsDataSource(elementNumber), "Data source is not available");
			assertTrue(ccrTopicPage.isContentCardHeaderExist(elementNumber), "Header not present");
			if (!Settings.isMobile()) {
				assertTrue(ccrTopicPage.isContentCardDescExist(elementNumber), "Description not present");
			}
		}
		if (ccrTopicPage.isSeeMoreButtonVisible()) {
			assertEquals(ccrTopicPage.getContentCardIconCount(), 9, "Content card count is not 9");
			ccrTopicPage.clickSeeMoreButton();
			assertTrue((ccrTopicPage.getContentCardIconCount() > 9), "Content card count did not increase after clicking see more button");
		} else {
			assertTrue(ccrTopicPage.getContentCardIconCount() < 9, "Content card count should be less than 9 when See More button not visible");
		}
	}

	private void verifyTopicIsAddedToFollowing(ConditionCenterTopicPage ccrTopicPage) {
		String topic = ccrTopicPage.getTopicText();
		GlobalNavHeader globalNavHeader = ccrTopicPage.onGlobalNavHeader();
		globalNavHeader.clickMyProfileButton();
		assertTrue(globalNavHeader.isProfileOverlayItemVisible("Following Topics"), "'Following Topics' profile overlay item is not visible");
		assertTrue(globalNavHeader.isProfileOverlayItemVisible("Saved Items"), "'Saved Items' profile overlay item is not visible");
		assertTrue(globalNavHeader.isProfileOverlayItemVisible("Newsletters"), "'Newsletters' profile overlay item is not visible");
		assertTrue(globalNavHeader.isProfileOverlayItemVisible("Tools"), "'Tools' profile overlay item is not visible");
		assertTrue(globalNavHeader.isProfileOverlayItemVisible("Settings"), "'Settings' profile overlay item is not visible");
		assertTrue(globalNavHeader.isProfileOverlayItemVisible("Logout"), "'Logout' profile overlay item is not visible");

		globalNavHeader.clickProfileOverlayItem("Following Topics");
		Logger.info("Check if topic is added to the list. Refreshing page up to 5 times if needed.");
		for (int waitCounter = 1; waitCounter <= 5; waitCounter++) {
			if (ccrTopicPage.getCountOfTopicNameInFollowingTopicPage() > 0) {
				Logger.info("Topic is added to list");
				break;
			}
			ccrTopicPage.refresh();
			Utils.waitFor(3000); //some time is needed for item to be added
		}
		assertTrue(ccrTopicPage.isTopicNameInFollowingTopicsPageVisible(), "Topic was not added to Following Topics list");
		assertTrue(ccrTopicPage.getTextOfTopicInTheList(1).equalsIgnoreCase(topic), "Correct topic should be added");
		assertTrue(ccrTopicPage.isEditLinkInFollowingTopicPageVisible(), "'Edit' link is not visible");
		ccrTopicPage.clickEditLinkInFollowingTopicPage();
		assertTrue(ccrTopicPage.isCloseIconInFollowingTopicVisible(), "'Close' icon is not visible");
		ccrTopicPage.clickCloseIconInFollowingTopicPage(1);
		for (int waitCounter = 1; waitCounter <= 5; waitCounter++) {
			ccrTopicPage.refresh();
			Utils.waitFor(4000); //some time is needed for item to be removed
		}
	}
}
