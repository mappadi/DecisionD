package everydayhealth.pages.conditions;

import everydayhealth.pages.articles.ArticleNewTemplatePage;
import everydayhealth.pages.registrations.InlineRegistration;
import framework.Logger;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

public class ConditionCenterTopicPage extends ArticleNewTemplatePage {

	public ConditionCenterTopicPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "conditionpages";
		String CLASS_NAME = "ConditionCenterTopicPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject topicPageTopicName;
	protected WebObject followButton;
	protected WebObject miniContentCard;
	protected WebObject miniContentCardHeader;
	protected WebObject miniContentCardBorder;
	protected WebObject miniContentCardImage;
	protected WebObject miniContentCardRightArrow;
	protected WebObject miniContentCardLeftArrow;
	protected WebObject contentCard;
	protected WebObject contentCardImage;
	protected WebObject contentCardHeader;
	protected WebObject contentCardDesc;
	protected WebObject contentCardIcon;
	protected WebObject seeMoreButton;
	protected WebObject followingButton;
	protected WebObject topicNameInFollowingTopicsPage;
	protected WebObject closeTopicIconInFollowingTopicPage;
	protected WebObject editLinkInFollowingTopicPage;

	@Override
	public void waitForPageToLoad() {
		topicPageTopicName.waitUntilVisibleOnPage(this);
	}

	public boolean isTopicNameVisible() {
		Logger.info("Checking for the topic name is visible");
		return topicPageTopicName.isVisible();
	}

	public String getTopicText() {
		Logger.info("Get topic text");
		return topicPageTopicName.getText();
	}

	public boolean isFollowButtonVisible() {
		Logger.info("Checking for follow button");
		return followButton.isVisible();
	}

	public String getFollowButtonText() {
		Logger.info("Getting the text of follow/following button");
		return followButton.getText();
	}

	public String getFollowButtonBackgroundColor() {
		Logger.info("Get 'Follow' button background color");
		return Utils.getHexColor(followButton.getCssValue("background-color"));
	}

	public void clickFollowButton() {
		Logger.info("Clicking the Follow button");
		followButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public int getMiniContentCardCount() {
		Logger.info("Getting the count of Mini content cards");
		return miniContentCard.getElementsCount();
	}

	public boolean isMiniContentCardContainsHref(int elementNumber) {
		Logger.info("Checking the mini content card " + elementNumber + " contains Href");
		String hrefValue = miniContentCard.getAttributeOfElementNumber(elementNumber, "href");
		Logger.info("Mini content card #" + elementNumber + " href - " + hrefValue);
		if (hrefValue.contains("/columns") || hrefValue.contains("/assessment")) {
			Logger.info("This link leads to Columns or Assessment which do not support https");
			return hrefValue.startsWith("http://");
		}
		return hrefValue.startsWith("https://");
	}

	public int getMiniContentCardBorderCount() {
		Logger.info("Checking for mini content card borders");
		return miniContentCardBorder.getElementsCount();
	}

	public boolean isMiniContentCardContainsImage(int elementNumber) {
		Logger.info("Checking the mini content card " + (elementNumber) + " Image");
		miniContentCardImage.waitUntilEnabled();
		String miniCardImageSource = miniContentCardImage.getAttributeOfElementNumber(elementNumber, "src");
		Logger.info("Mini content Image name - " + miniCardImageSource);
		return miniCardImageSource.startsWith("https://images.agoramedia.com");
	}

	public boolean isMiniContentCardContainsHeader(int elementNumber) {
		Logger.info("Checking the mini content card " + (elementNumber) + " header");
		miniContentCardHeader.waitUntilEnabled();
		String miniContentCardHeaderText = miniContentCardHeader.getTextFromElementNumber(elementNumber);
		Logger.info("Mini content card header - " + miniContentCardHeaderText);
		return miniContentCardHeaderText.isEmpty();
	}

	public void clickMiniContentCardRightArrow(int elementNumber) {
		if ((elementNumber > 3) && (miniContentCardRightArrow.isVisible())) {
			Logger.info("Clicking the right arrow to scroll " + elementNumber + " mini content card");
			miniContentCardRightArrow.click();
		}
	}

	public boolean isMiniContentCardLeftArrowVisible() {
		Logger.info("Checking if mini content card left arrow is present");
		return miniContentCardLeftArrow.isVisible();
	}

	public void clickMiniContentCardLeftArrow() {
		Logger.info("Clicking the mini content card left arrow");
		miniContentCardLeftArrow.click();
	}

	public int getContentCardCount() {
		Logger.info("Getting the count of content cards");
		return contentCardImage.getElementsCount();
	}

	public boolean isContentCardSlotContainsAdBlock(int slotNumber) {
		Logger.info("Check if ad block is in content card slot #" + slotNumber);
		return contentCard.getAttributeOfElementNumber(slotNumber, "class").contains("ad-container");
	}

	public boolean isContentCardImageContainsDataSource(int elementNumber) {
		Logger.info("Checking the content card image source");
		return !contentCardImage.getAttributeOfElementNumber(elementNumber, "data-src").isEmpty();
	}

	public boolean isContentCardImageWidth(int elementNumber, int width) {
		Logger.info("Checking the image width");
		return contentCardImage.getAttributeOfElementNumber(elementNumber, "data-src").contains("width=" + width);
	}

	public boolean isContentCardHeaderExist(int elementNumber) {
		Logger.info("Checking the content card Header");
		return !contentCardHeader.getTextFromElementNumber(elementNumber).isEmpty();
	}

	public boolean isContentCardDescExist(int elementNumber) {
		Logger.info("Checking for content card description - " + contentCardDesc.getTextFromElementNumber(elementNumber));
		return !contentCardDesc.getTextFromElementNumber(elementNumber).isEmpty();
	}

	public int getContentCardIconCount() {
		Logger.info("Checking for content card Icon");
		waitForAjaxRequestToBeFinished();
		return contentCardIcon.getNumberOfVisibleAndClickableElements();
	}

	public boolean isSeeMoreButtonVisible() {
		Logger.info("Checking for See More Button");
		return seeMoreButton.isVisible();
	}

	public void clickSeeMoreButton() {
		Logger.info("Clicking the See More Button");
		seeMoreButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isFollowingButtonVisible() {
		Logger.info("Checking the 'following' label");
		waitForAjaxRequestToBeFinished();
		return followingButton.isVisible();
	}

	public boolean isTopicNameInFollowingTopicsPageVisible() {
		Logger.info("Checking for Topic name in Following topics page");
		return topicNameInFollowingTopicsPage.isVisible();
	}

	public int getCountOfTopicNameInFollowingTopicPage() {
		Logger.info("Getting the count of Topic names in following topic page");
		return topicNameInFollowingTopicsPage.getVisibleElementsCount();
	}

	public String getTextOfTopicInTheList(int topicNumber) {
		Logger.info("Get topic text");
		return topicNameInFollowingTopicsPage.getTextFromElementNumber(topicNumber);
	}

	public boolean isCloseIconInFollowingTopicVisible() {
		Logger.info("Checking for close icon in following topic name");
		return closeTopicIconInFollowingTopicPage.isVisible();
	}

	public boolean isEditLinkInFollowingTopicPageVisible() {
		Logger.info("Checking for edit link in Following topic page");
		return editLinkInFollowingTopicPage.isVisible();
	}

	public void clickEditLinkInFollowingTopicPage() {
		Logger.info("Clicking the Edit link in following topic page");
		editLinkInFollowingTopicPage.click();
		waitForAjaxRequestToBeFinished();
	}

	public void clickCloseIconInFollowingTopicPage(int elementNumber) {
		Logger.info("Clicking the close icon in following topic page");
		closeTopicIconInFollowingTopicPage.clickOnElementNumber(elementNumber);
	}

	public InlineRegistration onInlineRegistration() {
		return new InlineRegistration(basedriver);
	}
}