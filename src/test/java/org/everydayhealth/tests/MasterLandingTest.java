package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;

import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import everydayhealth.pages.articles.IGNPlayerPage;
import everydayhealth.pages.landingpages.MasterLandingPage;
import framework.BrowserType;
import framework.Logger;
import framework.Settings;
import framework.platform.Environment;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.StringUtils;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MasterLandingTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C348612"})
	@TestRail(id = "C348612")
	public void verifyIntroElements() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();
		assertTrue(masterLandingPage.isBylineVisible(), "Byline was not visible");
		assertTrue(masterLandingPage.isSectionInViewPort(1), "Intro Section should be in view port");
		String category = masterLandingPage.getCategoryForPage().toLowerCase();
		String subCategory = masterLandingPage.getSubCategoryForPage().toLowerCase();
		verifyBreadcrumbs(masterLandingPage, category, subCategory);
		assertTrue(masterLandingPage.isJumpLinkVisible(), "JumpLink element should be visible");
		assertTrue(masterLandingPage.isTitleVisible(), "Title was not visible");
		assertTrue(masterLandingPage.isFeaturedPromoSectionVisible(), "Featured Promo was not  visible");
		if (!Settings.isMobile()) {
			assertTrue(masterLandingPage.getNumberOfRelatedContentCards() >= 1,
					"At least one related content card should be visible on page");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C348613"})
	@TestRail(id = "C348613")
	public void verifyAds() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();
		assertTrue(masterLandingPage.isAdDiv5Visible(), "AdTile5 was not Visible");
		assertTrue(masterLandingPage.isAdDiv7Visible(), "AdTile7 was not Visible");
		assertTrue(masterLandingPage.isAdDiv9Visible(), "AdTile9 was not Visible");
		if (!Settings.isMobile()) {
			assertTrue(masterLandingPage.isTopAdVisible(), "AdTile1 was not Visible");
			assertTrue(masterLandingPage.isBottomAdVisible(), "AdTile11 was not Visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C348614"})
	@TestRail(id = "C348614")
	public void verifyJumpLinks() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();
		int numberOfJumpLinks = masterLandingPage.getNumberOfJumpLinks();
		Logger.info("Number of jump links: " + numberOfJumpLinks);
		assertTrue(numberOfJumpLinks >= 1, "There should be at least 1 jumplink on the page");
		for (int section = 1; section <= numberOfJumpLinks; section++) {
			masterLandingPage.clickJumpLinks(section);
			assertTrue(masterLandingPage.isSectionInViewPort(section), "Section is not in view port");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C349746"})
	@TestRail(id = "C349746")
	public void verifyContinueReading() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();
		int numberOfContinueReading = masterLandingPage.getNumberOfContinueReading();
		Logger.info("# of Continue Reading Sections: " + numberOfContinueReading);
		assertTrue(numberOfContinueReading >= 1, "There should be at least 1 continue reading on the page");
		for (int section = 1; section <= numberOfContinueReading; section++) {
			masterLandingPage.clickContinueReading(section);
			assertTrue(masterLandingPage.isSectionInViewPort(section + 1), "Continue reading was not displayed");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C349853"})
	@TestRail(id = "C349853")
	public void verifyWidgets() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();
		int numberOfFeaturedPromos = masterLandingPage.getNumberOfVisibleFeaturedPromoSections();
		Logger.info("# of Feature Promo sections" + ":" + numberOfFeaturedPromos);
		assertTrue(numberOfFeaturedPromos >= 1, "There should be at least 1 featured promo on the page");
		for (int section = 1; section <= numberOfFeaturedPromos; section++) {
			assertTrue(masterLandingPage.getFeaturedPromoSectionItemHref(section).startsWith("https"));
			assertTrue(masterLandingPage.isFeaturedPromoSectionImageVisible(section), "Image was not visible");
			assertTrue(masterLandingPage.isFeaturedPromoSectionTagVisible(section),
					"The Tag section is not visible in Featured Promo section");
			assertTrue(masterLandingPage.isFeaturedPromoSectionTitleVisible(section),
					"The featured text is not visible in featured promo section");
			if (!Settings.isMobile()) {
				assertTrue(masterLandingPage.isFeaturedPromoSectionDeckVisible(section),
						"The Dek is not visible in the featured promo section");
			}
		}
		int numberOfLinkList = masterLandingPage.getNumberOfVisibleLinkListSections();
		Logger.info("# of Linklist sections" + ":" + numberOfLinkList);
		assertTrue(numberOfLinkList >= 1, "There should be at least 1 linklist section on the page");
		for (int section = 1; section <= numberOfLinkList; section++) {
			int numberOfLinks = masterLandingPage.getNumberOfLinksInLinkList(section);
			for (int link = 1; link <= numberOfLinks; link++)
				assertFalse(masterLandingPage.getLinklistLinkHrefAttributeValue(section, link).isEmpty(),
						"'href' value should not be empty");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C375423"})
	@TestRail(id = "C375423")
	public void verifyRelatedWidgets() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();
		if (!Settings.isMobile()) {
			int numberOfRelatedWidgetsWithCards = masterLandingPage.getNumberOfRelatedWidgetWithCard();
			assertTrue(numberOfRelatedWidgetsWithCards > 0, "Related Widget Card not visible");
			Logger.info("# of Related Widgets with card" + ":" + numberOfRelatedWidgetsWithCards);
			int numberOfCards = masterLandingPage.getRelatedWidgetWithCardItemCount();
			for (int widgetCard = 1; widgetCard <= numberOfCards; widgetCard++) {
				assertTrue(masterLandingPage.isRelatedWidgetWithCardItemImageVisible(widgetCard), "Related Widget card Image was not displayed");
				assertTrue(masterLandingPage.isRelatedWidgetWithCardItemTitleVisible(widgetCard), "Related Widget card Title was not displayed");
			}
		}
		int numberOfRelatedWidgetWithLink = masterLandingPage.getNumberOfRelatedWidgetWithLink();
		assertTrue(numberOfRelatedWidgetWithLink > 0, "Related Widget with link not visible");
		Logger.info("# of Related Widgets with Links" + ":" + numberOfRelatedWidgetWithLink);
		int numberOfItems = masterLandingPage.getRelatedWidgetWithLinkItemCount();
		for (int widgetItem = 1; widgetItem <= numberOfItems; widgetItem++) {
			assertTrue(masterLandingPage.isRelatedWidgetWithLinkItemBodyVisible(widgetItem), "Related Widget link body was not displayed");
			assertTrue(masterLandingPage.isRelatedWidgetWithLinkItemImageVisible(widgetItem), "Related Widget link image was not displayed");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C349747"})
	@TestRail(id = "C349747")
	public void verifyMostRecentAndHorizontalPromoSections() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();
		int numberOfPromos = masterLandingPage.getNumberOfVisibleHorizontalPromoSections();
		Logger.info("# of Horizontal sections" + ": " + numberOfPromos);
		assertEquals(numberOfPromos, 3, "3 horizontal promo sections should be visible");
		for (int promo = 1; promo <= numberOfPromos; promo++) {
			int numberOfCards = masterLandingPage.getNumberOfCardsInHorizontalPromo(promo);
			Logger.info("Number of cards in horizontal promo #" + promo + " is - " + numberOfCards);
			for (int card = 1; card <= numberOfCards; card++) {
				String cardHref = masterLandingPage.getHorizontalPromoSectionCardHrefValue(promo, card);
				Logger.info("Card #" + card + " href - " + cardHref);
				assertFalse(cardHref.isEmpty(), "'href' should not be empty");
			}
		}
		int numberOfViewAll = masterLandingPage.getNumberOfViewAllSections();
		Logger.info("# of View All" + ":" + numberOfViewAll);
		assertEquals(numberOfViewAll, 3, "View all was not visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C349748"})
	@TestRail(id = "C349748")
	public void verifyNlSection() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();
		verifyNewsletterWidgetFunctionality(masterLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "MasterLanding", "C349792"})
	@TestRail(id = "C349792")
	public void verifySSO() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();
		SocialBarEH socialBar = masterLandingPage.onSocialBar();
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

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C376037"})
	@TestRail(id = "C376037")
	public void verifyGoogleMatchContentsOnMasterLandingPage() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();

		assertEquals(masterLandingPage.getGMcontentCardAdSlot(), "4331001144", "Google match content section ad slot should be 4331001144");
		verifyGoogleMatchedContent(masterLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C384191"})
	@TestRail(id = "C384191")
	public void verifyLatestArticlesModuleOnMasterLandingPage() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();

		verifyLatestArticlesModule(masterLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "MasterLanding", "C671985"})
	@TestRail(id = "C671985")
	public void verifyAOLPlayerOnMasterLandingPage() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();
			verifyAOLPlayerFunctionality(masterLandingPage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C672598"})
	@TestRail(id = "C672598")
	public void verifyECommerceWidgetFunctionality() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();

		verifyECommerceModule(masterLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterLanding", "C505432"})
	@TestRail(id = "C505432")
	public void verifyPromoBannerSectionOnMasterLandingPage() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();

		verifyPromoBannerSection(masterLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "MasterLanding", "C678403"})
	@TestRail(id = "C678403")
	public void verifyPrimaryIGNVideo() {
		IGNPlayerPage masterLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.MASTER_LANDING_PAGE, IGNPlayerPage.class);

		verifyIGNMultipleVideos(masterLandingPage);
	}
}