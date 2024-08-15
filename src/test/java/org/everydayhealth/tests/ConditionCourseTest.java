package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import everydayhealth.pages.conditions.ConditionCoursePage;
import framework.Logger;
import framework.Settings;
import framework.platform.CookieName;
import framework.platform.SiteNavigatorEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Tests for Condition course
 */
public class ConditionCourseTest extends WidgetsBaseTest {

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ConditionCourse", "C214533"})
	@TestRail(id = "C214533")
	public void verifyConditionCourseContent() {
		ConditionCoursePage conditionCoursePage = SiteNavigatorEH.goToCusoConditionCoursePage();
		assertTrue(conditionCoursePage.isHeadlineVisible(), "Headline not visible");
		assertTrue(conditionCoursePage.isDeckVisible(), "Deck not visible");
		assertTrue(conditionCoursePage.isBylineVisible(), "Byline not visible");
		assertTrue(conditionCoursePage.isMedicalReviewerVisible(), "Medical reviewer not visible");

		verifyATCWidgetFunctionality(conditionCoursePage, false, true);

		Logger.info("Condition course tab navigation");
		for (int tabNumber = 1; tabNumber <= conditionCoursePage.getConditionTabCount(); tabNumber++) {
			assertTrue(conditionCoursePage.isConditionTabImageVisible(tabNumber), "Condition tab " + tabNumber + " image not visible");
			assertFalse(conditionCoursePage.isConditionTabTitlePresent(tabNumber), "Condition tab " + tabNumber + " title not visible");
		}
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ConditionCourse", "C208969"})
	@TestRail(id = "C208969")
	public void verifyConditionCourseWidgets() {
		ConditionCoursePage conditionCoursePage = SiteNavigatorEH.goToCusoConditionCoursePage();

		verifyCusoHeaderWidget(conditionCoursePage, true);
		verifyReadNextWidget(conditionCoursePage);
		if (Settings.isDesktop()) {
			verifyPromoWidget(conditionCoursePage);
			verifyRelatedWidget(conditionCoursePage);
		}
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ConditionCourse", "C208968"})
	@TestRail(id = "C208968")
	public void verifyConditionCourseSlideNavigation() {
		ConditionCoursePage conditionCoursePage = SiteNavigatorEH.goToCusoConditionCoursePage();

		Logger.info("Verify clicking on Get Started button on Tab 1 should navigate to first slide of tab 1");
		String dataCategory = conditionCoursePage.getConditionTabDataCategory(1);
		conditionCoursePage.clickOnGetStarted(dataCategory);
		verifySlideContent(conditionCoursePage, 1, dataCategory, 1);
		conditionCoursePage.clickOnConditionTab(1);

		Logger.info("Verify forward Slide navigation using next slide arrow");
		verifySlideNavigation(conditionCoursePage, "usingNextNavigationArrow");

		Logger.info("Verify backward Slide navigation using previous slide arrow");
		verifyBackwardSlideNavigation(conditionCoursePage);

		Logger.info("Verify Slide navigation using footer radio buttons");
		verifySlideNavigation(conditionCoursePage, "usingFooterRadioButtons");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ConditionCourse", "C345146"})
	@TestRail(id = "C345146")
	public void verifySocialShareBar() {
		ConditionCoursePage conditionCoursePage = SiteNavigatorEH.goToCusoConditionCoursePage();

		SocialBarEH socialBarEH = conditionCoursePage.onSocialBar();
		int socialBarXCoordinateValue = socialBarEH.getSocialShareBarXCoordinate();
		int headlineXCoordinateValue = conditionCoursePage.getHeadlineXCoordinateValue();
		assertTrue(socialBarXCoordinateValue < headlineXCoordinateValue, "Social bar should be on the left hand side");
		assertTrue(socialBarEH.isFacebookShareButtonVisible(), "'Facebook' share button should be visible");
		assertTrue(socialBarEH.isTwitterShareButtonVisible(), "'Twitter' share button should be visible");
		assertTrue(socialBarEH.isPinterestShareButtonVisible(), "'Pinterest' share button should be visible");
		assertTrue(socialBarEH.isEmailShareButtonVisible(), "'Email' share button should be visible");

		if (Settings.isDesktop()) {
			assertTrue(socialBarEH.isPrintShareButtonVisible(), "Print share button is not visible");
			socialBarEH.clickOnFacebookShareButton();
			Utils.waitFor(1500);
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event93", "'event93' should fire after FB button click");
			socialBarEH.verifyFacebookPopUpContainsFacebook();

			socialBarEH.clickOnTwitterShareButton();
			Utils.waitFor(1500);
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event94", "'event94' should fire after Twitter button click");
			socialBarEH.verifyTwitterPopUpContainsTwitter();

			socialBarEH.clickOnPinterestShareButton();
			Utils.waitFor(1500);
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event96", "'event96' should fire after Pinterest button click");
			socialBarEH.verifyPinterestPopUpContainsPinterest();

			if (Settings.browser.equals(framework.BrowserType.CHROME)) {
				socialBarEH.clickPrintShareButton();
				Utils.waitFor(1500);
				assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event98", "'event98' should fire after Print button click");
			}
		} else {
			assertTrue(socialBarEH.getFacebookShareLink().contains("facebook"), "Facebook button link does not contain 'facebook'");
			assertTrue(socialBarEH.getTwitterShareLink().contains("twitter"), "Twitter button link does not contain 'twitter'");
			assertTrue(socialBarEH.getPinterestShareLink().contains("pinterest"), "Pinterest button link does not contain 'pinterest'");
		}

		ShareViaEmailPopUp shareViaEmailPopUp = socialBarEH.clickEmailShareButton();
		Utils.waitFor(1500);
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event92", "'event92' should fire after Email button click");
		shareViaEmailPopUp.typeYourEmailFriendEmailAndSend(UserCacheEH.MAIN_USER.getEmail(), StringUtils.generateRandomEmail());
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks! Your email was sent"), "Sent email message is not visible");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyVisible(), "'Privacy Policy' is not visible");
		assertEquals(shareViaEmailPopUp.getPrivacyPolicyLinkText(), "Privacy Policy", "'Privacy Policy' text is not present");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyLinkPresent(), "'Privacy Policy' link is not present");
		shareViaEmailPopUp.clickSignUpButton();
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks for signing up!"), "Sent email message is not visible");
		shareViaEmailPopUp.closePopUp();
	}

	private void verifySlideNavigation(ConditionCoursePage conditionCoursePage, String type) {
		String dataCategory;
		String getStartedButtonColor = null;
		String conditionTabHeaderColor = null;
		String conditionTabFooterColor;
		String slideHeadlineColor;
		int slidesCount = 0;
		Set<String> tabColors = new HashSet<String>();

		int conditionTabCount = conditionCoursePage.getConditionTabCount();
		for (int tabNumber = 1; tabNumber <= conditionTabCount; tabNumber++) {
			if (type.contains("usingFooterRadioButtons")) {
				conditionCoursePage.clickOnConditionTab(tabNumber);
			}
			assertTrue(conditionCoursePage.isConditionTabActive(tabNumber), "Condition tab " + tabNumber + " not active");
			dataCategory = conditionCoursePage.getConditionTabDataCategory(tabNumber);

			if (type.contains("usingNextNavigationArrow")) {
				slidesCount = conditionCoursePage.getSlideCount(dataCategory);
			} else {
				slidesCount = conditionCoursePage.getFooterRadioButtons(dataCategory);
			}

			for (int slideNumber = 1; slideNumber <= slidesCount; slideNumber++) {
				if (slideNumber == 1) {
					Logger.info("Verify first slide of each tab is intro slide");
					verifyGetStartedContent(conditionCoursePage, dataCategory, tabNumber);
					getStartedButtonColor = conditionCoursePage.getColorOfGetStartedButton(dataCategory);
				}

				String hashTag = conditionCoursePage.getHashTagFromUrl();
				if (type.contains("usingNextNavigationArrow")) {
					conditionCoursePage.clickOnNextSlideArrow();
					conditionTabHeaderColor = conditionCoursePage.getColorOfConditionTabHeader();
					conditionTabFooterColor = conditionCoursePage.getColorOfConditionTabFooter();
					slideHeadlineColor = conditionCoursePage.getColorOfSlideHeadlineTab(dataCategory);
					assertEquals(getStartedButtonColor, conditionTabHeaderColor, "Get started button color does not match with condition tab header color");
					assertEquals(getStartedButtonColor, conditionTabFooterColor, "Get started button color does not match with condition tab footer color");
					assertEquals(getStartedButtonColor, slideHeadlineColor, "Get started button color does not match with Slide headline color");
					tabColors.add(conditionTabHeaderColor);
				} else {
					conditionCoursePage.clickOnFooterRadioButton(slideNumber, dataCategory);
				}
				verifySlideContent(conditionCoursePage, slideNumber, dataCategory, tabNumber);
				Logger.info("Hash tag in URL should be different for each slide");
				assertFalse(hashTag.equalsIgnoreCase(conditionCoursePage.getHashTagFromUrl()), "Hash tag from URL is same for slide " + slideNumber);
			}

			if (type.contains("usingNextNavigationArrow")) {
				conditionCoursePage.clickOnNextSlideArrow();
			}
		}

		if (type.contains("usingNextNavigationArrow")) {
			Logger.info("Verify after navigating through all slides over tabs, first slide on tab 1 should be displayed");
			dataCategory = conditionCoursePage.getConditionTabDataCategory(1);
			verifyGetStartedContent(conditionCoursePage, dataCategory, 1);
			Logger.info("Verify different tabs have different colors");
			assertEquals(tabColors.size(), conditionTabCount, "Condition tab colors are not different over tabs");
		}
	}

	private void verifyBackwardSlideNavigation(ConditionCoursePage conditionCoursePage) {
		String dataCategory;
		int slidesCount = 0;
		int conditionTabCount = conditionCoursePage.getConditionTabCount();
		for (int tabNumber = conditionTabCount; tabNumber >= 1; tabNumber--) {
			conditionCoursePage.clickOnPreviousSlideArrow();
			assertTrue(conditionCoursePage.isConditionTabActive(tabNumber), "Condition tab " + tabNumber + " not active");

			dataCategory = conditionCoursePage.getConditionTabDataCategory(tabNumber);
			slidesCount = conditionCoursePage.getSlideCount(dataCategory);

			for (int slide = slidesCount; slide >= 1; slide--) {
				verifySlideContent(conditionCoursePage, slide, dataCategory, tabNumber);
				conditionCoursePage.clickOnPreviousSlideArrow();
			}
			verifyGetStartedContent(conditionCoursePage, dataCategory, tabNumber);
		}
	}

	private void verifyGetStartedContent(ConditionCoursePage conditionCoursePage, String dataCategory, int tabNumber) {
		boolean getStartedButtonVisible = conditionCoursePage.isGetStartedButtonVisible(dataCategory);
		assertTrue(getStartedButtonVisible, "Get started button not visible for tab number " + tabNumber);
		assertTrue(conditionCoursePage.isGetStartedContentVisible(dataCategory), "Get started content not visible for tab number " + tabNumber);
		assertTrue(conditionCoursePage.getActiveFooterRadioButtons() == 0, "Footer radio buttons are active on intro slide for tab number " + tabNumber);
	}

	private void verifySlideContent(ConditionCoursePage conditionCoursePage, int slide, String dataCategory, int tabNumber) {
		assertTrue(conditionCoursePage.isSlideVisible(slide, dataCategory), "Slide " + slide + " in tab " + tabNumber + " not visible");
		assertTrue(conditionCoursePage.isSlideHeadlineVisible(slide, dataCategory), "Slide headline in slide " + slide + " in tab " + tabNumber + " not visible");
		assertTrue(conditionCoursePage.isSlideImageVisible(slide, dataCategory), "Slide image in slide " + slide + " in tab " + tabNumber + " not visible");
		assertTrue(conditionCoursePage.isSlideContentVisible(slide, dataCategory), "Slide content in slide " + slide + " in tab " + tabNumber + " not visible");
		assertTrue(conditionCoursePage.isFooterRadioButtonActive(slide, dataCategory), "Footer radio button in slide " + slide + " in tab " + tabNumber + " not active");
	}
}