package everydayhealth.pages.lifehack;

import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.ArticleNewTemplatePage;
import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * LifehackPage
 */
public class LifehackPage extends ArticleNewTemplatePage {

	public LifehackPage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "lifehack";
		String CLASS_NAME = "LifehackPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject heroMenu;
	protected WebObject breadcrumbLink;
	protected WebObject articleCard;
	protected WebObject articleCardImage;
	protected WebObject articleCardTitle;
	protected WebObject articleCardTypeIcon;
	protected WebObject tipCard;
	protected WebObject tipAuthor;
	protected WebObject tipActionLink;
	protected WebObject tipShareLink;
	protected WebObject tipCardCloseShareBarIcon;
	protected WebObject submissionWidget;
	protected WebObject shareYouLifehackButton;
	protected WebObject shareLifehackPopUp;
	protected WebObject popUpForm;
	protected WebObject popUpEmailField;
	protected WebObject popUpDefaultMessage;
	protected WebObject popUpTextArea;
	protected WebObject popUpSubscribeCheckbox;
	protected WebObject popUpSubmitButton;
	protected WebObject popUpPrivacyLink;
	protected WebObject popUpTextAreaCharCounter;
	protected WebObject popUpCloseButton;
	protected WebObject confirmationMessagePopUp;
	protected WebObject tosBlock;
	protected WebObject tosCheckbox;
	protected WebObject termsOfUseHyperlink;
	protected WebObject privacyPolicyHyperlink;
	protected WebObject miniGuideCard;
	protected WebObject miniGuideCardImage;
	protected WebObject miniGuideCardTitle;

	@Override
	public void waitForPageToLoad() {
		heroImage.waitUntilVisibleOnPage(this);
	}

	public boolean isHeroMenuVisible() {
		Logger.info("Check if hero menu is visible");
		return heroMenu.isVisible();
	}

	public boolean isBreadcrumbLinkVisible() {
		Logger.info("Check if breadcrumb link visible");
		return breadcrumbLink.isVisible();
	}

	public boolean isBreadcrumbLinkValid() {
		Logger.info("Check if breadcrumb's 'href' paramater is valid URL");
		return breadcrumbLink.getAttribute("href").startsWith("https://");
	}

	public void openActionLinkInBackground() {
		Logger.info("Open action link on tip #1");
		tipActionLink.openLinkInBackgroundTab();
	}

	public int getNumberOfArticleCards() {
		Logger.info("Get number of content cards (non-tip)");
		return articleCard.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfArticleCardImages() {
		Logger.info("Get number of content card (non-tip) images");
		return articleCardImage.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfArticleCardTitles() {
		Logger.info("Get number of content card (non-tip) titles");
		return articleCardTitle.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfArticleCardTypeIcons() {
		Logger.info("Get number of content card (non-tip) type icons");
		return articleCardTypeIcon.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfTipCards() {
		Logger.info("Get number of tip cards");
		return tipCard.getNumberOfVisibleAndClickableElements();
	}

	public boolean isTipCardNumberVisible(int tipNumber) {
		Logger.info("Check if tip #" + tipNumber + " is visible");
		return tipCard.isElementNumberVisible(tipNumber);
	}

	public boolean isTipCardAuthorNameNumberVisible(int tipNumber) {
		Logger.info("Check if author name is visible on tip #" + tipNumber);
		return tipAuthor.isElementNumberVisible(tipNumber);
	}

	public boolean isTipActionLinkNumberVisible(int tipNumber) {
		Logger.info("Check if action link is visible on tip #" + tipNumber);
		return tipActionLink.isElementNumberVisible(tipNumber);
	}

	public <T> T clickOnTipActionLinkNumber(int tipNumber, Class<T> expectedPage) {
		Logger.info("Click on action link on tip #" + tipNumber);
		tipActionLink.clickOnElementNumber(tipNumber);
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public boolean isTipShareIconNumberVisible(int tipNumber) {
		Logger.info("Check if share icon is visible on tip #" + tipNumber);
		return tipShareLink.isElementNumberVisible(tipNumber);
	}

	public SocialBarEH clickTipShareLink(int tipNumber) {
		Logger.info("Open social bar on tip #" + tipNumber);
		tipShareLink.clickOnElementNumber(tipNumber);
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(basedriver, SocialBarEH.class);
	}

	public boolean isTipCardNumberFlipped(int tipNumber) {
		Logger.info("Check if card flipped");
		return tipCard.getAttributeOfElementNumber(tipNumber, "class").contains("flipped");
	}

	public void clickCloseShareBarIcon() {
		Logger.info("Click 'x' button on share bar");
		tipCardCloseShareBarIcon.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isSubmissionWidgetVisible() {
		Logger.info("Check if submission widget is visible");
		return submissionWidget.isVisible();
	}

	public void clickShareYouLifehackButton() {
		Logger.info("Click 'Share your lifehack' button");
		shareYouLifehackButton.click();
		shareLifehackPopUp.waitUntilVisible();
	}

	public boolean isPopUpVisible() {
		Logger.info("Check if 'Share you lifehack' pop up appeared");
		return shareLifehackPopUp.isVisible();
	}

	public boolean isEmailInputVisible() {
		Logger.info("Check if 'Email' input is visible");
		return popUpEmailField.isVisible();
	}

	public String getDefaultEmailInputText() {
		Logger.info("Get 'Email' input default content");
		return popUpEmailField.getAttribute("placeholder");
	}

	public String getEmailInputText() {
		Logger.info("Get 'Email' input content");
		return popUpEmailField.getAttribute("value");
	}

	public void typeEmail(String email) {
		Logger.info("Type email");
		popUpEmailField.type(email);
	}

	public boolean isDefaultMessageVisible() {
		Logger.info("Check if default message is visible");
		return popUpDefaultMessage.isVisible();
	}

	public String getTextAreaDefaultContent() {
		Logger.info("Get text area default content");
		return popUpTextArea.getAttribute("placeholder");
	}

	public String getTextAreaContent() {
		Logger.info("Get text area content");
		return popUpTextArea.getAttribute("value");
	}

	public void typeText(String text) {
		Logger.info("Type lifehack message into text area");
		popUpTextArea.type(text);
	}

	public boolean isCharCounterVisible() {
		Logger.info("Check if char counter is visible");
		return popUpTextAreaCharCounter.isVisible();
	}

	public String getCharCounterValue() {
		Logger.info("Get char counter value");
		return popUpTextAreaCharCounter.getText();
	}

	public boolean isSubscribeCheckBoxVisible() {
		Logger.info("Check if subscription checkbox is visible");
		return popUpSubscribeCheckbox.isVisible();
	}

	public boolean isCheckboxChecked() {
		Logger.info("Check if checkbox is checked");
		return popUpSubscribeCheckbox.getCssValue("checked").equals("true");
	}

	public boolean isSubmitButtonVisible() {
		Logger.info("Check if 'Submit' button is visible");
		popUpSubmitButton.scrollIntoView();
		return popUpSubmitButton.isVisible();
	}

	public String getSubmitButtonText() {
		Logger.info("Get text from 'Submit' button");
		return popUpSubmitButton.getText();
	}

	public void clickSubmitButton() {
		Logger.info("Click 'Submit' button");
		popUpSubmitButton.scrollToElement();
		popUpSubmitButton.click();
		confirmationMessagePopUp.waitUntilVisible();
	}

	public boolean isButtonEnabled() {
		Logger.info("Check if button enabled");
		if (popUpTextAreaCharCounter.isVisible()) {
			popUpTextAreaCharCounter.click();
		}
		return popUpForm.getAttribute("data-form-valid").equals("true");
	}

	public boolean isPrivacyLinkVisible() {
		Logger.info("Check if 'Privacy' link is visible");
		popUpPrivacyLink.scrollIntoView();
		return popUpPrivacyLink.isVisible();
	}

	public String getPrivacyLinkHrefAttributeValue() {
		Logger.info("Get 'Privacy' hyperlink 'href' attribute value");
		return popUpPrivacyLink.getAttribute("href");
	}

	public boolean isConfirmationMessageVisible() {
		Logger.info("Check if confirmation message is visible");
		return confirmationMessagePopUp.isVisible();
	}

	public void clickClosePopUpButton() {
		Logger.info("Click 'Close' button on pop up");
		popUpCloseButton.click();
		popUpForm.waitUntilInvisible();
	}

	public boolean isTermsOfUseBlockVisible() {
		Logger.info("Verify if 'Terms of Use' block is visible");
		return tosBlock.isVisible();
	}

	public void clickTermsOfUseCheckbox() {
		Logger.info("Click 'Terms of use' checkbox");
		tosCheckbox.click();
		waitForAjaxRequestToBeFinished();
	}

	public String getTermsOfUseLinkHrefValue() {
		Logger.info("Get 'Terms of use' 'href' attribute value");
		return termsOfUseHyperlink.getAttribute("href");
	}

	public String getPrivacyPolicyLinkHrefValue() {
		Logger.info("Get 'Privacy Policy' 'href' attribute value");
		return privacyPolicyHyperlink.getAttribute("href");
	}

	public int getNumberOfMiniGuideCards() {
		Logger.info("Get number of mini guide cards");
		return miniGuideCard.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfMiniGuideCardsImages() {
		Logger.info("Get number of mini guide card images");
		return miniGuideCardImage.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfMiniGuideCardsTitles() {
		Logger.info("Get number of mini guide card titles");
		return miniGuideCardTitle.getNumberOfVisibleAndClickableElements();
	}
}
