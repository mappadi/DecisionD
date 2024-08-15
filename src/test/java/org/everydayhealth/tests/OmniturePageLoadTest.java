package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.columns.BlogArticlePage;
import everydayhealth.pages.columns.BlogAuthorPage;
import everydayhealth.pages.columns.BlogLandingPage;
import everydayhealth.pages.conditions.CategoryLandingPage;
import everydayhealth.pages.html.HtmlBasePage;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Omniture Page Load Test
 * Verify correct events are fired on each template
 */

public class OmniturePageLoadTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C193402"})
	@TestRail(id = "C193402")
	public void omnitureHomePage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToMainPageEH();
		Logger.info("Verify page load event along with important eVar and prop values on homepage");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/homepage"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "home"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/homepage"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "home|/homepage"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "home|/homepage|292822|Health Information, Resources, Tools & News Online | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "homepage 2.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "healthy living"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "healthy living"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Home Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/homepage"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "home"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/homepage"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "home|/homepage"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "home|/homepage|292822|Health Information, Resources, Tools & News Online | Everyday Health"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C193403"})
	@TestRail(id = "C193403")
	public void omnitureSlideshow() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.SLIDESHOW);
		Logger.info("Verify page load events along with important eVar values on slideshow template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/skinhairnails/beauty"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/skinhairnails/beauty"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "pht|/skinhairnails/beauty"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "pht|/skinhairnails/beauty|237391|6 Unexpected Ways to Use Baking Soda"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/skinhairnails/beauty"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/skinhairnails/beauty"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "pht|/skinhairnails/beauty"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "pht|/skinhairnails/beauty|237391|6 Unexpected Ways to Use Baking Soda"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "pht"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Everyday Health Exclusive"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/pictures/unexpected-ways-to-use-baking-soda/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "slideshow 2.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar54", "6 Unexpected Ways to Use Baking Soda"), "eVar54 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "skin &amp; beauty"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "skin &amp; beauty"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Slideshow Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "pht"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "Everyday Health Exclusive"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C193404"})
	@TestRail(id = "C193404")
	public void omnitureArticleV3() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.ARTICLE_V3);
		Logger.info("Verify page load event along with important eVar and prop values on Article template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/dietnutrition"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Greatist"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/dietnutrition"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc_2|/generalwellness/dietnutrition"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc_2|/generalwellness/dietnutrition|287511|The Best and Worst Foods to Eat Before Bed | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/news/best-worst-foods-eat-before-bed/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "article 3.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "diet &amp; nutrition"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "diet &amp; nutrition"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on article Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/dietnutrition"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "cc_2"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "Greatist"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/dietnutrition"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "cc_2|/generalwellness/dietnutrition"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "cc_2|/generalwellness/dietnutrition|287511|The Best and Worst Foods to Eat Before Bed | Everyday Health"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C193409"})
	@TestRail(id = "C193409")
	public void omnitureGuides() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.GUIDE);
		Logger.info("Verify page load event along with important eVar and prop values on Guides template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/digestivehealth/general"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "gui"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Everyday Health Guide"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/digestivehealth/general"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "gui|/digestivehealth/general"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "gui|/digestivehealth/general|279291|Appendicitis"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/appendicitis/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "guide"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "digestive health"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "appendicitis"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Guides Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/digestivehealth/general"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "gui"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/digestivehealth/general"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "gui|/digestivehealth/general"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "gui|/digestivehealth/general|279291|Appendicitis"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C193405"})
	@TestRail(id = "C193405")
	public void omnitureArticleVideo() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.ARTICLE_VIDEO_V3);
		Logger.info("Verify page load event along with important eVar and prop values on Article Video template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/mentalhealth/emohealth"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc_2"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/mentalhealth/emohealth"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc_2|/mentalhealth/emohealth"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc_2|/mentalhealth/emohealth|254821|We Are All 'The Scream"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/emotional-health/0503/we-are-all-the-scream.aspx"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "article 3.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "emotional health"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "emotional health"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Article Video Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/mentalhealth/emohealth"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "cc_2"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/mentalhealth/emohealth"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "cc_2|/mentalhealth/emohealth"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "cc_2|/mentalhealth/emohealth|254821|We Are All 'The Scream"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C193406"})
	@TestRail(id = "C193406")
	public void omnitureInfographics() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.INFOGRAPHIC);
		Logger.info("Verify page load event along with important eVar and prop values on Infographics template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/dietnutrition"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "inf"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/dietnutrition"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "inf|/generalwellness/dietnutrition"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "inf|/generalwellness/dietnutrition|229399|Christmas Cookie Monster | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/infographics/christmas-cookie-monster/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "infographic 2.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "diet &amp; nutrition"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "diet &amp; nutrition"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Infographics Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/dietnutrition"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "inf"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/dietnutrition"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "inf|/generalwellness/dietnutrition"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "inf|/generalwellness/dietnutrition|229399|Christmas Cookie Monster | Everyday Health"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C193407"})
	@TestRail(id = "C193407")
	public void omnitureLobbyLanding() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.LOBBY_LIST_PAGE);
		Logger.info("Verify page load event along with important eVar and prop values on Lobby landing page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/general"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "lob"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/general"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "lob|/generalwellness/general"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "lob|/generalwellness/general|278513|100+ Ways to Slim Down This Summer"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/lifestyle/slim-down-for-summer-challenge/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "lobby list 2.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "diet &amp; nutrition"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "weight"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "weight loss,food and recipes"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Infographics Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/general"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "lob"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/general"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "lob|/generalwellness/general"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "lob|/generalwellness/general|278513|100+ Ways to Slim Down This Summer"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoArticleTest", "OmnitureTest", "C193411"})
	@TestRail(id = "C193411")
	public void omnitureCusoArticle() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.CUSO_ARTICLE);
		Logger.info("Verify page load event along with important eVar and prop values on Custom Solution article page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cs/test"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cs/test"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc|/cs/test"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc|/cs/test|327535|" + WebDriverManager.getDriver().getTitle().trim()), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "cuso article"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "dental health"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "tooth decay"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on CusoArticle Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/cs/test"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "cc"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/cs/test"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "cc|/cs/test"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "cc|/cs/test|327535|" + WebDriverManager.getDriver().getTitle().trim()), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoSlideshowTest", "OmnitureTest", "C193412"})
	@TestRail(id = "C193412")
	public void omnitureCusoSlideshow() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.CUSO_SLIDESHOW);
		Logger.info("Verify page load event along with important eVar and prop values on Custom Solution article page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cs/test"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Custom Solution: content-editorial"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cs/test"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "undefined|/cs/test"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "undefined|/cs/test|308463|Test page title 636076141092795422"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/testpage/automation/cuso-slideshow/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "cuso slideshow"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "autoimmune diseases"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "guillain-barre syndrome"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on CusoSlideshow Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/cs/test"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "Custom Solution: content-editorial"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/cs/test"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "undefined|/cs/test"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "undefined|/cs/test|308463|Test page title 636076141092795422"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C195868"})
	@TestRail(id = "C195868")
	public void omnitureConditionsLandingPage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH("/conditions/");
		Logger.info("Verify page load event along with important eVar and prop values on Conditions (Health A-Z) landing page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/general"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "atoz"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/general"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "atoz|/generalwellness/general"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "atoz|/generalwellness/general|285102|Health A"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/conditions/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "health a-z"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "healthy living"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "healthy living"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Conditions Landing Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/general"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "atoz"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/general"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "atoz|/generalwellness/general"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "atoz|/generalwellness/general|285102|Health A"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C204584"})
	@TestRail(id = "C204584")
	public void omnitureCcrTopicPage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.TOPIC_LANDING);
		Logger.info("Verify page load event along with important eVar and prop values on CCR Topic page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/brainnerves/multiplesclerosis"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "topic"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/brainnerves/multiplesclerosis"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "topic|/brainnerves/multiplesclerosis"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "topic|/brainnerves/multiplesclerosis|306165|Physical Therapy for MS Content | Multiple Sclerosis | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/multiple-sclerosis/physical-therapy/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "topic landing 3.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "neurology"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "multiple sclerosis"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on CCR Topic Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/brainnerves/multiplesclerosis"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "topic"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/brainnerves/multiplesclerosis"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "topic|/brainnerves/multiplesclerosis"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "topic|/brainnerves/multiplesclerosis|306165|Physical Therapy for MS Content | Multiple Sclerosis | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C235441"})
	@TestRail(id = "C235441")
	public void omnitureHtmlPage() {
		CookiesManager.deleteAllCookies();

		Logger.info("Verify page load event along with important eVar and prop values on Html calorie counter template");
		SiteNavigatorEH.goToPage(TemplatesEH.HTML_CALORIE_COUNTER, HtmlBasePage.class);
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/weightmanagement"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "reg"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/weightmanagement"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "reg|/generalwellness/weightmanagement"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "reg|/generalwellness/weightmanagement|283387|Calorie Counter"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/calorie-counter/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "html"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "diet &amp; nutrition"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "weight"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Html calorie counter Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/weightmanagement"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "reg"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/weightmanagement"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "reg|/generalwellness/weightmanagement"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "reg|/generalwellness/weightmanagement|283387|Calorie Counter"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}

		Logger.info("Verify page load event along with important eVar and prop values on Html diabetes meal planner template");
		SiteNavigatorEH.goToPage(TemplatesEH.HTML_DIABETES_MEAL_PLANNER, HtmlBasePage.class);
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/endocrinehormones/diabetes"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "reg"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/endocrinehormones/diabetes"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "reg|/endocrinehormones/diabetes"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "reg|/endocrinehormones/diabetes|283388|Diabetes Meal Planner"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/diabetes-meal-planner/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "html"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "diabetes"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "diabetes"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Html diabetes meal planner Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/endocrinehormones/diabetes"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "reg"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/endocrinehormones/diabetes"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "reg|/endocrinehormones/diabetes"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "reg|/endocrinehormones/diabetes|283388|Diabetes Meal Planner"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}

		Logger.info("Verify page load event along with important eVar and prop values on Html meal planner template");
		SiteNavigatorEH.goToPage(TemplatesEH.HTML_MEAL_PLANNER, HtmlBasePage.class);
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/weightmanagement"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "reg"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/weightmanagement"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "reg|/generalwellness/weightmanagement"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "reg|/generalwellness/weightmanagement|283389|Meal Planner"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/meal-planner/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "html"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "diet &amp; nutrition"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "weight"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Html meal planner Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/weightmanagement"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "reg"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/weightmanagement"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "reg|/generalwellness/weightmanagement"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "reg|/generalwellness/weightmanagement|283389|Meal Planner"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C235178"})
	@TestRail(id = "C235178")
	public void omnitureProgramPage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.PROGRAM);
		Logger.info("Verify page load event along with important eVar and prop values on Program template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/endocrinehormones/diabetestype2"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "pgr"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/endocrinehormones/diabetestype2"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "pgr|/endocrinehormones/diabetestype2"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "pgr|/endocrinehormones/diabetestype2|281947|Diabetes Step"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/type-2-diabetes/living-with/step-by-step/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "program"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "diabetes"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "type 2 diabetes"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "risk factors,treatment,diagnosis"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Program Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/endocrinehormones/diabetestype2"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "pgr"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/endocrinehormones/diabetestype2"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "pgr|/endocrinehormones/diabetestype2"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "pgr|/endocrinehormones/diabetestype2|281947|Diabetes Step"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");

		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C238569"})
	@TestRail(id = "C238569")
	public void omnitureDrugsLandingPage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToDrugsLandingPage();
		Logger.info("Verify page load event along with important eVar and prop values on Drug Landing template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/drugs"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "daz"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Drugs A - Z"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/drugs"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "daz|/generalwellness/drugs"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar7", "false"), "eVar7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "daz|/generalwellness/drugs|174215373|Drugs Information, Side Effects, Reviews and Dosage | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/drugs/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "2.0"), "eVar30 is incorrect");

		Logger.info("Verifying prop values on Drug Landing Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/drugs"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "daz"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "Drugs A - Z"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/drugs"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "daz|/generalwellness/drugs"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop7", "false"), "prop7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "daz|/generalwellness/drugs|174215373|Drugs Information, Side Effects, Reviews and Dosage | Everyday Health"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");

		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C238572"})
	@TestRail(id = "C238572")
	public void omnitureDrugsSearchPage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.DRUGS_SEARCH);
		Logger.info("Verify page load event along with important eVar and prop values on Drug search template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/drugs"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "daz"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Drugs A - Z"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/drugs"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "daz|/generalwellness/drugs"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar7", "false"), "eVar7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "daz|/generalwellness/drugs|584304733|Drugs search |"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/drugs/search"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "2.0"), "eVar30 is incorrect");

		Logger.info("Verifying prop values on Drug search Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/drugs"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "daz"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "Drugs A - Z"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/drugs"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "daz|/generalwellness/drugs"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop7", "false"), "prop7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "daz|/generalwellness/drugs|584304733|Drugs search |"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");

		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C238570"})
	@TestRail(id = "C238570")
	public void omnitureDrugsProfilePage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToDrugProfilePage();
		Logger.info("Verify page load event along with important eVar and prop values on Drug profile template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/bonesjoints/generalpain/dr"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "daz"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Drugs A - Z"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/bonesjoints/generalpain"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "daz|/bonesjoints/generalpain"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar7", "false"), "eVar7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "daz|/bonesjoints/generalpain|309603|Ibuprofen"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/drugs/ibuprofen"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "2.0"), "eVar30 is incorrect");

		Logger.info("Verifying prop values on Drug profile Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/bonesjoints/generalpain/dr"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "daz"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "Drugs A - Z"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/bonesjoints/generalpain"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "daz|/bonesjoints/generalpain"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop7", "false"), "prop7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "daz|/bonesjoints/generalpain|309603|Ibuprofen"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");

		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C238574"})
	@TestRail(id = "C238574")
	public void omnitureDrugsByLetterPage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.DRUGS_BY_LETTER);
		Logger.info("Verify page load event along with important eVar and prop values on Drug By letter template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/drugs"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "daz"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Drugs A - Z"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/drugs"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "daz|/generalwellness/drugs"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar7", "false"), "eVar7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "daz|/generalwellness/drugs|838994708|Find Drugs and Drug Classes that Begin with S | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/drugs/s"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "2.0"), "eVar30 is incorrect");

		Logger.info("Verifying prop values on Drug By letter Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/drugs"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "daz"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "Drugs A - Z"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/drugs"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "daz|/generalwellness/drugs"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop7", "false"), "prop7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "daz|/generalwellness/drugs|838994708|Find Drugs and Drug Classes that Begin with S | Everyday Health"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");

		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C238573"})
	@TestRail(id = "C238573")
	public void omnitureDrugsByClassPage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.DRUGS_BY_CLASS);
		Logger.info("Verify page load event along with important eVar and prop values on Drug By class template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/drugs"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "daz"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Drugs A - Z"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/drugs"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "daz|/generalwellness/drugs"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar7", "false"), "eVar7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "daz|/generalwellness/drugs|1982616546|Find Drugs and Drug Classes that Begin with ANALGESICS | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/drugs/class/analgesics"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "2.0"), "eVar30 is incorrect");

		Logger.info("Verifying prop values on Drug By class Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/drugs"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "daz"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "Drugs A - Z"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/drugs"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "daz|/generalwellness/drugs"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop7", "false"), "prop7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "daz|/generalwellness/drugs|1982616546|Find Drugs and Drug Classes that Begin with ANALGESICS | Everyday Health"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");

		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C238571"})
	@TestRail(id = "C238571")
	public void omnitureDrugsReviewPage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.DRUGS_REVIEW);
		Logger.info("Verify page load event along with important eVar and prop values on Drug review template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/bonesjoints/generalpain/dr"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "daz"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Drugs A - Z"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/bonesjoints/generalpain"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "daz|/bonesjoints/generalpain"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar7", "false"), "eVar7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "daz|/bonesjoints/generalpain|309603|Ibuprofen"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/drugs/ibuprofen/reviews"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "2.0"), "eVar30 is incorrect");

		Logger.info("Verifying prop values on Drug review Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/bonesjoints/generalpain/dr"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "daz"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "Drugs A - Z"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/bonesjoints/generalpain"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "daz|/bonesjoints/generalpain"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop7", "false"), "prop7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "daz|/bonesjoints/generalpain|309603|Ibuprofen"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");

		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoLandingLobbyTest", "OmnitureTest", "C234768"})
	@TestRail(id = "C234768")
	public void omnitureCusoLandingLobbyPage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToCusoLandingLobbyPage();
		Logger.info("Verify page load event along with important eVar and prop values on cuso landing lobby template");
		assertTrue(Utils.getJSResult("return EH.Settings.omniture.event").contains("event5"), "events are incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cs/test"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "content-editorial"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cs/test"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc|/cs/test"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar7", "false"), "eVar7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc|/cs/test|"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].split("#")[0];
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "landing - lobby"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "autoimmune diseases"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "antiphospholipid syndrome"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "basics"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on cuso landing lobby Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/cs/test"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "cc"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "content-editorial"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/cs/test"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "cc|/cs/test"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop7", "false"), "prop7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "cc|/cs/test|"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "ConditionCourse", "OmnitureTest", "C234769"})
	@TestRail(id = "C234769")
	public void omnitureCusoConditionCoursePage() {
		SiteNavigatorEH.goToCusoConditionCoursePage();
		Logger.info("Verify page load event along with important eVar and prop values on cuso condition course template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cs/test"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cs/test"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc|/cs/test"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar7", "false"), "eVar7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc|/cs/test|"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].split("#")[0].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "condition course 2.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "digestive health"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "ulcerative colitis"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "basics"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on cuso condition course Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/cs/test"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "cc"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/cs/test"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "cc|/cs/test"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop7", "false"), "prop7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "cc|/cs/test|"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "OmnitureTest", "C234770"})
	@TestRail(id = "C234770")
	public void omnitureCusoVideologuesPage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToCusoVideologuesMultibleTabsPage();
		Logger.info("Verify page load event along with important eVar and prop values on cuso Videologues template (multiple tabs)");
		assertEquals(Utils.getJSResult("return EH.Settings.omniture.event"), "event5,event19", "events are incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/digestive/hepatitisc/br"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "branded-atc"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/digestive/hepatitisc"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc|/digestive/hepatitisc"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc|/digestive/hepatitisc|"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar7", "false"), "eVar7 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].split("#")[0].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "videologues"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "nutrients"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "protein"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
		Logger.info("Verifying prop values on cuso Videologues Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/digestive/hepatitisc/br"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "cc"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "branded-atc"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/digestive/hepatitisc"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "cc|/digestive/hepatitisc"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop7", "false"), "prop7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "cc|/digestive/hepatitisc|"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");

		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToCusoVideologuesSingleTabPage();
		Logger.info("Verify page load event along with important eVar and prop values on cuso Videologues template (single tab)");
		assertEquals(Utils.getJSResult("return EH.Settings.omniture.event"), "event5,event19", "events are incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cs/test"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "funded-atc"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cs/test"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc|/cs/test"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc|/cs/test|"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar7", "false"), "eVar7 is incorrect");
		url = Utils.getCurrentURL().split(".com")[1].split("#")[0].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "videologues"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "diabetes"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "type 2 diabetes"), "eVar68 is incorrect");
//		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "basics"), "eVar69 is incorrect"); //will be uncommented after clarification
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
		Logger.info("Verifying prop values on cuso Videologues Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/cs/test"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "cc"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "funded-atc"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/cs/test"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "cc|/cs/test"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop7", "false"), "prop7 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "cc|/cs/test|"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");

	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C237991"})
	@TestRail(id = "C237991")
	public void omnitureFluMapPage() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.FLU_MAP);
		Logger.info("Verify page load event along with important eVar and prop values on flu map template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77"), "events are incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/tools/flutracker"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "tl"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Everyday Health Exclusive"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/tools/flutracker"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "tl|/tools/flutracker"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "tl|/tools/flutracker|279962|Flu Map | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/flu/map/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "full width 2.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar58", "default recommendation"), "eVar58 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "lung &amp; respiratory"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "flu"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on flu map Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/tools/flutracker"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "tl"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop3", "Everyday Health Exclusive"), "prop3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/tools/flutracker"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "tl|/tools/flutracker"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "tl|/tools/flutracker|279962|Flu Map | Everyday Health"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
	}

	@Test(groups = {"EverydayHealthDesktop", "OmnitureTest", "BlogIndexTest", "C314420"})
	@TestRail(id = "C314420")
	public void omnitureBlogIndexPage() {
		SiteNavigatorEH.goToBlogIndexPage();

		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "load event should be 'event5'");

		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/general"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "lblg"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/general"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "lblg|/generalwellness/general"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "lblg|/generalwellness/general|"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "|Health Expert Columns | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/columns/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "blogs index"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "healthy living"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "healthy living"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/general"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "lblg"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/general"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "lblg|/generalwellness/general"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "lblg|/generalwellness/general|"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "|Health Expert Columns | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
	}

	@Test(groups = {"EverydayHealthDesktop", "OmnitureTest", "BlogArticleTest", "C326699"})
	@TestRail(id = "C326699")
	public void omnitureBlogArticlePage() {
		SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77"), "load event should be 'event5'");

		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/skinhairnails/skinconditions"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "lblg"), "eVar2 is incorrect");
		//evar3 and evar4??
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/skinhairnails/skinconditions"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "lblg|/skinhairnails/skinconditions"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "lblg|/skinhairnails/skinconditions|"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "|The Facts About a Flesh"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "blogs article"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "skin &amp; beauty"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "skin &amp; beauty"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "symptoms,treatment,diagnosis"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/skinhairnails/skinconditions"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "lblg"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/skinhairnails/skinconditions"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "lblg|/skinhairnails/skinconditions"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "lblg|/skinhairnails/skinconditions|"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "|The Facts About a Flesh"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
	}

	@Test(groups = {"EverydayHealthDesktop", "OmnitureTest", "BlogLandingTest", "C330388"})
	@TestRail(id = "C330388")
	public void omnitureBlogSingleAuthorLandingPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_SINGLE_AUTHOR, BlogLandingPage.class);

		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "load event should be 'event5'");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/skinhairnails/skinconditions"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "lblg"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/skinhairnails/skinconditions"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "lblg|/skinhairnails/skinconditions"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "lblg|/skinhairnails/skinconditions|"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "|The Skin You're In"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "blogs landing"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar42", "center"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "skin &amp; beauty"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "skin &amp; beauty"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/skinhairnails/skinconditions"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "lblg"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/skinhairnails/skinconditions"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "lblg|/skinhairnails/skinconditions"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "lblg|/skinhairnails/skinconditions|"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "|The Skin You're In"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
	}

	@Test(groups = {"EverydayHealthDesktop", "OmnitureTest", "BlogLandingTest", "C328362"})
	@TestRail(id = "C328362")
	public void omnitureBlogMultipleAuthorLandingPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_MULTIPLE_AUTHORS, BlogLandingPage.class);

		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "load event should be 'event5'");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cancer/general"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "lblg"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cancer/general"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "lblg|/cancer/general"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "lblg|/cancer/general|"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "|My Cancer Story"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "blogs landing"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar42", "center"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "cancer"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "cancer"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/cancer/general"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "lblg"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/cancer/general"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "lblg|/cancer/general"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "lblg|/cancer/general|"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "|My Cancer Story"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
	}

	@Test(groups = {"EverydayHealthDesktop", "OmnitureTest", "CategoryPageTest", "C345206"})
	@TestRail(id = "C345206")
	public void omnitureCategoryLandingPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_LANDING, CategoryLandingPage.class);

		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77"), "load events should be 'event5' and 'event77'");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cancer/general"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "land"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cancer/general"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "land|/cancer/general"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "land|/cancer/general|"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "category landing"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "cancer"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "cancer"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/cancer/general"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "land"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/cancer/general"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "land|/cancer/general"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "land|/cancer/general|"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
	}

	@Test(groups = {"CusoSolutionsDesktop", "OmnitureTest", "CusoManagementSelectorTest", "C315159"})
	@TestRail(id = "C315159")
	public void omnitureManagementSelectorPage() {
		SiteNavigatorEH.goToCusoManagementSelectorPage();

		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "load event should be 'event5'");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cs/test"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "content-managementselector"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cs/test"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc|/cs/test"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc|/cs/test|"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "management selector"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "arthritis"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "rheumatoid arthritis"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "basics"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/cs/test"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "cc"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/cs/test"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "cc|/cs/test"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "cc|/cs/test|"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "OmnitureTest", "C375424"})
	@TestRail(id = "C375424")
	public void omnitureMasterLanding() {
		CookiesManager.deleteAllCookies();
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.MASTER_LANDING_PAGE);
		Logger.info("Verify page load event along with important eVar and prop values on Master Landing template");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5"), "events are incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cancer/colon"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "masterlanding"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cancer/colon"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "masterlanding|/cancer/colon"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "masterlanding|/cancer/colon|325542|Test page title: Test Page: Master Landing"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/testpage/ma-636522312007396804/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "master landing"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "cancer"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "colon cancer"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");

		Logger.info("Verifying prop values on Master Landing Page");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/cancer/colon"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "masterlanding"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/cancer/colon"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "masterlanding|/cancer/colon"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "masterlanding|/cancer/colon|325542|Test page title: Test Page: Master Landing"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
		if (!Settings.isDesktop()) {
			verifyMobileEvent();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "OmnitureTest", "BlogAuthorTest", "C346371"})
	@TestRail(id = "C346371")
	public void omnitureBlogAuthorPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.BLOGS_AUTHOR, BlogAuthorPage.class);

		assertEquals(Utils.getJSResult("return EH.Settings.omniture.event"), "event5", "Load event should be 'event5'");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/general"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "lblg"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/general"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "lblg|/generalwellness/general"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "lblg|/generalwellness/general|-1|Howard Chang"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].split("#")[0].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "author"), "eVar30 is incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/generalwellness/general"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "lblg"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/generalwellness/general"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "lblg|/generalwellness/general"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "lblg|/generalwellness/general|-1|Howard Chang"), "prop8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop20", "VisitorAPI Present"), "prop20 is incorrect");
	}

	private void verifyMobileEvent() {
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar25", "mobile"), "eVar25 is incorrect");
	}

	private void verifyOmnitureEvent75(String day) {
		if (day.contains("Saturday") || day.contains("Sunday")) {
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar75", "weekend"), "eVar75 is incorrect");
		} else {
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar75", "weekday"), "eVar75 is incorrect");
		}
	}

}