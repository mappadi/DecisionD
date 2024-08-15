package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.articles.CusoVideologuesPage;
import everydayhealth.pages.articles.SlideshowBasePage;
import framework.Logger;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserCacheEH;
import framework.platform.UserEH;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Tile3ForCusoTest
 */
public class Tile3ForCusoTest {

	UserEH adsUser = UserCacheEH.ADS_USER;

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "Tile3Test", "C215430"})
	@TestRail(id = "C215430")
	public void verifyTile3AdOnCusoLandingPageTest() {
		checkAdsOnPage(false, SiteNavigatorEH.goToCusoLandingLobbyPage());
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "Tile3Test", "C215443"})
	@TestRail(id = "C215443")
	public void verifyTile3AdOnCusoLandingPageUserTest() {
		checkAdsOnPage(true, SiteNavigatorEH.goToCusoLandingLobbyPage());
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "Tile3Test", "C215446"})
	@TestRail(id = "C215446")
	public void verifyTile3AdInCusoLandingPageSourceTest() {
		SiteNavigatorEH.goToCusoLandingLobbyPage();
		assertTrue(Utils.isPageSourceContains("Tile=3"), "Tile 3 ad details should be present in page source");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "Tile3Test", "C215444"})
	@TestRail(id = "C215444")
	public void verifyTile3AdOnCusoArticlePageTest() {
		checkAdsOnPage(false, SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE));
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "Tile3Test", "C215445"})
	@TestRail(id = "C215445")
	public void verifyTile3AdOnCusoArticlePageUserTest() {
		checkAdsOnPage(true, SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE));
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "Tile3Test", "C215448"})
	@TestRail(id = "C215448")
	public void verifyTile3AdInCusoArticlePageSourceTest() {
		SiteNavigatorEH.goToCusoArticlePage(TemplatesEH.CUSO_ARTICLE);
		assertTrue(Utils.isPageSourceContains("Tile=3"), "Tile 3 ad details should be present in page source");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "Tile3Test", "C215636"})
	@TestRail(id = "C215636")
	public void verifyTile3AdOnCusoSlideshowPageTest() {
		checkAdsOnPage(false, SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, SlideshowBasePage.class));
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "Tile3Test", "C215637"})
	@TestRail(id = "C215637")
	public void verifyTile3AdOnCusoSlideshowPageUserTest() {
		checkAdsOnPage(true, SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, SlideshowBasePage.class));
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "Tile3Test", "C215638"})
	@TestRail(id = "C215638")
	public void verifyTile3AdInCusoSlideshowPageSourceTest() {
		SiteNavigatorEH.goToPage(TemplatesEH.CUSO_SLIDESHOW, SlideshowBasePage.class);
		assertTrue(Utils.isPageSourceContains("Tile=3"), "Tile 3 ad details should be present in page source");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "Tile3Test", "C215639"})
	@TestRail(id = "C215639")
	public void verifyTile3AdOnCusoVideologuesPageTest() {
		CusoVideologuesPage videologuesPage = SiteNavigatorEH.goToCusoVideologuesSingleTabPage();
		checkAdsOnPage(false, videologuesPage);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "Tile3Test", "C215640"})
	@TestRail(id = "C215640")
	public void verifyTile3AdOnCusoVideologuesPageUserTest() {
		CusoVideologuesPage videologuesPage = SiteNavigatorEH.goToCusoVideologuesSingleTabPage();
		checkAdsOnPage(true, videologuesPage);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoVideologues", "Tile3Test", "C215641"})
	@TestRail(id = "C215641")
	public void verifyTile3AdInCusoVideologuesPageSourceTest() {
		SiteNavigatorEH.goToCusoVideologuesSingleTabPage();
		assertTrue(Utils.isPageSourceContains("Tile=3"), "Tile 3 ad details should be present in page source");
	}

	private void checkAdsOnPage(boolean isLoggedIn, BasicPageEH basicPageEH) {
		if (isLoggedIn) {
			loginWithAdsUserOnNewHeader(basicPageEH);
		}
		SiteNavigatorEH.goToTestAdMode();
		assertTrue(basicPageEH.isLogoAdBlockVisible(), "Logo ad block (adDiv3) should be visible on page");
	}

	private void loginWithAdsUserOnNewHeader(BasicPageEH basicPageEH) {
		Logger.info("Performing login action with \"ads user\"");
		basicPageEH.onHeaderCCR().loginWithUserAndOpenPage(adsUser, BasicPageEH.class);
	}
}
