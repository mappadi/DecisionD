package org.mayoclinicdiet.tests;

import com.testrail.framework.platform.annotations.TestRail;
import framework.Logger;
import framework.platform.SiteNavigatorMCD;
import framework.platform.UserActionsMCD;
import framework.platform.utilities.DateUtils;
import mayoclinicdiet.pages.CreateCustomFoodPage;
import mayoclinicdiet.pages.FoodAndFitnessJournalPage;
import org.testng.annotations.Test;

public class FFJournalRegressionTest {

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C52999")
	public void successfulPageLoad() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.verifyFoodAndFitnessJournalHeader()
				.checkJournalPageContentDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53000")
	public void dateDisplay() {
		String expectedCurrentDate = DateUtils.getCurrentDateString();
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.checkActiveDateCorrect(expectedCurrentDate)
				.checkCalendarIconDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53001")
	public void pastDateDisplay() {
		String expectedPrevDay = DateUtils.getDayInPast(1);
		String expectedPrevDate = DateUtils.getDateInPast(1);
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.showCalendar()
				.choosePrevDate(expectedPrevDay)
				.checkActiveDateCorrect(expectedPrevDate);
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53002")
	public void futureDateDisplay() {
		String expectedNextDay = DateUtils.getDayInFuture(1);
		String expectedNextDate = DateUtils.getDateInFuture(1);
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.showCalendar()
				.chooseNextDate(expectedNextDay)
				.checkActiveDateCorrect(expectedNextDate);
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53003")
	public void dateForwardArrow() {
		String expectedNextDate = DateUtils.getDateInFuture(1);
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickNextDateArrow()
				.checkActiveDateCorrect(expectedNextDate);
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53004")
	public void dateBackwardArrow() {
		String expectedPrevDate = DateUtils.getDateInPast(1);
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickBackwardArrow()
				.checkActiveDateCorrect(expectedPrevDate);
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53005")
	public void consumedBurnedCalorieBalance() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.checkConsumedSectionDisplayed()
				.checkBurnedSectionDisplayed()
				.checkAddFoodButtonDisplayed()
				.checkAddExerciseButtonDisplayed()
				.checkCalorieBalanceSectionDisplayed()
				.checkDailyBudgetDisplayed()
				.checkEditCalorieBalanceLinkDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53006")
	public void nutritionAtGlance() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.checkNutritionAtGlanceModuleDisplayed()
				.checkNutritionCaloriesDisplayed()
				.checkNutritionFatDisplayed()
				.checkNutritionSatFatDisplayed()
				.checkNutritionCholesterolDisplayed()
				.checkNutritionSodiumDisplayed()
				.checkNutritionCarbohydratesDisplayed()
				.checkNutritionFiberDisplayed()
				.checkNutritionProteinDisplayed()
				.checkChangeYourCalorieRangeLinkDisplayed()
				.checkNutritionQuestionDisplayed()
				.checkNutritionQuestionIFlyoutDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53007")
	public void foodItemsNutritionalInformationDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.verifyFoodAndFitnessJournalHeader()
				.checkShowAllNutritionDetailsLinkDisplayed()
				.checkShowAllNutritionDetailsDisplayed()
				.clickOnShowAllNutritionDetailsLink()
				.checkHideAllNutritionDetailsDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53008")
	public void foodItemsNutritionalInformationHide() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.checkHideAllNutritionDetailsLinkDisplayed()
				.checkHideAllNutritionDetailsDisplayed()
				.clickOnShowAllNutritionDetailsLink()
				.checkShowAllNutritionDetailsDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53009")
	public void foodItemsNutritionalInformationEntries() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.checkShowAllNutritionDetailsLinkDisplayed()
				.clickOnShowAllNutritionDetailsLink()
				.verifyNutritionHeadersPresence()
				.clickOnShowAllNutritionDetailsLink();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53010")
	public void foodItemsCalorieDisplay() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.rememberAMCaloriesValues()
				.clickOnAddFoodButton()
				.clickAddToJournalForAMSnack()
				.clickOnReturnToJournalTab()
				.checkAddToJournalEntriesForAMSnackDisplayed()
				.verifyCaloriesAddedToAMSnackSections();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C53011"})
	@TestRail(id = "C53011")
	public void foodItemsViewLink() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.clickAddToJournalForLunch()
				.clickCloseAddExerciseModule()
				.checkFoodContainerPresented()
				.clickViewLinkInFoodContainer()
				.checkRecipePageDisplayed()
				.clickBackBrowserButton();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53012")
	public void copyForTheSameMeal() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.clickAddToJournalForPMSnack()
				.clickCloseAddExerciseModule()
				.checkFoodContainerPresented()
				.rememberFoodEntries()
				.clickCopyLinkInFoodContainer()
				.verifyFoodPopupDisplayed()
				.clickSaveButton()
				.checkSuccessMessageDisplayed()
				.clickOKButton()
				.verifyFoodEntries();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C53013"})
	@TestRail(id = "C53013")
	public void editForDifferentMealOnDifferentDate() {
		String expectedNextDay = DateUtils.getDayInFuture(1);
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.clickAddToJournalForLunch()
				.clickCloseAddExerciseModule()
				.checkFoodContainerPresented()
				.clickEditLinkInFoodContainer()
				.verifyFoodPopupDisplayed()
				.chooseNextDate(expectedNextDay)
				.chooseMealtime("Breakfast")
				.enterServingSize("2")
				.chooseFractSize("1/2")
				.clickSaveButton()
				.checkSuccessMessageDisplayed()
				.clickOKButton()
				.clickNextDateArrow()
				.checkItemCountBreakfast("(1 Item)")
				.checkServingsBreakfast("2.5 serving(s)");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C53014"})
	@TestRail(id = "C53014")
	public void verifyDeleteFoodLinks() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.clickAddToJournalButton()
				.clickCloseAddExerciseModule()
				.checkFoodContainerPresented()
				.clickDeleteLinkInFoodContainer()
				.checkDeleteConfirmationMessageDisplayed()
				.clickDeleteButton()
				.checkFoodContainerNotPresented();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53015")
	public void createCustomFood() {
		CreateCustomFoodPage createCustomFoodPage = UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickCreateNewCustomFoodLink();
		Logger.info("Create breakfast for Today");
		createCustomFoodPage.enterFoodName("My breakfast")
				.chooseFoodGroup()
				.checkYesRadioButtonChecked()
				.enterServingSize("1")
				.chooseServingUnits()
				.enterCaloriesValue("120")
				.clickSubmitButton()
				.checkSuccessMessageDisplayed()
				.clickCreateAnotherFoodButton();
		Logger.info("Create AM Snack for Yesterday");
		createCustomFoodPage.enterFoodName("My AM Snack")
				.chooseFoodGroup()
				.checkYesRadioButtonChecked()
				.selectAMSnackMeal()
				.selectYesterdayDay()
				.enterServingSize("1")
				.chooseServingUnits()
				.enterCaloriesValue("120")
				.clickSubmitButton()
				.checkSuccessMessageDisplayed()
				.clickCreateAnotherFoodButton();
		Logger.info("Create Dinner for Tomorrow");
		FoodAndFitnessJournalPage foodAndFitnessJournalPage = createCustomFoodPage.enterFoodName("My Dinner")
				.chooseFoodGroup()
				.checkYesRadioButtonChecked()
				.selectDinnerMeal()
				.selectTomorrowDay()
				.enterServingSize("1")
				.chooseServingUnits()
				.enterCaloriesValue("120")
				.clickSubmitButton()
				.checkSuccessMessageDisplayed()
				.clickGoToJournalButton();
		Logger.info("Check Journal");
		foodAndFitnessJournalPage.checkJournalPageContentDisplayed()
				.checkItemCountBreakfast("(1 Item)")
				.checkJournalEmpty()
				.clickBackwardArrow()
				.checkItemCountAMSnack("(1 Item)")
				.checkJournalEmpty()
				.clickNextDateArrow()
				.clickNextDateArrow()
				.checkDinnerItemCount("(1 Item)");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C53016"})
	@TestRail(id = "C53016")
	public void addMealPlanTab() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickAddFoodButtonUnderFoodLog()
				.checkAddMealPlanTabOpen()
				.verifyMealPlanForEachWeekDay();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53017")
	public void addMealPlanTabMealtimes() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.checkAddMealPlanTabOpen()
				.selectDayInAddMealPlanTab()
				.checkCategoriesInAddMealPlanTab();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C53018"})
	@TestRail(id = "C53018")
	public void addMealPlanTabFoodEntries() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.checkAddMealPlanTabOpen()
				.selectDayInAddMealPlanTab()
				.splitDateRange()
				.rememberDate()
				.clickAddToJournalButton()
				.clickCloseAddExerciseModule()
				.showCalendar()
				.chooseSelectedDate()
				.checkFoodContainerPresented();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53019")
	public void searchFoodTabSearchResultDisplayThreeCharacters() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.clickSearchFoodTab()
				.checkSearchFoodFormDisplayed()
				.enterFoodToSearchFoodForm("Chi")
				.clickOnFirstResult()
				.checkQuickListDisplayed()
				.rememberFoodName()
				.favoriteFood()
				.clickMyFavoritesTabForFood()
				.selectLetterOnFavoriteTab("C")
				.checkFoodWasAddedToFavorite()
				.favoriteFood();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53020")
	public void searchFoodTabOnClickAnySearchResult() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.clickSearchFoodTab()
				.checkSearchFoodFormDisplayed()
				.enterFoodToSearchFoodForm("Banan")
				.clickOnFirstResult()
				.clickSearchFoodButton()
				.chooseFoodFromQuickList()
				.verifyMoreFoodInfoDisplayed()
				.changeSelectMealValue("Lunch")
				.changeWhenValueForFood("Tomorrow")
				.chooseServingsInDropdown()
				.typeHowMuchFoodValue("2")
				.clickAddFoodButton()
				.clickCloseAddExerciseModule()
				.clickNextDateArrow()
				.checkAddToJournalEntriesForLunchDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53021")
	public void myFavoriteTabDefault() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.addFoodToFavorite()
				.clickMyFavoritesTabForFood()
				.checkFavoriteFoodsDisplayed()
				.checkFavoriteFoodCaloriesDisplayed()
				.checkFavoriteFoodSourceDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53022")
	public void myFavoriteTabBrowseByAlphabets() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.addFoodToFavorite()
				.clickMyFavoritesTabForFood()
				.clickOnEachLetterFavoritesTab();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53023")
	public void myFavoriteTabShowAllFoodsRecipesMealsLink() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.addFoodToFavorite()
				.clickMyFavoritesTabForFood()
				.clickShowAllLink()
				.checkFavoriteItemsDisplayed()
				.clickShowFoodsLink()
				.checkContentTypeForFavoriteFoods()
				.clickShowRecipesLink()
				.checkContentTypeForFavoriteRecipes()
				.clickShowMealsLink()
				.checkContentTypeForFavoriteMeals();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53024")
	public void quickLogControlShownForAllMeals() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.checkQuicklogBreakfastButtonDisplayed()
				.checkQuicklogAMSnackButtonDisplayed()
				.checkQuicklogLunchButtonDisplayed()
				.checkQuicklogPMSnackButtonDisplayed()
				.checkQuicklogDinnerButtonDisplayed()
				.checkQuicklogSweetsButtonDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53025")
	public void quickLogCaloriesWindowHasAllMealOptions() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnCaloriesEatenButton()
				.clickSelectMealField()
				.checkBreakfastOptionDisplayed()
				.checkAMSnackOptionDisplayed()
				.checkLunchOptionDisplayed()
				.checkPMSnackOptionDisplayed()
				.checkDinnerOptionDisplayed()
				.checkSweetsOptionDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53026")
	public void quickLogValueUpdatedFoodLog() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.rememberValues()
				.clickOnCaloriesEatenButton()
				.enterCaloriesEaten()
				.clickOnAddCaloriesEatenButton()
				.verifyCaloriesAddedToTheSections();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53027")
	public void quickLogWithCopyMealOption() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickOnCaloriesEatenButton()
				.enterCaloriesEaten()
				.clickOnAddCaloriesEatenButton()
				.clickOnAddFoodButton()
				.clickAddToJournalForBreakfast()
				.clickCloseAddExerciseModule()
				.checkCopeMealQuicklogOptionDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53028")
	public void quickLogWithCopyMealUpdate() {
		String expectedNextDay = DateUtils.getDayInFuture(1);
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickOnCaloriesEatenButton()
				.enterCaloriesEaten()
				.clickOnAddCaloriesEatenButton()
				.verifyFoodAndFitnessJournalHeader()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.clickAddToJournalForBreakfast()
				.clickCloseAddExerciseModule()
				.clickCopeMealQuicklogOption()
				.checkPopupDisplayed()
				.chooseNextDate(expectedNextDay)
				.selectMealField("Lunch")
				.clickOnAddCaloriesEatenButton()
				.clickOKButton()
				.checkJournalEmpty()
				.clickNextDateArrow()
				.checkAddToJournalEntriesForLunchDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53029")
	public void exerciseAddForToday() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.enterExerciseToSearchExercisesForm("volleyball")
				.clickSearchButton()
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.clickAddButton()
				.clickCloseAddExerciseModule()
				.exerciseEntryNameContainerIsDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53030")
	public void exerciseAddForDifferentCalories() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.enterExerciseToSearchExercisesForm("volleyball")
				.clickSearchButton()
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.changeWhenValue("Tomorrow")
				.checkValueWasChangedInWhenDropdown("Tomorrow")
				.typeMinutesValue("50")
				.checkMinutesValue("50")
				.clickAddButton()
				.clickCloseAddExerciseModule()
				.clickNextDateArrow()
				.exerciseEntryNameContainerIsDisplayed()
				.checkJournalEmpty()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.enterExerciseToSearchExercisesForm("basketball")
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.changeWhenValue("Yesterday")
				.checkValueWasChangedInWhenDropdown("Yesterday")
				.typeMinutesValue("20")
				.checkMinutesValue("20")
				.clickAddButton()
				.clickCloseAddExerciseModule()
				.clickBackwardArrow()
				.exerciseEntryNameContainerIsDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53031")
	public void exerciseQuickLogCaloriesAddForToday() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickQuicklogDropdownForExerciseLog()
				.clickCaloriesBurnedOption()
				.verifyFoodPopupDisplayed()
				.enterCaloriesBurned("200")
				.clickOnAddButtonForCaloriesBurned()
				.checkBurnedCaloriesDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53032")
	public void exerciseCopyToTodayDate() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.enterExerciseToSearchExercisesForm("volleyball")
				.clickSearchButton()
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.clickAddButton()
				.clickCloseAddExerciseModule()
				.exerciseEntryNameContainerIsDisplayed()
				.rememberExerciseQuantity()
				.clickCopyExerciseLink()
				.checkPopupDisplayed()
				.clickOnAddCaloriesEatenButton()
				.clickOKButton()
				.checkExerciseCopied();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53033")
	public void exercisePopupEditExerciseForToday() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.enterExerciseToSearchExercisesForm("volleyball")
				.clickSearchButton()
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.clickAddButton()
				.clickCloseAddExerciseModule()
				.exerciseEntryNameContainerIsDisplayed()
				.clickEditExerciseLink()
				.checkPopupDisplayed()
				.changeDurationValue("50")
				.clickOnAddCaloriesEatenButton()
				.clickOKButton()
				.checkDurationChanged("50 min");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53034")
	public void addExercisePopUp() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.checkRecentWorkoutsTabDisplayed()
				.checkMyFavoritesTabDisplayed()
				.checkCreateByMeTabDisplayed()
				.checkReturnToJournalTabDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C53035"})
	@TestRail(id = "C53035")
	public void searchExerciseTabBrowseOption() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.checkSearchInputFieldPresent()
				.checkSearchButtonPresent()
				.checkAlphabetRowPresent();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C53036"})
	@TestRail(id = "C53036")
	public void searchExerciseFavoritePossibility() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnFirstLetter()
				.clickOnFirstExercise()
				.clickOnAddExerciseToJournalButton()
				.clickOnSearchExerciseTab()
				.favoriteExerciseFromRecentlyAdded()
				.clickOnRecentWorkoutsTab()
				.clickOnSearchExerciseTab()
				.checkMyFavoritesSectionFavoritePossibility()
				.addCustomExerciseIfSectionEmpty()
				.favoriteExerciseFromCreateByMe()
				.clickOnReturnToJournalTab();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C53037"})
	@TestRail(id = "C53037")
	public void searchExerciseViewMoreFavorites() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkViewMoreFavoritesLinkPresent()
				.clickViewMoreFavorites()
				.checkMyFavoritesTabActive();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53038")
	public void searchExerciseViewMoreCreateByMe() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnCreatedByMeTab()
				.clickOnCreateNewCustomExercise()
				.createExercises(3)
				.clickOnAddExerciseLink()
				.checkViewMoreCreatedByMeDisplayed()
				.clickViewMoreCreatedByMeLink()
				.checkCreateByMeExerciseTabActive()
				.checkCreateByMeExerciseQuickListDisplayed()
				.deleteAllNewCustomFood();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C53039"})
	@TestRail(id = "C53039")
	public void recentWorkoutsTab() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnFirstLetter()
				.clickOnFirstExercise()
				.clickOnAddExerciseToJournalButton()
				.clickOnRecentWorkoutsTab()
				.favoriteExerciseFromRecentWorkoutTab()
				.favoriteExerciseFromRecentWorkoutTab()
				.clickOnReturnToJournalTab();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53040")
	public void displayRecentWorkoutsExerciseLogs() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.addExercise()
				.clickOnRecentWorkoutsTab()
				.checkExerciseLogs();
	}

	@Test(groups = {"journamRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53041")
	public void verifyExerciseLinkDetails() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.addExercise()
				.clickOnRecentWorkoutsTab()
				.displayExerciseLogLink();
	}


	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C53042"})
	@TestRail(id = "C53042")
	public void recentWorkoutsTabExploreExercise() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnFirstLetter()
				.clickOnFirstExercise()
				.clickOnAddExerciseToJournalButton()
				.clickOnRecentWorkoutsTab()
				.chooseExerciseFromQuickList()
				.checkMoreExerciseInfoDisplayed()
				.chooseExerciseFromQuickList()
				.checkMoreExerciseInfoNotDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53043")
	public void myFavoritesTabJumpTo() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.favoriteExerciseIfNeeded()
				.clickOnMyFavoritesTab()
				.checkActiveLettersInJumpToOption();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53044")
	public void myFavoritesTab() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.favoriteExerciseIfNeeded()
				.clickOnMyFavoritesTab()
				.rememberExercisesQuantity()
				.clickOnFavoriteExerciseIcon()
				.checkFavoritedExercisesDeselectedQuantity()
				.clickOnFavoriteExerciseIcon()
				.checkFavoritedExercisesSelectedQuantity();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C128832"})
	@TestRail(id = "C128832")
	public void createByMeExercisePage() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnCreatedByMeTab()
				.clickOnCreateNewCustomExercise()
				.checkCreateCustomExerciseUrl();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53048")
	public void waterAddForDifferentDates() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.clickNextDateArrow()
				.verifyWaterTrackerSectionPresent()
				.plusWaterAmountUpTo99()
				.checkAddWaterButtonIsDisable()
				.clickBackwardArrow()
				.clickNextDateArrow()
				.checkWaterAmountSaved("99")
				.clickBackwardArrow()
				.verifyWaterTrackerSectionPresent()
				.plusWaterAmountUpTo99()
				.checkAddWaterButtonIsDisable()
				.clickBackwardArrow()
				.clickNextDateArrow()
				.checkWaterAmountSaved("99");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53049")
	public void waterSubtract() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.verifyWaterTrackerSectionPresent()
				.addWaterGlassesIfNeeded()
				.minusWaterAmountAndCheckDecrement();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53050")
	public void waterSubtractDisableAfterGoesDownToMin() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.verifyWaterTrackerSectionPresent()
				.addWaterGlassesIfNeeded()
				.minusWaterAmountAndCheckDecrement()
				.checkSubWaterButtonDisable();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C53051"})
	@TestRail(id = "C53051")
	public void waterSubtractForDifferentDates() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.clickNextDateArrow()
				.addWaterGlassesIfNeeded()
				.minusWaterAmount()
				.clickBackwardArrow()
				.clickNextDateArrow()
				.checkWaterAmount()
				.clickBackwardArrow()
				.addWaterGlassesIfNeeded()
				.minusWaterAmount()
				.clickBackwardArrow()
				.clickNextDateArrow()
				.checkWaterAmount();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53052")
	public void waterAddCount() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.verifyWaterTrackerSectionPresent()
				.plusWaterAmountUpTo99()
				.checkWaterAmountSaved("99");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53053")
	public void addingText() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.verifyMyNotesSectionPresent()
				.enterNoteText()
				.clickOnSaveNoteButton()
				.verifySavedNoteMessagePresent()
				.verifyNoteFieldIsNotEmpty();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53054")
	public void addingNumericAndSpecialCharacters() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.verifyMyNotesSectionPresent()
				.enterNumericAndSpecialCharacters()
				.clickOnSaveNoteButton()
				.verifySavedNoteMessagePresent()
				.verifyNoteFieldContainsNumericAndSpecialCharacters();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C53055")
	public void deletingWhatWasAdded() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.verifyMyNotesSectionPresent()
				.enterNoteText()
				.clickOnSaveNoteButton()
				.verifySavedNoteMessagePresent()
				.verifyNoteFieldIsNotEmpty()
				.deleteNoteText()
				.clickOnSaveNoteButton()
				.checkDefaultNote();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126686")
	public void createByMeTabAddFoodToSelectedMeal() {
		CreateCustomFoodPage createCustomFoodPage = UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickCreateNewCustomFoodLink();
		Logger.info("Pre-condition: create custom food");
		FoodAndFitnessJournalPage foodAndFitnessJournalPage = createCustomFoodPage.enterFoodName("My Dinner")
				.chooseFoodGroup()
				.checkYesRadioButtonChecked()
				.selectDinnerMeal()
				.enterServingSize("1")
				.chooseServingUnits()
				.enterCaloriesValue("120")
				.clickSubmitButton()
				.checkSuccessMessageDisplayed()
				.clickGoToJournalButton();
		Logger.info("Change meal type");
		foodAndFitnessJournalPage.checkDinnerItemCount("(1 Item)")
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickFoodNameLink()
				.changeSelectMealValue("Breakfast")
				.clickAddFoodButton()
				.clickOnReturnToJournalTab()
				.checkItemCountBreakfast("(1 Item)");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126687")
	public void createByMeTabAddFood() {
		CreateCustomFoodPage createCustomFoodPage = UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickCreateNewCustomFoodLink();
		Logger.info("Pre-condition: create custom food");
		FoodAndFitnessJournalPage foodAndFitnessJournalPage = createCustomFoodPage.enterFoodName("My Dinner")
				.chooseFoodGroup()
				.checkYesRadioButtonChecked()
				.selectDinnerMeal()
				.enterServingSize("1")
				.chooseServingUnits()
				.enterCaloriesValue("120")
				.clickSubmitButton()
				.checkSuccessMessageDisplayed()
				.clickGoToJournalButton();
		Logger.info("Check user is able to add a custom food to the journal after clicking on 'Add'");
		foodAndFitnessJournalPage.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickFoodNameLink()
				.clickAddFoodButton()
				.clickOnReturnToJournalTab()
				.checkDinnerItemCount("(1 Item)")
				.checkItemCountBreakfast("(1 Item)");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126688")
	public void createByMeTabAddFoodToSelectedDay() {
		CreateCustomFoodPage createCustomFoodPage = UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickCreateNewCustomFoodLink();
		Logger.info("Pre-condition: create custom food");
		FoodAndFitnessJournalPage foodAndFitnessJournalPage = createCustomFoodPage.enterFoodName("My Dinner")
				.chooseFoodGroup()
				.checkYesRadioButtonChecked()
				.selectDinnerMeal()
				.enterServingSize("1")
				.chooseServingUnits()
				.enterCaloriesValue("120")
				.clickSubmitButton()
				.checkSuccessMessageDisplayed()
				.clickGoToJournalButton();
		Logger.info("Check user is able to add a custom food to selected day");
		foodAndFitnessJournalPage.checkDinnerItemCount("(1 Item)")
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickFoodNameLink()
				.changeWhenValueForFood("Tomorrow")
				.clickAddFoodButton()
				.clickOnReturnToJournalTab()
				.clickNextDateArrow()
				.checkItemCountBreakfast("(1 Item)");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126689")
	public void createByMeTabAddFoodQuantity() {
		CreateCustomFoodPage createCustomFoodPage = UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickCreateNewCustomFoodLink();
		Logger.info("Pre-condition: create custom food");
		FoodAndFitnessJournalPage foodAndFitnessJournalPage = createCustomFoodPage.enterFoodName("My Dinner")
				.chooseFoodGroup()
				.checkYesRadioButtonChecked()
				.selectDinnerMeal()
				.enterServingSize("1")
				.chooseServingUnits()
				.enterCaloriesValue("120")
				.clickSubmitButton()
				.checkSuccessMessageDisplayed()
				.clickGoToJournalButton();
		Logger.info("Check user is able to change food quantity");
		foodAndFitnessJournalPage.checkDinnerItemCount("(1 Item)")
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickFoodNameLink()
				.typeHowMuchFoodValue("2")
				.clickAddFoodButton()
				.clickOnReturnToJournalTab()
				.checkItemCountBreakfast("(2 Item)");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C126690"})
	@TestRail(id = "C126690")
	public void createByMeTabAddFoodDelete() {
		CreateCustomFoodPage createCustomFoodPage = UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickCreateNewCustomFoodLink();
		Logger.info("Pre-condition: create custom food");
		FoodAndFitnessJournalPage foodAndFitnessJournalPage = createCustomFoodPage.enterFoodName("My Dinner")
				.chooseFoodGroup()
				.checkYesRadioButtonChecked()
				.selectDinnerMeal()
				.enterServingSize("1")
				.chooseServingUnits()
				.enterCaloriesValue("120")
				.clickSubmitButton()
				.checkSuccessMessageDisplayed()
				.clickGoToJournalButton();
		Logger.info("Check user is able  to delete the custom food");
		foodAndFitnessJournalPage.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.deleteCustomItems()
				.checkDefaultContentOfCreateByMeFoodTabDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126691")
	public void createByMeTabSortByAlpha() {
		CreateCustomFoodPage createCustomFoodPage = UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickCreateNewCustomFoodLink();
		Logger.info("Pre-condition: create custom food");
		FoodAndFitnessJournalPage foodAndFitnessJournalPage = createCustomFoodPage.enterFoodName("Breakfast")
				.chooseFoodGroup()
				.checkYesRadioButtonChecked()
				.enterServingSize("1")
				.chooseServingUnits()
				.enterCaloriesValue("120")
				.clickSubmitButton()
				.checkSuccessMessageDisplayed()
				.clickCreateAnotherFoodButton()
				.enterFoodName("Snack")
				.chooseFoodGroup()
				.checkYesRadioButtonChecked()
				.enterServingSize("1")
				.chooseServingUnits()
				.enterCaloriesValue("120")
				.clickSubmitButton()
				.checkSuccessMessageDisplayed()
				.clickGoToJournalButton();
		Logger.info("Check user is able to see the food list starting from selected letter on created by me tab");
		foodAndFitnessJournalPage.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.selectLetterOnFavoriteTab("B")
				.checkFoodSortByAlpha("B")
				.selectLetterOnFavoriteTab("S")
				.checkFoodSortByAlpha("S");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C126692"})
	@TestRail(id = "C126692")
	public void createCustomFoodInvalidInfo() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickCreateNewCustomFoodLink()
				.enterFoodName("Breakfast")
				.chooseFoodGroup()
				.checkYesRadioButtonChecked()
				.enterServingSize("%^hg")
				.chooseServingUnits()
				.enterCaloriesValue("&%jh")
				.clickSubmitButton()
				.checkErrorMessageDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126693")
	public void createCustomFoodForms() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickAddFoodButtonUnderFoodLog()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.clickCreateNewCustomFoodLink()
				.enterFoodName("Breakfast")
				.clickSubmitButton()
				.checkErrorMessageDisplayed()
				.checkErrorMessageText();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126694")
	public void createByMeExerciseNameNegativeScenario() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnCreatedByMeTab()
				.clickOnCreateNewCustomExercise()
				.checkCreateCustomExerciseUrl()
				.enterDurationInMinute("30")
				.enterCaloriesBurnedValue("100")
				.clickOnSubmitButton()
				.checkErrorMessageBlankNameField();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126695")
	public void createByMeExerciseDurationNegativeScenario() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnCreatedByMeTab()
				.clickOnCreateNewCustomExercise()
				.checkCreateCustomExerciseUrl()
				.enterExerciseName("My aerobic")
				.enterCaloriesBurnedValue("100")
				.clickOnSubmitButton()
				.checkErrorMessageBlankDurationField();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126696")
	public void createByMeExerciseToday() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnCreatedByMeTab()
				.clickOnCreateNewCustomExercise()
				.checkCreateCustomExerciseUrl()
				.enterExerciseName("My aerobic")
				.enterDurationInMinute("30")
				.enterCaloriesBurnedValue("100")
				.clickOnSubmitButton()
				.clickTakeToJournalLink()
				.exerciseEntryNameContainerIsDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126698")
	public void createByMeExerciseYesterday() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnCreatedByMeTab()
				.clickOnCreateNewCustomExercise()
				.checkCreateCustomExerciseUrl()
				.enterExerciseName("My aerobic")
				.enterDurationInMinute("30")
				.enterCaloriesBurnedValue("100")
				.changeWhenValue("Yesterday")
				.clickOnSubmitButton()
				.clickTakeToJournalLink()
				.clickBackwardArrow()
				.exerciseEntryNameContainerIsDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126699")
	public void createByMeExerciseTomorrow() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnCreatedByMeTab()
				.clickOnCreateNewCustomExercise()
				.checkCreateCustomExerciseUrl()
				.enterExerciseName("My aerobic")
				.enterDurationInMinute("30")
				.enterCaloriesBurnedValue("100")
				.changeWhenValue("Tomorrow")
				.clickOnSubmitButton()
				.clickTakeToJournalLink()
				.clickNextDateArrow()
				.exerciseEntryNameContainerIsDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126700")
	public void createByMeExerciseSuggestedCalories() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnCreatedByMeTab()
				.clickOnCreateNewCustomExercise()
				.checkCreateCustomExerciseUrl()
				.enterExerciseName("My aerobic")
				.enterDurationInMinute("30")
				.selectNoAnswer()
				.moveSlider()
				.rememberEstimatedCaloriesValue()
				.clickOnSubmitButton()
				.clickTakeToJournalLink()
				.exerciseEntryNameContainerIsDisplayed()
				.checkSuggestedIntenseLevel();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression", "C126701"})
	@TestRail(id = "C126701")
	public void createByMeExerciseLogLater() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.clickOnCreatedByMeTab()
				.deleteCustomItems()
				.clickOnCreateNewCustomExercise()
				.checkCreateCustomExerciseUrl()
				.enterExerciseName("My aerobic")
				.enterDurationInMinute("30")
				.selectNoAnswer()
				.moveSlider()
				.rememberEstimatedCaloriesValue()
				.chooseLogThisLaterOption()
				.clickOnSubmitButton()
				.clickTakeToJournalLink()
				.checkExerciseLogEmpty()
				.clickOnAddExerciseLink()
				.checkCreatedByMeExerciseDisplayedOnSearchTab()
				.clickOnCreatedByMeTab()
				.clickOnCreateByMeExerciseName()
				.checkMoreExerciseInfoDisplayed()
				.checkCaloriesValueInMoreExerciseInfoContainer();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126704")
	public void exerciseQuickLogCaloriesAddForYesterday() {
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.clickQuicklogDropdownForExerciseLog()
				.clickCaloriesBurnedOption()
				.verifyFoodPopupDisplayed()
				.enterCaloriesBurned("200")
				.chooseWhenCaloriesBurned("Yesterday")
				.clickOnAddButtonForCaloriesBurned()
				.clickBackwardArrow()
				.checkBurnedCaloriesDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126706")
	public void exerciseCopyToTomorrow() {
		String expectedNextDay = DateUtils.getDayInFuture(1);
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.enterExerciseToSearchExercisesForm("volleyball")
				.clickSearchButton()
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.clickAddButton()
				.clickCloseAddExerciseModule()
				.exerciseEntryNameContainerIsDisplayed()
				.clickCopyExerciseLink()
				.checkPopupDisplayed()
				.chooseNextDate(expectedNextDay)
				.clickOnAddCaloriesEatenButton()
				.clickOKButton()
				.checkJournalEmpty()
				.clickNextDateArrow()
				.exerciseEntryNameContainerIsDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126707")
	public void exerciseCopyToYesterday() {
		String expectedPrevDay = DateUtils.getDayInPast(1);
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickBackwardArrow()
				.checkJournalEmpty()
				.clickNextDateArrow()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.enterExerciseToSearchExercisesForm("volleyball")
				.clickSearchButton()
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.clickAddButton()
				.clickCloseAddExerciseModule()
				.exerciseEntryNameContainerIsDisplayed()
				.clickCopyExerciseLink()
				.checkPopupDisplayed()
				.choosePrevDate(expectedPrevDay)
				.clickOnAddCaloriesEatenButton()
				.clickOKButton()
				.checkJournalEmpty()
				.clickBackwardArrow()
				.exerciseEntryNameContainerIsDisplayed();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126711")
	public void exercisePopupEditExerciseDurationForYesterday() {
		String expectedPrevDay = DateUtils.getDayInPast(1);
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickBackwardArrow()
				.checkJournalEmpty()
				.clickNextDateArrow()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.enterExerciseToSearchExercisesForm("volleyball")
				.clickSearchButton()
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.clickAddButton()
				.clickCloseAddExerciseModule()
				.exerciseEntryNameContainerIsDisplayed()
				.clickEditExerciseLink()
				.checkPopupDisplayed()
				.choosePrevDate(expectedPrevDay)
				.changeDurationValue("50")
				.clickOnAddCaloriesEatenButton()
				.clickOKButton()
				.clickBackwardArrow()
				.checkDurationChanged("50 min");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126712")
	public void exercisePopupEditExerciseDurationForTomorrow() {
		String expectedNextDay = DateUtils.getDayInFuture(1);
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickNextDateArrow()
				.checkJournalEmpty()
				.clickBackwardArrow()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.enterExerciseToSearchExercisesForm("volleyball")
				.clickSearchButton()
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.clickAddButton()
				.clickCloseAddExerciseModule()
				.exerciseEntryNameContainerIsDisplayed()
				.clickEditExerciseLink()
				.checkPopupDisplayed()
				.chooseNextDate(expectedNextDay)
				.changeDurationValue("50")
				.clickOnAddCaloriesEatenButton()
				.clickOKButton()
				.clickNextDateArrow()
				.checkDurationChanged("50 min");
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126713")
	public void exercisePopupEditExerciseWeightForYesterday() {
		String expectedPrevDay = DateUtils.getDayInPast(1);
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickBackwardArrow()
				.checkJournalEmpty()
				.clickNextDateArrow()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.enterExerciseToSearchExercisesForm("volleyball")
				.clickSearchButton()
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.clickAddButton()
				.clickCloseAddExerciseModule()
				.exerciseEntryNameContainerIsDisplayed()
				.clickEditExerciseLink()
				.checkPopupDisplayed()
				.choosePrevDate(expectedPrevDay)
				.changeWeightValue("130")
				.clickOnAddCaloriesEatenButton()
				.clickOKButton()
				.clickBackwardArrow()
				.clickEditExerciseLink()
				.checkWeightChanged("130")
				.clickOnAddCaloriesEatenButton()
				.clickOKButton();
	}

	@Test(groups = {"journalRegression", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C126714")
	public void exercisePopupEditExerciseWeightForTomorrow() {
		String expectedNextDay = DateUtils.getDayInFuture(1);
		UserActionsMCD.registerNewUser()
				.clickOnTrackLink()
				.checkJournalEmpty()
				.clickNextDateArrow()
				.checkJournalEmpty()
				.clickBackwardArrow()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.enterExerciseToSearchExercisesForm("volleyball")
				.clickSearchButton()
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.clickAddButton()
				.clickCloseAddExerciseModule()
				.exerciseEntryNameContainerIsDisplayed()
				.clickEditExerciseLink()
				.checkPopupDisplayed()
				.chooseNextDate(expectedNextDay)
				.changeWeightValue("130")
				.clickOnAddCaloriesEatenButton()
				.clickOKButton()
				.clickNextDateArrow()
				.clickEditExerciseLink()
				.checkWeightChanged("130")
				.clickOnAddCaloriesEatenButton()
				.clickOKButton();
	}
}
