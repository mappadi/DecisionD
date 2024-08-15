package org.mayoclinicdiet.tests;

import com.testrail.framework.platform.annotations.TestRail;
import framework.Logger;
import framework.platform.SiteNavigatorMCD;
import mayoclinicdiet.pages.EatPage;
import mayoclinicdiet.pages.MotivatePage;
import mayoclinicdiet.pages.MovePage;
import mayoclinicdiet.pages.PublicHeaderMCD;
import org.testng.annotations.Test;

public class ArticleTest {

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C34597")
	public void eatMoveMotivatePagesLoad() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickEatLink()
				.checkEatUrl()
				.clickMoveLink()
				.checkMoveUrl()
				.clickMotivateLink()
				.checkMotivateUrl();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C34598")
	public void eatMoveMotivatePageSection() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickEatLink()
				.checkLandingTitleDisplayed()
				.checkGetStartedSectionDisplayed()
				.checkSmartFoodChoicesSectionDisplayed()
				.checkMealsMadeEasySectionDisplayed()
				.checkEatingOutSectionDisplayed()
				.checkGetStartedSection()
				.checkSmartFoodChoicesSection()
				.checkMealsMadeEasySection()
				.checkEatingOutSection()
				.changeGetStartedSectionNameColourOnHover()
				.changeSmartFoodChoicesSectionNameColourOnHover()
				.changeMealsMadeEasySectionNameColourOnHover()
				.changeEatingOutSectionNameColourOnHover()
				.clickGetStartedName()
				.checkEatGetStartedUrl()
				.clickBackBrowserButton(EatPage.class)
				.clickSmartFoodChoicesName()
				.checkSmartFoodChoicesUrl()
				.clickBackBrowserButton(EatPage.class)
				.clickMealsMadeEasyName()
				.checkMealsMadeEasyUrl()
				.clickBackBrowserButton(EatPage.class)
				.clickEatingOutName()
				.checkEatingOutUrl()
				.clickMoveLink()
				.checkLandingTitleDisplayed()
				.checkGetStartedSectionDisplayed()
				.checkHealthyBodyBenefitsSectionDisplayed()
				.checkChallengeYourselfSectionDisplayed()
				.checkFitnessTipsSectionDisplayed()
				.checkGetStartedSection()
				.checkHealthyBodyBenefitsSection()
				.checkChallengeYourselfSection()
				.checkFitnessTipsSection()
				.changeGetStartedSectionNameColourOnHover()
				.changeHealthyBodyBenefitsSectionNameColourOnHover()
				.changeChallengeYourselfSectionNameColourOnHover()
				.changeFitnessTipsSectionNameColourOnHover()
				.clickGetStartedName()
				.checkMoveGetStartedUrl()
				.clickBackBrowserButton(MovePage.class)
				.clickHealthyBodyBenefitsName()
				.checkHealthyBodyBenefitsUrl()
				.clickBackBrowserButton(MovePage.class)
				.clickChallengeYourselfName()
				.checkChallengeYourselfUrl()
				.clickBackBrowserButton(MovePage.class)
				.clickFitnessTipsName()
				.checkFitnessTipsUrl()
				.clickMotivateLink()
				.checkLandingTitleDisplayed()
				.checkMindAndBodySectionDisplayed()
				.checkObstaclesSectionDisplayed()
				.checkSuccessStoriesSectionDisplayed()
				.checkSupportSectionDisplayed()
				.checkMindAndBodySection()
				.checkObstaclesSection()
				.checkSuccessStoriesSection()
				.checkSupportSection()
				.changeMindAndBodySectionNameColourOnHover()
				.changeObstaclesSectionNameColourOnHover()
				.changeSuccessStoriesSectionNameColourOnHover()
				.changeSupportSectionNameColourOnHover()
				.clickMindAndBodyName()
				.checkMindAndBodyUrl()
				.clickBackBrowserButton(MotivatePage.class)
				.clickObstaclesName()
				.checkObstaclesUrl()
				.clickBackBrowserButton(MotivatePage.class)
				.clickSuccessStoriesName()
				.checkMotivateSuccessStoriesUrl()
				.clickBackBrowserButton(MotivatePage.class)
				.clickSupportName()
				.checkMotivateSupportUrl();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C34599")
	public void eatMoveMotivatePageBreadcrumb() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickEatLink()
				.checkEatBreadcrumb()
				.clickMoveLink()
				.checkMoveBreadcrumb()
				.clickMotivateLink()
				.checkMotivateBreadcrumb();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd", "C144064"})
	@TestRail(id = "C144064")
	public void articleLandingPageLoading() {
		PublicHeaderMCD publicHeaderMCD = SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class);
		Logger.info("Check all links for EAT menu from Top Navigation Bar and Footer site map");
		publicHeaderMCD.clickGetStartedMenuLink()
				.checkEatGetStartedUrl()
				.clickSmartFoodChoicesMenuLink()
				.checkSmartFoodChoicesUrl()
				.clickMealsMadeEasyMenuLink()
				.checkMealsMadeEasyUrl()
				.clickEatingOutMenuLink()
				.checkEatingOutUrl()
				.clickRecipeFinderMenuLink()
				.checkRecipeSearchUrl()
				.clickDailyMealPlanMenuLink()
				.checkDailyMealPlanUrl()
				.clickWeeklyMealPlanMenuLink()
				.checkWeeklyMealPlanUrl()
				.clickGetStartedSiteMap()
				.checkEatGetStartedUrl()
				.clickSmartFoodChoicesSiteMap()
				.checkSmartFoodChoicesUrl()
				.clickMealsMadeEasySiteMap()
				.checkMealsMadeEasyUrl()
				.clickEatingOutSiteMap()
				.checkEatingOutUrl()
				.clickRecipeFinderSiteMap()
				.checkRecipeSearchUrl()
				.clickDailyMealPlanSiteMap()
				.checkDailyMealPlanUrl()
				.clickWeeklyMealPlanSiteMap()
				.checkWeeklyMealPlanUrl();
		Logger.info("Check all links for MOVE menu from Top Navigation Bar and Footer site map");
		publicHeaderMCD.clickGetStartedMoveMenuLink()
				.checkMoveGetStartedUrl()
				.clickHealthyBodyBenefitsMenuLink()
				.checkHealthyBodyBenefitsUrl()
				.clickChallengeYourselfMenuLink()
				.checkChallengeYourselfUrl()
				.clickMoveFitnessTipsMenuLink()
				.checkFitnessTipsUrl()
				.clickFitnessPlannerMenuLink()
				.checkFitnessPlannerUrl()
				.clickExerciseIndexMenuLink()
				.checkExchangeIndexUrl()
				.clickGetStartedMoveSiteMap()
				.checkMoveGetStartedUrl()
				.clickHealthyBodyBenefitsSiteMap()
				.checkHealthyBodyBenefitsUrl()
				.clickChallengeYourselfSiteMap()
				.checkChallengeYourselfUrl()
				.clickFitnessTipsSiteMap()
				.checkFitnessTipsUrl()
				.clickFitnessPlannerSiteMap()
				.checkFitnessPlannerUrl()
				.clickExerciseIndexSiteMap()
				.checkExchangeIndexUrl();
		Logger.info("Check all links for MOTIVATE menu from Top Navigation Bar and Footer site map");
		publicHeaderMCD.clickMotivateMindAndBodyMenuLink()
				.checkMindAndBodyUrl()
				.clickObstaclesMenuLink()
				.checkObstaclesUrl()
				.clickSuccessStoriesMenuLink()
				.checkMotivateSuccessStoriesUrl()
				.clickSupportMenuLink()
				.checkMotivateSupportUrl()
				.clickMindAndBodySiteMap()
				.checkMindAndBodyUrl()
				.clickObstaclesSiteMap()
				.checkObstaclesUrl()
				.clickSuccessStoriesSiteMap()
				.checkMotivateSuccessStoriesUrl()
				.checkMotivateSuccessStoriesUrl()
				.clickSupportSiteMap()
				.checkMotivateSupportUrl();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144065")
	public void articleLandingMainSection() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickGetStartedMenuLink()
				.checkEatGetStartedTitleDisplayed();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144066")
	public void articleLandingSections() {
		PublicHeaderMCD publicHeaderMCD = SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class);
		Logger.info("Check all sections for each sub-menu page under EAT menu");
		publicHeaderMCD.clickGetStartedMenuLink()
				.checkArticleSectionsOnEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.checkArticleSectionsOnSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.checkArticleSectionsOnMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.checkArticleSectionsOnEatingOutPage();
		Logger.info("Check all sections for each sub-menu page under Move menu");
		publicHeaderMCD.clickGetStartedMoveMenuLink()
				.checkArticleSectionsOnMoveGetStartedPage()
				.clickHealthyBodyBenefitsMenuLink()
				.checkArticleSectionsOnHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.checkArticleSectionsOnChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.checkArticleSectionsOnFitnessTipsPage();
		Logger.info("Check all sections for each sub-menu page under Motivate menu");
		publicHeaderMCD.clickMotivateMindAndBodyMenuLink()
				.checkArticleSectionsOnMindAndBodyPage()
				.clickObstaclesMenuLink()
				.checkArticleSectionsOnObstaclesPage()
				.clickSuccessStoriesMenuLink()
				.checkArticleSectionsOnSuccessStoriesPage()
				.clickSupportMenuLink()
				.checkArticleSectionsOnSupportPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144067")
	public void articleLandingBreadcrumbs() {
		PublicHeaderMCD publicHeaderMCD = SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class);
		Logger.info("Check breadcrumbs for each sub-menu page under EAT menu");
		publicHeaderMCD.clickGetStartedMenuLink()
				.checkEatGetStartedBreadcrumb()
				.clickSmartFoodChoicesMenuLink()
				.checkEatSmartFoodChoicesBreadcrumb()
				.clickMealsMadeEasyMenuLink()
				.checkEatMealsMadeEasyBreadcrumb()
				.clickEatingOutMenuLink()
				.checkEatingOutBreadcrumb();
		Logger.info("Check breadcrumbs for each sub-menu page under MOVE menu");
		publicHeaderMCD.clickGetStartedMoveMenuLink()
				.checkMoveGetStartedBreadcrumb()
				.clickHealthyBodyBenefitsMenuLink()
				.checkMoveHealthyBodyBenefitsBreadcrumb()
				.clickChallengeYourselfMenuLink()
				.checkMoveChallengeYourselfBreadcrumb()
				.clickMoveFitnessTipsMenuLink()
				.checkMoveFitnessTipsBreadcrumb();
		Logger.info("Check breadcrumbs for each sub-menu page under MOTIVATE menu");
		publicHeaderMCD.clickMotivateMindAndBodyMenuLink()
				.checkMindAndBodyBreadcrumb()
				.clickObstaclesMenuLink()
				.checkObstaclesBreadcrumb()
				.clickSuccessStoriesMenuLink()
				.checkSuccessStoriesBreadcrumb()
				.clickSupportMenuLink()
				.checkSupportBreadcrumb();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144068")
	public void eatArticlePageLoad() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickGetStartedMenuLink()
				.openArticleFromEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.openArticleFromSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.openArticleFromMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.openArticleFromEatingOutPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144069")
	public void moveArticlePageLoad() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickGetStartedMoveMenuLink()
				.openArticleFromMoveGetStartedPage()
				.clickHealthyBodyBenefitsMenuLink()
				.openArticleFromHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.openArticleFromChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.openArticleFromFitnessTipsPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144070")
	public void motivateArticlePageLoad() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickMotivateMindAndBodyMenuLink()
				.openArticleFromMindAndBodyPage()
				.clickObstaclesMenuLink()
				.openArticleFromObstaclesPage()
				.clickSuccessStoriesMenuLink()
				.openArticleFromSuccessStoriesPage()
				.clickSupportMenuLink()
				.openArticleFromSupportPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144071"})
	@TestRail(id = "C144071")
	public void eatArticleHeaderAndSubText() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickGetStartedMenuLink()
				.checkArticleHeaderAndSubTextOnArticleEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.checkArticleHeaderAndSubTextOnArticleSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.checkArticleHeaderAndSubTextOnArticleMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.checkArticleHeaderAndSubTextOnArticleEatingOutPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144072")
	public void moveArticleHeaderAndSubText() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickGetStartedMoveMenuLink()
				.checkArticleHeaderAndSubTextOnArticleMoveGetStartedPage()
				.clickHealthyBodyBenefitsMenuLink()
				.checkArticleHeaderAndSubTextOnArticleHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.checkArticleHeaderAndSubTextOnArticleChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.checkArticleHeaderAndSubTextOnArticleFitnessTipsPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144073"})
	@TestRail(id = "C144073")
	public void motivateArticleHeaderAndSubText() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickMotivateMindAndBodyMenuLink()
				.checkArticleHeaderAndSubTextOnArticleMindAndBodyPage()
				.clickObstaclesMenuLink()
				.checkArticleHeaderAndSubTextOnArticleObstaclesPage()
				.clickSuccessStoriesMenuLink()
				.checkArticleHeaderAndSubTextOnArticleSuccessStoriesPage()
				.clickSupportMenuLink()
				.checkArticleHeaderAndSubTextOnArticleSupportPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144074"})
	@TestRail(id = "C144074")
	public void eatArticleImage() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickGetStartedMenuLink()
				.checkArticleImageOnArticleEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.checkArticleImageOnArticleSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.checkArticleImageOnArticleMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.checkArticleImageOnArticleEatingOutPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144075")
	public void moveArticleImage() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickGetStartedMoveMenuLink()
				.checkArticleImageOnArticleMoveGetStartedPage()
				.clickHealthyBodyBenefitsMenuLink()
				.checkArticleImageOnArticleHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.checkArticleImageOnArticleChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.checkArticleImageOnArticleFitnessTipsPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144076"})
	@TestRail(id = "C144076")
	public void motivateArticleImage() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickMotivateMindAndBodyMenuLink()
				.checkArticleImageOnArticleMindAndBodyPage()
				.clickObstaclesMenuLink()
				.checkArticleImageOnArticleObstaclesPage()
				.clickSuccessStoriesMenuLink()
				.checkArticleImageOnArticleSuccessStoriesPage()
				.clickSupportMenuLink()
				.checkArticleImageOnArticleSupportPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144077"})
	@TestRail(id = "C144077")
	public void eatArticleContent() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickGetStartedMenuLink()
				.checkArticleContentOnArticleEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.checkArticleContentOnArticleSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.checkArticleContentOnArticleMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.checkArticleContentOnArticleEatingOutPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144078"})
	@TestRail(id = "C144078")
	public void moveArticleContent() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickGetStartedMoveMenuLink()
				.checkArticleContentOnArticleMoveGetStartedPage()
				.clickHealthyBodyBenefitsMenuLink()
				.checkArticleContentOnArticleHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.checkArticleContentOnArticleChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.checkArticleContentOnArticleFitnessTipsPage();
	}


	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144079"})
	@TestRail(id = "C144079")
	public void motivateArticleContent() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickMotivateMindAndBodyMenuLink()
				.checkArticleContentOnArticleMindAndBodyPage()
				.clickObstaclesMenuLink()
				.checkArticleContentOnArticleObstaclesPage()
				.clickSuccessStoriesMenuLink()
				.checkArticleContentOnArticleSuccessStoriesPage()
				.clickSupportMenuLink()
				.checkArticleContentOnArticleSupportPage();
	}


	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144080"})
	@TestRail(id = "C144080")
	public void eatArticleBreadcrumb() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickGetStartedMenuLink()
				.checkArticleBreadcrumbOnArticleEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.checkArticleBreadcrumbOnArticleSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.checkArticleBreadcrumbOnArticleMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.checkArticleBreadcrumbOnArticleEatingOutPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144081")
	public void moveArticleBreadcrumb() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickGetStartedMoveMenuLink()
				.checkArticleBreadcrumbOnArticleMoveGetStartedPage()
				.clickHealthyBodyBenefitsMenuLink()
				.checkArticleBreadcrumbOnArticleHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.checkArticleBreadcrumbOnArticleChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.checkArticleBreadcrumbOnArticleFitnessTipsPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144082")
	public void motivateArticleBreadcrumb() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class)
				.clickMotivateMindAndBodyMenuLink()
				.checkArticleBreadcrumbOnArticleMindAndBodyPage()
				.clickObstaclesMenuLink()
				.checkArticleBreadcrumbOnArticleObstaclesPage()
				.clickSuccessStoriesMenuLink()
				.checkArticleBreadcrumbOnArticleSuccessStoriesPage()
				.clickSupportMenuLink()
				.checkArticleBreadcrumbOnArticleSupportPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144083"})
	@TestRail(id = "C144083")
	public void slideShowPageLoad() {
		PublicHeaderMCD publicHeaderMCD = SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class);
		Logger.info("Check the slide show page is loaded for each sub-menu page under EAT menu");
		publicHeaderMCD.clickGetStartedMenuLink()
				.openSlideShowFromEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.openSlideShowFromSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.openSlideShowFromMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.openSlideShowFromEatingOutPage();
		Logger.info("Check the slide show page is loaded for each sub-menu page under MOVE menu");
		publicHeaderMCD.clickHealthyBodyBenefitsMenuLink()
				.openSlideShowFromHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.openSlideShowFromChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.openSlideShowFromFitnessTipsPage();
		Logger.info("Check the slide show page is loaded for each sub-menu page under MOTIVATE menu");
		publicHeaderMCD.clickObstaclesMenuLink()
				.openSlideShowFromObstaclesPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144084")
	public void slideShowHeaderAndSubText() {
		PublicHeaderMCD publicHeaderMCD = SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class);
		Logger.info("Check the slide show Header And Sub-Text are displayed for each sub-menu page under EAT menu");
		publicHeaderMCD.clickGetStartedMenuLink()
				.checkSlideShowHeaderAndSubTextFromEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.checkSlideShowHeaderAndSubTextFromSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.checkSlideShowHeaderAndSubTextFromMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.checkSlideShowHeaderAndSubTextFromEatingOutPage();
		Logger.info("Check the slide show Header And Sub-Text are displayed for each sub-menu page under MOVE menu");
		publicHeaderMCD.clickHealthyBodyBenefitsMenuLink()
				.checkSlideShowHeaderAndSubTextFromHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.checkSlideShowHeaderAndSubTextFromChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.checkSlideShowHeaderAndSubTextFromFitnessTipsPage();
		Logger.info("Check the slide show Header And Sub-Text are displayed for each sub-menu page under MOTIVATE menu");
		publicHeaderMCD.clickObstaclesMenuLink()
				.checkSlideShowHeaderAndSubTextFromObstaclesPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144085"})
	@TestRail(id = "C144085")
	public void slideShowNavigationArrow() {
		PublicHeaderMCD publicHeaderMCD = SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class);
		Logger.info("Check the slide show Navigation Arrows are displayed for each sub-menu page under EAT menu");
		publicHeaderMCD.clickGetStartedMenuLink()
				.checkSlideShowNavigationArrowsFromEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.checkSlideShowNavigationArrowsFromSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.checkSlideShowNavigationArrowsFromMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.checkSlideShowNavigationArrowsFromEatingOutPage();
		Logger.info("Check the slide show Navigation Arrows are displayed for each sub-menu page under MOVE menu");
		publicHeaderMCD.clickHealthyBodyBenefitsMenuLink()
				.checkSlideShowNavigationArrowsFromHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.checkSlideShowNavigationArrowsFromChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.checkSlideShowNavigationArrowsFromFitnessTipsPage();
		Logger.info("Check the slide show Navigation Arrows are displayed for each sub-menu page under MOTIVATE menu");
		publicHeaderMCD.clickObstaclesMenuLink()
				.checkSlideShowNavigationArrowsFromObstaclesPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C144086")
	public void slideShowContent() {
		PublicHeaderMCD publicHeaderMCD = SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class);
		Logger.info("Check the slide show content is displayed for each sub-menu page under EAT menu");
		publicHeaderMCD.clickGetStartedMenuLink()
				.checkSlideShowContentFromEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.checkSlideShowContentFromSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.checkSlideShowContentFromMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.checkSlideShowContentFromEatingOutPage();
		Logger.info("Check the slide show content is displayed for each sub-menu page under MOVE menu");
		publicHeaderMCD.clickHealthyBodyBenefitsMenuLink()
				.checkSlideShowContentFromHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.checkSlideShowContentFromChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.checkSlideShowContentFromFitnessTipsPage();
		Logger.info("Check the slide show content is displayed for each sub-menu page under MOTIVATE menu");
		publicHeaderMCD.clickObstaclesMenuLink()
				.checkSlideShowContentFromObstaclesPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144087"})
	@TestRail(id = "C144087")
	public void slideShowThumbnails() {
		PublicHeaderMCD publicHeaderMCD = SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class);
		Logger.info("Check the slide show thumbnails are displayed for each sub-menu page under EAT menu");
		publicHeaderMCD.clickGetStartedMenuLink()
				.checkSlideShowThumbnailsFromEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.checkSlideShowThumbnailsFromSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.checkSlideShowThumbnailsFromMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.checkSlideShowThumbnailsFromEatingOutPage();
		Logger.info("Check the slide show thumbnails are displayed for each sub-menu page under MOVE menu");
		publicHeaderMCD.clickHealthyBodyBenefitsMenuLink()
				.checkSlideShowThumbnailsFromHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.checkSlideShowThumbnailsFromChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.checkSlideShowThumbnailsFromFitnessTipsPage();
		Logger.info("Check the slide show thumbnails are displayed for each sub-menu page under MOTIVATE menu");
		publicHeaderMCD.clickObstaclesMenuLink()
				.checkSlideShowThumbnailsFromObstaclesPage();
	}

	@Test(groups = {"article", "MayoClinicDiet", "regressionSet", "prodRegression", "C144088"})
	@TestRail(id = "C144088")
	public void slideShowBreadcrumb() {
		PublicHeaderMCD publicHeaderMCD = SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(PublicHeaderMCD.class);
		Logger.info("Check the slide show breadcrumb is displayed for each sub-menu page under EAT menu");
		publicHeaderMCD.clickGetStartedMenuLink()
				.checkSlideShowBreadcrumbFromEatGetStartedPage()
				.clickSmartFoodChoicesMenuLink()
				.checkSlideShowBreadcrumbFromSmartFoodChoicesPage()
				.clickMealsMadeEasyMenuLink()
				.checkSlideShowBreadcrumbFromMealsMadeEasyPage()
				.clickEatingOutMenuLink()
				.checkSlideShowBreadcrumbFromEatingOutPage();
		Logger.info("Check the slide show breadcrumb is displayed for each sub-menu page under MOVE menu");
		publicHeaderMCD.clickHealthyBodyBenefitsMenuLink()
				.checkSlideShowBreadcrumbFromHealthyBodyBenefitsPage()
				.clickChallengeYourselfMenuLink()
				.checkSlideShowBreadcrumbFromChallengeYourselfPage()
				.clickMoveFitnessTipsMenuLink()
				.checkSlideShowBreadcrumbFromFitnessTipsPage();
		Logger.info("Check the slide show breadcrumb is displayed for each sub-menu page under MOTIVATE menu");
		publicHeaderMCD.clickObstaclesMenuLink()
				.checkSlideShowBreadcrumbFromObstaclesPage();
	}

}
