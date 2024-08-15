package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.conditions.ConditionCenterLandingPage;
import framework.Logger;
import framework.Settings;
import framework.platform.CookieName;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Tests for Condition Center (CCR)
 */
public class ConditionCenterTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C194940"})
	@TestRail(id = "C194940")
	public void verifyCCRLandingPageElements() {
		ConditionCenterLandingPage ccrLandingPage = SiteNavigatorEH.goToCCRLandingPageEH(TemplatesEH.LANDING);
		verifyHeroImageGuideButton(ccrLandingPage);
		verifyContentCardElements(ccrLandingPage, false);
		verifyLandingPagePagination(ccrLandingPage);
		verifyConditionTopicElements(ccrLandingPage);
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C194953"})
	@TestRail(id = "C194953")
	public void verifyNewsletterPositive() {
		Logger.info("Verify Newsletter subscription with positive test data");
		ConditionCenterLandingPage ccrLandingPage = SiteNavigatorEH.goToCCRLandingPageEH(TemplatesEH.LANDING);
		verifyNewsletterWidgetElements(ccrLandingPage);
		ccrLandingPage.enterEmailAndSubmit(StringUtils.generateRandomEmail());
		assertTrue(ccrLandingPage.isNewsletterWidgetSuccessMessageVisible(), "Newsletter subscription confirmation did not display");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C194954"})
	@TestRail(id = "C194954")
	public void verifyNewsletterNegative() {
		Logger.info("Verify Newsletter subscription with negative test data");
		ConditionCenterLandingPage ccrLandingPage = SiteNavigatorEH.goToCCRLandingPageEH(TemplatesEH.LANDING);
		verifyNewsletterWidgetElements(ccrLandingPage);
		ccrLandingPage.enterEmailAndSubmit("");
		assertTrue(ccrLandingPage.isNewsletterWarningMessageVisible(), "Warning message not available");
		ccrLandingPage.waitUntilWarningMessageDisappear();
		ccrLandingPage.enterEmailAndSubmit(StringUtils.generateRandomStrAlphabetic(10));
		assertTrue(ccrLandingPage.isNewsletterWarningMessageVisible(), "Warning message not available");
	}

	private void verifyNewsletterWidgetElements(ConditionCenterLandingPage ccrLandingPage) {
		assertTrue(ccrLandingPage.isNewsletterWidgetVisible(), "Newsletter widget should be visible");
		assertTrue(ccrLandingPage.isNewsLetterEmailBoxVisible(), "Newsletter Email input is not visible");
		assertTrue(ccrLandingPage.isNewsLetterSubmitButtonVisible(), "Newsletter Subscribe button is not visible");
		assertTrue(ccrLandingPage.isNewsletterWidgetPrivacyLinkVisible(), "We respect your privacy text is not visible");
		assertTrue(ccrLandingPage.isNewsLetterWidgetPrivacyLinkValid(), "Newsletter privacy link is not valid URL");
	}

	@Test(groups = {"EverydayHealthMobile", "C216765"})
	@TestRail(id = "C216765")
	public void verifyAdsPositionsMobile() {
		ConditionCenterLandingPage conditionCenterLandingPage = SiteNavigatorEH.goToCCRLandingPageEH(TemplatesEH.LANDING);

		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event5,event19"), "Events are incorrect. Custom programming content cards are not present on page.");

		assertTrue(conditionCenterLandingPage.isContentCardNumberVisible(3), "3rd content card should be visible");
		assertTrue(conditionCenterLandingPage.getContentCardBlockClassAttributeValue(3).contains("card-recommendation"), "Custom programming card should be present in 3rd card slot");
		assertTrue(conditionCenterLandingPage.isContentCardNumberVisible(5), "5th content card should be visible");
		assertTrue(conditionCenterLandingPage.getContentCardBlockClassAttributeValue(5).contains("ad-content"), "Ad block should be present after 3rd card and newsletter widget");
		assertTrue(conditionCenterLandingPage.isContentCardNumberVisible(8), "8th content card should be visible");
		assertTrue(conditionCenterLandingPage.getContentCardBlockClassAttributeValue(8).contains("card-recommendation"), "Custom programming card should be present in 6th card slot");
		assertTrue(conditionCenterLandingPage.isContentCardNumberVisible(9), "9th content card should be visible");
		assertTrue(conditionCenterLandingPage.getContentCardBlockClassAttributeValue(9).contains("ad-content"), "Ad block should be present after 6th card");
		assertTrue(conditionCenterLandingPage.isContentCardNumberVisible(12), "12th content card should be visible");
		assertTrue(conditionCenterLandingPage.getContentCardBlockClassAttributeValue(12).contains("card-recommendation"), "Custom programming card should be present in 9th card slot");
		assertTrue(conditionCenterLandingPage.isContentCardNumberVisible(13), "13th content card should be visible");
		assertTrue(conditionCenterLandingPage.getContentCardBlockClassAttributeValue(13).contains("ad-content"), "Ad block should be present after 9th card");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CategoryPageTest", "C344818"})
	@TestRail(id = "C344818")
	public void verifyCategoryAllArticlesTitleSection() {
		ConditionCenterLandingPage categoryAllArticlesPage = SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_ALL_ARTICLES, ConditionCenterLandingPage.class);

		String category = categoryAllArticlesPage.getCategoryForPage();
		String subCategory = categoryAllArticlesPage.getSubCategoryForPage();
		verifyBreadcrumbs(categoryAllArticlesPage, category, subCategory);

		assertTrue(categoryAllArticlesPage.isHeroTitleVisible(), "Page headline should be visible");
		assertEquals(categoryAllArticlesPage.getHeadlineText(), "All Cancer Articles", "Text should be 'All Cancer Articles'");
		if (!Settings.isMobile()) {
			assertTrue(categoryAllArticlesPage.isDescriptionVisible(), "Description should be visible");
		}
		assertTrue(categoryAllArticlesPage.isAllArticlesWidgetVisible(), "'All Articles' widget should be visible");
		assertTrue(categoryAllArticlesPage.isAllArticlesTypesTabVisible(), "'Types' tab should be visible on 'All Articles' widget");
		assertTrue(categoryAllArticlesPage.isAllArticlesLinkVisible(), "'All Articles' tab should be visible");
		String typesLink = categoryAllArticlesPage.getTypesLink();
		assertTrue(typesLink.contains("/cancer/"), "'Types' link should lead to category page");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "CategoryPageTest", "C344819"})
	@TestRail(id = "C344819")
	public void verifyCategoryAllArticlesCards() {
		ConditionCenterLandingPage categoryAllArticlesPage = SiteNavigatorEH.goToPage(TemplatesEH.CATEGORY_ALL_ARTICLES, ConditionCenterLandingPage.class);

		verifyContentCardElements(categoryAllArticlesPage, true);
		verifyLandingPagePagination(categoryAllArticlesPage);
	}

	private void verifyHeroImageGuideButton(ConditionCenterLandingPage ccrLandingPage) {
		Logger.info("Verify the Hero image is present on Condition Center (CCR) landing page");
		assertTrue(ccrLandingPage.isHeroImageVisible(), "Hero image is not visible");
		assertEquals(ccrLandingPage.getHeroImageHeight(), 280, "Hero image height should be 280px");
		assertTrue(ccrLandingPage.isHeroImageGuideButtonContainsGuideHref(TemplatesEH.LANDING), "Guides page was not loaded");
		assertTrue(ccrLandingPage.isGuideButtonVisible(), "Guide button not visible");
		assertTrue(ccrLandingPage.isHeroTitleVisible(), "Hero Title not visible");
	}

	private void verifyContentCardElements(ConditionCenterLandingPage ccrLandingPage, boolean isAllArticlesPage) {
		int numberOfContentCards = ccrLandingPage.getTotalNumberOfContentCards();
		if (Settings.isMobile()) {
			assertEquals(numberOfContentCards, 10, "10 content cards should be present on page (mobile device)");
		} else {
			assertEquals(numberOfContentCards, 20, "20 content cards should be present on page");
		}

		for (int contentCardNumber = 1; contentCardNumber <= numberOfContentCards; contentCardNumber++) {
			Logger.info("Verifying the " + contentCardNumber + " content card description");
			if ((contentCardNumber % 2) == 0) {
				ccrLandingPage.scrollToContentCard(contentCardNumber);
			}

			assertTrue(ccrLandingPage.getContentCardHrefValue(contentCardNumber).startsWith("http"), "Incorrect 'href' value");
			assertTrue(ccrLandingPage.isContentCardContainHeader(contentCardNumber), "Every content card should have header");
			if (!Settings.isMobile() && !ccrLandingPage.isContentCardContainDesc(contentCardNumber)) {
				Logger.info("Description of content card #" + contentCardNumber + " is not available");
			}
		}
		int numberOfContentCardWithImage = ccrLandingPage.getNumberOfContentCardWithImage();
		for (int card = 1; card <= numberOfContentCardWithImage; card++) {
			assertTrue(ccrLandingPage.getContentCardImageWidth(card) >= 300, "Image width is less than 300");
		}
		if (isAllArticlesPage) {
			assertTrue(ccrLandingPage.isNewsletterWidgetPlacedAfterCard(3));
			assertEquals(ccrLandingPage.getNumberOfContentCardBylines(), numberOfContentCards, "Every content card should have byline");
		}
		if (numberOfContentCards != ccrLandingPage.getNumberOfVisibleContentCardTypeIcons()) {
			Logger.info("Not every content card has type icon");
		} else {
			Logger.info("Each content card has type icon");
		}
	}

	private void verifyConditionTopicElements(ConditionCenterLandingPage ccrLandingPage) {
		Logger.info("Verify Condition topics on landing page");
		assertTrue(ccrLandingPage.isConditionTopicLabelVisible(), "Condition topic label is not visible");
		int tagsOnPageLoad = ccrLandingPage.getTopicTagsCount();
		assertTrue(tagsOnPageLoad >= 1, "At least one topic tag should be visible");
		assertTrue(ccrLandingPage.isConditionTopicMoreButtonVisible(), "Condition Topic More button was not visible");
		ccrLandingPage.clickConditionTopicMoreButton();
		int contentCardCount = ccrLandingPage.getTopicTagsCount();
		assertTrue(contentCardCount > tagsOnPageLoad, "More tags should appear");
		for (int conditionTopicNumber = 1; conditionTopicNumber < contentCardCount; conditionTopicNumber++) {
			assertFalse(ccrLandingPage.getTagHrefAttributeValue(conditionTopicNumber).isEmpty(), "Condition topic tags should have valid 'href' attribute");
		}
	}

	private void verifyLandingPagePagination(ConditionCenterLandingPage ccrLandingPage) {
		Logger.info("Verify Content card description in landing page");
		assertTrue(ccrLandingPage.isPaginationBlockVisible(), "Pagination block should be visible");
		assertEquals(ccrLandingPage.getPaginationInfo().split(" ")[0], "1", "User should be on the first page");
		assertFalse(ccrLandingPage.isPaginationPreviousLinkVisible(), "'Previous' link should not be visible");
		assertTrue(ccrLandingPage.isPaginationNextLinkVisible(), "'Next' link should be visible");
		ccrLandingPage.clickPaginationNextLink();
		assertEquals(ccrLandingPage.getPaginationInfo().split(" ")[0], "2", "User should be on the first page");
		assertTrue(ccrLandingPage.isPaginationPreviousLinkVisible(), "'Previous' link should not be visible");
		assertTrue(ccrLandingPage.isPaginationNextLinkVisible(), "'Next' link should be visible");
		assertTrue(Utils.getCurrentURL().endsWith("page=2"), "URL should be appended with page number");
		ccrLandingPage.clickPaginationPreviousLink();
		assertEquals(ccrLandingPage.getPaginationInfo().split(" ")[0], "1", "User should be on the first page");
		assertFalse(ccrLandingPage.isPaginationPreviousLinkVisible(), "'Previous' link should not be visible");
		assertTrue(ccrLandingPage.isPaginationNextLinkVisible(), "'Next' link should be visible");
		assertFalse(Utils.getCurrentURL().contains("page"), "Pagination info should not be present in URL");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ConditionCenter", "C505424"})
	@TestRail(id = "C505424")
	public void verifyPromoBannerSectiionOnLandingPage() {
		ConditionCenterLandingPage ccrLandingPage = SiteNavigatorEH.goToCCRLandingPageEH(TemplatesEH.LANDING);

		verifyPromoBannerSection(ccrLandingPage);
	}
}
