package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import everydayhealth.pages.articles.SlideshowBasePage;
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
 * SlideshowV3Test
 */
public class SlideshowV3Test extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SlideshowV3", "C235516"})
	@TestRail(id = "C235516")
	public void verifyDontMissThisSlideshowSection() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());
		if (!slideshowPage.isCSZoneActive()) {
			boolean isDontMissThisSectionVisible = slideshowPage.isDontMissThisSectionVisible();
			assertTrue(isDontMissThisSectionVisible, "'Don't miss this' section is not visible");
			assertTrue(slideshowPage.isDontMissThisHeaderVisible(), "'Don't miss this' section header is not visible");
			assertEquals(slideshowPage.getNumberOfDontMissArticles(), 2, "Number of article in 'Don't miss this' section is not 2");
			assertEquals(slideshowPage.getNumberOfDontMissArticleImages(), slideshowPage.getNumberOfDontMissArticles(), "Each article should have image");
			assertEquals(slideshowPage.getNumberOfDontMissArticleTitles(), slideshowPage.getNumberOfDontMissArticles(), "Each article should have title");
			BasicPageEH page = slideshowPage.clickOnFirstDontMissThisArticle();
			assertFalse(page.getPageSource().contains("errorPage"), "Page contains errors");
		}
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			//https://discuss.appium.io/t/driver-manage-getcookienamed-cookiename-is-not-working/10230
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "SlideshowV3", "C235517"})
	@TestRail(id = "C235517")
	public void verifySocialShareBar() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());
		SocialBarEH socialBar = slideshowPage.onSocialBar();
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

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SlideshowV3", "C235519"})
	@TestRail(id = "C235519")
	public void verifyNewsletterWidgetPositive() {
		Logger.info("Newsletter widget Positive test");
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());
		assertTrue(slideshowPage.isNewsLetterEmailBoxVisible(), "Newsletter email box not visible");
		assertTrue(slideshowPage.isNewsLetterSubmitButtonVisible(), "Newsletter Submit button not visible");
		assertTrue(slideshowPage.isNewsletterModulePrivacyLinkVisible(), "Newsletter Privacy link not visible");
		assertTrue(slideshowPage.isNewsLetterModulePrivacyLinkValid(), "Newsletter Privacy link does not contain href");
		slideshowPage.enterEmailAndSubmit(StringUtils.generateRandomEmail());
		assertTrue(slideshowPage.verifyNewsletterModuleSuccessMessage(), "Subscription confirmation message not visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SlideshowV3", "C235520"})
	@TestRail(id = "C235520")
	public void verifyNewsletterWidgetNegative() {
		Logger.info("Newsletter widget Negative test");
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());
		slideshowPage.enterEmailAndSubmit("");
		assertTrue(slideshowPage.verifyNewsletterWarningMessageText(), "Subscription confirmation message not visible");
		slideshowPage.waitUntilWarningMessageDisappear();
		slideshowPage.enterEmailAndSubmit(StringUtils.generateRandomStrAlphabetic(10));
		assertTrue(slideshowPage.verifyNewsletterWarningMessageText(), "Subscription confirmation message not visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SlideshowV3", "C235518"})
	@TestRail(id = "C235518")
	public void verifyNextSlideshowFunction() {
		Logger.info("Verify next slideshow functionality on last slide");
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());
		while (!slideshowPage.isLastSlide()) {
			slideshowPage.clickNextSlideArrow();
			if (slideshowPage.isInterstialAdVisible()) {
				slideshowPage.skipInterstialAd();
			}
		}
		assertTrue(slideshowPage.isLastSlide(), "Last slide not visible");
		if (Settings.isDesktop()) {
			assertTrue(slideshowPage.isNextSlideshowThumbnailVisible(), "Next slide thumbnail is not visible");
			assertTrue(slideshowPage.isNextSlideshowTitleVisible(), "Next slide title is not visible");
		}
		String nextSlideshowLink = slideshowPage.getNextSlideshowLink();
		slideshowPage.clickNextSlideshowLink();
		assertEquals(nextSlideshowLink, Utils.getCurrentURL(), "Next slideshow link and actual page URL are different");
		slideshowPage.clickBackBrowserButton(SlideshowBasePage.class);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SlideshowV3", "C235512"})
	@TestRail(id = "C235512")
	public void slideshowFunctionality() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());

		String category = slideshowPage.getCategoryForPage().replace(" & ", "-").toLowerCase();
		String subCategory = slideshowPage.getSubCategoryForPage().replace(" & ", "-").toLowerCase();
		verifyBreadcrumbs(slideshowPage, category, subCategory);

		assertTrue(slideshowPage.isTitleVisible(), "Slide title not visible");
		assertTrue(slideshowPage.isBylineVisible(), "Byline not visible");
		assertTrue(slideshowPage.isSlideLastUpdatedDateVisible(), "Last updated date not visible");

		Logger.info("Page forward through the slideshow using the next arrow and verify content on each slide");
		while (!slideshowPage.isLastSlide()) {
			if (slideshowPage.isPreInterstialSlide()) {
				Logger.info("Verify interstial ads are visible after 4th and before last slide");
				verifySlideContent(slideshowPage);
				slideshowPage.clickNextSlideArrow();
				assertTrue(slideshowPage.isInterstialAdVisible(), "Interstial ad not visible");
				slideshowPage.skipInterstialAd();
			}
			verifySlideContent(slideshowPage);
			if (!slideshowPage.isLastSlide()) {
				slideshowPage.clickNextSlideArrow();
			}
		}

		assertTrue(slideshowPage.isLastSlide(), "Last slide not visible");

		Logger.info("Page Backward through the slideshow using the previous arrow till the first slide");
		slideshowPage.scrollPage(0);
		do {
			if (slideshowPage.isLastSlide()) {
				Logger.info("Interstial ads should not be visible while page backward");
				slideshowPage.clickPreviousSlideArrow();
				assertFalse(slideshowPage.isInterstialAd2Visible(), "Interstial ad visible");
			}
			if (slideshowPage.getCurrentSlideNumber() == 5) {
				Logger.info("Interstial ads should not be visible while page backward");
				slideshowPage.clickPreviousSlideArrow();
				assertFalse(slideshowPage.isAdDiv7Visible(), "Interstial ad 1 should not be visible");
			}
			slideshowPage.clickPreviousSlideArrow();
		} while (!slideshowPage.isFirstSlide());
		assertTrue(slideshowPage.isFirstSlide(), "This is not first slide");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SlideshowV3", "C235513"})
	@TestRail(id = "C235513")
	public void slideshowGridViewFunctionality() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());
		Logger.info("Click on View all to verify slides displayed in grid view");
		slideshowPage.clickTriggerGridView();
		assertTrue(slideshowPage.isGridViewVisible(), "Grid view not visible");
		int slideCount = slideshowPage.getTotalSlideCount();
		assertEquals(slideshowPage.getGridViewImagesVisibleCount(), slideCount, "Grid view images not visible");
		assertEquals(slideshowPage.getNumberOfClickableGridViewImages(), slideCount, "Number of clickable images in Grid view should be equal to number of slides");
		assertEquals(slideshowPage.getGridImageTitlesVisibleCount(), slideCount, "Grid view image titles are not visible");

		Logger.info("Verify grid image is clickable and if chosen will send user back to that slide");
		slideshowPage.clickGridImage(4);
		slideshowPage.waitForSlideshowView();
		assertEquals(slideshowPage.getCurrentSlideNumber(), 4, "Grid to slide navigation failed");

		Logger.info("Verify Back to gallery button takes user back to slideshow view");
		slideshowPage.clickTriggerGridView();
		assertTrue(slideshowPage.isGridViewVisible(), "Grid view not visible");
		slideshowPage.clickBackToGallery();
		slideshowPage.waitForSlideshowView();
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "SlideshowV3", "C239199"})
	@TestRail(id = "C239199")
	public void verifySaveLinkForNonLoggedUser() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());
		verifySaveButtonFunctionalityForNonLoggedInUser(slideshowPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "SlideshowV3", "C239197"})
	@TestRail(id = "C239197")
	public void verifySaveLinkForLoggedInUser() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());
		verifySaveButtonFunctionalityForLoggedInUser(slideshowPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SlideshowV3", "C266824"})
	@TestRail(id = "C266824")
	public void verifyCustomProgrammingCard() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW_WITH_CP_CARDS.getTemplateURL());
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77,event19"), "events are incorrect");
		int contentCardCount = slideshowPage.getTotalNumberOfContentCards();
		assertEquals(contentCardCount, 3, "Content cards count is not 3");
		int numberOfPTCards = 0;
		for (int contentCardNumber = 1; contentCardNumber <= contentCardCount; contentCardNumber++) {
			Logger.info("Verifying content card description");
			String cardHref = slideshowPage.getContentCardHrefValue(contentCardNumber);
			assertTrue(slideshowPage.isContentCardImageContainsDataSource(contentCardNumber), "Data source is not available");
			assertTrue(slideshowPage.isContentCardContainHeader(contentCardNumber), "Content card Header not available");
			assertTrue(cardHref.startsWith("https://"), "Content card does not have href reference");
			if (cardHref.contains("/dashboard/my-daily")) {
				numberOfPTCards++;
				continue;
			}
			assertTrue(slideshowPage.isContentCardTypeIconNumberVisible(contentCardNumber - numberOfPTCards), "Content card type icon is not visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SlideshowV3", "C375543"})
	@TestRail(id = "C375543")
	public void verifyNativeAdOnSlideshowPage() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());
		assertTrue(slideshowPage.isNativeAdVisible(), "Native ad should be visible");
		if (Settings.isDesktop()) {
			assertEquals(slideshowPage.getNativeAdHeight(), 90, "Native ad height should be 90px");
			assertEquals(slideshowPage.getNativeAdWidth(), 300, "Native ad width should be 300px");
			assertTrue(Utils.isPageSourceContains("adDiv99"), "Page source should contain 'adDiv99' string");
			if (slideshowPage.isProgrammedNativeAd()) {
				assertTrue(slideshowPage.isProgrammedNativeAdImageVisible(), "Native ad thumbnail image should be visible");
				assertTrue(slideshowPage.isProgrammedNativeAdTitleVisible(), "Native ad title should be visible");
				assertTrue(slideshowPage.isProgrammedNativeAdLabelVisible(), "'Ad' label should be visible on native ad");
			} else {
				slideshowPage.switchToNativeAdIFrame();
				assertTrue(slideshowPage.isNativeAdImageVisible(), "Native ad thumbnail image should be visible");
				assertTrue(slideshowPage.isNativeAdTitleVisible(), "Native ad title should be visible");
				assertTrue(slideshowPage.isNativeAdAdchoiceIconVisible(), "'AdChoice' icon should be visible on native ad");
				assertTrue(slideshowPage.isNativeAdLabelVisible(), "'Ad' label should be visible on native ad");
			}
		}
	}

	private void verifySlideContent(SlideshowBasePage slideshowPage) {
		SocialBarEH socialBar = slideshowPage.onSocialBar();
		if (slideshowPage.isFirstSlide()) {
			Logger.info("Verifying slide content on slide number : 1");
			assertFalse(slideshowPage.isPrevSlideArrowVisible(), "Previous slide arrow visible on first slide");
		} else {
			Logger.info("Verifying slide content on slide number : " + slideshowPage.getCurrentSlideNumber());
			assertTrue(slideshowPage.isPrevSlideArrowVisible(), "Previous slide arrow not visible");
		}

		if (slideshowPage.isLastSlide()) {
			assertFalse(slideshowPage.isNextSlideArrowVisible(), "Next slide arrow visible on last slide");
		} else {
			assertTrue(slideshowPage.isNextSlideArrowVisible(), "Next slide arrow not visible");
		}
		if (Settings.isTablet()) {
			assertTrue(slideshowPage.isSlideHeadlineForTabletVisible(), "Slide headline not visible");
		} else {
			assertTrue(slideshowPage.isSlideHeadlineVisible(), "Slide headline not visible");
		}
		assertTrue(slideshowPage.isSlideImageVisible(), "Slide image not visible");
		assertTrue(slideshowPage.isPinterestVisible(), "Pinterest icon is not visible");
		if (!Settings.isMobile()) {
			assertTrue(socialBar.isSocialBarVisible(), "Social share bar not visible");
		}
		assertTrue(slideshowPage.isTriggerGridViewVisible(), "Trigger grid view not visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SlideshowV3", "C376035"})
	@TestRail(id = "C376035")
	public void verifyGoogleMatchContentsOnSlideshowPage() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());

		assertEquals(slideshowPage.getGMcontentCardAdSlot(), "7241951542", "Google match content section ad slot should be 7241951542");
		verifyGoogleMatchedContent(slideshowPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SlideshowV3", "C384193"})
	@TestRail(id = "C384193")
	public void verifyLatestArticlesModuleOnSlideshowPage() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());

		verifyLatestArticlesModule(slideshowPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SlideshowV3", "C505434"})
	@TestRail(id = "C505434")
	public void verifyPromoBannerSectionOnSlideshowPage() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());

		verifyPromoBannerSection(slideshowPage);
	}
}