package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.articles.ArticleNewTemplatePage;
import everydayhealth.pages.articles.CusoArticleV3Page;
import everydayhealth.pages.articles.CustomSolutionsTemplatePage;
import everydayhealth.pages.articles.FluMapPage;
import everydayhealth.pages.articles.InfographicsPage;
import everydayhealth.pages.articles.SlideshowBasePage;
import everydayhealth.pages.columns.BlogArticlePage;
import everydayhealth.pages.columns.BlogLandingPage;
import everydayhealth.pages.conditions.CategoryLandingPage;
import everydayhealth.pages.html.HtmlBasePage;
import everydayhealth.pages.landingpages.MasterLandingPage;
import everydayhealth.pages.landingpages.NewsLandingPage;
import everydayhealth.pages.program.ProgramPage;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * GoogleAnalyticsTest
 */
public class GoogleAnalyticsTest {

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C376080"})
	@TestRail(id = "C376080")
	public void verifyGACustomDimensionValuesOnArticlePage() {
		SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3, ArticleNewTemplatePage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/generalwellness/dietnutrition", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd2"), "Everyday Health Freelance", "Incorrect cd2 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Article 3.0", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Diet & Nutrition", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Diet & Nutrition", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "287511", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C376081"})
	@TestRail(id = "C376081")
	public void verifyGACustomDimensionValuesOnSlideshowPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.SLIDESHOW, SlideshowBasePage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/skinhairnails/beauty", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Slideshow 2.0", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Skin & Beauty", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Skin & Beauty", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "237391", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C376082"})
	@TestRail(id = "C376082")
	public void verifyGACustomDimensionValuesOnHomepage() {
		SiteNavigatorEH.goToMainPageEH();

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/homepage", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Homepage 2.0", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Healthy Living", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Healthy Living", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "292822", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C376083"})
	@TestRail(id = "C376083")
	public void verifyGACustomDimensionValuesOnCusoArticlePage() {
		CustomSolutionsTemplatePage cusoArticlePage = SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), cusoArticlePage.getAdZoneForPage(), "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "CuSo Article", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), cusoArticlePage.getCategoryForPage(), "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), cusoArticlePage.getSubCategoryForPage(), "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), cusoArticlePage.getPageId(), "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C376084"})
	@TestRail(id = "C376084")
	public void verifyGACustomDimensionValuesOnCusoArticleV3Page() {
		CusoArticleV3Page cusoArticleV3Page = SiteNavigatorEH.goToCusoArticleV3Page();

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), cusoArticleV3Page.getAdZoneForPage(), "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "CuSo Article 3.0", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), cusoArticleV3Page.getCategoryForPage(), "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), cusoArticleV3Page.getSubCategoryForPage(), "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), cusoArticleV3Page.getPageId(), "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383746"})
	@TestRail(id = "C383746")
	public void verifyGACustomDimensionValuesOnBlogsArticlePage() {
		SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/skinhairnails/skinconditions", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Blogs Article", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Skin & Beauty", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Skin & Beauty", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "314226", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383747"})
	@TestRail(id = "C383747")
	public void verifyGACustomDimensionValuesOnBlogsIndexPage() {
		SiteNavigatorEH.goToBlogIndexPage();

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/generalwellness/general", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Blogs Index", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Healthy Living", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Healthy Living", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "311938", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383748"})
	@TestRail(id = "C383748")
	public void verifyGACustomDimensionValuesOnBlogsLandingPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_SINGLE_AUTHOR, BlogLandingPage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/skinhairnails/skinconditions", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Blogs Landing", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Skin & Beauty", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Skin & Beauty", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "312931", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383750"})
	@TestRail(id = "C383750")
	public void verifyGACustomDimensionValuesOnCategoryLandingPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_LANDING, CategoryLandingPage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/cancer/general", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Category Landing", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Cancer", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Cancer", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "312757", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383751"})
	@TestRail(id = "C383751")
	public void verifyGACustomDimensionValuesOnCusoSlideshowPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, SlideshowBasePage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/cs/test", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "CuSo Slideshow", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Autoimmune Diseases", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Guillain-Barre Syndrome", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "308463", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383752"})
	@TestRail(id = "C383752")
	public void verifyGACustomDimensionValuesOnFullWidthPage() {
		FluMapPage fluMapPage = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Full Width 2.0", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), fluMapPage.getAdZoneForPage(), "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), fluMapPage.getCategoryForPage(), "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), fluMapPage.getSubCategoryForPage(), "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "279962", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383753"})
	@TestRail(id = "C383753")
	public void verifyGACustomDimensionValuesOnInfographicsPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.INFOGRAPHIC, InfographicsPage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/generalwellness/dietnutrition", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Infographic 2.0", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Diet & Nutrition", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Diet & Nutrition", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "229399", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383755"})
	@TestRail(id = "C383755")
	public void verifyGACustomDimensionValuesOnLandingV3Page() {
		SiteNavigatorEH.goToCCRLandingPageEH(TemplatesEH.LANDING);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/brainnerves/multiplesclerosis", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Landing 3.0", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Neurology", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Multiple Sclerosis", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "306107", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383756"})
	@TestRail(id = "C383756")
	public void verifyGACustomDimensionValuesOnLifehacksPage() {
		SiteNavigatorEH.goToLifeHackPage();

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/bonesjoints/arthritisrheumatoid", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Life Hacks", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Arthritis", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Rheumatoid Arthritis", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "309045", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383757"})
	@TestRail(id = "C383757")
	public void verifyGACustomDimensionValuesOnLobbyListPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.LOBBY_LIST_PAGE, ProgramPage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/generalwellness/general", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Lobby List 2.0", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Diet & Nutrition", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Weight", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "278513", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383758"})
	@TestRail(id = "C383758")
	public void verifyGACustomDimensionValuesOnMasterLandingPage() {
		MasterLandingPage masterLandingPage = SiteNavigatorEH.goToMasterLandingPage();

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), masterLandingPage.getAdZoneForPage(), "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Master Landing", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), masterLandingPage.getCategoryForPage(), "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), masterLandingPage.getSubCategoryForPage(), "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "325542", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383759"})
	@TestRail(id = "C383759")
	public void verifyGACustomDimensionValuesOnProgramPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/endocrinehormones/diabetestype2", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Program", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Diabetes", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Type 2 Diabetes", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "281947", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383760"})
	@TestRail(id = "C383760")
	public void verifyGACustomDimensionValuesOnTopicLandingV3Page() {
		SiteNavigatorEH.goToCCRTopicPageEH(TemplatesEH.TOPIC_LANDING);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/brainnerves/multiplesclerosis", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Topic Landing 3.0", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Neurology", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Multiple Sclerosis", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "306165", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383764"})
	@TestRail(id = "C383764")
	public void verifyGACustomDimensionValuesOnVideoLandingPage() {
		SiteNavigatorEH.goToVideoLandingPage();

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/cs/test", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Video Landing Page", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Arthritis", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Psoriatic Arthritis", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "312097", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383765"})
	@TestRail(id = "C383765")
	public void verifyGACustomDimensionValuesOnHTMLPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.HTML_MEAL_PLANNER, HtmlBasePage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/generalwellness/weightmanagement", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "HTML", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Diet & Nutrition", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Weight", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "283389", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");

		SiteNavigatorEH.goToPage(TemplatesEH.HTML_CALORIE_COUNTER, HtmlBasePage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/generalwellness/weightmanagement", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "HTML", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Diet & Nutrition", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Weight", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "283387", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");

		SiteNavigatorEH.goToPage(TemplatesEH.HTML_DIABETES_MEAL_PLANNER, HtmlBasePage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/endocrinehormones/diabetes", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "HTML", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "Diabetes", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "Diabetes", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "283388", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "no", "cd18 should contain 'no' value");
	}

	@Test(groups = {"EverydayHealthDesktop", "GATest", "C383995"})
	@TestRail(id = "C383995")
	public void verifyGACustomDimensionValuesOnNewsLandingPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.NEWS_LANDING_PAGE, NewsLandingPage.class);

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/generalwellness/general", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "Landing 3.0", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "News", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "News", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "324977", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd18"), "yes", "cd18 should contain 'yes' value");
	}

	@Test(groups = {"CusoSolutionsDesktop", "GATest", "C383800"})
	@TestRail(id = "C383800")
	public void verifyGACustomDimensionValuesOnCusoLandingLobbyPage() {
		SiteNavigatorEH.goToCusoLandingLobbyPage();

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/cs/test", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd2"), "content-editorial", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "landing - lobby", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "autoimmune diseases", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "antiphospholipid syndrome", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "311247", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
	}

	@Test(groups = {"CusoSolutionsDesktop", "GATest", "C383801"})
	@TestRail(id = "C383801")
	public void verifyGACustomDimensionValuesOnCusoVideologuesPage() {
		SiteNavigatorEH.goToCusoVideologuesSingleTabPage();

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/cs/test", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd2"), "funded-atc", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "videologues", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "diabetes", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "type 2 diabetes", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "312333", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
	}

	@Test(groups = {"CusoSolutionsDesktop", "GATest", "C383802"})
	@TestRail(id = "C383802")
	public void verifyGACustomDimensionValuesOnCusoConditionCoursePage() {
		SiteNavigatorEH.goToCusoConditionCoursePage();

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/cs/test", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd2"), "content-editorial", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "condition course 2.0", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "digestive health", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "ulcerative colitis", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "311244", "Incorrect cd7 value");
		String pageURL = Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", "").replace("#/mild", "");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), pageURL, "Incorrect cd14 value");
	}

	@Test(groups = {"CusoSolutionsDesktop", "GATest", "C383803"})
	@TestRail(id = "C383803")
	public void verifyGACustomDimensionValuesOnCusoManagementSelectorPage() {
		SiteNavigatorEH.goToCusoManagementSelectorPage();

		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd1"), "/cs/test", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd2"), "content-managementselector", "Incorrect cd1 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd3"), "management selector", "Incorrect cd3 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd4"), "arthritis", "Incorrect cd4 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd5"), "rheumatoid arthritis", "Incorrect cd5 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd7"), "311245", "Incorrect cd7 value");
		assertEquals(MarketingPixels.getGoogleAnalyticsCustomDimensionValue("cd14"), Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", ""), "Incorrect cd14 value");
	}
}
