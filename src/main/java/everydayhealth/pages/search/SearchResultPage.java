package everydayhealth.pages.search;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasicPageEH {

	public SearchResultPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "search";
		String CLASS_NAME = "SearchResultPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject siteSearchResultsSearchBox;
	protected WebObject siteSearchResultsSearchButton;
	protected WebObject siteSearchResultsTitle;
	protected WebObject siteSearchResultsTitleWithText;
	protected WebObject viewMoreButton;
	protected WebObject loadingIcon;
	protected WebObject searchResultsCounter;
	protected WebObject siteSearchNegativeResultLabel;
	protected WebObject siteSearchResultsCommonHealthConditionsLabel;
	protected WebObject siteSearchResultsCommonHealthConditionsList;
	protected WebObject siteSearchResultsCommonHealthSeeAllConditionsLink;

	@Override
	public void waitForPageToLoad() {
		siteSearchResultsSearchBox.waitUntilVisibleOnPage(this);
	}

	public boolean isSiteSearchResultsSearchBoxVisible() {
		Logger.info("Verify the Search Box in the site search results page");
		return siteSearchResultsSearchBox.isVisible();
	}

	public String getTextFromSearchInput() {
		Logger.info("Get text from search input");
		return siteSearchResultsSearchBox.getAttribute("value");
	}

	public boolean isSiteSearchResultsSearchButtonVisible() {
		Logger.info("Verifying the Search Button in the site search results page");
		return siteSearchResultsSearchButton.isVisible();
	}

	public int getNumberOfSearchResults() {
		Logger.info("Get number of search results");
		return siteSearchResultsTitle.getVisibleElementsCount();
	}

	public boolean isSearchResultNumberContainsTerm(int resultNumber, String term) {
		Logger.info("Verify if search result #" + resultNumber + " contains search term '" + term + "'");
		return siteSearchResultsTitleWithText.isElementWithTextVisible(term, resultNumber);
	}

	public String getSearchResultTitles(int elementNumber) {
		Logger.info("Verifying the " + elementNumber + " search result title contains");
		return siteSearchResultsTitle.getTextFromElementNumber(elementNumber).toLowerCase();
	}

	public boolean validateNumberOfResultsLabelData(String count) {
		Logger.info("Verifying the number of results");
		return searchResultsCounter.getText().contains("Showing 1-" + count);
	}

	public boolean isViewMoreButtonVisible() {
		Logger.info("Verifying the 'View More' button is visilble");
		return viewMoreButton.isVisible();
	}

	public void clickViewMoreButton() {
		Logger.info("Clicking View More button");
		viewMoreButton.click();
		loadingIcon.waitUntilInvisible();
	}

	public boolean isSiteSearchNegativeResultLabelVisible() {
		Logger.info("Verify if negative result label is visible");
		return siteSearchNegativeResultLabel.isVisible();
	}

	public boolean isNegativeResultLabelContainsSearchTerm(String SEARCH_QUERY) {
		Logger.info("Verify if negative result label contains search term");
		return siteSearchNegativeResultLabel.getText().contains(SEARCH_QUERY.toLowerCase());
	}

	public boolean isCommonHealthConditionsLabelVisible() {
		Logger.info("Verifying the 'Common Health Conditions' Label in search results page");
		return siteSearchResultsCommonHealthConditionsLabel.isVisible();
	}

	public boolean isCommonHealthConditionsListVisible() {
		Logger.info("Verify if 'Common Health Conditions' list is visible");
		return siteSearchResultsCommonHealthConditionsList.isVisible();
	}

	public boolean isCommonHealthConditionsSeeAllConditionsLinkVisible() {
		Logger.info("Verify if 'See all conditions' link is visible");
		return siteSearchResultsCommonHealthSeeAllConditionsLink.isVisible();
	}
}
