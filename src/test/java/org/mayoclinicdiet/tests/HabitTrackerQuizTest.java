package org.mayoclinicdiet.tests;


import com.testrail.framework.platform.annotations.TestRail;
import framework.platform.SiteNavigatorMCD;
import framework.platform.UserActionsMCD;
import mayoclinicdiet.pages.HomePage;
import org.testng.annotations.Test;

public class HabitTrackerQuizTest {
	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd", "C65540"})
	@TestRail(id = "C65540")
	public void quizPageIntroFlyout() {
		UserActionsMCD.registerNewUserQuiz()
				.checkHabitTrackerQuizDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65541")
	public void quizPageIntroLayout() {
		UserActionsMCD.registerNewUserQuiz()
				.checkHabitTrackerQuizHeader()
				.checkHabitTrackerQuizIntroTextDisplayed()
				.checkHabitTrackerQuizGetStartedButtonDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65542")
	public void getStartedButtonFunctionality() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.checkQuizOptionsContainerDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65543")
	public void quizPageDisplay() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.checkQuizQuestionHeaderDisplayed()
				.checkQuizQuestionDisplayed()
				.checkQuizOptionsContainerDisplayed()
				.checkQuizOptionsDisplayed()
				.oneAnswer()
				.checkCorrectAnswerDisplayed()
				.checkNextPreviousQuestionArrowsDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65544")
	public void quizPageOnclickAnswers() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.clickFirstAnswer()
				.checkCorrectAnswerBackground();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65545")
	public void quizPageOnclickAnswersWrongAnswer() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.clickFirstAnswer()
				.checkIncorrectAnswerBackground()
				.checkCorrectAnswerBackground();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65546")
	public void quizPageOnclickAnswersRightAnswer() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.clickCorrectAnswerForFirstQuestion()
				.checkCorrectAnswerBackground();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65547")
	public void quizPageSelectedAnswerCopyWrongAnswer() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.clickFirstAnswer()
				.checkSelectedFirstAnswerDisplayed()
				.checkCorrectAnswerDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65548")
	public void quizPageSelectedAnswerCopyRightAnswer() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.clickCorrectAnswerForFirstQuestion()
				.checkCorrectAnswerOnFirstQuestionDisplayed()
				.checkCorrectAnswerDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65549")
	public void nextQuestionButtonFunctionality() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.oneAnswer()
				.checkPreviousArrowDisabledDisplayed()
				.checkNextArrowEnabledDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65550")
	public void nextQuestionButtonOnclickFunctionality() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.oneAnswer()
				.clickNextArrow()
				.checkSecondQuestionDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65551")
	public void previousQuestionButtonOnclickFunctionality() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.oneAnswer()
				.clickNextArrow()
				.oneAnswer()
				.clickPreviousArrow()
				.checkFirstQuestionDisplayed()
				.checkCorrectAnswerDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65552")
	public void lastQuestionQuizPage() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.completeQuiz()
				.checkCorrectAnswerDisplayed()
				.checkSeeYourResultsButtonDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65553")
	public void showResultsButtonFunctionality() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.completeQuiz()
				.clickSeeYourResultsButton()
				.checkResultWindowDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65554")
	public void resultPagePopup() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.completeQuiz()
				.clickSeeYourResultsButton()
				.checkResultWindowHeaderDisplayed()
				.checkStartTrackingYourHabitsButtonDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65555")
	public void startTrackingYourHabitsButtonOnClick() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.completeQuiz()
				.clickSeeYourResultsButton()
				.clickStartTrackingYourHabitsButton()
				.checkHabitTrackerDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C118732")
	public void verifyButtonStartTrackingYourHabits() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.completeQuiz()
				.clickSeeYourResultsButton()
				.checkStartTrackingYourHabitsButtonText();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65556")
	public void quizLink() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.checkWhyYouShouldTrackYourHabitsLinkDisplayed()
				.checkWhyYouShouldTrackYourHabitsLinkCss();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65557")
	public void downloadPrintTheTrackerOnClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.checkPrintWeeklyTrackerPageLoading();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C65558")
	public void quizLinkOnClick() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickWhyYouShouldTrackYourHabitsLink()
				.checkHabitTrackerQuizIntroTextDisplayed();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65559")
	public void downloadPrintTheTracker() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.checkDownloadPrintTheTrackerDisplayedUnderFullProgressReport();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65560")
	public void formattingContinueToDayX() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.checkContinueToDayXButtonPosition();
	}

	@Test(groups = {"quiz", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C65458")
	public void xIconFunctionality() {
		UserActionsMCD.registerNewUserQuiz()
				.clickGetStartedButtonOnQuiz()
				.clickLetsGetStartedButtonOnLiveItPopUp()
				.checkHabitTrackerDisplayed();
	}
}
