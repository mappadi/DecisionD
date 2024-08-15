package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.drugs.DrugsBasePage;
import everydayhealth.pages.drugs.DrugsLandingPage;
import everydayhealth.pages.drugs.DrugsPageSearchResults;
import framework.Logger;
import framework.Settings;
import framework.platform.CookieName;
import framework.platform.SiteNavigatorEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.StringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Drugs Page Search Test Positive and Negative
 */

public class DrugsPageSearchTest {

	private final String SEARCH_QUERY = "insulin";
	private final String INVALID_SEARCH_QUERY = StringUtils.generateRandomStrAlphabetic(15);

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C189437"})
	@TestRail(id = "C189437")
	public void drugSearchPositive() {
		Logger.info("Verifying the Drug page Search, positive scenario: valid results");
		DrugsLandingPage drugsBasePage = SiteNavigatorEH.goToDrugsLandingPage();
		verifyDrugsPageElements(drugsBasePage);
		drugsBasePage.enterSearchText(SEARCH_QUERY);
		drugsBasePage.waitFor(5000); //allowing adequate time for REST service response
		for (int elementNumber = 1; elementNumber <= drugsBasePage.getNumberOfSearchSuggestions(); elementNumber++) {
			String searchSuggestion = drugsBasePage.getSearchSuggestionsText(elementNumber, SEARCH_QUERY);
			assertTrue(searchSuggestion.contains(SEARCH_QUERY), "Search suggestions auto population does not contain " + SEARCH_QUERY);
		}
		DrugsPageSearchResults drugsPageSearchResults = drugsBasePage.clickSearchButton();
		assertTrue(drugsPageSearchResults.verifyPositiveSearchResult(SEARCH_QUERY), "Search Result Label does not appear");
		Logger.info("Verifying the first 5 result titles contains the search query");
		for (int elementNumber = 1; elementNumber <= 5; elementNumber++) {
			String searchResultTitles = drugsPageSearchResults.getSearchResultTitles(elementNumber, SEARCH_QUERY);
			assertTrue(searchResultTitles.contains(SEARCH_QUERY), "Search result titles do not contain " + SEARCH_QUERY);
		}
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C189466"})
	@TestRail(id = "C189466")
	public void drugSearchNegative() {
		Logger.info("Verifying the Drug page Search, negative scenario: no results");
		DrugsLandingPage drugsBasePage = SiteNavigatorEH.goToDrugsLandingPage();
		verifyDrugsPageElements(drugsBasePage);
		drugsBasePage.enterSearchText(INVALID_SEARCH_QUERY);
		assertTrue(drugsBasePage.areNegativeSearchNoSuggestions(), "Search suggestions does not state 'No Suggestions' for negative test");
		DrugsPageSearchResults drugsPageSearchResults = drugsBasePage.clickSearchButton();
		assertTrue(drugsPageSearchResults.isNegativeSearchParameterVisible(), "Negative search result text is not visible");
		assertTrue(drugsPageSearchResults.getNegativeSearchResultText(INVALID_SEARCH_QUERY).contains(INVALID_SEARCH_QUERY), "Negative search result text does not contain " + INVALID_SEARCH_QUERY);
	}

	private void verifyDrugsPageElements(DrugsBasePage drugsBasePage) {
		assertTrue(drugsBasePage.isDrugsSearchFieldVisible(), "Search field is not visible");
		assertTrue(drugsBasePage.isDrugsSearchButtonVisible(), "Search button is not visible");
	}
}
