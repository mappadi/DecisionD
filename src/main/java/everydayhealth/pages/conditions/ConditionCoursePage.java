package everydayhealth.pages.conditions;

import everydayhealth.pages.articles.CustomSolutionsTemplatePage;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;

import org.openqa.selenium.WebDriver;

public class ConditionCoursePage extends CustomSolutionsTemplatePage {

	public ConditionCoursePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "conditionpages";
		String CLASS_NAME = "ConditionCoursePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject headline;
	protected WebObject medicalReviewer;
	protected WebObject conditionTabs;
	protected WebObject conditionTabsLink;
	protected WebObject conditionTabsImages;
	protected WebObject activeConditionTab;
	protected WebObject getStartedButton;
	protected WebObject getStartedContent;
	protected WebObject footerRadioButtons;
	protected WebObject footerNavigation;
	protected WebObject activeFooterRadioButtons;
	protected WebObject slides;
	protected WebObject slideImage;
	protected WebObject slideHeadline;
	protected WebObject slideContent;
	protected WebObject nextSlideArrow;
	protected WebObject previousSlideArrow;

	@Override
	public void waitForPageToLoad() {
		cusoHeaderTitleWithHref.waitUntilVisibleOnPage(this);
	}

	public boolean isHeadlineVisible() {
		Logger.info("Verify headline is visible");
		return headline.isVisible();
	}

	public int getHeadlineXCoordinateValue(){
		Logger.info("Get headline X coordinate value");
		return headline.getXCoordinate();
	}

	public boolean isMedicalReviewerVisible() {
		Logger.info("Verify medical reviewer is visible");
		return medicalReviewer.isVisible();
	}

	public int getConditionTabCount() {
		Logger.info("Get condition tab count");
		return conditionTabs.getVisibleElementsCount();
	}

	public boolean isConditionTabImageVisible(int elementNumber) {
		Logger.info("Verify condition tab image is visible");
		return conditionTabsImages.isElementNumberVisible(elementNumber);
	}

	public boolean isConditionTabTitlePresent(int elementNumber) {
		Logger.info("Verify condition tab title is visible");
		return conditionTabsLink.getTextFromElementNumber(elementNumber).isEmpty();
	}

	public boolean isConditionTabActive(int tab) {
		Logger.info("Get condition tabs images count");
		return conditionTabs.getAttributeOfElementNumber(tab, "class").contains("active");
	}

	public String getConditionTabDataCategory(int tab) {
		Logger.info("Get condition tabs data category");
		return conditionTabs.getAttributeOfElementNumber(tab, "data-category");
	}

	public String getHashTagFromUrl() {
		Logger.info("Get hash tag from current URL");
		return this.basedriver.getCurrentUrl().split("#")[1];
	}

	public boolean isGetStartedButtonVisible(String dataCategory) {
		Logger.info("Verify Get Started button is visible");
		return getStartedButton.isElementWithTextVisible(dataCategory);
	}

	public boolean isGetStartedContentVisible(String dataCategory) {
		Logger.info("Verify Started content is visible");
		return getStartedContent.isElementWithTextVisible(dataCategory);
	}

	public int getFooterRadioButtons(String dataCategory) {
		Logger.info("Get footer radio buttons");
		return footerRadioButtons.getElements(dataCategory).size();
	}

	public int getActiveFooterRadioButtons() {
		Logger.info("Get active footer radio buttons");
		return activeFooterRadioButtons.getVisibleElementsCount();
	}

	public int getSlideCount(String dataCategory) {
		int slideCount = slides.getElements(dataCategory).size();
		Logger.info("Number of Slides for "+dataCategory+" is "+slideCount);
		return slideCount;
	}

	public boolean isSlideVisible(int slideNumber, String dataCategory) {
		Logger.info("Verify slide is visible");
		return slides.isElementWithTextVisible(dataCategory, slideNumber);
	}

	public boolean isSlideImageVisible(int slideNumber, String dataCategory) {
		Logger.info("Verify slide image is visible");
		return slideImage.isElementWithTextVisible(dataCategory, slideNumber);
	}

	public boolean isSlideHeadlineVisible(int slideNumber, String dataCategory) {
		Logger.info("Verify slide headline is visible");
		return slideHeadline.isElementWithTextVisible(dataCategory, slideNumber);
	}

	public boolean isSlideContentVisible(int slideNumber, String dataCategory) {
		Logger.info("Is slide content visible");
		return slideContent.isElementWithTextVisible(dataCategory, slideNumber);
	}

	public boolean isFooterRadioButtonActive(int slideNumber, String dataCategory) {
		Logger.info("Is Footer radio button active");
		return footerRadioButtons.getAttributeOfElementNumberWithText(slideNumber, "class", dataCategory).contains("active");
	}

	public void clickOnNextSlideArrow() {
		Logger.info("Click on next slide arrow");
		if(Settings.isMobile()) {
			nextSlideArrow.click();
		} else {
			nextSlideArrow.clickWithJS();
		}
		waitForAjaxRequestToBeFinished();
		waitFor(2000);//Wait for slide to load
	}

	public void clickOnPreviousSlideArrow() {
		Logger.info("Click on previous slide arrow");
		previousSlideArrow.clickWithJS();
		waitForAjaxRequestToBeFinished();
		waitFor(1000);//Wait for slide to load
	}

	public void clickOnFooterRadioButton(int footerButton, String dataCategory) {
		Logger.info("Click on footer radio button");
		footerRadioButtons.clickOnElementNumberWithText(footerButton, dataCategory);
		waitForAjaxRequestToBeFinished();
		waitFor(1000);//Wait for slide to load
	}

	public void clickOnConditionTab(int tabNumber) {
		Logger.info("Click on condition tab "+tabNumber);
		conditionTabsLink.clickOnElementNumber(tabNumber);
		waitForAjaxRequestToBeFinished();
		waitFor(1000);//Wait for slide to load
	}

	public void clickOnGetStarted(String dataCategory) {
		Logger.info("Click on Get started tab");
		getStartedButton.getElements(dataCategory).get(0).click();
		waitForAjaxRequestToBeFinished();
	}

	public String getColorOfConditionTabHeader() {
		Logger.info("Getting color of condition tab");
		return activeConditionTab.getElements().get(0).getAttribute("data-tab-color").toLowerCase();
	}

	public String getColorOfSlideHeadlineTab(String dataCategory) {
		Logger.info("Getting color of Slide Headline");
		String rgbValue = slideHeadline.getElements(dataCategory).get(0).getCssValue("color");
		return Utils.getHexColor(rgbValue);
	}

	public String getColorOfGetStartedButton(String dataCategory) {
		Logger.info("Getting color of Get Started button");
		String rgbValue = getStartedButton.getElements(dataCategory).get(0).getCssValue("background-color");
		return Utils.getHexColor(rgbValue);
	}

	public String getColorOfConditionTabFooter() {
		Logger.info("Getting color of footer navigation");
		String rgbValue = footerNavigation.getCssValue("background-color");
		return Utils.getHexColor(rgbValue);
	}
}