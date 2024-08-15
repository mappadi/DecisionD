package everydayhealth.pages;

import everydayhealth.pages.drugs.DrugsLandingPage;
import everydayhealth.pages.registrations.ToolsRegistrationPage;
import everydayhealth.pages.tools.CalorieCounterPage;
import everydayhealth.pages.tools.MealPlannerPage;
import everydayhealth.pages.tools.NewslettersPage;
import everydayhealth.pages.tools.RecipesPage;
import everydayhealth.pages.tools.SymptomCheckerPage;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class EHPublicPage extends BasicPageEH {

	public EHPublicPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "";
		String CLASS_NAME = "MainPublicPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject toolsNewsletters;
	protected WebObject toolsSymptomChecker;
	protected WebObject toolsDrugFinder;
	protected WebObject toolsCalorieCounter;
	protected WebObject toolsMealPlanner;
	protected WebObject toolsRecipes;
	protected WebObject toolsSprites;
	protected WebObject moreButton;
	protected WebObject gridBlock;
	protected WebObject gridBlockImage;
	protected WebObject gridBlockHeader;
	protected WebObject gridBlockHeaderLink;
	protected WebObject gridBlockTitle;
	protected WebObject everydaySolutions;
	protected WebObject everydaySolutionsExpandButton;
	protected WebObject everydaySolutionsDisclaimer;
	protected WebObject everydaySolutionsSeeAll;
	protected WebObject everydaySolutionsContentLinks;
	protected WebObject everydaySolutionsContentColumn;
	protected WebObject everydaySolutionsContentColumnLink;
	protected WebObject rightRailImage;
	protected WebObject rightRailBlocks;
	protected WebObject rightRailTitle;
	protected WebObject rightRailBlockHeader;
	protected WebObject rightRailBlockHeaderWithPlainText;
	protected WebObject everydayHealthUpdatesHeader;
	protected WebObject everydayHealthUpdatesLinks;
	protected WebObject columnistsSection;
	protected WebObject columnistSlides;
	protected WebObject columnistPreviousSlider;
	protected WebObject columnistNextSlider;
	protected WebObject columnistTitle;
	protected WebObject primaryLeadSection;
	protected WebObject primaryLeads;
	protected WebObject primaryLeadActiveTitle;
	protected WebObject primaryLeadNextSlider;
	protected WebObject primaryLeadDate;
	protected WebObject primaryLeadDotControls;
	protected WebObject primaryLeadTitles;
	protected WebObject primaryLeadImages;

	@Override
	public void waitForPageToLoad() {
		gridBlock.waitUntilVisibleOnPage(this);
	}

	public int getNumberOfToolsImageSprites() {
		Logger.info("Getting number of visible 'tools' image sprites");
		toolsSprites.scrollToElement();
		return toolsSprites.getVisibleElementsCount();
	}

	public int getNumberOfClickableRightRailImages() {
		Logger.info("Getting number of visible images on the right rail");
		rightRailImage.scrollToElement();
		return rightRailImage.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfClickableRightRailBlocks() {
		Logger.info("Getting number of visible blocks on the right rail");
		rightRailBlocks.scrollToElement();
		return rightRailBlocks.getNumberOfVisibleAndClickableElements();
	}

	public String getGridBlockHeaderText(int blockNumber) {
		Logger.info("Get grid block #" + blockNumber);
		return gridBlockHeader.getTextFromElementNumber(blockNumber);
	}

	public int getNumberOfClickableHeaders(String headerPosition) {
		if (headerPosition.contains("rightRail")) {
			Logger.info("Get number of clickable headers in right rail blocks");
			rightRailBlockHeaderWithPlainText.scrollToElement();
			if (rightRailBlockHeader.getNumberOfVisibleAndClickableElements() < 2) {
				Logger.info("If right rail block header contains text 'EVERYDAY SOLUTIONS', it does not have link");
				int rightRailBlockHeaderCountWithPlainText = rightRailBlockHeaderWithPlainText.getVisibleElementsCount();
				return rightRailBlockHeader.getNumberOfVisibleAndClickableElements() + rightRailBlockHeaderCountWithPlainText;
			} else {
				return rightRailBlockHeader.getNumberOfVisibleAndClickableElements();
			}
		} else {
			Logger.info("Get number of clickable headers in grid blocks");
			return gridBlockHeaderLink.getNumberOfVisibleAndClickableElements();
		}
	}

	public int getNumberOfClickableRightRailTitles() {
		Logger.info("Getting number of visible titles on the right rail");
		rightRailTitle.scrollToElement();
		return rightRailTitle.getNumberOfVisibleAndClickableElements();
	}

	public NewslettersPage clickToolsNewsletters() {
		Logger.info("Clicking 'Newsletter tool' while not logged in on the Home Page");
		toolsNewsletters.scrollToElement();
		toolsNewsletters.click();
		waitForAjaxRequestToBeFinished();
		return new NewslettersPage(basedriver);
	}

	public ToolsRegistrationPage clickToolsCalorieCounterRegistration() {
		//call this method when main user is not logged in
		Logger.info("Clicking 'Calorie Counter tool' while not logged in on the Home Page");
		toolsCalorieCounter.scrollToElement();
		toolsCalorieCounter.click();
		waitForAjaxRequestToBeFinished();
		return new ToolsRegistrationPage(basedriver);
	}

	public ToolsRegistrationPage clickToolsMealPlannerRegistration() {
		//call this method when main user is not logged in
		Logger.info("Clicking 'Meal Planner tool' while not logged in on the Home Page");
		toolsMealPlanner.scrollToElement();
		toolsMealPlanner.click();
		waitForAjaxRequestToBeFinished();
		return new ToolsRegistrationPage(basedriver);
	}

	public SymptomCheckerPage clickToolsSymptomChecker() {
		Logger.info("Clicking 'Symptom checker tool'");
		toolsSymptomChecker.scrollToElement();
		toolsSymptomChecker.click();
		waitForAjaxRequestToBeFinished();
		return new SymptomCheckerPage(basedriver);
	}

	public CalorieCounterPage clickToolsCalorieCounter() {
		//call this method when main user is logged in
		Logger.info("Clicking 'Calorie Counter tool' while logged in on the Home Page");
		toolsCalorieCounter.scrollToElement();
		toolsCalorieCounter.click();
		waitForAjaxRequestToBeFinished();
		return new CalorieCounterPage(basedriver);
	}

	public MealPlannerPage clickToolsMealPlanner() {
		//call this method when main user is logged in
		Logger.info("Clicking 'Meal Planner tool' while logged in on the Home Page");
		toolsMealPlanner.scrollToElement();
		toolsMealPlanner.click();
		waitForAjaxRequestToBeFinished();
		return new MealPlannerPage(basedriver);
	}

	public DrugsLandingPage clickToolsDrugFinder() {
		Logger.info("Clicking 'Drug Finder tool' on the Home Page");
		toolsDrugFinder.scrollToElement();
		toolsDrugFinder.click();
		return new DrugsLandingPage(basedriver);
	}

	public RecipesPage clickToolsRecipes() {
		Logger.info("Clicking 'Recipe Finder tool' on the Home Page");
		toolsRecipes.scrollToElement();
		toolsRecipes.click();
		return new RecipesPage(basedriver);
	}

	public boolean isMoreButtonVisible() {
		Logger.info("Check 'More' button is visible on the Home Page");
		moreButton.scrollToElement();
		return moreButton.isVisible();
	}

	public int getNumberOfGridBlocks() {
		gridBlock.scrollToElement();
		return gridBlock.getVisibleElementsCount();
	}

	public int getNumberOfClickableGridImages() {
		Logger.info("Get number of clickable images in grid blocks");
		gridBlockImage.scrollToElement();
		return gridBlockImage.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfClickableGridTitles() {
		Logger.info("Get number of clickable titles in grid blocks");
		gridBlockTitle.scrollToElement();
		return gridBlockTitle.getNumberOfVisibleAndClickableElements();
	}

	public String getGridBlockHrefValue(int blockNumber) {
		Logger.info("Get 'href' attribute value for grid block #" + blockNumber);
		return gridBlockTitle.getHrefOfElementNumber(blockNumber);
	}

	public EHPublicPage clickMoreButton() {
		Logger.info("Clicking the grid 'more' button");
		moreButton.scrollToElement();
		moreButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isEverydaySolutionsTitleVisible() {
		Logger.info("Verifying the 'Everyday Solutions' CUSO section title is visible");
		everydaySolutions.scrollToElement();
		return everydaySolutions.isVisible();
	}

	public boolean isEverydaySolutionsExpanded() {
		Logger.info("Verify if 'Everyday Solutions' section is expanded");
		return everydaySolutions.getAttribute("class").contains("open");
	}

	public boolean isEverydaySolutionsButtonVisible() {
		Logger.info("Verifying the 'Everyday Solutions' '+' button is visible");
		everydaySolutionsExpandButton.scrollToElement();
		return everydaySolutionsExpandButton.isVisible();
	}

	public boolean isEverydaySolutionsDisclaimerVisible() {
		Logger.info("Verifying the 'Everyday Solutions' CUSO section disclaimer is visible");
		if (Settings.isMobile()) {
			everydaySolutionsExpandButton.click();
			waitForAjaxRequestToBeFinished();
		}
		return everydaySolutionsDisclaimer.isVisible() && everydaySolutionsDisclaimer.getText().contains("sponsors");
	}

	public boolean isEverydaySolutionsSeeAllLinkSponsored() {
		Logger.info("Verifying the 'See All' link contains 'sponsors'");
		String hrefValue = everydaySolutionsSeeAll.getAttribute("href");
		boolean validLink = hrefValue.contains("sponsors") && hrefValue.startsWith("https://");
		return validLink;
	}

	public int getNumberOfEverydaySolutionsLinks() {
		Logger.info("Get number of 'solutions' links");
		return everydaySolutionsContentLinks.getElementsCount();
	}

	public String getEverydaySolutionsContentLinkHrefValue(int elementNumber) {
		Logger.info("Verifying the section link #" + elementNumber + " contains 'href' attribute value is not empty");
		return everydaySolutionsContentLinks.getAttributeOfElementNumber(elementNumber, "href");
	}

	public int getNumberOfColumnsInEverydaySolutionsSection() {
		Logger.info("Get number of columns in Everyday Solutions section");
		return everydaySolutionsContentColumn.getElementsCount();
	}

	public int getNumberOfLinksInColumns(int columnNumber) {
		Logger.info("Get number of links in column #" + columnNumber);
		return everydaySolutionsContentColumnLink.getElementsWithTextCount(String.valueOf(columnNumber));
	}

	public boolean isEverydayHealthUpdatesHeaderVisible() {
		Logger.info("Checking for 'Everyday Health Updates' Header");
		return everydayHealthUpdatesHeader.isVisible();
	}

	public int getEverydayHealthUpdatesLinksCount() {
		Logger.info("Getting the count of everyday health updates links");
		return everydayHealthUpdatesLinks.getElementsCount();
	}

	public boolean isEveryHealthUpdatesLinksContainHREF(int elementNumber) {
		String linkHref = everydayHealthUpdatesLinks.getAttributeOfElementNumber(elementNumber, "href");
		Logger.info("Checking the " + elementNumber + " link contains HREF - HREF is " + linkHref);
		return !linkHref.isEmpty();
	}

	public void clickEverydayHealthUpdatesLinks(int elementNumber) {
		Logger.info("Clicking the " + elementNumber + " link on everyday health updates region");
		everydayHealthUpdatesLinks.clickOnElementNumber(elementNumber);
		everydayHealthUpdatesHeader.waitUntilInvisible();
		waitForAjaxRequestToBeFinished();
	}

	public String getEverydayHealthUpdatesLinkHref(int elementNumber) {
		Logger.info("Getting the " + elementNumber + " link Href");
		return everydayHealthUpdatesLinks.getAttributeOfElementNumber(elementNumber, "href");
	}

	public boolean isColumnistsSectionVisible() {
		Logger.info("Verifying the 'Columnists section' is visible");
		columnistsSection.scrollToElement();
		return columnistsSection.isVisible();
	}

	public int getNumberOfColumnists() {
		int numberOfColumnists = columnistSlides.getElementsCount();
		Logger.info("Getting the total number of 'Columnists': " + numberOfColumnists);
		return numberOfColumnists;
	}

	public String getColumnisTitle(int columnistNumber) {
		String text = columnistTitle.getTextFromElementNumber(columnistNumber);
		Logger.info("Columnist " + columnistNumber + " text: " + text);
		return text;
	}

	public int getNumberOfVisibleColumnists() {
		Logger.info("Getting number of visible Columnists");
		return columnistTitle.getNumberOfVisibleAndClickableElements();
	}

	public int getFirstVisibleColumnistsNumber() {
		Logger.info("Getting first visible Columnists number");
		return columnistTitle.getFirstVisibleAndClickableElement();
	}

	public boolean isColumnistsNextSliderVisible() {
		Logger.info("Verifying 'Columnists next slider' is visible");
		return columnistNextSlider.isVisible();
	}

	public boolean isColumnistsPreviousSliderVisible() {
		Logger.info("Verifying the 'Columnists previous slider' is visible");
		return columnistPreviousSlider.isVisible();
	}

	public void clickColumnistNextSlider() {
		Logger.info("Clicking on 'columnist next slider'");
		columnistNextSlider.click();
		waitForAjaxRequestToBeFinished();
		waitFor(1000);//need to load next slider element
	}

	public int getNumberOfPrimaryLeadDotControls() {
		Logger.info("Get number of primary lead dot controls");
		int leadDotsCount = primaryLeadDotControls.getVisibleElementsCount();
		Logger.info("Total number of 'Primary Lead Dot Controls': " + leadDotsCount);
		return leadDotsCount;
	}

	public int getNumberOfPrimaryLeadImages() {
		Logger.info("Get number of primary lead images");
		int leadImagesCount = primaryLeadImages.getElementsCount();
		Logger.info("Total number of 'Primary Lead Images': " + leadImagesCount);
		return leadImagesCount;
	}

	public int getNumberOfPrimaryLeadTitles() {
		Logger.info("Get number of primary lead titles");
		int leadTitlesCount = primaryLeadTitles.getElementsCount();
		Logger.info("Total number of 'Primary Lead Titles': " + leadTitlesCount);
		return leadTitlesCount;
	}

	public boolean isPrimaryLeadSectionVisible() {
		Logger.info("Verifying the 'Primary leads section' is visible");
		return primaryLeadSection.isVisible();
	}

	public int getNumberOfPrimaryLeads() {
		Logger.info("Get number of primary leads");
		int leadsCount = primaryLeads.getElementsCount();
		Logger.info("Total number of 'Primary Leads': " + leadsCount);
		return leadsCount;
	}

	public String getPrimaryLeadActiveTitle() {
		Logger.info("Get currently active primary lead title");
		String leadTitle = primaryLeadActiveTitle.getText();
		Logger.info("'Primary Lead Title': " + leadTitle);
		return leadTitle;
	}

	public void clickPrimaryLeadNextSlider() {
		Logger.info("Clicking on 'primary lead next slider'");
		primaryLeadNextSlider.click();
		waitForAjaxRequestToBeFinished();
		waitFor(1000);//need to load next primary lead
	}

	public String getPrimaryLeadDate() {
		Logger.info("Get 'Primary Lead Date': " + primaryLeadDate.getText());
		return primaryLeadDate.getText();
	}

	public void clickPrimaryLeadControlDot(int elementNumber) {
		Logger.info("Clicking on primary lead control dot number " + elementNumber);
		primaryLeadDotControls.clickOnElementNumber(elementNumber);
		waitFor(500);//need to load next primary lead
	}

	public boolean isPrimaryLeadActive(int elementNumber) {
		Logger.info("Verifying the Primary lead number " + elementNumber + " is active");
		return primaryLeads.getAttributeOfElementNumber(elementNumber, "class").contains("active");
	}

	public boolean verifyPrimaryLeadAutoscrollFeature() {
		int slideCount = 1;
		while (slideCount < getNumberOfPrimaryLeads() - 1 && !(isPrimaryLeadActive(getNumberOfPrimaryLeads()))) {
			String primaryLeadActiveTitle = getPrimaryLeadActiveTitle();

			Logger.info("Wait for automatic primary lead scroll");
			int waitTimeOut = 0;
			while (isPrimaryLeadActive(slideCount) && waitTimeOut < 10) {
				waitFor(1000);// Wait for slide to autoscroll
				waitTimeOut++;
			}

			String nextPrimaryLeadTitle = getPrimaryLeadActiveTitle();
			if (primaryLeadActiveTitle.contentEquals(nextPrimaryLeadTitle)) {
				return false;
			}
			slideCount++;
		}
		return true;
	}
}
