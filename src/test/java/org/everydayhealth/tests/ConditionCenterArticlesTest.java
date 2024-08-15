package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.ArticleBasePage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import framework.Logger;
import framework.Settings;
import framework.platform.CookieName;
import framework.platform.Environment;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Tests for Condition Center (CCR) Articles
 */

public class ConditionCenterArticlesTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C216418"})
	@TestRail(id = "C216418")
	public void verifyArticleContent() {
		Logger.info("Verify Header and Breadcrumb article page");
		ArticleBasePage ccrArticlePage = SiteNavigatorEH.goToCCRArticlePageEH(TemplatesEH.CCR_ARTICLE);
		assertTrue(ccrArticlePage.isTitleVisible(), "Article page header is not visible");
		String category = ccrArticlePage.getCategoryForPage().replace(" ", "-").toLowerCase();
		String subCategory = ccrArticlePage.getSubCategoryForPage().replace(" ", "-").toLowerCase();
		verifyBreadcrumbs(ccrArticlePage, category, subCategory);
		assertTrue(ccrArticlePage.isBylineVisible(), "Byline is not visible");
		assertTrue(ccrArticlePage.isLastUpdatedDateVisible(), "Last updated date is not visible");
		assertTrue(ccrArticlePage.isDeckVisible(), "Deck should be visible");
		assertTrue(ccrArticlePage.isHeroImageVisible(), "Hero image should be visible");
		if (Settings.isDesktop()) {
			assertTrue(ccrArticlePage.getHeroImageWidthValue() < 700, "Hero image width should be less than 700px");
		}
		assertTrue(ccrArticlePage.isHeroImageCaptionVisible(), "Photo caption is not visible");
		assertEquals(ccrArticlePage.getPhotoCaptionColor(), "rgba(51, 51, 51, 1)", "Photo caption color is incorrect");
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C231647"})
	@TestRail(id = "C231647")
	public void verifyCustomProgrammingCards() {
		ArticleBasePage ccrArticlePage = SiteNavigatorEH.goToCCRArticlePageEH(TemplatesEH.CCR_ARTICLE_CPCARD);
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77"), "events are incorrect");
		Logger.info("Verify 'More in' text and image");
		assertTrue(ccrArticlePage.isMoreInTextVisible(), "'More in' text is not visible");
		int contentCardCount = ccrArticlePage.getTotalNumberOfContentCards();
		assertEquals(contentCardCount, 3, "Custom programming card count is not 3");
		ccrArticlePage.scrollDownThePage();
		int numberOfPTCards = 0;
		for (int contentCardNumber = 1; contentCardNumber <= contentCardCount; contentCardNumber++) {
			Logger.info("Verifying content card description");
			String cardHref = ccrArticlePage.getContentCardHrefValue(contentCardNumber);
			assertTrue(ccrArticlePage.isContentCardImageContainsDataSource(contentCardNumber), "Data source is not available");
			assertTrue(ccrArticlePage.isContentCardContainHeader(contentCardNumber), "Content card Header not available");
			assertTrue(cardHref.startsWith("https://"), "Content card does not have href reference");
			if (cardHref.contains("/dashboard/my-daily")) {
				numberOfPTCards++;
				continue;
			}
			assertTrue(ccrArticlePage.isContentCardTypeIconNumberVisible(contentCardNumber - numberOfPTCards), "Content card type icon is not visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "ConditionCenter", "C216419"})
	@TestRail(id = "C216419")
	public void verifyDontMissThisArticles() {
		Logger.info("Verify Don't Miss this Articles in article page");
		ArticleBasePage ccrArticlePage = SiteNavigatorEH.goToCCRArticlePageEH(TemplatesEH.CCR_ARTICLE);
		assertTrue(ccrArticlePage.isDontMissThisSectionVisible(), "'Don't miss this' section is not visible");
		assertTrue(ccrArticlePage.isDontMissThisHeaderVisible(), "'Don't miss this' section header is not visible");
		assertEquals(ccrArticlePage.getNumberOfDontMissArticles(), 2, "Number of article is 'Don't miss this' section is not 2");
		assertEquals(ccrArticlePage.getNumberOfDontMissArticleImages(), ccrArticlePage.getNumberOfDontMissArticles(), "Each article should have image");
		assertEquals(ccrArticlePage.getNumberOfDontMissArticleTitles(), ccrArticlePage.getNumberOfDontMissArticles(), "Each article should have title");
		BasicPageEH page = ccrArticlePage.clickOnFirstDontMissThisArticle();
		assertFalse(page.getPageSource().contains("errorPage"), "Page contains errors");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "ConditionCenter", "C195546"})
	@TestRail(id = "C195546")
	public void verifySocialShareBar() {
		Logger.info("Verify Social bar and its options");
		ArticleBasePage ccrArticlePage = SiteNavigatorEH.goToCCRArticlePageEH(TemplatesEH.CCR_ARTICLE);
		SocialBarEH socialBar = ccrArticlePage.onSocialBar();
		assertTrue(socialBar.isSocialBarVisible(), "Social share bar is not visible");
		assertTrue(socialBar.isSocialShareCountVisible(), "Social share count is not visible");
		assertTrue(socialBar.isFacebookShareButtonVisible(), "Facebook share button is not visible");
		assertTrue(socialBar.isTwitterShareButtonVisible(), "Twitter share button is not visible");
		assertTrue(socialBar.isPinterestShareButtonVisible(), "Pinterest share button is not visible");
		assertTrue(socialBar.isEmailShareButtonVisible(), "Email share button is not visible");

		int expectedNumberOfCountableShareButtons = (Settings.isDesktop()) ? 5 : 4;
		assertEquals(socialBar.getNumberOfShareButtonsWithShareCountAttribute(), expectedNumberOfCountableShareButtons, "Number of countable share buttons is incorrect");

		String sharesNumberBeforeClicks = socialBar.getNumberOfShares();
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

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C216724"})
	@TestRail(id = "C216724")
	public void verifySocialShareBarOmniture() {
		Logger.info("Verify Social bar Omniture events");
		ArticleBasePage ccrArticlePage = SiteNavigatorEH.goToCCRArticlePageEH(TemplatesEH.CCR_ARTICLE);
		SocialBarEH socialBar = ccrArticlePage.onSocialBar();

		if (Settings.isDesktop()) {
			Logger.info("Verify Social bar Omniture events on facebook popup");
			socialBar.clickOnFacebookShareButton();
			socialBar.verifyFacebookPopUpContainsFacebook();
			assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event93"), "Incorrect event fired");
			verifyCCRArticleSocialShareOmnitureEvents();

			Logger.info("Verify Social bar Omniture events on twitter popup");
			socialBar.clickOnTwitterShareButton();
			socialBar.verifyTwitterPopUpContainsTwitter();
			assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event94"), "Incorrect event fired");
			verifyCCRArticleSocialShareOmnitureEvents();

			Logger.info("Verify Social bar Omniture events on pinterest popup");
			socialBar.clickOnPinterestShareButton();
			socialBar.verifyPinterestPopUpContainsPinterest();
			assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event96"), "Incorrect event fired");
			verifyCCRArticleSocialShareOmnitureEvents();

			if (Settings.browser.equals(framework.BrowserType.CHROME)) {
				Logger.info("Verify Social bar Omniture events on print popup");
				socialBar.clickPrintShareButton();
				assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event98"), "Incorrect event fired");
				verifyCCRArticleSocialShareOmnitureEvents();
			}
		}

		Logger.info("Verify Social bar Omniture events on email popup");
		ShareViaEmailPopUp shareViaEmailPopUp = socialBar.clickEmailShareButton();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event92"), "Incorrect event fired");
		verifyCCRArticleSocialShareOmnitureEvents();
		shareViaEmailPopUp.closePopUp();
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "ConditionCenter", "C204826"})
	@TestRail(id = "C204826")
	public void verifySaveLinkForNonLoggedUser() {
		ArticleBasePage ccrArticlePage = SiteNavigatorEH.goToCCRArticlePageEH(TemplatesEH.CCR_ARTICLE);
		verifySaveButtonFunctionalityForNonLoggedInUser(ccrArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "ConditionCenter", "C204827"})
	@TestRail(id = "C204827")
	public void verifySaveLinkForLoggedInUser() {
		ArticleBasePage ccrArticlePage = SiteNavigatorEH.goToCCRArticlePageEH(TemplatesEH.CCR_ARTICLE);
		verifySaveButtonFunctionalityForLoggedInUser(ccrArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C228057"})
	@TestRail(id = "C228057")
	public void verifyGulpIntegrationArticleCss() {
		String headerCSS;
		String footerCSS;
		Logger.info("Verify Article CSS");
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.CCR_ARTICLE);
		if (Settings.isEnvironment(Environment.PROD)) {
			headerCSS = "//content.everydayhealth.com/assets/everydayhealth/dist/styles/article3Head.css";
			footerCSS = "//content.everydayhealth.com/assets/everydayhealth/dist/scripts/article3videoFooter.js";
		} else {
			String env = Settings.config.getEnvironment().name().toLowerCase();
			headerCSS = "//content-" + env + ".everydayhealth.com/assets/everydayhealth/dist/styles/article3Head.css";
			System.out.println(headerCSS);
			footerCSS = "//content-" + env + ".everydayhealth.com/assets/everydayhealth/dist/scripts/article3videoFooter.js";
			System.out.println(footerCSS);
		}
		assertTrue(Utils.isPageSourceContains(headerCSS), "Article3.0 header did not built using gulp");
		assertTrue(Utils.isPageSourceContains(footerCSS), "Article3.0 footer did not built using gulp");
		assertEquals(Utils.getHttpResponseCode("http:" + headerCSS), 200, "Response is not 200");
		assertEquals(Utils.getHttpResponseCode("http:" + headerCSS), 200, "Response is not 200");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C326138"})
	@TestRail(id = "C326138")
	public void verifySmartNewsletterFunctionalityOnArticlePage() {
		ArticleBasePage ccrArticlePage = SiteNavigatorEH.goToCCRArticlePageEH(TemplatesEH.CCR_ARTICLE);

		verifySmartNewsletters(ccrArticlePage);
	}

	private void verifyCCRArticleSocialShareOmnitureEvents() {
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/brainnerves/multiplesclerosis"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc_2"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/brainnerves/multiplesclerosis"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc_2|/brainnerves/multiplesclerosis"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/multiple-sclerosis/living-with/six-steps-landing-dream-job-with-ms/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		//will be uncommented when click events will be handled
		//assertTrue(MarketingPixels.isOmnitureEventPresent("eVar29", "Sticky Social Share Bar"), "eVar29 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "article 3.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "neurology"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "multiple sclerosis"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "work"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
	}
}