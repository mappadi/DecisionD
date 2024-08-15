package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.columns.BlogIndexPage;
import framework.Logger;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.utilities.StringUtils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * BlogIndexTest
 */
public class BlogIndexTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogIndexTest", "C312190"})
	@TestRail(id = "C312190")
	public void verifyBlogIndexPageElements() {
		BlogIndexPage blogIndexPage = SiteNavigatorEH.goToBlogIndexPage();
		assertTrue(blogIndexPage.onGlobalNavHeader().isGlobalNavHeaderVisible(), "Globalnav header should be visible");
		assertTrue(blogIndexPage.onZDFooter().isFooterVisible(), "Footer should be visible");
		assertTrue(blogIndexPage.isHeroSectionVisible(), "Hero section should be visible");
		int numberOfSections = blogIndexPage.getNumberOfSections();
		assertTrue(numberOfSections >= 1 && numberOfSections <= 5, "At least one section should be present on page, but not more than 5");
		assertTrue(blogIndexPage.isNewsletterWidgetVisible(), "Newsletter widget should be visible after first section");
		if (!Settings.isMobile()) {
			assertTrue(blogIndexPage.isTopAdVisible(), "Leader1 ad should be visible");
		}
		assertTrue(blogIndexPage.isAdDiv5Visible(), "AdDiv5 (box1) ad should be visible");
		assertTrue(blogIndexPage.isAdDiv7Visible(), "AdDiv7 (box2) ad should be visible");
		assertTrue(blogIndexPage.isAdDiv9Visible(), "AdDiv9 (boxextra) ad should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogIndexTest", "C312191"})
	@TestRail(id = "C312191")
	public void verifyBlogIndexPageHeroSection() {
		BlogIndexPage blogIndexPage = SiteNavigatorEH.goToBlogIndexPage();
		assertTrue(blogIndexPage.isHeroSectionHeadingVisible(), "Hero section heading should be visible");
		assertFalse(blogIndexPage.getHeroSectionHeadingText().isEmpty(), "Hero section heading should have some text");
		assertTrue(blogIndexPage.isHeroSectionIconVisible(), "Hero section icon should be visible");
		assertTrue(blogIndexPage.isHeroSectionDeckVisible(), "Hero section deck should be visible");
		assertFalse(blogIndexPage.getHeroSectionDeckText().isEmpty(), "Hero section deck should have some text");
		if (!Settings.isMobile()) {
			assertTrue(blogIndexPage.getHeroSectionYCoordinateValue() > blogIndexPage.getLeader1AdYCoordinateValue(), "Hero section should be placed below leader1 ad");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogIndexTest", "C312192"})
	@TestRail(id = "C312192")
	public void verifyBlogIndexPageSectionContent() {
		BlogIndexPage blogIndexPage = SiteNavigatorEH.goToBlogIndexPage();
		int numberOfSections = blogIndexPage.getNumberOfSections();
		assertTrue(numberOfSections >= 1 && numberOfSections <= 5, "At least one section should be present on page, but not more than 5");
		assertEquals(blogIndexPage.getNumberOfSectionDividers(), numberOfSections, "Every section should have green divider");
		assertEquals(blogIndexPage.getNumberOfSectionHeadings(), numberOfSections, "Every section should have heading (in h2 tag)");
		for (int sectionNumber = 1; sectionNumber <= numberOfSections; sectionNumber++) {
			assertEquals(blogIndexPage.getColorValueForSectionDivider(sectionNumber), "#96c900", "Section divider should be green");
			assertFalse(blogIndexPage.getSectionHeadingText(sectionNumber).isEmpty(), "Section heading should have some text");
			int numberOfFranchiseCards = blogIndexPage.getNumberOfFranchiseCardsInSection(sectionNumber);
			assertTrue(numberOfFranchiseCards >= 1 && numberOfFranchiseCards <= 20, "At least 1 franchise card should be present in section, but not more than 20");
		}
		assertTrue(blogIndexPage.isAdBlockPlacedAfterSecondFranchiseCard(1), "Ad block should be on 3rd position in first section");
		if (numberOfSections >= 2) {
			assertTrue(blogIndexPage.isAdBlockPlacedAfterSecondFranchiseCard(2), "Ad block should be on 3rd position in second section");
		}
		if (numberOfSections >= 3) {
			assertTrue(blogIndexPage.isAdBlockPlacedAfterSecondFranchiseCard(3), "Ad block should be on 3rd position in third section");
		}
		assertTrue(blogIndexPage.isNewsletterWidgetVisible(), "Newsletter widget should be visible after first section");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogIndexTest", "C312193"})
	@TestRail(id = "C312193")
	public void verifyBlogIndexPageSectionFranchiseCards() {
		BlogIndexPage blogIndexPage = SiteNavigatorEH.goToBlogIndexPage();
		int numberOfSections = blogIndexPage.getNumberOfSections();
		assertTrue(numberOfSections >= 1 && numberOfSections <= 5, "At least one section should be present on page, but not more than 5");
		for (int sectionNumber = 1; sectionNumber <= numberOfSections; sectionNumber++) {
			int numberOfCards = blogIndexPage.getNumberOfFranchiseCardsInSection(sectionNumber);
			assertTrue(numberOfCards >= 1 && numberOfCards <= 20, "At least 1 franchise card should be present in section, but not more than 20");
			Logger.info("Number of cards in section #" + sectionNumber + " is - " + numberOfCards);
			for (int cardNumber = 1; cardNumber <= numberOfCards; cardNumber++) {
				assertTrue(blogIndexPage.isFranchiseCardTitleVisible(sectionNumber, cardNumber), "Franchise card title should be visible");
				String titleUrl = blogIndexPage.getFranchiseCardTitleHrefValue(sectionNumber, cardNumber);
				assertTrue(titleUrl.startsWith("http"), "Franchise card title should be hyperlink");
				assertFalse(blogIndexPage.getFranchiseCardTitleText(sectionNumber, cardNumber).isEmpty(), "Franchise card should have text in title");

				assertTrue(blogIndexPage.isFranchiseCardAuthorNameVisible(sectionNumber, cardNumber), "Author name should be visible on franchise card");
				String authorUrl = blogIndexPage.getFranchiseCardAuthorNameHrefValue(sectionNumber, cardNumber);
				assertTrue(authorUrl.startsWith("http"), "Author name url should start from 'https://'");
				assertTrue(authorUrl.contains("/author"), "Author name url should be linked to author page"); //authorS - is valid?

				assertTrue(blogIndexPage.isFranchiseCardImageVisible(sectionNumber, cardNumber), "Blog image should be visible on franchise card");
				String imageUrl = blogIndexPage.getFranchiseCardImageHrefValue(sectionNumber, cardNumber);
				assertTrue(imageUrl.startsWith("http"), "Franchise card image url should start from 'https://'");
			}
			int numberOfAvatarImages = blogIndexPage.getNumberOfAuthorAvatars(sectionNumber);
			for (int cardWithAvatar = 1; cardWithAvatar <= numberOfAvatarImages; cardWithAvatar++) {
				assertTrue(blogIndexPage.isAvatarImageVisible(sectionNumber, cardWithAvatar), "Image should be visible");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogIndexTest", "C312194"})
	@TestRail(id = "C312194")
	public void verifyBlogIndexPageNewsletterWidgetWithValidData() {
		BlogIndexPage blogIndexPage = SiteNavigatorEH.goToBlogIndexPage();
		assertTrue(blogIndexPage.isNewsletterWidgetVisible(), "Newsletter widget should be present after first section");
		verifyNewsletterWidgetElements(blogIndexPage);
		blogIndexPage.enterEmail(StringUtils.generateRandomEmail());
		blogIndexPage.clickNewsletterSubmitButton();
		blogIndexPage.waitUntilSuccessMessageAppears();
		assertTrue(blogIndexPage.isNewsletterWidgetSuccessMessageVisible(), "'Thanks for signing up for our newsletter! You should see it in your inbox very soon.' should be appear");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "BlogIndexTest", "C312195"})
	@TestRail(id = "C312195")
	public void verifyBlogIndexPageNewsletterWidgetWithInvalidData() {
		BlogIndexPage blogIndexPage = SiteNavigatorEH.goToBlogIndexPage();
		assertTrue(blogIndexPage.isNewsletterWidgetVisible(), "Newsletter widget should be present after first section");
		verifyNewsletterWidgetElements(blogIndexPage);
		blogIndexPage.enterEmail("");
		blogIndexPage.clickNewsletterSubmitButton();
		assertTrue(blogIndexPage.isNewsletterWidgetWarningMessageVisible(), "Warning message should appear");
		blogIndexPage.waitUntilWarningMessageDisappears();
		blogIndexPage.enterEmail(StringUtils.generateRandomStrAlphabetic(8));
		blogIndexPage.clickNewsletterSubmitButton();
		assertTrue(blogIndexPage.isNewsletterWidgetWarningMessageVisible(), "Warning message should appear");
	}

	private void verifyNewsletterWidgetElements(BlogIndexPage blogIndexPage) {
		assertTrue(blogIndexPage.isNewsletterWidgetTitleVisible(), "'Sign up for our Healthy Living newsletter!' title should be visible");
		assertTrue(blogIndexPage.isNewsLetterEmailBoxVisible(), "'Enter your email' input should be visible");
		assertTrue(blogIndexPage.isNewsletterWidgetPrivacyLinkVisible(), "'your privacy' should be visible");
		assertTrue(blogIndexPage.isNewsLetterWidgetPrivacyLinkValid(), "'your privacy' should be hyperlink");
		assertTrue(blogIndexPage.isNewsLetterSubmitButtonVisible(), "'Subscribe' button should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "BlogIndexTest", "C505403"})
	@TestRail(id = "C505403")
	public void verifyPromoBannerSectionOnBlogIndexPage() {
		BlogIndexPage blogIndexPage = SiteNavigatorEH.goToBlogIndexPage();

		verifyPromoBannerSection(blogIndexPage);
	}
}
