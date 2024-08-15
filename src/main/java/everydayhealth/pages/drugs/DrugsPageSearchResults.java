package everydayhealth.pages.drugs;

import framework.Logger;
import framework.platform.html.WebObject;

import org.openqa.selenium.WebDriver;

public class DrugsPageSearchResults extends DrugsBasePage {
	
	public DrugsPageSearchResults(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "drugs";
		String CLASS_NAME = "DrugsPageSearchResults";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}
	
	protected WebObject searchResultsTitle;
	protected WebObject drugsSearchPositiveResultLabel;
	protected WebObject drugsSearchNegativeResultLabel;
	protected WebObject drugsSearchResultTitles;
	
	@Override
	public void waitForPageToLoad() {
		searchResultsTitle.waitUntilVisibleOnPage(this);
	}
	
	public boolean verifyPositiveSearchResult(String drugNameOrCondition) {
		Logger.info("Verifying the positive search results contains " + drugNameOrCondition);
		searchResultsTitle.waitUntilVisible();
		return drugsSearchPositiveResultLabel.getText().contains(drugNameOrCondition);
	}
	
	public String getSearchResultTitles(int elementNumber, String drugNameOrCondition) {
		Logger.info("Verifying the " + elementNumber + " search result title contains " + drugNameOrCondition);
		return drugsSearchResultTitles.getTextFromElementNumber(elementNumber).toLowerCase();
	}

	public String getNegativeSearchResultText(String INVALID_SEARCH_QUERY) {
		Logger.info("Verifying the negative search results text contains " + INVALID_SEARCH_QUERY);
		return drugsSearchNegativeResultLabel.getText();
	}
	
	public boolean isNegativeSearchParameterVisible() {
		Logger.info("Verifying the negative search results are visible");
		searchResultsTitle.waitUntilVisible();
		return drugsSearchNegativeResultLabel.isVisible();
	}

}
