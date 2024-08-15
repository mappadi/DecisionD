package everydayhealth.pages.push;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * PushEditLifehacksPage
 */
public class PushEditLifehacksPage extends PushEditPageBasePage {

	public PushEditLifehacksPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "push";
		String CLASS_NAME = "PushEditLifehacksPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject templateContentSectionArticleTabs;
	protected WebObject heroSectionSaveButton;
	protected WebObject heroSectionLinkPanel;
	protected WebObject heroTitleInput;
	protected WebObject heroUrlInput;
	protected WebObject heroImageInput;
	protected WebObject contentPinningSectionTitleInput;
	protected WebObject contentPinningSectionCard;
	protected WebObject cardImageInput;
	protected WebObject cardHedInput;
	protected WebObject cardURLInput;
	protected WebObject cardDeckInput;
	protected WebObject cardContentTypeInput;
	protected WebObject cardPositionInput;
	protected WebObject contentPinningSectionSaveButton;
	protected WebObject miniGuideSectionTitleInput;
	protected WebObject miniGuideSectionLink;
	protected WebObject linkImageInput;
	protected WebObject linkHedInput;
	protected WebObject linkUrlInput;
	protected WebObject linkPositionInput;
	protected WebObject miniGuideSectionSaveButton;
	protected WebObject tipsSectionTip;
	protected WebObject tipTitleInput;
	protected WebObject tipTextInput;
	protected WebObject tipAuthorInput;
	protected WebObject tipActionLinkInput;
	protected WebObject tipActionLinkTextInput;
	protected WebObject tipPositionInput;
	protected WebObject tipsSectionSaveButton;

	public void clickHeroSectionLinkPanel() {
		Logger.info("Click 'LINK' panel on Hero Board");
		heroSectionLinkPanel.scrollIntoView();
		heroSectionLinkPanel.click();
		waitForAjaxRequestToBeFinished();
	}

	public void typeHeroTitle(String title) {
		Logger.info("Type title into 'Hero Title' input");
		heroTitleInput.type(title);
	}

	public void typeHeroUrl(String url) {
		Logger.info("Type URL into 'Hero Url' input");
		heroUrlInput.type(url);
	}

	public void typeHeroImageUrl(String url) {
		Logger.info("Type URL into 'Hero Image (url)' input");
		heroImageInput.type(url);
	}

	public void clickHeroSectionSaveButton() {
		Logger.info("Click 'Save' button in 'Hero Section' tab");
		heroSectionSaveButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public void clickContentCard(int cardNumber) {
		Logger.info("Click content card #" + cardNumber);
		contentPinningSectionCard.clickOnElementNumber(cardNumber);
		waitForAjaxRequestToBeFinished(3500);
	}

	public void typeContentPinningSectionTitle(String title) {
		Logger.info("Type title into 'Section Title' input in 'Content Pinning' tab");
		contentPinningSectionTitleInput.type(title);
	}

	public void typeCardImageURL(String imageURL, String elementText) {
		Logger.info("Type image URL into 'Image' input for content card");
		cardImageInput.typeIntoElementWithText(imageURL, elementText);
	}

	public void typeCardTitle(String title, String elementText) {
		Logger.info("Type image title into 'Title/Hed' input for content card");
		cardHedInput.typeIntoElementWithText(title, elementText);
	}

	public void typeCardUrl(String url, String elementText) {
		Logger.info("Type card URL into 'Url' input for content card");
		cardURLInput.typeIntoElementWithText(url, elementText);
	}

	public void typeCardDeck(String deck, String elementText) {
		Logger.info("Type card deck into 'Deck' input for content card");
		cardDeckInput.typeIntoElementWithText(deck, elementText);
	}

	public void typeCardContentType(String contentType, String elementText) {
		Logger.info("Type card content type into 'Content Type' input for content card");
		cardContentTypeInput.typeIntoElementWithText(contentType, elementText);
	}

	public void typeCardPosition(String cardPosition, String elementText) {
		Logger.info("Type card position into 'Position (numeric)' input");
		cardPositionInput.typeIntoElementWithText(cardPosition, elementText);
	}

	public void clickContentPinningSectionSaveButton() {
		Logger.info("Click 'Save' button in 'Content Pinning' tab");
		contentPinningSectionSaveButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public void clickMiniGuideLink(int linkNumber) {
		Logger.info("Click mini guide LINK #" + linkNumber);
		miniGuideSectionLink.clickOnElementNumber(linkNumber);
	}

	public void typeMiniGuideSectionTitle(String title) {
		Logger.info("Type title into 'Section Title' input on 'Mini Guide' tab");
		miniGuideSectionTitleInput.type(title);
	}

	public void typeLinkImageUrl(String imageURL, String elementText) {
		Logger.info("Type image URL into 'Image' input for link");
		linkImageInput.typeIntoElementWithText(imageURL, elementText);
	}

	public void typeLinkTitle(String title, String elementText) {
		Logger.info("Type title into 'Title/Hed' input for link");
		linkHedInput.typeIntoElementWithText(title, elementText);
	}

	public void typeLinkUrl(String url, String elementText) {
		Logger.info("Type URL into 'Url' input for link");
		linkUrlInput.typeIntoElementWithText(url, elementText);
	}

	public void typeLinkPosition(String position, String elementText) {
		Logger.info("Type position into 'Position (numeric)' input for link");
		linkPositionInput.typeIntoElementWithText(position, elementText);
	}

	public void clickMiniGuideSectionSaveButton() {
		Logger.info("Click 'Save' button on 'Mini Guide' tab");
		miniGuideSectionSaveButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public void clickTip(int tipNumber) {
		Logger.info("Click tip #" + tipNumber);
		tipsSectionTip.clickOnElementNumber(tipNumber);
	}

	public void typeTipTitle(String title, String elementText) {
		Logger.info("Type title into 'Title' input for tip");
		tipTitleInput.typeIntoElementWithText(title, elementText);
	}

	public void typeTipText(String text, String elementText) {
		Logger.info("Type text into 'Tip Text' input for tip");
		tipTextInput.typeIntoElementWithText(text, elementText);
	}

	public void typeTipAutor(String authorName, String elementText) {
		Logger.info("Type author name into 'Author' input for tip");
		tipAuthorInput.typeIntoElementWithText(authorName, elementText);
	}

	public void typeTipActionLink(String actionLink, String elementText) {
		Logger.info("Type action link into 'Action Link' input for tip");
		tipActionLinkInput.typeIntoElementWithText(actionLink, elementText);
	}

	public void typeTipActionLinkText(String actionLinkText, String elementText) {
		Logger.info("Type action link text into 'Action Link Text' input for tip");
		tipActionLinkTextInput.typeIntoElementWithText(actionLinkText, elementText);
	}

	public void typeTipPosition(String position, String elementText) {
		Logger.info("Type position into 'Position' input for tip");
		tipPositionInput.typeIntoElementWithText(position, elementText);
	}

	public void clickTipsSectionSaveButton() {
		Logger.info("Click 'Save' button in 'Tips' tab");
		tipsSectionSaveButton.click();
		waitForAjaxRequestToBeFinished();
	}
}
