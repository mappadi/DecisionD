package org.everydayhealth.tests.push.tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.articles.ArticleNewTemplatePage;
import everydayhealth.pages.articles.CusoArticleV3Page;
import everydayhealth.pages.articles.CustomSolutionsTemplatePage;
import everydayhealth.pages.articles.SlideshowBasePage;
import everydayhealth.pages.lifehack.LifehackPage;
import everydayhealth.pages.push.*;
import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.platform.DatePatterns;
import framework.platform.SiteNavigatorEH;
import framework.platform.utilities.DateUtils;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

/**
 * PushTest
 */
public class PushTest {

	List<String> imagesList = Arrays.asList("//images.agoramedia.com/everydayhealth/gcms/Is-Psoriasis-Remission-Possible-1440x810.jpg",
			"//images.agoramedia.com/EHBlogImages/margaret-omalley-the-lunch-lady/2015/05/Saffron-Cauliflower-Rice-400.jpg.jpg",
			"//images.agoramedia.com/everydayhealth/gcms/10-Heart-Healthy-Drinks-for-Cold-Weather-01-722x406.jpg",
			"//images.agoramedia.com/everydayhealth/gcms/High-Profile-Athletes-With-Atrial-Fibrillation-Intro-RM-1440x810.jpg",
			"//images.agoramedia.com/everydayhealth/gcms/Driving-With-Low-Blood-Sugar-1440x810.jpg");
	String TOPIC = "Basics";
	String IS_NEWS_OPTION = "false";

	@Test(groups = {"PUSHTest", "C349673"})
	@TestRail(id = "C349673")
	public void verifyPushLogin() {
		PushStartPage pushStartPage = SiteNavigatorEH.goToPushSelectProductPage();
		assertTrue(pushStartPage.isProductSelectFormVisible(), "Form for product selection should be visible");
		assertTrue(pushStartPage.isSelectButtonVisible(), "'Select' button should be visible");
		PushDashboardPage pushDashboardPage = pushStartPage.chooseEHProject().clickSelectButton();
		assertTrue(pushDashboardPage.isLeftNavMenuVisible(), "Left navigation menu should be visible");
		assertTrue(pushDashboardPage.isQuickLaunchBarVisible(), "Quick launch bar should be visible");
		assertEquals(pushDashboardPage.getLeftNavBarItemText(1), "EverydayHealth 2.0", "Text should be 'EverydayHealth 2.0' at the top of left menu");
	}

	@Test(groups = {"PUSHTest", "C349674"})
	@TestRail(id = "C349674")
	public void verifyArticleNewTestPageCreationPositive() {
		SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
		PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToPushCreateTestPage();

		Logger.info("Verify panels and mandatory fields are present");
		verifyFirstStepElements(pushCreateTestPage);

		Logger.info("Add values into mandatory fields");
		String pageName = "Automation test-page " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String templateId = "17201";
		String pageURL = pushCreateTestPage.getPageURLText();
		String category = pushCreateTestPage.getCategoryText(StringUtils.generateRandomIntInRange(2, 7));
		chooseTemplateAndCategory(pushCreateTestPage, templateId, pageName, category);
		String subcategory = pushCreateTestPage.getSubcategoryText(StringUtils.generateRandomIntInRange(2, 5));
		pushCreateTestPage.chooseSubcategoryFromDropdown(subcategory)
				.chooseIsNewsOption(IS_NEWS_OPTION)
				.clickSaveDraftButton();
		assertFalse(pushCreateTestPage.isErrorAlertVisible(), "Error alert should not appear");

		String headline = "Test headline " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String deck = "Test deck " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String body = generateBody();

		verifySecondStepElements(pushCreateTestPage);
		verifyArticleTabsOrder(pushCreateTestPage);
		fillPageContent(pushCreateTestPage, headline, deck, body);
		String keywords = pushCreateTestPage.getChosenTaxonomiesTreeConditionText();

		List<String> pushData = Arrays.asList(pageName,
				templateId,
				pushCreateTestPage.getChosenTemplateText(),
				headline,
				deck,
				body,
				TOPIC,
				category,
				subcategory,
				IS_NEWS_OPTION,
				keywords);

		publishPageAndVerifyResponseCode(pushCreateTestPage);

		Logger.info("Verify entered data is displayed on created page");
		ArticleNewTemplatePage articlePage = SiteNavigatorEH.openPage(pageURL.split(".com")[1] + "?nocache=true", ArticleNewTemplatePage.class);
		assertTrue(articlePage.isTitleVisible(), "Headline should be visible");
		assertTrue(articlePage.isDeckVisible(), "Deck should be visible");
		assertTrue(articlePage.isArticleBodyVisible(), "Article body should be visible");
		assertEquals(articlePage.getTitleText(), headline, "Headline text should be equal to the one added in PUSH");
		assertEquals(articlePage.getDeckText(), deck, "Deck text should be equal to the one added in PUSH");
		assertEquals(articlePage.getBodyText(), body, "Body text should be equal to the one added in PUSH");
		assertEquals(articlePage.getCategoryForPage(), category, "Category should be equal to the one added in PUSH");
		assertEquals(articlePage.getSubCategoryForPage(), subcategory, "Subcategory should be equal to the one added in PUSH");

		Logger.info("Verify correct data is saved in Content API");
		assertEquals(getContentAPIData(pageURL.split(".com")[1], true), pushData, "Data in content API differs from given in PUSH");
	}

	@Test(groups = {"PUSHTest", "C350096"})
	@TestRail(id = "C350096")
	public void verifyArticleNewTestPageCreationNegative() {
		SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
		PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToPushCreateTestPage();

		verifyErrorMessagesOnFirstStep(pushCreateTestPage, "17201");
		verifySecondStepElements(pushCreateTestPage);
		verifyErrorMessagesForArticleBasedTemplate(pushCreateTestPage);
	}

	@Test(groups = {"PUSHTest", "C350504"})
	@TestRail(id = "C350504")
	public void verifySlideshowNewTestPageCreationPositive() {
		SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();

		PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToPushCreateTestPage();

		Logger.info("Add values into mandatory fields");
		String pageName = "Automation test-page " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String pageURL = pushCreateTestPage.getPageURLText();
		String category = pushCreateTestPage.getCategoryText(StringUtils.generateRandomIntInRange(2, 7));
		String templateId = "17096"; //17096 is value for 'Slideshow 2.0' template
		chooseTemplateAndCategory(pushCreateTestPage, templateId, pageName, category);
		String subcategory = pushCreateTestPage.getSubcategoryText(StringUtils.generateRandomIntInRange(2, 5));
		PushEditSlideshowPage pushEditSlideshowPage = pushCreateTestPage.chooseSubcategoryFromDropdown(subcategory)
				.chooseIsNewsOption(IS_NEWS_OPTION)
				.clickSaveDraftButton(PushEditSlideshowPage.class);
		assertFalse(pushCreateTestPage.isErrorAlertVisible(), "Error alert should not appear");

		Logger.info("Verify additional section appeared after saving draft");
		assertEquals(pushEditSlideshowPage.getTemplateContentSectionTabText(1), "Hed, Dek, Byline", "1st tab should be 'Hed, Dek, Byline'");
		assertEquals(pushEditSlideshowPage.getTemplateContentSectionTabText(2), "Slides", "2nd tab should be 'Slides'");
		assertEquals(pushEditSlideshowPage.getTemplateContentSectionTabText(3), "Widgets", "3rd tab should be 'Widgets'");
		assertEquals(pushEditSlideshowPage.getTemplateContentSectionTabText(4), "Newsletter Promo", "4th tab should be 'Newsletter Promo'");

		String headline = "Test headline " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		pushEditSlideshowPage.typeHeadline(headline)
				.chooseLastUpdatedDateTime();
		pushEditSlideshowPage.clickSaveSlideshowButton();
		assertTrue(pushEditSlideshowPage.isSuccessAlertVisible(), "Success alert should be visible");
		pushEditSlideshowPage.clickTemplateContentSectionTab(2);
		assertTrue(pushEditSlideshowPage.isAddSlideButtonVisible(), "'Add Slide' button should be visible");
		int numberOfSlides = StringUtils.generateRandomIntInRange(2, 6);
		Logger.info("Page with " + numberOfSlides + " slides will be created");
		for (int slide = 1; slide <= numberOfSlides; slide++) {
			pushEditSlideshowPage.clickAddSlideButton();
			assertTrue(pushEditSlideshowPage.isSlideHedInputVisible(), "Slide 'Hed' input should be visible");
			assertTrue(pushEditSlideshowPage.isSlideImageURLInputVisible(), "Slide 'Url' input should be visible");
			assertTrue(pushEditSlideshowPage.isAltTextInputVisible(), "Slide 'Alt Text' input should be visible");
			assertTrue(pushEditSlideshowPage.isBodyTextareaVisible(), "'Slide copy' input should be visible");
			pushEditSlideshowPage.typeSlideHed("Slide test hed " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss));
			pushEditSlideshowPage.typeSlideImageURL(imagesList.get(StringUtils.generateRandomIntInRange(0, imagesList.size())));
			pushEditSlideshowPage.typeBody(generateBody());
			pushEditSlideshowPage.typeAltText("Slide test alt text " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss));
			pushEditSlideshowPage.clickSaveChangesButton();
		}
		assertTrue(pushEditSlideshowPage.isSlidesPreviewBlockVisible(), "Slide preview block should be visible");
		assertEquals(pushEditSlideshowPage.getNumberOfVisibleSlidesInPreview(), numberOfSlides, "Incorrect number of slides in preview");
		pushEditSlideshowPage.clickTopicsInput()
				.clickChooseTopic(TOPIC)
				.addItemToTaxonomiesTree()
				.clickPublishButton();
		assertTrue(pushCreateTestPage.isPublishConfirmationPopUpVisible(), "Confirmation pop up should appear");
		//'4' is value for 'Change Type' - 'Other'
		pushCreateTestPage.chooseChangeType("4")
				.typeConfirmationNotes("Automation test-page " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss))
				.clickConfirmationContinueButton();
		String keywords = pushCreateTestPage.getChosenTaxonomiesTreeConditionText();
		List<String> pushData = Arrays.asList(pageName,
				templateId,
				pushCreateTestPage.getChosenTemplateText(),
				headline,
				String.valueOf(numberOfSlides),
				TOPIC,
				category,
				subcategory,
				IS_NEWS_OPTION,
				keywords);
		Utils.waitFor(7000); //to get response
		assertTrue(isPostResponse200(), "Response code for 'http://push.qa1.everydayhealth.com/Page/Publish?environment=QA' should be '200'");

		Utils.waitFor(75000); //wait for 75 seconds for page to be available by URL
		Logger.info("Verify entered data is displayed on created page");
		SlideshowBasePage slideshowPage = SiteNavigatorEH.openPage(pageURL.split(".com")[1] + "?nocache=true", SlideshowBasePage.class);
		assertEquals(slideshowPage.getTitleText(), headline, "Incorrect headline");
		assertEquals(slideshowPage.getTotalSlideCount(), numberOfSlides, "Incorrect number of slides");
		assertEquals(slideshowPage.getCategoryForPage(), category, "Incorrect category");
		assertEquals(slideshowPage.getSubCategoryForPage(), subcategory, "Incorrect subcategory");
		for (int slide = 1; slide <= numberOfSlides; slide++) {
			assertTrue(slideshowPage.isSlideHeadlineVisible(), "Slide headline should be visible");
			assertTrue(slideshowPage.isSlideImageVisible(), "Slide image should be visible");
			assertTrue(slideshowPage.isSlideCopyVisible(slide), "Slide copy should be visible");
			assertTrue(slideshowPage.isSlideLastUpdatedDateVisible(), "Slide last updated date should be visible");
			if (numberOfSlides > 4 && slide == 4) {
				slideshowPage.skipInterstialAd();
			} else if (!slideshowPage.isLastSlide()) {
				slideshowPage.clickNextSlideArrow();
			}
		}
		Logger.info("Verify correct data is saved in Content API");
		assertEquals(getContentAPIData(pageURL.split(".com")[1], false), pushData, "Data in content API differs from given in PUSH");
	}

	@Test(groups = {"PUSHTest", "C373512"})
	@TestRail(id = "C373512")
	public void verifySlideshowNewTestPageCreationNegative() {
		SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();

		PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToPushCreateTestPage();
		verifyErrorMessagesOnFirstStep(pushCreateTestPage, "17096");

		PushEditSlideshowPage pushEditSlideshowPage = pushCreateTestPage.clickSaveDraftButton(PushEditSlideshowPage.class);
		Logger.info("Verify error messages for mandatory slideshow 2.0 fields");
		pushEditSlideshowPage.clearHeadlineInput();
		pushEditSlideshowPage.clearLastUpdatedInput();
		pushEditSlideshowPage.clickSaveSlideshowButton();
		assertTrue(pushEditSlideshowPage.isLastUpdatedErrorVisible(), "Error message should be visible under 'Last Updated' input");

		pushEditSlideshowPage.chooseLastUpdatedDateTime();
		pushEditSlideshowPage.clickSaveSlideshowButton();
		assertTrue(pushEditSlideshowPage.isSuccessAlertVisible(), "Success alert should appear");
		assertFalse(pushEditSlideshowPage.isLastUpdatedErrorVisible(), "Error message should not be visible under 'Last Updated' input");

		Logger.info("Verify error messages for slide creation");
		pushEditSlideshowPage.clickTemplateContentSectionTab(2);
		pushEditSlideshowPage.clickAddSlideButton();
		pushEditSlideshowPage.clickSaveChangesButton();
		assertTrue(pushEditSlideshowPage.isHeadlineErrorVisible(), "Error message should appear under 'Hed' input");
		assertTrue(pushEditSlideshowPage.isAltTextErrorVisible(), "Error message should appear under 'Alt text' input");
		assertFalse(pushEditSlideshowPage.isImageURLErrorMessageVisible(), "Error message for empty image 'URL' input should appear");
		assertTrue(pushEditSlideshowPage.isImageURLFormatErrorMessageVisible(), "Error message for invalid image URL format should not appear under 'Url' input");
		pushEditSlideshowPage.typeSlideHed("Test hed");
		pushEditSlideshowPage.clickSaveChangesButton();
		assertFalse(pushEditSlideshowPage.isHeadlineErrorVisible(), "Error message should not appear under 'Hed' input");
		assertTrue(pushEditSlideshowPage.isAltTextErrorVisible(), "Error message should appear under 'Alt text' input");
		assertTrue(pushEditSlideshowPage.isImageURLFormatErrorMessageVisible(), "Error message for invalid image URL format should not appear under 'Url' input");
		pushEditSlideshowPage.clearUrlInput();
		pushEditSlideshowPage.clickSaveChangesButton();
		assertFalse(pushEditSlideshowPage.isHeadlineErrorVisible(), "Error message should not appear under 'Hed' input");
		assertTrue(pushEditSlideshowPage.isAltTextErrorVisible(), "Error message should appear under 'Alt text' input");
		assertTrue(pushEditSlideshowPage.isImageURLErrorMessageVisible(), "Error message for empty image 'URL' input should not appear");
		assertFalse(pushEditSlideshowPage.isImageURLFormatErrorMessageVisible(), "Error message for invalid image URL format should appear under 'Url' input");
		pushEditSlideshowPage.typeSlideImageURL(imagesList.get(1));
		pushEditSlideshowPage.clickSaveChangesButton();
		assertFalse(pushEditSlideshowPage.isHeadlineErrorVisible(), "Error message should not appear under 'Hed' input");
		assertTrue(pushEditSlideshowPage.isAltTextErrorVisible(), "Error message should appear under 'Alt text' input");
		assertFalse(pushEditSlideshowPage.isImageURLErrorMessageVisible(), "Error message for empty image 'URL' input should not appear");
		assertFalse(pushEditSlideshowPage.isImageURLFormatErrorMessageVisible(), "Error message for invalid image URL format should not appear under 'Url' input");
		pushEditSlideshowPage.typeAltText(StringUtils.generateRandomStrAlphabetic(12));
		pushEditSlideshowPage.clickSaveChangesButton();
		assertFalse(pushEditSlideshowPage.isSlidePropertiesWindowVisible(), "Slide properties window should disappear");
		assertTrue(pushEditSlideshowPage.isSlidesPreviewBlockVisible(), "Slide preview block should appear");

		Logger.info("Verify error messages for Topics and Taxonomies tree");
		pushEditSlideshowPage.clickPublishButton();
		assertEquals(pushEditSlideshowPage.getNumberOfErrorAlerts(), 2, "2 error alerts should appear");
		assertEquals(pushEditSlideshowPage.getErrorAlertText(1), "Ad Taxonomy keyword is mandatory.", "Incorrect error alert text");
		assertEquals(pushEditSlideshowPage.getErrorAlertText(2), "Topics should be filled for this template.", "Incorrect error alert text");
		pushEditSlideshowPage.clickTopicsInput()
				.clickChooseTopic("Basics")
				.clickPublishButton();
		assertTrue(pushEditSlideshowPage.isErrorAlertVisible(), "Error alert should be visible");
		assertEquals(pushEditSlideshowPage.getErrorAlertText(), "Ad Taxonomy keyword is mandatory.", "Incorrect error alert text");
		pushEditSlideshowPage.addItemToTaxonomiesTree();
		pushEditSlideshowPage.clickPublishButton();
		//'2' is value for 'Change Type' - 'Minor'
		pushEditSlideshowPage.chooseChangeType("2")
				.typeConfirmationNotes("empty headline")
				.clickConfirmationContinueButton();
		assertTrue(pushEditSlideshowPage.isErrorAlertVisible(), "Error alert should appear");
		assertTrue(pushEditSlideshowPage.getErrorAlertText().endsWith("Content: The Headline field is required."), "Incorrect error message");
		pushEditSlideshowPage.clickTemplateContentSectionTab(1);
		pushEditSlideshowPage.typeHeadline("Test headline " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss));
		pushEditSlideshowPage.clickSaveSlideshowButton();
		assertTrue(pushEditSlideshowPage.isSuccessAlertVisible(), "Success alert should be visible");
		assertEquals(pushEditSlideshowPage.getSuccessAlertText(), "Article was successfully updated.", "Incorrect success alert text");
		assertFalse(pushEditSlideshowPage.isHeadlineErrorVisible(), "Error message should not be visible under 'Headline' input");
		assertFalse(pushEditSlideshowPage.isLastUpdatedErrorVisible(), "Error message should not be visible under 'Last Updated' input");
	}

	@Test(groups = {"PUSHTest", "C375017"})
	@TestRail(id = "C375017")
	public void verifyCusoArticleNewTestPageCreationPositive() {
		SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
		PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToPushCreateTestPage();

		String headline = "Test headline " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String deck = "Test deck " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String body = generateBody();
		Logger.info("Verify panels and mandatory fields are present");
		verifyFirstStepElements(pushCreateTestPage);

		Logger.info("Add values into mandatory fields");
		String pageName = "Automation test-page " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String pageURL = pushCreateTestPage.getPageURLText();
		String category = pushCreateTestPage.getCategoryText(StringUtils.generateRandomIntInRange(2, 7));
		String templateId = "17180";
		chooseTemplateAndCategory(pushCreateTestPage, templateId, pageName, category);
		String subcategory = pushCreateTestPage.getSubcategoryText(StringUtils.generateRandomIntInRange(2, 5));
		pushCreateTestPage.chooseSubcategoryFromDropdown(subcategory)
				.chooseIsNewsOption(IS_NEWS_OPTION)
				.clickSaveDraftButton();
		assertFalse(pushCreateTestPage.isErrorAlertVisible(), "Error alert should not appear");

		verifyArticleTabsOrder(pushCreateTestPage);
		fillPageContent(pushCreateTestPage, headline, deck, body);

		String keywords = pushCreateTestPage.getChosenTaxonomiesTreeConditionText();
		List<String> pushData = Arrays.asList(pageName,
				templateId,
				pushCreateTestPage.getChosenTemplateText(),
				headline,
				deck,
				body,
				TOPIC,
				category,
				subcategory,
				IS_NEWS_OPTION,
				keywords);

		publishPageAndVerifyResponseCode(pushCreateTestPage);

		CustomSolutionsTemplatePage cusoArticlePage = SiteNavigatorEH.openPage(pageURL.split(".com")[1] + "?nocache=true", CustomSolutionsTemplatePage.class);
		assertTrue(cusoArticlePage.isTitleVisible(), "Headline should be visible");
		assertTrue(cusoArticlePage.isDeckVisible(), "Deck should be visible");
		assertTrue(cusoArticlePage.isArticleBodyVisible(), "Article body should be visible");
		assertEquals(cusoArticlePage.getTitleText(), headline, "Headline text should be equal to the one added in PUSH");
		assertEquals(cusoArticlePage.getDeckText(), deck, "Deck text should be equal to the one added in PUSH");
		assertEquals(cusoArticlePage.getBodyText(), body, "Body text should be equal to the one added in PUSH");
		assertEquals(cusoArticlePage.getCategoryForPage(), category, "Category should be equal to the one added in PUSH");
		assertEquals(cusoArticlePage.getSubCategoryForPage(), subcategory, "Subcategory should be equal to the one added in PUSH");

		Logger.info("Verify correct data is saved in Content API");
		assertEquals(getContentAPIData(pageURL.split(".com")[1], true), pushData, "Data in content API differs from given in PUSH");
	}

	@Test(groups = {"PUSHTest", "C375047"})
	@TestRail(id = "C375047")
	public void verifyCusoArticleNewTestPageCreationNegative() {
		SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
		PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToPushCreateTestPage();

		verifyErrorMessagesOnFirstStep(pushCreateTestPage, "17180");
		verifySecondStepElements(pushCreateTestPage);
		verifyErrorMessagesForArticleBasedTemplate(pushCreateTestPage);
	}

	@Test(groups = {"PUSHTest", "C375292"})
	@TestRail(id = "C375292")
	public void verifyCusoArticleV3NewTestPageCreationPositive() {
		SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
		PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToPushCreateTestPage();

		String headline = "Test headline " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String deck = "Test deck " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String body = generateBody();
		Logger.info("Verify panels and mandatory fields are present");
		verifyFirstStepElements(pushCreateTestPage);

		Logger.info("Add values into mandatory fields");
		String pageName = "Automation test-page " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String pageURL = pushCreateTestPage.getPageURLText();
		String category = pushCreateTestPage.getCategoryText(StringUtils.generateRandomIntInRange(2, 7));
		String templateId = "17217";
		chooseTemplateAndCategory(pushCreateTestPage, templateId, pageName, category);
		String subcategory = pushCreateTestPage.getSubcategoryText(StringUtils.generateRandomIntInRange(2, 5));
		pushCreateTestPage.chooseSubcategoryFromDropdown(subcategory)
				.chooseIsNewsOption(IS_NEWS_OPTION)
				.clickSaveDraftButton();
		assertFalse(pushCreateTestPage.isErrorAlertVisible(), "Error alert should not appear");

		verifyArticleTabsOrder(pushCreateTestPage);
		fillPageContent(pushCreateTestPage, headline, deck, body);

		String keywords = pushCreateTestPage.getChosenTaxonomiesTreeConditionText();
		List<String> pushData = Arrays.asList(pageName,
				templateId,
				pushCreateTestPage.getChosenTemplateText(),
				headline,
				deck,
				body,
				TOPIC,
				category,
				subcategory,
				IS_NEWS_OPTION,
				keywords);

		publishPageAndVerifyResponseCode(pushCreateTestPage);

		CusoArticleV3Page cusoArticleV3Page = SiteNavigatorEH.openPage(pageURL.split(".com")[1] + "?nocache=true", CusoArticleV3Page.class);
		assertTrue(cusoArticleV3Page.isTitleVisible(), "Headline should be visible");
		assertTrue(cusoArticleV3Page.isDeckVisible(), "Deck should be visible");
		assertTrue(cusoArticleV3Page.isArticleBodyVisible(), "Article body should be visible");
		assertEquals(cusoArticleV3Page.getTitleText(), headline, "Headline text should be equal to the one added in PUSH");
		assertEquals(cusoArticleV3Page.getDeckText(), deck, "Deck text should be equal to the one added in PUSH");
		assertTrue(cusoArticleV3Page.getBodyText().contains(body), "Body text should contain the one added in PUSH");
		assertEquals(cusoArticleV3Page.getCategoryForPage(), category, "Category should be equal to the one added in PUSH");
		assertEquals(cusoArticleV3Page.getSubCategoryForPage(), subcategory, "Subcategory should be equal to the one added in PUSH");

		Logger.info("Verify correct data is saved in Content API");
		assertEquals(getContentAPIData(pageURL.split(".com")[1], true), pushData, "Data in content API differs from given in PUSH");
	}

	@Test(groups = {"PUSHTest", "C375293"})
	@TestRail(id = "C375293")
	public void verifyCusoArticleV3NewTestPageCreationNegative() {
		SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
		PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToPushCreateTestPage();

		verifyErrorMessagesOnFirstStep(pushCreateTestPage, "17217");
		verifySecondStepElements(pushCreateTestPage);
		verifyErrorMessagesForArticleBasedTemplate(pushCreateTestPage);
	}

	@Test(groups = {"PUSHTest", "C375339"})
	@TestRail(id = "C375339")
	public void verifyLifehacksNewTestPageCreationPositive() {
		SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
		PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToPushCreateTestPage();

		Logger.info("Verify panels and mandatory fields are present");
		verifyFirstStepElements(pushCreateTestPage);

		Logger.info("Add values into mandatory fields");
		String pageName = "Automation test-page " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String pageURL = pushCreateTestPage.getPageURLText();
		String category = "Arthritis";
		String templateId = "17213";
		chooseTemplateAndCategory(pushCreateTestPage, templateId, pageName, category);

		String subcategory = "Rheumatoid Arthritis";
		PushEditLifehacksPage pushEditLifehacksPage = pushCreateTestPage.chooseSubcategoryFromDropdown(subcategory)
				.chooseIsNewsOption(IS_NEWS_OPTION)
				.clickSaveDraftButton(PushEditLifehacksPage.class);
		assertFalse(pushCreateTestPage.isErrorAlertVisible(), "Error alert should not appear");

		String headline = "Test headline " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);
		String deck = "Test deck " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss);

		assertEquals(pushEditLifehacksPage.getTemplateContentSectionTabText(1), "Article Info", "1st tab should be 'Article Info'");
		assertEquals(pushEditLifehacksPage.getTemplateContentSectionTabText(2), "Hero Section", "2nd tab should be 'Hero Section'");
		assertEquals(pushEditLifehacksPage.getTemplateContentSectionTabText(3), "Content Pinning", "3rd tab should be 'Content Pinning'");
		assertEquals(pushEditLifehacksPage.getTemplateContentSectionTabText(4), "Mini Guide", "4th tab should be 'Mini Guide'");
		assertEquals(pushEditLifehacksPage.getTemplateContentSectionTabText(5), "Tips", "5th tab should be 'Tips'");
		assertEquals(pushEditLifehacksPage.getTemplateContentSectionTabText(6), "Videos", "6th tab should be 'Videos'");

		Logger.info("Fill 'Headline' and 'Deck' inputs and save article");
		pushEditLifehacksPage.typeHeadline(headline).typeDeck(deck).chooseLastUpdatedDateTime().clickSaveArticleButton();

		pushEditLifehacksPage.clickTemplateContentSectionTab(2);
		pushEditLifehacksPage.clickHeroSectionLinkPanel();
		pushEditLifehacksPage.typeHeroTitle(headline);
		pushEditLifehacksPage.typeHeroUrl("//www.everydayhealth.com");
		pushEditLifehacksPage.typeHeroImageUrl("//images.agoramedia.com/everydayhealth/gcms/life-hacks-RA-beach-dog-walk-1440x810.jpg");
		pushEditLifehacksPage.clickHeroSectionSaveButton();

		pushEditLifehacksPage.clickTemplateContentSectionTab(3);
		int numberOfCards = StringUtils.generateRandomIntInRange(3, 6);
		pushEditLifehacksPage.typeContentPinningSectionTitle("Test title " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss));
		for (int card = 0; card < numberOfCards; card++) {
			pushEditLifehacksPage.clickContentCard(card + 1);
			pushEditLifehacksPage.typeCardTitle("Test title " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss), String.valueOf(card));
			pushEditLifehacksPage.typeCardImageURL(imagesList.get(card), String.valueOf(card));
			pushEditLifehacksPage.typeCardUrl("//www.everydayhealth.com", String.valueOf(card));
			pushEditLifehacksPage.typeCardDeck("Test deck" + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss), String.valueOf(card));
			pushEditLifehacksPage.typeCardContentType("article", String.valueOf(card));
			pushEditLifehacksPage.typeCardPosition(String.valueOf(card + 1), String.valueOf(card));
		}
		pushEditLifehacksPage.clickContentPinningSectionSaveButton();

		pushEditLifehacksPage.clickTemplateContentSectionTab(4);
		int numberOfMiniGuideCards = StringUtils.generateRandomIntInRange(3, 5);
		pushEditLifehacksPage.typeMiniGuideSectionTitle("Test title " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss));
		for (int card = 0; card < numberOfMiniGuideCards; card++) {
			pushEditLifehacksPage.clickMiniGuideLink(card + 1);
			pushEditLifehacksPage.typeLinkImageUrl(imagesList.get(card), String.valueOf(card));
			pushEditLifehacksPage.typeLinkTitle("Test title " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss), String.valueOf(card));
			pushEditLifehacksPage.typeLinkUrl("//www.everydayhealth.com", String.valueOf(card));
			pushEditLifehacksPage.typeLinkPosition(String.valueOf(card + 1), String.valueOf(card));
		}
		pushEditLifehacksPage.clickMiniGuideSectionSaveButton();

		pushEditLifehacksPage.clickTemplateContentSectionTab(5);
		pushEditLifehacksPage.clickTip(1);
		pushEditLifehacksPage.typeTipTitle("Tip title " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss), "0");
		pushEditLifehacksPage.typeTipText("Tip text " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss), "0");
		pushEditLifehacksPage.typeTipAutor("Tip author", "0");
		pushEditLifehacksPage.typeTipActionLink("//www.everydayhealth.com", "0");
		pushEditLifehacksPage.typeTipActionLinkText("Read more", "0");
		pushEditLifehacksPage.typeTipPosition("1", "0");
		pushEditLifehacksPage.clickTipsSectionSaveButton();

		pushEditLifehacksPage.addItemToTaxonomiesTree();
		pushEditLifehacksPage.clickSaveDraftButton();
		publishPageAndVerifyResponseCode(pushEditLifehacksPage);


		Utils.waitFor(120000);
		LifehackPage lifehackPage = SiteNavigatorEH.openPage(pageURL.split(".com")[1] + "?nocache=true", LifehackPage.class);
		assertTrue(lifehackPage.isTitleVisible(), "Headline should be visible");
		assertTrue(lifehackPage.isDeckVisible(), "Deck should be visible");
		assertEquals(lifehackPage.getNumberOfArticleCards(), numberOfCards, "Incorrect number of cards");
		lifehackPage.scrollDownThePage();
		assertEquals(lifehackPage.getNumberOfArticleCardImages(), numberOfCards, "All cards should have images");
		assertEquals(lifehackPage.getNumberOfArticleCardTitles(), numberOfCards, "All cards should have titles");
		assertEquals(lifehackPage.getNumberOfArticleCardTypeIcons(), numberOfCards, "All cards should have type icons");
		assertEquals(lifehackPage.getNumberOfMiniGuideCards(), numberOfMiniGuideCards, "Incorrect number of mini guide cards");
		assertEquals(lifehackPage.getNumberOfMiniGuideCardsImages(), numberOfMiniGuideCards, "All cards should have images");
		assertEquals(lifehackPage.getNumberOfMiniGuideCardsTitles(), numberOfMiniGuideCards, "All cards should have titles");
		assertEquals(lifehackPage.getNumberOfTipCards(), 1, "Only 1 tip card should be visible");
		assertEquals(lifehackPage.getCategoryForPage(), category, "Category should be equal to the one added in PUSH");
		assertEquals(lifehackPage.getSubCategoryForPage(), subcategory, "Subcategory should be equal to the one added in PUSH");
	}

	@Test(groups = {"PUSHTest", "C375454"})
	@TestRail(id = "C375454")
	public void verifyLifehacksNewTestPageCreationNegative() {
		SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
		PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToPushCreateTestPage();

		verifyErrorMessagesOnFirstStep(pushCreateTestPage, "17213");
		verifySecondStepElements(pushCreateTestPage);
		verifyErrorMessagesForArticleBasedTemplate(pushCreateTestPage);
	}

	private boolean isPostResponse200() {
		LogEntries les = WebDriverManager.getDriver().manage().logs().get(LogType.PERFORMANCE);
		boolean isResponse200 = false;
		Logger.info("Filter 'Network' tab log messages");
		for (LogEntry le : les) {
			String logMessage = le.toString();
			if (logMessage.contains("http://push.staging.everydayhealth.com/Page/Publish?environment=Staging") &&
					logMessage.contains("Network.responseReceived")) {
				JsonParser jsonParser = new JsonParser();
				String responseCode = jsonParser.parse(le.getMessage()).getAsJsonObject().get("message").getAsJsonObject().get("params").getAsJsonObject().get("response").getAsJsonObject().get("status").getAsString();
				Logger.info("Response code is - " + responseCode);
				if ("200".equals(responseCode)) {
					isResponse200 = true;
				}
			}
		}
		return isResponse200;
	}

	private String generateBody() {
		StringBuilder body = new StringBuilder("Test body\n");
		for (int cycle = 1; cycle <= 5; cycle++) {
			body.append(DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss) + "\n");
		}
		body.append(StringUtils.generateRandomStrAlphabetic(60));
		return body.toString();
	}

	private void verifyFirstStepElements(PushEditPageBasePage pushCreateTestPage) {
		assertTrue(pushCreateTestPage.isSaveDraftButtonVisible(), "'Save Draft' button should be visible");
		assertTrue(pushCreateTestPage.isShareBarVisible(), "Share bar panel should be visible");
		assertTrue(pushCreateTestPage.isPageInfoBlockVisible(), "'Page Information' panel should be visible");
		assertEquals(pushCreateTestPage.getNumberOfTabsInPageContentSection(), 4, "4 tabs should be visible in 'Page Information' block");
		assertTrue(pushCreateTestPage.isTemplateDropdownVisible(), "'Page Template' dropdown should be visible");
		assertTrue(pushCreateTestPage.isPageNameInputVisible(), "'Page Name' input should be visible");
		assertTrue(pushCreateTestPage.isPageURLVisible(), "Page 'URL' should be visible");
		assertTrue(pushCreateTestPage.isEditURLButtonVisible(), "'Edit' button should be visible");
		assertTrue(pushCreateTestPage.isPageContentSectionVisible(), "Page content panel should be visible");
		assertTrue(pushCreateTestPage.isCategorizationBlockVisible(), "'Categorization' block should be visible");
		assertTrue(pushCreateTestPage.isCategoryDropdownVisible(), "'Category' dropdown should be visible");
		assertTrue(pushCreateTestPage.isSubcategoryDropdownVisible(), "'Subcategory' dropdown should be visible");
		assertTrue(pushCreateTestPage.isBlockIsNewsVisible(), "'Is News' block should be visible");
		assertTrue(pushCreateTestPage.isIsNewsDropdownVisible(), "'Is News' dropdown should be visible");
	}

	private void verifySecondStepElements(PushEditPageBasePage pushCreateTestPage) {
		assertTrue(pushCreateTestPage.isContentSectionVisible(), "Content section should be visible");
		assertTrue(pushCreateTestPage.isHeadlineInputVisible(), "'Headline' input should be visible");
		assertTrue(pushCreateTestPage.isDeckInputVisible(), "'Deck' input should be visible");
		assertTrue(pushCreateTestPage.isBodyTextareaVisible(), "'Body' textarea should be visible");
		assertTrue(pushCreateTestPage.isLastUpdatedInputVisible(), "'Last updated' input should be visible");
		assertTrue(pushCreateTestPage.isTopicsSectionVisible(), "'Topics' section should be visible");
		assertTrue(pushCreateTestPage.isAdTaxonomiesSectionVisible(), "'Ad Taxonomies' section should be visible");
		assertTrue(pushCreateTestPage.isTaxonomiesTreeVisible(), "Taxonomies tree should be visible");
		assertTrue(pushCreateTestPage.isPublishButtonVisible(), "'Publish' button should be visible");
	}

	private void verifyErrorMessagesOnFirstStep(PushEditPageBasePage pushCreateTestPage, String templateCode) {
		verifyFirstStepElements(pushCreateTestPage);
		Logger.info("Verify error messages for elements that are required to save draft");
		pushCreateTestPage.clearPageNameInput();
		pushCreateTestPage.clickSaveDraftButton();
		assertTrue(pushCreateTestPage.isPageNameErrorMessageVisible(), "Error message should appear under 'Page Name' input");
		assertTrue(pushCreateTestPage.isErrorAlertVisible(), "Error alert should be visible");
		assertEquals(pushCreateTestPage.getErrorAlertText(), "Please specify if your content \"Is News\"", "Error text is incorrect");
		assertTrue(pushCreateTestPage.isIsNewsErrorVisible(), "Error message should appear under 'Is News' dropdown");
		assertTrue(pushCreateTestPage.isCategoryErrorVisible(), "Error message should appear under 'Category' dropdown");
		assertTrue(pushCreateTestPage.isSubcategoryErrorVisible(), "Error message should appear under 'Subcategory' dropdown");
		pushCreateTestPage.chooseIsNewsOption("false").clickSaveDraftButton();
		assertFalse(pushCreateTestPage.isIsNewsErrorVisible(), "Error message should not appear under 'Is News' dropdown");
		assertTrue(pushCreateTestPage.isCategoryErrorVisible(), "Error message should appear under 'Category' dropdown");
		assertTrue(pushCreateTestPage.isSubcategoryErrorVisible(), "Error message should appear under 'Subcategory' dropdown");
		assertTrue(pushCreateTestPage.isPageNameErrorMessageVisible(), "Error message should appear under 'Page Name' input");
		String category = pushCreateTestPage.getCategoryText(StringUtils.generateRandomIntInRange(2, 7));
		pushCreateTestPage.chooseCategoryFromDropdown(category).clickSaveDraftButton();
		assertFalse(pushCreateTestPage.isIsNewsErrorVisible(), "Error message should not appear under 'Is News' dropdown");
		assertFalse(pushCreateTestPage.isCategoryErrorVisible(), "Error message should not appear under 'Category' dropdown");
		assertTrue(pushCreateTestPage.isSubcategoryErrorVisible(), "Error message should appear under 'Subcategory' dropdown");
		assertTrue(pushCreateTestPage.isPageNameErrorMessageVisible(), "Error message should appear under 'Page Name' input");
		String subcategory = pushCreateTestPage.getSubcategoryText(StringUtils.generateRandomIntInRange(2, 5));
		pushCreateTestPage.chooseSubcategoryFromDropdown(subcategory).clickSaveDraftButton();
		assertFalse(pushCreateTestPage.isIsNewsErrorVisible(), "Error message should not appear under 'Is News' dropdown");
		assertFalse(pushCreateTestPage.isCategoryErrorVisible(), "Error message should not appear under 'Category' dropdown");
		assertFalse(pushCreateTestPage.isSubcategoryErrorVisible(), "Error message should not appear under 'Subcategory' dropdown");
		assertTrue(pushCreateTestPage.isPageNameErrorMessageVisible(), "Error message should appear under 'Page Name' input");
		pushCreateTestPage.clickSaveDraftButton();
		pushCreateTestPage.typePageName("Automation test page").clickSaveDraftButton();
		assertFalse(pushCreateTestPage.isPageNameErrorMessageVisible(), "Error message should not appear under 'Page Name' input");
		pushCreateTestPage.clickSaveDraftButton();
		assertTrue(pushCreateTestPage.isErrorAlertVisible(), "Error alert should be visible");
		assertTrue(pushCreateTestPage.getErrorAlertText().contains("The INSERT statement conflicted with the FOREIGN KEY constraint \"FK_Page_Template1\""), "Error text is incorrect");
		pushCreateTestPage.chooseTemplateFromDropdown(templateCode).clickSaveDraftButton();
	}

	private void fillPageContent(PushEditPageBasePage pushCreateTestPage,
								 String headline,
								 String deck,
								 String body) {

		Logger.info("Add Topic");
		pushCreateTestPage.clickTopicsInput()
				.clickChooseTopic(TOPIC)
				.addItemToTaxonomiesTree();

		Logger.info("Add headline, deck, body, last updated values and save article");
		pushCreateTestPage.typeHeadline(headline)
				.typeDeck(deck)
				.typeBody(body)
				.chooseLastUpdatedDateTime()
				.clickSaveArticleButton();
	}

	private void verifyArticleTabsOrder(PushEditPageBasePage pushCreateTestPage) {
		Logger.info("Verify additional section appeared after saving draft");
		assertEquals(pushCreateTestPage.getTemplateContentSectionTabText(1), "Article", "1st tab should be 'Article'");
		assertEquals(pushCreateTestPage.getTemplateContentSectionTabText(2), "Bylines", "2nd tab should be 'Bylines'");
		assertEquals(pushCreateTestPage.getTemplateContentSectionTabText(3), "Media", "3rd tab should be 'Media'");
		assertEquals(pushCreateTestPage.getTemplateContentSectionTabText(4), "Widgets", "4th tab should be 'Widgets'");
		assertEquals(pushCreateTestPage.getTemplateContentSectionTabText(5), "Newsletter Promo", "5th tab should be 'Newsletter Promo'");
	}

	private void chooseTemplateAndCategory(PushEditPageBasePage pushCreateTestPage,
										   String templateId,
										   String pageName,
										   String category) {
		pushCreateTestPage.chooseTemplateFromDropdown(templateId)
				.typePageName(pageName)
				.chooseCategoryFromDropdown(category);
	}

	private void publishPageAndVerifyResponseCode(PushEditPageBasePage pushCreateTestPage) {
		pushCreateTestPage.clickPublishButton();

		assertTrue(pushCreateTestPage.isPublishConfirmationPopUpVisible(), "Confirmation pop up should appear");
		//'4' is value for 'Change Type' - 'Other'
		pushCreateTestPage.chooseChangeType("4")
				.typeConfirmationNotes("Automation test-page " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss))
				.clickConfirmationContinueButton();
		//Timeout to get response
		Utils.waitFor(7000);
		assertTrue(isPostResponse200(), "Response code for 'http://push.staging.everydayhealth.com/Page/Publish?environment=Staging' should be '200'");

		//Timeout for page to be available by URL
		Utils.waitFor(100000);
	}

	private void verifyErrorMessagesForArticleBasedTemplate(PushEditPageBasePage pushCreateTestPage) {
		Logger.info("Verify error messages for mandatory article 3.0 fields");
		pushCreateTestPage.clearHeadlineInput();
		pushCreateTestPage.clearLastUpdatedInput();
		pushCreateTestPage.clickSaveArticleButton();
		assertTrue(pushCreateTestPage.isHeadlineErrorVisible(), "Error message should be visible under 'Headline' input");
		assertTrue(pushCreateTestPage.isLastUpdatedErrorVisible(), "Error message should be visible under 'Last Updated' input");
		pushCreateTestPage.typeHeadline("Test headline " + DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss))
				.clickSaveArticleButton();
		assertFalse(pushCreateTestPage.isHeadlineErrorVisible(), "Error message should not be visible under 'Headline' input");
		assertTrue(pushCreateTestPage.isLastUpdatedErrorVisible(), "Error message should be visible under 'Last Updated' input");
		pushCreateTestPage.chooseLastUpdatedDateTime()
				.clickSaveArticleButton()
				.clickPublishButton();
		assertTrue(pushCreateTestPage.isSuccessAlertVisible(), "Success alert should be visible");
		assertEquals(pushCreateTestPage.getSuccessAlertText(), "Article has been successfully saved", "Incorrect success alert text");
		assertFalse(pushCreateTestPage.isHeadlineErrorVisible(), "Error message should not be visible under 'Headline' input");
		assertFalse(pushCreateTestPage.isLastUpdatedErrorVisible(), "Error message should not be visible under 'Last Updated' input");

		Logger.info("Verify error messages for Topics and Taxonomies tree");
		pushCreateTestPage.clickPublishButton();

		String template = pushCreateTestPage.getChosenTemplateText();
		if (template.equals("Article 3.0") || template.equals("Slideshow 2.0")) {
			assertEquals(pushCreateTestPage.getNumberOfErrorAlerts(), 2, "2 error alerts should appear");
			assertEquals(pushCreateTestPage.getErrorAlertText(1), "Ad Taxonomy keyword is mandatory.", "Incorrect error alert text");
			assertEquals(pushCreateTestPage.getErrorAlertText(2), "Topics should be filled for this template.", "Incorrect error alert text");
			pushCreateTestPage.clickTopicsInput()
					.clickChooseTopic("Basics")
					.clickPublishButton();
			assertTrue(pushCreateTestPage.isErrorAlertVisible(), "Error alert should be visible");
			assertEquals(pushCreateTestPage.getErrorAlertText(), "Ad Taxonomy keyword is mandatory.", "Incorrect error alert text");
		} else {
			assertTrue(pushCreateTestPage.isErrorAlertVisible(), "Error alert should be visible");
			assertEquals(pushCreateTestPage.getErrorAlertText(1), "Ad Taxonomy keyword is mandatory.", "Incorrect error alert text");
		}
		pushCreateTestPage.addItemToTaxonomiesTree().clickPublishButton();
		assertFalse(pushCreateTestPage.isErrorAlertVisible(), "Error alert should not be visible");
		assertTrue(pushCreateTestPage.isPublishConfirmationPopUpVisible(), "Confirmation pop up for publish should appear");
	}

	private List<String> getContentAPIData(String url, boolean isArticle) {
		WebDriver driver = WebDriverManager.getDriver();
		driver.get("http://services.everydayhealth.com/ContentAPI/api/Content/V1/277/getPage?maskUrl=~" + url);
		String json = driver.findElement(By.cssSelector("body")).getText();

		JsonParser jsonParser = new JsonParser();
		JsonElement jsonText = jsonParser.parse(json);

		String pageName = jsonText.getAsJsonObject().get("PageName").getAsString();
		String templateId = jsonText.getAsJsonObject().get("TemplateDetail").getAsJsonObject().get("TemplateId").getAsString();
		String templateName = jsonText.getAsJsonObject().get("TemplateDetail").getAsJsonObject().get("TemplateName").getAsString();

		JsonElement contentJson = jsonText.getAsJsonObject().get("Content");
		String headline = contentJson.getAsJsonObject().get("Headline").getAsString();
		String deck = "";
		String body = "";
		String slidesCount = "";
		if (isArticle) {
			deck = contentJson.getAsJsonObject().get("Deck").getAsString();
			body = contentJson.getAsJsonObject().get("Body").getAsString();
			/**
			 * This line removes all <p>, </p> tags, \\r and &nbsp; symbols
			 */
			body = body.replaceAll("\\n<p>&nbsp;</p>", "").replaceAll("<p>", "").replaceAll("</p>\\r", "");
		} else {
			JsonArray slidesArray = contentJson.getAsJsonObject().getAsJsonArray("Slides");
			int numberOfSlides = slidesArray.size();
			for (int slideNumber = 0; slideNumber < numberOfSlides; slideNumber++) {
				assertFalse(slidesArray.get(0).getAsJsonObject().get("Headline").getAsString().isEmpty(), "Slide headline should not be empty in ContentAPI");
				assertFalse(slidesArray.get(0).getAsJsonObject().get("Body").getAsString().isEmpty(), "Slide body should not be empty in ContentAPI");
				assertEquals(slidesArray.get(0).getAsJsonObject().getAsJsonArray("Media").get(0).getAsJsonObject().get("Type").getAsString(), "Image", "Image should be present for slide");
			}
			slidesCount = String.valueOf(numberOfSlides);
		}

		JsonArray attributesArray = jsonText.getAsJsonObject().getAsJsonArray("Attributes");
		/**
		 * In case category or subcategory does not have URL indexes should be reduced by 1
		 */
		boolean isSubcategoryURLPresent = attributesArray.get(2).getAsJsonObject().get("Attribute").getAsString().equals("TopicId");
		int topicIdIndex = isSubcategoryURLPresent ? 2 : 1;
		int categoryIndex = isSubcategoryURLPresent ? 3 : 2;
		int subCategoryIndex = isSubcategoryURLPresent ? 5 : 4;
		int isNewsIndex = isSubcategoryURLPresent ? 7 : 6;

		assertEquals(attributesArray.get(topicIdIndex).getAsJsonObject().get("Attribute").getAsString(), "TopicId");
		String topics = attributesArray.get(topicIdIndex).getAsJsonObject().get("AttributeSourceValue").getAsString();
		assertEquals(attributesArray.get(categoryIndex).getAsJsonObject().get("Attribute").getAsString(), "Category");
		String category = attributesArray.get(categoryIndex).getAsJsonObject().get("Value").getAsString();
		assertEquals(attributesArray.get(subCategoryIndex).getAsJsonObject().get("Attribute").getAsString(), "Sub-Category");
		String subCategory = attributesArray.get(subCategoryIndex).getAsJsonObject().get("Value").getAsString();
		assertEquals(attributesArray.get(isNewsIndex).getAsJsonObject().get("Attribute").getAsString(), "IsNews");
		String isNews = attributesArray.get(isNewsIndex).getAsJsonObject().get("Value").getAsString();

		String keywords = jsonText.getAsJsonObject().get("Keyword").getAsString();

		if (isArticle) {
			return Arrays.asList(pageName, templateId, templateName, headline, deck, body, topics, category, subCategory, isNews, keywords);
		} else {
			return Arrays.asList(pageName, templateId, templateName, headline, slidesCount, topics, category, subCategory, isNews, keywords);
		}
	}
}
