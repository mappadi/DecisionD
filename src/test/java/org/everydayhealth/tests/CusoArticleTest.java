package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.CustomSolutionsTemplatePage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import framework.BrowserType;
import framework.Logger;
import framework.Settings;
import framework.platform.CookieName;
import framework.platform.Environment;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.StringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * CusoArticleTest
 */
public class CusoArticleTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleTest", "C199610"})
	@TestRail(id = "C199610")
	public void verifySocialShareBar() {
		CustomSolutionsTemplatePage cusoArticle = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE);
		verifySocialShareBarOnCusoArticlePage(cusoArticle);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleMLRTest", "C260067"})
	@TestRail(id = "C260067")
	public void verifySocialShareBarOnCusoArticleMLRPage() {
		//We don't have URLs live on prod, so excluding prod from execution - Murali confirms this
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			CustomSolutionsTemplatePage cusoArticle = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE_MLR);
			verifySocialShareBarOnCusoArticlePage(cusoArticle);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleTest", "C199611"})
	@TestRail(id = "C199611")
	public void verifyAtcPopover() {
		CustomSolutionsTemplatePage cusoArticlePage = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE);
		Logger.info("Verify cuso slideshow Atc('More Information' link) popover functionality");
		verifyATCWidgetFunctionality(cusoArticlePage, false, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleMLRTest", "C260068"})
	@TestRail(id = "C260068")
	public void verifyAtcPopoverOnCusoArticleMLRPage() {
		//We don't have URLs live on prod, so excluding prod from execution - Murali confirms this
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			CustomSolutionsTemplatePage cusoArticlePage = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE_MLR);
			verifyATCWidgetFunctionality(cusoArticlePage, false, true);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleTest", "C204577"})
	@TestRail(id = "C204577")
	public void verifyCusoArticleWidgets() {
		CustomSolutionsTemplatePage cusoArticlePage = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE);
		verifyWidgetsOnCusoArticlePage(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleMLRTest", "C260069"})
	@TestRail(id = "C260069")
	public void verifyCusoArticleMLRPageWidgets() {
		//We don't have URLs live on prod, so excluding prod from execution - Murali confirms this
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			CustomSolutionsTemplatePage cusoArticlePage = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE_MLR);
			verifyWidgetsOnCusoArticlePage(cusoArticlePage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleTest", "C231725"})
	@TestRail(id = "C231725")
	public void verifyCusoArticleIsiWidget() {
		CustomSolutionsTemplatePage cusoArticlePage = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE);
		verifyISIWidgets(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleMLRTest", "C260072"})
	@TestRail(id = "C260072")
	public void verifyCusoArticleMLRPageIsiWidget() {
		//We don't have URLs live on prod, so excluding prod from execution - Murali confirms this
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			CustomSolutionsTemplatePage cusoArticlePage = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE_MLR);
			verifyISIWidgets(cusoArticlePage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleTest", "C199608"})
	@TestRail(id = "C199608")
	public void verifyCusoArticleContent() {
		CustomSolutionsTemplatePage cusoArticlePage = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE);
		verifyCusoArticlePageContent(cusoArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleMLRTest", "C260066"})
	@TestRail(id = "C260066")
	public void verifyCusoArticleMLRPageContent() {
		//We don't have URLs live on prod, so excluding prod from execution - Murali confirms this
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			CustomSolutionsTemplatePage cusoArticlePage = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE_MLR);
			verifyCusoArticlePageContent(cusoArticlePage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleTest", "C298583"})
	@TestRail(id = "C298583")
	public void verifyCusoArticlePrimaryVideoSecondaryImage() {
		CustomSolutionsTemplatePage cusoArticlePage = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE);

		assertTrue(cusoArticlePage.isPrimaryImageVisible(), "Primary image should be visible");
		assertTrue(cusoArticlePage.isSecondaryImageVisible(), "Secondary image should be visible");
	}

	private void verifyCusoArticlePageContent(CustomSolutionsTemplatePage cusoArticlePage) {
		SocialBarEH socialBar = cusoArticlePage.onSocialBar();
		assertTrue(cusoArticlePage.isCusoHeaderTitleVisible(), "Title is not visible");
		assertTrue(cusoArticlePage.isCusoHeaderEyebrowVisible(), "Eyebrow is not visible");
		assertTrue(cusoArticlePage.isCusoHeaderSubnavVisible(), "Cuso header subnavigation is not visible");
		assertTrue(cusoArticlePage.isBylineVisible(), "Byline is not visible");
		assertTrue(cusoArticlePage.isReviewedByVisible(), "Reviewed by is not visible");
		assertTrue(socialBar.isSocialBarVisible(), "Social share bar is not visible");
		assertTrue(cusoArticlePage.isLastUpdatedDateVisible(), "Last updated date is not visible");
		assertTrue(cusoArticlePage.isDeckVisible(), "Article description should be visible");
		assertTrue(cusoArticlePage.isTitleVisible(), "Article headline should be visible");
		assertTrue(cusoArticlePage.isATCWidgetVisible(), "ATC widget should be visible");
		if (!Settings.isMobile()) {
			assertTrue(cusoArticlePage.isPromoSectionVisible(), "Promo section is not visible");
		}
		assertTrue(cusoArticlePage.isReadNextVisible(), "Read next is not visible");
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	private void verifySocialShareBarOnCusoArticlePage(CustomSolutionsTemplatePage cusoArticle) {
		SocialBarEH socialBar = cusoArticle.onSocialBar();
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

			if (Settings.browser.equals(BrowserType.CHROME)) {
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
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks for signing up!"), "Sent email message is not visible");
		shareViaEmailPopUp.closePopUp();
		socialBar.verifyNumberOfSharesIncreasedAfterClick(socialBar, sharesNumberBeforeClicks);
	}

	private void verifyWidgetsOnCusoArticlePage(CustomSolutionsTemplatePage cusoArticlePage) {
		verifyCusoHeaderWidget(cusoArticlePage, true);
		verifyReadNextWidget(cusoArticlePage);
		assertTrue(cusoArticlePage.isReadNextEyebrowVisible(), "Read next eyebrow should be visible");
		if (Settings.isDesktop()) {
			verifyPromoWidget(cusoArticlePage);
			verifyRelatedWidget(cusoArticlePage);
			verifyPatientSupportBar(cusoArticlePage);
		}
	}
}