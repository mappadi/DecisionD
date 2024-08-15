package everydayhealth.pages.landingpages;

import everydayhealth.pages.articles.CustomSolutionsTemplatePage;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * VideoLandingPage
 */
public class VideoLandingPage extends CustomSolutionsTemplatePage {

	public VideoLandingPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "landingpages";
		String CLASS_NAME = "VideoLandingPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject featuredPromoSectionBlockBlueLink;
	protected WebObject featuredPromoSectionBlockBlueLinkA;
	protected WebObject questionCardsSection;
	protected WebObject questionCardsSectionDeck;
	protected WebObject questionCardsSectionFiltersSection;
	protected WebObject questionCardsSectionFiltersItems;
	protected WebObject questionCardsSectionItems;
	protected WebObject questionCard;
	protected WebObject questionCardLink;
	protected WebObject questionCardSponsoredLabel;
	protected WebObject questionCardQuestion;
	protected WebObject questionCardQuestionLink;
	protected WebObject questionCardThumbnails;
	protected WebObject questionCardThumbnailImages;
	protected WebObject questionCardThumbnailShadowImages;
	protected WebObject questionCardViewAllLink;
	protected WebObject questionCardDateLabel;
	protected WebObject moreButton;

	@Override
	public void waitForPageToLoad() {
		headlineSection.waitUntilVisibleOnPage(this);
	}


	public boolean isFeaturedPromoSectionVisible() {
		Logger.info("Verify if Featured Promo section is visible");
		return featuredPromoSectionBlocks.isVisible();
	}

	public boolean isFeaturedPromoSectionImageVisible() {
		Logger.info("Verify if Featured Promo section image is visible");
		return featuredPromoSectionBlockImage.isVisible();
	}

	public boolean isFeaturedPromoSectionTagVisible() {
		Logger.info("Verify if Featured Promo section tag is visible");
		return featuredPromoSectionBlockTag.isVisible();
	}

	public String getFeaturedPromoSectionTagHrefValue() {
		Logger.info("Get Featured Promo section tag 'href' attribute value");
		return featuredPromoSectionBlockTagLink.getAttribute("href");
	}

	public boolean isFeaturedPromoHeadlineVisible() {
		Logger.info("Verify if Featured Promo section headline is visible");
		return featuredPromoSectionBlockHeadline.isVisible();
	}

	public boolean isFeaturedPromoDeckVisible() {
		Logger.info("Verify if Featured Promo section deck is visible");
		return featuredPromoSectionBlockDeck.isVisible();
	}

	public boolean isFeaturedPromoBlueLinkVisible() {
		Logger.info("Verify if Featured Promo section blue link is visible");
		return featuredPromoSectionBlockBlueLink.isVisible();
	}

	public String getFeaturedPromoBlueLinkHrefValue() {
		Logger.info("Get Featured Promo section blue link 'href' attribute value");
		return featuredPromoSectionBlockBlueLinkA.getAttribute("href");
	}

	public String getFeaturedPromoSectionLink() {
		Logger.info("Get 'href' attribute of Featured Promo section");
		return featuredPromoSectionBlockLink.getAttribute("href");
	}

	public String getFeaturedPromoSectionHeadlineLink() {
		Logger.info("Get 'href' attribute value of Featured Promo section headline");
		return featuredPromoSectionBlockHeadline.getAttribute("href");
	}

	public boolean isQuestionCardsSectionVisible() {
		Logger.info("Verify if question cards section is visible");
		return questionCardsSection.isVisible();
	}

	public int getNumberOfQuestionCards() {
		Logger.info("Get number of question cards");
		return questionCard.getNumberOfVisibleAndClickableElements();
	}

	public boolean isNewsletterWidgetInPositionNumber(int position) {
		Logger.info("Verify if Newsletter widget is in " + position + "th slot");
		return questionCardsSectionItems.getAttributeOfElementNumber(position, "class").contains("newsletter");
	}

	public String getQuestionCardHrefValue(int cardNumber) {
		Logger.info("Get 'href' value for question card #" + cardNumber);
		return questionCardLink.getHrefOfElementNumber(cardNumber);
	}

	public boolean isQuestionCardHeadlineVisible(int cardNumber) {
		Logger.info("Verify if question card #" + cardNumber + " headline is visible");
		return questionCardQuestion.isElementNumberVisible(cardNumber);
	}

	public String getQuestionCardQuestionText(int cardNumber) {
		Logger.info("Get question for question card #" + cardNumber);
		return questionCardQuestion.getTextFromElementNumber(cardNumber);
	}

	public String getQuestionCardQuestionLink(int cardNumber) {
		Logger.info("Get question link for question card #" + cardNumber);
		return questionCardQuestionLink.getAttributeOfElementNumber(cardNumber, "href");
	}

	public boolean isThumbnailsSectionVisibleForCard(int cardNumber) {
		Logger.info("Verify if thumbnails section is visible for card #" + cardNumber);
		return questionCardThumbnails.isElementNumberVisible(cardNumber);
	}

	public int getNumberOfVisibleThumbnailImages(int cardNumber) {
		Logger.info("Get number of visible thumbnail images for card #" + cardNumber);
		return questionCardThumbnailImages.getElementsWithTextCount(String.valueOf(cardNumber));
	}

	public boolean areGreyCirclesVisible(int cardNumber) {
		Logger.info("Verify if grey circles are visible");
		return questionCardThumbnailShadowImages.isElementWithTextVisible(String.valueOf(cardNumber));
	}

	public boolean isViewAllLinkVisible(int cardNumber) {
		Logger.info("Verify if 'View all X videos' link is visible for card #" + cardNumber);
		return questionCardViewAllLink.isElementNumberVisible(cardNumber);
	}

	public String getViewAllLinkHrefValue(int cardNumber) {
		Logger.info("Get 'href' attribute value for card #" + cardNumber);
		return questionCardViewAllLink.getAttributeOfElementNumber(cardNumber, "href");
	}

	public int getTotalNumberOfVideosForCard(int cardNumber) {
		Logger.info("Get total number of videos for card #" + cardNumber);
		int numberOfVids = Integer.valueOf(questionCardViewAllLink.getTextFromElementNumber(cardNumber).split(" ")[2]);
		Logger.info("Number of videos: " + numberOfVids);
		return numberOfVids;
	}

	public boolean isDateLabelVisible(int cardNumber) {
		Logger.info("Verify if date label is visible for card #" + cardNumber);
		return questionCardDateLabel.isElementNumberVisible(cardNumber);
	}

	public LocalDate getDateValueFromDateLabel(int cardNumber) {
		Logger.info("Get date value from card #" + cardNumber);
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.US);
		LocalDate date = LocalDate.parse(questionCardDateLabel.getTextFromElementNumber(cardNumber), dateTimeFormatter);
		Logger.info("Date for card #" + cardNumber + " is: " + date);
		return date;
	}

	public boolean isSeeMoreButtonVisible() {
		Logger.info("Verify if 'See more' button is visible");
		return moreButton.isVisible();
	}

	public void clickSeeMoreButton() {
		Logger.info("Click 'See more' button");
		moreButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isSponsoredLabelVisibleForCard(int cardNumber) {
		Logger.info("Verify if 'From our sponsor' label is visible for card #" + cardNumber);
		return questionCardSponsoredLabel.isElementWithTextVisible(String.valueOf(cardNumber));
	}

	public boolean isFilterSectionVisible() {
		Logger.info("Verify if filters section is visible");
		return questionCardsSectionFiltersSection.isVisible();
	}

	public int getNumberOfAvailableFilters() {
		Logger.info("Get number of available filters");
		return questionCardsSectionFiltersItems.getNumberOfVisibleAndClickableElements();
	}

	public boolean isFilterActive(int filterNumber) {
		Logger.info("Verify if filter #" + filterNumber + " is active");
		return Boolean.parseBoolean(questionCardsSectionFiltersItems.getAttributeOfElementNumber(filterNumber, "data-selected"));
	}

	public String getFilterText(int filterNumber) {
		Logger.info("Get filter #" + filterNumber + " text");
		return questionCardsSectionFiltersItems.getTextFromElementNumber(filterNumber);
	}

	public void clickFilter(int filterNumber) {
		Logger.info("Click on filter '" + questionCardsSectionFiltersItems.getTextFromElementNumber(filterNumber) + "'");
		questionCardsSectionFiltersItems.clickOnElementNumber(filterNumber);
		waitForAjaxRequestToBeFinished();
	}
}
