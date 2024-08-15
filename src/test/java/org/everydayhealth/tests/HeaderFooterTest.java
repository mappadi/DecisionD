package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.EHPublicPage;
import everydayhealth.pages.GlobalNavHeader;
import everydayhealth.pages.PublicFooterZD;
import everydayhealth.pages.PublicHeaderCCR;
import everydayhealth.pages.PublicHeaderEH;
import everydayhealth.pages.articles.ArticleBasePage;
import everydayhealth.pages.articles.ArticleNewTemplatePage;
import everydayhealth.pages.articles.CusoArticleV3Page;
import everydayhealth.pages.articles.CusoLandingLobbyPage;
import everydayhealth.pages.articles.CusoManagementSelectorPage;
import everydayhealth.pages.articles.CusoVideologuesPage;
import everydayhealth.pages.articles.CustomSolutionsTemplatePage;
import everydayhealth.pages.articles.InfographicsPage;
import everydayhealth.pages.articles.PhotoGalleryPage;
import everydayhealth.pages.articles.SimpleQuizPage;
import everydayhealth.pages.articles.SlideshowBasePage;
import everydayhealth.pages.columns.BlogArticlePage;
import everydayhealth.pages.columns.BlogAuthorPage;
import everydayhealth.pages.columns.BlogIndexPage;
import everydayhealth.pages.columns.BlogLandingPage;
import everydayhealth.pages.conditions.CategoryLandingPage;
import everydayhealth.pages.conditions.ConditionCenterLandingPage;
import everydayhealth.pages.conditions.ConditionCenterTopicPage;
import everydayhealth.pages.conditions.ConditionCoursePage;
import everydayhealth.pages.conditions.HealthAZLandingPage;
import everydayhealth.pages.drugs.DrugsByClassPage;
import everydayhealth.pages.drugs.DrugsByLetterPage;
import everydayhealth.pages.drugs.DrugsLandingPage;
import everydayhealth.pages.drugs.DrugsProfilePage;
import everydayhealth.pages.drugs.DrugsReviewsPage;
import everydayhealth.pages.guides.GuidesBasePage;
import everydayhealth.pages.html.HtmlBasePage;
import everydayhealth.pages.landingpages.MasterContentPage;
import everydayhealth.pages.landingpages.MasterLandingPage;
import everydayhealth.pages.landingpages.NewsLandingPage;
import everydayhealth.pages.landingpages.VideoLandingPage;
import everydayhealth.pages.lifehack.LifehackPage;
import everydayhealth.pages.login.ForgotPasswordPage;
import everydayhealth.pages.login.LoginPageEH;
import everydayhealth.pages.program.ProgramPage;
import everydayhealth.pages.recipes.RecipesPage;
import everydayhealth.pages.resourceCenter.ResourceCenterPage;
import everydayhealth.pages.search.SearchOverlay;
import framework.Logger;
import framework.Settings;
import framework.platform.DatePatterns;
import framework.platform.Environment;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.DateUtils;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Header Footer Test
 */

public class HeaderFooterTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C214317"})
	@TestRail(id = "C214317")
	public void verifyHeaderAndFooterOnForgotPasswordPage() {
		Logger.info("Verifying the header and footer on forgot password page");
		ForgotPasswordPage forgotPasswordPage = SiteNavigatorEH.goToMainPageEH().onHeaderCCR().openLoginPage().clickForgotPassword();
		verifyGlobalNavHeader(forgotPasswordPage);
		verifyZDFooter(forgotPasswordPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C214318"})
	@TestRail(id = "C214318")
	public void verifyHeaderAndFooterOnLoginPage() {
		Logger.info("Verifying the header and footer on login page");
		LoginPageEH loginPageEH = SiteNavigatorEH.goToMainPageEH().onHeaderCCR().openLoginPage();
		verifyElements(loginPageEH, false);
		verifyZDFooter(loginPageEH);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C214319"})
	@TestRail(id = "C214319")
	public void verifyHeaderAndFooterOnCCRArticlePage() {
		Logger.info("Verifying the header and footer on CCR article page");
		ArticleBasePage ccrArticlePage = SiteNavigatorEH.goToCCRArticlePageEH(TemplatesEH.CCR_ARTICLE);
		verifyGlobalNavHeader(ccrArticlePage);
		verifyZDFooter(ccrArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C214320"})
	@TestRail(id = "C214320")
	public void verifyHeaderAndFooterOnCCRLandingPage() {
		Logger.info("Verifying the header and footer on CCR article page");
		ConditionCenterLandingPage ccrLandingPage = SiteNavigatorEH.goToCCRLandingPageEH(TemplatesEH.LANDING);
		verifyGlobalNavHeader(ccrLandingPage);
		verifyZDFooter(ccrLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C214321"})
	@TestRail(id = "C214321")
	public void verifyHeaderAndFooterOnCCRTopicPage() {
		Logger.info("Verifying the header and footer on CCR topic page");
		ConditionCenterTopicPage ccrTopicPage = SiteNavigatorEH.goToCCRTopicPageEH(TemplatesEH.TOPIC_LANDING);
		verifyGlobalNavHeader(ccrTopicPage);
		verifyZDFooter(ccrTopicPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C214322"})
	@TestRail(id = "C214322")
	public void verifyHeaderAndFooterOnHomePage() {
		Logger.info("Verifying the header and footer on Home page");
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		verifyGlobalNavHeader(ehPublicPage);
		verifyZDFooter(ehPublicPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C214323"})
	@TestRail(id = "C214323")
	public void verifyHeaderAndFooterOnGuidesPage() {
		Logger.info("Verifying the header and footer on Guides page");
		GuidesBasePage guidesPage = SiteNavigatorEH.goToPage(TemplatesEH.GUIDE, GuidesBasePage.class);
		verifyGlobalNavHeader(guidesPage);
		verifyZDFooter(guidesPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C214324"})
	@TestRail(id = "C214324")
	public void verifyHeaderAndFooterOnHealthAZLandingPage() {
		Logger.info("Verifying the header and footer on HealthAZ Landing page");
		HealthAZLandingPage healthAZLandingPage = SiteNavigatorEH.goToHealthAZLandingPage();
		verifyGlobalNavHeader(healthAZLandingPage);
		verifyZDFooter(healthAZLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C214325"})
	@TestRail(id = "C214325")
	public void verifyHeaderAndFooterOnInfographicsPage() {
		Logger.info("Verifying the header and footer on Infographics page");
		InfographicsPage infographicsPage = SiteNavigatorEH.goToInfographicsPage(TemplatesEH.INFOGRAPHIC.getTemplateURL());
		verifyGlobalNavHeader(infographicsPage);
		verifyZDFooter(infographicsPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "HeaderFooterTest", "CusoSlideshowTest", "C234756"})
	@TestRail(id = "C234756")
	public void verifyHeaderAndFooterOnCusoSlideshowPage() {
		Logger.info("Verifying the header and footer on Cuso Slideshow page");
		SlideshowBasePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, SlideshowBasePage.class);
		verifyGlobalNavHeader(cusoSlideshowPage);
		verifyZDFooter(cusoSlideshowPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleTest", "C234755"})
	@TestRail(id = "C234755")
	public void verifyHeaderAndFooterOnCusoArticlePage() {
		Logger.info("Verifying the header and footer on Cuso Article page");
		CustomSolutionsTemplatePage cusoArticle = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE);
		verifyGlobalNavHeader(cusoArticle);
		verifyZDFooter(cusoArticle);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "HeaderFooterTest", "CusoManagementSelectorTest", "C216470"})
	@TestRail(id = "C216470")
	public void verifyHeaderAndFooterOnCusoManagementSelectorPage() {
		Logger.info("Verifying the header and footer on Cuso Management Selector page");
		CusoManagementSelectorPage cusoPage = SiteNavigatorEH.goToCusoManagementSelectorPage();
		verifyGlobalNavHeader(cusoPage);
		verifyZDFooter(cusoPage);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "HeaderFooterTest", "ConditionCourse", "C235234"})
	@TestRail(id = "C235234")
	public void verifyHeaderAndFooterOnCusoConditionCoursePage() {
		Logger.info("Verifying the header and footer on Cuso Condition Course page");
		ConditionCoursePage conditionCoursePage = SiteNavigatorEH.goToCusoConditionCoursePage();
		verifyGlobalNavHeader(conditionCoursePage);
		verifyZDFooter(conditionCoursePage);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "HeaderFooterTest", "CusoVideologues", "C235236"})
	@TestRail(id = "C235236")
	public void verifyHeaderAndFooterOnCusoVideologuesPage() {
		Logger.info("Verifying the header and footer on Cuso Videologues page");
		CusoVideologuesPage videologuesPage = SiteNavigatorEH.goToCusoVideologuesSingleTabPage();
		verifyGlobalNavHeader(videologuesPage);
		verifyZDFooter(videologuesPage);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "HeaderFooterTest", "CusoLandingLobbyTest", "C235235"})
	@TestRail(id = "C235235")
	public void verifyHeaderAndFooterOnCusoLandingLobbyPage() {
		Logger.info("Verifying the header and footer on Cuso Landing lobby page");
		CusoLandingLobbyPage cusoLandingLobby = SiteNavigatorEH.goToCusoLandingLobbyPage();
		verifyGlobalNavHeader(cusoLandingLobby);
		verifyZDFooter(cusoLandingLobby);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C235440"})
	@TestRail(id = "C235440")
	public void verifyHeaderAndFooterOnHtmlPage() {
		Logger.info("Verifying the header and footer on Html Calorie counter page");
		HtmlBasePage htmlPage = SiteNavigatorEH.goToPage(TemplatesEH.HTML_CALORIE_COUNTER, HtmlBasePage.class);
		verifyCCRHeaderRegion(htmlPage);
		verifyZDFooter(htmlPage);
		Logger.info("Verifying the header and footer on Html Diabetes meal planner page");
		SiteNavigatorEH.goToPage(TemplatesEH.HTML_DIABETES_MEAL_PLANNER, HtmlBasePage.class);
		verifyCCRHeaderRegion(htmlPage);
		verifyZDFooter(htmlPage);
		Logger.info("Verifying the header and footer on Html meal planner page");
		SiteNavigatorEH.goToPage(TemplatesEH.HTML_MEAL_PLANNER, HtmlBasePage.class);
		verifyCCRHeaderRegion(htmlPage);
		verifyZDFooter(htmlPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C235166"})
	@TestRail(id = "C235166")
	public void verifyHeaderAndFooterOnProgramPage() {
		Logger.info("Verifying the header and footer on Program page");
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);
		verifyGlobalNavHeader(programPage);
		verifyZDFooter(programPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C238575"})
	@TestRail(id = "C238575")
	public void verifyHeaderAndFooterOnDrugsLandingPage() {
		Logger.info("Verifying the header and footer on Drugs landing page");
		DrugsLandingPage drugsPage = SiteNavigatorEH.goToDrugsLandingPage();
		verifyGlobalNavHeader(drugsPage);
		verifyZDFooter(drugsPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C238578"})
	@TestRail(id = "C238578")
	public void verifyHeaderAndFooterOnDrugsSearchPage() {
		Logger.info("Verifying the header and footer on Drugs search page");
		DrugsLandingPage drugsPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_SEARCH, DrugsLandingPage.class);
		verifyGlobalNavHeader(drugsPage);
		verifyZDFooter(drugsPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C238576"})
	@TestRail(id = "C238576")
	public void verifyHeaderAndFooterOnDrugsProfilePage() {
		Logger.info("Verifying the header and footer on Drugs profile page");
		DrugsProfilePage drugsPage = SiteNavigatorEH.goToDrugProfilePage();
		verifyGlobalNavHeader(drugsPage);
		verifyZDFooter(drugsPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C238580"})
	@TestRail(id = "C238580")
	public void verifyHeaderAndFooterOnDrugsByLetterPage() {
		Logger.info("Verifying the header and footer on Drugs By letter page");
		DrugsByLetterPage drugsPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_LETTER, DrugsByLetterPage.class);
		verifyGlobalNavHeader(drugsPage);
		verifyZDFooter(drugsPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C238579"})
	@TestRail(id = "C238579")
	public void verifyHeaderAndFooterOnDrugsByClassPage() {
		Logger.info("Verifying the header and footer on Drugs By class page");
		DrugsByClassPage drugsPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_CLASS, DrugsByClassPage.class);
		verifyGlobalNavHeader(drugsPage);
		verifyZDFooter(drugsPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C238577"})
	@TestRail(id = "C238577")
	public void verifyHeaderAndFooterOnDrugsReviewPage() {
		Logger.info("Verifying the header and footer on Drugs review page");
		DrugsReviewsPage drugsPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_REVIEW, DrugsReviewsPage.class);
		verifyGlobalNavHeader(drugsPage);
		verifyZDFooter(drugsPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleMLRTest", "HeaderFooterTest", "C260074"})
	@TestRail(id = "C260074")
	public void verifyHeaderAndFooterOnCusoArticleMLRPage() {
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			Logger.info("Verifying the header and footer on Cuso Article MLR page");
			CustomSolutionsTemplatePage cusoArticle = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE_MLR);
			verifyHeaderRegion(cusoArticle);
			verifyZDFooter(cusoArticle);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowMLRTest", "HeaderFooterTest", "C260082"})
	@TestRail(id = "C260082")
	public void verifyHeaderAndFooterOnCusoSlideshowMLRPage() {
		if (Settings.isEnvironment(Environment.QA) || Settings.isEnvironment(Environment.STAGE)) {
			Logger.info("Verifying the header and footer on Cuso Slideshow MLR page");
			CustomSolutionsTemplatePage cusoSlideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW_MLR, CustomSolutionsTemplatePage.class);
			verifyHeaderRegion(cusoSlideshowPage);
			verifyZDFooter(cusoSlideshowPage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C260748"})
	@TestRail(id = "C260748")
	public void verifyHeaderAndFooterOnRecipesPage() {
		RecipesPage recipesPage = SiteNavigatorEH.goToPage(TemplatesEH.RECIPES, RecipesPage.class);
		verifyGlobalNavHeader(recipesPage);
		verifyZDFooter(recipesPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3MLRTest", "HeaderFooterTest", "C265618"})
	@TestRail(id = "C265618")
	public void verifyHeaderAndFooterOnCUSOArticleV3MLRPage() {
		CusoArticleV3Page cusoArticleV3Page = SiteNavigatorEH.goToCusoArticleV3MLRPage();
		verifyGlobalNavHeader(cusoArticleV3Page);
		verifyZDFooter(cusoArticleV3Page);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleV3Test", "HeaderFooterTest", "C340542"})
	@TestRail(id = "C340542")
	public void verifyHeaderAndFooterOnCUSOArticleV3Page() {
		CusoArticleV3Page cusoArticleV3Page = SiteNavigatorEH.goToCusoArticleV3Page();
		verifyGlobalNavHeader(cusoArticleV3Page);
		verifyZDFooter(cusoArticleV3Page);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C306779"})
	@TestRail(id = "C306779")
	public void verifyHeaderAndFooterOnSlideshowV3Page() {
		SlideshowBasePage slideshowPage = SiteNavigatorEH.goToPage(TemplatesEH.SLIDESHOW, SlideshowBasePage.class);
		verifyGlobalNavHeader(slideshowPage);
		verifyZDFooter(slideshowPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "C306815"})
	@TestRail(id = "C306815")
	public void verifyHeaderAndFooterOnLifehackPage() {
		LifehackPage lifehackPage = SiteNavigatorEH.goToPage(TemplatesEH.LIFEHACK_PAGE, LifehackPage.class);
		verifyGlobalNavHeader(lifehackPage);
		verifyZDFooter(lifehackPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "ResourceCenterTest", "C309827"})
	@TestRail(id = "C309827")
	public void verifyHeaderAndFooterOnResourceCenterPage() {
		ResourceCenterPage resourceCenterPage = SiteNavigatorEH.goToResourceCenterPage();
		verifyGlobalNavHeader(resourceCenterPage);
		verifyZDFooter(resourceCenterPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "HeaderFooterTest", "BlogIndexTest", "C312196"})
	@TestRail(id = "C312196")
	public void verifyHeaderAndFooterOnBlogIndexPage() {
		BlogIndexPage blogIndexPage = SiteNavigatorEH.goToBlogIndexPage();
		verifyGlobalNavHeader(blogIndexPage);
		verifyZDFooter(blogIndexPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "HeaderFooterTest", "BlogArticleTest", "C326693"})
	@TestRail(id = "C326693")
	public void verifyHeaderAndFooterOnBlogArticlePage() {
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);
		verifyGlobalNavHeader(blogArticlePage);
		verifyZDFooter(blogArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "VLPageTest", "HeaderFooterTest", "C314442"})
	@TestRail(id = "C314442")
	public void verifyHeaderAndFooterOnVideoLandingPage() {
		VideoLandingPage videoLandingPage = SiteNavigatorEH.goToVideoLandingPage();
		verifyGlobalNavHeader(videoLandingPage);
		verifyZDFooter(videoLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "HeaderFooterTest", "BlogLandingTest", "C328315"})
	@TestRail(id = "C328315")
	public void verifyHeaderAndFooterOnBlogMultipleAuthorLandingPage() {
		BlogLandingPage blogLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_MULTIPLE_AUTHORS, BlogLandingPage.class);
		verifyGlobalNavHeader(blogLandingPage);
		verifyZDFooter(blogLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "HeaderFooterTest", "BlogLandingTest", "C330386"})
	@TestRail(id = "C330386")
	public void verifyHeaderAndFooterOnBlogSingleAuthorLandingPage() {
		BlogLandingPage blogLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_SINGLE_AUTHOR, BlogLandingPage.class);
		verifyGlobalNavHeader(blogLandingPage);
		verifyZDFooter(blogLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "HeaderFooterTest", "CategoryPageTest", "C344816"})
	@TestRail(id = "C344816")
	public void verifyHeaderAndFooterOnCategoryPage() {
		CategoryLandingPage categoryLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_LANDING, CategoryLandingPage.class);
		verifyGlobalNavHeader(categoryLandingPage);
		verifyZDFooter(categoryLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "HeaderFooterTest", "CategoryPageTest", "C344820"})
	@TestRail(id = "C344820")
	public void verifyHeaderAndFooterOnCategoryAllArticlesPage() {
		ConditionCenterLandingPage categoryAllArticlesPage = SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_ALL_ARTICLES, ConditionCenterLandingPage.class);
		verifyGlobalNavHeader(categoryAllArticlesPage);
		verifyZDFooter(categoryAllArticlesPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "HeaderFooterTest", "BlogAuthorTest", "C346369"})
	@TestRail(id = "C346369")
	public void verifyHeaderAndFooterOnBlogAuthorPage() {
		BlogAuthorPage blogAuthorPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOGS_AUTHOR, BlogAuthorPage.class);
		verifyGlobalNavHeader(blogAuthorPage);
		verifyZDFooter(blogAuthorPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "HeaderFooterTest", "NewsLandingTest", "C347272"})
	@TestRail(id = "C347272")
	public void verifyHeaderAndFooterOnNewsLandingPage() {
		NewsLandingPage newsLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.NEWS_LANDING_PAGE, NewsLandingPage.class);
		verifyGlobalNavHeader(newsLandingPage);
		verifyZDFooter(newsLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "HeaderFooterTest", "MasterLanding", "C348611"})
	@TestRail(id = "C348611")
	public void verifyHeaderAndFooterOnMasterLandingPage() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();
		verifyGlobalNavHeader(masterLandingPage);
		verifyZDFooter(masterLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "HeaderFooterTest", "MasterContentTest", "C376029"})
	@TestRail(id = "C376029")
	public void verifyHeaderAndFooterOnMasterContentPage() {
		MasterContentPage masterContentPage = SiteNavigatorEH.goToMasterContentPage();
		verifyGlobalNavHeader(masterContentPage);
		verifyZDFooter(masterContentPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "SimpleQuizTest", "C672606"})
	@TestRail(id = "C672606")
	public void verifyHeaderAndFooterOnSimpleQuizPage() {
		SimpleQuizPage simpleQuizPage = SiteNavigatorEH.goToPage(TemplatesEH.SIMPLE_QUIZ, SimpleQuizPage.class);
		verifyGlobalNavHeader(simpleQuizPage);
		verifyZDFooter(simpleQuizPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HeaderFooterTest", "PhotoGalleryTest", "C678293"})
	@TestRail(id = "C678293")
	public void verifyHeaderAndFooterOnPhotoGalleryPage() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPage(TemplatesEH.PHOTO_GALLERY, PhotoGalleryPage.class);
		verifyGlobalNavHeader(photoGalleryPage);
		verifyZDFooter(photoGalleryPage);
	}

	public void verifyGlobalNavHeader(BasicPageEH basicPageEH) {
		Logger.info("Verify legal text message");
		verifyLegalTextMessage(basicPageEH);
		Logger.info("Verify global nav header elements");
		verifyElements(basicPageEH, false);
		basicPageEH.onGlobalNavHeader().loginWithUserAndOpenPage(UserCacheEH.MAIN_USER, BasicPageEH.class);
		Logger.info("Verify global nav header elements for logged in user");
		verifyElements(basicPageEH, true);
	}

	private void verifyElements(BasicPageEH basicPageEH, boolean isLoggedIn) {
		GlobalNavHeader globalNavHeader = basicPageEH.onGlobalNavHeader();
		assertTrue(globalNavHeader.isEhLogoVisible(), "'Everyday Health' logo should be visible");
		assertTrue(globalNavHeader.isHamburgerMenuIconVisible(), "Hamburger menu icon should be visible");
		if (isLoggedIn) {
			assertTrue(globalNavHeader.isMyProfileIconVisible(), "'My Profile' icon should be visible");
		} else {
			assertTrue(globalNavHeader.isLoginIconVisible(), "'Login' button icon should be visible");
		}
		assertTrue(globalNavHeader.isSearchIconVisible(), "'Search' button icon should be visible");
		if (!Settings.isMobile()) {
			assertTrue(globalNavHeader.isHamburgerMenuLabelVisible(), "Hamburger 'Menu' label should be visible");
			assertTrue(globalNavHeader.isSubscribeIconVisible(), "'Subscribe' button icon should be visible");
			assertTrue(globalNavHeader.isSubscribeLabelVisible(), "'Subscribe' label should be visible");
			assertTrue(globalNavHeader.isSearchIconVisible(), "'Subscribe' button icon should be visible");
			if (isLoggedIn) {
				assertTrue(globalNavHeader.isMyProfileLabelVisible(), "'My Profile' label should be visible");
			} else {
				assertTrue(globalNavHeader.isLogInLabelVisible(), "'Login' label should be visible");
			}
			assertTrue(globalNavHeader.isSearchLabelVisible(), "'Search' label should be visible");
		}

		int ehLogoXvalue = globalNavHeader.getEhLogoXCoordinate();
		int hamburgerMenuXvalue = globalNavHeader.getHamburgerMenuButtonXCoordinate();
		int loginXvalue = isLoggedIn ? globalNavHeader.getMyProfileButtonXCoordinate() : globalNavHeader.getLoginButtonXCoordinate();
		int searchXvalue = globalNavHeader.getSearchButtonXCoordinate();

		assertTrue(ehLogoXvalue < hamburgerMenuXvalue, "'Everyday Health' logo should be on first position from the left side");
		if (!Settings.isMobile()) {
			int subscribeXvalue = globalNavHeader.getSubscribeButtonXCoordinate();
			assertTrue((ehLogoXvalue < hamburgerMenuXvalue) && (hamburgerMenuXvalue < subscribeXvalue), "Hamburger menu icon should be on second position from the left side");
			assertTrue(subscribeXvalue < loginXvalue, "'Subscribe' icon should be on third position from the left side");
		} else {
			assertTrue((ehLogoXvalue < hamburgerMenuXvalue) && (hamburgerMenuXvalue < loginXvalue), "Hamburger menu icon should be on second position from the left side");
		}
		assertTrue(loginXvalue < searchXvalue, "'Login' icon should be on 4th position from the left side");

		globalNavHeader.menuButtonClick();
		if (!Utils.getCurrentURL().contains("photogallery")) {
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event121", "event121 should be fired");
		}
		assertTrue(globalNavHeader.isMenuDrawerVisible(), "Menu drawer should be visible");
		globalNavHeader.menuButtonClick();
		if (!Settings.isMobile()) {
			assertTrue(globalNavHeader.getSubscribeButtonHrefValue().contains("/newsletter-subscriptions/signup/"), "'Subscribe' button should lead to newsletter sign up page");
		}
		if (isLoggedIn) {
			globalNavHeader.clickMyProfileButton();
			if (!Utils.getCurrentURL().contains("photogallery")) {
				assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event123", "event123 should be fired");
			}
			assertTrue(globalNavHeader.isProfileOverlayItemVisible("Following Topics"), "'Following Topics' profile overlay item is not visible");
			assertTrue(globalNavHeader.isProfileOverlayItemVisible("Saved Items"), "'Saved Items' profile overlay item is not visible");
			assertTrue(globalNavHeader.isProfileOverlayItemVisible("Newsletters"), "'Newsletters' profile overlay item is not visible");
			assertTrue(globalNavHeader.isProfileOverlayItemVisible("Tools"), "'Tools' profile overlay item is not visible");
			if (!Settings.isMobile()) {
				assertTrue(globalNavHeader.isProfileOverlayItemVisible("Settings"), "'Settings' profile overlay item is not visible");
				assertTrue(globalNavHeader.isProfileOverlayItemVisible("Logout"), "'Logout' profile overlay item is not visible");
			}
			assertTrue(globalNavHeader.isMyProfileCloseIconVisible(), "'My Profile' 'Close' (X) icon should be visible");
			assertTrue(globalNavHeader.isMyProfileCloseIconGreen(), "'My Profile' 'Close' (X) icon should be green");
			globalNavHeader.clickMyProfileCloseIcon();

		} else {
			assertTrue(globalNavHeader.getLoginButtonHrefValue().contains("/login/"), "'Login' button should lead to login page");
		}
		SearchOverlay searchOverlay = globalNavHeader.clickSearchButton();
		if (!Utils.getCurrentURL().contains("photogallery")) {
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event124", "event124 should be fired");
		}
		assertTrue(searchOverlay.isSearchFormVisible(), "Search form should be visible");
		assertTrue(searchOverlay.isSearchCloseIconVisible(), "Search 'Close' (X) icon should be visible");
		assertTrue(globalNavHeader.isSearchCloseIconGreen(), "'Search' 'Close' (X) icon should be green");
		searchOverlay.enterSearchTerm("diabetes");
		assertTrue(searchOverlay.isClearButtonVisible(), "'Clear' button should be visible");
		//According to EHF-678 recipes will be updated, no need to fix it.
		if (!Utils.getCurrentURL().contains("/recipes/raspberries/")) {
			assertTrue(searchOverlay.isAutosuggestionsListVisible(), "Autosuggestions list should be visible");
		}
		searchOverlay.clickSearchCloseIcon();
		assertTrue(globalNavHeader.getSubscribeButtonHrefValue().endsWith("?iid=gnav_head_sub"), "'Subscribe' button url should be appended with '?iid=gnav_head_sub'");
		verifyMenuDrawerUrls(globalNavHeader);
		if (isLoggedIn) {
			assertTrue(globalNavHeader.getProfileOverlayItemHref(1, "Following Topics").endsWith("?iid=gnav_pro_ft"), "'Following Topics' url should be appended with '?iid=gnav_pro_ft'");
			assertTrue(globalNavHeader.getProfileOverlayItemHref(1, "Saved Items").endsWith("?iid=gnav_pro_si"), "'Saved Items' url should be appended with '?iid=gnav_pro_si'");
			assertTrue(globalNavHeader.getProfileOverlayItemHref(1, "Newsletters").endsWith("?iid=gnav_pro_nl"), "'Newsletters' url should be appended with '?iid=gnav_pro_nl'");
			globalNavHeader.clickMyProfileCloseIcon();
		}
	}

	private void verifyMenuDrawerUrls(GlobalNavHeader globalNavHeader) {
		globalNavHeader.menuButtonClick();
		assertEquals(globalNavHeader.getConditionsHeadlineBorderColor(), "rgb(0, 93, 133)", "'Conditions' section border should be blue");
		assertEquals(globalNavHeader.getHealthyLivingHeadlineBorderColor(), "rgb(214, 60, 115)", "'Healthy Living' section border should be pink");
		assertEquals(globalNavHeader.getHealthToolsBorderColor(), "rgb(123, 150, 41)", "'Health Tools' section border should be olive");
		if (globalNavHeader.isMenuDrawerCCRSectionVisible()) {
			assertTrue(globalNavHeader.isMenuHeaderVisible(1), "CCR Menu header should be visible");
			String ccrMenuHeader = globalNavHeader.getMenuHeaderText(1).toLowerCase().replace(" ", "-");
			Logger.info("Verify CCR links");
			int numberOfCcrLinks = globalNavHeader.getNumberOfCCRLinks();
			for (int link = 1; link <= numberOfCcrLinks; link++) {
				assertTrue(globalNavHeader.getHrefOfCCRLink(link).contains("?iid=gnav_"), "All CCR links should be appended with '?iid=gnav_'");
				if (link == numberOfCcrLinks) {
					String ccrLandingUrl = Settings.getDefaultUrl() + "/" + ccrMenuHeader + "/?iid=gnav";
					assertTrue(globalNavHeader.getHrefOfCCRLink(link).contains(ccrLandingUrl), "'View all' link in CCR section should lead to CCR landing page");
				}
			}
		}
		assertTrue(globalNavHeader.isMenuHeaderVisible("Conditions"), "'Conditions' header should be visible in menu drawer");
		Logger.info("Verify condition links");
		int numberOfConditionLinks = globalNavHeader.getNumberOfConditionLinks();
		for (int link = 1; link <= numberOfConditionLinks; link++) {
			String conditionText = globalNavHeader.getConditionText(link);
			if (conditionText.equalsIgnoreCase("Type 2 diabetes")) {
				assertTrue(globalNavHeader.getHrefOfCConditionLink(link).endsWith("?iid=gnav_nav_t2d"));
				continue;
			} else if (conditionText.equalsIgnoreCase("view all")) {
				conditionText = "conditions";
			} else if (conditionText.contains(" ")) {
				conditionText = conditionText.split(" ")[0];
			}
			assertTrue(globalNavHeader.getHrefOfCConditionLink(link).endsWith("?iid=gnav_nav_" + conditionText.toLowerCase()), "Condition links should be appended with '?iid=gnav_nav_CONDITION'");
		}

		assertTrue(globalNavHeader.isConditionToolVisible("Drugs A-Z"), "Tool 'Drugs A-Z' should be visible");
		assertTrue(globalNavHeader.isConditionToolFontBold("Drugs A-Z"), "'Drugs A-Z' font should be bold");
		assertTrue(globalNavHeader.getHrefOfConditionToolsLink(1, "Drugs A-Z").endsWith("?iid=gnav_nav_drugs"), "'Drugs A-Z' url should be appended with '?iid=gnav_nav_drugs'");
		assertTrue(globalNavHeader.isConditionToolVisible("Symptom Checker"), "Tool 'Symptom Checker' should be visible");
		assertTrue(globalNavHeader.isConditionToolFontBold("Symptom Checker"), "'Symptom Checker' font should be bold");
		assertTrue(globalNavHeader.getHrefOfConditionToolsLink(1, "Symptom Checker").endsWith("?iid=gnav_nav_symptom"), "'Symptom Checker' url should be appended with '?iid=gnav_nav_symptom'");

		assertTrue(globalNavHeader.isMenuHeaderVisible("Healthy Living"), "'Healthy Living' header should be visible in menu drawer");
		Logger.info("Verify Healthy living links");
		int numberOfHealthyLivingLinks = globalNavHeader.getNumberOfHLLinks();
		for (int link = 1; link <= numberOfHealthyLivingLinks; link++) {
			String healthyLivingText = globalNavHeader.getHLText(link).toLowerCase();
			if (healthyLivingText.equalsIgnoreCase("view all")) {
				healthyLivingText = "healthy";
				assertTrue(globalNavHeader.getHrefOfHLLink(link).endsWith("?iid=gnav_nav_" + healthyLivingText.toLowerCase()), "Healthy living link 'View all' should be appended with '?iid=gnav_nav_healthy'");
				continue;
			} else if (healthyLivingText.contains(" ")) {
				healthyLivingText = healthyLivingText.split(" ")[0];
			}
			assertTrue(globalNavHeader.getHrefOfHLLink(link).endsWith("?iid=gnav_hl_" + healthyLivingText), "Healthy living links should be appended with '?iid=gnav_hl_HEALTHY_LIVING'");
		}
		assertTrue(globalNavHeader.isMenuHeaderVisible("Health Tools"), "'Health tools' header should be visible in menu drawer");
		Logger.info("Verify Tools links");
		int numberOfToolsLinks = globalNavHeader.getNumberOfToolsLinks();
		for (int link = 1; link <= numberOfToolsLinks; link++) {
			String toolText = globalNavHeader.getToolText(link).toLowerCase();
			if (toolText.contains("daily")) {
				continue;
			} else if (toolText.contains(" ")) {
				toolText = toolText.split(" ")[0];
			}

			assertTrue(globalNavHeader.getHrefOfToolsLink(link).endsWith("?iid=gnav_tool_" + toolText), "Tools links should be appended with '?iid=gnav_tool_TOOL'");
		}
		assertTrue(globalNavHeader.isMenuDrawerSubscribeLinkVisible(), "'Subscribe' link should be visible on menu drawer");
		assertTrue(globalNavHeader.isMenuCloseIconVisible(), "'Menu' 'Close' icon (X) should be visible");
		assertTrue(globalNavHeader.isMenuCloseIconGreen(), "'Menu' 'Close' (X) icon should be green");
		globalNavHeader.clickMenuCloseIcon();
	}

	public void verifyCCRHeaderRegion(BasicPageEH basicPageEH) {
		Logger.info("Verify the CCR Header elements on the page");
		PublicHeaderCCR publicHeaderCCR = basicPageEH.onHeaderCCR();
		assertTrue(publicHeaderCCR.isHeaderLogoVisible(), "Header Logo not visible");
		assertTrue(publicHeaderCCR.isSearchIconVisible(), "Search icon not visible");
		if (!Settings.isMobile()) {
			assertTrue(publicHeaderCCR.isExploreLinkVisible(), "Explore Link not visible");
			assertTrue(publicHeaderCCR.isLoginLinkVisible(), "Login Link not visible");
		}
		assertTrue(publicHeaderCCR.isLoginIconVisible(), "Login Icon not visible");
	}

	public void verifyHeaderRegion(ArticleNewTemplatePage articleNewTemplatePage) {
		Logger.info("Verifying all header elements on page");
		PublicHeaderEH publicHeaderEH = articleNewTemplatePage.onHeader();
		assertTrue(publicHeaderEH.isLogoVisible(), "EH logo should be visible");
		if (Settings.isDesktop()) {
			assertTrue(publicHeaderEH.isSiteSearchBoxVisible(), "Site search box should be visible");
			assertTrue(publicHeaderEH.isSearchButtonVisible(), "'Search button' is not visible");
			assertTrue(publicHeaderEH.isLoginLinkVisible(), "'Login link' should be visible");
		} else {
			publicHeaderEH.clickHeaderMenuBar();
			assertTrue(publicHeaderEH.isSiteSearchBoxVisible(), "Site search box should be visible");
			assertTrue(publicHeaderEH.isSearchButtonVisible(), "'Search button' is not visible");
		}
	}

	public void verifyZDFooter(BasicPageEH basicPageEH) {
		PublicFooterZD publicFooterZD = basicPageEH.onZDFooter();
		String baseURL = Settings.getDefaultUrl();
		assertTrue(publicFooterZD.isFooterVisible(), "Footer should be visible");
		assertEquals(publicFooterZD.getFooterBackgroundColor(), "#2c353b", "Footer should have grey background");
		assertTrue(publicFooterZD.isEHLogoVisible(), "EH logo should be visible on footer");
		assertTrue(publicFooterZD.isFooterTextVisible(), "Text should be visible near the footer logo");
		assertEquals(publicFooterZD.getFooterText(),
				"Wellness inspired. Wellness enabled.",
				"Incorrect footer text is present");
		String fontFamilyLogo = publicFooterZD.getFooterTextCSSAttribute("font-family");
		if (Utils.getCurrentURL().contains("/recipes/raspberries/")) {
			Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHF-3618");
		}
		if (Settings.isMobile()) {
			assertTrue(fontFamilyLogo.startsWith("'open sans'"), "'font-family' should start with \"Open Sans\"");
		} else {
			assertTrue(fontFamilyLogo.startsWith("\"open sans\""), "'font-family' should start with \"Open Sans\"");
		}
		if (Utils.getCurrentURL().contains("/recipes/raspberries/")) {
			Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHF-3618");
		}
		assertTrue(fontFamilyLogo.endsWith("verdana"), "'font-family' should end with 'Verdana'");
		assertEquals(publicFooterZD.getFooterTextCSSAttribute("font-size"), "18px", "'font-size' should be '18px'");
		assertEquals(publicFooterZD.getFooterTextCSSAttribute("text-align"), "left", "'text-align' should be 'left'");
		assertEquals(publicFooterZD.getFooterTextCSSAttribute("color"),
				"rgba(255, 255, 255, 1)",
				"'color' should be 'rgba(255, 255, 255, 1)' (#ffffff)");

		assertTrue(publicFooterZD.isSocialBarVisible(), "Social bar should be visible on footer");
		assertTrue(publicFooterZD.isFacebookButtonVisible(), "'Facebook' social button should be visible");
		assertEquals(publicFooterZD.getFacebookButtonHrefValue(),
				"https://www.facebook.com/everydayhealth",
				"Incorrect FB link");
		assertTrue(publicFooterZD.isTwitterButtonVisible(), "'Twitter' social button should be visible");
		assertEquals(publicFooterZD.getTwitterButtonHrefValue(),
				"https://twitter.com/everydayhealth",
				"Incorrect Twitter link");
		assertTrue(publicFooterZD.isInstagramButtonVisible(), "'Instagram' social button should be visible");
		assertEquals(publicFooterZD.getInstagramButtonHrefValue(),
				"https://www.instagram.com/everydayhealth/",
				"Incorrect Instagram link");
		assertTrue(publicFooterZD.isPinterestButtonVisible(), "'Pinterest' social button should be visible");
		assertEquals(publicFooterZD.getPinterestButtonHrefValue(),
				"https://pinterest.com/everydayhealth/",
				"Incorrect Pinterest link");
		assertTrue(publicFooterZD.isGooglePlusButtonVisible(), "'Google Plus' social button should be visible");
		assertEquals(publicFooterZD.getGooglePlusButtonHrefValue(),
				"https://plus.google.com/+EverydayHealth/posts",
				"Incorrect Google Plus link");

		int numberOfEHLinks = publicFooterZD.getNumberOfEHLinksInFooter();
		assertEquals(numberOfEHLinks, 10, "10 EH links should be present in footer");
		if (!Settings.isMobile()) {
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 1),
					"About Us",
					"First link in first column should be 'About Us'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 1),
					baseURL + "/about-us/",
					"Incorrect 'About Us' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 2),
					"Newsletters",
					"Second link in first column should be 'Newsletters'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 2),
					baseURL + "/newsletter-subscriptions/signup/",
					"Incorrect 'Newsletters' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 3),
					"Health News",
					"Third link in first column should be 'Health News'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 3),
					baseURL + "/news/",
					"Incorrect 'Health News' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 4),
					"Our Sponsors",
					"Fourth link in first column should be 'Our Sponsors'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 4),
					baseURL + "/solutions/landing/sponsors/",
					"Incorrect 'Our Sponsors' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 1),
					"Feedback",
					"First link in second column should be 'Feedback'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 1),
					"https://www.cvent.com/Surveys/Welcome.aspx?s=3bf4d45a-b8ce-49e4-b24c-49d5e101ad05&refid=everydayhealth",
					"Incorrect 'Feedback' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 2),
					"Contact Us",
					"Second link in second column should be 'Contact Us'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 2),
					baseURL + "/contact-us/",
					"Incorrect 'Contact Us' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 3),
					"Careers",
					"Third link in second column should be 'Careers'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 3),
					"http://www.j2global.com/careers/job-search",
					"Incorrect 'Careers' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 4),
					"Terms of Use",
					"Fourth link in second column should be 'Terms of Use'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 4),
					baseURL + "/privacyterms/#everyday_health_terms_of_use",
					"Incorrect 'Terms of Use' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(3, 1),
					"Privacy Policy",
					"First link in third column should be 'Privacy Policy'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(3, 1),
					baseURL + "/privacyterms/#everyday_health_privacy_policy",
					"Incorrect 'Privacy Policy' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(3, 2),
					"Accessibility Statement",
					"Second link in third column should be 'Accessibility Statement'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(3, 2),
					baseURL + "/accessibility-statement/",
					"Incorrect 'Accessibility Statement' link destination");
			assertFalse(publicFooterZD.isAdChoiceLinkIconVisible(), "AdChoice link icon should not be visible");
			assertTrue(publicFooterZD.isZiffDavisLinksBlockVisible(), "Block with Ziff Davis links should be visible");
			assertEquals(publicFooterZD.getZiffDavisLinksDescription(),
					"More From Ziff Davis:",
					"Incorrect Ziff Davis links description");
			String fontFamilyMoreFromZD = publicFooterZD.getZiffDavisLinksDescriptionCSSAttribute("font-family");
			if (Settings.isMobile()) {
				assertTrue(fontFamilyMoreFromZD.startsWith("'open sans'"), "'font-family' should start with \"Open Sans\"");
			} else {
				assertTrue(fontFamilyMoreFromZD.startsWith("\"open sans\""), "'font-family' should start with \"Open Sans\"");
			}
			assertTrue(fontFamilyMoreFromZD.endsWith("verdana"), "'font-family' should end with 'Verdana'");
			assertEquals(publicFooterZD.getZiffDavisLinksDescriptionCSSAttribute("font-size"),
					"12px",
					"'font-size' should be '12px'");
			assertEquals(publicFooterZD.getZiffDavisLinksDescriptionCSSAttribute("color"),
					"rgba(204, 204, 204, 1)",
					"'color' should be 'rgba(204, 204, 204, 1)' (#cccccc)");
			assertEquals(publicFooterZD.getZiffDavisLinksDescriptionCSSAttribute("font-weight"),
					"600",
					"'font-weight' should be '600'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(1),
					"Computer Shopper",
					"1st ZD link should be 'Computer Shopper'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(1),
					"http://www.computershopper.com/",
					"Incorrect destination for 'Computer Shopper'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(2),
					"ExtremeTech",
					"2nd ZD link should be 'ExtremeTech'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(2),
					"http://www.extremetech.com/",
					"Incorrect destination for 'ExtremeTech'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(3),
					"Geek",
					"3rd ZD link should be 'Geek'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(3),
					"https://www.geek.com/",
					"Incorrect destination for 'Geek'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(4),
					"AskMen",
					"4th ZD link should be 'AskMen'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(4),
					"http://www.askmen.com/",
					"Incorrect destination for 'AskMen'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(5),
					"IGN",
					"5th ZD link should be 'IGN'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(5),
					"http://www.ign.com/",
					"Incorrect destination for 'IGN'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(6),
					"Offers.com",
					"6th ZD link should be 'Offers.com'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(6),
					"https://www.offers.com/",
					"Incorrect destination for 'Offers.com'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(7),
					"Speedtest.net",
					"7th ZD link should be 'Speedtest.net'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(7),
					"http://www.speedtest.net/",
					"Incorrect destination for 'Speedtest.net'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(8),
					"TechBargains",
					"8th ZD link should be 'TechBargains'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(8),
					"https://www.techbargains.com/",
					"Incorrect destination for 'TechBargains'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(9),
					"Toolbox",
					"9th ZD link should be 'Toolbox'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(9),
					"http://it.toolbox.com/",
					"Incorrect destination for 'Toolbox'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(10),
					"What to Expect",
					"10th ZD link should be 'What to Expect'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(10),
					"https://www.whattoexpect.com/",
					"Incorrect destination for 'What to Expect'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(11),
					"MedPage Today",
					"11th ZD link should be 'MedPage Today'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(11),
					"https://www.medpagetoday.com/",
					"Incorrect destination for 'MedPage Today'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(12),
					"PCMag",
					"12th ZD link should be 'PCMag'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(12),
					"https://www.pcmag.com/",
					"Incorrect destination for 'PCMag'");
		} else {
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 1),
					"About Us",
					"First link in first column should be 'About Us'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 1),
					baseURL + "/about-us/",
					"Incorrect 'About Us' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 2),
					"Newsletters",
					"Second link in first column should be 'Newsletters'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 2),
					baseURL + "/newsletter-subscriptions/signup/",
					"Incorrect 'Newsletters' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 3),
					"Health News",
					"Third link in first column should be 'Health News'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 3),
					baseURL + "/news/",
					"Incorrect 'Health News' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 4),
					"Our Sponsors",
					"Fourth link in first column should be 'Our Sponsors'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 4),
					baseURL + "/solutions/landing/sponsors/",
					"Incorrect 'Our Sponsors' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 5),
					"Feedback",
					"First link in second column should be 'Feedback'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 5),
					"https://www.cvent.com/Surveys/Welcome.aspx?s=3bf4d45a-b8ce-49e4-b24c-49d5e101ad05&refid=everydayhealth",
					"Incorrect 'Feedback' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 1),
					"Contact Us",
					"Second link in second column should be 'Contact Us'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 1),
					baseURL + "/contact-us/",
					"Incorrect 'Contact Us' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 2),
					"Careers",
					"Third link in second column should be 'Careers'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 2),
					"http://www.j2global.com/careers/job-search",
					"Incorrect 'Careers' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 3),
					"Terms of Use",
					"First link in third column should be 'Terms of Use'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 3),
					baseURL + "/privacyterms/#everyday_health_terms_of_use",
					"Incorrect 'Terms of Use' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 4),
					"Privacy Policy", "Second link in third column should be 'Privacy Policy'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 4),
					baseURL + "/privacyterms/#everyday_health_privacy_policy",
					"Incorrect 'Privacy Policy' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 5),
					"Accessibility Statement",
					"Second link in third column should be 'Accessibility Statement'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 5),
					baseURL + "/accessibility-statement/",
					"Incorrect 'Accessibility Statement' link destination");
			assertFalse(publicFooterZD.isAdChoiceLinkIconVisible(), "AdChoice link icon should not be visible");
		}

		for (int link = 1; link <= numberOfEHLinks; link++) {
			String fontFamilyEhLink = publicFooterZD.getCSSAttributeForEHLink(link, "font-family");
			if (Settings.isMobile()) {
				assertTrue(fontFamilyEhLink.startsWith("'open sans'"), "'font-family' should start with \"Open Sans\"");
			} else {
				assertTrue(fontFamilyEhLink.startsWith("\"open sans\""), "'font-family' should start with \"Open Sans\"");
			}
			assertTrue(fontFamilyEhLink.endsWith("verdana"), "'font-family' should end with 'Verdana'");
			assertEquals(publicFooterZD.getCSSAttributeForEHLink(link, "font-size"), "13px", "'font-size' should be '13px'");
			assertEquals(publicFooterZD.getCSSAttributeForEHLink(link, "text-align"),
					"center",
					"'text-align' should be 'center'");
			assertEquals(publicFooterZD.getCSSAttributeForEHLink(link, "color"),
					"rgba(204, 204, 204, 1)",
					"'color' should be 'rgba(204, 204, 204, 1)' (#cccccc)");
		}

		int numberOfZDLinks = publicFooterZD.getNumberOfZDLinks();
		for (int link = 1; link < numberOfZDLinks; link++) {
			String fontFamilyZDLink = publicFooterZD.getCSSAttributeForZDLink(link, "font-family");
			if (Settings.isMobile()) {
				assertTrue(fontFamilyZDLink.startsWith("'open sans'"), "'font-family' should start with \"Open Sans\"");
			} else {
				assertTrue(fontFamilyZDLink.startsWith("\"open sans\""), "'font-family' should start with \"Open Sans\"");
			}
			assertTrue(fontFamilyZDLink.endsWith("verdana"), "'font-family' should end with 'Verdana'");
			assertEquals(publicFooterZD.getCSSAttributeForZDLink(link, "font-size"),
					"12px",
					"'font-size' should be '12px'");
			assertEquals(publicFooterZD.getCSSAttributeForZDLink(link, "text-align"),
					"center",
					"'text-align' should be 'center'");
			assertEquals(publicFooterZD.getCSSAttributeForZDLink(link, "color"),
					"rgba(170, 170, 170, 1)",
					"'color' should be 'rgba(170, 170, 170, 1)' (#aaaaaa)");
		}

		assertTrue(publicFooterZD.isFooterBorderVisible(), "Footer border should be visible");
		assertTrue(publicFooterZD.isHONCodeSectionVisible(), "HON Code section should be visible");
		assertTrue(publicFooterZD.isHONCodeTextVisible(), "HON Code test should be visible");
		assertTrue(publicFooterZD.isHONCodeImageVisible(), "HON Code image should be visible");
		assertFalse(publicFooterZD.getHONCodeImageHrefValue().isEmpty(),
				"HON Code image should have non-empty 'href' attribute value");
		assertEquals(publicFooterZD.getHONCodeSectionText(),
				"This site complies with the HONcode standard for trustworthy health information: verify here.",
				"Incorrect HON Code section text");
		assertEquals(publicFooterZD.getHONCodeVerifyHereLinkHrefValue(),
				"https://www.healthonnet.org/HONcode/Conduct.html",
				"Incorrect destination for 'verify here.' link");

		assertTrue(publicFooterZD.isCopyrightTextVisible(), "Copyright text should be visible");
		String currentYear = DateUtils.getCurrentDate(DatePatterns.YYYY);
		assertEquals(publicFooterZD.getCopyrightText(),
				"© 1996-" + currentYear + " Ziff Davis, LLC. Everyday Health is among the federally registered trademarks of Ziff Davis, LLC and may not be used by third parties without explicit permission.",
				"Incorrect copyright text");
		String fontFamilyCopyright = publicFooterZD.getCopyrightTextCSSAttribute("font-family");
		if (Settings.isMobile()) {
			assertTrue(fontFamilyCopyright.startsWith("'open sans'"), "'font-family' should start with \"Open Sans\"");
		} else {
			assertTrue(fontFamilyCopyright.startsWith("\"open sans\""), "'font-family' should start with \"Open Sans\"");
		}
		assertTrue(fontFamilyCopyright.endsWith("verdana"), "'font-family' should end with 'Verdana'");
		assertEquals(publicFooterZD.getCopyrightTextCSSAttribute("font-size"), "12px", "'font-size' should be '12px'");
		assertEquals(publicFooterZD.getCopyrightTextCSSAttribute("color"),
				"rgba(170, 170, 170, 1)",
				"'color' should be 'rgba(170, 170, 170, 1)' (#aaaaaa)");
	}

	private void verifyLegalTextMessage(BasicPageEH basicPageEH) {
		assertTrue(basicPageEH.isLegalTextMessageVisible(), "Legal text message should be visible");
		assertEquals(basicPageEH.getLegalTextMessage(), "We encourage you to read our updated PRIVACY POLICY and COOKIE POLICY.", "Incorrect message text");
		assertEquals(basicPageEH.getLegalTextLinkHrefValue(1), "https://www.everydayhealth.com/privacyterms/", "Incorrect 'Privacy Policy' link destination");
		assertEquals(basicPageEH.getLegalTextLinkHrefValue(2), "https://www.everydayhealth.com/cookie-policy/", "Incorrect 'Cookie Policy' link destination");
		if (!Settings.isMobile()) {
			assertTrue(basicPageEH.isAdChoiceElementVisible(), "AdChoice should be visible");
			assertTrue(basicPageEH.isAdChoiceLogoVisible(), "AdChoice logo image should be visible");
		}
		basicPageEH.clickCloseIconOnLegalTextMessage();
		if (Settings.isMobile()) {
			assertTrue(basicPageEH.isAdChoiceElementVisible(), "AdChoice should be visible");
			assertTrue(basicPageEH.isAdChoiceLogoVisible(), "AdChoice logo image should be visible");
		}
		basicPageEH.scrollPage(0);
		basicPageEH.refresh();
		basicPageEH.waitForPageToLoad();
		assertFalse(basicPageEH.isLegalTextMessageVisible(), "Legal text message should not be visible");
		assertTrue(basicPageEH.isAdChoiceElementVisible(), "AdChoice should be visible");
		assertTrue(basicPageEH.isAdChoiceLogoVisible(), "AdChoice logo image should be visible");
	}
}