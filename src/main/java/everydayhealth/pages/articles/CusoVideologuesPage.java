package everydayhealth.pages.articles;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class CusoVideologuesPage extends IGNPlayerPage {

	public CusoVideologuesPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "CusoVideologuesPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject videoSection;
	protected WebObject videoSectionInfo;
	protected WebObject videoSectionInfoHeadline;
	protected WebObject videoSectionInfoDeck;
	protected WebObject playlist;
	protected WebObject playlistHeadline;
	protected WebObject playlistHeadlineVideoCount;
	protected WebObject playlistCard;
	protected WebObject playlistVideoCard;
	protected WebObject playlistVideoCardLink;
	protected WebObject playlistVideoCardImage;
	protected WebObject playlistVideoCardImageLink;
	protected WebObject playlistNowViewingLabel;
	protected WebObject playlistVideoCardHeadline;
	protected WebObject playlistVideoCardHeadlineLink;
	protected WebObject playlistVideoCardTypeIcon;
	protected WebObject playlistPrevArrow;
	protected WebObject playlistNextArrow;
	protected WebObject readNextWidget;
	protected WebObject readNextWidgetHeadline;
	protected WebObject readNextWidgetHeadlineCategoryLink;
	protected WebObject readNextWidgetCard;
	protected WebObject readNextWidgetCardLink;
	protected WebObject readNextWidgetCardImage;
	protected WebObject readNextWidgetCardHeadline;
	protected WebObject readNextWidgetCardTypeIcon;
	protected WebObject lastUpdated;
	protected WebObject videologuesNavigation;
	protected WebObject videologuesNavigationPrev;
	protected WebObject videologuesNavigationNext;

	@Override
	public void waitForPageToLoad() {
		ignVideoModule.waitUntilVisibleOnPage(this);
	}

	public boolean isVideoSectionVisible() {
		Logger.info("Verify if video section is visible");
		return videoSection.isVisible();
	}

	public void mouseHoverDeck() {
		videoSectionInfoHeadline.mouseHover();
	}

	public boolean isVideoSectionInformationVisible() {
		Logger.info("Verify if video section information is visible");
		return videoSectionInfo.isVisible();
	}

	public boolean isVideoHeadlineVisible() {
		Logger.info("Verify if video headline is visible");
		return videoSectionInfoHeadline.isVisible();
	}

	public String getVideoHeadlineText() {
		Logger.info("Get video headline text");
		String videoTitle = videoSectionInfoHeadline.getText();
		Logger.info("Video title - '" + videoTitle + "'");
		return videoTitle;
	}

	public boolean isVideoDeckVisible() {
		Logger.info("Verify if video deck is visible");
		return videoSectionInfoDeck.isVisible();
	}

	public String getVideoDeckText() {
		Logger.info("Get video deck text");
		return videoSectionInfoDeck.getText();
	}

	public boolean isPlaylistVisible(int playlistNumber) {
		Logger.info("Verify if playlist #" + playlistNumber + " is visible");
		return playlist.isElementNumberVisible(playlistNumber);
	}

	public int getNumberOfPlaylistsOnPage() {
		Logger.info("Get number of playlists on page");
		return playlist.getVisibleElementsCount();
	}

	public void scrollToPlaylist(int playlistNumber) {
		Logger.info("Scroll to playlist #" + playlistNumber);
		playlist.scrollToElementNumber(playlistNumber);
	}

	public boolean isPlaylistHeadlineVisible(int playlistNumber) {
		Logger.info("Verify if playlist #" + playlistNumber + " is visible");
		return playlistHeadline.isElementNumberVisible(playlistNumber);
	}

	public int getNumberOfVideosInPlaylist(int playlistNumber) {
		Logger.info("Get number of videos in playlist #" + playlistNumber);
		return Integer.valueOf(playlistHeadlineVideoCount.getTextFromElementNumber(playlistNumber).split(" ")[0]);
	}

	public boolean isFormCardInPosition(int positionNumber) {
		Logger.info("Verify if Form is in position #" + positionNumber + " in playlist");
		return playlistCard.getAttributeOfElementNumberWithText(positionNumber, "class", "1").contains("form");
	}

	public int getNumberOfCardsInPlaylist(int playlistNumber) {
		Logger.info("Get number of video cards in playlist");
		return playlistVideoCard.getElementsWithTextCount(String.valueOf(playlistNumber));
	}

	public CusoVideologuesPage clickVideoCard(int playlistNumber, int cardNumber) {
		Logger.info("Click on video card #" + cardNumber + " in playlist #" + playlistNumber);
		if (cardNumber == 1 && playlistNumber == 1) {
			cardNumber++;
		}
		playlistVideoCard.clickOnElementNumberWithText(cardNumber, String.valueOf(playlistNumber));
		waitForAjaxRequestToBeFinished(2000); //for video to load
		return this;
	}

	public String getVideoTitleFromCard(int playlistNumber, int cardNumber) {
		Logger.info("Get video title from card #" + cardNumber + " in playlist #" + playlistNumber);
		String cardVideoTitle = playlistVideoCardHeadline.getTextFromElementWithText(String.valueOf(playlistNumber), cardNumber);
		Logger.info("Video title on card - '" + cardVideoTitle + "'");
		return cardVideoTitle;
	}

	public boolean isNowViewingVisibleForCard(int playlistNumber, int cardNumber) {
		Logger.info("Verify if video card #" + cardNumber + " in playlist #" + playlistNumber + " 'Now viewing' label is visible");
		return playlistNowViewingLabel.isElementWithTextVisible(String.valueOf(playlistNumber), cardNumber);
	}

	public boolean isVideoHeadlineOnCardVisible(int playlistNumber, int cardNumber) {
		Logger.info("Verify if headline is visible for card #" + cardNumber + " in playlist #" + playlistNumber);
		return playlistVideoCardHeadline.isElementWithTextVisible(String.valueOf(playlistNumber), cardNumber);
	}

	public boolean isVideoTypeIconOnCardVisible(int playlistNumber, int cardNumber) {
		Logger.info("Verify if type icon is visible for card #" + cardNumber + " in playlist #" + playlistNumber);
		return playlistVideoCardTypeIcon.isElementWithTextVisible(String.valueOf(playlistNumber), cardNumber);
	}

	public boolean isVideoImageOnCardVisible(int playlistNumber, int cardNumber) {
		Logger.info("Verify if image is visible for card #" + cardNumber + " in playlist #" + playlistNumber);
		return playlistVideoCardImage.isElementWithTextVisible(String.valueOf(playlistNumber), cardNumber);
	}

	public String getHrefFromVideoCard(int playlistNumber, int cardNumber) {
		Logger.info("Get 'href' attribute for card #" + cardNumber + " in playlist #" + playlistNumber);
		return playlistVideoCardLink.getAttributeOfElementNumberWithText(cardNumber, "href", String.valueOf(playlistNumber));
	}

	public String getHrefFromVideoCardImage(int playlistNumber, int cardNumber) {
		Logger.info("Get 'href' attribute for card image #" + cardNumber + " in playlist #" + playlistNumber);
		return playlistVideoCardImageLink.getAttributeOfElementNumberWithText(cardNumber, "href", String.valueOf(playlistNumber));
	}

	public String getHrefFromVideoCardHeadline(int playlistNumber, int cardNumber) {
		Logger.info("Get 'href' attribute for card headline #" + cardNumber + " in playlist #" + playlistNumber);
		return playlistVideoCardHeadlineLink.getAttributeOfElementNumberWithText(cardNumber, "href", String.valueOf(playlistNumber));
	}

	public boolean isPreviousNavigationArrowVisibleInPlaylist(int playlistNumber) {
		Logger.info("Verify if '<' navigation arrow is visible in playlist #" + playlistNumber);
		return playlistPrevArrow.isElementWithTextVisible(String.valueOf(playlistNumber));
	}

	public boolean isNextNavigationArrowVisibleInPlaylist(int playlistNumber) {
		Logger.info("Verify if '>' navigation arrow is visible in playlist #" + playlistNumber);
		return playlistNextArrow.isElementWithTextVisible(String.valueOf(playlistNumber));
	}

	public void clickNextNavigationArrowInPlaylist(int playlistNumber) {
		Logger.info("Click '>' navigation arrow in playlist #" + playlistNumber);
		playlistNextArrow.clickOnElementNumberWithText(1, String.valueOf(playlistNumber));
		waitForAjaxRequestToBeFinished();
	}

	public void clickPreviousNavigationArrowInPlaylist(int playlistNumber) {
		Logger.info("Click '<' navigation arrow in playlist #" + playlistNumber);
		playlistPrevArrow.clickOnElementNumberWithText(1, String.valueOf(playlistNumber));
		waitForAjaxRequestToBeFinished();
	}

	public boolean isReadNextWidgetVisible() {
		Logger.info("Verify if Read next widget is visible");
		return readNextWidget.isVisible();
	}

	public boolean isReadNextWidgetHeadlineVisible() {
		Logger.info("Verify if Read next widget headline is visible");
		return readNextWidgetHeadline.isVisible();
	}

	public boolean isReadNextCategoryLinkVisible() {
		Logger.info("Verify if Read next widget headline category link is visible");
		return readNextWidgetHeadlineCategoryLink.isVisible();
	}

	public int getNumberOfCardsInReadNext() {
		Logger.info("Get number of cards in Read next widget");
		return readNextWidgetCard.getNumberOfVisibleAndClickableElements();
	}

	public String getReadNextCardHrefAttributeValue(int cardNumber) {
		Logger.info("Get 'href' attribute value for card #" + cardNumber + " in Read next widget");
		return readNextWidgetCardLink.getAttributeOfElementNumber(cardNumber, "href");
	}

	public boolean isReadNextCardImageVisible(int cardNumber) {
		Logger.info("Verify if Read next card image #" + cardNumber + " is visible");
		return readNextWidgetCardImage.isElementNumberVisible(cardNumber);
	}

	public boolean isReadNextCardHeadlineVisible(int cardNumber) {
		Logger.info("Verify if Read next card headline #" + cardNumber + " is visible");
		return readNextWidgetCardHeadline.isElementNumberVisible(cardNumber);
	}

	public boolean isReadNextCardTypeIconVisible(int cardNumber) {
		Logger.info("Verify if Read next card type icon #" + cardNumber + " is visible");
		return readNextWidgetCardTypeIcon.isElementNumberVisible(cardNumber);
	}

	public boolean isLastUpdatedVisible() {
		Logger.info("Verify if 'Last updated' string is visible");
		return lastUpdated.isVisible();
	}

	public String getLastUpdatedDate() {
		Logger.info("Get 'Last updated' date");
		String date = lastUpdated.getText().split(":")[1].trim();
		Logger.info("Date is - " + date);
		return date;
	}

	public boolean isNavigationBlockVisible() {
		Logger.info("Verify if navigation block is visible");
		return videologuesNavigation.isVisible();
	}

	public boolean isPreviousNavigationArrowVisible() {
		Logger.info("Verify if 'Previous' navigation arrow is visible");
		return videologuesNavigationPrev.isVisible();
	}

	public String getPreviousNavigationArrowHrefAttributeValue() {
		Logger.info("Get 'Previous' navigation arrow 'href' attribute value");
		return videologuesNavigationPrev.getAttribute("href");
	}

	public boolean isNextNavigationArrowVisible() {
		Logger.info("Verify if 'Next' navigation arrow is visible");
		return videologuesNavigationNext.isVisible();
	}

	public String getNextNavigationArrowHrefAttributeValue() {
		Logger.info("Get 'Next' navigation arrow 'href' attribute value");
		return videologuesNavigationNext.getAttribute("href");
	}

	public boolean isBreadcrumbArrowVisible() {
		Logger.info("Verify if breadcrumb arrow (<) is visible");
		return breadcrumbArrow.isVisible();
	}

	public String getBreadcrumbHrefAttributeValue() {
		Logger.info("Get breadcrumb 'href' value");
		return breadcrumb.getAttribute("href");
	}
}