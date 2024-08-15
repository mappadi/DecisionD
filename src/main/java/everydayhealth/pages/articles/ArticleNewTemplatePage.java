package everydayhealth.pages.articles;

import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.registrations.InlineRegistration;
import framework.Logger;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Content Page Template Common Items
 */
public class ArticleNewTemplatePage extends BasicPageEH {

	public ArticleNewTemplatePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "ArticleNewTemplatePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject title;
	protected WebObject breadcrumb;
	protected WebObject breadcrumbLink;
	protected WebObject breadcrumbArrow;
	protected WebObject backToTop;
	protected WebObject recommendedForYouSection;
	protected WebObject flyout;
	protected WebObject flyoutArrow;
	protected WebObject flyoutLink;
	protected WebObject flyoutReadNext;
	protected WebObject flyoutArticleTitle;
	protected WebObject flyoutArticleImage;
	protected WebObject dontMissThisSection;
	protected WebObject dontMissThisHeader;
	protected WebObject dontMissThisArticles;
	protected WebObject dontMissThisArticleImages;
	protected WebObject dontMissThisArticleTitles;
	protected WebObject dontMissThisNativeAd;
	protected WebObject dontMissThisNativeAdDirectSold;
	protected WebObject dontMissThisNativeAdDirectSoldThumbnailImage;
	protected WebObject dontMissThisNativeAdDirectSoldAdchoiceIcon;
	protected WebObject dontMissThisNativeAdDirectSoldTitle;
	protected WebObject dontMissThisNativeAdDirectSoldSponsor;
	protected WebObject dontMissThisNativeAdProgrammed;
	protected WebObject dontMissThisNativeAdProgrammedThumbnailImage;
	protected WebObject dontMissThisNativeAdProgrammedTitle;
	protected WebObject dontMissThisNativeAdProgrammedSponsor;
	protected WebObject byLine;
	protected WebObject deck;
	protected WebObject reviewedBy;
	protected WebObject smartNewsletterModule;
	protected WebObject smartNewsletterEmailBox;
	protected WebObject smartNewsletterSubmitButton;
	protected WebObject smartNewsletterWarningMessage;
	protected WebObject smartNewsletterSuccessMessage;
	protected WebObject smartNewsletterExtra;
	protected WebObject smartNewsletterExtraOptions;
	protected WebObject bodyIFrameWidget;
	protected WebObject bodyIFrameWidgetFrame;
	protected WebObject rightRailIFrameWidget;
	protected WebObject rightRailIFrameWidgetFrame;
	protected WebObject moreInHeadline;
	protected WebObject moreInHeadlineCategoryLink;
	protected WebObject moreInSection;
	protected WebObject contentCard;
	protected WebObject contentCardImage;
	protected WebObject contentCardHeader;
	protected WebObject contentCardDesc;
	protected WebObject contentCardIcon;
	protected WebObject contentCardByline;
	protected WebObject seeMoreButton;
	protected WebObject articleBody;
	protected WebObject lastUpdatedDate;
	protected WebObject heroImage;
	protected WebObject imageCaption;
	protected WebObject imageCredit;
	protected WebObject tertiaryImage;
	protected WebObject secondaryImage;
	protected WebObject secondaryVideo;
	protected WebObject pullQuote;
	protected WebObject pullQuoteTwitterLink;
	protected WebObject keyTakeAways;
	protected WebObject keyTakeAwaysNotes;
	protected WebObject keyTakeAwaysWords;
	protected WebObject ampPageHeader;
	protected WebObject topicTag;
	protected WebObject eCommerceTitle;
	protected WebObject eCommerceProductImg;
	protected WebObject eCommerceProductDescription;
	protected WebObject eCommerceProductTitle;
	protected WebObject eCommerceProductPrice;
	protected WebObject eCommerceVendorName;
	protected WebObject eCommerceProductSectionTitle;
	protected WebObject eCommerceAffiliateText;
	protected WebObject eCommerceProductImgCaption;
	protected WebObject eCommerceWidget;
	protected WebObject relatedContentWidget;
	protected WebObject relatedContentWidgetLink;
	protected WebObject relatedContentWidgetEyebrow;
	protected WebObject relatedContentWidgetImage;
	protected WebObject relatedContentWidgetTitle;
	protected WebObject relatedContentWidgetDescription;

	@Override
	public void waitForPageToLoad() {
		waitForAjaxRequestToBeFinished(30000); //waiting for 30 sec for page to load (don't wait for any element as used for many pages with different elements)
	}

	public InlineRegistration onInlineRegistration() {
		return new InlineRegistration(basedriver);
	}

	public boolean isTitleVisible() {
		Logger.info("Verify if page title is visible");
		title.waitUntilVisible();
		title.scrollIntoView();
		return title.isVisible();
	}

	public String getTitleText() {
		Logger.info("Get page title text");
		return title.getText();
	}

	public boolean isHeroImageVisible() {
		Logger.info("Verify if hero image is visible");
		return heroImage.isVisible();
	}

	public int getHeroImageWidthValue() {
		Logger.info("Get hero image width value");
		int widthValue = heroImage.getElementWidth();
		Logger.info("Hero image width - " + widthValue);
		return widthValue;
	}

	public int getHeroImageYCoordinateValue() {
		Logger.info("Get hero image 'y' coordinate value");
		return heroImage.getYCoordinate();
	}

	public boolean isTertiaryImageVisible() {
		Logger.info("Check if tertiary image is visible");
		return tertiaryImage.isVisible();
	}

	public boolean isSecondaryImageVisible() {
		Logger.info("Check if secondary image is visible");
		return secondaryImage.isVisible();
	}

	public boolean isSecondaryVideoVisible() {
		Logger.info("Check if secondary video is visible");
		secondaryVideo.waitUntilVisible();
		return secondaryVideo.isVisible();
	}

	public boolean isHeroImageCaptionVisible() {
		Logger.info("Check if hero image caption is visible");
		return imageCaption.isVisible();
	}

	public boolean isHeroImageCreditVisible() {
		Logger.info("Check if hero image credit is visible");
		return imageCredit.isVisible();
	}

	public boolean isBackToTopVisible() {
		Logger.info("Check if back to top button is visible");
		waitForAjaxRequestToBeFinished();
		return backToTop.isVisible();
	}

	public boolean isBreadcrumbVisible() {
		Logger.info("Verify Breadcrumb is visible");
		return breadcrumb.isVisible();
	}

	public boolean isBylineVisible() {
		Logger.info("Verify byline is visible");
		return byLine.isVisible();
	}

	public boolean isArticleBodyVisible() {
		Logger.info("Check if article body is visible");
		return articleBody.isVisible();
	}

	public String getBodyText() {
		Logger.info("Get body text");
		return articleBody.getText();
	}

	public boolean isLastUpdatedDateVisible() {
		Logger.info("Verify Last Updated Date is visible");
		return lastUpdatedDate.isVisible();
	}

	public boolean isDeckVisible() {
		Logger.info("Verify Deck is visible");
		return deck.isVisible();
	}

	public String getDeckText() {
		Logger.info("Get deck text");
		return deck.getText();
	}

	public boolean isRecommendedForYouSectionVisible() {
		Logger.info("Check if 'Recommended For You' section is visible");
		waitForAjaxRequestToBeFinished();
		return recommendedForYouSection.isVisible();
	}

	public void scrollPageAndWaitForFlyoutVisibility() {
		Logger.info("Scroll page for flyout to appear");
		scrollDownThePage();
		flyout.waitUntilVisible();
	}

	public boolean isFlyoutVisible() {
		Logger.info("Check if 'Read Next' flyout is visible");
		return flyout.isVisible();
	}

	public boolean isFlyoutArrowVisible() {
		Logger.info("Check if flyout arrow is visible");
		return flyoutArrow.isVisible();
	}

	public boolean isFlyoutReadNextVisible() {
		Logger.info("Check if flyout 'Read Next' is visible");
		return flyoutReadNext.isVisible();
	}

	public boolean isFlyoutArticleTitleVisible() {
		Logger.info("Check if flyout article title is visible");
		return flyoutArticleTitle.isVisible();
	}

	public boolean isFlyoutArticleImageVisible() {
		Logger.info("Verify if flyout article image is visible");
		return flyoutArticleImage.isVisible();
	}

	public String getFlyoutLinkHrefAttribute() {
		Logger.info("Get flyout article 'href' attribute value");
		return flyoutLink.getAttribute("href");
	}

	public boolean isDontMissThisSectionVisible() {
		Logger.info("Check if 'Don't miss this' section is visible");
		return dontMissThisSection.isVisible();
	}

	public boolean isTopGreenBorderVisibleAboveDontMissThis() {
		Logger.info("Verify if green line is present above 'Don't miss this' section");
		return Utils.getHexColor(dontMissThisSection.getCssValue("border-top-color")).equals("#96c900");
	}

	public boolean isMoreInSectionVisible() {
		Logger.info("Check if 'More in' section is visible");
		return moreInSection.isVisible();
	}

	public boolean isDontMissThisHeaderVisible() {
		Logger.info("Check if 'Don't miss this' section header is visible");
		return dontMissThisHeader.isVisible();
	}

	public void flyoutMouseHover() {
		Logger.info("Move mouse hover on 'Read Next' flyout");
		flyout.mouseHover();
		waitForAjaxRequestToBeFinished();
	}

	public String getFlyoutReadNextTitle() {
		Logger.info("Get flyout 'Read next' link");
		return flyoutReadNext.getText();
	}

	public ArticleNewTemplatePage clickOnFlyout() {
		Logger.info("Click on 'Read Next' flyout");
		flyout.click();
		return new ArticleNewTemplatePage(basedriver);
	}

	public BasicPageEH clickOnFirstDontMissThisArticle() {
		Logger.info("Click on first 'Don't miss this' article");
		dontMissThisArticleTitles.click();
		return PageFactory.initElements(basedriver, BasicPageEH.class);
	}

	public ArticleNewTemplatePage clickBackToTopButton() {
		Logger.info("Click back to top button");
		backToTop.actionClick();
		waitFor(2000);//need for scroll to top
		return this;
	}

	public int getNumberOfDontMissArticles() {
		Logger.info("Get number of articles in 'Don't miss this' section");
		return dontMissThisArticles.getVisibleElementsCount();
	}

	public int getNumberOfDontMissArticleImages() {
		Logger.info("Get number of article images in 'Don't miss this' section");
		return dontMissThisArticleImages.getVisibleElementsCount();
	}

	public int getNumberOfDontMissArticleTitles() {
		Logger.info("Get number of article titles in 'Don't miss this' section");
		return dontMissThisArticleTitles.getVisibleElementsCount();
	}

	public boolean isCSZoneActive() {
		Logger.info("Verifying if CS zone is active for this page");
		return Utils.isPageSourceContains("data-zone=\"/cs/");
	}

	public boolean isReviewedByVisible() {
		Logger.info("Verifying if reviewed by is visible");
		return reviewedBy.isVisible();
	}

	public String getBreadcrumbHrefAttributeValue(int elementNumber) {
		Logger.info("Get 'href' attribute value for " + elementNumber + "th level of breadcrumb");
		String hrefValue = breadcrumbLink.getAttributeOfElementNumber(elementNumber, "href");
		Logger.info("Breadcrumb URL - " + hrefValue);
		return hrefValue;
	}

	public int getNumberOfBreadcrumbLinks() {
		Logger.info("Get number of breadcrumb links");
		return breadcrumbLink.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfBreadcrumbArrows() {
		Logger.info("Get number of breadcrumb arrows '>'");
		return breadcrumbArrow.getVisibleElementsCount();
	}

	public boolean isMoreInTextVisible() {
		Logger.info("Checking for 'More in' text");
		return moreInHeadline.isVisible();
	}

	public boolean isMoreInCategoryLinkVisible() {
		Logger.info("Verify if 'More in' headline category link is visible");
		return moreInHeadlineCategoryLink.isVisible();
	}

	public boolean isRightRailIframeWidgetVisible() {
		Logger.info("Verifying right rail iframe widget is visible");
		return rightRailIFrameWidget.isVisible();
	}

	public String getRightRailIframeWidgetLocation() {
		Logger.info("Get right rail iframe widget location");
		return rightRailIFrameWidget.getAttribute("data-iframe-location");
	}

	public boolean isBodyIframeWidgetVisible() {
		Logger.info("Verifying body iframe widget is visible");
		return bodyIFrameWidget.isVisible();
	}

	public String getBodyIframeWidgetLocation() {
		Logger.info("Get Body iframe widget location");
		return bodyIFrameWidget.getAttribute("data-iframe-location");
	}

	public int getBodyIframeWidgetHeight() {
		Logger.info("Get Body iframe widget Height");
		return bodyIFrameWidgetFrame.getElementHeight();
	}

	public int getBodyIframeWidgetWidth() {
		Logger.info("Get Body iframe widget Width");
		return bodyIFrameWidgetFrame.getElementWidth();
	}

	public int getRightRailIframeWidgetHeight() {
		Logger.info("Get Right rail iframe widget height");
		rightRailIFrameWidget.scrollToElement();
		return rightRailIFrameWidgetFrame.getElementHeight();
	}

	public int getRightRailIframeWidgetWidth() {
		Logger.info("Get Right rail iframe widget width");
		return rightRailIFrameWidgetFrame.getElementWidth();
	}

	public int getIframeWidgetYCoordinate() {
		Logger.info("Get iframe widget Y-coordinate");
		return rightRailIFrameWidget.getElement().getLocation().y;
	}

	public String getContentCardHrefValue(int contentCardNumber) {
		Logger.info("Get content card #" + contentCardNumber + " 'href' attribute value");
		String hrefValue = contentCard.getHrefOfElementNumber(contentCardNumber);
		Logger.info("Content card #" + contentCardNumber + " url - " + hrefValue);
		return hrefValue;
	}

	public int getNumberOfContentCardWithImage() {
		Logger.info("Get number of content cards with images");
		contentCard.scrollToElement();
		waitForAjaxRequestToBeFinished();
		return contentCardImage.getNumberOfVisibleAndClickableElements();
	}

	public void scrollToContentCard(int contentCardNumber) {
		Logger.info("Scrolling to content card #" + contentCardNumber + " for image to load (lazyness)");
		contentCard.scrollToElementNumber(contentCardNumber);
	}

	public boolean isContentCardImageContainsDataSource(int contentCardNumber) {
		Logger.info("Verifying the content card #" + contentCardNumber + " image source");
		return !contentCardImage.getAttributeOfElementNumber(contentCardNumber, "src").isEmpty();
	}

	public int getContentCardImageWidth(int contentCardNumber) {
		Logger.info("Verifying the image width for content card #" + contentCardNumber);
		return Integer.valueOf(contentCardImage.getAttributeOfElementNumber(contentCardNumber, "width"));
	}

	public boolean isContentCardContainHeader(int contentCardNumber) {
		Logger.info("Verifying content card #" + contentCardNumber + " header info");
		return !contentCardHeader.getTextFromElementNumber(contentCardNumber).isEmpty();
	}

	public int getNumberOfContentCardHeaders() {
		Logger.info("Get number of content card headers");
		return contentCardHeader.getNumberOfVisibleAndClickableElements();
	}

	public boolean isContentCardContainDesc(int contentCardNumber) {
		Logger.info("Verifying Content card Description");
		return !contentCardDesc.getTextFromElementNumber(contentCardNumber).isEmpty();
	}

	public boolean isContentCardTypeIconNumberVisible(int contentCardNumber) {
		Logger.info("Check if content card #" + (contentCardNumber) + " type icon is visible");
		return contentCardIcon.isElementNumberVisible(contentCardNumber);
	}

	public int getNumberOfVisibleContentCardTypeIcons() {
		Logger.info("Get number of visible content card type icons");
		return contentCardIcon.getVisibleElementsCount();
	}

	public int getNumberOfContentCardBylines() {
		Logger.info("Get number of content cards with byline");
		return contentCardByline.getVisibleElementsCount();
	}

	public int getTotalNumberOfContentCards() {
		Logger.info("Get total number of content cards");
		contentCard.scrollToElement();
		return contentCard.getVisibleElementsCount();
	}

	public boolean isSeeMoreButtonVisible() {
		Logger.info("Verifying See More button is visible");
		return seeMoreButton.isVisible();
	}

	public void clickSeeMoreButton() {
		Logger.info("Verifying See More button is visible");
		seeMoreButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isPullQuoteVisible() {
		Logger.info("Verifying pull quote is visible");
		return pullQuote.isVisible();
	}

	public boolean isPullQuoteGreenBorderVisible() {
		Logger.info("Verifying pull quote green border is visible");
		return pullQuote.getCssValue("border-left-color").contains("rgba(150, 201, 0, 1)") && !pullQuote.getCssValue("border-left-style").isEmpty();
	}

	public boolean isPullQuoteTwitterLinkVisible() {
		Logger.info("'Tweet' link should be visible on pullquote");
		return pullQuoteTwitterLink.isVisible();
	}

	public boolean isKeyTakeAwaysVisible() {
		Logger.info("Verifying Key take aways is visible");
		return keyTakeAways.isVisible();
	}

	public int getKeyTakeAwaysNotesCount() {
		Logger.info("Get Key Take Aways notes count");
		return keyTakeAwaysNotes.getNumberOfVisibleAndClickableElements();
	}

	public boolean isKeyTakeAwaysClickable(int elementNumber) {
		Logger.info("Verifying Key take aways note " + elementNumber + " is clickable");
		return !keyTakeAwaysWords.getHrefOfElementNumber(elementNumber).isEmpty();
	}

	public boolean isAmpPageHeaderVisible() {
		Logger.info("Check if AMP page header is visible");
		return ampPageHeader.isVisible();
	}

	public String getPhotoCaptionColor() {
		Logger.info("Get Photo caption color");
		return imageCaption.getCssValue("color");
	}

	public String getPhotoCaptionHrefValue() {
		Logger.info("Get photo caption 'href' attribute value");
		return imageCaption.getAttribute("href");
	}

	public String getPhotoCreditColor() {
		Logger.info("Get Photo credit color");
		return imageCredit.getCssValue("color");
	}

	public String getPhotoCreditHrefValue() {
		Logger.info("Get photo credit 'href' attribute value");
		return imageCredit.getAttribute("href");
	}

	public boolean isSmartNewsletterModuleVisible() {
		Logger.info("Verify if smart newsletter module is visible");
		return smartNewsletterModule.isVisible();
	}

	public boolean isSmartNewsletterSignUpButtonVisible() {
		Logger.info("Verify if 'Sign up' button is visible in smart newsletter module");
		return smartNewsletterSubmitButton.isVisible();
	}

	public void clickSmartNewsletterSignUpButton() {
		Logger.info("Click 'Sign up' button in smart newsletter module");
		smartNewsletterSubmitButton.scrollIntoView();
		smartNewsletterSubmitButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isSmartNewsletterEmailInputVisible() {
		Logger.info("Verify if 'Email' input is present in smart newsletter module");
		return smartNewsletterEmailBox.isVisible();
	}

	public void typeSmartNewsletterEmailAddress(String email) {
		Logger.info("Type email address - " + email);
		smartNewsletterSubmitButton.scrollIntoView();
		waitForAjaxRequestToBeFinished();
		smartNewsletterEmailBox.type(email);
	}

	public boolean isSmartNewsletterWarningMessageVisible() {
		Logger.info("Verify if warning message is visible in smart newsletter module");
		waitForAjaxRequestToBeFinished();
		return smartNewsletterWarningMessage.isVisible();
	}

	public void waitUntilSmartNLWarningMessageDisappears() {
		Logger.info("Wait until warning message disappears in smart newsletter module");
		smartNewsletterWarningMessage.waitUntilInvisible();
	}

	public boolean isSmartNewsletterSuccessMessageVisible() {
		Logger.info("Verify if success message is visible in smart newsletter module");
		smartNewsletterSuccessMessage.waitUntilVisible();
		return smartNewsletterSuccessMessage.isVisible();
	}

	public boolean isSmartNewsletterExtraSectionVisible() {
		Logger.info("Verify if smart newsletter extra section is visible");
		return smartNewsletterExtra.isVisible();
	}

	public int getNumberOfExtraNewsletters() {
		Logger.info("Get number of suggested newsletters");
		return smartNewsletterExtraOptions.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfTopicTags() {
		Logger.info("Get number of topic tags");
		return topicTag.getNumberOfVisibleAndClickableElements();
	}

	public boolean isNativeAdVisible() {
		Logger.info("Verify if native ad is visible");
		dontMissThisNativeAd.scrollIntoView();
		dontMissThisNativeAd.waitUntilVisible();
		return dontMissThisNativeAd.isVisible();
	}

	public boolean isProgrammedNativeAd() {
		Logger.info("Verify if programmed native ad is visible on this page");
		if (dontMissThisNativeAdDirectSold.isVisible()) {
			dontMissThisNativeAdDirectSold.scrollIntoView();
			return false;
		}
		if (dontMissThisNativeAdProgrammed.isVisible()) {
			dontMissThisNativeAdProgrammed.scrollIntoView();
			return true;
		}
		Logger.info("None of native ads is visible");
		return false;
	}

	public void switchToNativeAdIFrame() {
		Logger.info("Switch to native ad (direct sold) iframe");
		dontMissThisNativeAdDirectSold.switchToFrame();
	}

	public boolean isProgrammedNativeAdImageVisible() {
		Logger.info("Verify if native (programmed) ad image is visible");
		return dontMissThisNativeAdProgrammedThumbnailImage.isVisible();
	}

	public boolean isNativeAdImageVisible() {
		Logger.info("Verify if native ad image is visible");

		return dontMissThisNativeAdDirectSoldThumbnailImage.isVisible();
	}

	public boolean isNativeAdAdchoiceIconVisible() {
		Logger.info("Verify if native ad (direct sold) AdChoice icon is visible");
		return dontMissThisNativeAdDirectSoldAdchoiceIcon.isVisible();
	}

	public boolean isProgrammedNativeAdTitleVisible() {
		Logger.info("Verify if native ad (programmed) title is visible");
		return dontMissThisNativeAdProgrammedTitle.isVisible();
	}

	public boolean isNativeAdTitleVisible() {
		Logger.info("Verify if native ad title is visible");
		return dontMissThisNativeAdDirectSoldTitle.isVisible();
	}

	public boolean isProgrammedNativeAdLabelVisible() {
		Logger.info("Verify if native ad (programmed) 'Sponsored by' label is visible");
		return dontMissThisNativeAdProgrammedSponsor.isVisible();
	}

	public boolean isNativeAdLabelVisible() {
		Logger.info("Verify if native ad 'Ad' label is visible");
		return dontMissThisNativeAdDirectSoldSponsor.isVisible();
	}

	public int getNativeAdWidth() {
		Logger.info("Get native ad width value");
		return dontMissThisNativeAd.getElementWidth();
	}

	public int getNativeAdHeight() {
		Logger.info("Get native ad height value");
		return dontMissThisNativeAd.getElementHeight();
	}

	public int getNumberOfECommerceWidgets() {
		Logger.info("Get number of E-Commerce widgets");
		return eCommerceWidget.getElementsCount();
	}

	public boolean isECommerceModuleTitleVisible(int widgetNumer) {
		Logger.info("Verify if E-Commerce module title #" + widgetNumer + " is visible");
		return eCommerceTitle.isElementNumberVisible(widgetNumer);
	}

	public boolean isECommerceProductImageVisible(int widgetNumer) {
		Logger.info("Verify if E-Commerce module product image #" + widgetNumer + " is visible");
		return eCommerceProductImg.isElementNumberVisible(widgetNumer);
	}

	public boolean isECommerceProdcutDescriptionVisible(int widgetNumer) {
		Logger.info("Verify if E-Commerce module description #" + widgetNumer + " is visible");
		return eCommerceProductDescription.isElementNumberVisible(widgetNumer);
	}

	public String getECommerceProductTitle(int widgetNumber) {
		Logger.info("Get text from E-Commerce module title card #" + widgetNumber);
		return eCommerceProductTitle.getTextFromElementNumber(widgetNumber);
	}

	public String getECommerceProductPrice(int widgetNumber) {
		Logger.info("Get price from E-Commerce module #" + widgetNumber);
		return eCommerceProductPrice.getTextFromElementNumber(widgetNumber);
	}

	public String getECommerceProductVendorName(int widgetNumber) {
		Logger.info("Get vendor name from E-Commerce module #" + widgetNumber);
		return eCommerceVendorName.getTextFromElementNumber(widgetNumber);
	}

	public String getECommerceProductTitleText(int widgetNumer) {
		Logger.info("Get text from E-Commerce module title #" + widgetNumer);
		return eCommerceProductSectionTitle.getTextFromElementNumber(widgetNumer);
	}

	public boolean isECommerceProductAffliateTextVisible(int widgetNumer) {
		Logger.info("Verify if E-Commerce module #" + widgetNumer + " affiliate text is visible");
		return eCommerceAffiliateText.isElementNumberVisible(widgetNumer);
	}


	public boolean isECommerceImageCaptionVisible(int widgetNumber) {
		Logger.info("Verify if E-Commerce module #" + widgetNumber + " image caption is visible");
		return eCommerceProductImgCaption.isElementNumberVisible(widgetNumber);
	}

	public boolean isECommerceModuleVisible(int widgetNumber) {
		Logger.info("Check if E-Commerce module is visible");
		return eCommerceWidget.isElementNumberVisible(widgetNumber);
	}

	public void scrollToECommerceWidget() {
		Logger.info("Scroll to E-Commerce module");
		eCommerceWidget.scrollToElement();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isRelatedContentWidgetVisible() {
		Logger.info("Verify if Related Content Widget is visible");
		relatedContentWidget.scrollToElement();
		return relatedContentWidget.isVisible();
	}

	public String getWidgetBackgroundColor() {
		Logger.info("Get Related Content Widget background color");
		return Utils.getHexColor(relatedContentWidget.getCssValue("background-color"));
	}

	public String getRelatedContentWidgetHref() {
		Logger.info("Get Related Content Widget 'href' attribute value");
		return relatedContentWidgetLink.getAttribute("href");
	}

	public void clickRelatedWidgetArticleLink() {
		Logger.info("Click Related Widget article link");
		relatedContentWidgetLink.click();
		waitForAjaxRequestToBeFinished(2000);
	}

	public boolean isRelatedContentWidgetEyebrowVisible() {
		Logger.info("Verify if eyebrow is visible on Related Content Widget");
		return relatedContentWidgetEyebrow.isVisible();
	}

	public boolean isRelatedContentWidgetImageVisible() {
		Logger.info("Verify if image on Related Content Widget is visible");
		return relatedContentWidgetImage.isVisible();
	}

	public boolean isRelatedContentWidgetTitleVisible() {
		Logger.info("Verify if title on Related Content Widget is visible");
		return relatedContentWidgetTitle.isVisible();
	}

	public boolean isRelatedContentWidgetDescriptionVisible() {
		Logger.info("Verify if description on Related Content Widget is visible");
		return relatedContentWidgetDescription.isVisible();
	}
}