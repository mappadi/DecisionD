package everydayhealth.pages.conditions;

import everydayhealth.pages.articles.ArticleNewTemplatePage;
import framework.Logger;
import framework.platform.html.WebObject;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HealthAZLandingPage extends ArticleNewTemplatePage {

	public HealthAZLandingPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "conditionpages";
		String CLASS_NAME = "HealthAZLandingPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject header;
	protected WebObject navigationLettersSection;
	protected WebObject searchBox;
	protected WebObject searchButton;
	protected WebObject navigationLetters;
	protected WebObject navigationLettersWithLinks;
	protected WebObject mostSearchedConditions;
	protected WebObject groupTitleLetters;
	protected WebObject aboutHealthAtoZSectionContent;
	protected WebObject conditionsSearchAutoCompleteList;

	@Override
	public void waitForPageToLoad() {
		navigationLettersSection.waitUntilVisibleOnPage(this);
	}

	public String getPageTitle() {
		Logger.info("Get page title");
		return basedriver.getTitle();
	}

	public String getPageHeader() {
		Logger.info("Get page header");
		return header.getText();
	}

	public boolean isSearchBoxVisible() {
		Logger.info("Verifying conditions 'Search Box' is visible");
		return searchBox.isVisible();
	}

	public boolean isSearchButtonVisible() {
		Logger.info("Verifying conditions 'Search Button' is visible");
		return searchButton.isVisible();
	}

	public String getSearchBoxDefaultText() {
		Logger.info("Get 'Search Box' default text");
		return searchBox.getAttribute("placeholder");
	}

	public ArrayList<String> getNavigationLetters() {
		Logger.info("Getting navigation letters list from page");
		ArrayList<String> letters = new ArrayList<>();
		for (WebElement element : navigationLetters.getElements()) {
			letters.add(element.getText());
		}
		Logger.info("Remove first and last entry in list");
		letters.remove(letters.size() - 1);
		letters.remove(0);
		return letters;
	}

	public ArrayList<String> getGroupTitleLetters() {
		Logger.info("Getting Group Title Letters from content section");
		ArrayList<String> letters = new ArrayList<>();
		for (WebElement element : groupTitleLetters.getElements()) {
			letters.add(element.getText());
		}
		Logger.info("Remove first and last 2 entries in list, 'Most Searched Conditions' and 'About Health A-Z'");
		letters.remove(letters.size() - 1);
		letters.remove(letters.size() - 1);
		letters.remove(0);
		return letters;
	}

	public String getAboutHealthAtoZSectionHeading() {
		Logger.info("Get 'About Health A-Z' section heading");
		return groupTitleLetters.getTextFromElementNumber(groupTitleLetters.getElementsCount());
	}

	public String getAboutHealthAtoZSectionContent() {
		Logger.info("Get 'About Health A-Z' section content");
		return aboutHealthAtoZSectionContent.getText();
	}

	public String getRandomNavigationLetter() {
		Logger.info("Get random navigation letter");
		String letter = StringUtils.generateRandomStrAlphabetic(1).toLowerCase();
		Logger.debug("Letter: " + letter);
		while (navigationLettersWithLinks.getElements(letter).get(0).getAttribute("href").isEmpty()) {
			letter = StringUtils.generateRandomStrAlphabetic(1).toLowerCase();
		}
		return letter;
	}

	public void clickOnLetter(String letter) {
		Logger.info("Click on navigation letter " + letter);
		WebElement element = navigationLettersWithLinks.getElements(letter).get(0);
		Utils.scrollPage(element.getLocation().getY() - 1000);
		element.click();
		waitForAjaxRequestToBeFinished();
		waitFor(2000);//Wait for page to scroll
	}

	public boolean isLetterContentIsInViewport(String letter) {
		Logger.info("Verify target content locator is scrolled to viewport");
		return isInViewPort("#" + letter);
	}

	public int yCoordinateOfMostSeacrchedConditions() {
		Logger.info("Get Y-Coordinate Of 'Most Seacrched Conditions' section");
		return mostSearchedConditions.getElement().getLocation().y;
	}

	public boolean isMostSearchedConditionsSectionVisible(){
		Logger.info("Verify if 'Most Searched Conditions' section is visible");
		return mostSearchedConditions.isVisible();
	}

	public int yCoordinateOfLetterNavigationSection() {
		Logger.info("Get Y-Coordinate Of Letter navigation section");
		return navigationLettersSection.getElement().getLocation().y;
	}

	public void enterSearchText(String condition) {
		Logger.info("Entering a condition in Search box");
		searchBox.type(condition);
	}

	public int getNumberOfSearchSuggestions() {
		Logger.info("Get number of auto populated search suggestions");
		return conditionsSearchAutoCompleteList.getElementsCount();
	}

	public String getSearchSuggestionsText(int elementNumber) {
		Logger.info("Verifying the " + elementNumber + " auto populated search suggestion contains");
		return conditionsSearchAutoCompleteList.getTextFromElementNumber(elementNumber);
	}

	public <T> T clickSearchButtonAndGoToPage(Class<T> expectedPage) {
		Logger.info("Click on the Search Button"); //Using submit() instead of click() to avoid need of clicking twice on searchButton for results.
		searchButton.getElement().submit();
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(basedriver, expectedPage);
	}
}