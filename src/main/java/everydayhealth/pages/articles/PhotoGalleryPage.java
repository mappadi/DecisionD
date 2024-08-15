package everydayhealth.pages.articles;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

/**
 * PhotoGalleryPage
 */
public class PhotoGalleryPage extends BasicPageEH {

	public PhotoGalleryPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "PhotoGalleryPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	@Override
	public void waitForPageToLoad() {
		galleryContainer.waitUntilVisibleOnPage(this);
	}

	protected WebObject galleryContainer;
	protected WebObject introSection;
	protected WebObject introSectionImage;
	protected WebObject introSectionImageCredit;
	protected WebObject introSectionDescription;
	protected WebObject galleryItem;
	protected WebObject itemHeader;
	protected WebObject itemImage;
	protected WebObject itemImageTitle;
	protected WebObject itemImageNumber;
	protected WebObject itemImageCredit;
	protected WebObject itemImageDescription;
	protected WebObject itemImageDescriptionLink;
	protected WebObject itemCTAButton;
	protected WebObject itemAmazonPrice;
	protected WebObject headlineContainer;
	protected WebObject title;
	protected WebObject deck;
	protected WebObject byLine;
	protected WebObject byLineAuthor;
	protected WebObject byLineReviewer;
	protected WebObject date;
	protected WebObject affiliateDisclaimer;
	protected WebObject subcategoryTag;
	protected WebObject relatedGalleriesSection;
	protected WebObject relatedGalleriesSectionTitle;
	protected WebObject relatedGalleriesSectionCard;
	protected WebObject relatedGalleriesSectionCardImage;
	protected WebObject relatedGalleriesSectionCardSubcategory;
	protected WebObject relatedGalleriesSectionCardTitle;
	protected WebObject sourcesSection;
	protected WebObject sourcesSectionHeader;
	protected WebObject sourcesSectionContent;
	protected WebObject sponsoredBy;

	public boolean isIntroSectionVisible() {
		Logger.info("Verify if intro section is visible");
		return introSection.isVisible();
	}

	public boolean isIntroSectionImageVisible() {
		Logger.info("Verify if intro section image is visible");
		return introSectionImage.isVisible();
	}

	public boolean isIntroSectionImageCreditVisible() {
		Logger.info("Verify if intro section image credit is visible");
		return introSectionImageCredit.isVisible();
	}

	public boolean isIntroSectionDescriptionVisible() {
		Logger.info("Verify if intro section description is visible");
		return introSectionDescription.isVisible();
	}

	public int getNumberOfGalleryItems() {
		Logger.info("Get number of gallery items");
		int numberOfItems = galleryItem.getElementsCount();
		Logger.info("Number of gallery items is - " + numberOfItems);
		return numberOfItems;
	}

	public boolean isItemHeaderVisible(int itemNumber) {
		Logger.info("Verify if item #" + itemNumber + " header is visible");
		return itemHeader.isElementNumberVisible(itemNumber);
	}

	public void scrollToItem(int itemNumber) {
		if (itemNumber == 0) {
			Logger.info("Scrolling page to the top");
			scrollPage(0);
			waitForAjaxRequestToBeFinished();
		} else {
			Logger.info("Scroll to title #" + itemNumber);
			if (Settings.isMobile()) {
				if (itemNumber == 1) {
					adDiv7.scrollIntoView();
					adDiv8.scrollIntoView();
				}
				itemCTAButton.scrollIntoView(itemNumber);
			} else {
				itemImage.scrollToElementNumber(itemNumber);
			}
			waitForAjaxRequestToBeFinished();
		}
	}

	public void clickCTAButton(int buttonNumber) {
		Logger.info("Click CTA button #" + buttonNumber);
		itemCTAButton.clickOnElementNumber(buttonNumber);
		waitForAjaxRequestToBeFinished();
	}

	public String getCTAButtonHrefValue(int buttonNumber) {
		Logger.info("Get 'href' attribute value for CTA button #" + buttonNumber);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHF-4278");
		return itemCTAButton.getHrefOfElementNumber(buttonNumber);
	}

	public boolean isItemImageVisible(int itemNumber) {
		Logger.info("Verify if item image #" + itemNumber + " is visible");
		itemImage.scrollToElementNumber(itemNumber);
		waitForAjaxRequestToBeFinished();
		return itemImage.isElementNumberVisible(itemNumber);
	}

	public boolean isItemImageTitleVisible(int itemNumber) {
		Logger.info("Verify if item image title #" + itemNumber + " is visible");
		return itemImageTitle.isElementNumberVisible(itemNumber);
	}

	public String getImageTitleText(int itemNumber) {
		Logger.info("Get text from image title #" + itemNumber);
		return itemImageTitle.getTextFromElementNumber(itemNumber);
	}

	public boolean isItemImageNumberVisible(int itemNumber) {
		Logger.info("Verify if item image index #" + itemNumber + " is visible");
		return itemImageNumber.isElementNumberVisible(itemNumber);
	}

	public String getItemImageNumberColor(int itemNumber) {
		Logger.info("Get item image index #" + itemNumber + " 'color' value");
		return itemImageNumber.getColorFromElementNumber(itemNumber);
	}

	public int getNumberOfImageCredits() {
		Logger.info("Get number of image credits");
		return itemImageCredit.getVisibleElementsCount();
	}

	public boolean isItemImageDescriptionVisible(int itemNumber) {
		Logger.info("Verify if item image description #" + itemNumber + " is visible");
		return itemImageDescription.isElementNumberVisible(itemNumber);
	}

	public int getNumberOfDescriptionLinksOnPage() {
		Logger.info("Get number of description links on page");
		int numberOfLinks = itemImageDescriptionLink.getNumberOfVisibleAndClickableElements();
		Logger.info("Number of description links on page is - " + numberOfLinks);
		return numberOfLinks;
	}

	public String getDescriptionLinkBackgroundColor(int linkNumber) {
		return Utils.getHexColor(itemImageDescriptionLink.getCssOfElementNumber(linkNumber, "background-color"));
	}

	public int getNumberOfCTAButtons() {
		Logger.info("Get number of CTA buttons");
		return itemCTAButton.getVisibleElementsCount();
	}

	public String getCTAButtonText(int buttonNumber) {
		Logger.info("Get CTA button #" + buttonNumber + " text");
		String buttonText = itemCTAButton.getTextFromElementNumber(buttonNumber);
		Logger.info("CTA button #" + buttonNumber + " text is - " + buttonText);
		return buttonText;
	}

	public String getCTAButtonType(int buttonNumber) {
		Logger.info("Get CTA button #" + buttonNumber + " type");
		String type = itemCTAButton.getAttributeOfElementNumber(buttonNumber, "class");
		if (type.contains("cta--other")) {
			Logger.info("Button #" + buttonNumber + " type is - Other");
			return "Other";
		} else if (type.contains("cta--article")) {
			Logger.info("Button #" + buttonNumber + " type is - Article");
			return "Article";
		} else if (type.contains("cta--recipe")) {
			Logger.info("Button #" + buttonNumber + " type is - Recipe");
			return "Recipe";
		} else if (type.contains("cta--amazon")) {
			Logger.info("Button #" + buttonNumber + " type is - Amazon");
			return "Amazon";
		} else {
			return "";
		}
	}

	public String getAmazonPrice(int buttonNumber) {
		Logger.info("Get price on Amazon button #" + buttonNumber);
		return itemAmazonPrice.getTextFromElementNumber(buttonNumber);
	}

	public boolean isHeadlineSectionVisible() {
		Logger.info("Verify if headline section is visible");
		return headlineContainer.isVisible();
	}

	public boolean isTitleVisible() {
		Logger.info("Verify if title is visible");
		return title.isVisible();
	}

	public boolean isDeckVisible() {
		Logger.info("Verify if deck is visible");
		return deck.isVisible();
	}

	public boolean isBylineVisible() {
		Logger.info("Verify if byline is visible");
		return byLine.isVisible();
	}

	public boolean isBylineAuthorVisible() {
		Logger.info("Verify if byline author name is visible");
		return byLineAuthor.isVisible();
	}

	public boolean isBylineReviewerVisible() {
		Logger.info("Verify if byline reveiwer name is visible");
		return byLineReviewer.isVisible();
	}

	public boolean isSubcategoryTagVisible() {
		Logger.info("Verify if subcategory tag is visible");
		return subcategoryTag.isVisible();
	}

	public void clickSubcategoryTag() {
		Logger.info("Click subcategory tag");
		subcategoryTag.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isDateVisible() {
		Logger.info("Verify if date is visible");
		return date.isVisible();
	}

	public String getDate() {
		Logger.info("Get date text");
		return date.getText();
	}

	public boolean isAffiliateDisclaimerVisible() {
		Logger.info("Verify if affiliate disclaimer is visible");
		return affiliateDisclaimer.isVisible();
	}

	public String getAffiliateDisclaimerText() {
		Logger.info("Get affiliate disclaimer text");
		return affiliateDisclaimer.getText();
	}

	public String getSubcategoryTagColor() {
		Logger.info("Get 'color' value for subcategory tag");
		return Utils.getHexColor(subcategoryTag.getCssValue("background-color"));
	}

	public boolean isRelatedGalleriesSectionVisible() {
		Logger.info("Verify if Related Galleries section is visible");
		return relatedGalleriesSection.isVisible();
	}

	public String getRelatedGalleriesSectionBackgroundColor() {
		Logger.info("Get Related Galleries section background color");
		return Utils.getHexColor(relatedGalleriesSection.getCssValue("background-color"));
	}

	public boolean isRelatedGalleriesTitleVisible() {
		Logger.info("Verify if Related Galleries title is visible");
		return relatedGalleriesSectionTitle.isVisible();
	}

	public String getRelatedGalleriesTitleText() {
		Logger.info("Get related galleries title text");
		return relatedGalleriesSectionTitle.getText();
	}

	public int getNumberOfRelatedGalleriesCards() {
		Logger.info("Get number of cards in Related Galleries section");
		return relatedGalleriesSectionCard.getVisibleElementsCount();
	}

	public void clickRelatedGalleriesCard(int cardNumber) {
		Logger.info("Click on card #" + cardNumber + " in Related Galleries section");
		relatedGalleriesSectionCard.clickOnElementNumber(cardNumber);
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfRelatedGalleriesCardImages() {
		Logger.info("Get number of card images in Related Galleries section");
		return relatedGalleriesSectionCardImage.getVisibleElementsCount();
	}

	public int getNumberOfRelatedGalleriesCardSubcategoryTags() {
		Logger.info("Get number of cards in Related Galleries section");
		return relatedGalleriesSectionCardImage.getVisibleElementsCount();
	}

	public String getRelatedGallerySubcategoryTagText(int cardNumber) {
		Logger.info("Get text from Subcategory tag for Related Galleries card #" + cardNumber);
		return relatedGalleriesSectionCardSubcategory.getTextFromElementNumber(cardNumber);
	}

	public String getRelatedGallerySubcategoryTagHref(int cardNumber) {
		Logger.info("Get 'href' from Subcategory tag for Related Galleries card #" + cardNumber);
		return relatedGalleriesSectionCardSubcategory.getHrefOfElementNumber(cardNumber);
	}

	public void clickRelatedGalleriesSubcategory(int cardNumber) {
		Logger.info("Click on subcategory value #" + cardNumber + " in Related Galleries section");
		relatedGalleriesSectionCardSubcategory.clickOnElementNumber(cardNumber);
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfRelatedGalleriesCardTitles() {
		Logger.info("Get number of titles in Related Galleries section");
		return relatedGalleriesSectionCardTitle.getVisibleElementsCount();
	}

	public String getRelatedGalleryCardTitle(int cardNumber) {
		Logger.info("Get Related Gallery card #" + cardNumber + " title");
		return relatedGalleriesSectionCardTitle.getTextFromElementNumber(cardNumber);
	}

	public boolean isSourcesSectionVisible() {
		Logger.info("Verify if Sources section is visible");
		sourcesSection.scrollIntoView();
		return sourcesSection.isVisible();
	}

	public boolean isSourcesSectionHeaderVisible() {
		Logger.info("Verify if Sources section header is visible");
		return sourcesSectionHeader.isVisible();
	}

	public void clickSourcesSectionHeader() {
		Logger.info("Click Sources section header");
		if (isLegalTextMessageVisible()) {
			clickCloseIconOnLegalTextMessage();
		}
		sourcesSectionHeader.scrollIntoView();
		sourcesSectionHeader.click();
		Utils.waitFor(1500);
	}

	public String getSourcesSectionHeaderText() {
		Logger.info("Get Sources section header text");
		return sourcesSectionHeader.getText();
	}

	public boolean isSourcesSectionContentVisible() {
		Logger.info("Verify if Sources section content visible");
		return sourcesSectionContent.isVisible();
	}

	public boolean isSponsoredByVisible() {
		Logger.info("Verify if Sponsored By text is visible ");
		return sponsoredBy.isVisible();
	}
}