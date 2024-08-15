package org.mayoclinicdiet.tests;


import com.testrail.framework.platform.annotations.TestRail;
import framework.platform.SiteNavigatorMCD;
import framework.platform.UserActionsMCD;
import mayoclinicdiet.pages.HomePage;
import org.testng.annotations.Test;

public class DailyMealPlannerTest {

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C34729")
	public void dailyMealPlannerPageLoad() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.checkDailyMealPlanUrl()
				.checkHeaderDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34731")
	public void verifyBrowsByArrows() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.rememberValues()
				.clickOnNextDayArrow()
				.verifyNextDate()
				.checkDailyPlanDisplayed()
				.clickOnPreviousDayArrow()
				.clickOnPreviousDayArrow()
				.verifyPreviousDate()
				.checkDailyPlanDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34734")
	public void verifyViewFullWeekButton() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickOnViewFullWeekButton()
				.checkWeeklyMealPlanHeaderDisplayed()
				.verifyWeeklyMealPlanerTodayDate();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "C34735"})
	@TestRail(id = "C34735")
	public void verifyShoppingListButton() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickShoppingListButton()
				.checkHeaderDisplayed()
				.checkShoppingListDisplayed()
				.verifyShoppingListDate();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34737")
	public void verifyChangeThisMealLink() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.checkMealType();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd", "C34740"})
	@TestRail(id = "C34740")
	public void verifyAddedMeals() {
		UserActionsMCD.registerNewUser()
				.clickDailyMealPlanMenuLink()
				.rememberAmountOfMealEntries()
				.clickChangeThisMealLink()
				.checkChangeYourMealHeaderDisplayed()
				.clickOnAddRecipesTab()
				.clickAddRecipeIcon()
				.clickChangeThisMealLink()
				.checkChangeYourMealHeaderDisplayed()
				.clickOnAddRecipesTab()
				.clickAddRecipeIcon()
				.refreshPage()
				.verifyAmountOfMealEntriesChanged();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34741")
	public void verifyClearAllLink() {
		UserActionsMCD.registerNewUser()
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickSwapMealLink()
				.rememberAmountOfMealEntries()
				.clickClearAllLink()
				.clickDeleteMealEntryButton()
				.verifyAmountOfMealEntriesChanged();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34742")
	public void verifyDeleteIcon() {
		UserActionsMCD.registerNewUser()
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickSwapMealLink()
				.rememberAmountOfMealEntries()
				.clickDeleteMealEntryIcon()
				.clickDeleteMealEntryButton()
				.verifyAmountOfMealEntriesChanged();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "C34743"})
	@TestRail(id = "C34743")
	public void verifyCopyIcon() {
		UserActionsMCD.registerNewUser()
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickSwapMealLink()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickSaturdayDay()
				.clickCopyMealEntryButtonOnDailyMealPlanner();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34744")
	public void verifyViewRecommendedMeals() {
		UserActionsMCD.registerNewUser()
				.clickDailyMealPlanMenuLink()
				.clickViewRecommendedMealsLink()
				.checkChangeYourMealHeaderDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34745")
	public void verifyBreadCrumbs() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.checkBreadCrumbDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34746")
	public void verifyRightRail() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.checkEatingGuidelinesSectionDisplayed()
				.checkNutritionAtAGlanceSectionDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C34766")
	public void sliderDefaultView() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.checkMealType()
				.checkSwapMealActive();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34767")
	public void sliderClose() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickCloseButton()
				.checkChangeYourMealHeaderClosed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34768")
	public void sliderBrowsTabs() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickOnAddRecipesTab()
				.checkNumberOfRecipesDisplayed()
				.clickOnAddFoodTab()
				.checkAddFoodTabDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "C34770"})
	@TestRail(id = "C34770")
	public void swapMeal() {
		UserActionsMCD.registerNewUser()
				.clickDailyMealPlanMenuLink()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.clickCopyMealEntryIconOnDailyMealPlanner()
				.clickCopyMealEntryButtonOnDailyMealPlanner()
				.rememberAmountOfMealEntries()
				.clickChangeThisMealLink()
				.clickSwapMealLink()
				.verifyAmountOfMealEntriesChanged();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34771")
	public void recipeWithinMeal() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickOnRecipe()
				.checkRecipeDialogDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34781")
	public void getMoreMeals() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.scrollDown()
				.checkGetMoreMealsButtonDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C34772")
	public void addRecipesDefaultView() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickOnAddRecipesTab()
				.checkRecipesListDisplayed()
				.checkMealType();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34773")
	public void numberOfRecipes() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickOnAddRecipesTab()
				.checkNumberOfRecipesDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34774")
	public void recipeName() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickOnAddRecipesTab()
				.checkFavoriteIconsDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34775")
	public void mouseOver() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickOnAddRecipesTab()
				.hoverMouseOverRecipe()
				.checkAddRecipeIconDisplayed()
				.checkFavoriteLargeIconDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd", "C34776"})
	@TestRail(id = "C34776")
	public void favoriteRecipe() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickOnAddRecipesTab()
				.clickFavoriteLargeIcon()
				.checkRecipeIsFavorite();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd", "C34778"})
	@TestRail(id = "C34778")
	public void addRecipe() {
		UserActionsMCD.registerNewUser()
				.clickDailyMealPlanMenuLink()
				.rememberAmountOfMealEntries()
				.clickChangeThisMealLink()
				.clickOnAddRecipesTab()
				.clickAddRecipeIcon()
				.verifyAmountOfMealEntriesChanged();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34779")
	public void getMoreRecipes() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickOnAddRecipesTab()
				.scrollDownRecipes()
				.checkGetMoreRecipesButtonDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "C34780"})
	@TestRail(id = "C34780")
	public void viewAllDropDown() {
		UserActionsMCD.registerNewUser()
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickOnAddRecipesTab()
				.rememberAmountOfRecipeEntries()
				.clickViewAllDropDown()
				.clickGlutenFreeInViewAllDropDown()
				.verifyAmountOfRecipeEntriesChanged();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C34782")
	public void addFoodDefaultView() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickOnAddFoodTab()
				.checkAddFoodTabDisplayed()
				.checkSearchFoodButtonDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34783")
	public void searchResult() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.clickChangeThisMealLink()
				.clickOnAddFoodTab()
				.enterMealName()
				.clickSearchButton()
				.checkAppropriateMealNameIsPresent();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd", "C34784"})
	@TestRail(id = "C34784")
	public void addFood() {
		UserActionsMCD.registerNewUser()
				.clickDailyMealPlanMenuLink()
				.rememberAmountOfMealEntries()
				.clickChangeThisMealLink()
				.clickOnAddFoodTab()
				.enterMealName()
				.clickSearchButton()
				.clickAddFoodItemIcon()
				.verifyAmountOfMealEntriesChanged();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34785")
	public void iconsDisplay() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.rememberAmountOfMealEntries()
				.clickChangeThisMealLink()
				.clickOnAddFoodTab()
				.enterMealName()
				.clickSearchButton()
				.checkAddFoodIconDisplayed()
				.checkFavoriteIconsDisplayed();
	}

	@Test(groups = {"dailyPlanner", "MayoClinicDiet", "regressionSet", "prodRegression", "C34786"})
	@TestRail(id = "C34786")
	public void amountOfFoods() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.clickDailyMealPlanMenuLink()
				.rememberAmountOfMealEntries()
				.clickChangeThisMealLink()
				.clickOnAddFoodTab()
				.enterMealName()
				.clickSearchButton()
				.checkNumberOfFoodsDisplayed();
	}
}
