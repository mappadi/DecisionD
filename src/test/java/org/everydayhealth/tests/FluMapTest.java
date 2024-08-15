package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.articles.FluMapPage;
import everydayhealth.pages.share.SocialBarEH;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * FluMapTest
 */
public class FluMapTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "FluMap", "C217056"})
	@TestRail(id = "C217056")
	public void verifyFluMapGUI() {
		FluMapPage fluMapPage = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);

		if (!Settings.isMobile()) {
			assertTrue(fluMapPage.isTopAdVisible(), "Top ad should be visible");
			assertTrue(fluMapPage.isAdDiv5Visible(), "Right rail ad should be visible");
			assertTrue(fluMapPage.isBottomAdVisible(), "Bottom ad should be visible");
		}
		assertTrue(fluMapPage.isFluMapVisible(), "Flu map should be visible");
		assertTrue(fluMapPage.onSocialBar().isSocialBarVisible(), "Social bar should be visible");
		assertTrue(fluMapPage.isArticleBodyVisible(), "Article content should be visible");
		assertTrue(fluMapPage.isTitleVisible(), "Article header should be visible");
		assertTrue(fluMapPage.isDeckVisible(), "Deck should be visible");
		assertTrue(fluMapPage.isNewsLetterEmailBoxVisible(), "Newsletter 'Email' text field should be visible");
		assertTrue(fluMapPage.isNewsLetterSubmitButtonVisible(), "Newsletter 'Submit' button should be visible");
		assertTrue(fluMapPage.isYouMayLikeSectionVisible(), "'You may like' section should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "FluMap", "C217063"})
	@TestRail(id = "C217063")
	public void verifyNewsletterSignUpFunctionality() {
		FluMapPage fluMapPage = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);

		verifyNewsletterModuleFunctionality(fluMapPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "FluMap", "C217066"})
	@TestRail(id = "C217066")
	public void verifySSOFunctionality() {
		SocialBarEH socialBarEH = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class).onSocialBar();

		assertTrue(socialBarEH.isFacebookShareButtonVisible(), "'Facebook' share button should be visible");
		assertTrue(socialBarEH.isTwitterShareButtonVisible(), "'Twitter' share button should be visible");
		assertTrue(socialBarEH.isPinterestShareButtonVisible(), "'Pinterest' share button should be visible");
		assertTrue(socialBarEH.isEmailShareButtonVisible(), "'Email' share button should be visible");
		assertTrue(socialBarEH.isSaveLinkVisible(), "'Save' link should be visible");
		assertTrue(socialBarEH.isSaveButtonOnLeftHandSideOfScreen(), "'Save' button should be situated on LHS of the screen");
		assertTrue(socialBarEH.isSocialShareCountVisible(), "Social share counter should be visible");

		if (Settings.isDesktop()) {
			assertTrue(socialBarEH.isPrintShareButtonVisible(), "'Print' share button should be visible");
			assertEquals(socialBarEH.getNumberOfShares(), socialBarEH.getSumOfSharesFromSocialShareButtons(true), "Number of shares should be equal to the sum of shares for every button");
			socialBarEH.verifyAllPopUpsContainRespectiveDomain();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "FluMap", "C217057"})
	@TestRail(id = "C217057")
	public void verifyEyebrowNavigation() {
		FluMapPage fluMapPage = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);

		String category = fluMapPage.getCategoryForPage().replace(" & ", "-").toLowerCase();
		String subCategory = fluMapPage.getSubCategoryForPage().replace(" & ", "-").toLowerCase();
		verifyBreadcrumbs(fluMapPage, category, subCategory);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "FluMap", "C217058"})
	@TestRail(id = "C217058")
	public void verifyFluMapZipCodeFunctionality() {
		FluMapPage fluMapPage = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);

		fluMapPage.typeZipCode("10014").clickGoButton();
		assertTrue(fluMapPage.isFluForecastFlyoutVisible(), "Flu forecast flyout should appear");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "FluMap", "C217059"})
	@TestRail(id = "C217059")
	public void verifyFluMapLocationFunctionality() {
		FluMapPage fluMapPage = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);

		fluMapPage.clickRandomLocation();
		assertTrue(fluMapPage.isFluForecastFlyoutVisible(), "Flu forecast flyout should be visible");
		assertTrue(fluMapPage.isLocationInFocus(), "Chosen location should be in focus");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "FluMap", "C217060"})
	@TestRail(id = "C217060")
	public void verifyPharmacyLocationsLink() {
		FluMapPage fluMapPage = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);
		fluMapPage.clickRandomLocation();
		assertTrue(fluMapPage.isPharmacyLocationsLinkVisible(), "'Pharmacy locations' link should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "FluMap", "C217061"})
	@TestRail(id = "C217061")
	public void verifyPharmacyLocationNavigation() {
		FluMapPage fluMapPage = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);
		fluMapPage.clickRandomLocation()
				.clickPharmacyLocationsLink();
		assertTrue(fluMapPage.isReturnButtonVisible(), "'Return to Flu Map' link should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "FluMap", "C217067"})
	@TestRail(id = "C217067")
	public void verifySymptomsLinks() {
		FluMapPage fluMapPage = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);

		int numberOfSymptomsLinks = fluMapPage.getNumberOfSymptomsLinks();
		for (int linkNumber = 0; linkNumber < numberOfSymptomsLinks; linkNumber++) {
			fluMapPage.isRelatedLink(linkNumber);
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "EverydayHealthTablet", "FluMap", "C217068"})
	@TestRail(id = "C217068")
	public void verifyYouMayLikeSection() {
		FluMapPage fluMapPage = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);
		int numberOfLinks = fluMapPage.getNumberOfYouMayLikeLinks();
		for (int linkNumber = 1; linkNumber <= numberOfLinks; linkNumber++) {
			assertTrue(fluMapPage.getHrefOfYouMayLikeLink(linkNumber).startsWith("https://"), "Links in 'You May Like' section should be valid");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "FluMap", "C217062"})
	@TestRail(id = "C217062")
	public void verifyMinimizeMaximizeIcons() {
		FluMapPage fluMapPage = SiteNavigatorEH.goToPage(TemplatesEH.FLU_MAP, FluMapPage.class);

		assertTrue(fluMapPage.isMinimizeIconVisible(), "'Minimize' icon should be visible");
		assertTrue(fluMapPage.isMaximizeIconVisible(), "'Maximize' icon should be visible");
		fluMapPage.clickRandomLocation();
		//when navigation unit disappears, isVisible() for icons still 'true'; when unit is not visible 'transform' attribute should have following value 'translate(-60,0)'
		assertEquals(fluMapPage.getNavigationUnitTransformAttributeValue(), "translate(-60,0)", "Navigation unit should not be visible");
		fluMapPage.clickFlyoutCloseButton();
		assertTrue(fluMapPage.getScaleValue().contains("scale(1,1)"), "Map should not be zoomed in");
		fluMapPage.clickZoomInButton();
		assertTrue(fluMapPage.getScaleValue().contains("scale(2,2)"), "Map should be zoomed in");
		fluMapPage.clickZoomOutButton();
		assertTrue(fluMapPage.getScaleValue().contains("scale(1,1)"), "Map should be zoomed out");
	}
}
