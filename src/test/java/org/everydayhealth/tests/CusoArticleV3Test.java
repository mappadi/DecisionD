package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.CusoArticleV3Page;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * CusoArticleV3Test
 */
public class CusoArticleV3Test extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "C265637"})
	@TestRail(id = "C265637")
	public void verifySocialShareBarOnCusoArticleV3MLRPage() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3MLRPage();
		verifySocialShareBarFunctionality(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoArticleV3Test", "C339159"})
	@TestRail(id = "C339159")
	public void verifySocialShareBar() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3Page();
		verifySocialShareBarFunctionality(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "C265621"})
	@TestRail(id = "C265621")
	public void verifyNewsletterWidgetPositiveOnCusoArticleV3MLRPage() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3MLRPage();
		verifyNewsletterFunctionalityPositive(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3Test", "C339156"})
	@TestRail(id = "C339156")
	public void verifyNewsletterWidgetPositive() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3Page();
		verifyNewsletterFunctionalityPositive(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "C265622"})
	@TestRail(id = "C265622")
	public void verifyNewsletterWidgetNegativeOnCusoArticleV3MLRPage() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3MLRPage();
		verifyNewsletterFunctionalityNegative(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3Test", "C339157"})
	@TestRail(id = "C339157")
	public void verifyNewsletterWidgetNegative() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3Page();
		verifyNewsletterFunctionalityNegative(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "C265630"})
	@TestRail(id = "C265630")
	public void verifyInlineRegistrationOnCusoV3MLRPage() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3MLRPage();
		verifySaveButtonFunctionalityForLoggedInUser(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoArticleV3Test", "C339158"})
	@TestRail(id = "C339158")
	public void verifyInlineRegistrationOnCusoV3Page() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3Page();
		verifySaveButtonFunctionalityForNonLoggedInUser(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "C265937"})
	@TestRail(id = "C265937")
	public void verifyWidgetsOnCusoArticleV3MLRPage() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3MLRPage();
		verifyWidgetsOnCusoArticlePage(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3Test", "C339161"})
	@TestRail(id = "C339161")
	public void verifyWidgetsOnCusoArticleV3Page() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3Page();
		verifyWidgetsOnCusoArticlePage(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "C266859"})
	@TestRail(id = "C266859")
	public void verifyATCSectionOnMLRPage() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3MLRPage();
		verifyATCWidgetFunctionality(cusoArticlePage, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3Test", "C339162"})
	@TestRail(id = "C339162")
	public void verifyATCSection() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3Page();
		verifyATCWidgetFunctionality(cusoArticlePage, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "C266860"})
	@TestRail(id = "C266860")
	public void verifyPullquoteAndKeyTakeawaysOnMLRPage() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3MLRPage();
		verifyPullQuotesAndKeyTakeawaysOnCusoArticleV3Page(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3Test", "C339163"})
	@TestRail(id = "C339163")
	public void verifyPullquoteAndKeyTakeaways() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3Page();
		verifyPullQuotesAndKeyTakeawaysOnCusoArticleV3Page(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "C266942"})
	@TestRail(id = "C266942")
	public void verifyBackToTopButtonFuctionalityOnMLRPage() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3MLRPage();
		verifyBackToTopFunctionality(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3Test", "C339164"})
	@TestRail(id = "C339164")
	public void verifyBackToTopButtonFuctionality() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3Page();
		verifyBackToTopFunctionality(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "C339740"})
	@TestRail(id = "C339740")
	public void verifyCusoArticleMLRPageElements() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3MLRPage();
		verifyCusoArticleV3PageElements(cusoArticlePage, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3Test", "C339171"})
	@TestRail(id = "C339171")
	public void verifyCusoArticlePageElements() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToCusoArticleV3Page();
		verifyCusoArticleV3PageElements(cusoArticlePage, false);
	}

	private void verifyCusoArticleV3PageElements(CusoArticleV3Page cusoArticleV3Page, boolean isMLR) {
		assertTrue(cusoArticleV3Page.isBreadcrumbVisible(), "Breadcrumb should be visible");
		assertTrue(cusoArticleV3Page.isTitleVisible(), "Title should be visible");
		assertTrue(cusoArticleV3Page.isDeckVisible(), "Article description should be visible");
		assertTrue(cusoArticleV3Page.isBylineVisible(), "Byline should be visible");
		assertTrue(cusoArticleV3Page.isMedicalReviewVisible(), "Medical review should be visible");
		assertTrue(cusoArticleV3Page.isLastUpdatedDateVisible(), "Last updated should be visible");
		boolean isPrimaryVideoPresent = cusoArticleV3Page.isIGNPlayerVisible();
		if (isPrimaryVideoPresent) {
			assertTrue(cusoArticleV3Page.isIGNPlayerVisible(), "Video module should be visible");
		} else {
			assertTrue(cusoArticleV3Page.isHeroImageVisible(), "If primary video is missing - hero image should be visible");
		}
		assertTrue(cusoArticleV3Page.isHeroImageCreditVisible(), "Image credit should be visible");
		assertTrue(cusoArticleV3Page.isHeroImageCaptionVisible(), "Image caption should be visible");
		assertFalse(cusoArticleV3Page.getPhotoCreditHrefValue().isEmpty(), "Image credit 'href' attribute value should not be empty");
		assertFalse(cusoArticleV3Page.getPhotoCaptionHrefValue().isEmpty(), "Image caption 'href' attribute value should not be empty");

		assertTrue(cusoArticleV3Page.isMoreInSectionVisible(), "'More in...' section should be visible");
		assertTrue(cusoArticleV3Page.isMoreInTextVisible(), "'More in...' section headline should be visible");
		assertTrue(cusoArticleV3Page.isMoreInCategoryLinkVisible(), "Category link should be visible in 'More in...' sectin headline");
		int numberOfContentCards = cusoArticleV3Page.getTotalNumberOfContentCards();
		assertEquals(numberOfContentCards, 3, "3 content cards should be visible");
		assertEquals(cusoArticleV3Page.getNumberOfContentCardHeaders(), 3, "Each content card should have header");
		assertEquals(cusoArticleV3Page.getNumberOfContentCardWithImage(), 3, "Each content card should have image");
		assertEquals(cusoArticleV3Page.getNumberOfVisibleContentCardTypeIcons(), 3, "Each content card should have type icon");

		int mediaLocation = isPrimaryVideoPresent ? cusoArticleV3Page.getVideoModuleLocation() : cusoArticleV3Page.getHeroImageYCoordinateValue();
		int headlineSectionYCoordinate = cusoArticleV3Page.getHeadlineBlockYCoordinateValue();
		assertTrue(headlineSectionYCoordinate < mediaLocation, "Headline section should be below video module");
		if (isPrimaryVideoPresent) {
			assertEquals(cusoArticleV3Page.getIGNPlayerWidth(), 710, "Video module width should be 710px");
		} else {
			assertEquals(cusoArticleV3Page.getHeroImageWidthValue(), 710, "Hero image width should be 710px");
		}

		String category = cusoArticleV3Page.getCategoryForPage().toLowerCase();
		String subCategory = cusoArticleV3Page.getSubCategoryForPage().replace(" ", "-").toLowerCase();
		verifyBreadcrumbs(cusoArticleV3Page, category, subCategory);
		assertTrue(cusoArticleV3Page.isRelatedContentWidgetVisible(), "Related content widget should be visible");
		assertFalse(cusoArticleV3Page.getRelatedContentWidgetHref().isEmpty(), "Related content widget should have valid URL in 'href'");
		assertTrue(cusoArticleV3Page.isRelatedContentWidgetImageVisible(), "Image should be visible on related content widget");
		assertTrue(cusoArticleV3Page.isRelatedContentWidgetTitleVisible(), "Related content widget should have title");
		assertTrue(cusoArticleV3Page.isRelatedContentWidgetDescriptionVisible(), "Related content widget should have description");
		assertTrue(cusoArticleV3Page.isRelatedContentWidgetEyebrowVisible(), "Related content widget should have eyebrow");
		assertEquals(cusoArticleV3Page.getWidgetBackgroundColor(), "#f6f6f6", "Related content widget should have grey background");
		cusoArticleV3Page.clickRelatedWidgetArticleLink();
		assertTrue(Utils.getCurrentURL().endsWith("?iid=content_widget"), "Opened URL should end with '?iid=content_widget'");

	}

	private void verifyNewsletterFunctionalityPositive(CusoArticleV3Page cusoArticlePage) {
		verifyNewsletterWidgetElements(cusoArticlePage);
		cusoArticlePage.enterEmailAndSubmit(StringUtils.generateRandomEmail());
		assertTrue(cusoArticlePage.verifyNewsletterModuleSuccessMessage(), "Subscription confirmation message not visible");
	}

	private void verifyNewsletterFunctionalityNegative(CusoArticleV3Page cusoArticlePage) {
		verifyNewsletterWidgetElements(cusoArticlePage);
		cusoArticlePage.enterEmailAndSubmit("");
		assertTrue(cusoArticlePage.verifyNewsletterWarningMessageText(), "Subscription confirmation message not visible");
		cusoArticlePage.waitUntilWarningMessageDisappear();
		cusoArticlePage.enterEmailAndSubmit(StringUtils.generateRandomStrAlphabetic(10));
		assertTrue(cusoArticlePage.verifyNewsletterWarningMessageText(), "Subscription confirmation message not visible");
	}

	private void verifyNewsletterWidgetElements(CusoArticleV3Page cusoArticlePage) {
		assertTrue(cusoArticlePage.isNewsLetterEmailBoxVisible(), "Newsletter email box not visible");
		assertTrue(cusoArticlePage.isNewsLetterSubmitButtonVisible(), "Newsletter Submit button not visible");
		assertTrue(cusoArticlePage.isNewsletterModulePrivacyLinkVisible(), "Newsletter Privacy link not visible");
		assertTrue(cusoArticlePage.isNewsLetterModulePrivacyLinkValid(), "Newsletter Privacy link does not contain href");
	}

	private void verifySocialShareBarFunctionality(CusoArticleV3Page cusoArticlePage) {
		SocialBarEH socialBar = cusoArticlePage.onSocialBar();
		assertTrue(socialBar.isSocialBarVisible(), "Social share bar should be visible");
		assertTrue(socialBar.isSocialShareCountVisible(), "Social share count should be visible");
		assertTrue(socialBar.isFacebookShareButtonVisible(), "'Facebook' share button should be visible");
		assertTrue(socialBar.isTwitterShareButtonVisible(), "'Twitter' share button should be visible");
		assertTrue(socialBar.isPinterestShareButtonVisible(), "'Pinterest' share button should be visible");
		assertTrue(socialBar.isEmailShareButtonVisible(), "'Email' share button should be visible");
		if (Settings.isDesktop()) {
			assertTrue(socialBar.isPrintShareButtonVisible(), "'Print' share button should be visible");
		}

		assertEquals(socialBar.getNumberOfShareButtonsWithShareCountAttribute(), (Settings.isDesktop()) ? 5 : 4, "Number of countable share buttons is incorrect");

		String sharesNumberBeforeClicks = socialBar.getNumberOfShares();
		if (Settings.isDesktop()) {
			assertEquals(sharesNumberBeforeClicks, socialBar.getSumOfSharesFromSocialShareButtons(true), "Number of shares in not equal sum of shares");
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

	private void verifyBackToTopFunctionality(CusoArticleV3Page cusoArticlePage) {
		cusoArticlePage.scrollDownThePage();
		if (!Settings.isMobile()) {
			assertTrue(cusoArticlePage.isBackToTopVisible(), "'Back to top' button should be visible");
			cusoArticlePage.clickBackToTopButton();
		}
		assertFalse(cusoArticlePage.isBackToTopVisible(), "'Back to top' button should not be visible");
	}

	private void verifyPullQuotesAndKeyTakeawaysOnCusoArticleV3Page(CusoArticleV3Page cusoArticlePage) {
		if (Settings.isMobile()) {
			assertFalse(cusoArticlePage.isPullQuoteVisible(), "Pull quote should be visible");
			assertFalse(cusoArticlePage.isKeyTakeAwaysVisible(), "Key takeaways section should be visible");
		} else {
			assertTrue(cusoArticlePage.isPullQuoteVisible(), "Pull quote should be visible");
			assertTrue(cusoArticlePage.isPullQuoteGreenBorderVisible(), "Green border line should be visible on the left border");
			assertTrue(cusoArticlePage.isPullQuoteTwitterLinkVisible(), "Pull quote Twitter link should be visible");
			assertTrue(cusoArticlePage.isKeyTakeAwaysVisible(), "Key takeaways section should be visible");
			assertTrue(cusoArticlePage.getKeyTakeAwaysNotesCount() > 0, "Key takeaways notes should be present in Key takeaways section");
		}
	}

	private void verifyWidgetsOnCusoArticlePage(CusoArticleV3Page cusoArticlePage) {
		if (!Settings.isMobile()) {
			assertTrue(cusoArticlePage.isKeyTakeAwaysVisible(), "'Key takeaways' section should be visible");
			assertTrue(cusoArticlePage.isPromoWidgetVisible(), "Promo widget is not visible");
		}
		verifyISIWidgets(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoArticleV3Test", "C432232"})
	@TestRail(id = "C432232")
	public void verifyECommerceWidgetFunctionality() {
		CusoArticleV3Page articlePage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_ARTICLE_V3_MLR, CusoArticleV3Page.class);

		verifyECommerceModule(articlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "CusoArticleV3Test", "C678402"})
	@TestRail(id = "C678402")
	public void verifyPrimaryIGNVideo() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_ARTICLE_V3, CusoArticleV3Page.class);

		verifyIGNSingleVideo(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "CusoArticleV3Test", "C678405"})
	@TestRail(id = "C678405")
	public void verifyVideoWithQueryString() {
		CusoArticleV3Page cusoArticlePage = SiteNavigatorEH.openPage("/testpage/pr-636445257866940357/?nocache=true&dsrsre&autoplay&autopause&hideFullScreen&hidepreroll", CusoArticleV3Page.class);

		verifyIGNVideoWithQueryString(cusoArticlePage);
	}
}
