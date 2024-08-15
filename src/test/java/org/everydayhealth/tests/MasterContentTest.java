package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.landingpages.MasterContentPage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import everydayhealth.pages.share.SocialBarEH;
import framework.Logger;
import framework.Settings;
import framework.platform.Environment;
import framework.platform.SiteNavigatorEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.StringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * MasterContentTest
 */
public class MasterContentTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterContentTest", "C376030"})
	@TestRail(id = "C376030")
	public void verifyHeadlineElements() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		String category = masterContentPage.getCategoryForPage().replace(" & ", "-").toLowerCase();
		String subCategory = masterContentPage.getSubCategoryForPage().replace(" ", "-").toLowerCase();
		verifyBreadcrumbs(masterContentPage, category, subCategory);

		assertTrue(masterContentPage.isTitleVisible(), "Title should be visible (in h1 tag)");
		assertTrue(masterContentPage.isBylineVisible(), "Byline should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterContentTest", "C376031"})
	@TestRail(id = "C376031")
	public void verifyTextBlocks() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		int numberOfTextBlocks = masterContentPage.getNumberOfTextContentSections();
		for (int title = 2; title <= numberOfTextBlocks; title++) { //skip 1st headline as it is not added in PUSH
			assertTrue(masterContentPage.isContentSectionTitleVisible(title), "Each text content section should have title");
		}

		Logger.info("Verify jump links navigation");
		int numberOfJumpLinks = masterContentPage.getNumberOfJumpLinks();
		assertEquals(numberOfJumpLinks, numberOfTextBlocks - 1, "Each text section should have jump link except the first one");
		for (int section = 1; section < numberOfTextBlocks; section++) {
			masterContentPage.clickJumpLinks(section);
			assertTrue(masterContentPage.isSectionInViewPort(section), "Corresponding section should appear in view port");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterContentTest", "C376032"})
	@TestRail(id = "C376032")
	public void verifyHorizontalPromoSection() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		int horizontalPromosCount = masterContentPage.getNumberOfVisibleHorizontalPromoSections();
		assertTrue(horizontalPromosCount >= 1, "At least one horizontal promo section should be visible on page");
		for (int promoSection = 1; promoSection <= horizontalPromosCount; promoSection++) {
			int numberOfCards = Settings.isMobile() ? 3 : 4;//EHF-770
			assertEquals(masterContentPage.getNumberOfCardsInHorizontalPromo(promoSection),
					numberOfCards,
					"Horizontal promo section should contain " + numberOfCards + " cards");
			assertTrue(masterContentPage.isHorizontalPromoSectionTitleVisible(promoSection),
					"Each horizontal promo section should have title");
			assertTrue(masterContentPage.isHorizontalPromoSectionViewAllLinkVisible(promoSection),
					"Each horizontal promo section should have 'View all' link");
			for (int card = 1; card <= numberOfCards; card++) {
				assertTrue(masterContentPage.isHorizontalPromoSectionCardImageVisible(promoSection, card),
						"Each horizontal promo section card should have image");
				assertTrue(masterContentPage.isHorizontalPromoSectionCardTitleVisible(promoSection, card),
						"Each horizontal promo section card should have title");
				assertFalse(masterContentPage.getHorizontalPromoSectionCardHrefValue(promoSection, card).isEmpty(),
						"Each horizontal promo section card should have non-empty 'href'");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterContentTest", "C376033"})
	@TestRail(id = "C376033")
	public void verifyFeaturedPromoSection() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		int featuredPromosCount = masterContentPage.getNumberOfVisibleFeaturedPromoSections();
		assertTrue(featuredPromosCount >= 1, "At least one featured promo section should be visible on page");
		for (int promoSection = 1; promoSection <= featuredPromosCount; promoSection++) {
			assertTrue(masterContentPage.isFeaturedPromoSectionImageVisible(promoSection),
					"Each featured promo section should have image");
			assertTrue(masterContentPage.isFeaturedPromoSectionTagVisible(promoSection),
					"Each featured promo section should have tag");
			assertTrue(masterContentPage.isFeaturedPromoSectionTitleVisible(promoSection),
					"Each featured promo section should have title");
			if (!Settings.isMobile()) {
				assertTrue(masterContentPage.isFeaturedPromoSectionDeckVisible(promoSection),
						"Each featured promo section should have deck");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterContentTest", "C376038"})
	@TestRail(id = "C376038")
	public void verifyLinkListComponent() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		assertEquals(masterContentPage.getNumberOfVisibleLinkListSections(), 1, "At least one link list section should be visible");
		assertTrue(masterContentPage.isLinkListSectionTitleVisible(1), "Link list section should have visible title");
		int numberOfLinks = masterContentPage.getNumberOfLinksInLinkList(1);
		assertTrue(numberOfLinks > 1 && numberOfLinks <= 12, "Link list section should have more than 2 links");

		assertTrue(masterContentPage.isPullQuoteVisible(), "Pull quote component should be visible");
		assertTrue(masterContentPage.isPullQuoteTextVisible(), "Pull quote text should be visible");
		assertFalse(masterContentPage.getPullQuoteText().isEmpty(), "Pull quote should have some text");
		assertTrue(masterContentPage.isPullQuoteSocialBarIconVisible(), "Pull quote social bar icon should be visible");
		assertFalse(masterContentPage.isPullQuoteSocialBarVisible(), "Social bar should not be visible");
		masterContentPage.clickPullQuoteSocialBarOpenIcon();
		assertTrue(masterContentPage.isPullQuoteSocialBarVisible(), "Social bar should be visible");
		assertEquals(masterContentPage.getNumberOfSocialLinks(), 3, "3 social links should be present on pull quote social bar");
		assertTrue(masterContentPage.getSocialIconHrefAttributeValue(1).contains("facebook.com"), "1st social link should lead to facebook.com");
		assertTrue(masterContentPage.getSocialIconHrefAttributeValue(2).contains("twitter.com"), "2nd social link should lead to twitter.com");
		assertTrue(masterContentPage.getSocialIconHrefAttributeValue(3).contains("pinterest.com"), "3rd social link should lead to pinterest.com");
		assertTrue(masterContentPage.isPullQuoteSocialBarCloseIconVisible(), "Close icon should be visible on social bar");
		masterContentPage.clickPullQuoteSocialBarCloseIcon();
		assertFalse(masterContentPage.isPullQuoteSocialBarVisible(), "Pull quote social bar should not be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterContentTest", "C376040"})
	@TestRail(id = "C376040")
	public void verifySourcesComponent() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		assertTrue(masterContentPage.isSourcesElementVisible(), "Sources element should be visible");
		assertTrue(masterContentPage.isSourcesSeeMoreLinkVisible(), "'See more' link should be visible under sources");
		assertFalse(masterContentPage.isSourcesContentVisible(), "Sources content should not be visible");
		assertTrue(masterContentPage.isSourcesTitleVisible(), "Sources title should be visible");
		assertEquals(masterContentPage.getSourcesTitleText(), "Editorial Sources and Fact-Checking", "Incorrect sources title");
		masterContentPage.clickSourcesSeeMoreLink();
		assertTrue(masterContentPage.isSourcesContentVisible(), "Sources content should be visible");
		assertTrue(masterContentPage.getSourcesContentText().contains("References"), "Sources content should contain 'References' text");
		assertTrue(masterContentPage.getSourcesContentText().contains("Sources"), "Sources content should contain 'Sources' text");
		masterContentPage.clickSourcesSeeMoreLink();
		assertFalse(masterContentPage.isSourcesContentVisible(), "Sources content should not be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterContentTest", "C384141"})
	@TestRail(id = "C384141")
	public void verifyLatestArticlesModuleOnMasterContentPage() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		verifyLatestArticlesModule(masterContentPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterContentTest", "C376041"})
	@TestRail(id = "C376041")
	public void verifyNewsletterWidgetFunctionality() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		verifyNewsletterWidgetFunctionality(masterContentPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "MasterContentTest", "C376042"})
	@TestRail(id = "C376042")
	public void verifySocialShareBarFunctionality() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		SocialBarEH socialBar = masterContentPage.onSocialBar();
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

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "MasterContentTest", "C376043"})
	@TestRail(id = "C376043")
	public void verifySaveButtonFunctionalityForNonLoggedInUser() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		verifySaveButtonFunctionalityForNonLoggedInUser(masterContentPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterContentTest", "C384190"})
	@TestRail(id = "C384190")
	public void verifyGoogleMatchContentOnMasterContentPage() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		assertEquals(masterContentPage.getGMcontentCardAdSlot(), "4331001144", "Google match content section ad slot should be 4331001144");
		verifyGoogleMatchedContent(masterContentPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "MasterContentTest", "C671986"})
	@TestRail(id = "C671986")
	public void verifyAOLPlayerOnMasterContentPage() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();
			verifyAOLPlayerFunctionality(masterContentPage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterContentTest", "C672599"})
	@TestRail(id = "C672599")
	public void verifyECommerceWidgetFunctionality() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		verifyECommerceModule(masterContentPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "MasterContentTest", "C505431"})
	@TestRail(id = "C505431")
	public void verifyPromoBannerSectionOnMasterContentPage() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		verifyPromoBannerSection(masterContentPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "MasterContentTest", "C678404"})
	@TestRail(id = "C678404")
	public void verifyPrimaryIGNVideo() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();

		verifyIGNMultipleVideos(masterContentPage);
	}
}
