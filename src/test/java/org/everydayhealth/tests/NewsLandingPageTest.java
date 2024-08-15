package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.landingpages.NewsLandingPage;
import framework.Logger;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.testng.Assert.*;

/**
 * NewsLandingPageTest
 */
public class NewsLandingPageTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "NewsLandingTest", "C347268"})
	@TestRail(id = "C347268")
	public void verifyTitleSection() {
		NewsLandingPage newsLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.NEWS_LANDING_PAGE, NewsLandingPage.class);

		assertTrue(newsLandingPage.isHeroSectionVisible(), "Hero section should be visible");
		assertTrue(newsLandingPage.isHeroTitleVisible(), "Headline should be visible");
		assertEquals(newsLandingPage.getHeadlineText(),
				"Health News: Latest Research, Top Stories, Trending Topics",
				"Incorrect text in headline");
		assertEquals(newsLandingPage.getHeadlineCssAttribute("color"),
				"rgba(0, 0, 0, 1)",
				"Headline color should be 'rgba(0, 0, 0, 1)'");
		String fontFamily = Settings.isMobile() ? "'Open Sans', Verdana" : "\"Open Sans\", Verdana";
		assertEquals(newsLandingPage.getHeadlineCssAttribute("font-family"),
				fontFamily,
				"Headline font-family should be '\"Open Sans\", Verdana'");
		String fontSize = Settings.isMobile() ? "24px" : "42px";
		assertEquals(newsLandingPage.getHeadlineCssAttribute("font-size"),
				fontSize,
				"Headline font-size should be - " + fontSize);
		assertEquals(newsLandingPage.getHeadlineCssAttribute("text-align"),
				"center",
				"Headline text-align should be 'center'");

		assertTrue(newsLandingPage.isDescriptionVisible(), "Description should be visible");
		assertTrue(newsLandingPage.isContactUsLinkVisibleInDescription(),
				"'Contact Us' link should be visible in description");
		assertTrue(newsLandingPage.getContactUsHrefValue().endsWith("/contact-us/"), "Invalid 'Contact Us' link");
		assertEquals(newsLandingPage.getDescriptionCssAttribute("color"),
				"rgba(51, 51, 51, 1)",
				"Description color should be 'rgba(51, 51, 51, 1)'");
		assertEquals(newsLandingPage.getDescriptionCssAttribute("font-family"),
				fontFamily,
				"Description font-family should be '\"Open Sans\", Verdana'");
		assertEquals(newsLandingPage.getDescriptionCssAttribute("font-size"),
				"15px",
				"Description font-size should be '15px'");
		assertEquals(newsLandingPage.getDescriptionCssAttribute("text-align"),
				"center",
				"Description text-align should be 'center'");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "NewsLandingTest", "C347271"})
	@TestRail(id = "C347271")
	public void verifyHealthDayWidget() {
		NewsLandingPage newsLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.NEWS_LANDING_PAGE, NewsLandingPage.class);

		assertTrue(newsLandingPage.isHealthDayWidgetVisible(), "HealthDay Widget should be visible");
		assertTrue(newsLandingPage.isHealthDayWidgetHealineVisible(), "HealthDay Widget headline should be visible");
		assertEquals(newsLandingPage.getHealthDayWidgetHeadlineText(), "More News", "Text should be 'More News'");
		assertEquals(newsLandingPage.getHealthDayWidgetHeadlineCssAttribute("color"),
				"rgba(0, 0, 0, 1)",
				"Description color should be 'rgba(0, 0, 0, 1'");
		String fontWeight = Settings.isMobile() ? "normal" : "400";
		assertEquals(newsLandingPage.getHealthDayWidgetHeadlineCssAttribute("font-weight"),
				fontWeight,
				"Headline font-weight should be - " + fontWeight);
		assertEquals(newsLandingPage.getHealthDayWidgetHeadlineCssAttribute("font-size"),
				"26px",
				"Headline font-size should be '26px'");
		String textAlign = Settings.isMobile() ? "center" : "left";
		assertEquals(newsLandingPage.getHealthDayWidgetHeadlineCssAttribute("text-align"),
				textAlign,
				"Headline text-align should be 'left'");

		int numberOfHealthDayCards = newsLandingPage.getNumberOfHealthDayWidgetCards();
		newsLandingPage.scrollToHealthDayWidgetCard(numberOfHealthDayCards);
		assertEquals(numberOfHealthDayCards, 3, "3 cards should be present on HealthDay Widget");
		assertEquals(newsLandingPage.getNumberOfHealthDayWidgetCardTitles(),
				numberOfHealthDayCards,
				"Each card should have title");
		assertEquals(newsLandingPage.getNumberOfHealthDayWidgetCardTypeIcons(),
				numberOfHealthDayCards,
				"Each card should have type icon");
		assertEquals(newsLandingPage.getNumberOfHealthDayWidgetCardTimestamps(),
				numberOfHealthDayCards,
				"Each card should have timestamp");
		assertEquals(newsLandingPage.getNumberOfHealthDayWidgetCardBylines(),
				numberOfHealthDayCards,
				"Each card should have byline");
		if (newsLandingPage.getNumberOfHealthDayWidgetCardImages() < 3) {
			Logger.info("Not all content cards have image");
		}
		if (newsLandingPage.getNumberOfHealthDayWidgetCardDescriptions() < 3) {
			Logger.info("Not all content cards have description");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "NewsLandingTest", "C347270"})
	@TestRail(id = "C347270")
	public void verifyPageContent() {
		NewsLandingPage newsLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.NEWS_LANDING_PAGE, NewsLandingPage.class);

		Logger.info("Verify navigation and number of articles on each page");
		if (Settings.isMobile()) {
			assertEquals(newsLandingPage.getPaginationInfo(), "1 of 6", "Correct pagination info should be displayed on page load");
			assertFalse(newsLandingPage.isPaginationPreviousLinkVisible(), "'Previous' navigation arrow should not be visible");
			assertTrue(newsLandingPage.isPaginationNextLinkVisible(), "'Next' navigation arrow should be visible");
			assertEquals(newsLandingPage.getTotalNumberOfContentCards(), 10, "10 content cards should be displayed");
		} else {
			assertEquals(newsLandingPage.getPaginationInfo(), "1 of 3", "Correct pagination info should be displayed on page load");
			assertFalse(newsLandingPage.isPaginationPreviousLinkVisible(), "'Previous' navigation arrow should not be visible");
			assertTrue(newsLandingPage.isPaginationNextLinkVisible(), "'Next' navigation arrow should be visible");
			assertEquals(newsLandingPage.getTotalNumberOfContentCards(), 20, "20 content cards should be displayed");
			newsLandingPage.clickPaginationNextLink();
			assertTrue(Utils.getCurrentURL().endsWith("?page=2"), "User should be taken to 2nd page");
			assertEquals(newsLandingPage.getTotalNumberOfContentCards(), 20, "20 content cards should be displayed");
			assertEquals(newsLandingPage.getPaginationInfo(), "2 of 3", "Correct pagination info should be displayed");
			assertTrue(newsLandingPage.isPaginationPreviousLinkVisible(), "'Previous' navigation arrow should be visible");
			assertTrue(newsLandingPage.isPaginationNextLinkVisible(), "'Next' navigation arrow should be visible");
			newsLandingPage.clickPaginationNextLink();
			assertTrue(Utils.getCurrentURL().endsWith("?page=3"), "User should be taken to 3rd page");
			assertEquals(newsLandingPage.getTotalNumberOfContentCards(), 20, "20 content cards should be displayed");
			assertEquals(newsLandingPage.getPaginationInfo(), "3 of 3", "Correct pagination info should be displayed");
			assertTrue(newsLandingPage.isPaginationPreviousLinkVisible(), "'Previous' navigation arrow should be visible");
			assertFalse(newsLandingPage.isPaginationNextLinkVisible(), "'Next' navigation arrow should not be visible");
			newsLandingPage.clickPaginationPreviousLink();
			assertTrue(Utils.getCurrentURL().endsWith("?page=2"), "User should be taken to 2nd page");
			assertEquals(newsLandingPage.getPaginationInfo(), "2 of 3", "Correct pagination info should be displayed");
			newsLandingPage.clickPaginationPreviousLink();
			assertEquals(newsLandingPage.getPaginationInfo(), "1 of 3", "Correct pagination info should be displayed on page load");
			assertFalse(newsLandingPage.isPaginationPreviousLinkVisible(), "'Previous' navigation arrow should not be visible");
			assertTrue(newsLandingPage.isPaginationNextLinkVisible(), "'Next' navigation arrow should be visible");
			assertTrue(Utils.getCurrentURL().endsWith("/news/"), "News landing page URL should not be modified");
		}

		int numberOfContentCards = newsLandingPage.getTotalNumberOfContentCards();
		for (int contentCardNumber = 1; contentCardNumber <= numberOfContentCards; contentCardNumber++) {
			Logger.info("Verifying the " + contentCardNumber + " content card description");
			if ((contentCardNumber % 2) == 0) {
				newsLandingPage.scrollToContentCard(contentCardNumber);
			}
			assertTrue(newsLandingPage.getContentCardHrefValue(contentCardNumber).startsWith("https://"), "'href' value is not https URL");
			assertTrue(newsLandingPage.isContentCardContainHeader(contentCardNumber), "Every content card should have header");
			if (!Settings.isMobile() && !newsLandingPage.isContentCardContainDesc(contentCardNumber)) {
				Logger.info("Description of content card #" + contentCardNumber + " is not available");
			}
		}
		assertEquals(newsLandingPage.getNumberOfVisibleContentCardTypeIcons(), numberOfContentCards, "Each card should have type icon");
		assertEquals(newsLandingPage.getNumberOfContentCardBylines(), numberOfContentCards, "Each card should have byline");
		int numberOfImages = newsLandingPage.getNumberOfContentCardWithImage();
		if (numberOfContentCards != numberOfImages) {
			Logger.info("Not all cards have image. Total number of images on current page - " + numberOfImages);
		}
		int numberOfHyperlinkedBylines = newsLandingPage.getNumberOfHyperlinkedBylines();
		if (numberOfContentCards != numberOfHyperlinkedBylines) {
			Logger.info("Not all cards have hyperlinked byline. Total number of hyperlinked bylines - " + numberOfHyperlinkedBylines);
		}
		for (int timeStamp = 1; timeStamp < numberOfContentCards; timeStamp++) {
			LocalDate date = LocalDate.parse(newsLandingPage.getCardTimestamp(timeStamp), DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.US));
			Logger.info("Card #" + timeStamp + " timestamp - " + date);
			LocalDate date1 = LocalDate.parse(newsLandingPage.getCardTimestamp(timeStamp + 1), DateTimeFormatter.ofPattern("MMM d, yyyy", Locale.US));
			Logger.info("Card #" + timeStamp + " timestamp - " + date1);
			assertTrue(date.isAfter(date1) || date.isEqual(date1), "Cards should be placed in chronological order");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "NewsLandingTest", "C347269"})
	@TestRail(id = "C347269")
	public void verifyNewsletterWidgetFunctionality() {
		NewsLandingPage newsLandingPage = SiteNavigatorEH.goToPage(TemplatesEH.NEWS_LANDING_PAGE, NewsLandingPage.class);

		assertTrue(newsLandingPage.isNewsletterWidgetInPosition(4), "Newsletter widget should be placed after 3rd content card");
		verifyNewsletterWidgetFunctionality(newsLandingPage);
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event4", "'event4' should fire");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/generalwellness/general"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "newsland"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/generalwellness/general"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "newsland|/generalwellness/general"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "newsland|/generalwellness/general|"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].split("#")[0].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "landing 3.0"), "eVar30 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar42", "center"), "eVar42 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "news"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "news"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
	}
}