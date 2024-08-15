package mayoclinicdiet.pages;

import framework.Logger;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class MainFooter extends BasicPage {

	public MainFooter(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "footer";
		String CLASS_NAME = "MainFooter";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject footerSection;
	protected WebObject aboutUsLink;
	protected WebObject mayoClinicLink;
	protected WebObject feedbackLink;
	protected WebObject contactUsLink;
	protected WebObject termsOfUseLink;
	protected WebObject everydayHealthLogo;
	protected WebObject textContent;
	protected WebObject seeAdditionalInformationLink;
	protected WebObject termsOfUseSecondLink;
	protected WebObject privacyPolicyLink;
	protected WebObject siteMapHeaders;
	protected WebObject getStartedLinkSiteMap;
	protected WebObject smartFoodChoicesSiteMap;
	protected WebObject mealsMadeSiteMap;
	protected WebObject eatingOutSiteMap;
	protected WebObject recipeFinderSiteMap;
	protected WebObject dailyMealPlanSiteMap;
	protected WebObject weeklyMealPlanSiteMap;
	protected WebObject getStartedMoveSiteMap;
	protected WebObject healthyBodyBenefitsSiteMap;
	protected WebObject challengeYourselfSiteMap;
	protected WebObject fitnessTipsSiteMap;
	protected WebObject fitnessPlannerSiteMap;
	protected WebObject exerciseIndexSiteMap;
	protected WebObject mindAndBodySiteMap;
	protected WebObject obstaclesSiteMap;
	protected WebObject successStoriesSiteMap;
	protected WebObject supportSiteMap;
	protected WebObject foodAndFitnessJournalSiteMap;
	protected WebObject weightTrackerSiteMap;
	protected WebObject inchTrackerSiteMap;
	protected WebObject nutrientTrackerSiteMap;
	protected WebObject add5HabitsSiteMap;
	protected WebObject break5HabitsSiteMap;
	protected WebObject bonus5HabitsSiteMap;
	protected WebObject learningFromLoseItSiteMap;
	protected WebObject preparingToLiveItSiteMap;
	protected WebObject theExpertsSiteMap;
	protected WebObject faqsSiteMap;
	protected WebObject faqsSiteAndToolsSiteMap;

	public MainFooter checkFooterSectionPresent() {
		Logger.info("Check footer section is presented");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		boolean isFooterSectionPresent =
				footerSection
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isFooterSectionPresent, "Footer section is not present");
		return this;
	}

	public MainFooter checkAboutUsLinkPresent() {
		Logger.info("Check 'About us' link is presented");
		boolean isAboutUsLinkPresent =
				aboutUsLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isAboutUsLinkPresent, "'About us' link is not present");
		return this;
	}

	public MainFooter checkMayoClinicLinkPresent() {
		Logger.info("Check 'Mayo Clinic' link is presented");
		boolean isMayoClinicLinkPresent =
				mayoClinicLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMayoClinicLinkPresent, "'Mayo Clinic' link is not present");
		return this;
	}

	public MainFooter checkFeedbackLinkPresent() {
		Logger.info("Check 'Feedback' link is presented");
		boolean isFeedbackLinkPresent =
				feedbackLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isFeedbackLinkPresent, "'Feedback' link is not present");
		return this;
	}

	public MainFooter checkContactUsLinkPresent() {
		Logger.info("Check 'Contact us' link is presented");
		boolean isContactUsLinkPresent =
				contactUsLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isContactUsLinkPresent, "'Contact us' link is not present");
		return this;
	}

	public MainFooter checkTermsOfUseLinkPresent() {
		Logger.info("Check 'Terms of use' link is presented");
		boolean isTermsOfUseLinkPresent =
				termsOfUseLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isTermsOfUseLinkPresent, "'Terms of use' link is not present");
		return this;
	}

	public MainFooter checkEverydayHealthLogoPresent() {
		Logger.info("Check everyday health logo is presented");
		boolean isEverydayHealthLogoPresent =
				everydayHealthLogo
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isEverydayHealthLogoPresent, "Everyday health logo is not present");
		return this;
	}

	public MainFooter checkTextContentPresent() {
		Logger.info("Check text content is presented");
		boolean isTextContentPresent =
				textContent
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isTextContentPresent, "Text content is not present");
		return this;
	}

	public MainFooter checkSeeAdditionalInformationLinkPresent() {
		Logger.info("Check 'See Additional Information' link is presented");
		boolean isSeeAdditionalInformationLinkPresent =
				seeAdditionalInformationLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isSeeAdditionalInformationLinkPresent, "'See Additional Information' link is not present");
		return this;
	}

	public MainFooter checkTermsOfUseSecondLinkPresent() {
		Logger.info("Check 'Terms of use' second link is presented");
		boolean isTermsOfUseSecondLinkPresent =
				termsOfUseSecondLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isTermsOfUseSecondLinkPresent, "'Terms of use' second link is not present");
		return this;
	}

	public MainFooter checkPrivacyPolicyLinkPresent() {
		Logger.info("Check 'Privacy policy' link is presented");
		boolean isPrivacyPolicyLinkPresent =
				privacyPolicyLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isPrivacyPolicyLinkPresent, "'Privacy policy' link is not present");
		return this;
	}

	public MainFooter checkSireMapHeadersPresent() {
		Logger.info("Check site map headers is presented");
		boolean isSireMapHeadersPresent =
				siteMapHeaders
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isSireMapHeadersPresent, "Site map headers is not present");
		return this;
	}

	public MainFooter checkEatGetStartedLinkPresent() {
		Logger.info("Check 'Get Started' link in Eat menu is presented");
		boolean isEatGetStartedLinkPresent =
				getStartedLinkSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isEatGetStartedLinkPresent, "'Get Started' link in Eat menu is not present");
		return this;
	}

	public MainFooter checkSmartFoodChoicesLinkPresent() {
		Logger.info("Check 'Smart Food Choices' link is presented");
		boolean isSmartFoodChoicesLinkPresent =
				smartFoodChoicesSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isSmartFoodChoicesLinkPresent, "'Smart Food Choices' link is not present");
		return this;
	}

	public MainFooter checkMealsMadeEasyLinkPresent() {
		Logger.info("Check 'Meals Made Easy' link is presented");
		boolean isMealsMadeEasyLinkPresent =
				mealsMadeSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMealsMadeEasyLinkPresent, "'Smart Food Choices' link is not present");
		return this;
	}

	public MainFooter checkEatingOutLinkPresent() {
		Logger.info("Check 'Eating Out' link is presented");
		boolean isEatingOutLinkPresent =
				eatingOutSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isEatingOutLinkPresent, "'Eating Out' link is not present");
		return this;
	}

	public MainFooter checkRecipeFinderLinkPresent() {
		Logger.info("Check 'Recipe Finder' link is presented");
		boolean isRecipeFinderLinkPresent =
				recipeFinderSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isRecipeFinderLinkPresent, "'Recipe Finder' link is not present");
		return this;
	}

	public MainFooter checkDailyMealPlanLinkPresent() {
		Logger.info("Check 'Daily Meal Plan' link is presented");
		boolean isDailyMealPlanLinkPresent =
				dailyMealPlanSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isDailyMealPlanLinkPresent, "'Daily Meal Plan' link is not present");
		return this;
	}

	public MainFooter checkWeeklyMealPlanLinkPresent() {
		Logger.info("Check 'Weekly Meal Plan' link is presented");
		boolean isWeeklyMealPlanLinkPresent =
				weeklyMealPlanSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isWeeklyMealPlanLinkPresent, "'Weekly Meal Plan' link is not present");
		return this;
	}

	public MainFooter checkMoveGetStartedLinkPresent() {
		Logger.info("Check 'Get Started' link in Move menu is presented");
		boolean isMoveGetStartedLinkPresent =
				getStartedMoveSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMoveGetStartedLinkPresent, "'Get Started' link in Move menu is not present");
		return this;
	}

	public MainFooter checkHealthyBodyBenefitsLinkPresent() {
		Logger.info("Check 'Healthy Body Benefits' link is presented");
		boolean isHealthyBodyBenefitsLinkPresent =
				healthyBodyBenefitsSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isHealthyBodyBenefitsLinkPresent, "'Healthy Body Benefits' link is not present");
		return this;
	}

	public MainFooter checkChallengeYourselfLinkPresent() {
		Logger.info("Check 'Challenge Yourself' link is presented");
		boolean isChallengeYourselfLinkPresent =
				challengeYourselfSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isChallengeYourselfLinkPresent, "'Challenge Yourself' link is not present");
		return this;
	}

	public MainFooter checkFitnessTipsLinkPresent() {
		Logger.info("Check 'Fitness Tips' link is presented");
		boolean isFitnessTipsLinkPresent =
				fitnessTipsSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isFitnessTipsLinkPresent, "'Fitness Tips' link is not present");
		return this;
	}

	public MainFooter checkFitnessPlannerLinkPresent() {
		Logger.info("Check 'Fitness Planner' link is presented");
		boolean isFitnessPlannerLinkPresent =
				fitnessPlannerSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isFitnessPlannerLinkPresent, "'Fitness Planner' link is not present");
		return this;
	}

	public MainFooter checkExerciseIndexLinkPresent() {
		Logger.info("Check 'Exercise Index' link is presented");
		boolean isExerciseIndexLinkPresent =
				exerciseIndexSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isExerciseIndexLinkPresent, "'Exercise Index' link is not present");
		return this;
	}

	public MainFooter checkMindAndBodyLinkPresent() {
		Logger.info("Check 'Mind & Body' link is presented");
		boolean isMindAndBodyLinkPresent =
				mindAndBodySiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMindAndBodyLinkPresent, "'Mind & Body' link is not present");
		return this;
	}

	public MainFooter checkObstaclesLinkPresent() {
		Logger.info("Check 'Obstacles' link is presented");
		boolean isObstaclesLinkPresent =
				obstaclesSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isObstaclesLinkPresent, "'Obstacles' link is not present");
		return this;
	}

	public MainFooter checkSuccessStoriesLinkPresent() {
		Logger.info("Check 'Success Stories' link is presented");
		boolean isSuccessStoriesLinkPresent =
				successStoriesSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isSuccessStoriesLinkPresent, "'Success Stories' link is not present");
		return this;
	}

	public MainFooter checkSupportLinkPresent() {
		Logger.info("Check 'Support' link is presented");
		boolean isSupportLinkPresent =
				supportSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isSupportLinkPresent, "'Support' link is not present");
		return this;
	}

	public MainFooter checkFoodAndFitnessJournalLinkPresent() {
		Logger.info("Check 'Food & Fitness Journal' link is presented");
		boolean isFoodAndFitnessJournalLinkPresent =
				foodAndFitnessJournalSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isFoodAndFitnessJournalLinkPresent, "'Food & Fitness Journal' link is not present");
		return this;
	}

	public MainFooter checkWeightTrackerLinkPresent() {
		Logger.info("Check 'Weight Tracker' link is presented");
		boolean isWeightTrackerLinkPresent =
				weightTrackerSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isWeightTrackerLinkPresent, "'Weight Tracker' link is not present");
		return this;
	}

	public MainFooter checkInchTrackerLinkPresent() {
		Logger.info("Check 'Inch Tracker' link is presented");
		boolean isInchTrackerLinkPresent =
				inchTrackerSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isInchTrackerLinkPresent, "'Inch Tracker' link is not present");
		return this;
	}

	public MainFooter checkNutrientTrackerLinkPresent() {
		Logger.info("Check 'Nutrient Tracker' link is presented");
		boolean isNutrientTrackerLinkPresent =
				nutrientTrackerSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isNutrientTrackerLinkPresent, "'Nutrient Tracker' link is not present");
		return this;
	}

	public MainFooter checkAdd5HabitsLinkPresent() {
		Logger.info("Check 'Add 5 Habits' link is presented");
		boolean isAdd5HabitsLinkPresent =
				add5HabitsSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isAdd5HabitsLinkPresent, "'Add 5 Habits' link is not present");
		return this;
	}

	public MainFooter checkBreak5HabitsLinkPresent() {
		Logger.info("Check 'Break 5 Habits' link is presented");
		boolean isBreak5HabitsLinkPresent =
				break5HabitsSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isBreak5HabitsLinkPresent, "'Break 5 Habits' link is not present");
		return this;
	}

	public MainFooter checkBonus5HabitsLinkPresent() {
		Logger.info("Check 'Bonus 5 Habits' link is presented");
		boolean isBonus5HabitsLinkPresent =
				bonus5HabitsSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isBonus5HabitsLinkPresent, "'Bonus 5 Habits' link is not present");
		return this;
	}

	public MainFooter checkLearningFromLoseItLinkPresent() {
		Logger.info("Check 'Learning From Lose It' link is presented");
		boolean isLearningFromLoseItLinkPresent =
				learningFromLoseItSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isLearningFromLoseItLinkPresent, "'Learning From Lose It' link is not present");
		return this;
	}

	public MainFooter checkPreparingToLiveItLinkPresent() {
		Logger.info("Check 'Preparing To Live It' link is presented");
		boolean isPreparingToLiveItLinkPresent =
				preparingToLiveItSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isPreparingToLiveItLinkPresent, "'Preparing To Live It' link is not present");
		return this;
	}

	public MainFooter checkTheExpertsLinkPresent() {
		Logger.info("Check 'The Experts' link is presented");
		boolean isTheExpertsLinkPresent =
				theExpertsSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isTheExpertsLinkPresent, "'The Experts' link is not present");
		return this;
	}

	public MainFooter checkFAQsLinkPresent() {
		Logger.info("Check 'FAQs' link is presented");
		boolean isFAQsLinkPresent =
				faqsSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isFAQsLinkPresent, "'FAQs' link is not present");
		return this;
	}

	public MainFooter checkFAQsSiteAndToolsLinkPresent() {
		Logger.info("Check 'FAQs Site And Tools' link is presented");
		boolean isFAQsSiteAndToolsLinkPresent =
				faqsSiteAndToolsSiteMap
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isFAQsSiteAndToolsLinkPresent, "'FAQs Site And Tools' link is not present");
		return this;
	}

	@Override
	public void waitForPageToLoad() {
		footerSection.waitUntilVisible();
	}
}
