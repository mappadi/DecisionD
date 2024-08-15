package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.GlobalNavHeader;
import everydayhealth.pages.search.SearchOverlay;
import everydayhealth.pages.search.SearchResultPage;
import framework.Logger;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Site Search Page Test Positive and Negative
 */

public class SiteSearchTest {

	private final String SEARCH_QUERY = "Diabetes";
	private final String EMPTY_HTML_TAG = "<>";
	private final String INVALID_SEARCH_QUERY = StringUtils.generateRandomStrAlphabetic(15);

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SiteSearch", "C190745"})
	@TestRail(id = "C190745")
	public void siteSearchHomePage() {
		siteSearchGlobalNav(TemplatesEH.HOMEPAGE);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SiteSearch", "C193485"})
	@TestRail(id = "C193485")
	public void siteSearchArticleV3() {
		siteSearchGlobalNav(TemplatesEH.ARTICLE_V3);
	}


	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SiteSearch", "C193524"})
	@TestRail(id = "C193524")
	public void siteSearchSlideShow() {
		siteSearchGlobalNav(TemplatesEH.SLIDESHOW);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SiteSearch", "C193525"})
	@TestRail(id = "C193525")
	public void siteSearchArticleV3WithVideo() {
		siteSearchGlobalNav(TemplatesEH.ARTICLE_VIDEO_V3);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SiteSearch", "C193526"})
	@TestRail(id = "C193526")
	public void siteSearchInfographics() {
		siteSearchGlobalNav(TemplatesEH.INFOGRAPHIC);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "BlogLandingTest", "C330396"})
	@TestRail(id = "C330396")
	public void siteSearchBlogsSingleAuthorLandingPage() {
		siteSearchGlobalNav(TemplatesEH.BLOG_LANDING_SINGLE_AUTHOR);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "BlogLandingTest", "C329779"})
	@TestRail(id = "C329779")
	public void siteSearchBlogsMultipleAuthorLandingPage() {
		siteSearchGlobalNav(TemplatesEH.BLOG_LANDING_MULTIPLE_AUTHORS);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SiteSearch", "C238582"})
	@TestRail(id = "C238582")
	public void siteSearchDrugsLanding() {
		siteSearchGlobalNav(TemplatesEH.DRUGS_LANDING);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SiteSearch", "C238587"})
	@TestRail(id = "C238587")
	public void siteSearchDrugsProfile() {
		siteSearchGlobalNav(TemplatesEH.DRUGS_PROFILE);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SiteSearch", "C238592"})
	@TestRail(id = "C238592")
	public void siteSearchDrugsReview() {
		siteSearchGlobalNav(TemplatesEH.DRUGS_REVIEW);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SiteSearch", "C238593"})
	@TestRail(id = "C238593")
	public void siteSearchDrugsSearch() {
		siteSearchGlobalNav(TemplatesEH.DRUGS_SEARCH);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SiteSearch", "C238596"})
	@TestRail(id = "C238596")
	public void siteSearchDrugsByClass() {
		siteSearchGlobalNav(TemplatesEH.DRUGS_BY_CLASS);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "SiteSearch", "C238601"})
	@TestRail(id = "C238601")
	public void siteSearchDrugsByLetter() {
		siteSearchGlobalNav(TemplatesEH.DRUGS_BY_LETTER);
	}

	private void siteSearchGlobalNav(TemplatesEH pageURL) {
		BasicPageEH basicPageEH = SiteNavigatorEH.goToBasicPageEH(pageURL);
		GlobalNavHeader globalNavHeader = basicPageEH.onGlobalNavHeader();

		assertTrue(globalNavHeader.isSearchIconVisible(), "Search icon (magnifying glass) should be visible");
		if (!Settings.isMobile()) {
			assertTrue(globalNavHeader.isSearchLabelVisible(), "'Search' label should be visible");
		}
		SearchOverlay searchOverlay = globalNavHeader.clickSearchButton();
		assertTrue(globalNavHeader.isSearchOverlayVisible(), "Search overlay should be visible");
		globalNavHeader.clickSearchCloseIcon();
		assertFalse(globalNavHeader.isSearchOverlayVisible(), "Search overlay should not be visible");
		globalNavHeader.clickSearchButton();

		Logger.info("Valid search query");
		assertTrue(searchOverlay.isSearchFormVisible(), "Search form should be visible");
		assertTrue(globalNavHeader.isSearchCloseIconVisible(), "Search close (X) icon should be visible");
		assertTrue(globalNavHeader.isSearchCloseIconGreen(), "Search close (X) icon should be green");
		assertTrue(searchOverlay.isMagnifyingGlassIconVisible(), "Magnifying glass icon should be visible");
		assertTrue(searchOverlay.getTextFromSearchInput().isEmpty(), "Search input value should be empty");
		assertEquals(searchOverlay.getPlaceholderText(), "Search Everyday Health", "Placeholder text should be 'Search Everyday Health'");

		Logger.info("Verify 'Clear' button functionality");
		searchOverlay.enterSearchTerm(SEARCH_QUERY);
		assertTrue(searchOverlay.isClearButtonVisible(), "'Clear' button should be visible");
		assertEquals(searchOverlay.getTextFromSearchInput(), SEARCH_QUERY, "Search input should contain search query");
		searchOverlay.clickClearButton();
		assertTrue(searchOverlay.getTextFromSearchInput().isEmpty(), "Search input should not contain search term");
		assertNotEquals(searchOverlay.getTextFromSearchInput(), SEARCH_QUERY, "Search input should not contain search query");
		searchOverlay.enterSearchTerm(SEARCH_QUERY);
		SearchResultPage searchResultPage = searchOverlay.clickOnSearch();

		Logger.info("Verify search result page content");
		assertTrue(searchResultPage.isSearchResultNumberContainsTerm(1, SEARCH_QUERY), "At least first search result should contain search term");
		assertTrue(searchResultPage.isSiteSearchResultsSearchBoxVisible(), "Search input should be visible on search result page");
		assertTrue(searchResultPage.getTextFromSearchInput().equalsIgnoreCase(SEARCH_QUERY), "Search term should be present in search input");
		assertTrue(searchResultPage.isSiteSearchResultsSearchButtonVisible(), "'Search' button should be present on search result page");
		assertTrue(searchResultPage.isViewMoreButtonVisible(), "'View more' button should be visible");
		assertEquals(searchResultPage.getNumberOfSearchResults(), 10, "10 results should be visible on results page");
		searchResultPage.clickViewMoreButton();
		assertEquals(searchResultPage.getNumberOfSearchResults(), 20, "20 results should be visible on results page ");
		assertTrue(Utils.getCurrentURL().contains("?iid=gnav_head_search"), "URL should be appended with '?iid=gnav_head_search'");
		BasicPageEH.clickBackBrowserButton(BasicPageEH.class);

		Logger.info("Invalid search query");
		if (!Settings.isMobile()) {
			searchOverlay = globalNavHeader.clickSearchButton();
		}
		searchOverlay.enterSearchTerm(INVALID_SEARCH_QUERY);
		assertTrue(searchOverlay.isClearButtonVisible(), "'Clear' button should be visible");
		assertFalse(searchOverlay.isAutosuggestionsListVisible(), "Autosuggestions list should not be visible");
		searchResultPage = searchOverlay.clickOnSearchNegative();
		assertEquals(searchResultPage.getTextFromSearchInput(), INVALID_SEARCH_QUERY.toLowerCase(), "Search term should be present in search input");
		assertTrue(searchResultPage.isSiteSearchNegativeResultLabelVisible(), "'Sorry, we didn't find any matches for %SEARCH_QUERY% should be visible'");
		assertTrue(searchResultPage.isNegativeResultLabelContainsSearchTerm(INVALID_SEARCH_QUERY), "Negative result label should contain search term");
		assertTrue(searchResultPage.isCommonHealthConditionsLabelVisible(), "'Common Health Conditions' label should be visible");
		assertTrue(searchResultPage.isCommonHealthConditionsListVisible(), "List of common conditions should be visible");
		assertTrue(searchResultPage.isCommonHealthConditionsSeeAllConditionsLinkVisible(), "'See all conditions' link should be visible");
		assertTrue(Utils.getCurrentURL().contains("?iid=gnav_head_search"), "URL should be appended with '?iid=gnav_head_search'");
		BasicPageEH.clickBackBrowserButton(BasicPageEH.class);

		Logger.info("Empty tag as search query");
		if (!Settings.isMobile()) {
			searchOverlay = globalNavHeader.clickSearchButton();
		}
		searchOverlay.enterSearchTerm(EMPTY_HTML_TAG);
		assertTrue(searchOverlay.isClearButtonVisible(), "'Clear' button should be visible");
		assertFalse(searchOverlay.isAutosuggestionsListVisible(), "Autosuggestions list should not be visible");
		searchResultPage = searchOverlay.clickOnSearchNegative();
		assertEquals(searchResultPage.getTextFromSearchInput(), " ", "Search input should be empty");
		assertTrue(searchResultPage.isCommonHealthConditionsLabelVisible(), "'Common Health Conditions' label should be visible");
		assertTrue(searchResultPage.isCommonHealthConditionsListVisible(), "List of common conditions should be visible");
		assertTrue(searchResultPage.isCommonHealthConditionsSeeAllConditionsLinkVisible(), "'See all conditions' link should be visible");
		assertTrue(Utils.getCurrentURL().contains("?iid=gnav_head_search"), "URL should be appended with '?iid=gnav_head_search'");
	}
}