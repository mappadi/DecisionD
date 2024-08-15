package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.resourceCenter.ResourceCenterPage;
import framework.DebugMode;
import framework.GoogleAdValue;
import framework.Logger;
import framework.Settings;
import framework.platform.Environment;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * ResourceCenterTest
 */
public class ResourceCenterTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "C309818"})
	@TestRail(id = "C309818")
	public void verifyATCSection() {
		ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToResourceCenterPage();
		verifyATCWidgetFunctionality(resourceCenterPage, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "C309819"})
	@TestRail(id = "C309819")
	public void verifyHeadlineSection() {
		ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToResourceCenterPage();
		assertTrue(resourceCenterPage.isHeadlineSectionVisible(), "Headline section should be visible");
		int headlineSectionYCoordinate = resourceCenterPage.getHeadlineSectionYCoordinateValue();
		assertTrue(headlineSectionYCoordinate > resourceCenterPage.getATCWidgetYCoordinateValue(), "Headline should be placed below 'ATC' section");
		assertTrue(headlineSectionYCoordinate < resourceCenterPage.getFeaturedPromoSectionYCoordinateValue(), "Headline should be placed above Featured Promo section");
		assertTrue(resourceCenterPage.isHeadlineTitleVisible(), "Headline title should be visible");
		assertFalse(resourceCenterPage.getHeadlineTitleText().isEmpty(), "Headline title should not be empty");
		assertTrue(resourceCenterPage.isBreadcrumbVisible(), "Breadcrumb should be visible");
		assertTrue(resourceCenterPage.isBreadcrumbArrowVisible(), "Breadcrumb arrow (<) should be visible");
		String breadcrumbHrefValue = resourceCenterPage.getBreadcrumbHrefAttributeValue();
		Logger.info("Breadcrumb url: " + breadcrumbHrefValue);
		assertFalse(breadcrumbHrefValue.isEmpty(), "Breadcrumb 'href' value should not be empty");
		assertTrue(breadcrumbHrefValue.startsWith("https://"), "'href' value should be valid URL");
		assertTrue(resourceCenterPage.isHeadlineDeckVisible(), "Headline deck should be visible");
		assertFalse(resourceCenterPage.getHeadlineDeckText().isEmpty(), "Headline deck should have text");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "C309820"})
	@TestRail(id = "C309820")
	public void verifyFeaturedPromoSection() {
		ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToResourceCenterPage();
		int numberOfBlocks = resourceCenterPage.getNumberOfBlocksInFeaturedPromoSection();
		assertTrue(numberOfBlocks <= 3, "3 or less blocks should be present in Featured Promo section");
		assertEquals(resourceCenterPage.getNumberOfBlockTitles(), numberOfBlocks, "Every block in Featured Promo sectin should have title");
		resourceCenterPage.scrollToFeaturedPromoImage(numberOfBlocks);
		assertEquals(resourceCenterPage.getNumberOfBlockImages(), numberOfBlocks, "Every block in Featured Promo sectin should have image");
		assertEquals(resourceCenterPage.getNumberOfBlockTags(), numberOfBlocks, "Every block in Featured Promo sectin should have tag");
		if (!Settings.isMobile()) {
			assertEquals(resourceCenterPage.getNumberOfBlockDecks(), numberOfBlocks, "Every block in Featured Promo sectin should have deck");
		}
		for (int blockNumber = 1; blockNumber <= numberOfBlocks; blockNumber++) {
			assertTrue(resourceCenterPage.isFeaturedPromoSectionBlockURLValid(blockNumber), "Featured Promo blocks should be valid links");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "C309821"})
	@TestRail(id = "C309821")
	public void verifyVerticalPromoSection() {
		ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToResourceCenterPage();
		int numberOfBlocks = resourceCenterPage.getNumberOfBlocksInVerticalPromoSection();
		assertTrue(numberOfBlocks <= 3, "3 or less blocks should be present in Vertical Promo section");
		assertEquals(resourceCenterPage.getNumberOfHeadlinesInVerticalPromoSection(), numberOfBlocks, "Every block in Vertical Promo section should have headline");
		resourceCenterPage.scrollToLastCardInVerticalPromoSection();
		int numberOfContentCards = resourceCenterPage.getNumberOfCardsInVerticalPromoSection();
		assertEquals(resourceCenterPage.getNumberOfCardHeadlinesInVerticalPromoSection(), numberOfContentCards, "Every content card should have headline");
		assertEquals(resourceCenterPage.getNumberOfCardImagesInVerticalPromoSection(), numberOfContentCards, "Every content card should have image");
		if (!Settings.isMobile()) {
			assertEquals(resourceCenterPage.getNumberOfCardTypeIconsInVerticalPromoSection(), numberOfContentCards, "Every content card should have type icon");
		}
		assertTrue(resourceCenterPage.getNumberOfSponsoredTagsInVerticalPromoSection() > 0, "At least one 'From our sponsor' tag should be in Vertical Promo section");
		assertTrue(resourceCenterPage.isGetMoreLinkVisible(), "'Get more' link should be present in 2nd block of Vertical Promo section");
		assertTrue(resourceCenterPage.isGetMoreLinkValid(), "'Get more' link should be proper URL");
		for (int cardNumber = 1; cardNumber <= numberOfContentCards; cardNumber++) {
			assertTrue(resourceCenterPage.isCardLinkValid(cardNumber), "All cards should be valid links");
		}
		assertTrue(resourceCenterPage.isAdDiv5BlockVisibleInFirstBlock(), "adDiv5 should be visible in first block of Vertical Promo section");
		assertTrue(resourceCenterPage.isAdDiv7BlockVisibleInSecondBlock(), "adDiv7 should be visible in second block of Vertical Promo section");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "C309822"})
	@TestRail(id = "C309822")
	public void verifyHorizontalPromoSection() {
		ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToResourceCenterPage();

		int numberOfHorizontalPromos = resourceCenterPage.getNumberOfBlocksInHorizontalPromoSection();
		assertEquals(numberOfHorizontalPromos, 3, "3 horizontal promo sections should be present");
		if (Settings.isDesktop()) {
			resourceCenterPage.scrollToHorizontalPromoSectionBlock(3);
		}
		assertEquals(resourceCenterPage.getNumberOfHeadlinesInHorizontalPromoSection(),
				numberOfHorizontalPromos,
				"Number of headlines should be equal to number of sections");
		for (int section = 1; section <= numberOfHorizontalPromos; section++) {
			int numberOfCardsInSection = resourceCenterPage.getNumberOfCardsInHorizontalPromoSectionBlock(section);
			resourceCenterPage.scrollToHorizontalPromoSectionBlock(section);
			if (!Settings.isMobile() && numberOfCardsInSection > 4) {
				assertFalse(resourceCenterPage.isPreviousNavigationArrowVisibleInBlock(1), "Previous navigation arrow should not be visible");
				assertTrue(resourceCenterPage.isNextNavigationArrowVisibleInBlock(1), "Next navigation arrow should be visible");
			}
			for (int cardNumber = 1; cardNumber <= numberOfCardsInSection; cardNumber++) {
				if (Settings.isMobile()) {
					resourceCenterPage.clickHorizontalPromoCardsPagerButton(section, cardNumber);
				} else {
					if (cardNumber > 4 && cardNumber <= numberOfCardsInSection) {
						Logger.info("Verify navigation '>' arrow functionality");
						resourceCenterPage.clickNextNavigationArrowInBlock(section);
						assertTrue(resourceCenterPage.isPreviousNavigationArrowVisibleInBlock(1));
					}
				}
				assertTrue(resourceCenterPage.isImageVisibleForCardInBlock(section, cardNumber), "Image should be visible for cards in Horizontal Promo section");
				assertTrue(resourceCenterPage.isTypeIconVisibleForCardInBlock(section, cardNumber), "Type icon should be visible for cards in Horizontal Promo section");
				assertTrue(resourceCenterPage.isHeadlineVisibleForCardInBlock(section, cardNumber), "Headline should be visible for cards in Horizontal Promo section");
			}
			if (numberOfCardsInSection > 4 && Settings.isDesktop()) {
				Logger.info("Verify navigation '<' arrow functionality");
				assertFalse(resourceCenterPage.isImageVisibleForCardInBlock(section, 1), "First card should not be visible");
				assertFalse(resourceCenterPage.isImageVisibleForCardInBlock(section, 2), "Second card should not be visible");
				while (!resourceCenterPage.isImageVisibleForCardInBlock(section, 1)) {
					resourceCenterPage.clickPreviousNavigationArrowInBlock(section);
				}
				assertTrue(resourceCenterPage.isImageVisibleForCardInBlock(section, 1), "First card should be visible");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "C309823"})
	@TestRail(id = "C309823")
	public void verifyLinksListSection() {
		ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToResourceCenterPage();
		assertTrue(resourceCenterPage.isLinksListSectionVisible(), "Links List section should be visible");
		assertTrue(resourceCenterPage.isLinksListHeaderVisible(), "Links List section header should be visible");
		assertFalse(resourceCenterPage.getLinksListHeaderText().isEmpty(), "Links List header should have some text");
		int numberOfLinks = resourceCenterPage.getNumberOfLinksInLinksListSection();
		for (int linkNumber = 1; linkNumber <= numberOfLinks; linkNumber++) {
			assertTrue(resourceCenterPage.isLinksListSectionLinkValid(linkNumber), "All links in Links list section should be valid (start with 'https://'");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "C309824"})
	@TestRail(id = "C309824")
	public void verifyNewsletterWidgetWithValidData() {
		ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToResourceCenterPage();
		verifyNewsletterWidgetElements(resourceCenterPage);
		resourceCenterPage.enterEmail(StringUtils.generateRandomEmail());
		resourceCenterPage.clickNewsletterSubmitButton();
		assertTrue(resourceCenterPage.isNewsletterWidgetSuccessMessageVisible(), "Success message should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "C309825"})
	@TestRail(id = "C309825")
	public void verifyNewsletterWidgetWithInvalidData() {
		ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToResourceCenterPage();
		verifyNewsletterWidgetElements(resourceCenterPage);
		resourceCenterPage.clickNewsletterSubmitButton();
		assertTrue(resourceCenterPage.isNewsletterWarningMessageVisible(), "Warning message should be visible");
		resourceCenterPage.waitUntilWarningMessageDisappear();
		resourceCenterPage.enterEmailAndSubmit(StringUtils.generateRandomStrAlphabetic(7));
		assertTrue(resourceCenterPage.isNewsletterWarningMessageVisible(), "Warning message should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "C309844"})
	@TestRail(id = "C309844")
	public void verifyLogoAdBlock() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToResourceCenterPage();
			SiteNavigatorEH.goToTestAdMode();
			assertTrue(resourceCenterPage.isLogoAdBlockVisible(), "Logo ad should be visible");
			DebugMode debugMode = resourceCenterPage.inDebugMode();
			if (!Settings.isMobile()) {
				assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 2), "230x45", "'Size' value for logo ad should be 230x45");
			} else {
				assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 2), "185x36", "'Size' value for logo ad should be 185x36");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "C339154"})
	@TestRail(id = "C339154")
	public void verifySeeMoreButtonFunctionality() {
		ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToResourceCenterPage();
		assertTrue(resourceCenterPage.isSeeMoreButtonVisibleInFirstVerticalPromoBlock(), "'See more' button should be visible in first vertical promo section");
		int numberOfContentCards = resourceCenterPage.getNumberOfContentCardsInVerticalPromoSectionBlock(1);
		assertEquals(numberOfContentCards, 5, "5 cards should be visible if 'See more' button is present");
		resourceCenterPage.clickSeeMoreButton();
		assertEquals(MarketingPixels.getConsoleValue("linkTrackEvents"), "event37", "'event37' should fire");
		assertTrue(resourceCenterPage.getNumberOfContentCardsInVerticalPromoSectionBlock(1) > numberOfContentCards, "More content cards should be displayed after 'See more' button click");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "C339155"})
	@TestRail(id = "C339155")
	public void verifyPageElementsInBrZone() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToPage(TemplatesEH.RESOURCE_CENTER_BR_ZONE, ResourceCenterPage.class);
			assertTrue(Utils.isPageSourceContains("data-zone=\"/cs/test/br\""), "Page should have /br data-zone");
			verifyATCBrandedWidgetFunctionality(resourceCenterPage);
			assertFalse(resourceCenterPage.isNewsletterWidgetVisible(), "Newsletter widget should not be present on page with /br data-zone");
		}
	}

	private void verifyNewsletterWidgetElements(ResourceCenterPage resourceCenterPage) {
		assertTrue(resourceCenterPage.isNewsletterWidgetVisible(), "Newsletter widget should be visible");
		assertTrue(resourceCenterPage.isNewsLetterEmailBoxVisible(), "'Email' input should be visible on newsletter widget");
		assertTrue(resourceCenterPage.isNewsLetterSubmitButtonVisible(), "'Submit' button should be visible on newsletter widget");
		assertTrue(resourceCenterPage.isNewsletterWidgetPrivacyLinkVisible(), "'Privacy' link should be visible");
		assertTrue(resourceCenterPage.isNewsLetterWidgetPrivacyLinkValid(), "'Privacy' link should be valid");
	}
}
