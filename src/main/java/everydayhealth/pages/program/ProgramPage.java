package everydayhealth.pages.program;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

public class ProgramPage extends BasicPageEH {

	public ProgramPage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "program";
		String CLASS_NAME = "ProgramPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject subnavigationItems;
	protected WebObject subnavigationDropdownTrigger;
	protected WebObject subnavigationDropdownMenu;
	protected WebObject subnavigationDropdownItems;
	protected WebObject subHeading;
	protected WebObject deckHeader;
	protected WebObject deckText;
	protected WebObject image;
	protected WebObject articleTitle;
	protected WebObject secondarySubNavigationModule;
	protected WebObject recentStories;
	protected WebObject rightRailModule;
	protected WebObject secondarySubNavigationSlides;
	protected WebObject nextSlideArrow;
	protected WebObject previousSlideArrow;
	protected WebObject slideImage;
	protected WebObject slideHeading;
	protected WebObject firstSubnavigationSlideHeading;
	protected WebObject slideText;
	protected WebObject recentStoriesImage;
	protected WebObject recentStoriesTitle;
	protected WebObject relatedListImage;
	protected WebObject relatedListTitle;
	protected WebObject rightRailModuleStories;
	protected WebObject adDiv5Image;
	protected WebObject moreInButton;
	protected WebObject recentStoriesBlock;
	protected WebObject recentStoriesAdBlock;
	protected WebObject moreButton;
	protected WebObject leadStoryBlock;
	protected WebObject secondaryLeadStoriesSection;
	protected WebObject secondaryLeadStoryImage;
	protected WebObject secondaryLeadStoryTitle;
	protected WebObject newsletterHeading;
	protected WebObject newsletterDescription;
	protected WebObject newsletterImage;
	protected WebObject newsletterModuleSuccessMessage;

	@Override
	public void waitForPageToLoad() {
		secondarySubNavigationModule.waitUntilVisibleOnPage(this);
	}

	public ProgramPage clickOnSubNavigationItemNumber(int elementNumber) {
		Logger.info("Click on subnavigation item number " + elementNumber);
		if (Settings.isMobile()) {
			subnavigationDropdownTrigger.click();
			subnavigationDropdownMenu.waitUntilVisible();
			subnavigationDropdownItems.clickOnElementNumber(elementNumber);
		} else {
			subnavigationItems.clickOnElementNumber(elementNumber);
		}
		if (!Settings.isDesktop()) {
			waitFor(2000); //needed for page to load
		}
		waitForAjaxRequestToBeFinished();
		return new ProgramPage(basedriver);
	}

	public int getNumberOfVisibleRelatedStories() {
		Logger.info("Get number of related stories displayed in right rail module");
		return rightRailModuleStories.getNumberOfVisibleAndClickableElements();
	}

	public boolean isLeadStoryBlockVisible() {
		Logger.info("Check if lead story block is visible");
		return leadStoryBlock.isVisible();
	}

	public boolean isSecondaryLeadStoriesBlockVisible() {
		Logger.info("Check if secondary lead stories block is visible");
		return secondaryLeadStoriesSection.isVisible();
	}

	public String getTile5ImageHeight() {
		String height = adDiv5Image.getAttribute("height");
		Logger.info("Get Tile 5 image height: " + height);
		return height;
	}

	public void waitForMoreInButton() {
		Logger.info("Wait until 'More in...' button is visible");
		moreInButton.waitUntilVisible();
	}

	public void clickMoreButton() {
		Logger.info("Click 'More' button");
		moreButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isMoreButtonVisible() {
		Logger.info("Check if 'More' button is visible");
		return moreButton.isVisible();
	}

	public int getSubNavigationTabCount() {
		Logger.info("Get sub navigation tab count");
		return subnavigationItems.getNumberOfVisibleAndClickableElements();
	}

	public boolean isSubHeadingVisible() {
		Logger.info("Verify sub heading is visible");
		return subHeading.isVisible();
	}

	public boolean isSubHeadingLinkValid() {
		Logger.info("Verify sub heading is clickable");
		return subHeading.getAttribute("href").startsWith("https://");
	}

	public boolean isDeckHeaderVisible() {
		Logger.info("Verify deck header is visible");
		return deckHeader.isVisible();
	}

	public boolean isDeckTextVisible() {
		Logger.info("Verify deck text is visible");
		return deckText.isVisible();
	}

	public boolean isImageVisible() {
		Logger.info("Verify Image is visible");
		return image.isVisible();
	}

	public String getLeadStoryImageSize() {
		Logger.info("Get lead story image size");
		return image.getElement().getSize().toString();
	}

	public String getSecondaryLeadStoryImageSize(int imageNumber) {
		Logger.info("Get secondary lead story #" + (imageNumber + 1) + " image size");
		return secondaryLeadStoryImage.getElements().get(imageNumber).getSize().toString();
	}

	public int getNumberOfSecondaryStoriesImages() {
		Logger.info("Get number of secondary stories images");
		return secondaryLeadStoryImage.getElementsCount();
	}

	public String getImageLinkNumber(int imageNumber) {
		Logger.info("Get image #" + imageNumber + " 'href' attribute value");
		return secondaryLeadStoryImage.getAttributeOfElementNumber(imageNumber, "href");
	}

	public String getTitleLinkNumber(int titleNumber) {
		Logger.info("Get title #" + titleNumber + " 'href' attribute value");
		return secondaryLeadStoryTitle.getAttributeOfElementNumber(titleNumber, "href");
	}

	public int getNumberOfSecondaryStoriesTitles() {
		Logger.info("Get number of secondary stories titles");
		return secondaryLeadStoryTitle.getElementsCount();
	}

	public boolean isArticleTitleVisible() {
		Logger.info("Verify Article title is visible");
		return articleTitle.isVisible();
	}

	public boolean isArticleTitleLinkValid() {
		Logger.info("Verify Article title is clickable");
		return articleTitle.getAttribute("href").startsWith("https://");
	}

	public boolean isSecondarySubNavigationModuleVisible() {
		Logger.info("Verify secondary sub navigation module is visible");
		return secondarySubNavigationModule.isVisible();
	}

	public boolean isRecentStoriesSectionVisible() {
		Logger.info("Verify recent stories section is visible");
		return recentStories.isVisible();
	}

	public boolean isRightRailModuleVisible() {
		Logger.info("Verify right rail module is visible");
		rightRailModule.scrollToElement();
		return rightRailModule.isVisible();
	}

	public boolean isNewsletterHeadingVisible() {
		Logger.info("Verify newsletter heading is visible");
		return newsletterHeading.isVisible();
	}

	public String getNewsletterHeadingText() {
		Logger.info("Get newsletter heading text");
		return newsletterHeading.getText();
	}

	public boolean isNewsletterDescriptionVisible() {
		Logger.info("Verify newsletter description is visible");
		return newsletterDescription.isVisible();
	}

	public boolean isNewsletterImageVisible() {
		Logger.info("Verify newsletter image is visible");
		return newsletterImage.isVisible();
	}

	public int getSecondarySubNavigationSlideCount() {
		Logger.info("Get Secondary Sub Navigation Slides Count");
		return secondarySubNavigationSlides.getElementsCount();
	}

	public int getFirstVisibleStoryNumber() {
		Logger.info("Get number of first visible story");
		return secondarySubNavigationSlides.getFirstVisibleAndClickableElement();
	}

	public boolean verifySlideNumberVisible(int slideNumber) {
		Logger.info("Verify slide number is visible");
		return secondarySubNavigationSlides.isElementNumberVisible(slideNumber) && secondarySubNavigationSlides.getAttributeOfElementNumber(slideNumber, "class").contains("active-slide");
	}

	public boolean isSlideImageVisible() {
		Logger.info("Verify slide image is visible");
		return slideImage.isVisible();
	}

	public boolean isSlideHeadingVisible() {
		Logger.info("Verify slide heading is visible");
		return slideHeading.isVisible();
	}

	public boolean isSlideHeadingLinkValid() {
		Logger.info("Verify slide heading is clickable");
		return firstSubnavigationSlideHeading.getAttribute("href").startsWith("https://");
	}

	public String getSlideHeadingText() {
		Logger.info("Get slide heading text");
		return slideHeading.getText();
	}

	public boolean isSlideTextVisible() {
		Logger.info("Verify slide text is visible");
		return slideText.isVisible();
	}

	public void clickNextSlideArrow() {
		Logger.info("Click next slide arrow");
		nextSlideArrow.click();
		Utils.waitFor(1500); // for carousel to move
	}

	public void clickPreviousSlideArrow() {
		Logger.info("Click previous slide arrow");
		previousSlideArrow.click();
		waitForAjaxRequestToBeFinished();
	}

	public int getRecentStoriesCount() {
		Logger.info("Get recent stories count");
		return recentStoriesBlock.getVisibleElementsCount();
	}

	public int getRecentStoriesAdBlocksCount() {
		Logger.info("Get number of ad blocks in 'Recent stories' section");
		return recentStoriesAdBlock.getVisibleElementsCount();
	}

	public boolean isRecentStoriesImageNumberVisible(int elementNumber) {
		Logger.info("Verify recent stories image is visible for block #" + elementNumber);
		return recentStoriesImage.isElementNumberVisible(elementNumber);
	}

	public String getRecentStoryImageSize(int imageNumber) {
		Logger.info("Get recent story #" + (imageNumber + 1) + " image size");
		return recentStoriesImage.getElements().get(imageNumber).getSize().toString();
	}

	public boolean isRecentStoriesTitleNumberVisible(int elementNumber) {
		Logger.info("Verify recent stories title is visible for block #" + elementNumber);
		return recentStoriesTitle.isElementNumberVisible(elementNumber);
	}

	public boolean isRecentStoriesImageNumberClickable(int elementNumber) {
		Logger.info("Verify recent stories image is clickable");
		return !recentStoriesImage.getAttributeOfElementNumber(elementNumber, "href").isEmpty();
	}

	public boolean isRecentStoriesTitleNumberClickable(int elementNumber) {
		Logger.info("Verify recent stories title is clickable");
		return !recentStoriesTitle.getAttributeOfElementNumber(elementNumber, "href").isEmpty();
	}

	public int getRelatedListCount() {
		Logger.info("Get related list count");
		return relatedListImage.getVisibleElementsCount();
	}

	public boolean isRelatedListImageNumberVisible(int elementNumber) {
		Logger.info("Verify related list image is visible");
		return relatedListImage.isElementNumberVisible(elementNumber);
	}

	public boolean isRelatedListTitleNumberVisible(int elementNumber) {
		Logger.info("Verify related list title is visible");
		return relatedListTitle.isElementNumberVisible(elementNumber);
	}

	public boolean isRelatedListImageNumberClickable(int elementNumber) {
		Logger.info("Verify related list image is clickable");
		return !relatedListImage.getAttributeOfElementNumber(elementNumber, "href").isEmpty();
	}

	public boolean isRelatedListTitleNumberClickable(int elementNumber) {
		Logger.info("Verify related list title is clickable");
		return !relatedListTitle.getAttributeOfElementNumber(elementNumber, "href").isEmpty();
	}

	@Override
	public boolean verifyNewsletterModuleSuccessMessage() {
		Logger.info("Verify Newsletter module confirmation message");
		if (!Settings.isDesktop()) {
			newsletterModuleSuccessMessage.scrollToElement();
		}
		newsletterModuleSuccessMessage.waitUntilVisible();
		return newsletterModuleSuccessMessage.getText().equalsIgnoreCase("Thank you for subscribing. You should receive your newsletter within 24 hours.");
	}
}