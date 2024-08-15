package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.EHPublicPage;
import everydayhealth.pages.PublicFooterZD;
import everydayhealth.pages.drugs.DrugsLandingPage;
import everydayhealth.pages.registrations.ToolsRegistrationPage;
import everydayhealth.pages.tools.CalorieCounterPage;
import everydayhealth.pages.tools.MealPlannerPage;
import everydayhealth.pages.tools.NewslettersPage;
import everydayhealth.pages.tools.RecipesPage;
import everydayhealth.pages.tools.SymptomCheckerPage;
import framework.Logger;
import framework.Settings;
import framework.platform.CookieName;
import framework.platform.DatePatterns;
import framework.platform.SiteNavigatorEH;
import framework.platform.UserCacheEH;
import framework.platform.UserEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.DateUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * HomePageTest
 */
public class HomePageTest extends WidgetsBaseTest {

	UserEH user = UserCacheEH.MAIN_USER;

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HomePage", "C190525"})
	@TestRail(id = "C190525")
	public void verifyPrimaryLeadCarousel() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		Logger.info("Verifying the 'Primary Lead' carousel scroll functionality");

		assertTrue(ehPublicPage.isPrimaryLeadSectionVisible(), "'Primary lead section' should be visible");
		assertTrue(ehPublicPage.getNumberOfPrimaryLeads() <= 6, "Number of primary leads should not be more than 6");
		assertEquals(ehPublicPage.getNumberOfPrimaryLeads(), ehPublicPage.getNumberOfPrimaryLeadDotControls(), "Count of lead items and dot controls should be equal");
		assertEquals(ehPublicPage.getNumberOfPrimaryLeadImages(), ehPublicPage.getNumberOfPrimaryLeadTitles(), "Count of images and titles should be equal");

		if (Settings.isDesktop()) {
			Logger.info("Verifying the 'Primary Lead' manual scroll feature using next slider button");
			primaryLeadManualScroll(ehPublicPage, "usingNextSlider");
			primaryLeadManualScroll(ehPublicPage, "usingDotControls");

			Logger.info("Verifying the 'Primary Lead' auto scroll feature");
			if (ehPublicPage.getNumberOfPrimaryLeads() > 1) {
				Logger.info("Clicking on first primary lead control dot");
				ehPublicPage.clickPrimaryLeadControlDot(1);
				assertTrue(ehPublicPage.isPrimaryLeadActive(1), "First Primary lead not active");
				ehPublicPage.onHeaderCCR().moveToLogo();
				assertTrue(ehPublicPage.verifyPrimaryLeadAutoscrollFeature(), "Primary lead autoscroll feature failed");
			}
		} else {
			primaryLeadManualScroll(ehPublicPage, "usingDotControls");
		}

		if (!Settings.isMobile()) {
			Logger.info("Verifying Primary Lead date feature");
			String primaryLeadDate = ehPublicPage.getPrimaryLeadDate();
			assertEquals(primaryLeadDate, DateUtils.getCurrentDate(DatePatterns.EEEE_MMMMMMMMM_dd), "Incorrect Primary lead date");
		}
	}

	private void primaryLeadManualScroll(EHPublicPage ehPublicPage, String option) {
		int primaryLeadsCount = ehPublicPage.getNumberOfPrimaryLeads();
		if (primaryLeadsCount > 1) {
			Logger.info("Clicking on first primary lead control dot");
			ehPublicPage.clickPrimaryLeadControlDot(1);
			assertTrue(ehPublicPage.isPrimaryLeadActive(1), "First Primary lead not active");

			for (int elementNumber = 1; elementNumber <= primaryLeadsCount; elementNumber++) {
				String primaryLeadActiveTitle = ehPublicPage.getPrimaryLeadActiveTitle();
				assertTrue(ehPublicPage.isPrimaryLeadActive(elementNumber), "Primary lead not active");

				if (option.contains("usingNextSlider")) {
					ehPublicPage.clickPrimaryLeadNextSlider();
				} else {
					if (elementNumber == primaryLeadsCount) {
						ehPublicPage.clickPrimaryLeadControlDot(1);
					} else {
						ehPublicPage.clickPrimaryLeadControlDot(elementNumber + 1);
					}
				}
				String nextPrimaryLeadActiveTitle = ehPublicPage.getPrimaryLeadActiveTitle();
				assertNotEquals(primaryLeadActiveTitle, nextPrimaryLeadActiveTitle, "After we click next slider - primary lead title should be changed");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HomePage", "C189507"})
	@TestRail(id = "C189507")
	public void verifyColumnistCarousel() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		Logger.info("Verifying the 'Columnist' carousel scroll functionality");
		assertTrue(ehPublicPage.isColumnistsSectionVisible(), "'Columnists section' should be visible");
		if (ehPublicPage.getNumberOfColumnists() > ehPublicPage.getNumberOfVisibleColumnists()) {
			assertTrue(ehPublicPage.isColumnistsPreviousSliderVisible(), "Columnists 'previous' button should be visible");
			assertTrue(ehPublicPage.isColumnistsNextSliderVisible(), "Columnists 'next' button should be visible");
			for (int elementNumber = 0; elementNumber < ehPublicPage.getNumberOfColumnists() / getNumberOfExpectedColumnists(); elementNumber++) {
				String firstColumnistTitle = ehPublicPage.getColumnisTitle(ehPublicPage.getFirstVisibleColumnistsNumber());
				assertEquals(ehPublicPage.getNumberOfVisibleColumnists(), getNumberOfExpectedColumnists(), "There should be " + getNumberOfExpectedColumnists() + " visible on " + Settings.getPlatform());
				ehPublicPage.clickColumnistNextSlider();
				String firstColumnistTitleNextBlock = ehPublicPage.getColumnisTitle(ehPublicPage.getFirstVisibleColumnistsNumber());
				assertNotEquals(firstColumnistTitle, firstColumnistTitleNextBlock, "After we open next block - text should be changed");
			}
		}
	}

	private int getNumberOfExpectedColumnists() {
		if (Settings.isDesktop()) {
			return 3;
		} else if (Settings.isTablet()) {
			return 2;
		} else return 1;
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "HomePage", "C179100"})
	@TestRail(id = "C179100")
	public void toolsNewsletters() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		Logger.info("Verifying 'Newsletter' sign up form with logged out user");
		assertEquals(ehPublicPage.getNumberOfToolsImageSprites(), 6, "All 6 tools images should be visible");
		NewslettersPage newslettersPage = ehPublicPage.clickToolsNewsletters();
		assertTrue(newslettersPage.isNewslettersTitleVisible(), "Newsletters title should be visible");
		assertEquals(newslettersPage.getNumberOfSteps(), 2, "2 subscribe steps should be visible");
		assertTrue(newslettersPage.isNewslettersOptionsHeadingVisible(), "Newsletters heading should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "HomePage", "C168834"})
	@TestRail(id = "C168834")
	public void toolsCalorieCounter() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		Logger.info("Verifying 'Calorie Counter' sign up form with logged out user");
		assertEquals(ehPublicPage.getNumberOfToolsImageSprites(), 6, "All 6 tools images should be visible");
		ToolsRegistrationPage calorieCounterRegistrationPage = ehPublicPage.clickToolsCalorieCounterRegistration();
		if (Settings.isDesktop()) {
			assertTrue(calorieCounterRegistrationPage.onHeaderCCR().isLoginLinkVisible(), "Login link should be visible");
		}
		assertTrue(calorieCounterRegistrationPage.isSubmitButtonVisible(), "Submit form button should be visible");
		Logger.info("Verifying 'Calorie Counter' dashboard with logged in user");
		calorieCounterRegistrationPage.clickBackBrowserButton(EHPublicPage.class);
		ehPublicPage.onGlobalNavHeader().loginWithUserAndOpenPage(user, EHPublicPage.class);
		assertTrue(Utils.isConnectionHTTPS(), "Connection is not https");
		assertTrue(ehPublicPage.onGlobalNavHeader().isLoggedIn(), "Main user should be logged in");
		CalorieCounterPage calorieCounterTool = ehPublicPage.clickToolsCalorieCounter();
		assertTrue(calorieCounterTool.isCalorieCounterTitleVisible(), "Calorie Counter title should be visible");
		assertTrue(calorieCounterTool.isDatePickerVisible(), "Date picker UI should be visible");
		assertTrue(calorieCounterTool.isDatePickerNavLeftVisible(), "Date picker left nav arrow should be visible");
		assertTrue(calorieCounterTool.isDatePickerNavRightVisible(), "Date picker right nav arrow should be visible");
		verifyZDFooter(calorieCounterTool);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "HomePage", "C179077"})
	@TestRail(id = "C179077")
	public void toolsMealPlanner() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		Logger.info("Verifying 'Meal Planner' sign up form with logged out user");
		assertEquals(ehPublicPage.getNumberOfToolsImageSprites(), 6, "All 6 tools images should be visible");
		ToolsRegistrationPage mealPlannerRegistrationPage = ehPublicPage.clickToolsMealPlannerRegistration();
		if (Settings.isDesktop()) {
			assertTrue(mealPlannerRegistrationPage.onHeaderCCR().isLoginLinkVisible(), "Login link should be visible");
		}
		assertTrue(mealPlannerRegistrationPage.isSubmitButtonVisible(), "Submit form button should be visible");
		Logger.info("Verifying 'Meal Planner' dashboard with logged in user");
		mealPlannerRegistrationPage.clickBackBrowserButton(EHPublicPage.class);
		ehPublicPage.onGlobalNavHeader().loginWithUserAndOpenPage(user, EHPublicPage.class);
		assertTrue(Utils.isConnectionHTTPS(), "Connection is not https");
		assertTrue(ehPublicPage.onGlobalNavHeader().isLoggedIn(), "Main user should be logged in");
		MealPlannerPage mealPlannerPage = ehPublicPage.clickToolsMealPlanner();
		assertTrue(mealPlannerPage.isMealPlannerTitleVisible(), "Meal Planner title should be visible");
		assertTrue(mealPlannerPage.isDatePickerVisible(), "Date picker UI should be visible");
		assertTrue(mealPlannerPage.isDatePickerNavLeftVisible(), "Date picker left nav arrow should be visible");
		assertTrue(mealPlannerPage.isDatePickerNavRightVisible(), "Date picker right nav arrow should be visible");
		assertTrue(mealPlannerPage.isViewByDayVisible(), "'View By Day' should be visible");
		assertTrue(mealPlannerPage.isViewByWeekVisible(), "'View By Week' should be visible");
		verifyZDFooter(mealPlannerPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "HomePage", "C203430"})
	@TestRail(id = "C203430")
	public void toolsSymptomChecker() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		Logger.info("Verifying 'Symptom checker' sign up form with logged out user");
		SymptomCheckerPage symptomCheckerPage = ehPublicPage.clickToolsSymptomChecker();
		assertTrue(symptomCheckerPage.isSymptomCheckerTitleVisible(), "Symptom checker title should be visible");
		Logger.info("Verifying 'Symptom checker' page with logged in user");
		symptomCheckerPage.clickBackBrowserButton(EHPublicPage.class);
		ehPublicPage.onGlobalNavHeader().loginWithUserAndOpenPage(user, EHPublicPage.class);
		assertTrue(Utils.isConnectionHTTPS(), "Connection is not https");
		assertTrue(ehPublicPage.onGlobalNavHeader().isLoggedIn(), "Main user should be logged in");
		symptomCheckerPage = ehPublicPage.clickToolsSymptomChecker();
		assertTrue(symptomCheckerPage.isSymptomCheckerTitleVisible(), "Symptom checker title should be visible");
		Logger.info("Verify the footer elements on the page");
		verifyZDFooter(symptomCheckerPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "HomePage", "C179093"})
	@TestRail(id = "C179093")
	public void toolsDrugs() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		Logger.info("Verifying 'Tools Drug Finder' tool elements and page");
		assertEquals(ehPublicPage.getNumberOfToolsImageSprites(), 6, "All 6 tools images should be visible");
		DrugsLandingPage drugsPage = ehPublicPage.clickToolsDrugFinder();
		assertTrue(drugsPage.isDrugsTitleVisible(), "Drugs title should be visible");
		assertTrue(drugsPage.isDrugsSearchFieldVisible(), "Drugs search field should be visible");
		assertTrue(drugsPage.isDrugsSearchButtonVisible(), "Drugs search button should be visible");
		verifyZDFooter(drugsPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "HomePage", "C179094"})
	@TestRail(id = "C179094")
	public void toolsRecipes() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		Logger.info("Verifying 'Tools Recipes' tool elements and page");
		assertEquals(ehPublicPage.getNumberOfToolsImageSprites(), 6, "All 6 tools images should be visible");
		RecipesPage recipesPage = ehPublicPage.clickToolsRecipes();
		assertTrue(recipesPage.isRecipesTitleVisible(), "Recipes title should be visible");
		if (Settings.isTablet()) {
			recipesPage.scrollDownThePage();
		}
		verifyZDFooter(recipesPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HomePage", "C187493"})
	@TestRail(id = "C187493")
	public void gridMoreButton() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		Logger.info("Verifying clicking the grid 'More' button reveals all grid items");
		assertTrue(ehPublicPage.isMoreButtonVisible(), "'More' button should be visible");
		int numberOfGridItems = ehPublicPage.getNumberOfGridBlocks();
		assertEquals(numberOfGridItems, 11, "There should be 11 grid items before clicking 'more' button");
		ehPublicPage.clickMoreButton();
		assertTrue(ehPublicPage.getNumberOfGridBlocks() > numberOfGridItems, "There should be 24 grid items after clicking 'more' button");
	}

	@Test(groups = {"EverydayHealthDesktop", "HomePage", "C187466"})
	@TestRail(id = "C187466")
	public void verifyGridElementsPresence() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH().clickMoreButton();
		int numberOfGridBlocks = ehPublicPage.getNumberOfGridBlocks();
		assertEquals(ehPublicPage.getNumberOfClickableGridImages(),
				numberOfGridBlocks,
				"Number of grid blocks and clickable images should be same");
		assertEquals(ehPublicPage.getNumberOfClickableGridTitles(),
				numberOfGridBlocks,
				"Number of grid blocks and clickable titles should be same");

		/*
			if header is 'FROM OUR SPONSOR' it won't be clickable
			if grid block is 'Wellness Defined: The Ultimate Guide to Health and Happiness' - it won't have header
		*/
		int numberOfHeaderExceptions = 0;
		if (ehPublicPage.getGridBlockHrefValue(8)
				.equals("https://www.everydayhealth.com/wellness/state-of-wellness-women/")) {
			numberOfHeaderExceptions++;
		}
		for (int block = 1; block <= numberOfGridBlocks - numberOfHeaderExceptions; block++) {
			if (ehPublicPage.getGridBlockHeaderText(block).equals("FROM OUR SPONSOR")) {
				numberOfHeaderExceptions++;
			}
		}
		assertEquals(ehPublicPage.getNumberOfClickableHeaders("grid"),
				numberOfGridBlocks - numberOfHeaderExceptions,
				"Incorrect number of clickable headers");
	}

	@Test(groups = {"EverydayHealthDesktop", "HomePage", "C189808"})
	@TestRail(id = "C189808")
	public void verifyRightRailElements() {
		Logger.info("Verifying presence of all right rail items");
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		assertEquals(ehPublicPage.getNumberOfClickableRightRailImages(), 2, "Number of clickable Right Rail images should be 2");
		assertEquals(ehPublicPage.getNumberOfClickableRightRailTitles(), 2, "Number of clickable Right Rail titles should be 2");
		assertEquals(ehPublicPage.getNumberOfClickableRightRailBlocks(), 2, "Number of clickable Right Rail blocks should be 2");
		assertEquals(ehPublicPage.getNumberOfClickableHeaders("rightRail"), 2, "Number of clickable Right Rail headers should be 2");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HomePage", "C189432"})
	@TestRail(id = "C189432")
	public void verifyCustomSolutionsLinks() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();

		Logger.info("Verifying the 'Custom Solutions' region URLs and clicking the '+' button reveals all topic items and links");
		assertTrue(ehPublicPage.isEverydaySolutionsTitleVisible(), "'Everyday Solutions' section title should be visible");
		assertTrue(ehPublicPage.isEverydaySolutionsButtonVisible(), "'Everyday Solutions' '+' button should be visible");
		if (Settings.isDesktop() || Settings.isTablet()) {
			assertTrue(ehPublicPage.isEverydaySolutionsExpanded(), "'Everyday Solutions' section should be expanded on desktop/tablet");
		} else {
			assertFalse(ehPublicPage.isEverydaySolutionsExpanded(), "'Everyday Solutions' section should not be expanded on mobile");
		}

		assertTrue(ehPublicPage.isEverydaySolutionsDisclaimerVisible(), "'Everyday Solutions' disclaimer should be visible");
		assertTrue(ehPublicPage.isEverydaySolutionsSeeAllLinkSponsored(), "'See All' link should contain 'sponsors'");
		int numberOfSolutionLinks = ehPublicPage.getNumberOfEverydaySolutionsLinks();
		for (int elementNumber = 1; elementNumber <= numberOfSolutionLinks; elementNumber++) {
			assertFalse(ehPublicPage.getEverydaySolutionsContentLinkHrefValue(elementNumber).isEmpty(), "Solutions links should be hyperlinks");
		}

		if (numberOfSolutionLinks % 4 == 0) {
			int numberOfLinksInColumn = numberOfSolutionLinks / 4;
			for (int column = 1; column <= 4; column++) {
				assertEquals(ehPublicPage.getNumberOfLinksInColumns(column),
						numberOfLinksInColumn,
						"Incorrect number of links in column #" + column);
			}
		} else {
			int divResult = numberOfSolutionLinks % 4;
			for (int column = 1; column <= divResult; column++) {
				assertEquals(ehPublicPage.getNumberOfLinksInColumns(column),
						(numberOfSolutionLinks / 4) + 1,
						"Incorrect number of links in column #" + column);
			}
			while (divResult != 4) {
				divResult++;
				assertEquals(ehPublicPage.getNumberOfLinksInColumns(divResult),
						numberOfSolutionLinks / 4,
						"Incorrect number of links in column #" + divResult);
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HomePage", "C209065"})
	@TestRail(id = "C209065")
	public void verifyEverydayHealthUpdates() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();
		Logger.info("Verifying the 'Everyday Health Updates' region URLs");
		assertTrue(ehPublicPage.isEverydayHealthUpdatesHeaderVisible(), "Everyday health updates header not available");
		int everydayHealthUpdatesLinksCount = ehPublicPage.getEverydayHealthUpdatesLinksCount();
		for (int elementNumber = 1; elementNumber <= everydayHealthUpdatesLinksCount; elementNumber++) {
			assertTrue(ehPublicPage.isEveryHealthUpdatesLinksContainHREF(elementNumber), "Everyday health updates link does not contain HREF");
			String linkHref = ehPublicPage.getEverydayHealthUpdatesLinkHref(elementNumber).toLowerCase();
			ehPublicPage.clickEverydayHealthUpdatesLinks(elementNumber);
			assertTrue(Utils.getCurrentURL().toLowerCase().contains(linkHref), "URL is not correct");
			SiteNavigatorEH.goToMainPageEH();
		}
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	public void verifyZDFooter(BasicPageEH basicPageEH) {
		PublicFooterZD publicFooterZD = basicPageEH.onZDFooter();
		String baseURL = Settings.getDefaultUrl();
		assertTrue(publicFooterZD.isFooterVisible(), "Footer should be visible");
		assertEquals(publicFooterZD.getFooterBackgroundColor(), "#2c353b", "Footer should have grey background");

		assertTrue(publicFooterZD.isEHLogoVisible(), "EH logo should be visible on footer");
		assertTrue(publicFooterZD.isFooterTextVisible(), "Text should be visible near the footer logo");
		assertEquals(publicFooterZD.getFooterText(), "Wellness inspired. Wellness enabled.", "Incorrect footer text is present");
		String fontFamilyLogo = publicFooterZD.getFooterTextCSSAttribute("font-family");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHF-3618");
		assertTrue(fontFamilyLogo.startsWith("\"open sans\""), "'font-family' should start with \"Open Sans\"");
		assertTrue(fontFamilyLogo.endsWith("verdana"), "'font-family' should end with 'Verdana'");
		assertEquals(publicFooterZD.getFooterTextCSSAttribute("font-size"), "18px", "'font-size' should be '18px'");
		assertEquals(publicFooterZD.getFooterTextCSSAttribute("text-align"), "left", "'text-align' should be 'left'");
		assertEquals(publicFooterZD.getFooterTextCSSAttribute("color"), "rgba(255, 255, 255, 1)", "'color' should be 'rgba(255, 255, 255, 1)' (#ffffff)");

		assertTrue(publicFooterZD.isSocialBarVisible(), "Social bar should be visible on footer");
		assertTrue(publicFooterZD.isFacebookButtonVisible(), "'Facebook' social button should be visible");
		assertEquals(publicFooterZD.getFacebookButtonHrefValue(), "https://www.facebook.com/everydayhealth", "Incorrect FB link");
		assertTrue(publicFooterZD.isTwitterButtonVisible(), "'Twitter' social button should be visible");
		assertEquals(publicFooterZD.getTwitterButtonHrefValue(), "https://twitter.com/everydayhealth", "Incorrect Twitter link");
		assertTrue(publicFooterZD.isInstagramButtonVisible(), "'Instagram' social button should be visible");
		assertEquals(publicFooterZD.getInstagramButtonHrefValue(), "https://www.instagram.com/everydayhealth/", "Incorrect Instagram link");
		assertTrue(publicFooterZD.isPinterestButtonVisible(), "'Pinterest' social button should be visible");
		assertEquals(publicFooterZD.getPinterestButtonHrefValue(), "https://pinterest.com/everydayhealth/", "Incorrect Pinterest link");
		assertTrue(publicFooterZD.isGooglePlusButtonVisible(), "'Google Plus' social button should be visible");
		assertEquals(publicFooterZD.getGooglePlusButtonHrefValue(), "https://plus.google.com/+EverydayHealth/posts", "Incorrect Google Plus link");

		int numberOfEHLinks = publicFooterZD.getNumberOfEHLinksInFooter();
		assertEquals(numberOfEHLinks, 10, "10 EH links should be present in footer");
		if (!Settings.isMobile()) {
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 1), "About Us", "First link in first column should be 'About Us'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 1), baseURL + "/about-us/", "Incorrect 'About Us' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 2), "Newsletters", "Second link in first column should be 'Newsletters'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 2), baseURL + "/newsletter-subscriptions/signup/", "Incorrect 'Newsletters' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 3), "Health News", "Third link in first column should be 'Health News'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 3), baseURL + "/news/", "Incorrect 'Health News' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 4), "Our Sponsors", "Fourth link in first column should be 'Our Sponsors'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 4), baseURL + "/solutions/landing/sponsors/", "Incorrect 'Our Sponsors' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 1), "Feedback", "First link in second column should be 'Feedback'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 1), "https://www.cvent.com/Surveys/Welcome.aspx?s=3bf4d45a-b8ce-49e4-b24c-49d5e101ad05&refid=everydayhealth", "Incorrect 'Feedback' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 2), "Contact Us", "Second link in second column should be 'Contact Us'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 2), baseURL + "/contact-us/", "Incorrect 'Contact Us' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 3), "Careers", "Third link in second column should be 'Careers'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 3), "http://www.j2global.com/careers/job-search", "Incorrect 'Careers' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 4), "Terms of Use", "First link in third column should be 'Terms of Use'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 4), baseURL + "/privacyterms/#everyday_health_terms_of_use", "Incorrect 'Terms of Use' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(3, 1), "Privacy Policy", "Second link in third column should be 'Privacy Policy'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(3, 1), baseURL + "/privacyterms/#everyday_health_privacy_policy", "Incorrect 'Privacy Policy' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(3, 2), "Accessibility Statement", "Second link in third column should be 'Accessibility Statement'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(3, 2), baseURL + "/accessibility-statement/", "Incorrect 'Privacy Policy' link destination");
			assertFalse(publicFooterZD.isAdChoiceLinkIconVisible(), "AdChoice link icon should not be visible");

			assertTrue(publicFooterZD.isZiffDavisLinksBlockVisible(), "Block with Ziff Davis links should be visible");
			assertEquals(publicFooterZD.getZiffDavisLinksDescription(), "More From Ziff Davis:", "Incorrect Ziff Davis links description");
			String fontFamilyMoreFromZD = publicFooterZD.getZiffDavisLinksDescriptionCSSAttribute("font-family");
			assertTrue(fontFamilyMoreFromZD.startsWith("\"open sans\""), "'font-family' should start with \"Open Sans\"");
			assertTrue(fontFamilyMoreFromZD.endsWith("verdana"), "'font-family' should end with 'Verdana'");
			assertEquals(publicFooterZD.getZiffDavisLinksDescriptionCSSAttribute("font-size"), "12px", "'font-size' should be '12px'");
			assertEquals(publicFooterZD.getZiffDavisLinksDescriptionCSSAttribute("color"), "rgba(204, 204, 204, 1)", "'color' should be 'rgba(204, 204, 204, 1)' (#cccccc)");
			assertEquals(publicFooterZD.getZiffDavisLinksDescriptionCSSAttribute("font-weight"), "600", "'font-weight' should be '600'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(1), "Computer Shopper", "1st ZD link should be 'Computer Shopper'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(1), "http://www.computershopper.com/", "Incorrect destination for 'Computer Shopper'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(2), "ExtremeTech", "2nd ZD link should be 'ExtremeTech'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(2), "http://www.extremetech.com/", "Incorrect destination for 'ExtremeTech'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(3), "Geek", "3rd ZD link should be 'ExtremeTech'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(3), "https://www.geek.com/", "Incorrect destination for 'Geek'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(4), "AskMen", "4th ZD link should be 'AskMen'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(4), "http://www.askmen.com/", "Incorrect destination for 'AskMen'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(5), "IGN", "5th ZD link should be 'IGN'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(5), "http://www.ign.com/", "Incorrect destination for 'IGN'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(6), "Offers.com", "6th ZD link should be 'Offers.com'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(6), "https://www.offers.com/", "Incorrect destination for 'Offers.com'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(7), "Speedtest.net", "7th ZD link should be 'Speedtest.net'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(7), "http://www.speedtest.net/", "Incorrect destination for 'Speedtest.net'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(8), "TechBargains", "8th ZD link should be 'TechBargains'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(8), "https://www.techbargains.com/", "Incorrect destination for 'TechBargains'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(9), "Toolbox", "9th ZD link should be 'Toolbox'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(9), "http://it.toolbox.com/", "Incorrect destination for 'Toolbox'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(10), "What to Expect", "10th ZD link should be 'What to Expect'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(10), "https://www.whattoexpect.com/", "Incorrect destination for 'What to Expect'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(11), "MedPage Today", "11th ZD link should be 'MedPage Today'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(11), "https://www.medpagetoday.com/", "Incorrect destination for 'MedPage Today'");
			assertEquals(publicFooterZD.getTextFromZiffDavisLink(12), "PCMag", "12th ZD link should be 'PCMag'");
			assertEquals(publicFooterZD.getHrefValueForZiffDavisLink(12), "https://www.pcmag.com/", "Incorrect destination for 'PCMag'");
		} else {
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 1), "About Us", "First link in first column should be 'About Us'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 1), baseURL + "/about-us/", "Incorrect 'About Us' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 2), "Newsletters", "Second link in first column should be 'Newsletters'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 2), baseURL + "/newsletter-subscriptions/signup/", "Incorrect 'Newsletters' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 3), "Health News", "Third link in first column should be 'Health News'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 3), baseURL + "/news/", "Incorrect 'Health News' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 4), "Our Sponsors", "Fourth link in first column should be 'Our Sponsors'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 4), baseURL + "/solutions/landing/sponsors/", "Incorrect 'Our Sponsors' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(1, 5), "Feedback", "Fifth link in first column should be 'Feedback'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(1, 5), "https://www.cvent.com/Surveys/Welcome.aspx?s=3bf4d45a-b8ce-49e4-b24c-49d5e101ad05&refid=everydayhealth", "Incorrect 'Feedback' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 1), "Contact Us", "First link in second column should be 'Contact Us'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 1), baseURL + "/contact-us/", "Incorrect 'Contact Us' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 2), "Careers", "Second link in second column should be 'Careers'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 2), "http://www.j2global.com/careers/job-search", "Incorrect 'Careers' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 3), "Terms of Use", "Third link in second column should be 'Terms of Use'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 3), baseURL + "/privacyterms/#everyday_health_terms_of_use", "Incorrect 'Terms of Use' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 4), "Privacy Policy", "Fourth link in second column should be 'Privacy Policy'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 4), baseURL + "/privacyterms/#everyday_health_privacy_policy", "Incorrect 'Privacy Policy' link destination");
			assertEquals(publicFooterZD.getEHLinkTextFromColumn(2, 5), "Accessibility Statement", "Fifth link in second column should be 'Accessibility Statement'");
			assertEquals(publicFooterZD.getEHLinkHrefFromColumn(2, 5), baseURL + "/accessibility-statement/", "Incorrect 'Privacy Policy' link destination");
			assertFalse(publicFooterZD.isAdChoiceLinkIconVisible(), "AdChoice link icon should not be visible");
		}

		for (int link = 1; link <= numberOfEHLinks; link++) {
			String fontFamilyEhLink = publicFooterZD.getCSSAttributeForEHLink(link, "font-family");
			assertTrue(fontFamilyEhLink.startsWith("\"open sans\""), "'font-family' should start with \"Open Sans\"");
			assertTrue(fontFamilyEhLink.endsWith("verdana"), "'font-family' should end with 'Verdana'");
			assertEquals(publicFooterZD.getCSSAttributeForEHLink(link, "font-size"), "13px", "'font-size' should be '13px'");
			assertEquals(publicFooterZD.getCSSAttributeForEHLink(link, "text-align"), "center", "'text-align' should be 'center'");
			assertEquals(publicFooterZD.getCSSAttributeForEHLink(link, "color"), "rgba(204, 204, 204, 1)", "'color' should be 'rgba(204, 204, 204, 1)' (#cccccc)");
		}

		int numberOfZDLinks = publicFooterZD.getNumberOfZDLinks();
		for (int link = 1; link < numberOfZDLinks; link++) {
			String fontFamilyZDLink = publicFooterZD.getCSSAttributeForZDLink(link, "font-family");
			assertTrue(fontFamilyZDLink.startsWith("\"open sans\""), "'font-family' should start with \"Open Sans\"");
			assertTrue(fontFamilyZDLink.endsWith("verdana"), "'font-family' should end with 'Verdana'");
			assertEquals(publicFooterZD.getCSSAttributeForZDLink(link, "font-size"), "12px", "'font-size' should be '12px'");
			assertEquals(publicFooterZD.getCSSAttributeForZDLink(link, "text-align"), "center", "'text-align' should be 'center'");
			assertEquals(publicFooterZD.getCSSAttributeForZDLink(link, "color"), "rgba(170, 170, 170, 1)", "'color' should be 'rgba(170, 170, 170, 1)' (#aaaaaa)");
		}

		assertTrue(publicFooterZD.isFooterBorderVisible(), "Footer border should be visible");
		assertTrue(publicFooterZD.isHONCodeSectionVisible(), "HON Code section should be visible");
		assertTrue(publicFooterZD.isHONCodeTextVisible(), "HON Code test should be visible");
		assertTrue(publicFooterZD.isHONCodeImageVisible(), "HON Code image should be visible");
		assertFalse(publicFooterZD.getHONCodeImageHrefValue().isEmpty(), "HON Code image should have non-empty 'href' attribute value");
		assertEquals(publicFooterZD.getHONCodeSectionText(), "This site complies with the HONcode standard for trustworthy health information: verify here.", "Incorrect HON Code section text");
		assertEquals(publicFooterZD.getHONCodeVerifyHereLinkHrefValue(), "https://www.healthonnet.org/HONcode/Conduct.html", "Incorrect destination for 'verify here.' link");

		assertTrue(publicFooterZD.isCopyrightTextVisible(), "Copyright text should be visible");
		String currentYear = DateUtils.getCurrentDate(DatePatterns.YYYY);
		assertEquals(publicFooterZD.getCopyrightText(), "© 1996-" + currentYear + " Ziff Davis, LLC. Everyday Health is among the federally registered trademarks of Ziff Davis, LLC and may not be used by third parties without explicit permission.", "Incorrect copyright text");
		String fontFamilyCopyright = publicFooterZD.getCopyrightTextCSSAttribute("font-family");
		assertTrue(fontFamilyCopyright.startsWith("\"open sans\""), "'font-family' should start with \"Open Sans\"");
		assertTrue(fontFamilyCopyright.endsWith("verdana"), "'font-family' should end with 'Verdana'");
		assertEquals(publicFooterZD.getCopyrightTextCSSAttribute("font-size"), "12px", "'font-size' should be '12px'");
		assertEquals(publicFooterZD.getCopyrightTextCSSAttribute("color"), "rgba(170, 170, 170, 1)", "'color' should be 'rgba(170, 170, 170, 1)' (#aaaaaa)");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HomePage", "C505421"})
	@TestRail(id = "C505421")
	public void verifyPromoBannerSectionOnHomePage() {
		EHPublicPage ehPublicPage = SiteNavigatorEH.goToMainPageEH();

		verifyPromoBannerSection(ehPublicPage);
	}
}