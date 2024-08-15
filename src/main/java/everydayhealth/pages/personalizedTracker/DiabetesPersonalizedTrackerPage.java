package everydayhealth.pages.personalizedTracker;

import framework.Logger;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

/**
 * PersonalizedTrackerPage
 */
public class DiabetesPersonalizedTrackerPage extends PersonalizedTrackerPage {

	public DiabetesPersonalizedTrackerPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "personalizedTracker";
		String CLASS_NAME = "DiabetesPersonalizedTrackerPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject dailyBloodSugarLevelModule;
	protected WebObject dailyBloodSugarLevelModuleLabel;
	protected WebObject dailyBSLModuleEditModeQuestion;
	protected WebObject dailyBSLModuleEditModeYesButton;
	protected WebObject dailyBSLModuleEditModeNoButton;
	protected WebObject dailyBSLModuleEditModeInfo;
	protected WebObject dailyBSLModuleEditModeBar;
	protected WebObject dailyBSLModuleEditModeBarSelectedLevel;
	protected WebObject dailyBSLModuleEditModeLevel;
	protected WebObject dailyBSLModuleResultLabel;
	protected WebObject weeklyBSLModule;
	protected WebObject weeklyBSLModuleResults;
	protected WebObject weeklyBSLModuleResultsContainer;
	protected WebObject weeklyBSLModuleResultsContainerLabel;
	protected WebObject weeklyBSLModuleResultsContainerTimeLabel;
	protected WebObject weeklyBSLModuleResultsContainerImage;
	protected WebObject weeklyBSLModuleResultsContainerImageLabel;
	protected WebObject a1cModule;
	protected WebObject a1cModuleEditLink;
	protected WebObject a1cModuleResults;
	protected WebObject a1cModuleResultsHeader;
	protected WebObject a1cModuleResultsAmount;
	protected WebObject a1cModuleCalculator;
	protected WebObject a1cModuleCalculatorHeading;
	protected WebObject a1cModuleCalculatorGoalDropdown;
	protected WebObject a1cModuleCalculatorGoalDropdownOption;
	protected WebObject a1cModuleCalculatorLatestResultInput;
	protected WebObject a1cModuleCalculatorDateButton;
	protected WebObject a1cModuleCalculatorSubmitButton;
	protected WebObject bmiModule;
	protected WebObject bmiModuleCalculatorHeading;
	protected WebObject bmiModuleCalculatorWeightInput;
	protected WebObject bmiModuleCalculatorHeightFtDropdown;
	protected WebObject bmiModuleCalculatorHeightFtDropdownOption;
	protected WebObject bmiModuleCalculatorHeightInDropdown;
	protected WebObject bmiModuleCalculatorHeightInDropdownOption;
	protected WebObject bmiModuleCalculateButton;
	protected WebObject bmiModuleResults;
	protected WebObject bmiModuleResultsAmount;
	protected WebObject bmiModuleResultsRecalculateLink;
	protected WebObject bmiModuleResultsBar;
	protected WebObject bmiModuleResultsBarSelected;
	protected WebObject bmiModuleResultsBarPin;

	@Override
	public void waitForPageToLoad() {
		tab.waitUntilVisibleOnPage(this);
	}

	public boolean isBloodSugarLevelModuleVisibleOnDailyView() {
		Logger.info("Verify if Blood sugar level module is visible on Daily view");
		return dailyBloodSugarLevelModule.isVisible();
	}

	public boolean isBSLModuleInNonEditMode() {
		Logger.info("Verify if BSL module is in non-edit mode");
		return dailyBloodSugarLevelModuleLabel.isVisible();
	}

	public String getBSLModuleLabelInNonEditMode() {
		Logger.info("Get Blood sugar level module label text");
		return dailyBloodSugarLevelModuleLabel.getText();
	}

	public String getBSLModuleQuestionText() {
		Logger.info("Get Blood sugar level module question text");
		return dailyBSLModuleEditModeQuestion.getText();
	}

	public boolean isBSLModuleQuestionVisible() {
		Logger.info("Verify if question is visible on Blood sugar level module");
		return dailyBSLModuleEditModeQuestion.isVisible();
	}

	public boolean isBSLModuleYesAnswerButtonVisible() {
		Logger.info("Verify if 'Yes' answer button is visible on Blood sugar level module");
		return dailyBSLModuleEditModeYesButton.isVisible();
	}

	public DiabetesPersonalizedTrackerPage clickBSLModuleYesAnswerButton() {
		Logger.info("Click 'Yes' button on Blood sugar level module");
		dailyBSLModuleEditModeYesButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isBSLModuleNoAnswerButtonVisible() {
		Logger.info("Verify if 'No' answer button is visible on Blood sugar level module");
		return dailyBSLModuleEditModeNoButton.isVisible();
	}

	public DiabetesPersonalizedTrackerPage clickBSLModuleNoAnswerButton() {
		Logger.info("Click 'No' button on Blood sugar level module");
		dailyBSLModuleEditModeNoButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isBSLModuleInputsVisible() {
		Logger.info("Verify if Blood sugar module inputs are visible in edit mode");
		return dailyBSLModuleEditModeInfo.isVisible();
	}

	public DiabetesPersonalizedTrackerPage clickOnBarWithLevel(int barNumber, String level) {
		Logger.info("Click on Bar #" + barNumber + " level: " + level);
		dailyBSLModuleEditModeLevel.clickOnElementNumberWithText(barNumber, level);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public String getColorOfBarNumber(int barNumber) {
		Logger.info("Get color of bar #" + barNumber);
		return Utils.getHexColor(dailyBSLModuleEditModeBarSelectedLevel.getCSSValueFromElementWithText("background-color", String.valueOf(barNumber)));
	}

	public int getNumberOfBars() {
		Logger.info("Get number of visible bars in edit mode");
		return dailyBSLModuleEditModeBar.getNumberOfVisibleAndClickableElements();
	}

	public String getTextOfResultNumber(int resultNumber) {
		Logger.info("Get text of result #" + resultNumber);
		return dailyBSLModuleResultLabel.getTextFromElementNumber(resultNumber);
	}

	public boolean isWeeklyBSLModuleVisible() {
		Logger.info("Verify if BSL module is visible in weekly view");
		return weeklyBSLModule.isVisible();
	}

	public boolean isBSLResultsModuleVisibleInWeeklyView() {
		Logger.info("Verify if results are visible on BSL module in weekly view");
		return weeklyBSLModuleResults.isVisible();
	}

	public boolean isBSLModuleResultsLabelVisible(String resultsLabel) {
		Logger.info("Verify if label '" + resultsLabel + "' is visible in results module");
		return weeklyBSLModuleResultsContainerLabel.isElementWithTextVisible(resultsLabel);
	}

	public String getBSLModuleResultsLabelTimeText(String resultsLabel) {
		Logger.info("Verify if time label is present for block '" + resultsLabel + "'");
		return weeklyBSLModuleResultsContainerTimeLabel.getTextFromElementWithText(resultsLabel);
	}

	public int getNumberOfResultContainers() {
		Logger.info("Get number of result containers");
		return weeklyBSLModuleResultsContainer.getVisibleElementsCount();
	}

	public boolean isImageVisibleForResult(String resultText) {
		Logger.info("Verify if image is visible for result '" + resultText + "'");
		return weeklyBSLModuleResultsContainerImage.isElementWithTextVisible(resultText);
	}

	public boolean isLabelVisibleOnResultImage(String resultText) {
		Logger.info("Verify if label is visible for result '" + resultText + "'");
		return weeklyBSLModuleResultsContainerImageLabel.isElementWithTextVisible(resultText);
	}

	public boolean isBMIModuleVisible() {
		Logger.info("Verify if BMI module is visible");
		return bmiModule.isVisible();
	}

	public DiabetesPersonalizedTrackerPage clickRecalculateLink() {
		Logger.info("Click 'Recalculate' link");
		bmiModuleResultsRecalculateLink.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isRecalculateLinkVisible() {
		Logger.info("Verify if 'Recalculate' link is visible");
		return bmiModuleResultsRecalculateLink.isVisible();
	}

	public boolean isWeightInputVisible() {
		Logger.info("Verify if 'Weight' input is visible");
		return bmiModuleCalculatorWeightInput.isVisible();
	}

	public DiabetesPersonalizedTrackerPage typeWeight(String weightValue) {
		Logger.info("Type weight: " + weightValue);
		bmiModuleCalculatorWeightInput.type(weightValue);
		return this;
	}

	public boolean isWeightInputValueCorrect() {
		Logger.info("Verify if 'Weight' input is valid (field is red)");
		return !bmiModuleCalculatorWeightInput.getAttribute("class").contains("error") && Utils.getHexColor(bmiModuleCalculatorWeightInput.getCssValue("border-bottom-color")).equals("#ff0000");
	}

	public boolean isHeightFtDropdownVisible() {
		Logger.info("Verify if 'Height Ft' dropdown is visible");
		return bmiModuleCalculatorHeightFtDropdown.isVisible();
	}

	public DiabetesPersonalizedTrackerPage chooseValueFromHeightFtDropdown(String heightFtValue) {
		Logger.info("Choose value from 'Height Ft' dropdown: " + heightFtValue);
		bmiModuleCalculatorHeightFtDropdownOption.clickOnElementWithValue(heightFtValue);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public String getHeightFtDropdownOptionText(int optionNumber) {
		Logger.info("Get text from 'Height Ft' dropdown option");
		return bmiModuleCalculatorHeightFtDropdownOption.getTextFromElementNumber(optionNumber);
	}

	public boolean isHeightInDropdownVisible() {
		Logger.info("Verify if 'Height In' dropdown is visible");
		return bmiModuleCalculatorHeightInDropdown.isVisible();
	}

	public DiabetesPersonalizedTrackerPage chooseValueFromHeightInDropdown(String heightInValue) {
		Logger.info("Choose value from 'Height In' dropdown: " + heightInValue);
		bmiModuleCalculatorHeightInDropdownOption.clickOnElementWithValue(heightInValue);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public String getHeightInDropdownOptionText(int optionNumber) {
		Logger.info("Get text from 'Height In' dropdown option");
		return bmiModuleCalculatorHeightInDropdownOption.getTextFromElementNumber(optionNumber);
	}

	public boolean isCalculateButtonVisible() {
		Logger.info("Verify if 'Calculate' button is visible");
		return bmiModuleCalculateButton.isVisible();
	}

	public DiabetesPersonalizedTrackerPage clickCalculateButton() {
		Logger.info("Click 'Calculate' button");
		bmiModuleCalculateButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public int getNumberOfOptionsInHeightFtDropdown() {
		Logger.info("Get number of options in 'Height Ft' dropdown");
		return bmiModuleCalculatorHeightFtDropdownOption.getElementsCount();
	}

	public int getNumberOfOptionsInHeightInDropdown() {
		Logger.info("Get number of options in 'Height In' dropdown");
		return bmiModuleCalculatorHeightInDropdownOption.getElementsCount();
	}

	public boolean isBMIModuleHeadingVisible() {
		Logger.info("Verify if BMI module heading is visible");
		return bmiModuleCalculatorHeading.isVisible();
	}

	public boolean isBMIResultsVisible() {
		Logger.info("Verify if results are visible on BMI module");
		return bmiModuleResults.isVisible();
	}

	public boolean isBMIValueVisible() {
		Logger.info("Verify if BMI value is visible");
		return bmiModuleResultsAmount.isVisible() && !bmiModuleResultsAmount.getText().isEmpty();
	}

	public boolean isBMIResultsBarVisible() {
		Logger.info("Verify if results bar is visible on BMI module");
		return bmiModuleResultsBar.isVisible();
	}

	public boolean isFilledBMIResultsBarVisible() {
		Logger.info("Verify if filled bar is visible on BMI module");
		return bmiModuleResultsBarSelected.isVisible();
	}

	public boolean isPinVisibleOnBMIResultsBar() {
		Logger.info("Verify if pin is visible on BMI results bar");
		return bmiModuleResultsBarPin.isVisible();
	}

	public boolean isA1CModuleVisible() {
		Logger.info("Verify if A1C module is visible");
		return a1cModule.isVisible();
	}

	public boolean isEditLinkVisible() {
		Logger.info("Verify if 'Edit' link is visible");
		return a1cModuleEditLink.isVisible();
	}

	public DiabetesPersonalizedTrackerPage clickEditLink() {
		Logger.info("Click 'Edit' link");
		a1cModuleEditLink.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isA1CCalculatorVisible() {
		Logger.info("Verify if A1C calculator is visible");
		return a1cModuleCalculator.isVisible();
	}

	public boolean isA1CCalculatorHeadingVisible() {
		Logger.info("Verify if A1C calculator heading is visible");
		return a1cModuleCalculatorHeading.isVisible();
	}

	public boolean isA1CGoalDropdownVisible() {
		Logger.info("Verify if A1C 'What's Your A1C Goal?' dropdown is visible");
		return a1cModuleCalculatorGoalDropdown.isVisible();
	}

	public boolean isA1CLastResultInputVisible() {
		Logger.info("Verify if 'Last A1C Test Result' is visible");
		return a1cModuleCalculatorLatestResultInput.isVisible();
	}

	public boolean isA1CDateSelectDateButtonVisible() {
		Logger.info("Verify if A1C 'Select Date' button is visible");
		return a1cModuleCalculatorDateButton.isVisible();
	}

	public DiabetesPersonalizedTrackerPage clickA1CModuleSelectDateButton() {
		Logger.info("Click 'Select Date' button on A1C module");
		a1cModuleCalculatorDateButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public String getGoalDropdownOptionText(int optionNumber) {
		Logger.info("Get text from 'What's Your A1C Goal?' dropdown option #" + optionNumber);
		return a1cModuleCalculatorGoalDropdownOption.getTextFromElementNumber(optionNumber);
	}

	public DiabetesPersonalizedTrackerPage chooseGoalValue(String goalValue) {
		Logger.info("Choose goal value '" + goalValue + "'");
		a1cModuleCalculatorGoalDropdownOption.clickOnElementWithValue(goalValue);
		return this;
	}

	public DiabetesPersonalizedTrackerPage typeA1CLastResult(String value) {
		Logger.info("Type '" + value + "' into 'Last A1C Test Result' input");
		a1cModuleCalculatorLatestResultInput.type(value);
		return this;
	}

	public boolean isA1CLastResultInputValueCorrect() {
		Logger.info("Verify if value in 'Last A1C Test Result' input is correct");
		return !a1cModuleCalculatorLatestResultInput.getAttribute("class").contains("error") && Utils.getHexColor(a1cModuleCalculatorLatestResultInput.getCssValue("border-bottom-color")).equals("#ff0000");
	}

	public DiabetesPersonalizedTrackerPage clickA1CCalculateButton() {
		Logger.info("Click A1C module 'Calculate' button");
		a1cModuleCalculatorSubmitButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isA1CCalculateButtonVisible() {
		Logger.info("Verify if 'Calculate' button is visible on A1C module");
		return a1cModuleCalculatorSubmitButton.isVisible();
	}

	public boolean isA1CResultsModuleVisible() {
		Logger.info("Verify if A1C Results module is visible");
		return a1cModuleResults.isVisible();
	}

	public String getA1CResultsHeaderText(int resultNumber) {
		Logger.info("Get A1C results header text");
		return a1cModuleResultsHeader.getTextFromElementNumber(resultNumber);
	}

	public String getA1CResultsAmount(int resultNumber) {
		Logger.info("Get A1C results amount text");
		return a1cModuleResultsAmount.getTextFromElementNumber(resultNumber);
	}
}
