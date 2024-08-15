package org.mayoclinicdiet.tests;


import com.testrail.framework.platform.annotations.TestRail;
import framework.platform.DatePatterns;
import framework.platform.SiteNavigatorMCD;
import framework.platform.utilities.DateUtils;
import org.testng.annotations.Test;

public class FoodAndFitnessJournalTest {

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43076")
	public void verifyOnTrackLinkClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.verifyFoodAndFitnessJournalHeader();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43077")
	public void checkCalendar() {
		String expectedDate = DateUtils.getDateInFuture(1);
		String expectedDay = DateUtils.getDayInFuture(1);
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.submitLogin()
				.checkLogoutHeaderPresent()
				.clickOnTrackLink()
				.verifyFoodAndFitnessJournalHeader()
				.showCalendar()
				.calendarIsPresent()
				.chooseNextDate(expectedDay)
				.checkActiveDateCorrect(expectedDate);
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43078")
	public void verifyCalorieBalanceEditLinkClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnCalorieBalanceEditLink()
				.verifyProfileSettingsHeaderPresence();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43079")
	public void verifyAddFoodModal() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.verifyAddMealPlanTabPresent()
				.verifySearchFoodTabPresent()
				.verifyMyFavoritesTabPresent()
				.verifyCreatedByMeTabPresent()
				.checkReturnToJournalTabDisplayed()
				.clickOnReturnToJournalTab()
				.verifyFoodAndFitnessJournalHeader();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43080")
	public void verifyAddFoodModalDates() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddMealPlaneTodayDate()
				.verifyWeekDays();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43081")
	public void verifyAddMealPlan() {
		String expectedDay = DateUtils.getCurrentDate(DatePatterns.MMMMMMMMM_d_yyy);
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.checkDateInAddMealTab(expectedDay)
				.checkCategoriesInAddMealPlanTab()
				.clickAddToJournalForBreakfast()
				.clickAddToJournalForAMSnack()
				.clickAddToJournalForLunch()
				.clickAddToJournalForPMSnack()
				.clickAddToJournalForDinner()
				.clickOnReturnToJournalTab()
				.checkAddToJournalEntriesForBreakfastDisplayed()
				.checkAddToJournalEntriesForAMSnackDisplayed()
				.checkAddToJournalEntriesForLunchDisplayed()
				.checkAddToJournalEntriesForPMSnackDisplayed()
				.checkAddToJournalEntriesForDinnerDisplayed()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43082")
	//Test fails in IE because of bug
	public void verifyRemoveFoodFromMealPlan() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.clickAddToJournalForBreakfast()
				.clickRemoveFromJournalForBreakfast()
				.checkDeleteConfirmationMessageDisplayed()
				.clickDeleteButton()
				.checkRemoveButtonConvertedIntoAddToJournalButton()
				.clickOnReturnToJournalTab()
				.checkFoodItemsAreNotDisplayedInJournal();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43083")
	public void verifyCurrentDateSelection() {
		String expectedDay = DateUtils.getCurrentDate(DatePatterns.MMMMMMMMM_d_yyy);
		String expectedDate = DateUtils.getCurrentDate(DatePatterns.EEEE_MMM_d);
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.checkDateInAddMealTab(expectedDay)
				.clickViewLink()
				.checkHeaderDisplayed()
				.checkCurrentDate(expectedDate);
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43084")
	public void verifySearchFoodPossibility() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.clickSearchFoodTab()
				.checkSearchFoodFormDisplayed()
				.enterFoodToSearchFoodForm("Banana")
				.clickSearchFoodButton()
				.chooseFoodFromQuickList()
				.verifyMoreFoodInfoDisplayed()
				.changeSelectMealValue("Lunch")
				.changeWhenValueForFood("Tomorrow")
				.typeHowMuchFoodValue("2")
				.checkHowMuchFoodValue("2")
				.chooseServingsInDropdown()
				.clickSwitchToLink()
				.selectFractionFoodValue("1/2")
				.clickAddFoodButton()
				.clickCloseAddExerciseModule()
				.clickNextDateArrow()
				.checkAddToJournalEntriesForLunchDisplayed()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43085")
	public void verifyMyFavoritesTabFromAddFoodModal() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.clickOnMyFavoritesTabFromAddFoodModal()
				.verifyMyFavoritesHeader();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43086")
	public void verifyCreatedByMeTabFromAddFoodModal() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.clickOnCreatedByMeTabFromAddFoodModal()
				.verifyCreatedByMeHeader();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43087")
	public void verifyReturnToJournalFromAddFood() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.clickOnReturnToJournalTab()
				.verifyFoodAndFitnessJournalHeader();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43088")
	public void verifyAddExerciseLinkClick() {
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
				.checkReturnToJournalTabDisplayed()
				.clickOnReturnToJournalTab()
				.verifyFoodAndFitnessJournalHeader();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43089")
	public void verifyBrowseExercisesAbility() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.clickOnEachLetter();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43090")
	public void verifySearchExercisesAbility() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.checkExerciseModuleDisplayed()
				.checkSearchExercisesTabDisplayed()
				.clickOnLetterFromAlphabetRow("B")
				.chooseExerciseFromQuickList()
				.verifyMoreExerciseInfoDisplayed()
				.changeWhenValue("Tomorrow")
				.checkValueWasChangedInWhenDropdown("Tomorrow")
				.typeMinutesValue("50")
				.checkMinutesValue("50")
				.clickAddButton()
				.checkSearchExercisesTabDisplayed()
				.clickCloseAddExerciseModule()
				.clickNextDateArrow()
				.exerciseEntryNameContainerIsDisplayed()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43091")
	public void verifySearchExercisesExtendedAbility() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
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
				.checkSearchExercisesTabDisplayed()
				.clickCloseAddExerciseModule()
				.clickNextDateArrow()
				.exerciseEntryNameContainerIsDisplayed()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43092")
	public void verifyRecentWorkoutsClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.clickOnRecentWorkoutsTab()
				.verifyRecentWorkoutHeader();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43093")
	public void verifyMyFavoritesTabClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.clickOnMyFavoritesTab()
				.verifyMyFavoritesHeader();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43094")
	public void verifyCreatedByMeTabClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.clickOnCreatedByMeTab()
				.verifyCreatedByMeHeader();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43095")
	public void verifyReturnToJournal() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseLink()
				.clickOnReturnToJournalTab()
				.verifyFoodAndFitnessJournalHeader();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43096")
	public void verifyNutritionDetails() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnShowAllNutritionDetailsLink()
				.verifyNutritionHeadersPresence()
				.clickOnShowAllNutritionDetailsLink()
				.verifyNutritionHeadersAbsence();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43097")
	public void verifyQuickLogDialog() throws InterruptedException {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.rememberValues()
				.clickOnCaloriesEatenButton()
				.verifyQuickLogCaloriesEatenModalAppears()
				.enterCaloriesEaten()
				.selectMeal("Breakfast")
				.selectTime("Today")
				.clickOnAddCaloriesEatenButton()
				.verifyCaloriesAddedToTheSections()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43098")
	public void checkAbilityAddFoodToBreakfast() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.clickAddToJournalForBreakfast()
				.clickOnReturnToJournalTab()
				.checkAddToJournalEntriesForBreakfastDisplayed()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43099")
	public void checkAbilityAddFoodToAMSnack() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.clickAddToJournalForAMSnack()
				.clickOnReturnToJournalTab()
				.checkAddToJournalEntriesForAMSnackDisplayed()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43100")
	public void checkAbilityAddFoodToLunch() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.clickAddToJournalForLunch()
				.clickOnReturnToJournalTab()
				.checkAddToJournalEntriesForLunchDisplayed()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43101")
	public void checkAbilityAddFoodToPMSnack() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.clickAddToJournalForPMSnack()
				.clickOnReturnToJournalTab()
				.checkAddToJournalEntriesForPMSnackDisplayed()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43102")
	public void checkAbilityAddFoodToDinner() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddFoodButton()
				.verifyAddFoodModalPresent()
				.clickAddToJournalForDinner()
				.clickOnReturnToJournalTab()
				.checkAddToJournalEntriesForDinnerDisplayed()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43103")
	public void checkAbilityAddFoodToSweets() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickAddFoodToSweetsButton()
				.verifyAddFoodModalPresent()
				.clickSearchFoodTab()
				.enterFoodToSearchFoodForm("Ice Cream")
				.clickSearchFoodButton()
				.chooseFoodFromQuickList()
				.clickAddFoodButton()
				.clickOnReturnToJournalTab()
				.checkAddToJournalEntriesForSweetsDisplayed()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43104")
	public void verifyFoodLogLinks() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickAddFoodButtonUnderFoodLog()
				.clickAddToJournalButton()
				.clickCloseAddExerciseModule()
				.checkFoodContainerPresented()
				.checkViewLinkIsPresented()
				.checkEditLinkIsPresented()
				.checkCopyLinkIsPresented()
				.checkDeleteLinkIsPresented()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43105")
	public void verifyViewFoodLinks() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickAddFoodButtonUnderFoodLog()
				.clickAddToJournalButton()
				.clickCloseAddExerciseModule()
				.checkFoodContainerPresented()
				.clickViewLinkInFoodContainer()
				.checkRecipePageDisplayed()
				.clickBackBrowserButton()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43106")
	public void verifyEditFoodLinks() {
		String expectedDay = DateUtils.getDayInFuture(1);
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickAddFoodButtonUnderFoodLog()
				.clickAddToJournalButton()
				.clickCloseAddExerciseModule()
				.checkFoodContainerPresented()
				.clickEditLinkInFoodContainer()
				.verifyFoodPopupDisplayed()
				.chooseNextDate(expectedDay)
				.chooseMealtime("Dinner")
				.enterServingSize("2")
				.chooseFractSize("1/2")
				.clickSaveButton()
				.checkSuccessMessageDisplayed()
				.clickOKButton()
				.clickNextDateArrow()
				.checkDinnerItemCount("(1 Item)")
				.checkServings("2.5 serving(s)")
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43107")
	public void verifyCopyFoodLinks() {
		String expectedDay = DateUtils.getDayInFuture(1);
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickAddFoodButtonUnderFoodLog()
				.clickAddToJournalButton()
				.clickCloseAddExerciseModule()
				.checkFoodContainerPresented()
				.clickCopyLinkInFoodContainer()
				.verifyFoodPopupDisplayed()
				.chooseNextDate(expectedDay)
				.chooseMealtime("Dinner")
				.enterServingSize("2")
				.chooseFractSize("1/2")
				.clickSaveButton()
				.checkSuccessMessageDisplayed()
				.clickOKButton()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton()
				.clickNextDateArrow()
				.checkDinnerItemCount("(1 Item)")
				.checkServings("2.5 serving(s)")
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43108")
	public void verifyDeleteFoodLinks() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickAddFoodButtonUnderFoodLog()
				.clickAddToJournalButton()
				.clickCloseAddExerciseModule()
				.checkFoodContainerPresented()
				.clickDeleteLinkInFoodContainer()
				.checkDeleteConfirmationMessageDisplayed()
				.clickDeleteButton()
				.checkFoodContainerNotPresented();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43109")
	public void verifyAddExerciseButtonClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseButton()
				.checkExerciseModuleDisplayed()
				.clickOnFirstLetter()
				.clickOnFirstExercise()
				.clickOnAddExerciseToJournalButton()
				.clickOnReturnToJournalTab()
				.verifyFoodAndFitnessJournalHeader()
				.verifyExerciseWasAdded()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43111")
	public void verifyQuickLogForExerciseLog() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickQuicklogDropdownForExerciseLog()
				.clickCaloriesBurnedOption()
				.verifyFoodPopupDisplayed()
				.enterCaloriesBurned("200")
				.chooseWhenCaloriesBurned("Tomorrow")
				.clickOnAddButtonForCaloriesBurned()
				.clickNextDateArrow()
				.checkBurnedCaloriesDisplayed()
				.clickOnAddExerciseButton()
				.checkExerciseModuleDisplayed()
				.clickOnFirstLetter()
				.clickOnFirstExercise()
				.clickOnAddExerciseToJournalButton()
				.clickOnReturnToJournalTab()
				.clickQuicklogDropdownForExerciseLog()
				.checkTwoOptionsArePresentInQuickLogForExerciseLog()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43112")
	public void verifyCaloriesBurnedForExerciseLog() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickQuicklogDropdownForExerciseLog()
				.clickCaloriesBurnedOption()
				.verifyFoodPopupDisplayed()
				.enterCaloriesBurned("200")
				.chooseWhenCaloriesBurned("Tomorrow")
				.clickOnAddButtonForCaloriesBurned()
				.clickNextDateArrow()
				.checkBurnedCaloriesDisplayed()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C43113")
	public void verifyAddExerciseToJournal() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.clickOnAddExerciseButton()
				.checkExerciseModuleDisplayed()
				.clickOnFirstLetter()
				.clickOnFirstExercise()
				.selectExerciseDate("Today")
				.enterExerciseDuration("45")
				.clickOnAddExerciseToJournalButton()
				.checkExerciseModuleDisplayed()
				.clickOnReturnToJournalTab()
				.verifyExerciseWasAdded()
				.clickDeleteLinkInFoodContainer()
				.clickDeleteButton();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43114")
	public void verifyWaterTracker() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.verifyWaterTrackerSectionPresent()
				.plusWaterAmount()
				.verifyWaterAmountIncreased()
				.minusWaterAmount()
				.verifyWaterAmountDecreased();
	}

	@Test(groups = {"journal", "MayoClinicDiet", "smokeSet", "smokeForProd"})
	@TestRail(id = "C43115")
	public void verifyMyNotesSection() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin()
				.clickOnTrackLink()
				.verifyMyNotesSectionPresent()
				.enterNoteText()
				.clickOnSaveNoteButton()
				.verifySavedNoteMessagePresent()
				.verifyNoteFieldIsNotEmpty();
	}
}
