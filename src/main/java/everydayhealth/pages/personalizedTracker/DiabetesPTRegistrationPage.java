package everydayhealth.pages.personalizedTracker;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * DiabetesPTRegistrationPage
 */

public class DiabetesPTRegistrationPage extends PTRegistrationPage {

	public DiabetesPTRegistrationPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "personalizedTracker";
		String CLASS_NAME = "DiabetesPTRegistrationPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject ageRange;
	protected WebObject ageRangeDropdownOption;
	protected WebObject ageRangeDropdownOptionText;
	protected WebObject medicareQuestionModule;
	protected WebObject medicareAnswerYesCheckbox;
	protected WebObject medicareAnswerNoCheckbox;
	protected WebObject medicationModule;
	protected WebObject diabetesMedicationDropdownOption;
	protected WebObject under18ErrorMessage;

	public boolean isAgeRangeModuleVisible() {
		Logger.info("Verify if age range module is visible");
		return ageRange.isVisible();
	}

	public void chooseAgeRange(String ageRange) {
		Logger.info("Choose age range value - " + ageRange);
		if (ageRange.equals("Under 18")) {
			ageRange = "1";
		}
		ageRangeDropdownOption.clickOnElementWithValue(ageRange);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isAgeRangeValuePresentInDropdown(String ageRange) {
		Logger.info("Verify if age range - " + ageRange + " is present in dropdown");
		return ageRangeDropdownOptionText.isElementWithTextVisible(ageRange);
	}

	public boolean isMedicareQuestionModuleVisible() {
		Logger.info("Verify if medicare question is visible");
		return medicareQuestionModule.isVisible();
	}

	public boolean isMedicareAnswerYesCheckboxVisible() {
		Logger.info("Verify if medicare answer 'Yes' checkbox is visible");
		return medicareAnswerYesCheckbox.isVisible();
	}

	public boolean isMedicareAnswerNoCheckboxVisible() {
		Logger.info("Verify if medicare answer 'No' checkbox is visible");
		return medicareAnswerNoCheckbox.isVisible();
	}

	public boolean isMedicareAnswerYesCheckboxChecked() {
		Logger.info("Verify if medicare answer 'Yes' checkbox is checked");
		return medicareAnswerYesCheckbox.getAttribute("class").contains("checkbox-checked");
	}

	public void clickMedicareAnswerYesCheckbox() {
		Logger.info("Click on 'Yes' answer for medicare question");
		medicareAnswerYesCheckbox.click();
		waitForAjaxRequestToBeFinished();
	}

	public void clickMedicareAnswerNoCheckbox() {
		Logger.info("Click on 'No' answer for medicare question");
		medicareAnswerNoCheckbox.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isMedicareAnswerNoCheckboxChecked() {
		Logger.info("Verify if medicare answer 'No' checkbox is checked");
		return medicareAnswerNoCheckbox.getAttribute("class").contains("checkbox-checked");
	}

	public boolean isMedicationModuleVisible() {
		Logger.info("Verify if medication module is visible");
		return medicationModule.isVisible();
	}

	public int getNumberOfMedicationOptions() {
		Logger.info("Get number of medication options");
		return diabetesMedicationDropdownOption.getElementsCount();
	}

	public DiabetesPTRegistrationPage chooseMedicationOptionNumber(int optionNumber) {
		Logger.info("Choose medication option #" + optionNumber);
		Logger.info("Option name is " + diabetesMedicationDropdownOption.getTextFromElementNumber(optionNumber));
		diabetesMedicationDropdownOption.clickOnElementNumber(optionNumber);
		return this;
	}

	public boolean isUnder18ErrorMessageVisible() {
		Logger.info("Verify if 'Sorry, you must be over 18 to be eligible for this program.' error message is visible");
		return under18ErrorMessage.isVisible();
	}
}
