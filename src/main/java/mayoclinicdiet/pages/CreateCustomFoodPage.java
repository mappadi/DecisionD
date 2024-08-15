package mayoclinicdiet.pages;

import framework.Logger;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateCustomFoodPage extends BasicPage {

	public CreateCustomFoodPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "createCustomFood";
		String CLASS_NAME = "CreateCustomFoodPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject foodNameInputField;
	protected WebObject foodGroupDropdownArrow;
	protected WebObject foodGroupDropdownOptions;
	protected WebObject yesRadioButton;
	protected WebObject selectMealDropdownArrow;
	protected WebObject mealAMSnackOption;
	protected WebObject mealDinnerOption;
	protected WebObject whenDropdownArrow;
	protected WebObject yesterdayOption;
	protected WebObject tomorrowOption;
	protected WebObject submitButton;
	protected WebObject servingSizeInputField;
	protected WebObject caloriesInputField;
	protected WebObject servingUnitsDropdownArrow;
	protected WebObject servingUnitsOptions;
	protected WebObject successMessage;
	protected WebObject createAnotherFoodButton;
	protected WebObject goToJournalButton;
	protected WebObject errorMessage;

	public CreateCustomFoodPage enterFoodName(String name) {
		Logger.info("Enter food name");
		foodNameInputField
				.waitUntilVisible()
				.type(name);
		return this;
	}

	public CreateCustomFoodPage chooseFoodGroup() {
		Logger.info("Choose food group");
		foodGroupDropdownArrow
				.waitElementsReady()
				.click();
		foodGroupDropdownOptions
				.getElements()
				.parallelStream()
				.findAny()
				.get()
				.click();
		return this;
	}

	public CreateCustomFoodPage checkYesRadioButtonChecked() {
		Logger.info("Check 'Yes! Please log this food now.' radio button is checked");
		if (yesRadioButton.isSelected()) {
			return this;
		} else {
			yesRadioButton.click();
		}
		return this;
	}

	public CreateCustomFoodPage selectAMSnackMeal() {
		Logger.info("Select 'AM Snack' meal option");
		selectMealDropdownArrow
				.waitElementsReady()
				.click();
		mealAMSnackOption
				.waitElementsReady()
				.click();
		return this;
	}

	public CreateCustomFoodPage selectDinnerMeal() {
		Logger.info("Select 'Dinner' meal option");
		selectMealDropdownArrow
				.waitElementsReady()
				.click();
		mealDinnerOption
				.waitElementsReady()
				.click();
		return this;
	}

	public CreateCustomFoodPage selectYesterdayDay() {
		Logger.info("Select 'Yesterday' option from 'When?' dropdown");
		whenDropdownArrow
				.waitElementsReady()
				.click();
		yesterdayOption
				.waitElementsReady()
				.click();
		return this;
	}

	public CreateCustomFoodPage selectTomorrowDay() {
		Logger.info("Select 'Tomorrow' option from 'When?' dropdown");
		whenDropdownArrow
				.waitElementsReady()
				.click();
		tomorrowOption
				.waitElementsReady()
				.click();
		return this;
	}

	public CreateCustomFoodPage enterServingSize(String size) {
		Logger.info("Enter Serving size value");
		servingSizeInputField
				.waitElementsReady()
				.type(size);
		return this;
	}

	public CreateCustomFoodPage chooseServingUnits() {
		Logger.info("Choose serving units");
		servingUnitsDropdownArrow
				.waitElementsReady()
				.click();
		servingUnitsOptions
				.getElements()
				.parallelStream()
				.findAny()
				.get()
				.click();
		return this;
	}

	public CreateCustomFoodPage enterCaloriesValue(String calories) {
		Logger.info("Enter Calories value");
		caloriesInputField
				.waitElementsReady()
				.type(calories);
		return this;
	}

	public CreateCustomFoodPage clickSubmitButton() {
		Logger.info("Click on 'Submit' button");
		submitButton
				.waitElementsReady()
				.click();
		return this;
	}

	public CreateCustomFoodPage checkSuccessMessageDisplayed() {
		Logger.info("Check the success message is displayed");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1728");
		boolean isSuccessMessageDisplayed = successMessage
				.waitElementsReady()
				.isPresent();
		assertTrue(isSuccessMessageDisplayed, "The success message is not displayed");
		return this;
	}

	public CreateCustomFoodPage clickCreateAnotherFoodButton() {
		Logger.info("Click on 'Create Another Food' button");
		createAnotherFoodButton
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage clickGoToJournalButton() {
		Logger.info("Click on 'Go To Journal' button");
		goToJournalButton
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, FoodAndFitnessJournalPage.class);
	}

	public CreateCustomFoodPage checkErrorMessageDisplayed() {
		Logger.info("Check the error message is displayed");
		assertTrue(errorMessage.isVisible(), "The error message is not displayed");
		return this;
	}

	public CreateCustomFoodPage checkErrorMessageText() {
		Logger.info("Check the error message for all blank mandatory fields is displayed ");
		assertEquals(errorMessage.getText(), "Please enter the required fields: Calories, Serving Size, Food Group, Serving Units.", "The error message is not correct");
		return this;
	}

	@Override
	public void waitForPageToLoad() {
		submitButton.waitUntilVisible();
	}
}
