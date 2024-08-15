package org.everydayhealth.tests;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.articles.FluMapPage;
import everydayhealth.pages.columns.BlogArticlePage;
import everydayhealth.pages.columns.BlogAuthorPage;
import everydayhealth.pages.columns.BlogLandingPage;
import everydayhealth.pages.conditions.CategoryLandingPage;
import everydayhealth.pages.drugs.DrugsBasePage;
import everydayhealth.pages.html.HtmlBasePage;
import everydayhealth.pages.program.ProgramPage;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.EHScripts;
import framework.platform.Environment;
import framework.platform.OptimizelyTemplatesEH;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.Utils;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Standard Marketing Pixels Test
 */
public class MarketingPixelsTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C168831"})
	@TestRail(id = "C168831")
	public void verifyMarketingPixelsHomePage() {
		SiteNavigatorEH.goToMainPageEH();

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, false, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C199197"})
	@TestRail(id = "C199197")
	public void verifyMarketingPixelsCCRLandingPage() {
		SiteNavigatorEH.goToCCRLandingPageEH(TemplatesEH.LANDING);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C197359"})
	@TestRail(id = "C197359")
	public void verifyMarketingPixelsHealthAZLandingPage() {
		SiteNavigatorEH.goToHealthAZLandingPage();

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C199187"})
	@TestRail(id = "C199187")
	public void verifyMarketingPixelsFoodPage() {
		SiteNavigatorEH.openPage("/lifestyle/food/");

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C199188"})
	@TestRail(id = "C199188")
	public void verifyMarketingPixelsArticleV3Page() {
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.ARTICLE_V3.getTemplateURL());

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C199189"})
	@TestRail(id = "C199189")
	public void verifyMarketingPixelsGuidePage() {
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.GUIDE.getTemplateURL());

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C199190"})
	@TestRail(id = "C199190")
	public void verifyMarketingPixelsSlideshowPage() {
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.SLIDESHOW.getTemplateURL());

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C199191"})
	@TestRail(id = "C199191")
	public void verifyMarketingPixelsArticleVideoPage() {
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.ARTICLE_VIDEO_V3.getTemplateURL());

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C199192"})
	@TestRail(id = "C199192")
	public void verifyMarketingPixelsInfographicPage() {
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.INFOGRAPHIC.getTemplateURL());

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C260747"})
	@TestRail(id = "C260747")
	public void verifyMarketingPixelsRecipesPage() {
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.RECIPES.getTemplateURL());

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, false, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "CusoSolutionsDesktop", "CusoArticleTest", "MarketingPixels", "C199194"})
	@TestRail(id = "C199194")
	public void verifyMarketingPixelsCusoArticlePage() {
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.CUSO_ARTICLE.getTemplateURL());

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "CusoSolutionsDesktop", "EverydayHealthSmoke", "MarketingPixels", "CusoSlideshowTest", "C199195"})
	@TestRail(id = "C199195")
	public void verifyMarketingPixelsCusoSlideshowPage() {
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.CUSO_SLIDESHOW.getTemplateURL());

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C204595"})
	@TestRail(id = "C204595")
	public void verifyMarketingPixelsCCRTopicPage() {
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.TOPIC_LANDING);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C235442"})
	@TestRail(id = "C235442")
	public void verifyMarketingPixelsHtmlPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.HTML_CALORIE_COUNTER, HtmlBasePage.class);
		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
		SiteNavigatorEH.goToPage(TemplatesEH.HTML_DIABETES_MEAL_PLANNER, HtmlBasePage.class);
		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
		SiteNavigatorEH.goToPage(TemplatesEH.HTML_MEAL_PLANNER, HtmlBasePage.class);
		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C228074"})
	@TestRail(id = "C228074")
	public void verifyOptimizely() {
		if (Settings.isEnvironment(Environment.PROD)) {
			for (OptimizelyTemplatesEH templates : OptimizelyTemplatesEH.values()) {
				SiteNavigatorEH.goToBasicPageEH(templates.getOptimizelyTemplateURL());
				assertTrue(Utils.isPageSourceContains("window['optimizely']=window['optimizely']||[];window['optimizely']") || Utils.isPageSourceContains("window['optimizely'] = window['optimizely'] || [];\n" +
						"        window['optimizely']"), "Page source should contain optimizely script");
			}
		} else {
			Logger.info("Optimizely is only need to be tested in prod for given set of URLs");
		}
	}


	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C237992"})
	@TestRail(id = "C237992")
	public void verifyMarketingPixelsFluMapPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C235593"})
	@TestRail(id = "C235593")
	public void verifyMarketingPixelsLifestylePage() {
		SiteNavigatorEH.goToPage(TemplatesEH.LOBBY_LIST_PAGE, ProgramPage.class);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C235167"})
	@TestRail(id = "C235167")
	public void verifyMarketingPixelsProgramPage() {
		SiteNavigatorEH.goToBasicPageEH(TemplatesEH.PROGRAM);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C238561"})
	@TestRail(id = "C238561")
	public void verifyMarketingPixelsDrugsLandingPage() {
		SiteNavigatorEH.goToDrugsLandingPage();

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, false, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C238563"})
	@TestRail(id = "C238563")
	public void verifyMarketingPixelsDrugsSearchPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_SEARCH, DrugsBasePage.class);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, false, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C238564"})
	@TestRail(id = "C238564")
	public void verifyMarketingPixelsDrugsProfilePage() {
		SiteNavigatorEH.goToDrugProfilePage();

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, false, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C238565"})
	@TestRail(id = "C238565")
	public void verifyMarketingPixelsDrugsByLetterPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_LETTER, DrugsBasePage.class);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, false, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C238566"})
	@TestRail(id = "C238566")
	public void verifyMarketingPixelsDrugsByClassPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_CLASS, DrugsBasePage.class);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, false, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthSmoke", "MarketingPixels", "C238567"})
	@TestRail(id = "C238567")
	public void verifyMarketingPixelsDrugsReviewPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_REVIEW, DrugsBasePage.class);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, false, true, false);
	}

	@Test(groups = {"CusoSolutionsDesktop", "EverydayHealthSmoke", "CusoManagementSelectorTest", "MarketingPixels", "C235417"})
	@TestRail(id = "C235417")
	public void verifyMarketingPixelsCusoManagementSelectorPage() {
		SiteNavigatorEH.goToCusoManagementSelectorPage();

		verifyDataOnPage(false);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "CusoSolutionsDesktop", "EverydayHealthSmoke", "ResourceCenterTest", "MarketingPixels", "C309830"})
	@TestRail(id = "C309830")
	public void verifyMarketingPixelsResourceCenterPage() {
		SiteNavigatorEH.goToResourceCenterPage();

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, false, true, false); //TODO update when GTM (Qualtrics script) requirements clarified
	}

	@Test(groups = {"EverydayHealthDesktop", "MarketingPixels", "BlogIndexTest", "C314421"})
	@TestRail(id = "C314421")
	public void verifyMarketingPixelsBlogIndexPage() {
		SiteNavigatorEH.goToBlogIndexPage();

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "MarketingPixels", "BlogArticleTest", "C326646"})
	@TestRail(id = "C326646")
	public void verifyMarketingPixelsBlogArticlePage() {
		SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "MarketingPixels", "BlogLandingTest", "C330395"})
	@TestRail(id = "C330395")
	public void verifyMarketingPixelsBlogLandingSingleAuthorPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_SINGLE_AUTHOR, BlogLandingPage.class);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "MarketingPixels", "BlogLandingTest", "C329778"})
	@TestRail(id = "C329778")
	public void verifyMarketingPixelsBlogLandingMultipleAuthorsPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_MULTIPLE_AUTHORS, BlogLandingPage.class);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, true, true, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "MarketingPixels", "BlogLandingTest", "C345210"})
	@TestRail(id = "C345210")
	public void verifyMarketingPixelsCategoryLandingPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_LANDING, CategoryLandingPage.class);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, false, true, false); //TODO clarify if Qualtrics should fire
	}

	@Test(groups = {"EverydayHealthDesktop", "MarketingPixels", "BlogAuthorTest", "C346370"})
	@TestRail(id = "C346370")
	public void verifyMarketingPixelsBlogAuthorPage() {
		SiteNavigatorEH.goToPage(TemplatesEH.BLOGS_AUTHOR, BlogAuthorPage.class);

		verifyDataOnPage(true);
		verifyMarketingPixelsOnPage(true, false, true, false);
	}

	private Map<String, String> getPageLoadResults() {
		LogEntries les = WebDriverManager.getDriver().manage().logs().get(LogType.PERFORMANCE);
		Map<String, String> receivedResponses = new TreeMap<>();
		Logger.info("Filter 'Network' tab log messages");
		for (LogEntry le : les) {
			String logMessage = le.toString();
			JsonParser jsonParser = new JsonParser();
			String message = logMessage.substring(34, logMessage.length());
			JsonElement jsonElement = jsonParser.parse(message);
			JsonObject messageObj = jsonElement.getAsJsonObject().getAsJsonObject("message");
			JsonObject responseObj = messageObj.getAsJsonObject("params").getAsJsonObject("response");
			if (messageObj.get("method").getAsString().equals("Network.responseReceived") &&
					!responseObj.getAsJsonObject("headers").toString().equals("{}") &&
					responseObj.get("mimeType").getAsString().contains("javascript")) {
				receivedResponses.put(responseObj.get("url").getAsString(), responseObj.get("status").getAsString());
			}
		}
		return receivedResponses;
	}

	private boolean checkQualtricsScript(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().startsWith(EHScripts.QUALTRICS_SCRIPT_URL_HTTPS.getText())) {
				String responseStatusCode = entry.getValue();
				Logger.info("Response status code for Qualtrics script " + entry.getKey() + " = " + responseStatusCode);
				if (responseStatusCode.contains("200")) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkComscoreScript(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().startsWith(EHScripts.COMSCORE_SCRIPT_URL_HTTPS.getText())) {
				String responseStatusCode = entry.getValue();
				Logger.info("Response status code for Comscore script " + entry.getKey() + " = " + responseStatusCode);
				if (responseStatusCode.contains("200")) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkGTMScript(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().startsWith(EHScripts.GTM_SCRIPT_URL.getText())) {
				String responseStatusCode = entry.getValue();
				Logger.info("Response status code for GTM script " + entry.getKey() + " = " + responseStatusCode);
				if (responseStatusCode.contains("200")) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkClicktaleScript(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().startsWith(EHScripts.CLICKTALE_SCRIPT_URL.getText()) || entry.getKey().startsWith(EHScripts.CLICKTALE_SCRIPT_URL_HTTPS.getText())) {
				String responseStatusCode = entry.getValue();
				Logger.info("Response status code for Clicktale script " + entry.getKey() + " = " + responseStatusCode);
				if (responseStatusCode.contains("200") || responseStatusCode.contains("304")) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkGoogleAnalytics(Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().startsWith(EHScripts.GOOGLE_ANALYTICS_URL.getText())) {
				String responseStatusCode = entry.getValue();
				Logger.info("Response status code for Google Analytics script " + entry.getKey() + " = " + responseStatusCode);
				if (responseStatusCode.contains("200") || responseStatusCode.contains("304")) {
					return true;
				}
			}
		}
		return false;
	}

	private void verifyMarketingPixelsOnPage(boolean comscore, boolean qualtrics, boolean googleTagManager, boolean bounceExchange) {
		Logger.info("Check if Clicktale, Comscore, Index exchange, Qualtrics and Google Tag Manager scripts loaded correctly");
		Map<String, String> networkTabData = getPageLoadResults();
		if (comscore) {
			assertFalse(Utils.isPageSourceContains(EHScripts.COMSCORE_SCRIPT.getText()), "Page source should not contain ComScore script");
			assertTrue(checkComscoreScript(networkTabData), "Comscore script should send request and receive 200 response");
		}
		if (qualtrics) {
			assertFalse(Utils.isPageSourceContains(EHScripts.QUALTRICS_SCRIPT.getText()), "Page source should not contain Qualtrics script");
			assertTrue(checkQualtricsScript(networkTabData), "Qualtrics script should send request and receive 200 response");
		}
		if (googleTagManager) {
			assertTrue(Utils.isPageSourceContains(EHScripts.GTM_SCRIPT_MINIFIED.getText()) || Utils.isPageSourceContains(EHScripts.GTM_SCRIPT.getText()), "Google tag manager script should be present in page source");
			assertTrue(checkGTMScript(networkTabData), "Google Tag Manager script should send request and receive 200 response");
		}
		if (bounceExchange) {
			assertFalse(Utils.isPageSourceContains(EHScripts.BOUNCE_EXCHANGE_SCRIPT.getText()), "Page source should not contain BounceExchange script");
		}
		assertFalse(Utils.isPageSourceContains(EHScripts.GOOGLE_ANALYTICS_STRING.getText()), "Page source should not contain GA string");
		assertTrue(checkGoogleAnalytics(networkTabData), "Google Analytics script should send request and receive 200 response");
	}

	private void verifyDataOnPage(boolean isOptimizelyPresent) {
		Logger.info("Verify Optimizely, GA account and omniture events on page load");
		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5") || Utils.getJSResult("return EH.Settings.omniture.event").equals("event5"), "'event5' should fire on page load");
		Utils.waitFor(7000); //wait for all scripts to load properly
		assertTrue(Utils.isPageSourceContains("omniture"), "Omniture script should be present in page source");
		if (isOptimizelyPresent) {
			assertTrue(Utils.isPageSourceContains("optimizely", "EH-6166"), "Optimizely not present in page source");
		}
		assertTrue(MarketingPixels.verifyUtpLoaded(), "UTP should be loaded");
	}
}