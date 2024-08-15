package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.columns.BlogAuthorPage;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * BlogAuthorPageTest
 */
public class BlogAuthorPageTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogAuthorTest", "C346290"})
	@TestRail(id = "C346290")
	public void verifyBlogAuthorPageElements() {
		BlogAuthorPage blogAuthorPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOGS_AUTHOR, BlogAuthorPage.class);
		assertTrue(blogAuthorPage.isAuthorImageVisible(), "Author image should be visible");
		assertTrue(blogAuthorPage.isAuthorNameVisible(), "Author name should be visible");
		String authorName = blogAuthorPage.getAuthorName();
		assertTrue(Utils.getCurrentURL().replace("?isautomation=true", "").endsWith(authorName.toLowerCase().replace(" ", "-") + "/"), "URL should end with author name");
		assertTrue(blogAuthorPage.isAuthorDescriptionVisible(), "Author description should be visible");
		int numberOfSocialIcons = blogAuthorPage.getNumberOfSocialIcons();
		for (int icon = 1; icon <= numberOfSocialIcons; icon++) {
			assertTrue(blogAuthorPage.isSocialIconVisible(icon), "Social network icon should be visible");
		}
		assertTrue(blogAuthorPage.getSocialIconHrefValue(1).contains("facebook.com"), "First social icon should lead to Facebook");
		assertTrue(blogAuthorPage.getSocialIconHrefValue(2).contains("twitter.com"), "Second social icon should lead to Twitter");
	}
}
