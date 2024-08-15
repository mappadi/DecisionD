package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.conditions.HealthAZLandingPage;
import everydayhealth.pages.search.SearchResultPage;
import framework.Logger;
import framework.Settings;
import framework.platform.CookieName;
import framework.platform.SiteNavigatorEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.StringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Health A-Z Test (/conditions/ URL)
 */
public class HealthAZLandingPageTest extends WidgetsBaseTest {

	private final String VALID_SEARCH_QUERY = "flu";
	private final String INVALID_SEARCH_QUERY = StringUtils.generateRandomStrAlphabetic(15);

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HealthAZ", "C191003"})
	@TestRail(id = "C191003")
	public void verifyHealthAlphabetNavigation() {
		HealthAZLandingPage healthAZLandingPage = SiteNavigatorEH.goToHealthAZLandingPage();

		assertEquals(healthAZLandingPage.getPageTitle(), "Health A-Z | Everyday Health", "Page title is not 'Health A-Z | Everyday Health'");
		assertEquals(healthAZLandingPage.getPageHeader(), "Health A-Z", "Page header text is not 'Health A-Z'");
		assertTrue(healthAZLandingPage.isSearchBoxVisible(), "Search box not visible");
		assertTrue(healthAZLandingPage.isSearchButtonVisible(), "Search button not visible");
		assertEquals(healthAZLandingPage.getSearchBoxDefaultText(), "Enter condition or topic (e.g., Psoriasis)", "Search box default text mismatch");

		assertEquals(healthAZLandingPage.getNavigationLetters(), StringUtils.getAlphabetCharacters(), "Verification of presense of A-Z letters on letter navigation section failed");

		Logger.info("Verify clicking on letters from letter navigation section scrolls page to respective letter content section");
		String testLetter = healthAZLandingPage.getRandomNavigationLetter();
		healthAZLandingPage.clickOnLetter(testLetter);
		assertTrue(healthAZLandingPage.isLetterContentIsInViewport(testLetter), testLetter + " section is not in viewport");

		Logger.info("Verify most searched conditions section is below letter navigation section");
		assertTrue(healthAZLandingPage.isMostSearchedConditionsSectionVisible(), "'Most Searched Conditions' should be visible");
		assertTrue(healthAZLandingPage.yCoordinateOfMostSeacrchedConditions() > healthAZLandingPage.yCoordinateOfLetterNavigationSection(), "'Most Searched Conditions' section is not below the letter navigation section");

		assertEquals(healthAZLandingPage.getGroupTitleLetters(), StringUtils.getAlphabetCharacters(), "Verification of presense of A-Z letters on letter content section failed");

		Logger.info("Verify Back To Top link");
		assertTrue(healthAZLandingPage.isBackToTopVisible(), "Back to top button is not visible");

		Logger.info("Verify 'About Health A-Z' section");
		assertEquals(healthAZLandingPage.getAboutHealthAtoZSectionHeading(), "About Health A-Z", "Verification of 'About Health A-Z'section heading failed");
		assertFalse(healthAZLandingPage.getAboutHealthAtoZSectionContent().isEmpty(), "'About Health A-Z' section content empty");
		if (Settings.isDesktop()) {
			assertTrue(healthAZLandingPage.isTopAdVisible(), "Leader1 ad should be visible");
			assertTrue(healthAZLandingPage.isBottomAdVisible(), "Leaderextra ad should be visible");
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HealthAZ", "C191322"})
	@TestRail(id = "C191322")
	public void healthAZSearchPositive() {
		Logger.info("Verifying the Conditions page Search, positive scenario");
		HealthAZLandingPage healthAZLandingPage = SiteNavigatorEH.goToHealthAZLandingPage();
		assertTrue(healthAZLandingPage.isSearchBoxVisible(), "Search box not visible");
		assertTrue(healthAZLandingPage.isSearchButtonVisible(), "Search button not visible");

		healthAZLandingPage.enterSearchText(VALID_SEARCH_QUERY);
		for (int elementNumber = 1; elementNumber <= healthAZLandingPage.getNumberOfSearchSuggestions(); elementNumber++) {
			assertTrue(healthAZLandingPage.getSearchSuggestionsText(elementNumber).contains(VALID_SEARCH_QUERY), "Search suggestions auto population does not contain " + VALID_SEARCH_QUERY);
		}

		SearchResultPage searchResultPage = healthAZLandingPage.clickSearchButtonAndGoToPage(SearchResultPage.class);
		assertTrue(searchResultPage.isSiteSearchResultsSearchBoxVisible(), "Results page Search box does not exist");
		assertTrue(searchResultPage.isSiteSearchResultsSearchButtonVisible(), "Results page Search Button does not exist");
		assertTrue(searchResultPage.validateNumberOfResultsLabelData("10"), "Number of results should be 10");
		assertEquals(searchResultPage.getNumberOfSearchResults(), 10, "10 results shoud be visible");
		assertTrue(searchResultPage.isViewMoreButtonVisible(), "View More button not visible");
		searchResultPage.clickViewMoreButton();
		assertTrue(searchResultPage.validateNumberOfResultsLabelData("20"), "Number of results does not match after clicking View More button");
		assertEquals(searchResultPage.getNumberOfSearchResults(), 20, "20 results shoud be visible");
		Logger.info("Verifying the first result title contains the search query");
		assertTrue(searchResultPage.getSearchResultTitles(1).contains(VALID_SEARCH_QUERY), "Search result title does not contain " + VALID_SEARCH_QUERY);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HealthAZ", "C191323"})
	@TestRail(id = "C191323")
	public void healthAZSearchNegative() {
		Logger.info("Verifying the Conditions page Search, Negative scenario");
		HealthAZLandingPage healthAZLandingPage = SiteNavigatorEH.goToHealthAZLandingPage();
		assertTrue(healthAZLandingPage.isSearchBoxVisible(), "Search box not visible");
		assertTrue(healthAZLandingPage.isSearchButtonVisible(), "Search button not visible");
		healthAZLandingPage.enterSearchText(INVALID_SEARCH_QUERY);
		assertEquals(healthAZLandingPage.getNumberOfSearchSuggestions(), 0, "Search suggestions list is not blank for negative test");

		SearchResultPage searchResultPage = healthAZLandingPage.clickSearchButtonAndGoToPage(SearchResultPage.class);
		assertTrue(searchResultPage.isSiteSearchNegativeResultLabelVisible(), "Negative result label was not displayed");
		assertTrue(searchResultPage.isNegativeResultLabelContainsSearchTerm(INVALID_SEARCH_QUERY), "Negative result label should contain search term");
		assertTrue(searchResultPage.isCommonHealthConditionsLabelVisible(), "Common Health Conditions Label does not exist in search results page");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HealthAZ", "C505418"})
	@TestRail(id = "C505418")
	public void verifyPromoBannerSectionOnAtoZPage() {
		HealthAZLandingPage healthAZLandingPage = SiteNavigatorEH.goToHealthAZLandingPage();

		verifyPromoBannerSection(healthAZLandingPage);
	}
}