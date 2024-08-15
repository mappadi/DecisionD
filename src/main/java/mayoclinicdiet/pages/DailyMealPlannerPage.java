package mayoclinicdiet.pages;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class DailyMealPlannerPage extends PublicHeaderMCD {

	public DailyMealPlannerPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "daily.meal.planner";
		String CLASS_NAME = "DailyMealPlannerPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject header;
	protected WebObject currentDate;
	protected WebObject copyLink;
	protected WebObject copyButton;
	protected WebObject mealEntries;
	protected static String rememberDate;
	protected WebObject dateField;
	protected WebObject forwardArrow;
	protected WebObject backwardArrow;
	protected WebObject mealPlanDaily;
	protected WebObject viewFullWeekButton;
	protected WebObject shoppingListButton;
	protected WebObject changeYourMealTitle;
	protected WebObject addRecipesNavigation;
	protected WebObject recipeList;
	protected WebObject addRecipeIcon;
	protected WebObject mealEntriesList;
	protected int rememberAmountOfMealEntries;
	protected WebObject deleteIcon;
	protected WebObject deleteButtonOnPopup;
	protected WebObject clearAllLinkForBreakfast;
	protected WebObject saturdayDay;
	protected WebObject viewRecommendedMealsLink;
	protected WebObject breadCrumb;
	protected WebObject eatingGuidelinesSection;
	protected WebObject nutritionAtAGlanceSection;
	protected WebObject swapMealTab;
	protected WebObject closeButton;
	protected WebObject totalAmountOfRecipes;
	protected WebObject addFoodNavigation;
	protected WebObject searchFoodBox;
	protected WebObject recipesLinks;
	protected WebObject recipeDialogContent;
	protected WebObject getMoreMealsButton;
	protected WebObject recipesList;
	protected WebObject favoriteIcons;
	protected WebObject favoriteIconLarge;
	protected WebObject recipeSearchWrapper;
	protected WebObject viewAllDropDown;
	protected WebObject getMoreRecipesButton;
	protected WebObject searchFoodButton;
	protected WebObject foodItemsName;
	protected WebObject addFoodItem;
	protected WebObject totalAmountOfFoods;
	protected WebObject changeThisMealLinkList;
	protected WebObject swapMealLinks;
	protected WebObject activeMealType;
	protected WebObject deleteEntryPopup;
	protected WebObject glutenFreeOption;
	protected WebObject changeYourMealDialog;
	private static String rememberAmountOfRecipeEntries;
	private static String recipesContainerLocator = ".search-results-container.recipe-container.three-col";

	public DailyMealPlannerPage checkHeaderDisplayed() {
		Logger.info("Check 'Daily Meal Planner' header is displayed");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		boolean isHeaderDisplayed = header
				.waitUntilVisible()
				.isPresent();
		assertTrue(isHeaderDisplayed, "'Daily Meal Planner' header is not displayed");
		return this;
	}

	public DailyMealPlannerPage checkCurrentDate(String expectedDate) {
		Logger.info("Check current date is correct");
		String actualDate = currentDate
				.waitUntilVisible()
				.getText();
		assertTrue(actualDate.contains(expectedDate), "Current date is wrong");
		return this;
	}

	public DailyMealPlannerPage checkDailyMealPlanUrl() {
		Logger.info("Check 'Daily Meal Planner' page url");
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/food-fitness/DailyMealPlan"), "URL doesn't contain '/food-fitness/DailyMealPlan'");
		return this;
	}

	public DailyMealPlannerPage clickChangeThisMealLink() {
		Logger.info("Click change this meal link");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		changeThisMealLinkList.clickOnElementNumber(1);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public DailyMealPlannerPage clickSwapMealLink() {
		Logger.info("Click swap meal link");
		swapMealLinks.waitUntilClickable();
		swapMealLinks.getElements().stream().findFirst().get().click();
		changeYourMealDialog.waitUntilInvisible();
		return this;
	}

	public DailyMealPlannerPage verifyDailyPlannerDate() {
		Logger.info("Check today's date corresponds date on the Daily Planner");
		String currDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		assertEquals(currentDate.getAttribute("date"), currDate, "Displayed date is incorrect ");
		return this;
	}

	public DailyMealPlannerPage verifyDailyPlannerDateForMeal() {
		Logger.info("Check meal's date corresponds date on the Daily Planner");
		//this element is not detached from DOM in chrome
		waitForAjaxRequestToBeFinished();
		assertEquals(currentDate.getAttribute("copydate"), WeeklyMealPlannerPage.rememberDateOfMealEntry, "Displayed date is incorrect ");
		return this;
	}

	public DailyMealPlannerPage clickCopyMealEntryIconOnDailyMealPlanner() {
		Logger.info("Click copy icon on meal entry");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		mealEntries.waitElementsReady();
		waitForAjaxRequestToBeFinished();
		mealEntries.mouseHover();
		copyLink.click();
		return this;
	}

	public DailyMealPlannerPage clickCopyMealEntryButtonOnDailyMealPlanner() {
		Logger.info("Click copy button on meal entry popup");
		copyButton
				.waitUntilVisible()
				.then()
				.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public DailyMealPlannerPage rememberValues() {
		Logger.info("Remember date");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		rememberDate = dateField.getAttribute("date");
		return this;
	}

	public DailyMealPlannerPage clickOnNextDayArrow() {
		Logger.info("Click next day arrow");
		forwardArrow
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public DailyMealPlannerPage clickOnPreviousDayArrow() {
		Logger.info("Click previous day arrow");
		backwardArrow
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public DailyMealPlannerPage verifyNextDate() {
		Logger.info("Check next date correctness");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		assertEquals(WeeklyMealPlannerPage.addDaysMethod(rememberDate, 1), dateField.getAttribute("date"), "Displayed next date is incorrect ");
		return this;
	}

	public DailyMealPlannerPage checkDailyPlanDisplayed() {
		Logger.info("Check daily plan is displayed");
		boolean isDailyPlanDisplayed = mealPlanDaily
				.waitUntilVisible()
				.isPresent();
		assertTrue(isDailyPlanDisplayed, "Daily plan is not displayed");
		return this;
	}

	public DailyMealPlannerPage verifyPreviousDate() {
		Logger.info("Check previous date correctness");
		assertEquals(WeeklyMealPlannerPage.addDaysMethod(rememberDate, -1), dateField.getAttribute("date"), "Displayed previous date is incorrect ");
		return this;
	}

	public WeeklyMealPlannerPage clickOnViewFullWeekButton() {
		Logger.info("Click 'View Full Week' button");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		viewFullWeekButton
				.waitUntilVisible()
				.then()
				.click();
		return PageFactory.initElements(basedriver, WeeklyMealPlannerPage.class);
	}

	public DailyMealPlannerPage verifyTodayDate() {
		Logger.info("Check today's date correctness");
		String currDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		assertEquals(dateField.getAttribute("date"), currDate, "Displayed today's date is incorrect ");
		return this;
	}

	public ShoppingListPage clickShoppingListButton() {
		Logger.info("Click 'Shopping List' button");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		shoppingListButton
				.waitUntilVisible()
				.then()
				.click();
		return PageFactory.initElements(basedriver, ShoppingListPage.class);
	}

	public DailyMealPlannerPage checkMealType() {
		Logger.info("Check Active meal type");
		activeMealType.waitUntilClickable();
		assertEquals(activeMealType.getText(), "BREAKFAST", "Active meal type is incorrect ");
		return this;
	}

	public DailyMealPlannerPage checkChangeYourMealHeaderDisplayed() {
		Logger.info("Check Change Your Meal Header is displayed");
		boolean isChangeYourMealHeaderDisplayed = changeYourMealTitle
				.waitUntilVisible()
				.isPresent();
		assertTrue(isChangeYourMealHeaderDisplayed, "Change Your Meal Header is not displayed");
		return this;
	}

	public DailyMealPlannerPage clickOnAddRecipesTab() {
		addRecipesNavigation.waitUntilClickable();
		Logger.info("Click 'Add recipes' tab");
		addRecipesNavigation.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public DailyMealPlannerPage clickAddRecipeIcon() {
		Logger.info("Click add recipe icon");
		hoverMouseOverRecipe();
		waitForAjaxRequestToBeFinished();
		addRecipeIcon.click();
		waitForAjaxRequestToBeFinished();
		deleteEntryPopup.waitUntilInvisible();
		return this;
	}

	public int getNumberOfMealsOnPage() {
		Logger.info("Get number of meal entries on current page");
		return mealEntriesList.getNumberOfVisibleAndClickableElements();
	}

	public DailyMealPlannerPage rememberAmountOfMealEntries() {
		Logger.info("Remember amount of meal entries");
		waitForAjaxRequestToBeFinished();
		rememberAmountOfMealEntries = getNumberOfMealsOnPage();
		Logger.info("Number of meal entries is: " + rememberAmountOfMealEntries);
		return this;
	}

	public DailyMealPlannerPage refreshPage() {
		Logger.info("Refresh page");
		basedriver.navigate().refresh();
		return this;
	}

	public DailyMealPlannerPage verifyAmountOfMealEntriesChanged() {
		Logger.info("Check number of meal entries is changed");
		int numberOfMealsAfterEditing = getNumberOfMealsOnPage();
		Logger.info("New number of meal entries is: " + numberOfMealsAfterEditing);
		assertNotEquals(rememberAmountOfMealEntries, numberOfMealsAfterEditing, "Number of meal entries was not changed!");
		return this;
	}

	public DailyMealPlannerPage clickDeleteMealEntryIcon() {
		Logger.info("Click delete icon on meal entry");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		mealEntriesList.waitElementsReady();
		waitFor(1000);
		mealEntriesList.mouseHover();
		deleteIcon.click();
		return this;
	}

	public DailyMealPlannerPage clickDeleteMealEntryButton() {
		Logger.info("Click delete button on meal entry popup");
		deleteButtonOnPopup.waitUntilClickable();
		deleteButtonOnPopup
				.waitUntilVisible()
				.then()
				.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public DailyMealPlannerPage clickClearAllLink() {
		Logger.info("Click 'Clear All' link for Breakfast section");
		changeYourMealDialog.waitUntilInvisible();
		waitFor(2000);
		clearAllLinkForBreakfast.longClickWebObject();
		return this;
	}

	public DailyMealPlannerPage clickSaturdayDay() {
		Logger.info("Click Saturday on meal entry popup");
		saturdayDay
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public DailyMealPlannerPage clickViewRecommendedMealsLink() {
		Logger.info("Click 'View Recommended Meals' link");
		while (!viewRecommendedMealsLink.isPresent()) {
			clickDeleteMealEntryIcon();
			clickDeleteMealEntryButton();
		}
		waitFor(1000);
		viewRecommendedMealsLink
				.getElements()
				.parallelStream()
				.findFirst()
				.get()
				.click();
		return this;
	}

	public DailyMealPlannerPage checkBreadCrumbDisplayed() {
		Logger.info("Check 'Daily Meal Planner' bread crumb is displayed");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		boolean isTitleDisplayed = breadCrumb
				.waitUntilVisible()
				.isPresent();
		assertTrue(isTitleDisplayed, "'Daily Meal Planner' bread crumb is not displayed");
		return this;
	}

	public DailyMealPlannerPage checkEatingGuidelinesSectionDisplayed() {
		Logger.info("Check Eating guidelines section is displayed");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		boolean isEatingGuidelinesSectionDisplayed = eatingGuidelinesSection
				.waitUntilVisible()
				.isPresent();
		assertTrue(isEatingGuidelinesSectionDisplayed, "Eating guidelines section is not displayed");
		return this;
	}

	public DailyMealPlannerPage checkNutritionAtAGlanceSectionDisplayed() {
		Logger.info("Check Nutrition at a glance section is displayed");
		boolean isNutritionAtAGlanceSectionDisplayed = nutritionAtAGlanceSection
				.waitUntilVisible()
				.isPresent();
		assertTrue(isNutritionAtAGlanceSectionDisplayed, "Nutrition at a glance section is not displayed");
		return this;
	}

	public DailyMealPlannerPage checkSwapMealActive() {
		Logger.info("Check Active tab");
		assertEquals(swapMealTab.getText(), "SWAP MEAL", "Active tab is incorrect ");
		return this;
	}

	public DailyMealPlannerPage clickCloseButton() {
		Logger.info("Click close button on Change Your Meal popup");
		closeButton
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	private boolean checkIfPopupWindowClosed() {
		for (int i = 0; i < 10; i++) {
			waitFor(1000);
			Set<String> wHandle = basedriver.getWindowHandles();
			if (wHandle.size() < 2) {
				return true;
			}
		}
		return false;
	}

	public DailyMealPlannerPage checkChangeYourMealHeaderClosed() {
		Logger.info("Check Change Your Meal popup is closed");
		checkIfPopupWindowClosed();
		assertTrue(deleteEntryPopup.getAttribute("style").contains("display: none"), "Change Your Meal popup is not closed");
		return this;
	}

	public DailyMealPlannerPage checkNumberOfRecipesDisplayed() {
		Logger.info("Check Add Recipes tab is displayed");
		boolean isAddRecipesTabDisplayed = totalAmountOfRecipes
				.waitUntilVisible()
				.isPresent();
		assertTrue(isAddRecipesTabDisplayed, "Add Recipes tab is not displayed");
		return this;
	}

	public DailyMealPlannerPage clickOnAddFoodTab() {
		Logger.info("Click 'Add Food' tab");
		addFoodNavigation
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public DailyMealPlannerPage checkAddFoodTabDisplayed() {
		Logger.info("Check Add Food tab is displayed");
		boolean isAddFoodTabDisplayed = searchFoodBox
				.waitUntilVisible()
				.isPresent();
		assertTrue(isAddFoodTabDisplayed, "Add Food tab is not displayed");
		return this;
	}

	public DailyMealPlannerPage clickOnRecipe() {
		Logger.info("Click on recipe");
		recipesLinks.waitElementsReady().clickOnElementNumber(1);
		return this;
	}

	public DailyMealPlannerPage checkRecipeDialogDisplayed() {
		Logger.info("Check Recipe dialog is displayed");
		boolean isRecipeDialogDisplayed = recipeDialogContent
				.waitUntilVisible()
				.isPresent();
		assertTrue(isRecipeDialogDisplayed, "Recipe dialog is not displayed");
		return this;
	}

	public DailyMealPlannerPage scrollDown() {
		Logger.info("Scroll down to the 'Get More Meals' button");
		swapMealLinks.getElements().stream().findFirst().get();
		WebDriverWait wait = new WebDriverWait(basedriver, 10);
		WebElement element = swapMealLinks.getElements().stream().findFirst().get();
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) basedriver;
		js.executeScript("arguments[0].scrollTop = arguments[1];", basedriver.findElement(By.cssSelector(recipesContainerLocator)), 10000);
		return this;
	}

	public DailyMealPlannerPage checkGetMoreMealsButtonDisplayed() {
		Logger.info("Check 'Get More Meals' button is displayed");
		boolean isGetMoreMealsButtonDisplayed = getMoreMealsButton
				.waitUntilVisible()
				.isPresent();
		assertTrue(isGetMoreMealsButtonDisplayed, "'Get More Meals' button is not displayed");
		return this;
	}

	public DailyMealPlannerPage checkRecipesListDisplayed() {
		Logger.info("Check recipes list is displayed");
		boolean isRecipesListDisplayed = recipesList
				.waitUntilVisible()
				.isPresent();
		assertTrue(isRecipesListDisplayed, "'Get More Meals' button is not displayed");
		return this;
	}

	public DailyMealPlannerPage checkFavoriteIconsDisplayed() {
		Logger.info("Check favorite icons are displayed near recipe name");
		boolean isFavoriteIconsDisplayed = favoriteIcons
				.waitUntilVisible()
				.isPresent();
		assertTrue(isFavoriteIconsDisplayed, "Favorite icons are not displayed");
		return this;
	}

	public DailyMealPlannerPage checkAddRecipeIconDisplayed() {
		Logger.info("Check add recipe icon is displayed");
		boolean isAddRecipeIconDisplayed = addRecipeIcon
				.waitUntilVisible()
				.isPresent();
		assertTrue(isAddRecipeIconDisplayed, "Add recipe icon is not displayed");
		return this;
	}

	public DailyMealPlannerPage hoverMouseOverRecipe() {
		Logger.info("Hover mouse over recipe");
		WebElement firstElement = recipeList
				.getElements()
				.parallelStream()
				.findFirst()
				.get();
		new Actions(basedriver).moveToElement(firstElement).perform();
		return this;
	}

	public DailyMealPlannerPage checkFavoriteLargeIconDisplayed() {
		Logger.info("Check favorite large icon is displayed");
		boolean isFavoriteLargeIconDisplayed = favoriteIconLarge
				.waitUntilVisible()
				.isPresent();
		assertTrue(isFavoriteLargeIconDisplayed, "Favorite large icon is not displayed");
		return this;
	}

	public DailyMealPlannerPage clickFavoriteLargeIcon() {
		Logger.info("Click favorite large icon");
		hoverMouseOverRecipe();
		waitForAjaxRequestToBeFinished();
		favoriteIconLarge.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public DailyMealPlannerPage checkRecipeIsFavorite() {
		Logger.info("Check recipe was marked as favorite");
		String attr = recipeSearchWrapper.getAttributeOfElementNumber(1, "isfavorite");
		assertEquals(attr, "true", "Recipe is not favorite!");
		favoriteIconLarge.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public DailyMealPlannerPage scrollDownRecipes() {
		Logger.info("Scroll down to the 'Get More Recipes' button");
		totalAmountOfRecipes.waitUntilElementIsVisible();
		JavascriptExecutor js = (JavascriptExecutor) basedriver;
		js.executeScript("arguments[0].scrollTop = arguments[1];", basedriver.findElement(By.cssSelector(recipesContainerLocator)), 10000);
		return this;
	}

	public DailyMealPlannerPage checkGetMoreRecipesButtonDisplayed() {
		Logger.info("Check 'Get More Recipes' button is displayed");
		boolean isGetMoreRecipesButtonDisplayed = getMoreRecipesButton
				.waitUntilVisible()
				.isPresent();
		assertTrue(isGetMoreRecipesButtonDisplayed, "'Get More Recipes' button is not displayed");
		return this;
	}

	public DailyMealPlannerPage rememberAmountOfRecipeEntries() {
		Logger.info("Remember amount of recipe entries");
		long value = recipesList
				.getElements()
				.parallelStream()
				.count();
		rememberAmountOfRecipeEntries = String.valueOf(value);
		return this;
	}

	public DailyMealPlannerPage clickViewAllDropDown() {
		Logger.info("Click 'View All' dropdown");
		viewAllDropDown
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public DailyMealPlannerPage clickGlutenFreeInViewAllDropDown() {
		Logger.info("Click 'Gluten Free' option");
		glutenFreeOption.clickOnElementNumber(6);
		return this;
	}

	public DailyMealPlannerPage verifyAmountOfRecipeEntriesChanged() {
		Logger.info("Check Number of Recipe Entries is changed");
		long secondValue = recipesList
				.getElements()
				.parallelStream()
				.count();
		assertFalse(rememberAmountOfRecipeEntries.equals(String.valueOf(secondValue)), "Number of Recipe Entries was not changed!");
		return this;
	}

	public DailyMealPlannerPage checkSearchFoodButtonDisplayed() {
		Logger.info("Check 'Search' food button is displayed");
		boolean isSearchFoodButtonDisplayed = searchFoodButton
				.waitUntilVisible()
				.isPresent();
		assertTrue(isSearchFoodButtonDisplayed, "'Search' food button is not displayed");
		return this;
	}

	public DailyMealPlannerPage enterMealName() {
		Logger.info("Enter meal name into search box");
		searchFoodBox
				.waitUntilVisible()
				.type("Banana");
		return this;
	}

	public DailyMealPlannerPage clickSearchButton() {
		Logger.info("Click 'Search' button");
		searchFoodButton
				.waitUntilVisible()
				.then()
				.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public DailyMealPlannerPage checkAppropriateMealNameIsPresent() {
		Logger.info("Check appropriate food name is present");
		addFoodItem.waitUntilClickable();
		WebElement firstItemInResultsList = foodItemsName.getElements().parallelStream().findFirst().get();
		assertTrue(firstItemInResultsList.getText().equals("Banana"), "Appropriate food name is absent in list!");
		return this;
	}

	public DailyMealPlannerPage clickAddFoodItemIcon() {
		Logger.info("Click add food icon");
		addFoodItem.waitElementsReady().clickOnElementNumber(1);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public DailyMealPlannerPage checkAddFoodIconDisplayed() {
		Logger.info("Check add food icon is displayed");
		boolean isAddFoodIconDisplayed = addFoodItem
				.waitUntilVisible()
				.isPresent();
		assertTrue(isAddFoodIconDisplayed, "Add food icon is not displayed");
		return this;
	}

	public DailyMealPlannerPage checkNumberOfFoodsDisplayed() {
		Logger.info("Check number of foods is displayed");
		boolean isNumberOfFoodsDisplayed = totalAmountOfFoods
				.waitUntilVisible()
				.isPresent();
		assertTrue(isNumberOfFoodsDisplayed, "Total number of foods is not displayed");
		return this;
	}
}
