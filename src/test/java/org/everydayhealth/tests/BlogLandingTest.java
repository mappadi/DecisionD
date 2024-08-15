package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.columns.BlogLandingPage;
import framework.Logger;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * BlogLandingTest
 */
public class BlogLandingTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogLandingTest", "C328361"})
	@TestRail(id = "C328361")
	public void verifyBlogLandingMultipleAuthorPageElements() {
		BlogLandingPage blogLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_MULTIPLE_AUTHORS, BlogLandingPage.class);
		verifyBlogLandingPageElements(blogLandingPage, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogLandingTest", "C328363"})
	@TestRail(id = "C328363")
	public void verifyBlogLandingMultipleAuthorPageContent() {
		BlogLandingPage blogLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_MULTIPLE_AUTHORS, BlogLandingPage.class);
		verifyBlogsLandingPageContent(blogLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogLandingTest", "C330387"})
	@TestRail(id = "C330387")
	public void verifyBlogLandingSingleAuthorPageElements() {
		BlogLandingPage blogLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_SINGLE_AUTHOR, BlogLandingPage.class);
		verifyBlogLandingPageElements(blogLandingPage, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogLandingTest", "C330389"})
	@TestRail(id = "C330389")
	public void verifyBlogLandingSingleAuthorPageContent() {
		BlogLandingPage blogLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_SINGLE_AUTHOR, BlogLandingPage.class);
		verifyBlogsLandingPageContent(blogLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogLandingTest", "C330394"})
	@TestRail(id = "C330394")
	public void verifyBlogsLandingSingleAuthorNewsletterWidgetFunctionality() {
		BlogLandingPage blogLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_SINGLE_AUTHOR, BlogLandingPage.class);
		verifyNewsletterWidgetFunctionality(blogLandingPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogLandingTest", "C329777"})
	@TestRail(id = "C329777")
	public void verifyBlogsLandingMultipleAuthorNewsletterWidgetFunctionality() {
		BlogLandingPage blogLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_MULTIPLE_AUTHORS, BlogLandingPage.class);
		verifyNewsletterWidgetFunctionality(blogLandingPage);
	}

	private void verifyBlogLandingPageElements(BlogLandingPage blogLandingPage, boolean isSingleAuthor) {
		if (isSingleAuthor) {
			assertTrue(blogLandingPage.isAboutThisAuthorSectionVisible(), "'About This Author' section should be visible");
			assertTrue(blogLandingPage.isAboutThisAuthorLabelVisible(), "'About This Author' headline should be visible");
			assertTrue(blogLandingPage.isAboutThisAuthorImageVisible(), "Author avatar should be visible in 'About This Author' section");
			assertTrue(blogLandingPage.isAboutThisAuthorInfoVisible(), "Author information should be visible");
			assertTrue(blogLandingPage.isReadMoreLinkVisibleInAboutThisAuthorSection(), "'read more' link should be visible");
			assertTrue(blogLandingPage.getReadMoreLinkHref().contains("/authors/"), "'read more' link should lead to author page");
		}

		assertTrue(blogLandingPage.isRelatedTopicsSectionVisible(), "'Related topics' section should be visible");
		assertTrue(blogLandingPage.isRelatedTopicsHeadlineVisible(), "'Related Topics' headline should be visible");
		int numberOfTags = blogLandingPage.getNumberOfTopicTags();
		assertTrue(numberOfTags >= 1 && numberOfTags <= 6, "At least one topic tag should be visible but not more then 6");

		assertTrue(blogLandingPage.isBrowseMorePersonalTakesLinkVisible(), "'Browse More Personal Takes' link should be visible");
		assertEquals(blogLandingPage.getBrowserMorePersonalTakesLinkHrefValue(), Settings.getDefaultUrl() + "/columns", "'Browser More Personal Takes' link should lead to blogs index page");

		int numberOfPostCards = blogLandingPage.getTotalNumberOfContentCards();
		if (numberOfPostCards >= 3) {
			assertTrue(blogLandingPage.isNewsletterWidgetInPositionNumber(4), "Newsletter widget should be placed after 3rd post card");
		} else {
			assertTrue(blogLandingPage.isNewsletterWidgetInPositionNumber(numberOfPostCards), "Newsletter widget should be in the last position");
		}
	}

	private void verifyBlogsLandingPageContent(BlogLandingPage blogLandingPage) {
		String category = blogLandingPage.getCategoryForPage().replace(" & ", "-").toLowerCase();
		String subCategory = blogLandingPage.getSubCategoryForPage().replace(" & ", "-").toLowerCase();
		verifyBreadcrumbs(blogLandingPage, category, subCategory);

		assertTrue(blogLandingPage.isBlogTitleVisible(), "Blog title should be visible");
		assertTrue(blogLandingPage.isBlogDescriptionVisible(), "Blog description should be visible");

		Logger.info("Verify blog articles cards");
		int numberOfCards = blogLandingPage.getTotalNumberOfContentCards();
		assertTrue(numberOfCards > 1, "At least one blog article card should be present");
		if (blogLandingPage.isPaginationBlockVisible()) {
			assertEquals(numberOfCards, 10, "10 blog article cards should be present");
			assertTrue(blogLandingPage.isNextPageArrowVisible(), "Next page navigation block should be visible");
			assertFalse(blogLandingPage.isPreviousPageArrowVisible(), "Previous page navigation block should not be visible");
			assertTrue(blogLandingPage.getPaginationData().startsWith("1"), "First page should be opened");
		}
		assertEquals(blogLandingPage.getNumberOfContentCardHeaders(), numberOfCards, "Each card should have headline");
		assertEquals(blogLandingPage.getNumberOfVisibleContentCardTypeIcons(), numberOfCards, "Each content card should have type icon");
		assertEquals(blogLandingPage.getNumberOfTimestamps(), numberOfCards, "Each content card should have timestamp");
		for (int card = 1; card <= numberOfCards; card++) {
			assertTrue(blogLandingPage.getContentCardHrefValue(card).startsWith("https://"), "Card URL should be secured");
		}

		Logger.info("Verify navigation");
		blogLandingPage.clickNextArrow();
		String paginationData = blogLandingPage.getPaginationData();
		assertTrue(paginationData.startsWith("2"), "Second page should be opened");
		assertTrue(Utils.getCurrentURL().endsWith("/page/2/"));
		assertTrue(blogLandingPage.isPreviousPageArrowVisible(), "Previous navigation block should be visible");
		if (Integer.valueOf(paginationData.split(" ")[2]) > 2) {
			assertTrue(blogLandingPage.isNextPageArrowVisible(), "Next page navigation block should be visible");
		}
		blogLandingPage.clickPreviousArrow();
		assertTrue(Utils.getCurrentURL().endsWith("/page/1/"), "First page should be opened");
		assertFalse(blogLandingPage.isPreviousPageArrowVisible(), "Previous page navigation block should not be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "BlogLandingTest", "C505405"})
	@TestRail(id = "C505405")
	public void verifyPromoBannerSectionOnBlogLandingPage() {
		BlogLandingPage blogLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_LANDING_MULTIPLE_AUTHORS, BlogLandingPage.class);

		verifyPromoBannerSection(blogLandingPage);
	}
}
