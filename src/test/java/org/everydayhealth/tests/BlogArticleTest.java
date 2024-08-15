package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import everydayhealth.pages.columns.BlogArticlePage;
import framework.Settings;
import framework.platform.SiteNavigatorBase;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;


/**
 * BlogArticleTest
 */
public class BlogArticleTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogArticleTest", "C326692"})
	@TestRail(id = "C326692")
	public void verifyBlogArticlePageElements() {
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		assertTrue(blogArticlePage.isNewsletterModuleVisible(), "Newsletter module should be visible");
		assertTrue(blogArticlePage.isAdDiv5Visible() || blogArticlePage.isAdDiv7Visible(), "adDiv5 or adDiv7 should be visible depending on replace timeout");
		assertTrue(blogArticlePage.isDontMissThisSectionVisible(), "'In this series' section should be visible");
		assertTrue(blogArticlePage.isTopGreenBorderVisibleAboveDontMissThis(), "Green line should be on top of 'In this series' section");
		assertEquals(blogArticlePage.getNumberOfDontMissArticles(), 2, "2 articles should be present in 'In this series' section");

		assertTrue(blogArticlePage.isGoogleMatchedSectionVisible(), "Google Matched should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "BlogArticleTest", "C326694"})
	@TestRail(id = "C326694")
	public void verifySkybox() {
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		blogArticlePage.scrollDownThePage();
		assertTrue(blogArticlePage.isBackToTopVisible(), "'Top' button should be visible");
		blogArticlePage.clickBackToTopButton();
		assertFalse(blogArticlePage.isRecommendedForYouSectionVisible(), "Skybox should not be visible");
		assertFalse(blogArticlePage.isBackToTopVisible(), "'Top' button should not be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "BlogArticleTest", "C326695"})
	@TestRail(id = "C326695")
	public void verifyReadNextFlyout() {
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		assertFalse(blogArticlePage.isFlyoutVisible(), "Flyout should not be visible on page load");
		blogArticlePage.scrollDownThePage();
		assertTrue(blogArticlePage.isFlyoutVisible(), "Flyout should be visible after scroll down");
		assertTrue(blogArticlePage.isFlyoutArrowVisible(), "Flyout arrow '>' should be visible");
		blogArticlePage.flyoutMouseHover();
		assertTrue(blogArticlePage.isFlyoutReadNextVisible(), "'Read next' label should be visible");
		assertTrue(blogArticlePage.isFlyoutArticleTitleVisible(), "Article title should be visible in flyout on mouse hover");
		assertTrue(blogArticlePage.isFlyoutArticleImageVisible(), "Article image should be visible in flyout on mouse hover");
		assertTrue(blogArticlePage.getFlyoutLinkHrefAttribute().startsWith("https://"), "Article flyout should be valid hyperlink");
		String beforeClickURL = Utils.getCurrentURL();
		blogArticlePage.clickOnFlyout();
		assertNotEquals(Utils.getCurrentURL(), beforeClickURL, "Another page should be opened");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogArticleTest", "C326696"})
	@TestRail(id = "C326696")
	public void verifyNewsletterModuleFunctionality() {
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		verifyNewsletterModuleFunctionality(blogArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "BlogArticleTest", "C326700"})
	@TestRail(id = "C326700")
	public void verifySaveButtonFunctionalityForNonLoggedInUser() {
		BlogArticlePage blogArticlePage = SiteNavigatorBase.openPage(TemplatesEH.BLOG_ARTICLE.getTemplateURL(), BlogArticlePage.class);

		verifySaveButtonFunctionalityForNonLoggedInUser(blogArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "BlogArticleTest", "C326708"})
	@TestRail(id = "C326708")
	public void verifySaveButtonFunctionalityForLoggedInUser() {
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		verifySaveButtonFunctionalityForLoggedInUser(blogArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogArticleTest", "C326701"})
	@TestRail(id = "C326701")
	public void verifyBlogArticlePageContent() {
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		assertTrue(blogArticlePage.isPersonalTakesSectionVisible(), "'Personal Takes' section should be visible");
		assertTrue(blogArticlePage.isPersonalTakesIconVisible(), "'Personal Takes' icon should be visible");
		assertEquals(blogArticlePage.getPersonalTakesHrefAttributeValue(), Settings.getDefaultUrl() + "/columns", "'Personal Takes' section should lead to blog index page");

		String category = blogArticlePage.getCategoryForPage().replace(" & ", "-").toLowerCase();
		String subCategory = blogArticlePage.getSubCategoryForPage().replace(" & ", "-").toLowerCase();
		verifyBreadcrumbs(blogArticlePage, category, subCategory);

		assertTrue(blogArticlePage.isTitleVisible(), "Article page title should be visible");
		assertTrue(blogArticlePage.isArticleAuthorImageVisible(), "Article author image should be visible");
		assertTrue(blogArticlePage.isArticleAuthorNameVisible(), "Article author name should be visible");
		assertTrue(blogArticlePage.getArticleAuthorNameHrefAttributeValue().contains("/authors/"), "Author name hyperlink should lead to authors page");

		assertTrue(blogArticlePage.isArticleBodyVisible(), "Article body should be visible");
		assertTrue(blogArticlePage.isLastUpdatedDateVisible(), "Last updated date should be visible");
//		assertTrue(blogArticlePage.getNumberOfTopicTags() > 0, "At least one topic tag should be present");  will be uncommented when clarify if topic tags should be present
		assertTrue(blogArticlePage.isArticleDisclaimerVisible(), "Disclaimer should be visible in the end of article");
		assertTrue(blogArticlePage.isSeeMoreLinkVisibleInDisclaimer(), "'See More' link should be visible in disclaimer");
		assertEquals(blogArticlePage.getShortenedDisclaimerText(), "Important: The views and opinions expressed in this article are those of the author and not Everyday Health. See More", "Disclaimer should contain this text");
		blogArticlePage.clickSeeMoreLink();
		assertTrue(blogArticlePage.isExpandedDisclaimerVisible(), "Expanded version of disclaimer should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "BlogArticleTest", "C326703"})
	@TestRail(id = "C326703")
	public void verifySocialShareBarElementsAndOmniture() {
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);
		SocialBarEH socialBarEH = blogArticlePage.onSocialBar();

		assertTrue(socialBarEH.isFacebookShareButtonVisible(), "'Facebook' share button should be visible");
		assertTrue(socialBarEH.isTwitterShareButtonVisible(), "'Twitter' share button should be visible");
		assertTrue(socialBarEH.isPinterestShareButtonVisible(), "'Pinteres' share button should be visible");
		assertTrue(socialBarEH.isEmailShareButtonVisible(), "'Email' share button should be visible");
		assertTrue(socialBarEH.isSaveLinkVisible(), "'Save' link should be visible");

		socialBarEH.clickOnFacebookShareButton();
		socialBarEH.verifyFacebookPopUpContainsFacebook();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event93"), "Incorrect event fired");
		verifyOmnitureEvents();

		socialBarEH.clickOnTwitterShareButton();
		socialBarEH.verifyTwitterPopUpContainsTwitter();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event94"), "Incorrect event fired");
		verifyOmnitureEvents();

		socialBarEH.clickOnPinterestShareButton();
		socialBarEH.verifyPinterestPopUpContainsPinterest();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event96"), "Incorrect event fired");
		verifyOmnitureEvents();

		ShareViaEmailPopUp shareViaEmailPopUp = socialBarEH.clickEmailShareButton();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event92"), "Incorrect event fired");
		verifyOmnitureEvents();
		shareViaEmailPopUp.closePopUp();

		assertTrue(socialBarEH.isPrintShareButtonVisible(), "'Print' share button should be visible");
		socialBarEH.clickPrintShareButton();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event98"), "Incorrect event fired");
		verifyOmnitureEvents();
	}

	private void verifyOmnitureEvents() {
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/skinhairnails/skinconditions"), "Incorrect event fired");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "lblg"), "Incorrect event fired");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/skinhairnails/skinconditions"), "Incorrect event fired");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "lblg|/skinhairnails/skinconditions"), "Incorrect event fired");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", Utils.getCurrentURL().split(".com")[1].replace("?isautomation=true", "")), "Incorrect event fired");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "Incorrect event fired");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "blogs article"), "Incorrect event fired");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "skin &amp; beauty"), "Incorrect event fired");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "skin &amp; beauty"), "Incorrect event fired");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "symptoms,treatment,diagnosis"), "Incorrect event fired");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "Incorrect event fired");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "BlogArticleTest", "C376036"})
	@TestRail(id = "C376036")
	public void verifyGoogleMatchContentsOnBlogsArticlePage() {
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		assertEquals(blogArticlePage.getGMcontentCardAdSlot(), "8510871142", "Google match content section ad slot should be 8510871142");
		verifyGoogleMatchedContent(blogArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "BlogArticleTest", "C384194"})
	@TestRail(id = "C384194")
	public void verifyLatestArticlesModuleOnBlogsArticlePage() {
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		verifyLatestArticlesModule(blogArticlePage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "BlogArticleTest", "C505402"})
	@TestRail(id = "C505402")
	public void verifyPromoBannerSectionOnBlogArticlePage() {
		BlogArticlePage blogArticlePage = SiteNavigatorEH.goToPage(TemplatesEH.BLOG_ARTICLE, BlogArticlePage.class);

		verifyPromoBannerSection(blogArticlePage);
	}
}