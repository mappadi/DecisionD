package everydayhealth.pages;

import everydayhealth.pages.share.PGSocialBar;
import everydayhealth.pages.share.SocialBarEH;
import framework.Logger;
import framework.Settings;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

public class BasicPageEH extends BasicPage {

	public BasicPageEH(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "";
		String CLASS_NAME = "BasicPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject body;
	protected WebObject legalText;
	protected WebObject legalTextMessage;
	protected WebObject legalTextMessageLinks;
	protected WebObject legalTextClose;
	protected WebObject adChoice;
	protected WebObject adChoiceLogo;
	protected WebObject aolPlayer;
	protected WebObject aolPlayerIFrame;
	protected WebObject aolPlayerVideoModule;
	protected WebObject aolPlayerSpinner;
	protected WebObject aolPlayerUnMuteIcon;
	protected WebObject aolPlayerControlBar;
	protected WebObject aolPlayerPlayButton;
	protected WebObject aolPlayerProgressBar;
	protected WebObject aolPlayerMuteButton;
	protected WebObject aolPlayerFullScreenButton;
	protected WebObject promoBannerContainer;
	protected WebObject promoBannerText;
	protected WebObject promoBannerLink;
	protected WebObject tile3Ad;
	protected WebObject form;
	protected WebObject formIcon;
	protected WebObject formDeck;
	protected WebObject formShareLink;
	protected WebObject formPopUpWindow;
	protected WebObject formPopUpWindowCloseIcon;
	protected WebObject formPopUpWindowHeadline;
	protected WebObject formPopUpWindowHeadlineThankYouMessage;
	protected WebObject formFNameInput;
	protected WebObject formLNameInput;
	protected WebObject formEmailInput;
	protected WebObject formStoryTextarea;
	protected WebObject formStoryTextareaCharCounter;
	protected WebObject formTOSCheckbox;
	protected WebObject formTOSLabel;
	protected WebObject formTOSLink;
	protected WebObject formTOSPrivacyLink;
	protected WebObject formSubmitButton;
	protected WebObject formValidationError;
	protected WebObject atcWidget;
	protected WebObject atcWidgetLabel;
	protected WebObject atcWidgetAdditionalInfoLink;
	protected WebObject atcWidgetPopoverContent;
	protected WebObject atcWidgetPopoverCloseIcon;
	protected WebObject atcWidgetPopoverContentNew;
	protected WebObject atcWidgetPopoverCloseLink;
	protected WebObject atcWidgetMoreInfoText;
	protected WebObject rightRailISIWidget;
	protected WebObject rightRailISIWidgetBody;
	protected WebObject bottomISIWidget;
	protected WebObject bottomISIWidgetBody;
	protected WebObject newsletterWidget;
	protected WebObject newsletterModule;
	protected WebObject newsletterEmailBox;
	protected WebObject newsletterSubmitButton;
	protected WebObject newsletterWarningMessage;
	protected WebObject newsletterModuleSuccessMessage;
	protected WebObject newsletterWidgetSuccessMessage;
	protected WebObject newsletterModulePrivacyLink;
	protected WebObject newsletterWidgetPrivacyLink;
	protected WebObject googleMatchedContentTitle;
	protected WebObject googleMatchedContentCardsImages;
	protected WebObject googleMatchedParentIFrame;
	protected WebObject googleMatchedChildIFrame;
	protected WebObject googleMatchedContentCards;
	protected WebObject googleMatchedContentCardAdTitle;
	protected WebObject googleMatchedAdSponsorText;
	protected WebObject googleMatchedAdIcon;
	protected WebObject googleMatchedContentLink;
	protected WebObject googleMatchedAdSlot;
	protected WebObject latestArticlesModule;
	protected WebObject latestArticlesModuleTitle;
	protected WebObject latestArticlesModuleCard;
	protected WebObject latestArticlesModuleCardSubcat;
	protected WebObject latestArticlesModuleCardLink;
	protected WebObject latestArticlesModuleCardImage;
	protected WebObject latestArticlesModuleCardTitle;
	protected WebObject latestArticlesModuleCardDeck;
	protected WebObject leader1Ad;
	protected WebObject adDiv5;
	protected WebObject adDiv7;
	protected WebObject adDiv8;
	protected WebObject adDiv9;
	protected WebObject leaderExtraAd;
	protected WebObject horizontalPromoSection;
	protected WebObject horizontalPromoSectionTitle;
	protected WebObject horizontalPromoSectionViewAllLink;
	protected WebObject horizontalPromoSectionCard;
	protected WebObject horizontalPromoSectionCardTitle;
	protected WebObject horizontalPromoSectionCardImage;
	protected WebObject horizontalPromoSectionCardLink;
	protected WebObject evidon;
	protected WebObject evidonAccept;

	@Override
	public void waitForPageToLoad() {
		waitForAjaxRequestToBeFinished();
	}

	public SocialBarEH onSocialBar() {
		return new SocialBarEH(basedriver);
	}

	public PublicHeaderEH onHeader() {
		return new PublicHeaderEH(basedriver, "PublicHeader");
	}

	public PublicHeaderCCR onHeaderCCR() {
		return new PublicHeaderCCR(basedriver);
	}

	public GlobalNavHeader onGlobalNavHeader() {
		return new GlobalNavHeader(basedriver);
	}

	public PublicFooterZD onZDFooter() {
		return new PublicFooterZD(basedriver);
	}

	public PGSocialBar onPGSocialBar() {
		return new PGSocialBar(basedriver);
	}

	public String getSubCategoryForPage() {
		Logger.info("Get page sub-category value");
		String subCategory = body.getAttribute("data-condition-name");
		Logger.info("Subcategory - " + subCategory);
		return subCategory;
	}

	public String getCategoryForPage() {
		Logger.info("Get page category value");
		String category = body.getAttribute("data-category-name");
		Logger.info("Category - " + category);
		return category;
	}

	public String getAdZoneForPage() {
		Logger.info("Get page ad zone value");
		String adZone = body.getAttribute("data-zone");
		Logger.info("Ad zone - " + adZone);
		return adZone;
	}

	public String getPageId() {
		Logger.info("Get page id value");
		String pageId = body.getAttribute("data-page-id");
		Logger.info("Page id - " + pageId);
		return pageId;
	}

	public boolean isLegalTextMessageVisible() {
		Logger.info("Verify if legal text message is visible");
		waitForAjaxRequestToBeFinished();
		return legalText.isVisible();
	}

	public String getLegalTextMessage() {
		Logger.info("Get legal text message");
		return legalTextMessage.getText();
	}

	public String getLegalTextLinkHrefValue(int linkNumber) {
		Logger.info("Get 'href' attribute for legal text link #" + linkNumber);
		return legalTextMessageLinks.getHrefOfElementNumber(linkNumber);
	}

	public void clickCloseIconOnLegalTextMessage() {
		Logger.info("Click 'Close' icon on legal text message");
		legalTextClose.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isAOLPLayerVisible() {
		Logger.info("Verify if AOL player is visible");
		aolPlayerIFrame.waitUntilVisible();
		aolPlayerIFrame.scrollIntoView();
		Utils.scrollPage(aolPlayerIFrame.getYCoordinate() - 100);
		return aolPlayerIFrame.isVisible();
	}

	public String getAOLPlayerVideoID() {
		Logger.info("Get AOL Player video ID");
		return aolPlayer.getAttribute("id").trim();
	}

	public void switchToAOLPlayerIFrame() {
		Logger.info("Switch to AOL player iFrame");
		aolPlayerIFrame.switchToFrame();
		Utils.waitFor(750);
	}

	public void aolPlayerMouseHover() {
		Logger.info("Mouse hover over AOL player");
		aolPlayerVideoModule.mouseHover();
		Utils.waitFor(750);
	}

	public boolean isAOLPlayerUnMuteIconVisible() {
		Logger.info("Verify if 'Mute' icon is visible on AOL Player");
		return aolPlayerUnMuteIcon.isVisible();
	}

	public void clickAOLPlayerUnMuteIcon() {
		Logger.info("Click 'Unmute' icon on AOL Player");
		aolPlayerUnMuteIcon.actionClick();
	}

	public boolean isAOLPlayerControlBarVisible() {
		Logger.info("Verify if control bar is visible on AOL Player");
		return aolPlayerControlBar.isVisible();
	}

	public boolean isAOLPlayerSpinnerVisible() {
		Logger.info("Verify if spinner is visible in AOL player");
		return aolPlayerSpinner.isVisible();
	}

	public void waitUntilSpinnerDisappears() {
		aolPlayerSpinner.waitUntilInvisible();
	}

	public boolean isAOLPlayerPlayButtonVisible() {
		Logger.info("Verify if AOL Player 'Play' button is visible");
		return aolPlayerPlayButton.isVisible();
	}

	public void clickAOLPlayerPlayButton() {
		Logger.info("Click 'Play' button on AOL player");
		aolPlayerPlayButton.actionClick();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isAOLPlayerProgressBarVisible() {
		Logger.info("Verify if AOL Player progress bar is visible");
		return aolPlayerProgressBar.isVisible();
	}

	public boolean isAOLPlayerMuteButtonVisible() {
		Logger.info("Verify if 'Mute' button is visible on AOL Player");
		return aolPlayerMuteButton.isVisible();
	}

	public void clickAOLPlayerMuteButton() {
		Logger.info("Click 'Mute' button on AOL Player");
		aolPlayerMuteButton.actionClick();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isAOLPlayerFullScreenButtonVisible() {
		Logger.info("Verify if 'Fullscreen' button is visible on AOL Player");
		return aolPlayerFullScreenButton.isVisible();
	}

	public String getAOLPlayerStatus(String videoID) {
		Logger.info("Get AOL Player status");
		switchToDefaultContent();
		return Utils.getJSResult("return document.getElementById(\"" + videoID + "\").vdb_Player.getPlayerStatus()");
	}

	public String getAOLPlayerVolumeValue(String videoID) {
		Logger.info("Get AOL Player volume value");
		switchToDefaultContent();
		return Utils.getJSResult("return document.getElementById(\"" + videoID + "\").vdb_Player.getPlayerInfo().volume");
	}

	public boolean isAdChoiceElementVisible() {
		Logger.info("Verify if AdChoice element is visible");
		waitForAjaxRequestToBeFinished();
		return adChoice.isVisible();
	}

	public boolean isAdChoiceLogoVisible() {
		Logger.info("Verify if AdChoice logo image is visible");
		return adChoiceLogo.isVisible();
	}

	public boolean isPromoBannerVisible() {
		Logger.info("Verify if promo banner section/container is visible");
		return promoBannerContainer.isVisible();
	}

	public boolean isPromoBannerTextVisible() {
		Logger.info("Verify if promo banner text is visible");
		return promoBannerText.isVisible();
	}

	public String getPromoBannerLinkHrefValue() {
		Logger.info("Verify if promo banner link is valid");
		String hrefValue = promoBannerLink.getAttribute("href");
		Logger.info("Promo banner link - " + hrefValue);
		return hrefValue;
	}

	public void clickPromoBannerLink() {
		Logger.info("Click Promo banner link");
		promoBannerLink.click();
	}

	public boolean isLogoAdBlockVisible() {
		Logger.info("Verify if logo ad block (adDiv3) is visible");
		return tile3Ad.isVisible();
	}

	public boolean isFormVisible() {
		Logger.info("Verify if Form is visible");
		return form.isVisible();
	}

	public boolean isFormIconVisible() {
		Logger.info("Verify if Form icon is visilbe");
		return formIcon.isVisible();
	}

	public boolean isFormDeckVisible() {
		Logger.info("Verify if Form deck is visible");
		return formDeck.isVisible();
	}

	public boolean isFormShareLinkVisible() {
		Logger.info("Verify if Form 'Share here' link is visible");
		return formShareLink.isVisible();
	}

	public void clickFormShareLink() {
		Logger.info("Click 'Share here' link");
		formShareLink.click();
		formPopUpWindow.waitUntilVisible();
	}

	public boolean isFormPopUpWindowVisible() {
		Logger.info("Verify if Form pop up window is visible");
		return formPopUpWindow.isVisible();
	}

	public boolean isFormPopUpHeadlineVisible() {
		Logger.info("Verify if Form headline is visible");
		return formPopUpWindowHeadline.isVisible();
	}

	public boolean isFormPopUpCloseIconVisible() {
		Logger.info("Verify if Form [x] icon is visible");
		return formPopUpWindowCloseIcon.isVisible();
	}

	public void clickFormPopUpCloseIcon() {
		Logger.info("Click [x] icon on Form pop up");
		formPopUpWindowCloseIcon.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isFormPopUpFirstNameInputVisible() {
		Logger.info("Verify if 'First Name' input is visible");
		return formFNameInput.isVisible();
	}

	public BasicPageEH typeFormFirstName(String fname) {
		Logger.info("Type first name");
		formFNameInput.type(fname);
		return this;
	}

	public boolean isFormPopUpLastNameInputVisible() {
		Logger.info("Verify if 'Last Name' input is visible");
		return formLNameInput.isVisible();
	}

	public BasicPageEH typeFormLastName(String lname) {
		Logger.info("Type last name");
		formLNameInput.type(lname);
		return this;
	}

	public boolean isFormPopUpEmailInputVisible() {
		Logger.info("Verify if 'Email' input is visible");
		return formEmailInput.isVisible();
	}

	public BasicPageEH typeFormEmailAddress(String email) {
		Logger.info("Type email");
		formEmailInput.type(email);
		return this;
	}

	public boolean isFormPopUpStoryTextareaVisible() {
		Logger.info("Verify if 'Share your story' textarea is visible");
		return formStoryTextarea.isVisible();
	}

	public BasicPageEH typeFormStory(String story) {
		Logger.info("Type story");
		formStoryTextarea.type(story);
		return this;
	}

	public boolean isFormPopUpCharCounterVisible() {
		Logger.info("Verify if char counter is visible on Form");
		return formStoryTextareaCharCounter.isVisible();
	}

	public String getFormPopUpCharCounterValue() {
		Logger.info("Get char counter value");
		return formStoryTextareaCharCounter.getText().split("/")[0].trim();
	}

	public boolean isFormPopUpTosCheckboxVisible() {
		Logger.info("Verify if 'Terms of Service' checkbox is visible");
		return formTOSCheckbox.isVisible();
	}

	public BasicPageEH clickFormPopUpTosCheckbox() {
		Logger.info("Click 'Terms of service' checkbox");
		formTOSCheckbox.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isFormPopUpTosLabelVisible() {
		Logger.info("Verify if 'Terms of service' label is visible");
		return formTOSLabel.isVisible();
	}

	public String getFormPopUpTosLinkHrefValue() {
		Logger.info("Get 'Terms of service' link 'href' attribute value");
		return formTOSLink.getAttribute("href");
	}

	public String getFormPopUpPrivacyLinkHrefValue() {
		Logger.info("Get 'Privacy Policy' link 'href' attribute value");
		return formTOSPrivacyLink.getAttribute("href");
	}

	public boolean isFormPopUpFormSubmitButtonVisible() {
		Logger.info("Verify if 'Submit' button is visible");
		return formSubmitButton.isVisible();
	}

	public BasicPageEH clickFormPopUpSubmitButton() {
		Logger.info("Click 'Submit' button on Form pop up window");
		formSubmitButton.scrollIntoView();
		formSubmitButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isFormPopUpErrorMessageVisible(String errMessage) {
		Logger.info("Verify if error message - '" + errMessage + "' is visible");
		return formValidationError.isElementWithTextVisible(errMessage);
	}

	public boolean isFormPopUpThankYouMessageVisible() {
		Logger.info("Verify if 'Thank you' message is visible on Form pop up");
		return formPopUpWindowHeadlineThankYouMessage.isVisible();
	}

	public boolean isATCWidgetVisible() {
		Logger.info("Verify if ATC widget is visible");
		return atcWidget.isVisible();
	}

	public int getATCWidgetYCoordinateValue() {
		Logger.info("Get ATC widget Y coordinate value");
		return atcWidget.getYCoordinate();
	}

	public boolean isATCWidgetLabelVisible() {
		Logger.info("Verify if label is visible on ATC Widget (new)");
		return atcWidgetLabel.isVisible();
	}

	public String getATCWidgetLabelText() {
		Logger.info("Get text from label on ATC widget (new)");
		return atcWidgetLabel.getText();
	}

	public String getATCSectionBackgroundColor() {
		Logger.info("Get ATC section background color");
		return Utils.getHexColor(atcWidget.getCssValue("background-color"));
	}

	public BasicPageEH clickATCAdditionalInfoLink() {
		Logger.info("Click on Atc('More Information' link) popover");
		atcWidgetAdditionalInfoLink.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isATCAdditionalInfoLinkVisible() {
		Logger.info("Check if additional information link is visible on ATC widget");
		return atcWidgetAdditionalInfoLink.isVisible();
	}

	public boolean isATCNewPopoverVisible() {
		Logger.info("Check if ATC popover content is visible");
		return atcWidgetPopoverContentNew.isVisible();
	}

	public void clickATCClosePopoverLink() {
		Logger.info("Click 'Close' link on ATC popover");
		atcWidgetPopoverCloseLink.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isATCClosePopoverLinkVisible() {
		Logger.info("Verify if 'Close' link is visible on ATC popover");
		return atcWidgetPopoverCloseLink.isVisible();
	}

	public String getATCWidgetMoreInfoText() {
		Logger.info("Get text from ATC widget popover");
		return atcWidgetMoreInfoText.getText();
	}

	public boolean isATCPopoverVisible() {
		Logger.info("Verify Atc('More Information' link) popover content is visible");
		return atcWidgetPopoverContent.isVisible();
	}

	public BasicPageEH clickAtcPopoverCloseIcon() {
		Logger.info("Click on ATC popover 'Close' icon");
		atcWidgetPopoverCloseIcon.click();
		atcWidgetPopoverContent.waitUntilInvisible();
		return this;
	}

	public boolean isATCPopoverCloseIconVisible() {
		Logger.info("Verify if Close icon [x] is visible on ATC widget popover");
		return atcWidgetPopoverCloseIcon.isVisible();
	}

	public boolean isRightRailISIWidgetVisible() {
		Logger.info("Verifying ISI widget is visible");
		return rightRailISIWidget.isVisible();
	}

	public int getISIWidgetYCoordinate() {
		Logger.info("Get ISI widget Y-coordinate");
		return rightRailISIWidget.getElement().getLocation().y;
	}

	public String getRightRailISIWidgetLocation() {
		Logger.info("Get right rail ISI widget location");
		return rightRailISIWidget.getAttribute("data-location");
	}

	public int getRightRailISIWidgetHeight() {
		Logger.info("Get Right rail ISI widget height");
		return rightRailISIWidgetBody.getElementHeight();
	}

	public String getRightRailISIHeaderName() {
		Logger.info("Get ISI header name");
		return rightRailISIWidget.getAttribute("data-header");
	}

	public String getRightRailISIFooterName() {
		Logger.info("Get ISI footer text");
		return rightRailISIWidget.getAttribute("data-footer");
	}

	public boolean isBodyISIWidgetVisible() {
		Logger.info("Verifying body ISI widget is visible");
		return bottomISIWidget.isVisible();
	}

	public String getBodyISIWidgetLocation() {
		Logger.info("Get Body ISI widget location");
		return bottomISIWidget.getAttribute("data-location");
	}

	public int getBodyISIWidgetHeight() {
		Logger.info("Get Body ISI widget height");
		return bottomISIWidgetBody.getElementHeight();
	}

	public String getBodyISIHeaderName() {
		Logger.info("Get ISI header name");
		return bottomISIWidget.getAttribute("data-header");
	}

	public String getBodyISIFooterName() {
		Logger.info("Get ISI footer text");
		return bottomISIWidget.getAttribute("data-footer");
	}

	public void enterEmailAndSubmit(String email) {
		Logger.info("Entering Email and Clicking Submit");
		enterEmail(email);
		clickNewsletterSubmitButton();
	}

	public boolean isNewsletterWidgetVisible() {
		Logger.info("Verify if Newsletter widget is visible");
		return newsletterWidget.isVisible();
	}

	public boolean isNewsletterModuleVisible() {
		Logger.info("Verify if Newsletter module is visible");
		return newsletterModule.isVisible();
	}

	public boolean isNewsLetterEmailBoxVisible() {
		Logger.info("Verifying Newsletter Email edit box is visible");
		newsletterEmailBox.scrollToElement();
		return newsletterEmailBox.isVisible();
	}

	public void enterEmail(String email) {
		Logger.info("Entering the email id as '" + email + "'");
		if (!Settings.isDesktop()) {
			newsletterEmailBox.scrollToElement();
		}
		newsletterEmailBox.type(email);
	}

	public boolean verifyNewsletterModuleSuccessMessage() {
		Logger.info("Verify Newsletter module confirmation message");
		if (!Settings.isDesktop()) {
			newsletterModuleSuccessMessage.scrollToElement();
		}
		newsletterModuleSuccessMessage.waitUntilVisible();
		return newsletterModuleSuccessMessage.getText().equalsIgnoreCase("Thanks for signing up!");
	}

	public boolean isNewsletterModuleSuccessMessageVisible() {
		Logger.info("Check if Newsletter module success message is visible");
		newsletterModuleSuccessMessage.waitUntilVisible();
		return newsletterModuleSuccessMessage.isVisible();
	}

	public boolean isNewsletterWidgetSuccessMessageVisible() {
		Logger.info("Verify if Newsletter widget success message is visible");
		newsletterWidgetSuccessMessage.waitUntilVisible();
		return newsletterWidgetSuccessMessage.isVisible();
	}

	public boolean verifyNewsletterWarningMessageText() {
		Logger.info("Verifying the Newsletter warning message");
		if (Settings.isMobile()) {
			newsletterWarningMessage.scrollToElement();
		}
		newsletterWarningMessage.waitUntilVisible();
		return newsletterWarningMessage.getText().contains("Oops! Please enter a valid email address");
	}

	public void waitUntilWarningMessageDisappear() {
		newsletterWarningMessage.waitUntilInvisible();
	}

	public boolean isNewsletterWarningMessageVisible() {
		Logger.info("Verify if Newsletter warning message is visible");
		return newsletterWarningMessage.isVisible();
	}

	public boolean isNewsLetterSubmitButtonVisible() {
		Logger.info("Verifying Newsletter 'Submit' button is visible");
		return newsletterSubmitButton.isVisible();
	}

	public boolean isNewsletterModulePrivacyLinkVisible() {
		Logger.info("Verifying Newsletter module Privacy link is visible");
		return newsletterModulePrivacyLink.isVisible();
	}

	public boolean isNewsletterWidgetPrivacyLinkVisible() {
		Logger.info("Verifying Newsletter widget Privacy link is visible");
		return newsletterWidgetPrivacyLink.isVisible();
	}

	public boolean isNewsLetterModulePrivacyLinkValid() {
		Logger.info("Verify if Newsletter module Privacy link is valid");
		String hrefValue = newsletterModulePrivacyLink.getAttribute("href");
		Logger.info("Privacy link - " + hrefValue);
		return hrefValue.startsWith("https://");
	}

	public boolean isNewsLetterWidgetPrivacyLinkValid() {
		Logger.info("Verify if Newsletter widget Privacy link is valid");
		String hrefValue = newsletterWidgetPrivacyLink.getAttribute("href");
		Logger.info("Privacy link - " + hrefValue);
		return hrefValue.startsWith("https://");
	}

	public void clickNewsletterSubmitButton() {
		Logger.info("Clicking Newsletter Submit button");
		newsletterSubmitButton.scrollToElement();
		newsletterSubmitButton.waitUntilClickable();
		waitForAjaxRequestToBeFinished();
		newsletterSubmitButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isGoogleMatchedSectionVisible() {
		Logger.info("Verify if Google Matched is visible");
		googleMatchedParentIFrame.scrollIntoView();
		return googleMatchedParentIFrame.isVisible();
	}

	public String getGMCCardSectionTitle() {
		Logger.info("Get GMC card section title");
		return googleMatchedContentTitle.getText();
	}

	public String getGMCCardHrefAttributeValue(int cardNumber) {
		Logger.info("Get 'href' attribute value for card #" + cardNumber + " in GMC/recommended for you section");
		return googleMatchedContentLink.getHrefOfElementNumber(cardNumber);
	}

	public boolean isGMCCardHeadlineVisible(int cardNumber) {
		Logger.info("Verify if GMC card headline #" + cardNumber + " is visible");
		return googleMatchedContentCardAdTitle.isElementNumberVisible(cardNumber);
	}

	public boolean isGMCCardImageVisible(int cardNumber) {
		Logger.info("Verify if GMC card image #" + cardNumber + " is visible");
		return googleMatchedContentCardsImages.isElementNumberVisible(cardNumber);
	}

	public boolean isGMCAdSponsorTextVisisble() {
		Logger.info("Verify if GMC contents ad sponsor name is visible");
		return googleMatchedAdSponsorText.isVisible();
	}

	public boolean isGMCAdIconVisible() {
		Logger.info("Verify if GMC contents ad sponsor icon is visible");
		return googleMatchedAdIcon.isVisible();
	}

	public int getNumberOfGMCCards() {
		Logger.info("Get number of google matched contents count");
		return googleMatchedContentCards.getNumberOfVisibleAndClickableElements();
	}

	public void switchToGMIFrame() {
		Logger.info("To switch parent IFrame to child IFrame");
		switchToDefaultContent();
		switchToFrame(googleMatchedParentIFrame);
		switchToFrame(googleMatchedChildIFrame);
	}

	public String getGMcontentCardAdSlot() {
		Logger.info("Get google match content section slot value");
		return googleMatchedAdSlot.getAttribute("data-ad-slot");
	}

	public void scrollToLatestArticlesModule() {
		Logger.info("Scroll to Latest articles module");
		latestArticlesModule.scrollIntoView();
	}

	public boolean isLatestArticlesModuleVisible() {
		Logger.info("Verify 'Latest articles' module is visible");
		return latestArticlesModule.isVisible();
	}

	public boolean isLatestArticlesTitleVisible() {
		Logger.info("Verify 'Latest articles' module has visible title");
		return latestArticlesModuleTitle.isVisible();
	}

	public String getLatestArticlesModuleTitleText() {
		Logger.info("Get text from 'Latest articles' title");
		return latestArticlesModuleTitle.getText();
	}

	public int getNumberOfVisibleTitles() {
		Logger.info("Get number of visible card titles");
		return latestArticlesModuleCardTitle.getVisibleElementsCount();
	}

	public int getNumberOfCardsInLatestArticlesModule() {
		Logger.info("Get number of cards in 'Latest articles' module");
		return latestArticlesModuleCard.getElementsCount();
	}

	public void clickLatestArticlesModuleCard(int cardNumber) {
		Logger.info("Click on 'Latest articles' module card #" + cardNumber);
		latestArticlesModuleCard.clickOnElementNumber(cardNumber);
	}

	public boolean isLatestArticlesModuleCardSubcategoryLinkVisible(int cardNumber) {
		Logger.info("Verify if card #" + cardNumber + " in 'Latest Articles' module has visible subcat link");
		return latestArticlesModuleCardSubcat.isElementNumberVisible(cardNumber);
	}

	public void clickLatestArticlesModuleCardSubcategory(int cardNumber) {
		Logger.info("Click on 'Latest articles' module card #" + cardNumber + " subcategory value");
		latestArticlesModuleCardSubcat.clickOnElementNumber(cardNumber);
	}

	public String getLatestArticlesModuleCardSubcategoryText(int cardNumber) {
		Logger.info("Get subcategory link text for card #" + cardNumber);
		return latestArticlesModuleCardSubcat.getTextFromElementNumber(cardNumber);
	}

	public int getNumberOfVisibleSubcategoryLinks() {
		Logger.info("Get number of subcategory links");
		return latestArticlesModuleCardSubcat.getVisibleElementsCount();
	}

	public void scrollToCard(int cardNumber) {
		Logger.info("Scroll to card #" + cardNumber + " in 'Latest articles' module (lazy load)");
		latestArticlesModuleCard.scrollIntoView(cardNumber);
	}

	public boolean isLatestArticlesModuleCardTitleVisible(int cardNumber) {
		Logger.info("Verify if card #" + cardNumber + " in 'Latest Articles' module has visible title");
		return latestArticlesModuleCardTitle.isElementNumberVisible(cardNumber);
	}

	public boolean isLatestArticlesModuleCardImageVisible(int cardNumber) {
		Logger.info("Verify if card #" + cardNumber + " in 'Latest Articles' module has visible image");
		return latestArticlesModuleCardImage.isElementNumberVisible(cardNumber);
	}

	public boolean isLatestArticlesModuleCardDeckVisible(int cardNumber) {
		Logger.info("Verify if card #" + cardNumber + " in 'Latest Articles' module has visible deck");
		return latestArticlesModuleCardDeck.isElementNumberVisible(cardNumber);
	}

	public String getLatestArticlesModuleCardHrefValue(int cardNumber) {
		Logger.info("Get 'href' attribute value for card #" + cardNumber + " in 'Latest Articles' module");
		return latestArticlesModuleCardLink.getHrefOfElementNumber(cardNumber);
	}

	public int getLeader1AdBlockLocation() {
		Logger.info("Get leader1 ad Y coordinate value");
		return leader1Ad.getElement().getLocation().y;
	}

	public boolean isTopAdVisible() {
		Logger.info("Check if top ad (leader1) is visible");
		return leader1Ad.isVisible();
	}

	public int getGoogleAd5YCoordinate() {
		Logger.info("Get Google ad number 5 Y-coordinate");
		return adDiv5.getElement().getLocation().y;
	}

	public boolean isAdDiv5Visible() {
		Logger.info("Check if right rail (adDiv5) ad is visible");
		return adDiv5.isVisible();
	}

	public boolean isAdDiv7Visible() {
		Logger.info("Check if right rail (adDiv7) ad is visible");
		return adDiv7.isVisible();
	}

	public boolean isAdDiv8Visible() {
		Logger.info("Verify if adDiv8 is visible");
		return adDiv8.isVisible();
	}

	public boolean isAdDiv9Visible() {
		Logger.info("Verify if adDiv9 is visible");
		return adDiv9.isVisible();
	}

	public boolean isBottomAdVisible() {
		Logger.info("Check if bottom ad (leaderextra) is visible");
		return leaderExtraAd.isVisible();
	}

	public int getNumberOfVisibleHorizontalPromoSections() {
		Logger.info("Get Number of Horizontal Promos");
		horizontalPromoSection.scrollIntoView();
		return horizontalPromoSection.getVisibleElementsCount();
	}

	public boolean isHorizontalPromoSectionTitleVisible(int sectionNumber) {
		Logger.info("Verify if horizontal promo #" + sectionNumber + " section title is visible");
		return horizontalPromoSectionTitle.isElementNumberVisible(sectionNumber);
	}

	public boolean isHorizontalPromoSectionViewAllLinkVisible(int sectionNumber) {
		Logger.info("Verify if 'View all' link is visible for horizontal promo section #" + sectionNumber);
		return horizontalPromoSectionViewAllLink.isElementNumberVisible(sectionNumber);
	}

	public int getNumberOfCardsInHorizontalPromo(int promoSectionNumber) {
		Logger.info("Get Number of horizontal Cards on page");
		horizontalPromoSection.scrollIntoView(promoSectionNumber);
		return horizontalPromoSectionCard.getElementsWithTextCount(String.valueOf(promoSectionNumber));
	}

	public String getHorizontalPromoSectionCardHrefValue(int sectionNumber, int cardNumber) {
		Logger.info("Get horizontal promo section card 'href' attribute value");
		return horizontalPromoSectionCardLink.getAttributeOfElementNumberWithText(cardNumber, "href", String.valueOf(sectionNumber));
	}

	public boolean isHorizontalPromoSectionCardImageVisible(int sectionNumber, int cardNumber) {
		Logger.info("Verify if horizontal promo section #" + sectionNumber + " card image #" + cardNumber + " is visible");
		return horizontalPromoSectionCardImage.isElementWithTextVisible(String.valueOf(sectionNumber), cardNumber);
	}

	public boolean isHorizontalPromoSectionCardTitleVisible(int sectionNumber, int cardNumber) {
		Logger.info("Verify if horizontal promo section #" + sectionNumber + " card title #" + cardNumber + " is visible");
		return horizontalPromoSectionCardTitle.isElementWithTextVisible(String.valueOf(sectionNumber), cardNumber);
	}
}
