package org.everydayhealth.tests;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.ArticleBasePage;
import everydayhealth.pages.articles.ArticleNewTemplatePage;
import framework.DebugMode;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.Environment;
import framework.platform.SiteNavigatorBase;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.Utils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

/**
 * ArticlesV3Test
 */
public class ArticlesV3Test extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "ArticleV3Test", "C216425"})
	@TestRail(id = "C216425")
	public void verifyTertiaryImage() {
		ArticleBasePage articleNewTemplatePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3_WITH_TERTIARY_IMAGE, ArticleBasePage.class);
		if (Settings.isMobile()) {
			assertFalse(articleNewTemplatePage.isTertiaryImageVisible(), "Tertiary image should not be visible");
		} else {
			assertTrue(articleNewTemplatePage.isTertiaryImageVisible(), "Tertiary image should be visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C216427"})
	@TestRail(id = "C216427")
	public void verifyPrimaryImageSecondaryVideo() {
		ArticleBasePage articleNewTemplatePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3_WITH_PRIMARY_IMAGE_SECONDARY_VIDEO, ArticleBasePage.class);
		assertTrue(articleNewTemplatePage.isHeroImageVisible(), "Hero image should be visible");
		if (Settings.isDesktop()) {
			assertTrue(articleNewTemplatePage.getHeroImageWidthValue() < 700, "Hero image width should be less than 700px");
		}
		assertTrue(articleNewTemplatePage.isSecondaryVideoVisible(), "Secondary video should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C216431"})
	@TestRail(id = "C216431")
	public void verifySecondaryImage() {
		ArticleBasePage articleNewTemplatePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3_WITH_SECONDARY_IMAGE, ArticleBasePage.class);
		assertTrue(articleNewTemplatePage.isSecondaryImageVisible(), "Secondary image should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C216445"})
	@TestRail(id = "C216445")
	public void verifyPullQuoteAndKeyTakeAways() {
		ArticleBasePage articleNewTemplatePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3_WITH_PULLQUOTE, ArticleBasePage.class);
		if (Settings.isMobile()) {
			assertFalse(articleNewTemplatePage.isPullQuoteVisible(), "Pull quote should not be visible");
			assertFalse(articleNewTemplatePage.isKeyTakeAwaysVisible(), "Key take aways should not be visible");
		} else {
			assertTrue(articleNewTemplatePage.isPullQuoteVisible(), "Pull quote should be visible");
			assertTrue(articleNewTemplatePage.isPullQuoteGreenBorderVisible(), "Pull quote green border should be visible");
			assertTrue(articleNewTemplatePage.isKeyTakeAwaysVisible(), "Key take aways should be visible");
			int keyTakeAwaysNotesCount = articleNewTemplatePage.getKeyTakeAwaysNotesCount();
			for (int elementNumber = 1; elementNumber < keyTakeAwaysNotesCount; elementNumber++) {
				assertTrue(articleNewTemplatePage.isKeyTakeAwaysClickable(elementNumber), "Key take aways not clickable");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C240208"})
	@TestRail(id = "C240208")
	public void verifyArticlePageInCSZone() {
		ArticleBasePage articlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3_CSZONE, ArticleBasePage.class);

		assertFalse(articlePage.isDontMissThisSectionVisible(), "'Don't miss this' section should not be visible");
		assertFalse(articlePage.isMoreInSectionVisible(), "'More in ...' section should not be visible");
		assertFalse(articlePage.isNewsletterModuleVisible(), "'Newsletter' module should not be visible");
		assertFalse(Utils.isPageSourceContains("http://ardrone.swoop.com/js/spxw.js"), "Swoop ads script should be missing");
		verifyPromoBannerSection(articlePage);
		articlePage.scrollDownThePage();
		if (Settings.isDesktop()) {
			assertFalse(articlePage.isFlyoutVisible(), "Flyout should not be visible");
			assertFalse(articlePage.isRecommendedForYouSectionVisible(), "'Recommended for you' section should not be visible");
			assertTrue(articlePage.isBackToTopVisible(), "'Top' button should be visible");
		}
		assertTrue(articlePage.onGlobalNavHeader().isGlobalNavHeaderVisible(), "Header should be visible");
		assertTrue(articlePage.onZDFooter().isEHLogoVisible(), "Footer should be visible");
		SocialBarEH socialBarEH = articlePage.onSocialBar();
		assertTrue(articlePage.isHeroImageVisible(), "Article hero image should be visible");
		if (Settings.isDesktop()) {
			assertEquals(articlePage.getHeroImageWidthValue(), 650, "Hero image width should be 650px");
		}
		assertTrue(socialBarEH.isSocialBarVisible(), "Social bar should be visible");
		assertTrue(socialBarEH.isSaveLinkVisible(), "'Save' button should be visible");
		assertTrue(articlePage.isBylineVisible(), "Byline should be visible");

		String category = articlePage.getCategoryForPage().toLowerCase();
		String subCategory = articlePage.getSubCategoryForPage().replace(" ", "-").toLowerCase();
		verifyBreadcrumbs(articlePage, category, subCategory);

		if (!Settings.isMobile()) {
			assertTrue(articlePage.isKeyTakeAwaysVisible(), "'Key takeaways' section should be visible");
		}
		assertTrue(articlePage.isHeroImageCaptionVisible(), "Hero image caption should be visible");
		assertTrue(articlePage.isHeroImageCreditVisible(), "Hero image credit should be visible");
		assertTrue(articlePage.isLastUpdatedDateVisible(), "Last updated date should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C241865"})
	@TestRail(id = "C241865")
	public void verifySchema() {
		Document doc = null;
		String url = Settings.getDefaultUrl() + TemplatesEH.ARTICLE_V3.getTemplateURL();
		try {
			doc = Jsoup.connect(url).timeout(5000).get(); //connection timeout in case it take more time than usual to load the page
		} catch (IOException e) {
			fail("Connection to url failed");
		}
		try {
			Element element = doc.select("script[type=application/ld+json]").first();
			JsonParser jsonParser = new JsonParser();
			String schemaBody = element.data();
			JsonElement schemaBodyJson = jsonParser.parse(schemaBody);
			assertEquals(schemaBodyJson.getAsJsonObject().getAsJsonObject().get("@context").getAsString(), "https://schema.org", "'@context' object should have 'https://schema.org' value");
			assertEquals(schemaBodyJson.getAsJsonObject().getAsJsonObject().get("@type").getAsString(), "Article", "'@type' object should have 'Article' value");
			assertEquals(schemaBodyJson.getAsJsonObject().getAsJsonObject().get("author").getAsString(), "Katie Golde, Greatist", "'author' object should have 'Katie Golde, Greatist' value");
			assertEquals(schemaBodyJson.getAsJsonObject().getAsJsonObject().get("url").getAsString(), url, "'url' object value should be equal to page url");
			assertEquals(schemaBodyJson.getAsJsonObject().getAsJsonObject().get("name").getAsString(), "The Best and Worst Foods to Eat Before Bed", "'name' object should be equal to page title");
			assertEquals(schemaBodyJson.getAsJsonObject().getAsJsonObject().get("audience").getAsString(), "Patients", "'audience' object should have 'Patients' value");
			JsonElement mainEntityOfPage = schemaBodyJson.getAsJsonObject().getAsJsonObject("mainEntityOfPage");
			assertEquals(mainEntityOfPage.getAsJsonObject().get("@type").getAsString(), "WebPage", "'@type' parameter of 'mainEntityOfPage' object should have 'WebPage' value");
			assertEquals(mainEntityOfPage.getAsJsonObject().get("@id").getAsString(), url, "'@id' parameter of 'mainEntityOfPage' object should be equal to page url");
			assertEquals(schemaBodyJson.getAsJsonObject().getAsJsonObject().get("datePublished").getAsString(), "2015-03-11T10:27:13.0000000", "'datePublished' object should have '2015-03-11T10:27:13.0000000' value");
			assertEquals(schemaBodyJson.getAsJsonObject().getAsJsonObject().get("dateModified").getAsString(), "2015-03-11T00:00:00.0000000", "'dateModified' object should have '2015-03-11T00:00:00.0000000' value");
			assertEquals(schemaBodyJson.getAsJsonObject().getAsJsonObject().get("headline").getAsString(), "The Best and Worst Foods to Eat Before Bed", "'headline' object should have article headline value");
			JsonElement image = schemaBodyJson.getAsJsonObject().getAsJsonObject("image");
			assertEquals(image.getAsJsonObject().getAsJsonObject().get("@type").getAsString(), "ImageObject", "'@type' parameter of 'image' object should have 'ImageObject' value");
			assertEquals(image.getAsJsonObject().getAsJsonObject().get("url").getAsString(), "https://images.agoramedia.com/everydayhealth/gcms/The-Best-and-Worst-Foods-to-Eat-Before-Bed-722x406.jpg", "'url' parameter of 'image' object has incorrect value");
			assertEquals(image.getAsJsonObject().getAsJsonObject().get("width").getAsString(), "722", "'width' parameter of 'image' object should have '1440' value");
			assertEquals(image.getAsJsonObject().getAsJsonObject().get("height").getAsString(), "406", "'height' parameter of 'image' object should have '406' value");
			JsonElement publisher = schemaBodyJson.getAsJsonObject().getAsJsonObject("publisher");
			assertEquals(publisher.getAsJsonObject().getAsJsonObject().get("@type").getAsString(), "Organization", "'@type' parameter of 'publisher' object should have 'Organization' value");
			assertEquals(publisher.getAsJsonObject().getAsJsonObject().get("name").getAsString(), "Everyday Health", "'name' parameter of 'publisher' object should have 'Everyday Health' value");
			JsonElement logo = publisher.getAsJsonObject().getAsJsonObject("logo");
			assertEquals(logo.getAsJsonObject().getAsJsonObject().get("@type").getAsString(), "ImageObject", "'@type' parameter of 'logo' subobject should have 'ImageObject' value");
			assertEquals(logo.getAsJsonObject().getAsJsonObject().get("url").getAsString(), "https://images.agoramedia.com/everydayhealth/logos/eh%20logo.png", "'url' parameter of 'logo' subobject should has incorrect value");
			assertEquals(logo.getAsJsonObject().getAsJsonObject().get("width").getAsString(), "200", "'width' parameter of 'logo' subobject should have '200' value");
			assertEquals(logo.getAsJsonObject().getAsJsonObject().get("height").getAsString(), "50", "'height' parameter of 'logo' subobject should have '50' value");
			JsonElement interactionStatistic = schemaBodyJson.getAsJsonObject().getAsJsonObject("interactionStatistic");
			assertEquals(interactionStatistic.getAsJsonObject().getAsJsonObject().get("@type").getAsString(), "InteractionCounter", "'@type' parameter of 'interactionStatistic' object should have 'InteractionCounter' value");
			assertEquals(interactionStatistic.getAsJsonObject().getAsJsonObject().get("interactionType").getAsString(), "https://schema.org/CommentAction", "'interactionType' parameter of 'interactionStatistic' object should have 'http://schema.org/CommentAction' value");
		} catch (AssertionError | NullPointerException e) {
			fail("Schema mismatch found");
			Logger.info(e.getMessage());
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "C285497"})
	@TestRail(id = "C285497")
	public void verifyAmpValidationOnAmpPage() {
		assertTrue(isAmpValidationSuccessfull(), "AMP validation failed. Please check page source with AMP Validator.");
	}

	@Test(groups = {"EverydayHealthMobile", "C286199"})
	@TestRail(id = "C286199")
	public void verifyAmpPageContent() {
		String ampPageURL = Settings.getDefaultUrl() + TemplatesEH.AMP_PAGE.getTemplateURL() + "amp/";
		String canonicalLinkText = "<link rel=\"amphtml\" href=\"" + ampPageURL + "\">";
		ArticleBasePage articleBasePage = SiteNavigatorEH.goToPage(TemplatesEH.AMP_PAGE, ArticleBasePage.class);
		assertTrue(Utils.isPageSourceContains(canonicalLinkText), "Page source should contain link to AMP page");
		WebDriverManager.getDriver().get(ampPageURL);
		assertTrue(articleBasePage.isAmpPageHeaderVisible(), "AMP page header should be visible on page");
		assertTrue(Utils.isConnectionHTTPS(), "Page should be secured (HTTPS)");
		assertTrue(Utils.isPageSourceContains("https://sb.scorecardresearch.com/beacon.js"), "Comscore script should be present in AMP page source");
		assertTrue(articleBasePage.isAdDiv5Visible(), "adDiv5 should be visible on mobile");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C375542"})
	@TestRail(id = "C375542")
	public void verifyNativeAdOnArticlePage() {
		ArticleBasePage articlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3, ArticleBasePage.class);
		assertTrue(articlePage.isNativeAdVisible(), "Native ad should be visible");
		if (Settings.isMobile()) {
			assertTrue(articlePage.isContentCardNativeAdVisible(), "Content card native ad should be visible");
			assertEquals(articlePage.getContentCardNativeAdHeight(), 345, "Incorrect native ad height");
			assertEquals(articlePage.getContentCardNativeAdWidth(), 345, "Incorrect native ad width");
		}
		if (Settings.isDesktop()) {
			assertEquals(articlePage.getNativeAdHeight(), 90, "Native ad height should be 90px");
			assertEquals(articlePage.getNativeAdWidth(), 300, "Native ad width should be 300px");
			assertTrue(Utils.isPageSourceContains("adDiv99"), "Page source should contain 'adDiv99' string");
			if (articlePage.isProgrammedNativeAd()) {
				assertTrue(articlePage.isProgrammedNativeAdImageVisible(), "Native ad thumbnail image should be visible");
				assertTrue(articlePage.isProgrammedNativeAdTitleVisible(), "Native ad title should be visible");
				assertTrue(articlePage.isProgrammedNativeAdLabelVisible(), "'Ad' label should be visible on native ad");
			} else {
				articlePage.switchToNativeAdIFrame();
				assertTrue(articlePage.isNativeAdImageVisible(), "Native ad thumbnail image should be visible");
				assertTrue(articlePage.isNativeAdTitleVisible(), "Native ad title should be visible");
				assertTrue(articlePage.isNativeAdAdchoiceIconVisible(), "'AdChoice' icon should be visible on native ad");
				assertTrue(articlePage.isNativeAdLabelVisible(), "'Ad' label should be visible on native ad");
			}
		}
	}

	private boolean isAmpValidationSuccessfull() {
		Logger.info("Verifying AMP validation successful");
		String ampPageURL = Settings.getDefaultUrl() + TemplatesEH.AMP_PAGE.getTemplateURL() + "amp/";
		WebDriverManager.getDriver().get(ampPageURL + "#development=1");
		Utils.waitFor(5000); //wait for page to load
		LogEntries les = WebDriverManager.getDriver().manage().logs().get(LogType.BROWSER);
		for (LogEntry le : les) {
			Logger.debug(le.toString());
			if (le.getMessage().contains("https://cdn.ampproject.org/v0/validator.js")) {
				if (le.getMessage().contains("AMP validation successful.")) {
					Logger.info("AMP validation successful. No warnings and errors were found.");
					return true;
				}
				if (le.getMessage().contains("AMP validation had warnings")) {
					Logger.info("AMP validation successful, but warnings were found.");
					return true;
				}
				return false;
			}
		}
		return false;
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C376034"})
	@TestRail(id = "C376034")
	public void verifyGoogleMatchContentsOnArticlePage() {
		ArticleBasePage articlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3, ArticleBasePage.class);

		assertEquals(articlePage.getGMcontentCardAdSlot(), "4331001144", "Google match content section ad slot should be 4331001144");
		verifyGoogleMatchedContent(articlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C384192"})
	@TestRail(id = "C384192")
	public void verifyLatestArticlesModuleOnArticlePage() {
		ArticleBasePage articlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3, ArticleBasePage.class);

		verifyLatestArticlesModule(articlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C384270"})
	@TestRail(id = "C384270")
	public void verifyECommerceWidgetFunctionality() {
		ArticleNewTemplatePage articlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3_ECOMMERCE_WIDGET, ArticleNewTemplatePage.class);

		verifyECommerceModule(articlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C505400"})
	@TestRail(id = "C505400")
	public void verifyPromoBannerSectionOnArticlePage() {
		ArticleNewTemplatePage articlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3, ArticleNewTemplatePage.class);

		verifyPromoBannerSection(articlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "ArticleV3Test", "C671953"})
	@TestRail(id = "C671953")
	public void verifyAOLPlayerOnArticlePage() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			ArticleBasePage articlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_VIDEO_AOL, ArticleBasePage.class);
			verifyAOLPlayerFunctionality(articlePage);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ArticleV3Test", "C671982"})
	@TestRail(id = "C671982")
	public void verifyRelatedWidgetElements() {
		ArticleBasePage articlePage = SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3_ECOMMERCE_WIDGET, ArticleBasePage.class);
		assertTrue(articlePage.isRelatedContentWidgetVisible(), "Related content widget should be visible");
		assertFalse(articlePage.getRelatedContentWidgetHref().isEmpty(), "Related content widget should have valid URL in 'href'");
		assertTrue(articlePage.isRelatedContentWidgetImageVisible(), "Image should be visible on related content widget");
		assertTrue(articlePage.isRelatedContentWidgetTitleVisible(), "Related content widget should have title");
		assertTrue(articlePage.isRelatedContentWidgetDescriptionVisible(), "Related content widget should have description");
		assertTrue(articlePage.isRelatedContentWidgetEyebrowVisible(), "Related content widget should have eyebrow");
		assertEquals(articlePage.getWidgetBackgroundColor(), "#f6f6f6", "Related content widget should have grey background");
		articlePage.clickRelatedWidgetArticleLink();
		assertTrue(Utils.getCurrentURL().endsWith("?iid=content_widget"), "Opened URL should end with '?iid=content_widget'");
	}

	@Test(groups = {"EverydayHealthMobile", "ArticleV3Test", "C510194"})
	@TestRail(id = "C510194")
	public void verifyAdsLogicForMobileDevices() {
		ArticleBasePage articleBasePage;
		DebugMode debugMode;
		if (Settings.isEnvironment(Environment.PROD)) {
			articleBasePage = SiteNavigatorBase.openPage("/testpage/ap-636627575424856683/?test_ads=nativefullwidthadx", ArticleBasePage.class);
		} else {
			articleBasePage = SiteNavigatorBase.openPage("/testpage/ap-636625661843385119/?test_ads=nativefullwidthadx", ArticleBasePage.class);
		}
		debugMode = articleBasePage.inDebugMode();
		debugMode.scrollDownUntilNumberOfDebugAdsPresent(5);
		assertTrue(articleBasePage.isBox1AdVisible("2"), "Box1 ad should be visible below 2nd paragraph");
		assertTrue(articleBasePage.isNative2AdVisible("5"), "Native2 ad should be visible below 5th paragraph");
		assertTrue(articleBasePage.isBox2AdVisible("9"), "Box2 ad should be visible below 9th paragraph");
		assertTrue(articleBasePage.isBoxExtraAdVisible("12"), "Boxextra ad should be visible below 12th paragraph");

		if (!Settings.isEnvironment(Environment.PROD)) {

			articleBasePage = SiteNavigatorBase.openPage("/testpage/ap-636625652141405119/?test_ads=nativefullwidthadx", ArticleBasePage.class);
			debugMode = articleBasePage.inDebugMode();
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			assertTrue(articleBasePage.isBox1AdVisible("2"), "Box1 ad should be visible below 2nd paragraph");
			assertTrue(articleBasePage.isNative2AdVisible("5"), "Native2 ad should be visible below 5th paragraph");
			assertTrue(articleBasePage.isAdVisibleBelowArticle("adDiv7"), "Box2 ad should be visible below article content");
			assertFalse(articleBasePage.isAdDiv9Visible(), "adDiv9 should not be visible");

			articleBasePage = SiteNavigatorBase.openPage("/testpage/ap-636624779179315119/?test_ads=nativefullwidthadx", ArticleBasePage.class);
			debugMode = articleBasePage.inDebugMode();
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			assertTrue(articleBasePage.isBox1AdVisible("2"), "Box1 ad should be visible below 2nd paragraph");
			assertTrue(articleBasePage.isAdVisibleBelowArticle("adDiv100"), "Native2 ad should be visible below article");
			assertTrue(articleBasePage.isAdVisibleBelowNewslettersModule("adDiv7"), "Box2 ad should be visible below newsletters module");
			assertFalse(articleBasePage.isAdDiv9Visible(), "adDiv9 should not be visible");

			articleBasePage = SiteNavigatorBase.openPage("/testpage/ap-636624809257605119/?test_ads=nativefullwidthadx", ArticleBasePage.class);
			debugMode = articleBasePage.inDebugMode();
			debugMode.scrollDownUntilNumberOfDebugAdsPresent(4);
			assertTrue(articleBasePage.isBox1AdVisible("2"), "Box1 ad should be visible below 2nd paragraph");
			assertTrue(articleBasePage.isAdVisibleBelowArticle("adDiv100"), "Native2 ad should be visible below article");
			assertTrue(articleBasePage.isAdVisibleBelowNewslettersModule("adDiv7"), "Box2 ad should be visible below newsletters module");
			assertFalse(articleBasePage.isAdDiv9Visible(), "adDiv9 should not be visible");
		}
	}
}