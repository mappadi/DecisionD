package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.InfographicsPage;
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
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNotEquals;

/**
 * Infographics test
 */
public class InfographicsTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "InfographicsTest", "C198491"})
	@TestRail(id = "C198491")
	public void verifyRecommendedForYouOnInfographicPage() {
		InfographicsPage infographicsPage = SiteNavigatorEH.goToInfographicsPage(TemplatesEH.INFOGRAPHIC.getTemplateURL());
		assertFalse(infographicsPage.isRecommendedForYouSectionVisible(), "'Recommended For You' section is visible");
		infographicsPage.scrollDownThePage();
		assertTrue(infographicsPage.isBackToTopVisible(), "Back to top button is not visible");
		infographicsPage.clickBackToTopButton();
		assertFalse(infographicsPage.isRecommendedForYouSectionVisible(), "Skybox should not be visible");
		assertFalse(infographicsPage.isBackToTopVisible(), "'Top' button should not be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "InfographicsTest", "C198494"})
	@TestRail(id = "C198494")
	public void verifyFlyoutReadNext() {
		InfographicsPage infographicsPage = SiteNavigatorEH.goToInfographicsPage(TemplatesEH.INFOGRAPHIC.getTemplateURL());

		assertFalse(infographicsPage.isFlyoutVisible(), "Flyout should not be visible on page load");
		infographicsPage.scrollPageAndWaitForFlyoutVisibility();
		assertTrue(infographicsPage.isFlyoutVisible(), "Flyout should be visible");
		assertTrue(infographicsPage.isFlyoutArrowVisible(), "Flyout arrow should be visible");
		infographicsPage.flyoutMouseHover();
		assertTrue(infographicsPage.isFlyoutReadNextVisible(), "'Read next' title should be visible");
		assertEquals(infographicsPage.getFlyoutReadNextTitle(), "Read Next", "Flyout title should be 'READ NEXT'");
		assertTrue(infographicsPage.isFlyoutArticleTitleVisible(), "Article title should be visible");
		assertTrue(infographicsPage.isFlyoutArticleImageVisible(), "Article image should be visible in flyout on mouse hover");
		String beforeClickURL = Utils.getCurrentURL();
		infographicsPage.clickOnFlyout();
		assertNotEquals(Utils.getCurrentURL(), beforeClickURL, "Another page should be opened");
		assertFalse(Utils.isPageSourceContains("errorPage"), "Page contains errors");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "InfographicsTest", "C198496"})
	@TestRail(id = "C198496")
	public void verifyDontMissThisArticlesSection() {
		InfographicsPage infographicsPage = SiteNavigatorEH.goToInfographicsPage(TemplatesEH.INFOGRAPHIC.getTemplateURL());
		assertTrue(infographicsPage.isDontMissThisSectionVisible(), "'Don't miss this' section is not visible");
		assertTrue(infographicsPage.isDontMissThisHeaderVisible(), "'Don't miss this' section header is not visible");
		assertEquals(infographicsPage.getNumberOfDontMissArticles(), 2, "Number of article is 'Don't miss this' section is not 2");
		assertEquals(infographicsPage.getNumberOfDontMissArticleImages(), infographicsPage.getNumberOfDontMissArticles(), "Each article should have image");
		assertEquals(infographicsPage.getNumberOfDontMissArticleTitles(), infographicsPage.getNumberOfDontMissArticles(), "Each article should have title");
		BasicPageEH page = infographicsPage.clickOnFirstDontMissThisArticle();
		assertFalse(page.getPageSource().contains("errorPage"), "Page contains errors");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "InfographicsTest", "C198497"})
	@TestRail(id = "C198497")
	public void verifySocialShareBar() {
		InfographicsPage infographicsPage = SiteNavigatorEH.goToInfographicsPage(TemplatesEH.INFOGRAPHIC.getTemplateURL());
		SocialBarEH socialBar = infographicsPage.onSocialBar();
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

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "InfographicsTest", "C216712"})
	@TestRail(id = "C216712")
	public void verifySocialShareBarOmniture() {
		Logger.info("Verify Social bar Omniture events");
		InfographicsPage infographicsPage = SiteNavigatorEH.goToInfographicsPage(TemplatesEH.INFOGRAPHIC.getTemplateURL());
		SocialBarEH socialBar = infographicsPage.onSocialBar();

		if (Settings.isDesktop()) {
			Logger.info("Verify Social bar Omniture events on facebook popup");
			socialBar.clickOnFacebookShareButton();
			socialBar.verifyFacebookPopUpContainsFacebook();
			assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event93"), "events are incorrect");
			verifyInfographicsSocialShareOmnitureEvents();

			Logger.info("Verify Social bar Omniture events on twitter popup");
			socialBar.clickOnTwitterShareButton();
			socialBar.verifyTwitterPopUpContainsTwitter();
			assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event94"), "events are incorrect");
			verifyInfographicsSocialShareOmnitureEvents();

			Logger.info("Verify Social bar Omniture events on pinterest popup");
			socialBar.clickOnPinterestShareButton();
			socialBar.verifyPinterestPopUpContainsPinterest();
			assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event96"), "events are incorrect");
			verifyInfographicsSocialShareOmnitureEvents();

			if (Settings.browser.equals(framework.BrowserType.CHROME)) {
				Logger.info("Verify Social bar Omniture events on print popup");
				socialBar.clickPrintShareButton();
				assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event98"), "events are incorrect");
				verifyInfographicsSocialShareOmnitureEvents();
			}
		}

		Logger.info("Verify Social bar Omniture events on email popup");
		ShareViaEmailPopUp shareViaEmailPopUp = socialBar.clickEmailShareButton();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event92"), "events are incorrect");
		verifyInfographicsSocialShareOmnitureEvents();
		shareViaEmailPopUp.closePopUp();
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "InfographicsTest", "C198495"})
	@TestRail(id = "C198495")
	public void verifyInfographicsContent() {
		InfographicsPage infographicsPage = SiteNavigatorEH.goToInfographicsPage(TemplatesEH.INFOGRAPHIC.getTemplateURL());
		assertTrue(infographicsPage.isBylineVisible(), "Byline not visible");
		assertTrue(infographicsPage.isPinterestVisible(), "Pinterest not visible");
		assertTrue(infographicsPage.isLastUpdatedDateVisible(), "Last updated date not visible");
		assertEquals(infographicsPage.getRelatedLinksHeading(), "RELATED LINKS:", "Related links heading mismatch");
		assertTrue(infographicsPage.getVisibleRelatedLinksCount() > 0, "Related links not found");
		String category = infographicsPage.getCategoryForPage().replace(" & ", "-").toLowerCase();
		String subCategory = infographicsPage.getSubCategoryForPage().replace(" & ", "-").toLowerCase();
		verifyBreadcrumbs(infographicsPage, category, subCategory);
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "InfographicsTest", "C216708"})
	@TestRail(id = "C216708")
	public void verifySaveLinkForNonLoggedUser() {
		InfographicsPage infographicsPage = SiteNavigatorEH.goToInfographicsPage(TemplatesEH.INFOGRAPHIC.getTemplateURL());
		verifySaveButtonFunctionalityForNonLoggedInUser(infographicsPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "InfographicsTest", "C216709"})
	@TestRail(id = "C216709")
	public void verifySaveLinkForLoggedInUser() {
		Logger.info("Verify the Save link in Article page for Logged in user");
		InfographicsPage infographicsPage = SiteNavigatorEH.goToInfographicsPage(TemplatesEH.INFOGRAPHIC.getTemplateURL());
		verifySaveButtonFunctionalityForLoggedInUser(infographicsPage);
	}

	private void verifyInfographicsSocialShareOmnitureEvents() {
		Logger.info("Verifying social share bar omniture events");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/dietnutrition"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "inf"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/dietnutrition"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "inf|/generalwellness/dietnutrition"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/infographics/christmas-cookie-monster/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		//will be uncommented when click events will be handled
		//assertTrue(MarketingPixels.isOmnitureEventPresent("eVar29", "Sticky Social Share Bar"), "eVar29 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "infographic 2.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "diet &amp; nutrition"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "diet &amp; nutrition"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
	}
}