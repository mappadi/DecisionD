package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.EHPublicPage;
import everydayhealth.pages.articles.ArticleNewTemplatePage;
import everydayhealth.pages.articles.SlideshowBasePage;
import everydayhealth.pages.guides.GuidesBasePage;
import framework.Logger;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserActionsEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.Utils;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.FileAssert.fail;

/**
 * VarnishTest
 */
public class VarnishTest {

	private final String MISS = "MISS";
	private final String HIT = "HIT";
	private final String X_CACHE = "X-Cache";
	private final String AGE = "Age";

	@Test(groups = {"EverydayHealthDesktop", "VarnishTests", "C216851"})
	@TestRail(id = "C216851")
	public void testVarnishDetails() {
		Logger.info("Get cookies for logged in user");
		EHPublicPage ehPublicPage = UserActionsEH.loginWithUser(UserCacheEH.MAIN_USER, true);
		Set<Cookie> cookiesLoggedIn = CookiesManager.getCookies();
		ehPublicPage.refresh();
		Logger.info("Get cookies for logged in user after page refresh");
		Set<Cookie> cookiesLoggedInAfterRefresh = CookiesManager.getCookies();
		UserActionsEH.logout(true);
		Logger.info("Get cookies for logged out user");
		Set<Cookie> cookiesLoggedOut = CookiesManager.getCookies();

		Logger.info("Check varnish details on main page");
		varnishTest(Utils.getCurrentURL());
		varnishTestForUser(Utils.getCurrentURL(), cookiesLoggedIn, cookiesLoggedInAfterRefresh, cookiesLoggedOut);

		Logger.info("Check varnish details on article 3.0 template page");
		SiteNavigatorEH.goToPage(TemplatesEH.ARTICLE_V3, ArticleNewTemplatePage.class);
		varnishTest(Utils.getCurrentURL());
		varnishTestForUser(Utils.getCurrentURL(), cookiesLoggedIn, cookiesLoggedInAfterRefresh, cookiesLoggedOut);

		Logger.info("Check varnish details on guides template page");
		SiteNavigatorEH.goToPage(TemplatesEH.GUIDE, GuidesBasePage.class);
		varnishTest(Utils.getCurrentURL());
		varnishTestForUser(Utils.getCurrentURL(), cookiesLoggedIn, cookiesLoggedInAfterRefresh, cookiesLoggedOut);

		Logger.info("Check varnish details on slideshow 3.0 template page");
		SiteNavigatorEH.goToPage(TemplatesEH.SLIDESHOW, SlideshowBasePage.class);
		varnishTest(Utils.getCurrentURL());
		varnishTestForUser(Utils.getCurrentURL(), cookiesLoggedIn, cookiesLoggedInAfterRefresh, cookiesLoggedOut);
	}

	public void varnishTest(String url) {
		HttpURLConnection con;
		try {
			con = (HttpURLConnection) new URL(url).openConnection();
			int ageValue = 0;
			if (con.getHeaderField(X_CACHE).equals(MISS)) {
				Logger.info("Page is recently published and opened for the 1st time. Checking 'Age' value to be '0'");
				assertEquals(con.getHeaderField(AGE), "0", "'Age' value should be '0' for 1st visit");
			} else {
				assertEquals(con.getHeaderField(X_CACHE), HIT, "'X-cache' value should be 'HIT'");
				Logger.info("'Age' = " + con.getHeaderField(AGE));
				assertTrue(Integer.parseInt(con.getHeaderField(AGE)) > 0, "'Age' value should be positive numerical");
				ageValue = Integer.parseInt(con.getHeaderField(AGE));
			}
			Logger.info("Refresh the page");
			Utils.waitFor(1000); //waiting 1 second to get proper age value
			con = (HttpURLConnection) new URL(url).openConnection();
			assertEquals(con.getHeaderField(X_CACHE), HIT, "'X-Cache' value should be 'Hit'");
			Logger.info("'Age' = " + con.getHeaderField(AGE));
			assertTrue(Integer.parseInt(con.getHeaderField(AGE)) > 0, "'Age' value should be positive numerical");
			assertTrue(Integer.parseInt(con.getHeaderField(AGE)) > ageValue, "'Age' ");
		} catch (Exception e) {
			fail("Test failed. Please see stacktrace", e);
		}
	}

	public void varnishTestForUser(String url, Set<Cookie> cookiesFirstVisit, Set<Cookie> cookiesFirstVisitAfterRefresh, Set<Cookie> cookiesLoggedOut) {
		HttpURLConnection con;
		try {
			con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestProperty("Cookie", cookiesFirstVisit.toString());
			con.setRequestMethod("HEAD");
			assertEquals(con.getHeaderField(X_CACHE), MISS, "'X-Cache' value should be 'Miss'");
			assertEquals(con.getHeaderField(AGE), "0", "'Age' value should be '0'");

			con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestProperty("Cookie", cookiesFirstVisitAfterRefresh.toString());
			con.setRequestMethod("HEAD");
			assertEquals(con.getHeaderField(X_CACHE), MISS, "'X-Cache' value should be 'Miss'");
			assertEquals(con.getHeaderField(AGE), "0", "'Age' value should be '0'");

			con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestProperty("Cookie", cookiesLoggedOut.toString());
			con.setRequestMethod("HEAD");
			if (con.getHeaderField(X_CACHE).equals(MISS)) {
				Logger.info("Page is recently published and opened for the 1st time. Checking 'Age' value to be '0'");
				assertEquals(con.getHeaderField(AGE), "0", "'Age' value should be '0' for 1st visit");
			} else {
				assertEquals(con.getHeaderField(X_CACHE), HIT, "'X-cache' value should be 'HIT'");
				Logger.info("'Age' = " + con.getHeaderField(AGE));
				assertTrue(Integer.parseInt(con.getHeaderField(AGE)) > 0, "'Age' value should be positive numerical");
			}
		} catch (Exception e) {
			fail("Test failed. Please see stacktrace", e);
		}
	}
}
