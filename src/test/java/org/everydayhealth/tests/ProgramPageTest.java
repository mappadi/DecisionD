package org.everydayhealth.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import com.testrail.framework.platform.annotations.TestRail;

import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import everydayhealth.pages.program.ProgramPage;
import framework.Logger;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;

import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

/**
 * ProgramPageTest
 */
public class ProgramPageTest {

	@Test(groups = { "EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ProgramPage", "C235238" })
	@TestRail(id = "C235238")
	public void verifyProgramPageContent() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);
		Logger.info("Verify program page content on each subnavigation page");
		int subNavigationTabCount = programPage.getSubNavigationTabCount();
		for(int subnavigationNumber = 1; subnavigationNumber <= subNavigationTabCount; subnavigationNumber++) {
			Logger.info("Verify page content on subnavigation "+subnavigationNumber);
			if(subnavigationNumber != 1) {
				programPage.clickOnSubNavigationItemNumber(subnavigationNumber);
			}
			verifyProgramPageContent(programPage);
		}
	}

	@Test(groups = { "EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ProgramPage", "C238538" })
	@TestRail(id = "C238538")
	public void verifyProgramPageSubnavigationPage1() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);
		int subnavigationNumber = 1;
		verifyRecentStories(programPage);
		verifyRelatedList(programPage);
		verifyNextSlideNavigation(programPage, subnavigationNumber);
		verifyPreviousSlideNavigation(programPage, subnavigationNumber);
	}

	@Test(groups = { "EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ProgramPage", "C238539" })
	@TestRail(id = "C238539")
	public void verifyProgramPageSubnavigationPage2() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);
		int subnavigationNumber = 2;
		programPage.clickOnSubNavigationItemNumber(subnavigationNumber);
		verifyRecentStories(programPage);
		verifyRelatedList(programPage);
		verifyNextSlideNavigation(programPage, subnavigationNumber);
		verifyPreviousSlideNavigation(programPage, subnavigationNumber);
	}

	@Test(groups = { "EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ProgramPage", "C238540" })
	@TestRail(id = "C238540")
	public void verifyProgramPageSubnavigationPage3() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);
		int subnavigationNumber = 3;
		programPage.clickOnSubNavigationItemNumber(subnavigationNumber);
		verifyRecentStories(programPage);
		verifyRelatedList(programPage);
		verifyNextSlideNavigation(programPage, subnavigationNumber);
		verifyPreviousSlideNavigation(programPage, subnavigationNumber);
	}

	@Test(groups = { "EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ProgramPage", "C238541" })
	@TestRail(id = "C238541")
	public void verifyProgramPageSubnavigationPage4() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);
		int subnavigationNumber = 4;
		programPage.clickOnSubNavigationItemNumber(subnavigationNumber);
		verifyRecentStories(programPage);
		verifyRelatedList(programPage);
		verifyNextSlideNavigation(programPage, subnavigationNumber);
		verifyPreviousSlideNavigation(programPage, subnavigationNumber);
	}

	@Test(groups = { "EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ProgramPage", "C238542" })
	@TestRail(id = "C238542")
	public void verifyProgramPageSubnavigationPage5() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);
		int subnavigationNumber = 5;
		programPage.clickOnSubNavigationItemNumber(subnavigationNumber);
		verifyRecentStories(programPage);
		verifyRelatedList(programPage);
		verifyNextSlideNavigation(programPage, subnavigationNumber);
		verifyPreviousSlideNavigation(programPage, subnavigationNumber);
	}

	@Test(groups = { "EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ProgramPage", "C238543" })
	@TestRail(id = "C238543")
	public void verifyProgramPageSubnavigationPage6() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);
		int subnavigationNumber = 6;
		programPage.clickOnSubNavigationItemNumber(subnavigationNumber);
		verifyRecentStories(programPage);
		verifyRelatedList(programPage);
		verifyNextSlideNavigation(programPage, subnavigationNumber);
		verifyPreviousSlideNavigation(programPage, subnavigationNumber);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ProgramPage", "C235221"})
	@TestRail(id = "C235221")
	public void verifyNewsletterWidgetPositive() {
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);
		assertTrue(programPage.isNewsletterModuleVisible(), "Newsletter module is not visible");
		assertTrue(programPage.isNewsletterHeadingVisible(), "Newsletter heading is not visible");
		assertTrue(programPage.isNewsletterDescriptionVisible(), "Newsletter description is not visible");
		if(Settings.isDesktop()) {
			assertTrue(programPage.isNewsletterImageVisible(), "Newsletter image is not visible");
		}
		assertTrue(programPage.isNewsLetterEmailBoxVisible(), "Newsletter email box is not visible");
		assertTrue(programPage.isNewsLetterSubmitButtonVisible(), "Newsletter Submit button is not visible");
		assertTrue(programPage.isNewsletterModulePrivacyLinkVisible(), "Newsletter Privacy link  is not visible");
		assertTrue(programPage.isNewsLetterModulePrivacyLinkValid(), "Newsletter Privacy link is not clickable");
		programPage.enterEmailAndSubmit(StringUtils.generateRandomEmail());
		assertTrue(programPage.verifyNewsletterModuleSuccessMessage(), "Subscription confirmation message not visible");
		verifyProgramPageSocialShareOmnitureEvents();
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "ProgramPage", "C235222"})
	@TestRail(id = "C235222")
	public void verifyNewsletterWidgetNegative() {
		Logger.info("Newsletter widget Negative test");
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);
		programPage.enterEmailAndSubmit("");
		assertTrue(programPage.verifyNewsletterWarningMessageText(), "Subscription confirmation message not visible");
		programPage.waitUntilWarningMessageDisappear();
		programPage.enterEmailAndSubmit(StringUtils.generateRandomStrAlphabetic(10));
		assertTrue(programPage.verifyNewsletterWarningMessageText(), "Subscription confirmation message not visible");
	}
	
	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "ProgramPage", "C235183"})
	@TestRail(id = "C235183")
	public void verifySocialShareBarOmniture() {
		Logger.info("Verify Social bar Omniture events");
		ProgramPage programPage = SiteNavigatorEH.goToPage(TemplatesEH.PROGRAM, ProgramPage.class);
		SocialBarEH socialBar = programPage.onSocialBar();

		if (Settings.isDesktop()) {
			Logger.info("Verify Social bar Omniture events on facebook popup");
			socialBar.clickOnFacebookShareButton();
			socialBar.verifyFacebookPopUpContainsFacebook();
			assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event93"), "events are incorrect");
			verifyProgramPageSocialShareOmnitureEvents();

			Logger.info("Verify Social bar Omniture events on twitter popup");
			socialBar.clickOnTwitterShareButton();
			socialBar.verifyTwitterPopUpContainsTwitter();
			assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event94"), "events are incorrect");
			verifyProgramPageSocialShareOmnitureEvents();

			Logger.info("Verify Social bar Omniture events on pinterest popup");
			socialBar.clickOnPinterestShareButton();
			socialBar.verifyPinterestPopUpContainsPinterest();
			assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event96"), "events are incorrect");
			verifyProgramPageSocialShareOmnitureEvents();
		}

		Logger.info("Verify Social bar Omniture events on email popup");
		ShareViaEmailPopUp shareViaEmailPopUp = socialBar.clickEmailShareButton();
		assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event92"), "events are incorrect");
		verifyProgramPageSocialShareOmnitureEvents();
		shareViaEmailPopUp.closePopUp();
	}
	
	private void verifyProgramPageSocialShareOmnitureEvents() {
		Logger.info("Verifying social share bar omniture events");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/endocrinehormones/diabetestype2"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "pgr"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/endocrinehormones/diabetestype2"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "pgr|/endocrinehormones/diabetestype2"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "pgr|/endocrinehormones/diabetestype2|281947|Diabetes Step"), "eVar8 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/type-2-diabetes/living-with/step-by-step/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "program"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "diabetes"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "type 2 diabetes"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "risk factors,treatment"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "diagnosis"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
	}
	
	private void verifyNextSlideNavigation(ProgramPage programPage, int subnavigationNumber) {
		Logger.info("Verify next slide arrow functionality in secondary sub navigation");
		int slideCount = programPage.getSecondarySubNavigationSlideCount();
		String firstSlideHeading;
		if(subnavigationNumber == 1) {
			firstSlideHeading = programPage.getNewsletterHeadingText();
		} else {
			firstSlideHeading = programPage.getSlideHeadingText();
		}
		int slideNumber = 1;
		do {
			if(!(subnavigationNumber == 1 && slideNumber == 1)) {
				assertTrue(programPage.verifySlideNumberVisible(slideNumber), "Slide number "+ slideNumber+" on subnavigation number "+subnavigationNumber+" is not visible");
				assertTrue(programPage.isSlideHeadingVisible(), "Slide heading in slide number "+ slideNumber+" on subnavigation number "+subnavigationNumber+" is not visible");
				if(subnavigationNumber == 1) {
					assertTrue(programPage.isSlideHeadingLinkValid(), "Slide heading in slide number "+ slideNumber+" on subnavigation number "+subnavigationNumber+" is not clickable");
				}
				assertTrue(programPage.isSlideTextVisible(), "Slide text in slide number "+ slideNumber+" on subnavigation number "+subnavigationNumber+" is not visible");
				if(subnavigationNumber == 3 && Settings.isDesktop()) {
					assertTrue(programPage.isSlideImageVisible(), "Slide image in slide number "+ slideNumber+" on subnavigation number "+subnavigationNumber+" is not visible");
				}
			}
			if(slideNumber != slideCount) {
				programPage.clickNextSlideArrow();
			}
			slideNumber++;
		} while(slideNumber <= slideCount);
		String lastSlideHeading = programPage.getSlideHeadingText();
		assertNotEquals(firstSlideHeading, lastSlideHeading, "Slide heading text should not be same");
		programPage.clickNextSlideArrow();
		Utils.waitFor(1000); //needed for slider to return to first slide
		if(subnavigationNumber == 1) {
			assertEquals(programPage.getNewsletterHeadingText(), firstSlideHeading, "Slide heading text should be same");
		} else {
			assertEquals(programPage.getSlideHeadingText(), firstSlideHeading, "Slide heading text should be same");
		}

		programPage.clickPreviousSlideArrow();
		Utils.waitFor(1000); //needed for slider to return to last slide
		assertEquals(lastSlideHeading, programPage.getSlideHeadingText(), "Slide heading text should be same");
	}

	private void verifyPreviousSlideNavigation(ProgramPage programPage, int subnavigationNumber) {
		Logger.info("Verify previous slide arrow functionality in secondary sub navigation");
		String firstSlideHeading;
		int slideCount = programPage.getSecondarySubNavigationSlideCount();
		String lastSlideHeading = programPage.getSlideHeadingText();
		int slideNumber = slideCount;
		do {
			assertTrue(programPage.verifySlideNumberVisible(slideNumber), "Slide number "+ slideNumber+" on subnavigation number "+subnavigationNumber+" is not visible");
			if(!(subnavigationNumber == 1 && slideNumber == 1)) {
				assertTrue(programPage.isSlideHeadingVisible(), "Slide heading in slide number "+ slideNumber+" on subnavigation number "+subnavigationNumber+" is not visible");
				assertTrue(programPage.isSlideTextVisible(), "Slide text in slide number "+ slideNumber+" on subnavigation number "+subnavigationNumber+" is not visible");
			}
			if(subnavigationNumber == 3 && Settings.isDesktop()) {
				assertTrue(programPage.isSlideImageVisible(), "Slide image in slide number "+ slideNumber+" on subnavigation number "+subnavigationNumber+" is not visible");
			}
			if(slideNumber != 1) {
				programPage.clickPreviousSlideArrow();
			}

			slideNumber--;
		} while(slideNumber != 0);

		if(subnavigationNumber == 1) {
			firstSlideHeading = programPage.getNewsletterHeadingText();
		} else {
			firstSlideHeading = programPage.getSlideHeadingText();
		}
		assertNotEquals(lastSlideHeading, firstSlideHeading, "Slide heading text should not be same");
	}

	private void verifyRecentStories(ProgramPage programPage) {
		Logger.info("Verify recent stories");
		int recentStoriesCount = programPage.getRecentStoriesCount();
		for(int recentStory = 1; recentStory <= recentStoriesCount; recentStory++) {
			assertTrue(programPage.isRecentStoriesImageNumberVisible(recentStory), "Recent story image number "+ recentStory+" is not visible");
			assertTrue(programPage.isRecentStoriesTitleNumberVisible(recentStory), "Recent story title number "+ recentStory+" is not visible");
			assertTrue(programPage.isRecentStoriesImageNumberClickable(recentStory), "Recent story image number "+ recentStory+" is not clickable");
			assertTrue(programPage.isRecentStoriesTitleNumberClickable(recentStory), "Recent story title number "+ recentStory+" is not clickable");
		}
	}

	private void verifyRelatedList(ProgramPage programPage) {
		if(Settings.isDesktop()) {
			Logger.info("Verify related list stories");
			int relatedListCount = programPage.getRelatedListCount();
			for(int relatedListElement = 1; relatedListElement <= relatedListCount; relatedListElement++) {
				assertTrue(programPage.isRelatedListImageNumberVisible(relatedListElement), "Related list image number "+ relatedListElement+" is not visible");
				assertTrue(programPage.isRelatedListTitleNumberVisible(relatedListElement), "Related list title number "+ relatedListElement+" is not visible");
				assertTrue(programPage.isRelatedListImageNumberClickable(relatedListElement), "Related list image number "+ relatedListElement+" is not clickable");
				assertTrue(programPage.isRelatedListTitleNumberClickable(relatedListElement), "Related list title number "+ relatedListElement+" is not clickable");
			}
		}
	}

	private void verifyProgramPageContent(ProgramPage programPage) {
		assertTrue(programPage.isSubHeadingVisible(), "Sub heading is not visible");
		assertTrue(programPage.isSubHeadingLinkValid(), "Sub heading is not clickable");
		assertTrue(programPage.isDeckHeaderVisible(), "Deck header is not visible");
		assertTrue(programPage.isDeckTextVisible(), "Deck text is not visible");
		assertTrue(programPage.isImageVisible(), "Image is not visible");
		assertTrue(programPage.isArticleTitleVisible(), "Article title is not visible");
		assertTrue(programPage.isArticleTitleLinkValid(), "Article title is not clickable");
		assertTrue(programPage.isSecondarySubNavigationModuleVisible(), "Secondary Sub Navigation Module is not visible");
		assertTrue(programPage.isRecentStoriesSectionVisible(), "Recent Stories Section is not visible");
		if(Settings.isDesktop()) {
			assertTrue(programPage.isRightRailModuleVisible(), "Right Rail Module is not visible");
		}
	}
}