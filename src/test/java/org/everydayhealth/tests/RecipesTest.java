package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.login.LoginPageEH;
import everydayhealth.pages.recipes.RecipesPage;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.MarketingPixels;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * RecipesTest
 */
public class RecipesTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "RecipesTest", "C260108"})
	@TestRail(id = "C260108")
	public void verifyRecipesPageElements() {
		RecipesPage recipesPage = SiteNavigatorEH.goToPage(TemplatesEH.RECIPES, RecipesPage.class);

		if (!Settings.isMobile()) {
			assertTrue(recipesPage.isTopAdVisible(), "Top ad block should be visible");
			assertTrue(recipesPage.isBottomAdVisible(), "Bottom ad block should be visible");
			assertTrue(recipesPage.isDontMissThisSectionVisible(), "'Don't miss this' section should be visible");
			if (Settings.isDesktop()) {
				recipesPage.scrollDownThePage();
				assertTrue(recipesPage.isBackToTopVisible(), "'Back to top' button should be visible");
				recipesPage.clickBackToTopButton();
				assertFalse(recipesPage.isRecommendedForYouSectionVisible(), "'Recommended for you' section should not be visible");
			}
		}
		assertTrue(recipesPage.isAdDiv5Visible() || recipesPage.isAdDiv7Visible(), "Right rail ad block should be visible");
		if (Settings.isMobile()) {
			assertTrue(recipesPage.isAdDiv5Visible(), "AdDiv5 ad block should be visible");
			assertTrue(recipesPage.isAdDiv7Visible(), "AdDiv7 ad block should be visible");
			assertTrue(recipesPage.isAdDiv9Visible(), "AdDiv9 ad block should be visible");
		}
		assertTrue(recipesPage.onGlobalNavHeader().isGlobalNavHeaderVisible(), "Header should be visible");
		assertTrue(recipesPage.onZDFooter().isFooterVisible(), "Footer should be visible");

		assertTrue(recipesPage.isAddToMealPlanButtonVisible(), "'Add to Meal Plan' button should be visible");
		LoginPageEH loginPageEH = recipesPage.clickAddToMealPlanButton();
		assertTrue(loginPageEH.isLoginFormVisible(), "Click on 'Add to Meal Plan' button should lead to login page");
		loginPageEH.clickBackBrowserButton(RecipesPage.class);
		assertTrue(recipesPage.isAddToJournalButtonVisible(), "'Add to Journal' button should be visible");
		loginPageEH = recipesPage.clickAddToJournalButton();
		assertTrue(loginPageEH.isLoginFormVisible(), "Click on 'Add to Journal' button should lead to login page");
		loginPageEH.clickBackBrowserButton(RecipesPage.class);
		assertTrue(recipesPage.isFavoriteButtonVisible(), "Favorite '*' button should be visible");
		loginPageEH = recipesPage.clickFavoriteButton();
		assertTrue(loginPageEH.isLoginFormVisible(), "Click on Favorite '*' button should lead to login page");
		loginPageEH.clickBackBrowserButton(RecipesPage.class);

		SocialBarEH socialBarEH = recipesPage.onSocialBar();
		assertTrue(socialBarEH.isSocialBarVisible(), "Social bar should be visible");
		assertTrue(socialBarEH.isFacebookShareButtonVisible(), "'Facebook' share button should be visible");
		assertTrue(socialBarEH.isTwitterShareButtonVisible(), "'Twitter' share button should be visible");
		assertTrue(socialBarEH.isPinterestShareButtonVisible(), "'Pinterest' share button should be visible");
		assertTrue(socialBarEH.isEmailShareButtonVisible(), "'Email' share button should be visible");
		if (Settings.isDesktop()) {
			assertTrue(socialBarEH.isPrintShareButtonVisible(), "'Print' share button should be visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "RecipesTest", "C260119"})
	@TestRail(id = "C260119")
	public void verifyOmniture() {
		SiteNavigatorEH.goToPage(TemplatesEH.RECIPES, RecipesPage.class);

		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event77"), "'event5,event77' should fire on page load");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/healthyliving/recipes"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "rec"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/healthyliving/recipes"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "rec|/healthyliving/recipes"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "rec|/healthyliving/recipes|-1|Raspberries Recipe | Everyday Health"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/recipes/raspberries/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "recipes 2.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "healthy living"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "recipe"), "eVar68 is incorrect");

		assertTrue(MarketingPixels.isOmnitureEventPresent("prop1", "/healthyliving/recipes"), "prop1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop2", "rec"), "prop2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop5", "/healthyliving/recipes"), "prop5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop6", "rec|/healthyliving/recipes"), "prop6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("prop8", "rec|/healthyliving/recipes|-1|Raspberries Recipe | Everyday Health"), "prop8 is incorrect");
	}
}
