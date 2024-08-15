package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.ArticleBasePage;
import everydayhealth.pages.articles.IGNPlayerPage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import framework.BrowserType;
import framework.Logger;
import framework.Settings;
import framework.platform.CookieName;
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
 * Article Video Test
 */
public class ArticleVideoTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "ArticleVideoTest", "C199545"})
	@TestRail(id = "C199545")
	public void verifyDontMissThisArticlesSection() {
		IGNPlayerPage videoArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_VIDEO_V3, IGNPlayerPage.class);
		if (!videoArticlePage.isCSZoneActive()) {
			assertTrue(videoArticlePage.isDontMissThisSectionVisible(), "'Don't miss this' section is not visible");
			assertTrue(videoArticlePage.isDontMissThisHeaderVisible(), "'Don't miss this' section header is not visible");
			int numberOfArticles = videoArticlePage.getNumberOfDontMissArticles();
			assertEquals(numberOfArticles, 2, "Number of article is 'Don't miss this' section is not 2");
			assertEquals(videoArticlePage.getNumberOfDontMissArticleImages(), numberOfArticles, "Each article should have image");
			assertEquals(videoArticlePage.getNumberOfDontMissArticleTitles(), numberOfArticles, "Each article should have title");
			BasicPageEH page = videoArticlePage.clickOnFirstDontMissThisArticle();
			assertFalse(page.getPageSource().contains("errorPage"), "Page contains errors");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "ArticleVideoTest", "C199546"})
	@TestRail(id = "C199546")
	public void verifySocialShareBar() {
		IGNPlayerPage videoArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_VIDEO_V3, IGNPlayerPage.class);
		SocialBarEH socialBar = videoArticlePage.onSocialBar();
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

		if (Settings.browser.equals(BrowserType.CHROME)) {
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

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "ArticleVideoTest", "C216719"})
	@TestRail(id = "C216719")
	public void verifySocialShareBarOmniture() {
		Logger.info("Verify Social bar Omniture events");
		IGNPlayerPage videoArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_VIDEO_V3, IGNPlayerPage.class);
		SocialBarEH socialBar = videoArticlePage.onSocialBar();

		Logger.info("Verify Social bar Omniture events on facebook popup");
		socialBar.clickOnFacebookShareButton();
		socialBar.verifyFacebookPopUpContainsFacebook();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event93"), "events are incorrect");
		verifyArticleVideoSocialShareOmnitureEvents();

		Logger.info("Verify Social bar Omniture events on twitter popup");
		socialBar.clickOnTwitterShareButton();
		socialBar.verifyTwitterPopUpContainsTwitter();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event94"), "events are incorrect");
		verifyArticleVideoSocialShareOmnitureEvents();

		Logger.info("Verify Social bar Omniture events on pinterest popup");
		socialBar.clickOnPinterestShareButton();
		socialBar.verifyPinterestPopUpContainsPinterest();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event96"), "events are incorrect");
		verifyArticleVideoSocialShareOmnitureEvents();

		if (Settings.browser.equals(framework.BrowserType.CHROME)) {
			Logger.info("Verify Social bar Omniture events on print popup");
			socialBar.clickPrintShareButton();
			assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event98"), "events are incorrect");
			verifyArticleVideoSocialShareOmnitureEvents();
		}

		Logger.info("Verify Social bar Omniture events on email popup");
		ShareViaEmailPopUp shareViaEmailPopUp = socialBar.clickEmailShareButton();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event92"), "events are incorrect");
		verifyArticleVideoSocialShareOmnitureEvents();
		shareViaEmailPopUp.closePopUp();
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "ArticleVideoTest", "C199544"})
	@TestRail(id = "C199544")
	public void verifyArticleVideoContent() {
		IGNPlayerPage videoArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_VIDEO_V3, IGNPlayerPage.class);

		String category = videoArticlePage.getCategoryForPage().replace(" ", "-").toLowerCase();
		String subCategory = videoArticlePage.getSubCategoryForPage().replace(" ", "-").toLowerCase();
		verifyBreadcrumbs(videoArticlePage, category, subCategory);

		assertTrue(videoArticlePage.isBylineVisible(), "Byline is not visible");
		assertTrue(videoArticlePage.isDeckVisible(), "Deck should be visible");
		assertTrue(videoArticlePage.isLastUpdatedDateVisible(), "Last updated date not visible");
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "ArticleVideoTest", "C216715"})
	@TestRail(id = "C216715")
	public void verifySaveLinkForNonLoggedUser() {
		Logger.info("Verify the Save link in Infographic page for non logged in user");
		IGNPlayerPage videoArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_VIDEO_V3, IGNPlayerPage.class);
		verifySaveButtonFunctionalityForNonLoggedInUser(videoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "ArticleVideoTest", "C216716"})
	@TestRail(id = "C216716")
	public void verifySaveLinkForLoggedInUser() {
		Logger.info("Verify the Save link in Article page for Logged in user");
		IGNPlayerPage videoArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_VIDEO_V3, IGNPlayerPage.class);
		verifySaveButtonFunctionalityForLoggedInUser(videoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleVideoTest", "C216426"})
	@TestRail(id = "C216426")
	public void verifyPrimaryVideo() {
		IGNPlayerPage ignPlayerPage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3_WITH_PRIMARY_VIDEO, IGNPlayerPage.class);
		assertTrue(ignPlayerPage.isIGNPlayerVisible(), "Video module (IGN player) should be visible");
		if (!Settings.isMobile()) {
			assertTrue(ignPlayerPage.getVideoModuleLocation() > ignPlayerPage.getLeader1AdBlockLocation(), "Video module should be below leader1 ad block");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleVideoTest", "C216428"})
	@TestRail(id = "C216428")
	public void verifyPrimaryVideoTertiaryImage() {
		IGNPlayerPage ignPlayerPage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3_WITH_PRIMARY_VIDEO_TERTIARY_IMAGE, IGNPlayerPage.class);
		assertTrue(ignPlayerPage.isIGNPlayerVisible(), "Video module (IGN player) should be visible");
		if (Settings.isMobile()) {
			assertFalse(ignPlayerPage.isTertiaryImageVisible(), "Tertiary image should not be visible");
		} else {
			assertTrue(ignPlayerPage.isTertiaryImageVisible(), "Tertiary image should be visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleVideoTest", "C326139"})
	@TestRail(id = "C326139")
	public void verifySmartNewsletterFunctionalityOnArticleVideoPage() {
		ArticleBasePage videoArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_VIDEO_V3, ArticleBasePage.class);
		verifySmartNewsletters(videoArticlePage);
	}

	private void verifyArticleVideoSocialShareOmnitureEvents() {
		Logger.info("Verifying social share bar omniture events");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/mentalhealth/emohealth"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc_2"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/mentalhealth/emohealth"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc_2|/mentalhealth/emohealth"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/emotional-health/0503/we-are-all-the-scream.aspx"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		//will be uncommented when click events will be handled
		//assertTrue(MarketingPixels.isOmnitureEventPresent("eVar29", "Sticky Social Share Bar"), "eVar29 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "article 3.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "emotional health"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
	}

	@Test(groups = {"EverydayHealthDesktop", "ArticleVideoTest", "C375118"})
	@TestRail(id = "C375118")
	public void verifyPrimaryIGNVideo() {
		IGNPlayerPage articleVideoPage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3_ECOMMERCE_WIDGET, IGNPlayerPage.class);

		verifyIGNSingleVideo(articleVideoPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "ArticleVideoTest", "C375457"})
	@TestRail(id = "C375457")
	public void verifyVideoWithQueryString() {
		IGNPlayerPage articleVideoPage = SiteNavigatorEH.openPage("/sanjay-gupta/aneurysm/how-dangerous-aneurysm/?autoplay&autopause&hideFullScreen&hidepreroll", IGNPlayerPage.class);

		verifyIGNVideoWithQueryString(articleVideoPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C671984"})
	@TestRail(id = "C671984")
	public void verifyRelatedWidgetElements() {
		ArticleBasePage articlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_VIDEO_V3, ArticleBasePage.class);
		assertTrue(articlePage.isRelatedContentWidgetVisible(), "Related content widget should be visible");
		assertFalse(articlePage.getRelatedContentWidgetHref().isEmpty(), "Related content widget should have valid URL in 'href'");
		assertTrue(articlePage.isRelatedContentWidgetImageVisible(), "Image should be visible on related content widget");
		assertTrue(articlePage.isRelatedContentWidgetTitleVisible(), "Related content widget should have title");
		assertTrue(articlePage.isRelatedContentWidgetDescriptionVisible(), "Related content widget should have description");
		assertTrue(articlePage.isRelatedContentWidgetEyebrowVisible(), "Related content widget should have eyebrow");
		assertEquals(articlePage.getWidgetBackgroundColor(), "#f6f6f6", "Related content widget should have grey background");
		articlePage.clickRelatedWidgetArticleLink();
		assertTrue(Utils.getCurrentURL().endsWith("?iid=content_widget"), "Opened URL should end with '?iid=content_widget'");
	}
}