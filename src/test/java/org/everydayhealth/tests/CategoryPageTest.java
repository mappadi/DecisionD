package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.conditions.CategoryLandingPage;
import framework.Logger;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * CategoryPageTest
 */
public class CategoryPageTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CategoryPageTest", "C344814"})
	@TestRail(id = "C344814")
	public void verifyTitleSection() {
		CategoryLandingPage categoryLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_LANDING, CategoryLandingPage.class);
		String category = categoryLandingPage.getCategoryForPage();
		assertTrue(categoryLandingPage.isHeadlineVisible(), "Headline should be visible");
		assertEquals(categoryLandingPage.getHeadlineText(), category, "Category page headline should be equal to page category");
		assertTrue(categoryLandingPage.isDeckVisible(), "Description should be visible");
		assertTrue(categoryLandingPage.isAllArticlesWidgetVisible(), "'All Articles' widget should be visible");
		assertTrue(categoryLandingPage.isAllArticlesTypesTabVisible(), "'Types' tab should be visible on 'All Articles' widget");
		assertTrue(categoryLandingPage.isAllArticlesLinkVisible(), "'All Articles' tab should be visible");
		String allArticlesLink = categoryLandingPage.getAllArticlesLink();
		assertTrue(allArticlesLink.startsWith(Settings.getDefaultUrl() + "/cancer"), "'All articles' link should contain category name");
		assertTrue(allArticlesLink.contains("articles"), "'All articles' link should contain 'articles' string");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CategoryPageTest", "C344815"})
	@TestRail(id = "C344815")
	public void verifyCategoryPageContent() {
		CategoryLandingPage categoryLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_LANDING, CategoryLandingPage.class);
		String category = categoryLandingPage.getCategoryForPage();
		assertTrue(categoryLandingPage.isSubcategorySectionHeadlineVisible(), "Subcategory section headline should be visible");
		assertTrue(categoryLandingPage.getSubcategorySectionHeadlineText().equalsIgnoreCase("Types of " + category), "Text should be 'Types of %category%'");
		int numberOfSubcategories = categoryLandingPage.getNumberOfSubcategorySectionElements();
		int numberOfAccordions = categoryLandingPage.getNumberOfSubcategorySectionOpenAccordions();
		assertEquals(numberOfAccordions, numberOfSubcategories, "Each subcategory should have accordion arrow in open state (down)");
		if (numberOfSubcategories < 5) {
			assertTrue(categoryLandingPage.isNewsletterPlacedAfterSection(numberOfSubcategories), "Newsletter widget should be placed in the last slot");
		} else {
			if (Settings.isMobile()) {
				assertTrue(categoryLandingPage.isNewsletterPlacedAfterSection(3), "Newsletter widget should be placed after 3rd slot");
			} else {
				assertTrue(categoryLandingPage.isNewsletterPlacedAfterSection(6), "Newsletter widget should be placed after 6th slot");
			}
		}
		for (int section = 1; section <= numberOfSubcategories; section++) {
			if (!Settings.isMobile()) {
				assertFalse(categoryLandingPage.getAccordionState(section).contains("collapsed"), "Section should not be collapsed on desktop");
			} else {
				if (section == 1) {
					assertFalse(categoryLandingPage.getAccordionState(section).contains("collapsed"), "Section #1 should not be collapsed on mobile");
				} else {
					assertTrue(categoryLandingPage.getAccordionState(section).contains("collapsed"), "Section should be collapsed on mobile");
				}
			}
			assertTrue(categoryLandingPage.isSectionTitleVisible(section), "Each section should have title");
			if (categoryLandingPage.isSectionTitleHyperlinked(section)) {
				assertFalse(categoryLandingPage.getSectionTitleHrefValue(section).isEmpty(), "'href' attribute should not be empty for hyperlinked titles");
			} else {
				Logger.info("Subcategory title is not hyperlinked");
			}
			if (!Settings.isMobile()) {
				assertTrue(categoryLandingPage.isSectionDescriptionVisible(section), "Each section should have description");
			}
			if (categoryLandingPage.isSectionArticlesListVisible(section)) {
				int numberOfArticles = categoryLandingPage.getNumberOfArticlesInList(section);
				for (int article = 1; article <= numberOfArticles; article++) {
					assertFalse(categoryLandingPage.getHrefValueOfArticleInList(section, article).isEmpty(), "'href' attribute should not be empty for articles in the list");
				}
			} else {
				Logger.info("'More in %subcategory%' is not present in section #" + section);
			}
			if (categoryLandingPage.isReadAboutVisible(section)) {
				int numberOfTopics = categoryLandingPage.getNumberOfTopicsInReadAbout(section);
				for (int topic = 1; topic <= numberOfTopics; topic++) {
					assertFalse(categoryLandingPage.getHrefValueForReadAboutTopic(section, topic).isEmpty(), "'href' attribute should not be empty for topics in the list");
				}
			} else {
				Logger.info("'Read about' is not present for section #" + section);
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CategoryPageTest", "C344817"})
	@TestRail(id = "C344817")
	public void verifyPromoWidget() {
		CategoryLandingPage categoryLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_LANDING, CategoryLandingPage.class);
		assertTrue(categoryLandingPage.isPromoWidgetVisible(), "Promo widget should be visible");
		assertTrue(categoryLandingPage.isPromoWidgetTitleVisible(), "Promo widget title should be visible");
		assertFalse(categoryLandingPage.getPromoWidgetTitleHref().isEmpty(), "Promo widget title 'href' should not be empty");
		assertTrue(categoryLandingPage.isPromoWidgetDescriptionVisible(), "Promo widget description should be visible");
		assertTrue(categoryLandingPage.isPromoWidgetLearnMoreLinkVisible(), "Promo widget 'Learn more about...' should be visible");
		assertFalse(categoryLandingPage.getPromoWidgetLearnMoreLinkHref().isEmpty(), "Promo widget 'Learn more about...' link 'href' should not be empty");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CategoryPageTest", "C346287"})
	@TestRail(id = "C346287")
	public void verifyNewsletterWidgetFunctionality() {
		CategoryLandingPage categoryLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_LANDING, CategoryLandingPage.class);

		verifyNewsletterWidgetFunctionality(categoryLandingPage);
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event4", "'event4' should fire");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cancer/general"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "land"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cancer/general"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "land|/cancer/general"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "land|/cancer/general|"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].split("#")[0].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "category landing"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar42", "center"), "eVar42 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "cancer"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "cancer"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CategoryPageTest", "C505409"})
	@TestRail(id = "C505409")
	public void verifyPromoBannerSectionOnCLPage() {
		CategoryLandingPage categoryLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_LANDING, CategoryLandingPage.class);

		verifyPromoBannerSection(categoryLandingPage);
	}
}