package org.mayoclinicdiet.tests;


import com.testrail.framework.platform.annotations.TestRail;
import framework.platform.SiteNavigatorMCD;
import framework.platform.UserActionsMCD;
import mayoclinicdiet.pages.HomePage;
import mayoclinicdiet.pages.MainFooter;
import mayoclinicdiet.pages.PublicHeaderMCD;
import org.testng.annotations.Test;


public class HabitTrackerTest {

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65459")
	public void successfulPageLoad() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkPageIsLoaded();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65460")
	public void globalMemberSiteHeaderDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink(PublicHeaderMCD.class)
				.checkTheMayoClinicDietTextDisplayed()
				.checkMainLogoDisplayed()
				.checkNavigationBarDisplayed()
				.checkHomeLinkPresent()
				.checkEatLinkPresent()
				.checkMoveLinkPresent()
				.checkMotivateLinkPresent()
				.checkTrackLinkPresent()
				.checkAboutTheDietLinkPresent()
				.checkSettingsLinkPresent()
				.checkFAQLinkPresent()
				.checkLogOutLinkPresent();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65461")
	public void globalMemberSiteFooterDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink(MainFooter.class)
				.checkFooterSectionPresent()
				.checkAboutUsLinkPresent()
				.checkMayoClinicLinkPresent()
				.checkFeedbackLinkPresent()
				.checkContactUsLinkPresent()
				.checkTermsOfUseLinkPresent()
				.checkEverydayHealthLogoPresent()
				.checkTextContentPresent()
				.checkSeeAdditionalInformationLinkPresent()
				.checkTermsOfUseSecondLinkPresent()
				.checkPrivacyPolicyLinkPresent();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65462")
	public void siteMapDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink(MainFooter.class)
				.checkSireMapHeadersPresent()
				.checkEatGetStartedLinkPresent()
				.checkSmartFoodChoicesLinkPresent()
				.checkMealsMadeEasyLinkPresent()
				.checkEatingOutLinkPresent()
				.checkRecipeFinderLinkPresent()
				.checkDailyMealPlanLinkPresent()
				.checkWeeklyMealPlanLinkPresent()
				.checkMoveGetStartedLinkPresent()
				.checkHealthyBodyBenefitsLinkPresent()
				.checkChallengeYourselfLinkPresent()
				.checkFitnessTipsLinkPresent()
				.checkFitnessPlannerLinkPresent()
				.checkExerciseIndexLinkPresent()
				.checkMindAndBodyLinkPresent()
				.checkObstaclesLinkPresent()
				.checkSuccessStoriesLinkPresent()
				.checkSupportLinkPresent()
				.checkFoodAndFitnessJournalLinkPresent()
				.checkWeightTrackerLinkPresent()
				.checkInchTrackerLinkPresent()
				.checkNutrientTrackerLinkPresent()
				.checkAdd5HabitsLinkPresent()
				.checkBreak5HabitsLinkPresent()
				.checkBonus5HabitsLinkPresent()
				.checkLearningFromLoseItLinkPresent()
				.checkPreparingToLiveItLinkPresent()
				.checkTheExpertsLinkPresent()
				.checkFAQsLinkPresent()
				.checkFAQsSiteAndToolsLinkPresent();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65463")
	public void headingSectionDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkHabitTrackerTitleDisplayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65464")
	public void headingSectionCssValues() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkTitleCss();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65465")
	public void returnLinkDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkReturnToHomePageButtonDisplayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65466")
	public void returnLinkOnClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickReturnToHomePageButton()
				.checkWelcomeTextDisplayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65467")
	public void returnLinkCssValues() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkReturnToHomePageButtonCss();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65468")
	public void threeTabsDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkWeek1TabDisplayed()
				.checkWeek2TabDisplayed()
				.checkAnalysisTabDisplayed()
				.checkActiveTab();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65469")
	public void threeTabsCssValues() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkWeek1TabCss()
				.checkWeek2TabCss()
				.checkAnalysisTabCss();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65470")
	public void threeTabsCssValuesOnClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickWeek2Tab()
				.checkWeek2TabCssOnClick()
				.clickAnalysisTab()
				.checkAnalysisTabCssOnClick()
				.clickWeek1Tab()
				.checkWeek1TabCss();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65471")
	public void week1TabOnClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkActiveTab()
				.checkAdd5HabitsAnalysisTableWeek1Displayed()
				.checkBreak5HabitsAnalysisTableWeek1IsNotDisplayed()
				.checkBonus5HabitsAnalysisTableWeek1IsNotDisplayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65472")
	public void week2TabOnClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickWeek2Tab()
				.checkAdd5HabitsAnalysisTableWeek2Displayed()
				.checkBreak5HabitsAnalysisTableWeek2IsNotDisplayed()
				.checkBonus5HabitsAnalysisTableWeek2IsNotDisplayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65473")
	public void add5HabitsContentDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkAdd5HabitsWeek1CheckMarksDisplayed()
				.checkAdd5HabitsWeek1TotalsDisplayed()
				.clickWeek2Tab()
				.checkAdd5HabitsWeek2CheckMarksDisplayed()
				.checkAdd5HabitsWeek2TotalsDisplayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65474")
	public void add5Habits5AddHabits() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkEatAHealthyBreakfastTitleWeek1Displayed()
				.checkEatVegetablesTitleWeek1Displayed()
				.checkEatWholeGrainsTitleWeek1Displayed()
				.checkEatHealthyFatsTitleWeek1Displayed()
				.checkMoveTitleWeek1Displayed()
				.checkAmountOfCheckboxesForEatAHealthyBreakfastWeek1()
				.checkAmountOfCheckboxesForEatVegetablesWeek1()
				.checkAmountOfCheckboxesForEatWholeGrainsWeek1()
				.checkAmountOfCheckboxesForEatHealthyFatsWeek1()
				.checkAmountOfCheckboxesForMoveWeek1()
				.checkAmountOfTotalsWeek1()
				.clickWeek2Tab()
				.checkEatAHealthyBreakfastTitleWeek2Displayed()
				.checkEatVegetablesTitleWeek2Displayed()
				.checkEatWholeGrainsTitleWeek2Displayed()
				.checkEatHealthyFatsTitleWeek2Displayed()
				.checkMoveTitleWeek2Displayed()
				.checkAmountOfCheckboxesForEatAHealthyBreakfastWeek2()
				.checkAmountOfCheckboxesForEatVegetablesWeek2()
				.checkAmountOfCheckboxesForEatWholeGrainsWeek2()
				.checkAmountOfCheckboxesForEatHealthyFatsWeek2()
				.checkAmountOfCheckboxesForMoveWeek2()
				.checkAmountOfTotalsWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65475")
	public void add5HabitsEatAHealthyBreakfast() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabit(0)
				.clickFullProgressReportLinkOnHabitTracker()
				.checkAmountOfTotalsForEatAHealthyBreakfastWeek1()
				.clickWeek2Tab()
				.checkAmountOfTotalsForEatAHealthyBreakfastWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65476")
	public void add5HabitsEatAHealthyBreakfastUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.checkEatAHealthyBreakfastWeek1CheckboxIsEmpty(0)
				.clickWeek2Tab()
				.checkEatAHealthyBreakfastWeek2CheckboxIsEmpty(0);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65477")
	public void add5HabitsEatVegetablesAndFruits() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabit(1)
				.clickFullProgressReportLinkOnHabitTracker()
				.checkAmountOfTotalsForEatVegetablesWeek1()
				.clickWeek2Tab()
				.checkAmountOfTotalsForEatVegetablesWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "C65478"})
	@TestRail(id = "C65478")
	public void add5HabitsEatVegetablesAndFruitsUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.checkEatVegetablesWeek1CheckboxIsEmpty(1)
				.clickWeek2Tab()
				.checkEatVegetablesWeek2CheckboxIsEmpty(1);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65479")
	public void add5HabitsEatWholeGrains() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabit(2)
				.clickFullProgressReportLinkOnHabitTracker()
				.checkAmountOfTotalsForEatWholeGrainsWeek1()
				.clickWeek2Tab()
				.checkAmountOfTotalsForEatWholeGrainsWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65480")
	public void add5HabitsEatWholeGrainsUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.checkEatWholeGrainsWeek1CheckboxIsEmpty(2)
				.clickWeek2Tab()
				.checkEatWholeGrainsWeek2CheckboxIsEmpty(2);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65481")
	public void add5HabitsEatHealthyFats() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabit(3)
				.clickFullProgressReportLinkOnHabitTracker()
				.checkAmountOfTotalsForEatHealthyFatsWeek1()
				.clickWeek2Tab()
				.checkAmountOfTotalsForEatHealthyFatsWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65482")
	public void add5HabitsEatHealthyFatsUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.checkEatHealthyFatsWeek1CheckboxIsEmpty(3)
				.clickWeek2Tab()
				.checkEatHealthyFatsWeek2CheckboxIsEmpty(3);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65483")
	public void add5HabitsMove() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabit(4)
				.clickFullProgressReportLinkOnHabitTracker()
				.checkAmountOfTotalsForMoveWeek1()
				.clickWeek2Tab()
				.checkAmountOfTotalsForMoveWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65484")
	public void add5HabitsMoveUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.checkMoveWeek1CheckboxIsEmpty(4)
				.clickWeek2Tab()
				.checkMoveWeek2CheckboxIsEmpty(4);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65485")
	public void add5HabitsContentNotEditable() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkContentNotEditableWeek1()
				.clickWeek2Tab()
				.checkContentNotEditableWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65486")
	public void add5HabitsHeaderDisplayColorAndBackgroundColor() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkAdd5HabitsHeaderWeek1Css()
				.checkDayNumberHeaderWeek1Css()
				.clickWeek2Tab()
				.checkAdd5HabitsHeaderWeek2Css()
				.checkDayNumberHeaderWeek2Css();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65487")
	public void add5HabitsPlusAndMinusIconsDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkExpandIconOnAdd5HabitsWeek1Displayed()
				.clickWeek2Tab()
				.checkExpandIconOnAdd5HabitsWeek2Displayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65488")
	public void add5HabitsPlusAndMinusIconsOnClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickExpandIconAdd5HabitsWeek1()
				.checkPlusIconAdd5HabitsWeek1()
				.clickExpandIconAdd5HabitsWeek1()
				.checkMinusIconAdd5HabitsWeek1()
				.clickWeek2Tab()
				.clickExpandIconAdd5HabitsWeek2()
				.checkPlusIconAdd5HabitsWeek2()
				.clickExpandIconAdd5HabitsWeek2()
				.checkMinusIconAdd5HabitsWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65489")
	public void break5HabitsContentDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickBreak5HabitsHeaderWeek1()
				.checkBreak5HabitsWeek1CheckMarksDisplayed()
				.checkBreak5HabitsWeek1TotalsDisplayed()
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkBreak5HabitsWeek2CheckMarksDisplayed()
				.checkBreak5HabitsWeek2TotalsDisplayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65490")
	public void break5Habits5AddHabits() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickBreak5HabitsHeaderWeek1()
				.checkNoTVWhileEatingTitleWeek1Displayed()
				.checkNoSugarTitleWeek1Displayed()
				.checkNoSnacksTitleWeek1Displayed()
				.checkModerateMeatAndLowFatDairyTitleWeek1Displayed()
				.checkNoEatingAtRestaurantsTitleWeek1Displayed()
				.checkAmountOfCheckboxesForNoTVWhileEatingWeek1()
				.checkAmountOfCheckboxesForNoSugarWeek1()
				.checkAmountOfCheckboxesForNoSnacksWeek1()
				.checkAmountOfCheckboxesForModerateMeatAndLowFatDairyWeek1()
				.checkAmountOfCheckboxesForNoEatingAtRestaurantsWeek1()
				.checkAmountOfTotalsForBreak5HabitsWeek1()
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkNoTVWhileEatingTitleWeek2Displayed()
				.checkNoSugarTitleWeek2Displayed()
				.checkNoSnacksTitleWeek2Displayed()
				.checkModerateMeatAndLowFatDairyTitleWeek2Displayed()
				.checkNoEatingAtRestaurantsTitleWeek2Displayed()
				.checkAmountOfCheckboxesForNoTVWhileEatingWeek2()
				.checkAmountOfCheckboxesForNoSugarWeek2()
				.checkAmountOfCheckboxesForNoSnacksWeek2()
				.checkAmountOfCheckboxesForModerateMeatAndLowFatDairyWeek2()
				.checkAmountOfCheckboxesForNoEatingAtRestaurantsWeek2()
				.checkAmountOfTotalsForBreak5HabitsWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65491")
	public void break5HabitsNoTVWhileEating() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabitBreak5Habits(0)
				.clickFullProgressReportLinkOnHabitTracker()
				.clickBreak5HabitsHeaderWeek1()
				.checkAmountOfTotalsForNoTVWhileEatingWeek1()
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkAmountOfTotalsForNoTVWhileEatingWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65492")
	public void break5HabitsNoTVWhileEatingUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickBreak5HabitsHeaderWeek1()
				.checkNoTVWhileEatingWeek1CheckboxIsEmpty(0)
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkNoTVWhileEatingWeek2CheckboxIsEmpty(0);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65493")
	public void break5HabitsNoSugar() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabitBreak5Habits(1)
				.clickFullProgressReportLinkOnHabitTracker()
				.clickBreak5HabitsHeaderWeek1()
				.checkAmountOfTotalsForNoSugarWeek1()
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkAmountOfTotalsForNoSugarWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65494")
	public void break5HabitsNoSugarUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickBreak5HabitsHeaderWeek1()
				.checkNoSugarWeek1CheckboxIsEmpty(1)
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkNoSugarWeek2CheckboxIsEmpty(1);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65495")
	public void break5HabitsNoSnacks() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabitBreak5Habits(2)
				.clickFullProgressReportLinkOnHabitTracker()
				.clickBreak5HabitsHeaderWeek1()
				.checkAmountOfTotalsForNoSnacksWeek1()
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkAmountOfTotalsForNoSnacksWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65496")
	public void break5HabitsNoSnacksUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickBreak5HabitsHeaderWeek1()
				.checkNoSnacksWeek1CheckboxIsEmpty(2)
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkNoSnacksWeek2CheckboxIsEmpty(2);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65497")
	public void break5HabitsModerateMeatAndLowFatDairy() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabitBreak5Habits(3)
				.clickFullProgressReportLinkOnHabitTracker()
				.clickBreak5HabitsHeaderWeek1()
				.checkAmountOfTotalsForModerateMeatAndLowFatDairyWeek1()
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkAmountOfTotalsForModerateMeatAndLowFatDairyWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65498")
	public void break5HabitsModerateMeatAndLowFatDairyUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickBreak5HabitsHeaderWeek1()
				.checkModerateMeatAndLowFatDairyWeek1CheckboxIsEmpty(3)
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkModerateMeatAndLowFatDairyWeek2CheckboxIsEmpty(3);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65499")
	public void break5HabitsNoEatingAtRestaurants() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabitBreak5Habits(4)
				.clickFullProgressReportLinkOnHabitTracker()
				.clickBreak5HabitsHeaderWeek1()
				.checkAmountOfTotalsForNoEatingAtRestaurantsWeek1()
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkAmountOfTotalsForNoEatingAtRestaurantsWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65500")
	public void break5HabitsNoEatingAtRestaurantsUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickBreak5HabitsHeaderWeek1()
				.checkNoEatingAtRestaurantsWeek1CheckboxIsEmpty(4)
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkNoEatingAtRestaurantsWeek2CheckboxIsEmpty(4);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65501")
	public void break5HabitsContentNotEditable() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickBreak5HabitsHeaderWeek1()
				.checkContentBreak5HabitsNotEditableWeek1()
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkContentBreak5HabitsNotEditableWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65502")
	public void break5HabitsHeaderDisplayColorAndBackgroundColor() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickBreak5HabitsHeaderWeek1()
				.checkBreak5HabitsHeaderWeek1Css()
				.checkDayNumberHeaderBreak5HabitsWeek1Css()
				.clickWeek2Tab()
				.clickBreak5HabitsHeaderWeek2()
				.checkBreak5HabitsHeaderWeek2Css()
				.checkDayNumberHeaderBreak5HabitsWeek2Css();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "C65503"})
	@TestRail(id = "C65503")
	public void break5HabitsPlusAndMinusIconsDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkExpandIconOnBreak5HabitsWeek1Displayed()
				.clickWeek2Tab()
				.checkExpandIconOnBreak5HabitsWeek2Displayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65504")
	public void break5HabitsPlusAndMinusIconsOnClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickExpandIconBreak5HabitsWeek1()
				.checkMinusIconBreak5HabitsWeek1()
				.clickExpandIconBreak5HabitsWeek1()
				.checkPlusIconBreak5HabitsWeek1()
				.clickWeek2Tab()
				.clickExpandIconBreak5HabitsWeek2()
				.checkMinusIconBreak5HabitsWeek2()
				.clickExpandIconBreak5HabitsWeek2()
				.checkPlusIconBreak5HabitsWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd", "C65505"})
	@TestRail(id = "C65505")
	public void bonus5HabitsContentDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickBonus5HabitsHeaderWeek1()
				.checkBonus5HabitsWeek1CheckMarksDisplayed()
				.checkBonus5HabitsWeek1TotalsDisplayed()
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkBonus5HabitsWeek2CheckMarksDisplayed()
				.checkBonus5HabitsWeek2TotalsDisplayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65506")
	public void bonus5Habits5BonusHabits() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickBonus5HabitsHeaderWeek1()
				.checkKeepFoodRecordsTitleWeek1Displayed()
				.checkLogActivityTitleWeek1Displayed()
				.checkMoveMoreTitleWeek1Displayed()
				.checkEatRealFoodTitleWeek1Displayed()
				.checkWriteOutDailyGoalsTitleWeek1Displayed()
				.checkAmountOfCheckboxesForKeepFoodRecordsWeek1()
				.checkAmountOfCheckboxesForLogActivityWeek1()
				.checkAmountOfCheckboxesForMoveMoreWeek1()
				.checkAmountOfCheckboxesForEatRealFoodWeek1()
				.checkAmountOfCheckboxesForWriteOutDailyGoalsWeek1()
				.checkAmountOfTotalsForBonus5HabitsWeek1()
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkKeepFoodRecordsTitleWeek2Displayed()
				.checkLogActivityTitleWeek2Displayed()
				.checkMoveMoreTitleWeek2Displayed()
				.checkEatRealFoodTitleWeek2Displayed()
				.checkWriteOutDailyGoalsTitleWeek2Displayed()
				.checkAmountOfCheckboxesForKeepFoodRecordsWeek2()
				.checkAmountOfCheckboxesForLogActivityWeek2()
				.checkAmountOfCheckboxesForMoveMoreWeek2()
				.checkAmountOfCheckboxesForEatRealFoodWeek2()
				.checkAmountOfCheckboxesForWriteOutDailyGoalsWeek2()
				.checkAmountOfTotalsForBonus5HabitsWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65507")
	public void bonus5HabitsKeepFoodRecords() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabitBonus5Habits(0)
				.clickFullProgressReportLinkOnHabitTracker()
				.clickBonus5HabitsHeaderWeek1()
				.checkAmountOfTotalsForKeepFoodRecordsWeek1()
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkAmountOfTotalsForKeepFoodRecordsWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65508")
	public void bonus5HabitsKeepFoodRecordsUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickBonus5HabitsHeaderWeek1()
				.checkKeepFoodRecordsWeek1CheckboxIsEmpty(0)
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkKeepFoodRecordsWeek2CheckboxIsEmpty(0);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65509")
	public void bonus5HabitsLogActivity() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabitBonus5Habits(1)
				.clickFullProgressReportLinkOnHabitTracker()
				.clickBonus5HabitsHeaderWeek1()
				.checkAmountOfTotalsForLogActivityWeek1()
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkAmountOfTotalsForLogActivityWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65510")
	public void bonus5HabitsLogActivityUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickBonus5HabitsHeaderWeek1()
				.checkLogActivityWeek1CheckboxIsEmpty(1)
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkLogActivityWeek2CheckboxIsEmpty(1);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "C65511"})
	@TestRail(id = "C65511")
	public void bonus5HabitsMoveMore() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabitBonus5Habits(2)
				.clickFullProgressReportLinkOnHabitTracker()
				.clickBonus5HabitsHeaderWeek1()
				.checkAmountOfTotalsForMoveMoreWeek1()
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkAmountOfTotalsForMoveMoreWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65512")
	public void bonus5HabitsMoveMoreUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickBonus5HabitsHeaderWeek1()
				.checkMoveMoreWeek1CheckboxIsEmpty(2)
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkMoveMoreWeek2CheckboxIsEmpty(2);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65513")
	public void bonus5HabitsEatRealFood() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabitBonus5Habits(3)
				.clickFullProgressReportLinkOnHabitTracker()
				.clickBonus5HabitsHeaderWeek1()
				.checkAmountOfTotalsForEatRealFoodWeek1()
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkAmountOfTotalsForEatRealFoodWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65514")
	public void bonus5HabitsEatRealFoodUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickBonus5HabitsHeaderWeek1()
				.checkEatRealFoodWeek1CheckboxIsEmpty(3)
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkEatRealFoodWeek2CheckboxIsEmpty(3);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65515")
	public void bonus5HabitsWriteOutDailyGoals() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickOnDayAndHabitBonus5Habits(4)
				.clickFullProgressReportLinkOnHabitTracker()
				.clickBonus5HabitsHeaderWeek1()
				.checkAmountOfTotalsForWriteOutDailyGoalsWeek1()
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkAmountOfTotalsForWriteOutDailyGoalsWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65516")
	public void bonus5HabitsWriteOutDailyGoalsUncheck() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickBonus5HabitsHeaderWeek1()
				.checkWriteOutDailyGoalsWeek1CheckboxIsEmpty(4)
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkWriteOutDailyGoalsWeek2CheckboxIsEmpty(4);
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65517")
	public void bonus5HabitsContentNotEditable() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickBonus5HabitsHeaderWeek1()
				.checkContentBonus5HabitsNotEditableWeek1()
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkContentBonus5HabitsNotEditableWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65518")
	public void bonus5HabitsHeaderDisplayColorAndBackgroundColor() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickBonus5HabitsHeaderWeek1()
				.checkBonus5HabitsHeaderWeek1Css()
				.checkDayNumberHeaderBonus5HabitsWeek1Css()
				.clickWeek2Tab()
				.clickBonus5HabitsHeaderWeek2()
				.checkBonus5HabitsHeaderWeek2Css()
				.checkDayNumberHeaderBonus5HabitsWeek2Css();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65519")
	public void bonus5HabitsPlusAndMinusIconsDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.checkExpandIconOnBonus5HabitsWeek1Displayed()
				.clickWeek2Tab()
				.checkExpandIconOnBonus5HabitsWeek2Displayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65520")
	public void bonus5HabitsPlusAndMinusIconsOnClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickExpandIconBonus5HabitsWeek1()
				.checkMinusIconBonus5HabitsWeek1()
				.clickExpandIconBonus5HabitsWeek1()
				.checkPlusIconBonus5HabitsWeek1()
				.clickWeek2Tab()
				.clickExpandIconBonus5HabitsWeek2()
				.checkMinusIconBonus5HabitsWeek2()
				.clickExpandIconBonus5HabitsWeek2()
				.checkPlusIconBonus5HabitsWeek2();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65521")
	public void analysisTabOnClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickAnalysisTab()
				.checkAnalysisTabStaticContentDisplayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65522")
	public void analysisTabOnClickAllContent() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickAnalysisTab()
				.checkAnalysisTabAllContentDisplayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65523")
	public void analysisTabButtonDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickAnalysisTab()
				.checkStartLoseItAgainButtonDisplayed()
				.checkMoveToLiveItButtonDisplayed();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65524")
	public void analysisTabDefaultColorOfButton() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickAnalysisTab()
				.checkStartLoseItAgainButtonCss()
				.checkMoveToLiveItButtonCss();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65525")
	public void analysisTabButtonColorChangeOnHover() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickAnalysisTab()
				.checkStartLoseItAgainButtonOnHoverCss()
				.checkMoveToLiveItButtonOnHoverCss();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65526")
	public void startLoseItAgainButtonOnClick() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickAnalysisTab()
				.clickStartLoseItAgainButtonClick()
				.checkLoseItPageLoading();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "C65527"})
	@TestRail(id = "C65527")
	public void moveToLiveItButtonOnClick() {
		UserActionsMCD.registerNewUserHabitTracker()
				.clickFullProgressReportLink()
				.clickAnalysisTab()
				.clickMoveToLiveItButtonClick()
				.checkLiveItPageLoading();
	}

	@Test(groups = {"habitTracker", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65528")
	public void expandMoreThatOneHabitSection() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFullProgressReportLink()
				.clickExpandIconAdd5HabitsWeek1()
				.clickExpandIconBonus5HabitsWeek1()
				.clickExpandIconBreak5HabitsWeek1()
				.checkAllSectionsExpandedWeek1()
				.clickWeek2Tab()
				.clickExpandIconAdd5HabitsWeek2()
				.clickExpandIconBonus5HabitsWeek2()
				.clickExpandIconBreak5HabitsWeek2()
				.checkAllSectionsExpandedWeek2();
	}
}
