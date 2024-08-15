package everydayhealth.pages.articles;

import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class CustomSolutionsTemplatePage extends ArticleNewTemplatePage {

	public CustomSolutionsTemplatePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "CustomSolutionsTemplatePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject headlineSection;
	protected WebObject headlineSectionTitle;
	protected WebObject headlineSectionDeck;
	protected WebObject breadcrumb;
	protected WebObject breadcrumbArrow;
	protected WebObject featuredPromoSectionBlocks;
	protected WebObject featuredPromoSectionBlockLink;
	protected WebObject featuredPromoSectionBlockImage;
	protected WebObject featuredPromoSectionBlockTag;
	protected WebObject featuredPromoSectionBlockTagLink;
	protected WebObject featuredPromoSectionBlockHeadline;
	protected WebObject featuredPromoSectionBlockDeck;
	protected WebObject cusoHeaderNavigation;
	protected WebObject cusoHeaderTitle;
	protected WebObject cusoHeaderTitleWithHref;
	protected WebObject cusoEyebrow;
	protected WebObject cusoHeaderSubnav;
	protected WebObject primaryImage;
	protected WebObject secondaryImage;
	protected WebObject promoWidget;
	protected WebObject promoHeader;
	protected WebObject promoArticles;
	protected WebObject promoArticlesImage;
	protected WebObject promoArticlesImageLink;
	protected WebObject promoArticlesTitle;
	protected WebObject relatedArticles;
	protected WebObject relatedHeader;
	protected WebObject relatedArticlesTitle;
	protected WebObject relatedArticlesImage;
	protected WebObject relatedArticlesImageLink;
	protected WebObject readNext;
	protected WebObject readNextArticles;
	protected WebObject readNextArticlesTitle;
	protected WebObject readNextArticlesImage;
	protected WebObject readNextArticlesImageLink;
	protected WebObject readNextHeader;
	protected WebObject readNextEyebrow;
	protected WebObject cusoHeaderSubnavMore; //mobile and tablet only
	protected WebObject patientSupportBarToggle;
	protected WebObject patientSupportBarContent;
	protected WebObject patientSupportBarSocialShareIcons;

	public boolean isSecondaryImageVisible() {
		Logger.info("Verify if secondary image is visible");
		return secondaryImage.isVisible();
	}

	public boolean isPrimaryImageVisible() {
		Logger.info("Verify if primary image is visible");
		return primaryImage.isVisible();
	}

	public boolean isHeaderVisible() {
		Logger.info("Verify header is visible");
		return cusoHeaderTitle.isVisible();
	}

	public boolean isPromoSectionVisible() {
		Logger.info("Verify promo section is visible");
		return promoWidget.isVisible();
	}

	public boolean isPromoHeaderVisible() {
		Logger.info("Verify promo header is visible");
		return promoHeader.isVisible();
	}

	public int getPromoWidgetYCoordinate() {
		Logger.info("Get promo widget Y-coordinate");
		return promoWidget.getElement().getLocation().y;
	}

	public int getNumberOfPromoArticles() {
		Logger.info("Get number of Promo widget articles");
		return promoArticles.getNumberOfVisibleAndClickableElements();
	}

	public boolean isPromoImageNumberVisible(int itemNumber) {
		Logger.info("Verify Promo article image #" + itemNumber + " is visible");
		return promoArticlesImage.isElementNumberVisible(itemNumber);
	}

	public String getPromoImageNumberHrefValue(int itemNumber) {
		Logger.info("Get 'href' value of Promo article image #" + itemNumber);
		return promoArticlesImageLink.getHrefOfElementNumber(itemNumber);
	}

	public boolean isPromoTitleNumberVisible(int itemNumber) {
		Logger.info("Verify Promo article title #" + itemNumber + " is visible");
		return promoArticlesTitle.isElementNumberVisible(itemNumber);
	}

	public String getPromoTitleNumberHrefValue(int itemNumber) {
		Logger.info("Get 'href' value of Promo article title #" + itemNumber);
		return promoArticlesTitle.getHrefOfElementNumber(itemNumber);
	}

	public boolean isReadNextSectionVisible() {
		Logger.info("Verify read next section is visible");
		return readNextArticles.isVisible();
	}

	public boolean isReadNextHeaderVisible() {
		Logger.info("Verify read next header is visible");
		return readNextHeader.isVisible();
	}

	public boolean isReadNextEyebrowVisible() {
		Logger.info("Verify read next eyebrow is visible");
		return readNextEyebrow.isVisible();
	}

	public int getNumberOfVisibleReadNextEyebrows() {
		Logger.info("Get number of visible eyebrows in 'Read next' section");
		return readNextEyebrow.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfReadNextItems() {
		Logger.info("Get number of articles on Read next widget");
		return readNextArticles.getNumberOfVisibleAndClickableElements();
	}

	public boolean isReadNextImageNumberVisible(int itemNumber) {
		Logger.info("Verify Read next article image #" + itemNumber + " is visible");
		return readNextArticlesImage.isElementNumberVisible(itemNumber);
	}

	public String getReadNextImageNumberHrefValue(int itemNumber) {
		Logger.info("Get 'href' value of Read next article image #" + itemNumber);
		return readNextArticlesImageLink.getHrefOfElementNumber(itemNumber);
	}

	public boolean isReadNextTitleNumberVisible(int itemNumber) {
		Logger.info("Verify Read next article title #" + itemNumber + " is visible");
		return readNextArticlesTitle.isElementNumberVisible(itemNumber);
	}

	public String getReadNextTitleNumberHrefValue(int itemNumber) {
		Logger.info("Get 'href' value of Read next article title #" + itemNumber);
		return readNextArticlesTitle.getHrefOfElementNumber(itemNumber);
	}

	public boolean isRelatedHeaderVisible() {
		Logger.info("Verify Related header is visible");
		return relatedHeader.isVisible();
	}

	public int getNumberOfRelatedItems() {
		Logger.info("Get number of articles on Related widget");
		return relatedArticles.getNumberOfVisibleAndClickableElements();
	}

	public boolean isRelatedImageNumberVisible(int itemNumber) {
		Logger.info("Verify Related article image #" + itemNumber + " is visible");
		return relatedArticlesImage.isElementNumberVisible(itemNumber);
	}

	public String getRelatedImageNumberHrefValue(int itemNumber) {
		Logger.info("Get 'href' value of Related article image #" + itemNumber);
		return relatedArticlesImageLink.getHrefOfElementNumber(itemNumber);
	}

	public boolean isRelatedTitleNumberVisible(int itemNumber) {
		Logger.info("Verify Related article title #" + itemNumber + " is visible");
		return relatedArticlesTitle.isElementNumberVisible(itemNumber);
	}

	public String getRelatedTitleNumberHrefValue(int itemNumber) {
		Logger.info("Get 'href' value of Related article title #" + itemNumber);
		return relatedArticlesTitle.getHrefOfElementNumber(itemNumber);
	}

	public boolean isCusoNavigationWidgetVisible() {
		return cusoHeaderNavigation.isVisible();
	}

	public int getHeaderNavigationXCoordinateValue() {
		Logger.info("Get Header navigation X coordinate value");
		return cusoHeaderNavigation.getXCoordinate();
	}

	public boolean isCusoHeaderTitleVisible() {
		Logger.info("Verify Header Navigation title is visible");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHF-3817");
		return cusoHeaderTitleWithHref.isVisible();
	}

	public boolean isCusoHeaderTitleClickable() {
		Logger.info("Verify Header Navigation title is clickable");
		return !cusoHeaderTitleWithHref.getHrefOfElementNumber(1).isEmpty();
	}

	public boolean isCusoHeaderEyebrowVisible() {
		Logger.info("Verify Header Navigation Eyebrow is visible");
		return cusoEyebrow.isVisible();
	}

	public boolean isCusoHeaderSubnavVisible() {
		Logger.info("Verify Header Navigation subnav is visible");
		return cusoHeaderSubnav.isVisible();
	}

	public void clickSubnavMoreButton() {
		if (Settings.isMobile()) {
			Logger.info("Click 'More' button on subnavition unit (mobile)");
			cusoHeaderSubnavMore.click();
		}
	}

	public int getNumberOfCusoHeaderSubnavLinks() {
		Logger.info("Get number of subnavigation links");
		return cusoHeaderSubnav.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefValueOfCusoSubnavLinkNumber(int linkNumber) {
		Logger.info("Get 'href' value of cuso subnav link #" + linkNumber);
		return cusoHeaderSubnav.getHrefOfElementNumber(linkNumber);
	}

	public boolean isReadNextVisible() {
		Logger.info("Verify 'Read Next' visible");
		return readNext.isVisible();
	}

	public boolean isPatientSupportBarVisible() {
		Logger.info("Verify Patient support bar is visible");
		return patientSupportBarContent.isVisible();
	}

	public boolean isPatientSupportBarSocialShareIconsVisible() {
		Logger.info("Verify Patient support bar social share icons is visible");
		return patientSupportBarSocialShareIcons.getVisibleElementsCount() > 0;
	}

	public String getPatientSupportBarToggleText() {
		Logger.info("Get Patient support bar toggle value");
		return patientSupportBarToggle.getText();
	}

	public void clickPatientSupportBarCloseButton() {
		Logger.info("Click on Patient support bar 'Close' button");
		patientSupportBarToggle.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isPatientSupportBarOpen() {
		Logger.info("Verify if Patient support bar is open");
		return patientSupportBarContent.getAttribute("style").equalsIgnoreCase("display: block;");
	}

	public boolean isHeadlineTitleVisible() {
		Logger.info("Get headline title visible");
		return headlineSectionTitle.isVisible();
	}

	public String getHeadlineTitleText() {
		Logger.info("Get headline title text");
		return headlineSectionTitle.getText();
	}

	public boolean isHeadlineDeckVisible() {
		Logger.info("Verify if headline deck is visible");
		return headlineSectionDeck.isVisible();
	}

	public String getHeadlineDeckText() {
		Logger.info("Get headline deck text");
		return headlineSectionDeck.getText();
	}

	public boolean isHeadlineSectionVisible() {
		Logger.info("Verify if headline section is visible");
		return headlineSection.isVisible();
	}

	public int getHeadlineSectionYCoordinateValue() {
		Logger.info("Get headline section Y coordinate value");
		return headlineSection.getYCoordinate();
	}

	public boolean isBreadcrumbVisible() {
		Logger.info("Verify if breadcrumb is visible in Headline section");
		return breadcrumb.isVisible();
	}

	public boolean isBreadcrumbArrowVisible() {
		Logger.info("Verify if breadcrumb arrow (<) is visible");
		return breadcrumbArrow.isVisible();
	}

	public String getBreadcrumbHrefAttributeValue() {
		Logger.info("Get breadcrumb 'href' value");
		return breadcrumb.getAttribute("href");
	}

	public int getFeaturedPromoSectionYCoordinateValue() {
		Logger.info("Get Featured Promo section Y coordinate value");
		return featuredPromoSectionBlocks.getYCoordinate();
	}

	public int getNumberOfBlocksInFeaturedPromoSection() {
		Logger.info("Get number of blocks in Featured Promo section");
		return featuredPromoSectionBlocks.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfBlockTitles() {
		Logger.info("Get number of titles in Featured Promo section blocks");
		return featuredPromoSectionBlockHeadline.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfBlockImages() {
		Logger.info("Get number of images in Featured Promo section blocks");
		return featuredPromoSectionBlockImage.getNumberOfVisibleAndClickableElements();
	}

	public void scrollToFeaturedPromoImage(int imageNumber) {
		Logger.info("Scroll to Featured Promo image #" + imageNumber + " (lazy load)");
		featuredPromoSectionBlockImage.scrollToElementNumber(imageNumber);
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfBlockTags() {
		Logger.info("Get number of tags in Featured Promo section blocks");
		return featuredPromoSectionBlockTag.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfBlockDecks() {
		Logger.info("Get number of decks in Featured Promo section blocks");
		return featuredPromoSectionBlockDeck.getNumberOfVisibleAndClickableElements();
	}

	public boolean isFeaturedPromoSectionBlockURLValid(int blockNumber) {
		Logger.info("Verify 'href' value of Featured Promo section block #" + blockNumber + " is valid URL");
		String hrefValue = featuredPromoSectionBlockLink.getAttributeOfElementNumber(blockNumber, "href");
		Logger.info("Featured promo block #" + blockNumber + " URL: " + hrefValue);
		return !hrefValue.isEmpty();
	}
}