package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.program.ProgramPage;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * LobbyListTest
 */
public class LobbyListTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "LobbyPage", "C235578"})
	@TestRail(id = "C235578")
	public void verifyRightColumnArticles() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.LOBBY_LIST_PAGE, ProgramPage.class);

		String adBlockImageHeight = programPage.getTile5ImageHeight();
		programPage.waitForMoreInButton();
		int numberOfStories = programPage.getNumberOfVisibleRelatedStories();
		if (adBlockImageHeight.equals("250")) {
			assertTrue(numberOfStories > 3, "More than 3 stories can be displayed if ad height is 250px");
		} else {
			assertTrue(numberOfStories < 3, "Less than 3 stories should be displayed if ad height is >250px");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "LobbyPage", "C235566"})
	@TestRail(id = "C235566")
	public void verifyLoginLogoutFunctionality() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.LOBBY_LIST_PAGE, ProgramPage.class);

		String currentURL = Utils.getCurrentURL();
		programPage.onGlobalNavHeader().clickLogin().enterCredentialsAndSubmitForm(UserCacheEH.MAIN_USER);
		assertTrue(programPage.onGlobalNavHeader().isLoggedIn(), "User should be logged in");
		assertEquals(Utils.getCurrentURL(), currentURL, "The same page should be opened for logged in user");
		programPage.onGlobalNavHeader().userLogOut();
		assertFalse(programPage.onGlobalNavHeader().isLoggedIn(), "User should not be logged in");
		assertEquals(Utils.getCurrentURL(), currentURL, "The same page should be opened for logged out user");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "LobbyPage", "C235567"})
	@TestRail(id = "C235567")
	public void verifyRecentTopicsSection() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.LOBBY_LIST_PAGE, ProgramPage.class);

		assertTrue(programPage.isRecentStoriesSectionVisible(), "'Recent topics' section should be visible");
		int recentStoriesCount = programPage.getRecentStoriesCount();
		assertEquals(recentStoriesCount, 11, "11 recent topics should be visible");
		for (int storyNumber = 1; storyNumber <= recentStoriesCount; storyNumber++) {
			assertTrue(programPage.isRecentStoriesImageNumberVisible(storyNumber), "Recent story image should be visible");
			assertTrue(programPage.isRecentStoriesTitleNumberVisible(storyNumber), "Recent story title should be visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "LobbyPage", "C235568"})
	@TestRail(id = "C235568")
	public void verifyMoreButtonFunctionality() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.LOBBY_LIST_PAGE, ProgramPage.class);

		int recentStoriesCount = programPage.getRecentStoriesCount();
		int recentStoriesAdBlocksCount = programPage.getRecentStoriesAdBlocksCount();
		assertEquals(recentStoriesCount, 11, "11 recent topics should be visible");
		assertEquals(recentStoriesAdBlocksCount, 1, "1 ad block should be shown in 'Recent stories' section");
		programPage.clickMoreButton();
		int recentStoriesCountDelta = programPage.getRecentStoriesCount() - recentStoriesCount;
		int recentStoriesAdBlocksCountDelta = programPage.getRecentStoriesAdBlocksCount() - recentStoriesAdBlocksCount;
		assertTrue(recentStoriesCountDelta <= 11 && recentStoriesCountDelta > 0, "Up to 11 more stories should be shown");
		assertEquals(recentStoriesAdBlocksCountDelta, 1, "1 more ad block should appear");
		assertFalse(programPage.isMoreButtonVisible(), "'More' button should not be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "LobbyPage", "C235564"})
	@TestRail(id = "C235564")
	public void verifyLobbyPageDesign() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.LOBBY_LIST_PAGE, ProgramPage.class);

		verifyBaseElementsOnLobbyPage(programPage);
		assertTrue(programPage.isRightRailModuleVisible(), "Right rail section should be visible");
		assertEquals(programPage.getLeadStoryImageSize(), "(750, 422)", "Lead story image size should be 750x422");
		int secondaryLeadStoriesCount = programPage.getSecondarySubNavigationSlideCount();
		for (int imageNumber = 0; imageNumber < secondaryLeadStoriesCount; imageNumber++) {
			assertEquals(programPage.getSecondaryLeadStoryImageSize(imageNumber), "(197, 197)", "Secondary lead story image size should be 229x229");
		}
		int recentStoriesCount = programPage.getRecentStoriesCount();
		for (int imageNumber = 0; imageNumber < recentStoriesCount; imageNumber++) {
			assertTrue(programPage.getRecentStoryImageSize(imageNumber).contains("360,"), "All recent stories images should have width=330");
		}

	}

	@Test(groups = {"EverydayHealthTablet", "EverydayHealthMobile", "LobbyPage", "C235582"})
	@TestRail(id = "C235582")
	public void verifyLobbyPageDesignMobile() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.LOBBY_LIST_PAGE, ProgramPage.class);

		verifyBaseElementsOnLobbyPage(programPage);
		Utils.rotateToLandscape();
		programPage.refresh();
		verifyBaseElementsOnLobbyPage(programPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "LobbyPage", "C235572"})
	@TestRail(id = "C235572")
	public void verifySecondaryLeadStories() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.LOBBY_LIST_PAGE, ProgramPage.class);

		int secondaryLeadStoriesCount = programPage.getSecondarySubNavigationSlideCount();
		assertTrue(secondaryLeadStoriesCount > 0 && secondaryLeadStoriesCount <= 6, "Up to 6 secondary lead stories should load");
		assertEquals(programPage.getNumberOfSecondaryStoriesImages(), secondaryLeadStoriesCount, "Number of images should be equal to number of slides");
		assertEquals(programPage.getNumberOfSecondaryStoriesTitles(), secondaryLeadStoriesCount, "Number of titles should be equal to number of slides");

		int firstVisibleStory = programPage.getFirstVisibleStoryNumber();
		programPage.clickNextSlideArrow();
		assertNotEquals(programPage.getFirstVisibleStoryNumber(), firstVisibleStory, "First story should not be visible");
		programPage.clickPreviousSlideArrow();
		assertEquals(programPage.getFirstVisibleStoryNumber(), firstVisibleStory, "First story should be visible");

		for (int storyNumber = 1; storyNumber <= secondaryLeadStoriesCount; storyNumber++) {
			assertEquals(programPage.getImageLinkNumber(storyNumber), programPage.getTitleLinkNumber(storyNumber), "Title and image should lead to the same url");
		}
	}

	private void verifyBaseElementsOnLobbyPage(ProgramPage programPage) {
		assertTrue(programPage.onGlobalNavHeader().isGlobalNavHeaderVisible(), "Header should be visible");
		assertTrue(programPage.onZDFooter().isEHLogoVisible(), "Footer logo should be visible");
		assertTrue(programPage.isLeadStoryBlockVisible(), "Lead story should be visible");
		assertTrue(programPage.isSecondaryLeadStoriesBlockVisible(), "Secondary lead stories block should be visible");
		assertTrue(programPage.isRecentStoriesSectionVisible(), "Recent topics section should be visible");
		int recentStoriesCount = programPage.getRecentStoriesCount();
		assertTrue(recentStoriesCount <= 11 && recentStoriesCount > 0, "Up to 11 recent stories should be loaded");
		if (Settings.isDesktop() || Settings.isTablet()) {
			assertTrue(programPage.isTopAdVisible(), "Top ad should be visible");
		}
		assertTrue(programPage.isAdDiv5Visible(), "adDiv5 should be visible");
	}
}