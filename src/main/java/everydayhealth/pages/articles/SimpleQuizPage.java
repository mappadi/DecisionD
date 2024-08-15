package everydayhealth.pages.articles;

import framework.Logger;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

public class SimpleQuizPage extends IGNPlayerPage {

	public SimpleQuizPage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "SimpleQuizPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject readNextWidget;
	protected WebObject readNextWidgetCard;
	protected WebObject readNextWidgetHeadline;
	protected WebObject readNextWidgetHeadlineCategoryLink;
	protected WebObject readNextWidgetCardLink;
	protected WebObject readNextWidgetCardImage;
	protected WebObject readNextWidgetCardHeadline;
	protected WebObject readNextWidgetCardTypeIcon;
	protected WebObject simpleQuizContent;
	protected WebObject simpleQuizTitle;
	protected WebObject simpleQuizDeck;
	protected WebObject simpleQuizIntroImage;
	protected WebObject simpleQuizStartButton;
	protected WebObject simpleQuizQuestion;
	protected WebObject simpleQuizPreviousArrow;
	protected WebObject optionSelectorButton;
	protected WebObject quizRestartButton;
	protected WebObject questionImage;
	protected WebObject quizResultTitle;
	protected WebObject quizResultDeck;
	protected WebObject quizResultImage;
	protected WebObject quizResultDescription;
	protected WebObject relatedContentModule;
	protected WebObject relatedContentItems;
	protected WebObject relatedContentItemImage;
	protected WebObject relatedContentItemTitle;

	@Override
	public void waitForPageToLoad() {
		waitForAjaxRequestToBeFinished(30000); //waiting for 30 sec for page to load (don't wait for any element as used for many pages with different elements)
	}

	public boolean isReadNextWidgetVisible() {
		Logger.info("Verify if Read next widget is visible");
		return readNextWidget.isVisible();
	}

	public int getNumberOfCardsInReadNext() {
		Logger.info("Get number of cards in Read next widget");
		return readNextWidgetCard.getNumberOfVisibleAndClickableElements();
	}

	public boolean isReadNextWidgetHeadlineVisible() {
		Logger.info("Verify if Read next widget headline is visible");
		return readNextWidgetHeadline.isVisible();
	}

	public boolean isReadNextCategoryLinkVisible() {
		Logger.info("Verify if Read next widget headline category link is visible");
		return readNextWidgetHeadlineCategoryLink.isVisible();
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

	public boolean isSimpleQuizContentVisible() {
		Logger.info("Check if simple quiz widget is visible");
		return simpleQuizContent.isVisible();
	}

	public boolean isSimpleQuizTitleVisible() {
		Logger.info("Verify 'Simple Quiz' widget title is visible");
		return simpleQuizTitle.isVisible();
	}

	public boolean isSimpleQuizDeckVisible() {
		Logger.info("Verify Deck is visible");
		return simpleQuizDeck.isVisible();
	}

	public boolean isSimpleQuizIntroImageVisible() {
		Logger.info("Verify if simple quiz intro image is visible");
		return simpleQuizIntroImage.isVisible();
	}

	public boolean isSimpleQuizStartButtonVisible() {
		Logger.info("Verifying simple quiz 'Start/take the quiz' button is visible");
		return simpleQuizStartButton.isVisible();
	}

	public boolean isQuizResultTitleVisible() {
		Logger.info("Verifying simple quiz 'result title'  is visible");
		quizResultTitle.waitUntilVisible();
		return quizResultTitle.isVisible();
	}

	public boolean isQuizResultDeckVisible() {
		Logger.info("Verifying simple quiz 'result deck'  is visible");
		return quizResultDeck.isVisible();
	}

	public void clickTakeTheQuizButton() {
		Logger.info("Click on take the quiz button");
		simpleQuizStartButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public void clickQuizRestartButton() {
		Logger.info("Cliking on quiz restart button");
		quizRestartButton.waitUntilVisible();
		quizRestartButton.scrollIntoView();
		quizRestartButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isRestartButtonVisible() {
		Logger.info("Verifying simple quiz restart button is visible");
		quizRestartButton.waitUntilVisible();
		return quizRestartButton.isVisible();
	}

	public boolean isQuizPreviousArrowVisible() {
		Logger.info("Verifying simple quiz previous arrow button is visible");
		return simpleQuizPreviousArrow.isVisible();
	}

	public int getSimpleQuizQuestionsCount() {
		Logger.info("Get simple quiz questions count");
		return simpleQuizQuestion.getElementsCount();
	}

	public String getSelectedOptionText(int elementNumber) {
		Logger.info("Get selected option text");
		return optionSelectorButton.getTextFromElementNumber(elementNumber);
	}

	public void clickOnOption(int elementNumber) {
		Logger.info("Click on option choice number " + elementNumber + " with text: " + getSelectedOptionText(elementNumber));
		optionSelectorButton.scrollIntoView(elementNumber);
		optionSelectorButton.clickOnElementNumber(elementNumber);
		waitForAjaxRequestToBeFinished();
	}


	public boolean isQuizResultImageVisible() {
		Logger.info("Check if simple quiz result image is visible");
		return quizResultImage.isVisible();
	}

	public boolean isQuizResultDescriptionVisible() {
		Logger.info("Check if simple quiz result description is visible");
		return quizResultDescription.isVisible();
	}

	public boolean isRelatedContentModuleVisible() {
		Logger.info("Check if related content module visible on simple quiz result page");
		return relatedContentModule.isVisible();
	}

	public boolean isSimpleQuizIGNVideoPaused() {
		Logger.info("Check if simple quiz IGN video is paused");
		waitForAjaxRequestToBeFinished();
		return Utils.getJSResult("return EDH.video1.player.getPaused();").equals("true");
	}

	public boolean isSimpleQuizIGNVideoMuted() {
		Logger.info("Check if video is muted");
		return Utils.getJSResult("return EDH.video1.player.getMuted()").equals("true");
	}

	public boolean isSimpleQuizIGNVideoInFullscreenMode() {
		Logger.info("Check if video is in fullscreen mode");
		waitForAjaxRequestToBeFinished();
		return Utils.getJSResult("return EDH.video1.player.getFullscreen();").equals("true");
	}

	public int getNumberOfRelatedContentItems() {
		Logger.info("Get number of related content items on result page");
		return relatedContentItems.getVisibleElementsCount();
	}

	public boolean isRelatedContentItemImageVisible() {
		Logger.info("Check if related content item image is visible on result page");
		relatedContentItemImage.scrollToElement();
		return relatedContentItemImage.isVisible();
	}

	public boolean isRelatedContentItemTitleVisible() {
		Logger.info("Check if related content item title is visible on result page");
		return relatedContentItemTitle.isVisible();
	}
}
