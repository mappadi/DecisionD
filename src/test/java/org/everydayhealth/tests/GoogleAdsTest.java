package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.EHPublicPage;
import everydayhealth.pages.articles.ArticleBasePage;
import everydayhealth.pages.articles.FluMapPage;
import everydayhealth.pages.articles.PhotoGalleryPage;
import everydayhealth.pages.articles.SimpleQuizPage;
import everydayhealth.pages.articles.SlideshowBasePage;
import everydayhealth.pages.columns.BlogArticlePage;
import everydayhealth.pages.columns.BlogIndexPage;
import everydayhealth.pages.columns.BlogLandingPage;
import everydayhealth.pages.conditions.CategoryLandingPage;
import everydayhealth.pages.conditions.ConditionCenterTopicPage;
import everydayhealth.pages.drugs.DrugsProfilePage;
import everydayhealth.pages.drugs.DrugsReviewsPage;
import everydayhealth.pages.landingpages.MasterLandingPage;
import everydayhealth.pages.landingpages.NewsLandingPage;
import everydayhealth.pages.landingpages.VideoLandingPage;
import everydayhealth.pages.personalizedTracker.PersonalizedTrackerPage;
import everydayhealth.pages.program.ProgramPage;
import everydayhealth.pages.visualizer.VisualizerLitePage;
import framework.DebugMode;
import framework.GoogleAdValue;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.CookieName;
import framework.platform.Environment;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserActionsEH;
import framework.platform.UserCacheEH;
import framework.platform.UserEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * GoogleAdsTest
 * Google Publisher Tag (GPT) platform tests
 */
public class GoogleAdsTest {

	UserEH adsUser = UserCacheEH.ADS_USER;

	private void loginWithAdsUserOnNewHeader() {
		Logger.info("Performing login action with \"ads user\"");
		BasicPageEH basicPageEH = SiteNavigatorEH.goToMainPageEH().onGlobalNavHeader().loginWithUserAndOpenPage(adsUser, BasicPageEH.class);
		basicPageEH.onGlobalNavHeader().isLoggedIn();
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "EverydayHealthSmoke", "AdsTests", "C189439"})
	@TestRail(id = "C189439")
	public void checkAdsOnHomePageTest() {
		checkAdsHomepage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "EverydayHealthSmoke", "AdsTests", "C189806"})
	@TestRail(id = "C189806")
	public void checkAdsOnHomePageUserTest() {
		checkAdsHomepage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C193582"})
	@TestRail(id = "C193582")
	public void checkAdsOnDrugsPageTest() {
		checkAdsDrugsLanding(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C194878"})
	@TestRail(id = "C194878")
	public void checkAdsOnDrugsPageUserTest() {
		checkAdsDrugsLanding(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C195729"})
	@TestRail(id = "C195729")
	public void checkAdsOnDrugsProfilePageTest() {
		checkAdsDrugsProfilePage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C195730"})
	@TestRail(id = "C195730")
	public void checkAdsOnDrugsProfilePageUserTest() {
		checkAdsDrugsProfilePage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "AdsTests", "C197414"})
	@TestRail(id = "C197414")
	public void checkAdsOnDrugsReviewPageTest() {
		checkAdsDrugReviewPage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "AdsTests", "C197415"})
	@TestRail(id = "C197415")
	public void checkAdsOnDrugsReviewPageUserTest() {
		checkAdsDrugReviewPage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C197909"})
	@TestRail(id = "C197909")
	public void checkAdsOnDrugsSearchResultsTest() {
		if (!Settings.isMobile()) {
			checkAdsDrugsSearchResults(false);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C197910"})
	@TestRail(id = "C197910")
	public void checkAdsOnDrugsSearchResultsUserTest() {
		if (!Settings.isMobile()) {
			checkAdsDrugsSearchResults(true);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C194890"})
	@TestRail(id = "C194890")
	public void checkAdsOnFluMapTest() {
		checkAdsFluMap(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C195207"})
	@TestRail(id = "C195207")
	public void checkAdsOnFluMapUserTest() {
		checkAdsFluMap(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C195331"})
	@TestRail(id = "C195331")
	public void checkAdsOnCCRLandingTest() {
		checkAdsCCRLanding(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C195332"})
	@TestRail(id = "C195332")
	public void checkAdsOnCCRLandingUserTest() {
		checkAdsCCRLanding(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C198563"})
	@TestRail(id = "C198563")
	public void checkAdsOnCCRArticleTest() {
		checkAdsCCRArticle(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C198564"})
	@TestRail(id = "C198564")
	public void checkAdsOnCCRArticleUserTest() {
		checkAdsCCRArticle(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C197913"})
	@TestRail(id = "C197913")
	public void checkAdsOnArticleVideoPageTest() {
		checkAdsArticleVideo(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C197914"})
	@TestRail(id = "C197914")
	public void checkAdsOnArticleVideoPageUserTest() {
		checkAdsArticleVideo(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C202720"})
	@TestRail(id = "C202720")
	public void checkAdsOnGuideTest() {
		checkAdsGuide(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C202721"})
	@TestRail(id = "C202721")
	public void checkAdsOnGuideUserTest() {
		checkAdsGuide(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C197920"})
	@TestRail(id = "C197920")
	public void checkAdsOnSlideshowPageTest() {
		checkAdsSlideshow(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C197921"})
	@TestRail(id = "C197921")
	public void checkAdsOnSlideshowPageUserTest() {
		checkAdsSlideshow(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleTest", "AdsTests", "C199536"})
	@TestRail(id = "C199536")
	public void checkAdsOnCUSOArticleTest() {
		checkAdsCusoArticle(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleTest", "AdsTests", "C199537"})
	@TestRail(id = "C199537")
	public void checkAdsOnCUSOArticleUserTest() {
		checkAdsCusoArticle(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "AdsTests", "CusoSlideshowTest", "C199539"})
	@TestRail(id = "C199539")
	public void checkAdsOnCUSOSlideshowTest() {
		checkAdsCusoSlideshow(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "AdsTests", "CusoSlideshowTest", "C199651"})
	@TestRail(id = "C199651")
	public void checkAdsOnCUSOSlideshowUserTest() {
		checkAdsCusoSlideshow(true);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "AdsTests", "C211570"})
	@TestRail(id = "C211570")
	public void checkAdsOnCusoLobbyLandingTest() {
		checkAdsCusoLobbyLanding(false);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "AdsTests", "C211571"})
	@TestRail(id = "C211571")
	public void checkAdsOnCusoLobbyLandingUserTest() {
		checkAdsCusoLobbyLanding(true);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "AdsTests", "C211572"})
	@TestRail(id = "C211572")
	public void checkAdsOnCusoVideologuesTest() {
		checkAdsCusoVideologues(false);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "AdsTests", "C211573"})
	@TestRail(id = "C211573")
	public void checkAdsOnCusoVideologuesUserTest() {
		checkAdsCusoVideologues(true);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ConditionCourse", "AdsTests", "C211574"})
	@TestRail(id = "C211574")
	public void checkAdsOnCusoConditionCourseTest() {
		checkAdsCusoConditionCourse(false);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ConditionCourse", "AdsTests", "C211575"})
	@TestRail(id = "C211575")
	public void checkAdsOnCusoConditionCourseUserTest() {
		checkAdsCusoConditionCourse(true);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoManagementSelectorTest", "AdsTests", "C211576"})
	@TestRail(id = "C211576")
	public void checkAdsOnCusoManagementSelectorTest() {
		checkAdsCusoManagementSelector(false);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoManagementSelectorTest", "AdsTests", "C211577"})
	@TestRail(id = "C211577")
	public void checkAdsOnCusoManagementSelectorUserTest() {
		checkAdsCusoManagementSelector(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C234552"})
	@TestRail(id = "C234552")
	public void checkAdsOnCCRTopicLandingPageTest() {
		checkAdsCCRTopicLandingPage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C234553"})
	@TestRail(id = "C234553")
	public void checkAdsOnCCRTopicLandingPageUserTest() {
		checkAdsCCRTopicLandingPage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "AdsTests", "C216704"})
	@TestRail(id = "C216704")
	public void checkAdsOnInfographicsPageUserTest() {
		checkAdsInfographicsPage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "AdsTests", "C216705"})
	@TestRail(id = "C216705")
	public void checkAdsOnInfographicsPageTest() {
		checkAdsInfographicsPage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C235435"})
	@TestRail(id = "C235435")
	public void checkAdsOnProgramPageUserTest() {
		checkAdsProgramPage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C235434"})
	@TestRail(id = "C235434")
	public void checkAdsOnProgramPageTest() {
		checkAdsProgramPage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C265852"})
	@TestRail(id = "C265852")
	public void checkAdsOnLobbyPageUserTest() {
		checkAdsLobbyPage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C235595"})
	@TestRail(id = "C235595")
	public void checkAdsOnLobbyPageTest() {
		checkAdsLobbyPage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C260751"})
	@TestRail(id = "C260751")
	public void checkAdsOnRecipesPageTest() {
		checkAdsRecipesPage();
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "C260752"})
	@TestRail(id = "C260752")
	public void checkAdsOnRecipesPageUserTest() {
		checkAdsRecipesPageLoggedIn();
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "AdsTests", "C266825"})
	@TestRail(id = "C266825")
	public void checkAdsOnCusoV3MLRPageTest() {
		checkAdsCusoV3Page(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "AdsTests", "C266826"})
	@TestRail(id = "C266826")
	public void checkAdsOnCusoV3MLRPageUserTest() {
		checkAdsCusoV3Page(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "AdsTests", "C309828"})
	@TestRail(id = "C309828")
	public void checkAdsOnResourceCenterPageTest() {
		checkAdsResourceCenterPage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ResourceCenterTest", "AdsTests", "C309829"})
	@TestRail(id = "C309829")
	public void checkAdsOnResourceCenterPageUserTest() {
		checkAdsResourceCenterPage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "PTTest", "C311878"})
	@TestRail(id = "C311878")
	public void checkAdsOnRaPTUserTest() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.RA_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);
		DebugMode debugMode = ptPage.inDebugMode();
		checkAds(debugMode, 2, 2, 2, "/4213/everydayhealth/cs//cchumirara//ad3", "trk", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		checkPTAdsUniqueValues(debugMode, ptPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "PTTest", "C311879"})
	@TestRail(id = "C311879")
	public void checkAdsOnCrohnsPTUserTest() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.CROHNS_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);
		DebugMode debugMode = ptPage.inDebugMode();
		checkAds(debugMode, 2, 2, 2, "/4213/everydayhealth/cs//humiracrohns//ad3", "trk", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		checkPTAdsUniqueValues(debugMode, ptPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "PTTest", "C311880"})
	@TestRail(id = "C311880")
	public void checkAdsOnDiabetesPTUserTest() {
		UserActionsEH.loginWithUser(UserCacheEH.PT_USER, true);
		PersonalizedTrackerPage ptPage = SiteNavigatorEH.goToPage(TemplatesEH.DIABETES_PERSONALIZED_TRACKER, PersonalizedTrackerPage.class);
		DebugMode debugMode = ptPage.inDebugMode();
		if (Settings.isEnvironment(Environment.PROD)) {
			checkAds(debugMode, 2, 2, 2, "/4213/everydayhealth/endocrinehormones//diabetestype2", "trk", "0");
		} else {
			checkAds(debugMode, 2, 2, 2, "/4213/everydayhealth/cs//invokana//mydailydiabetes", "trk", "0");
		}
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		checkPTAdsUniqueValues(debugMode, ptPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "AdsTests", "BlogIndexTest", "C312197"})
	@TestRail(id = "C312197")
	public void checkAdsOnBlogIndexPageTest() {
		checkAdsBlogIndexPage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "AdsTests", "BlogIndexTest", "C312198"})
	@TestRail(id = "C312198")
	public void checkAdsOnBlogIndexPageUserTest() {
		checkAdsBlogIndexPage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "VLPageTest", "AdsTests", "C314454"})
	@TestRail(id = "C314454")
	public void checkAdsOnVideoLandingPageTest() {
		checkAdsVideoLandingPage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "VLPageTest", "AdsTests", "C314455"})
	@TestRail(id = "C314455")
	public void checkAdsOnVideoLandingPageUserTest() {
		checkAdsVideoLandingPage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "BlogArticleTest", "C326697"})
	@TestRail(id = "C326697")
	public void checkAdsOnBlogArticlePageTest() {
		checkAdsBlogAritclePage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "BlogArticleTest", "C326698"})
	@TestRail(id = "C326698")
	public void checkAdsOnBlogArticlePageUserTest() {
		checkAdsBlogAritclePage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "BlogLandingTest", "C330391"})
	@TestRail(id = "C330391")
	public void checkAdsOnBlogLandingSingleAuthorPageTest() {
		verifyAdsBlogsLanding(false, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "BlogLandingTest", "C330392"})
	@TestRail(id = "C330392")
	public void checkAdsOnBlogLandingSingleAuthorPageUserTest() {
		verifyAdsBlogsLanding(true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "BlogLandingTest", "C328365"})
	@TestRail(id = "C328365")
	public void checkAdsOnBlogLandingMultipleAuthorsPageTest() {
		verifyAdsBlogsLanding(false, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "BlogLandingTest", "C328366"})
	@TestRail(id = "C328366")
	public void checkAdsOnBlogLandingMultipleAuthorsPageUserTest() {
		verifyAdsBlogsLanding(true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "CategoryPageTest", "C345199"})
	@TestRail(id = "C345199")
	public void checkAdsOnCategoryLandingTest() {
		verifyAdsCategoryLanding(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "CategoryPageTest", "C345200"})
	@TestRail(id = "C345200")
	public void checkAdsOnCategoryLandingUserTest() {
		verifyAdsCategoryLanding(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "NewsLandingTest", "C347273"})
	@TestRail(id = "C347273")
	public void checkAdsOnNewsLandingTest() {
		verifyAdsNewsLanding(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "NewsLandingTest", "C347274"})
	@TestRail(id = "C347274")
	public void checkAdsOnNewsLandingUserTest() {
		verifyAdsNewsLanding(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "MasterContentTest", "C376027"})
	@TestRail(id = "C376027")
	public void checkAdsOnMasterContentPageTest() {
		checkAdsMasterLandingPage(false, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "MasterContentTest", "C376028"})
	@TestRail(id = "C376028")
	public void checkAdsOnMasterContentPageUserTest() {
		checkAdsMasterLandingPage(true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "MasterLanding", "C384144"})
	@TestRail(id = "C384144")
	public void checkAdsOnMasterLandingPageTest() {
		checkAdsMasterLandingPage(false, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "MasterLanding", "C384145"})
	@TestRail(id = "C384145")
	public void checkAdsOnMasterLandingPageUserTest() {
		checkAdsMasterLandingPage(true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "SimpleQuizTest", "C675860"})
	@TestRail(id = "C675860")
	public void checkAdsOnSimpleQuizPageTest() {
		checkAdsSimpleQuizPage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "AdsTests", "SimpleQuizTest", "C675861"})
	@TestRail(id = "C675861")
	public void checkAdsOnSimpleQuizPageUserTest() {
		checkAdsSimpleQuizPage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "AdsTests", "PhotoGalleryTest", "C675881"})
	@TestRail(id = "C675881")
	public void checkAdsOnPhotoGalleryPageTest() {
		checkAdsPhotoGalleryPage(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "AdsTests", "PhotoGalleryTest", "C675882"})
	@TestRail(id = "C675882")
	public void checkAdsOnPhotoGalleryPageUserTest() {
		checkAdsPhotoGalleryPage(true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "AdsTests", "C678499"})
	@TestRail(id = "C678499")
	public void checkAdsOnVisualizerLitePageTest() {
		verifyAdsVisualizerLite(false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "AdsTests", "C678500"})
	@TestRail(id = "C678500")
	public void checkAdsOnVisualizerLitePageUserTest() {
		verifyAdsVisualizerLite(true);
	}

	private void checkAds(DebugMode ehPublicPageDebug, int numberOfAdsDesktop, int numberOfAdsTablet, int numberOfAdsMobile, String unitID, String ct, String ugc) {
		Logger.info("Verifying ad values on page " + WebDriverManager.getDriver().getCurrentUrl() + " " + Settings.getPlatform());
		int adsToCheck = 0;
		if (Settings.isDesktop()) {
			adsToCheck = numberOfAdsDesktop;
			ehPublicPageDebug.scrollDownUntilNumberOfDebugAdsPresent(numberOfAdsDesktop);
			assertEquals(ehPublicPageDebug.getNumberOfDebugAdBlocks(), numberOfAdsDesktop, "number of ads is not " + numberOfAdsDesktop);
		}
		if (Settings.isTablet()) {
			adsToCheck = numberOfAdsTablet;
			ehPublicPageDebug.scrollDownUntilNumberOfDebugAdsPresent(numberOfAdsTablet);
			assertEquals(ehPublicPageDebug.getNumberOfDebugAdBlocks(), numberOfAdsTablet, "number of ads is not " + numberOfAdsTablet);
		}
		if (Settings.isMobile()) {
			adsToCheck = numberOfAdsMobile;
			ehPublicPageDebug.scrollDownUntilNumberOfDebugAdsPresent(numberOfAdsMobile);
			assertEquals(ehPublicPageDebug.getNumberOfDebugAdBlocks(), numberOfAdsMobile, "number of ads is not " + numberOfAdsMobile);
		}
		ehPublicPageDebug.scrollPage(0);

		ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.CORRELATOR);
		if (!Utils.getCurrentURL().contains("/solutions/")) {
			ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.PAGEVIEWID);
		}
		ehPublicPageDebug.verifyAllDebugUnitsEqualsValue(GoogleAdValue.UNIT_ID, unitID);
		ehPublicPageDebug.verifyAllDebugUnitsEqualsValue(GoogleAdValue.UGC, ugc);
		ehPublicPageDebug.verifyAllDebugUnitsEqualsValue(GoogleAdValue.CT, ct);
		ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.PAGE);

		for (int ad = 1; ad <= adsToCheck; ad++) {
			assertFalse(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.CORRELATOR, ad).isEmpty(), "'Correlator' in ad#" + ad + " should not be empty");
			if (!Utils.getCurrentURL().contains("/solutions/")) {
				assertFalse(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.PAGEVIEWID, ad).isEmpty(), "'pageviewid' in ad#" + ad + " should not be empty");
			}
		}

		if (Settings.isDesktop()) {
			ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.ADOBEID);
			for (int ad = 1; ad <= adsToCheck; ad++) {
				assertFalse(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.ADOBEID, ad).isEmpty(), "AdobeID in ad#" + ad + " should not be empty");
			}
			ehPublicPageDebug.verifyAllDebugUnitsEqualsValue(GoogleAdValue.PLT, "desktop");
			ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.BTG);
		}
		if (Settings.isTablet()) {
			ehPublicPageDebug.verifyAllDebugUnitsEqualsValue(GoogleAdValue.PLT, "mobileweb");
			for (int ad = 1; ad <= adsToCheck; ad++) {
				assertEquals(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.MDV), "tab", "mdv value is not 'tab'");
			}
		}
		if (Settings.isMobile()) {
			ehPublicPageDebug.verifyAllDebugUnitsEqualsValue(GoogleAdValue.PLT, "mobileweb");
			for (int ad = 1; ad <= adsToCheck; ad++) {
				assertEquals(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.MDV, ad), "sph", "mdv value is not 'sph'");
			}
		}
	}

	private void checkAdsUser(DebugMode ehPublicPageDebug, String p, String c, String z, String ta, String tg, String nl, String u) {
		Logger.info("Verifying 'utp' values on " + Settings.getPlatform() + " with user " + adsUser.getEmail());
		ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.P);
		if (Settings.isEnvironment(Environment.PROD)) {
			ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.C);
		}
		ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.Z);
		ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.TA);
		ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.TG);
		if (!Settings.isEnvironment(Environment.PROD)) {
			ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.NL);
		}
		ehPublicPageDebug.verifyAllDebugUnitsAreEquals(GoogleAdValue.U);

		Logger.info("Verifying all utp values are expected values");
		assertEquals(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.P), p, "'p' value in ads is not " + p);
		if (Settings.isEnvironment(Environment.PROD)) {
			assertEquals(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.C), c, "'c' value in ads is not " + c);
		}
		assertEquals(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.Z), z, "'z' value in ads is not " + z);
		assertEquals(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.TA), ta, "'ta' value in ads is not " + ta);
		assertEquals(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.TG), tg, "'tg' value in ads is not " + tg);
		if (!Settings.isEnvironment(Environment.PROD)) {
			assertEquals(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.NL), nl, "'nl' value in ads is not " + nl);
		}
		assertEquals(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.U), u, "'u' value in ads is not " + u);
	}

	private void checkAdsUniqueValues(DebugMode ehPublicPageDebug, int debugAd, String size, String pos, String slot) {
		Logger.info("Verifying unique ad values on page " + WebDriverManager.getDriver().getCurrentUrl() + " " + Settings.getPlatform());
		if (Utils.getCurrentURL().contains("tools.")) {
			Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHOPY-1046");
		}
		String adSize = ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.SIZE, debugAd);
		assertTrue(adSize.contains("300x") || adSize.contains("x90") || adSize.equals("970x250") || adSize.equals(size), "Wrong 'Size' value for ad #" + debugAd);
		assertEquals(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.POS, debugAd), pos, "'pos' value for ad: " + debugAd + " is not: " + pos);
		assertEquals(ehPublicPageDebug.getValueOfDebugAd(GoogleAdValue.SLOT, debugAd), slot, "'slot' value for ad: " + debugAd + " is not: " + slot);
	}

	private void checkAdsHomepage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		DebugMode debugMode = ehPublicPage.inDebugMode();
		ehPublicPage.clickMoreButton();
		debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
		checkAds(debugMode, 3, 3, 3, "/4213/everydayhealth/homepage", "home", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
		checkAdsUniqueValues(debugMode, 2, "300x600", "bottom", "box2");
		checkAdsUniqueValues(debugMode, 3, "300x600", "bottom", "box3");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsDrugsLanding(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToDrugsLandingPage().inDebugMode();
		checkAds(debugMode, 4, 3, 1, "/4213/everydayhealth/generalwellness//drugs", "daz", "0");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x600", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
		}
	}

	private void checkAdsDrugsProfilePage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DrugsProfilePage drugTemplate = SiteNavigatorEH.goToDrugProfilePage();
		DebugMode debugMode = drugTemplate.inDebugMode();
		if (!Settings.isDesktop()) {
			Logger.info("Closing the drug template side menu");
			drugTemplate.clickSideMenu();
		}
		if (Settings.isDesktop() || Settings.isTablet()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x600", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 4, "300x250", "bottom", "box3");
			checkAdsUniqueValues(debugMode, 5, "300x250", "extra", "boxextra");
			debugMode.scrollPage(100000);
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(6);
			checkAdsUniqueValues(debugMode, 6, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 2, "300x600", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box3");
			checkAdsUniqueValues(debugMode, 4, "300x250", "extra", "boxextra");
		}
		checkAds(debugMode, 6, 6, 4, "/4213/everydayhealth/bonesjoints//generalpain//dr", "daz", "0");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsDrugReviewPage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_REVIEW, DrugsReviewsPage.class).inDebugMode();
		checkAds(debugMode, 2, 2, 0, "/4213/everydayhealth/bonesjoints//generalpain//dr", "daz", "1");
		checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
		checkAdsUniqueValues(debugMode, 2, "728x90", "extra", "leaderextra");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsDrugsSearchResults(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToDrugSearchResultsPage("/drugs/search?q=ambien").inDebugMode();
		checkAds(debugMode, 4, 3, 1, "/4213/everydayhealth/generalwellness//drugs", "daz", "0");
		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
		}
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsFluMap(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class).inDebugMode();
		if (Settings.isEnvironment(Environment.PROD)) {
			checkAds(debugMode, 3, 3, 1, "/4213/everydayhealth/tools//flutracker//super2018", "fw", "0");
		} else {
			checkAds(debugMode, 3, 3, 1, "/4213/everydayhealth/tools//flutracker", "fw", "0");
		}
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x600", "bottom", "box1");
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box1");
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "300x250", "bottom", "box1");
		}
	}

	private void checkAdsCCRTopicLandingPage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		ConditionCenterTopicPage ccrTopicPage = SiteNavigatorEH.goToCCRTopicPageEH(TemplatesEH.TOPIC_LANDING);
		DebugMode debugMode = ccrTopicPage.inDebugMode();
		if (Settings.isDesktop()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 1, "728x90", "topsticky", "leader1");
			Logger.info("Verifying the unique values of adDiv5");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x600", "bottom", "box2");
			ccrTopicPage.clickSeeMoreButton();
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 4, "300x600", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 5, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x600", "bottom", "box2");
			ccrTopicPage.clickSeeMoreButton();
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 4, "300x600", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 5, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			ccrTopicPage.clickSeeMoreButton();
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x250", "extra", "boxextra");
		}
		checkAds(debugMode, 5, 5, 3, "/4213/everydayhealth/brainnerves//multiplesclerosis", "topic", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsInfographicsPage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToInfographicsPage(TemplatesEH.INFOGRAPHIC.getTemplateURL()).inDebugMode();
		Logger.info("Check ads unique values");
		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "topsticky", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 2, "300x250", "topsticky", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottomsticky", "box2");
			checkAdsUniqueValues(debugMode, 4, "300x250", "extrasticky", "boxextra");
			checkAdsUniqueValues(debugMode, 5, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x600", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		checkAds(debugMode, 5, 3, 0, "/4213/everydayhealth/generalwellness//dietnutrition", "inf", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsCCRLanding(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToCCRLandingPageEH(TemplatesEH.LANDING).inDebugMode();
		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
		}
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (Settings.isDesktop()) {
			Logger.info("Verifying the unique values of adDiv1");
			checkAdsUniqueValues(debugMode, 1, "728x90", "topsticky", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			Logger.info("Verifying the unique values of adDiv5");
			checkAdsUniqueValues(debugMode, 2, "300x250", "topsticky", "box1");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv5"));
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv7");
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottomsticky", "box2");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7"));
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv9");
			checkAdsUniqueValues(debugMode, 2, "300x250", "extrasticky", "boxextra");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
		}
		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 3, "300x250", "extra", "boxextra");
		}
		checkAds(debugMode, 3, 3, 3, "/4213/everydayhealth/brainnerves//multiplesclerosis", "sub", "0");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsCCRArticle(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToPage(TemplatesEH.CCR_ARTICLE, ArticleBasePage.class).inDebugMode();
		if (Settings.isDesktop()) {
			Logger.info("Verifying the unique values of adDiv1");
			checkAdsUniqueValues(debugMode, 2, "728x90", "topsticky", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x600", "topsticky", "box1");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 4), "/4213/everydayhealth/brainnerves//multiplesclerosis", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 4), "articleimage3", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 4), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv7");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv5"));
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x600", "bottomsticky", "box2");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 4), "/4213/everydayhealth/brainnerves//multiplesclerosis", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 4), "articleimage3", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 4), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv9");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7"));
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x250", "extrasticky", "boxextra");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 4), "/4213/everydayhealth/brainnerves//multiplesclerosis", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 4), "articleimage3", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 4), "0", "Wrong value of 'ugc' parameter");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 5, "728x90", "extra", "leaderextra");
			checkAdsUniqueValues(debugMode, 1, "1x1", "oop", "video");
			checkAdsUniqueValues(debugMode, 3, "300x90", "top", "native1");
		}
		if (Settings.isTablet()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(7);
			checkAdsUniqueValues(debugMode, 1, "1x1", "oop", "video");
			checkAdsUniqueValues(debugMode, 2, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 4, "300x90", "top", "native1");
			checkAdsUniqueValues(debugMode, 5, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 6, "300x250", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 7, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 1, "1x1", "oop", "video");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 4, "300x250", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 5, "300x90", "top", "native1");
		}
		checkAds(debugMode, 5, 7, 5, "/4213/everydayhealth/brainnerves//multiplesclerosis", "articleimage3", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsArticleVideo(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_VIDEO_V3, ArticleBasePage.class).inDebugMode();
		if (Settings.isDesktop()) {
			Logger.info("Verifying the unique values of adDiv1 and adDiv5");
			checkAdsUniqueValues(debugMode, 2, "728x90", "topsticky", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x600", "topsticky", "box1");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 4), "/4213/everydayhealth/mentalhealth//emohealth", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 4), "articlevideo3", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 4), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv7");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv5"));
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x600", "bottomsticky", "box2");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 4), "/4213/everydayhealth/mentalhealth//emohealth", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 4), "articlevideo3", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 4), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv9");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7"));
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x250", "extrasticky", "boxextra");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 4), "/4213/everydayhealth/mentalhealth//emohealth", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 4), "articlevideo3", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 4), "0", "Wrong value of 'ugc' parameter");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 5, "728x90", "extra", "leaderextra");
			checkAdsUniqueValues(debugMode, 1, "1x1", "oop", "video");
			checkAdsUniqueValues(debugMode, 3, "300x90", "top", "native1");
		}
		if (Settings.isTablet()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 3, "300x90", "top", "native1");
		}
		checkAds(debugMode, 5, 4, 3, "/4213/everydayhealth/mentalhealth//emohealth", "articlevideo3", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsGuide(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToBasicPageEH(TemplatesEH.GUIDE.getTemplateURL()).inDebugMode();

		checkAds(debugMode, 5, 5, 3, "/4213/everydayhealth/brainnerves//parkinsons", "gui", "0");

		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "topsticky", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x600", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 4, "300x250", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 5, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x600", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 4, "300x250", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 5, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 3, "300x250", "extra", "boxextra");
		}
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsSlideshow(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToSlideshowPage(TemplatesEH.SLIDESHOW.getTemplateURL());
		DebugMode debugMode = slideshowPage.inDebugMode();
		checkAds(debugMode, 4, 4, 1, "/4213/everydayhealth/skinhairnails//beauty", "pht", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 2, "300x90", "top", "native1");
			checkAdsUniqueValues(debugMode, 3, "728x90", "bottom", "leader1");
			checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "native1");
			checkAdsUniqueValues(debugMode, 3, "728x90", "bottom", "leader1");
			checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
		}
		Logger.info("Page forward through the slideshow using the next arrow to verify interstitial ads");
		int slideNumber = 0;
		int totalNumberOfSlides = slideshowPage.getTotalSlideCount() + 2; //Total slides number + number of ads
		while (!slideshowPage.isLastSlide() && slideNumber <= totalNumberOfSlides) {
			Logger.info("Verify interstitial ads after 4th and before last slide");
			slideshowPage.clickNextSlideArrow();
			if (slideshowPage.isAdDiv7Visible()) {
				Utils.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7")); //extra wait required for ads
				checkAdsUniqueValues(debugMode, 1, "300x250", "ss", "box2");
				slideshowPage.skipInterstialAd();
			}
			if (slideshowPage.isInterstialAd2Visible()) {
				Utils.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7")); //extra wait required for ads
				checkAdsUniqueValues(debugMode, 2, "300x250", "ss2", "box3");
			}
			slideNumber++;
		}
		if (slideNumber >= totalNumberOfSlides) {
			fail("10 Slides were verified but were not able to find second ad.");
		}
	}

	private void checkAdsCusoArticle(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToBasicPageEH(TemplatesEH.CUSO_ARTICLE.getTemplateURL()).inDebugMode();
		debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (Settings.isDesktop() || Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x600", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 4, "300x600", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 5, "728x90", "extra", "leaderextra");

		}
		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 1, "320x50", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x600", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 4, "300x600", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 5, "320x50", "extra", "leaderextra");
		}
		checkAds(debugMode, 5, 5, 5, "/4213/everydayhealth/cs//test", "cusoarticle", "0");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsCusoSlideshow(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, SlideshowBasePage.class);
		DebugMode debugMode = slideshowPage.inDebugMode();
		checkAds(debugMode, 3, 3, 3, "/4213/everydayhealth/cs//test", "cusopht", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
		if (Settings.isDesktop() || Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x600", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "320x50", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "320x50", "extra", "leaderextra");
		}
		Logger.info("Page forward through the slideshow using the next arrow to verify interstitial ads");
		int slideNumber = 0;
		int totalNumberOfSlides = slideshowPage.getTotalSlideCount() + 1; //Total slides number + number of ads
		while (!slideshowPage.isLastSlide() && slideNumber <= totalNumberOfSlides) {
			Logger.info("Verify interstitial ads after 4th slide. Current slide: " + slideNumber);
			slideshowPage.clickNextSlideArrow();
			if (slideshowPage.isAdDiv7Visible()) {
				Utils.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7")); //extra wait required for ads
				if (Settings.isMobile()) {
					checkAdsUniqueValues(debugMode, 4, "300x250", "ss", "box2");
				} else {
					checkAdsUniqueValues(debugMode, 3, "300x250", "ss", "box2");
				}
				slideshowPage.skipCusoInterstialAd();
			}
			slideNumber++;
		}
	}

	private void checkAdsCusoLobbyLanding(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToCusoLandingLobbyPage().inDebugMode();
		if (Settings.isEnvironment(Environment.PROD)) {
			checkAds(debugMode, 3, 3, 3, "/4213/everydayhealth/cs//test", "cusolob", "0");
		} else {
			checkAds(debugMode, 4, 4, 4, "/4213/everydayhealth/cs//test", "cusolob", "0");
		}

		if (Settings.isDesktop() || Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x600", "bottom", "box2");
			if (!Settings.isEnvironment(Environment.PROD)) {
				debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
				checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
			}
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "320x50", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x600", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			if (!Settings.isEnvironment(Environment.PROD)) {
				checkAdsUniqueValues(debugMode, 4, "320x50", "extra", "leaderextra");
			}
		}
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsCusoManagementSelector(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToCusoManagementSelectorPage().inDebugMode();
		if (Settings.isEnvironment(Environment.PROD)) {
			checkAds(debugMode, 2, 2, 1, "/4213/everydayhealth/cs//test", "cusomgmt", "0");
		} else {
			checkAds(debugMode, 3, 3, 1, "/4213/everydayhealth/cs//test", "cusomgmt", "0");
		}
		if (Settings.isDesktop() || Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x600", "top", "box1");
			if (!Settings.isEnvironment(Environment.PROD)) {
				debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
				checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
			}
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
		}
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsCusoVideologues(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToCusoVideologuesSingleTabPage().inDebugMode();
		if (Settings.isEnvironment(Environment.PROD)) {
			checkAds(debugMode, 2, 2, 3, "/4213/everydayhealth/cs//test", "cusovideo", "0");
		} else {
			checkAds(debugMode, 3, 2, 3, "/4213/everydayhealth/cs//test", "cusovideo", "0");
		}
		if (Settings.isDesktop() || Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x600", "top", "box1");
			if (!Settings.isEnvironment(Environment.PROD)) {
				debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
				checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
			}
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "320x50", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
		}
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsCusoConditionCourse(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToCusoConditionCoursePage().inDebugMode();
		if (Settings.isEnvironment(Environment.PROD)) {
			checkAds(debugMode, 2, 2, 2, "/4213/everydayhealth/cs//test", "cusocourse", "0");
		} else {
			checkAds(debugMode, 3, 3, 3, "/4213/everydayhealth/cs//test", "cusocourse", "0");
		}
		if (Settings.isDesktop() || Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			if (!Settings.isEnvironment(Environment.PROD)) {
				debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
				checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
			}
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "320x50", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			if (!Settings.isEnvironment(Environment.PROD)) {
				checkAdsUniqueValues(debugMode, 3, "320x50", "extra", "leaderextra");
			}
		}
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsProgramPage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToBasicPageEH(TemplatesEH.PROGRAM.getTemplateURL()).inDebugMode();
		checkAds(debugMode, 3, 3, 2, "/4213/everydayhealth/endocrinehormones//diabetestype2", "pgr", "0");

		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (!Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x600", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x600", "bottom", "box2");
		} else {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "320x250", "bottom", "box2");
		}
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsRecipesPage() {
		DebugMode debugMode = SiteNavigatorEH.goToBasicPageEH(TemplatesEH.RECIPES.getTemplateURL()).inDebugMode();

		if (Settings.isDesktop()) {
			Logger.info("Verifying the unique values of adDiv1 and adDiv5");
			checkAdsUniqueValues(debugMode, 1, "728x90", "topsticky", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "topsticky", "box1");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/healthyliving//recipes", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "rec", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv7");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv5"));
			checkAdsUniqueValues(debugMode, 2, "300x600", "bottomsticky", "box2");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/healthyliving//recipes", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "rec", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv9");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7"));
			checkAdsUniqueValues(debugMode, 2, "300x250", "extrasticky", "boxextra");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/healthyliving//recipes", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "rec", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 1, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "extra", "boxextra");
		}
		checkAds(debugMode, 3, 3, 3, "/4213/everydayhealth/healthyliving//recipes", "rec", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
	}

	private void checkAdsRecipesPageLoggedIn() {
		loginWithAdsUserOnNewHeader();
		DebugMode debugMode = SiteNavigatorEH.goToBasicPageEH(TemplatesEH.RECIPES.getTemplateURL()).inDebugMode();

		if (Settings.isDesktop()) {
			Logger.info("Verifying the unique values of adDiv1 and adDiv5");
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/generalwellness//weightmanagement", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "tool", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv7");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv5"));
			checkAdsUniqueValues(debugMode, 2, "300x600", "top", "box1");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/generalwellness//weightmanagement", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "tool", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv9");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7"));
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/generalwellness//weightmanagement", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "tool", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
		}
		if (Settings.isTablet()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
		}
		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 1, "320x50", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
		}
		checkAds(debugMode, 2, 2, 2, "/4213/everydayhealth/generalwellness//weightmanagement", "tool", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");

		checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
	}

	private void checkAdsLobbyPage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.LOBBY_LIST_PAGE, ProgramPage.class);
		DebugMode debugMode = programPage.inDebugMode();
		programPage.clickMoreButton();
		checkAds(debugMode, 4, 4, 3, "/4213/everydayhealth/generalwellness//general", "lob", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x250", "bottom", "box3");
		} else if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x250", "bottom", "box3");
		} else {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box3");
		}
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsCusoV3Page(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToCusoArticleV3MLRPage().inDebugMode();
		checkAds(debugMode, 5, 5, 4, "/4213/everydayhealth/cs//test", "cusoarticle3", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (!Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x250", "extra", "boxextra");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x250", "bottom", "box2");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 5, "728x90", "extra", "leaderextra");
		} else {
			checkAdsUniqueValues(debugMode, 1, "320x50", "top", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 4, "300x250", "extra", "boxextra");
		}
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsResourceCenterPage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToResourceCenterPage().inDebugMode();
		checkAds(debugMode, 4, 4, 3, "/4213/everydayhealth/cs//test", "cuso", "0");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (Settings.isDesktop() || Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x600", "bottom", "box2");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
		} else {
			checkAdsUniqueValues(debugMode, 1, "320x50", "top", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "320x50", "bottom", "box2");
		}
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkPTAdsUniqueValues(DebugMode debugMode, PersonalizedTrackerPage ptPage) {
		if (Settings.isDesktop() || Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x600", "top", "box1");
			ptPage.clickWeeklyTab();
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x600", "bottom", "box2");
		}
	}

	private void checkAdsBlogIndexPage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		BlogIndexPage blogIndexPage = SiteNavigatorEH.goToBlogIndexPage();
		DebugMode debugMode = blogIndexPage.inDebugMode();
		checkAds(debugMode, 4, 4, 3, "/4213/everydayhealth/generalwellness//general", "lblg", "1");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (Settings.isDesktop() || Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "topsticky", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			int numberOfSections = blogIndexPage.getNumberOfSections();
			if (numberOfSections >= 2) {
				debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
				checkAdsUniqueValues(debugMode, 3, "300x600", "bottom", "box2");
			}
			if (numberOfSections >= 3) {
				debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
				checkAdsUniqueValues(debugMode, 4, "300x250", "extra", "boxextra");
			}
		} else {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x250", "extra", "boxextra");
		}
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsVideoLandingPage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		VideoLandingPage videoLandingPageTest = SiteNavigatorEH.goToVideoLandingPage();
		DebugMode debugMode = videoLandingPageTest.inDebugMode();
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (Settings.isDesktop() || Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			if (videoLandingPageTest.isSeeMoreButtonVisible()) {
				videoLandingPageTest.clickSeeMoreButton();
				debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
				checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			}
			checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
		} else {
			checkAdsUniqueValues(debugMode, 1, "320x50", "top", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			if (videoLandingPageTest.isSeeMoreButtonVisible()) {
				videoLandingPageTest.clickSeeMoreButton();
				debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
				checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			}
		}
		checkAds(debugMode, 4, 4, 3, "/4213/everydayhealth/cs//test", "cusosocvid", "0");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsBlogAritclePage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);
		DebugMode debugMode = blogArticlePage.inDebugMode();
		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "1x1", "oop", "video");
			checkAdsUniqueValues(debugMode, 2, "728x90", "topsticky", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x250", "topsticky", "box1");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv5"));
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottomsticky", "box2");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7"));
			checkAdsUniqueValues(debugMode, 3, "300x250", "extrasticky", "boxextra");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "topsticky", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 1, "1x1", "oop", "video");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 4, "300x250", "extra", "boxextra");
		}
		checkAds(debugMode, 4, 4, 4, "/4213/everydayhealth/skinhairnails//skinconditions", "lblg", "1");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void verifyAdsBlogsLanding(boolean isLoggedIn, boolean isSingleAuthor) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		BlogLandingPage blogLandingPage;
		if (isSingleAuthor) {
			blogLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_SINGLE_AUTHOR, BlogLandingPage.class);
		} else {
			blogLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_MULTIPLE_AUTHORS, BlogLandingPage.class);
		}
		DebugMode debugMode = blogLandingPage.inDebugMode();
		String unitIDValue = isSingleAuthor ? "/4213/everydayhealth/skinhairnails//skinconditions" : "/4213/everydayhealth/cancer//general";
		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "topsticky", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "topsticky", "box1");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), unitIDValue, "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "lblg", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "1", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv7");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv5"));
			checkAdsUniqueValues(debugMode, 2, "300x600", "bottomsticky", "box2");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), unitIDValue, "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "lblg", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "1", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv9");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7"));
			checkAdsUniqueValues(debugMode, 2, "300x250", "extrasticky", "boxextra");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), unitIDValue, "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "lblg", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "1", "Wrong value of 'ugc' parameter");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 2, "300x250", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 2, "300x250", "extra", "boxextra");
		}
		checkAds(debugMode, 3, 4, 3, unitIDValue, "lblg", "1");
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void verifyAdsCategoryLanding(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_LANDING, CategoryLandingPage.class).inDebugMode();
		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "topsticky", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "topsticky", "box1");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/cancer//general", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "land", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv7");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv5"));
			checkAdsUniqueValues(debugMode, 2, "300x600", "bottomsticky", "box2");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/cancer//general", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "land", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv9");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7"));
			checkAdsUniqueValues(debugMode, 2, "300x250", "extrasticky", "boxextra");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/cancer//general", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "land", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
			debugMode.scrollPage(100000);
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			checkAdsUniqueValues(debugMode, 3, "300x250", "top", "box2");
			checkAdsUniqueValues(debugMode, 4, "300x250", "top", "boxextra");
			checkAdsUniqueValues(debugMode, 5, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
		}
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		checkAds(debugMode, 3, 5, 1, "/4213/everydayhealth/cancer//general", "land", "0");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private String getUValueFromCookies() {
		return CookiesManager.getCookieValue(CookieName.Profile).split("&")[1].split("=")[1];
	}

	private void verifyAdsNewsLanding(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		DebugMode debugMode = SiteNavigatorEH.goToPage(TemplatesEH.NEWS_LANDING_PAGE, NewsLandingPage.class).inDebugMode();
		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "topsticky", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "topsticky", "box1");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/generalwellness//general", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "newsland", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv7");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv5"));
			checkAdsUniqueValues(debugMode, 2, "300x600", "bottomsticky", "box2");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/generalwellness//general", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "newsland", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
			Logger.info("Waiting for ad refresh and verifying the unique values of adDiv9");
			debugMode.waitFor(debugMode.getValueOfAdReplaceTime("adDiv7"));
			checkAdsUniqueValues(debugMode, 2, "300x250", "extrasticky", "boxextra");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 2), "/4213/everydayhealth/generalwellness//general", "Wrong value of 'Unit ID' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 2), "newsland", "Wrong value of 'ct' parameter");
			assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 2), "0", "Wrong value of 'ugc' parameter");
			debugMode.scrollPage(100000);
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 3, "300x250", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 4, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(1);
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x250", "extra", "boxextra");
		}
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		checkAds(debugMode, 3, 4, 3, "/4213/everydayhealth/generalwellness//general", "newsland", "0");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsMasterLandingPage(boolean isLoggedIn, boolean isMasterContent) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}

		MasterLandingPage masterLandingPage = isMasterContent ?
				SiteNavigatorEH.goToMasterContentPage() :
				SiteNavigatorEH.goToMasterLandingPage();
		DebugMode debugMode = masterLandingPage.inDebugMode();

		if (Settings.isMobile()) {
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(1);
			checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
			masterLandingPage.scrollToPromoSection();
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
			masterLandingPage.scrollToLinkList();
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x250", "extra", "boxextra");
		} else {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(2);
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			debugMode.scrollPage(100000);
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 3, "300x250", "bottom", "box2");
			checkAdsUniqueValues(debugMode, 4, "300x250", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, 5, "728x90", "extra", "leaderextra");
		}

		if (isMasterContent) {
			checkAds(debugMode, 5, 5, 3, "/4213/everydayhealth/lungs//chroniccopd", "mastercontent", "0");
		} else {
			checkAds(debugMode, 5, 5, 3, "/4213/everydayhealth/cancer//colon", "masterlanding", "0");
		}
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void checkAdsSimpleQuizPage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}

		SimpleQuizPage simpleQuizPage = SiteNavigatorEH.goToPage(TemplatesEH.SIMPLE_QUIZ, SimpleQuizPage.class);
		DebugMode debugMode = simpleQuizPage.inDebugMode();
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "320x50", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
		} else {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "top", "box1");
		}

		Logger.info("Page forward through the question and answers to verify tile 7 ad");
		checkAds(debugMode, 2, 2, 2, "/4213/everydayhealth/generalwellness//dietnutrition", "simplequiz", "0");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		simpleQuizPage.clickTakeTheQuizButton();
		int numberOfQuestions = simpleQuizPage.getSimpleQuizQuestionsCount();
		for (int numberBlocks = 1; numberBlocks <= numberOfQuestions; numberBlocks++) {
			String currentAnswer = simpleQuizPage.getSelectedOptionText(numberBlocks);
			simpleQuizPage.clickOnOption(numberBlocks);
		}
		if (simpleQuizPage.isRestartButtonVisible()) {
			checkAdsUniqueValues(debugMode, 3, "300x250", "top", "box2");
		}
		assertFalse(debugMode.getValueOfDebugAd(GoogleAdValue.PAGEVIEWID, 3).isEmpty(), "'pageviewid' in tile 7 ad should not be empty");
		assertFalse(debugMode.getValueOfDebugAd(GoogleAdValue.CORRELATOR, 3).isEmpty(), "'Correlator' in tile 7 ad should not be empty");
		assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UNIT_ID, 3), "/4213/everydayhealth/generalwellness//dietnutrition", "Wrong value of 'Unit ID' parameter");
		assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.CT, 3), "simplequizres", "Wrong value of 'ct' parameter");
		assertEquals(debugMode.getValueOfDebugAd(GoogleAdValue.UGC, 3), "0", "Wrong value of 'ugc' parameter");
	}

	private void checkAdsPhotoGalleryPage(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		PhotoGalleryPage photoGalleryPage;
		if (Settings.isMobile()) {
			photoGalleryPage = SiteNavigatorEH.openPage("/yk-photo-gallery-test-page/", PhotoGalleryPage.class);
		} else {
			photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();
		}
		DebugMode debugMode = photoGalleryPage.inDebugMode();
		int numberOfGalleryItems = photoGalleryPage.getNumberOfGalleryItems();

		//See https://everydayhealth.atlassian.net/browse/EHF-3475 for ads logic reference
		int numberOfRightRailAds = numberOfGalleryItems % 2 == 0 ?
				numberOfGalleryItems / 2 :
				numberOfGalleryItems / 2 + 1;
		int numberOfHorizontalAds = numberOfGalleryItems % 2 == 0 ?
				numberOfGalleryItems / 2 - 1 :
				numberOfGalleryItems / 2;
		int numberOfAdsDesktop = numberOfHorizontalAds + numberOfRightRailAds + 2;
		int numberOfAdsMobile = photoGalleryPage.isIntroSectionVisible() ?
				numberOfHorizontalAds + 3 :
				numberOfHorizontalAds + 2;
		String unitID = Settings.isMobile() ?
				"/4213/everydayhealth/cardio//anemia" :
				"/4213/everydayhealth/bonesjoints//arthritisgeneral";
		checkAds(debugMode, numberOfAdsDesktop, numberOfAdsDesktop, numberOfAdsMobile, unitID, "pht3", "0");
		if (Settings.isMobile()) {
			Logger.info("Expected number of ads MOBILE is - " + numberOfAdsMobile);

			int boxAdsCounter = 2;
			if (photoGalleryPage.isIntroSectionVisible()) {
				checkAdsUniqueValues(debugMode, 1, "300x250", "top", "box1");
				checkAdsUniqueValues(debugMode, 2, "300x250", "bottom", "box2");
				boxAdsCounter += 1;
			} else {
				checkAdsUniqueValues(debugMode, 1, "300x250", "bottom", "box2");
			}
			if (numberOfGalleryItems > 4) {
				if (debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, boxAdsCounter).equals("1x1")) {
					checkAdsUniqueValues(debugMode, boxAdsCounter, "1x1", "oop", "video");
				} else {
					checkAdsUniqueValues(debugMode, boxAdsCounter, "300x250", "bottom", "box" + (boxAdsCounter + 1));
					boxAdsCounter++;
				}

				if (numberOfGalleryItems > 6) {
					if (debugMode.getValueOfDebugAd(GoogleAdValue.SLOT, 4).equals("native1")) {
						checkAdsUniqueValues(debugMode, boxAdsCounter, "300x250", "bottom", "native1");
					} else {
						checkAdsUniqueValues(debugMode, boxAdsCounter, "300x250", "bottom", "box" + (boxAdsCounter + 1));
						boxAdsCounter++;
					}
				}

				if (numberOfGalleryItems > 8) {
					int adsCounter = boxAdsCounter + 1;
					while (boxAdsCounter <= numberOfAdsMobile - 2) {
						checkAdsUniqueValues(debugMode, adsCounter, "300x250", "bottom", "box" + boxAdsCounter);
						adsCounter++;
					}
				}
			}
			checkAdsUniqueValues(debugMode, numberOfAdsMobile - 1, "320x50", "extra", "boxextra");
			checkAdsUniqueValues(debugMode, numberOfAdsMobile, "320x50", "extra", "leaderextra");
		} else {
			Logger.info("Expected number of ads DESKTOP is - " + numberOfAdsDesktop);
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(numberOfAdsDesktop);
			int leaderAdsCounter = 2;
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			checkAdsUniqueValues(debugMode, 2, "300x250", "topsticky", "box1");
			checkAdsUniqueValues(debugMode, 3, "728x90", "bottom", "leader2");
			checkAdsUniqueValues(debugMode, 4, "300x250", "bottomsticky", "box2");
			if (debugMode.getValueOfDebugAd(GoogleAdValue.SIZE, 5).equals("1x1")) {
				checkAdsUniqueValues(debugMode, 5, "1x1", "oop", "video");
			} else {
				checkAdsUniqueValues(debugMode, 5, "728x90", "bottom", "leader3");
				leaderAdsCounter++;
			}
			checkAdsUniqueValues(debugMode, 6, "300x250", "bottomsticky", "box3");
			if (debugMode.getValueOfDebugAd(GoogleAdValue.SLOT, 7).equals("native1")) {
				checkAdsUniqueValues(debugMode, 7, "728x90", "top", "native1");
			} else {
				checkAdsUniqueValues(debugMode, 7, "728x90", "bottom", "leader4");
				leaderAdsCounter++;
			}
			int adsCounter = 8;
			while (adsCounter <= numberOfAdsDesktop - 1) {
				checkAdsUniqueValues(debugMode, adsCounter, "300x250", "bottomsticky", "box" + String.valueOf(adsCounter / 2));
				adsCounter++;
				if (adsCounter != numberOfAdsDesktop) {
					checkAdsUniqueValues(debugMode, adsCounter, "728x90", "bottom", "leader" + String.valueOf(leaderAdsCounter + 1));
					leaderAdsCounter++;
					adsCounter++;
				}
			}
			checkAdsUniqueValues(debugMode, numberOfAdsDesktop, "728x90", "extra", "leaderextra");
		}
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

	private void verifyAdsVisualizerLite(boolean isLoggedIn) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader();
		}
		VisualizerLitePage visualizerLitePage = SiteNavigatorEH.goToPage(TemplatesEH.VISUALIZER_LITE_PAGE, VisualizerLitePage.class);
		DebugMode debugMode = visualizerLitePage.inDebugMode();

		if (visualizerLitePage.isIGNPlayerVisible()) {
			visualizerLitePage.clickIGNPauseButton();
		}

		if (Settings.isDesktop()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x250", "bottom", "box2");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 5, "300x250", "bottom", "box3");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(6);
			checkAdsUniqueValues(debugMode, 6, "728x90", "extra", "leaderextra");
		}
		if (Settings.isTablet()) {
			checkAdsUniqueValues(debugMode, 1, "728x90", "top", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x250", "bottom", "box2");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 5, "300x250", "bottom", "box3");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(6);
			checkAdsUniqueValues(debugMode, 6, "728x90", "extra", "leaderextra");
		}
		if (Settings.isMobile()) {
			checkAdsUniqueValues(debugMode, 1, "320x50", "top", "leader1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(3);
			checkAdsUniqueValues(debugMode, 3, "300x250", "top", "box1");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			checkAdsUniqueValues(debugMode, 4, "300x250", "bottom", "box2");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
			checkAdsUniqueValues(debugMode, 5, "300x250", "bottom", "box3");
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(6);
			checkAdsUniqueValues(debugMode, 6, "320x50", "extra", "leaderextra");
		}
		debugMode.verifyAllDebugUnitsContainValue(GoogleAdValue.INVIEW, "0", "1");
		checkAds(debugMode, 6, 6, 6, "/4213/everydayhealth/cancer//colon", "visualizer", "0");
		if (isLoggedIn) {
			checkAdsUser(debugMode, "37", "181,180,143,45", "10012", "25", "F", "48,46", getUValueFromCookies());
		}
	}

}