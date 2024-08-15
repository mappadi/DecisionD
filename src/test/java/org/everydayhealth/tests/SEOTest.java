package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import framework.Logger;
import framework.platform.SiteNavigatorEH;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * SEOTest
 */
public class SEOTest {

	@Test(groups = {"EverydayHealthDesktop", "SeoTest", "C189436"})
	@TestRail(id = "C189436")
	public void seoPagesTest() {
		SiteNavigatorEH.openPage("/sitemap.xml");
		Logger.info("Verifying the '/sitemap.xml' file exists off doc root and is valid xml markup");
		assertFalse(Utils.isPageSourceContains("page contains the following errors"), "Sitemap.xml contains errors");
		assertTrue(Utils.isPageSourceContains("<loc>"), "Sitemap does not contain <loc> nest");
		assertTrue(Utils.isPageSourceContains("</loc>"), "Sitemap does not contain </loc> nest");

		SiteNavigatorEH.openPage("/sitemap-index.xml");
		Logger.info("Verifying the '/sitemap-index.xml' file exists off doc root and is valid xml markup");
		assertFalse(Utils.isPageSourceContains("page contains the following errors"), "Sitemap.xml contains errors");
		assertTrue(Utils.isPageSourceContains("<loc>"), "Sitemap does not contain <loc> nest");
		assertTrue(Utils.isPageSourceContains("</loc>"), "Sitemap does not contain </loc> nest");

		//will be uncommented when requirements on news-sitemap.xml will be clarified
//		SiteNavigatorEH.openPage("/news-sitemap.xml");
//		Logger.info("Verifying the '/news-sitemap.xml' file exists off doc root and is valid xml markup");
//		assertFalse(Utils.isPageSourceContains("page contains the following errors"), "Sitemap.xml contains errors");
//		assertTrue(Utils.isPageSourceContains("<loc>"), "Sitemap does not contain <loc> nest");
//		assertTrue(Utils.isPageSourceContains("</loc>"), "Sitemap does not contain </loc> nest");

		SiteNavigatorEH.openPage("/general-sitemap.xml");
		Logger.info("Verifying the '/general-sitemap.xml' file exists off doc root and is valid xml markup");
		assertFalse(Utils.isPageSourceContains("page contains the following errors"), "Sitemap.xml contains errors");
		assertTrue(Utils.isPageSourceContains("<loc>"), "Sitemap does not contain <loc> nest");
		assertTrue(Utils.isPageSourceContains("</loc>"), "Sitemap does not contain </loc> nest");

		SiteNavigatorEH.openPage("/robots.txt");
		Logger.info("Verifying the '/robots.txt' file exists off doc root and contains 'user-agent' and 'disallow' rules");
		assertFalse(Utils.isPageSourceContains("error"), "Robots.txt contains errors");
		assertTrue(Utils.isPageSourceContains("User-agent"), "Robots.txt does not contain 'User-agent'");
		assertTrue(Utils.isPageSourceContains("Disallow"), "Robots.txt does not contain 'Disallow'");
		assertTrue(Utils.isPageSourceContains("Noindex"), "Robots.txt does not contain 'Noindex'");
	}

}
