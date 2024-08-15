package mayoclinicdiet.pages;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class WeeklyMealPlannerPage extends PublicHeaderMCD {

	public WeeklyMealPlannerPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "weekly.meal.planner";
		String CLASS_NAME = "WeeklyMealPlannerPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject header;
	protected WebObject breadCrumb;
	protected WebObject todayDay;
	protected WebObject todayMonth;
	protected WebObject todayDate;
	protected WebObject dateRange;
	protected WebObject forwardArrow;
	protected WebObject backwardArrow;
	protected static String rememberStartDate;
	protected static String rememberEndDate;
	protected WebObject mealItems;
	protected WebObject mealEntriesList;
	protected WebObject breakfastCells;
	protected WebObject deleteIcon;
	protected WebObject deleteButtonOnPopup;
	protected int rememberAmountOfMealEntries;
	protected WebObject copyLink;
	protected WebObject copyButton;
	protected WebObject saturdayDay;
	protected WebObject viewByDayButton;
	protected WebObject editTodayLink;
	protected static String rememberDateOfMealEntry;
	protected WebObject viewMoreLink;
	protected WebObject goToTodayButton;
	protected WebObject shoppingListButton;
	public static String[] splited;
	private static String dateRowLocator = ".date-row";

	public WeeklyMealPlannerPage checkWeeklyMealPlanUrl() {
		Logger.info("Check 'Weekly Meal Planner' page url");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/food-fitness/WeeklyMealPlan"), "URL doesn't contain '/food-fitness/WeeklyMealPlan'");
		return this;
	}

	public WeeklyMealPlannerPage checkWeeklyMealPlanHeaderDisplayed() {
		Logger.info("Check 'Weekly Meal Planner' header is displayed");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		boolean isHeaderDisplayed = header
				.waitUntilVisible()
				.isPresent();
		assertTrue(isHeaderDisplayed, "'Weekly Meal Planner' header is not displayed");
		return this;
	}

	public WeeklyMealPlannerPage checkBreadCrumbDisplayed() {
		Logger.info("Check 'Weekly Meal Planner' bread crumb is displayed");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		boolean isTitleDisplayed = breadCrumb
				.waitUntilVisible()
				.isPresent();
		assertTrue(isTitleDisplayed, "'Weekly Meal Planner' bread crumb is not displayed");
		return this;
	}

	public WeeklyMealPlannerPage verifyWeeklyMealPlanerTodayDate() {
		Logger.info("Check today's date corresponds date on the tab");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String currDayOfWeek = new SimpleDateFormat("EE", Locale.US).format(date.getTime()).toUpperCase();
		assertEquals(todayDay.getText(), currDayOfWeek, "Displayed day of week is incorrect ");
		String currMonth = new SimpleDateFormat("MMM", Locale.US).format(date.getTime()).toUpperCase();
		assertEquals(todayMonth.getText(), currMonth, "Displayed month is incorrect ");
		String currDate = new SimpleDateFormat("dd", Locale.US).format(date.getTime());
		assertEquals(todayDate.getText(), currDate, "Displayed date is incorrect ");
		return this;
	}

	public WeeklyMealPlannerPage checkDateRangeDisplayed() {
		Logger.info("Check date range is displayed");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		boolean isDateRangeDisplayed = dateRange
				.waitUntilVisible()
				.isPresent();
		assertTrue(isDateRangeDisplayed, "Date range is not displayed");
		return this;
	}

	public WeeklyMealPlannerPage clickOnNextWeekArrow() {
		Logger.info("Click next week arrow");
		forwardArrow
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public WeeklyMealPlannerPage clickOnPreviousWeekArrow() {
		Logger.info("Click previous week arrow");
		backwardArrow
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public static String addDaysMethod(String date, int amount) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.add(Calendar.DATE, amount);
		return dateFormat.format(cal.getTime());
	}

	public WeeklyMealPlannerPage verifyNextWeekDates() {
		Logger.info("Check next week dates correctness");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		assertEquals(addDaysMethod(rememberStartDate, 7), dateRange.getAttribute("sdate"), "Displayed next start date is incorrect ");
		assertEquals(addDaysMethod(rememberEndDate, 7), dateRange.getAttribute("edate"), "Displayed next end date is incorrect ");
		return this;
	}

	public WeeklyMealPlannerPage rememberValues() {
		Logger.info("Remember this week dates");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		rememberStartDate = dateRange.getAttribute("sdate");
		rememberEndDate = dateRange.getAttribute("edate");
		return this;
	}

	public WeeklyMealPlannerPage verifyPreviousWeekDates() {
		Logger.info("Check previous week dates correctness");
		assertEquals(addDaysMethod(rememberStartDate, -7), dateRange.getAttribute("sdate"), "Displayed previous start date is incorrect ");
		assertEquals(addDaysMethod(rememberEndDate, -7), dateRange.getAttribute("edate"), "Displayed previous end date is incorrect ");
		return this;
	}

	public WeeklyMealPlannerPage checkMealItemsDisplayed() {
		Logger.info("Check meal items are displayed");
		boolean isMealItemsDisplayed = mealItems
				.waitUntilVisible()
				.isPresent();
		assertTrue(isMealItemsDisplayed, "Meal items are not displayed");
		return this;
	}

	public WeeklyMealPlannerPage clickDeleteMealEntryIcon() {
		Logger.info("Click delete icon on meal entry");
		new Actions(basedriver).moveToElement(breakfastCells.getFirstElementFromList()).perform();
		waitForAjaxRequestToBeFinished();
		deleteIcon.actionClick();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public WeeklyMealPlannerPage clickDeleteMealEntryButton() {
		Logger.info("Click delete button on meal entry popup");
		deleteButtonOnPopup.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public WeeklyMealPlannerPage rememberAmountOfMealEntries() {
		Logger.info("Remember amount of meal entries");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		rememberAmountOfMealEntries = breakfastCells.getNumberOfVisibleAndClickableElements();
		Logger.info("Amount of breakfast meal entries on page: " + rememberAmountOfMealEntries);
		return this;
	}

	public WeeklyMealPlannerPage verifyAmountOfMealEntriesChanged() {
		Logger.info("Check Meal entry is deleted");
		waitForAjaxRequestToBeFinished();
		int numberOfMealEntriesAfterDeleting = breakfastCells.getNumberOfVisibleAndClickableElements();
		Logger.info("Amount of breakfast meal entries on page after deleting: " + numberOfMealEntriesAfterDeleting);
		assertNotEquals(rememberAmountOfMealEntries, numberOfMealEntriesAfterDeleting, "Meal Entry was not deleted!");
		return this;
	}

	public WeeklyMealPlannerPage clickCopyMealEntryIcon() {
		Logger.info("Click copy icon on meal entry");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		new Actions(basedriver).moveToElement(breakfastCells.getFirstElementFromList()).perform();
		waitForAjaxRequestToBeFinished();
		copyLink.click();
		return this;
	}

	public WeeklyMealPlannerPage clickCopyMealEntryButton() {
		Logger.info("Click copy button on meal entry popup");
		copyButton
				.waitUntilVisible()
				.then()
				.click();
		waitFor(1000);
		return this;
	}

	public WeeklyMealPlannerPage clickSaturdayDay() {
		Logger.info("Click Saturday on meal entry popup");
		saturdayDay
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public WeeklyMealPlannerPage refreshPage() {
		Logger.info("Refresh page");
		basedriver.navigate().refresh();
		return this;
	}

	public DailyMealPlannerPage clickViewByDayButton() {
		Logger.info("Click 'View By Day' button");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		viewByDayButton
				.waitUntilVisible()
				.then()
				.click();
		return PageFactory.initElements(basedriver, DailyMealPlannerPage.class);
	}

	public DailyMealPlannerPage clickEditLink() {
		Logger.info("Click edit link for Today's day");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		editTodayLink
				.waitUntilVisible()
				.then()
				.click();
		return PageFactory.initElements(basedriver, DailyMealPlannerPage.class);
	}

	public WeeklyMealPlannerPage rememberDate() {
		Logger.info("Remember meal entry date");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		rememberDateOfMealEntry = mealItems
				.getElements()
				.parallelStream()
				.findFirst()
				.get()
				.getAttribute("id");
		return this;
	}

	public DailyMealPlannerPage clickOnMealEntry() {
		Logger.info("Click on meal entry");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		mealEntriesList.clickOnElementNumber(1);
		return PageFactory.initElements(basedriver, DailyMealPlannerPage.class);
	}

	public WeeklyMealPlannerPage checkViewMoreLinkDisplayed() {
		Logger.info("Check 'view more' link is displayed");
		boolean isViewMoreLinkDisplayed = viewMoreLink
				.waitUntilVisible()
				.isPresent();
		assertTrue(isViewMoreLinkDisplayed, "'view more' link is not displayed");
		return this;
	}

	private boolean compareDays(String firstDate, String secondDate) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM-d-yyyy");
			return sdf.parse(firstDate).compareTo(sdf.parse(secondDate)) == 0;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	public WeeklyMealPlannerPage checkGoToTodayButton() {
		Logger.info("Check 'Go To Today' button takes user to today's meal planner ");
		String currDate = new SimpleDateFormat("MM-d-yyyy").format(new Date());
		Optional<WebElement> el = basedriver.findElements(By.cssSelector(dateRowLocator)).stream().filter(element -> compareDays(element.getAttribute("id"), currDate)).findFirst();
		if (el.isPresent()) {
			JavascriptExecutor executor = (JavascriptExecutor) basedriver;
			Long startPos = (Long) executor.executeScript("return window.pageYOffset;");
			goToTodayButton
					.waitUntilVisible()
					.then()
					.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Long value = (Long) executor.executeScript("return window.pageYOffset;");
			assertNotEquals(startPos, value, "User isn't taken to today's meal planner");
		}
		return this;
	}

	public ShoppingListPage clickShoppingListButton() {
		Logger.info("Click 'Shopping List' button");
		shoppingListButton
				.waitUntilVisible()
				.then()
				.click();
		return PageFactory.initElements(basedriver, ShoppingListPage.class);
	}

	public WeeklyMealPlannerPage splitDateRange() {
		Logger.info("Split date range");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		splited = dateRange.getText().split("\\s+");
		return this;
	}
}
