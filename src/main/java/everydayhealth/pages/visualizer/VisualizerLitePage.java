package everydayhealth.pages.visualizer;

import everydayhealth.pages.articles.IGNPlayerPage;
import framework.Logger;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

public class VisualizerLitePage extends IGNPlayerPage {

	public VisualizerLitePage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "visualizer";
		String CLASS_NAME = "VisualizerLitePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject heroTitle;
	protected WebObject jumpOverview;
	protected WebObject overviewSection;
	protected WebObject overviewSectionTitle;
	protected WebObject overviewSectionDeck;
	protected WebObject overviewSectionImage;
	protected WebObject overviewSectionImageDescription;
	protected WebObject overviewSectionImageCaption;
	protected WebObject imageSelectorSection;
	protected WebObject imageSelectorSectionSlider;
	protected WebObject imageSelectorSectionSliderOption;
	protected WebObject imageSelectorSectionImage;
	protected WebObject personalStoriesSection;
	protected WebObject personalStoriesSectionTitle;
	protected WebObject personalStoriesSectionDescription;
	protected WebObject personalStoriesSectionContent;
	protected WebObject personalStoriesSectionContentCard;
	protected WebObject personalStoriesSectionCardThumbnailImage;
	protected WebObject personalStoriesSectionCardTitle;
	protected WebObject personalStoriesSectionCardDeck;
	protected WebObject personalStoriesSectionCardText;
	protected WebObject personalStoriesSectionCardSeeMoreNav;
	protected WebObject personalStoriesSectionSliderNext;
	protected WebObject personalStoriesSectionSliderPrev;
	protected WebObject personalStoriesSectionPager;
	protected WebObject personalStoriesSectionPagerDot;
	protected WebObject textOnlySection;
	protected WebObject textOnlySectionTitle;
	protected WebObject textOnlySectionContent;
	protected WebObject actionPlanSection;
	protected WebObject actionPlanSectionTitle;
	protected WebObject actionPlanSectionDeck;
	protected WebObject actionPlanSectionList;
	protected WebObject promoSection;
	protected WebObject promoSectionCard;
	protected WebObject promoSectionCardFromOurSponsorText;
	protected WebObject promoSectionCardHeadline;
	protected WebObject promoSectionCardThumbnailImage;
	protected WebObject imageCreditsSection;
	protected WebObject imageCreditsText;
	protected WebObject imageCreditsLink;
	protected WebObject videoSection;
	protected WebObject videoSectionPlaylist;
	protected WebObject videoSectionPlaylistItem;
	protected WebObject videoSectionPlaylistItemTitle;
	protected WebObject navigation;
	protected WebObject navigationItem;
	protected WebObject stickyNavigation;
	protected WebObject stickyNavigationPagination;
	protected WebObject stickyNavigationMenu;
	protected WebObject stickyNavigationMenuItem;
	protected WebObject statisticsSection;
	protected WebObject statisticsSectionTitle;
	protected WebObject statisticsSectionDeck;
	protected WebObject statisticsSectionSliderNext;
	protected WebObject statisticsSectionSliderPrev;
	protected WebObject statisticsSectionContentCard;
	protected WebObject statisticsSectionContentCardTitle;
	protected WebObject statisticsSectionContentCardStats;
	protected WebObject statisticsSectionContentCardDescription;
	protected WebObject statisticsSectionPager;
	protected WebObject statisticsSectionPagerDot;

	@Override
	public void waitForPageToLoad() {
		heroImage.waitUntilVisibleOnPage(this);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isHeroTitleVisible() {
		Logger.info("Verify if hero title is visible");
		return heroTitle.isVisible();
	}

	public boolean isJumpOverviewLinkVisible() {
		Logger.info("Verify if jump link overview is visible");
		return jumpOverview.isVisible();
	}

	public int getNumberOfOverviewSections() {
		Logger.info("Get number of Overview sections");
		int numberOfSections = overviewSection.getVisibleElementsCount();
		Logger.info("Number of Overview sections - " + numberOfSections);
		return numberOfSections;
	}

	public boolean isOverviewSectionTitleVisible(int sectionNumber) {
		Logger.info("Verify if overview section #" + sectionNumber + " title is visible");
		return overviewSectionTitle.isElementNumberVisible(sectionNumber);
	}

	public boolean isOverviewSectionDeckVisible(int sectionNumber) {
		Logger.info("Verify if overview section #" + sectionNumber + " deck is visible");
		return overviewSectionDeck.isElementNumberVisible(sectionNumber);
	}

	public boolean isOverviewSectionImageVisible(int sectionNumber) {
		Logger.info("Verify if overview section #" + sectionNumber + " image is visible");
		return overviewSectionImage.isElementNumberVisible(sectionNumber);
	}

	public boolean isOverviewSectionImageDescriptionVisible(int sectionNumber) {
		Logger.info("Verify if overview section #" + sectionNumber + " image description is visible");
		return overviewSectionImageDescription.isElementNumberVisible(sectionNumber);
	}

	public int getNumberOfImageCaptionsInOverviewSections() {
		Logger.info("Get number of image captions in overview sections");
		int numberOfCaptions = overviewSectionImageCaption.getVisibleElementsCount();
		Logger.info("Number of image captions - " + numberOfCaptions);
		return numberOfCaptions;
	}

	public boolean isImageSelectorSectionVisible() {
		Logger.info("Verify if image selector section is visible");
		return imageSelectorSection.isVisible();
	}

	public boolean isImageSelectorSectionSliderVisible() {
		Logger.info("Verify if slider is visible in image selector section");
		Utils.scrollPage(imageSelectorSectionSlider.getYCoordinate() - 100);
		return imageSelectorSectionSlider.isVisible();
	}

	public int getNumberOfImagesInImageSelectorSection() {
		Logger.info("Get number of images in image selector section");
		int numberOfImages = imageSelectorSectionImage.getElementsCount();
		Logger.info("Number of images in Image Selector section - " + numberOfImages);
		return numberOfImages;
	}

	public boolean isImageActiveInImageSelector(int imageNumber) {
		Logger.info("Verify if image #" + imageNumber + " is active in Image Selector section");
		return imageSelectorSectionImage.getAttributeOfElementNumber(imageNumber, "class").contains("active");
	}

	public int getIndexOfVisibleImageInSelector() {
		Logger.info("Get index of visible and clickable image");
		imageSelectorSectionSlider.scrollIntoView();
		return imageSelectorSectionImage.getFirstVisibleAndClickableElement();
	}

	public int getNumberOfSliderOptionsInImageSelectorSection() {
		Logger.info("Get number of slider options in image selector section");
		int numberOfOptions = imageSelectorSectionSliderOption.getNumberOfVisibleAndClickableElements();
		Logger.info("Number of slider options in Image Selector section - " + numberOfOptions);
		return numberOfOptions;
	}

	public void clickSliderOption(int optionNumber) {
		Logger.info("Click on slider option #" + optionNumber);
		imageSelectorSectionSliderOption.clickOnElementNumber(optionNumber);
		Utils.waitFor(1500);
	}

	public boolean isStatsSectionVisible() {
		Logger.info("Verify Stats Section is visible");
		statisticsSection.scrollIntoView();
		return statisticsSection.isVisible();
	}

	public String getStatsSectionStyleAttribute() {
		Logger.info("Get 'style' attribute for stats section");
		return statisticsSection.getAttribute("style");
	}

	public boolean isStatsSectionTitleVisible() {
		Logger.info("Verify if Stats section title is visible");
		return statisticsSectionTitle.isVisible();
	}

	public boolean isStatsSectionDeckVisible() {
		Logger.info("Verify if Stats section deck is visible");
		return statisticsSectionDeck.isVisible();
	}

	public boolean isNavigationArrowNextVisibleInStatsSection() {
		Logger.info("Verify if 'Next' navigation arrow is visible in Stats section");
		return statisticsSectionSliderNext.isVisible();
	}

	public boolean isNavigationArrowPreviousVisibleInStatsSection() {
		Logger.info("Verify if 'Previous' navigation arrow is visible in Stats section");
		return statisticsSectionSliderPrev.isVisible();
	}

	public void clickNextArrowInStatsSection() {
		Logger.info("Click 'Next' arrow in Stats section");
		statisticsSectionSliderNext.click();
		waitForAjaxRequestToBeFinished();
		Utils.waitFor(750);
	}

	public int getNumberOfStatsSectionContentCards() {
		Logger.info("Get number of content cards");
		int cardsCount = statisticsSectionContentCard.getElementsCount();
		Logger.info("Content cards count - " + cardsCount);
		return cardsCount;
	}

	public boolean isStatsSectionCardTitleVisible(int cardNumber) {
		Logger.info("Verify if title is visible for card #" + cardNumber);
		return statisticsSectionContentCardTitle.isElementNumberVisible(cardNumber);
	}

	public boolean isStatsSectionCardStatsInfoVisible(int cardNumber) {
		Logger.info("Verify if stats info is visible for card #" + cardNumber);
		return statisticsSectionContentCardStats.isElementNumberVisible(cardNumber);
	}

	public boolean isStatsSectionCardDescriptionVisible(int cardNumber) {
		Logger.info("Verify if description is visible for card #" + cardNumber);
		return statisticsSectionContentCardDescription.isElementNumberVisible(cardNumber);
	}

	public boolean isPersonalStoriesSectionVisible() {
		Logger.info("Verify Personal Stories section is visible");
		personalStoriesSection.scrollIntoView();
		return personalStoriesSection.isVisible();
	}

	public boolean isPersonalStoriesSectionTitleVisible() {
		Logger.info("Verify Personal Stories section title is visible");
		return personalStoriesSectionTitle.isVisible();
	}

	public boolean isPersonalStoriesSectionDeckVisible() {
		Logger.info("Verify if Personal Stories section deck is visible");
		return personalStoriesSectionDescription.isVisible();
	}

	public boolean isPersonalStoriesContentSectionVisible() {
		Logger.info("Verify Personal Stories section content is visible");
		return personalStoriesSectionContent.isVisible();
	}

	public int getNumberOfPersonalStoriesContentCards() {
		Logger.info("Get number of personal stories content cards");
		int cardsCount = personalStoriesSectionContentCard.getElementsCount();
		Logger.info("Content cards count - " + cardsCount);
		return cardsCount;
	}

	public boolean isNavigationArrowNextVisibleInPersonalStoriesSection() {
		Logger.info("Verify if 'Next' navigation arrow is visible in Personal Stories section");
		return personalStoriesSectionSliderNext.isVisible();
	}

	public boolean isNavigationArrowPreviousVisibleInPersonalStoriesSection() {
		Logger.info("Verify if 'Previous' navigation arrow is visible in Personal Stories section");
		return personalStoriesSectionSliderPrev.isVisible();
	}

	public void clickNextArrowInPersonalStoriesSection() {
		Logger.info("Click 'Next' arrow in Personal Stories section");
		personalStoriesSectionSliderNext.click();
		waitForAjaxRequestToBeFinished();
		Utils.waitFor(750);
	}

	public boolean isPersonalStoriesCardThumbnailImageVisible(int cardNumber) {
		Logger.info("Verify Thumbnail Image for card #" + cardNumber + " is visible");
		return personalStoriesSectionCardThumbnailImage.isElementNumberVisible(cardNumber);
	}

	public boolean isPersonalStoriesCardTitleVisible(int cardNumber) {
		Logger.info("Verify Title for card #" + cardNumber + " is visible");
		return personalStoriesSectionCardTitle.isElementNumberVisible(cardNumber);
	}

	public boolean isPersonalStoriesCardDeckVisible(int cardNumber) {
		Logger.info("Verify Deck for card #" + cardNumber + " is visible");
		return personalStoriesSectionCardDeck.isElementNumberVisible(cardNumber);
	}

	public boolean isPersonalStoriesCardTextVisible(int cardNumber) {
		Logger.info("Verify Text for card #" + cardNumber + " is visible");
		return personalStoriesSectionCardText.isElementNumberVisible(cardNumber);
	}

	public boolean isPersonalStoriesCardSeeMoreNavVisible(int cardNumber) {
		Logger.info("Verify See More Nav #" + cardNumber + " is visible");
		return personalStoriesSectionCardSeeMoreNav.isElementNumberVisible(cardNumber);
	}

	public int getNumberOfTextOnlySections() {
		Logger.info("Get number of text only sections");
		return textOnlySection.getVisibleElementsCount();
	}

	public boolean isTextOnlySectionTitleVisible(int sectionNumber) {
		Logger.info("Verify Title is visible on the text only section #" + sectionNumber);
		return textOnlySectionTitle.isElementNumberVisible(sectionNumber);
	}

	public boolean isTextOnlySectionContentVisible(int sectionNumber) {
		Logger.info("Verify Content is visible on the text only section #" + sectionNumber);
		return textOnlySectionContent.isElementNumberVisible(sectionNumber);
	}

	public boolean isPromoSectionVisible() {
		Logger.info("Verify Promo Section is visible");
		promoSection.scrollIntoView();
		return promoSection.isVisible();
	}

	public boolean isPromoSectionCardVisible() {
		Logger.info("Verify promo section card is visible");
		return promoSectionCard.isVisible();
	}

	public boolean isPromoSectionFromOurSponsorTextVisible() {
		Logger.info("Verify 'From our sponsor' is visible in Promo section");
		return promoSectionCardFromOurSponsorText.isVisible();
	}

	public boolean isPromoSectionCardHeadlineVisible() {
		Logger.info("Verify promo section card headline is visible");
		return promoSectionCardHeadline.isVisible();
	}

	public boolean isPromoSectionCardThumbnailImageVisible() {
		Logger.info("Verify promo section card thumbnail image is visible");
		return promoSectionCardThumbnailImage.isVisible();
	}

	public boolean isActionPlanSectionVisible() {
		Logger.info("Verify action plan section is visible");
		return actionPlanSection.isVisible();
	}

	public String getActionPlanStyleAttribute() {
		Logger.info("Get action plan section style attribute");
		return actionPlanSection.getAttribute("style");
	}

	public boolean isActionPlanSectionTitleVisible() {
		Logger.info("Verify action plan section title is visible");
		return actionPlanSectionTitle.isVisible();
	}

	public boolean isActionPlanSectionDeckVisible() {
		Logger.info("Verify action plan section deck is visible");
		return actionPlanSectionDeck.isVisible();
	}

	public boolean isActionPlanSectionListVisible() {
		Logger.info("Verify Action plan section list is visible");
		return actionPlanSectionList.isVisible();
	}

	public boolean isImageCreditsSectionVisible() {
		Logger.info("Verify image credits section is visible");
		return imageCreditsSection.isVisible();
	}

	public boolean isImageCreditsTextVisible() {
		Logger.info("Verify if text is visible in image credits section");
		return imageCreditsText.isVisible();
	}

	public String getImageCreditsText() {
		Logger.info("Get image credits text");
		return imageCreditsText.getText();
	}

	public int getNumberOfImageCreditLinks() {
		Logger.info("Get number of credit links");
		return imageCreditsLink.getNumberOfVisibleAndClickableElements();
	}

	public boolean isVideoSectionVisible() {
		Logger.info("Verify if video section is visible");
		videoSection.scrollIntoView();
		return videoSection.isVisible();
	}

	public boolean isVideoSectionPlaylistVisible() {
		Logger.info("Verify if playlist is visible in video section");
		return videoSectionPlaylist.isVisible();
	}

	public int getNumberOfVideosInPlaylist() {
		Logger.info("Get number of videos in playlist");
		return videoSectionPlaylistItem.getNumberOfVisibleAndClickableElements();
	}

	public boolean isVideoActive(int videoNumber) {
		Logger.info("Verify if video #" + videoNumber + " is active");
		return videoSectionPlaylistItem.getAttributeOfElementNumber(videoNumber, "class").contains("--active");
	}

	public void clickStatsSectionDot(int dotNumber) {
		Logger.info("Click stats section dot #" + dotNumber);
		if (isLegalTextMessageVisible()) {
			clickCloseIconOnLegalTextMessage();
		}
		statisticsSectionPager.scrollIntoView();
		statisticsSectionPagerDot.clickOnElementNumber(dotNumber);
		waitForAjaxRequestToBeFinished();
	}

	public void clickPersonalStoriesSectionDot(int dotNumber) {
		Logger.info("Click personal stories section dot #" + dotNumber);
		if (isLegalTextMessageVisible()) {
			clickCloseIconOnLegalTextMessage();
		}
		personalStoriesSectionPager.scrollIntoView();
		personalStoriesSectionPagerDot.clickOnElementNumber(dotNumber);
		waitForAjaxRequestToBeFinished();
	}

	public void clickVideoInPlaylist(int videoNumber) {
		Logger.info("Click on video #" + videoNumber);
		videoSectionPlaylistItem.clickOnElementNumber(videoNumber);
		waitForAjaxRequestToBeFinished();
	}
}
