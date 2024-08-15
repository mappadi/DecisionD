package everydayhealth.pages.drugs;

import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.EHPublicPage;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DrugsBasePage extends BasicPageEH {

	public DrugsBasePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "drugs";
		String CLASS_NAME = "DrugsBasePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject drugsTitle;
	protected WebObject drugsSearchField;
	protected WebObject drugsSearchButton;
	protected WebObject drugsSearchAutoSuggestions;
	protected WebObject drugsSearchAutoCompleteList;
	protected WebObject drugsHeadline;
	protected WebObject drugsHeadlineTagline;
	protected WebObject drugsHeadlineTitle;
	protected WebObject drugsHeadlineSocialBar;
	protected WebObject breadcrumbs;
	protected WebObject breadcrumbLinks;
	protected WebObject breadcrumbsItems;
	protected WebObject mostSearchedDrugsSection;
	protected WebObject mostSearchedClassesSection;
	protected WebObject browseDrugsSection;
	protected WebObject browseDrugsSectionLetters;
	protected WebObject aboutDrugsSection;
	protected WebObject mostSearchedDrugsBlock;
	protected WebObject mostSearchedDrugsImages;
	protected WebObject mostSearchedDrugsNames;
	protected WebObject mostSearchedClassesTitle;

	@Override
	public void waitForPageToLoad() {
		drugsTitle.waitUntilVisibleOnPage(this);
	}

	public boolean isDrugsTitleVisible() {
		Logger.info("Verifying the 'Drugs' Category title is visible");
		return drugsTitle.isVisible();
	}

	public boolean isDrugsSearchFieldVisible() {
		Logger.info("Verifying the 'Search field' is visible");
		return drugsSearchField.isVisible();
	}

	public boolean isDrugsSearchButtonVisible() {
		Logger.info("Verifying the 'Search' button is visible");
		return drugsSearchButton.isVisible();
	}

	public void enterSearchText(String drugNameOrCondition) {
		Logger.info("Entering a condition in Search box");
		drugsSearchField.type(drugNameOrCondition);
		drugsSearchAutoSuggestions.waitUntilVisible();
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfSearchSuggestions() {
		Logger.info("Get number of auto populated search suggestions");
		drugsSearchAutoSuggestions.waitUntilVisibleOnPage(this); //waiting for the ul of suggestions before proceeding to count
		return drugsSearchAutoCompleteList.getElementsCount();
	}

	public String getSearchSuggestionsText(int elementNumber, String drugNameOrCondition) {
		Logger.info("Verifying the " + elementNumber + " auto populated search suggestion contains '" + drugNameOrCondition + "'");
		return drugsSearchAutoCompleteList.getTextFromElementNumber(elementNumber);
	}

	public boolean areNegativeSearchNoSuggestions() {
		Logger.info("Verifying auto populated text matches 'No Suggestions'");
		return drugsSearchAutoCompleteList.getText().contains("No Suggestions");
	}

	public DrugsPageSearchResults clickSearchButton() {
		Logger.info("Clicking on the Search Button");
		drugsSearchButton.click();
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(basedriver, DrugsPageSearchResults.class);
	}

	public boolean isDrugsHeadlineVisible() {
		Logger.info("Check if 'Drugs' headline is visible");
		return drugsHeadline.isVisible();
	}

	public boolean isMostSearchedDrugsSectionVisible() {
		Logger.info("Check if 'Most searched drugs' section is visible");
		return mostSearchedDrugsSection.isVisible();
	}

	public boolean isMostSearchedClassesSectionVisible() {
		Logger.info("Check if 'Most searched classes' section is visible");
		return mostSearchedClassesSection.isVisible();
	}

	public boolean isBrowseDrugsSectionVisible() {
		Logger.info("Check if 'Browse Drugs' section is visible");
		return browseDrugsSection.isVisible();
	}

	public boolean isAboutDrugsSectionVisible() {
		Logger.info("Check if 'About Drugs A-Z' section is visible");
		return aboutDrugsSection.isVisible();
	}

	public int getNumberOfDrugsInMostSearchedSection() {
		Logger.info("Get number of drugs in 'Most searched drugs' section");
		return mostSearchedDrugsBlock.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfImagesInMostSearchedSection() {
		Logger.info("Get number of drugs images in 'Most searched drugs' section");
		return mostSearchedDrugsImages.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfTitleInMostSearchedSection() {
		Logger.info("Get number of drugs titles in 'Most searched drugs' section");
		return mostSearchedDrugsNames.getNumberOfVisibleAndClickableElements();
	}

	public String getTitleTextNumber(int elementNumber) {
		Logger.info("Get text from title number #" + elementNumber);
		return mostSearchedDrugsNames.getTextFromElementNumber(elementNumber);
	}

	public String getLinkFromDrugNumber(int elementNumber) {
		Logger.info("Get 'href' attribute of drug block #" + elementNumber);
		return mostSearchedDrugsBlock.getHrefOfElementNumber(elementNumber);
	}

	public int getNumberOfClasses() {
		Logger.info("Get number of classes in 'Most searched classes' section");
		return mostSearchedClassesTitle.getNumberOfVisibleAndClickableElements();
	}

	public String getClassNumberTitle(int elementNumber) {
		Logger.info("Get title of class #" + elementNumber);
		return mostSearchedClassesTitle.getTextFromElementNumber(elementNumber);
	}

	public String getLinkFromDrugClassNumber(int elementNumber) {
		Logger.info("Get 'href' attribute of drug class #" + elementNumber);
		return mostSearchedClassesTitle.getHrefOfElementNumber(elementNumber);
	}

	public int getNumberOfElementsInBrowseDrugsSection() {
		Logger.info("Get number of elements in 'Browse drugs' section");
		return browseDrugsSectionLetters.getNumberOfVisibleAndClickableElements();
	}

	public String getSymbolFromBrowseDrugsSection(int elementNumber) {
		Logger.info("Get symbol #" + elementNumber);
		return browseDrugsSectionLetters.getTextFromElementNumber(elementNumber);
	}

	public String getLinkFromSymbolInBrowseDrugsSection(int elementNumber) {
		Logger.info("Get 'href' attribute of #" + elementNumber);
		return browseDrugsSectionLetters.getHrefOfElementNumber(elementNumber);
	}

	public boolean isTaglineVisible() {
		Logger.info("Check if tagline is visible");
		return drugsHeadlineTagline.isVisible();
	}

	public String getTitle() {
		Logger.info("Get title");
		return drugsHeadlineTitle.getText();
	}

	public boolean isSocialBarOnHeadlineVisible() {
		Logger.info("Check if social bar on headline is visible");
		return drugsHeadlineSocialBar.isVisible();
	}

	public boolean isBreadcrumbsVisible() {
		Logger.info("Check if breadcrumbs is visible");
		return breadcrumbs.isVisible();
	}

	public int getNumberOfBreadcrumbLinks() {
		Logger.info("Get number of hyperlinks in breadcrumbs");
		return breadcrumbLinks.getNumberOfVisibleAndClickableElements();
	}

	public String getBreadcrumbsLinksTextNumber(int linkNumber) {
		Logger.info("Get breadcrumbs links text");
		return breadcrumbLinks.getTextFromElementNumber(linkNumber);
	}

	public EHPublicPage clickFirstBreadcrumbsLink() {
		Logger.info("Click 'Everyday Health' breadcrumbs link");
		breadcrumbLinks.clickOnElementNumber(1);
		return PageFactory.initElements(basedriver, EHPublicPage.class);
	}

	public String getBreadcrumbLinkNumber(int hyperlinkNumber) {
		Logger.info("Get hyperlink #" + hyperlinkNumber);
		return breadcrumbLinks.getAttributeOfElementNumber(hyperlinkNumber, "href");
	}

	public String getBreadcrumbItemTitleNumber(int itemNumber) {
		Logger.info("Get breadcrumb non-hyperlink title");
		return breadcrumbsItems.getTextFromElementNumber(itemNumber);
	}
}
