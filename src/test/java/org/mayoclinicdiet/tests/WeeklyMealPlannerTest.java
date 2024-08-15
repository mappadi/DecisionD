package org.mayoclinicdiet.tests;

import com.testrail.framework.platform.annotations.TestRail;
import framework.platform.SiteNavigatorMCD;
import framework.platform.UserActionsMCD;
import mayoclinicdiet.pages.HomePage;
import org.testng.annotations.Test;

public class WeeklyMealPlannerTest {

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C34692")
	public void weeklyMealPlannerPageLoad() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickWeeklyMealPlanMenuLink()
				.checkWeeklyMealPlanUrl();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C34693")
	public void weeklyMealPlannerDefaultView() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickWeeklyMealPlanMenuLink()
				.checkWeeklyMealPlanHeaderDisplayed();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34694")
	public void verifyTodayDate() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickWeeklyMealPlanMenuLink()
				.verifyWeeklyMealPlanerTodayDate();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C34695")
	public void verifyDateRange() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickWeeklyMealPlanMenuLink()
				.checkDateRangeDisplayed();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34697")
	public void verifyBrowsByArrows() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickWeeklyMealPlanMenuLink()
				.rememberValues()
				.clickOnNextWeekArrow()
				.verifyNextWeekDates()
				.checkMealItemsDisplayed()
				.clickOnPreviousWeekArrow()
				.clickOnPreviousWeekArrow()
				.verifyPreviousWeekDates()
				.checkMealItemsDisplayed();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression", "C34698"})
	@TestRail(id = "C34698")
	public void verifyDeleteMealEntry() {
		UserActionsMCD.registerNewUser()
				.clickWeeklyMealPlanMenuLink()
				.clickCopyMealEntryIcon()
				.clickCopyMealEntryButton()
				.rememberAmountOfMealEntries()
				.clickDeleteMealEntryIcon()
				.clickDeleteMealEntryButton()
				.verifyAmountOfMealEntriesChanged();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression", "C34699"})
	@TestRail(id = "C34699")
	public void verifyAddMealEntry() {
		UserActionsMCD.registerNewUser()
				.clickWeeklyMealPlanMenuLink()
				.rememberAmountOfMealEntries()
				.clickDailyMealPlanMenuLink()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.clickWeeklyMealPlanMenuLink()
				.verifyAmountOfMealEntriesChanged();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34700")
	public void verifyCopyBeforeRefresh() {
		UserActionsMCD.registerNewUser()
				.clickWeeklyMealPlanMenuLink()
				.rememberAmountOfMealEntries()
				.clickCopyMealEntryIcon()
				.clickSaturdayDay()
				.clickCopyMealEntryButton()
				.verifyAmountOfMealEntriesChanged();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34701")
	public void verifyCopyAfterRefresh() {
		UserActionsMCD.registerNewUser()
				.clickWeeklyMealPlanMenuLink()
				.rememberAmountOfMealEntries()
				.clickCopyMealEntryIcon()
				.clickSaturdayDay()
				.clickCopyMealEntryButton()
				.refreshPage()
				.verifyAmountOfMealEntriesChanged();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34702")
	public void verifyViewByDayButton() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickWeeklyMealPlanMenuLink()
				.clickViewByDayButton()
				.checkHeaderDisplayed()
				.verifyTodayDate();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34703")
	public void verifyEditLink() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickWeeklyMealPlanMenuLink()
				.clickEditLink()
				.checkHeaderDisplayed()
				.verifyDailyPlannerDate();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression", "C34704"})
	@TestRail(id = "C34704")
	public void verifyBrowseByMealFunctionality() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickWeeklyMealPlanMenuLink()
				.rememberDate()
				.clickOnMealEntry()
				.verifyDailyPlannerDateForMeal();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34705")
	public void verifyBreadCrumb() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickWeeklyMealPlanMenuLink()
				.checkBreadCrumbDisplayed();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd", "C34706"})
	@TestRail(id = "C34706")
	public void verifyViewMoreFunctionalityAdd() {
		UserActionsMCD.registerNewUser()
				.clickWeeklyMealPlanMenuLink()
				.clickOnMealEntry()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.clickWeeklyMealPlanMenuLink()
				.checkViewMoreLinkDisplayed();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd", "C34707"})
	@TestRail(id = "C34707")
	public void verifyViewMoreFunctionalityDelete() {
		UserActionsMCD.registerNewUser()
				.clickWeeklyMealPlanMenuLink()
				.clickOnMealEntry()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.refreshPage()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.refreshPage()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.clickWeeklyMealPlanMenuLink()
				.clickDeleteMealEntryIcon()
				.clickDeleteMealEntryButton()
				.clickDeleteMealEntryIcon()
				.clickDeleteMealEntryButton()
				.checkViewMoreLinkDisplayed();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C34726")
	public void verifyGoToTodayButton() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickWeeklyMealPlanMenuLink()
				.checkGoToTodayButton();
	}

	@Test(groups = {"planner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34727")
	public void verifyShoppingList() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickWeeklyMealPlanMenuLink()
				.splitDateRange()
				.clickShoppingListButton()
				.checkHeaderDisplayed()
				.checkShoppingListDisplayed()
				.verifyShoppingListDateRange();
	}
}
