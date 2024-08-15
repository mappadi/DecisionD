package org.everydayhealth.tests;

import com.google.common.collect.ImmutableMap;
import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.personalizedTracker.CrohnsPersonalizedTrackerPage;
import everydayhealth.pages.personalizedTracker.DiabetesPersonalizedTrackerPage;
import everydayhealth.pages.personalizedTracker.PersonalizedTrackerPage;
import framework.Logger;
import framework.Settings;
import framework.platform.DatePatterns;
import framework.platform.Environment;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserActionsEH;
import framework.platform.UserCacheEH;
import framework.platform.UserEH;
import framework.platform.utilities.DateUtils;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * PersonalizedTrackerTest
 */
public class PersonalizedTrackerTest extends WidgetsBaseTest {

	UserEH user;

	static ImmutableMap<Integer, String> painDesc = ImmutableMap.<Integer, String>builder()
			.put(0, "I had no pain today.")
			.put(1, "I felt some pain but it didn't limit activity.")
			.put(2, "I felt some pain but it didn't limit activity.")
			.put(3, "I had mild pain but could be active.")
			.put(4, "I had mild pain but could be active.")
			.put(5, "Moderate pain kept me from doing some activities.")
			.put(6, "Moderate pain kept me from doing some activities.")
			.put(7, "Severe pain prohibits most activities.")
			.put(8, "Severe pain prohibits most activities.")
			.put(9, "Excruciating pain makes me unable to do any activities.")
			.put(10, "Excruciating pain makes me unable to do any activities.").build();

	static ImmutableMap<Integer, String> savedPainDesc = ImmutableMap.<Integer, String>builder()
			.put(0, "No")
			.put(1, "Minor")
			.put(2, "Minor")
			.put(3, "Mild")
			.put(4, "Mild")
			.put(5, "Moderate")
			.put(6, "Moderate")
			.put(7, "Severe")
			.put(8, "Severe")
			.put(9, "Excruciating")
			.put(10, "Excruciating").build();

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C276403"})
	@TestRail(id = "C276403")
	public void verifyRADailyViewElements() {
		verifyDailyViewElements(TemplatesEH.RA_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C287068"})
	@TestRail(id = "C287068")
	public void verifyCrohnsDailyViewElements() {
		verifyDailyViewElements(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311801"})
	@TestRail(id = "C311801")
	public void verifyDiabetesDailyViewElements() {
		verifyDailyViewElements(TemplatesEH.DIABETES_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C276404"}, priority = 0)
	@TestRail(id = "C276404")
	public void verifyRAEmojis() {
		verifyEmojis(TemplatesEH.RA_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C287069"}, priority = 0)
	@TestRail(id = "C287069")
	public void verifyCrohnsEmojis() {
		verifyEmojis(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311802"})
	@TestRail(id = "C311802")
	public void verifyDiabetesEmojis() {
		verifyEmojis(TemplatesEH.DIABETES_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C276405"})
	@TestRail(id = "C276405")
	public void verifyRADatePicker() {
		verifyDatePicker(TemplatesEH.RA_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C287070"})
	@TestRail(id = "C287070")
	public void verifyCrohnsDatePicker() {
		verifyDatePicker(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311803"})
	@TestRail(id = "C311803")
	public void verifyDiabetesDatePicker() {
		verifyDatePicker(TemplatesEH.DIABETES_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C276406"})
	@TestRail(id = "C276406")
	public void verifyRADailyViewNavigation() {
		verifyDailyViewNavigation(TemplatesEH.RA_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C287071"})
	@TestRail(id = "C287071")
	public void verifyCrohnsDailyViewNavigation() {
		verifyDailyViewNavigation(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311804"})
	@TestRail(id = "C311804")
	public void verifyDiabetesDailyViewNavigation() {
		verifyDailyViewNavigation(TemplatesEH.DIABETES_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C276407"})
	@TestRail(id = "C276407")
	public void verifyRAWeeklyView() {
		verifyWeeklyView(TemplatesEH.RA_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C287067"})
	@TestRail(id = "C287067")
	public void verifyCrohnsWeeklyView() {
		verifyWeeklyView(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311797"})
	@TestRail(id = "C311797")
	public void verifyDiabetesWeeklyView() {
		verifyWeeklyView(TemplatesEH.DIABETES_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C276408"})
	@TestRail(id = "C276408")
	public void verifyRAEditMyDayButtonFuctionality() {
		verifyEditMyDayButton(TemplatesEH.RA_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C287075"})
	@TestRail(id = "C287075")
	public void verifyCrohnsEditMyDayButtonFuctionality() {
		verifyEditMyDayButton(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311798"})
	@TestRail(id = "C311798")
	public void verifyDiabetesEditMyDayButtonFuctionality() {
		verifyEditMyDayButton(TemplatesEH.DIABETES_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C276409"}, priority = 1)
	@TestRail(id = "C276409")
	public void verifyAddingContentRA() {
		verifyAddingContent(TemplatesEH.RA_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C287076"}, priority = 1)
	@TestRail(id = "C287076")
	public void verifyAddingContentCrohns() {
		verifyAddingContent(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311799"})
	@TestRail(id = "C311799")
	public void verifyAddingContentDiabetes() {
		verifyAddingContent(TemplatesEH.DIABETES_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C276419"}, priority = 2)
	@TestRail(id = "C276419")
	public void verifyRASaveChangesPopUpFunctionality() {
		verifySaveChangesPopUp(TemplatesEH.RA_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C287077"}, priority = 2)
	@TestRail(id = "C287077")
	public void verifyCrohnsSaveChangesPopUpFunctionality() {
		verifySaveChangesPopUp(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311800"})
	@TestRail(id = "C311800")
	public void verifyDiabetesSaveChangesPopUpFunctionality() {
		verifySaveChangesPopUp(TemplatesEH.DIABETES_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C287295"}, priority = 3)
	@TestRail(id = "C287295")
	public void verifyOmnitureOnRADashboard() {
		verifyOmnitureValuesOnDashboard(TemplatesEH.RA_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C287296"}, priority = 3)
	@TestRail(id = "C287296")
	public void verifyOmnitureOnCrohnsDashboard() {
		verifyOmnitureValuesOnDashboard(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C287508"}, priority = 4)
	@TestRail(id = "C287508")
	public void verifyTextMessagingAPIOnRADashboard() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			verifyMoodLevelKeywords(TemplatesEH.RA_PERSONALIZED_TRACKER);
		} else {
			Logger.info("Text messaging is tested on real devices on PROD environment");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C287514"}, priority = 5)
	@TestRail(id = "C287514")
	public void verifyTextMessagingAPIForRASubscription() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			verifyUnsubscribeKeywords(TemplatesEH.RA_PERSONALIZED_TRACKER);
		} else {
			Logger.info("Text messaging is tested on real devices on PROD environment");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C287513"}, priority = 4)
	@TestRail(id = "C287513")
	public void verifyTextMessagingAPIOnCrohnsDashboard() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			verifyMoodLevelKeywords(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
		} else {
			Logger.info("Text messaging is tested on real devices on PROD environment");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C287515"}, priority = 5)
	@TestRail(id = "C287515")
	public void verifyTextMessagingAPIForCrohnsSubscription() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			verifyUnsubscribeKeywords(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
		} else {
			Logger.info("Text messaging is tested on real devices on PROD environment");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311875"})
	@TestRail(id = "C311875")
	public void verifyNewsletterWidgetFunctionalityRADashboard() {
		verifyNewsletterWidgetFunctionalityPTPage(TemplatesEH.RA_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311876"})
	@TestRail(id = "C311876")
	public void verifyNewsletterWidgetFunctionalityCrohnsDashboard() {
		verifyNewsletterWidgetFunctionalityPTPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311877"})
	@TestRail(id = "C311877")
	public void verifyNewsletterWidgetFunctionalityDiabetesDashboard() {
		verifyNewsletterWidgetFunctionalityPTPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311867"}, priority = 7)
	@TestRail(id = "C311867")
	public void verifyBowelMovementModuleCrohnsDailyView() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		CrohnsPersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, CrohnsPersonalizedTrackerPage.class);
		assertTrue(ptPage.isBowelMovementModuleVisibleInDailyView(), "Bowel movement module should be visible in daily view");
		ptPage.clickEditMyDayButton();
		assertTrue(ptPage.isBowelMovementInEditMode(), "Bowel movement module should be in edit mode");
		assertTrue(ptPage.isBowelMovementModuleEditModeDropdownVisible(), "Bowel movement module dropdown should be visible");
		assertTrue(ptPage.getBowelMovementDropdownOptionText(1).equals("#"), "Default dropdown value should be '#'");
		assertTrue(ptPage.getBowelMovementDropdownOptionText(2).equals("1-3"), "Dropdown should contain '1-3' value");
		assertTrue(ptPage.getBowelMovementDropdownOptionText(3).equals("4-6"), "Dropdown should contain '4-6' value");
		assertTrue(ptPage.getBowelMovementDropdownOptionText(4).equals("7-9"), "Dropdown should contain '7-9' value");
		assertTrue(ptPage.getBowelMovementDropdownOptionText(5).equals("> 9"), "Dropdown should contain '>9' value");
		assertTrue(ptPage.getBowelMovementDropdownOptionText(6).equals("None"), "Dropdown should contain 'None' value");
		ptPage.clickBowelMovementModuleDropdownOptionWithValue("1-3").clickSaveChangesLink();
		assertTrue(ptPage.isDailyBowelMovementSavedDataVisible(), "Saved data should be displayed");
		assertEquals(ptPage.getDailyBowelMovementModuleData(), "1-3", "Chosen value should be saved and displayed in daily view");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C312162"}, priority = 8)
	@TestRail(id = "C312162")
	public void verifyBowelMovementModuleCrohnsWeeklyView() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		CrohnsPersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, CrohnsPersonalizedTrackerPage.class);
		ptPage.clickWeeklyTab();
		assertTrue(ptPage.isWeeklyBowelMovementModuleVisible(), "Weekly bowel movement module should be visible");
		assertTrue(ptPage.isWeeklyBowelMovementResultTextVisible(), "Weekly bowel movement module results should be visible");
		assertTrue(ptPage.isWeeklyBowelMovementPoomojiVisible(), "Weekly bowel movement module poomoji should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311869"})
	@TestRail(id = "C311869")
	public void verifyDailyBloodSugarLevelModule() {
		String GREY_COLOR = "#ededed";
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		DiabetesPersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, DiabetesPersonalizedTrackerPage.class);
		assertTrue(ptPage.isBloodSugarLevelModuleVisibleOnDailyView(), "Blood sugar level module should be visible on Daily view");
		if (ptPage.isBSLModuleInNonEditMode()) {
			assertEquals(ptPage.getBSLModuleLabelInNonEditMode(), "Based on your target sugar range.", "'Based on your target sugar range.' text should be visible");
			ptPage.clickEditMyDayButton();
			assertTrue(ptPage.isBSLModuleQuestionVisible(), "Question should be visible on BSL module in edit mode");
			assertEquals(ptPage.getBSLModuleQuestionText(), "Did you test today?", "Question should be 'Did you test today?'");
			assertTrue(ptPage.isBSLModuleNoAnswerButtonVisible(), "'No' answer button should be visible");
			assertTrue(ptPage.isBSLModuleYesAnswerButtonVisible(), "'Yes' answer button should be visible");
			ptPage.clickBSLModuleNoAnswerButton().clickSaveChangesButton();
			assertTrue(ptPage.isBloodSugarLevelModuleVisibleOnDailyView(), "Blood sugar level module should be visible on Daily view");
			ptPage.clickEditMyDayLink();
			ptPage.clickBSLModuleYesAnswerButton();
			assertTrue(ptPage.isBSLModuleInputsVisible(), "Additional inputs should be visible");
			assertEquals(ptPage.getNumberOfBars(), 3, "3 bars should be visible in edit mode");
			assertEquals(ptPage.getColorOfBarNumber(1), GREY_COLOR, "First bar should be grey");
			assertEquals(ptPage.getColorOfBarNumber(2), GREY_COLOR, "Second bar should be grey");
			assertEquals(ptPage.getColorOfBarNumber(3), GREY_COLOR, "Third bar should be grey");
			ptPage.clickOnBarWithLevel(1, "Low").clickOnBarWithLevel(2, "At Goal").clickOnBarWithLevel(3, "High");
			assertEquals(ptPage.getColorOfBarNumber(1), "#dfc9c9", "First bar should change color");
			assertEquals(ptPage.getColorOfBarNumber(2), "#c67a7a", "Second bar should change color");
			assertEquals(ptPage.getColorOfBarNumber(3), "#9a3939", "Third bar should change color");
			ptPage.clickSaveChangesLink();
			assertEquals(ptPage.getTextOfResultNumber(1), "Breakfast/Fasting: Low");
			assertEquals(ptPage.getTextOfResultNumber(2), "After Meals: At Goal");
			assertEquals(ptPage.getTextOfResultNumber(3), "Bedtime: High");
		} else {
			Logger.info("This test already has results for today.");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311870"})
	@TestRail(id = "C311870")
	public void verifyWeeklyBloodSugarLevelModule() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		DiabetesPersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, DiabetesPersonalizedTrackerPage.class);
		ptPage.clickWeeklyTab();
		assertTrue(ptPage.isWeeklyBSLModuleVisible(), "Blood sugar level module should be visible in weekly view");
		assertTrue(ptPage.isBSLResultsModuleVisibleInWeeklyView(), "Results should be visible in BSL module in weekly view");
		assertEquals(ptPage.getNumberOfResultContainers(), 2, "Only two results should be visible in Results module");
		assertTrue(ptPage.isBSLModuleResultsLabelVisible("Low Blood Sugar"), "'Low Blood Sugar' label should be visible in Results container");
		assertTrue(ptPage.isBSLModuleResultsLabelVisible("High Blood Sugar"), "'High Blood Sugar' label should be visible in Results container");
		assertEquals(ptPage.getBSLModuleResultsLabelTimeText("Low Blood Sugar"), "Breakfast/Fasting", "Time label should be 'Breakfast/Fasting'");
		assertEquals(ptPage.getBSLModuleResultsLabelTimeText("High Blood Sugar"), "Bedtime", "Time label should be 'Bedtime'");
		assertTrue(ptPage.isImageVisibleForResult("Low Blood Sugar"), "Image should be visible for 'Low Blood Sugar' result");
		assertTrue(ptPage.isImageVisibleForResult("High Blood Sugar"), "Image should be visible for 'High Blood Sugar' result");
		assertTrue(ptPage.isLabelVisibleOnResultImage("Low Blood Sugar"), "Counter label should be visible for 'Low Blood Sugar' result");
		assertTrue(ptPage.isLabelVisibleOnResultImage("High Blood Sugar"), "Counter label should be visible for 'High Blood Sugar' result");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311871"})
	@TestRail(id = "C311871")
	public void verifyWeeklyBMIModule() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		DiabetesPersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, DiabetesPersonalizedTrackerPage.class);
		ptPage.clickWeeklyTab();
		assertTrue(ptPage.isBMIModuleVisible(), "BMI module should be visible in weekly view");
		assertTrue(ptPage.isBMIModuleHeadingVisible(), "Heading should be visible for BMI module");
		if (ptPage.isRecalculateLinkVisible()) {
			Logger.info("Click 'Recalculate' button to verify BMI module functionality");
			ptPage.clickRecalculateLink();
		}
		assertTrue(ptPage.isWeightInputVisible(), "'Weight' input should be visible");
		assertTrue(ptPage.isHeightFtDropdownVisible(), "'Height Ft' dropdown should be visible");
		assertTrue(ptPage.isHeightInDropdownVisible(), "'Height In' dropdown should be visible");
		assertTrue(ptPage.isCalculateButtonVisible(), "'Calculate' button should be visible");
		ptPage.typeWeight("FFFFF").clickCalculateButton();
		assertFalse(ptPage.isWeightInputValueCorrect(), "'Weight' input should accept digits only");
		int numberOfOptionsInHeightFtDropdown = ptPage.getNumberOfOptionsInHeightFtDropdown();
		int numberOfOptionsInHeightInDropdown = ptPage.getNumberOfOptionsInHeightInDropdown();
		assertEquals(ptPage.getHeightFtDropdownOptionText(1), "ft", "First option should be 'ft'");
		assertEquals(ptPage.getHeightFtDropdownOptionText(2), "02", "First available option should be '02'");
		assertEquals(ptPage.getHeightFtDropdownOptionText(numberOfOptionsInHeightFtDropdown), "10", "Last available option should be '10'");
		assertEquals(ptPage.getHeightInDropdownOptionText(1), "in", "First option should be 'in'");
		assertEquals(ptPage.getHeightInDropdownOptionText(2), "00", "First available option should be '00'");
		assertEquals(ptPage.getHeightInDropdownOptionText(numberOfOptionsInHeightInDropdown), "11", "Last available option should be '11'");
		ptPage.typeWeight("155").chooseValueFromHeightFtDropdown("72").chooseValueFromHeightInDropdown("6").clickCalculateButton();
		assertTrue(ptPage.isBMIResultsVisible(), "Results for BMI should be visible");
		assertTrue(ptPage.isBMIResultsBarVisible(), "Bar should be visible on BMI results module");
		assertTrue(ptPage.isFilledBMIResultsBarVisible(), "Part of results bar should be filled");
		assertTrue(ptPage.isPinVisibleOnBMIResultsBar(), "Pin should be visible on BMI results bar");
		assertTrue(ptPage.isBMIValueVisible(), "BMI value should be present on results module");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C311872"})
	@TestRail(id = "C311872")
	public void verifyWeeklyA1CModule() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		DiabetesPersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, DiabetesPersonalizedTrackerPage.class);
		ptPage.clickWeeklyTab();
		assertTrue(ptPage.isA1CModuleVisible(), "A1C module should be visible");
		assertTrue(ptPage.isA1CCalculatorHeadingVisible(), "A1C heading should be visible");
		if (ptPage.isEditLinkVisible()) {
			ptPage.clickEditLink();
		}
		assertTrue(ptPage.isA1CCalculatorVisible(), "A1C calculator should be visible");
		assertTrue(ptPage.isA1CGoalDropdownVisible(), "'What’s Your A1C Goal?' dropdown should be visible");
		assertTrue(ptPage.isA1CLastResultInputVisible(), "'Last A1C Test Result' input should be visible");
		assertTrue(ptPage.isA1CDateSelectDateButtonVisible(), "'Select Date' button should be visible");
		assertTrue(ptPage.isA1CCalculateButtonVisible(), "'Calculate' button should be visible");
		assertEquals(ptPage.getGoalDropdownOptionText(1), "%", "'%' should be default value in 'What’s Your A1C Goal?' dropdown");
		assertEquals(ptPage.getGoalDropdownOptionText(2), " < 6.5% ", "'<6.5%' value should be available in 'What’s Your A1C Goal?' dropdown");
		assertEquals(ptPage.getGoalDropdownOptionText(3), " < 7% ", "'<7%' value should be available in 'What’s Your A1C Goal?' dropdown");
		assertEquals(ptPage.getGoalDropdownOptionText(4), (" < 8% "), "'<8%' value should be available in 'What’s Your A1C Goal?' dropdown");
		assertEquals(ptPage.getGoalDropdownOptionText(5), (" > 8% "), "'>8%' value should be available in 'What’s Your A1C Goal?' dropdown");
		assertEquals(ptPage.getGoalDropdownOptionText(6), (" I haven’t had my A1C tested "), "'I haven't had my A1C tested' value should be available in 'What’s Your A1C Goal?' dropdown");
		ptPage.typeA1CLastResult("FFF").clickA1CCalculateButton();
		assertFalse(ptPage.isA1CLastResultInputValueCorrect(), "'Last A1C Test Result' input should not accept letters");
		ptPage.clickA1CModuleSelectDateButton();
		assertTrue(ptPage.isDatePickerVisible(), "Date picker should be visible");
		assertTrue(ptPage.isFutureDateDisabledInCalendar(DateUtils.getDateInFuture(1, DatePatterns.d)), "Days in future should be disabled");
		assertTrue(ptPage.isFutureDateDisabledInCalendar(DateUtils.getDateInFuture(2, DatePatterns.d)), "Days in future should be disabled");
		assertTrue(ptPage.isFutureDateDisabledInCalendar(DateUtils.getDateInFuture(3, DatePatterns.d)), "Days in future should be disabled");
		String goal = ">8%";
		String lastResult = "9";
		ptPage.typeA1CLastResult(lastResult).chooseGoalValue(goal);
		if (Settings.isMobile()) {
			ptPage.clickA1CModuleSelectDateButton();
		}
		ptPage.clickDay(DateUtils.getDayInPast(1));
		ptPage.clickA1CCalculateButton();
		assertTrue(ptPage.isA1CResultsModuleVisible(), "A1C results module should be visible");
		assertEquals(ptPage.getA1CResultsHeaderText(1), "Your Goal is", "Results header for goal should be 'You Goal is'");
		assertEquals(ptPage.getA1CResultsHeaderText(2), "Most Recent", "Results header for last result should be 'Most Recent'");
		assertEquals(ptPage.getA1CResultsAmount(1), goal, "Goal amount should be equal to the one that was entered in calculator");
		assertEquals(ptPage.getA1CResultsAmount(2), lastResult + ".0%", "Last result amount should be equal to the one that was entered in calculator");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C330317"})
	@TestRail(id = "C330317")
	public void verifyDailyEmailLink() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		DiabetesPersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, DiabetesPersonalizedTrackerPage.class);

		/*
		First we get date for Monday of current week
		Then we get date for Thursday of past week
		Navigate to the daily view for past week Thursday date and verify this date is displayed in daily view
		Switch to weekly view and verify correct week is displayed
		USER SHOULD BE LOGGED IN
		 */
		LocalDate mondayThisWeek = LocalDate.now().with(DayOfWeek.MONDAY);
		Logger.info("MONDAY FOR CURRENT WEEK: " + mondayThisWeek);
		LocalDate datePastWeek = mondayThisWeek.minusDays(4L);
		Logger.info("THURSDAY FOR PREVIOUS WEEK: " + datePastWeek);
		String dayPastWeek = datePastWeek.format(DateTimeFormatter.BASIC_ISO_DATE);
		Logger.info("THURSDAY PREVIOUS WEEK ISO DATE: " + dayPastWeek);
		String dayPastWeekFull = MonthDay.from(datePastWeek).format(DateTimeFormatter.ofPattern("MMMM d", Locale.US));
		Logger.info("THURSDAY PREVIOUS WEEK MONTH_DAY: " + dayPastWeekFull);
		ptPage = SiteNavigatorEH.goToDiabetesPTPageFromEmail("daily", dayPastWeek, "d");
		assertTrue(ptPage.isDailyTabActive(), "User should land in daily view");
		assertTrue(ptPage.getCurrentDayDate().equals("Thu, " + dayPastWeekFull), "Past thursday date should be displayed");
		ptPage.clickWeeklyTab();
		assertTrue(ptPage.isWeeklyTabActive(), "Weekly tab should be active");
		MonthDay monday = MonthDay.parse(datePastWeek.with(DayOfWeek.MONDAY).toString(), DateTimeFormatter.ofPattern("YYYY-MM-dd", Locale.US));
		Logger.info("Expected Monday date is: " + monday);
		assertEquals(getWeekMonday(ptPage), monday, "Correct week should be displayed in weekly tab");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C330318"})
	@TestRail(id = "C330318")
	public void verifyWeeklyEmailLink() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		DiabetesPersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, DiabetesPersonalizedTrackerPage.class);

		/*
		First we get date for Monday of current week
		Then we get date for Thursday of past week
		Navigate to the weekly view for past week and verify correct week is displayed
		Switch to daily view and verify Monday is displayed
		USER SHOULD BE LOGGED IN
		 */
		LocalDate mondayThisWeek = LocalDate.now().with(DayOfWeek.MONDAY);
		Logger.info("MONDAY FOR CURRENT WEEK: " + mondayThisWeek);
		LocalDate datePastWeek = mondayThisWeek.minusDays(4L);
		Logger.info("THURSDAY FOR PREVIOUS WEEK: " + datePastWeek);
		String dayPastWeek = datePastWeek.format(DateTimeFormatter.BASIC_ISO_DATE);
		Logger.info("THURSDAY PREVIOUS WEEK ISO DATE: " + dayPastWeek);
		ptPage = SiteNavigatorEH.goToDiabetesPTPageFromEmail("weekly", dayPastWeek, "w");
		assertTrue(ptPage.isWeeklyTabActive(), "Weekly tab should be active");
		MonthDay day = getWeekMonday(ptPage);
		Logger.info("This week starts and finishes this month: " + DateUtils.isWeekEndsInTheSameMonth(ptPage.getWeekDates()));
		MonthDay monday = MonthDay.parse(datePastWeek.with(DayOfWeek.MONDAY).toString(), DateTimeFormatter.ofPattern("YYYY-MM-dd", Locale.US));
		Logger.info("Expected Monday for date - " + datePastWeek + " is - " + monday);
		assertEquals(day, monday, "User should see correct week in weekly view");
		ptPage.clickDailyTab();
		assertTrue(ptPage.isDailyTabActive(), "User should switch to daily tab");
		MonthDay dayInDailyView = MonthDay.parse(ptPage.getCurrentDayDate().split(",")[1].trim(), DateTimeFormatter.ofPattern("MMMM d", Locale.US));
		Logger.info("Monday in Daily view is - " + dayInDailyView);
		assertEquals(dayInDailyView, MonthDay.parse(datePastWeek.toString(), DateTimeFormatter.ofPattern("YYYY-MM-dd", Locale.US)), "Day in daily view should be the same as in email");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C333931"})
	@TestRail(id = "C333931")
	public void verifyDailyEmailSettingsNavigation() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		SiteNavigatorEH.goToPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, DiabetesPersonalizedTrackerPage.class);

		LocalDate mondayThisWeek = LocalDate.now().with(DayOfWeek.MONDAY);
		Logger.info("MONDAY FOR CURRENT WEEK: " + mondayThisWeek);
		LocalDate datePastWeek = mondayThisWeek.minusDays(4L);
		Logger.info("THURSDAY FOR PREVIOUS WEEK: " + datePastWeek);
		String dayPastWeek = datePastWeek.format(DateTimeFormatter.BASIC_ISO_DATE);
		Logger.info("THURSDAY PREVIOUS WEEK ISO DATE: " + dayPastWeek);
		DiabetesPersonalizedTrackerPage ptPage = SiteNavigatorEH.goToDiabetesPTPageFromEmail("daily", dayPastWeek, "s");
		assertTrue(ptPage.isSettingsWindowVisible(), "'Settings' window should be visible");
		assertTrue(ptPage.isSaveChangesButtonVisibleOnSettingsWindow(), "'Save Changes' button should be visible");
		assertEquals(ptPage.getDropdownChosenElementText(), "Enabled", "Email notifications should have 'Enabled' chosen in dropdown");
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C341102"}, priority = 6)
	@TestRail(id = "C341102")
	public void verifyRASymptomsTextMessaging() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
			PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

			ImmutableMap<String, String> map = ImmutableMap.<String, String>builder()
					.put("A", "Joint Pain")
					.put("B", "Morning Stiffness")
					.put("C", "Swollen Joints")
					.put("D", "Fatigue")
					.put("E", "Other Symptoms")
					.put("F", "Anxiety/Depression")
					.put("G", "What I Ate")
					.put("H", "Inactivity")
					.put("I", "Stress")
					.put("J", "Overexertion")
					.put("K", "Lack of Sleep")
					.put("L", "Weather")
					.put("M", "Missed Dose")
					.put("N", "Infection")
					.put("O", "Other")
					.put("P", "Ate Healthy Foods")
					.put("Q", "Exercised")
					.put("R", "Managed Stress")
					.put("S", "Had “Me” Time")
					.put("T", "Slept Well")
					.put("U", "Followed Treatment Plan")
					.put("V", "Enjoyed Social Outings")
					.put("W", "Felt Supported")
					.put("X", "Other Wins").build();
			for (Map.Entry<String, String> entry : map.entrySet()) {
				Utils.sendPostRequestWithParameters(entry.getKey(), "73160");
				Utils.waitFor(1500);
				ptPage.refresh();
				Utils.waitFor(1500);
				assertTrue(ptPage.isActiveButtonWithTextVisible(entry.getValue()));
			}
			uncheckSymptomsTriggersWins(ptPage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C341103"}, priority = 6)
	@TestRail(id = "C341103")
	public void verifyCrohnsSymptomsTextMessaging() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
			CrohnsPersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, CrohnsPersonalizedTrackerPage.class);

			ImmutableMap<String, String> map = ImmutableMap.<String, String>builder()
					.put("A", "Abdominal Pain/Cramping")
					.put("B", "Persistent Diarrhea")
					.put("C", "Urgency")
					.put("D", "Fatigue")
					.put("E", "Other Symptoms")
					.put("F", "Fever")
					.put("G", "Reduced Appetite")
					.put("H", "Nausea/Vomiting")
					.put("I", "Eye, Skin or Joint Issues")
					.put("J", "Blood in Stool")
					.put("K", "What I Ate")
					.put("L", "Caffeine")
					.put("M", "Alcohol")
					.put("N", "Stress")
					.put("O", "Aspirin/Ibuprofen")
					.put("P", "Smoking")
					.put("Q", "Infection")
					.put("R", "Menstrual Cramps")
					.put("S", "Missed Dose")
					.put("T", "Other")
					.put("U", "Followed Treatment Plan")
					.put("V", "Avoided Problem Foods")
					.put("W", "Got Active")
					.put("X", "Managed Stress")
					.put("Y", "Stayed Hydrated")
					.put("Z", "Slept Well")
					.put("AA", "Enjoyed Social Outings")
					.put("BB", "Felt Supported")
					.put("CC", "Other Wins").build();
			for (Map.Entry<String, String> entry : map.entrySet()) {
				Utils.sendPostRequestWithParameters(entry.getKey(), "25171");
				Utils.waitFor(1500);
				ptPage.refresh();
				assertTrue(ptPage.isActiveButtonWithTextVisible(entry.getValue()));
			}
			uncheckSymptomsTriggersWins(ptPage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344226"})
	@TestRail(id = "C344226")
	public void verifyDataSavingRAPTDailyView() {
		verifyDataSavingUsingDatePicker(TemplatesEH.RA_PERSONALIZED_TRACKER, 14, false, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.RA_PERSONALIZED_TRACKER, 60, false, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.RA_PERSONALIZED_TRACKER, 0, false, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344230"})
	@TestRail(id = "C344230")
	public void verifyDataSavingCrohnsPTDailyView() {
		verifyDataSavingUsingDatePicker(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, 14, false, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, 60, false, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, 0, false, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344234"})
	@TestRail(id = "C344234")
	public void verifyDataSavingDiabetesPTDailyView() {
		verifyDataSavingUsingDatePicker(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, 14, false, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, 60, false, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, 0, false, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344227"})
	@TestRail(id = "C344227")
	public void verifyDataSavingRAPTWeeklyView() {
		verifyDataSavingUsingDatePicker(TemplatesEH.RA_PERSONALIZED_TRACKER, 14, true, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.RA_PERSONALIZED_TRACKER, 60, true, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.RA_PERSONALIZED_TRACKER, 0, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344231"})
	@TestRail(id = "C344231")
	public void verifyDataSavingCrohnsPTWeeklyView() {
		verifyDataSavingUsingDatePicker(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, 14, true, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, 60, true, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, 0, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344235"})
	@TestRail(id = "C344235")
	public void verifyDataSavingDiabetesPTWeeklyView() {
		verifyDataSavingUsingDatePicker(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, 14, true, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, 60, true, false);
		verifyDataSavingUsingDatePicker(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, 0, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344228"})
	@TestRail(id = "C344228")
	public void verifyDataSavingRAPTDailyViewNavArrows() {
		verifyDataSavingUsingDatePicker(TemplatesEH.RA_PERSONALIZED_TRACKER, 14, false, true);
		verifyDataSavingUsingDatePicker(TemplatesEH.RA_PERSONALIZED_TRACKER, 60, false, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344232"})
	@TestRail(id = "C344232")
	public void verifyDataSavingCrohnsPTDailyViewNavArrows() {
		verifyDataSavingUsingDatePicker(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, 14, false, true);
		verifyDataSavingUsingDatePicker(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, 60, false, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344236"})
	@TestRail(id = "C344236")
	public void verifyDataSavingDiabetesPTDailyViewNavArrows() {
		verifyDataSavingUsingDatePicker(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, 14, false, true);
		verifyDataSavingUsingDatePicker(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, 60, false, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344229"})
	@TestRail(id = "C344229")
	public void verifyDataSavingRAPTWeeklyViewNavArrows() {
		verifyDataSavingUsingDatePicker(TemplatesEH.RA_PERSONALIZED_TRACKER, 14, true, true);
		verifyDataSavingUsingDatePicker(TemplatesEH.RA_PERSONALIZED_TRACKER, 60, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344233"})
	@TestRail(id = "C344233")
	public void verifyDataSavingCrohnsPTWeeklyViewNavArrows() {
		verifyDataSavingUsingDatePicker(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, 14, true, true);
		verifyDataSavingUsingDatePicker(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, 60, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "C344237"})
	@TestRail(id = "C344237")
	public void verifyDataSavingDiabetesPTWeeklyViewNavArrows() {
		verifyDataSavingUsingDatePicker(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, 14, true, true);
		verifyDataSavingUsingDatePicker(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, 60, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C347408"})
	@TestRail(id = "C347408")
	public void verifyATCWidgetRADailyView() {
		verifyATC(TemplatesEH.RA_PERSONALIZED_TRACKER, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C347412"})
	@TestRail(id = "C347412")
	public void verifyATCWidgetRAWeeklyView() {
		verifyATC(TemplatesEH.RA_PERSONALIZED_TRACKER, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C347410"})
	@TestRail(id = "C347410")
	public void verifyATCWidgetCrohnsDailyView() {
		verifyATC(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C347413"})
	@TestRail(id = "C347413")
	public void verifyATCWidgetCrohnsWeeklyView() {
		verifyATC(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C347411"})
	@TestRail(id = "C347411")
	public void verifyATCWidgetDiabetesDailyView() {
		verifyATC(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C347414"})
	@TestRail(id = "C347414")
	public void verifyATCWidgetDiabetesWeeklyView() {
		verifyATC(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, true);
	}

	@BeforeGroups(groups = {"C375791"}, alwaysRun = true)
	public void beforeRAPTTest() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			Utils.releasePhoneNumber(Utils.updatePhoneNumberViaPOSTRequest());
			user = new UserEH(StringUtils.generateRandomEmail(), "Pass@123");
			UserActionsEH.registerNewPTUser(false, user);
		}
	}

	@BeforeGroups(groups = {"C375792"}, alwaysRun = true)
	public void beforeCrohnsPTTest() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			UserActionsEH.registerExistingEHUserAsNewPTUser(true, user);
		}
	}

	@BeforeGroups(groups = {"C375793"}, alwaysRun = true)
	public void beforeDiabetesPTTest() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			UserActionsEH.registerExistingEHUserAsNewPTUser(user);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "PTMedTracker", "C375791"}, priority = 1)
	@TestRail(id = "C375791")
	public void verifyRAPTMedTrackerModalWindow() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			UserActionsEH.loginWithUser(user, true);
			PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

			ptPage.onGlobalNavHeader().userLogOut();
			UserActionsEH.loginWithUser(user, true);
			ptPage = SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);
			verifyMedTrackerModalWindowElements(ptPage, false);
			verifySearchFunctionality(ptPage, "aceta", true);

			ptPage.clickSuggestion("Acetaminophen 325mg");
			ptPage.clickAddButtonOnModalWindow();
			assertTrue(ptPage.isWeeklyTabActive(), "User should be in weekly tab");
			assertTrue(ptPage.isMedTrackerModuleVisible(), "Med tracker module should be visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "PTMedTracker", "C375794"})
	@TestRail(id = "C375794")
	public void verifyRAPTMedTrackerModule() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);
		verifyMedTrackerModuleElements(ptPage, false);
		verifySearchFunctionality(ptPage, "aceta", false);

		ptPage.typeSearchQueryOnMedTrackerModule("Anacin").clickSuggestion("Anacin").clickAddButtonOnMedTrackerModule();
		assertEquals(ptPage.getNumberOfMedicationItems(), 2, "List should contain 2 medications");
		assertTrue(ptPage.getHyperlinkedMedicationHrefValue(1).endsWith("drugs/anacin"), "Hyperlinked items should lead to drug profile page");
		ptPage.typeSearchQueryOnMedTrackerModule("Anacin").clickSuggestion("Anacin").clickAddButtonOnMedTrackerModule();
		assertTrue(ptPage.isDuplicateMedicationErrorMessageVisible(), "Error message should appear");
		Logger.info("Verify [x] remove icon functionality");
		ptPage.clickRemoveMedicationIcon(2);
		assertEquals(ptPage.getNumberOfMedicationItems(), 1, "1 medication should be present in the list");
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "PTMedTracker", "C375792"}, dependsOnMethods = {"verifyRAPTMedTrackerModalWindow"}, priority = 2)
	@TestRail(id = "C375792")
	public void verifyCrohnsPTMedTrackerModalWindow() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			UserActionsEH.loginWithUser(user, true);
			PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

			ptPage.onGlobalNavHeader().userLogOut();
			UserActionsEH.loginWithUser(user, true);
			verifyMedTrackerModalWindowElements(ptPage, true);
			verifySearchFunctionality(ptPage, "hyos", true);

			ptPage.clickSuggestion("Hyospaz");
			ptPage.clickAddButtonOnModalWindow();
			assertTrue(ptPage.isWeeklyTabActive(), "User should be in weekly tab");
			assertTrue(ptPage.isMedTrackerModuleVisible(), "Med tracker module should be visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "PTMedTracker", "C375798"})
	@TestRail(id = "C375798")
	public void verifyCrohnsPTMedTrackerModule() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);
		verifyMedTrackerModuleElements(ptPage, true);
		verifySearchFunctionality(ptPage, "hyos", false);

		ptPage.typeSearchQueryOnMedTrackerModule("Humira").clickSuggestion("Humira").clickAddButtonOnMedTrackerModule();
		assertEquals(ptPage.getNumberOfMedicationItems(), 2, "List should contain 2 medications");
		assertTrue(ptPage.getHyperlinkedMedicationHrefValue(2).endsWith("drugs/humira"), "Hyperlinked items should lead to drug profile page");
		ptPage.typeSearchQueryOnMedTrackerModule("Humira").clickSuggestion("Humira").clickAddButtonOnMedTrackerModule();
		assertTrue(ptPage.isDuplicateMedicationErrorMessageVisible(), "Error message should appear");
		Logger.info("Verify [x] remove icon functionality");
		ptPage.clickRemoveMedicationIcon(2);
		assertEquals(ptPage.getNumberOfMedicationItems(), 1, "1 medication should be present in the list");
	}

	@Test(groups = {"EverydayHealthDesktop", "PTTest", "PTMedTracker", "C375793"}, dependsOnMethods = {"verifyCrohnsPTMedTrackerModalWindow"}, priority = 3)
	@TestRail(id = "C375793")
	public void verifyDiabetesPTMedTracker() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			UserActionsEH.loginWithUser(user, true);
			DiabetesPersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, DiabetesPersonalizedTrackerPage.class);
			ptPage.refresh();
			assertFalse(ptPage.isMedTrackerkModalWindowVisible(), "Med tracker modal window should not appear");
			ptPage.clickWeeklyTab();
			assertFalse(ptPage.isMedTrackerModuleVisible(), "Med tracker module should not appear");
		}
	}

	private void verifyDataSavingUsingDatePicker(TemplatesEH url, int daysAgo, boolean isWeeklyView, boolean arrowsNavigation) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_REGISTRATION_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);

		verifyCorrectDataIsDisplayedOnPageLoad(ptPage, isWeeklyView);
		ptPage.openDayInPast(ptPage, daysAgo, arrowsNavigation);
		verifyCorrectDataIsOpened(ptPage, daysAgo, isWeeklyView);

		ptPage.clickEditMyDayLink();
		int randomSymptom = StringUtils.generateRandomInt(ptPage.getNumberOfMySymptomsVariantButtons());
		String symptom = ptPage.getMySymptomsVariantButtonText(randomSymptom);
		int randomTrigger = StringUtils.generateRandomInt(ptPage.getNumberOfMyTriggersVariantButtons());
		String trigger = ptPage.getMyTriggersVariantButtonText(randomTrigger);
		int randomWin = StringUtils.generateRandomInt(ptPage.getNumberOfMyWinsVariantButtons());
		String win = ptPage.getMyWinsVariantButtonText(randomWin);
		int randomEmoji = StringUtils.generateRandomIntInRange(1, 5);
		ptPage.clickMySymptomsVariantButton(randomSymptom)
				.clickMyTriggersVariantButton(randomTrigger)
				.clickMyWinsVariantButton(randomWin)
				.clickEmojiIconNumber(randomEmoji);
		assertTrue(ptPage.isMySymptomsVariantButtonChosen(symptom), "Symptom should be chosen");
		assertTrue(ptPage.isMyTriggersVariantButtonChosen(trigger), "Trigger should be chosen");
		assertTrue(ptPage.isMyWinsVariantButtonChosen(win), "Win should be chosen");
		assertTrue(ptPage.isEmojiIconActive(randomEmoji), "Emoji should be active");
		ptPage.clickSaveChangesButton();
		verifyDataIsSaved(ptPage, symptom, trigger, win, randomEmoji);
		Utils.waitFor(2000);
		ptPage.refresh();

		verifyCorrectDataIsDisplayedOnPageLoad(ptPage, isWeeklyView);
		ptPage.openDayInPast(ptPage, daysAgo, arrowsNavigation);
		verifyCorrectDataIsOpened(ptPage, daysAgo, isWeeklyView);

		verifyDataIsSaved(ptPage, symptom, trigger, win, randomEmoji);
		ptPage.onGlobalNavHeader().userLogOut();
	}

	private void verifyCorrectDataIsDisplayedOnPageLoad(PersonalizedTrackerPage ptPage, boolean isWeeklyView) {
		LocalDate today = LocalDate.now();
		assertTrue(ptPage.getCurrentDayDate().endsWith(today.format(DateTimeFormatter.ofPattern("MMMM d", Locale.US))), "Current day should be displayed");
		if (isWeeklyView) {
			ptPage.clickWeeklyTab();
			assertTrue(ptPage.isCorrectWeekVisibleForDate(today), "Current week should be displayed in weekly view");
		}
	}

	private void verifyCorrectDataIsOpened(PersonalizedTrackerPage ptPage, int daysAgo, boolean isWeeklyView) {
		LocalDate dayInPast = daysAgo == 0 ? ptPage.getProgramStartDate() : LocalDate.now().minusDays(daysAgo);
		if (isWeeklyView) {
			assertTrue(ptPage.isCorrectWeekVisibleForDate(dayInPast), "Date in past " + dayInPast + " is not in the week that is displayed");
			ptPage.clickDailyTab();
			assertTrue(ptPage.getCurrentDayDate().endsWith(dayInPast.with(DayOfWeek.MONDAY).format(DateTimeFormatter.ofPattern("MMMM d", Locale.US))));
		} else {
			assertTrue(ptPage.getCurrentDayDate().endsWith(dayInPast.format(DateTimeFormatter.ofPattern("MMMM d", Locale.US))));
		}
	}

	private void verifyDailyViewElements(TemplatesEH url) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertTrue(ptPage.isDailyTabActive(), "'Daily' tab should be active tab");
		assertEquals(ptPage.getActiveDayDate(), DateUtils.getCurrentDate(DatePatterns.EEE_MMMM_d), "Today's date should be opened");
		assertTrue(ptPage.isDateButtonVisible(), "'Date' button should be visible");
		assertTrue(ptPage.isHowWasYourDaySectionVisible(), "'How was your day today?' section should be visible");
		assertEquals(ptPage.getNumberOfVisibleEmojiIcons(), 5, "5 emoji icons should be visible in 'How was your day today?' section");
		assertTrue(ptPage.isDailyMySymptomsSectionVisible(), "'My Symptoms' section should be visible");
		assertTrue(ptPage.isDailyMyTriggersSectionVisible(), "'My Triggers' section should be visible");
		assertTrue(ptPage.isDailyMyWinsSectionVisible(), "'My Wins' section should be visible");
		assertTrue(ptPage.isDailyMyNotesSectionVisible(), "'My Notes' section should be visible");
		assertTrue(ptPage.isEditMyDayButtonVisible(), "'Edit my day' button should be visible");
		assertTrue(ptPage.isNewsletterWidgetVisible(), "Newsletter module should be visible");
		if (!url.equals(TemplatesEH.CROHNS_PERSONALIZED_TRACKER)) { //TODO ask Yuliya to add normal RR module to Crohn's pt on qa1
			assertTrue(ptPage.isRecommendedReadingsModuleVisibleInDailyView(), "Recommended readings module should be visible in daily view");
			if (ptPage.isRecommendedReadingsHeadingVisibleInDailyView()) {
				assertTrue(ptPage.isRecommendedReadingsHeadingImageVisibleInDailyView(), "Heading of Recommended readings module should be visible in daily view");
				assertTrue(ptPage.isRecommendedReadingsHeadingTextVisibleInDailyView(), "Icon should be visible for Recommended readings module headline in daily view");
			}
			int numberOfArticles = ptPage.getNumberOfItemsInRecommendedReadingsModuleDailyView();
			for (int articleNumber = 1; articleNumber <= numberOfArticles; articleNumber++) {
				assertEquals(ptPage.getNumberOfImagesInRecommendedReadingsModuleDailyView(), numberOfArticles, "Every article should have clickable image");
				assertEquals(ptPage.getNumberOfHeadlinesInRecommendedReadingsModuleDailyView(), numberOfArticles, "Every article should have clickable title");
			}
		}
	}

	private void verifyEmojis(TemplatesEH url) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		int numberOfEmojis = ptPage.getNumberOfVisibleEmojiIcons();
		assertEquals(numberOfEmojis, 5, "5 emoji icons should be present on page");
		ptPage.clickEditMyDayLink();
		for (int emojiNumber = 1; emojiNumber <= numberOfEmojis; emojiNumber++) {
			assertTrue(ptPage.isEmojiIconActive(emojiNumber), "Emoji icons should be active after click on 'Edit my day' button");
			if (ptPage.getNumberOfActiveEmojiOnPage() == 0) {
				Logger.debug("Changes for current day have not been done yet");
				assertTrue(ptPage.isEmojiNumberGrey(emojiNumber), "Number under emoji icon should be grey");
			} else {
				assertTrue(ptPage.isEmojiNumberVisible(emojiNumber), "Number under emoji icon should be visible");
			}
		}
		int emojiNumber = StringUtils.generateRandomIntInRange(1, 6);
		ptPage.clickEmojiIconNumber(emojiNumber);
		assertTrue(ptPage.isEmojiChosen(emojiNumber), "Chosen emoji icon should become bigger");
		assertTrue(ptPage.isEmojiSentenceVisible(emojiNumber), "Chosen emoji associated sentence should be visible");
		assertTrue(ptPage.isChosenEmojiNumberBlack(emojiNumber), "Chosen emoji number should become black");
		ptPage.clickSaveChangesLink();
		for (int emojiN = 1; emojiN <= numberOfEmojis; emojiN++) {
			if (emojiN == emojiNumber) {
				assertTrue(ptPage.isEmojiChosen(emojiN), "Chose emoji should remain active");
				assertTrue(ptPage.isEmojiNumberVisible(emojiN), "Chose emoji associated number should remain visible");
				assertTrue(ptPage.isEmojiSentenceVisible(emojiN), "Chose emoji associated sentence should remain visible");
				continue;
			}
			assertFalse(ptPage.isEmojiIconActive(emojiN), "Emoji icon #" + emojiN + " should not be active");
			assertFalse(ptPage.isEmojiNumberVisible(emojiN), "Emoji #" + emojiN + " associated number should not be visible");
		}
	}

	private void verifyDatePicker(TemplatesEH url) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertTrue(ptPage.isDateButtonVisible(), "'Date' button should be visible");
		ptPage.clickDateButton();
		assertTrue(ptPage.isDatePickerVisible(), "Calendar should be visible");
		String currentDayOfMonth = DateUtils.getCurrentDate(DatePatterns.d);
		assertTrue(ptPage.isCurrentDayHighlighted(currentDayOfMonth), "Current day should be highlighted in Calendar");
		assertFalse(ptPage.isCalendarRightNavigationArrowEnabled(), "Calendar right navigation arrow should be disabled for current month");
		ptPage.clickEditMyDayLink().clickDateButton();
		assertTrue(ptPage.isSaveChangesPopUpVisible(), "'Save changes pop up should appear'");
		ptPage.clickDontSaveButton();
		assertTrue(ptPage.isDatePickerVisible(), "Calendar should be visible");
		int numberOfDisabledDates = ptPage.getNumberOfDisabledDates();
		assertTrue(ptPage.isFutureDateDisabledInCalendar(DateUtils.getDateInFuture(1, DatePatterns.d)), "Days in future should be disabled");
		if (numberOfDisabledDates >= 2) {
			assertTrue(ptPage.isFutureDateDisabledInCalendar(DateUtils.getDateInFuture(2, DatePatterns.d)), "Days in future should be disabled");
		}
		if (numberOfDisabledDates >= 3) {
			assertTrue(ptPage.isFutureDateDisabledInCalendar(DateUtils.getDateInFuture(3, DatePatterns.d)), "Days in future should be disabled");
		}
	}

	private void verifyDailyViewNavigation(TemplatesEH url) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertEquals(ptPage.getNumberOfDaysDisplayed(), 1, "Only one day information should be displayed on page");
		String currentDate = DateUtils.getCurrentDate(DatePatterns.EEE_MMMM_d);
		assertEquals(ptPage.getCurrentDayDate(), currentDate, "Current day date should be displayed");
		ptPage.clickPreviousDayButton();
		assertEquals(ptPage.getCurrentDayDate(), DateUtils.getDateInPast(1, DatePatterns.EEE_MMMM_d), "Previous day should be displayed on page");
		ptPage.clickNextDayButton();
		assertEquals(ptPage.getCurrentDayDate(), currentDate, "Current day date should be displayed");
		assertFalse(ptPage.isNextDayNavigationArrowVisible(), "Next day navigation arrow should not be visible");
		ptPage.clickEditMyDayLink().clickPreviousDayButton();
		assertTrue(ptPage.isSaveChangesPopUpVisible(), "Pop up for saving changes should appear");
		ptPage.clickDontSaveButton().clickWeeklyTab();
		ptPage.clickPreviousWeekNavigationArrow();
		String weekStartDate = ptPage.getWeekStartDate();
		ptPage.clickDailyTab();
		assertTrue(ptPage.isMondayDisplayedInDailyViewForGivenDate(weekStartDate), "After switching to 'Daily' tab Monday should be displayed");
	}

	private void verifyWeeklyView(TemplatesEH url) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		ptPage.clickWeeklyTab();
		assertTrue(ptPage.isCorrectWeekVisibleForDate(LocalDate.now()), "Current week should be displayed in 'Weekly' tab");
		assertTrue(ptPage.isPreviousWeekNavigationArrowVisible(), "Previous week navigation arrow should be visible");
		assertTrue(ptPage.isDateButtonVisible(), "'Date' button should be visible");
		assertTrue(ptPage.isWeeklyMySymptomsSectionVisible(), "'My symptoms' section should be visible");
		assertTrue(ptPage.isWeeklyMyTriggersSectionVisible(), "'My triggers' section should be visible");
		assertTrue(ptPage.isWeeklyMyWinsSectionVisible(), "'My wins' section should be visible");
		assertTrue(ptPage.isWeeklyMyNotesSectionVisible(), "'My notes' section should be visible");
		assertTrue(ptPage.isNewsletterWidgetVisible(), "Newsletter widget should be visible");
		assertTrue(ptPage.isShareResultsWithDoctorSectionVisible(), "'Share these Results with Your Doctor' section should be visible");
		assertTrue(ptPage.isShareResultsWithDoctorEmailButtonVisible(), "'Email' button should be visible in 'Share these Results with Your Doctor' section");
		if (Settings.isDesktop()) {
			assertTrue(ptPage.isShareResultsWithDoctorPrintButtonVisible(), "'Print' button should be visible in 'Share these Results with Your Doctor' section");
		}
		if (!url.equals(TemplatesEH.CROHNS_PERSONALIZED_TRACKER)) {
			assertTrue(ptPage.isRecommendedReadingsModuleVisibleInWeeklyView(), "Recommended readings module should be visible in weekly view");
			if (ptPage.isRecommendedReadingsHeadingVisibleInWeeklyView()) {
				assertTrue(ptPage.isRecommendedReadingsHeadingImageVisibleInWeeklyView(), "Heading of Recommended readings module should be visible in weekly view");
				assertTrue(ptPage.isRecommendedReadingsHeadingTextVisibleInWeeklyView(), "Icon should be visible for Recommended readings module headline in weekly view");
			}
			int numberOfArticles = ptPage.getNumberOfItemsInRecommendedReadingsModuleDailyView();
			for (int articleNumber = 1; articleNumber <= numberOfArticles; articleNumber++) {
				assertEquals(ptPage.getNumberOfImagesInRecommendedReadingsModuleWeeklyView(), numberOfArticles, "Every article should have clickable image");
				assertEquals(ptPage.getNumberOfHeadlinesInRecommendedReadingsModuleWeeklyView(), numberOfArticles, "Every article should have clickable title");
			}
		}
		String weekDates = ptPage.getWeekDates();
		ptPage.clickPreviousWeekNavigationArrow();
		assertNotEquals(ptPage.getWeekDates(), weekDates, "Another week should be displayed");
		String monday = ptPage.getWeekStartDate();
		ptPage.clickDailyTab();
		assertTrue(ptPage.isMondayDisplayedInDailyViewForGivenDate(monday), "Monday should be displayed when switch from weekly view to daily view");
		ptPage.clickWeeklyTab();
		ptPage.clickNextWeekNavigationArrow();
		assertTrue(ptPage.isCorrectWeekVisibleForDate(LocalDate.now()), "Current week should be displayed in 'Weekly' tab");
		assertFalse(ptPage.isNextWeekNavigationArrowVisible(), "Next week navigation arrow should not be visible for current week");
	}

	private void verifyEditMyDayButton(TemplatesEH url) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		ptPage.clickEditMyDayLink();
		verifyEditMode(ptPage);
		ptPage.clickPreviousDayButton().clickDontSaveButton().clickNextDayButton();
		ptPage.clickEditMyDayButton();
		verifyEditMode(ptPage);
	}

	private void verifyAddingContent(TemplatesEH url) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		ptPage.clickEditMyDayLink();
		verifyEditMode(ptPage);
		chooseValuesAndVerifyChangesSaved(ptPage);
		ptPage.clickEditMyDayButton();
		Logger.info("Verify user can choose more variants and these values also will be saved");
		chooseValuesAndVerifyChangesSaved(ptPage);
		ptPage.clickEditMyDayButton();
		assertTrue(ptPage.isMyNotesTextAreaVisible(), "Text areas should appear in 'My notes' section");
		assertTrue(ptPage.isCharCounterVisible(), "Char counter should be visible in 'My notes' section");
		int startingValue = ptPage.getCurrentCharCounterValue();
		String note = StringUtils.generateRandomStrAlphaNumeric(10);
		ptPage.typeNote(note);
		assertTrue(startingValue < ptPage.getCurrentCharCounterValue(), "After typing note char counter value should increase");
		assertEquals(ptPage.getCharCounterLimitValue(), "200", "Char counter limit should be '200'");
		ptPage.clickSaveChangesButton();
		assertTrue(ptPage.isSaveNoteVisible(note), "Note should be saved");
		ptPage.clickEditMyDayButton();
		ptPage.typeNote("edited");
		ptPage.clickSaveChangesButton();
		assertTrue(ptPage.isSaveNoteVisible("edited"), "Edited note should be saved");
	}

	private void verifySaveChangesPopUp(TemplatesEH url) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		ptPage.clickEditMyDayLink();
		verifyEditMode(ptPage);
		int emojiNumber = StringUtils.generateRandomIntInRange(1, 6);
		ptPage.clickEmojiIconNumber(emojiNumber).clickPreviousDayButton();
		assertTrue(ptPage.isSaveChangesPopUpVisible(), "Pop up window should appear");
		assertEquals(ptPage.getPopUpMessage(), "Don’t forget to save your changes!", "Pop up window message should be 'Don’t forget to save your changes!'");
		assertTrue(ptPage.isSaveButtonVisibleOnPopUp(), "'Save' button should be present");
		assertTrue(ptPage.isDontSaveButtonVisibleOnPopUp(), "'Don't save' button should be present");
		ptPage.clickSaveButtonOnPopUp().clickNextDayButton();
		assertTrue(ptPage.isEmojiChosen(emojiNumber), "Chosen emoji number should be active");
		ptPage.clickEditMyDayButton().clickEmojiIconNumber(StringUtils.generateRandomIntInRange(1, 6)).clickPreviousDayButton().clickDontSaveButton().clickNextDayButton();
		assertTrue(ptPage.isEmojiChosen(emojiNumber), "Chosen emoji number should be active");
		ptPage.clickEditMyDayButton().typeNote(StringUtils.generateRandomStrAlphabetic(11)).clickPreviousDayButton().clickCloseButtonOnPopUp();
		assertFalse(ptPage.isSaveChangesPopUpVisible(), "Pop up window should disappear");
		assertFalse(ptPage.isEditMyDayButtonVisible(), "User should stay in edit mode. 'Edit my day' button should not be visible.");
	}

	private void verifyEditMode(PersonalizedTrackerPage personalizedTrackerPage) {
		assertTrue(personalizedTrackerPage.isDailyMySymptomsSectionVisible(), "'My symptoms' section should be visible");
		assertTrue(personalizedTrackerPage.getNumberOfMySymptomsVariantButtons() > 0, "Variant buttons should be visible in 'My symptoms' section");
		assertTrue(personalizedTrackerPage.isDailyMyTriggersSectionVisible(), "'My triggers' section should be visible");
		assertTrue(personalizedTrackerPage.getNumberOfMyTriggersVariantButtons() > 0, "Variant buttons should be visible in 'My triggers' section");
		assertTrue(personalizedTrackerPage.isDailyMyWinsSectionVisible(), "'My wins' section should be visible");
		assertTrue(personalizedTrackerPage.getNumberOfMyWinsVariantButtons() > 0, "Variant buttons should be visible in 'My wins' section");
		assertTrue(personalizedTrackerPage.isMyNotesTextAreaVisible(), "Input text area should be visible in 'My notes' section");
	}

	private void chooseValuesAndVerifyChangesSaved(PersonalizedTrackerPage ptPage) {
		int randomSymptom = StringUtils.generateRandomInt(ptPage.getNumberOfMySymptomsVariantButtons());
		String symptom = ptPage.getMySymptomsVariantButtonText(randomSymptom);
		if (Settings.isMobile() && symptom.contains("\n")) {
			symptom = symptom.split("\n")[0];
		}
		int randomTrigger = StringUtils.generateRandomInt(ptPage.getNumberOfMyTriggersVariantButtons());
		String trigger = ptPage.getMyTriggersVariantButtonText(randomTrigger);
		if (Settings.isMobile() && trigger.contains("\n")) {
			trigger = trigger.split("\n")[0];
		}
		int randomWin = StringUtils.generateRandomInt(ptPage.getNumberOfMyWinsVariantButtons());
		String win = ptPage.getMyWinsVariantButtonText(randomWin);
		if (Settings.isMobile() && win.contains("\n")) {
			win = win.split("\n")[0];
		}
		int randomEmoji = StringUtils.generateRandomIntInRange(1, 5);
		ptPage.clickMySymptomsVariantButton(randomSymptom)
				.clickMyTriggersVariantButton(randomTrigger)
				.clickMyWinsVariantButton(randomWin)
				.clickEmojiIconNumber(randomEmoji);
		assertTrue(ptPage.isMySymptomsVariantButtonChosen(symptom), "Symptom '" + symptom + "' button should be chosen");
		assertTrue(ptPage.isMyTriggersVariantButtonChosen(trigger), "Trigger '" + trigger + "' button should be chosen");
		assertTrue(ptPage.isMyWinsVariantButtonChosen(win), "Win '" + win + "' button should be chosen");
		ptPage.clickSaveChangesLink();
		verifyDataIsSaved(ptPage, symptom, trigger, win, randomEmoji);
	}

	private void verifyDataIsSaved(PersonalizedTrackerPage ptPage, String symptom, String trigger, String win, int emoji) {
		assertTrue(ptPage.isActiveSymptomButtonWithTextVisible(symptom),
				"Symptom '" + symptom + "' button should be visible after saving changes");
		assertTrue(ptPage.isActiveTriggerButtonWithTextVisible(trigger),
				"Trigger '" + trigger + "' button should be visible after saving changes");
		assertTrue(ptPage.isActiveWinButtonWithTextVisible(win), "Win '" + win + "' button should be visible after saving changes");
		assertTrue(ptPage.isEmojiChosen(emoji), "Emoji #" + emoji + " should be chosen");
	}

	private void verifyOmnitureValuesOnDashboard(TemplatesEH url) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		Logger.info("Verify navigation arrow click event and evars on Daily view tab");
		ptPage.clickPreviousDayButton();
		verifyEventsAndEvars(url, "event115");
		Logger.info("Verify 'Date' button click event and evars");
		ptPage.clickDateButton();
		verifyEventsAndEvars(url, "event112");
		Logger.info("Verify choosing date from Calendar event and evars");
		ptPage.clickActiveDayInCalendar();
		verifyEventsAndEvars(url, "event111");
		Logger.info("Verify 'Edit my day' button click event and evars");
		ptPage.clickEditMyDayButton();
		verifyEventsAndEvars(url, "event113");
		Logger.info("Verify saving emoji event and evars");
		int emojiNumber = StringUtils.generateRandomIntInRange(1, 6);
		ptPage.clickEmojiIconNumber(emojiNumber).clickSaveChangesLink();
		verifyEventsAndEvars(url, "event114");
		assertTrue(MarketingPixels.getConsoleValue("products").contains("emojis;"), "Products value should contain 'emoji;' string");
		Logger.info("Verify saving triggers/symptoms/wins event and evars");
		ptPage.clickEditMyDayLink();
		int randomSymptom = StringUtils.generateRandomInt(ptPage.getNumberOfMySymptomsVariantButtons());
		String symptom = ptPage.getMySymptomsVariantButtonText(randomSymptom);
		int randomTrigger = StringUtils.generateRandomInt(ptPage.getNumberOfMyTriggersVariantButtons());
		String trigger = ptPage.getMyTriggersVariantButtonText(randomTrigger);
		int randomWin = StringUtils.generateRandomInt(ptPage.getNumberOfMyWinsVariantButtons());
		String win = ptPage.getMyWinsVariantButtonText(randomWin);
		ptPage.clickMySymptomsVariantButton(randomSymptom)
				.clickMyTriggersVariantButton(randomTrigger)
				.clickMyWinsVariantButton(randomWin)
				.clickSaveChangesLink();
		verifyEventsAndEvars(url, "event114");
		assertTrue(MarketingPixels.getConsoleValue("products").contains("symptoms;" + symptom),
				"Products value should contain 'symptoms;'" + symptom);
		assertTrue(MarketingPixels.getConsoleValue("products").contains("triggers;" + trigger),
				"Products value should contain 'triggers;'" + trigger);
		assertTrue(MarketingPixels.getConsoleValue("products").contains("wins;" + win),
				"Products value should contain 'wins;'" + win);
		ptPage.clickWeeklyTab();
		if (Settings.isDesktop()) {
			Logger.info("Verify 'Print' button click event and evars");
			ptPage.clickPrintButton();
			verifyEventsAndEvars(url, "event98");
		}
		Logger.info("Verify 'Share this results with your doctor' section 'Email' button click event and evars");
		ptPage.clickDashboardEmailButton();
		verifyEventsAndEvars(url, "event92");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar29", "dashboard"), "eVar29 is incorrect");
		ptPage.clickShareWithDoctorPopUpCloseButton();
		Logger.info("Verify footer 'Share' button click event and evars");
		ptPage.clickFooterShareButton();
		verifyEventsAndEvars(url, "event92");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar29", "sticky social share bar"), "eVar29 is incorrect");
		ptPage.clickShareWithDoctorPopUpCloseButton();
		if (!Settings.isEnvironment(Environment.PROD)) {
			Logger.info("Verify newsletter subscription event and evars on Weekly view tab");
			ptPage.enterEmailAndSubmit(StringUtils.generateRandomEmail());
			verifyEventsAndEvars(url, "event4");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar42", "center"), "eVar42 is incorrect");
		}
		Logger.info("Verify navigation arrow click event and evars on Weekly view tab");
		ptPage.clickPreviousWeekNavigationArrow();
		verifyEventsAndEvars(url, "event116");
	}

	private void verifyEventsAndEvars(TemplatesEH url, String event) {
		assertTrue(MarketingPixels.getConsoleValue("linkTrackEvents").equals(event), event + " should fire");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "trk"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureNumberIsNumericId("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "personalized tracker"), "eVar30 is incorrect");
		if (url.equals(TemplatesEH.CROHNS_PERSONALIZED_TRACKER)) {
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cs/humiracrohns/ad3"), "eVar1 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cs/humiracrohns"), "eVar5 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8",
					"trk|/cs/humiracrohns|-1|My Daily Crohn's Dashboard | Everyday Health"), "eVar8 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/dashboard/my-daily-crohns/"), "eVar9 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "digestive health"), "eVar67 is incorrect");
			String eVar68Value = MarketingPixels.getValue("eVar68").replace("&#39;", "'");
			assertEquals(eVar68Value, "crohn's disease", "eVar68 is incorrect");
		} else {
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cs/cchumirara"), "eVar1 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cs/cchumirara"), "eVar5 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8",
					"trk|/cs/cchumirara|-1|My Daily RA Dashboard | Everyday Health"), "eVar8 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/dashboard/my-daily-ra/"), "eVar9 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "arthritis"), "eVar67 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "rheumatoid arthritis"), "eVar68 is incorrect");
		}
	}

	private void verifyMoodLevelKeywords(TemplatesEH url) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		String shortcode = url.equals(TemplatesEH.CROHNS_PERSONALIZED_TRACKER) ? "25171" : "73160"; //shortcode is equivalent of phone number for each program
		for (int emojiN = 1; emojiN <= 5; emojiN++) {
			Utils.sendPostRequestWithParameters(String.valueOf(emojiN), shortcode);
			ptPage.refresh();
			Utils.waitFor(1500);
			assertTrue(ptPage.isEmojiChosen(emojiN), "Emoji icon #" + emojiN + " should be active");
			assertTrue(ptPage.isEmojiSentenceVisible(emojiN), "Emoji sentence #" + emojiN + " should be visible");
		}
	}

	private void verifyUnsubscribeKeywords(TemplatesEH url) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		String shortcode = url.equals(TemplatesEH.CROHNS_PERSONALIZED_TRACKER) ? "25171" : "73160"; //shortcode is equivalent of phone number for each program
		ptPage.clickSettingsButton();
		assertEquals(ptPage.getDropdownChosenElementText(), "Enabled", "Text messaging should be enabled");
		Utils.sendPostRequestWithParameters("STOP", shortcode);
		SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertEquals(ptPage.getDropdownChosenElementText(), "Disabled", "Text messaging should be disabled");
		enableTextMessaging(ptPage);
		SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertEquals(ptPage.getDropdownChosenElementText(), "Enabled", "Text messaging should be enabled");
		Utils.sendPostRequestWithParameters("QUIT", shortcode);
		SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertEquals(ptPage.getDropdownChosenElementText(), "Disabled", "Text messaging should be disabled");
		enableTextMessaging(ptPage);
		SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertEquals(ptPage.getDropdownChosenElementText(), "Enabled", "Text messaging should be enabled");
		Utils.sendPostRequestWithParameters("END", shortcode);
		SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertEquals(ptPage.getDropdownChosenElementText(), "Disabled", "Text messaging should be disabled");
		enableTextMessaging(ptPage);
		SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertEquals(ptPage.getDropdownChosenElementText(), "Enabled", "Text messaging should be enabled");
		Utils.sendPostRequestWithParameters("CANCEL", shortcode);
		SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertEquals(ptPage.getDropdownChosenElementText(), "Disabled", "Text messaging should be disabled");
		enableTextMessaging(ptPage);
		SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertEquals(ptPage.getDropdownChosenElementText(), "Enabled", "Text messaging should be enabled");
		Utils.sendPostRequestWithParameters("UNSUBSCRIBE", shortcode);
		SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertEquals(ptPage.getDropdownChosenElementText(), "Disabled", "Text messaging should be disabled");
		enableTextMessaging(ptPage);
		SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		assertEquals(ptPage.getDropdownChosenElementText(), "Enabled", "Text messaging should be enabled");
	}

	private void enableTextMessaging(PersonalizedTrackerPage ptPage) {
		if (!ptPage.isSettingsWindowVisible()) {
			ptPage.clickSettingsButton();
		}
		ptPage.enableTextMessaging().clickConsentCheckbox().clickSaveChangesButtonSettingsWindow();
	}

	private void verifyNewsletterWidgetFunctionalityPTPage(TemplatesEH url) {
		if (!Settings.isEnvironment(Environment.PROD)) {
			UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
			PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
			verifyNewsletterWidgetFunctionality(ptPage);
		}
	}

	private MonthDay getWeekMonday(DiabetesPersonalizedTrackerPage ptPage) {
		String weekDates = ptPage.getWeekDates();
		MonthDay day;
		if (DateUtils.isWeekEndsInTheSameMonth(weekDates)) {
			day = MonthDay.parse(weekDates.split("-")[0].trim(), DateTimeFormatter.ofPattern("MMMM d", Locale.US));
		} else {
			day = MonthDay.parse(weekDates.split("-")[0].trim(), DateTimeFormatter.ofPattern("MMM d", Locale.US));
		}
		Logger.info("Monday in weekly tab is - " + day);
		return day;
	}

	private void uncheckSymptomsTriggersWins(PersonalizedTrackerPage page) {
		page.clickEditMyDayLink();
		while (page.getNumberOfActiveButtons() > 0) {
			page.clickActiveButton();
		}
		page.clickSaveChangesLink();
	}

	private void verifyATC(TemplatesEH url, boolean isWeekly) {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(url, PersonalizedTrackerPage.class);
		if (isWeekly) {
			ptPage.clickWeeklyTab();
		}
		Logger.info("Verify ATC widget functionality");
		verifyATCWidgetFunctionality(ptPage, true, false);
	}

	private void verifyMedTrackerModuleElements(PersonalizedTrackerPage ptPage, boolean isCrohnsPT) {
		assertTrue(ptPage.isDailyTabActive(), "User should be on daily tab");
		assertFalse(ptPage.isMedTrackerModuleVisible(), "Med Tracker module should not be visible");
		ptPage.clickWeeklyTab();
		assertTrue(ptPage.isWeeklyTabActive(), "User should switch to weekly tab");
		assertTrue(ptPage.isMedTrackerModuleVisible(), "Med Tracker module should be visible");

		assertTrue(ptPage.isMedTrackerModuleTitleVisible(), "Med Tracker module title should be visible");
		assertTrue(ptPage.isMedTrackerModuleDeckVisible(), "Med Tracker deck should be visible");
		assertTrue(ptPage.isMedTrackerModuleSearchInputVisible(), "Search input should be visible on med tracker module");
		assertTrue(ptPage.isAddButtonVisibleOnMedTrackerModule(), "'Add' button should be visible on med tracker module");
		assertTrue(ptPage.isMedTrackerModulePillIconVisible(), "'Pill' icon should be visible on med tracker module");

		if (isCrohnsPT) {
			assertEquals(ptPage.getMedTrackerModuleTitleText(), "My Crohn's Medications", "Incorrect title text");
			assertEquals(ptPage.getMedTrackerModuleDeckText(),
					"Track your Crohn's medications to stay organized, share with your healthcare team, and research and review drugs.",
					"Incorrect deck text");
		} else {
			assertEquals(ptPage.getMedTrackerModuleTitleText(), "My RA Medications", "Incorrect title text");
			assertEquals(ptPage.getMedTrackerModuleDeckText(),
					"Track your RA medications to stay organized, share with your healthcare team, and research and review drugs.",
					"Incorrect deck text");
		}

		assertEquals(ptPage.getNumberOfMedicationItems(), 1, "1 medication should be present in the list");
		assertEquals(ptPage.getNumberOfCloseIcons(), 1, "1 close icon should be visible");
	}

	private void verifyMedTrackerModalWindowElements(PersonalizedTrackerPage ptPage, boolean isCrohnsPT) {
		assertTrue(ptPage.isMedTrackerkModalWindowVisible(), "Med Tracker modal window should appear");
		assertTrue(ptPage.isMedTrackerModalWindowCloseIconVisible(), "[x] icon should be visible");
		assertTrue(ptPage.isMedTrackerModalNewLabelVisible(), "'NEW' label should be visible on modal window");
		assertTrue(ptPage.isTitleVisibleOnMedTrackerModalWindow(), "Title should be visible");
		assertTrue(ptPage.isDeckVisibleOnMedTrackerModalWindow(), "Deck should be visible");
		assertEquals(ptPage.getNumberOfDotsInList(), 3, "3 dots should be present in the list");
		assertEquals(ptPage.getNumberOfItemsInList(), 3, "3 items should be present in the list");
		assertTrue(ptPage.isMedTrackerModalWindowSearchInputVisible(), "Search input should be visible");
		assertTrue(ptPage.isMedTrackerModalWindowPillIconVisible(), "'Pill' icon should be visible");
		assertTrue(ptPage.isAddButtonVisibleOnModalWindow(), "'Add' button should be visible");

		assertEquals(Utils.getHexColor(ptPage.getMedTrackerModalLabelColor()), "#56710e", "'NEW!' label should be green");
		assertEquals(ptPage.getMedTrackerModalLabelText(), "NEW!", "Label text should be 'NEW!'");
		if (isCrohnsPT) {
			assertEquals(ptPage.getMedTrackerModalWindowTitleText(),
					"My Crohn's Medications",
					"Title text should be 'My Crohn's Medications'");
			assertEquals(ptPage.getMedTrackerModalWindowDeckText(),
					"Now you can keep a record of your current Crohn's medications. Here’s how it can help:",
					"Incorrect deck text");
		} else {
			assertEquals(ptPage.getMedTrackerModalWindowTitleText(),
					"My RA Medications",
					"Title text should be 'My RA Medications'");
			assertEquals(ptPage.getMedTrackerModalWindowDeckText(),
					"Now you can keep a record of your current RA medications. Here’s how it can help:",
					"Incorrect deck text");
		}
		assertEquals(ptPage.getListItemText(1),
				"Stay organized with everything in one place",
				"First item in the list contains incorrect text");
		assertEquals(ptPage.getListItemText(2),
				"Share with your healthcare team",
				"Second item in the list contains incorrect text");
		assertEquals(ptPage.getListItemText(3),
				"Research and review your medications",
				"Third item in the list contains incorrect text");
	}

	private void verifySearchFunctionality(PersonalizedTrackerPage ptPage, String searchQuery, boolean isPopUp) {
		if (isPopUp) {
			Logger.info("Verify pop up window search functionality");
			ptPage.typeSearchQueryOnModalWindow(searchQuery.substring(0, 1));
			assertFalse(ptPage.isModalWindowAutosuggestionListVisible(),
					"Autosuggestion list should not appear for 1-symbol query");
			ptPage.typeSearchQueryOnModalWindow(searchQuery.substring(0, 2));
			assertFalse(ptPage.isModalWindowAutosuggestionListVisible(),
					"Autosuggestion list should not appear for 2-symbol query");
			String threeSymbolQuery = searchQuery.substring(0, 3);
			ptPage.typeSearchQueryOnModalWindow(threeSymbolQuery);
			assertTrue(ptPage.isModalWindowAutosuggestionListVisible(),
					"Autosuggestion list should appear when search query is 3 or more symbols long");
			int numberOfSuggestions = ptPage.getNumberOfSuggestions();
			assertTrue(numberOfSuggestions > 0 && numberOfSuggestions <= 5,
					"At least one suggested item should appear but not more than 5");
			for (int suggestedItem = 1; suggestedItem <= numberOfSuggestions; suggestedItem++) {
				assertTrue(ptPage.getSuggestionText(suggestedItem).toLowerCase().startsWith(threeSymbolQuery),
						"Each suggested item should start from query text");
			}

			ptPage.typeSearchQueryOnModalWindow(searchQuery);
			int numberOfItems = ptPage.getNumberOfSuggestions();
			assertTrue(numberOfItems > 0 && numberOfItems <= 5, "At least one suggested item should appear but not more than 5");
			for (int suggestedItem = 1; suggestedItem <= numberOfItems; suggestedItem++) {
				assertTrue(ptPage.getSuggestionText(suggestedItem).toLowerCase().startsWith(searchQuery),
						"Each suggested item should start from query text");
			}
		} else {
			Logger.info("Verify med tracker module search functionality");
			ptPage.typeSearchQueryOnMedTrackerModule(searchQuery.substring(0, 1));
			assertFalse(ptPage.isMedTrackerModuleAutosuggestionListVisible(),
					"Autosuggestion list should not appear for 1-symbol query");
			ptPage.typeSearchQueryOnMedTrackerModule(searchQuery.substring(0, 2));
			assertFalse(ptPage.isMedTrackerModuleAutosuggestionListVisible(),
					"Autosuggestion list should not appear for 2-symbol query");
			String threeSymbolQuery = searchQuery.substring(0, 3);
			ptPage.typeSearchQueryOnMedTrackerModule(threeSymbolQuery);
			assertTrue(ptPage.isMedTrackerModuleAutosuggestionListVisible(),
					"Autosuggestion list should appear when search query is 3 or more symbols long");
			int numberOfSuggestions = ptPage.getNumberOfSuggestions();
			assertTrue(numberOfSuggestions > 0 && numberOfSuggestions <= 5,
					"At least one suggested item should appear but not more than 5");
			for (int suggestedItem = 1; suggestedItem <= numberOfSuggestions; suggestedItem++) {
				assertTrue(ptPage.getSuggestionText(suggestedItem).toLowerCase().startsWith(threeSymbolQuery),
						"Each suggested item should start from query text");
			}

			ptPage.typeSearchQueryOnMedTrackerModule(searchQuery);
			int numberOfItems = ptPage.getNumberOfSuggestions();
			assertTrue(numberOfItems > 0 && numberOfItems <= 5, "At least one suggested item should appear but not more than 5");
			for (int suggestedItem = 1; suggestedItem <= numberOfItems; suggestedItem++) {
				assertTrue(ptPage.getSuggestionText(suggestedItem).toLowerCase().startsWith(searchQuery),
						"Each suggested item should start from query text");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C505325"})
	@TestRail(id = "C505325")
	public void verifyPainTrackerModuleElementsOnCrohns() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);
		verifyPainTrackerModuleElements(ptPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C505314"})
	@TestRail(id = "C505314")
	public void verifyPainTrackerModuleElementsOnRA() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

		verifyPainTrackerModuleElements(ptPage);

		Logger.info("Verify pain location section");
		String painDescriptionOnLoad = ptPage.getPainDescriptionText();
		if (painDesc.get(0).equals(painDescriptionOnLoad) ||
				"Tap or drag to select".equals(painDescriptionOnLoad)) {
			assertFalse(ptPage.isDialyPainTrackerPainLocationButtonsModuleVisible(), "Pain location module should not be visible");
		} else {
			assertTrue(ptPage.isDialyPainTrackerPainLocationButtonsModuleVisible(), "Pain location module should be visible");
			assertEquals(ptPage.getNumberOfPainLocationButtons(), 10, "10 pain locations should be available");
			assertEquals(ptPage.getTextFromPainLocationButton(1), "Hands/Fingers", "Incorrect text for button #1");
			assertEquals(ptPage.getTextFromPainLocationButton(2), "Elbows", "Incorrect text for button #2");
			assertEquals(ptPage.getTextFromPainLocationButton(3), "Wrists", "Incorrect text for button #3");
			assertEquals(ptPage.getTextFromPainLocationButton(4), "Neck", "Incorrect text for button #4");
			assertEquals(ptPage.getTextFromPainLocationButton(5), "Feet/Toes", "Incorrect text for button #5");
			assertEquals(ptPage.getTextFromPainLocationButton(6), "Shoulders", "Incorrect text for button #6");
			assertEquals(ptPage.getTextFromPainLocationButton(7), "Ankles", "Incorrect text for button #7");
			assertEquals(ptPage.getTextFromPainLocationButton(8), "Hips", "Incorrect text for button #8");
			assertEquals(ptPage.getTextFromPainLocationButton(9), "Knees", "Incorrect text for button #9");
			assertEquals(ptPage.getTextFromPainLocationButton(10), "Other", "Incorrect text for button #10");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C505321"})
	@TestRail(id = "C505321")
	public void verifyPainTrackerPainLevelsOnRA() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

		verifyPainLevelDescriptions(ptPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C505326"})
	@TestRail(id = "C505326")
	public void verifyPainTrackerPainLevelsOnCrohns() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

		verifyPainLevelDescriptions(ptPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C505324"})
	@TestRail(id = "C505324")
	public void verifyPainTrackerPainLocations() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

		ptPage.clickEditMyDayLink();
		ptPage.clickDailyPainTrackerLevelPip(1);
		assertTrue(ptPage.isDialyPainTrackerPainLocationButtonsModuleVisible(), "Pain locations module should appear");
		assertEquals(ptPage.getNumberOfPainLocationButtons(), 10, "10 pain location buttons should be available");
		int locationButton = StringUtils.generateRandomIntInRange(1, 10);
		int location2Button = StringUtils.generateRandomIntInRange(1, 10);
		String locationText = ptPage.getTextFromPainLocationButton(locationButton);
		String location2Text = ptPage.getTextFromPainLocationButton(location2Button);
		assertFalse(ptPage.isActivePainLocationButtonVisible(locationText), "Button should not be active before it is clicked");
		assertFalse(ptPage.isActivePainLocationButtonVisible(location2Text), "Button should not be active before it is clicked");

		ptPage.clickDailyPainTrackerLevelPip(locationButton); //pain level > 0 should be chosen for pain locations module to appear
		ptPage.clickPainLocationButton(locationText);
		if (locationButton != location2Button) { //to avoid uncheck of the same button
			ptPage.clickPainLocationButton(location2Text);
		}
		ptPage.clickSaveChangesButton();

		assertTrue(ptPage.isActivePainLocationButtonVisible(locationText), "Button - " + locationText + " should be active");
		assertTrue(ptPage.isActivePainLocationButtonVisible(location2Text), "Button - " + location2Text + " should be active");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C505344"})
	@TestRail(id = "C505344")
	public void verifyPainTrackerRAWeeklyView() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

		verifyPainTrackerElementsInWeeklyView(ptPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C505356"})
	@TestRail(id = "C505356")
	public void verifyPainTrackerCrohnsWeeklyView() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

		verifyPainTrackerElementsInWeeklyView(ptPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C505345"})
	@TestRail(id = "C505345")
	public void verifyPainTrackerDayScoresRAWeeklyView() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

		verifyDayRecordsInWeeklyView(ptPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C505357"})
	@TestRail(id = "C505357")
	public void verifyPainTrackerDayScoresCrohnsWeeklyView() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

		verifyDayRecordsInWeeklyView(ptPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "PTTest", "C505346"})
	@TestRail(id = "C505346")
	public void verifyPainTrackerPainLocationsRAWeeklyView() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);

		ptPage.clickWeeklyTab();

		Logger.info("Get data for each day of current week");
		ptPage.clickDailyTab();
		int dayNumberToday = LocalDate.now().getDayOfWeek().getValue();
		int daysCounter = 1;
		Map<String, Integer> painLocations = new TreeMap<>();
		while (daysCounter <= dayNumberToday) {
			int numberOfPainLocations = ptPage.getNumberOfChosenButtons();
			for (int button = 1; button <= numberOfPainLocations; button++) {
				String painLocationText = ptPage.getChosenButtonText(button);
				if (painLocations.containsKey(painLocationText)) {
					painLocations.put(painLocationText, painLocations.get(painLocationText) + 1);
				} else {
					painLocations.put(painLocationText, 1);
				}
			}

			if (daysCounter != dayNumberToday) {
				ptPage.clickNextDayButton();
			}
			daysCounter++;
		}

		Logger.info("Verify graph contains correct data (per day)");
		ptPage.clickWeeklyTab();
		assertTrue(ptPage.isWeeklyTabActive(), "User should switch to weekly tab");
		assertTrue(ptPage.isWeeklyPainTrackerModuleVisible(), "Pain Tracker module should be visible in weekly view");
		if (!painLocations.isEmpty()) {
			assertTrue(ptPage.isWeeklyPainTrackerGraphVisible(), "Graph should be visible");
			assertTrue(ptPage.isWeeklyPainTrackerScoresModuleVisible(), "Scores module should be visible");
			assertTrue(ptPage.isWeeklyPainTrackerDaysModuleVisible(), "Days module should be visible");
			assertTrue(ptPage.isPainLocationsSummaryModuleVisible(), "Summary module should be visible");
			assertEquals(ptPage.getNumberOfPainLocationItems(),
					painLocations.size(),
					"Each chosen pain location should be present in weekly view");
			for (Map.Entry<String, Integer> entry : painLocations.entrySet()) {
				String locationName = entry.getKey();
				assertTrue(ptPage.isPainLocationItemVisible(locationName), "Pain location - " + locationName + " should be visible in weekly view");
				assertEquals(ptPage.getPainLocationItemDaysCountText(locationName),
						entry.getValue() + " out of 7 days",
						"Invalid counter value for pain location - " + locationName);
			}
		}
	}

	private void verifyPainTrackerModuleElements(PersonalizedTrackerPage ptPage) {
		Logger.info("Verify pain tracker module is visible in non-edit mode");
		assertTrue(ptPage.isDailyPainTrackerModuleVisible(), "Pain tracker module should be visible");
		assertTrue(ptPage.isDailyPainTrackerHeaderTextVisible(), "Pain Tracker header should be visible in Saved Mode");
		if (!ptPage.isDailyPainTrackerResultVisible()) {
			assertTrue(ptPage.isDailyPainTrackerQuestionTextVisible(), "Pain Tracker question should be visible in Saved Mode");
			String question = Utils.getCurrentURL().replace("?isautomation=true", "").endsWith("/my-daily-ra/") ?
					"How bad is your joint pain?" :
					"How bad is your abdominal pain?";
			assertEquals(ptPage.getDailyPainTrackerQuestionText(), question, "Incorrect question text");
		}
		assertFalse(ptPage.isDailyPainTrackerBarVisible(), "Pain level bar should not be visible in non-edit mode");

		Logger.info("Verify pain tracker module and elements in edit mode");
		ptPage.clickEditMyDayLink();
		assertTrue(ptPage.isDailyTabActive(), "User should be on daily tab");
		assertTrue(ptPage.isDailyPainTrackerHeaderTextVisible(), "Pain Tracker header should be visible");
		assertTrue(ptPage.isDailyPainTrackerQuestionTextVisible(), "Pain Tracker question should be visible");
		assertTrue(ptPage.isDailyPainTrackerBarVisible(), "Pain Tracker bar should be visible");
		assertTrue(ptPage.isDailyPainTrackerLegendVisible(), "Pain Tracker legend should be visible below bar");
	}

	private void verifyPainLevelDescriptions(PersonalizedTrackerPage ptPage) {
		assertFalse(ptPage.isDailyPainTrackerBarVisible(), "Pain level bar should not be visible in non-edit mode");
		for (int level = 0; level <= 10; level++) {
			ptPage.clickEditMyDayLink();
			assertTrue(ptPage.isDailyPainTrackerBarVisible(), "Pain level bar should be visible in edit mode");
			ptPage.clickDailyPainTrackerLevelPip(level);
			assertEquals(ptPage.getPainTrackerPainLevelValue(), String.valueOf(level), "Corresponding value should be displayed");
			assertTrue(ptPage.isDailyPainTrackerPainDescriptionVisible(), "Pain description text should be visible");
			String painDescription = ptPage.getPainDescriptionText();
			assertEquals(painDescription, painDesc.get(level), "Invalid pain level description text");
			ptPage.clickSaveChangesLink();
			assertTrue(ptPage.isDailyPainTrackerResultVisible(), "Result should be visible for Pain Tracker");
			String savedPainDescription = ptPage.getDailyPainResultDescription();
			String painText = Utils.getCurrentURL().replace("?isautomation=true", "").endsWith("/my-daily-ra/") ?
					"joint pain." :
					"abdominal pain.";
			assertTrue(savedPainDescription.endsWith(savedPainDesc.get(level) + " (" + level + ") " + painText), "Invalid pain description for saved result");
		}
	}

	private void verifyPainTrackerElementsInWeeklyView(PersonalizedTrackerPage ptPage) {
		ptPage.clickWeeklyTab();
		assertTrue(ptPage.isWeeklyTabActive(), "User should switch to weekly tab");
		assertTrue(ptPage.isWeeklyPainTrackerModuleVisible(), "Pain Tracker module should be visible in weekly view");
		assertTrue(ptPage.isWeeklyPainTrackerModuleTitleVisible(), "Pain Tracker title should be visible in weekly view");
		if (ptPage.isWeeklyPainTrackerGraphModuleVisible()) {
			assertTrue(ptPage.isWeeklyPainTrackerModuleDescriptionVisible(),
					"Pain Tracker description should be visible in weekly view");
			assertEquals(ptPage.getWeeklyPainTrackerModuleDescriptionText(),
					"Based on your daily logged inputs.",
					"Incorrect Pain Tracker description text");
			assertTrue(ptPage.isWeeklyPainTrackerGraphVisible(), "Graph should be visible");
			assertTrue(ptPage.isWeeklyPainTrackerScoresModuleVisible(), "Scores module should be visible");
			assertTrue(ptPage.isWeeklyPainTrackerDaysModuleVisible(), "Days module should be visible");
			int dayNumberToday = LocalDate.now().getDayOfWeek().getValue();
			if (dayNumberToday != 7) { //no need to check this on Sundays
				for (int dayInFuture = dayNumberToday + 1; dayInFuture <= 7; dayInFuture++) {
					assertEquals(Utils.getHexColor(ptPage.getWeeklyDayColorAttribute(dayInFuture)),
							"#b7b7b7",
							"Days in future should be greyed out");
				}
			}
		} else {
			assertTrue(ptPage.isWeeklyPainTrackerNoDataMessageVisible(), "No data message should be visible");
			assertEquals(ptPage.getWeeklyPainTrackerNoDataMessage(),
					"None recorded for this time period.",
					"Incorrect Pain Tracker description text");
		}
	}

	private void verifyDayRecordsInWeeklyView(PersonalizedTrackerPage ptPage) {
		ptPage.clickWeeklyTab();

		Logger.info("Get data for each day of current week");
		ptPage.clickDailyTab();
		int dayNumberToday = LocalDate.now().getDayOfWeek().getValue();
		int daysCounter = 1;
		List<String> scoresList = new ArrayList<>();
		while (daysCounter <= dayNumberToday) {
			if (ptPage.isDailyPainTrackerQuestionTextVisible()) {
				scoresList.add("—");
			} else {
				String dayPainDesc = ptPage.getDailyPainResultDescription();
				String dayPainLevel = dayPainDesc.substring(dayPainDesc.indexOf("(") + 1, dayPainDesc.indexOf(")")).trim();
				scoresList.add(dayPainLevel);
			}
			if (daysCounter != dayNumberToday) {
				ptPage.clickNextDayButton();
			}
			daysCounter++;
		}

		Logger.info("Verify graph contains correct data (per day)");
		ptPage.clickWeeklyTab();
		assertTrue(ptPage.isWeeklyTabActive(), "User should switch to weekly tab");
		assertTrue(ptPage.isWeeklyPainTrackerModuleVisible(), "Pain Tracker module should be visible in weekly view");
		if (!ptPage.isWeeklyPainTrackerNoDataMessageVisible()) {
			assertTrue(ptPage.isWeeklyPainTrackerGraphVisible(), "Graph should be visible");
			assertTrue(ptPage.isWeeklyPainTrackerScoresModuleVisible(), "Scores module should be visible");
			assertTrue(ptPage.isWeeklyPainTrackerDaysModuleVisible(), "Days module should be visible");
			for (int day = 1; day <= 7; day++) {
				if (day <= dayNumberToday) {
					assertEquals(ptPage.getWeeklyPainTrackerDayScore(day), scoresList.get(day - 1), "Weekly graph contains invalid data");
				} else {
					assertEquals(ptPage.getWeeklyPainTrackerDayScore(day), "—", "Day in future contains data");
					assertEquals(Utils.getHexColor(ptPage.getWeeklyDayColorAttribute(day)), "#b7b7b7", "All days should be greyed out");
				}
			}
		} else {
			for (int day = 1; day <= 7; day++) {
				assertEquals(ptPage.getWeeklyPainTrackerDayScore(day), "—", "Day in future contains data");
				assertEquals(Utils.getHexColor(ptPage.getWeeklyDayColorAttribute(day)), "#b7b7b7", "All days should be greyed out");
			}
		}
	}
}