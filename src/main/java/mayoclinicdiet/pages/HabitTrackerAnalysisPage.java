package mayoclinicdiet.pages;


import framework.BrowserType;
import framework.Logger;
import framework.Settings;
import framework.platform.Environment;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HabitTrackerAnalysisPage extends PublicHeaderMCD {

	public HabitTrackerAnalysisPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "habitTracker";
		String CLASS_NAME = "HabitTrackerAnalysisPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject habitAnalysisSection;
	protected WebObject yourHabitTrackerTitle;
	protected WebObject yourHabitTrackerPart;
	protected WebObject returnToHomePageButton;
	protected WebObject week1Tab;
	protected WebObject week2Tab;
	protected WebObject analysisTab;
	protected WebObject add5HabitsAnalysisTableWeek1;
	protected WebObject break5HabitsAnalysisTableWeek1;
	protected WebObject bonus5HabitsAnalysisTableWeek1;
	protected WebObject add5HabitsAnalysisTableWeek2;
	protected WebObject break5HabitsAnalysisTableWeek2;
	protected WebObject bonus5HabitsAnalysisTableWeek2;
	protected WebObject checkboxFieldAdd5HabitsWeek1;
	protected WebObject totalValueAdd5HabitsWeek1;
	protected WebObject checkboxFieldAdd5HabitsWeek2;
	protected WebObject totalValueAdd5HabitsWeek2;
	protected WebObject eatAHealthyBreakfastWeek1Title;
	protected WebObject eatVegetablesWeek1Title;
	protected WebObject eatWholeGrainsWeek1Title;
	protected WebObject eatHealthyFatsWeek1Title;
	protected WebObject moveWeek1Title;
	protected WebObject eatVegetablesWeek1Checkboxes;
	protected WebObject eatWholeGrainsWeek1Checkboxes;
	protected WebObject eatHealthyFatsWeek1Checkboxes;
	protected WebObject moveWeek1Checkboxes;
	protected WebObject totalsFieldsWeek1;
	protected WebObject eatAHealthyBreakfastWeek2Title;
	protected WebObject eatVegetablesWeek2Title;
	protected WebObject eatWholeGrainsWeek2Title;
	protected WebObject eatHealthyFatsWeek2Title;
	protected WebObject moveWeek2Title;
	protected WebObject eatVegetablesWeek2Checkboxes;
	protected WebObject eatWholeGrainsWeek2Checkboxes;
	protected WebObject eatHealthyFatsWeek2Checkboxes;
	protected WebObject moveWeek2Checkboxes;
	protected WebObject totalsFieldsWeek2;
	protected WebObject eatAHealthyBreakfastWeek1CheckboxFlag;
	protected WebObject eatAHealthyBreakfastWeek2CheckboxFlag;
	protected WebObject totalValueEatVegetablesWeek1;
	protected WebObject totalValueEatVegetablesWeek2;
	protected WebObject eatVegetablesWeek1CheckboxFlag;
	protected WebObject eatVegetablesWeek2CheckboxFlag;
	protected WebObject totalValueEatWholeGrainsWeek1;
	protected WebObject totalValueEatWholeGrainsWeek2;
	protected WebObject eatWholeGrainsWeek1CheckboxFlag;
	protected WebObject eatWholeGrainsWeek2CheckboxFlag;
	protected WebObject totalValueEatHealthyFatsWeek1;
	protected WebObject totalValueEatHealthyFatsWeek2;
	protected WebObject eatHealthyFatsWeek1CheckboxFlag;
	protected WebObject eatHealthyFatsWeek2CheckboxFlag;
	protected WebObject totalValueMoveWeek1;
	protected WebObject totalValueMoveWeek2;
	protected WebObject moveWeek1CheckboxFlag;
	protected WebObject moveWeek2CheckboxFlag;
	protected WebObject add5HabitsHeaderWeek1;
	protected WebObject add5HabitsHeaderWeek2;
	protected WebObject dayNumberHeaderWeek1;
	protected WebObject dayNumberHeaderWeek2;
	protected WebObject dayNumbersAllWeek1;
	protected WebObject dayNumbersAllWeek2;
	protected WebObject expandIconAdd5HabitsWeek1;
	protected WebObject expandIconAdd5HabitsWeek2;
	protected WebObject tableCellsAdd5HabitsWeek1;
	protected WebObject tableCellsAdd5HabitsWeek2;
	protected WebObject break5HabitsHeaderWeek1;
	protected WebObject break5HabitsHeaderWeek2;
	protected WebObject checkboxFieldBreak5HabitsWeek1;
	protected WebObject totalValueBreak5HabitsWeek1;
	protected WebObject checkboxFieldBreak5HabitsWeek2;
	protected WebObject totalValueBreak5HabitsWeek2;
	protected WebObject noTVWhileEatingWeek1Title;
	protected WebObject noSugarWeek1Title;
	protected WebObject noSnacksWeek1Title;
	protected WebObject moderateMeatAndLowFatDairyWeek1Title;
	protected WebObject noEatingAtRestaurantsWeek1Title;
	protected WebObject noSugarWeek1Checkboxes;
	protected WebObject noSnacksWeek1Checkboxes;
	protected WebObject moderateMeatAndLowFatDairyWeek1Checkboxes;
	protected WebObject noEatingAtRestaurantsWeek1Checkboxes;
	protected WebObject totalsFieldsBreak5HabitsWeek1;
	protected WebObject noTVWhileEatingWeek2Title;
	protected WebObject noSugarWeek2Title;
	protected WebObject noSnacksWeek2Title;
	protected WebObject moderateMeatAndLowFatDairyWeek2Title;
	protected WebObject noEatingAtRestaurantsWeek2Title;
	protected WebObject noSugarWeek2Checkboxes;
	protected WebObject noSnacksWeek2Checkboxes;
	protected WebObject moderateMeatAndLowFatDairyWeek2Checkboxes;
	protected WebObject noEatingAtRestaurantsWeek2Checkboxes;
	protected WebObject totalsFieldsBreak5HabitsWeek2;
	protected WebObject noTVWhileEatingWeek1CheckboxFlag;
	protected WebObject noTVWhileEatingWeek2CheckboxFlag;
	protected WebObject totalValueNoSugarWeek1;
	protected WebObject totalValueNoSugarWeek2;
	protected WebObject noSugarWeek1CheckboxFlag;
	protected WebObject noSugarWeek2CheckboxFlag;
	protected WebObject totalValueNoSnacksWeek1;
	protected WebObject totalValueNoSnacksWeek2;
	protected WebObject noSnacksWeek1CheckboxFlag;
	protected WebObject noSnacksWeek2CheckboxFlag;
	protected WebObject totalValueModerateMeatAndLowFatDairyWeek1;
	protected WebObject totalValueModerateMeatAndLowFatDairyWeek2;
	protected WebObject moderateMeatAndLowFatDairyWeek1CheckboxFlag;
	protected WebObject moderateMeatAndLowFatDairyWeek2CheckboxFlag;
	protected WebObject totalValueNoEatingAtRestaurantsWeek1;
	protected WebObject totalValueNoEatingAtRestaurantsWeek2;
	protected WebObject noEatingAtRestaurantsWeek1CheckboxFlag;
	protected WebObject noEatingAtRestaurantsWeek2CheckboxFlag;
	protected WebObject tableCellsBreak5HabitsWeek1;
	protected WebObject tableCellsBreak5HabitsWeek2;
	protected WebObject dayNumberBreak5HabitsHeaderWeek1;
	protected WebObject dayNumberBreak5HabitsHeaderWeek2;
	protected WebObject dayNumbersAllBreak5HabitsWeek1;
	protected WebObject dayNumbersAllBreak5HabitsWeek2;
	protected WebObject expandIconBreak5HabitsWeek1;
	protected WebObject expandIconBreak5HabitsWeek2;
	protected WebObject bonus5HabitsHeaderWeek1;
	protected WebObject bonus5HabitsHeaderWeek2;
	protected WebObject checkboxFieldBonus5HabitsWeek1;
	protected WebObject checkboxFieldBonus5HabitsWeek2;
	protected WebObject totalValueBonus5HabitsWeek1;
	protected WebObject totalValueBonus5HabitsWeek2;
	protected WebObject keepFoodRecordsWeek1Title;
	protected WebObject logActivityWeek1Title;
	protected WebObject moveMoreWeek1Title;
	protected WebObject eatRealFoodWeek1Title;
	protected WebObject writeOutDailyGoalsWeek1Title;
	protected WebObject logActivityWeek1Checkboxes;
	protected WebObject moveMoreWeek1Checkboxes;
	protected WebObject eatRealFoodWeek1Checkboxes;
	protected WebObject writeOutDailyGoalsWeek1Checkboxes;
	protected WebObject totalsFieldsBonus5HabitsWeek1;
	protected WebObject keepFoodRecordsWeek2Title;
	protected WebObject logActivityWeek2Title;
	protected WebObject moveMoreWeek2Title;
	protected WebObject eatRealFoodWeek2Title;
	protected WebObject writeOutDailyGoalsWeek2Title;
	protected WebObject logActivityWeek2Checkboxes;
	protected WebObject moveMoreWeek2Checkboxes;
	protected WebObject eatRealFoodWeek2Checkboxes;
	protected WebObject writeOutDailyGoalsWeek2Checkboxes;
	protected WebObject totalsFieldsBonus5HabitsWeek2;
	protected WebObject keepFoodRecordsWeek1CheckboxFlag;
	protected WebObject keepFoodRecordsWeek2CheckboxFlag;
	protected WebObject totalValueLogActivityWeek1;
	protected WebObject totalValueLogActivityWeek2;
	protected WebObject logActivityWeek1CheckboxFlag;
	protected WebObject logActivityWeek2CheckboxFlag;
	protected WebObject totalValueMoveMoreWeek1;
	protected WebObject totalValueMoveMoreWeek2;
	protected WebObject moveMoreWeek1CheckboxFlag;
	protected WebObject moveMoreWeek2CheckboxFlag;
	protected WebObject totalValueEatRealFoodWeek1;
	protected WebObject totalValueEatRealFoodWeek2;
	protected WebObject eatRealFoodWeek1CheckboxFlag;
	protected WebObject eatRealFoodWeek2CheckboxFlag;
	protected WebObject totalValueWriteOutDailyGoalsWeek1;
	protected WebObject totalValueWriteOutDailyGoalsWeek2;
	protected WebObject writeOutDailyGoalsWeek1CheckboxFlag;
	protected WebObject writeOutDailyGoalsWeek2CheckboxFlag;
	protected WebObject tableCellsBonus5HabitsWeek1;
	protected WebObject tableCellsBonus5HabitsWeek2;
	protected WebObject dayNumberBonus5HabitsHeaderWeek1;
	protected WebObject dayNumberBonus5HabitsHeaderWeek2;
	protected WebObject dayNumbersAllBonus5HabitsWeek1;
	protected WebObject dayNumbersAllBonus5HabitsWeek2;
	protected WebObject expandIconBonus5HabitsWeek1;
	protected WebObject expandIconBonus5HabitsWeek2;
	protected WebObject analysisTabStaticContent;
	protected WebObject analysisTabAllContent;
	protected WebObject startLoseItAgainButton;
	protected WebObject moveToLiveItButton;
	protected WebObject add5HabitsTableWeek1;
	protected WebObject break5HabitsTableWeek1;
	protected WebObject bonus5HabitsTableWeek1;
	protected WebObject add5HabitsTableWeek2;
	protected WebObject break5HabitsTableWeek2;
	protected WebObject bonus5HabitsTableWeek2;
	private static String whiteColor = "rgba(255, 255, 255, 1)";
	private static String greyColor = "rgba(196, 195, 193, 1)";
	private static String darkGreyColor = "rgba(122, 122, 122, 1)";
	private static String greenColor = "rgba(66, 173, 43, 1)";
	private static String lightGreenColor = "rgba(81, 205, 53, 1)";
	private static String purpleColor = "rgba(194, 45, 143, 1)";
	private static String lightPurpleColor = "rgba(229, 94, 180, 1)";
	private static String orangeColor = "rgba(246, 184, 22, 1)";
	private static String lightOrangeColor = "rgba(255, 205, 74, 1)";
	private static String deepOrangeColor = "rgba(255, 80, 1, 1)";
	private static String darkOrangeColor = "rgba(210, 65, 2, 1)";
	private static String hidedTableStyle = "display:none;";

	public HabitTrackerAnalysisPage checkPageIsLoaded() {
		Logger.info("Check Habit Tracker Analysis page is loaded");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		boolean isPageLoaded =
				habitAnalysisSection
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isPageLoaded, "Habit Tracker Analysis page is not loaded");
		return this;
	}

	public HabitTrackerAnalysisPage checkHabitTrackerTitleDisplayed() {
		Logger.info("Check 'Your Habit Tracker | Full Progress Report' title is displayed");
		boolean isHabitTrackerTitleDisplayed =
				yourHabitTrackerTitle
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isHabitTrackerTitleDisplayed, "'Your Habit Tracker | Full Progress Report' title is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkTitleCss() {
		Logger.info("Check 'Your Habit Tracker | Full Progress Report' title colour");
		yourHabitTrackerTitle.waitUntilVisible();
		String textColor = yourHabitTrackerTitle
				.getCssValue("color");
		assertEquals(textColor, whiteColor, "The colour of the 'Your Habit Tracker | Full Progress Report' title doesn't correspond to mock-up");

		Logger.info("Check 'Your Habit Tracker' font-weight");
		String yourHabitTrackerStyle = yourHabitTrackerPart
				.getCssValue("font-weight");
		if (Settings.browser.equals(BrowserType.CHROME)) {
			assertEquals(yourHabitTrackerStyle, "bold", "'Your Habit Tracker' font-weight doesn't correspond to mock-up");
		} else {
			assertEquals(yourHabitTrackerStyle, "700", "'Your Habit Tracker' font-weight doesn't correspond to mock-up");
		}
		return this;
	}

	public HabitTrackerAnalysisPage checkReturnToHomePageButtonDisplayed() {
		Logger.info("Check 'Return to home page' button is displayed");
		boolean isReturnToHomePageButtonDisplayed =
				returnToHomePageButton
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isReturnToHomePageButtonDisplayed, "'Return to home page' button is not displayed");
		return this;
	}

	public HomePage clickReturnToHomePageButton() {
		Logger.info("Click 'Return to home page' button");
		returnToHomePageButton
				.waitUntilVisible()
				.then()
				.click();
		return PageFactory.initElements(basedriver, HomePage.class);
	}

	public HabitTrackerAnalysisPage checkReturnToHomePageButtonCss() {
		Logger.info("Check 'Return to home page' button font colour");
		returnToHomePageButton.waitUntilVisible();
		String textColor = returnToHomePageButton
				.getCssValue("color");
		assertEquals(textColor, whiteColor, "The colour of the 'Return to home page' button doesn't correspond to mock-up");

		Logger.info("Check 'Return to home page' button font-size");
		String buttonFontSize = returnToHomePageButton
				.getCssValue("font-size");
		assertEquals(buttonFontSize, "13px", "'Return to home page' button font-size doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkWeek1TabDisplayed() {
		Logger.info("Check 'Week 1' tab is displayed");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		boolean isWeek1TabDisplayed =
				week1Tab
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isWeek1TabDisplayed, "'Week 1' tab is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkWeek2TabDisplayed() {
		Logger.info("Check 'Week 2' tab is displayed");
		boolean isWeek2TabDisplayed =
				week2Tab
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isWeek2TabDisplayed, "'Week 2' tab is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAnalysisTabDisplayed() {
		Logger.info("Check 'Analysis' tab is displayed");
		boolean isAnalysisTabDisplayed =
				analysisTab
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isAnalysisTabDisplayed, "'Analysis' tab is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkActiveTab() {
		Logger.info("Check active tab is tab 'Week 1'");
		week1Tab.waitUntilVisible();
		assertTrue(week1Tab.getAttribute("class").contains("active"), "Active tab is not 'Week 1'");
		return this;
	}

	public HabitTrackerAnalysisPage checkWeek1TabCss() {
		Logger.info("Check 'Week 1' tab font colour");
		week1Tab.waitUntilVisible();
		String textColorWeek1 = week1Tab
				.getCssValue("color");
		assertEquals(textColorWeek1, whiteColor, "The font colour of the 'Week 1' tab doesn't correspond to mock-up");

		Logger.info("Check 'Week 1' tab background colour");
		String backgroundColorWeek1 = week1Tab
				.getCssValue("background-color");
		assertEquals(backgroundColorWeek1, greyColor, "The background colour of the 'Week 1' tab doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkWeek2TabCss() {
		Logger.info("Check 'Week 2' tab font colour");
		String textColorWeek2 = week2Tab
				.getCssValue("color");
		assertEquals(textColorWeek2, darkGreyColor, "The font colour of the 'Week 2' tab doesn't correspond to mock-up");

		Logger.info("Check 'Week 2' tab background colour");
		String backgroundColorWeek2 = week2Tab
				.getCssValue("background-color");
		assertEquals(backgroundColorWeek2, whiteColor, "The background colour of the 'Week 2' tab doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkAnalysisTabCss() {
		Logger.info("Check 'Analysis' tab font colour");
		String textColorAnalysisTab = analysisTab
				.getCssValue("color");
		assertEquals(textColorAnalysisTab, darkGreyColor, "The font colour of the 'Analysis' tab doesn't correspond to mock-up");

		Logger.info("Check 'Analysis' tab background colour");
		String backgroundColorAnalysisTab = analysisTab
				.getCssValue("background-color");
		assertEquals(backgroundColorAnalysisTab, whiteColor, "The background colour of the 'Analysis' tab doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage clickWeek1Tab() {
		Logger.info("Click 'Week 1' tab");
		week1Tab
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public HabitTrackerAnalysisPage clickWeek2Tab() {
		Logger.info("Click 'Week 2' tab");
		week2Tab
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public HabitTrackerAnalysisPage clickAnalysisTab() {
		Logger.info("Click 'Analysis' tab");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		analysisTab
				.waitUntilVisible()
				.then()
				.click();
		return this;
	}

	public HabitTrackerAnalysisPage checkWeek2TabCssOnClick() {
		Logger.info("Check 'Week 2' tab font colour");
		String textColorWeek2 = week2Tab
				.getCssValue("color");
		assertEquals(textColorWeek2, whiteColor, "The font colour of the 'Week 2' tab doesn't correspond to mock-up");

		Logger.info("Check 'Week 2' tab background colour");
		String backgroundColorWeek2 = week2Tab
				.getCssValue("background-color");
		assertEquals(backgroundColorWeek2, greyColor, "The background colour of the 'Week 2' tab doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkAnalysisTabCssOnClick() {
		Logger.info("Check 'Analysis' tab font colour");
		String textColorAnalysisTab = analysisTab
				.getCssValue("color");
		assertEquals(textColorAnalysisTab, whiteColor, "The font colour of the 'Analysis' tab doesn't correspond to mock-up");

		Logger.info("Check 'Analysis' tab background colour");
		String backgroundColorAnalysisTab = analysisTab
				.getCssValue("background-color");
		assertEquals(backgroundColorAnalysisTab, greyColor, "The background colour of the 'Analysis' tab doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkAdd5HabitsAnalysisTableWeek1Displayed() {
		Logger.info("Check Add 5 Habits Analysis Table is displayed");
		assertTrue(add5HabitsAnalysisTableWeek1.isVisible(), "Add 5 Habits Analysis Table is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkBreak5HabitsAnalysisTableWeek1IsNotDisplayed() {
		Logger.info("Check Break 5 Habits Analysis Table is not displayed");
		assertFalse(break5HabitsAnalysisTableWeek1.isVisible(), "Break 5 Habits Analysis Table is displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkBonus5HabitsAnalysisTableWeek1IsNotDisplayed() {
		Logger.info("Check Bonus 5 Habits Analysis Table is displayed");
		assertFalse(bonus5HabitsAnalysisTableWeek1.isVisible(), "Bonus 5 Habits Analysis Table is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAdd5HabitsAnalysisTableWeek2Displayed() {
		Logger.info("Check Add 5 Habits Analysis Table is displayed");
		assertTrue(add5HabitsAnalysisTableWeek2.isVisible(), "Add 5 Habits Analysis Table is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkBreak5HabitsAnalysisTableWeek2IsNotDisplayed() {
		Logger.info("Check Break 5 Habits Analysis Table is not displayed");
		assertFalse(break5HabitsAnalysisTableWeek2.isVisible(), "Break 5 Habits Analysis Table is displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkBonus5HabitsAnalysisTableWeek2IsNotDisplayed() {
		Logger.info("Check Bonus 5 Habits Analysis Table is displayed");
		assertFalse(bonus5HabitsAnalysisTableWeek2.isVisible(), "Bonus 5 Habits Analysis Table is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAdd5HabitsWeek1CheckMarksDisplayed() {
		Logger.info("Check Add 5 Habits Week 1 check marks is displayed");
		checkboxFieldAdd5HabitsWeek1.waitUntilVisible();
		assertTrue(checkboxFieldAdd5HabitsWeek1.isVisible(), "Add 5 Habits Week 1 check marks are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAdd5HabitsWeek1TotalsDisplayed() {
		Logger.info("Check Add 5 Habits Week 1 totals is displayed");
		assertTrue(totalValueAdd5HabitsWeek1.isVisible(), "Add 5 Habits Week 1 totals are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAdd5HabitsWeek2CheckMarksDisplayed() {
		Logger.info("Check Add 5 Habits Week 2 check marks is displayed");
		assertTrue(checkboxFieldAdd5HabitsWeek2.isVisible(), "Add 5 Habits Week 2 check marks are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAdd5HabitsWeek2TotalsDisplayed() {
		Logger.info("Check Add 5 Habits Week 2 totals is displayed");
		assertTrue(totalValueAdd5HabitsWeek2.isVisible(), "Add 5 Habits Week 2 totals are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatAHealthyBreakfastTitleWeek1Displayed() {
		Logger.info("Check Eat A Healthy Breakfast Title for Week 1 is displayed");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		eatAHealthyBreakfastWeek1Title.waitUntilVisible();
		assertTrue(eatAHealthyBreakfastWeek1Title.isVisible(), "Eat A Healthy Breakfast Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatVegetablesTitleWeek1Displayed() {
		Logger.info("Check Eat Vegetables Title for Week 1 is displayed");
		assertTrue(eatVegetablesWeek1Title.isVisible(), "Eat Vegetables Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatWholeGrainsTitleWeek1Displayed() {
		Logger.info("Check Eat Whole Grains Title for Week 1 is displayed");
		assertTrue(eatWholeGrainsWeek1Title.isVisible(), "Eat Whole Grains Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatHealthyFatsTitleWeek1Displayed() {
		Logger.info("Check Eat Healthy Fats Title for Week 1 is displayed");
		assertTrue(eatHealthyFatsWeek1Title.isVisible(), "Eat Healthy Fats Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkMoveTitleWeek1Displayed() {
		Logger.info("Check Move Title for Week 1 is displayed");
		assertTrue(moveWeek1Title.isVisible(), "Move Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForEatAHealthyBreakfastWeek1() {
		Logger.info("Check Amount of checkboxes for Eat A Healthy Breakfast for Week 1 is equal 7");
		int amountOfCheckboxesForEatAHealthyBreakfastWeek1 =
				checkboxFieldAdd5HabitsWeek1
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForEatAHealthyBreakfastWeek1).equals("7"), "Amount of checkboxes for Eat A Healthy Breakfast for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForEatVegetablesWeek1() {
		Logger.info("Check Amount of checkboxes for Eat Vegetables for Week 1 is equal 7");
		int amountOfCheckboxesForEatVegetablesWeek1 =
				eatVegetablesWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForEatVegetablesWeek1).equals("7"), "Amount of checkboxes for Eat Vegetables for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForEatWholeGrainsWeek1() {
		Logger.info("Check Amount of checkboxes for Eat Whole Grains for Week 1 is equal 7");
		int amountOfCheckboxesForEatWholeGrainsWeek1 =
				eatWholeGrainsWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForEatWholeGrainsWeek1).equals("7"), "Amount of checkboxes for Eat Whole Grains for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForEatHealthyFatsWeek1() {
		Logger.info("Check Amount of checkboxes for Eat Healthy Fats for Week 1 is equal 7");
		int amountOfCheckboxesForEatHealthyFatsWeek1 =
				eatHealthyFatsWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForEatHealthyFatsWeek1).equals("7"), "Amount of checkboxes for Eat Healthy Fats for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForMoveWeek1() {
		Logger.info("Check Amount of checkboxes for Move for Week 1 is equal 7");
		int amountOfCheckboxesForMoveWeek1 =
				moveWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForMoveWeek1).equals("7"), "Amount of checkboxes for Move for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsWeek1() {
		Logger.info("Check Amount of Totals for Week 1 is equal 7");
		int amountOfTotalsWeek1 =
				totalsFieldsWeek1
						.getElementsCount();
		assertTrue(Integer.toString(amountOfTotalsWeek1).equals("5"), "Amount of Totals for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatAHealthyBreakfastTitleWeek2Displayed() {
		Logger.info("Check Eat A Healthy Breakfast Title for Week 2 is displayed");
		assertTrue(eatAHealthyBreakfastWeek2Title.isVisible(), "Eat A Healthy Breakfast Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatVegetablesTitleWeek2Displayed() {
		Logger.info("Check Eat Vegetables Title for Week 2 is displayed");
		assertTrue(eatVegetablesWeek2Title.isVisible(), "Eat Vegetables Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatWholeGrainsTitleWeek2Displayed() {
		Logger.info("Check Eat Whole Grains Title for Week 2 is displayed");
		assertTrue(eatWholeGrainsWeek2Title.isVisible(), "Eat Whole Grains Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatHealthyFatsTitleWeek2Displayed() {
		Logger.info("Check Eat Healthy Fats Title for Week 2 is displayed");
		assertTrue(eatHealthyFatsWeek2Title.isVisible(), "Eat Healthy Fats Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkMoveTitleWeek2Displayed() {
		Logger.info("Check Move Title for Week 2 is displayed");
		assertTrue(moveWeek2Title.isVisible(), "Move Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForEatAHealthyBreakfastWeek2() {
		Logger.info("Check Amount of checkboxes for Eat A Healthy Breakfast for Week 2 is equal 7");
		int amountOfCheckboxesForEatAHealthyBreakfastWeek2 =
				checkboxFieldAdd5HabitsWeek2
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForEatAHealthyBreakfastWeek2).equals("7"), "Amount of checkboxes for Eat A Healthy Breakfast for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForEatVegetablesWeek2() {
		Logger.info("Check Amount of checkboxes for Eat Vegetables for Week 2 is equal 7");
		int amountOfCheckboxesForEatVegetablesWeek2 =
				eatVegetablesWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForEatVegetablesWeek2).equals("7"), "Amount of checkboxes for Eat Vegetables for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForEatWholeGrainsWeek2() {
		Logger.info("Check Amount of checkboxes for Eat Whole Grains for Week 2 is equal 7");
		int amountOfCheckboxesForEatWholeGrainsWeek2 =
				eatWholeGrainsWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForEatWholeGrainsWeek2).equals("7"), "Amount of checkboxes for Eat Whole Grains for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForEatHealthyFatsWeek2() {
		Logger.info("Check Amount of checkboxes for Eat Healthy Fats for Week 2 is equal 7");
		int amountOfCheckboxesForEatHealthyFatsWeek2 =
				eatHealthyFatsWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForEatHealthyFatsWeek2).equals("7"), "Amount of checkboxes for Eat Healthy Fats for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForMoveWeek2() {
		Logger.info("Check Amount of checkboxes for Move for Week 2 is equal 7");
		int amountOfCheckboxesForMoveWeek2 =
				moveWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForMoveWeek2).equals("7"), "Amount of checkboxes for Move for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsWeek2() {
		Logger.info("Check Amount of Totals for Week 2 is equal 7");
		int amountOfTotalsWeek2 =
				totalsFieldsWeek2
						.getElementsCount();
		assertTrue(Integer.toString(amountOfTotalsWeek2).equals("5"), "Amount of Totals for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForEatAHealthyBreakfastWeek1() {
		Logger.info("Check Amount of Totals for Eat A Healthy Breakfast Week 1 is equal 7");
		totalValueAdd5HabitsWeek1.waitUntilVisible();
		assertTrue(totalValueAdd5HabitsWeek1.getText().equals("7"), "Amount of Totals for Eat A Healthy Breakfast Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForEatAHealthyBreakfastWeek2() {
		Logger.info("Check Amount of Totals for Eat A Healthy Breakfast Week 2 is equal 7");
		assertTrue(totalValueAdd5HabitsWeek2.getText().equals("7"), "Amount of Totals for Eat A Healthy Breakfast Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatAHealthyBreakfastWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Eat A Healthy Breakfast Week 1 are empty");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		week1Tab.waitUntilVisible();
		if (eatAHealthyBreakfastWeek1CheckboxFlag.isVisible()) {
			uncheckAdd5Habits(elNumber);
		}
		String attr = eatAHealthyBreakfastWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatAHealthyBreakfastWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Eat A Healthy Breakfast Week 2 are empty");
		if (eatAHealthyBreakfastWeek2CheckboxFlag.isVisible()) {
			uncheckAdd5Habits(elNumber);
		}
		String attr = eatAHealthyBreakfastWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForEatVegetablesWeek1() {
		Logger.info("Check Amount of Totals for Eat Vegetables Week 1 is equal 7");
		totalValueEatVegetablesWeek1.waitUntilVisible();
		assertTrue(totalValueEatVegetablesWeek1.getText().equals("7"), "Amount of Totals for Eat Vegetables Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForEatVegetablesWeek2() {
		Logger.info("Check Amount of Totals for Eat Vegetables Week 2 is equal 7");
		assertTrue(totalValueEatVegetablesWeek2.getText().equals("7"), "Amount of Totals for Eat Vegetables Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatVegetablesWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Eat Vegetables Week 1 are empty");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		week1Tab.waitUntilVisible();
		if (eatVegetablesWeek1CheckboxFlag.isVisible()) {
			uncheckAdd5Habits(elNumber);
		}
		String attr = eatVegetablesWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatVegetablesWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Eat Vegetables Week 2 are empty");
		if (eatVegetablesWeek2CheckboxFlag.isVisible()) {
			uncheckAdd5Habits(elNumber);
		}
		String attr = eatVegetablesWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForEatWholeGrainsWeek1() {
		Logger.info("Check Amount of Totals for Eat Whole Grains Week 1 is equal 7");
		totalValueEatWholeGrainsWeek1.waitUntilVisible();
		assertTrue(totalValueEatWholeGrainsWeek1.getText().equals("7"), "Amount of Totals for Eat Whole Grains Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForEatWholeGrainsWeek2() {
		Logger.info("Check Amount of Totals for Eat Whole Grains Week 2 is equal 7");
		assertTrue(totalValueEatWholeGrainsWeek2.getText().equals("7"), "Amount of Totals for Eat Whole Grains Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatWholeGrainsWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Eat Whole Grains Week 1 are empty");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		week1Tab.waitUntilVisible();
		if (eatWholeGrainsWeek1CheckboxFlag.isVisible()) {
			uncheckAdd5Habits(elNumber);
		}
		String attr = eatWholeGrainsWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatWholeGrainsWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Eat Whole Grains Week 2 are empty");
		if (eatWholeGrainsWeek2CheckboxFlag.isVisible()) {
			uncheckAdd5Habits(elNumber);
		}
		String attr = eatWholeGrainsWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForEatHealthyFatsWeek1() {
		Logger.info("Check Amount of Totals for Eat Healthy Fats Week 1 is equal 7");
		totalValueEatHealthyFatsWeek1.waitUntilVisible();
		assertTrue(totalValueEatHealthyFatsWeek1.getText().equals("7"), "Amount of Totals for Eat Healthy Fats Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForEatHealthyFatsWeek2() {
		Logger.info("Check Amount of Totals for Eat Healthy Fats Week 2 is equal 7");
		assertTrue(totalValueEatHealthyFatsWeek2.getText().equals("7"), "Amount of Totals for Eat Healthy Fats Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatHealthyFatsWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Eat Healthy Fats Week 1 are empty");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		week1Tab.waitUntilVisible();
		if (eatHealthyFatsWeek1CheckboxFlag.isVisible()) {
			uncheckAdd5Habits(elNumber);
		}
		String attr = eatHealthyFatsWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatHealthyFatsWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Eat Healthy Fats Week 2 are empty");
		if (eatHealthyFatsWeek2CheckboxFlag.isVisible()) {
			uncheckAdd5Habits(elNumber);
		}
		String attr = eatHealthyFatsWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForMoveWeek1() {
		Logger.info("Check Amount of Totals for Move Week 1 is equal 7");
		totalValueMoveWeek1.waitUntilVisible();
		assertTrue(totalValueMoveWeek1.getText().equals("7"), "Amount of Totals for Move Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForMoveWeek2() {
		Logger.info("Check Amount of Totals for Move Week 2 is equal 7");
		assertTrue(totalValueMoveWeek2.getText().equals("7"), "Amount of Totals for Move Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkMoveWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Move Week 1 are empty");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		week1Tab.waitUntilVisible();
		if (moveWeek1CheckboxFlag.isVisible()) {
			uncheckAdd5Habits(elNumber);
		}
		String attr = moveWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkMoveWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Move Week 2 are empty");
		if (moveWeek2CheckboxFlag.isVisible()) {
			uncheckAdd5Habits(elNumber);
		}
		String attr = moveWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAdd5HabitsHeaderWeek1Css() {
		Logger.info("Check 'Add 5 habits' header font colour");
		add5HabitsHeaderWeek1.waitUntilVisible();
		String textAdd5HabitsHeader = add5HabitsHeaderWeek1
				.getCssValue("color");
		assertEquals(textAdd5HabitsHeader, whiteColor, "The font colour of the 'Add 5 habits' header doesn't correspond to mock-up");

		Logger.info("Check 'Add 5 habits' header background colour");
		String backgroundColorAdd5HabitsHeader = add5HabitsHeaderWeek1
				.getCssValue("background-color");
		assertEquals(backgroundColorAdd5HabitsHeader, greenColor, "The background colour of the 'Add 5 habits' header doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkAdd5HabitsHeaderWeek2Css() {
		Logger.info("Check 'Add 5 habits' header font colour");
		String textAdd5HabitsHeader = add5HabitsHeaderWeek2
				.getCssValue("color");
		assertEquals(textAdd5HabitsHeader, whiteColor, "The font colour of the 'Add 5 habits' header doesn't correspond to mock-up");

		Logger.info("Check 'Add 5 habits' header background colour");
		String backgroundColorAdd5HabitsHeader = add5HabitsHeaderWeek2
				.getCssValue("background-color");
		assertEquals(backgroundColorAdd5HabitsHeader, greenColor, "The background colour of the 'Add 5 habits' header doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkDayNumberHeaderWeek1Css() {
		Logger.info("Check day number header font colour");
		String textDayNumberHeader = dayNumberHeaderWeek1
				.getCssValue("color");
		assertEquals(textDayNumberHeader, whiteColor, "The font colour of day number doesn't correspond to mock-up");

		Logger.info("Check day number background colour");
		String backgroundColorDayNumberHeader = dayNumbersAllWeek1
				.getCssValue("background-color");
		assertEquals(backgroundColorDayNumberHeader, lightGreenColor, "The background colour of day number doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkDayNumberHeaderWeek2Css() {
		Logger.info("Check day number header font colour");
		String textDayNumberHeader = dayNumberHeaderWeek2
				.getCssValue("color");
		assertEquals(textDayNumberHeader, whiteColor, "The font colour of day number doesn't correspond to mock-up");

		Logger.info("Check day number background colour");
		String backgroundColorDayNumberHeader = dayNumbersAllWeek2
				.getCssValue("background-color");
		assertEquals(backgroundColorDayNumberHeader, lightGreenColor, "The background colour of day number doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkExpandIconOnAdd5HabitsWeek1Displayed() {
		Logger.info("Check expand icon on Add 5 habits for Week 1 is displayed");
		expandIconAdd5HabitsWeek1.waitUntilVisible();
		assertTrue(expandIconAdd5HabitsWeek1.isVisible(), "Expand icon on Add 5 habits for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkExpandIconOnAdd5HabitsWeek2Displayed() {
		Logger.info("Check expand icon on Add 5 habits for Week 2 is displayed");
		assertTrue(expandIconAdd5HabitsWeek2.isVisible(), "Expand icon on Add 5 habits for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkContentNotEditableWeek1() {
		Logger.info("Check Add 5 habits table for Week 1 is not editable");
		tableCellsAdd5HabitsWeek1.waitUntilVisible();
		boolean isTextAreaElementPresent = tableCellsAdd5HabitsWeek1
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().contains("textarea"));

		boolean isInputElementPresent = tableCellsAdd5HabitsWeek1
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().equals("input"));
		assertFalse(isTextAreaElementPresent, "Add 5 Habits Content is editable");
		assertFalse(isInputElementPresent, "Add 5 Habits Content is editable");
		return this;
	}

	public HabitTrackerAnalysisPage checkContentNotEditableWeek2() {
		Logger.info("Check Add 5 habits table for Week 2 is not editable");
		boolean isTextAreaElementPresent = tableCellsAdd5HabitsWeek2
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().contains("textarea"));

		boolean isInputElementPresent = tableCellsAdd5HabitsWeek2
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().equals("input"));
		assertFalse(isTextAreaElementPresent, "Add 5 Habits Content is editable");
		assertFalse(isInputElementPresent, "Add 5 Habits Content is editable");
		return this;
	}

	public HabitTrackerAnalysisPage clickExpandIconAdd5HabitsWeek1() {
		Logger.info("Click expand icon on Week 1 tab");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		expandIconAdd5HabitsWeek1
				.waitUntilVisible()
				.click();
		return this;
	}

	public HabitTrackerAnalysisPage checkPlusIconAdd5HabitsWeek1() {
		Logger.info("Check plus icon on Add 5 Habits Week 1");
		boolean isPlusIconPresent = expandIconAdd5HabitsWeek1
				.getAttribute("class")
				.contains("active");
		assertFalse(isPlusIconPresent, "Plus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkMinusIconAdd5HabitsWeek1() {
		Logger.info("Check minus icon on Add 5 Habits Week 1");
		boolean isPlusIconPresent = expandIconAdd5HabitsWeek1
				.getAttribute("class")
				.contains("active");
		assertTrue(isPlusIconPresent, "Minus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage clickExpandIconAdd5HabitsWeek2() {
		Logger.info("Click expand icon on Week 2 tab");
		expandIconAdd5HabitsWeek2.click();
		return this;
	}

	public HabitTrackerAnalysisPage checkPlusIconAdd5HabitsWeek2() {
		Logger.info("Check plus icon on Add 5 Habits Week 2");
		boolean isPlusIconPresent = expandIconAdd5HabitsWeek2
				.getAttribute("class")
				.contains("active");
		assertFalse(isPlusIconPresent, "Plus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkMinusIconAdd5HabitsWeek2() {
		Logger.info("Check minus icon on Add 5 Habits Week 2");
		boolean isPlusIconPresent = expandIconAdd5HabitsWeek2
				.getAttribute("class")
				.contains("active");
		assertTrue(isPlusIconPresent, "Minus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage clickBreak5HabitsHeaderWeek1() {
		Logger.info("Click on Break 5 Habits header for Week 1");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		break5HabitsHeaderWeek1
				.waitUntilVisible()
				.click();
		return this;
	}

	public HabitTrackerAnalysisPage clickBreak5HabitsHeaderWeek2() {
		Logger.info("Click on Break 5 Habits header for Week 2");
		break5HabitsHeaderWeek2.click();
		return this;
	}

	public HabitTrackerAnalysisPage checkBreak5HabitsWeek1CheckMarksDisplayed() {
		Logger.info("Check Break 5 Habits Week 1 check marks is displayed");
		checkboxFieldBreak5HabitsWeek1.waitUntilVisible();
		assertTrue(checkboxFieldBreak5HabitsWeek1.isVisible(), "Break 5 Habits Week 1 check marks are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkBreak5HabitsWeek1TotalsDisplayed() {
		Logger.info("Check Break 5 Habits Week 1 totals is displayed");
		assertTrue(totalValueBreak5HabitsWeek1.isVisible(), "Break 5 Habits Week 1 totals are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkBreak5HabitsWeek2CheckMarksDisplayed() {
		Logger.info("Check Break 5 Habits Week 2 check marks is displayed");
		assertTrue(checkboxFieldBreak5HabitsWeek2.isVisible(), "Break 5 Habits Week 2 check marks are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkBreak5HabitsWeek2TotalsDisplayed() {
		Logger.info("Check Break 5 Habits Week 2 totals is displayed");
		assertTrue(totalValueBreak5HabitsWeek2.isVisible(), "Break 5 Habits Week 2 totals are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoTVWhileEatingTitleWeek1Displayed() {
		Logger.info("Check No TV While Eating Title for Week 1 is displayed");
		noTVWhileEatingWeek1Title.waitUntilVisible();
		assertTrue(noTVWhileEatingWeek1Title.isVisible(), "No TV While Eating Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoSugarTitleWeek1Displayed() {
		Logger.info("Check No Sugar Title for Week 1 is displayed");
		assertTrue(noSugarWeek1Title.isVisible(), "No Sugar Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoSnacksTitleWeek1Displayed() {
		Logger.info("Check No Snacks Title for Week 1 is displayed");
		assertTrue(noSnacksWeek1Title.isVisible(), "No Snacks Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkModerateMeatAndLowFatDairyTitleWeek1Displayed() {
		Logger.info("Check Moderate Meat And Low-Fat Dairy Title for Week 1 is displayed");
		assertTrue(moderateMeatAndLowFatDairyWeek1Title.isVisible(), "Moderate Meat And Low-Fat Dairy Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoEatingAtRestaurantsTitleWeek1Displayed() {
		Logger.info("Check No Eating At Restaurants Title for Week 1 is displayed");
		assertTrue(noEatingAtRestaurantsWeek1Title.isVisible(), "No Eating At Restaurants Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForNoTVWhileEatingWeek1() {
		Logger.info("Check Amount of checkboxes for No TV While Eating for Week 1 is equal 7");
		int amountOfCheckboxesForNoTVWhileEatingWeek1 =
				checkboxFieldBreak5HabitsWeek1
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForNoTVWhileEatingWeek1).equals("7"), "Amount of checkboxes for No TV While Eating for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForNoSugarWeek1() {
		Logger.info("Check Amount of checkboxes for No Sugar for Week 1 is equal 7");
		int amountOfCheckboxesForNoSugarWeek1 =
				noSugarWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForNoSugarWeek1).equals("7"), "Amount of checkboxes for No Sugar for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForNoSnacksWeek1() {
		Logger.info("Check Amount of checkboxes for No Snacks for Week 1 is equal 7");
		int amountOfCheckboxesForNoSnacksWeek1 =
				noSnacksWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForNoSnacksWeek1).equals("7"), "Amount of checkboxes for No Snacks for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForModerateMeatAndLowFatDairyWeek1() {
		Logger.info("Check Amount of checkboxes for Moderate Meat And Low-Fat Dairy for Week 1 is equal 7");
		int amountOfCheckboxesForModerateMeatAndLowFatDairyWeek1 =
				moderateMeatAndLowFatDairyWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForModerateMeatAndLowFatDairyWeek1).equals("7"), "Amount of checkboxes for Moderate Meat And Low-Fat Dairy for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForNoEatingAtRestaurantsWeek1() {
		Logger.info("Check Amount of checkboxes for No Eating At Restaurants for Week 1 is equal 7");
		int amountOfCheckboxesForNoEatingAtRestaurantsWeek1 =
				noEatingAtRestaurantsWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForNoEatingAtRestaurantsWeek1).equals("7"), "Amount of checkboxes for No Eating At Restaurants for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForBreak5HabitsWeek1() {
		Logger.info("Check Amount of Totals For Break 5 Habits for Week 1 is equal 7");
		int amountOfTotalsWeek1 =
				totalsFieldsBreak5HabitsWeek1
						.getElementsCount();
		assertTrue(Integer.toString(amountOfTotalsWeek1).equals("5"), "Amount of Totals For Break 5 Habits for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoTVWhileEatingTitleWeek2Displayed() {
		Logger.info("Check No TV While Eating Title for Week 2 is displayed");
		assertTrue(noTVWhileEatingWeek2Title.isVisible(), "No TV While Eating Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoSugarTitleWeek2Displayed() {
		Logger.info("Check No Sugar Title for Week 2 is displayed");
		assertTrue(noSugarWeek2Title.isVisible(), "No Sugar Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoSnacksTitleWeek2Displayed() {
		Logger.info("Check No Snacks Title for Week 2 is displayed");
		assertTrue(noSnacksWeek2Title.isVisible(), "No Snacks Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkModerateMeatAndLowFatDairyTitleWeek2Displayed() {
		Logger.info("Check Moderate Meat And Low-Fat Dairy Title for Week 2 is displayed");
		assertTrue(moderateMeatAndLowFatDairyWeek2Title.isVisible(), "Moderate Meat And Low-Fat Dairy Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoEatingAtRestaurantsTitleWeek2Displayed() {
		Logger.info("Check No Eating At Restaurants Title for Week 2 is displayed");
		assertTrue(noEatingAtRestaurantsWeek2Title.isVisible(), "No Eating At Restaurants Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForNoTVWhileEatingWeek2() {
		Logger.info("Check Amount of checkboxes for No TV While Eating for Week 2 is equal 7");
		int amountOfCheckboxesForNoTVWhileEatingWeek2 =
				checkboxFieldBreak5HabitsWeek2
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForNoTVWhileEatingWeek2).equals("7"), "Amount of checkboxes for No TV While Eating for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForNoSugarWeek2() {
		Logger.info("Check Amount of checkboxes for No Sugar for Week 2 is equal 7");
		int amountOfCheckboxesForNoSugarWeek2 =
				noSugarWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForNoSugarWeek2).equals("7"), "Amount of checkboxes for No Sugar for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForNoSnacksWeek2() {
		Logger.info("Check Amount of checkboxes for No Snacks for Week 2 is equal 7");
		int amountOfCheckboxesForNoSnacksWeek2 =
				noSnacksWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForNoSnacksWeek2).equals("7"), "Amount of checkboxes for No Snacks for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForModerateMeatAndLowFatDairyWeek2() {
		Logger.info("Check Amount of checkboxes for Moderate Meat And Low-Fat Dairy for Week 2 is equal 7");
		int amountOfCheckboxesForModerateMeatAndLowFatDairyWeek2 =
				moderateMeatAndLowFatDairyWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForModerateMeatAndLowFatDairyWeek2).equals("7"), "Amount of checkboxes for Moderate Meat And Low-Fat Dairy for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForNoEatingAtRestaurantsWeek2() {
		Logger.info("Check Amount of checkboxes for No Eating At Restaurants for Week 2 is equal 7");
		int amountOfCheckboxesForNoEatingAtRestaurantsWeek2 =
				noEatingAtRestaurantsWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForNoEatingAtRestaurantsWeek2).equals("7"), "Amount of checkboxes for No Eating At Restaurants for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForBreak5HabitsWeek2() {
		Logger.info("Check Amount of Totals For Break 5 Habits for Week 2 is equal 7");
		int amountOfTotalsWeek2 =
				totalsFieldsBreak5HabitsWeek2
						.getElementsCount();
		assertTrue(Integer.toString(amountOfTotalsWeek2).equals("5"), "Amount of Totals For Break 5 Habits for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForNoTVWhileEatingWeek1() {
		Logger.info("Check Amount of Totals for No TV While Eating Week 1 is equal 7");
		totalValueBreak5HabitsWeek1.waitUntilVisible();
		assertTrue(totalValueBreak5HabitsWeek1.getText().equals("7"), "Amount of Totals for No TV While Eating Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForNoTVWhileEatingWeek2() {
		Logger.info("Check Amount of Totals for No TV While Eating Week 2 is equal 7");
		assertTrue(totalValueBreak5HabitsWeek2.getText().equals("7"), "Amount of Totals for No TV While Eating Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoTVWhileEatingWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for No TV While Eating Week 1 are empty");
		week1Tab.waitUntilVisible();
		if (noTVWhileEatingWeek1CheckboxFlag.isVisible()) {
			uncheckBreak5Habits(elNumber);
		}
		String attr = noTVWhileEatingWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoTVWhileEatingWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for No TV While Eating Week 2 are empty");
		if (noTVWhileEatingWeek2CheckboxFlag.isVisible()) {
			uncheckBreak5Habits(elNumber);
		}
		String attr = noTVWhileEatingWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForNoSugarWeek1() {
		Logger.info("Check Amount of Totals for No Sugar Week 1 is equal 7");
		totalValueNoSugarWeek1.waitUntilVisible();
		assertTrue(totalValueNoSugarWeek1.getText().equals("7"), "Amount of Totals for No Sugar Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForNoSugarWeek2() {
		Logger.info("Check Amount of Totals for No Sugar Week 2 is equal 7");
		assertTrue(totalValueNoSugarWeek2.getText().equals("7"), "Amount of Totals for No Sugar Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoSugarWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for No Sugar Week 1 are empty");
		week1Tab.waitUntilVisible();
		if (noSugarWeek1CheckboxFlag.isVisible()) {
			uncheckBreak5Habits(elNumber);
		}
		String attr = noSugarWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoSugarWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for No Sugar Week 2 are empty");
		if (noSugarWeek2CheckboxFlag.isVisible()) {
			uncheckBreak5Habits(elNumber);
		}
		String attr = noSugarWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForNoSnacksWeek1() {
		Logger.info("Check Amount of Totals for No Snacks Week 1 is equal 7");
		totalValueNoSnacksWeek1.waitUntilVisible();
		assertTrue(totalValueNoSnacksWeek1.getText().equals("7"), "Amount of Totals for No Snacks Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForNoSnacksWeek2() {
		Logger.info("Check Amount of Totals for No Snacks Week 2 is equal 7");
		assertTrue(totalValueNoSnacksWeek2.getText().equals("7"), "Amount of Totals for No Snacks Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoSnacksWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for No Snacks Week 1 are empty");
		week1Tab.waitUntilVisible();
		if (noSnacksWeek1CheckboxFlag.isVisible()) {
			uncheckBreak5Habits(elNumber);
		}
		String attr = noSnacksWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoSnacksWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for No Snacks Week 2 are empty");
		if (noSnacksWeek2CheckboxFlag.isVisible()) {
			uncheckBreak5Habits(elNumber);
		}
		String attr = noSnacksWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForModerateMeatAndLowFatDairyWeek1() {
		Logger.info("Check Amount of Totals for Moderate Meat And Low-Fat Dairy Week 1 is equal 7");
		totalValueModerateMeatAndLowFatDairyWeek1.waitUntilVisible();
		assertTrue(totalValueModerateMeatAndLowFatDairyWeek1.getText().equals("7"), "Amount of Totals for Moderate Meat And Low-Fat Dairy Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForModerateMeatAndLowFatDairyWeek2() {
		Logger.info("Check Amount of Totals for Moderate Meat And Low-Fat Dairy Week 2 is equal 7");
		assertTrue(totalValueModerateMeatAndLowFatDairyWeek2.getText().equals("7"), "Amount of Totals for Moderate Meat And Low-Fat Dairy Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkModerateMeatAndLowFatDairyWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Moderate Meat And Low-Fat Dairy Week 1 are empty");
		week1Tab.waitUntilVisible();
		if (moderateMeatAndLowFatDairyWeek1CheckboxFlag.isVisible()) {
			uncheckBreak5Habits(elNumber);
		}
		String attr = moderateMeatAndLowFatDairyWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkModerateMeatAndLowFatDairyWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Moderate Meat And Low-Fat Dairy Week 2 are empty");
		if (moderateMeatAndLowFatDairyWeek2CheckboxFlag.isVisible()) {
			uncheckBreak5Habits(elNumber);
		}
		String attr = moderateMeatAndLowFatDairyWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForNoEatingAtRestaurantsWeek1() {
		Logger.info("Check Amount of Totals for No Eating At Restaurants Week 1 is equal 7");
		totalValueNoEatingAtRestaurantsWeek1.waitUntilVisible();
		assertTrue(totalValueNoEatingAtRestaurantsWeek1.getText().equals("7"), "Amount of Totals for No Eating At Restaurants Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForNoEatingAtRestaurantsWeek2() {
		Logger.info("Check Amount of Totals for No Eating At Restaurants Week 2 is equal 7");
		assertTrue(totalValueNoEatingAtRestaurantsWeek2.getText().equals("7"), "Amount of Totals for No Eating At Restaurants Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoEatingAtRestaurantsWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for No Eating At Restaurants Week 1 are empty");
		week1Tab.waitUntilVisible();
		if (noEatingAtRestaurantsWeek1CheckboxFlag.isVisible()) {
			uncheckBreak5Habits(elNumber);
		}
		String attr = noEatingAtRestaurantsWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkNoEatingAtRestaurantsWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for No Eating At Restaurants Week 2 are empty");
		if (noEatingAtRestaurantsWeek2CheckboxFlag.isVisible()) {
			uncheckBreak5Habits(elNumber);
		}
		String attr = noEatingAtRestaurantsWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkContentBreak5HabitsNotEditableWeek1() {
		Logger.info("Check Break 5 habits table for Week 1 is not editable");
		tableCellsBreak5HabitsWeek1.waitUntilVisible();
		boolean isTextAreaElementPresent = tableCellsBreak5HabitsWeek1
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().contains("textarea"));

		boolean isInputElementPresent = tableCellsBreak5HabitsWeek1
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().equals("input"));
		assertFalse(isTextAreaElementPresent, "Break 5 Habits Content is editable");
		assertFalse(isInputElementPresent, "Break 5 Habits Content is editable");
		return this;
	}

	public HabitTrackerAnalysisPage checkContentBreak5HabitsNotEditableWeek2() {
		Logger.info("Check Break 5 habits table for Week 2 is not editable");
		boolean isTextAreaElementPresent = tableCellsBreak5HabitsWeek2
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().contains("textarea"));

		boolean isInputElementPresent = tableCellsBreak5HabitsWeek2
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().equals("input"));
		assertFalse(isTextAreaElementPresent, "Break 5 Habits Content is editable");
		assertFalse(isInputElementPresent, "Break 5 Habits Content is editable");
		return this;
	}

	public HabitTrackerAnalysisPage checkBreak5HabitsHeaderWeek1Css() {
		Logger.info("Check 'Break 5 habits' header font colour");
		break5HabitsHeaderWeek1.waitUntilVisible();
		String textBreak5HabitsHeader = break5HabitsHeaderWeek1
				.getCssValue("color");
		assertEquals(textBreak5HabitsHeader, whiteColor, "The font colour of the 'Break 5 habits' header doesn't correspond to mock-up");

		Logger.info("Check 'Break 5 habits' header background colour");
		String backgroundColorBreak5HabitsHeader = break5HabitsHeaderWeek1
				.getCssValue("background-color");
		assertEquals(backgroundColorBreak5HabitsHeader, purpleColor, "The background colour of the 'Break 5 habits' header doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkBreak5HabitsHeaderWeek2Css() {
		Logger.info("Check 'Break 5 habits' header font colour");
		String textBreak5HabitsHeader = break5HabitsHeaderWeek2
				.getCssValue("color");
		assertEquals(textBreak5HabitsHeader, whiteColor, "The font colour of the 'Break 5 habits' header doesn't correspond to mock-up");

		Logger.info("Check 'Break 5 habits' header background colour");
		String backgroundColorBreak5HabitsHeader = break5HabitsHeaderWeek2
				.getCssValue("background-color");
		assertEquals(backgroundColorBreak5HabitsHeader, purpleColor, "The background colour of the 'Break 5 habits' header doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkDayNumberHeaderBreak5HabitsWeek1Css() {
		Logger.info("Check day number header font colour for Break 5 Habits table");
		String textDayNumberHeader = dayNumberBreak5HabitsHeaderWeek1
				.getCssValue("color");
		assertEquals(textDayNumberHeader, whiteColor, "The font colour for Break 5 Habits table of day number doesn't correspond to mock-up");

		Logger.info("Check day number background colour");
		String backgroundColorDayNumberHeader = dayNumbersAllBreak5HabitsWeek1
				.getCssValue("background-color");
		assertEquals(backgroundColorDayNumberHeader, lightPurpleColor, "The background colour for Break 5 Habits table of day number doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkDayNumberHeaderBreak5HabitsWeek2Css() {
		Logger.info("Check day number header for Break 5 Habits table font colour");
		String textDayNumberHeader = dayNumberBreak5HabitsHeaderWeek2
				.getCssValue("color");
		assertEquals(textDayNumberHeader, whiteColor, "The font colour for Break 5 Habits table of day number doesn't correspond to mock-up");

		Logger.info("Check day number background colour for Break 5 Habits table");
		String backgroundColorDayNumberHeader = dayNumbersAllBreak5HabitsWeek2
				.getCssValue("background-color");
		assertEquals(backgroundColorDayNumberHeader, lightPurpleColor, "The background colour for Break 5 Habits table of day number doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkExpandIconOnBreak5HabitsWeek1Displayed() {
		Logger.info("Check expand icon on Break 5 habits for Week 1 is displayed");
		expandIconBreak5HabitsWeek1.waitUntilVisible();
		assertTrue(expandIconBreak5HabitsWeek1.isVisible(), "Expand icon on Break 5 habits for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkExpandIconOnBreak5HabitsWeek2Displayed() {
		Logger.info("Check expand icon on Break 5 habits for Week 2 is displayed");
		assertTrue(expandIconBreak5HabitsWeek2.isVisible(), "Expand icon on Break 5 habits for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage clickExpandIconBreak5HabitsWeek1() {
		Logger.info("Click expand icon for Break 5 Habits table on Week 1 tab");
		expandIconBreak5HabitsWeek1
				.waitUntilVisible()
				.click();
		return this;
	}

	public HabitTrackerAnalysisPage checkPlusIconBreak5HabitsWeek1() {
		Logger.info("Check plus icon on Break 5 Habits Week 1");
		boolean isPlusIconPresent = expandIconBreak5HabitsWeek1
				.getAttribute("class")
				.contains("active");
		assertFalse(isPlusIconPresent, "Plus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkMinusIconBreak5HabitsWeek1() {
		Logger.info("Check minus icon on Break 5 Habits Week 1");
		boolean isPlusIconPresent = expandIconBreak5HabitsWeek1
				.getAttribute("class")
				.contains("active");
		assertTrue(isPlusIconPresent, "Minus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage clickExpandIconBreak5HabitsWeek2() {
		Logger.info("Click expand icon for Break 5 Habits table on Week 2 tab");
		expandIconBreak5HabitsWeek2.click();
		return this;
	}

	public HabitTrackerAnalysisPage checkPlusIconBreak5HabitsWeek2() {
		Logger.info("Check plus icon on Break 5 Habits Week 2");
		boolean isPlusIconPresent = expandIconBreak5HabitsWeek2
				.getAttribute("class")
				.contains("active");
		assertFalse(isPlusIconPresent, "Plus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkMinusIconBreak5HabitsWeek2() {
		Logger.info("Check minus icon on Break 5 Habits Week 2");
		boolean isPlusIconPresent = expandIconBreak5HabitsWeek2
				.getAttribute("class")
				.contains("active");
		assertTrue(isPlusIconPresent, "Minus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage clickBonus5HabitsHeaderWeek1() {
		Logger.info("Click on Bonus 5 Habits header for Week 1");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		bonus5HabitsHeaderWeek1
				.waitUntilVisible()
				.click();
		return this;
	}

	public HabitTrackerAnalysisPage clickBonus5HabitsHeaderWeek2() {
		Logger.info("Click on Bonus 5 Habits header for Week 2");
		bonus5HabitsHeaderWeek2.click();
		return this;
	}

	public HabitTrackerAnalysisPage checkBonus5HabitsWeek1CheckMarksDisplayed() {
		Logger.info("Check Bonus 5 Habits Week 1 check marks is displayed");
		checkboxFieldBonus5HabitsWeek1.waitUntilVisible();
		assertTrue(checkboxFieldBonus5HabitsWeek1.isVisible(), "Bonus 5 Habits Week 1 check marks are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkBonus5HabitsWeek1TotalsDisplayed() {
		Logger.info("Check Bonus 5 Habits Week 1 totals is displayed");
		assertTrue(totalValueBonus5HabitsWeek1.isVisible(), "Bonus 5 Habits Week 1 totals are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkBonus5HabitsWeek2CheckMarksDisplayed() {
		Logger.info("Check Bonus 5 Habits Week 2 check marks is displayed");
		assertTrue(checkboxFieldBonus5HabitsWeek2.isVisible(), "Bonus 5 Habits Week 2 check marks are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkBonus5HabitsWeek2TotalsDisplayed() {
		Logger.info("Check Bonus 5 Habits Week 2 totals is displayed");
		assertTrue(totalValueBonus5HabitsWeek2.isVisible(), "Bonus 5 Habits Week 2 totals are not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkKeepFoodRecordsTitleWeek1Displayed() {
		Logger.info("Check Keep Food Records Title for Week 1 is displayed");
		keepFoodRecordsWeek1Title.waitUntilVisible();
		assertTrue(keepFoodRecordsWeek1Title.isVisible(), "Keep Food Records Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkLogActivityTitleWeek1Displayed() {
		Logger.info("Check Log Activity Title for Week 1 is displayed");
		assertTrue(logActivityWeek1Title.isVisible(), "Log Activity Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkMoveMoreTitleWeek1Displayed() {
		Logger.info("Check Move More Title for Week 1 is displayed");
		assertTrue(moveMoreWeek1Title.isVisible(), "Move More Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatRealFoodTitleWeek1Displayed() {
		Logger.info("Check Eat Real Food Title for Week 1 is displayed");
		assertTrue(eatRealFoodWeek1Title.isVisible(), "Eat Real Food Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkWriteOutDailyGoalsTitleWeek1Displayed() {
		Logger.info("Check Write Out Daily Goals Title for Week 1 is displayed");
		assertTrue(writeOutDailyGoalsWeek1Title.isVisible(), "Write Out Daily Goals Title for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForKeepFoodRecordsWeek1() {
		Logger.info("Check Amount of checkboxes for Keep Food Records for Week 1 is equal 7");
		int amountOfCheckboxesForKeepFoodRecordsWeek1 =
				checkboxFieldBonus5HabitsWeek1
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForKeepFoodRecordsWeek1).equals("7"), "Amount of checkboxes for Keep Food Records for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForLogActivityWeek1() {
		Logger.info("Check Amount of checkboxes for Log Activity for Week 1 is equal 7");
		int amountOfCheckboxesForLogActivityWeek1 =
				logActivityWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForLogActivityWeek1).equals("7"), "Amount of checkboxes for Log Activity for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForMoveMoreWeek1() {
		Logger.info("Check Amount of checkboxes for Move More for Week 1 is equal 7");
		int amountOfCheckboxesForMoveMoreWeek1 =
				moveMoreWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForMoveMoreWeek1).equals("7"), "Amount of checkboxes for Move More for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForEatRealFoodWeek1() {
		Logger.info("Check Amount of checkboxes for Eat Real Food for Week 1 is equal 7");
		int amountOfCheckboxesForEatRealFoodWeek1 =
				eatRealFoodWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForEatRealFoodWeek1).equals("7"), "Amount of checkboxes for Eat Real Food for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForWriteOutDailyGoalsWeek1() {
		Logger.info("Check Amount of checkboxes for Write Out Daily Goals for Week 1 is equal 7");
		int amountOfCheckboxesForWriteOutDailyGoalsWeek1 =
				writeOutDailyGoalsWeek1Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForWriteOutDailyGoalsWeek1).equals("7"), "Amount of checkboxes for Write Out Daily Goals for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForBonus5HabitsWeek1() {
		Logger.info("Check Amount of Totals For Bonus 5 Habits for Week 1 is equal 7");
		int amountOfTotalsWeek1 =
				totalsFieldsBonus5HabitsWeek1
						.getElementsCount();
		assertTrue(Integer.toString(amountOfTotalsWeek1).equals("5"), "Amount of Totals For Bonus 5 Habits for Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkKeepFoodRecordsTitleWeek2Displayed() {
		Logger.info("Check Keep Food Records Title for Week 2 is displayed");
		assertTrue(keepFoodRecordsWeek2Title.isVisible(), "Keep Food Records Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkLogActivityTitleWeek2Displayed() {
		Logger.info("Check Log Activity Title for Week 2 is displayed");
		assertTrue(logActivityWeek2Title.isVisible(), "Log Activity Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkMoveMoreTitleWeek2Displayed() {
		Logger.info("Check Move More Title for Week 2 is displayed");
		assertTrue(moveMoreWeek2Title.isVisible(), "Move More Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatRealFoodTitleWeek2Displayed() {
		Logger.info("Check Eat Real Food for Week 2 is displayed");
		assertTrue(eatRealFoodWeek2Title.isVisible(), "Eat Real Food Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkWriteOutDailyGoalsTitleWeek2Displayed() {
		Logger.info("Check Write Out Daily Goals Title for Week 2 is displayed");
		assertTrue(writeOutDailyGoalsWeek2Title.isVisible(), "Write Out Daily Goals Title for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForKeepFoodRecordsWeek2() {
		Logger.info("Check Amount of checkboxes for Keep Food Records for Week 2 is equal 7");
		int amountOfCheckboxesForKeepFoodRecordsWeek2 =
				checkboxFieldBonus5HabitsWeek2
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForKeepFoodRecordsWeek2).equals("7"), "Amount of checkboxes for Keep Food Records for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForLogActivityWeek2() {
		Logger.info("Check Amount of checkboxes for Log Activity for Week 2 is equal 7");
		int amountOfCheckboxesForLogActivityWeek2 =
				logActivityWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForLogActivityWeek2).equals("7"), "Amount of checkboxes for Log Activity for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForMoveMoreWeek2() {
		Logger.info("Check Amount of checkboxes for Move More for Week 2 is equal 7");
		int amountOfCheckboxesForMoveMoreWeek2 =
				moveMoreWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForMoveMoreWeek2).equals("7"), "Amount of checkboxes for Move More for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForEatRealFoodWeek2() {
		Logger.info("Check Amount of checkboxes for Eat Real Food for Week 2 is equal 7");
		int amountOfCheckboxesForEatRealFoodWeek2 =
				eatRealFoodWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForEatRealFoodWeek2).equals("7"), "Amount of checkboxes for Eat Real Food for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfCheckboxesForWriteOutDailyGoalsWeek2() {
		Logger.info("Check Amount of checkboxes for Write Out Daily Goals for Week 2 is equal 7");
		int amountOfCheckboxesForWriteOutDailyGoalsWeek2 =
				writeOutDailyGoalsWeek2Checkboxes
						.getElementsCount();
		assertTrue(Integer.toString(amountOfCheckboxesForWriteOutDailyGoalsWeek2).equals("7"), "Amount of checkboxes for Write Out Daily Goals for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForBonus5HabitsWeek2() {
		Logger.info("Check Amount of Totals For Bonus 5 Habits for Week 2 is equal 7");
		int amountOfTotalsWeek2 =
				totalsFieldsBonus5HabitsWeek2
						.getElementsCount();
		assertTrue(Integer.toString(amountOfTotalsWeek2).equals("5"), "Amount of Totals For Bonus 5 Habits for Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForKeepFoodRecordsWeek1() {
		Logger.info("Check Amount of Totals for Keep Food Records Week 1 is equal 7");
		totalValueBonus5HabitsWeek1.waitUntilVisible();
		assertTrue(totalValueBonus5HabitsWeek1.getText().equals("7"), "Amount of Totals for Keep Food Records Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForKeepFoodRecordsWeek2() {
		Logger.info("Check Amount of Totals for Keep Food Records Week 2 is equal 7");
		assertTrue(totalValueBonus5HabitsWeek2.getText().equals("7"), "Amount of Totals for Keep Food Records Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkKeepFoodRecordsWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Keep Food Records Week 1 are empty");
		week1Tab.waitUntilVisible();
		if (keepFoodRecordsWeek1CheckboxFlag.isVisible()) {
			uncheckBonus5Habits(elNumber);
		}
		String attr = keepFoodRecordsWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkKeepFoodRecordsWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Keep Food Records Week 2 are empty");
		if (keepFoodRecordsWeek2CheckboxFlag.isVisible()) {
			uncheckBonus5Habits(elNumber);
		}
		String attr = keepFoodRecordsWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForLogActivityWeek1() {
		Logger.info("Check Amount of Totals for Log Activity Week 1 is equal 7");
		totalValueLogActivityWeek1.waitUntilVisible();
		assertTrue(totalValueLogActivityWeek1.getText().equals("7"), "Amount of Totals for Log Activity Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForLogActivityWeek2() {
		Logger.info("Check Amount of Totals for Log Activity Week 2 is equal 7");
		assertTrue(totalValueLogActivityWeek2.getText().equals("7"), "Amount of Totals for Log Activity Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkLogActivityWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Log Activity Week 1 are empty");
		week1Tab.waitUntilVisible();
		if (logActivityWeek1CheckboxFlag.isVisible()) {
			uncheckBonus5Habits(elNumber);
		}
		String attr = logActivityWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkLogActivityWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Log Activity Week 2 are empty");
		if (logActivityWeek2CheckboxFlag.isVisible()) {
			uncheckBonus5Habits(elNumber);
		}
		String attr = logActivityWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForMoveMoreWeek1() {
		Logger.info("Check Amount of Totals for Move More Week 1 is equal 7");
		totalValueMoveMoreWeek1.waitUntilVisible();
		assertTrue(totalValueMoveMoreWeek1.getText().equals("7"), "Amount of Totals for Move More Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForMoveMoreWeek2() {
		Logger.info("Check Amount of Totals for Move More Week 2 is equal 7");
		assertTrue(totalValueMoveMoreWeek2.getText().equals("7"), "Amount of Totals for Move More Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkMoveMoreWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Move More Week 1 are empty");
		week1Tab.waitUntilVisible();
		if (moveMoreWeek1CheckboxFlag.isVisible()) {
			uncheckBonus5Habits(elNumber);
		}
		String attr = moveMoreWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkMoveMoreWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Move More Week 2 are empty");
		if (moveMoreWeek2CheckboxFlag.isVisible()) {
			uncheckBonus5Habits(elNumber);
		}
		String attr = moveMoreWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForEatRealFoodWeek1() {
		Logger.info("Check Amount of Totals for Eat Real Food Week 1 is equal 7");
		totalValueEatRealFoodWeek1.waitUntilVisible();
		assertTrue(totalValueEatRealFoodWeek1.getText().equals("7"), "Amount of Totals for Eat Real Food Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForEatRealFoodWeek2() {
		Logger.info("Check Amount of Totals for Eat Real Food Week 2 is equal 7");
		assertTrue(totalValueEatRealFoodWeek2.getText().equals("7"), "Amount of Totals for Eat Real Food Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatRealFoodWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Eat Real Food Week 1 are empty");
		week1Tab.waitUntilVisible();
		if (eatRealFoodWeek1CheckboxFlag.isVisible()) {
			uncheckBonus5Habits(elNumber);
		}
		String attr = eatRealFoodWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkEatRealFoodWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Eat Real Food Week 2 are empty");
		if (eatRealFoodWeek2CheckboxFlag.isVisible()) {
			uncheckBonus5Habits(elNumber);
		}
		String attr = eatRealFoodWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForWriteOutDailyGoalsWeek1() {
		Logger.info("Check Amount of Totals for Write Out Daily Goals Week 1 is equal 7");
		totalValueWriteOutDailyGoalsWeek1.waitUntilVisible();
		assertTrue(totalValueWriteOutDailyGoalsWeek1.getText().equals("7"), "Amount of Totals for Write Out Daily Goals Week 1 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkAmountOfTotalsForWriteOutDailyGoalsWeek2() {
		Logger.info("Check Amount of Totals for Write Out Daily Goals Week 2 is equal 7");
		assertTrue(totalValueWriteOutDailyGoalsWeek2.getText().equals("7"), "Amount of Totals for Write Out Daily Goals Week 2 is not equal 7");
		return this;
	}

	public HabitTrackerAnalysisPage checkWriteOutDailyGoalsWeek1CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Write Out Daily Goals Week 1 are empty");
		week1Tab.waitUntilVisible();
		if (writeOutDailyGoalsWeek1CheckboxFlag.isVisible()) {
			uncheckBonus5Habits(elNumber);
		}
		String attr = writeOutDailyGoalsWeek1CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkWriteOutDailyGoalsWeek2CheckboxIsEmpty(int elNumber) {
		Logger.info("Check checkboxes for Write Out Daily Goals Week 2 are empty");
		if (writeOutDailyGoalsWeek2CheckboxFlag.isVisible()) {
			uncheckBonus5Habits(elNumber);
		}
		String attr = writeOutDailyGoalsWeek2CheckboxFlag.getAttribute("style");
		assertEquals(attr, "visibility: hidden;", "Checkbox is not empty");
		return this;
	}

	public HabitTrackerAnalysisPage checkContentBonus5HabitsNotEditableWeek1() {
		Logger.info("Check Bonus 5 habits table for Week 1 is not editable");
		tableCellsBonus5HabitsWeek1.waitUntilVisible();
		boolean isTextAreaElementPresent = tableCellsBonus5HabitsWeek1
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().contains("textarea"));

		boolean isInputElementPresent = tableCellsBonus5HabitsWeek1
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().equals("input"));
		assertFalse(isTextAreaElementPresent, "Bonus 5 Habits Content is editable");
		assertFalse(isInputElementPresent, "Bonus 5 Habits Content is editable");
		return this;
	}

	public HabitTrackerAnalysisPage checkContentBonus5HabitsNotEditableWeek2() {
		Logger.info("Check Bonus 5 habits table for Week 2 is not editable");
		boolean isTextAreaElementPresent = tableCellsBonus5HabitsWeek2
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().contains("textarea"));

		boolean isInputElementPresent = tableCellsBonus5HabitsWeek2
				.getElements()
				.parallelStream()
				.anyMatch(element -> element.getTagName().equals("input"));
		assertFalse(isTextAreaElementPresent, "Bonus 5 Habits Content is editable");
		assertFalse(isInputElementPresent, "Bonus 5 Habits Content is editable");
		return this;
	}

	public HabitTrackerAnalysisPage checkBonus5HabitsHeaderWeek1Css() {
		Logger.info("Check 'Bonus 5 habits' header font colour");
		bonus5HabitsHeaderWeek1.waitUntilVisible();
		String textBonus5HabitsHeader = bonus5HabitsHeaderWeek1
				.getCssValue("color");
		assertEquals(textBonus5HabitsHeader, whiteColor, "The font colour of the 'Bonus 5 habits' header doesn't correspond to mock-up");

		Logger.info("Check 'Bonus 5 habits' header background colour");
		String backgroundColorBonus5HabitsHeader = bonus5HabitsHeaderWeek1
				.getCssValue("background-color");
		assertEquals(backgroundColorBonus5HabitsHeader, orangeColor, "The background colour of the 'Bonus 5 habits' header doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkBonus5HabitsHeaderWeek2Css() {
		Logger.info("Check 'Bonus 5 habits' header font colour");
		String textBonus5HabitsHeader = bonus5HabitsHeaderWeek2
				.getCssValue("color");
		assertEquals(textBonus5HabitsHeader, whiteColor, "The font colour of the 'Bonus 5 habits' header doesn't correspond to mock-up");

		Logger.info("Check 'Bonus 5 habits' header background colour");
		String backgroundColorBonus5HabitsHeader = bonus5HabitsHeaderWeek2
				.getCssValue("background-color");
		assertEquals(backgroundColorBonus5HabitsHeader, orangeColor, "The background colour of the 'Bonus 5 habits' header doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkDayNumberHeaderBonus5HabitsWeek1Css() {
		Logger.info("Check day number header font colour for Bonus 5 Habits table");
		String textDayNumberHeader = dayNumberBonus5HabitsHeaderWeek1
				.getCssValue("color");
		assertEquals(textDayNumberHeader, whiteColor, "The font colour for Bonus 5 Habits table of day number doesn't correspond to mock-up");

		Logger.info("Check day number background colour");
		String backgroundColorDayNumberHeader = dayNumbersAllBonus5HabitsWeek1
				.getCssValue("background-color");
		assertEquals(backgroundColorDayNumberHeader, lightOrangeColor, "The background colour for Bonus 5 Habits table of day number doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkDayNumberHeaderBonus5HabitsWeek2Css() {
		Logger.info("Check day number header for Bonus 5 Habits table font colour");
		String textDayNumberHeader = dayNumberBonus5HabitsHeaderWeek2
				.getCssValue("color");
		assertEquals(textDayNumberHeader, whiteColor, "The font colour for Bonus 5 Habits table of day number doesn't correspond to mock-up");

		Logger.info("Check day number background colour for Bonus 5 Habits table");
		String backgroundColorDayNumberHeader = dayNumbersAllBonus5HabitsWeek2
				.getCssValue("background-color");
		assertEquals(backgroundColorDayNumberHeader, lightOrangeColor, "The background colour for Bonus 5 Habits table of day number doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkExpandIconOnBonus5HabitsWeek1Displayed() {
		Logger.info("Check expand icon on Bonus 5 habits for Week 1 is displayed");
		expandIconBonus5HabitsWeek1.waitUntilVisible();
		assertTrue(expandIconBonus5HabitsWeek1.isVisible(), "Expand icon on Bonus 5 habits for Week 1 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkExpandIconOnBonus5HabitsWeek2Displayed() {
		Logger.info("Check expand icon on Bonus 5 habits for Week 2 is displayed");
		assertTrue(expandIconBonus5HabitsWeek2.isVisible(), "Expand icon on Bonus 5 habits for Week 2 is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage clickExpandIconBonus5HabitsWeek1() {
		Logger.info("Click expand icon for Bonus 5 Habits table on Week 1 tab");
		expandIconBonus5HabitsWeek1
				.waitUntilVisible()
				.click();
		return this;
	}

	public HabitTrackerAnalysisPage checkPlusIconBonus5HabitsWeek1() {
		Logger.info("Check plus icon on Bonus 5 Habits Week 1");
		boolean isPlusIconPresent = expandIconBonus5HabitsWeek1
				.getAttribute("class")
				.contains("active");
		assertFalse(isPlusIconPresent, "Plus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkMinusIconBonus5HabitsWeek1() {
		Logger.info("Check minus icon on Bonus 5 Habits Week 1");
		boolean isPlusIconPresent = expandIconBonus5HabitsWeek1
				.getAttribute("class")
				.contains("active");
		assertTrue(isPlusIconPresent, "Minus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage clickExpandIconBonus5HabitsWeek2() {
		Logger.info("Click expand icon for Bonus 5 Habits table on Week 2 tab");
		expandIconBonus5HabitsWeek2.click();
		return this;
	}

	public HabitTrackerAnalysisPage checkPlusIconBonus5HabitsWeek2() {
		Logger.info("Check plus icon on Bonus 5 Habits Week 2");
		boolean isPlusIconPresent = expandIconBonus5HabitsWeek2
				.getAttribute("class")
				.contains("active");
		assertFalse(isPlusIconPresent, "Plus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkMinusIconBonus5HabitsWeek2() {
		Logger.info("Check minus icon on Break 5 Habits Week 2");
		boolean isPlusIconPresent = expandIconBonus5HabitsWeek2
				.getAttribute("class")
				.contains("active");
		assertTrue(isPlusIconPresent, "Minus icon is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAnalysisTabStaticContentDisplayed() {
		Logger.info("Check Analysis tab static content is displayed");
		assertTrue(analysisTabStaticContent.isVisible(), "Analysis tab static content is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkAnalysisTabAllContentDisplayed() {
		Logger.info("Check Analysis tab all content is displayed");
		assertTrue(analysisTabAllContent.isVisible(), "Analysis tab all content is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkStartLoseItAgainButtonDisplayed() {
		Logger.info("Check 'Start Lose It Again' button is displayed");
		assertTrue(startLoseItAgainButton.isVisible(), "'Start Lose It Again' button is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkMoveToLiveItButtonDisplayed() {
		Logger.info("Check 'Move To Live It' button is displayed");
		assertTrue(moveToLiveItButton.isVisible(), "'Move To Live It' button is not displayed");
		return this;
	}

	public HabitTrackerAnalysisPage checkStartLoseItAgainButtonCss() {
		Logger.info("Check 'Start Lose It Again' button color");
		String colorStartLoseItAgainButton = startLoseItAgainButton
				.getCssValue("background-color");
		assertEquals(colorStartLoseItAgainButton, deepOrangeColor, "The colour of the 'Start Lose It Again' button doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkMoveToLiveItButtonCss() {
		Logger.info("Check 'Move To Live It' button color");
		String colorMoveToLiveItButton = moveToLiveItButton
				.getCssValue("background-color");
		assertEquals(colorMoveToLiveItButton, deepOrangeColor, "The colour of the 'Move To Live It' button doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkStartLoseItAgainButtonOnHoverCss() {
		Logger.info("Check 'Start Lose It Again' button color on hover");
		startLoseItAgainButton.mouseHover();
		if (Settings.browser.equals(BrowserType.IE)) {
			startLoseItAgainButton.moveSlider(1, 1);
		}
		String colorStartLoseItAgainButton = startLoseItAgainButton
				.getCssValue("background-color");
		assertEquals(colorStartLoseItAgainButton, darkOrangeColor, "The colour on hover of the 'Start Lose It Again' button doesn't correspond to mock-up");
		return this;
	}

	public HabitTrackerAnalysisPage checkMoveToLiveItButtonOnHoverCss() {
		Logger.info("Check 'Move To Live It' button color on hover");
		moveToLiveItButton.mouseHover();
		if (Settings.browser.equals(BrowserType.IE)) {
			moveToLiveItButton.moveSlider(1, 1);
		}
		String colorMoveToLiveItButton = moveToLiveItButton
				.getCssValue("background-color");
		assertEquals(colorMoveToLiveItButton, darkOrangeColor, "The colour on hover of the 'Move To Live It' button doesn't correspond to mock-up");
		return this;
	}

	public HomePage clickStartLoseItAgainButtonClick() {
		Logger.info("Click 'Start Lose It Again' button");
		startLoseItAgainButton.click();
		startLoseItAgainButton.waitUntilStalenessOfElement();
		return PageFactory.initElements(basedriver, HomePage.class);
	}

	public HomePage clickMoveToLiveItButtonClick() {
		Logger.info("Click 'Move To Live It' button");
		moveToLiveItButton.click();
		return PageFactory.initElements(basedriver, HomePage.class);
	}

	public HabitTrackerAnalysisPage checkAllSectionsExpandedWeek1() {
		Logger.info("Check all sections are expanded");
		assertFalse(add5HabitsTableWeek1.getAttribute("style").contains(hidedTableStyle), "Add 5 Habits week 1 table is not expanded");
		assertFalse(break5HabitsTableWeek1.getAttribute("style").contains(hidedTableStyle), "Break 5 Habits week 1 table is not expanded");
		assertFalse(bonus5HabitsTableWeek1.getAttribute("style").contains(hidedTableStyle), "Bonus 5 Habits week 1 table is not expanded");
		return this;
	}

	public HabitTrackerAnalysisPage checkAllSectionsExpandedWeek2() {
		Logger.info("Check all sections are expanded");
		assertFalse(add5HabitsTableWeek2.getAttribute("style").contains(hidedTableStyle), "Add 5 Habits week 2 table is not expanded");
		assertFalse(break5HabitsTableWeek2.getAttribute("style").contains(hidedTableStyle), "Break 5 Habits week 2 table is not expanded");
		assertFalse(bonus5HabitsTableWeek2.getAttribute("style").contains(hidedTableStyle), "Bonus 5 Habits week 2 table is not expanded");
		return this;
	}

	public HabitTrackerAnalysisPage uncheckAdd5Habits(int elNumber) {
		Logger.info("Click on checkbox for Add 5 habits tab");
		if (!Settings.isEnvironment(Environment.PROD)) {
			return this;
		} else {
			clickReturnToHomePageButton()
					.clickOnDayAndHabitToRemove(elNumber)
					.clickFullProgressReportLinkOnHabitTracker();
		}
		return this;
	}

	public HabitTrackerAnalysisPage uncheckBreak5Habits(int elNumber) {
		Logger.info("Click on checkbox for Break 5 habits tab");
		if (!Settings.isEnvironment(Environment.PROD)) {
			return this;
		} else {
			clickReturnToHomePageButton()
					.clickOnDayAndHabitBreak5HabitsToRemove(elNumber)
					.clickFullProgressReportLinkOnHabitTracker();
		}
		return this;
	}

	public HabitTrackerAnalysisPage uncheckBonus5Habits(int elNumber) {
		Logger.info("Click on checkbox for Bonus 5 habits tab");
		if (!Settings.isEnvironment(Environment.PROD)) {
			return this;
		} else {
			clickReturnToHomePageButton()
					.clickOnDayAndHabitBonus5HabitsToRemove(elNumber)
					.clickFullProgressReportLinkOnHabitTracker();
		}
		return this;
	}
}
