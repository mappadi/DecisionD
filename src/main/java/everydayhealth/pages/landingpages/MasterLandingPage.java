package everydayhealth.pages.landingpages;

import everydayhealth.pages.articles.IGNPlayerPage;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class MasterLandingPage extends IGNPlayerPage {

	public MasterLandingPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "landingpages";
		String CLASS_NAME = "MasterLandingPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject jumpLink;
	protected WebObject jumpLinkItems;
	protected WebObject relatedContentCard;
	protected WebObject linkListLinks;
	protected WebObject linkListSection;
	protected WebObject linkListTitle;
	protected WebObject contentSection;
	protected WebObject contentSectionWithText;
	protected WebObject contentSectionBlockTitle;
	protected WebObject continueReading;
	protected WebObject featuredPromoSection;
	protected WebObject featuredPromoSectionLink;
	protected WebObject featuredPromoSectionImage;
	protected WebObject featuredPromoSectionTag;
	protected WebObject featuredPromoSectionTitle;
	protected WebObject featuredPromoSectionDeck;
	protected WebObject mostRecentViewAll;
	protected WebObject relatedWidgetWithCard;
	protected WebObject relatedWidgetCardItemImage;
	protected WebObject relatedWidgetCardItemTitle;
	protected WebObject relatedWidgetWithLink;
	protected WebObject relatedWidgetLinkItemBody;
	protected WebObject relatedWidgetLinkItemImage;
	protected WebObject relatedWidgetWithCardItem;
	protected WebObject relatedWidgetWithLinkItem;
	protected WebObject pullQuote;
	protected WebObject pullQuoteText;
	protected WebObject pullQuoteAuthor;
	protected WebObject pullQuoteSocialBarOpenIcon;
	protected WebObject pullQuoteSocialBarCloseIcon;
	protected WebObject pullQuoteSocialBar;
	protected WebObject pullQuoteSocialBarLink;

	@Override
	public void waitForPageToLoad() {
		jumpLink.waitUntilVisibleOnPage(this);
	}

	public int getNumberOfRelatedWidgetWithCard() {
		Logger.info("Get Number of Related Widgets with card");
		return relatedWidgetWithCard.getVisibleElementsCount();
	}

	public void scrollToPromoSection() {
		Logger.info("Scroll to promo section");
		featuredPromoSection.scrollToElement();
	}

	public void scrollToLinkList() {
		Logger.info("Scroll to link list");
		linkListSection.scrollToElement();
	}

	public int getRelatedWidgetWithCardItemCount() {
		Logger.info("Get Related Widget with card items count");
		return relatedWidgetWithCardItem.getVisibleElementsCount();
	}

	public boolean isRelatedWidgetWithCardItemImageVisible(int itemNumber) {
		Logger.info("Verify related widget card image is visible");
		relatedWidgetCardItemImage.scrollToElementNumber(itemNumber);
		return relatedWidgetCardItemImage.isElementNumberVisible(itemNumber);
	}

	public boolean isRelatedWidgetWithCardItemTitleVisible(int itemNumber) {
		Logger.info("Verify related widget card title is visible");
		return relatedWidgetCardItemTitle.isElementNumberVisible(itemNumber);
	}

	public int getNumberOfRelatedWidgetWithLink() {
		Logger.info("Get Number of Related Widgets with links");
		return relatedWidgetWithLink.getVisibleElementsCount();
	}

	public int getRelatedWidgetWithLinkItemCount() {
		Logger.info("Get number of Related widget with link items count");
		return relatedWidgetWithLinkItem.getVisibleElementsCount();
	}

	public boolean isRelatedWidgetWithLinkItemBodyVisible(int itemNumber) {
		Logger.info("Verify related widget with Link body is visible");
		return relatedWidgetLinkItemBody.isElementNumberVisible(itemNumber);
	}

	public boolean isRelatedWidgetWithLinkItemImageVisible(int itemNumber) {
		Logger.info("Verify related widget with Link Image is Visible");
		return relatedWidgetLinkItemImage.isElementNumberVisible(itemNumber);
	}

	public int getNumberOfViewAllSections() {
		Logger.info("Get Number of View All sections");
		return mostRecentViewAll.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfVisibleFeaturedPromoSections() {
		Logger.info("Get number of Featured Promo sections");
		return featuredPromoSection.getNumberOfVisibleAndClickableElements();
	}

	public String getFeaturedPromoSectionItemHref(int sectionNumber) {
		Logger.info("Get the featured promo section 'href' attribute value");
		return featuredPromoSectionLink.getHrefOfElementNumber(sectionNumber);
	}

	public boolean isFeaturedPromoSectionImageVisible(int sectionNumber) {
		Logger.info("Verify featured promo image is visible");
		featuredPromoSection.scrollIntoView(sectionNumber);
		return featuredPromoSectionImage.isElementNumberVisible(sectionNumber);
	}

	public boolean isFeaturedPromoSectionTagVisible(int sectionNumber) {
		Logger.info("Verify tag is visible in the featured promo section");
		return featuredPromoSectionTag.isElementNumberVisible(sectionNumber);
	}

	public boolean isFeaturedPromoSectionTitleVisible(int sectionNumber) {
		Logger.info("Verify featured text is visible in the featured promo section");
		return featuredPromoSectionTitle.isElementNumberVisible(sectionNumber);
	}

	public boolean isFeaturedPromoSectionDeckVisible(int sectionNumber) {
		Logger.info("Verify dek section is visible in the featured promo section");
		return featuredPromoSectionDeck.isElementNumberVisible(sectionNumber);
	}

	public boolean isJumpLinkVisible() {
		Logger.info("Verify JumpLink section is visible");
		return jumpLink.isVisible();
	}

	public int getNumberOfContinueReading() {
		Logger.info("Get number of Continue Reading sections on page");
		return continueReading.getNumberOfVisibleAndClickableElements();
	}

	public void clickContinueReading(int sectionNumber) {
		Logger.info("Click on Continue Reading");
		continueReading.clickOnElementNumber(sectionNumber);
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfJumpLinks() {
		Logger.info("Get number of Jumplink items on page");
		return jumpLinkItems.getNumberOfVisibleAndClickableElements();
	}

	public void clickJumpLinks(int linkNumber) {
		Logger.info("Click on JumpLink #" + linkNumber);
		jumpLinkItems.clickOnElementNumber(linkNumber);
		waitForAjaxRequestToBeFinished();
	}

	public String getJumpLinkText(int linkNumber) {
		Logger.info("Get text from jump link #" + linkNumber);
		return jumpLinkItems.getTextFromElementNumber(linkNumber).toLowerCase().replace(" ", "");
	}

	public boolean isFeaturedPromoSectionVisible() {
		Logger.info("Verify Featured Promo section is visible");
		return featuredPromoSection.isVisible();
	}

	public boolean isRelatedContentCardsVisible() {
		Logger.info("Verify Related content card is visible");
		return relatedContentCard.isVisible();
	}

	public int getNumberOfRelatedContentCards() {
		Logger.info("Get number of related content cards");
		return relatedContentCard.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfTextContentSections() {
		Logger.info("Get number of text blocks on page");
		return contentSection.getVisibleElementsCount();
	}

	public boolean isSectionInViewPort(int section) {
		Logger.info("Verify if section #" + section + " is in view port");
		String jumpLinkTitle = getJumpLinkText(section).toLowerCase().replace("?", "");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHF-3954");
		return contentSectionWithText.isElementWithTextInViewPort(jumpLinkTitle);
	}

	public boolean isContentSectionTitleVisible(int sectionNumber) {
		Logger.info("Verify if title is visible in section #" + sectionNumber);
		return contentSectionBlockTitle.isElementNumberVisible(sectionNumber);
	}

	public int getNumberOfVisibleLinkListSections() {
		Logger.info("Get number of link list sections");
		return linkListSection.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfLinksInLinkList(int sectionNumber) {
		Logger.info("Get number of links in link list section #" + sectionNumber);
		return linkListLinks.getElementsWithTextCount(String.valueOf(sectionNumber));
	}

	public String getLinklistLinkHrefAttributeValue(int sectionNumber, int linkNumber) {
		Logger.info("Get 'href' attribute value for link #" + linkNumber + " in section #" + sectionNumber);
		return linkListLinks.getAttributeOfElementNumberWithText(linkNumber, "href", String.valueOf(sectionNumber));
	}

	public boolean isLinkListSectionTitleVisible(int sectionNumber) {
		Logger.info("Verify if link list section title is visible");
		return linkListTitle.isElementNumberVisible(sectionNumber);
	}

	public boolean isPullQuoteVisible() {
		Logger.info("Verify if pull quote is visible");
		return pullQuote.isVisible();
	}

	public boolean isPullQuoteTextVisible() {
		Logger.info("Verify if pull quote text is visible");
		return pullQuoteText.isVisible();
	}

	public String getPullQuoteText() {
		Logger.info("Get pull quote text");
		return pullQuoteText.getText();
	}

	public boolean isPullQuoteSocialBarVisible() {
		Logger.info("Verify if pull quote social bar is visible");
		return pullQuoteSocialBar.isVisible();
	}

	public boolean isPullQuoteSocialBarIconVisible() {
		Logger.info("Verify if pull quote social bar icon is visible");
		return pullQuoteSocialBarOpenIcon.isVisible();
	}

	public void clickPullQuoteSocialBarOpenIcon() {
		Logger.info("Click pull quote social bar open icon");
		pullQuoteSocialBarOpenIcon.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isPullQuoteSocialBarCloseIconVisible() {
		Logger.info("Verify if [x] close icon is visible on social bar");
		return pullQuoteSocialBarCloseIcon.isVisible();
	}

	public void clickPullQuoteSocialBarCloseIcon() {
		Logger.info("Click pull quote social bar close icon");
		pullQuoteSocialBarCloseIcon.click();
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfSocialLinks() {
		Logger.info("Get number of social icons");
		return pullQuoteSocialBarLink.getNumberOfVisibleAndClickableElements();
	}

	public String getSocialIconHrefAttributeValue(int iconNumber) {
		Logger.info("Get 'href' attribute value for social icon #" + iconNumber);
		return pullQuoteSocialBarLink.getHrefOfElementNumber(iconNumber);
	}
}