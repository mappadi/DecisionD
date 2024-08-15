package mayoclinicdiet.pages;

import framework.BrowserType;
import framework.Logger;
import framework.Settings;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class PublicHeaderMCD extends BasicPage {

	public PublicHeaderMCD(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "header";
		String CLASS_NAME = "MainHeader";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject logOutHeader;
	protected WebObject trackLink;
	protected WebObject homeLink;
	protected WebObject eatLink;
	protected WebObject moveLink;
	protected WebObject motivateLink;
	protected WebObject recipeFinderMenuLink;
	protected WebObject dailyMealPlanMenuLink;
	protected WebObject weeklyMealPlanMenuLink;
	protected WebObject getStartedLinkSiteMap;
	protected WebObject smartFoodChoicesSiteMap;
	protected WebObject mealsMadeSiteMap;
	protected WebObject eatingOutSiteMap;
	protected WebObject recipeFinderSiteMap;
	protected WebObject dailyMealPlanSiteMap;
	protected WebObject weeklyMealPlanSiteMap;
	protected WebObject fitnessPlannerMenuLink;
	protected WebObject exerciseIndexMenuLink;
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
	protected WebObject globalHeader;
	protected WebObject mainLogo;
	protected WebObject navigationBar;
	protected WebObject aboutTheDietLink;
	protected WebObject settingsLink;
	protected WebObject faqsLink;
	protected WebObject siteAndToolsLink;
	protected WebObject eatingOutMenuLink;
	protected WebObject mealsMadeMenuLink;
	protected WebObject smartFoodChoicesMenuLink;
	protected WebObject getStartedMenuLink;

	public LogoutPage clickLogOutHeader() {
		Logger.info("Click 'Log Out' link");
		if (Settings.browser.equals(BrowserType.IE)) {
			WebDriverWait wait = new WebDriverWait(basedriver, 30);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logOut_header a")));
			element.click();
		} else {
			logOutHeader
					.waitUntilVisible()
					.then()
					.click();
		}
		return PageFactory.initElements(basedriver, LogoutPage.class);
	}

	public PublicHeaderMCD checkLogoutHeaderPresent() {
		Logger.info("Check 'Log Out' header is presented");
		boolean isLogoutLinkPresent =
				logOutHeader
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isLogoutLinkPresent, "'Logout' link is not present");
		return this;
	}

	public FoodAndFitnessJournalPage clickOnTrackLink() {
		Logger.info("Click 'Track' link");
		trackLink.clickWithJS();
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(basedriver, FoodAndFitnessJournalPage.class);
	}

	public ProfileSettingsPage clickOnSettingLink() {
		Logger.info("Click on Setting link");
		settingsLink.clickWithJS();
		return PageFactory.initElements(basedriver, ProfileSettingsPage.class);
	}

	public EatPage clickEatLink() {
		Logger.info("Click on Eat link");
		eatLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, EatPage.class);
	}

	public MovePage clickMoveLink() {
		Logger.info("Click on Eat link");
		moveLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MovePage.class);
	}

	public MotivatePage clickMotivateLink() {
		Logger.info("Click on Eat link");
		motivateLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MotivatePage.class);
	}

	public HomePage clickOnHomeLink() {
		Logger.info("Click on Home link");
		homeLink.clickWithJS();
		return PageFactory.initElements(basedriver, HomePage.class);
	}

	public EatGetStartedPage clickGetStartedMenuLink() {
		Logger.info("Click on the Get Started menu under EAT");
		eatLink.mouseHover();
		getStartedMenuLink.waitUntilClickable();
		getStartedMenuLink.click();
		return PageFactory.initElements(basedriver, EatGetStartedPage.class);
	}

	public EatSmartFoodChoicesPage clickSmartFoodChoicesMenuLink() {
		Logger.info("Click on the Smart Food Choices menu under EAT");
		eatLink.mouseHover();
		smartFoodChoicesMenuLink.waitUntilClickable();
		smartFoodChoicesMenuLink.click();
		return PageFactory.initElements(basedriver, EatSmartFoodChoicesPage.class);
	}

	public EatMealsMadeEasyPage clickMealsMadeEasyMenuLink() {
		Logger.info("Click on the Meals Made Easy menu under EAT");
		eatLink.mouseHover();
		mealsMadeMenuLink.waitUntilClickable();
		mealsMadeMenuLink.click();
		return PageFactory.initElements(basedriver, EatMealsMadeEasyPage.class);
	}

	public EatingOutPage clickEatingOutMenuLink() {
		Logger.info("Click on the Eating Out menu under EAT");
		eatLink.mouseHover();
		eatingOutMenuLink.waitUntilClickable();
		eatingOutMenuLink.click();
		return PageFactory.initElements(basedriver, EatingOutPage.class);
	}

	public RecipeSearchPage clickRecipeFinderMenuLink() {
		Logger.info("Click on the Recipe Finder menu under EAT");
		eatLink.mouseHover();
		recipeFinderMenuLink.waitUntilClickable();
		recipeFinderMenuLink.click();
		return PageFactory.initElements(basedriver, RecipeSearchPage.class);
	}

	public DailyMealPlannerPage clickDailyMealPlanMenuLink() {
		Logger.info("Click on the Daily Meal Plan menu under EAT");
		eatLink.mouseHover();
		waitForAjaxRequestToBeFinished();
		dailyMealPlanMenuLink.waitUntilClickable();
		dailyMealPlanMenuLink.click();
		return PageFactory.initElements(basedriver, DailyMealPlannerPage.class);
	}

	public WeeklyMealPlannerPage clickWeeklyMealPlanMenuLink() {
		Logger.info("Click on the Weekly Meal Plan menu under EAT");
		eatLink.mouseHover();
		weeklyMealPlanMenuLink.waitUntilClickable();
		weeklyMealPlanMenuLink.click();
		return PageFactory.initElements(basedriver, WeeklyMealPlannerPage.class);
	}

	public EatGetStartedPage clickGetStartedSiteMap() {
		Logger.info("Click on the EAT Get Started menu in the Site Map");
		getStartedLinkSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, EatGetStartedPage.class);
	}

	public EatSmartFoodChoicesPage clickSmartFoodChoicesSiteMap() {
		Logger.info("Click on the Smart Food Choices menu in the Site Map");
		smartFoodChoicesSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, EatSmartFoodChoicesPage.class);
	}

	public EatMealsMadeEasyPage clickMealsMadeEasySiteMap() {
		Logger.info("Click on the Meals Made Easy menu in the Site Map");
		mealsMadeSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, EatMealsMadeEasyPage.class);
	}

	public EatingOutPage clickEatingOutSiteMap() {
		Logger.info("Click on the Eating Out menu in the Site Map");
		eatingOutSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, EatingOutPage.class);
	}

	public RecipeSearchPage clickRecipeFinderSiteMap() {
		Logger.info("Click on the Recipe Finder in the Site Map");
		recipeFinderSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, RecipeSearchPage.class);
	}

	public DailyMealPlannerPage clickDailyMealPlanSiteMap() {
		Logger.info("Click on the Daily Meal Plan in the Site Map");
		dailyMealPlanSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, DailyMealPlannerPage.class);
	}

	public WeeklyMealPlannerPage clickWeeklyMealPlanSiteMap() {
		Logger.info("Click on the Weekly Meal Plan in the Site Map");
		weeklyMealPlanSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, WeeklyMealPlannerPage.class);
	}

	public MoveGetStartedPage clickGetStartedMoveMenuLink() {
		Logger.info("Click on the Get Started menu under MOVE");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement moveMenu = basedriver.findElement(By.cssSelector(".body1>a[href='/diet/members/move']"));
		withActions().moveToElement(moveMenu).build().perform();
		WebDriverWait wait = new WebDriverWait(basedriver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".subnav a[href='/diet/members/move/get-started']")));
		element.click();
		return PageFactory.initElements(basedriver, MoveGetStartedPage.class);
	}

	public MoveHealthyBodyBenefitsPage clickHealthyBodyBenefitsMenuLink() {
		Logger.info("Click on the Healthy Body Benefits menu under MOVE");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement moveMenu = basedriver.findElement(By.cssSelector(".body1>a[href='/diet/members/move']"));
		withActions().moveToElement(moveMenu).build().perform();
		WebDriverWait wait = new WebDriverWait(basedriver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".subnav a[href='/diet/members/move/healthy-body-benefits']")));
		element.click();
		return PageFactory.initElements(basedriver, MoveHealthyBodyBenefitsPage.class);
	}

	public MoveChallengeYourselfPage clickChallengeYourselfMenuLink() {
		Logger.info("Click on the Challenge Yourself menu under MOVE");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement moveMenu = basedriver.findElement(By.cssSelector(".body1>a[href='/diet/members/move']"));
		withActions().moveToElement(moveMenu).build().perform();
		WebDriverWait wait = new WebDriverWait(basedriver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".subnav a[href='/diet/members/move/challenge-yourself']")));
		element.click();
		return PageFactory.initElements(basedriver, MoveChallengeYourselfPage.class);
	}

	public MoveFitnessTipsPage clickMoveFitnessTipsMenuLink() {
		Logger.info("Click on the Fitness Tips menu under MOVE");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement moveMenu = basedriver.findElement(By.cssSelector(".body1>a[href='/diet/members/move']"));
		withActions().moveToElement(moveMenu).build().perform();
		WebDriverWait wait = new WebDriverWait(basedriver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".subnav a[href='/diet/members/move/fitness-tips']")));
		element.click();
		return PageFactory.initElements(basedriver, MoveFitnessTipsPage.class);
	}

	public FitnessPlannerPage clickFitnessPlannerMenuLink() {
		Logger.info("Click on the Fitness Planner menu under MOVE");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement moveMenu = basedriver.findElement(By.cssSelector(".body1>a[href='/diet/members/move']"));
		withActions().moveToElement(moveMenu).build().perform();
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		fitnessPlannerMenuLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, FitnessPlannerPage.class);
	}

	public ExerciseIndexPage clickExerciseIndexMenuLink() {
		Logger.info("Click on the Exercise Index menu under MOVE");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement moveMenu = basedriver.findElement(By.cssSelector(".body1>a[href='/diet/members/move']"));
		withActions().moveToElement(moveMenu).build().perform();
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		exerciseIndexMenuLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, ExerciseIndexPage.class);
	}

	public MoveGetStartedPage clickGetStartedMoveSiteMap() {
		Logger.info("Click on the MOVE Get Started menu in the Site Map");
		getStartedMoveSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MoveGetStartedPage.class);
	}

	public MoveHealthyBodyBenefitsPage clickHealthyBodyBenefitsSiteMap() {
		Logger.info("Click on the Healthy Body Benefits menu in the Site Map");
		healthyBodyBenefitsSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MoveHealthyBodyBenefitsPage.class);
	}

	public MoveChallengeYourselfPage clickChallengeYourselfSiteMap() {
		Logger.info("Click on the Challenge Yourself menu in the Site Map");
		challengeYourselfSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MoveChallengeYourselfPage.class);
	}

	public MoveFitnessTipsPage clickFitnessTipsSiteMap() {
		Logger.info("Click on the Fitness Tips in the Site Map");
		fitnessTipsSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MoveFitnessTipsPage.class);
	}

	public FitnessPlannerPage clickFitnessPlannerSiteMap() {
		Logger.info("Click on the Fitness Planner in the Site Map");
		fitnessPlannerSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, FitnessPlannerPage.class);
	}

	public ExerciseIndexPage clickExerciseIndexSiteMap() {
		Logger.info("Click on the Exercise Index in the Site Map");
		exerciseIndexSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, ExerciseIndexPage.class);
	}

	public MotivateMindAndBodyPage clickMotivateMindAndBodyMenuLink() {
		Logger.info("Click on the Mind & Body menu under MOTIVATE");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement motivateMenu = basedriver.findElement(By.cssSelector(".body1>a[href='/diet/members/motivate']"));
		withActions().moveToElement(motivateMenu).build().perform();
		WebDriverWait wait = new WebDriverWait(basedriver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".subnav a[href='/diet/members/motivate/mind-and-body']")));
		element.click();
		return PageFactory.initElements(basedriver, MotivateMindAndBodyPage.class);
	}

	public MotivateObstaclesPage clickObstaclesMenuLink() {
		Logger.info("Click on the Obstacles menu under MOTIVATE");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement motivateMenu = basedriver.findElement(By.cssSelector(".body1>a[href='/diet/members/motivate']"));
		withActions().moveToElement(motivateMenu).build().perform();
		WebDriverWait wait = new WebDriverWait(basedriver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".subnav a[href='/diet/members/motivate/obstacles']")));
		element.click();
		return PageFactory.initElements(basedriver, MotivateObstaclesPage.class);
	}

	public MotivateSuccessStoriesPage clickSuccessStoriesMenuLink() {
		Logger.info("Click on the Success Stories menu under MOTIVATE");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement motivateMenu = basedriver.findElement(By.cssSelector(".body1>a[href='/diet/members/motivate']"));
		withActions().moveToElement(motivateMenu).build().perform();
		WebDriverWait wait = new WebDriverWait(basedriver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".subnav a[href='/diet/members/motivate/success-stories']")));
		element.click();
		return PageFactory.initElements(basedriver, MotivateSuccessStoriesPage.class);
	}

	public MotivateSupportPage clickSupportMenuLink() {
		Logger.info("Click on the Support menu under MOTIVATE");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement motivateMenu = basedriver.findElement(By.cssSelector(".body1>a[href='/diet/members/motivate']"));
		withActions().moveToElement(motivateMenu).build().perform();
		WebDriverWait wait = new WebDriverWait(basedriver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".subnav a[href='/diet/members/motivate/support']")));
		element.click();
		return PageFactory.initElements(basedriver, MotivateSupportPage.class);
	}

	public MotivateMindAndBodyPage clickMindAndBodySiteMap() {
		Logger.info("Click on the Mind & Body menu in the Site Map");
		mindAndBodySiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MotivateMindAndBodyPage.class);
	}

	public MotivateObstaclesPage clickObstaclesSiteMap() {
		Logger.info("Click on the Obstacles on the Site Map");
		obstaclesSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MotivateObstaclesPage.class);
	}

	public MotivateSuccessStoriesPage clickSuccessStoriesSiteMap() {
		Logger.info("Click on the Success Stories in the Site Map");
		successStoriesSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MotivateSuccessStoriesPage.class);
	}

	public MotivateSupportPage clickSupportSiteMap() {
		Logger.info("Click on the Support in the Site Map");
		supportSiteMap
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, MotivateSupportPage.class);
	}

	public PublicHeaderMCD checkTheMayoClinicDietTextDisplayed() {
		Logger.info("Check 'The Mayo Clinic Diet' text is presented");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/PSWEB-1645");
		globalHeader.waitUntilVisible();
		boolean isTheMayoClinicDietTextPresent =
				globalHeader
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isTheMayoClinicDietTextPresent, "'The Mayo Clinic Diet' text is not present");
		return this;
	}

	public PublicHeaderMCD checkMainLogoDisplayed() {
		Logger.info("Check main logo is presented");
		boolean isMainLogoPresent =
				mainLogo
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMainLogoPresent, "Main logo is not present");
		return this;
	}

	public PublicHeaderMCD checkNavigationBarDisplayed() {
		Logger.info("Check navigation bar is presented");
		boolean isNavigationBarPresent =
				navigationBar
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isNavigationBarPresent, "Navigation bar is not present");
		return this;
	}

	public PublicHeaderMCD checkHomeLinkPresent() {
		Logger.info("Check 'Home' link is presented");
		boolean isHomeLinkPresent =
				homeLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isHomeLinkPresent, "'Home' link is not present");
		return this;
	}

	public PublicHeaderMCD checkEatLinkPresent() {
		Logger.info("Check 'Eat' link is presented");
		boolean isEatLinkPresent =
				eatLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isEatLinkPresent, "'Eat' link is not present");
		return this;
	}

	public PublicHeaderMCD checkMoveLinkPresent() {
		Logger.info("Check 'Move' link is presented");
		boolean isMoveLinkPresent =
				moveLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMoveLinkPresent, "'Move' link is not present");
		return this;
	}

	public PublicHeaderMCD checkMotivateLinkPresent() {
		Logger.info("Check 'Motivate' link is presented");
		boolean isMotivateLinkPresent =
				motivateLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isMotivateLinkPresent, "'Motivate' link is not present");
		return this;
	}

	public PublicHeaderMCD checkTrackLinkPresent() {
		Logger.info("Check 'Track' link is presented");
		boolean isTrackLinkPresent =
				trackLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isTrackLinkPresent, "'Track' link is not present");
		return this;
	}

	public PublicHeaderMCD checkAboutTheDietLinkPresent() {
		Logger.info("Check 'About the diet' link is presented");
		boolean isAboutTheDietLinkPresent =
				aboutTheDietLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isAboutTheDietLinkPresent, "'About the diet' link is not present");
		return this;
	}

	public PublicHeaderMCD checkSettingsLinkPresent() {
		Logger.info("Check 'Settings' link is presented");
		boolean isSettingsLinkPresent =
				settingsLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isSettingsLinkPresent, "'Settings' link is not present");
		return this;
	}

	public PublicHeaderMCD checkFAQLinkPresent() {
		Logger.info("Check 'FAQ' link is presented");
		boolean isFAQSLinkPresent =
				faqsLink
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isFAQSLinkPresent, "'FAQ' link is not present");
		return this;
	}

	public PublicHeaderMCD checkSiteAndToolsLinkDisplay() {
		Logger.info("Check Site and Tools Link is Present");
		faqsLink.mouseHover();
		assertTrue(siteAndToolsLink.isVisible(), "Site and Tools Link is not displaying");
		return this;
	}

	public PublicHeaderMCD checkLogOutLinkPresent() {
		Logger.info("Check 'Log Out' link is presented");
		boolean isLogOutLinkPresent =
				logOutHeader
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isLogOutLinkPresent, "'Log Out' link is not present");
		return this;
	}

	public FAQsPage clickFAQLink() {
		Logger.info("Click on FAQs Link");
		faqsLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, FAQsPage.class);
	}

	public FAQsSiteAndToolsPage clickFAQSiteAndToolsLink() {
		Logger.info("Click on FAQs: Site And Tools Sub Link");
		faqsLink.mouseHover();
		siteAndToolsLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, FAQsSiteAndToolsPage.class);
	}

	@Override
	public void waitForPageToLoad() {
		waitForAjaxRequestToBeFinished();
	}
}
