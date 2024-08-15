package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.landingpages.VideoLandingPage;
import framework.Logger;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;

/**
 * VideoLandingPageTest
 */
public class VideoLandingPageTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "VLPageTest", "C314448"})
	@TestRail(id = "C314448")
	public void verifyHeroSection() {
		VideoLandingPage videoLandingPage = SiteNavigatorEH.goToVideoLandingPage();

		assertTrue(videoLandingPage.isHeadlineSectionVisible(), "Headline section should be visible");
		assertTrue(videoLandingPage.isHeadlineTitleVisible(), "Headline title should be visible");
		assertFalse(videoLandingPage.getHeadlineTitleText().isEmpty(), "Headline title should contain some text");
		assertTrue(videoLandingPage.isHeadlineDeckVisible(), "Deck should be visible in headline section");
		assertFalse(videoLandingPage.getHeadlineDeckText().isEmpty(), "Headline deck should contain some text");
		assertTrue(videoLandingPage.isBreadcrumbVisible(), "Breadcrumb text should be visible");
		assertTrue(videoLandingPage.isBreadcrumbArrowVisible(), "Breadcrumb arrow should be visible");
		String breadcrumbHrefValue = videoLandingPage.getBreadcrumbHrefAttributeValue();
		Logger.info("Breadcrumb url: " + breadcrumbHrefValue);
		assertFalse(breadcrumbHrefValue.isEmpty(), "Breadcrumb 'href' value should not be empty");
		assertTrue(breadcrumbHrefValue.startsWith("http"), "'href' value should be valid URL");
		int headlineYCoordinateValue = videoLandingPage.getHeadlineSectionYCoordinateValue();
		assertTrue(headlineYCoordinateValue > videoLandingPage.getLeader1AdBlockLocation(),
				"Hero section should be placed below leader1 ad");
		assertTrue(headlineYCoordinateValue < videoLandingPage.getFeaturedPromoSectionYCoordinateValue(),
				"Hero section should be placed above Featured Promo section");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "VLPageTest", "C314450"})
	@TestRail(id = "C314450")
	public void verifyFeaturedPromoSection() {
		VideoLandingPage videoLandingPage = SiteNavigatorEH.goToVideoLandingPage();

		assertTrue(videoLandingPage.isFeaturedPromoSectionVisible(), "Featured Promo section should be visible");
		assertTrue(videoLandingPage.isFeaturedPromoHeadlineVisible(),
				"Featured Promo section headline should be visible");
		assertTrue(videoLandingPage.isFeaturedPromoSectionImageVisible(),
				"Featured Promo section image should be visible");
		if (!Settings.isMobile()) {
			assertTrue(videoLandingPage.isFeaturedPromoDeckVisible(), "Featured Promo deck should be visible");
		}
		assertTrue(videoLandingPage.isFeaturedPromoSectionTagVisible(), "Featured Promo tag should be visible");
		assertTrue(videoLandingPage.isFeaturedPromoBlueLinkVisible(),
				"Featured Promo section blue link should be visible");
		String sectionLink = videoLandingPage.getFeaturedPromoSectionLink();
		assertTrue(sectionLink.startsWith("https://"), "Featured Promo section link should be valid");
		String headlineLink = videoLandingPage.getFeaturedPromoSectionHeadlineLink();
		assertTrue(headlineLink.startsWith("https://"), "Featured Promo section headline link should be valid");
		assertEquals(sectionLink, headlineLink, "Featured Promo section and headline links should be equal");
		assertTrue(videoLandingPage.getFeaturedPromoSectionTagHrefValue().startsWith("https://"),
				"Featured Promo section tag link should be valid");
		assertTrue(videoLandingPage.getFeaturedPromoBlueLinkHrefValue().startsWith("https://"),
				"Featured Promo section blue link should be valid");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "VLPageTest", "C314451"})
	@TestRail(id = "C314451")
	public void verifyFormFunctionality() {
		VideoLandingPage videoLandingPage = SiteNavigatorEH.goToVideoLandingPage();

		verifyFormElements(videoLandingPage);
		String eVar9Value = Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", "");
		videoLandingPage.clickFormShareLink();
		verifyOmnitureEvents("event14", eVar9Value);
		verifyFormPopUpElements(videoLandingPage);
		verifyFormPopUpStoryShare(videoLandingPage, "Video Landing");
		verifyOmnitureEvents("event15", eVar9Value);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "VLPageTest", "C314452"})
	@TestRail(id = "C314452")
	public void verifyQuestions() {
		VideoLandingPage videoLandingPage = SiteNavigatorEH.goToVideoLandingPage();

		assertTrue(videoLandingPage.isQuestionCardsSectionVisible(), "Question cards section should be visible");
		int numberOfQuestionCards = videoLandingPage.getNumberOfQuestionCards();
		if (numberOfQuestionCards >= 9) {
			assertTrue(videoLandingPage.isSeeMoreButtonVisible(), "'See more' button should be visible");
			assertTrue(videoLandingPage.isAdDiv5Visible(), "AdDiv5 should be visible");
			assertFalse(videoLandingPage.isAdDiv7Visible(), "AdDiv7 should not be visible");
		}
		if (numberOfQuestionCards >= 6) {
			assertTrue(videoLandingPage.isNewsletterWidgetInPositionNumber(6));
		} else {
			assertTrue(videoLandingPage.isNewsletterWidgetInPositionNumber(numberOfQuestionCards));
		}
		for (int cardNumber = 1; cardNumber <= numberOfQuestionCards; cardNumber++) {
			assertTrue(videoLandingPage.getQuestionCardHrefValue(cardNumber).startsWith("https://"),
					"Question card URL should be valid");
			assertTrue(videoLandingPage.isQuestionCardHeadlineVisible(cardNumber), "Question card should have headline");
			assertFalse(videoLandingPage.getQuestionCardQuestionText(cardNumber).isEmpty(),
					"Question card should have some text in question");
			assertTrue(videoLandingPage.isDateLabelVisible(cardNumber),
					"Date label should be visible for every question card");
			if (videoLandingPage.isSponsoredLabelVisibleForCard(cardNumber)) {
				Logger.info("'From Our Sponsor' label is visible for card #" + cardNumber);
			}
			assertTrue(videoLandingPage.isViewAllLinkVisible(cardNumber),
					"'View all X videos' link should be present for every question card");
			int numberOfVideos = videoLandingPage.getTotalNumberOfVideosForCard(cardNumber);
			int numberOfThumbnailImages = videoLandingPage.getNumberOfVisibleThumbnailImages(cardNumber);
			if (numberOfVideos > 4) {
				assertTrue(videoLandingPage.areGreyCirclesVisible(cardNumber),
						"Number of videos for this card is >4, three grey circles should be visible");
			}
			assertTrue(numberOfThumbnailImages >= 1 && numberOfThumbnailImages <= 4,
					"Number of visible thumbnail images should be more than 1 but not more than 4");
		}
		if (videoLandingPage.isSeeMoreButtonVisible()) {
			videoLandingPage.clickSeeMoreButton();
			assertTrue(videoLandingPage.isAdDiv7Visible(), "AdDiv7 should be visible after 'See more' button click");
		}

		Logger.info("Verify cards are sorted from newest to oldest");
		for (int cardNumber = 1; cardNumber < numberOfQuestionCards; cardNumber++) {
			LocalDate date = videoLandingPage.getDateValueFromDateLabel(cardNumber);
			LocalDate date1 = videoLandingPage.getDateValueFromDateLabel(cardNumber + 1);
			assertTrue(date.isAfter(date1) || date.equals(date1), "Newer cards should be placed above older");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "VLPageTest", "C314453"})
	@TestRail(id = "C314453")
	public void verifyFilters() {
		VideoLandingPage videoLandingPage = SiteNavigatorEH.goToVideoLandingPage();

		assertTrue(videoLandingPage.isFilterSectionVisible(), "Filters section should be visible");
		int numberOfFilters = videoLandingPage.getNumberOfAvailableFilters();
		assertTrue(videoLandingPage.isFilterActive(1), "First filter should be active");
		assertEquals(videoLandingPage.getFilterText(1), "All", "'All' filter should be applied by default");
		assertEquals(numberOfFilters, 5, "5 filters should be available");
		for (int filterNumber = 2; filterNumber <= numberOfFilters; filterNumber++) {
			assertFalse(videoLandingPage.isFilterActive(filterNumber),
					"All filters should not be active except for 'All'");
		}
		assertEquals(videoLandingPage.getFilterText(2), "Emotional Health", "2nd filter should be 'Emotional Health'");
		assertEquals(videoLandingPage.getFilterText(3), "Food", "2nd filter should be 'Food'");
		assertEquals(videoLandingPage.getFilterText(4), "Tips", "3rd filter should be 'Tips'");
		assertEquals(videoLandingPage.getFilterText(5), "Relationships", "4th filter should be 'Relationships'");

		for (int filterNumber = 2; filterNumber <= numberOfFilters; filterNumber++) {
			videoLandingPage.clickFilter(filterNumber);
			assertTrue(videoLandingPage.isFilterActive(filterNumber), "2nd filter should be active");
			int numberOfCards = videoLandingPage.getNumberOfQuestionCards();
			Logger.info("Number of question cards after filter is applied - " + numberOfCards);
			if (numberOfCards >= 9) {
				assertTrue(videoLandingPage.isSeeMoreButtonVisible(),
						"'See more' button should be visible if there are 9 or more cards");
			}
			if (numberOfCards >= 5) {
				assertTrue(videoLandingPage.isNewsletterWidgetInPositionNumber(6),
						"Newsletter widget should be in 6th position");
			} else {
				assertTrue(videoLandingPage.isNewsletterWidgetInPositionNumber(numberOfCards + 1));
			}
			assertTrue(Utils.getCurrentURL().endsWith("s/" + videoLandingPage.getFilterText(filterNumber).toLowerCase().replace(" ", "-") + "/"),
					"URL should be changes after filter is applied");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "VLPageTest", "C314449"})
	@TestRail(id = "C314449")
	public void verifyATCWidget() {
		VideoLandingPage videoLandingPage = SiteNavigatorEH.goToVideoLandingPage();

		verifyATCWidgetFunctionality(videoLandingPage, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "VLPageTest", "C314460"})
	@TestRail(id = "C314460")
	public void verifyNewsletterWidgetFunctionality() {
		VideoLandingPage videoLandingPage = SiteNavigatorEH.goToVideoLandingPage();

		verifyNewsletterWidgetFunctionality(videoLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "VLPageTest", "OmnitureTest", "C314456"})
	@TestRail(id = "C314456")
	public void verifyOmnitureEventsAndValues() {
		VideoLandingPage videoLandingPage = SiteNavigatorEH.goToVideoLandingPage();

		String eVar9Value = Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "Event5 should be load event");
		verifyOmnitureEvents("None", eVar9Value);
		if (videoLandingPage.isSeeMoreButtonVisible()) {
			videoLandingPage.clickSeeMoreButton();
			verifyOmnitureEvents("event37", eVar9Value);
		}
		videoLandingPage.clickFilter(5);
		verifyOmnitureEvents("event73", eVar9Value);
		if (videoLandingPage.isSeeMoreButtonVisible()) {
			videoLandingPage.clickSeeMoreButton();
			verifyOmnitureEvents("event37", eVar9Value);
		}
	}

	private void verifyOmnitureEvents(String event, String eVar9) {
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", event), event + " should fire");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cs/test"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "vlp"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cs/test"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "vlp|/cs/test"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "vlp|/cs/test|"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", eVar9), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "arthritis"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "psoriatic arthritis"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "basics"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 value should be published date");
	}
}
