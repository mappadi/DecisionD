package everydayhealth.pages.resourceCenter;

import everydayhealth.pages.articles.CustomSolutionsTemplatePage;
import framework.Logger;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

/**
 * ResourceCenterPage
 */
public class ResourceCenterPage extends CustomSolutionsTemplatePage {

	public ResourceCenterPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "resourceCenter";
		String CLASS_NAME = "ResourceCenterPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject adDiv5;
	protected WebObject adDiv7;
	protected WebObject verticalPromoSectionBlocks;
	protected WebObject verticalPromoSectionBlockCards;
	protected WebObject verticalPromoSectionBlockHeadline;
	protected WebObject verticalPromoSectionBlockCardLink;
	protected WebObject verticalPromoSectionBlockCardImage;
	protected WebObject verticalPromoSectionBlockCardSponsoredTag;
	protected WebObject verticalPromoSectionBlockCardHeadline;
	protected WebObject verticalPromoSectionBlockCardTypeIcon;
	protected WebObject verticalPromoSectionBlockCardMoreLink;
	protected WebObject verticalPromoSectionFirstBlockSeeMore;
	protected WebObject horizontalPromoSectionBlocks;
	protected WebObject horizontalPromoSectionBlockCards;
	protected WebObject horizontalPromoSectionBlockHeadline;
	protected WebObject horizontalPromoSectionBlockPrevArrow;
	protected WebObject horizontalPromoSectionBlockNextArrow;
	protected WebObject horizontalPromoSectionBlockCardImage;
	protected WebObject horizontalPromoSectionBlockCardHeadline;
	protected WebObject horizontalPromoSectionBlockCardTypeIcon;
	protected WebObject horizontalPromoSectionBlockCardPager;
	protected WebObject horizontalPromoSectionBlockCardPagerItem;
	protected WebObject linksListSection;
	protected WebObject linksListSectionHeader;
	protected WebObject linksListSectionLinks;

	@Override
	public void waitForPageToLoad() {
		headlineSection.waitUntilVisibleOnPage(this);
	}

	public int getNumberOfBlocksInVerticalPromoSection() {
		Logger.info("Get number of blocks in Vertical Promo section");
		return verticalPromoSectionBlocks.getVisibleElementsCount();
	}

	public int getNumberOfContentCardsInVerticalPromoSectionBlock(int blockNumber) {
		Logger.info("Get number of content cards in Vertical promo section block #" + blockNumber);
		return verticalPromoSectionBlockCards.getElementsWithTextCount(String.valueOf(blockNumber));
	}

	public int getNumberOfHeadlinesInVerticalPromoSection() {
		Logger.info("Get number of block headlines in Vertical Promo section");
		return verticalPromoSectionBlockHeadline.getVisibleElementsCount();
	}

	public boolean isAdDiv5BlockVisibleInFirstBlock() {
		Logger.info("Verify if adDiv5 is visible in first block of Vertical Promo section");
		return adDiv5.isVisible();
	}

	public boolean isAdDiv7BlockVisibleInSecondBlock() {
		Logger.info("Verify if adDiv7 is visible in second block of Vertical Promo section");
		return adDiv7.isVisible();
	}

	public int getNumberOfCardsInVerticalPromoSection() {
		Logger.info("Get number of cards in Vertical Promo section");
		return verticalPromoSectionBlockCardLink.getNumberOfVisibleAndClickableElements();
	}

	public void scrollToLastCardInVerticalPromoSection() {
		Logger.info("Scroll to last card in Vertical Promo Section (lazy load)");
		//required for all images to load
		int numberOfImages = verticalPromoSectionBlockCardImage.getElementsCount();
		for (int image = 1; image <= numberOfImages; image += 3) {
			verticalPromoSectionBlockCardImage.scrollToElementNumber(image);
			waitForAjaxRequestToBeFinished();
		}
	}

	public int getNumberOfCardImagesInVerticalPromoSection() {
		Logger.info("Get number of visible card images in Vertical Promo section");
		return verticalPromoSectionBlockCardImage.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfCardHeadlinesInVerticalPromoSection() {
		Logger.info("Get number of visible card headline in Vertical Promo section");
		return verticalPromoSectionBlockCardHeadline.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfCardTypeIconsInVerticalPromoSection() {
		Logger.info("Get number of visible card type icons in Vertical Promo section");
		return verticalPromoSectionBlockCardTypeIcon.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfSponsoredTagsInVerticalPromoSection() {
		Logger.info("Get number of visible 'From our sponsor' tags in Vertical Promo section");
		return verticalPromoSectionBlockCardSponsoredTag.getNumberOfVisibleAndClickableElements();
	}

	public boolean isGetMoreLinkVisible() {
		Logger.info("Verify 'Get more' link is visible in second Vertical Promo section block");
		return verticalPromoSectionBlockCardMoreLink.isVisible();
	}

	public boolean isGetMoreLinkValid() {
		Logger.info("Get 'href' attribute of 'Get more' link and verify if url is valid");
		return verticalPromoSectionBlockCardMoreLink.getAttribute("href").startsWith("https://");
	}

	public boolean isSeeMoreButtonVisibleInFirstVerticalPromoBlock() {
		Logger.info("Verify if 'See more' button is visible in first vertical promo block");
		return verticalPromoSectionFirstBlockSeeMore.isVisible();
	}

	public void clickSeeMoreButton() {
		Logger.info("Click 'See More' button");
		verticalPromoSectionFirstBlockSeeMore.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isCardLinkValid(int cardNumber) {
		Logger.info("Verify if card #" + cardNumber + " URL is valid");
		String hrefValue = verticalPromoSectionBlockCardLink.getAttributeOfElementNumber(cardNumber, "href");
		Logger.info("URL - " + hrefValue);
		if (hrefValue.contains("/columns") || hrefValue.contains("/assessment")) {
			Logger.info("This URL leads to Columns or Assessment which do not support https");
			return hrefValue.startsWith("http://");
		}
		return hrefValue.startsWith("https://");
	}

	public int getNumberOfBlocksInHorizontalPromoSection() {
		Logger.info("Get number of Horizontal Promo sections");
		return horizontalPromoSectionBlocks.getVisibleElementsCount();
	}

	public int getNumberOfHeadlinesInHorizontalPromoSection() {
		Logger.info("Get number of headlines in Horizontal Promo section");
		return horizontalPromoSectionBlockHeadline.getVisibleElementsCount();
	}

	public int getNumberOfCardsInHorizontalPromoSectionBlock(int blockNumber) {
		Logger.info("Get number of cards in Horizontal Promo section");
		return horizontalPromoSectionBlockCards.getElementsWithTextCount(String.valueOf(blockNumber));
	}

	public boolean isPreviousNavigationArrowVisibleInBlock(int blockNumber) {
		Logger.info("Verify if '<' navigation arrow is visible in block #" + blockNumber);
		return horizontalPromoSectionBlockPrevArrow.isElementWithTextVisible(String.valueOf(blockNumber));
	}

	public boolean isNextNavigationArrowVisibleInBlock(int blockNumber) {
		Logger.info("Verify if '>' navigation arrow is visible in block #" + blockNumber);
		return horizontalPromoSectionBlockNextArrow.isElementWithTextVisible(String.valueOf(blockNumber));
	}

	public void clickNextNavigationArrowInBlock(int blockNumber) {
		Logger.info("Click '>' navigation arrow in block #" + blockNumber);
		horizontalPromoSectionBlocks.scrollToElementNumber(1);
		horizontalPromoSectionBlockNextArrow.clickOnElementNumberWithText(1, String.valueOf(blockNumber));
		waitForAjaxRequestToBeFinished();
	}

	public void clickPreviousNavigationArrowInBlock(int blockNumber) {
		Logger.info("Click '<' navigation arrow in block #" + blockNumber);
		horizontalPromoSectionBlockPrevArrow.clickOnElementNumberWithText(1, String.valueOf(blockNumber));
		waitForAjaxRequestToBeFinished();
	}

	public boolean isImageVisibleForCardInBlock(int blockNumber, int cardNumber) {
		Logger.info("Verify image is visible for card #" + cardNumber + " in Horizontal Promo section block number #" + blockNumber);
		waitForAjaxRequestToBeFinished();
		return horizontalPromoSectionBlockCardImage.isElementWithTextVisible(String.valueOf(blockNumber), cardNumber);
	}

	public boolean isHeadlineVisibleForCardInBlock(int blockNumber, int cardNumber) {
		Logger.info("Verify headline is visible for card #" + cardNumber + " in Horizontal Promo section block number #" + blockNumber);
		return horizontalPromoSectionBlockCardHeadline.isElementWithTextVisible(String.valueOf(blockNumber), cardNumber);
	}

	public boolean isTypeIconVisibleForCardInBlock(int blockNumber, int cardNumber) {
		Logger.info("Verify type icon is visible for card #" + cardNumber + " in Horizontal Promo section block number #" + blockNumber);
		return horizontalPromoSectionBlockCardTypeIcon.isElementWithTextVisible(String.valueOf(blockNumber), cardNumber);
	}

	public void scrollToHorizontalPromoSectionBlock(int blockNumber) {
		Logger.info("Scroll to Horizontal Promo section block #" + blockNumber + " (lazy load)");
		horizontalPromoSectionBlocks.scrollIntoView(blockNumber);
		waitForAjaxRequestToBeFinished();
	}

	public void clickHorizontalPromoCardsPagerButton(int blockNumber, int buttonNumber) {
		Logger.info("Click on horizontal promo pager button #" + buttonNumber + " in Horizontal Promo block #" + blockNumber);
		if (isLegalTextMessageVisible()) {
			clickCloseIconOnLegalTextMessage();
		}
		horizontalPromoSectionBlockCardPager.scrollIntoView(blockNumber);
		horizontalPromoSectionBlockCardPagerItem.clickOnElementNumberWithText(buttonNumber, String.valueOf(blockNumber));
		Utils.waitFor(2000);
	}

	public boolean isLinksListSectionVisible() {
		Logger.info("Verify if Links List section is visible");
		return linksListSection.isVisible();
	}

	public boolean isLinksListHeaderVisible() {
		Logger.info("Verify if Links List section header is visible");
		return linksListSectionHeader.isVisible();
	}

	public String getLinksListHeaderText() {
		Logger.info("Get Links List header text");
		return linksListSectionHeader.getText();
	}

	public int getNumberOfLinksInLinksListSection() {
		Logger.info("Get number of links in Links List section");
		return linksListSectionLinks.getNumberOfVisibleAndClickableElements();
	}

	public boolean isLinksListSectionLinkValid(int linkNumber) {
		Logger.info("Verify if link #" + linkNumber + " in Links List section is valid");
		String hrefValue = linksListSectionLinks.getAttributeOfElementNumber(linkNumber, "href");
		Logger.info("Link: " + hrefValue);
		if (hrefValue.contains("/columns") || hrefValue.contains("/assessment")) {
			Logger.info("This link leads to Columns or Assessment which do not support https");
			return hrefValue.startsWith("http://");
		}
		return hrefValue.startsWith("https://");
	}
}
