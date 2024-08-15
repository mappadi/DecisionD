package mayoclinicdiet.pages;

import framework.Logger;
import framework.Settings;
import framework.platform.DatePatterns;
import framework.platform.Environment;
import framework.platform.html.WebObject;
import framework.platform.utilities.DateUtils;
import framework.platform.utilities.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class FoodAndFitnessJournalPage extends CreateCustomExercisePage {

	public FoodAndFitnessJournalPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "journal";
		String CLASS_NAME = "FoodAndFitnessJournalPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject foodAndFitnessJournalHeader;
	protected WebObject calendarDates;
	protected WebObject activeDate;
	protected WebObject calendar;
	protected WebObject recentWorkoutsTab;
	protected WebObject recentAmountOfWorkouts;
	protected WebObject exerciseModule;
	protected WebObject searchExercisesTab;
	protected WebObject myFavoritesTab;
	protected WebObject createByMeTab;
	protected WebObject returnToJournalTab;
	protected WebObject fatHeader;
	protected WebObject satFatHeader;
	protected WebObject cholHeader;
	protected WebObject sodHeader;
	protected WebObject carbHeader;
	protected WebObject fibHeader;
	protected WebObject proHeader;
	protected WebObject caloriesHeader;
	protected WebObject alphabetRow;
	protected WebObject letters;
	protected WebObject exerciseNames;
	protected WebObject noResultsMessage;
	protected WebObject quickResultModule;
	protected WebObject moreExerciseInfo;
	protected WebObject whenDropDown;
	protected WebObject howLongMinutesInputField;
	protected WebObject closeAddExerciseModuleLink;
	protected WebObject exerciseEntryNameContainer;
	protected WebObject searchForm;
	protected WebObject quickLogCaloriesEatenPopUpTitle;
	protected WebObject caloriesEatenField;
	protected WebObject consumedTextField;
	protected WebObject calorieBalance;
	protected WebObject consumedCaloriesTextField;
	protected WebObject addFoodButtonUnderFoodLog;
	protected WebObject foodInfoContainer;
	protected WebObject viewLinkInFoodContainer;
	protected WebObject editLinkInFoodContainer;
	protected WebObject copyLinkInFoodContainer;
	protected WebObject deleteLinkInFoodContainer;
	protected WebObject recipeDetailsPage;
	protected WebObject foodInJournalPopup;
	protected WebObject mealtimeInEditFoodInJournalPopup;
	protected WebObject servingSizeInputFieldInEditFoodInJournalPopup;
	protected WebObject fractSizeDropdownInEditFoodInJournalPopup;
	protected WebObject successMessage;
	protected WebObject itemCountForDinnerInFoodInfoContainer;
	protected WebObject servingsCountForDinnerInFoodInfoContainer;
	protected WebObject deleteConfirmationMessage;
	protected WebObject quicklogDropdownForExerciseLog;
	protected WebObject copyWorkout;
	protected WebObject caloriesBurnedForExerciseLog;
	protected WebObject addExerciseButton;
	protected WebObject browseExercisesOnA;
	protected WebObject firstExercise;
	protected WebObject addExerciseToJournal;
	protected WebObject exercisesName;
	protected WebObject howLongField;
	protected WebObject waterTrackerSection;
	protected WebObject waterCount;
	protected WebObject plusWater;
	protected WebObject minusWater;
	protected WebObject whenDropdownForCaloriesBurned;
	protected WebObject addButtonForCaloriesBurned;
	protected WebObject burnedCaloriesInQuickLogCaloriesBurned;
	protected WebObject myNotesSection;
	protected WebObject noteEditField;
	protected WebObject saveNoteButton;
	protected WebObject savedNoteMassage;
	protected WebObject addFoodModal;
	protected WebObject addMealPlanTab;
	protected WebObject searchFoodsTab;
	protected WebObject myFavoritesFoodTab;
	protected WebObject createdByMeFoodTab;
	protected WebObject dateTextField;
	protected Settings settings;
	protected WebObject deleteButton;
	protected WebObject mealDays;
	protected WebObject removeButtonForBreakfastSection;
	protected WebObject foodItemsInBreakfastSection;
	protected static String rememberConsumedCalories;
	protected static String rememberCalorieBalance;
	protected static String rememberCaloriesEaten;
	protected static String rememberExerciseName;
	protected static String rememberAmountOfWater;
	protected WebObject dateInAddMealPlanTab;
	protected WebObject mealContainerForBreakfast;
	protected WebObject mealContainerForAMSnack;
	protected WebObject mealContainerForLunch;
	protected WebObject mealContainerForPMSnack;
	protected WebObject mealContainerForDinner;
	protected WebObject viewLinkInAddMealPlan;
	protected WebObject searchFoodForm;
	protected WebObject quickListFood;
	protected WebObject moreFoodInfo;
	protected WebObject selectMealDropdown;
	protected WebObject whenFoodDropdown;
	protected WebObject servingSizeFood;
	protected WebObject itemOrServingDropdown;
	protected WebObject switchToLink;
	protected WebObject addFoodToJournalButton;
	protected WebObject foodServingSizeFraction;
	protected WebObject journalPageContent;
	protected WebObject consumedSection;
	protected WebObject burnedSection;
	protected WebObject addFoodButton;
	protected WebObject addExerciseLink;
	protected WebObject calorieBalanceSection;
	protected WebObject dailyBudget;
	protected WebObject calorieBalanceEditLink;
	protected WebObject nutritionAtGlance;
	protected WebObject nutritionCalories;
	protected WebObject nutritionFat;
	protected WebObject nutritionSatFat;
	protected WebObject nutritionCholesterol;
	protected WebObject nutritionSodium;
	protected WebObject nutritionCarbohydrates;
	protected WebObject nutritionFiber;
	protected WebObject nutritionProtein;
	protected WebObject changeYourCalorieRangeLink;
	protected WebObject nutritionQuestionLink;
	protected WebObject nutritionQuestionIFlyout;
	protected WebObject hideAllNutritionDetailsLink;
	protected WebObject amSnackIndividualMealCalorieBalance;
	protected WebObject amSnackTotalMealCalorieBalance;
	protected static String id;
	protected static Integer rememberFoodEntries;
	protected WebObject itemCountForBreakfastInFoodInfoContainer;
	protected WebObject servingsCountForBreakfastInFoodInfoContainer;
	protected WebObject createNewCustomFood;
	protected WebObject itemCountForAMSnackInFoodInfoContainer;
	protected WebObject nextDate;
	protected WebObject prevDate;
	protected WebObject calendarIcon;
	protected WebObject addMealTabActive;
	protected WebObject mealPlanContainer;
	public static String[] splited;
	protected static String selectedDate;
	protected WebObject addToJournalButton;
	protected WebObject searchFoodButton;
	protected WebObject autocompleteList;
	protected WebObject iconForFavorite;
	protected WebObject lettersOnFavoriteTab;
	protected WebObject foodTitleFavoriteTab;
	protected WebObject myFavoritesTabForFood;
	protected WebObject favoriteFoods;
	protected WebObject favoriteFoodCalories;
	protected WebObject favoriteFoodSource;
	protected WebObject quickListResultFavoritesTab;
	protected WebObject favoriteFoodCount;
	protected WebObject showAllLinkFavoriteTab;
	protected WebObject showFoodsLinkFavoriteTab;
	protected WebObject showRecipesLinkFavoriteTab;
	protected WebObject showMealsLinkFavoriteTab;
	protected WebObject favoriteFoodItems;
	protected WebObject noFavoriteItems;
	protected WebObject quicklogBreakfastButton;
	protected WebObject quicklogAMSnackButton;
	protected WebObject quicklogLunchButton;
	protected WebObject quicklogPMSnackButton;
	protected WebObject quicklogDinnerButton;
	protected WebObject quicklogSweetsButton;
	protected WebObject selectMealField;
	protected WebObject selectMealBreakfastOption;
	protected WebObject selectMealAMSnackOption;
	protected WebObject selectMealLunchOption;
	protected WebObject selectMealPMSnackOption;
	protected WebObject selectMealDinnerOption;
	protected WebObject selectMealSweetsOption;
	protected WebObject caloriesEatenBreakfastQuicklog;
	protected WebObject addCaloriesEatenButton;
	protected WebObject copyMealQuicklogOption;
	protected WebObject modalPopup;
	protected WebObject okButton;
	protected WebObject quickListExercise;
	protected WebObject addButton;
	protected WebObject deleteExercise;
	protected WebObject copyExerciseLink;
	protected static Integer rememberExerciseQuantity;
	protected WebObject editExerciseLink;
	protected WebObject durationField;
	protected WebObject exerciseDuration;
	protected WebObject addExerciseToFavoriteIcon;
	protected WebObject exerciseFromFavorites;
	protected static Integer rememberFavoritedExercisesQuantity;
	protected WebObject createNewCustomExercise;
	protected WebObject searchButton;
	protected WebObject recentlyAddedFavoritedExercise;
	protected WebObject recentlyAddedExercise;
	protected WebObject myFavoritesOnSearchTab;
	protected WebObject deleteCustomFood;
	protected WebObject favoritedExerciseFromRecentWorkoutTab;
	protected WebObject viewMoreFavoritesLink;
	protected WebObject myFavoritesTavSelected;
	protected WebObject activeLetters;
	protected WebObject exerciseItems;
	protected WebObject addWaterDisableButton;
	protected WebObject addToJournal;
	protected WebObject logItemLinkClose;
	protected WebObject exerciseFacts;
	protected WebObject subWaterDisableButton;
	protected WebObject moreExerciseInfoContainer;
	protected WebObject pmSnackAddToJournal;
	protected WebObject breakfastAddToJournal;
	protected WebObject amSnackAddToJournal;
	protected WebObject lunchAddToJournal;
	protected WebObject dinnerAddToJournal;
	protected WebObject foodName;
	protected WebObject defaultContentOfCreateByMeFoodTab;
	protected WebObject weightInputField;
	protected WebObject viewMoreCreateByMeExercise;
	protected WebObject createByMeExerciseTabActive;
	protected WebObject createByMeExerciseQuickList;
	protected WebObject createdByMeExerciseOnSearchTab;
	protected WebObject caloriesBurnedValueInMoreExerciseInfoContainer;
	protected WebObject nextArrowInDatePickerPopup;
	protected WebObject prevArrowInDatePickerPopup;
	protected WebObject addFoodToFavorite;
	protected static String rememberFoodName;

	public FoodAndFitnessJournalPage verifyFoodAndFitnessJournalHeader() {
		Logger.info("Check 'Food and Fitness Journal' header is presented");
		foodAndFitnessJournalHeader
				.waitUntilVisible()
				.click();
		boolean isFoodAndFitnessJournalHeaderPresent =
				foodAndFitnessJournalHeader
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isFoodAndFitnessJournalHeaderPresent, "User isn't taken to the Food & Fitness Journal Page. Header is absent!");
		return this;
	}

	public FoodAndFitnessJournalPage showCalendar() {
		Logger.info("Click Calendar icon");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		calendarIcon.clickWithJS();
		return this;
	}

	public FoodAndFitnessJournalPage calendarIsPresent() {
		Logger.info("Check 'Calendar' is presented");
		assertTrue(calendar.isVisible(), "Calendar is not visible");
		return this;
	}

	public FoodAndFitnessJournalPage chooseNextDate(String number) {
		Logger.info("Choose date in the calendar");
		if (number.equals("1")) {
			nextArrowInDatePickerPopup.click();
		}
		calendarDates
				.getElements()
				.parallelStream()
				.filter(date -> date.getText().equals(number))
				.findFirst()
				.get()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage choosePrevDate(String number) {
		Logger.info("Choose date in the calendar");
		calendar.scrollToElement();
		if (number.equals("31") || number.equals("30")) {
			prevArrowInDatePickerPopup.click();
		}
		calendarDates
				.getElements()
				.parallelStream()
				.filter(date -> date.getText().equals(number))
				.findFirst()
				.get()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkActiveDateCorrect(String expectedDate) {
		Logger.info("Check active date is correct");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String actualDate = activeDate
				.waitUntilVisible()
				.getText();
		assertTrue(actualDate.contains(expectedDate), "Journal date is wrong");
		return this;
	}

	public ProfileSettingsPage clickOnCalorieBalanceEditLink() {
		Logger.info("Click Calorie balance 'Edit' link");
		WebElement calorieBalanceEditLink = basedriver.findElement(By.cssSelector(".headline>a"));
		calorieBalanceEditLink.isDisplayed();
		withActions().click(calorieBalanceEditLink).perform();
		return PageFactory.initElements(basedriver, ProfileSettingsPage.class);
	}

	public FoodAndFitnessJournalPage clickOnAddExerciseLink() {
		Logger.info("Click 'Add exercise' link");
		addExerciseLink
				.waitElementsReady()
				.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public FoodAndFitnessJournalPage clickOnRecentWorkoutsTab() {
		Logger.info("Click on 'Recent Workouts' tab");
		recentWorkoutsTab
				.waitElementsReady()
				.clickWithJS();
		return this;
	}

	public FoodAndFitnessJournalPage verifyRecentWorkoutHeader() {
		Logger.info("Check 'Recent Workouts' header is presented");
		boolean isRecentWorkoutHeaderPresent =
				recentAmountOfWorkouts
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isRecentWorkoutHeaderPresent, "User isn't taken to the Recent Workouts Tab. Header is absent!");
		return this;
	}

	public FoodAndFitnessJournalPage checkExerciseModuleDisplayed() {
		Logger.info("Check Exercise Module is presented");
		waitFor(1000);
		boolean isExerciseModuleDisplayed =
				exerciseModule
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isExerciseModuleDisplayed, "Exercise module is not present");
		return this;
	}

	public FoodAndFitnessJournalPage checkSearchExercisesTabDisplayed() {
		Logger.info("Check 'Search Exercises' tab is presented");
		boolean isSearchExercisesTabDisplayed =
				searchExercisesTab
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isSearchExercisesTabDisplayed, "'Search Exercise' tab is not present");
		return this;
	}

	public FoodAndFitnessJournalPage checkRecentWorkoutsTabDisplayed() {
		Logger.info("Check 'Recent Workouts' tab is presented");
		boolean isRecentWorkoutsTabDisplayed =
				recentWorkoutsTab
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isRecentWorkoutsTabDisplayed, "'Resent Workouts' tab is not present");
		return this;
	}

	public FoodAndFitnessJournalPage checkMyFavoritesTabDisplayed() {
		Logger.info("Check 'My Favorite' tab is presented");
		boolean isMyFavoritesTabDisplayed =
				myFavoritesTab
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMyFavoritesTabDisplayed, "'My Favorite' tab is not present");
		return this;
	}

	public FoodAndFitnessJournalPage checkCreateByMeTabDisplayed() {
		Logger.info("Check 'Create By Me' tab is presented");
		boolean isCreateByMeTabDisplayed =
				createByMeTab
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isCreateByMeTabDisplayed, "'Create By Me' tab is not present");
		return this;
	}

	public FoodAndFitnessJournalPage checkReturnToJournalTabDisplayed() {
		Logger.info("Check 'Return To Journal' tab is presented");
		boolean isReturnToJournalTabDisplayed =
				returnToJournalTab
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isReturnToJournalTabDisplayed, "'Return To Journal' tab is not present");
		return this;
	}

	public FoodAndFitnessJournalPage clickOnMyFavoritesTab() {
		Logger.info("Click 'My Favorite' tab");
		myFavoritesTab
				.waitElementsReady()
				.clickWithJS();
		return this;
	}

	public FoodAndFitnessJournalPage verifyMyFavoritesHeader() {
		Logger.info("Check 'My Favorite' header is presented");
		boolean isMyFavoritedHeaderPresent =
				recentAmountOfWorkouts
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMyFavoritedHeaderPresent, "User isn't taken to the My Favorites Tab. Header is absent!");
		return this;
	}

	public FoodAndFitnessJournalPage clickOnReturnToJournalTab() {
		Logger.info("Click 'Return To Journal' link");
		returnToJournalTab
				.waitUntilVisible()
				.then()
				.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public FoodAndFitnessJournalPage clickOnCreatedByMeTab() {
		Logger.info("Click 'Create By Me' tab");
		createByMeTab.doubleClick();
		if (createNewCustomExercise.isVisible()) {
			return this;
		} else {
			createByMeTab.click();
		}
		return this;
	}

	public FoodAndFitnessJournalPage verifyCreatedByMeHeader() {
		Logger.info("Check 'Create By Me' header is presented");
		boolean isCreatedByMePresent =
				recentAmountOfWorkouts
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isCreatedByMePresent, "User isn't taken to the Created By Me Tab. Header is absent!");
		return this;
	}

	public FoodAndFitnessJournalPage clickOnShowAllNutritionDetailsLink() {
		Logger.info("Click 'Show All Nutrition Details' link");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		hideAllNutritionDetailsLink.click();
		return this;
	}

	public FoodAndFitnessJournalPage verifyNutritionHeadersPresence() {
		Logger.info("Check 'Fat' header is presented");
		boolean isFatHeaderVisible =
				fatHeader
						.waitUntilVisible()
						.isPresent();
		assertTrue(isFatHeaderVisible, "Fat header is absent!");

		Logger.info("Check 'Sat Fat' header is presented");
		boolean isSatFatHeaderVisible =
				satFatHeader
						.waitUntilVisible()
						.isPresent();
		assertTrue(isSatFatHeaderVisible, "Sat Fat header is absent!");

		Logger.info("Check 'Chol' header is presented");
		boolean isCholHeaderVisible =
				cholHeader
						.waitUntilVisible()
						.isPresent();
		assertTrue(isCholHeaderVisible, "Chol header is absent!");

		Logger.info("Check 'Sod' header is presented");
		boolean isSodHeaderVisible =
				sodHeader
						.waitUntilVisible()
						.isPresent();
		assertTrue(isSodHeaderVisible, "Sod header is absent!");

		Logger.info("Check 'Crb' header is presented");
		boolean isCrbHeaderVisible =
				carbHeader
						.waitUntilVisible()
						.isPresent();
		assertTrue(isCrbHeaderVisible, "Crb header is absent!");

		Logger.info("Check 'Fib' header is presented");
		boolean isFibHeaderVisible =
				fibHeader
						.waitUntilVisible()
						.isPresent();
		assertTrue(isFibHeaderVisible, "Fib header is absent!");

		Logger.info("Check 'Pro' header is presented");
		boolean isProHeaderVisible =
				proHeader
						.waitUntilVisible()
						.isPresent();
		assertTrue(isProHeaderVisible, "Pro header is absent!");

		Logger.info("Check 'Calories' header is presented");
		boolean isCaloriesHeaderVisible =
				caloriesHeader
						.waitUntilVisible()
						.isPresent();
		assertTrue(isCaloriesHeaderVisible, "Calories header is absent!");
		return this;
	}

	public FoodAndFitnessJournalPage verifyNutritionHeadersAbsence() {
		Logger.info("Check 'Fat' header is not presented");
		boolean isFatHeaderVisible =
				fatHeader
						.waitUntilVisible()
						.isPresent();
		assertFalse(isFatHeaderVisible, "Fat header is present!");

		Logger.info("Check 'Sat' header is not presented");
		boolean isSatFatHeaderVisible =
				satFatHeader
						.waitUntilVisible()
						.isPresent();
		assertFalse(isSatFatHeaderVisible, "Sat Fat header is present!");

		Logger.info("Check 'Chol' header is not presented");
		boolean isCholHeaderVisible =
				cholHeader
						.waitUntilVisible()
						.isPresent();
		assertFalse(isCholHeaderVisible, "Chol header is present!");

		Logger.info("Check 'Sod' header is not presented");
		boolean isSodHeaderVisible =
				sodHeader
						.waitUntilVisible()
						.isPresent();
		assertFalse(isSodHeaderVisible, "Sod header is present!");

		Logger.info("Check 'Crb' header is not presented");
		boolean isCrbHeaderVisible =
				carbHeader
						.waitUntilVisible()
						.isPresent();
		assertFalse(isCrbHeaderVisible, "Crb header is present!");

		Logger.info("Check 'Fib' header is not presented");
		boolean isFibHeaderVisible =
				fibHeader
						.waitUntilVisible()
						.isPresent();
		assertFalse(isFibHeaderVisible, "Fib header is present!");

		Logger.info("Check 'Pro' header is not presented");
		boolean isProHeaderVisible =
				proHeader
						.waitUntilVisible()
						.isPresent();
		assertFalse(isProHeaderVisible, "Pro header is present!");

		Logger.info("Check 'Calories' header is not presented");
		boolean isCaloriesHeaderVisible =
				caloriesHeader
						.waitUntilVisible()
						.isPresent();
		assertTrue(isCaloriesHeaderVisible, "Calories header is absent!");
		return this;
	}

	public FoodAndFitnessJournalPage clickOnLetterFromAlphabetRow(String letter) {
		Logger.info("Click on a letter from alphabet row on the Search Exercises tab");
		alphabetRow
				.getElements()
				.parallelStream()
				.filter(date -> date.getText().equals(letter))
				.findFirst()
				.get()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage chooseExerciseFromQuickList() {
		Logger.info("Choose exercise from quick list");
		quickListExercise.waitElementsReady().click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public FoodAndFitnessJournalPage verifyMoreExerciseInfoDisplayed() {
		Logger.info("Check 'More Exercise Info' module is presented");
		boolean isMoreExerciseInfoDisplayed =
				moreExerciseInfo
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMoreExerciseInfoDisplayed, "More Exercise Info is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage changeWhenValue(String day) {
		Logger.info("Change value in the 'When?' dropdown");
		whenDropDown
				.waitUntilVisible()
				.then()
				.selectByText(day);
		return this;
	}

	public FoodAndFitnessJournalPage checkValueWasChangedInWhenDropdown(String expectedDay) {
		Logger.info("Check value in the 'When?' dropdown");
		String expectedValue = expectedDay;
		String valueInDropdown =
				whenDropDown
						.getSelectedText();
		assertEquals(valueInDropdown, expectedValue, "Chosen value is not correct in the 'When?' dropdown");
		return this;
	}

	public FoodAndFitnessJournalPage typeMinutesValue(String minutes) {
		Logger.info("Enter minutes into the 'How Long?' input field");
		howLongMinutesInputField
				.waitUntilVisible()
				.then()
				.type(minutes);
		return this;
	}

	public FoodAndFitnessJournalPage checkMinutesValue(String minutes) {
		Logger.info("Check value in the 'How long?' input field");
		String expectedValue = minutes;
		String valueInTheField = howLongMinutesInputField.getValue();
		assertEquals(valueInTheField, expectedValue, "Minutes value is not correct in the 'How long?' input field");
		return this;
	}

	public FoodAndFitnessJournalPage clickAddButton() {
		Logger.info("Click 'Add' button");
		addButton
				.waitElementsReady()
				.clickWithJS();
		return this;
	}

	public FoodAndFitnessJournalPage clickCloseAddExerciseModule() {
		Logger.info("Close 'Add Exercise' module");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		closeAddExerciseModuleLink
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage clickNextDateArrow() {
		Logger.info("Navigate to next date");
		nextDate.waitUntilElementIsVisible();
		nextDate
				.waitElementsReady()
				.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public FoodAndFitnessJournalPage exerciseEntryNameContainerIsDisplayed() {
		Logger.info("Check exercise was added to the Exercise log");
		boolean isExerciseEntryNameContainerDisplayed =
				exerciseEntryNameContainer
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isExerciseEntryNameContainerDisplayed, "Exercise is not displayed in the Exercise log");
		return this;
	}

	public FoodAndFitnessJournalPage enterExerciseToSearchExercisesForm(String exercise) {
		Logger.info("Enter a search criteria to the Search exercises form");
		searchForm
				.waitUntilVisible()
				.then()
				.type(exercise);
		return this;
	}

	public FoodAndFitnessJournalPage clickSearchButton() {
		Logger.info("Click 'Search' button");
		autocompleteList
				.waitElementsReady()
				.clickOnElementNumber(1);
		searchButton.click();
		waitForAjaxRequestToBeFinished();
		quickResultModule.waitElementsReady();
		return this;
	}

	public FoodAndFitnessJournalPage clickOnEachLetter() {
		Logger.info("Verify the exercise names listed match the letter chosen");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		letters.getElements().forEach(chr -> {
			chr.click();
			quickResultModule.waitElementsReady();
			if (noResultsMessage.isPresent()) {
				return;
			}
			if (exerciseNames.isPresent()) {
				exerciseNames.waitUntilVisible();

				boolean isSortCorrect = exerciseNames
						.getElements()
						.parallelStream()
						.anyMatch(exr -> exr.getText().startsWith(chr.getText()));
				assertTrue(isSortCorrect, "The exercise names are not listed match the letter chosen");
			}
		});
		return this;
	}

	public FoodAndFitnessJournalPage clickOnCaloriesEatenButton() {
		Logger.info("Click 'QuickLog' button");
		waitFor(1000);
		quicklogBreakfastButton
				.waitElementsReady()
				.click();

		Logger.info("Click 'Calories Eaten' button");
		caloriesEatenBreakfastQuicklog
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage verifyQuickLogCaloriesEatenModalAppears() {
		Logger.info("Check 'QuickLog Calories Eaten Modal' title is presented");
		boolean isQuickLogCaloriesEatenModalDisplayed =
				quickLogCaloriesEatenPopUpTitle
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isQuickLogCaloriesEatenModalDisplayed, "More Exercise Info is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage enterCaloriesEaten() {
		Logger.info("Enter calories eaten amount");
		caloriesEatenField
				.waitUntilVisible()
				.type("120");
		return this;
	}

	public FoodAndFitnessJournalPage selectMeal(String meal) {
		Logger.info("Select meal");
		WebElement mealDropdown = basedriver.findElement(By.id("request_MealTypeId"));
		Select logMeal = new Select(mealDropdown);
		logMeal.selectByVisibleText(meal);
		return this;
	}

	public FoodAndFitnessJournalPage selectTime(String time) {
		Logger.info("Select time");
		WebElement timeDropdown = basedriver.findElement(By.id("request_JournalEntryDate"));
		Select logTime = new Select(timeDropdown);
		logTime.selectByVisibleText(time);
		return this;
	}

	public FoodAndFitnessJournalPage clickOnAddCaloriesEatenButton() {
		Logger.info("Click 'Add' button");
		addCaloriesEatenButton.click();
		addCaloriesEatenButton.waitUntilInvisible();
		return this;
	}

	public FoodAndFitnessJournalPage rememberValues() {
		consumedTextField.waitElementsReady();
		rememberConsumedCalories = consumedTextField.getText();
		rememberCalorieBalance = calorieBalance.getText();
		rememberCaloriesEaten = consumedCaloriesTextField.getText();
		return this;
	}

	public FoodAndFitnessJournalPage verifyCaloriesAddedToTheSections() {
		waitFor(3000);
		assertFalse(consumedTextField.getText().equals(rememberConsumedCalories), "Added calories and displayed calories are different in Consumed section!");
		Logger.info("Check added calories and displayed calories are the same in Consumed section");
		assertFalse(consumedCaloriesTextField.getText().equals(rememberCaloriesEaten), "Added calories and displayed calories are different in Food Log section!");
		Logger.info("Check added calories and displayed calories are the same in Food Log section");
		assertFalse(calorieBalance.getText().equals(rememberCalorieBalance), "Added calories and displayed calories are different in Calorie balance section!");
		Logger.info("Check added calories and displayed calories are the same in Calorie balance section");

		return this;
	}

	public FoodAndFitnessJournalPage clickAddFoodButtonUnderFoodLog() {
		Logger.info("Click 'Add Food' button under Food Log");
		addFoodButtonUnderFoodLog.clickOnElementNumber(1);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public FoodAndFitnessJournalPage clickAddToJournalButton() {
		Logger.info("Click 'Add To Journal' button");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1727");
		addToJournalButton.clickOnElementNumber(0);
		return this;
	}

	public FoodAndFitnessJournalPage checkFoodContainerPresented() {
		Logger.info("Check Food info container is presented");
		boolean isFoodContainerPresent = foodInfoContainer
				.waitUntilVisible()
				.then()
				.isPresent();
		assertTrue(isFoodContainerPresent, "Food info container is not present");
		return this;
	}

	public FoodAndFitnessJournalPage checkViewLinkIsPresented() {
		Logger.info("Check 'View' link  is presented");
		boolean isViewLinkPresent = viewLinkInFoodContainer
				.waitUntilVisible()
				.then()
				.isPresent();
		assertTrue(isViewLinkPresent, "'View' link is not present");
		return this;
	}

	public FoodAndFitnessJournalPage checkEditLinkIsPresented() {
		Logger.info("Check 'Edit' link  is presented");
		boolean isEditLinkPresent = editLinkInFoodContainer
				.waitUntilVisible()
				.then()
				.isPresent();
		assertTrue(isEditLinkPresent, "'Edit' link is not present");
		return this;
	}

	public FoodAndFitnessJournalPage checkCopyLinkIsPresented() {
		Logger.info("Check 'Copy' link  is presented");
		boolean isCopyLinkPresent = copyLinkInFoodContainer
				.waitUntilVisible()
				.then()
				.isPresent();
		assertTrue(isCopyLinkPresent, "'Copy' link is not present");
		return this;
	}

	public FoodAndFitnessJournalPage checkDeleteLinkIsPresented() {
		Logger.info("Check 'Delete' link  is presented");
		boolean isDeleteLinkPresent = deleteLinkInFoodContainer
				.waitUntilVisible()
				.then()
				.isPresent();
		assertTrue(isDeleteLinkPresent, "'Delete' link is not present");
		return this;
	}

	public FoodAndFitnessJournalPage clickViewLinkInFoodContainer() {
		Logger.info("Click 'view' link in food info container");
		WebElement viewLinkInFoodContainer = basedriver.findElement(By.cssSelector("a[class='view linktext']"));
		viewLinkInFoodContainer.isDisplayed();
		withActions().click(viewLinkInFoodContainer).perform();
		return this;
	}

	public FoodAndFitnessJournalPage clickEditLinkInFoodContainer() {
		Logger.info("Click 'Edit' link in food info container");
		WebElement editLinkInFoodContainer = basedriver.findElement(By.cssSelector("span[id^=edit]"));
		editLinkInFoodContainer.isDisplayed();
		withActions().click(editLinkInFoodContainer).perform();
		return this;
	}

	public FoodAndFitnessJournalPage clickCopyLinkInFoodContainer() {
		Logger.info("Click 'Copy' link in food info container");
		WebElement copyLinkInFoodContainer = basedriver.findElement(By.cssSelector(".copy.linktext"));
		copyLinkInFoodContainer.isDisplayed();
		withActions().click(copyLinkInFoodContainer).perform();
		return this;
	}

	public FoodAndFitnessJournalPage clickDeleteLinkInFoodContainer() {
		Logger.info("Click 'Delete' link in food info container");
		deleteLinkInFoodContainer
				.waitElementsReady()
				.clickWithJS();
		return this;
	}

	public FoodAndFitnessJournalPage checkRecipePageDisplayed() {
		Logger.info("Check recipe details page is displayed");
		boolean isRecipePageDisplayed = recipeDetailsPage
				.waitUntilVisible()
				.then()
				.isPresent();
		assertTrue(isRecipePageDisplayed, "Recipe details page is not present");
		return this;
	}

	public FoodAndFitnessJournalPage verifyFoodPopupDisplayed() {
		Logger.info("Check 'Edit Food in Journal' popup is displayed");
		boolean isEditFoodPopupDisplayed = foodInJournalPopup
				.waitUntilVisible()
				.isPresent();
		assertTrue(isEditFoodPopupDisplayed, "'Edit Food in Journal' popup is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage chooseMealtime(String mealtime) {
		Logger.info("Choose mealtime in 'Edit Food in Journal' popup");
		mealtimeInEditFoodInJournalPopup
				.getElements()
				.parallelStream()
				.filter(date -> date.getText().equals(mealtime))
				.findFirst()
				.get()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage enterServingSize(String serving) {
		Logger.info("Enter serving value");
		servingSizeInputFieldInEditFoodInJournalPopup
				.waitUntilVisible()
				.then()
				.type(serving);
		return this;
	}

	public FoodAndFitnessJournalPage chooseFractSize(String fractSize) {
		Logger.info("Choose Serving Size Fraction in 'Edit Food in Journal' popup");
		fractSizeDropdownInEditFoodInJournalPopup
				.getElements()
				.parallelStream()
				.filter(date -> date.getText().equals(fractSize))
				.findFirst()
				.get()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage clickSaveButton() {
		Logger.info("Click 'Save' button");
		WebElement saveButtonInEditFoodInJournalPopup = basedriver.findElement(By.cssSelector(".btn.save"));
		saveButtonInEditFoodInJournalPopup.isDisplayed();
		withActions().click(saveButtonInEditFoodInJournalPopup).perform();
		return this;
	}

	public FoodAndFitnessJournalPage checkSuccessMessageDisplayed() {
		Logger.info("Check success message is displayed");
		boolean isSuccessMsgDisplayed = successMessage
				.waitUntilVisible()
				.then()
				.isPresent();
		assertTrue(isSuccessMsgDisplayed, "Success message is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage clickOKButton() {
		Logger.info("Click 'Ok' button");
		okButton.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkDinnerItemCount(String item) {
		Logger.info("Check item count in food info container");
		itemCountForDinnerInFoodInfoContainer
				.getElements()
				.parallelStream()
				.filter(itm -> itm.getText().equals(item));
		return this;
	}

	public FoodAndFitnessJournalPage checkServings(String servings) {
		Logger.info("Check servings count in food info container");
		servingsCountForDinnerInFoodInfoContainer
				.getElements()
				.parallelStream()
				.filter(srv -> srv.getText().equals(servings));
		return this;
	}

	public FoodAndFitnessJournalPage checkDeleteConfirmationMessageDisplayed() {
		Logger.info("Delete confirmation message is displayed");
		boolean isDeleteConfirmMsgDisplayed = deleteConfirmationMessage
				.waitUntilVisible()
				.then()
				.isPresent();
		assertTrue(isDeleteConfirmMsgDisplayed, "Delete confirmation message is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage clickDeleteButton() {
		Logger.info("Click 'Delete' button");
		deleteButton
				.waitUntilVisible()
				.then()
				.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public FoodAndFitnessJournalPage checkFoodContainerNotPresented() {
		Logger.info("Check food info container is cleaned up");
		basedriver.navigate().refresh();
		assertFalse(foodInfoContainer.isPresent(), "Food info container is not cleaned up");
		return this;
	}

	public FoodAndFitnessJournalPage clickQuicklogDropdownForExerciseLog() {
		Logger.info("Click 'Quicklog' dropdown for Exercise Log");
		quicklogDropdownForExerciseLog
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage clickCaloriesBurnedOption() {
		Logger.info("Click 'Calories burned' option from Quicklog dropdown for Exercise Log");
		caloriesBurnedForExerciseLog
				.waitUntilVisible()
				.isPresent();
		caloriesBurnedForExerciseLog.click();
		return this;
	}

	public FoodAndFitnessJournalPage clickOnAddExerciseButton() {
		Logger.info("Click 'Add Exercise' button");
		addExerciseButton
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage clickOnFirstLetter() {
		Logger.info("Click on 'A' letter");
		browseExercisesOnA
				.waitUntilVisible()
				.isPresent();
		browseExercisesOnA.click();
		return this;
	}

	public FoodAndFitnessJournalPage clickOnFirstExercise() {
		Logger.info("Click on first exercise");
		waitForAjaxRequestToBeFinished();
		rememberExerciseName = firstExercise.getTextFromElementNumber(1);
		firstExercise.clickWithJS();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public FoodAndFitnessJournalPage clickOnAddExerciseToJournalButton() {
		Logger.info("Click 'Add' button");
		addExerciseToJournal
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage verifyExerciseWasAdded() {
		Logger.info("Check that exercise was added to the journal");
		basedriver.navigate().refresh();
		assertTrue(exercisesName.getText().contains(rememberExerciseName), "Exercise wasn't added");
		return this;
	}

	public FoodAndFitnessJournalPage selectExerciseDate(String date) {
		Logger.info("Select exercise date");
		WebElement dateDropdown = basedriver.findElement(By.id("exerciseDate"));
		Select exerciseDate = new Select(dateDropdown);
		exerciseDate.selectByVisibleText(date);
		return this;
	}

	public FoodAndFitnessJournalPage enterExerciseDuration(String time) {
		Logger.info("Enter exercise duration");
		howLongField
				.waitUntilVisible()
				.type(time);
		return this;
	}

	public FoodAndFitnessJournalPage verifyWaterTrackerSectionPresent() {
		Logger.info("Check Water Tracker section is displayed");
		boolean isWaterTrackerSectionDisplayed =
				waterTrackerSection
						.waitUntilVisible()
						.then()
						.isPresent();
		assertTrue(isWaterTrackerSectionDisplayed, "Water Tracker section is not displayed");
		rememberAmountOfWater = waterCount.getText();
		return this;
	}

	public FoodAndFitnessJournalPage plusWaterAmount() {
		Logger.info("Plus water amount");
		plusWater
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage verifyWaterAmountIncreased() {
		Logger.info("Check that amount of water increased");
		assertFalse(waterCount.getText().equals(rememberAmountOfWater), "Amount of water didn't increase!");
		return this;
	}

	public FoodAndFitnessJournalPage minusWaterAmount() {
		Logger.info("Minus water amount");
		minusWater
				.waitUntilVisible()
				.then()
				.click();
		rememberAmountOfWater = waterCount.getText();
		return this;
	}

	public FoodAndFitnessJournalPage verifyWaterAmountDecreased() {
		Logger.info("Check that amount of water decreased");
		assertTrue(waterCount.getText().equals(rememberAmountOfWater), "Amount of water didn't decrease!");
		return this;
	}

	public FoodAndFitnessJournalPage enterCaloriesBurned(String calories) {
		Logger.info("Enter calories burned");
		caloriesEatenField
				.waitUntilVisible()
				.then()
				.type(calories);
		return this;
	}

	public FoodAndFitnessJournalPage chooseWhenCaloriesBurned(String day) {
		Logger.info("Click 'Calories burned' option from Quicklog dropdown for Exercise Log");
		whenDropdownForCaloriesBurned
				.getElements()
				.parallelStream()
				.filter(opt -> opt.getText().equals(day))
				.findFirst()
				.get()
				.click();
		waitFor(1000);
		return this;
	}

	public FoodAndFitnessJournalPage clickOnAddButtonForCaloriesBurned() {
		Logger.info("Click 'Add' button");
		addButtonForCaloriesBurned
				.waitUntilVisible()
				.then()
				.click();
		waitFor(1000);
		return this;
	}

	public FoodAndFitnessJournalPage checkBurnedCaloriesDisplayed() {
		Logger.info("Check Burned calories are displayed");
		boolean isBurnedCaloriesDisplayed = burnedCaloriesInQuickLogCaloriesBurned
				.waitUntilVisible()
				.then()
				.isPresent();
		assertTrue(isBurnedCaloriesDisplayed, "Burned calories are not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage verifyMyNotesSectionPresent() {
		Logger.info("Check My Notes section is displayed");
		boolean isMyNotesSectionDisplayed =
				myNotesSection
						.waitUntilVisible()
						.then()
						.isPresent();
		assertTrue(isMyNotesSectionDisplayed, "My Notes section is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage enterNoteText() {
		Logger.info("Enter note text");
		noteEditField.clear();
		noteEditField
				.waitUntilVisible()
				.type("Test note text.");
		return this;
	}

	public FoodAndFitnessJournalPage clickOnSaveNoteButton() {
		Logger.info("Click 'Save' button");
		saveNoteButton
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage verifySavedNoteMessagePresent() {
		Logger.info("Check Saved note message is displayed");
		boolean isSavedNoteMessageDisplayed =
				savedNoteMassage
						.waitUntilVisible()
						.then()
						.isPresent();
		assertTrue(isSavedNoteMessageDisplayed, "Saved note message is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage verifyNoteFieldIsNotEmpty() {
		Logger.info("Check Note field is not empty");
		basedriver.navigate().refresh();
		assertTrue(noteEditField.getText().contains("Test note text."), "Note field is empty!");
		return this;
	}

	public FoodAndFitnessJournalPage checkTwoOptionsArePresentInQuickLogForExerciseLog() {
		Logger.info("Check two options are presented in QuickLog dropdown for Exercise Log");
		boolean isCaloriesBurnedPresent = caloriesBurnedForExerciseLog
				.waitUntilVisible()
				.then()
				.isPresent();
		assertTrue(isCaloriesBurnedPresent, "Burned calories are not displayed");
		boolean isCopyWorkoutPresent = copyWorkout
				.waitUntilVisible()
				.then()
				.isPresent();
		assertTrue(isCopyWorkoutPresent, "Burned calories are not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage clickBackBrowserButton() {
		Logger.info("Click 'Back' browser button");
		basedriver.navigate().back();
		return this;
	}

	public FoodAndFitnessJournalPage clickOnAddFoodButton() {
		Logger.info("Click 'Add Food' button");
		addFoodButton.waitUntilVisible().clickWithJS();
		return this;
	}

	public FoodAndFitnessJournalPage verifyAddFoodModalPresent() {
		Logger.info("Check Add food modal is displayed");
		boolean isAddFoodModalPresent =
				addFoodModal
						.waitUntilVisible()
						.then()
						.isPresent();
		assertTrue(isAddFoodModalPresent, "Add food modal is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage verifyAddMealPlanTabPresent() {
		Logger.info("Check Add meal plan tab is displayed");
		boolean isAddMealPlanTabPresent =
				addMealPlanTab
						.waitUntilVisible()
						.then()
						.isPresent();
		assertTrue(isAddMealPlanTabPresent, "Add meal plan tab is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage verifySearchFoodTabPresent() {
		Logger.info("Check Search foods tab is displayed");
		boolean isSearchFoodTabPresent =
				searchFoodsTab
						.waitUntilVisible()
						.then()
						.isPresent();
		assertTrue(isSearchFoodTabPresent, "Search foods tab is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage verifyMyFavoritesTabPresent() {
		Logger.info("Check My favorites tab is displayed");
		boolean isMyFavoritesTabPresent =
				myFavoritesFoodTab
						.waitUntilVisible()
						.then()
						.isPresent();
		assertTrue(isMyFavoritesTabPresent, "My Favorites tab is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage verifyCreatedByMeTabPresent() {
		Logger.info("Check Created By Me tab is displayed");
		boolean isCreatedByMeTabPresent =
				createdByMeFoodTab
						.waitUntilVisible()
						.then()
						.isPresent();
		assertTrue(isCreatedByMeTabPresent, "Created By Me tab is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage verifyAddMealPlaneTodayDate() {
		Logger.info("Check today's date corresponds date on the tab");
		String currDate = new SimpleDateFormat("MMMMMMMMM d, yyyy").format(new Date());
		assertEquals(dateTextField.getText(), currDate, "Displayed date is incorrect ");
		return this;
	}

	public FoodAndFitnessJournalPage verifyWeekDays() {
		Logger.info("Check dates on tab correspond correct calendar dates");
		mealDays.getElements().forEach(elem -> {
			elem.click();
			try {
				String propValue = elem.getAttribute("mealplandate");
				String mealPlanDate = new SimpleDateFormat("MMMMMMMMM d, yyyy").format(new SimpleDateFormat("MM-dd-yyyy").parse(propValue));
				assertEquals(dateTextField.waitUntilVisible().getText(), mealPlanDate, "Displayed date is incorrect for Monday");
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
		});
		return this;
	}

	public FoodAndFitnessJournalPage checkDateInAddMealTab(String expectedDate) {
		Logger.info("Check date in the 'Add Meal Plan' tab");
		String todaysDate = dateInAddMealPlanTab
				.waitUntilVisible()
				.getText();
		assertEquals(todaysDate, expectedDate, "Date is not correct");
		return this;
	}

	public FoodAndFitnessJournalPage checkCategoriesInAddMealPlanTab() {
		Logger.info("Check Breakfast category is displayed");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1727");
		boolean isBreackfastCategoryDisplayed =
				mealContainerForBreakfast
						.waitUntilVisible()
						.isPresent();
		assertTrue(isBreackfastCategoryDisplayed, "Breakfast category is not displayed");

		Logger.info("Check AM Snack category is displayed");
		boolean isAMSnackCategoryDisplayed =
				mealContainerForAMSnack
						.waitUntilVisible()
						.isPresent();
		assertTrue(isAMSnackCategoryDisplayed, "AM Snack category is not displayed");

		Logger.info("Check Lunch category is displayed");
		boolean isLunchCategoryDisplayed =
				mealContainerForLunch
						.waitUntilVisible()
						.isPresent();
		assertTrue(isLunchCategoryDisplayed, "Lunch category is not displayed");

		Logger.info("Check PM Snack category is displayed");
		boolean isPMSnackCategoryDisplayed =
				mealContainerForPMSnack
						.waitUntilVisible()
						.isPresent();
		assertTrue(isPMSnackCategoryDisplayed, "PM Snack category is not displayed");

		Logger.info("Check Dinner category is displayed");
		boolean isDinnerCategoryDisplayed =
				mealContainerForDinner
						.waitUntilVisible()
						.isPresent();
		assertTrue(isDinnerCategoryDisplayed, "Dinner category is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage clickAddToJournalForBreakfast() {
		Logger.info("Click 'Add To Journal' button for Breakfast section");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1727");
		breakfastAddToJournal.waitElementsReady();
		breakfastAddToJournal.clickOnElementNumber(1);
		checkDeleteLinkIsPresented();
		return this;
	}

	public FoodAndFitnessJournalPage clickAddToJournalForAMSnack() {
		Logger.info("Click 'Add To Journal' button for AM Snack section");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1727");
		amSnackAddToJournal.waitElementsReady();
		amSnackAddToJournal.clickOnElementNumber(1);
		checkDeleteLinkIsPresented();
		return this;
	}

	public FoodAndFitnessJournalPage clickAddToJournalForLunch() {
		Logger.info("Click 'Add To Journal' button for Lunch section");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1727");
		lunchAddToJournal.waitElementsReady();
		lunchAddToJournal.clickOnElementNumber(1);
		checkDeleteLinkIsPresented();
		return this;
	}

	public FoodAndFitnessJournalPage clickAddToJournalForPMSnack() {
		Logger.info("Click 'Add To Journal' button for PM Snack section");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1727");
		pmSnackAddToJournal.waitElementsReady();
		pmSnackAddToJournal.clickOnElementNumber(1);
		checkDeleteLinkIsPresented();
		return this;
	}

	public FoodAndFitnessJournalPage clickAddToJournalForDinner() {
		Logger.info("Click 'Add To Journal' button for Dinner section");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1727");
		dinnerAddToJournal.waitElementsReady();
		dinnerAddToJournal.clickOnElementNumber(1);
		checkDeleteLinkIsPresented();
		return this;
	}

	public DailyMealPlannerPage clickViewLink() {
		Logger.info("Click 'VIEW' link");
		viewLinkInAddMealPlan
				.waitUntilVisible()
				.click();
		return PageFactory.initElements(basedriver, DailyMealPlannerPage.class);
	}

	public FoodAndFitnessJournalPage clickRemoveFromJournalForBreakfast() {
		Logger.info("Click 'Remove' button for Breakfast section");
		basedriver.findElement(By.cssSelector(".meal-plan-container>div:nth-of-type(1)")).findElement(By.cssSelector("span[id^='delete']")).click();
		return this;
	}

	public FoodAndFitnessJournalPage checkRemoveButtonConvertedIntoAddToJournalButton() {
		Logger.info("Check Remove button is not displayed for Breakfast section");
		assertFalse(removeButtonForBreakfastSection.isElementPresent(), "'Remove' button is still present!");
		return this;
	}

	public FoodAndFitnessJournalPage checkFoodItemsAreNotDisplayedInJournal() {
		Logger.info("Check food items are not displayed for Breakfast section");
		assertFalse(foodItemsInBreakfastSection.isElementPresent(), "Food items are still present in Journal!");
		return this;
	}

	public FoodAndFitnessJournalPage clickOnMyFavoritesTabFromAddFoodModal() {
		Logger.info("Click 'My favotites' tab");
		myFavoritesFoodTab
				.waitUntilVisible()
				.clickWithJS();
		return this;
	}

	public FoodAndFitnessJournalPage clickSearchFoodTab() {
		Logger.info("Click 'Search Food' tab");
		searchFoodsTab
				.waitUntilVisible()
				.clickWithJS();
		return this;
	}

	public FoodAndFitnessJournalPage checkSearchFoodFormDisplayed() {
		Logger.info("Check Search food form is displayed");
		boolean isSearchFoodFormDisplayed = searchFoodForm
				.waitUntilVisible()
				.isVisible();
		assertTrue(isSearchFoodFormDisplayed, "Search food form is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage enterFoodToSearchFoodForm(String food) {
		Logger.info("Enter a search criteria to the Search food form");
		searchFoodForm
				.waitUntilVisible()
				.then()
				.type(food);
		return this;
	}

	public FoodAndFitnessJournalPage clickSearchFoodButton() {
		Logger.info("Click 'Search' button");
		searchFoodButton
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage chooseFoodFromQuickList() {
		Logger.info("Choose food from quick list");
		quickListFood.waitUntilVisible();
		quickListFood.clickOnElementNumber(0);
		return this;
	}

	public FoodAndFitnessJournalPage verifyMoreFoodInfoDisplayed() {
		Logger.info("Check 'More Food Info' module is presented");
		boolean isMoreFoodInfoDisplayed =
				moreFoodInfo
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMoreFoodInfoDisplayed, "More Food Info is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage changeWhenValueForFood(String day) {
		Logger.info("Change value in the 'When?' dropdown");
		whenFoodDropdown
				.waitUntilVisible()
				.then()
				.selectByText(day);
		return this;
	}

	public FoodAndFitnessJournalPage changeSelectMealValue(String meal) {
		Logger.info("Change value in the 'Select Meal' dropdown");
		selectMealDropdown
				.waitUntilVisible()
				.then()
				.selectByText(meal);
		return this;
	}

	public FoodAndFitnessJournalPage typeHowMuchFoodValue(String meal) {
		Logger.info("Change value in the 'How mach?' input field");
		servingSizeFood
				.waitUntilVisible()
				.clear();
		servingSizeFood.type(meal);
		return this;
	}

	public FoodAndFitnessJournalPage checkHowMuchFoodValue(String value) {
		Logger.info("Check value in the 'How much?' input field");
		String expectedValue = value;
		assertEquals(servingSizeFood.getValue(), expectedValue, "'How much' value is not correct in the 'How much?' input field");
		return this;
	}

	public FoodAndFitnessJournalPage chooseServingsInDropdown() {
		Logger.info("Change value in the 'item(s)/serving(s)' dropdown");
		itemOrServingDropdown
				.waitUntilVisible()
				.then()
				.selectByText("serving(s)");
		return this;
	}

	public FoodAndFitnessJournalPage clickSwitchToLink() {
		Logger.info("Click 'switch to...' link");
		switchToLink
				.waitUntilVisible()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage selectFractionFoodValue(String fraction) {
		Logger.info("Change value in the 'Fraction Food Size' dropdown");
		foodServingSizeFraction
				.waitUntilVisible()
				.then()
				.selectByText(fraction);
		return this;
	}

	public FoodAndFitnessJournalPage clickAddFoodButton() {
		Logger.info("Click 'Add' button");
		addFoodToJournalButton
				.waitUntilVisible()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkAddToJournalEntriesForLunchDisplayed() {
		Logger.info("Check food item is displayed for Lunch section");
		basedriver.findElement(By.cssSelector("#journalitems_2 .foodInfoContainer")).isDisplayed();
		return this;
	}

	public FoodAndFitnessJournalPage clickOnCreatedByMeTabFromAddFoodModal() {
		Logger.info("Click 'Created by Me' tab");
		createdByMeFoodTab
				.waitUntilVisible()
				.doubleClick();
		waitFor(1000);
		if (createNewCustomFood.isVisible()) {
			return this;
		} else {
			createdByMeFoodTab.click();
		}
		return this;
	}

	public FoodAndFitnessJournalPage checkAddToJournalEntriesForBreakfastDisplayed() {
		Logger.info("Check food item is displayed for Breakfast section");
		basedriver.findElement(By.cssSelector("#journalitems_1 .foodInfoContainer")).isDisplayed();
		return this;
	}

	public FoodAndFitnessJournalPage checkAddToJournalEntriesForAMSnackDisplayed() {
		Logger.info("Check food item is displayed for AM Snack section");
		basedriver.findElement(By.cssSelector("#journalitems_5 .foodInfoContainer")).isDisplayed();
		return this;
	}

	public FoodAndFitnessJournalPage checkAddToJournalEntriesForPMSnackDisplayed() {
		Logger.info("Check food item is displayed for PM Snack section");
		basedriver.findElement(By.cssSelector("#journalitems_6 .foodInfoContainer")).isDisplayed();
		return this;
	}

	public FoodAndFitnessJournalPage checkAddToJournalEntriesForDinnerDisplayed() {
		Logger.info("Check food item is displayed for Dinner section");
		basedriver.findElement(By.cssSelector("#journalitems_4 .foodInfoContainer")).isDisplayed();
		return this;
	}

	public FoodAndFitnessJournalPage clickAddFoodToSweetsButton() {
		Logger.info("Click 'Add Food' button for 'Sweets' container");
		WebElement addFoodToSweetsButton = basedriver.findElement(By.cssSelector("#mealtotals_7 .btn.mcc.addfood"));
		addFoodToSweetsButton.isDisplayed();
		withActions().click(addFoodToSweetsButton).build().perform();
		return this;
	}

	public FoodAndFitnessJournalPage checkAddToJournalEntriesForSweetsDisplayed() {
		Logger.info("Check food item is displayed for Sweets section");
		basedriver.findElement(By.cssSelector("#journalitems_7 .foodInfoContainer")).isDisplayed();
		return this;
	}

	public FoodAndFitnessJournalPage checkJournalPageContentDisplayed() {
		Logger.info("Check the journal page content is displayed");
		boolean isContentDisplayed = journalPageContent
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isContentDisplayed, "The FF journal page content is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkCalendarIconDisplayed() {
		Logger.info("Check the calendar icon is displayed");
		WebElement calendarIcon = basedriver.findElement(By.cssSelector(".select-date"));
		assertTrue(calendarIcon.isDisplayed(), "The calendar icon is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage clickBackwardArrow() {
		Logger.info("Navigate to backward date");
		prevDate.waitUntilElementIsVisible();
		prevDate
				.waitElementsReady()
				.clickWithJS();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public FoodAndFitnessJournalPage checkConsumedSectionDisplayed() {
		Logger.info("Check the Consumed calorie section is displayed");
		boolean isConsumedSectionDisplayed = consumedSection
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isConsumedSectionDisplayed, "The Consumed calorie section is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkBurnedSectionDisplayed() {
		Logger.info("Check the Burned calorie section is displayed");
		boolean isBurnedSectionDisplayed = burnedSection
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isBurnedSectionDisplayed, "The Burned calorie section is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkAddFoodButtonDisplayed() {
		Logger.info("Check the Add Food button is displayed under the Consumed calorie");
		boolean isAddFoodButtonDisplayed = addFoodButton
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isAddFoodButtonDisplayed, "The Add Food button is not displayed under the Consumed calorie correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkAddExerciseButtonDisplayed() {
		Logger.info("Check the Add Exercise button is displayed under the Burned calorie");
		boolean isAddExerciseButtonDisplayed = addExerciseLink
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isAddExerciseButtonDisplayed, "The Add Exercise button is not displayed under the Burned calorie correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkCalorieBalanceSectionDisplayed() {
		Logger.info("Check the Calorie Balance section is displayed");
		boolean isCalorieBalanceSectionDisplayed = calorieBalanceSection
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isCalorieBalanceSectionDisplayed, "The Calorie Balance section is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkDailyBudgetDisplayed() {
		Logger.info("Check the Daily Budget is displayed");
		boolean isDailyBudgetDisplayed = dailyBudget
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isDailyBudgetDisplayed, "The Daily Budget is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkEditCalorieBalanceLinkDisplayed() {
		Logger.info("Check the Edit Calorie Balance Link is displayed");
		boolean isEditCalorieBalanceLinkDisplayed = calorieBalanceEditLink
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isEditCalorieBalanceLinkDisplayed, "The Edit Calorie Balance Link is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkNutritionAtGlanceModuleDisplayed() {
		Logger.info("Check the Nutrition At A Glance module is displayed");
		boolean isNutritionAtGlanceModuleDisplayed = nutritionAtGlance
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isNutritionAtGlanceModuleDisplayed, "The Nutrition At A Glance module is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkNutritionCaloriesDisplayed() {
		Logger.info("Check the Nutrition calories value is displayed");
		boolean isNutritionCaloriesValueDisplayed = nutritionCalories
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isNutritionCaloriesValueDisplayed, "The Nutrition calories value is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkNutritionFatDisplayed() {
		Logger.info("Check the Nutrition fat value is displayed");
		boolean isNutritionFatValueDisplayed = nutritionFat
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isNutritionFatValueDisplayed, "The Nutrition fat value is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkNutritionSatFatDisplayed() {
		Logger.info("Check the Nutrition Saturated fat value is displayed");
		boolean isNutritionSaturatedFatValueDisplayed = nutritionSatFat
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isNutritionSaturatedFatValueDisplayed, "The Nutrition Saturated fat value is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkNutritionCholesterolDisplayed() {
		Logger.info("Check the Nutrition Cholesterol value is displayed");
		boolean isNutritionCholesterolValueDisplayed = nutritionCholesterol
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isNutritionCholesterolValueDisplayed, "The Nutrition Cholesterol value is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkNutritionSodiumDisplayed() {
		Logger.info("Check the Nutrition Sodium value is displayed");
		boolean isNutritionSodiumValueDisplayed = nutritionSodium
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isNutritionSodiumValueDisplayed, "The Nutrition Sodium value is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkNutritionCarbohydratesDisplayed() {
		Logger.info("Check the Nutrition Carbohydrates value is displayed");
		boolean isNutritionCarbohydratesValueDisplayed = nutritionCarbohydrates
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isNutritionCarbohydratesValueDisplayed, "The Nutrition Carbohydrates value is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkNutritionFiberDisplayed() {
		Logger.info("Check the Nutrition Fiber value is displayed");
		boolean isNutritionFiberValueDisplayed = nutritionFiber
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isNutritionFiberValueDisplayed, "The Nutrition Fiber value is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkNutritionProteinDisplayed() {
		Logger.info("Check the Nutrition Protein value is displayed");
		boolean isNutritionProteinValueDisplayed = nutritionProtein
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isNutritionProteinValueDisplayed, "The Nutrition Protein value is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkChangeYourCalorieRangeLinkDisplayed() {
		Logger.info("Check the 'Change Your Calorie Range' link is displayed");
		boolean isChangeYourCalorieRangeLinkDisplayed = changeYourCalorieRangeLink
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isChangeYourCalorieRangeLinkDisplayed, "The 'Change Your Calorie Range' link is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkNutritionQuestionDisplayed() {
		Logger.info("Check the 'What does the blue and gold bar mean?' question is displayed");
		boolean isNutritionQuestionDisplayed = nutritionQuestionLink
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isNutritionQuestionDisplayed, "The 'What does the blue and gold bar mean?' question is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkNutritionQuestionIFlyoutDisplayed() {
		Logger.info("Check the 'i' flyout is displayed");
		boolean isNutritionQuestionIFlyoutDisplayed = nutritionQuestionIFlyout
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isNutritionQuestionIFlyoutDisplayed, "The the 'i' flyout is not displayed correctly");
		return this;
	}

	public FoodAndFitnessJournalPage checkShowAllNutritionDetailsDisplayed() {
		Logger.info("Check 'Show all nutrition details' is displayed");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean isShowAllNutritionDetailsLink = hideAllNutritionDetailsLink
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isShowAllNutritionDetailsLink, "'Show all nutrition details' is not displayed");
		assertEquals(hideAllNutritionDetailsLink.getText(), "SHOW ALL NUTRITION DETAILS", "'SHOW ALL NUTRITION DETAILS' text is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage checkHideAllNutritionDetailsDisplayed() {
		Logger.info("Check 'Hide all nutrition details' is displayed");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean isHideAllNutritionDetailsLink = hideAllNutritionDetailsLink
				.waitElementsReady()
				.isElementPresent();
		assertTrue(isHideAllNutritionDetailsLink, "'Hide all nutrition details' is not displayed");
		assertEquals(hideAllNutritionDetailsLink.getText(), "HIDE ALL NUTRITION DETAILS", "'HIDE ALL NUTRITION DETAILS' text is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage rememberAMCaloriesValues() {
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		rememberConsumedCalories = consumedTextField.getText();
		return this;
	}

	public FoodAndFitnessJournalPage verifyCaloriesAddedToAMSnackSections() {
		basedriver.navigate().refresh();
		Logger.info("Check individual meal calories are added and displayed in AM Snack section");
		assertFalse(amSnackIndividualMealCalorieBalance.getText().equals(rememberConsumedCalories), "The individual calorie log of each food is not displayed");
		Logger.info("Check total meal calories are added and displayed in AM Snack section");
		assertFalse(amSnackTotalMealCalorieBalance.getText().equals(rememberConsumedCalories), "The total calories are not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage checkShowAllNutritionDetailsLinkDisplayed() {
		Logger.info("Check 'Show All Nutrition details' link is displayed");
		if (hideAllNutritionDetailsLink.getText().contains("SHOW ALL NUTRITION DETAILS")) {
			return this;
		} else {
			hideAllNutritionDetailsLink.click();
		}
		return this;
	}

	public FoodAndFitnessJournalPage checkHideAllNutritionDetailsLinkDisplayed() {
		Logger.info("Check 'Hide All Nutrition details' link is displayed");
		hideAllNutritionDetailsLink.waitElementsReady();
		if (hideAllNutritionDetailsLink.getText().contains("HIDE ALL NUTRITION DETAILS")) {
			return this;
		} else {
			hideAllNutritionDetailsLink.click();
		}
		return this;
	}

	public FoodAndFitnessJournalPage checkJournalEmpty() {
		Logger.info("Check journal is empty");
		if (!Settings.isEnvironment(Environment.PROD)) {
			return this;
		} else {
			basedriver.navigate().refresh();
			if (deleteLinkInFoodContainer.isElementPresent()) {
				List<WebElement> deleteLinks = deleteLinkInFoodContainer.getElements();
				for (WebElement deleteLink : deleteLinks) {
					deleteLink.click();
					waitFor(1000);
					clickDeleteButton();
				}
			}
			return this;
		}
	}

	public FoodAndFitnessJournalPage rememberFoodEntries() {
		rememberFoodEntries = foodInfoContainer.getElementsCount();
		return this;
	}

	public FoodAndFitnessJournalPage verifyFoodEntries() {
		basedriver.navigate().refresh();
		Logger.info("Check food item was added to journal");
		Integer foodEntries = foodInfoContainer.getElementsCount();
		assertFalse(foodEntries.equals(rememberFoodEntries), "The food item was not added to journal");
		return this;
	}

	public FoodAndFitnessJournalPage checkItemCountBreakfast(String item) {
		Logger.info("Check item count in food info container");
		itemCountForBreakfastInFoodInfoContainer
				.getElements()
				.parallelStream()
				.filter(itm -> itm.getText().equals(item));
		return this;
	}

	public FoodAndFitnessJournalPage checkServingsBreakfast(String servings) {
		Logger.info("Check servings count in food info container");
		servingsCountForBreakfastInFoodInfoContainer
				.getElements()
				.parallelStream()
				.filter(srv -> srv.getText().equals(servings));
		return this;
	}

	public CreateCustomFoodPage clickCreateNewCustomFoodLink() {
		Logger.info("Click on 'Create a New Custom Food' link");
		waitFor(2000); // need for tab content loading
		createNewCustomFood.clickWithJS();
		return PageFactory.initElements(basedriver, CreateCustomFoodPage.class);
	}

	public FoodAndFitnessJournalPage checkItemCountAMSnack(String item) {
		Logger.info("Check item count in food info container");
		itemCountForAMSnackInFoodInfoContainer
				.getElements()
				.parallelStream()
				.filter(itm -> itm.getText().equals(item));
		return this;
	}

	public FoodAndFitnessJournalPage checkAddMealPlanTabOpen() {
		Logger.info("Check Add Meal Plan tab is opened by default");
		boolean isAddMealPlanTabActive = addMealTabActive
				.waitElementsReady()
				.isPresent();
		assertTrue(isAddMealPlanTabActive, "Add Meal Plan tab is not opened");
		return this;
	}

	public FoodAndFitnessJournalPage verifyMealPlanForEachWeekDay() {
		Logger.info("Check Meal Plan container is displayed for each weekday");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1727");
		mealDays.getElements().forEach(elem -> {
			elem.click();
			assertTrue(mealPlanContainer.isPresent(), "Meal Plan container is not displayed");
		});
		return this;
	}

	public FoodAndFitnessJournalPage splitDateRange() {
		Logger.info("Split date range");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1727");
		dateInAddMealPlanTab.waitUntilVisible();
		splited = dateInAddMealPlanTab.getText().split("\\s+");
		return this;
	}

	public FoodAndFitnessJournalPage selectDayInAddMealPlanTab() {
		Logger.info("Select day in Add Meal Plan tab");
		mealDays.clickOnElementNumber(4);
		return this;
	}

	public FoodAndFitnessJournalPage rememberDate() {
		selectedDate = splited[1].replaceAll("[\\,]", "").toString();
		return this;
	}

	public FoodAndFitnessJournalPage chooseSelectedDate() {
		Logger.info("Choose selected date in the calendar");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (selectedDate.equals("1") && !selectedDate.equals(DateUtils.getCurrentDate(DatePatterns.dd))) {
			nextArrowInDatePickerPopup.click();
		}
		if (selectedDate.equals("31") || selectedDate.equals("30")) {
			prevArrowInDatePickerPopup.click();
		}
		calendarDates
				.getElements()
				.parallelStream()
				.filter(date -> date.getText().equals(selectedDate))
				.findFirst()
				.get()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage clickOnFirstResult() {
		Logger.info("Click on the first result from the list");
		autocompleteList
				.waitElementsReady()
				.clickOnElementNumber(0);
		return this;
	}

	public FoodAndFitnessJournalPage checkQuickListDisplayed() {
		Logger.info("Check the search result is displayed");
		boolean isQuickListDisplayed = quickListFood
				.waitElementsReady()
				.isPresent();
		assertTrue(isQuickListDisplayed, "The search result is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage favoriteFood() {
		Logger.info("Favorite food from search list");
		iconForFavorite.clickOnElementNumber(0);
		waitFor(1000);
		return this;
	}

	public FoodAndFitnessJournalPage clickMyFavoritesTabForFood() {
		Logger.info("Navigate to 'My favorites' food tab");
		myFavoritesTabForFood
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage selectLetterOnFavoriteTab(String letter) {
		Logger.info("Select letter on the 'browser by:' option");
		lettersOnFavoriteTab.waitUntilVisible();
		lettersOnFavoriteTab
				.getElements()
				.parallelStream()
				.filter(date -> date.getText().equals(letter))
				.findFirst()
				.get()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkFoodWasAddedToFavorite() {
		Logger.info("Check the food was added to favorite recipes");
		boolean isFoodFavorited = foodTitleFavoriteTab
				.waitElementsReady()
				.isPresent();
		assertTrue(isFoodFavorited, "The food is not favorite");
		assertTrue(foodTitleFavoriteTab.getText().contains(rememberFoodName), "The food title is not correct");
		return this;
	}

	public FoodAndFitnessJournalPage checkFavoriteFoodsDisplayed() {
		Logger.info("Check the foods that the user favorited are displayed");
		waitFor(1000);
		assertTrue(favoriteFoods.isPresent(), "The favorite foods are not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage checkFavoriteFoodCaloriesDisplayed() {
		Logger.info("Check the foods that the user favorited are displayed with their calorie details");
		assertTrue(favoriteFoodCalories.isPresent(), "The favorite food calories are not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage checkFavoriteFoodSourceDisplayed() {
		Logger.info("Check the foods that the user favorited are displayed with their Restaurant/Store Brand (if given)");
		assertTrue(favoriteFoodSource.isPresent(), "The favorite food Restaurant/Store Brand (if given) are not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage clickOnEachLetterFavoritesTab() {
		Logger.info("Verify the food names listed match the letter chosen");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int linkSize = lettersOnFavoriteTab.getElementsCount();
		for (int letter = 0; letter < linkSize; letter++) {
			basedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement link = lettersOnFavoriteTab.getElements().get(letter);
			link.click();
			waitFor(1000);
			Logger.info("Click On " + link.getText() + " letter");
			assertTrue(quickListResultFavoritesTab.isPresent(), "The quick list of results is not displayed");
			String foodCount = favoriteFoodCount.getText();
			if (!foodCount.equals("0")) {
				favoriteFoods.waitUntilClickable();
				boolean isSortCorrect = favoriteFoods
						.getText()
						.startsWith(link.getText());
				assertTrue(isSortCorrect, "The food names are not listed match the letter chosen");
			}
		}
		return this;
	}

	public FoodAndFitnessJournalPage clickShowAllLink() {
		Logger.info("Click on 'Show ALL' link on My Favorite tab");
		showAllLinkFavoriteTab
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkFavoriteItemsDisplayed() {
		Logger.info("Check All favorite recipes of the user are be displayed");
		boolean isFavoriteItemsDisplayed = favoriteFoodItems
				.waitElementsReady()
				.isPresent();
		assertTrue(isFavoriteItemsDisplayed, "NOT All favorite recipes of the user are be displayed");
		return this;
	}

	public FoodAndFitnessJournalPage clickShowFoodsLink() {
		Logger.info("Click on 'Show Foods' link on My Favorite tab");
		showFoodsLinkFavoriteTab
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkContentTypeForFavoriteFoods() {
		Logger.info("Check OnClick of Foods link, only the Favorite Foods of the user are be displayed");
		if (noFavoriteItems.isPresent()) {
			return this;
		} else {
			assertEquals(favoriteFoodItems.getAttribute("contenttype"), "Food", "OnClick of Foods link, not only the Favorite Foods of the user are be displayed");
		}
		return this;
	}

	public FoodAndFitnessJournalPage clickShowRecipesLink() {
		Logger.info("Click on 'Show Recipes' link on My Favorite tab");
		showRecipesLinkFavoriteTab
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkContentTypeForFavoriteRecipes() {
		Logger.info("Check OnClick of Recipes link, only the Favorite Recipes of the user are be displayed");
		if (noFavoriteItems.isPresent()) {
			return this;
		} else {
			assertEquals(favoriteFoodItems.getAttribute("contenttype"), "Recipe", "OnClick of Recipes link, not only the Favorite Recipes of the user are be displayed");
		}
		return this;
	}

	public FoodAndFitnessJournalPage clickShowMealsLink() {
		Logger.info("Click on 'Show Meals' link on My Favorite tab");
		showMealsLinkFavoriteTab
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkContentTypeForFavoriteMeals() {
		Logger.info("Check OnClick of Meal link, only the Favorite Meals of the user are be displayed");
		if (noFavoriteItems.isPresent()) {
			return this;
		} else {
			assertEquals(favoriteFoodItems.getAttribute("contenttype"), "Meal", "OnClick of Meals link, not only the Favorite Meals of the user are be displayed");
		}
		return this;
	}

	public FoodAndFitnessJournalPage checkQuicklogBreakfastButtonDisplayed() {
		Logger.info("Check Quicklog option is displayed for Breakfast");
		boolean isQuicklogDisplayed = quicklogBreakfastButton
				.waitElementsReady()
				.isPresent();
		assertTrue(isQuicklogDisplayed, "Quicklog option is not displayed for Breakfast");
		return this;
	}

	public FoodAndFitnessJournalPage checkQuicklogAMSnackButtonDisplayed() {
		Logger.info("Check Quicklog option is displayed for AM Snack");
		boolean isQuicklogDisplayed = quicklogAMSnackButton
				.waitElementsReady()
				.isPresent();
		assertTrue(isQuicklogDisplayed, "Quicklog option is not displayed for AM Snack");
		return this;
	}

	public FoodAndFitnessJournalPage checkQuicklogLunchButtonDisplayed() {
		Logger.info("Check Quicklog option is displayed for Lunch");
		boolean isQuicklogDisplayed = quicklogLunchButton
				.waitElementsReady()
				.isPresent();
		assertTrue(isQuicklogDisplayed, "Quicklog option is not displayed for Lunch");
		return this;
	}

	public FoodAndFitnessJournalPage checkQuicklogPMSnackButtonDisplayed() {
		Logger.info("Check Quicklog option is displayed for PM Snack");
		boolean isQuicklogDisplayed = quicklogPMSnackButton
				.waitElementsReady()
				.isPresent();
		assertTrue(isQuicklogDisplayed, "Quicklog option is not displayed for PM Snack");
		return this;
	}

	public FoodAndFitnessJournalPage checkQuicklogDinnerButtonDisplayed() {
		Logger.info("Check Quicklog option is displayed for Dinner");
		boolean isQuicklogDisplayed = quicklogDinnerButton
				.waitElementsReady()
				.isPresent();
		assertTrue(isQuicklogDisplayed, "Quicklog option is not displayed for Dinner");
		return this;
	}

	public FoodAndFitnessJournalPage checkQuicklogSweetsButtonDisplayed() {
		Logger.info("Check Quicklog option is displayed for Sweets");
		boolean isQuicklogDisplayed = quicklogSweetsButton
				.waitElementsReady()
				.isPresent();
		assertTrue(isQuicklogDisplayed, "Quicklog option is not displayed for Sweets");
		return this;
	}

	public FoodAndFitnessJournalPage clickSelectMealField() {
		Logger.info("Click on 'Select Meal' dropdown");
		selectMealField
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkBreakfastOptionDisplayed() {
		Logger.info("Check Breakfast option is displayed on dropdown menu for Select Meal option");
		boolean isMealOptionDisplayed = selectMealBreakfastOption
				.waitElementsReady()
				.isPresent();
		assertTrue(isMealOptionDisplayed, "Breakfast option is not displayed on dropdown menu for Select Meal option");
		return this;
	}

	public FoodAndFitnessJournalPage checkAMSnackOptionDisplayed() {
		Logger.info("Check AM Snack option is displayed on dropdown menu for Select Meal option");
		boolean isMealOptionDisplayed = selectMealAMSnackOption
				.waitElementsReady()
				.isPresent();
		assertTrue(isMealOptionDisplayed, "AM Snack option is not displayed on dropdown menu for Select Meal option");
		return this;
	}

	public FoodAndFitnessJournalPage checkLunchOptionDisplayed() {
		Logger.info("Check Lunch option is displayed on dropdown menu for Select Meal option");
		boolean isMealOptionDisplayed = selectMealLunchOption
				.waitElementsReady()
				.isPresent();
		assertTrue(isMealOptionDisplayed, "Lunch option is not displayed on dropdown menu for Select Meal option");
		return this;
	}

	public FoodAndFitnessJournalPage checkPMSnackOptionDisplayed() {
		Logger.info("Check PM Snack option is displayed on dropdown menu for Select Meal option");
		boolean isMealOptionDisplayed = selectMealPMSnackOption
				.waitElementsReady()
				.isPresent();
		assertTrue(isMealOptionDisplayed, "PM Snack option is not displayed on dropdown menu for Select Meal option");
		return this;
	}

	public FoodAndFitnessJournalPage checkDinnerOptionDisplayed() {
		Logger.info("Check Dinner option is displayed on dropdown menu for Select Meal option");
		boolean isMealOptionDisplayed = selectMealDinnerOption
				.waitElementsReady()
				.isPresent();
		assertTrue(isMealOptionDisplayed, "Dinner option is not displayed on dropdown menu for Select Meal option");
		return this;
	}

	public FoodAndFitnessJournalPage checkSweetsOptionDisplayed() {
		Logger.info("Check Sweets option is displayed on dropdown menu for Select Meal option");
		boolean isMealOptionDisplayed = selectMealSweetsOption
				.waitElementsReady()
				.isPresent();
		assertTrue(isMealOptionDisplayed, "Sweets option is not displayed on dropdown menu for Select Meal option");
		return this;
	}

	public FoodAndFitnessJournalPage checkCopeMealQuicklogOptionDisplayed() {
		Logger.info("Check 'Copy Meal' option is available on Quicklog dropdown");
		waitFor(1000);
		scrollPage(250);
		quicklogBreakfastButton
				.waitElementsReady()
				.clickWithJS();
		waitFor(1000);
		assertTrue(copyMealQuicklogOption.isPresent(), "'Copy Meal' option is not displayed on Quicklog dropdown");
		return this;
	}

	public FoodAndFitnessJournalPage clickCopeMealQuicklogOption() {
		Logger.info("Click on 'Copy Meal' option on Quicklog dropdown");
		scrollPage(250);
		waitFor(2000);
		quicklogBreakfastButton.click();
		waitFor(2000);
		copyMealQuicklogOption.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkPopupDisplayed() {
		Logger.info("Check popup is opened");
		boolean isPopupDisplayed = modalPopup
				.isVisible();
		assertTrue(isPopupDisplayed, "'Copy Meal to Journal' popup is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage selectMealField(String mealtime) {
		Logger.info("Choose option on 'Select Meal' dropdown");
		selectMealField.selectByText(mealtime);
		return this;
	}

	public FoodAndFitnessJournalPage clickDeleteLinkInExerciseContainer() {
		Logger.info("Click 'Delete' link in food info container");
		waitFor(2000);
		deleteExercise.click();
		return this;
	}

	public FoodAndFitnessJournalPage clickCopyExerciseLink() {
		Logger.info("Click on Copy link for exercise");
		copyExerciseLink
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage rememberExerciseQuantity() {
		rememberExerciseQuantity = exercisesName.getElementsCount();
		return this;
	}

	public FoodAndFitnessJournalPage checkExerciseCopied() {
		Logger.info("Check exercise was copied");
		exerciseItems.waitElementsReady();
		assertNotEquals(exercisesName.getElementsCount(), rememberExerciseQuantity, "The Exercise was not copied");
		return this;
	}

	public FoodAndFitnessJournalPage clickEditExerciseLink() {
		Logger.info("Click on Edit link for exercise");
		editExerciseLink
				.waitElementsReady()
				.click();
		return this;
	}

	public FoodAndFitnessJournalPage changeDurationValue(String min) {
		Logger.info("Enter duration value");
		durationField
				.waitUntilVisible()
				.then()
				.type(min);
		return this;
	}

	public FoodAndFitnessJournalPage checkDurationChanged(String value) {
		Logger.info("Check duration value of exercise is changed");
		waitFor(1000);
		assertEquals(exerciseDuration.getText(), value, "Duration value is not changed");
		return this;
	}

	public FoodAndFitnessJournalPage clickOnFavoriteExerciseIcon() {
		Logger.info("Click on the exercise favorite icon on the 'Recent Workouts' tab");
		waitForAjaxRequestToBeFinished();
		addExerciseToFavoriteIcon.clickOnElementNumber(1);
		return this;
	}

	public FoodAndFitnessJournalPage checkFavoriteExerciseDisplayed() {
		Logger.info("Check the exercise is favorited");
		waitForAjaxRequestToBeFinished();
		assertTrue(addExerciseToFavoriteIcon.getAttribute("src").contains("icon_is_favorite"), "The exercise is not favorited");
		return this;
	}

	public FoodAndFitnessJournalPage checkExerciseNotFavorite() {
		Logger.info("Check the exercise is not favorited");
		waitForAjaxRequestToBeFinished();
		assertFalse(addExerciseToFavoriteIcon.getAttribute("src").contains("icon_is_favorite"), "The exercise is favorited");
		return this;
	}

	public FoodAndFitnessJournalPage rememberExercisesQuantity() {
		waitFor(1000);
		int remember = exerciseFromFavorites.getElementsCount();
		if (remember < 2) {
			clickOnSearchExerciseTab();
			clickOnFirstLetter();
			boolean isNotFavorite = addExerciseToFavoriteIcon.getAttribute("src").contains("icon_is_not_favorite");
			if (isNotFavorite) {
				addExerciseToFavoriteIcon.waitElementsReady();
				addExerciseToFavoriteIcon.clickOnElementNumber(1);
			}
			clickOnMyFavoritesTab();
			rememberFavoritedExercisesQuantity = exerciseFromFavorites.getElementsCount();
		} else {
			rememberFavoritedExercisesQuantity = exerciseFromFavorites.getElementsCount();
		}
		return this;
	}

	public FoodAndFitnessJournalPage checkFavoritedExercisesDeselectedQuantity() {
		Logger.info("Check exercise was deselected");
		waitFor(1000);
		assertNotEquals(exerciseFromFavorites.getElementsCount(), rememberFavoritedExercisesQuantity, "The Exercise was not deselected");
		return this;
	}

	public FoodAndFitnessJournalPage checkFavoritedExercisesSelectedQuantity() {
		Logger.info("Check exercise was selected");
		waitFor(1000);
		Integer favoritedExercisesQuantity = exerciseFromFavorites.getElementsCount();
		assertEquals(favoritedExercisesQuantity, rememberFavoritedExercisesQuantity, "The Exercise was not selected");
		return this;
	}

	public CreateCustomExercisePage clickOnCreateNewCustomExercise() {
		Logger.info("Click on 'Create a New Custom Exercise' link");
		createNewCustomExercise.longClickWebObject();
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(basedriver, CreateCustomExercisePage.class);
	}

	public FoodAndFitnessJournalPage checkSearchInputFieldPresent() {
		Logger.info("Check search exercise input field is present");
		waitFor(2000); //need for loading
		assertTrue(searchForm.isVisible(), "Search exercise input field is not present");
		return this;
	}

	public FoodAndFitnessJournalPage checkSearchButtonPresent() {
		Logger.info("Check 'Search' button is present");
		assertTrue(searchButton.isVisible(), "'Search' button is not present");
		return this;
	}

	public FoodAndFitnessJournalPage checkAlphabetRowPresent() {
		Logger.info("Check the alphabet row is present");
		assertTrue(alphabetRow.isPresent(), "The Alphabet row  is not present");
		return this;
	}

	public FoodAndFitnessJournalPage favoriteExerciseFromRecentlyAdded() {
		Logger.info("Check User can favorite exercise from Recently Added section");
		String favoriteIcon = recentlyAddedExercise.getAttributeOfElementNumber(1, "src");
		if (favoriteIcon.contains("icon_is_favorite")) {
			recentlyAddedFavoritedExercise.clickOnElementNumber(1);
			waitFor(1000);
			String isFavorite = recentlyAddedExercise.getAttributeOfElementNumber(1, "src");
			assertFalse(isFavorite.contains("icon_is_favorite"), "The exercise is favorited");
		} else {
			recentlyAddedExercise.clickOnElementNumber(1);
			waitFor(1000);
			String isFavorite = recentlyAddedExercise.getAttributeOfElementNumber(1, "src");
			assertTrue(isFavorite.contains("icon_is_favorite"), "The exercise is not favorited");
		}
		return this;
	}

	public FoodAndFitnessJournalPage checkMyFavoritesSectionFavoritePossibility() {
		Logger.info("Check User can change favorite status of exercise from My Favorites section");
		if (myFavoritesOnSearchTab.isPresent()) {
			myFavoritesOnSearchTab.clickOnElementNumber(1);
			waitFor(1000);
			String isFavorite = myFavoritesOnSearchTab.getAttributeOfElementNumber(1, "src");
			assertFalse(isFavorite.contains("icon_is_favorite"), "The exercise was not deselected");
		} else {
			recentlyAddedExercise
					.waitElementsReady()
					.click();
			clickOnRecentWorkoutsTab();
			clickOnSearchExerciseTab();
			myFavoritesOnSearchTab.clickOnElementNumber(0);
			waitFor(1000);
			String isFavorite = myFavoritesOnSearchTab.getAttributeOfElementNumber(1, "src");
			assertFalse(isFavorite.contains("icon_is_favorite"), "The exercise was not deselected");
		}
		return this;
	}

	public FoodAndFitnessJournalPage clickOnSearchExerciseTab() {
		Logger.info("Click on Search Exercise tab");
		searchExercisesTab
				.waitElementsReady()
				.clickWithJS();
		return this;
	}


	public FoodAndFitnessJournalPage deleteCustomItems() {
		Logger.info("Delete Create By Me food");
		if (deleteCustomFood.isElementPresent()) {
			deleteCustomFood.getElements().forEach(elem -> {
				elem.click();
				waitFor(1000);
				clickDeleteButton();
				waitFor(1000);
			});
		}
		return this;
	}

	public FoodAndFitnessJournalPage favoriteAnyExerciseFromRecentWorkoutsTab() {
		Logger.info("Favorite exercise from Recent Workouts tab");
		addExerciseToFavoriteIcon.clickOnElementNumber(1);
		return this;
	}

	public FoodAndFitnessJournalPage favoriteExerciseIfNeeded() {
		Logger.info("Favorite the exercise on the 'Recent Workouts' section");
		waitForAjaxRequestToBeFinished();
		if (recentlyAddedExercise.isPresent()) {
			String favorite = recentlyAddedExercise.getAttribute("src");
			if (favorite.contains("icon_is_favorite")) {
				return this;
			} else {
				recentlyAddedExercise.clickOnElementNumber(1);
			}
		} else {
			clickOnFirstLetter();
			clickOnFirstExercise();
			clickOnAddExerciseToJournalButton();
			clickOnSearchExerciseTab();
			recentlyAddedExercise.clickOnElementNumber(1);
		}

		return this;
	}

	public FoodAndFitnessJournalPage favoriteExerciseFromRecentWorkoutTab() {
		Logger.info("Check User can favorite exercise from 'Recent Workouts' tab");
		addExerciseToFavoriteIcon.waitUntilVisible();
		String favoriteIcon = addExerciseToFavoriteIcon.getAttribute("src");
		clickOnFavoriteExerciseIcon();
		if (favoriteIcon.contains("icon_is_favorite")) {
			checkExerciseNotFavorite();
		} else {
			checkFavoriteExerciseDisplayed();
		}
		return this;
	}

	public FoodAndFitnessJournalPage clickViewMoreFavorites() {
		Logger.info("Click on 'view more favorites' link");
		viewMoreFavoritesLink.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkMyFavoritesTabActive() {
		Logger.info("Check 'My favorites' tab is active");
		assertTrue(myFavoritesTavSelected.isPresent(), "User is not redirected to the 'My Favorites' tab");
		return this;
	}

	public FoodAndFitnessJournalPage checkViewMoreFavoritesLinkPresent() {
		Logger.info("Add more exercises to favorite if 'view more favorites' link is not displayed");
		letters.waitElementsReady();
		for (int favoriteExercise = 1; favoriteExercise <= letters.getElementsCount(); favoriteExercise++) {
			if (viewMoreFavoritesLink.isPresent()) {
				return this;
			} else {
				if (myFavoritesOnSearchTab.isPresent()) {
					int myFavorite = myFavoritesOnSearchTab.getElementsCount();
					if (myFavorite < 3) {
						letters.clickOnElementNumber(favoriteExercise);
						addExerciseToFavoriteIcon.waitUntilElementIsVisible();
						addExerciseToFavoriteIcon.clickOnElementNumber(favoriteExercise);
						clickOnSearchExerciseTab();
					}
				} else {
					letters.clickOnElementNumber(favoriteExercise);
					addExerciseToFavoriteIcon.waitUntilElementIsVisible();
					addExerciseToFavoriteIcon.clickOnElementNumber(favoriteExercise);
					clickOnSearchExerciseTab();
				}
			}
		}
		return this;
	}

	public FoodAndFitnessJournalPage checkActiveLettersInJumpToOption() {
		Logger.info("Verify that only listed exercises' alphabets are active in Jump To option");
		ArrayList<String> arrayExerciseNameFirstLetters = new ArrayList<String>();
		ArrayList<String> arrayActiveLetters = new ArrayList<String>();
		int names = exerciseNames.getElementsCount();
		String firstLetter = "";
		for (int exercise = 0; exercise < names; exercise++) {
			String name = exerciseNames.getElements().get(exercise).getText().toUpperCase();
			firstLetter = name.substring(0, 1);
			if (arrayExerciseNameFirstLetters.contains(firstLetter)) {
				continue;
			} else {
				arrayExerciseNameFirstLetters.add(firstLetter);
			}
		}
		int letters = activeLetters.getElementsCount();
		for (int lettersActive = 0; lettersActive < letters; lettersActive++) {
			String letter = activeLetters.getElements().get(lettersActive).getText().toUpperCase();
			arrayActiveLetters.add(letter);
		}
		Collections.sort(arrayExerciseNameFirstLetters);
		Logger.info("Array of exercise names' first letters is " + String.valueOf(arrayExerciseNameFirstLetters));
		Logger.info("Array of active letters in 'Jump to:' option is " + String.valueOf(arrayActiveLetters));
		assertEquals(arrayExerciseNameFirstLetters, arrayActiveLetters, "Not only listed exercises' alphabets are active in Jump To option");
		return this;
	}

	public FoodAndFitnessJournalPage plusWaterAmountUpTo99() {
		Logger.info("Plus water amount up to 99 glasses");
		int goal = 99;
		for (int glass = 0; Integer.parseInt(waterCount.getText()) < goal; glass++) {
			int beforeClickCount = Integer.parseInt(waterCount.getText());
			plusWater.click();
			int newCount = Integer.parseInt(waterCount.getText());
			assertEquals(newCount, beforeClickCount + 1, "The Number increments is not by one after click");
		}
		return this;
	}

	public FoodAndFitnessJournalPage checkAddWaterButtonIsDisable() {
		Logger.info("Check Add water button is disable");
		assertTrue(addWaterDisableButton.isPresent(), "Add water button is not Disable");
		return this;
	}

	public FoodAndFitnessJournalPage checkWaterAmountSaved(String count) {
		Logger.info("Check water amount is saved after navigation to other dates");
		assertEquals(waterCount.getText(), count, "Water amount is not saved");
		return this;
	}

	public FoodAndFitnessJournalPage checkWaterAmount() {
		Logger.info("Check water amount is saved after navigation to other dates");
		assertEquals(waterCount.getText(), rememberAmountOfWater, "Water amount is not saved");
		return this;
	}

	public FoodAndFitnessJournalPage checkExerciseLogs() {
		Logger.info("Verify Elements on Exercise Log Link");
		waitFor(1000);
		List<WebElement> links = quickListExercise.getElements();
		for (WebElement link : links) {
			link.click();

			assertTrue(addToJournal.isElementPresent(), "Add to Journal is Not Displaying");
			assertTrue(whenDropDown.isElementPresent(), "When Today is Not Displaying");
			assertTrue(howLongMinutesInputField.isElementPresent(), "How Long Minutes is Not Displaying");
			assertTrue(logItemLinkClose.isElementPresent(), "Cancel Button is Not Displaying");
			assertTrue(addButton.isElementPresent(), "Add Log Item Button is Not Displaying");
			assertTrue(exerciseFacts.isElementPresent(), "Exercise Facts is not Displaying");
		}
		return this;
	}

	public FoodAndFitnessJournalPage displayExerciseLogLink() {
		Logger.info("Verify Exercise Log Link");
		quickListExercise.waitUntilVisible();
		assertTrue(quickListExercise.isElementPresent(), "Exercise Details Links are Not visible");
		return this;
	}

	public FoodAndFitnessJournalPage addWaterGlassesIfNeeded() {
		Logger.info("Adding glasses of water");
		int count = Integer.parseInt(StringUtils.getOnlyNumbers(waterCount.getText()));
		if (count < 5) {
			for (int i = 0; i < 5; i++) {
				plusWater.click();
			}
		}
		return this;
	}

	public FoodAndFitnessJournalPage minusWaterAmountAndCheckDecrement() {
		Logger.info("Minus water amount up to 0 glasses");
		int goal = 0;
		for (int glass = 0; Integer.parseInt(waterCount.getText()) > goal; glass--) {
			int beforeClickCount = Integer.parseInt(StringUtils.getOnlyNumbers(waterCount.getText()));
			minusWater.click();
			int newCount = Integer.parseInt(StringUtils.getOnlyNumbers(waterCount.getText()));
			assertEquals(newCount, beforeClickCount - 1, "The Number decrements is not by one after click");
		}
		return this;
	}

	public FoodAndFitnessJournalPage checkSubWaterButtonDisable() {
		Logger.info("Check the '-' button is disabled when it reaches to 0");
		assertTrue(subWaterDisableButton.isPresent(), "The '-' button is not disabled when it reaches to 0");
		return this;
	}

	public FoodAndFitnessJournalPage enterNumericAndSpecialCharacters() {
		Logger.info("Enter Numeric And Special Characters to the note field");
		noteEditField.clear();
		noteEditField
				.waitUntilVisible()
				.type("123456#$%^&*");
		return this;
	}

	public FoodAndFitnessJournalPage verifyNoteFieldContainsNumericAndSpecialCharacters() {
		Logger.info("Check Note field contains Numeric And Special Characters");
		basedriver.navigate().refresh();
		assertTrue(noteEditField.getText().contains("123456#$%^&*"), "Note field is empty!");
		return this;
	}

	public FoodAndFitnessJournalPage deleteNoteText() {
		Logger.info("Delete note text");
		noteEditField.clear();
		return this;
	}

	public FoodAndFitnessJournalPage checkDefaultNote() {
		Logger.info("Check the default note 'Join me in losing weight and gaining health on the Mayo Clinic Diet!' is displayed");
		noteEditField.waitElementsReady();
		assertEquals(noteEditField.getValue(), "Join me in losing weight and gaining health on the Mayo Clinic Diet!", "The default note is not correct");
		return this;
	}

	public FoodAndFitnessJournalPage checkMoreExerciseInfoDisplayed() {
		Logger.info("Check more exercise info container is displayed");
		moreExerciseInfoContainer.waitElementsReady();
		assertTrue(moreExerciseInfoContainer.isPresent(), "More exercise info container is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage checkMoreExerciseInfoNotDisplayed() {
		Logger.info("Check more exercise info container is not displayed");
		assertFalse(moreExerciseInfoContainer.isPresent(), "More exercise info container is displayed");
		return this;
	}

	public FoodAndFitnessJournalPage clickFoodNameLink() {
		Logger.info("Click on food name link");
		foodName.clickWithJS();
		return this;
	}

	public FoodAndFitnessJournalPage checkDefaultContentOfCreateByMeFoodTabDisplayed() {
		Logger.info("Check default content of Create by me food tab is displayed");
		assertTrue(defaultContentOfCreateByMeFoodTab.isPresent(), "The custom food was not removed");
		return this;
	}

	public FoodAndFitnessJournalPage checkFoodSortByAlpha(String letter) {
		Logger.info("Verify the food names listed match the letter chosen");
		waitFor(1000);
		foodName.waitUntilVisible();
		boolean isSortCorrect = foodName
				.getElements()
				.parallelStream()
				.anyMatch(exr -> exr.getText().startsWith(letter));
		assertTrue(isSortCorrect, "The food names are not listed match the letter chosen");
		return this;
	}

	public FoodAndFitnessJournalPage changeWeightValue(String weight) {
		Logger.info("Enter weight value");
		weightInputField
				.waitUntilVisible()
				.then()
				.type(weight);
		return this;
	}

	public FoodAndFitnessJournalPage checkWeightChanged(String value) {
		Logger.info("Check weight value of exercise is changed");
		waitFor(1000);
		String currentWeight = weightInputField.getAttribute("value");
		assertEquals(currentWeight, value, "Weight value is not changed");
		return this;
	}

	public FoodAndFitnessJournalPage checkViewMoreCreatedByMeDisplayed() {
		Logger.info("Check if 'view more created by me' link is displayed");
		assertTrue(viewMoreCreateByMeExercise.isVisible(), "'view more created by me' link is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage clickViewMoreCreatedByMeLink() {
		Logger.info("Click on 'view more created by me' link");
		viewMoreCreateByMeExercise.click();
		return this;
	}

	public FoodAndFitnessJournalPage checkCreateByMeExerciseTabActive() {
		Logger.info("Check 'Create By Me' exercise tab is active");
		assertTrue(createByMeExerciseTabActive.isPresent(), "'Create By Me' exercise tab is not active");
		return this;
	}

	public FoodAndFitnessJournalPage checkCreateByMeExerciseQuickListDisplayed() {
		Logger.info("Check quick list of created by me exercises is displayed");
		assertTrue(createByMeExerciseQuickList.isVisible(), "Quick list of created by me exercises is not displayed");
		return this;
	}

	public FoodAndFitnessJournalPage checkSuggestedIntenseLevel() {
		Logger.info("Check the exercise is displayed with suggested intense level exercise");
		assertEquals(burnedCaloriesInQuickLogCaloriesBurned.getText().replace("- ", ""), rememberEstimatedCalories, "The exercise is not displayed with suggested intense level exercise");
		return this;
	}

	public FoodAndFitnessJournalPage checkExerciseLogEmpty() {
		Logger.info("Check the exercise log is empty");
		assertFalse(exerciseEntryNameContainer.isPresent(), "The exercise log is not empty");
		return this;
	}

	public FoodAndFitnessJournalPage checkCreatedByMeExerciseDisplayedOnSearchTab() {
		Logger.info("Check custom created exercises are displayed on the Search tab");
		assertTrue(createdByMeExerciseOnSearchTab.isPresent(), "Custom created exercises are not displayed on the Search tab");
		return this;
	}

	public FoodAndFitnessJournalPage clickOnCreateByMeExerciseName() {
		Logger.info("Open more information about custom created exercise");
		createByMeExerciseQuickList.clickWithJS();
		return this;
	}

	public FoodAndFitnessJournalPage checkCaloriesValueInMoreExerciseInfoContainer() {
		Logger.info("Check calories burned value in more exercise container");
		assertEquals(caloriesBurnedValueInMoreExerciseInfoContainer.getText(), rememberEstimatedCalories, "The exercise is not displayed with suggested intense level exercise");
		return this;
	}

	public FoodAndFitnessJournalPage favoriteExerciseFromCreateByMe() {
		Logger.info("Check User can favorite exercise from Create By Me section");
		String favoriteIcon = createdByMeExerciseOnSearchTab.getAttributeOfElementNumber(1, "src");
		if (favoriteIcon.contains("icon_is_favorite")) {
			createdByMeExerciseOnSearchTab.clickOnElementNumber(1);
			waitFor(1000);
			String isFavorite = createdByMeExerciseOnSearchTab.getAttributeOfElementNumber(1, "src");
			assertFalse(isFavorite.contains("icon_is_favorite"), "The exercise is favorited");
		} else {
			createdByMeExerciseOnSearchTab.clickOnElementNumber(1);
			waitFor(1000);
			String isFavorite = createdByMeExerciseOnSearchTab.getAttributeOfElementNumber(1, "src");
			assertTrue(isFavorite.contains("icon_is_favorite"), "The exercise is not favorited");
		}
		return this;
	}

	public FoodAndFitnessJournalPage addCustomExerciseIfSectionEmpty() {
		Logger.info("Check Create By Me exercise section on the Search tab and add exercise if it is empty");
		boolean isCreateByMeExerciseSectionEmpty = createdByMeExerciseOnSearchTab.isPresent();
		if (isCreateByMeExerciseSectionEmpty) {
			return this;
		} else {
			clickOnCreatedByMeTab();
			clickOnCreateNewCustomExercise();
			createExercises(1);
			clickOnAddExerciseLink();
		}
		return this;
	}

	public FoodAndFitnessJournalPage deleteAllNewCustomFood() {
		Logger.info("Delete Create By Me food");
		if (!Settings.isEnvironment(Environment.PROD)) {
			return this;
		} else {
			if (deleteCustomFood.isElementPresent()) {
				deleteCustomFood.clickWithJS();
				waitFor(1000);
				clickDeleteButton();
			}
		}
		return this;
	}

	public FoodAndFitnessJournalPage addFoodToFavorite() {
		Logger.info("Add food to favorite");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1727");
		addFoodToFavorite.clickOnElementNumber(1);
		waitFor(1000);
		return this;
	}

	public FoodAndFitnessJournalPage rememberFoodName() {
		Logger.info("Remember food name");
		rememberFoodName = foodTitleFavoriteTab
				.getElements()
				.get(0)
				.getText();
		return this;
	}

	public FoodAndFitnessJournalPage addExercise() {
		Logger.info("Add exercise");
		if (recentlyAddedExercise.isPresent()) {
			return this;
		} else {
			clickOnFirstLetter();
			clickOnFirstExercise();
			clickOnAddExerciseToJournalButton();
		}
		return this;
	}

	@Override
	public void waitForPageToLoad() {
		waitForAjaxRequestToBeFinished();
	}
}