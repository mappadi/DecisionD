package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.articles.SimpleQuizPage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import everydayhealth.pages.share.SocialBarEH;
import framework.Logger;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.StringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SimpleQuizTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SimpleQuizTest", "C516628"})
	@TestRail(id = "C516628")
	public void verifyHeadlineElements() {
		SimpleQuizPage simpleQuizPage = SiteNavigatorEH.goToPage(TemplatesEH.SIMPLE_QUIZ, SimpleQuizPage.class);

		String category = simpleQuizPage.getCategoryForPage().replace(" & ", "-").toLowerCase();
		String subCategory = simpleQuizPage.getSubCategoryForPage().replace(" ", "-").toLowerCase();
		verifyBreadcrumbs(simpleQuizPage, category, subCategory);
		verifyPromoBannerSection(simpleQuizPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "SimpleQuizTest", "C517792"})
	@TestRail(id = "C517792")
	public void verifySocialShareBarFunctionality() {
		SimpleQuizPage simpleQuizPage = SiteNavigatorEH.goToPage(TemplatesEH.SIMPLE_QUIZ, SimpleQuizPage.class);

		SocialBarEH socialBar = simpleQuizPage.onSocialBar();
		assertTrue(socialBar.isSocialBarVisible(), "Social share bar is not visible");
		assertTrue(socialBar.isSocialShareCountVisible(), "Social share count is not visible");
		assertTrue(socialBar.isFacebookShareButtonVisible(), "Facebook share button is not visible");
		assertTrue(socialBar.isTwitterShareButtonVisible(), "Twitter share button is not visible");
		assertTrue(socialBar.isPinterestShareButtonVisible(), "Pinterest share button is not visible");
		assertTrue(socialBar.isEmailShareButtonVisible(), "Email share button is not visible");

		int expectedNumberOfCountableShareButtons = (Settings.isDesktop()) ? 5 : 4;
		assertEquals(socialBar.getNumberOfShareButtonsWithShareCountAttribute(), expectedNumberOfCountableShareButtons, "Number of countable share buttons is incorrect");

		String sharesNumberBeforeClicks = socialBar.getNumberOfShares();
		if (Settings.isDesktop()) {
			assertTrue(socialBar.isPrintShareButtonVisible(), "Print share button is not visible");
			assertEquals(socialBar.getNumberOfShares(), socialBar.getSumOfSharesFromSocialShareButtons(true), "Number of shares in not equal sum of shares");
			socialBar.clickOnFacebookShareButton();
			socialBar.verifyFacebookPopUpContainsFacebook();
			socialBar.verifyNumberOfSharesIncreasedAfterClick(socialBar, sharesNumberBeforeClicks);

			sharesNumberBeforeClicks = socialBar.getNumberOfShares();
			socialBar.clickOnTwitterShareButton();
			socialBar.verifyTwitterPopUpContainsTwitter();
			socialBar.verifyNumberOfSharesIncreasedAfterClick(socialBar, sharesNumberBeforeClicks);

			sharesNumberBeforeClicks = socialBar.getNumberOfShares();
			socialBar.clickOnPinterestShareButton();
			socialBar.verifyPinterestPopUpContainsPinterest();
			socialBar.verifyNumberOfSharesIncreasedAfterClick(socialBar, sharesNumberBeforeClicks);

			if (Settings.browser.equals(framework.BrowserType.CHROME)) {
				sharesNumberBeforeClicks = socialBar.getNumberOfShares();
				socialBar.clickPrintShareButton();
				socialBar.verifyNumberOfSharesIncreasedAfterClick(socialBar, sharesNumberBeforeClicks);
			}
		} else {
			assertTrue(socialBar.getFacebookShareLink().contains("facebook"), "Facebook button link does not contain 'facebook'");
			assertTrue(socialBar.getTwitterShareLink().contains("twitter"), "Twitter button link does not contain 'twitter'");
			assertTrue(socialBar.getPinterestShareLink().contains("pinterest"), "Pinterest button link does not contain 'pinterest'");
		}

		sharesNumberBeforeClicks = socialBar.getNumberOfShares();
		ShareViaEmailPopUp shareViaEmailPopUp = socialBar.clickEmailShareButton();
		shareViaEmailPopUp.typeYourEmailFriendEmailAndSend(UserCacheEH.MAIN_USER.getEmail(), StringUtils.generateRandomEmail());
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks! Your email was sent"), "Sent email message is not visible");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyVisible(), "'Privacy Policy' is not visible");
		assertEquals(shareViaEmailPopUp.getPrivacyPolicyLinkText(), "Privacy Policy", "'Privacy Policy' text is not present");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyLinkPresent(), "'Privacy Policy' link is not present");
		shareViaEmailPopUp.clickSignUpButton();
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks! Your email was sent"), "Sent email message is not visible");
		shareViaEmailPopUp.closePopUp();
		socialBar.verifyNumberOfSharesIncreasedAfterClick(socialBar, sharesNumberBeforeClicks);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "SimpleQuizTest", "C671916"})
	@TestRail(id = "C671916")
	public void verifySaveButtonFunctionalityForNonLoggedInUser() {
		SimpleQuizPage simpleQuizPage = SiteNavigatorEH.goToPage(TemplatesEH.SIMPLE_QUIZ, SimpleQuizPage.class);

		verifySaveButtonFunctionalityForNonLoggedInUser(simpleQuizPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SimpleQuizTest", "C672605"})
	@TestRail(id = "C672605")
	public void verifyReadNextWidgetOnSimpleQuiz() {
		SimpleQuizPage simpleQuizPage = SiteNavigatorEH.goToPage(TemplatesEH.SIMPLE_QUIZ, SimpleQuizPage.class);

		Logger.info("Verify ReadNext widget");
		assertTrue(simpleQuizPage.isReadNextWidgetVisible(), "Read next widget should be visible");
		int numberOfCards = simpleQuizPage.getNumberOfCardsInReadNext();
		assertEquals(numberOfCards, 3, "3 cards should be present in Read next widget");
		assertTrue(simpleQuizPage.isReadNextWidgetHeadlineVisible(), "Read next widget headline should be visible");
		assertTrue(simpleQuizPage.isReadNextCategoryLinkVisible(), "Read next widget headline category link should be visible");
		for (int card = 1; card <= numberOfCards; card++) {
			assertFalse(simpleQuizPage.getReadNextCardHrefAttributeValue(card).isEmpty(), "Read next card should be clickable");
			assertTrue(simpleQuizPage.isReadNextCardHeadlineVisible(card), "Every Read next widget card should have headline");
			assertTrue(simpleQuizPage.isReadNextCardImageVisible(card), "Every Read next widget card should have image");
			if (!Settings.isMobile()) {
				assertTrue(simpleQuizPage.isReadNextCardTypeIconVisible(card), "Every Read next widget card should have type icon");
			}
		}
	}


	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SimpleQuizTest", "C674460"})
	@TestRail(id = "C674460")
	public void verifySimpleQuizQuestionnaire() {
		SimpleQuizPage simpleQuizPage = SiteNavigatorEH.goToPage(TemplatesEH.SIMPLE_QUIZ, SimpleQuizPage.class);

		assertTrue(simpleQuizPage.isSimpleQuizContentVisible(), "Simple quiz widget should be visible");
		assertTrue(simpleQuizPage.isSimpleQuizTitleVisible(), "Simple quiz widget title should be visible");
		assertTrue(simpleQuizPage.isSimpleQuizDeckVisible(), "Simple quiz widget deck should be visible");
		assertTrue(simpleQuizPage.isSimpleQuizIntroImageVisible(), "Simple quiz widget intro image should be visible");
		assertTrue(simpleQuizPage.isSimpleQuizStartButtonVisible(), "Simple quiz widget take the quiz button should be visible");
		simpleQuizPage.clickTakeTheQuizButton();
		assertTrue(simpleQuizPage.isQuizPreviousArrowVisible(), "Simple quiz widget previous arrow button should be visible");
		int numberOfQuestions = simpleQuizPage.getSimpleQuizQuestionsCount();
		assertTrue(numberOfQuestions >= 1, "At least one question should be visible on Simple quiz widget");
		for (int numberBlocks = 1; numberBlocks <= numberOfQuestions; numberBlocks++) {
			simpleQuizPage.clickOnOption(numberBlocks);
		}
		assertTrue(simpleQuizPage.isIGNPlayerVisible(), "Video module (IGN player) should be visible");
		if (Settings.isDesktop()) {
			simpleQuizPage.clickIGNPlayButton();
			assertFalse(simpleQuizPage.isSimpleQuizIGNVideoPaused(), "Video should play after click on 'Play' button");
			simpleQuizPage.clickIGNPauseButton();
			assertTrue(simpleQuizPage.isSimpleQuizIGNVideoPaused(), "Video should be paused after click on 'Pause' button");
			simpleQuizPage.clickIGNMuteButton();
			assertTrue(simpleQuizPage.isSimpleQuizIGNVideoMuted(), "Video should be muted after click on volume button");
			simpleQuizPage.clickIGNMuteButton();
			assertFalse(simpleQuizPage.isSimpleQuizIGNVideoMuted(), "Video should be muted after click on volume button");
			simpleQuizPage.clickIGNFullscreenButton();
			assertTrue(simpleQuizPage.isSimpleQuizIGNVideoInFullscreenMode(), "Video should be in fullscreen mode after click on 'Fullscreen' button");
			simpleQuizPage.clickIGNFullscreenButton();
			assertFalse(simpleQuizPage.isSimpleQuizIGNVideoInFullscreenMode(), "Video should not be in fullscreen mode after click on 'Fullscreen' button");
			assertTrue(simpleQuizPage.isIGNVideoCreditVisible(), "IGN video credit should be visible");
			assertTrue(simpleQuizPage.isIGNVideoCaptionVisible(), "IGN video caption should be visible");
			assertFalse(simpleQuizPage.getIGNVideoCreditHrefValue().isEmpty(), "IGN video credit 'href' attribute value should not be empty");
			assertFalse(simpleQuizPage.getIGNVideoCaptionHrefValue().isEmpty(), "IGN video caption 'href' attribute value should not be empty");
		}
		assertTrue(simpleQuizPage.isQuizResultTitleVisible(), "Simple quiz result title should be visible");
		assertTrue(simpleQuizPage.isQuizResultDeckVisible(), "Simple quiz result deck should be visible");
		assertTrue(simpleQuizPage.isQuizResultImageVisible(), "Simple quiz result image should be visible");
		assertTrue(simpleQuizPage.isQuizResultDescriptionVisible(), "Simple quiz result description should be visible");
		assertTrue(simpleQuizPage.isRelatedContentModuleVisible(), "Simple quiz related content module should be visible");
		int numberOfRelatedItems = simpleQuizPage.getNumberOfRelatedContentItems();
		assertEquals(simpleQuizPage.getNumberOfRelatedContentItems(), 2, "Incorrect Number of related content items");
		for (int item = 1; item <= numberOfRelatedItems; item++) {
			assertTrue(simpleQuizPage.isRelatedContentItemImageVisible(), "Simple quiz related content item image should be visible");
			assertTrue(simpleQuizPage.isRelatedContentItemTitleVisible(), "Simple quiz related content item title should be visible");
		}
		assertTrue(simpleQuizPage.isBylineVisible(), "Byline and reviewer is not visible");
		assertTrue(simpleQuizPage.isRestartButtonVisible(), "Take the quiz again/restart is not visible");
		assertFalse(simpleQuizPage.isQuizPreviousArrowVisible(), "Simple quiz widget previous arrow button should be visible");
		simpleQuizPage.clickQuizRestartButton();
		assertTrue(simpleQuizPage.isQuizPreviousArrowVisible(), "Simple quiz widget previous arrow button should be visible");
	}
}
