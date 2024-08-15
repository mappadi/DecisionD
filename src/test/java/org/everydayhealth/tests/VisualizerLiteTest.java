package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.visualizer.VisualizerLitePage;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.StringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class VisualizerLiteTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C678493"})
	@TestRail(id = "C678493")
	public void verifyVisualizerHeroSection() {
		VisualizerLitePage visualizerPage = SiteNavigatorEH.goToVisualizerLitePage();
		assertTrue(visualizerPage.isBreadcrumbVisible(), "BreadCrumb should be visible");
		assertEquals(visualizerPage.getNumberOfBreadcrumbArrows(), 1, "1 arrow should be visible");
		assertEquals(visualizerPage.getNumberOfBreadcrumbLinks(), 1, "1 breadcrumb link should be visible");
		assertTrue(visualizerPage.getBreadcrumbHrefAttributeValue(1)
						.contains(visualizerPage.getSubCategoryForPage().toLowerCase().replace(" ", "-")),
				"Breadcrumb URL should lead to subcategory page");
		assertTrue(visualizerPage.isHeroTitleVisible(), "Hero Title should be visible");
		assertTrue(visualizerPage.isDeckVisible(), "Deck should be visible");
		assertTrue(visualizerPage.isJumpOverviewLinkVisible(), "Jump Overview link should be visible");
		assertTrue(visualizerPage.isBylineVisible(), "Byline should be visible");
	}

	@Test(groups = {"EverydayhealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C679146"})
	@TestRail(id = "C679146")
	public void verifyOverviewSection() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		int numberOfOverviewSections = visualizerLitePage.getNumberOfOverviewSections();
		assertTrue(numberOfOverviewSections >= 1, "At least one overview section should be visible on page");
		for (int section = 1; section <= numberOfOverviewSections; section++) {
			assertTrue(visualizerLitePage.isOverviewSectionTitleVisible(section), "Section title is not visible");
			assertTrue(visualizerLitePage.isOverviewSectionDeckVisible(section), "Section deck is not visible");
			assertTrue(visualizerLitePage.isOverviewSectionImageVisible(section), "Section image is not visible");
			assertTrue(visualizerLitePage.isOverviewSectionImageDescriptionVisible(section),
					"Section description should be visible");
		}
		int numberOfCaptions = visualizerLitePage.getNumberOfImageCaptionsInOverviewSections();
		assertTrue(numberOfCaptions >= 1 && numberOfCaptions <= numberOfOverviewSections,
				"At least one image caption should be present, but not more than number of sections");
	}

	@Test(groups = {"EverydayhealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C679148"})
	@TestRail(id = "C679148")
	public void verifyStatisticsSection() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		assertTrue(visualizerLitePage.isStatsSectionVisible(), "Stats section should be visible");
		assertTrue(visualizerLitePage.getStatsSectionStyleAttribute().contains("agoramedia"),
				"'style' attribute should contain link to background image");
		assertTrue(visualizerLitePage.isStatsSectionTitleVisible(), "Stats section title should be visible");
		assertTrue(visualizerLitePage.isStatsSectionDeckVisible(), "Stats section deck should be visible");
		int cardsCount = visualizerLitePage.getNumberOfStatsSectionContentCards();
		for (int cardNumber = 1; cardNumber <= cardsCount; cardNumber++) {
			if (cardNumber == cardsCount && Settings.isDesktop()) {
				assertTrue(visualizerLitePage.isNavigationArrowNextVisibleInStatsSection(), "'Next' arrow should be visible");
				assertFalse(visualizerLitePage.isNavigationArrowPreviousVisibleInStatsSection(),
						"'Previous' arrow should not be visible");
				visualizerLitePage.clickNextArrowInStatsSection();
			}
			if (Settings.isMobile()) {
				visualizerLitePage.clickStatsSectionDot(cardNumber);
			}
			assertTrue(visualizerLitePage.isStatsSectionCardTitleVisible(cardNumber),
					"Content card title should be visible");
			assertTrue(visualizerLitePage.isStatsSectionCardStatsInfoVisible(cardNumber),
					"Content card stats info should be visible");
			assertTrue(visualizerLitePage.isStatsSectionCardDescriptionVisible(cardNumber),
					"Content card description should be visible");
		}
		if (Settings.isDesktop()) {
			assertFalse(visualizerLitePage.isNavigationArrowNextVisibleInStatsSection(),
					"'Next' arrow should not be visible");
			assertTrue(visualizerLitePage.isNavigationArrowPreviousVisibleInStatsSection(),
					"'Previous' arrow should be visible");
		}
	}

	@Test(groups = {"EverydayhealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C679156"})
	@TestRail(id = "C679156")
	public void verifyImageSelectorSection() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		assertTrue(visualizerLitePage.isImageSelectorSectionVisible(), "Image selector section should be visible");
		assertTrue(visualizerLitePage.isImageSelectorSectionSliderVisible(), "Slider should be visible");
		int imageCount = visualizerLitePage.getNumberOfImagesInImageSelectorSection();
		assertEquals(imageCount,
				visualizerLitePage.getNumberOfSliderOptionsInImageSelectorSection(),
				"Number of slider options should be equal to number of images in section");
		if (Settings.isMobile()) {
			assertTrue(visualizerLitePage.isImageActiveInImageSelector(1), "First image should be active");
			visualizerLitePage.clickSliderOption(2);
			assertTrue(visualizerLitePage.isImageActiveInImageSelector(2), "Second image should be active");
			visualizerLitePage.clickSliderOption(3);
			assertTrue(visualizerLitePage.isImageActiveInImageSelector(3), "Third image should be active");
			visualizerLitePage.clickSliderOption(1);
			assertTrue(visualizerLitePage.isImageActiveInImageSelector(1), "First image should be active");
		} else {
			assertEquals(visualizerLitePage.getIndexOfVisibleImageInSelector(), 1, "First image should be visible");
			visualizerLitePage.clickSliderOption(2);
			assertEquals(visualizerLitePage.getIndexOfVisibleImageInSelector(), 2, "Second image should be visible");
			visualizerLitePage.clickSliderOption(3);
			assertEquals(visualizerLitePage.getIndexOfVisibleImageInSelector(), 3, "Third image should be visible");
			visualizerLitePage.clickSliderOption(1);
			assertEquals(visualizerLitePage.getIndexOfVisibleImageInSelector(), 1, "First image should be visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C679154"})
	@TestRail(id = "C679154")
	public void verifyNewsletterWidgetFunctionality() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		verifyNewsletterWidgetFunctionality(visualizerLitePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C678492"})
	@TestRail(id = "C678492")
	public void verifyATCSection() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		verifyATCWidgetFunctionality(visualizerLitePage, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "VisualizerLiteTest", "C678400"})
	@TestRail(id = "C678400")
	public void verifySSOFunctionality() {
		SocialBarEH socialBarEH = SiteNavigatorEH.goToPage(TemplatesEH.VISUALIZER_LITE_PAGE, VisualizerLitePage.class).onSocialBar();
		assertTrue(socialBarEH.isFacebookShareButtonVisible(), "'Facebook' share button should be visible");
		assertTrue(socialBarEH.isTwitterShareButtonVisible(), "'Twitter' share button should be visible");
		assertTrue(socialBarEH.isPinterestShareButtonVisible(), "'Pinterest' share button should be visible");
		assertTrue(socialBarEH.isEmailShareButtonVisible(), "'Email' share button should be visible");
		assertTrue(socialBarEH.isSocialShareCountVisible(), "Social share counter should be visible");

		if (Settings.isDesktop()) {
			assertTrue(socialBarEH.isPrintShareButtonVisible(), "'Print' share button should be visible");
			assertEquals(socialBarEH.getNumberOfShares(), socialBarEH.getSumOfSharesFromSocialShareButtons(true), "Number of shares should be equal to the sum of shares for every button");
			socialBarEH.verifyAllPopUpsContainRespectiveDomain();
		}
	}

	@Test(groups = {"EverydayhealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C679149"})
	@TestRail(id = "C679149")
	public void verifyPersonalStoriesSection() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		assertTrue(visualizerLitePage.isPersonalStoriesSectionVisible(), "Personal stories section should be visible");
		assertTrue(visualizerLitePage.isPersonalStoriesSectionTitleVisible(),
				"Title on the personal stories section should be visible");
		assertTrue(visualizerLitePage.isPersonalStoriesSectionDeckVisible(),
				"Deck on the personal stories section should be visible");
		assertTrue(visualizerLitePage.isPersonalStoriesContentSectionVisible(),
				"Text in the personal stories section should be visible");

		int cardsCount = visualizerLitePage.getNumberOfPersonalStoriesContentCards();
		assertTrue(cardsCount <= 6, "Number of content cards should be less or equal to six");
		for (int cardNumber = 1; cardNumber <= cardsCount; cardNumber++) {
			if (cardNumber == cardsCount && !Settings.isMobile()) {
				assertTrue(visualizerLitePage.isNavigationArrowNextVisibleInPersonalStoriesSection()
						, "'Next' arrow should be visible");
				assertFalse(visualizerLitePage.isNavigationArrowPreviousVisibleInPersonalStoriesSection(),
						"'Previous' arrow should not be visible");
				visualizerLitePage.clickNextArrowInPersonalStoriesSection();
			}
			if (Settings.isMobile()) {
				visualizerLitePage.clickPersonalStoriesSectionDot(cardNumber);
			}
			assertTrue(visualizerLitePage.isPersonalStoriesCardThumbnailImageVisible(cardNumber),
					"Thumbnail Image should be visible");
			assertTrue(visualizerLitePage.isPersonalStoriesCardTitleVisible(cardNumber), "Title text should be visible");
			assertTrue(visualizerLitePage.isPersonalStoriesCardDeckVisible(cardNumber), "Deck should be visible");
			assertTrue(visualizerLitePage.isPersonalStoriesCardTextVisible(cardNumber), "Text content should be visible");
			assertTrue(visualizerLitePage.isPersonalStoriesCardSeeMoreNavVisible(cardNumber),
					"See More Nav should be visible");
		}
	}

	@Test(groups = {"EverydayhealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C679150"})
	@TestRail(id = "C679150")
	public void verifyTextOnlySection() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		int numberOfSections = visualizerLitePage.getNumberOfTextOnlySections();
		for (int sectionNumber = 1; sectionNumber <= numberOfSections; sectionNumber++) {
			assertTrue(visualizerLitePage.isTextOnlySectionTitleVisible(sectionNumber), "Title should be visible");
			assertTrue(visualizerLitePage.isTextOnlySectionContentVisible(sectionNumber), "Section content should be visible");
		}
	}

	@Test(groups = {"EverydayhealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C679151"})
	@TestRail(id = "C679151")
	public void verifyPromoSection() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		assertTrue(visualizerLitePage.isPromoSectionVisible(), "promo section should be visible");
		assertTrue(visualizerLitePage.isPromoSectionCardVisible(), "Promo Section Card should be visible");
		assertTrue(visualizerLitePage.isPromoSectionFromOurSponsorTextVisible(), "From our Sponsor text should be visible");
		assertTrue(visualizerLitePage.isPromoSectionCardHeadlineVisible(), "Headline Text should be visible");
		assertTrue(visualizerLitePage.isPromoSectionCardThumbnailImageVisible(), "Thumbnail Image should be visible on the promo section card");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C679153"})
	@TestRail(id = "C679153")
	public void verifyActionPlanSection() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		assertTrue(visualizerLitePage.isActionPlanSectionVisible(), "Action Plan section should be visible");
		assertTrue(visualizerLitePage.getActionPlanStyleAttribute().contains("agoramedia"),
				"Link to background image should be present in 'style' attribute");
		assertTrue(visualizerLitePage.isActionPlanSectionTitleVisible(), "Title should be visible");
		assertTrue(visualizerLitePage.isActionPlanSectionDeckVisible(), "Deck should be visible");
		assertTrue(visualizerLitePage.isActionPlanSectionListVisible(), "List should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C679155"})
	@TestRail(id = "C679155")
	public void verifyImageCreditText() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		assertTrue(visualizerLitePage.isImageCreditsSectionVisible(), "Image Credit text should be visible");
		assertTrue(visualizerLitePage.isImageCreditsTextVisible(), "Image credits text should be visible");
		assertEquals(visualizerLitePage.getImageCreditsText(), "Image Credits:", "Incorrect text");
		assertTrue(visualizerLitePage.getNumberOfImageCreditLinks() >= 1, "At least one image credit link should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C679152"})
	@TestRail(id = "C679152")
	public void verifyHorizontalPromoSection() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		int horizontalPromosCount = visualizerLitePage.getNumberOfVisibleHorizontalPromoSections();
		assertTrue(horizontalPromosCount >= 1, "At least one horizontal promo section should be visible on page");
		for (int promoSection = 1; promoSection <= horizontalPromosCount; promoSection++) {
			assertEquals(visualizerLitePage.getNumberOfCardsInHorizontalPromo(promoSection),
					3,
					"Horizontal promo section should contain 3 cards");
			assertTrue(visualizerLitePage.isHorizontalPromoSectionTitleVisible(promoSection),
					"Each horizontal promo section should have title");
			for (int card = 1; card <= 3; card++) {
				assertTrue(visualizerLitePage.isHorizontalPromoSectionCardImageVisible(promoSection, card),
						"Each horizontal promo section card should have image");
				assertTrue(visualizerLitePage.isHorizontalPromoSectionCardTitleVisible(promoSection, card),
						"Each horizontal promo section card should have title");
				assertFalse(visualizerLitePage.getHorizontalPromoSectionCardHrefValue(promoSection, card).isEmpty(),
						"Each horizontal promo section card should have non-empty 'href'");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "VisualizerLiteTest", "C679147"})
	@TestRail(id = "C679147")
	public void verifyVideoSection() {
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToVisualizerLitePage();

		assertTrue(visualizerLitePage.isVideoSectionVisible(), "Video section should be visible");
		assertTrue(visualizerLitePage.isIGNPlayerVisible(), "Video player should be visible");
		assertTrue(visualizerLitePage.isVideoSectionPlaylistVisible(), "Playlist should be visible");
		int numberOfVideos = visualizerLitePage.getNumberOfVideosInPlaylist();
		assertTrue(numberOfVideos >= 1, "At least one video should be visible");
		assertTrue(visualizerLitePage.isVideoActive(1), "First video should be active");
		int videoNumber = StringUtils.generateRandomIntInRange(2, numberOfVideos);
		visualizerLitePage.clickVideoInPlaylist(videoNumber);
		assertTrue(visualizerLitePage.isVideoActive(videoNumber), "Chosen video should be active");
	}
}
