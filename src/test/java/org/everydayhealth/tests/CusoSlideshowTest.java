package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.CustomSolutionsTemplatePage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import everydayhealth.pages.articles.SlideshowBasePage;
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
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * CusoSlideshowTest
 */
public class CusoSlideshowTest extends WidgetsBaseTest {


	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowTest", "C198079"})
	@TestRail(id = "C198079")
	public void verifySocialShareBar() {
		SlideshowBasePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, SlideshowBasePage.class);
		verifySocialBar(cusoSlideshowPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowMLRTest", "C260078"})
	@TestRail(id = "C260078")
	public void verifySocialShareBarOnCusoSlideshowMLRPage() {
		//We don't have URLs live on prod, so excluding prod from execution - Murali confirms this
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			SlideshowBasePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW_MLR, SlideshowBasePage.class);
			verifySocialBar(cusoSlideshowPage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowTest", "C198077"})
	@TestRail(id = "C198077")
	public void cusoSlideshowFunctionality() {
		SlideshowBasePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, SlideshowBasePage.class);
		verifySlideshowFunctionality(cusoSlideshowPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowMLRTest", "C260076"})
	@TestRail(id = "C260076")
	public void cusoSlideshowFunctionalityOnCusoSlideshowMLRPage() {
		//We don't have URLs live on prod, so excluding prod from execution - Murali confirms this
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			SlideshowBasePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW_MLR, SlideshowBasePage.class);
			verifySlideshowFunctionality(cusoSlideshowPage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowTest", "C198078"})
	@TestRail(id = "C198078")
	public void cusoSlideshowGridViewFunctionality() {
		SlideshowBasePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, SlideshowBasePage.class);
		verifySlideshowGridView(cusoSlideshowPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowMLRTest", "C260077"})
	@TestRail(id = "C260077")
	public void cusoSlideshowGridViewFunctionalityMLRPage() {
		//We don't have URLs live on prod, so excluding prod from execution - Murali confirms this
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			SlideshowBasePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW_MLR, SlideshowBasePage.class);
			verifySlideshowGridView(cusoSlideshowPage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowTest", "C198087"})
	@TestRail(id = "C198087")
	public void verifyAtcPopover() {
		SlideshowBasePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, SlideshowBasePage.class);
		Logger.info("Verify cuso slideshow Atc('More Information' link) popover functionality");
		verifyATCWidgetFunctionality(cusoSlideshowPage, false, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowMLRTest", "C260079"})
	@TestRail(id = "C260079")
	public void verifyAtcPopoverOnCusoSlideshowMLRPage() {
		//We don't have URLs live on prod, so excluding prod from execution - Murali confirms this
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			SlideshowBasePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW_MLR, SlideshowBasePage.class);
			verifyATCWidgetFunctionality(cusoSlideshowPage, false, true);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowTest", "C204603"})
	@TestRail(id = "C204603")
	public void verifyCusoSlideshowWidgets() {
		CustomSolutionsTemplatePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, CustomSolutionsTemplatePage.class);
		verifyCusoSlideshowPageWidgets(cusoSlideshowPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowMLRTest", "C260080"})
	@TestRail(id = "C260080")
	public void verifyCusoSlideshowMLRPageWidgets() {
		//We don't have URLs live on prod, so excluding prod from execution - Murali confirms this
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			CustomSolutionsTemplatePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW_MLR, CustomSolutionsTemplatePage.class);
			verifyCusoSlideshowPageWidgets(cusoSlideshowPage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowTest", "C231736"})
	@TestRail(id = "C231736")
	public void verifyCusoSlideshowISIWidget() {
		CustomSolutionsTemplatePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, CustomSolutionsTemplatePage.class);
		verifyISIWidgets(cusoSlideshowPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowMLRTest", "C260083"})
	@TestRail(id = "C260083")
	public void verifyCusoSlideshowMLRPageISIWidget() {
		//We don't have URLs live on prod, so excluding prod from execution - Murali confirms this
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			CustomSolutionsTemplatePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW_MLR, CustomSolutionsTemplatePage.class);
			verifyISIWidgets(cusoSlideshowPage);
		}
	}

	private void verifySocialBar(SlideshowBasePage cusoSlideshowPage) {
		SocialBarEH socialBar = cusoSlideshowPage.onSocialBar();
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
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks for signing up!"), "Sent email message is not visible");
		shareViaEmailPopUp.closePopUp();
		socialBar.verifyNumberOfSharesIncreasedAfterClick(socialBar, sharesNumberBeforeClicks);
	}

	private void verifySlideshowFunctionality(SlideshowBasePage cusoSlideshowPage) {
		Logger.info("Page forward through the cuso slideshow using the next arrow and verify content on each slide");
		while (!cusoSlideshowPage.isLastSlide()) {
			if (cusoSlideshowPage.isPreInterstialSlide()) {
				Logger.info("Verify interstial ads are visible after 4th slide");
				verifySlideContent(cusoSlideshowPage);
				cusoSlideshowPage.clickNextSlideArrow();
				assertTrue(cusoSlideshowPage.isInterstialAdVisible(), "Interstial ad not visible");
				cusoSlideshowPage.skipCusoInterstialAd();
			}
			verifySlideContent(cusoSlideshowPage);
			if (!cusoSlideshowPage.isLastSlide()) {
				cusoSlideshowPage.clickNextSlideArrow();
			}
		}

		assertTrue(cusoSlideshowPage.isLastSlide(), "Last slide not visible");

		Logger.info("Page Backward through the cuso slideshow using the previous arrow till the first slide");
		cusoSlideshowPage.scrollPage(0);
		do {
			if (cusoSlideshowPage.getCurrentSlideNumber() == 5) {
				Logger.info("Interstial ads should not be visible while page backward");
				cusoSlideshowPage.clickPreviousSlideArrow();
				assertFalse(cusoSlideshowPage.isInterstialAdVisible(), "Interstial ad visible");
			}
			cusoSlideshowPage.clickPreviousSlideArrow();
		} while (!cusoSlideshowPage.isFirstSlide());
		assertTrue(cusoSlideshowPage.isFirstSlide(), "This is not first slide");
	}

	private void verifySlideContent(SlideshowBasePage cusoSlideshowPage) {
		SocialBarEH socialBar = cusoSlideshowPage.onSocialBar();
		if (cusoSlideshowPage.isFirstSlide()) {
			Logger.info("Verifying slide content on slide number : 1");
			assertFalse(cusoSlideshowPage.isPrevSlideArrowVisible(), "Previous slide arrow should not be visible on the first slide");
		} else {
			Logger.info("Verifying slide content on slide number : " + cusoSlideshowPage.getCurrentSlideNumber());
			assertTrue(cusoSlideshowPage.isPrevSlideArrowVisible(), "Previous slide arrow is not visible");
		}

		if (cusoSlideshowPage.isLastSlide()) {
			assertFalse(cusoSlideshowPage.isNextSlideArrowVisible(), "Next slide arrow should not be visible on the last slide");
		} else {
			assertTrue(cusoSlideshowPage.isNextSlideArrowVisible(), "Next slide arrow is not visible");
		}

		if (Settings.isDesktop()) {
			Logger.info("X-coordinate of Social share bar < X-coordinate of slideshow image  to make sure -> Social share bar is on left of slideshow image");
			assertTrue(socialBar.getSocialShareBarXCoordinate() < cusoSlideshowPage.getSlideshowImageXCoordinate(), "Social share bar is not on left of slideshow image");
		}

		assertTrue(cusoSlideshowPage.isTitleVisible(), "Slide title is not visible");
		assertTrue(cusoSlideshowPage.isSlideHeadlineVisible(), "Slide headline is not visible");
		assertTrue(cusoSlideshowPage.isSlideImageVisible(), "Slide image is not visible");
		assertTrue(cusoSlideshowPage.isPinterestVisible(), "Pinterest icon is not visible");
		assertTrue(socialBar.isSocialBarVisible(), "Social share bar is not visible");
		assertTrue(cusoSlideshowPage.isTriggerGridViewVisible(), "Trigger grid view is not visible");
		assertTrue(cusoSlideshowPage.getSlideCount().startsWith(cusoSlideshowPage.getActiveSlideId()), "Active slide number and slide count are not same");

		assertTrue(cusoSlideshowPage.isBylineVisible(), "Byline is not visible");
		assertTrue(cusoSlideshowPage.isReviewedByVisible(), "Reviewed by is not visible");
		assertTrue(cusoSlideshowPage.isATCWidgetVisible(), "ATC widget is not visible");
		assertTrue(cusoSlideshowPage.isCusoSlideLastUpdatedDateVisible(), "Last updated date is not visible");
	}

	private void verifySlideshowGridView(SlideshowBasePage cusoSlideshowPage) {
		Logger.info("Click on View all to verify slides displayed in grid view");
		cusoSlideshowPage.clickTriggerGridView();
		assertTrue(cusoSlideshowPage.isGridViewVisible(), "Grid view not visible");
		int slideCount = cusoSlideshowPage.getTotalSlideCount();
		assertEquals(cusoSlideshowPage.getGridViewImagesVisibleCount(), slideCount, "Number of slide images in Grid view should be equal to total number of slides");
		assertEquals(cusoSlideshowPage.getNumberOfClickableGridViewImages(), slideCount, "Number of clickable images in Grid view should be equal to number of slides");
		assertEquals(cusoSlideshowPage.getGridImageTitlesVisibleCount(), slideCount, "Number of slide titles in Grid view should be equal to total number of slides");

		Logger.info("Verify grid image is clickable and if chosen will send user back to that slide");
		cusoSlideshowPage.clickGridImage(4);
		cusoSlideshowPage.waitForSlideshowView();
		assertEquals(cusoSlideshowPage.getCurrentSlideNumber(), 4, "Grid to slide navigation failed");

		Logger.info("Verify Back to gallery button takes user back to slideshow view");
		cusoSlideshowPage.clickTriggerGridView();
		assertTrue(cusoSlideshowPage.isGridViewVisible(), "Grid view not visible");
		cusoSlideshowPage.clickBackToGallery();
		cusoSlideshowPage.waitForSlideshowView();
	}

	private void verifyCusoSlideshowPageWidgets(CustomSolutionsTemplatePage cusoSlideshowPage) {
		verifyCusoHeaderWidget(cusoSlideshowPage, true);
		verifyReadNextWidget(cusoSlideshowPage);
		assertTrue(cusoSlideshowPage.getNumberOfVisibleReadNextEyebrows() > 0, "Eyebrows in 'Read next' section should be present");
		if (Settings.isDesktop()) {
			verifyPromoWidget(cusoSlideshowPage);
			verifyRelatedWidget(cusoSlideshowPage);
			verifyPatientSupportBar(cusoSlideshowPage);
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}
}