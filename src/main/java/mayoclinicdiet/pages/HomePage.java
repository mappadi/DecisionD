package mayoclinicdiet.pages;

import framework.BrowserType;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage extends PublicHeaderMCD {

	protected WebObject habitHolderSection;
	protected WebObject practiceTheHabitsSection;
	protected WebObject inspirationCenterSection;
	protected WebObject welcomeText;
	protected WebObject liveItPopUp;
	protected WebObject closeLiveItPopUpIcon;
	protected WebObject phaseTitle;
	protected WebObject howIsYourDayGoingSection;
	protected WebObject weeklySpotlightEatingTriggersSection;
	protected WebObject healthyLivingSection;
	protected WebObject nextArrow;
	protected WebObject fullProgressReportLink;
	protected WebObject add5HabitsTab;
	protected WebObject daysNumber;
	protected WebObject habitsCheckbox;
	protected WebObject continueButton;
	protected WebObject quizPopup;
	protected WebObject quizHeader;
	protected WebObject quizIntroText;
	protected WebObject getStartedButton;
	protected WebObject quizOptionsContainer;
	protected WebObject quizQuestionHeader;
	protected WebObject quizQuestion;
	protected WebObject quizOptions;
	protected WebObject correctAnswerText;
	protected WebObject nextPreviousQuestionArrows;
	protected WebObject quizLetters;
	protected WebObject selectedAnswer;
	protected WebObject disabledPreviousArrow;
	protected WebObject enabledNextArrow;
	protected WebObject questionNumber;
	protected WebObject previousArrow;
	protected WebObject seeYourResultsButton;
	protected WebObject getStartedHereButton;
	protected WebObject resultWindow;
	protected WebObject resultWindowHeader;
	protected WebObject startTrackingYourHabits;
	protected WebObject whyYouShouldTrackYourHabitsLink;
	protected WebObject downloadPrintTheTrackerLink;
	protected WebObject habitTrackerFrame;
	protected WebObject downloadPrintTheTrackerDiv;
	protected WebObject continueToDayXContainer;
	protected WebObject break5HabitsTab;
	protected WebObject break5HabitsCheckbox;
	protected WebObject bonus5HabitsTab;
	protected WebObject bonus5HabitsCheckbox;
	protected WebObject checkPointAdd5Habits;
	protected WebObject checkPointBreak5Habits;
	protected WebObject checkPointBonus5Habits;
	protected WebObject letsGetStartedButtonInPopup;
	protected WebObject popUpCloseButton;
	protected WebObject trackerContent;

	public HomePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "home";
		String CLASS_NAME = "HomePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	public HomePage checkLoseItPopUpDisplayed() {
		Logger.info("Check 'Lose It' pop up is displayed on the Home page");
		liveItPopUp.waitUntilElementIsVisible();
		assertTrue(liveItPopUp.isVisible(), "'Lose It' pop up is not displayed on the Home page");
		return this;
	}

	public HomePage checkHabitTrackerDisplayed() {
		Logger.info("Check Habit tracker section is displayed on the Home page");
		habitHolderSection.waitUntilVisible();
		assertTrue(habitHolderSection.isVisible(), "Habit tracker section is not displayed on the Home page");
		return this;
	}

	public HomePage checkPracticeTheHabitsSectionDisplayed() {
		Logger.info("Check Practice the habits section is displayed on the Home page");
		assertTrue(practiceTheHabitsSection.isVisible(), "Practice the habits section is not displayed on the Home page");
		return this;
	}

	public HomePage checkInspirationCenterSectionDisplayed() {
		Logger.info("Check Inspiration center section is displayed on the Home page");
		assertTrue(inspirationCenterSection.isVisible(), "Inspiration center section is not displayed on the Home page");
		return this;
	}

	public HomePage checkWelcomeTextDisplayed() {
		Logger.info("Check welcome text is displayed on the Home page");
		welcomeText.waitUntilVisible();
		assertTrue(welcomeText.isVisible(), "Welcome text is not displayed on the Home page");
		return this;
	}

	public HomePage checkLoseItPageLoading() {
		Logger.info("Check 'lose it' page loading");
		String currentURL = basedriver.
				getCurrentUrl();
		assertTrue(currentURL.contains("loseit"), "Lose It page was not loaded");
		return this;
	}

	public HomePage checkLiveItPageLoading() {
		Logger.info("Check 'live it' page loading");
		String currentURL = basedriver.
				getCurrentUrl();
		assertTrue(currentURL.contains("liveit"), "Live It page was not loaded");
		return this;
	}

	public HomePage checkLiveItPopUpDisplayed() {
		Logger.info("Check 'Live It' pop up is displayed on the Home page");
		liveItPopUp.waitUntilVisible();
		assertTrue(liveItPopUp.isVisible(), "'Live It' pop up is not displayed on the Home page");
		return this;
	}

	public HomePage clickLetsGetStartedButtonOnLiveItPopUp() {
		Logger.info("Click 'Let's get started' button on Live It popup");
		if (liveItPopUp.isVisible()) {
			if (letsGetStartedButtonInPopup.isVisible()) {
				letsGetStartedButtonInPopup.click();
			} else {
				closePopupButton();
			}
		}
		return this;
	}

	public HomePage checkIfCurrentPhaseIsLoseIt() {
		if (phaseTitle.getText().contains("Lose It!")) {
			clickLetsGetStartedButtonOnLiveItPopUp();
		} else {
			clickOnSettingLink()
					.clickLoseItRadioButton()
					.clickSaveChangesButton()
					.clickOnHomeLink()
					.clickLetsGetStartedButtonOnLiveItPopUp();
			if (liveItPopUp.isVisible()) {
				clickLetsGetStartedButtonOnLiveItPopUp();
			}
		}
		return this;
	}

	public HomePage checkIfCurrentPhaseIsLiveIt() {
		waitForAjaxRequestToBeFinished();
		if (phaseTitle.getText().contains("Live It!")) {
			clickLetsGetStartedButtonOnLiveItPopUp();
		} else {
			clickOnSettingLink()
					.clickLiveItRadioButton()
					.clickSaveChangesButton()
					.clickOnHomeLink();
			clickLetsGetStartedButtonOnLiveItPopUp();
		}
		return this;
	}

	public HomePage checkHowIsYourDayGoingSectionDisplayed() {
		Logger.info("Check 'How Is Your Day Going?' section is displayed on the Home page");
		assertTrue(howIsYourDayGoingSection.isVisible(), "'How Is Your Day Going?' section is not displayed on the Home page");
		return this;
	}

	public HomePage checkWeeklySpotlightEatingTriggersSectionDisplayed() {
		Logger.info("Check 'Weekly Spotlight: Eating Triggers' section is displayed on the Home page");
		assertTrue(weeklySpotlightEatingTriggersSection.isVisible(), "'Weekly Spotlight: Eating Triggers' section is not displayed on the Home page");
		return this;
	}

	public HomePage checkHealthyLivingSectionDisplayed() {
		Logger.info("Check 'Healthy Living' section is displayed on the Home page");
		assertTrue(healthyLivingSection.isVisible(), "'Healthy Living' section is not displayed on the Home page");
		return this;
	}

	public HomePage clickGetStartedButtonOnQuiz() {
		Logger.info("Click 'Get Started' button on popup");
		switchToDefaultContent();
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1786");
		getStartedButton.waitUntilVisible();
		getStartedButton.click();
		return this;
	}

	public HomePage clickNextArrow() {
		Logger.info("Click next arrow on Quiz popup");
		waitFor(1000);
		nextArrow.longClickWebObject();
		return this;
	}

	public HomePage clickPreviousArrow() {
		Logger.info("Click next arrow on Quiz popup");
		waitFor(1000);
		previousArrow.click();
		return this;
	}

	public HomePage completeQuiz() {
		Logger.info("Click random answer on Quiz popup");
		Random r = new java.util.Random();
		for (int i = 1; i <= 12; i++) {
			waitFor(1000);
			quizLetters.longClickWebElement(r.nextInt(quizLetters.getElementsCount()));
			clickNextArrow();
		}
		waitFor(1000);
		quizLetters.longClickWebElement(r.nextInt(quizLetters.getElementsCount()));
		return this;
	}

	public HomePage clickSeeYourResultsButton() {
		Logger.info("Click 'See Your Results' button on Quiz popup");
		seeYourResultsButton.waitUntilClickable();
		seeYourResultsButton.click();
		return this;
	}

	public HomePage clickGetStartedHereButton() {
		Logger.info("Click 'Get Started here' button on Quiz popup");
		getStartedHereButton.waitUntilClickable();
		getStartedHereButton.click();
		return this;
	}

	public HomePage closePopupButton() {
		Logger.info("Click close button on Quiz popup");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1786");
		closeLiveItPopUpIcon.click();
		return this;
	}

	public HabitTrackerAnalysisPage clickFullProgressReportLink() {
		Logger.info("Click 'Full Progress Report' link");
		habitTrackerFrame.waitUntilVisible();
		switchToFrame(habitTrackerFrame);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1667");
		fullProgressReportLink.longClickWebObject();
		waitForAjaxRequestToBeFinished();
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		return PageFactory.initElements(basedriver, HabitTrackerAnalysisPage.class);
	}

	public HabitTrackerAnalysisPage clickFullProgressReportLinkOnHabitTracker() {
		Logger.info("Click 'Full Progress Report' link");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1667");
		fullProgressReportLink.waitUntilClickable();
		fullProgressReportLink.longClickWebObject();
		return PageFactory.initElements(basedriver, HabitTrackerAnalysisPage.class);
	}

	public <T> T clickFullProgressReportLink(Class<T> expectedPage) {
		Logger.info("Click 'Full Progress Report' link");
		switchToFrame(habitTrackerFrame);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1667");
		fullProgressReportLink
				.waitUntilVisible()
				.then()
				.click();
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public HomePage checkHabitTrackerQuizDisplayed() {
		Logger.info("Check habit tracker quiz is displayed on the Home page");
		switchToDefaultContent();
		quizPopup.waitUntilVisible();
		assertTrue(quizPopup.isVisible(), "Habit tracker quiz is not displayed on the Home page");
		return this;
	}

	public HomePage checkHabitTrackerQuizHeader() {
		Logger.info("Check habit tracker quiz header text");
		switchToDefaultContent();
		quizHeader.waitUntilVisible();
		assertEquals(quizHeader.getText(), "Why you should track your habits", "Habit tracker quiz header is not correct");
		return this;
	}

	public HomePage checkHabitTrackerQuizIntroTextDisplayed() {
		Logger.info("Check intro text is displayed on the habit tracker quiz");
		switchToDefaultContent();
		assertTrue(quizIntroText.isVisible(), "intro text is not displayed on the Habit tracker quiz ");
		return this;
	}

	public HomePage checkHabitTrackerQuizGetStartedButtonDisplayed() {
		Logger.info("Check 'Get Started' button is displayed on the habit tracker quiz");
		assertTrue(getStartedButton.isVisible(), "'Get Started' button is not displayed on the habit tracker quiz");
		return this;
	}

	public HomePage checkQuizOptionsContainerDisplayed() {
		Logger.info("Check quiz Options are displayed on the habit tracker quiz");
		quizOptionsContainer.waitUntilVisible();
		assertTrue(quizOptionsContainer.isVisible(), "Quiz Options are not displayed on the habit tracker quiz");
		return this;
	}

	public HomePage checkQuizQuestionHeaderDisplayed() {
		Logger.info("Check question header is displayed on the habit tracker quiz");
		quizQuestionHeader.waitUntilVisible();
		assertTrue(quizQuestionHeader.isVisible(), "question header is not displayed on the habit tracker quiz");
		return this;
	}

	public HomePage checkQuizQuestionDisplayed() {
		Logger.info("Check question is displayed on the habit tracker quiz");
		assertTrue(quizQuestion.isVisible(), "question is not displayed on the habit tracker quiz");
		return this;
	}

	public HomePage checkQuizOptionsDisplayed() {
		Logger.info("Check options are displayed on the habit tracker quiz");
		assertTrue(quizOptions.isVisible(), "options are not displayed on the habit tracker quiz");
		return this;
	}

	public HomePage oneAnswer() {
		Logger.info("Choose option on Quiz popup");
		Random r = new java.util.Random();
		waitFor(1000);
		quizLetters.longClickWebElement(r.nextInt(quizLetters.getElementsCount()));
		return this;
	}

	public HomePage checkCorrectAnswerDisplayed() {
		Logger.info("Check correct answer is displayed on the habit tracker quiz");
		correctAnswerText.waitUntilVisible();
		assertTrue(correctAnswerText.isVisible(), "correct answer is not displayed on the habit tracker quiz");
		return this;
	}

	public HomePage checkNextPreviousQuestionArrowsDisplayed() {
		Logger.info("Check Next/Previous Question Arrows are displayed on the habit tracker quiz");
		assertTrue(nextPreviousQuestionArrows.isVisible(), "Next/Previous Question Arrows are not displayed on the habit tracker quiz");
		return this;
	}

	public HomePage checkIncorrectAnswerBackground() {
		Logger.info("Check incorrect answer background");
		String backgroundColor = quizLetters.getElements().get(0)
				.getCssValue("background-color");
		assertEquals(backgroundColor, "rgba(254, 80, 0, 1)", "The background-color of chosen answer is not correspond to mock-up");
		return this;
	}

	public HomePage checkCorrectAnswerBackground() {
		Logger.info("Check correct answer background");
		String backgroundColor = quizLetters.getElements().get(2)
				.getCssValue("background-color");
		assertEquals(backgroundColor, "rgba(5, 193, 45, 1)", "The background-color of correct answer is not correspond to mock-up");
		return this;
	}

	public HomePage clickFirstAnswer() {
		Logger.info("Click first answer");
		waitFor(1000);
		quizOptions.clickOnElementNumber(1);
		return this;
	}

	public HomePage clickCorrectAnswerForFirstQuestion() {
		Logger.info("Click correct answer for first question");
		waitFor(1000);
		quizOptions.clickOnElementNumber(3);
		return this;
	}

	public HomePage checkSelectedFirstAnswerDisplayed() {
		Logger.info("Check selected first answer is displayed on the habit tracker quiz");
		boolean isSelectedAnswerDisplayed =
				selectedAnswer
						.getElements()
						.get(0)
						.isDisplayed();
		assertTrue(isSelectedAnswerDisplayed, "Selected first answer is not displayed on the habit tracker quiz");
		return this;
	}

	public HomePage checkCorrectAnswerOnFirstQuestionDisplayed() {
		Logger.info("Check correct answer for first question is displayed on the habit tracker quiz");
		boolean isSelectedAnswerDisplayed =
				selectedAnswer
						.getElements()
						.get(2)
						.isDisplayed();
		assertTrue(isSelectedAnswerDisplayed, "Correct answer for first question is not displayed on the habit tracker quiz");
		return this;
	}

	public HomePage checkPreviousArrowDisabledDisplayed() {
		Logger.info("Check previous arrow is disabled on first question");
		disabledPreviousArrow.waitUntilVisible();
		assertTrue(disabledPreviousArrow.isVisible(), "Previous arrow is not disabled on first question");
		return this;
	}

	public HomePage checkNextArrowEnabledDisplayed() {
		Logger.info("Check next arrow is enabled on first question");
		assertTrue(enabledNextArrow.isVisible(), "Next arrow is not enabled on first question");
		return this;
	}

	public HomePage checkSecondQuestionDisplayed() {
		Logger.info("Check second question is displayed");
		waitFor(1000);
		boolean isSecondQuestionDisplayed =
				questionNumber
						.getText()
						.contains("Question 2");
		assertTrue(isSecondQuestionDisplayed, "Second question is not displayed");
		return this;
	}

	public HomePage checkFirstQuestionDisplayed() {
		Logger.info("Check First question is displayed");
		waitFor(1000);
		boolean isFirstQuestionDisplayed =
				questionNumber
						.getText()
						.contains("Question 1");
		assertTrue(isFirstQuestionDisplayed, "First question is not displayed");
		return this;
	}

	public HomePage checkSeeYourResultsButtonDisplayed() {
		Logger.info("Check 'See Your Results' button is displayed");
		assertTrue(seeYourResultsButton.isVisible(), "'See Your Results' button is not displayed");
		return this;
	}

	public HomePage checkResultWindowDisplayed() {
		Logger.info("Check result window is displayed");
		resultWindow.waitUntilVisible();
		assertTrue(resultWindow.isVisible(), "Result window is not displayed");
		return this;
	}

	public HomePage checkResultWindowHeaderDisplayed() {
		Logger.info("Check result window header is displayed");
		resultWindow.waitUntilVisible();
		assertTrue(resultWindowHeader.isVisible(), "Result window header is not displayed");
		return this;
	}

	public HomePage checkStartTrackingYourHabitsButtonDisplayed() {
		Logger.info("Check 'Start Tracking Your Habits' button is displayed");
		assertTrue(startTrackingYourHabits.isVisible(), "'Start Tracking Your Habits' button is not displayed");
		return this;
	}

	public HomePage clickStartTrackingYourHabitsButton() {
		Logger.info("Click 'Start Tracking Your Habits' button");
		startTrackingYourHabits.waitUntilVisible();
		startTrackingYourHabits.click();
		return this;
	}

	public HomePage checkStartTrackingYourHabitsButtonText() {
		Logger.info("Check 'Start Tracking Your Habits' button text is correct");
		startTrackingYourHabits.waitUntilVisible();
		assertEquals(startTrackingYourHabits.getText(), "START TRACKING YOUR HABITS", "'Start Tracking Your Habits' button text is not correct");
		return this;
	}

	public HomePage checkWhyYouShouldTrackYourHabitsLinkDisplayed() {
		Logger.info("Check 'Why You Should Track Your Habits' link is displayed");
		switchToFrame(habitTrackerFrame);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1667");
		assertTrue(whyYouShouldTrackYourHabitsLink.isVisible(), "'Why You Should Track Your Habits' link is not displayed");
		return this;
	}

	public HomePage checkWhyYouShouldTrackYourHabitsLinkCss() {
		Logger.info("Check 'Why You Should Track Your Habits' link font colour");
		String textWhyYouShouldTrackYourHabitsLink = whyYouShouldTrackYourHabitsLink
				.getCssValue("color");
		assertEquals(textWhyYouShouldTrackYourHabitsLink, "rgba(254, 80, 0, 1)", "The font colour of the 'Why You Should Track Your Habits' link doesn't correspond to mock-up");

		Logger.info("Check 'Why You Should Track Your Habits' link font weight");
		String fontWeightWhyYouShouldTrackYourHabitsLink = whyYouShouldTrackYourHabitsLink
				.getCssValue("font-weight");
		if (Settings.browser.equals(BrowserType.CHROME)) {
			assertEquals(fontWeightWhyYouShouldTrackYourHabitsLink, "bold", "'Why You Should Track Your Habits' link font-weight doesn't correspond to mock-up");
		} else {
			assertEquals(fontWeightWhyYouShouldTrackYourHabitsLink, "700", "'Why You Should Track Your Habits' link font-weight doesn't correspond to mock-up");
		}
		return this;
	}

	public HomePage checkPrintWeeklyTrackerPageLoading() {
		Logger.info("Check print weekly tracker page loading");
		switchToFrame(habitTrackerFrame);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1667");
		downloadPrintTheTrackerLink.waitUntilVisible();
		assertEquals(downloadPrintTheTrackerLink.getAttribute("href"), "http://content.everydayhealth.com/habittracker/292/habit-tracker-web.pdf", "'Download/Print The Tracker' Link isn't loading a new page to print weekly tracker");
		return this;
	}

	public HomePage clickWhyYouShouldTrackYourHabitsLink() {
		Logger.info("Click 'Why You Should Track Your Habits' link");
		switchToFrame(habitTrackerFrame);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1667");
		whyYouShouldTrackYourHabitsLink.click();
		return this;
	}

	public HomePage checkDownloadPrintTheTrackerDisplayedUnderFullProgressReport() {
		Logger.info("Check 'Download Print The Tracker' link is displayed under 'Full Progress Report' link");
		switchToFrame(habitTrackerFrame);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1667");
		boolean isDownloadPrintTheTrackerDisplayedUnderFullProgressReport =
				downloadPrintTheTrackerDiv
						.getText()
						.contains("DOWNLOAD/PRINT THE TRACKER");
		assertTrue(isDownloadPrintTheTrackerDisplayedUnderFullProgressReport, "'Download Print The Tracker' link is not displayed under 'Full Progress Report' link");
		return this;
	}

	public HomePage checkContinueToDayXButtonPosition() {
		Logger.info("Check 'Continue To Day X' button position");
		switchToFrame(habitTrackerFrame);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1667");
		continueToDayXContainer.waitUntilVisible();
		String positionContinueToDayXButton = continueToDayXContainer
				.getCssValue("float");
		assertEquals(positionContinueToDayXButton, "right", "'Continue To Day X' button position doesn't correspond to mock-up");
		return this;
	}

	public HomePage clickOnDayAndHabit(int elNumber) {
		Logger.info("Click on habit checkbox for 14 days for Add 5 Habits section");
		String buttonTxt = "";
		switchToFrame(habitTrackerFrame);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1667");
		daysNumber
				.getElements()
				.parallelStream()
				.findFirst()
				.get()
				.click();
		for (int i = 1; i < 14; i++) {
			if (continueButton.isVisible()) {
				buttonTxt = continueButton.getText();
			}
			add5HabitsTab.longClickWebObject();
			clickOnElement2IfElement1isNotDisplayed(checkPointAdd5Habits, habitsCheckbox, elNumber);
			while (continueButton.isVisible() && buttonTxt.equals(continueButton.getText())) {
				continueButton
						.waitUntilVisible()
						.click();
				waitFor(2000);
			}
		}
		add5HabitsTab
				.waitUntilVisible()
				.click();
		clickOnElement2IfElement1isNotDisplayed(checkPointAdd5Habits, habitsCheckbox, elNumber);
		return this;
	}

	public HomePage clickOnDayAndHabitToRemove(int elNumber) {
		Logger.info("Click on habit checkbox for 14 days for Add 5 Habits section");
		String buttonTxt = "";
		switchToFrame(habitTrackerFrame);
		daysNumber
				.getElements()
				.parallelStream()
				.findFirst()
				.get()
				.click();
		for (int i = 0; i < 13; i++) {
			add5HabitsTab.longClickWebObject();
			if (continueButton.isVisible()) {
				buttonTxt = continueButton.getText();
			}
			clickOnElement2IfElement1isDisplayed(checkPointAdd5Habits, habitsCheckbox, elNumber);
			while (continueButton.isVisible() && buttonTxt.equals(continueButton.getText())) {
				continueButton
						.waitUntilVisible()
						.click();
				waitFor(2000);
			}
		}
		add5HabitsTab
				.waitUntilVisible()
				.click();
		clickOnElement2IfElement1isDisplayed(checkPointAdd5Habits, habitsCheckbox, elNumber);
		return this;
	}

	public HomePage clickOnDayAndHabitBreak5Habits(int elNumber) {
		Logger.info("Click on habit checkbox for 14 days for Break 5 Habits section");
		String buttonTxt = "";
		switchToFrame(habitTrackerFrame);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1667");
		daysNumber
				.getElements()
				.parallelStream()
				.findFirst()
				.get()
				.click();
		for (int i = 1; i < 14; i++) {
			break5HabitsTab.longClickWebObject();
			if (continueButton.isVisible()) {
				buttonTxt = continueButton.getText();
			}
			clickOnElement2IfElement1isNotDisplayed(checkPointBreak5Habits, break5HabitsCheckbox, elNumber);
			while (continueButton.isVisible() && buttonTxt.equals(continueButton.getText())) {
				continueButton
						.waitUntilVisible()
						.click();
				waitFor(2000);
			}
		}
		break5HabitsTab
				.waitUntilVisible()
				.click();
		clickOnElement2IfElement1isNotDisplayed(checkPointBreak5Habits, break5HabitsCheckbox, elNumber);
		return this;
	}

	public HomePage clickOnDayAndHabitBreak5HabitsToRemove(int elNumber) {
		Logger.info("Click on habit checkbox for 14 days for Break 5 Habits section");
		String buttonTxt = "";
		switchToFrame(habitTrackerFrame);
		daysNumber
				.getElements()
				.parallelStream()
				.findFirst()
				.get()
				.click();
		for (int i = 0; i < 13; i++) {
			break5HabitsTab.longClickWebObject();
			if (continueButton.isVisible()) {
				buttonTxt = continueButton.getText();
			}
			clickOnElement2IfElement1isDisplayed(checkPointBreak5Habits, break5HabitsCheckbox, elNumber);
			while (continueButton.isVisible() && buttonTxt.equals(continueButton.getText())) {
				continueButton
						.waitUntilVisible()
						.click();
				waitFor(2000);
			}
		}
		break5HabitsTab
				.waitUntilVisible()
				.click();
		clickOnElement2IfElement1isDisplayed(checkPointBreak5Habits, break5HabitsCheckbox, elNumber);
		return this;
	}

	public HomePage clickOnDayAndHabitBonus5Habits(int elNumber) {
		Logger.info("Click on habit checkbox for 14 days for Bonus 5 Habits section");
		String buttonTxt = "";
		switchToFrame(habitTrackerFrame);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1667");
		daysNumber
				.getElements()
				.parallelStream()
				.findFirst()
				.get()
				.click();
		for (int i = 0; i < 13; i++) {
			bonus5HabitsTab.longClickWebObject();
			if (continueButton.isVisible()) {
				buttonTxt = continueButton.getText();
			}
			clickOnElement2IfElement1isNotDisplayed(checkPointBonus5Habits, bonus5HabitsCheckbox, elNumber);
			while (continueButton.isVisible() && buttonTxt.equals(continueButton.getText())) {
				continueButton
						.waitUntilVisible()
						.click();
				waitFor(2000);
			}
		}
		bonus5HabitsTab
				.waitUntilVisible()
				.click();
		clickOnElement2IfElement1isNotDisplayed(checkPointBonus5Habits, bonus5HabitsCheckbox, elNumber);
		return this;
	}

	public HomePage clickOnDayAndHabitBonus5HabitsToRemove(int elNumber) {
		Logger.info("Click on habit checkbox for 14 days for Bonus 5 Habits section");
		String buttonTxt = "";
		switchToFrame(habitTrackerFrame);
		daysNumber
				.getElements()
				.parallelStream()
				.findFirst()
				.get()
				.click();
		for (int i = 0; i < 13; i++) {
			bonus5HabitsTab.longClickWebObject();
			if (continueButton.isVisible()) {
				buttonTxt = continueButton.getText();
			}
			clickOnElement2IfElement1isDisplayed(checkPointBonus5Habits, bonus5HabitsCheckbox, elNumber);
			while (continueButton.isVisible() && buttonTxt.equals(continueButton.getText())) {
				continueButton
						.waitUntilVisible()
						.click();
				waitFor(2000);
			}
		}
		bonus5HabitsTab
				.waitUntilVisible()
				.click();
		clickOnElement2IfElement1isDisplayed(checkPointBonus5Habits, bonus5HabitsCheckbox, elNumber);
		return this;
	}

	public HomePage clickOnElement2IfElement1isNotDisplayed(WebObject checkpoint, WebObject checkbox, int elNumber) {
		if (!checkpoint.getElements().get(elNumber).isDisplayed()) {
			checkbox
					.clickOnElementNumber(elNumber + 1);
		}
		return this;
	}

	public HomePage clickOnElement2IfElement1isDisplayed(WebObject checkpoint, WebObject checkbox, int elNumber) {
		if (checkpoint.getElements().get(elNumber).isDisplayed()) {
			checkbox
					.clickOnElementNumber(elNumber + 1);
		}
		return this;
	}

	public HomePage clickCloseButtonOnPopUp() {
		Logger.info("Click 'Close' (X) button on pop up window");
		if (popUpCloseButton.isVisible()) {
			popUpCloseButton.click();
			waitForAjaxRequestToBeFinished();
		}
		return this;
	}

	public boolean isTrackerContentVisible() {
		Logger.info("Verify if tracker content is visible");
		return trackerContent.isVisible();
	}
}
