package everydayhealth.pages.drugs;

import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DrugsProfilePage extends DrugsBasePage {

	public DrugsProfilePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "drugs";
		String CLASS_NAME = "DrugsProfilePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject drugHeadline;
	protected WebObject drugHeadlineTitle;
	protected WebObject drugsHeadlineButton;
	protected WebObject sideMenu;
	protected WebObject sideMenuButton;
	protected WebObject sideMenuItem;
	protected WebObject sideMenuItemText;
	protected WebObject sideMenuItemLink;
	protected WebObject sideMenuReviewLink;
	protected WebObject sideMenuCouponsLink;
	protected WebObject sideMenuCouponsIcon;
	protected WebObject section;
	protected WebObject byLine;
	protected WebObject lastUpdated;
	protected WebObject readNext;
	protected WebObject reviewsLink;
	protected WebObject getCouponsLink;
	protected WebObject getCouponsLinkIcon;
	protected WebObject seeAllImagesButton;
	protected WebObject image;
	protected WebObject showAnswerLink;
	protected WebObject answerText;
	protected WebObject answerOnDesktop;
	protected WebObject questionLink;

	@Override
	public void waitForPageToLoad() {
		drugHeadline.waitUntilVisibleOnPage(this);
	}

	public boolean isDrugHeadlineBarVisible() {
		Logger.info("Check if drug headline bar is visible");
		return drugHeadline.isVisible();
	}

	public boolean isDrugHeadlineTitleVisible() {
		Logger.info("Check if drug headline title is visible");
		return drugHeadlineTitle.isVisible();
	}

	public String getDrugHeadlineTitle() {
		Logger.info("Get drug headline title");
		return drugHeadlineTitle.getText();
	}

	public boolean isDrugsHeadlineButtonVisible() {
		Logger.info("Check if 'Drugs' button is visible on headline");
		return drugsHeadlineButton.isVisible();
	}

	public String getDrugsHeadlineButtonHrefAttribute() {
		Logger.info("Get 'href' attribute of 'Drugs' button");
		return drugsHeadlineButton.getAttribute("href");
	}

	public boolean isSideMenuVisible() {
		Logger.info("Check if side menu is visible");
		return sideMenu.isVisible();
	}

	public void clickSideMenu() {
		Logger.info("Click side menu on mobile/tablet");
		if (!Settings.isDesktop()) {
			sideMenuButton.click();
		}
	}

	public int getNumberOfSideMenuTabs() {
		Logger.info("Get number of tabs in side menu");
		return sideMenuItem.getNumberOfVisibleAndClickableElements();
	}

	public boolean isSideMenuTabTitleVisible(String title) {
		Logger.info("Check if side menu tab '" + title + "' is visible");
		return sideMenuItemText.isElementWithTextVisible(title);
	}

	public String getSideMenuTabTitleNumber(int titleNumber) {
		Logger.info("Get side menu tab title #" + titleNumber);
		return sideMenuItem.getTextFromElementNumber(titleNumber);
	}

	public void clickSideMenuTabWithTitle(String title) {
		Logger.info("Click on side menu tab with title '" + title + "'");
		sideMenuItemLink.clickOnElementNumberWithText(1, title.replace(" ", "").toLowerCase());
		waitForAjaxRequestToBeFinished();
		Utils.waitFor(2000); //For section to be scrolled into view port
	}

	public String getHrefOfReviewsSideMenuTab() {
		Logger.info("Get 'href' attribute of 'Reviews' tab");
		return sideMenuReviewLink.getAttribute("href");
	}

	public boolean isSideMenuCouponsLinkVisible() {
		Logger.info("Verify if 'Coupons' link is visible in side menu");
		return sideMenuCouponsLink.isVisible();
	}

	public String getSideMenuCouponsLinkText() {
		Logger.info("Get side menu 'Coupons & Prices' item text");
		return sideMenuCouponsLink.getText();
	}

	public String getSideMenuCouponsLinkHrefValue() {
		Logger.info("Get side menu 'Coupons & Prices' item 'href' attribute value");
		return sideMenuCouponsLink.getAttribute("href");
	}

	public boolean isSideMenuCouponsTagIconVisible() {
		Logger.info("Verify if 'Coupons & Prices' icon is visible");
		return sideMenuCouponsIcon.isVisible();
	}

	public DrugsCouponsPage clickCouponsAndPricesLink() {
		Logger.info("Click 'Coupons & Prices' side menu link");
		sideMenuCouponsLink.click();
		return new DrugsCouponsPage(WebDriverManager.getDriver());
	}

	public DrugsReviewsPage clickSideMenuReviewTab() {
		Logger.info("Click 'Review' side menu tab");
		sideMenuReviewLink.click();
		return PageFactory.initElements(basedriver, DrugsReviewsPage.class);
	}

	public DrugsReviewsPage clickNumberOfReviewsLink() {
		Logger.info("Click 'Reviews' link");
		reviewsLink.click();
		return PageFactory.initElements(basedriver, DrugsReviewsPage.class);
	}

	public void clickGetCouponsLink() {
		Logger.info("Click 'Get coupons' link");
		getCouponsLink.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isGetCouponsLinkVisible() {
		Logger.info("Verify if 'Get coupons' link is visible");
		return getCouponsLink.isVisible();
	}

	public boolean isGetCouponsLinkIconVisible() {
		Logger.info("Verify if icon is visible near 'Get coupons' link");
		return getCouponsLinkIcon.isVisible();
	}

	public boolean isSectionWithTitleInViewPort(String sectionTitle) {
		Logger.info("Check if section with title '" + sectionTitle + "' is visible");
		return section.isElementWithTextInViewPort(sectionTitle.replace(" ", "").toLowerCase());
	}

	public boolean isBylineVisible() {
		Logger.info("Check if byline is visible");
		return byLine.isVisible();
	}

	public boolean isLastUpdatedDateVisible() {
		Logger.info("Check if last updated date is visible");
		return lastUpdated.isVisible();
	}

	public boolean isReadNextNavigationVisible() {
		Logger.info("Check if read next navigation is visible");
		return readNext.isVisible();
	}

	public String getReadNextHrefAttribute() {
		Logger.info("Get 'href' attribute of read next section");
		return readNext.getAttribute("href");
	}

	public int getNumberOfVisibleImagesOnPage() {
		Logger.info("Get number of images on page");
		return image.getNumberOfVisibleAndClickableElements();
	}

	public boolean isSeeAllImagesButtonVisible() {
		Logger.info("Check if 'See all images' button is visible");
		return seeAllImagesButton.isVisible();
	}

	public void clickSeeAllImagesButton() {
		Logger.info("Click 'See all images' button");
		seeAllImagesButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public DrugsReviewsPage clickReadNextButton() {
		Logger.info("Click 'Read next' button");
		readNext.click();
		return PageFactory.initElements(basedriver, DrugsReviewsPage.class);
	}

	public String getHrefOfReadNextNavigationModule() {
		Logger.info("Get 'href' attribute value of 'Read next' navigation module");
		return readNext.getAttribute("href");
	}

	public void clickQuestionNumber(int questionNumber) {
		Logger.info("Click on question #" + questionNumber);
		questionLink.clickOnElementNumber(questionNumber);
		Utils.waitFor(2000); //for answer text to (dis)appear
	}

	public int getNumberOfQuestions() {
		Logger.info("Get number of questions");
		return questionLink.getNumberOfVisibleAndClickableElements();
	}

	public void clickShowAnserNumber(int answerNumber) {
		Logger.info("Click on answer #" + answerNumber);
		showAnswerLink.clickOnElementNumber(answerNumber);
		Utils.waitFor(2000); //for answer text to (dis)appear
	}

	public boolean isAnswerNumberTextVisible() {
		Logger.info("Check if answer text is visible");
		return answerText.isVisible();
	}

	public int getNumberOfAnswers() {
		Logger.info("Get number of visible answers");
		return answerOnDesktop.getVisibleElementsCount();
	}

	public String getColorOfReviewsTab() {
		Logger.info("Get background color for 'Reviews' tab");
		return sideMenuItem.getCssOfElementNumber(7, "color");
	}
}
