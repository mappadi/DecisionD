package framework.platform;

import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.EHPublicPage;
import everydayhealth.pages.SettingsPage;
import everydayhealth.pages.articles.ArticleBasePage;
import everydayhealth.pages.articles.CusoArticleV3Page;
import everydayhealth.pages.articles.CusoLandingLobbyPage;
import everydayhealth.pages.articles.CusoManagementSelectorPage;
import everydayhealth.pages.articles.CusoVideologuesPage;
import everydayhealth.pages.articles.CustomSolutionsTemplatePage;
import everydayhealth.pages.articles.InfographicsPage;
import everydayhealth.pages.articles.PhotoGalleryPage;
import everydayhealth.pages.articles.SlideshowBasePage;
import everydayhealth.pages.columns.BlogIndexPage;
import everydayhealth.pages.conditions.ConditionCenterLandingPage;
import everydayhealth.pages.conditions.ConditionCenterTopicPage;
import everydayhealth.pages.conditions.ConditionCoursePage;
import everydayhealth.pages.conditions.HealthAZLandingPage;
import everydayhealth.pages.drugs.DrugsLandingPage;
import everydayhealth.pages.drugs.DrugsPageSearchResults;
import everydayhealth.pages.drugs.DrugsProfilePage;
import everydayhealth.pages.landingpages.MasterContentPage;
import everydayhealth.pages.landingpages.MasterLandingPage;
import everydayhealth.pages.landingpages.VideoLandingPage;
import everydayhealth.pages.lifehack.LifehackPage;
import everydayhealth.pages.personalizedTracker.DiabetesPTRegistrationPage;
import everydayhealth.pages.personalizedTracker.DiabetesPersonalizedTrackerPage;
import everydayhealth.pages.personalizedTracker.PTRegistrationPage;
import everydayhealth.pages.push.PushEditPageBasePage;
import everydayhealth.pages.push.PushStartPage;
import everydayhealth.pages.registrations.ToolsRegistrationPage;
import everydayhealth.pages.resourceCenter.ResourceCenterPage;
import everydayhealth.pages.visualizer.VisualizerLitePage;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * SiteNavigatorEH
 */
public class SiteNavigatorEH extends SiteNavigatorBase {

	public static EHPublicPage goToMainPageEH() {
		return goToPage("", EHPublicPage.class);
	}

	public static ConditionCenterLandingPage goToCCRLandingPageEH(TemplatesEH ccrLandingPage) {
		return goToPage(ccrLandingPage, ConditionCenterLandingPage.class);
	}

	public static HealthAZLandingPage goToHealthAZLandingPage() {
		return goToPage("/conditions/", HealthAZLandingPage.class);
	}

	public static CusoArticleV3Page goToCusoArticleV3MLRPage() {
		return goToPage(TemplatesEH.CUSO_ARTICLE_V3_MLR, CusoArticleV3Page.class);
	}

	public static CusoArticleV3Page goToCusoArticleV3Page() {
		return goToPage(TemplatesEH.CUSO_ARTICLE_V3, CusoArticleV3Page.class);
	}

	public static DrugsLandingPage goToDrugsLandingPage() {
		return goToPage(TemplatesEH.DRUGS_LANDING, DrugsLandingPage.class);
	}

	public static DrugsProfilePage goToDrugProfilePage() {
		return goToPage(TemplatesEH.DRUGS_PROFILE, DrugsProfilePage.class);
	}

	public static DrugsPageSearchResults goToDrugSearchResultsPage(String url) {
		return goToPage(url, DrugsPageSearchResults.class);
	}

	public static BasicPageEH goToBasicPageEH(String url) {
		Logger.info("Loading page: " + url);
		return goToPage(url, BasicPageEH.class);
	}

	public static BasicPageEH goToBasicPageEH(TemplatesEH template) {
		return goToBasicPageEH(template.getTemplateURL());
	}

	public static ToolsRegistrationPage goToToolsRegistrationPage(String url) {
		Logger.info("Loading tools registration page: " + url);
		return goToPage(url, ToolsRegistrationPage.class);
	}

	public static SlideshowBasePage goToSlideshowPage(String url) {
		return goToPage(url, SlideshowBasePage.class);
	}

	public static LifehackPage goToLifeHackPage() {
		return goToPage(TemplatesEH.LIFEHACK_PAGE, LifehackPage.class);
	}

	public static InfographicsPage goToInfographicsPage(String url) {
		return goToPage(url, InfographicsPage.class);
	}

	public static CustomSolutionsTemplatePage goToCusoArticlePage(TemplatesEH url) {
		return goToPage(url.getTemplateURL(), CustomSolutionsTemplatePage.class);
	}

	public static ConditionCenterTopicPage goToCCRTopicPageEH(TemplatesEH url) {
		return goToPage(url.getTemplateURL(), ConditionCenterTopicPage.class);
	}

	public static ArticleBasePage goToCCRArticlePageEH(TemplatesEH url) {
		return goToPage(url.getTemplateURL(), ArticleBasePage.class);
	}

	public static <T> T goToPage(TemplatesEH url, Class<T> expectedPage) {
		if (url.getTemplateURL().contains("?")) {
			openPage(url.getTemplateURL() + "&isautomation=true");
		} else {
			openPage(url.getTemplateURL() + "?isautomation=true");
		}
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public static PTRegistrationPage goToRAPTRegistrationPageViaNewsletterUrl(String encodedEmail) {
		openPage("/register/?returnurl=%2fdashboard%2fmy-daily-ra%2f&e=" + encodedEmail);
		return PageFactory.initElements(WebDriverManager.getDriver(), PTRegistrationPage.class);
	}

	public static PTRegistrationPage goToCrohnsPTRegistrationPageViaNewsletterUrl(String encodedEmail) {
		openPage("/register/?returnurl=%2fdashboard%2fmy-daily-crohns%2f&e=" + encodedEmail);
		return PageFactory.initElements(WebDriverManager.getDriver(), PTRegistrationPage.class);
	}

	public static DiabetesPTRegistrationPage goToDiabetesPTRegistrationPageViaNewsletterUrl(String encodedEmail) {
		openPage("/register/?returnurl=%2fdashboard%2fmy-daily-diabetes%2f&e=" + encodedEmail);
		return PageFactory.initElements(WebDriverManager.getDriver(), DiabetesPTRegistrationPage.class);
	}

	public static DiabetesPersonalizedTrackerPage goToDiabetesPTPageFromEmail(String viewFull, String date, String viewLetter) {
		String url = "/dashboard/my-daily-diabetes/?xid=nl_dash_" + viewFull + "&d=" + date + "&v=" + viewLetter;
		openPage(url);
		return PageFactory.initElements(WebDriverManager.getDriver(), DiabetesPersonalizedTrackerPage.class);
	}

	public static CusoLandingLobbyPage goToCusoLandingLobbyPage() {
		return goToPage(TemplatesEH.CUSO_LANDING_LOBBY, CusoLandingLobbyPage.class);
	}

	public static SettingsPage goToSettingsPage() {
		openPage("/profile/");
		return PageFactory.initElements(WebDriverManager.getDriver(), SettingsPage.class);
	}

	public static ConditionCoursePage goToCusoConditionCoursePage() {
		return goToPage(TemplatesEH.CUSO_CONDITION_COURSE, ConditionCoursePage.class);
	}

	public static CusoManagementSelectorPage goToCusoManagementSelectorPage() {
		return goToPage(TemplatesEH.CUSO_MANAGEMENT_SELECTOR, CusoManagementSelectorPage.class);
	}

	public static PushStartPage goToPushSelectProductPage() {
		if (Settings.isEnvironment(Environment.QA)) {
			WebDriverManager.getDriver().get("http://ihossain:Evd@y345hudson@push.qa1.everydayhealth.com");
		} else if (Settings.isEnvironment(Environment.STAGING2)) {
			WebDriverManager.getDriver().get("http://ihossain:Evd@y345hudson@push.staging.everydayhealth.com");
		} else if (Settings.isEnvironment(Environment.DEV)) {
			WebDriverManager.getDriver().get("http://ihossain:Evd@y345hudson@push.dev.everydayhealth.com");
		} else {
			WebDriverManager.getDriver().get("http://ihossain:Evd@y345hudson@push.everydayhealth.com");
		}
		return PageFactory.initElements(WebDriverManager.getDriver(), PushStartPage.class);
	}

	public static PushEditPageBasePage goToPushCreateTestPage() {
		RemoteWebDriver webDriver = WebDriverManager.getDriver();
		webDriver.manage().window().maximize();
		webDriver.get("http://push.staging.everydayhealth.com/page/new?type=testpage");
		return PageFactory.initElements(webDriver, PushEditPageBasePage.class);
	}

	public static PushEditPageBasePage goToMasterContentTestPage() {
		RemoteWebDriver webDriver = WebDriverManager.getDriver();
		webDriver.manage().window().maximize();
		webDriver.get("http://push.staging.everydayhealth.com/page/edit/326882");
		return PageFactory.initElements(webDriver, PushEditPageBasePage.class);
	}

	public static ResourceCenterPage goToResourceCenterPage() {
		if (Settings.isEnvironment(Environment.PROD)) {
			return goToPage(TemplatesEH.RESOURCE_CENTER_V3_PROD, ResourceCenterPage.class);
		} else {
			return goToPage(TemplatesEH.RESOURCE_CENTER_V3, ResourceCenterPage.class);
		}
	}

	public static BlogIndexPage goToBlogIndexPage() {
		return goToPage(TemplatesEH.BLOGS_INDEX, BlogIndexPage.class);
	}

	public static VideoLandingPage goToVideoLandingPage() {
		return goToPage(TemplatesEH.VIDEO_LANDING_PAGE, VideoLandingPage.class);
	}

	public static CusoVideologuesPage goToCusoVideologuesSingleTabPage() {
		return goToPage(TemplatesEH.CUSO_VIDEOLOGUES_SINGLE_TAB, CusoVideologuesPage.class);
	}

	public static CusoVideologuesPage goToCusoVideologuesMultibleTabsPage() {
		return goToPage(TemplatesEH.CUSO_VIDEOLOGUES_MULTIPLE_TABS, CusoVideologuesPage.class);
	}

	public static MasterLandingPage goToMasterLandingPage() {
		return goToPage(TemplatesEH.MASTER_LANDING_PAGE, MasterLandingPage.class);
	}

	public static MasterContentPage goToMasterContentPage() {
		if (Settings.isEnvironment(Environment.PROD)) {
			return goToPage(TemplatesEH.MASTER_CONTENT_PAGE_PROD, MasterContentPage.class);
		} else {
			return goToPage(TemplatesEH.MASTER_CONTENT_PAGE, MasterContentPage.class);
		}
	}

	public static PhotoGalleryPage goToPhotoGalleryPage() {
		if (Settings.isMobile()) {
			return openPage("/yk-photo-gallery-test-page/?isautomation=true", PhotoGalleryPage.class);
		} else {
			return goToPage(TemplatesEH.PHOTO_GALLERY, PhotoGalleryPage.class);
		}
	}

	public static VisualizerLitePage goToVisualizerLitePage() {
		return goToPage(TemplatesEH.VISUALIZER_LITE_PAGE, VisualizerLitePage.class);
	}
}
