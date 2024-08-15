package everydayhealth.pages.articles;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class CusoManagementSelectorPage extends CustomSolutionsTemplatePage {

	public CusoManagementSelectorPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "CusoManagementSelectorPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject quizPage;
	protected WebObject breadcrumb;
	protected WebObject headline;
	protected WebObject readMoreLink;
	protected WebObject readMoreBefore;
	protected WebObject readMoreAfter;
	protected WebObject progressBar;
	protected WebObject answerButton;
	protected WebObject optionSelectorButton;
	protected WebObject nextAnswer;
	protected WebObject resultDescription;
	protected WebObject resultHeadline;
	protected WebObject resultSubDescription;
	protected WebObject resultContentHeadline;
	protected WebObject resultContent;
	protected WebObject previousLink;
	protected WebObject startOver;

	@Override
	public void waitForPageToLoad() {
		quizPage.waitUntilVisibleOnPage(this);
	}

	public boolean isHeadlineVisible() {
		Logger.info("Verify headline is visible");
		return headline.isVisible();
	}

	public boolean isBreadcrumbVisible() {
		Logger.info("Verify breadcrumb is visible");
		return breadcrumb.isVisible();
	}

	public boolean isReadMoreBeforeVisible() {
		Logger.info("Verify Read More Before is visible");
		return readMoreBefore.isVisible();
	}

	public String getReadMoreTextBeforeClick() {
		Logger.info("Get text from ATC section before clicking 'Read more' link");
		return readMoreBefore.getText();
	}

	public boolean isReadMoreLinkVisible() {
		Logger.info("Verify Read More link is visible");
		return readMoreLink.isVisible();
	}

	public boolean isReadMoreTextAfterClickVisible() {
		Logger.info("Verify Read More After is visible");
		return readMoreAfter.isVisible();
	}

	public void clickReadMoreLink() {
		Logger.info("Click on Read More Link");
		readMoreLink.click();
		waitForAjaxRequestToBeFinished();
	}

	public void clickOnAnswer(int questionNumber, int answerNumber) {
		Logger.info("Click on answer #" + answerNumber);
		answerButton.clickOnElementNumberWithText(answerNumber, String.valueOf(questionNumber));
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfAnswers(int questionNumber) {
		Logger.info("Get number of available answers");
		return answerButton.getElementsWithTextCount(String.valueOf(questionNumber));
	}

	public String getAnwerText(int questionNumber, int answerNumber) {
		Logger.info("Get answer #" + answerNumber + " text");
		return answerButton.getTextFromElementWithText(String.valueOf(questionNumber), answerNumber);
	}

	public int getProgressBarElementsCount() {
		Logger.info("Get progress bar count");
		return progressBar.getVisibleElementsCount();
	}

	public boolean isProgressBarElementNumberEnabled(int elementNumber) {
		Logger.info("Verify if progress bar element #" + elementNumber + " is enabled");
		return Boolean.parseBoolean(progressBar.getAttributeOfElementNumber(elementNumber, "data-viewed"));
	}

	public String getSelectedOptionText(int elementNumber) {
		Logger.info("Get selected option text");
		return optionSelectorButton.getTextFromElementNumber(elementNumber);
	}

	public List<String> getOptionsText() {
		Logger.info("Get rest of options text");
		int optionButtonSize = optionSelectorButton.getElementsCount();
		List<String> options = new ArrayList<String>(optionButtonSize);
		for (int optionNumber = 1; optionNumber <= optionButtonSize; optionNumber++) {
			options.add(optionSelectorButton.getTextFromElementNumber(optionNumber));
		}
		return options;
	}

	public String getResultHeadline() {
		Logger.info("Get result Headline");
		return resultHeadline.getText();
	}

	public boolean isResultHeadlineVisible() {
		Logger.info("Verify result Headline is visible");
		return resultHeadline.isVisible();
	}

	public boolean isResultDescriptionVisible() {
		Logger.info("Verify result description is visible");
		return resultDescription.isVisible();
	}

	public boolean isResultSubDescriptionVisible() {
		Logger.info("Verify result subdescription is visible");
		return resultSubDescription.isVisible();
	}

	public boolean isResultContentHeadlineVisible() {
		Logger.info("Verify result content headline is visible");
		return resultContentHeadline.isVisible();
	}

	public boolean isResultContentVisible() {
		Logger.info("Verify result content is visible");
		return resultContent.isVisible();
	}

	public boolean isStartOverLinkVisible() {
		Logger.info("Verify Start over link is visible");
		return startOver.isVisible();
	}

	public void clickStartOverLink() {
		Logger.info("Click on Start over link");
		int elementNumber = startOver.getFirstVisibleAndClickableElement();
		startOver.clickOnElementNumber(elementNumber);
		waitForAjaxRequestToBeFinished();
	}

	public void clickPreviousLink() {
		Logger.info("Click on previous link");
		int elementNumber = previousLink.getFirstVisibleAndClickableElement();
		previousLink.clickOnElementNumber(elementNumber);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isPreviousLinkVisible() {
		Logger.info("Verify previous link is visible");
		int elementNumber = previousLink.getFirstVisibleAndClickableElement();
		return previousLink.isElementNumberVisible(elementNumber);
	}

	public String getNextAnswerText() {
		Logger.info("Get next answer text");
		int elementNumber = nextAnswer.getFirstVisibleAndClickableElement();
		return nextAnswer.getTextFromElementNumber(elementNumber);
	}

	public void clickNextAnswerLink() {
		Logger.info("Click on Next Answer Link");
		int elementNumber = nextAnswer.getFirstVisibleAndClickableElement();
		nextAnswer.clickOnElementNumber(elementNumber);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isNextAnswerVisible() {
		Logger.info("Verify 'Next Answer' is visible");
		return nextAnswer.getNumberOfVisibleAndClickableElements() > 0;
	}

	public void clickOnOption(int elementNumber) {
		Logger.info("Click on option choice number " + elementNumber + " with text :" + optionSelectorButton.getTextFromElementNumber(elementNumber));
		optionSelectorButton.clickOnElementNumber(elementNumber);
		waitForAjaxRequestToBeFinished();
	}
}