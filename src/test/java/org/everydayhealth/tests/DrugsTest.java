package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import everydayhealth.pages.drugs.DrugsBasePage;
import everydayhealth.pages.drugs.DrugsByClassPage;
import everydayhealth.pages.drugs.DrugsByLetterPage;
import everydayhealth.pages.drugs.DrugsCouponsPage;
import everydayhealth.pages.drugs.DrugsLandingPage;
import everydayhealth.pages.drugs.DrugsPageSearchResults;
import everydayhealth.pages.drugs.DrugsProfilePage;
import everydayhealth.pages.drugs.DrugsReviewsPage;
import framework.Logger;
import framework.Settings;
import framework.components.BasicPage;
import framework.platform.CookieName;
import framework.platform.Environment;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.EmailUtils;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

/**
 * DrugsTest
 */
public class DrugsTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239929"})
	@TestRail(id = "C239929")
	public void verifyDrugsLandingPageElements() {
		DrugsLandingPage drugsBasePage = SiteNavigatorEH.goToDrugsLandingPage();

		assertTrue(drugsBasePage.isDrugsHeadlineVisible(), "Drugs headline should be visible");
		assertTrue(drugsBasePage.isDrugsSearchFieldVisible(), "Search field should be visible");
		assertTrue(drugsBasePage.isAdDiv5Visible(), "Box1 ad block should be visible");
		assertTrue(drugsBasePage.isMostSearchedDrugsSectionVisible(), "'Most searched drugs' section should be visible");
		if (Settings.isDesktop()) {
			assertTrue(drugsBasePage.isAdDiv9Visible(), "Box extra ad block should be visible");
		}
		assertTrue(drugsBasePage.isMostSearchedClassesSectionVisible(), "'Most searched classes' section should be visible");
		assertTrue(drugsBasePage.isBrowseDrugsSectionVisible(), "'Browse drugs' section should be visible");
		assertTrue(drugsBasePage.isAboutDrugsSectionVisible(), "'About drugs' section should be visible");
		if (!Settings.isMobile()) {
			assertTrue(drugsBasePage.isTopAdVisible(), "Top ad block should be visible");
			assertTrue(drugsBasePage.isBottomAdVisible(), "Bottom ad block should be visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239930"})
	@TestRail(id = "C239930")
	public void verifyMostSearchedDrugsSection() {
		DrugsLandingPage drugsBasePage = SiteNavigatorEH.goToDrugsLandingPage();

		assertEquals(drugsBasePage.getNumberOfDrugsInMostSearchedSection(), 12, "12 drugs should be present in 'Most searched drugs' section");
		assertEquals(drugsBasePage.getNumberOfImagesInMostSearchedSection(), 12, "12 drugs images should be present in 'Most searched drugs' section");
		int numberOfTitles = drugsBasePage.getNumberOfTitleInMostSearchedSection();
		for (int drugTitle = 1; drugTitle < numberOfTitles; drugTitle++) {
			int compareResult = drugsBasePage.getTitleTextNumber(drugTitle).compareTo(drugsBasePage.getTitleTextNumber(drugTitle + 1));
			assertTrue(compareResult <= 0, "Drugs are not in alphabetical order");
		}
		for (int drugTitle = 1; drugTitle <= numberOfTitles; drugTitle++) {
			assertTrue(drugsBasePage.getLinkFromDrugNumber(drugTitle).contains("/drugs/" + drugsBasePage.getTitleTextNumber(drugTitle).toLowerCase()), "Each drug block should lead to corresponding drug page");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239936"})
	@TestRail(id = "C239936")
	public void verifyMostSearchedClassesSection() {
		DrugsLandingPage drugsBasePage = SiteNavigatorEH.goToDrugsLandingPage();

		assertTrue(drugsBasePage.isMostSearchedClassesSectionVisible(), "'Most searched classes' section should be visible");
		int numberOfClasses = drugsBasePage.getNumberOfClasses();
		assertEquals(numberOfClasses, 30, "30 classes should be present in 'Most searched classes' section");
		for (int classNumber = 1; classNumber < numberOfClasses; classNumber++) {
			int comparisonResult = drugsBasePage.getClassNumberTitle(classNumber).compareTo(drugsBasePage.getClassNumberTitle(classNumber + 1));
			assertTrue(comparisonResult <= 0, "Classes are not in alphabetical order");
		}

		for (int classNumber = 1; classNumber <= numberOfClasses; classNumber++) {
			String drugsClass = drugsBasePage.getClassNumberTitle(classNumber);
			String partOfHref = drugsClass.toLowerCase().replace(" ", "-");
			switch (drugsClass) {
				case "Ace Inhibitors":
					partOfHref = "angiotensin-converting-enzyme-inhibitors";
					break;
				case "Beta Blockers":
					partOfHref = "beta-adrenergic-blocking-agents";
					break;
				case "Statins":
					partOfHref = "hmg-coa-reductase-inhibitors";
					break;
			}
			assertTrue(drugsBasePage.getLinkFromDrugClassNumber(classNumber).contains(partOfHref), "Class url should lead to correct page");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239937"})
	@TestRail(id = "C239937")
	public void verifyBrowseDrugsSection() {
		DrugsLandingPage drugsBasePage = SiteNavigatorEH.goToDrugsLandingPage();

		assertTrue(drugsBasePage.isBrowseDrugsSectionVisible(), "'Browse drugs' should be visible");
		int numberOfSymbols = drugsBasePage.getNumberOfElementsInBrowseDrugsSection();
		assertEquals(numberOfSymbols, 27, "26 letters and '#' sign should be present in section");
		for (int symbol = 1; symbol <= numberOfSymbols; symbol++) {
			String letter = drugsBasePage.getSymbolFromBrowseDrugsSection(symbol).toLowerCase();
			if (letter.equals("#")) {
				letter = "0-9";
			}
			String[] splittedAddress = drugsBasePage.getLinkFromSymbolInBrowseDrugsSection(symbol).split("/");
			assertTrue(splittedAddress[splittedAddress.length - 1].equals(letter), "URL should lead to corresponding page");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "DrugsTest", "C239928"})
	@TestRail(id = "C239928")
	public void verifyDrugHeadlineBar() {
		DrugsLandingPage drugsBasePage = SiteNavigatorEH.goToDrugsLandingPage();

		SocialBarEH socialBarEH = drugsBasePage.onSocialBar();
		verifyDrugsBasePageElements(drugsBasePage, socialBarEH);
		assertTrue(drugsBasePage.isBreadcrumbsVisible(), "Breadcrumbs should be visible");
		assertFalse(drugsBasePage.getBreadcrumbLinkNumber(1).isEmpty(), "Breadcrumbs link should not be empty");
		int numberOfBreadcrumbsLinks = drugsBasePage.getNumberOfBreadcrumbLinks();
		assertTrue(drugsBasePage.getBreadcrumbItemTitleNumber(numberOfBreadcrumbsLinks + 1).equalsIgnoreCase("Drugs"), "Breadcrumbs title should be 'Drugs'");
		drugsBasePage.clickFirstBreadcrumbsLink();
		assertEquals(Utils.getCurrentURL(), Settings.getDefaultUrl() + "/", "User should be on main page");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239938"})
	@TestRail(id = "C239938")
	public void verifyDrugsProfilePageElements() {
		DrugsProfilePage drugTemplatePage = SiteNavigatorEH.goToDrugProfilePage();

		assertTrue(drugTemplatePage.isSideMenuVisible(), "Side menu should be visible");
		assertEquals(drugTemplatePage.getNumberOfSideMenuTabs(), 8, "8 side menu tabs should be loaded");
		if (Settings.isMobile() || Settings.isTablet()) {
			drugTemplatePage.clickSideMenu();
		}
		assertTrue(drugTemplatePage.isAdDiv5Visible(), "Box1 ad block should be visible");
		assertTrue(drugTemplatePage.isAdDiv7Visible(), "Box2 ad block should be visible");
		assertTrue(drugTemplatePage.isAdDiv8Visible(), "Box3 ad block should be visible");
		assertTrue(drugTemplatePage.isAdDiv9Visible(), "Boxextra ad block should be visible");
		if (!Settings.isMobile()) {
			assertTrue(drugTemplatePage.isTopAdVisible(), "Top ad block should be visible");
			assertTrue(drugTemplatePage.isBottomAdVisible(), "Bottom ad block should be visible");
		}
		assertTrue(drugTemplatePage.isDrugHeadlineBarVisible(), "Drug headline bar should be visible");
		assertTrue(drugTemplatePage.isBylineVisible(), "Byline should be visible");
		assertTrue(drugTemplatePage.isLastUpdatedDateVisible(), "Last updated date should be visible");
		assertTrue(drugTemplatePage.isReadNextNavigationVisible(), "Read next navigation module should be visible");
		assertFalse(drugTemplatePage.getReadNextHrefAttribute().isEmpty(), "Read next navigation module url should not be empty");
		assertTrue(drugTemplatePage.isAboutDrugsSectionVisible(), "'About drugs' section should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "DrugsTest", "C239939"})
	@TestRail(id = "C239939")
	public void verifyDrugsProfilePageHeadline() {
		DrugsProfilePage drugTemplatePage = SiteNavigatorEH.goToDrugProfilePage();

		verifyDrugPageTemplateHeadlineBar(drugTemplatePage);
		verifyBreadcrumbsElements(drugTemplatePage, "Ibuprofen");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239940"})
	@TestRail(id = "C239940")
	public void verifyDrugProfileMenuTab() {
		DrugsProfilePage drugTemplatePage = SiteNavigatorEH.goToDrugProfilePage();

		for (int sideMenuTabNumber = 1; sideMenuTabNumber <= 6; sideMenuTabNumber++) {
			String sideMenuTitle = drugTemplatePage.getSideMenuTabTitleNumber(sideMenuTabNumber);
			assertTrue(drugTemplatePage.isSideMenuTabTitleVisible(sideMenuTitle), "'Basics' side menu tab should be visible");
			drugTemplatePage.clickSideMenuTabWithTitle(sideMenuTitle);
			assertTrue(drugTemplatePage.isSectionWithTitleInViewPort(sideMenuTitle), "Corresponding section should be in view port");
		}

		String drugName = drugTemplatePage.getDrugHeadlineTitle();

		assertTrue(drugTemplatePage.isSideMenuTabTitleVisible("Reviews"), "'Reviews' side menu tab should be visible");
		assertTrue(drugTemplatePage.getHrefOfReviewsSideMenuTab().contains("/ibuprofen/reviews"), "'Reviews' menu tab should lead to reviews page");

		assertTrue(drugTemplatePage.isSideMenuCouponsLinkVisible(), "'Coupons & Prices' link should be visible in side menu");
		assertTrue(drugTemplatePage.isSideMenuCouponsTagIconVisible(), "Icon should be visible near 'Coupons & Prices' side menu");
		assertEquals(drugTemplatePage.getSideMenuCouponsLinkText(), "Coupons & Prices", "Incorrect coupons link text");
		assertTrue(drugTemplatePage.getSideMenuCouponsLinkHrefValue().endsWith("/drugs/" + drugName.toLowerCase() + "/coupons"), "'Coupons & Prices' should lead to discount page");

		DrugsReviewsPage drugTemplateReviewsPage = drugTemplatePage.clickSideMenuReviewTab();
		assertTrue(drugTemplateReviewsPage.isRatingVisible(), "Rating should be visible");
		BasicPage.clickBackBrowserButton(DrugsProfilePage.class);

		drugTemplateReviewsPage = drugTemplatePage.clickNumberOfReviewsLink();
		assertTrue(drugTemplateReviewsPage.isRatingVisible(), "Rating should be visible");
		BasicPage.clickBackBrowserButton(DrugsProfilePage.class);

		drugTemplatePage.clickSideMenuTabWithTitle("Pictures");
		int numberOfVisiblePictures = drugTemplatePage.getNumberOfVisibleImagesOnPage();
		assertTrue(drugTemplatePage.isSeeAllImagesButtonVisible(), "'See all images' button should be visible");
		drugTemplatePage.clickSeeAllImagesButton();
		assertTrue(drugTemplatePage.getNumberOfVisibleImagesOnPage() > numberOfVisiblePictures, "More images should be visible");

		int totalQuestionsCount = drugTemplatePage.getNumberOfQuestions();
		if (!Settings.isDesktop()) {
			int randomNumber = StringUtils.generateRandomInt(totalQuestionsCount);
			drugTemplatePage.clickQuestionNumber(randomNumber);
			assertTrue(drugTemplatePage.isAnswerNumberTextVisible(), "Answer text should appear");
			drugTemplatePage.clickQuestionNumber(randomNumber);
			assertFalse(drugTemplatePage.isAnswerNumberTextVisible(), "Answer text should disappear");
			drugTemplatePage.clickShowAnserNumber(randomNumber);
			assertTrue(drugTemplatePage.isAnswerNumberTextVisible(), "Answer text should appear");
			drugTemplatePage.clickShowAnserNumber(randomNumber);
			assertFalse(drugTemplatePage.isAnswerNumberTextVisible(), "Answer text should disappear");
		} else {
			assertEquals(drugTemplatePage.getNumberOfAnswers(), totalQuestionsCount, "Each question should have visible answer");
		}

		assertTrue(drugTemplatePage.getHrefOfReadNextNavigationModule().contains("/ibuprofen/reviews"), "'Read next' should lead to reviews page");
		drugTemplateReviewsPage = drugTemplatePage.clickReadNextButton();
		assertTrue(drugTemplateReviewsPage.isRatingVisible(), "Rating should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239941"})
	@TestRail(id = "C239941")
	public void verifyDrugsReviewPageElements() {
		DrugsReviewsPage reviewPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_REVIEW, DrugsReviewsPage.class);

		assertTrue(reviewPage.isDrugHeadlineBarVisible(), "Drug headline should be visible");
		assertTrue(reviewPage.isReviewThisDrugButtonVisible(), "'Review this drug+' button should be visible");
		assertTrue(reviewPage.isSideMenuVisible(), "Side menu should be visible");
		assertEquals(reviewPage.getNumberOfSideMenuTabs(), 8, "8 side menu tabs should be loaded");
		assertTrue(reviewPage.isShowAllButtonVisible(), "Show: 'All' button should be visible");
		assertTrue(reviewPage.isShowHighestButtonVisible(), "Show: 'Highest' button should be visible");
		assertTrue(reviewPage.isShowLowestButtonVisible(), "Show: 'Lowest' button should be visible");
		assertTrue(reviewPage.isReadPreviousNavigationVisible(), "'Read previous' navigation should be visible");
		assertTrue(reviewPage.isAboutDrugsSectionVisible(), "'About drugs' section should be visible");
		if (!Settings.isMobile()) {
			assertTrue(reviewPage.isTopAdVisible(), "Top ad block should be visible");
			assertTrue(reviewPage.isBottomAdVisible(), "Bottom ad block should be visible");
		}

		int numberOfReviews = reviewPage.getNumberOfVisibleReviews();
		if (!(numberOfReviews < 10)) {
			assertTrue(reviewPage.isPageCounterPresent(), "Page counter should be present");
			assertTrue(reviewPage.isNextNavigationArrowVisible(), "'Next' navigation arrow should be visible");
			String hrefValue = reviewPage.getHrefValueOfNextArrow();
			assertTrue(hrefValue.startsWith("https://"), "'Next' navigation arrow link should be https://");
			assertTrue(Utils.isPageSourceContains("<link rel=\"next\" href=\"" + hrefValue), "Page source should contain next https link");
			assertFalse(reviewPage.isPreviousNavigationArrowVisible(), "'Previous' navigation arrow should not be visible");
			assertEquals(reviewPage.getCurrentPageNumber(), "1", "1st page should be displayed");
			reviewPage.clickNextArrow();
			assertEquals(reviewPage.getCurrentPageNumber(), "2", "2nd page should be displayed");
			assertTrue(reviewPage.isPreviousNavigationArrowVisible(), "'Previous' navigation arrow should be visible");
			assertTrue(reviewPage.getHrefValueOfPreviousArrow().startsWith("https://"), "'Previous' navigation arrow link should be https://");
			reviewPage.clickPreviousArrow();
			assertEquals(reviewPage.getCurrentPageNumber(), "1", "1st page should be displayed");
		}
		assertTrue(Utils.isPageSourceContains("<link rel=\"canonical\" href=\"" + Utils.getCurrentURL().replace("?isautomation=true", "")), "Page source should contain canonical https link");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "DrugsTest", "C239942"})
	@TestRail(id = "C239942")
	public void verifyDrugsReviewPageHeadlineBar() {
		DrugsReviewsPage reviewPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_REVIEW, DrugsReviewsPage.class);

		verifyDrugPageTemplateHeadlineBar(reviewPage);
		verifyBreadcrumbsElements(reviewPage, "Reviews");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239943"})
	@TestRail(id = "C239943")
	public void verifyReviewTabElements() {
		DrugsReviewsPage reviewPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_REVIEW, DrugsReviewsPage.class);

		assertNotEquals(Utils.getHexColor(reviewPage.getColorOfReviewsTab()), "#333333", "'Reviews' tab should be highlited");
		verifyDrugReviewPageElements(reviewPage);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239947"})
	@TestRail(id = "C239947")
	public void verifyReviewFunctionalityPositive() {
		DrugsReviewsPage reviewPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_REVIEW, DrugsReviewsPage.class);

		verifyDrugReviewPageElements(reviewPage);
		reviewDrug(reviewPage, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239948"})
	@TestRail(id = "C239948")
	public void verifyReviewFunctionalityNegative() {
		DrugsReviewsPage reviewPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_REVIEW, DrugsReviewsPage.class);

		verifyDrugReviewPageElements(reviewPage);
		reviewDrug(reviewPage, false);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239950"})
	@TestRail(id = "C239950")
	public void verifyDrugsByClassPage() {
		DrugsByClassPage drugsByClassPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_CLASS, DrugsByClassPage.class);

		if (!Settings.isMobile()) {
			assertTrue(drugsByClassPage.isTopAdVisible(), "Top ad block should be visible");
			assertTrue(drugsByClassPage.isBottomAdVisible(), "Bottom ad block should be visible");
		}
		assertTrue(drugsByClassPage.isAdDiv5Visible(), "Box1 ad block should be visible");
		assertTrue(drugsByClassPage.isDrugsHeadlineVisible(), "Drugs headline should be visible");
		assertTrue(drugsByClassPage.isDrugsByClassSectionVisible(), "Drugs by class section should be visible");
		assertEquals(drugsByClassPage.getDrugsClass(), "ANALGESICS", "Drugs class should be 'Analgetics'");
		assertTrue(drugsByClassPage.isAboutDrugsSectionVisible(), "'About drugs' section should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "DrugsTest", "C239951"})
	@TestRail(id = "C239951")
	public void verifyHeadlineOnDrugsByClassPage() {
		DrugsByClassPage drugsByClassPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_CLASS, DrugsByClassPage.class);

		SocialBarEH socialBarEH = drugsByClassPage.onSocialBar();
		verifyDrugsBasePageElements(drugsByClassPage, socialBarEH);
		verifyBreadcrumbsElements(drugsByClassPage, "Analgesics");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239953"})
	@TestRail(id = "C239953")
	public void verifyDrugsByLetterPageElements() {
		DrugsByLetterPage drugsByLetterPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_LETTER, DrugsByLetterPage.class);

		if (!Settings.isMobile()) {
			assertTrue(drugsByLetterPage.isTopAdVisible(), "Top ad block should be visible");
			assertTrue(drugsByLetterPage.isBottomAdVisible(), "Bottom ad block should be visible");
			assertTrue(drugsByLetterPage.isAdDiv9Visible(), "Box extra ad block should be visible");
		}
		assertTrue(drugsByLetterPage.isDrugsHeadlineVisible(), "Drugs headline should be visible");
		assertTrue(drugsByLetterPage.isDrugsSearchFieldVisible(), "Search field should be visible");
		assertTrue(drugsByLetterPage.isAdDiv5Visible(), "Box 1 ad block should be visible");
		assertTrue(drugsByLetterPage.isDrugsByLetterSectionVisible(), "'Drugs by letter' section should be visible");
		assertTrue(drugsByLetterPage.isClassesByLetterSectionVisible(), "'Classes by letter' should be visible");
		assertTrue(drugsByLetterPage.isBrowseDrugsSectionVisible(), "'Browse drugs' section should be visible");
		assertTrue(drugsByLetterPage.isAboutDrugsSectionVisible(), "'About drugs' section should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "DrugsTest", "C239954"})
	@TestRail(id = "C239954")
	public void verifyHeadlineOnDrugsByLetterPage() {
		DrugsByLetterPage drugsByLetterPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_LETTER, DrugsByLetterPage.class);

		SocialBarEH socialBarEH = drugsByLetterPage.onSocialBar();
		verifyDrugsBasePageElements(drugsByLetterPage, socialBarEH);
		verifyBreadcrumbsElements(drugsByLetterPage, "S");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239955"})
	@TestRail(id = "C239955")
	public void verifySearchSection() {
		DrugsByLetterPage drugsByLetterPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_LETTER, DrugsByLetterPage.class);

		String randomQuery = StringUtils.generateRandomNumeric(10);
		String validQuery = "insulin";
		assertTrue(drugsByLetterPage.isDrugsSearchFieldVisible(), "Search field should be visible");
		assertTrue(drugsByLetterPage.isDrugsSearchButtonVisible(), "'Search' button should be visible");
		drugsByLetterPage.enterSearchText(randomQuery);
		DrugsPageSearchResults drugsPageSearchResults = drugsByLetterPage.clickSearchButton();
		assertEquals(drugsPageSearchResults.getNegativeSearchResultText(randomQuery), "There are no results for \"" + randomQuery + "\". You can search again using the above form or you can return to Drugs A-Z.", "Given text should be shown");

		drugsByLetterPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_LETTER, DrugsByLetterPage.class);

		drugsByLetterPage.enterSearchText(validQuery);
		int numberOfSuggestions = drugsByLetterPage.getNumberOfSearchSuggestions();
		for (int suggestionNumber = 1; suggestionNumber <= numberOfSuggestions; suggestionNumber++) {
			assertTrue(drugsByLetterPage.getSearchSuggestionsText(suggestionNumber, validQuery).contains(validQuery), validQuery + " should be present in every auto-suggestion");
		}
		drugsPageSearchResults = drugsByLetterPage.clickSearchButton();
		assertTrue(drugsPageSearchResults.verifyPositiveSearchResult(validQuery), "Result page should contain '" + validQuery + "'");
		assertTrue(drugsPageSearchResults.getSearchResultTitles(1, validQuery).contains(validQuery), "At least 1st result should contain '" + validQuery + "'");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239957"})
	@TestRail(id = "C239957")
	public void verifyClassesByLetterSection() {
		DrugsByLetterPage drugsByLetterPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_LETTER, DrugsByLetterPage.class);

		assertTrue(drugsByLetterPage.isClassesByLetterSectionVisible(), "'Classes by letter' section should be visible");
		if (!Settings.isMobile()) {
			int numberOfClasses = drugsByLetterPage.getNumberOfClassesByLetter();
			for (int classNumber = 1; classNumber <= numberOfClasses; classNumber++) {
				String classTitle = drugsByLetterPage.getClassTitle(classNumber);
				if (classNumber == numberOfClasses) {
					assertTrue(drugsByLetterPage.getClassUrl(classNumber).contains(classTitle.toLowerCase().replace(" ", "-")), "'href' attribute should contain link to drug class");
					continue;
				}
				StringUtils.isSortedAsc(classTitle, drugsByLetterPage.getClassTitle(classNumber + 1));
				assertTrue(drugsByLetterPage.getClassUrl(classNumber).contains(classTitle.toLowerCase().replace(" ", "-")), "'href' attribute should contain link to drug class");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239958"})
	@TestRail(id = "C239958")
	public void verifyBrowseDrugsSectionNavigation() {
		DrugsByLetterPage drugsByLetterPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_LETTER, DrugsByLetterPage.class);

		assertTrue(drugsByLetterPage.isBrowseDrugsSectionVisible(), "'Browse drugs' should be visible");
		int numberOfSymbols = drugsByLetterPage.getNumberOfLinksInBrowseDrugsSection();
		assertEquals(drugsByLetterPage.getNumberOfElementsInBrowseDrugsSection(), 27, "26 letters and '#' sign should be present in section");
		for (int symbol = 1; symbol <= numberOfSymbols; symbol++) {
			String letter = drugsByLetterPage.getSymbolFromBrowseDrugsSection(symbol).toLowerCase();
			if (letter.equals("#")) {
				letter = "0-9";
			}
			String[] splittedAddress = drugsByLetterPage.getLinkFromSymbolInBrowseDrugsSection(symbol).split("/");
			assertTrue(splittedAddress[splittedAddress.length - 1].equals(letter), "URL should lead to corresponding page");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239944"})
	@TestRail(id = "C239944")
	public void verifyDrugsSearchPageElements() {
		DrugsLandingPage drugsSearchPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_SEARCH, DrugsLandingPage.class);

		if (!Settings.isMobile()) {
			assertTrue(drugsSearchPage.isTopAdVisible(), "Top ad block should be visible");
			assertTrue(drugsSearchPage.isAdDiv9Visible(), "Box extra ad block should be visible");
			assertTrue(drugsSearchPage.isBottomAdVisible(), "Bottom ad block should be visible");
		}
		assertTrue(drugsSearchPage.isAdDiv5Visible(), "Box 1 ad block should be visible");
		assertTrue(drugsSearchPage.isDrugsHeadlineVisible(), "Drugs headline should be visible");
		assertTrue(drugsSearchPage.isDrugsSearchFieldVisible(), "Search field should be visible");
		assertTrue(drugsSearchPage.isAboutDrugsSectionVisible(), "'About drugs' section should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "DrugsTest", "C239945"})
	@TestRail(id = "C239945")
	public void verifyDrugsSearchPageHeadline() {
		DrugsLandingPage drugsSearchPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_SEARCH, DrugsLandingPage.class);

		SocialBarEH socialBarEH = drugsSearchPage.onSocialBar();
		verifyDrugsBasePageElements(drugsSearchPage, socialBarEH);
		verifyBreadcrumbsElements(drugsSearchPage, "Search Results");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239952"})
	@TestRail(id = "C239952")
	public void verifyDrugsByClassSection() {
		DrugsByClassPage drugsByClassPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_CLASS, DrugsByClassPage.class);

		assertTrue(drugsByClassPage.isDrugsByClassSectionVisible(), "'Drugs by class' section should be visible");
		if (!Settings.isMobile()) {
			int numberOfDrugs = drugsByClassPage.getNumberOfDrugsInDrugsByClassSection();
			for (int drug = 1; drug <= numberOfDrugs; drug++) {
				if (drug == numberOfDrugs) {
					assertFalse(drugsByClassPage.getDrugURLNumber(drug).isEmpty(), "Drug hyperlinks should not be empty");
					continue;
				}
				assertTrue(StringUtils.isSortedAscLexicographically(drugsByClassPage.getDrugTitleNumber(drug), drugsByClassPage.getDrugTitleNumber(drug + 1)), "Classes are not in alphabetical order");
				assertFalse(drugsByClassPage.getDrugURLNumber(drug).isEmpty(), "Drug hyperlinks should not be empty");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C239956"})
	@TestRail(id = "C239956")
	public void verifyDrugsByLetterSection() {
		DrugsByLetterPage drugsByLetterPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_BY_LETTER, DrugsByLetterPage.class);

		assertTrue(drugsByLetterPage.isDrugsByLetterSectionVisible(), "'Drugs by letter' section should be visible");
		if (!Settings.isMobile()) {
			int numberOfDrugs = drugsByLetterPage.getNumberOfLinksInDrugsByLetterSection();
			for (int drug = 1; drug <= numberOfDrugs; drug++) {
				if (drug == numberOfDrugs) {
					assertFalse(drugsByLetterPage.getLinkFromTitleInDrugsByLetterSection(drug).isEmpty(), "Drug hyperlinks from 'Drugs by letter' section should not be empty");
					continue;
				}
				assertTrue(StringUtils.isSortedAscLexicographically(drugsByLetterPage.getDrugTitleFromDrugsByLetterSection(drug), drugsByLetterPage.getDrugTitleFromDrugsByLetterSection(drug + 1)), "Drugs in 'Drugs by letter' section are not in alphabetical order");
				assertFalse(drugsByLetterPage.getLinkFromTitleInDrugsByLetterSection(drug).isEmpty(), "Drugs hyperlinks in 'Drugs by letter' section should not be empty");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C432229"})
	@TestRail(id = "C432229")
	public void verifyDiscountPageElements() {
		DrugsProfilePage drugsProfilePage = SiteNavigatorEH.goToDrugProfilePage();
		assertTrue(drugsProfilePage.isSideMenuCouponsLinkVisible(), "Side menu 'Coupons & Prices' link should be visible");

		DrugsCouponsPage drugsCouponsPage = drugsProfilePage.clickCouponsAndPricesLink();
		String drugName = drugsCouponsPage.getDrugHeadlineTitle().toLowerCase();
		assertTrue(Utils.getCurrentURL().endsWith("/drugs/" + drugName + "/coupons"), "Incorrect URL");

		assertTrue(drugsCouponsPage.isZipInputVisible(), "Zip input (location) should be visible");
		assertTrue(drugsCouponsPage.isZipSearchButtonVisible(), "'Search' button should be visible");
		assertTrue(drugsCouponsPage.isSearchResultContainerVisible(), "Search results container should be visible");
		int numberOfSearchResults = drugsCouponsPage.getNumberOfSearchResultItems();
		assertTrue(numberOfSearchResults >= 1, "At least one search result should appear");
		assertTrue(drugsCouponsPage.isDosageInfoVisible(), "Dosage info should be visible");
		assertTrue(drugsCouponsPage.isEditDosageQuantityButtonVisible(), "'Edit dosage/qty' link should be visible");
		for (int resultNumber = 1; resultNumber <= numberOfSearchResults; resultNumber++) {
			assertTrue(drugsCouponsPage.isResultItemNameVisible(resultNumber), "Every search result should have title");
			assertTrue(drugsCouponsPage.isResultItemPriceVisible(resultNumber), "Every search result should have price");
			assertTrue(drugsCouponsPage.isResultItemAddressVisible(resultNumber), "Every search result should have address");
			assertTrue(drugsCouponsPage.isResultItemGetCouponButtonVisible(resultNumber), "Every search result should have 'Get free coupon' button");
			if (resultNumber > 1) {
				double price1 = Double.parseDouble(drugsCouponsPage.getResultItemPriceValue(resultNumber - 1).replace("$", ""));
				double price2 = Double.parseDouble(drugsCouponsPage.getResultItemPriceValue(resultNumber).replace("$", ""));
				assertTrue(price2 >= price1, "Prices should be sorted from lowest to highest");
			}
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C432230"})
	@TestRail(id = "C432230")
	public void verifyEditDosageQuantityModal() {
		DrugsCouponsPage drugsCouponsPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_COUPONS, DrugsCouponsPage.class);

		String dosageInfo = drugsCouponsPage.getDosageInfo();
		assertFalse(dosageInfo.isEmpty(), "Dosage info should not be empty");
		assertTrue(drugsCouponsPage.isEditDosageQuantityButtonVisible(), "'Edit dosage/qty' link should be visible");

		drugsCouponsPage.clickEditDosageQuantityButton();
		assertTrue(drugsCouponsPage.isEditDosageQuantityModalVisible(), "Modal window should appear after click");
		assertTrue(drugsCouponsPage.isFormFilterSectionVisible(), "Form section should be visible");
		assertTrue(drugsCouponsPage.isQuantityFilterSectionVisible(), "Quantity section should be visible");
		assertTrue(drugsCouponsPage.isDosageFilterSectionVisible(), "Dosage section should be visible");
		assertTrue(drugsCouponsPage.isTypeFilterSectionVisible(), "Type section should be visible");
		assertTrue(drugsCouponsPage.isCloseIconVisibleOnModal(), "Close icon [x] should be visible on modal window");

		drugsCouponsPage.chooseDosageOption(1);
		drugsCouponsPage.chooseQuantityOption(1);
		drugsCouponsPage.clickCancelButton();
		assertFalse(drugsCouponsPage.isEditDosageQuantityModalVisible(), "Modal window should not be visible");
		assertEquals(drugsCouponsPage.getDosageInfo(), dosageInfo, "Changes should not be saved");

		drugsCouponsPage.clickEditDosageQuantityButton();
		String form = "";
		if (drugsCouponsPage.getNumberOfFormFilterItems() > 1) {
			drugsCouponsPage.clickFormFilterItem(1);
			form = drugsCouponsPage.getChosenFormFilterItemText();
		}
		drugsCouponsPage.chooseDosageOption(1);
		String dosage = drugsCouponsPage.getChosenDosageOptionText();
		drugsCouponsPage.chooseQuantityOption(1);
		String quantity = drugsCouponsPage.getChosenQuantityOptionText();
		drugsCouponsPage.clickApplyButton();

		String dosageInfoUpdated = drugsCouponsPage.getDosageInfo();
		assertTrue(dosageInfoUpdated.startsWith(quantity), "Chosen quantity value should be displayed");
		if (!form.isEmpty()) {
			assertTrue(dosageInfoUpdated.contains(form), "Dosage info should contain changed form value");
		}
		assertTrue(dosageInfoUpdated.endsWith(dosage.toLowerCase()), "Chosen dosage value should be displayed");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C432231"})
	@TestRail(id = "C432231")
	public void verifyLocationInput() {
		DrugsCouponsPage drugsCouponsPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_COUPONS, DrugsCouponsPage.class);

		assertTrue(drugsCouponsPage.isZipInputVisible(), "Zip code input should be visible");
		assertTrue(drugsCouponsPage.isZipSearchButtonVisible(), "'Search' button should be visible near zip input");
		drugsCouponsPage.typeZip("95814");
		drugsCouponsPage.clickZipSearchButton();
		int numberOfSearchResults = drugsCouponsPage.getNumberOfSearchResultItems();
		assertTrue(numberOfSearchResults >= 1, "At least one search result should be displayed");
		for (int resultNumber = 1; resultNumber <= numberOfSearchResults; resultNumber++) {
			assertTrue(drugsCouponsPage.getResultItemAddress(resultNumber).contains("Sacramento"), "Each result item should contain location value");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C432327"})
	@TestRail(id = "C432327")
	public void verifyCoRegistration() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			DrugsCouponsPage drugsCouponsPage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_COUPONS, DrugsCouponsPage.class);

			assertTrue(drugsCouponsPage.isSearchResultContainerVisible(), "Search results container should be visible");
			assertTrue(drugsCouponsPage.getNumberOfSearchResultItems() >= 1, "At least one search result item should be visible");
			String drugName = drugsCouponsPage.getDrugHeadlineTitle();
			String drugPrice = drugsCouponsPage.getResultItemPriceValue(1);

			drugsCouponsPage.clickGetCouponButton(1);
			assertTrue(drugsCouponsPage.isRegistrationModalVisible(), "Registration modal should appear");
			Logger.info("Verify registration modal window elements");
			assertTrue(drugsCouponsPage.isCloseIconVisibleOnRegistrationModal(), "Close [x] icon should be visible");
			assertTrue(drugsCouponsPage.isDrugNameVisibleOnRegistrationModal(), "Drug name should be visible");
			assertEquals(drugsCouponsPage.getRegistrationModalDrugName(), drugName, "Incorrect drug name on modal");
			assertTrue(drugsCouponsPage.isPriceVisibleOnRegistrationModal(), "Price should be visible");
			assertEquals(drugsCouponsPage.getDrugPriceFromRegistrationModal(), drugPrice, "Incorrect drug price on modal");
			assertTrue(drugsCouponsPage.isRegistrationModalFirstNameInputVisible(), "'First name' input should be visible");
			assertTrue(drugsCouponsPage.isRegistrationModalLastNameInputVisible(), "'Last name' input should be visible");
			assertTrue(drugsCouponsPage.isRegistrationModalEmailInputVisible(), "'Email' input should be visible");
			assertTrue(drugsCouponsPage.isRegistrationModalSignUpButtonVisible(), "'Sign up' button should be visible");
			assertTrue(drugsCouponsPage.isRegistrationModalLegalTextVisible(), "Legal text should be visible");

			Logger.info("Verify legal text and links");
			assertEquals(drugsCouponsPage.getRegistrationModalLegalText(),
					"See SingleCare Support for more information. By clicking submit, you agree to SingleCare’s Member Agreement and Privacy Policy.",
					"Incorrect legal text");
			assertEquals(drugsCouponsPage.getNumberOfLinksInLegalText(), 3, "3 links should be present in legal text");
			assertEquals(drugsCouponsPage.getLegalTextLinkHrefAttributeValue(1),
					"https://support.singlecare.com/",
					"Incorrect 'SingleCare support for more information.' link");
			assertEquals(drugsCouponsPage.getLegalTextLinkHrefAttributeValue(2),
					"https://www.singlecare.com/terms-and-conditions",
					"Incorrect 'Member Agreement' link");
			assertEquals(drugsCouponsPage.getLegalTextLinkHrefAttributeValue(3),
					"https://www.singlecare.com/privacy-policy",
					"Incorrect 'Privacy Policy' link");

			Logger.info("Verify error messages for input fields");
			drugsCouponsPage.clickRegistrationModalSignUpButton();
			assertTrue(drugsCouponsPage.isFirstNameInputErrorMessageVisible(),
					"Error message should be visible for 'First name' input");
			assertTrue(drugsCouponsPage.isLastNameInputErrorMessageVisible(),
					"Error message should be visible for 'Last name' input");
			assertTrue(drugsCouponsPage.isEmailInputErrorMessageVisible(),
					"Error message should be visible for 'Email' input");
			drugsCouponsPage.typeFirstName("John" + StringUtils.generateRandomStrAlphabetic(7));
			drugsCouponsPage.clickRegistrationModalSignUpButton();
			assertFalse(drugsCouponsPage.isFirstNameInputErrorMessageVisible(),
					"Error message should not be visible for 'First name' input");
			assertTrue(drugsCouponsPage.isLastNameInputErrorMessageVisible(),
					"Error message should be visible for 'Last name' input");
			assertTrue(drugsCouponsPage.isEmailInputErrorMessageVisible(),
					"Error message should be visible for 'Email' input");
			drugsCouponsPage.typeLastName("Smith" + StringUtils.generateRandomStrAlphabetic(7));
			drugsCouponsPage.typeEmailAddress(StringUtils.generateRandomStrAlphabetic(8));
			drugsCouponsPage.clickRegistrationModalSignUpButton();
			assertFalse(drugsCouponsPage.isFirstNameInputErrorMessageVisible(),
					"Error message should not be visible for 'First name' input");
			assertFalse(drugsCouponsPage.isLastNameInputErrorMessageVisible(),
					"Error message should not be visible for 'Last name' input");
			assertTrue(drugsCouponsPage.isEmailInputErrorMessageVisible(),
					"Error message should be visible for 'Email' input");
			String email = EmailUtils.generateRandomMailGunEmailAddress();
			drugsCouponsPage.typeEmailAddress(email);
			drugsCouponsPage.clickRegistrationModalSignUpButton();

			Logger.info("Verify newsletter sign-up screen is visible");
			assertTrue(drugsCouponsPage.isNewsletterModalWindowVisible(), "Newsletter modal should be visible");
			assertTrue(drugsCouponsPage.isNewsletterModalCaptchaVisible(), "Captcha should be visible on newsletter modal");
			assertTrue(drugsCouponsPage.isNewsletterModalSkipButtonVisible(), "'Skip' button should be visible");
			assertTrue(drugsCouponsPage.getNumberOfNewsletterSignUpOptions() >= 1,
					"At least one newsletter option should appear");
			assertTrue(drugsCouponsPage.isThankYouMessageVisible(), "Thank you message should be visible");
			String cookieValue = CookiesManager.getCookieValue(CookieName.SCPricingModalWidgetCookie);
			assertFalse(cookieValue.isEmpty(), "Cookie 'SCPricingModalWidgetCookie' should be added");
			Logger.debug(cookieValue);
			drugsCouponsPage.clickNewsletterModalSkipButton();

			Logger.info("Verify delivery screen elements");
			assertTrue(drugsCouponsPage.isGetCouponModalWindowVisible(), "Delivery modal should be visible");
			assertTrue(drugsCouponsPage.isEmailButtonVisibleOnDeliveryModal(), "'Email' button should be visible");
			assertTrue(drugsCouponsPage.isTextButtonVisibleOnDeliveryModal(), "'Text' button should be visible");
			assertTrue(drugsCouponsPage.isPrintButtonVisibleOnDeliveryModal(), "'Print' button should be visible");
			drugsCouponsPage.clickDeliveryModalEmailButton();
			assertTrue(drugsCouponsPage.isDeliverySetupModalVisible(), "Delivery setup modal should be visible");
			assertTrue(drugsCouponsPage.isEmailInputVisibleOnDeliveryModal(), "'Email' input should be visible");
			assertTrue(drugsCouponsPage.isSendButtonVisibleOnDeliveryModal(), "'Send' button should be visible");
			assertFalse(drugsCouponsPage.isDeliveryNotificationMessageVisible(), "Notification should not be visible");
			drugsCouponsPage.typeEmailAddressOnDeliveryModal(email);
			drugsCouponsPage.clickDeliveryModalSendButton();
			assertTrue(drugsCouponsPage.isDeliveryNotificationMessageVisible(), "Notification should be visible");
			assertEquals(drugsCouponsPage.getDeliveryNotificationText(), "Your coupon has been sent!", "Incorrect message");
			Utils.waitFor(30000); //wait for 30 seconds for email to be sent
			String messageURL = EmailUtils.getEmailURL(email);
			assertTrue(EmailUtils.getMessageBodyByUrl(messageURL).contains("Here is your prescription discount for")
					, "Email address should get the letter from Singlecare");
		}
	}

	private void verifySocialButtonClickEvents(SocialBarEH socialBarEH, boolean isPrintButtonPresent) {
		socialBarEH.clickOnFacebookShareButton();
		socialBarEH.verifyFacebookPopUpContainsFacebook();
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event93");
		socialBarEH.clickOnTwitterShareButton();
		socialBarEH.verifyTwitterPopUpContainsTwitter();
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event94");
		socialBarEH.clickOnPinterestShareButton();
		socialBarEH.verifyPinterestPopUpContainsPinterest();
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event96");
		ShareViaEmailPopUp shareViaEmailPopUp = socialBarEH.clickEmailShareButton();
		shareViaEmailPopUp.closePopUp();
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event92");
		if (isPrintButtonPresent) {
			socialBarEH.clickPrintShareButton();
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event98");
		}
	}

	private void verifySocialButtonsVisibility(SocialBarEH socialBarEH, boolean isPrintButtonPresent) {
		assertTrue(socialBarEH.isFacebookShareButtonVisible(), "'Facebook' share button should be visible");
		assertTrue(socialBarEH.isTwitterShareButtonVisible(), "'Twitter' share button should be visible");
		assertTrue(socialBarEH.isPinterestShareButtonVisible(), "'Pinterest' share button should be visible");
		assertTrue(socialBarEH.isEmailShareButtonVisible(), "'Email' share button should be visible");
		if (isPrintButtonPresent && !Settings.isMobile()) {
			assertTrue(socialBarEH.isPrintShareButtonVisible(), "'Print' share button should be visible");
		}
	}

	private void verifyDrugPageTemplateHeadlineBar(DrugsProfilePage drugTemplatePage) {
		if (Settings.isTablet()) {
			drugTemplatePage.clickSideMenu();
		}

		assertTrue(drugTemplatePage.isDrugHeadlineTitleVisible(), "Drug headline title should be visible");
		assertEquals(drugTemplatePage.getDrugHeadlineTitle(), "Ibuprofen", "Drug headline title should be 'Ibuprofen'");
		assertTrue(drugTemplatePage.isDrugsHeadlineButtonVisible(), "'Drugs' button should be visible on headline");
		assertEquals(drugTemplatePage.getDrugsHeadlineButtonHrefAttribute(),
				Settings.getDefaultUrl() + "/drugs/",
				"'href' attribute should contain '/drugs/' value");

		assertTrue(drugTemplatePage.isSocialBarOnHeadlineVisible(), "Social bar should be visible");
		SocialBarEH socialBarEH = drugTemplatePage.onSocialBar();
		verifySocialButtonsVisibility(socialBarEH, true);
		if (Settings.isDesktop()) {
			verifySocialButtonClickEvents(socialBarEH, true);
		}
	}

	private void verifyDrugReviewPageElements(DrugsReviewsPage reviewPage) {
		assertFalse(reviewPage.isReviewSectionVisible(), "Review section should not be visible by default");
		reviewPage.clickReviewThisDrugButton();
		assertTrue(reviewPage.isReviewSectionVisible(), "Review section should be visible");
		assertTrue(reviewPage.isReviewFormVisible(), "Review form should be visible");

		assertEquals(reviewPage.getNumberOfVisibleRateFields(), 4, "4 rate fields should be visible");
		assertEquals(reviewPage.getNumberOfRateFieldsRequiredLabels(), 4, "4 'required' labels should be visible");

		assertTrue(reviewPage.isReasonDropdownVisible(), "Reason dropdown should be visible");
		assertTrue(reviewPage.isShareYouExperienceTextFieldVisible(), "Experience textfield should be visible");
		assertTrue(reviewPage.isTermsOfServiceCheckboxVisible(), "Terms of service checkbox should be visible");
		assertTrue(reviewPage.isTermsOfServiceRequiredLabelVisible(), "Terms of service 'required' label should be visible");
		assertTrue(reviewPage.isCaptchaVisible(), "Captcha checkbox should be visible");
		assertTrue(reviewPage.isCancelButtonVisible(), "'Cancel' button should be visible");
		assertTrue(reviewPage.isSubmitButtonVisible(), "'Submit' button should be visible");
	}

	private void reviewDrug(DrugsReviewsPage reviewPage, boolean positive) {
		int numberOfQuestions = positive ? reviewPage.getNumberOfVisibleRateFields() : 3;
		for (int questionNumber = 1; questionNumber <= numberOfQuestions; questionNumber++) {
			int rate = StringUtils.generateRandomInt(6);
			reviewPage.rateQuestion(questionNumber, rate);
			assertTrue(reviewPage.getStarClassAttribute(questionNumber, rate).contains("active"),
					"Selected star and below should be highlighted");
		}
		if (Settings.isDesktop()) {
			reviewPage.clickReasonDropdown();
			reviewPage.chooseReasonNumber(2);
		}
		String text = StringUtils.generateRandomStrAlphabetic(20);
		reviewPage.enterTextIntoTextField(text);
		assertEquals(reviewPage.getTextFromTextField(), text, "Entered text should be present in textfield");
		reviewPage.clickTermsOfServiceCheckbox();
		if (positive) {
			assertTrue(reviewPage.isSubmitButtonActive(), "'Submit' button should be active");
		} else {
			assertFalse(reviewPage.isSubmitButtonActive(), "'Submit' button should not be active");
		}
	}

	private void verifyDrugsBasePageElements(DrugsBasePage drugsBasePage, SocialBarEH socialBarEH) {
		assertEquals(drugsBasePage.getTitle(), "DRUGS", "Headline title should be 'DRUGS'");
		if (Settings.isDesktop()) {
			assertTrue(drugsBasePage.isSocialBarOnHeadlineVisible(), "Social bar on headline should be visible");
			verifySocialButtonsVisibility(socialBarEH, false);
			assertTrue(drugsBasePage.isTaglineVisible(), "Tagline should be visible");
			verifySocialButtonClickEvents(socialBarEH, false);
		}
	}

	private void verifyBreadcrumbsElements(DrugsBasePage drugsBasePage, String lastElementTitle) {
		assertTrue(drugsBasePage.isBreadcrumbsVisible(), "Breadcrumbs should be visible");
		int numberOfBreadcrumbsLinks = drugsBasePage.getNumberOfBreadcrumbLinks();
		for (int link = 1; link <= numberOfBreadcrumbsLinks; link++) {
			String breadcrumbUrl = drugsBasePage.getBreadcrumbLinkNumber(link);
			assertFalse(breadcrumbUrl.isEmpty(), "'href' attribute of breadcrumb links should not be empty");
			if (link == 1) {
				assertEquals(breadcrumbUrl, Settings.getDefaultUrl() + "/", "1st link should lead to homepage");
				continue;
			}
			String linkTitle = drugsBasePage.getBreadcrumbsLinksTextNumber(link).replace(" ", "-").toLowerCase();
			assertTrue(breadcrumbUrl.contains(linkTitle), "Url should contain respective title");
		}
		assertEquals(drugsBasePage.getBreadcrumbItemTitleNumber(numberOfBreadcrumbsLinks + 1),
				lastElementTitle,
				"Breadcrumb last item should be '" + lastElementTitle + "'");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "DrugsTest", "C505411"})
	@TestRail(id = "C505411")
	public void verifyPromoBannerSectionOnDrugsPage() {
		DrugsBasePage drugsBasePage = SiteNavigatorEH.goToPage(TemplatesEH.DRUGS_LANDING, DrugsBasePage.class);

		verifyPromoBannerSection(drugsBasePage);
	}
}
