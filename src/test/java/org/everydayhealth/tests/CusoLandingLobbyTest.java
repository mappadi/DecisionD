package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.CusoLandingLobbyPage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import framework.Logger;
import framework.Settings;
import framework.platform.CookieName;
import framework.platform.SiteNavigatorEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

/**
 * CusoLandingLobbyTest
 */
public class CusoLandingLobbyTest extends WidgetsBaseTest {

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "C204946"})
	@TestRail(id = "C204946")
	public void verifyAtcPopoverFunctionality() {
		CusoLandingLobbyPage cusoLandingLobby = SiteNavigatorEH.goToCusoLandingLobbyPage();
		verifyATCWidgetFunctionality(cusoLandingLobby, false, true);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "C204951"})
	@TestRail(id = "C204951")
	public void verifySmallGridFunctionality() {
		CusoLandingLobbyPage cusoLandingLobby = SiteNavigatorEH.goToCusoLandingLobbyPage();
		cusoLandingLobby.scrollToSmallGrid();
		assertTrue(cusoLandingLobby.isSmallGridTitlePresent(), "Small grid title should be present");
		int smallGridItemsNumber = cusoLandingLobby.getNumberOfVisibleSmallGridItems();
		int smallGridTitlesNumber = cusoLandingLobby.getNumberOfVisibleSmallGridTitles();
		int smallGridImagesNumber = cusoLandingLobby.getNumberOfVisibleSmallGridImages();
		assertEquals(smallGridItemsNumber, smallGridTitlesNumber, "Number of small grid titles should be equal to total number of items");
		assertEquals(smallGridImagesNumber, smallGridTitlesNumber, "Number of small grid titles and images shold be equal");
		for (int smallGridItem = 1; smallGridItem <= smallGridItemsNumber; smallGridItem++) {
			assertFalse(cusoLandingLobby.getHrefValueOfSmallGridTitleNumber(smallGridItem).isEmpty(), "Small grid title should be hyperlink");
			assertFalse(cusoLandingLobby.getHrefValueOfSmallGridImageNumber(smallGridItem).isEmpty(), "Small grid image should be hyperlink");
		}
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "C204950"})
	@TestRail(id = "C204950")
	public void verifyGridFunctionality() {
		CusoLandingLobbyPage cusoLandingLobby = SiteNavigatorEH.goToCusoLandingLobbyPage();
		switch (Settings.getPlatform()) {
			case MOBILE:
				assertTrue(cusoLandingLobby.getNumberOfGridTables() == 1, "Should be 1 grid table on mobile");
				break;
			case TABLET:
				assertTrue(cusoLandingLobby.getNumberOfGridTables() == 2, "Should be 2 grid table on tablet");
				break;
			case DESKTOP:
				assertTrue(cusoLandingLobby.getNumberOfGridTables() == 3, "Should be 3 grid table on desktop");
				break;
		}
		int totalNumberOfGridItems = cusoLandingLobby.getNumberOfGridItems();
		int totalNumberOfGridImages = cusoLandingLobby.getNumberOfGridImages();
		int totalNumberOfGridTitles = cusoLandingLobby.getNumberOfGridTitles();
		assertEquals(totalNumberOfGridItems, totalNumberOfGridImages, "Total number of grid images should be equal to number of items in grid");
		assertEquals(totalNumberOfGridTitles, totalNumberOfGridImages, "Total number of grid images should be equal to number of titles in grid");
		for (int gridItemNumber = 1; gridItemNumber <= totalNumberOfGridItems; gridItemNumber++) {
			assertFalse(cusoLandingLobby.getHrefOfGridItemTitleNumber(gridItemNumber).isEmpty(), "Grid title should be hyperlink");
			assertFalse(cusoLandingLobby.getHrefOfGridItemImageNumber(gridItemNumber).isEmpty(), "Grid image should be hyperlink");
		}
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "C204949"})
	@TestRail(id = "C204949")
	public void verifySmallCarouselFunctionality() {
		CusoLandingLobbyPage cusoLandingLobby = SiteNavigatorEH.goToCusoLandingLobbyPage();

		assertTrue(cusoLandingLobby.isSmallCarouselTitlePresent(), "Small carousel title should be present");

		Logger.info("Verify content changes after navigation to next block of articles");
		int numberOfExpectedCarouselItems = getNumberOfExpectedCarouselItems();
		String firstColumnistTitle = cusoLandingLobby.getArticeNameForSmallCarousel(cusoLandingLobby.getFirstVisibleSmallCarouselArticleNumber());
		int numberOfSmallCarouselArticles = cusoLandingLobby.getNumberOfVisibleSmallCarouselArticles();
		assertEquals(numberOfSmallCarouselArticles, numberOfExpectedCarouselItems, "There should be " + numberOfExpectedCarouselItems + " visible on " + Settings.getPlatform());
		int numberOfVisibleSmallCarouselTitles = cusoLandingLobby.getNumberOfSmallCarouselTitles();
		int numberOfVisibleSmallCarouselImages = cusoLandingLobby.getNumberOfSmallCarouselImages();
		assertEquals(numberOfSmallCarouselArticles, numberOfVisibleSmallCarouselTitles, "Number of small carousel titles should be equal to number of visible articles");
		assertEquals(numberOfVisibleSmallCarouselImages, numberOfVisibleSmallCarouselTitles, "Number of small carousel images should be equal to number of visible titles");
		for (int articleNumber = 1; articleNumber <= numberOfSmallCarouselArticles; articleNumber++) {
			assertFalse(cusoLandingLobby.getHrefOfSmallCarouselTitleNumber(articleNumber).isEmpty(), "Small carousel title should be hyperlink");
			assertFalse(cusoLandingLobby.getHrefOfSmallCarouselImageNumber(articleNumber).isEmpty(), "Small carousel image should be hyperlink");
		}
		cusoLandingLobby.clickNextSmallCarouselButton();
		String firstColumnistTitleNextBlock = cusoLandingLobby.getArticeNameForSmallCarousel(cusoLandingLobby.getFirstVisibleSmallCarouselArticleNumber());
		assertNotEquals(firstColumnistTitle, firstColumnistTitleNextBlock, "After we open next block - text should be changed");
		for (int articleNumber = 1; articleNumber <= numberOfSmallCarouselArticles; articleNumber++) {
			assertFalse(cusoLandingLobby.getHrefOfSmallCarouselTitleNumber(articleNumber).isEmpty(), "Small carousel title should be hyperlink");
			assertFalse(cusoLandingLobby.getHrefOfSmallCarouselImageNumber(articleNumber).isEmpty(), "Small carousel image should be hyperlink");
		}
		String lastTitle = firstColumnistTitleNextBlock;

		Logger.info("Verify content changes back after navigation to previous item");
		cusoLandingLobby.clickPrevSmallCarouselButton();
		String firstColumnistTitlePrevBlock = cusoLandingLobby.getArticeNameForSmallCarousel(cusoLandingLobby.getFirstVisibleSmallCarouselArticleNumber());
		assertNotEquals(lastTitle, firstColumnistTitlePrevBlock, "After we open prev block - text should be changed");
	}

	private int getNumberOfExpectedCarouselItems() {
		if (Settings.isDesktop()) {
			return 3;
		} else if (Settings.isTablet()) {
			return 2;
		} else return 1;
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "C204948"})
	@TestRail(id = "C204948")
	public void verifyLargeCarouselFunctionality() {
		CusoLandingLobbyPage cusoLandingLobby = SiteNavigatorEH.goToCusoLandingLobbyPage();
		int totalNumberOfLargeCarouselItems = cusoLandingLobby.getTotalNumberOfLargeCarouselItems();
		int numberOfLargeCarouselTitles = cusoLandingLobby.getNumberOfVisibleLargeCarouselTitles();
		int numberOfLargeCarouselImages = cusoLandingLobby.getNumberOfVisibleLargeCarouselImages();
		assertEquals(totalNumberOfLargeCarouselItems, numberOfLargeCarouselImages, "Number of images in large carousel should be equal to total number of items");
		assertEquals(numberOfLargeCarouselTitles, numberOfLargeCarouselImages, "Number of titles in large carousel should be equal to total number of images");
		for (int itemNumber = 1; itemNumber <= totalNumberOfLargeCarouselItems; itemNumber++) {
			assertFalse(cusoLandingLobby.getHrefValueOfLargeCarouselTitle(itemNumber).isEmpty(), "Large carousel title should be hyperlink");
			assertFalse(cusoLandingLobby.getHrefValueOfLargeCarouselImage(itemNumber).isEmpty(), "Large carousel image should be hyperlink");
		}
		if (Settings.isDesktop()) {
			cusoLandingLobby.clickNextPrimaryCarouselButton();
			cusoLandingLobby.clickPrevPrimaryCarouselButton();
		}
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "C204947"})
	@TestRail(id = "C204947")
	public void verifyCusoLandingLobbyWidgets() {
		CusoLandingLobbyPage cusoLandingLobby = SiteNavigatorEH.goToCusoLandingLobbyPage();
		verifyCusoHeaderWidget(cusoLandingLobby, false);
		if (Settings.isDesktop()) {
			assertTrue(cusoLandingLobby.isRelatedListWidgetVisible(), "Related list widget is not visible");
			assertFalse(cusoLandingLobby.isRelatedListHeaderHrefEmpty(), "Related list header is not clickable");
			int numberOfItemsOnRelatedWidget = cusoLandingLobby.getNumberOfRelatedWidgetItems();
			assertTrue(numberOfItemsOnRelatedWidget >= 1, "Should be at least one featured article");
			assertEquals(numberOfItemsOnRelatedWidget, cusoLandingLobby.getNumberOfRelatedWidgetImages(), "Number of images on Related widget should be equal to total number of items");
			assertEquals(cusoLandingLobby.getNumberOfRelatedWidgetImages(), cusoLandingLobby.getNumberOfRelatedWidgetTitles(), "Number of titles on Related widget should be equal to total number of images");
			for (int itemNumber = 1; itemNumber <= numberOfItemsOnRelatedWidget; itemNumber++) {
				assertFalse(cusoLandingLobby.getHrefValueOfRelatedWidgetTitleNumber(itemNumber).isEmpty(), "Related widget title should be hyperlink");
				assertFalse(cusoLandingLobby.getHrefValueOfRelatedWidgetImageNumber(itemNumber).isEmpty(), "Related widget image should be hyperlink");
			}
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "C234658"})
	@TestRail(id = "C234658")
	public void verifyCusoLandingLobbyIsiWidget() {
		CusoLandingLobbyPage cusoLandingLobby = SiteNavigatorEH.goToCusoLandingLobbyPage();
		verifyISIWidgets(cusoLandingLobby);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "C234660"})
	@TestRail(id = "C234660")
	public void verifyCusoLandingLobbyIframeWidget() {
		CusoLandingLobbyPage cusoLandingLobby = SiteNavigatorEH.goToCusoLandingLobbyPage();

		assertTrue(cusoLandingLobby.getRightRailIframeWidgetLocation().equalsIgnoreCase("RightRail"), "Right rail iframe widget position is incorrect");
		assertTrue(cusoLandingLobby.isRightRailIframeWidgetVisible(), "Right rail iframe widget is not visible");

		assertEquals(cusoLandingLobby.getRightRailIframeWidgetHeight(), 250, "Right rail iframe widget height is incorrect");
		assertEquals(cusoLandingLobby.getRightRailIframeWidgetWidth(), 300, "Right rail iframe widget width is incorrect");

		Logger.info("Verify iFrame widget is below adDiv5 and ISI widget in right rail");
		assertTrue(cusoLandingLobby.getGoogleAd5YCoordinate() < cusoLandingLobby.getIframeWidgetYCoordinate(), "Iframe widget is not below Google ad 5");
		assertTrue(cusoLandingLobby.getISIWidgetYCoordinate() < cusoLandingLobby.getIframeWidgetYCoordinate(), "ISI widget is not on top of Iframe widget");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "C204945"})
	@TestRail(id = "C204945")
	public void verifySocialShareBarFunctionality() {
		CusoLandingLobbyPage cusoLandingLobby = SiteNavigatorEH.goToCusoLandingLobbyPage();
		SocialBarEH socialBarEH = cusoLandingLobby.onSocialBar();

		int socialBarXCoordinateValue = socialBarEH.getSocialShareBarXCoordinate();
		assertTrue(socialBarXCoordinateValue < cusoLandingLobby.getHeaderNavigationXCoordinateValue(), "Social bar should be on the left hand side");
		assertTrue(socialBarEH.isFacebookShareButtonVisible(), "'Facebook' share button should be visible");
		assertTrue(socialBarEH.isTwitterShareButtonVisible(), "'Twitter' share button should be visible");
		assertTrue(socialBarEH.isPinterestShareButtonVisible(), "'Pinterest' share button should be visible");
		assertTrue(socialBarEH.isEmailShareButtonVisible(), "'Email' share button should be visible");

		if (Settings.isDesktop()) {
			assertTrue(socialBarEH.isPrintShareButtonVisible(), "Print share button is not visible");
			socialBarEH.clickOnFacebookShareButton();
			Utils.waitFor(1500);
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event93", "'event93' should fire after FB button click");
			socialBarEH.verifyFacebookPopUpContainsFacebook();

			socialBarEH.clickOnTwitterShareButton();
			Utils.waitFor(1500);
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event94", "'event94' should fire after Twitter button click");
			socialBarEH.verifyTwitterPopUpContainsTwitter();

			socialBarEH.clickOnPinterestShareButton();
			Utils.waitFor(1500);
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event96", "'event96' should fire after Pinterest button click");
			socialBarEH.verifyPinterestPopUpContainsPinterest();

			if (Settings.browser.equals(framework.BrowserType.CHROME)) {
				socialBarEH.clickPrintShareButton();
				Utils.waitFor(1500);
				assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event98", "'event98' should fire after Print button click");
			}
		} else {
			assertTrue(socialBarEH.getFacebookShareLink().contains("facebook"), "Facebook button link does not contain 'facebook'");
			assertTrue(socialBarEH.getTwitterShareLink().contains("twitter"), "Twitter button link does not contain 'twitter'");
			assertTrue(socialBarEH.getPinterestShareLink().contains("pinterest"), "Pinterest button link does not contain 'pinterest'");
		}

		ShareViaEmailPopUp shareViaEmailPopUp = socialBarEH.clickEmailShareButton();
		Utils.waitFor(1500);
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event92", "'event92' should fire after Email button click");
		shareViaEmailPopUp.typeYourEmailFriendEmailAndSend(UserCacheEH.MAIN_USER.getEmail(), StringUtils.generateRandomEmail());
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks! Your email was sent"), "Sent email message is not visible");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyVisible(), "'Privacy Policy' is not visible");
		assertEquals(shareViaEmailPopUp.getPrivacyPolicyLinkText(), "Privacy Policy", "'Privacy Policy' text is not present");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyLinkPresent(), "'Privacy Policy' link is not present");
		shareViaEmailPopUp.clickSignUpButton();
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks for signing up!"), "Sent email message is not visible");
		shareViaEmailPopUp.closePopUp();
	}
}