package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.articles.PhotoGalleryPage;
import everydayhealth.pages.share.PGSocialBar;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import framework.Logger;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.GAUtils;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import framework.platform.utilities.WindowUtils;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import static framework.components.BasicPage.clickBackBrowserButton;
import static org.testng.Assert.*;

/**
 * PhotoGalleryTest
 */
public class PhotoGalleryTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C675130"})
	@TestRail(id = "C675130")
	public void verifyGallerySection() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();
		int numberOfItems = photoGalleryPage.getNumberOfGalleryItems();
		assertTrue(numberOfItems >= 1, "At least one item should be present on page");

		for (int itemNumber = 1; itemNumber <= numberOfItems; itemNumber++) {
			assertTrue(photoGalleryPage.isItemHeaderVisible(itemNumber), "Each item should have visible header");
			assertTrue(photoGalleryPage.isItemImageNumberVisible(itemNumber), "Item number index should be visible");
			assertEquals(Utils.getHexColor(photoGalleryPage.getItemImageNumberColor(itemNumber)),
					"#b3dbf1",
					"Incorrect color for index number");
			assertTrue(photoGalleryPage.isItemImageTitleVisible(itemNumber), "Item should have visible title");
			assertTrue(photoGalleryPage.isItemImageVisible(itemNumber), "Item should have visible image");
			assertTrue(photoGalleryPage.isItemImageDescriptionVisible(itemNumber),
					"Item should have visible description");
		}
		int numberOfImageCredits = photoGalleryPage.getNumberOfImageCredits();
		if (numberOfImageCredits <= numberOfItems + 1) {
			assertTrue(numberOfImageCredits >= 1, "At least one image credit should be visible");
			Logger.info("Image credit is not present for every image");
		}
		int numberOfLinksInDescriptions = photoGalleryPage.getNumberOfDescriptionLinksOnPage();
		if (numberOfImageCredits >= 1) {
			for (int linkNumber = 1; linkNumber <= numberOfLinksInDescriptions; linkNumber++) {
				assertEquals(photoGalleryPage.getDescriptionLinkBackgroundColor(linkNumber),
						"#eef2ff",
						"All hyperlinks should have background color '#eef2ff'");
			}
		}

	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C675776"})
	@TestRail(id = "C675776")
	public void verifyIntroSection() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();

		assertTrue(photoGalleryPage.isIntroSectionVisible(), "Intro section should be visible");
		assertTrue(photoGalleryPage.isIntroSectionImageVisible(), "Intro section image should be visible");
		if (photoGalleryPage.isIntroSectionImageCreditVisible()) {
			Logger.info("Intro section image credit is present");
		} else {
			Logger.info("Intro section image credit is not present");
		}
		assertTrue(photoGalleryPage.isIntroSectionDescriptionVisible(),
				"Intro section description should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C675781"})
	@TestRail(id = "C675781")
	public void verifyURLUpdate() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();

		int numberOfItems = photoGalleryPage.getNumberOfGalleryItems();
		String pgUrl = Settings.isMobile() ?
				"/yk-photo-gallery-test-page/" :
				TemplatesEH.PHOTO_GALLERY.getTemplateURL();
		String originalURL = Settings.getDefaultUrl() + pgUrl;
		assertEquals(Utils.getCurrentURL().replace("?isautomation=true", ""),
				originalURL,
				"Original URL should not be appended with any symbol");
		for (int item = 1; item <= numberOfItems; item++) {
			photoGalleryPage.scrollToItem(item);
			String itemTitle = photoGalleryPage.getImageTitleText(item)
					.replace("'", "")
					.replace(" ", "-")
					.toLowerCase()
					.trim();
			Logger.info("Item title - " + itemTitle);
			assertTrue(Utils.getCurrentURL().endsWith("#" + itemTitle), "URL should be appended with title text");
		}
		photoGalleryPage.scrollToItem(0);
		assertEquals(Utils.getCurrentURL().replace("?isautomation=true", ""),
				originalURL,
				"Original URL should not be appended with any symbol");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C675818"})
	@TestRail(id = "C675818")
	public void verifyPromoBanner() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();

		verifyPromoBannerSection(photoGalleryPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C675862"})
	@TestRail(id = "C675862")
	public void verifyNewsletterWidget() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();

		verifyNewsletterWidgetFunctionality(photoGalleryPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C675131"})
	@TestRail(id = "C675131")
	public void verifyGalleryButtons() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();

		int numberOfItems = photoGalleryPage.getNumberOfGalleryItems();
		int numberOfButtons = photoGalleryPage.getNumberOfCTAButtons();
		assertEquals(numberOfButtons, numberOfItems, "Each gallery item should have CTA button");

		int amazonButtonsCounter = 1;
		for (int buttonNumber = 1; buttonNumber <= numberOfButtons; buttonNumber++) {
			String type = photoGalleryPage.getCTAButtonType(buttonNumber);
			switch (type) {
				case "Article":
					assertEquals(photoGalleryPage.getCTAButtonText(buttonNumber),
							"Read More",
							"Incorrect text for article-type button");
					break;
				case "Recipe":
					assertEquals(photoGalleryPage.getCTAButtonText(buttonNumber),
							"Get the Recipe",
							"Incorrect text for recipe-type button");
					break;
				case "Amazon":
					String price = photoGalleryPage.getAmazonPrice(amazonButtonsCounter);
					assertEquals(photoGalleryPage.getCTAButtonText(buttonNumber),
							"Buy for " + price + " on Amazon",
							"Incorrect text for amazon-type button");
					amazonButtonsCounter++;
					break;
				case "Other":
					assertTrue(photoGalleryPage.getCTAButtonText(buttonNumber).contains("Other button"),
							"Incorrect text for other-type button");
					break;
				default:
					fail("Unexpected button type");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C675133"})
	@TestRail(id = "C675133")
	public void verifyHeadlineElements() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();

		assertTrue(photoGalleryPage.isHeadlineSectionVisible(), "Headline section should be visible");
		assertTrue(photoGalleryPage.isSubcategoryTagVisible(), "Subcategory tag should be visible");
		assertEquals(photoGalleryPage.getSubcategoryTagColor(), "#2488be", "Subcategory tag should be blue");
		assertTrue(photoGalleryPage.isTitleVisible(), "Title should be visible");
		assertTrue(photoGalleryPage.isDeckVisible(), "Deck should be visible");
		assertTrue(photoGalleryPage.isBylineVisible(), "Byline should be visible");
		assertTrue(photoGalleryPage.isBylineAuthorVisible(), "Author name should be visible");
		assertTrue(photoGalleryPage.isBylineReviewerVisible(), "Reviewer name should be visible");
		LocalDate pageDate = LocalDate.parse(photoGalleryPage.getDate(),
				DateTimeFormatter.ofPattern("MMMM dd, yyyy", Locale.US));
		if (photoGalleryPage.isDateVisible()) {
			assertTrue(pageDate.isAfter(LocalDate.now().minusDays(365L)),
					"Date should not be visible if it is more than 365 days old");
		}
		assertTrue(photoGalleryPage.isSponsoredByVisible(), "Sponsored By text should be visible");
		assertTrue(photoGalleryPage.isAffiliateDisclaimerVisible(), "Affiliate disclaimer should be visible");
		assertEquals(photoGalleryPage.getAffiliateDisclaimerText(),
				"Everyday Health may earn a portion of revenue from purchases of featured products.",
				"Incorrect text for affiliate disclaimer");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C675870"})
	@TestRail(id = "C675870")
	public void verifyGoogleMatched() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();

		verifyGoogleMatchedContent(photoGalleryPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C675879"})
	@TestRail(id = "C675879")
	public void verifyRelatedGalleries() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();

		assertTrue(photoGalleryPage.isRelatedGalleriesSectionVisible(),
				"Related Galleries section should be visible");
		assertEquals(photoGalleryPage.getRelatedGalleriesSectionBackgroundColor(),
				"#f5fafb",
				"Incorrect background color");
		assertTrue(photoGalleryPage.isRelatedGalleriesTitleVisible(), "Title should be visible");
		assertEquals(photoGalleryPage.getRelatedGalleriesTitleText(),
				"Related Galleries",
				"Incorrect title text");
		int numberOfContentCards = photoGalleryPage.getNumberOfRelatedGalleriesCards();
		assertTrue(numberOfContentCards >= 1 && numberOfContentCards <= 4,
				"At least one content card should be visible, but not more than 4");
		assertEquals(photoGalleryPage.getNumberOfRelatedGalleriesCardImages(),
				numberOfContentCards,
				"Each content card should have image");
		assertEquals(photoGalleryPage.getNumberOfRelatedGalleriesCardTitles(),
				numberOfContentCards,
				"Each content card should have title");
		assertEquals(photoGalleryPage.getNumberOfRelatedGalleriesCardSubcategoryTags(),
				numberOfContentCards,
				"Each content card should have subcategory tag");
		String category = photoGalleryPage.getCategoryForPage();
		String subCategory = photoGalleryPage.getSubCategoryForPage();
		for (int cardNumber = 1; cardNumber <= numberOfContentCards; cardNumber++) {
			String subcategoryTagText = photoGalleryPage.getRelatedGallerySubcategoryTagText(cardNumber);
			assertTrue(subcategoryTagText.equals(subCategory) ||
							subcategoryTagText.equals(category),
					"Subcategory tag should be equal to subcategory or parent category");
			String subcategoryTagHref = photoGalleryPage.getRelatedGallerySubcategoryTagHref(cardNumber);
			assertTrue(subcategoryTagHref.contains(subCategory.toLowerCase().replace(" ", "-")) ||
							subcategoryTagHref.contains(category.toLowerCase().replace(" ", "-")),
					"Subcategory tag should contain subcategory or parent category in 'href' attribute");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C675132"})
	@TestRail(id = "C675132")
	public void verifyShareBar() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();

		PGSocialBar pgSocialBar = photoGalleryPage.onPGSocialBar();
		assertTrue(pgSocialBar.isShareBarVisible(), "Share bar should be visible");
		assertTrue(pgSocialBar.isFacebookShareButtonVisible(), "Facebook share button should be visible");
		assertTrue(pgSocialBar.isTwitterShareButtonVisible(), "Twitter share button should be visible");
		if (Settings.isMobile()) {
			assertTrue(pgSocialBar.isPinterestShareButtonVisible(), "Pinterest share button should be visible");

			assertTrue(pgSocialBar.isBottomShareBarVisible(), "Bottom share bar should be visible");
			assertTrue(pgSocialBar.isBottomShareBarFacebookButtonVisible(),
					"'Facebook' button should be visible on bottom sharebar");
			assertTrue(pgSocialBar.isBottomShareBarTwitterButtonVisible(),
					"'Twitter' button should be visible on bottom sharebar");
			assertTrue(pgSocialBar.isBottomShareBarPinterestButtonVisible(),
					"'Pinterest' button should be visible on bottom sharebar");
			assertTrue(pgSocialBar.isBottomShareBarEmailButtonVisible(),
					"'Email' button should be visible on bottom sharebar");
		} else {
			assertFalse(pgSocialBar.isPinterestShareButtonVisible(), "Pinterest share button should not be visible");
		}
		assertTrue(pgSocialBar.isEmailShareButtonVisible(), "Email share button should be visible");

		ShareViaEmailPopUp shareViaEmailPopUp = pgSocialBar.clickEmailShareButton();
		shareViaEmailPopUp.typeYourEmailFriendEmailAndSend(UserCacheEH.MAIN_USER.getEmail(), StringUtils.generateRandomEmail());
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks! Your email was sent"),
				"Sent email message is not visible");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyVisible(), "'Privacy Policy' is not visible");
		assertEquals(shareViaEmailPopUp.getPrivacyPolicyLinkText(), "Privacy Policy",
				"'Privacy Policy' text is not present");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyLinkPresent(), "'Privacy Policy' link is not present");
		shareViaEmailPopUp.clickSignUpButton();
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks! Your email was sent"),
				"Sent email message is not visible");
		shareViaEmailPopUp.closePopUp();

		if (Settings.isDesktop()) {
			assertTrue(pgSocialBar.isPrintShareButtonVisible(), "Print share button should be visible");

			String currentURL = Utils.getCurrentURL().replace("?isautomation=true", "");

			pgSocialBar.clickFacebookShareButton();
			WindowUtils.switchToLastOpenedWindow();
			assertTrue(Utils.getCurrentURL().contains("facebook.com"), "Facebook share window should be opened");
			WindowUtils.switchToMainWindow();

			pgSocialBar.scrollPage(4000);
			pgSocialBar.clickTwitterShareButton();
			WindowUtils.switchToLastOpenedWindow();
			assertTrue(Utils.getCurrentURL().contains("twitter.com"), "Twitter share window should be opened");
			assertTrue(pgSocialBar.getTwitterStatusText()
							.endsWith("via @EverydayHealth  " + currentURL),
					"Share link should not contain gallery item URL");
			WindowUtils.switchToMainWindow();
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C675919"})
	@TestRail(id = "C675919")
	public void verifySourcesSection() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();

		assertTrue(photoGalleryPage.isSourcesSectionVisible(), "Sources section should be visible");
		assertTrue(photoGalleryPage.isSourcesSectionHeaderVisible(), "Sources section header should be visible");
		assertEquals(photoGalleryPage.getSourcesSectionHeaderText(),
				"Editorial Sources and Fact Checking",
				"Incorrect sources section title");
		assertFalse(photoGalleryPage.isSourcesSectionContentVisible(), "Sources section content should not be visible");
		photoGalleryPage.clickSourcesSectionHeader();
		assertTrue(photoGalleryPage.isSourcesSectionContentVisible(), "Sources section content should be visible");
		photoGalleryPage.clickSourcesSectionHeader();
		assertFalse(photoGalleryPage.isSourcesSectionContentVisible(), "Sources section content should not be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthMobile", "PhotoGalleryTest", "C678382"})
	@TestRail(id = "C678382")
	public void verifyLatestArticlesModule() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToPhotoGalleryPage();

		verifyLatestArticlesModule(photoGalleryPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "PhotoGalleryTest", "PGGATest", "C678407"}, priority = 1)
	@TestRail(id = "C678407")
	public void verifyPageLoadAndScrollDepthEvents() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToGADebugMode(TemplatesEH.PHOTO_GALLERY, PhotoGalleryPage.class);

		Utils.waitFor(7000);
		Map<String, Map<String, String>> consoleOutput = GAUtils.getConsoleOutput();
		assertTrue(consoleOutput.keySet().contains("pageview"), "Page load event should fire");
		verifyValues("pageview", consoleOutput.get("pageview"), photoGalleryPage);
		Utils.executeJS("scrollTo(0,($(document).height()/5))");
		consoleOutput = GAUtils.getConsoleOutput();
		assertTrue(consoleOutput.keySet().contains("Scroll Depth 20%"),
				"Scroll depth event should fire on 20% of page scroll");
		verifyValues("Scroll Depth 20%", consoleOutput.get("Scroll Depth 20%"), photoGalleryPage);
		Utils.executeJS("scrollTo(0,($(document).height()*0.4))");
		consoleOutput = GAUtils.getConsoleOutput();
		assertTrue(consoleOutput.keySet().contains("Scroll Depth 40%"),
				"Scroll depth event should fire on 40% of page scroll");
		verifyValues("Scroll Depth 40%", consoleOutput.get("Scroll Depth 40%"), photoGalleryPage);
		Utils.executeJS("scrollTo(0,($(document).height()*0.6))");
		consoleOutput = GAUtils.getConsoleOutput();
		assertTrue(consoleOutput.keySet().contains("Scroll Depth 60%"),
				"Scroll depth event should fire on 60% of page scroll");
		verifyValues("Scroll Depth 60%", consoleOutput.get("Scroll Depth 60%"), photoGalleryPage);
		Utils.executeJS("scrollTo(0,($(document).height()*0.8))");
		consoleOutput = GAUtils.getConsoleOutput();
		assertTrue(consoleOutput.keySet().contains("Scroll Depth 80%"),
				"Scroll depth event should fire on 80% of page scroll");
		verifyValues("Scroll Depth 80%", consoleOutput.get("Scroll Depth 80%"), photoGalleryPage);
		Utils.executeJS("scrollTo(0,($(document).height()*1.1))");
		Utils.executeJS("scrollTo(0,($(document).height()*1.2))");
		consoleOutput = GAUtils.getConsoleOutput();
		assertTrue(consoleOutput.keySet().contains("Scroll Depth 100%"),
				"Scroll depth event should fire on 100% of page scroll");
		verifyValues("Scroll Depth 100%", consoleOutput.get("Scroll Depth 100%"), photoGalleryPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "PhotoGalleryTest", "PGGATest", "C681468"}, priority = 2)
	@TestRail(id = "C681468")
	public void verifySubcategoryAndSourcesClickEvents() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToGADebugMode(TemplatesEH.PHOTO_GALLERY, PhotoGalleryPage.class);

		photoGalleryPage.clickSubcategoryTag();
		Map<String, Map<String, String>> consoleOutput = GAUtils.getConsoleOutput();
		Map<String, String> cdValues = consoleOutput.get("content click subcategory click");
		assertTrue(consoleOutput.keySet().contains("content click subcategory click"),
				"Content click event should fire");
		verifyValues("content click", cdValues, photoGalleryPage);
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "content click", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"), "subcategory click", "Incorrect event action");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventLabel"),
				photoGalleryPage.getSubCategoryForPage(),
				"Incorrect event label");
		clickBackBrowserButton(PhotoGalleryPage.class);
		Utils.waitFor(7000);
		photoGalleryPage.clickSourcesSectionHeader();
		consoleOutput = GAUtils.getConsoleOutput();
		assertTrue(consoleOutput.keySet().contains("content click editorial sources click"),
				"Content click event should fire");
		cdValues = consoleOutput.get("content click editorial sources click");
		verifyValues("content click", cdValues, photoGalleryPage);
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "content click", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"),
				"editorial sources click",
				"Incorrect event action");
	}

	@Test(groups = {"EverydayHealthDesktop", "PhotoGalleryTest", "PGGATest", "C681469"}, priority = 3)
	@TestRail(id = "C681469")
	public void verifyNewslettersEvents() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToGADebugMode(TemplatesEH.PHOTO_GALLERY, PhotoGalleryPage.class);

		Utils.waitFor(7000);
		photoGalleryPage.clickNewsletterSubmitButton();
		Map<String, Map<String, String>> consoleOutput = GAUtils.getConsoleOutput();
		Map<String, String> cdValues = consoleOutput.get("email email error");
		verifyValues("email", cdValues, photoGalleryPage);
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "email", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"), "email error", "Incorrect event action");

		photoGalleryPage.enterEmailAndSubmit(StringUtils.generateRandomEmail());
		consoleOutput = GAUtils.getConsoleOutput();
		cdValues = consoleOutput.get("email email capture");
		verifyValues("email", cdValues, photoGalleryPage);
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "email", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"), "email capture", "Incorrect event action");
	}

	@Test(groups = {"EverydayHealthDesktop", "PhotoGalleryTest", "PGGATest", "C681470"}, priority = 4)
	@TestRail(id = "C681470")
	public void verifyLatestArticlesModuleEvents() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToGADebugMode(TemplatesEH.PHOTO_GALLERY, PhotoGalleryPage.class);

		Utils.waitFor(7000);
		photoGalleryPage.scrollToLatestArticlesModule();
		Map<String, Map<String, String>> consoleOutput = GAUtils.getConsoleOutput();
		Map<String, String> cdValues = consoleOutput.get("recirculation module load");
		verifyValues("recirculation", cdValues, photoGalleryPage);
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "recirculation", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"),
				"module load",
				"Incorrect event action");

		photoGalleryPage.clickLatestArticlesModuleCard(2);
		consoleOutput = GAUtils.getConsoleOutput();
		cdValues = consoleOutput.get("recirculation recirc click");
		verifyValues("recirculation", cdValues, photoGalleryPage);
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "recirculation", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"),
				"recirc click",
				"Incorrect event action");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventLabel"),
				photoGalleryPage.getLatestArticlesModuleCardHrefValue(2).split(".com")[1],
				"Incorrect event label");

		clickBackBrowserButton(PhotoGalleryPage.class);
		Utils.waitFor(7000);
		consoleOutput = GAUtils.getConsoleOutput();
		cdValues = consoleOutput.get("recirculation subcategory click");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "recirculation", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"),
				"subcategory click",
				"Incorrect event action");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventLabel"),
				photoGalleryPage.getSubCategoryForPage(),
				"Incorrect event label");
	}

	@Test(groups = {"EverydayHealthDesktop", "PhotoGalleryTest", "PGGATest", "C681471"}, priority = 5)
	@TestRail(id = "C681471")
	public void verifyCTAButtonsClickEvents() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToGADebugMode(TemplatesEH.PHOTO_GALLERY, PhotoGalleryPage.class);

		Utils.waitFor(7000);
		photoGalleryPage.clickCTAButton(1);
		Map<String, Map<String, String>> consoleOutput = GAUtils.getConsoleOutput();
		Map<String, String> cdValues = consoleOutput.get("content click internal link");
		clickBackBrowserButton(PhotoGalleryPage.class);
		Utils.waitFor(7000);
		verifyValues("content click", cdValues, photoGalleryPage);
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "content click", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"),
				"internal link",
				"Incorrect event action");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventLabel"),
				photoGalleryPage.getCTAButtonHrefValue(1),
				"Incorrect event label");

		photoGalleryPage.clickCTAButton(4); //amazon link
		WindowUtils.switchToLastOpenedWindow();
		consoleOutput = GAUtils.getConsoleOutput();
		assertEquals(WindowUtils.getTabsCount(), 2, "Outbound link should be opened in new tab");
		WindowUtils.switchToMainWindow();
		cdValues = consoleOutput.get("affiliate product click");
		verifyValues("affiliate", cdValues, photoGalleryPage);
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "affiliate", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"),
				"product click",
				"Incorrect event action");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventLabel"), "amazon", "Incorrect event label");
		assertEquals(GAUtils.getEventParameter(cdValues, "dimension9"), "B073JYVKNX", "Incorrect cd9 (product SKU)");

		photoGalleryPage.clickCTAButton(6); //outbound link
		assertEquals(WindowUtils.getTabsCount(), 2, "Outbound link should be opened in new tab");
		consoleOutput = GAUtils.getConsoleOutput();
		WindowUtils.switchToLastOpenedWindow();
		WindowUtils.switchToMainWindow();
		cdValues = consoleOutput.get("outbound links click");
		verifyValues("outbound click", cdValues, photoGalleryPage);
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "outbound links", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"), "click", "Incorrect event action");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventLabel"),
				photoGalleryPage.getCTAButtonHrefValue(6),
				"Incorrect event label");
	}

	@Test(groups = {"EverydayHealthDesktop", "PhotoGalleryTest", "PGGATest", "C696092"}, priority = 6)
	@TestRail(id = "C696092")
	public void verifyRelatedGalleriesSectionEvents() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToGADebugMode(TemplatesEH.PHOTO_GALLERY, PhotoGalleryPage.class);

		Utils.waitFor(7000);
		photoGalleryPage.clickRelatedGalleriesCard(2);
		Map<String, Map<String, String>> consoleOutput = GAUtils.getConsoleOutput();
		Map<String, String> cdValues = consoleOutput.get("content click related gallery click");
		clickBackBrowserButton(PhotoGalleryPage.class);
		Utils.waitFor(7000);
		verifyValues("content click", cdValues, photoGalleryPage);
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "content click", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"),
				"related gallery click",
				"Incorrect event action");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventLabel"),
				photoGalleryPage.getRelatedGalleryCardTitle(2),
				"Incorrect event label");

		photoGalleryPage.clickRelatedGalleriesSubcategory(3);
		consoleOutput = GAUtils.getConsoleOutput();
		cdValues = consoleOutput.get("content click related gallery subcat");
		clickBackBrowserButton(PhotoGalleryPage.class);
		Utils.waitFor(7000);
		verifyValues("content click", cdValues, photoGalleryPage);
		assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "content click", "Incorrect event category");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"),
				"related gallery subcat",
				"Incorrect event action");
		assertEquals(GAUtils.getEventParameter(cdValues, "eventLabel"),
				photoGalleryPage.getSubCategoryForPage(),
				"Incorrect event label");
	}

	@Test(groups = {"EverydayHealthDesktop", "PhotoGalleryTest", "PGGATest", "C696093"}, priority = 7)
	@TestRail(id = "C696093")
	public void verifyContentViewEvents() {
		PhotoGalleryPage photoGalleryPage = SiteNavigatorEH.goToGADebugMode(TemplatesEH.PHOTO_GALLERY, PhotoGalleryPage.class);

		Utils.waitFor(7000);
		Map<String, Map<String, String>> consoleOutput = GAUtils.getConsoleOutput();
		Map<String, String> cdValues;
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHF-4722");
		assertFalse(consoleOutput.containsKey("content item display 1"),
				"View event should not fire until 1st item is in view port");
		int numberOfGalleryItems = photoGalleryPage.getNumberOfGalleryItems();
		for (int itemIndex = 1; itemIndex <= numberOfGalleryItems; itemIndex++) {
			photoGalleryPage.scrollToItem(itemIndex);
			consoleOutput = GAUtils.getConsoleOutput();
			cdValues = consoleOutput.get("content item display " + itemIndex);
			verifyValues("content item display " + itemIndex, cdValues, photoGalleryPage);
			assertEquals(GAUtils.getEventParameter(cdValues, "eventCategory"), "content", "Incorrect event category");
			assertEquals(GAUtils.getEventParameter(cdValues, "eventAction"),
					"item display",
					"Incorrect event action");
			assertEquals(GAUtils.getEventParameter(cdValues, "eventLabel"),
					String.valueOf(itemIndex),
					"Incorrect event label");
		}
	}

	private void verifyValues(String event, Map<String, String> cdValues, PhotoGalleryPage photoGalleryPage) {
		if (!event.equals("outbound click")) {
			assertEquals(GAUtils.getEventParameter(cdValues, "dimension1"), photoGalleryPage.getAdZoneForPage(),
					"cd1 should contain ad-zone value");
		}
		assertEquals(GAUtils.getEventParameter(cdValues, "dimension3"), "Photo Gallery", "cd3 should contain template name");
		assertEquals(GAUtils.getEventParameter(cdValues, "dimension4"), photoGalleryPage.getCategoryForPage(),
				"cd4 should contain category value");
		assertEquals(GAUtils.getEventParameter(cdValues, "dimension5"), photoGalleryPage.getSubCategoryForPage(),
				"cd5 should contain subcategory value");
		assertEquals(GAUtils.getEventParameter(cdValues, "dimension6"), photoGalleryPage.getAdZoneForPage(),
				"cd6 should contain ad-zone value");
		assertEquals(GAUtils.getEventParameter(cdValues, "dimension7"), "327618", "cd7 should contain page id value");
		assertEquals(GAUtils.getEventParameter(cdValues, "dimension14"), TemplatesEH.PHOTO_GALLERY.getTemplateURL(),
				"cd14 should contain URL");
		assertEquals(GAUtils.getEventParameter(cdValues, "dimension18"), "no", "cd18 should contain 'isNews' value");
		assertFalse(GAUtils.getEventParameter(cdValues, "dimension22").isEmpty(),
				"cd22 should not be empty (if page contains e-commerce links)");
		if (event.equals("pageview")) {
			String cd24Value = photoGalleryPage.isIntroSectionVisible() ? "1" : "0";
			assertEquals(GAUtils.getEventParameter(cdValues, "dimension24"), cd24Value, "cd24 should contain 'isIntroPresent' value");
			assertEquals(GAUtils.getEventParameter(cdValues, "dimension25"),
					String.valueOf(photoGalleryPage.getNumberOfGalleryItems()),
					"cd25 should contain number of gallery items");
		}
	}
}
