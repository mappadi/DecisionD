package everydayhealth.pages.personalizedTracker;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.platform.DatePatterns;
import framework.platform.html.WebObject;
import framework.platform.utilities.DateUtils;
import framework.platform.utilities.Utils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * PersonalizedTrackerPage
 */
public class PersonalizedTrackerPage extends BasicPageEH {

	public PersonalizedTrackerPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "personalizedTracker";
		String CLASS_NAME = "PersonalizedTrackerPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject dailyView;
	protected WebObject activeDaySection;
	protected WebObject previousDay;
	protected WebObject date;
	protected WebObject nextDay;
	protected WebObject tab;
	protected WebObject dailyTab;
	protected WebObject weeklyTab;
	protected WebObject dateButton;
	protected WebObject calendar;
	protected WebObject calendarHeader;
	protected WebObject calendarPrevMonthArrow;
	protected WebObject calendarNextMonthArrow;
	protected WebObject calendarDayOfMonth;
	protected WebObject calendarDayCurrentMonth;
	protected WebObject calendarDayNextMonth;
	protected WebObject calendarDisabledDate;
	protected WebObject calendarActiveDay;
	protected WebObject howWasYourDaySection;
	protected WebObject editMyDayLink;
	protected WebObject saveChangesLink;
	protected WebObject emoji;
	protected WebObject emojiBlock;
	protected WebObject emojiAssociatedNumber;
	protected WebObject emojiSentence;
	protected WebObject activeEmoji;
	protected WebObject dailyMySymptomsModule;
	protected WebObject dailyMySymptomsButtons;
	protected WebObject dailyMySymptomsButtonsWithText;
	protected WebObject dailyMySymptomsButtonsChosen;
	protected WebObject dailyMyTriggersModule;
	protected WebObject dailyMyTriggersButtons;
	protected WebObject dailyMyTriggersButtonsWithText;
	protected WebObject dailyMyTriggersButtonsChosen;
	protected WebObject dailyMyWinsModule;
	protected WebObject dailyMyWinsButtons;
	protected WebObject dailyMyWinsButtonsWithText;
	protected WebObject dailyMyWinsButtonsChosen;
	protected WebObject dailyActiveButtonWithText;
	protected WebObject dailyActiveButton;
	protected WebObject dailyMyNotes;
	protected WebObject dailyRecommendedReadingsModule;
	protected WebObject dailyRecommendedReadingsModuleItem;
	protected WebObject dailyRecommendedReadingsModuleItemImage;
	protected WebObject dailyRecommendedReadingsModuleItemText;
	protected WebObject dailyRecommendedReadingsModuleHeading;
	protected WebObject dailyRecommendedReadingsModuleHeadingIcon;
	protected WebObject dailyRecommendedReadingsModuleHeadingHeadline;
	protected WebObject weeklyMySymptomsModule;
	protected WebObject weeklyMyWinsModule;
	protected WebObject weeklyMyTriggersModule;
	protected WebObject weeklyMyNotes;
	protected WebObject weeklyRecommendedReadingsModule;
	protected WebObject weeklyRecommendedReadingsModuleItemImage;
	protected WebObject weeklyRecommendedReadingsModuleItemText;
	protected WebObject weeklyRecommendedReadingsModuleHeading;
	protected WebObject weeklyRecommendedReadingsModuleHeadingIcon;
	protected WebObject weeklyRecommendedReadingsModuleHeadingHeadline;
	protected WebObject myNotesTextArea;
	protected WebObject charCounter;
	protected WebObject editMyDayButton;
	protected WebObject saveChangesButton;
	protected WebObject saveChangesPopUp;
	protected WebObject saveChangesPopUpCloseButton;
	protected WebObject saveChangesPopUpMessage;
	protected WebObject saveChangesPopUpSaveButton;
	protected WebObject saveChangesPopUpDontSaveButton;
	protected WebObject weeklyChart;
	protected WebObject previousWeekButton;
	protected WebObject nextWeekButton;
	protected WebObject weekDates;
	protected WebObject shareWithDoctorModule;
	protected WebObject shareWithDoctorModuleEmailButton;
	protected WebObject shareWithDoctorModulePrintButton;
	protected WebObject shareWithDoctorPopUp;
	protected WebObject shareWithDoctorPopUpCloseButton;
	protected WebObject welcomePopUp;
	protected WebObject welcomePopUpCloseButton;
	protected WebObject savedNote;
	protected WebObject footerShareButton;
	protected WebObject settingsButton;
	protected WebObject settingsWindow;
	protected WebObject settingsWindowCloseButton;
	protected WebObject settingsWindowSaveChangesButton;
	protected WebObject settingsWindowConsentCheckbox;
	protected WebObject settingsWindowTextMessagingDropdown;
	protected WebObject settingsWindowTextMessagingDropdownChosenItem;
	protected WebObject settingsWindowTextMessagingDropdownItem;
	protected WebObject medTrackerModal;
	protected WebObject medTrackerModalCloseIcon;
	protected WebObject medTrackerModalLabel;
	protected WebObject medTrackerModalTitle;
	protected WebObject medTrackerModalDeck;
	protected WebObject medTrackerListDot;
	protected WebObject medTrackerListItem;
	protected WebObject medTrackerModalSearchInput;
	protected WebObject medTrackerModalPillIcon;
	protected WebObject medTrackerModalAddButton;
	protected WebObject medTrackerModalSuggestionsList;
	protected WebObject medTrackerModule;
	protected WebObject medTrackerModuleTitle;
	protected WebObject medTrackerModuleDeck;
	protected WebObject medTrackerModuleSearchInput;
	protected WebObject medTrackerModuleAddButton;
	protected WebObject medTrackerModulePillIcon;
	protected WebObject medTrackerModuleSuggestionsList;
	protected WebObject moduleMedicationItem;
	protected WebObject moduleMedicationItemLink;
	protected WebObject moduleMedicationItemRemoveIcon;
	protected WebObject moduleDuplicateMedicationError;
	protected WebObject suggestionsListOption;
	protected WebObject suggestionsListOptionWithText;
	protected WebObject dailyPainTrackerModule;
	protected WebObject dailyPainTrackerHeader;
	protected WebObject dailyPainTrackerQuestion;
	protected WebObject dailyPainTrackerBar;
	protected WebObject dailyPainTrackerLegend;
	protected WebObject dailyPainTrackerPainLevelChosen;
	protected WebObject dailyPainTrackerPainDescription;
	protected WebObject dailyPainTrackerPainLevelOption;
	protected WebObject dailyPainTrackerResultEntry;
	protected WebObject dailyPainTrackerPainLocationsModule;
	protected WebObject dailyPainTrackerPainLocationButton;
	protected WebObject dailyPainTrackerPainLocationButtonChosenWithText;
	protected WebObject dailyPainTrackerPainLocationButtonChosen;
	protected WebObject dailyPainTrackerPainLocationButtonWithText;
	protected WebObject weeklyPainTrackerModule;
	protected WebObject weeklyPainTrackerTitle;
	protected WebObject weeklyPainTrackerDesc;
	protected WebObject weeklyPainTrackerDescNoData;
	protected WebObject weeklyPainTrackerGraphContainer;
	protected WebObject weeklyPainTrackerGraph;
	protected WebObject weeklyPainTrackerGraphScoresModule;
	protected WebObject weeklyPainTrackerGraphScore;
	protected WebObject weeklyPainTrackerGraphWeekDaysModule;
	protected WebObject weeklyPainTrackerGraphWeekDay;
	protected WebObject weeklyPainTrackerPainSummariesModule;
	protected WebObject weeklyPainTrackerPainSummaryItem;
	protected WebObject weeklyPainTrackerPainSummaryLocationName;
	protected WebObject weeklyPainTrackerPainSummaryLocationNameText;
	protected WebObject weeklyPainTrackerPainSummaryLocationDays;
	protected WebObject weeklyPainTrackerPainSummaryLocationDaysText;

	@Override
	public void waitForPageToLoad() {
		if (isMedTrackerkModalWindowVisible()) {
			clickMedTrackerModalWindowCloseIcon();
		}
		if (welcomePopUp.isVisible()) {
			welcomePopUpCloseButton.click();
		}
		dailyView.waitUntilVisibleOnPage(this);
	}

	public boolean isDailyTabActive() {
		Logger.info("Check if 'Daily' tab is active");
		return tab.getAttributeOfElementNumber(1, "class").contains("active");
	}

	public boolean isWeeklyTabActive() {
		Logger.info("Check if 'Weekly' tab is active");
		return tab.getAttributeOfElementNumber(2, "class").contains("active");
	}

	public boolean isActiveDaySectionVisible() {
		Logger.info("Check if active day section is visible");
		return activeDaySection.isVisible();
	}

	public String getActiveDayDate() {
		Logger.info("Get active day date");
		return date.getText();
	}

	public boolean isDateButtonVisible() {
		Logger.info("Check if 'Date' button visible");
		return dateButton.isVisible();
	}

	public boolean isHowWasYourDaySectionVisible() {
		Logger.info("Check if 'How was your day today?' visible");
		return howWasYourDaySection.isVisible();
	}

	public int getNumberOfVisibleEmojiIcons() {
		Logger.info("Get number of visible emoji icons");
		return emoji.getVisibleElementsCount();
	}

	public boolean isWeeklyMySymptomsSectionVisible() {
		Logger.info("Check if 'My symptoms' section is visible in weekly view");
		return weeklyMySymptomsModule.isVisible();
	}

	public boolean isWeeklyMyTriggersSectionVisible() {
		Logger.info("Check if 'My triggers' section is visible in weekly view");
		return weeklyMyTriggersModule.isVisible();
	}

	public boolean isWeeklyMyWinsSectionVisible() {
		Logger.info("Check if 'My wins' section is visible in weekly view");
		return weeklyMyWinsModule.isVisible();
	}

	public boolean isWeeklyMyNotesSectionVisible() {
		Logger.info("Check if 'My notes' is visible in weekly view");
		return weeklyMyNotes.isVisible();
	}

	public boolean isEditMyDayButtonVisible() {
		Logger.info("Check if 'Edit my day' button is visible");
		return editMyDayButton.isVisible();
	}

	public PersonalizedTrackerPage clickEditMyDayLink() {
		Logger.info("Click on 'Edit my day' link");
		editMyDayLink.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public PersonalizedTrackerPage clickEditMyDayButton() {
		Logger.info("Click on 'Edit my day' button");
		editMyDayButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isEmojiIconActive(int emojiIconNumber) {
		Logger.info("Check if emoji icon #" + emojiIconNumber + " is active");
		try {
			return emoji.getAttributeOfElementNumber(emojiIconNumber, "data-toggle").equals("tab");
		} catch (NullPointerException e) {
			return false;
		}
	}

	public int getNumberOfActiveEmojiOnPage() {
		Logger.info("Get number of active emoji icons on page");
		return activeEmoji.getVisibleElementsCount();
	}

	public boolean isEmojiNumberGrey(int emojiNumber) {
		Logger.info("Check if emoji #" + emojiNumber + " associated number is grey");
		return Utils.getHexColor(emojiAssociatedNumber.getColor()).equals("#999999");
	}

	public PersonalizedTrackerPage clickEmojiIconNumber(int emojiNumber) {
		Logger.info("Click on emoji icon #" + emojiNumber);
		emoji.clickOnElementNumber(emojiNumber);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isEmojiChosen(int chosenEmojiNumber) {
		Logger.info("Check if emoji #" + chosenEmojiNumber + " is chosen and icon became bigger");
		waitForAjaxRequestToBeFinished();
		return emojiBlock.getAttributeOfElementNumber(chosenEmojiNumber, "class").equals("active");
	}

	public boolean isEmojiSentenceVisible(int emojiNumber) {
		Logger.info("Check if emoji #" + emojiNumber + " associated sentence visible");
		return emojiSentence.isElementNumberVisible(emojiNumber);
	}

	public boolean isChosenEmojiNumberBlack(int emojiNumber) {
		Logger.info("Check if chose emoji #" + emojiNumber + " associated number is black");
		return Utils.getHexColor(emojiAssociatedNumber.getElements().get(emojiNumber - 1).getCssValue("color")).equals("#333333");
	}

	public PersonalizedTrackerPage clickSaveChangesLink() {
		Logger.info("Click 'Save Changes' link");
		saveChangesLink.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public void clickSaveChangesButton() {
		Logger.info("Click 'Save Changes' button");
		saveChangesButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isEmojiNumberVisible(int emojiNumber) {
		Logger.info("Check if emoji #" + emojiNumber + " associated number is visible");
		return !emojiAssociatedNumber.getCssOfElementNumber(emojiNumber, "visibility").equals("hidden");
	}

	public PersonalizedTrackerPage clickPreviousDayButton() {
		Logger.info("Click on previous day navigation arrow");
		previousDay.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public PersonalizedTrackerPage clickNextDayButton() {
		Logger.info("Click on next day navigation arrow");
		nextDay.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isNextDayNavigationArrowVisible() {
		Logger.info("Check if next day navigation arrow is visible");
		return nextDay.isVisible();
	}

	public void clickDateButton() {
		Logger.info("Click 'Date' button");
		dateButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isDatePickerVisible() {
		Logger.info("Check if date picker visible");
		return calendar.isVisible();
	}

	public String getDatePickerHeaderText() {
		Logger.info("Get header text in date picker");
		return calendarHeader.getText();
	}

	public void clickDatePickerPreviousMonthButton() {
		Logger.info("Click '<' arrow in date picker");
		calendarPrevMonthArrow.click();
		waitForAjaxRequestToBeFinished(1500);
	}

	public void openDayInPast(PersonalizedTrackerPage ptPage, int daysAgo, boolean arrowsNavigation) {
		LocalDate dateInPast = daysAgo == 0 ? getProgramStartDate() : LocalDate.now().minusDays(daysAgo);
		Logger.info("User should be taken to " + dateInPast);
		if (arrowsNavigation) {
			openDayUsingNavArrows(ptPage, daysAgo);
		} else {
			openDayUsingDatePicker(dateInPast.format(DateTimeFormatter.ofPattern("MMMM yyyy", Locale.US)), dateInPast);
		}
	}

	private void openDayUsingDatePicker(String dateInPastMMMMyyyy, LocalDate dateInPast) {
		clickDateButton();
		while (!getDatePickerHeaderText().equals(dateInPastMMMMyyyy)) {
			clickDatePickerPreviousMonthButton();
		}
		assertEquals(getDatePickerHeaderText(), dateInPast.format(DateTimeFormatter.ofPattern("MMMM yyyy", Locale.US)), "User should be taken to correct month in date picker");
		clickDay(String.valueOf(dateInPast.getDayOfMonth()));
	}

	private void openDayUsingNavArrows(PersonalizedTrackerPage ptPage, int daysAgo) {
		LocalDate today = LocalDate.now();
		LocalDate dateInPast = today.minusDays(daysAgo);
		Logger.debug("Should open date " + dateInPast);
		LocalDate monday = dateInPast.with(DayOfWeek.MONDAY);
		Logger.debug("Week starts at " + monday);
		LocalDate sunday = dateInPast.with(DayOfWeek.SUNDAY);
		String dateInPastText = dateInPast.format(DateTimeFormatter.ofPattern("MMMM d", Locale.US));
		Logger.debug("Date in past text " + dateInPastText);
		//if week starts and ends in one month - date format is a bit different
		boolean isWeekInMonth = sunday.getMonthValue() == monday.getMonthValue();
		String mondayText = isWeekInMonth ?
				monday.format(DateTimeFormatter.ofPattern("MMMM d", Locale.US)) :
				monday.format(DateTimeFormatter.ofPattern("MMM d", Locale.US));
		Logger.debug("Monday in past text " + mondayText);

		if (isDailyTabActive()) {
			while (!ptPage.getCurrentDayDate().endsWith(dateInPastText)) {
				ptPage.clickPreviousDayButton();
			}
		} else {
			while (!getWeekStartDate().equals(mondayText)) {
				ptPage.clickPreviousWeekNavigationArrow();
			}
		}
	}

	public LocalDate getProgramStartDate() {
		String pageSource = WebDriverManager.getDriver().getPageSource();
		boolean isCodeMinified = Utils.isPageSourceContains("dashboardJSON=") ? true : false;
		String separator = isCodeMinified ? "dashboardJSON=" : "dashboardJSON = ";
		String jsonProgramStartDate = pageSource.split(separator)[1].split(",")[0];
		assertTrue(jsonProgramStartDate.startsWith("{\"ProgramStartDate\""), "'ProgramStartDate' JSON parameter should be chosen");
		return LocalDate.parse(jsonProgramStartDate.substring(21, 31), DateTimeFormatter.ISO_LOCAL_DATE);
	}

	public ArrayList<LocalDate> getWeekDatesInWeeklyView() {
		ArrayList<LocalDate> weekDates = new ArrayList<>();
		String[] dateLineText = getWeekDates().split("-");
		String weekStartDay = dateLineText[0].trim();
		String weekStartMonth = weekStartDay.split(" ")[0];

		String[] weekEndDate = dateLineText[1].trim().split(",");
		String weekFinishDay = weekEndDate[0];
		String weekYear = weekEndDate[1];

		Character character = weekFinishDay.charAt(0);
		LocalDate sunday;
		LocalDate monday;

		if (character >= '0' && character <= '9') { //means week starts and finishes in one month
			monday = LocalDate.parse(weekStartDay + weekYear, DateTimeFormatter.ofPattern("MMMM d yyyy", Locale.US));
			sunday = LocalDate.parse(weekStartMonth + dateLineText[1], DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.US));
		} else {
			monday = LocalDate.parse(weekStartDay + weekYear, DateTimeFormatter.ofPattern("MMM d yyyy", Locale.US));
			sunday = LocalDate.parse(dateLineText[1].trim(), DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.US));
		}
		Logger.info("Displayed week start date - " + monday);
		Logger.info("Displayed week end date - " + sunday);
		weekDates.add(monday);
		weekDates.add(sunday);
		return weekDates;
	}

	public boolean isCorrectWeekVisibleForDate(LocalDate date) {
		Logger.info("Date to check - " + date.format(DateTimeFormatter.ISO_LOCAL_DATE));
		Logger.info("Expected Monday - " + date.with(DayOfWeek.MONDAY).format(DateTimeFormatter.ISO_LOCAL_DATE));
		Logger.info("Expected Sunday - " + date.with(DayOfWeek.SUNDAY).format(DateTimeFormatter.ISO_LOCAL_DATE));
		Logger.info("Verify if correct week dates are displayed in weekly view");

		ArrayList<LocalDate> weekDates = getWeekDatesInWeeklyView();
		boolean isCorrectWeek = false;
		if (!date.isBefore(weekDates.get(0)) && !date.isAfter(weekDates.get(1))) {
			isCorrectWeek = true;
		}
		return isCorrectWeek;
	}

	public boolean isCurrentDayHighlighted(String dayNumber) {
		Logger.info("Check if current day is highlighted in calendar");
		return calendarDayOfMonth.isElementWithTextVisible(dayNumber) && calendarDayOfMonth.getAttributeOfElementNumberWithText(1, "class", dayNumber).contains("ui-state-highlight ui-state-active");
	}

	public void clickDay(String dayNumber) {
		Logger.info("Click day #" + dayNumber + " in Calendar");
		calendarDayOfMonth.clickOnElementNumberWithText(1, dayNumber);
		waitForAjaxRequestToBeFinished(1500);
	}

	public boolean isFutureDateDisabledInCalendar(String dayNumber) {
		Logger.info("Check if " + dayNumber + " day of month in future is enabled");
		int currentDay = Integer.valueOf(DateUtils.getCurrentDate(DatePatterns.d));
		if (currentDay > Integer.valueOf(dayNumber)) {
			return calendarDayNextMonth.getAttributeOfElementNumberWithText(1, "class", dayNumber).contains("ui-datepicker-unselectable ui-state-disabled");
		} else {
			return calendarDayCurrentMonth.getAttributeOfElementNumberWithText(1, "class", dayNumber).contains("ui-datepicker-unselectable ui-state-disabled");
		}
	}

	public int getNumberOfDisabledDates() {
		Logger.info("Get number of disabled dates in date picker (days in future)");
		return calendarDisabledDate.getElementsCount();
	}

	public boolean isCalendarRightNavigationArrowEnabled() {
		Logger.info("Check if right navigation arrow is enabled on Calendar");
		return !calendarNextMonthArrow.getAttribute("class").contains("ui-state-disabled");
	}

	public int getNumberOfDaysDisplayed() {
		Logger.info("Get number of days that are displayed");
		return dailyView.getVisibleElementsCount();
	}

	public String getCurrentDayDate() {
		Logger.info("Get current day date");
		String dateText = date.getText();
		Logger.info("Date: " + dateText);
		return dateText;
	}

	public boolean isSaveChangesPopUpVisible() {
		Logger.info("Check if 'Save changes' pop up is visible");
		return saveChangesPopUp.isVisible();
	}

	public PersonalizedTrackerPage clickDontSaveButton() {
		Logger.info("Click 'Don't save' button on pop up");
		saveChangesPopUpDontSaveButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public void clickWeeklyTab() {
		Logger.info("Click 'Weekly' tab");
		weeklyTab.click();
		weeklyChart.waitUntilVisible();
	}

	public void clickDailyTab() {
		Logger.info("Click 'Daily' tab");
		dailyTab.click();
		activeDaySection.waitUntilVisible();
	}

	public void clickPreviousWeekNavigationArrow() {
		Logger.info("Click previous week navigation arrow");
		previousWeekButton.click();
		waitForAjaxRequestToBeFinished(1500);
	}

	public boolean isPreviousWeekNavigationArrowVisible() {
		Logger.info("Check if previous week navigation arrow is visible");
		return previousWeekButton.isVisible();
	}

	public boolean isNextWeekNavigationArrowVisible() {
		Logger.info("Check if next week navigation arrow is visible");
		return nextWeekButton.isVisible();
	}

	public PersonalizedTrackerPage clickNextWeekNavigationArrow() {
		Logger.info("Click next week navigation arrow");
		nextWeekButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public String getWeekDates() {
		Logger.info("Get dates of week start/end");
		return weekDates.getText();
	}

	public String getWeekStartDate() {
		Logger.info("Get week start date");
		return getWeekDates().split("-")[0].trim();
	}

	public boolean isMondayDisplayedInDailyViewForGivenDate(String givenDate) {
		Logger.info("Check if given date " + givenDate + " is displayed in daily view");
		String activeDateDailyTab = getActiveDayDate();
		if (givenDate.contains(",")) { //means week started in one year and finished in another
			String dateToParse[] = givenDate.split(",")[0].split(" "); //'Dec 26, 2016' -> 'Dec' and '26'
			Logger.info("Week started on " + givenDate + ". After switching to 'Daily' tab visible date is " + activeDateDailyTab);
			return activeDateDailyTab.contains("Mon") && activeDateDailyTab.contains(dateToParse[0]) && activeDateDailyTab.contains(dateToParse[1]);
		} else {
			String dateToParse[] = givenDate.split(" ");
			Logger.info("Week started on " + givenDate + ". After switching to 'Daily' tab visible date is " + activeDateDailyTab);
			return activeDateDailyTab.contains(dateToParse[0]) && activeDateDailyTab.contains(dateToParse[1]);
		}
	}

	public boolean isShareResultsWithDoctorSectionVisible() {
		Logger.info("Check if 'Share this results with your doctor' section is visible");
		return shareWithDoctorModule.isVisible();
	}

	public boolean isShareResultsWithDoctorEmailButtonVisible() {
		Logger.info("Check if 'Email' button is visible in 'Share this results with your doctor' section");
		return shareWithDoctorModuleEmailButton.isVisible();
	}

	public PersonalizedTrackerPage clickDashboardEmailButton() {
		Logger.info("Click 'Email' button in 'Share this results with your doctor' section");
		shareWithDoctorModuleEmailButton.click();
		shareWithDoctorPopUp.waitUntilVisible();
		return this;
	}

	public boolean isShareResultsWithDoctorPrintButtonVisible() {
		Logger.info("Check if 'Print' button is visible in 'Share this results with your doctor' section");
		return shareWithDoctorModulePrintButton.isVisible();
	}

	public void clickPrintButton() {
		Logger.info("Click 'Print' button in 'Share this results with your doctor' section");
		((JavascriptExecutor) basedriver).executeScript("window.print=function(){};"); //disabling print dialog window
		shareWithDoctorModulePrintButton.click();
	}

	public boolean isDailyMySymptomsSectionVisible() {
		Logger.info("Check if 'My symptoms' section is visible in daily view");
		return dailyMySymptomsModule.isVisible();
	}

	public boolean isDailyMyTriggersSectionVisible() {
		Logger.info("Check if 'My triggers' section is visible in daily view");
		return dailyMyTriggersModule.isVisible();
	}

	public boolean isDailyMyWinsSectionVisible() {
		Logger.info("Check if 'My wins' section is visible in daily view");
		return dailyMyWinsModule.isVisible();
	}

	public boolean isDailyMyNotesSectionVisible() {
		Logger.info("Check if 'My notes' section is visible in daily view");
		return dailyMyNotes.isVisible();
	}

	public int getNumberOfMySymptomsVariantButtons() {
		Logger.info("Check if variant buttons are visible in 'My symptoms' section");
		return dailyMySymptomsButtons.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfMyTriggersVariantButtons() {
		Logger.info("Check if variant buttons are visible in 'My triggers' section");
		return dailyMyTriggersButtons.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfMyWinsVariantButtons() {
		Logger.info("Check if variant buttons are visible in 'My wins' section");
		return dailyMyWinsButtons.getNumberOfVisibleAndClickableElements();
	}

	public boolean isMyNotesTextAreaVisible() {
		Logger.info("Check if my notes input text area visible");
		return myNotesTextArea.isVisible();
	}

	public PersonalizedTrackerPage clickMySymptomsVariantButton(int buttonNumber) {
		Logger.info("Click variant button #" + buttonNumber + " in 'My symptoms' section");
		if (dailyMySymptomsButtons.getAttributeOfElementNumber(buttonNumber, "class").contains("active")) {
			Logger.info("Button '" + dailyMySymptomsButtons.getText() + "' is already chosen");
		} else {
			dailyMySymptomsButtons.clickOnElementNumber(buttonNumber);
		}
		return this;
	}

	public PersonalizedTrackerPage clickMyTriggersVariantButton(int buttonNumber) {
		Logger.info("Click variant button #" + buttonNumber + " in 'My triggers' section");
		if (dailyMyTriggersButtons.getAttributeOfElementNumber(buttonNumber, "class").contains("active")) {
			Logger.info("Button '" + dailyMyTriggersButtons.getText() + "' is already chosen");
		} else {
			dailyMyTriggersButtons.clickOnElementNumber(buttonNumber);
		}
		return this;
	}

	public PersonalizedTrackerPage clickMyWinsVariantButton(int buttonNumber) {
		Logger.info("Click variant button #" + buttonNumber + " in 'My wins' section");
		if (dailyMyWinsButtons.getAttributeOfElementNumber(buttonNumber, "class").contains("active")) {
			Logger.info("Button '" + dailyMyWinsButtons.getText() + "' is already chosen");
		} else {
			dailyMyWinsButtons.clickOnElementNumber(buttonNumber);
		}
		return this;
	}

	public boolean isMySymptomsVariantButtonChosen(String text) {
		Logger.info("Check if variant button with text '" + text + "' in 'My symptoms' section is active");
		return dailyMySymptomsButtonsWithText.getAttributeOfElementNumberWithText(1, "class", text).contains("active");
	}

	public boolean isMyTriggersVariantButtonChosen(String text) {
		Logger.info("Check if variant button with text '" + text + "' in 'My triggers' section is active");
		return dailyMyTriggersButtonsWithText.getAttributeOfElementNumberWithText(1, "class", text).contains("active");
	}

	public boolean isMyWinsVariantButtonChosen(String text) {
		Logger.info("Check if variant button with text '" + text + "' in 'My wins' section is active");
		return dailyMyWinsButtonsWithText.getAttributeOfElementNumberWithText(1, "class", text).contains("active");
	}

	public String getMySymptomsVariantButtonText(int buttonNumber) {
		Logger.info("Get symptoms variant button text");
		String buttonText = dailyMySymptomsButtons.getTextFromElementNumber(buttonNumber);
		Logger.info("Button - '" + buttonText + "'");
		return buttonText;
	}

	public String getMyTriggersVariantButtonText(int buttonNumber) {
		Logger.info("Get triggers variant button text");
		String buttonText = dailyMyTriggersButtons.getTextFromElementNumber(buttonNumber);
		Logger.info("Button - '" + buttonText + "'");
		return buttonText;
	}

	public String getMyWinsVariantButtonText(int buttonNumber) {
		Logger.info("Get wins variant button text");
		String buttonText = dailyMyWinsButtons.getTextFromElementNumber(buttonNumber);
		Logger.info("Button - '" + buttonText + "'");
		return buttonText;
	}

	public boolean isActiveSymptomButtonWithTextVisible(String text) {
		Logger.info("Check if active symptom button '" + text + "' is visible");
		return dailyMySymptomsButtonsChosen.isElementWithTextVisible(text);
	}

	public boolean isActiveTriggerButtonWithTextVisible(String text) {
		Logger.info("Check if active trigger button '" + text + "' is visible");
		return dailyMyTriggersButtonsChosen.isElementWithTextVisible(text);
	}

	public boolean isActiveWinButtonWithTextVisible(String text) {
		Logger.info("Check if active win button '" + text + "' is visible");
		return dailyMyWinsButtonsChosen.isElementWithTextVisible(text);
	}

	public boolean isActiveButtonWithTextVisible(String text) {
		Logger.info("Verify if button with text '" + text + "' is visible");
		waitForAjaxRequestToBeFinished();
		return dailyActiveButtonWithText.isElementWithTextVisible(text);
	}

	public int getNumberOfActiveButtons() {
		Logger.info("Get number of active buttons");
		return dailyActiveButton.getNumberOfVisibleAndClickableElements();
	}

	public void clickActiveButton() {
		dailyActiveButton.click();
	}

	public boolean isCharCounterVisible() {
		Logger.info("Check if char counter is visible in 'My notes' section");
		return charCounter.isVisible();
	}

	public String getCharCounterLimitValue() {
		Logger.info("Get char limit value");
		return charCounter.getText().split("/")[1].trim();
	}

	public int getCurrentCharCounterValue() {
		Logger.info("Get current char counter value");
		return Integer.valueOf(charCounter.getText().split("/")[0].trim());
	}

	public PersonalizedTrackerPage typeNote(String text) {
		Logger.info("Type note");
		myNotesTextArea.type(text);
		return this;
	}

	public boolean isSaveNoteVisible(String note) {
		Logger.info("Check if saved note is visible");
		return savedNote.isElementWithTextVisible(note);
	}

	public String getPopUpMessage() {
		Logger.info("Get pop up window message");
		return saveChangesPopUpMessage.getText().trim();
	}

	public boolean isSaveButtonVisibleOnPopUp() {
		Logger.info("Check if 'Save' button is visible on pop up window");
		return saveChangesPopUpSaveButton.isVisible();
	}

	public boolean isDontSaveButtonVisibleOnPopUp() {
		Logger.info("Check if 'Don't save' button is visible on pop up window");
		return saveChangesPopUpDontSaveButton.isVisible();
	}

	public PersonalizedTrackerPage clickSaveButtonOnPopUp() {
		Logger.info("Click 'Save' button on pop up window");
		saveChangesPopUpSaveButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public PersonalizedTrackerPage clickCloseButtonOnPopUp() {
		Logger.info("Click 'Close' button on pop up window");
		saveChangesPopUpCloseButton.click();
		return this;
	}

	public PersonalizedTrackerPage clickFooterShareButton() {
		Logger.info("Click footer sticky bar 'Share' button");
		footerShareButton.click();
		shareWithDoctorPopUp.waitUntilVisible();
		return this;
	}

	public PersonalizedTrackerPage clickShareWithDoctorPopUpCloseButton() {
		Logger.info("Click 'Close' button on 'Share these results with your doctor' pop up window");
		shareWithDoctorPopUpCloseButton.click();
		shareWithDoctorPopUp.waitUntilInvisible();
		return this;
	}

	public void clickActiveDayInCalendar() {
		Logger.info("Click on current day in Calendar");
		calendarActiveDay.click();
		waitForAjaxRequestToBeFinished();
	}

	public PersonalizedTrackerPage clickSettingsButton() {
		Logger.info("Click 'Settings' button");
		settingsButton.click();
		settingsWindow.waitUntilVisible();
		return this;
	}

	public PersonalizedTrackerPage enableTextMessaging() {
		Logger.info("Choose 'Enabled' value from dropdown");
		settingsWindowTextMessagingDropdown.click();
		settingsWindowTextMessagingDropdownItem.clickOnElementNumberWithText(1, "Enabled");
		return this;
	}

	public PersonalizedTrackerPage clickConsentCheckbox() {
		Logger.info("Check consent checkbox");
		settingsWindowConsentCheckbox.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isSaveChangesButtonVisibleOnSettingsWindow() {
		Logger.info("Verify if 'Save Changes' button is visible in 'Settings' window");
		return settingsWindowSaveChangesButton.isVisible();
	}

	public PersonalizedTrackerPage clickSaveChangesButtonSettingsWindow() {
		Logger.info("Click 'Save changes' button in 'Settings' window");
		settingsWindowSaveChangesButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public PersonalizedTrackerPage clickSettingsCloseButton() {
		Logger.info("Click 'Close' button in 'Settings' window");
		settingsWindowCloseButton.click();
		settingsWindow.waitUntilInvisible();
		return this;
	}

	public String getDropdownChosenElementText() {
		Logger.info("Get selected value text");
		if (!settingsWindow.isVisible()) {
			clickSettingsButton();
			waitForAjaxRequestToBeFinished();
		}
		return settingsWindowTextMessagingDropdownChosenItem.getText();
	}

	public boolean isSettingsWindowVisible() {
		Logger.info("Verify if 'Settings' window is visible");
		return settingsWindow.isVisible();
	}

	public boolean isRecommendedReadingsModuleVisibleInDailyView() {
		Logger.info("Verify if Recommended readings module is visible in daily view");
		return dailyRecommendedReadingsModule.isVisible();
	}

	public boolean isRecommendedReadingsModuleVisibleInWeeklyView() {
		Logger.info("Verify if Recommended readings module is visible in weekly view");
		return weeklyRecommendedReadingsModule.isVisible();
	}

	public boolean isRecommendedReadingsHeadingVisibleInDailyView() {
		Logger.info("Verify if heading is visible for Recommended readings module in daily view");
		return dailyRecommendedReadingsModuleHeading.isVisible();
	}

	public boolean isRecommendedReadingsHeadingVisibleInWeeklyView() {
		Logger.info("Verify if heading is visible for Recommended readings module in weekly view");
		return weeklyRecommendedReadingsModuleHeading.isVisible();
	}

	public boolean isRecommendedReadingsHeadingImageVisibleInDailyView() {
		Logger.info("Verify if heading image is visible for Recommended readings module in daily view");
		return dailyRecommendedReadingsModuleHeadingIcon.isVisible();
	}

	public boolean isRecommendedReadingsHeadingTextVisibleInDailyView() {
		Logger.info("Verify if heading text is visible for Recommended readings module in daily view");
		return dailyRecommendedReadingsModuleHeadingHeadline.isVisible();
	}

	public boolean isRecommendedReadingsHeadingImageVisibleInWeeklyView() {
		Logger.info("Verify if heading image is visible for Recommended readings module in weekly view");
		return weeklyRecommendedReadingsModuleHeadingIcon.isVisible();
	}

	public boolean isRecommendedReadingsHeadingTextVisibleInWeeklyView() {
		Logger.info("Verify if heading text is visible for Recommended readings module in weekly view");
		return weeklyRecommendedReadingsModuleHeadingHeadline.isVisible();
	}

	public int getNumberOfItemsInRecommendedReadingsModuleDailyView() {
		Logger.info("Get number of items in Recommended readings module in daily view");
		return dailyRecommendedReadingsModuleItem.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfImagesInRecommendedReadingsModuleDailyView() {
		Logger.info("Get number of images in Recommended readings module in daily view");
		return dailyRecommendedReadingsModuleItemImage.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfHeadlinesInRecommendedReadingsModuleDailyView() {
		Logger.info("Get number of headlines in Recommended readings module in daily view");
		return dailyRecommendedReadingsModuleItemText.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfImagesInRecommendedReadingsModuleWeeklyView() {
		Logger.info("Get number of images in Recommended readings module in weekly view");
		return weeklyRecommendedReadingsModuleItemText.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfHeadlinesInRecommendedReadingsModuleWeeklyView() {
		Logger.info("Get number of headlines in Recommended readings module in weekly view");
		return weeklyRecommendedReadingsModuleItemImage.getNumberOfVisibleAndClickableElements();
	}

	public boolean isMedTrackerkModalWindowVisible() {
		Logger.info("Verify if med tracker modal window is visible");
		return medTrackerModal.isVisible();
	}

	public boolean isMedTrackerModalWindowCloseIconVisible() {
		Logger.info("Verify if Close icon [x] is visible on med tracker modal");
		return medTrackerModalCloseIcon.isVisible();
	}

	public void clickMedTrackerModalWindowCloseIcon() {
		Logger.info("Click 'Close' icon [x] on med tracker modal window");
		medTrackerModalCloseIcon.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isMedTrackerModalNewLabelVisible() {
		Logger.info("Verify if 'NEW' label is visible on med tracker modal window");
		return medTrackerModalLabel.isVisible();
	}

	public String getMedTrackerModalLabelText() {
		Logger.info("Get text from label on med tracker modal");
		return medTrackerModalLabel.getText();
	}

	public String getMedTrackerModalLabelColor() {
		Logger.info("Get 'color' value for 'NEW' label");
		return medTrackerModalLabel.getColor();
	}

	public boolean isTitleVisibleOnMedTrackerModalWindow() {
		Logger.info("Verify if title is visible on med tracker modal window");
		return medTrackerModalTitle.isVisible();
	}

	public String getMedTrackerModalWindowTitleText() {
		Logger.info("Get med tracker modal window title text");
		return medTrackerModalTitle.getText();
	}

	public boolean isDeckVisibleOnMedTrackerModalWindow() {
		Logger.info("Verify if deck is visible on med tracker modal window");
		return medTrackerModalDeck.isVisible();
	}

	public String getMedTrackerModalWindowDeckText() {
		Logger.info("Get med tracker modal window deck text");
		return medTrackerModalDeck.getText();
	}

	public int getNumberOfDotsInList() {
		Logger.info("Get number of dots in list on med tracker modal window");
		return medTrackerListDot.getVisibleElementsCount();
	}

	public int getNumberOfItemsInList() {
		Logger.info("Get number of items in list on med tracker modal window");
		return medTrackerListItem.getVisibleElementsCount();
	}

	public String getListItemText(int listItemNumber) {
		Logger.info("Get text from list item #" + listItemNumber);
		return medTrackerListItem.getTextFromElementNumber(listItemNumber);
	}

	public boolean isMedTrackerModalWindowPillIconVisible() {
		Logger.info("Verify if pill icon is visible on med tracker modal");
		return medTrackerModalPillIcon.isVisible();
	}

	public boolean isMedTrackerModalWindowSearchInputVisible() {
		Logger.info("Verify if search input is visible on modal window");
		return medTrackerModalSearchInput.isVisible();
	}

	public void typeSearchQueryOnModalWindow(String query) {
		Logger.info("Type search query - " + query);
		medTrackerModalSearchInput.type(query);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isModalWindowAutosuggestionListVisible() {
		Logger.info("Verify if autosuggestion list is visible on modal window");
		return medTrackerModalSuggestionsList.isVisible();
	}

	public boolean isAddButtonVisibleOnModalWindow() {
		Logger.info("Verify if 'Add' button is visible on modal window");
		return medTrackerModalAddButton.isVisible();
	}

	public void clickAddButtonOnModalWindow() {
		Logger.info("Click 'Add' button on med tracker modal window");
		medTrackerModalAddButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isMedTrackerModuleVisible() {
		Logger.info("Verify if med tracker module is visible");
		return medTrackerModule.isVisible();
	}

	public int getMedTrackerModuleYCoordinateValue() {
		Logger.info("Get med tracker 'Y' coordinate value");
		return medTrackerModule.getYCoordinate();
	}

	public boolean isMedTrackerModuleTitleVisible() {
		Logger.info("Verify if med tracker module title is visible");
		return medTrackerModuleTitle.isVisible();
	}

	public String getMedTrackerModuleTitleText() {
		Logger.info("Get med tracker module title text");
		return medTrackerModuleTitle.getText();
	}

	public boolean isMedTrackerModuleDeckVisible() {
		Logger.info("Verify if med tracker module deck is visible");
		return medTrackerModuleDeck.isVisible();
	}

	public String getMedTrackerModuleDeckText() {
		Logger.info("Get med tracker module deck text");
		return medTrackerModuleDeck.getText();
	}

	public boolean isMedTrackerModulePillIconVisible() {
		Logger.info("Verify if pill icon is visible on med tracker module");
		return medTrackerModulePillIcon.isVisible();
	}

	public boolean isMedTrackerModuleSearchInputVisible() {
		Logger.info("Verify if search input is visible on med tracker module");
		return medTrackerModuleSearchInput.isVisible();
	}

	public PersonalizedTrackerPage typeSearchQueryOnMedTrackerModule(String query) {
		Logger.info("Type search query - " + query);
		medTrackerModuleSearchInput.type(query);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isMedTrackerModuleAutosuggestionListVisible() {
		Logger.info("Verify if autosuggestion list is visible");
		return medTrackerModuleSuggestionsList.isVisible();
	}

	public int getNumberOfMedicationItems() {
		Logger.info("Get number of medication items");
		return moduleMedicationItem.getVisibleElementsCount();
	}

	public String getMedicationItemText(int itemNumber) {
		Logger.info("Get text from medication item #" + itemNumber);
		return medTrackerListItem.getTextFromElementNumber(itemNumber);
	}

	public int getNumberOfMedicationHyperlinkedItems() {
		Logger.info("Get number of medication hyperlinked items");
		return moduleMedicationItemLink.getVisibleElementsCount();
	}

	public String getMedicationItemHrefAttributeValue(int itemNumber) {
		Logger.info("Get 'href' attribute value");
		return moduleMedicationItemLink.getTextFromElementNumber(itemNumber);
	}

	public String getHyperlinkedMedicationHrefValue(int linkNumber) {
		Logger.info("Get 'href' attribute value for hyperlinked medication #" + linkNumber);
		return moduleMedicationItemLink.getHrefOfElementNumber(linkNumber);
	}

	public int getNumberOfCloseIcons() {
		Logger.info("Get number of [x] icons for medications in the list");
		return moduleMedicationItemRemoveIcon.getNumberOfVisibleAndClickableElements();
	}

	public void clickRemoveMedicationIcon(int iconNumber) {
		Logger.info("Click [x] icon for medication #" + iconNumber);
		moduleMedicationItemRemoveIcon.clickOnElementNumber(iconNumber);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isDuplicateMedicationErrorMessageVisible() {
		Logger.info("Verify if error message is visible for duplicate medication in the list");
		return moduleDuplicateMedicationError.isVisible();
	}

	public boolean isAddButtonVisibleOnMedTrackerModule() {
		Logger.info("Verify if 'Add' button is visible on med tracker module");
		return medTrackerModuleAddButton.isVisible();
	}

	public void clickAddButtonOnMedTrackerModule() {
		Logger.info("Click 'Add' button on med tracker module");
		medTrackerModuleAddButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfSuggestions() {
		Logger.info("Get number of suggested results");
		return suggestionsListOption.getNumberOfVisibleAndClickableElements();
	}

	public String getSuggestionText(int suggestionNumber) {
		Logger.info("Get text from suggested item #" + suggestionNumber);
		return suggestionsListOption.getTextFromElementNumber(suggestionNumber);
	}

	public PersonalizedTrackerPage clickSuggestion(String suggestionText) {
		Logger.info("Click on suggestion item - '" + suggestionText + "'");
		suggestionsListOptionWithText.clickOnElementNumberWithText(1, suggestionText);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isDailyPainTrackerModuleVisible() {
		Logger.info("Verify if Pain Tracker module is visible");
		return dailyPainTrackerModule.isVisible();
	}

	public boolean isDailyPainTrackerHeaderTextVisible() {
		Logger.info("Verifying Pain Tracker header text is visible on Daily View");
		return dailyPainTrackerHeader.isVisible();
	}

	public boolean isDailyPainTrackerQuestionTextVisible() {
		Logger.info("Verifying Pain Tracker question text is visible on Daily View");
		return dailyPainTrackerQuestion.isVisible();
	}

	public String getDailyPainTrackerQuestionText() {
		Logger.info("Get question text for Pain Tracker in daily view");
		return dailyPainTrackerQuestion.getText();
	}

	public boolean isDailyPainTrackerBarVisible() {
		Logger.info("Verify if pain tracker bar is visible");
		return dailyPainTrackerBar.isVisible();
	}

	public String getPainTrackerPainLevelValue() {
		Logger.info("Get pain level value");
		String level = dailyPainTrackerPainLevelChosen.getText();
		Logger.info("Pain level - " + level);
		return level;
	}

	public boolean isDailyPainTrackerPainDescriptionVisible() {
		Logger.info("Verify if pain description is visible on Daily view");
		return dailyPainTrackerPainDescription.isVisible();
	}

	public String getPainDescriptionText() {
		Logger.info("Get pain description text");
		String description = dailyPainTrackerPainDescription.getText();
		Logger.info("Description - " + description);
		return description;
	}

	public boolean isDailyPainTrackerLegendVisible() {
		Logger.info("Verifying Pain Tracker legend (per level) is visible");
		return dailyPainTrackerLegend.isVisible();
	}

	public void clickDailyPainTrackerLevelPip(int levelNumber) {
		Logger.info("Click Pain Tracker level pip #" + levelNumber);
		dailyPainTrackerPainLevelOption.clickOnElementNumberWithText(1, String.valueOf(levelNumber));
		waitForAjaxRequestToBeFinished();
	}

	public boolean isDailyPainTrackerResultVisible() {
		Logger.info("Verify if pain tracker result is visible in daily view");
		dailyPainTrackerResultEntry.scrollToElement();
		return dailyPainTrackerResultEntry.isVisible();
	}

	public String getDailyPainResultDescription() {
		Logger.info("Get pain result description text");
		String description = dailyPainTrackerResultEntry.getText();
		Logger.info("Saved description - " + description);
		return description;
	}

	public boolean isDialyPainTrackerPainLocationButtonsModuleVisible() {
		Logger.info("Verify if pain location buttons are visible in edit mode");
		dailyPainTrackerPainLocationsModule.scrollToElement();
		return dailyPainTrackerPainLocationsModule.isVisible();
	}

	public int getNumberOfPainLocationButtons() {
		Logger.info("Get number of pain location buttons");
		return dailyPainTrackerPainLocationButton.getNumberOfVisibleAndClickableElements();
	}

	public void clickPainLocationButton(String locationText) {
		Logger.info("Click pain location button - '" + locationText + "'");
		dailyPainTrackerPainLocationButtonWithText.clickOnElementNumberWithText(1, locationText);
		waitForAjaxRequestToBeFinished();
	}

	public String getTextFromPainLocationButton(int buttonNumber) {
		Logger.info("Get text from pain location button #" + buttonNumber);
		return dailyPainTrackerPainLocationButton.getTextFromElementNumber(buttonNumber);
	}

	public boolean isActivePainLocationButtonVisible(String painLocation) {
		Logger.info("Verify if pain location button - '" + painLocation + "' is visible");
		return dailyPainTrackerPainLocationButtonChosenWithText.isElementWithTextVisible(painLocation);
	}

	public int getNumberOfChosenButtons() {
		Logger.info("Get number of buttons with chosen pain location");
		return dailyPainTrackerPainLocationButtonChosen.getVisibleElementsCount();
	}

	public String getChosenButtonText(int buttonNumber) {
		Logger.info("Get text from pain location button #" + buttonNumber);
		return dailyPainTrackerPainLocationButtonChosen.getTextFromElementNumber(buttonNumber).trim();
	}

	public boolean isWeeklyPainTrackerModuleVisible() {
		Logger.info("Verify if weekly pain tracker module is visible");
		weeklyPainTrackerModule.scrollToElement();
		return weeklyPainTrackerModule.isVisible();
	}

	public boolean isWeeklyPainTrackerModuleTitleVisible() {
		Logger.info("Verify if weekly pain tracker module title is visible");
		return weeklyPainTrackerTitle.isVisible();
	}

	public boolean isWeeklyPainTrackerModuleDescriptionVisible() {
		Logger.info("Verify if weekly pain tracker module description is visible");
		return weeklyPainTrackerDesc.isVisible();
	}

	public String getWeeklyPainTrackerModuleDescriptionText() {
		Logger.info("Get description text for Pain Tracker module in weekly view");
		return weeklyPainTrackerDesc.getText();
	}

	public boolean isWeeklyPainTrackerNoDataMessageVisible() {
		Logger.info("Verify if 'None recorded for this time period.' message is visible");
		return weeklyPainTrackerDescNoData.isVisible();
	}

	public String getWeeklyPainTrackerNoDataMessage() {
		Logger.info("Get no data message text");
		return weeklyPainTrackerDescNoData.getText();
	}

	public boolean isWeeklyPainTrackerGraphModuleVisible() {
		Logger.info("Verify if graph module is visible for weekly Pain Tracker");
		return weeklyPainTrackerGraphContainer.isVisible();
	}

	public boolean isWeeklyPainTrackerGraphVisible() {
		Logger.info("Verify if graph is visible for weekly Pain Tracker");
		return weeklyPainTrackerGraph.isVisible();
	}

	public boolean isWeeklyPainTrackerScoresModuleVisible() {
		Logger.info("Verify if scores module is visible for weekly Pain Tracker");
		return weeklyPainTrackerGraphScoresModule.isVisible();
	}

	public String getWeeklyPainTrackerDayScore(int dayNumber) {
		Logger.info("Get day score for day #" + dayNumber);
		String dayScore = weeklyPainTrackerGraphScore.getTextFromElementNumber(dayNumber);
		Logger.info("Day score - " + dayScore);
		return dayScore;
	}

	public boolean isWeeklyPainTrackerDaysModuleVisible() {
		Logger.info("Verify if days module is visible for weekly Pain Tracker");
		return weeklyPainTrackerGraphWeekDaysModule.isVisible();
	}

	public String getWeeklyDayColorAttribute(int dayNumber) {
		Logger.info("Get 'color' attribute value for day #" + dayNumber);
		return weeklyPainTrackerGraphWeekDay.getColorFromElementNumber(dayNumber);
	}

	public boolean isPainLocationsSummaryModuleVisible() {
		Logger.info("Verify if pain locations summary module is visible");
		return weeklyPainTrackerPainSummariesModule.isVisible();
	}

	public int getNumberOfPainLocationItems() {
		Logger.info("Get number of pain locations for week");
		return weeklyPainTrackerPainSummaryItem.getVisibleElementsCount();
	}

	public boolean isPainLocationItemVisible(String itemText) {
		Logger.info("Verify if summary module for pain location - " + itemText + " is visible");
		return weeklyPainTrackerPainSummaryLocationNameText.isElementWithTextVisible(itemText);
	}

	public String getPainLocationItemDaysCountText(String itemText) {
		Logger.info("Get pain location item - " + itemText + " days count data");
		return weeklyPainTrackerPainSummaryLocationDaysText.getTextFromElementWithText(itemText);
	}
}
