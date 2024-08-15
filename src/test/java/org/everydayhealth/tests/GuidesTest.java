package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.guides.GuidesBasePage;
import everydayhealth.pages.landingpages.MasterLandingPage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
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
import framework.platform.utilities.WindowUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

/**
 * GuidesTest
 */
public class GuidesTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "GuidesTest", "C204486"})
	@TestRail(id = "C204486")
	public void verifyGuidesSocialShareBar() {
		GuidesBasePage guidesPage = SiteNavigatorEH.goToPage(TemplatesEH.GUIDE, GuidesBasePage.class);

		verifySocialBarAndShareViaEmailFunctionality(guidesPage);

		assertTrue(guidesPage.getFacebookShareLink().contains("facebook"), "Facebook button link does not contain 'facebook'");
		assertTrue(guidesPage.getTwitterShareLink().contains("twitter"), "Twitter button link does not contain 'twitter'");
		assertTrue(guidesPage.getPinterestShareLink().contains("pinterest"), "Pinterest button link does not contain 'pinterest'");

	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "GuidesTest", "C204545"})
	@TestRail(id = "C204545")
	public void verifyGuidePageContent() {
		GuidesBasePage guidesPage = SiteNavigatorEH.goToPage(TemplatesEH.GUIDE, GuidesBasePage.class);

		int guideLinksCount = guidesPage.getGuideNavigationLinks();
		assertTrue(guideLinksCount > 0, "Guide navigation links are not present");
		if (!Settings.isDesktop()) {
			guideLinksCount = 2;
		}

		int numberOfNavLinks = guidesPage.getNumberOfGuideNavigationLinks();
		for (int link = 1; link <= numberOfNavLinks; link++) {
			assertFalse(guidesPage.isGuideNavigationHrefEmpty(link), "Navigation links 'href' attribute should not be empty");
		}
		String subCategory = guidesPage.getSubCategoryForPage().replace("'", "");
		assertEquals(guidesPage.getNumberOfBreadcrumbLinks(), 2, "2 links should be present in breadcrumb");
		assertEquals(guidesPage.getNumberOfBreadcrumbArrows(), 2, "2 arrows should be present in breadcrumb");
		assertEquals(guidesPage.getBreadcrumbHrefAttributeValue(1),
				Settings.getDefaultUrl() + "/",
				"First breadcrumb item should lead to homepage");
		assertTrue(guidesPage.getBreadcrumbHrefAttributeValue(2).contains(subCategory.replace(" ", "-").toLowerCase()),
				"Second breadcrumb item should lead to subcategory page");
		for (int guideLinkNumber = 1; guideLinkNumber <= guideLinksCount; guideLinkNumber++) {
			int currentArticleNumber = guidesPage.getActiveArticleNumber();
			Logger.info("Verifying guide page content on article number " + currentArticleNumber);
			assertEquals(currentArticleNumber, guideLinkNumber, "Wrong active guide number");

			if (guidesPage.isFirstGuidePage()) {
				verifyNextNavigation(guidesPage);
				assertFalse(guidesPage.isPreviousNavigationBlockVisible(), "Previous navigation block is visible");
			} else {
				verifyPreviousNavigation(guidesPage);
				if (guidesPage.isLastGuidePage()) {
					assertFalse(guidesPage.isNextNavigationBlockVisible(), "Next navigation block is visible");
				} else {
					verifyNextNavigation(guidesPage);
				}
			}

			verifyGuidePageContent(guidesPage);

			if (!guidesPage.isLastGuidePage()) {
				while (currentArticleNumber == guidesPage.getActiveArticleNumber()) {
					guidesPage.clickNextNavigation();
				}
			}
			if (!guidesPage.isNewsSectionVisible()) {
				verifySourcesSection(guidesPage);
			}
		}
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "GuidesTest", "C231649"})
	@TestRail(id = "C231649")
	public void verifyCustomProgrammingSection() {
		GuidesBasePage guidesPage = SiteNavigatorEH.goToPage(TemplatesEH.GUIDE, GuidesBasePage.class);
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77,event19"), "events are incorrect");
		int contentCardCount = guidesPage.getTotalNumberOfContentCards();
		assertEquals(contentCardCount, 3, "Content cards count is not 3");
		for (int contentCardNumber = 1; contentCardNumber <= contentCardCount; contentCardNumber++) {
			Logger.info("Verifying the " + (contentCardNumber) + " content card description");
			assertTrue(guidesPage.getContentCardHrefValue(contentCardNumber).startsWith("https://"), "Content card does not have href reference");
			assertTrue(guidesPage.isContentCardImageContainsDataSource(contentCardNumber), "Data source is not available");
			assertTrue(guidesPage.isContentCardContainHeader(contentCardNumber), "Content card Header not available");
			assertTrue(guidesPage.isContentCardTypeIconNumberVisible(contentCardNumber), "Content card should have type icon");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "GuidesTest", "C235089"})
	@TestRail(id = "C235089")
	public void verifyGuidesNewsPageContent() {
		GuidesBasePage guidesNewsPage = SiteNavigatorEH.goToPage(TemplatesEH.GUIDE_NEWS_PAGE, GuidesBasePage.class);

		int numberOfNavLinks = guidesNewsPage.getNumberOfGuideNavigationLinks();
		for (int link = 1; link <= numberOfNavLinks; link++) {
			assertFalse(guidesNewsPage.isGuideNavigationHrefEmpty(link), "Navigation links 'href' attribute should not be empty");
		}
		assertTrue(guidesNewsPage.isGuideNavigationBlockVisible(), "Guide navigation block should be visible");
		assertTrue(guidesNewsPage.isBreadcrumbVisible(), "Breadcrumb should be visible");
		assertTrue(guidesNewsPage.isGuideBrandingVisible(), "Guide branding should be visible");
		assertTrue(guidesNewsPage.isGuideConditionVisible(), "Guide condition should be visible");
		assertEquals(guidesNewsPage.getActiveLinkText(), guidesNewsPage.getTitleText(), "Wrong link chosen");
		if (Settings.isDesktop()) {
			int numberOfNews = guidesNewsPage.getNumberOfRelatedNews();
			for (int link = 0; link < numberOfNews; link++) {
				assertTrue(guidesNewsPage.isValidHyperlink(link), "Guide news link should be valid URL");
			}
			guidesNewsPage.clickMoreButton();
			int numberOfNewsAfterClick = guidesNewsPage.getNumberOfRelatedNews();
			assertTrue(numberOfNews < numberOfNewsAfterClick, "More related news should be visible");
			assertEquals(guidesNewsPage.getNumberOfTimestamps(), numberOfNewsAfterClick, "All news should have publish date");
		}

		assertTrue(Utils.getCurrentURL().replace("?isautomation=true", "").endsWith("/"), "Page URL should contain '/' symbol as the last one");

		if (Settings.isDesktop()) {
			verifySocialBarAndShareViaEmailFunctionality(guidesNewsPage);
		}
		verifyNextNavigation(guidesNewsPage);
		verifyPreviousNavigation(guidesNewsPage);
		guidesNewsPage.clickNextNavigation();
		assertTrue(guidesNewsPage.isGuideButtonVisible(), "Main MS page should be opened with visible 'Guide' button");
		MasterLandingPage masterLandingPage = guidesNewsPage.clickGuideButton();
		assertTrue(masterLandingPage.isJumpLinkVisible(),
				"User should land on Master Landing page. Jump links section should be visible");
	}

	private void verifyGuidePageContent(GuidesBasePage guidesPage) {
		verifyGuideNewsContent(guidesPage);
		if (!guidesPage.isNewsSectionVisible()) {
			verifyGuideNewsContent(guidesPage);
			assertTrue(guidesPage.isBylineVisible(), "Byline not visible");
			assertTrue(guidesPage.isReviewedByVisible(), "Reviewed by not visible");
			assertTrue(guidesPage.isDeckVisible(), "Deck not visible");
			assertTrue(guidesPage.isLastUpdatedDateVisible(), "Last updated date not visible");
		}
	}

	private void verifyGuideNewsContent(GuidesBasePage guidesPage) {
		assertTrue(guidesPage.isGuideArticleVisible(), "Guide article not visible");
		assertTrue(guidesPage.isBreadcrumbVisible(), "Breadcrumb not visible");
		assertTrue(guidesPage.isGuideBrandingVisible(), "Guide branding not visible");
		assertTrue(guidesPage.isGuideConditionVisible(), "Guide condition not visible");
		assertTrue(guidesPage.isTitleVisible(), "Headline not visible");
	}

	private void verifyNextNavigation(GuidesBasePage guidesPage) {
		guidesPage.scrollToNextNavigationBlock();
		assertTrue(guidesPage.isNextNavigationBlockVisible(), "Next navigation block is not visible");
		assertTrue(guidesPage.isNextNavigationArrowVisible(), "Next navigation arrow is not visible");
		assertTrue(guidesPage.isNextNavigationLabelVisible(), "Next navigation label is not visible");
		Logger.info("Verify if article on next navigation is same as next article in guide navigation");
		String articleOnNextNavigation = guidesPage.getNextNavigationArticle();
		String articleOnGuideNavigation = guidesPage.getGuideNavigationArticle(guidesPage.getActiveArticleNumber() + 1);
		assertTrue(articleOnNextNavigation.equalsIgnoreCase(articleOnGuideNavigation), "Article in next navigation mismatch with guide navigation article");
	}

	private void verifyPreviousNavigation(GuidesBasePage guidesPage) {
		assertTrue(guidesPage.isPreviousNavigationBlockVisible(), "Previous navigation block is not visible");
		assertTrue(guidesPage.isPreviousNavigationArrowVisible(), "Previous navigation arrow is not visible");
		assertTrue(guidesPage.isPreviousNavigationLabelVisible(), "Previous navigation label is not visible");
		Logger.info("Verify if article on previous navigation is same as previous article in guide navigation");
		String articleOnPreviousNavigation = guidesPage.getPreviousNavigationArticle();
		String articleOnGuideNavigation = guidesPage.getGuideNavigationArticle(guidesPage.getActiveArticleNumber() - 1);
		assertTrue(articleOnPreviousNavigation.equalsIgnoreCase(articleOnGuideNavigation), "Article in previous navigation mismatch with guide navigation article");
	}

	private void verifySourcesSection(GuidesBasePage guidesPage) {
		assertTrue(guidesPage.isSourcesHeaderVisible(), "Sources Header is not visible");
		assertTrue(guidesPage.isSourcesSectionVisible(), "Sources section is not visible");
		int elementCount = guidesPage.getCountOfSourceSectionLinks();
		Logger.info("Getting the Link Text and href links associated with it");
		for (int elementNumber = 1; elementNumber <= elementCount; elementNumber++) {
			assertTrue(guidesPage.getSourceSectionHref(elementNumber).startsWith("http"), "Link does not have href");
		}
	}

	private void verifySocialBarAndShareViaEmailFunctionality(GuidesBasePage guidesPage) {
		assertTrue(guidesPage.isSocialShareBarVisible(), "Social share bar is not visible");
		assertTrue(guidesPage.isEmailShareButtonVisible(), "Email share button is not visible");
		assertTrue(guidesPage.isPrintShareButtonVisible(), "Print share button is not visible");
		guidesPage.shareButtonHover();
		assertTrue(guidesPage.isFacebookShareButtonVisible(), "Facebook share button is not visible");
		assertTrue(guidesPage.isTwitterShareButtonVisible(), "Twitter share button is not visible");
		assertTrue(guidesPage.isPinterestShareButtonVisible(), "Pinterest share button is not visible");

		guidesPage.shareButtonHover();
		guidesPage.clickFacebookShareButton();
		WindowUtils.switchToLastOpenedWindow();
		assertTrue(Utils.currentUrlContains("facebook.com"), "Current URL does not contain 'facebook.com'");
		WindowUtils.switchToMainWindow();

		guidesPage.shareButtonHover();
		guidesPage.clickTwitterShareButton();
		WindowUtils.switchToLastOpenedWindow();
		assertTrue(Utils.currentUrlContains("twitter.com"), "Current URL does not contain 'twitter.com'");
		WindowUtils.switchToMainWindow();

		guidesPage.shareButtonHover();
		guidesPage.clickPinterestShareButton();
		WindowUtils.switchToLastOpenedWindow();
		assertTrue(Utils.currentUrlContains("pinterest.com"), "Current URL does not contain 'pinterest.com'");
		WindowUtils.switchToMainWindow();

		ShareViaEmailPopUp shareViaEmailPopUp = guidesPage.clickEmailShareButton();
		shareViaEmailPopUp.typeYourEmailFriendEmailAndSend(UserCacheEH.MAIN_USER.getEmail(), StringUtils.generateRandomEmail());
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks! Your email was sent"), "Sent email message is not visible");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyVisible(), "'Privacy Policy' is not visible");
		assertEquals(shareViaEmailPopUp.getPrivacyPolicyLinkText(), "Privacy Policy", "'Privacy Policy' text is not present");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyLinkPresent(), "'Privacy Policy' link is not present");
		shareViaEmailPopUp.clickSignUpButton();
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks for signing up!"), "'Thanks for signing up!' message is not visible");
		shareViaEmailPopUp.closePopUp();
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "GuidesTest", "C505416"})
	@TestRail(id = "C505416")
	public void verifyPromoBannerSectionOnGuidesPage() {
		GuidesBasePage guidesPage = SiteNavigatorEH.goToPage(TemplatesEH.GUIDE, GuidesBasePage.class);

		verifyPromoBannerSection(guidesPage);
	}
}