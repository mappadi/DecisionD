package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.CusoVideologuesPage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import framework.Logger;
import framework.platform.SiteNavigatorEH;
import framework.platform.utilities.JsonUtils;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * CusoVideologuesTest
 */
public class CusoVideologuesTest extends WidgetsBaseTest {

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "C234724"})
	@TestRail(id = "C234724")
	public void verifyCusoVideologuesIsiWidget() {
		CusoVideologuesPage videologuesPage = SiteNavigatorEH.goToCusoVideologuesMultibleTabsPage();
		verifyISIWidgets(videologuesPage);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "C234725"})
	@TestRail(id = "C234725")
	public void verifyCusoVideologuesIframeWidget() {
		CusoVideologuesPage videologuesPage = SiteNavigatorEH.goToCusoVideologuesMultibleTabsPage();

		assertTrue(videologuesPage.getRightRailIframeWidgetLocation().equalsIgnoreCase("RightRail"), "Right rail iframe widget position is incorrect");
		assertTrue(videologuesPage.isRightRailIframeWidgetVisible(), "Right rail iframe widget is not visible");

		assertEquals(videologuesPage.getRightRailIframeWidgetHeight(), 250, "Right rail iframe widget height is incorrect");
		assertEquals(videologuesPage.getRightRailIframeWidgetWidth(), 300, "Right rail iframe widget width is incorrect");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "C205009"})
	@TestRail(id = "C205009")
	public void verifyCusoVideologuesPageWithMultipleTabs() {
		CusoVideologuesPage cusoVideologuesPage = SiteNavigatorEH.goToCusoVideologuesMultibleTabsPage();

		verifyATCBrandedWidgetFunctionality(cusoVideologuesPage);
		assertFalse(cusoVideologuesPage.isNewsletterWidgetVisible(), "Newsletter widget should not be visible on page with /br ad-zone");
		verifyCusoVideologuesPageElements(cusoVideologuesPage);
		int numberOfPlaylists = cusoVideologuesPage.getNumberOfPlaylistsOnPage();
		assertTrue(numberOfPlaylists > 1, "More than 1 playlist should be visible on page");

		for (int playlist = 1; playlist <= numberOfPlaylists; playlist++) {
			cusoVideologuesPage.scrollToPlaylist(playlist);
			assertTrue(cusoVideologuesPage.isPlaylistVisible(playlist), "Playlist #" + playlist + " is not visible");
			int numberOfCards = cusoVideologuesPage.getNumberOfCardsInPlaylist(playlist);
			assertTrue(cusoVideologuesPage.isPlaylistHeadlineVisible(playlist), "Headlide for playlist #" + playlist + " should be visible");
			int numberOfVideos = cusoVideologuesPage.getNumberOfVideosInPlaylist(playlist);
			assertEquals(numberOfVideos, numberOfCards, "Video counter should be equal to number of cards");
			if (numberOfVideos > 4) {
				assertTrue(cusoVideologuesPage.isNextNavigationArrowVisibleInPlaylist(playlist), "'>' next arrow should be visible");
			}
			for (int card = 1; card <= numberOfCards; card++) {
				if (card > 4 && card <= numberOfCards) {
					Logger.info("Verify navigation '>' arrow functionality");
					cusoVideologuesPage.clickNextNavigationArrowInPlaylist(playlist);
					assertTrue(cusoVideologuesPage.isPreviousNavigationArrowVisibleInPlaylist(playlist), "'Previous' navigation arrow should be visible if card number is more than 4");
				}
				assertFalse(cusoVideologuesPage.getHrefFromVideoCard(playlist, card).isEmpty(), "Every card should be clickable");
				assertTrue(cusoVideologuesPage.isVideoHeadlineOnCardVisible(playlist, card), "Every card should have headline");
				assertFalse(cusoVideologuesPage.getHrefFromVideoCardHeadline(playlist, card).isEmpty(), "Every card headline should be hyperlink");
				assertTrue(cusoVideologuesPage.isVideoImageOnCardVisible(playlist, card), "Every card should have image");
				assertFalse(cusoVideologuesPage.getHrefFromVideoCardImage(playlist, card).isEmpty(), "Every card image should be hyperlink");
				assertTrue(cusoVideologuesPage.isVideoTypeIconOnCardVisible(playlist, card), "Every card should have type icon");
			}
			if (numberOfCards > 4) {
				assertFalse(cusoVideologuesPage.isVideoHeadlineOnCardVisible(playlist, 1));
				while (!cusoVideologuesPage.isVideoHeadlineOnCardVisible(playlist, 1)) {
					cusoVideologuesPage.clickPreviousNavigationArrowInPlaylist(playlist);
				}
				assertTrue(cusoVideologuesPage.isVideoHeadlineOnCardVisible(playlist, 1));
			}
		}

		int playlistNumber = StringUtils.generateRandomIntInRange(1, 3);
		int cardNumber = StringUtils.generateRandomIntInRange(1, cusoVideologuesPage.getNumberOfCardsInPlaylist(playlistNumber));
		cusoVideologuesPage.clickVideoCard(playlistNumber, cardNumber);
		assertTrue(cusoVideologuesPage.isNowViewingVisibleForCard(playlistNumber, cardNumber), "'Now viewing' label should be visible for chosen video");
		assertEquals(cusoVideologuesPage.getVideoHeadlineText(), cusoVideologuesPage.getVideoTitleFromCard(playlistNumber, cardNumber), "Chosen video should be playing");

		verifyNewReadNextWidget(cusoVideologuesPage);

		assertTrue(cusoVideologuesPage.isNavigationBlockVisible(), "Navigation block should be visible");
		assertTrue(cusoVideologuesPage.isPreviousNavigationArrowVisible(), "'Previous' navigation arrow should be visible");
		assertTrue(cusoVideologuesPage.isNextNavigationArrowVisible(), "'Next' navigation arrow should be visible");
		assertTrue(cusoVideologuesPage.getPreviousNavigationArrowHrefAttributeValue().startsWith("https://"), "'Previous' navigation arrow should be hyperlink");
		assertTrue(cusoVideologuesPage.getNextNavigationArrowHrefAttributeValue().startsWith("https://"), "'Next' navigation arrow should be hyperlink");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "C207930"})
	@TestRail(id = "C207930")
	public void verifyCusoVideologuesPageWithSingleTab() {
		CusoVideologuesPage cusoVideologuesPage = SiteNavigatorEH.goToCusoVideologuesSingleTabPage();

		verifyATCWidgetFunctionality(cusoVideologuesPage, true, false);
		verifyCusoVideologuesPageElements(cusoVideologuesPage);

		assertEquals(cusoVideologuesPage.getNumberOfPlaylistsOnPage(), 1, "Only 1 playlist should be visible on page");
		int numberOfCards = cusoVideologuesPage.getNumberOfCardsInPlaylist(1);
		assertTrue(cusoVideologuesPage.isFormCardInPosition(numberOfCards + 1), "Form should be the last card in playlist");
		for (int card = 1; card <= numberOfCards; card++) {
			assertFalse(cusoVideologuesPage.getHrefFromVideoCard(1, card).isEmpty(), "Every card should be clickable");
			assertTrue(cusoVideologuesPage.isVideoHeadlineOnCardVisible(1, card), "Every card should have headline");
			assertFalse(cusoVideologuesPage.getHrefFromVideoCardHeadline(1, card).isEmpty(), "Every card headline should be hyperlink");
			assertTrue(cusoVideologuesPage.isVideoImageOnCardVisible(1, card), "Every card should have image");
			assertFalse(cusoVideologuesPage.getHrefFromVideoCardImage(1, card).isEmpty(), "Every card image should be hyperlink");
			assertTrue(cusoVideologuesPage.isVideoTypeIconOnCardVisible(1, card), "Every card should have type icon");
		}
		verifyNewReadNextWidget(cusoVideologuesPage);

		int cardNumber = StringUtils.generateRandomIntInRange(1, numberOfCards);
		String videoTitle = cusoVideologuesPage.getVideoTitleFromCard(1, cardNumber);
		cusoVideologuesPage.clickVideoCard(1, cardNumber);
		assertTrue(cusoVideologuesPage.isNowViewingVisibleForCard(1, cardNumber), "'Now viewing' label should be visible for chosen video");
		assertEquals(cusoVideologuesPage.getVideoHeadlineText(), videoTitle, "Chosen video should be playing");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "C325934"})
	@TestRail(id = "C325934")
	public void verifyFormFunctionality() {
		CusoVideologuesPage cusoVideologuesPage = SiteNavigatorEH.goToCusoVideologuesSingleTabPage();

		verifyFormElements(cusoVideologuesPage);
		cusoVideologuesPage.clickFormShareLink();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event14"), "event14 should fire");
		verifyOmnitureVariablesSingleTabPage(cusoVideologuesPage);
		verifyFormPopUpElements(cusoVideologuesPage);
		verifyFormPopUpStoryShare(cusoVideologuesPage, "Cuso Videologues");
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event15"), "event15 should fire");
		verifyOmnitureVariablesSingleTabPage(cusoVideologuesPage);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "C328312"})
	@TestRail(id = "C328312")
	public void verifyNewsletterModuleFunctionality() {
		CusoVideologuesPage cusoVideologuesPage = SiteNavigatorEH.goToCusoVideologuesSingleTabPage();

		verifyNewsletterWidgetFunctionality(cusoVideologuesPage);
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event4"), "'event4' should fire");
		verifyOmnitureVariablesSingleTabPage(cusoVideologuesPage);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "C328313"})
	@TestRail(id = "C328313")
	public void verifySocialShareBarOmniture() {
		CusoVideologuesPage cusoVideologuesPage = SiteNavigatorEH.goToCusoVideologuesMultibleTabsPage();
		SocialBarEH socialBarEH = cusoVideologuesPage.onSocialBar();

		assertTrue(socialBarEH.isFacebookShareButtonVisible(), "Facebook share button should be visible");
		assertTrue(socialBarEH.isTwitterShareButtonVisible(), "Twitter share button should be visible");
		assertTrue(socialBarEH.isPinterestShareButtonVisible(), "Pinterest share button should be visible");
		assertTrue(socialBarEH.isEmailShareButtonVisible(), "Email share button should be visible");
		assertTrue(socialBarEH.isPrintShareButtonVisible(), "Print share button should be visible");
		socialBarEH.clickOnFacebookShareButton();
		socialBarEH.verifyFacebookPopUpContainsFacebook();
		verifyOmnitureVariablesMultipleTabsPage("event93");
		socialBarEH.clickOnTwitterShareButton();
		socialBarEH.verifyTwitterPopUpContainsTwitter();
		verifyOmnitureVariablesMultipleTabsPage("event94");
		socialBarEH.clickOnPinterestShareButton();
		socialBarEH.verifyPinterestPopUpContainsPinterest();
		verifyOmnitureVariablesMultipleTabsPage("event96");
		ShareViaEmailPopUp shareViaEmailPopUp = socialBarEH.clickEmailShareButton();
		verifyOmnitureVariablesMultipleTabsPage("event92");
		shareViaEmailPopUp.closePopUp();
		socialBarEH.clickPrintShareButton();
		verifyOmnitureVariablesMultipleTabsPage("event98");
	}

	//TODO update this test to work with IGN
	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "C337494"}, enabled = false)
	@TestRail(id = "C337494")
	public void verifyCusoVideologuesPageAutoscrollUpFunctionality() {
		CusoVideologuesPage cusoVideologuesPage = SiteNavigatorEH.goToCusoVideologuesMultibleTabsPage();
		cusoVideologuesPage.scrollPage(4000);
		int numberOfPlaylists = cusoVideologuesPage.getNumberOfPlaylistsOnPage();
		cusoVideologuesPage.clickVideoCard(numberOfPlaylists, 1);
		Utils.waitFor(3000);
		assertTrue(cusoVideologuesPage.isNowViewingVisibleForCard(numberOfPlaylists, 1), "'Now viewing' label should be visible on correct video");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "C337412"})
	@TestRail(id = "C337412")
	public void verifyVideoSchema() {
		CusoVideologuesPage cusoVideologuesPage = SiteNavigatorEH.goToCusoVideologuesSingleTabPage();

		String videoTitle = cusoVideologuesPage.getVideoHeadlineText();
		String pageURL = Utils.getCurrentURL();
		Document doc = null;
		try {
			doc = Jsoup.connect(pageURL).timeout(5000).get(); //connection timeout in case it take more time than usual to load the page
		} catch (IOException e) {
			fail("Connection to url failed");
		}
		try {
			Elements elements = doc.select("script[type=application/ld+json]");
			assertEquals(elements.size(), 1, "1 schema should be present in page source");
			Element schema = elements.first();
			JsonUtils.setStringJson(schema.data());
			assertEquals(JsonUtils.getJsonObjectValue("@context"), "http://schema.org", "'@context' object should have 'http://schema.org' value");
			assertEquals(JsonUtils.getJsonObjectValue("@type"), "VideoObject", "'@type' object should have 'VideoObject' value");
			assertEquals(JsonUtils.getJsonObjectValue("name"), videoTitle, "'name' object should be equal to video title");
			assertFalse(JsonUtils.getJsonObjectValue("description").isEmpty(), "'description' object should not be empty");
			assertFalse(JsonUtils.getJsonObjectValue("thumbnailUrl").isEmpty(), "'thumbnailUrl' object should not be empty");
			assertFalse(JsonUtils.getJsonObjectValue("uploadDate").isEmpty(), "'uploadDate' object should not be empty");
			assertTrue(JsonUtils.getJsonObjectValue("contentUrl").endsWith(pageURL.split(".com")[1]), "'contentUrl' object be equal to current URl");
			assertFalse(JsonUtils.getJsonObjectValue("embedUrl").isEmpty(), "'embedUrl' object should not be empty");
		} catch (AssertionError | NullPointerException e) {
			fail("There was an error. Please check console output.");
		}
	}

	private void verifyOmnitureVariablesSingleTabPage(CusoVideologuesPage videologuesPage) {
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cs/test"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cs/test"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc|/cs/test|"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].split("#")[0].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "videologues"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "diabetes"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "type 2 diabetes"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
	}

	private void verifyOmnitureVariablesMultipleTabsPage(String event) {
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", event), event + " should fire");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/digestive/hepatitisc/br"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/digestive/hepatitisc"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc|/digestive/hepatitisc"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc|/digestive/hepatitisc|"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].split("#")[0].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "videologues"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "nutrients"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "protein"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "basics"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
	}

	private void verifyNewReadNextWidget(CusoVideologuesPage cusoVideologuesPage) {
		Logger.info("Verify ReadNext widget");
		assertTrue(cusoVideologuesPage.isReadNextWidgetVisible(), "Read next widget should be visible");
		int numberOfCards = cusoVideologuesPage.getNumberOfCardsInReadNext();
		assertEquals(numberOfCards, 3, "3 cards should be present in Read next widget");
		assertTrue(cusoVideologuesPage.isReadNextWidgetHeadlineVisible(), "Read next widget headline should be visible");
		assertTrue(cusoVideologuesPage.isReadNextCategoryLinkVisible(), "Read next widget headline category link should be visible");
		for (int card = 1; card <= numberOfCards; card++) {
			assertFalse(cusoVideologuesPage.getReadNextCardHrefAttributeValue(card).isEmpty(), "Read next card should be clickable");
			assertTrue(cusoVideologuesPage.isReadNextCardHeadlineVisible(card), "Every Read next widget card should have headline");
			assertTrue(cusoVideologuesPage.isReadNextCardImageVisible(card), "Every Read next widget card should have image");
			assertTrue(cusoVideologuesPage.isReadNextCardTypeIconVisible(card), "Every Read next widget card should have type icon");
		}
	}

	private void verifyCusoVideologuesPageElements(CusoVideologuesPage cusoVideologuesPage) {
		Utils.waitFor(3000);
		assertFalse(cusoVideologuesPage.isIGNVideoPaused(), "Video should play");

		cusoVideologuesPage.scrollPage(1000);
		cusoVideologuesPage.clickIGNPauseButton();
		assertTrue(cusoVideologuesPage.isIGNVideoPaused(), "Video should be paused");

		assertTrue(cusoVideologuesPage.isTitleVisible(), "Headline should be visible");
		assertTrue(cusoVideologuesPage.isDeckVisible(), "Deck should be visible");
		assertTrue(cusoVideologuesPage.isBreadcrumbVisible(), "Breadcrumb should be visible");
		assertTrue(cusoVideologuesPage.isBreadcrumbArrowVisible(), "Breadcrumb arrow should be visible");
		assertFalse(cusoVideologuesPage.getBreadcrumbHrefAttributeValue().isEmpty(), "Breadcrumb should be clickable");

		assertTrue(cusoVideologuesPage.isVideoSectionVisible(), "Section with videoplayer should be visible");
		assertTrue(cusoVideologuesPage.isVideoSectionInformationVisible(), "Video informations section should be visible below video");
		assertTrue(cusoVideologuesPage.isVideoHeadlineVisible(), "Video headline should be visible");
		assertTrue(cusoVideologuesPage.isVideoDeckVisible(), "Video deck should be visible");
		String videoTitle = cusoVideologuesPage.getVideoHeadlineText();
		assertFalse(videoTitle.isEmpty(), "Video should have non-empty headline");
		assertFalse(cusoVideologuesPage.getVideoDeckText().isEmpty(), "Video deck should have some text");

		assertTrue(cusoVideologuesPage.isPlaylistHeadlineVisible(1), "Playlist headline should be visible");
		assertEquals(videoTitle, cusoVideologuesPage.getVideoTitleFromCard(1, 1), "Video title from first card should be the same as video title from video section");
		assertTrue(cusoVideologuesPage.isNowViewingVisibleForCard(1, 1), "'Now viewing' label should be visible for first video in playlist");

		assertTrue(cusoVideologuesPage.isLastUpdatedVisible(), "'Last updated' string should be visible");
		assertFalse(cusoVideologuesPage.getLastUpdatedDate().isEmpty(), "Some date should be displayed");
	}
}