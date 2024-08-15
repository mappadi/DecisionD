package mayoclinicdiet.pages;

import framework.Logger;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateCustomExercisePage extends BasicPage {

	public CreateCustomExercisePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "сreateCustomExercise";
		String CLASS_NAME = "CreateCustomExercisePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject exerciseNameInputField;
	protected WebObject howLongInputField;
	protected WebObject noRadioButton;
	protected WebObject submitButton;
	protected WebObject logThisLater;
	protected WebObject caloriesSlider;
	protected WebObject successMessage;
	protected WebObject takeToJournalLink;
	protected WebObject createAnotherExerciseLink;
	protected WebObject caloriesBurnedInputField;
	protected WebObject whenDropDown;
	protected WebObject estimatedCalories;
	protected WebObject errorMessage;
	protected static String rememberEstimatedCalories;

	public CreateCustomExercisePage checkCreateCustomExerciseUrl() {
		Logger.info("Check 'Create Custom Exercise' page url");
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/food-fitness/journal/create-custom-exercise"), "URL doesn't contain '/food-fitness/journal/create-custom-exercise'");
		return this;
	}

	public CreateCustomExercisePage enterExerciseName(String name) {
		Logger.info("Enter exercise name");
		exerciseNameInputField
				.waitElementsReady()
				.type(name);
		return this;
	}

	public CreateCustomExercisePage enterDurationInMinute(String minute) {
		Logger.info("Enter 'How Long?' value");
		howLongInputField
				.waitElementsReady()
				.type(minute);
		return this;
	}

	public CreateCustomExercisePage selectNoAnswer() {
		Logger.info("Select 'No' answer");
		noRadioButton
				.waitElementsReady()
				.click();
		return this;
	}

	public CreateCustomExercisePage clickOnSubmitButton() {
		Logger.info("Click on 'Submit' button");
		submitButton
				.waitElementsReady()
				.click();
		return this;
	}

	public CreateCustomExercisePage checkSuccessMessageDisplayed() {
		Logger.info("Check the Success message is displayed");
		assertTrue(successMessage.isPresent(), "The success message is not displayed");
		return this;
	}

	public CreateCustomExercisePage clickCreateAnotherExerciseLink() {
		Logger.info("Click on 'Create Another Exercise' link");
		createAnotherExerciseLink
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage clickTakeToJournalLink() {
		Logger.info("Click on 'Take to Journal' link");
		takeToJournalLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, FoodAndFitnessJournalPage.class);
	}

	public FoodAndFitnessJournalPage createExercises(int num) {
		Logger.info("Create exercises up to 3");
		for (int exerciseNumber = 1; exerciseNumber <= num; exerciseNumber++) {
			enterExerciseName("TestExercise_" + String.valueOf(exerciseNumber));
			enterDurationInMinute("30");
			selectNoAnswer();
			clickOnSubmitButton();
			checkSuccessMessageDisplayed();
			if (exerciseNumber == num) {
				clickTakeToJournalLink();
			} else {
				clickCreateAnotherExerciseLink();
			}
		}
		return PageFactory.initElements(basedriver, FoodAndFitnessJournalPage.class);
	}

	public CreateCustomExercisePage enterCaloriesBurnedValue(String calories) {
		Logger.info("Enter calories burned value");
		caloriesBurnedInputField
				.waitElementsReady()
				.type(calories);
		return this;
	}

	public CreateCustomExercisePage changeWhenValue(String day) {
		Logger.info("Change value in the 'When?' dropdown");
		whenDropDown
				.getElements()
				.parallelStream()
				.filter(opt -> opt.getText().equals(day))
				.findFirst()
				.get()
				.click();
		return this;
	}

	public CreateCustomExercisePage moveSlider() {
		Logger.info("Move slider");
		waitFor(1000);
		caloriesSlider.moveSlider(30, 0);
		return this;
	}

	public CreateCustomExercisePage rememberEstimatedCaloriesValue() {
		Logger.info("Remember Estimated Calories value");
		rememberEstimatedCalories = estimatedCalories.getText();
		return this;
	}

	public CreateCustomExercisePage chooseLogThisLaterOption() {
		Logger.info("Choose 'No I'll log this later' option");
		logThisLater.click();
		return this;
	}

	public CreateCustomExercisePage checkErrorMessageBlankNameField() {
		Logger.info("Check the error message is displayed when user leaves blank Exercise Name field");
		assertTrue(errorMessage.isVisible(), "The error message is not displayed");
		assertEquals(errorMessage.getText(), "Please enter the required fields: Exercise Name", "The error message is not correct");
		return this;
	}

	public CreateCustomExercisePage checkErrorMessageBlankDurationField() {
		Logger.info("Check the error message is displayed when user leaves blank 'How Long?' field");
		assertTrue(errorMessage.isVisible(), "The error message is not displayed");
		assertEquals(errorMessage.getText(), "Please enter the required fields: Valid Exercise Duration", "The error message is not correct");
		return this;
	}

	@Override
	public void waitForPageToLoad() {
		submitButton.waitUntilVisible();
	}
}
