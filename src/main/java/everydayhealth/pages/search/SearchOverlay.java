package everydayhealth.pages.search;

import everydayhealth.pages.GlobalNavHeader;
import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.platform.html.WebObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchOverlay extends GlobalNavHeader {

	public SearchOverlay(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "search";
		String CLASS_NAME = "SearchOverlay";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject searchOverlayPageSearchInput;
	protected WebObject searchOverlayPageAutoSuggestionsList;
	protected WebObject searchForm;
	protected WebObject magnifyingGlassIcon;
	protected WebObject clearButton;
	protected WebObject searchOverlay;

	@Override
	public void waitForPageToLoad() {
		searchOverlay.waitUntilVisibleOnPage(this);
	}

	public void enterSearchTerm(String search) {
		Logger.info("Entering search term as " + search);
		searchOverlayPageSearchInput.type(search);
	}

	public String getTextFromSearchInput() {
		Logger.info("Get text from search input");
		return searchOverlayPageSearchInput.getAttribute("value");
	}

	public String getPlaceholderText() {
		Logger.info("Get placeholder text from search input");
		return searchOverlayPageSearchInput.getAttribute("placeholder");
	}

	public boolean isAutosuggestionsListVisible() {
		Logger.info("Verify autosuggestions list is visible");
		return searchOverlayPageAutoSuggestionsList.isVisible();
	}

	public SearchResultPage clickOnSearch() {
		Logger.info("Clicking on the search");
		searchOverlayPageAutoSuggestionsList.clickOnElementNumber(1);
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(WebDriverManager.getDriver(), SearchResultPage.class);
	}

	public SearchResultPage clickOnSearchNegative() {
		Logger.info("Entering the Negative Search term in the Site search");
		searchOverlayPageSearchInput.sendKeys(Keys.ENTER);
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(basedriver, SearchResultPage.class);
	}

	public boolean isSearchFormVisible() {
		Logger.info("Verify if search form is visible");
		return searchForm.isVisible();
	}

	public boolean isMagnifyingGlassIconVisible() {
		Logger.info("Verify if magnifying glass icon is visible on search form");
		return magnifyingGlassIcon.isVisible();
	}

	public boolean isClearButtonVisible() {
		Logger.info("Verify if 'Clear' button is visible on search form");
		return clearButton.isVisible();
	}

	public void clickClearButton() {
		Logger.info("Click 'Clear' button");
		clearButton.click();
		waitForAjaxRequestToBeFinished();
	}
}
