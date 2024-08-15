package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.html.HtmlBasePage;
import framework.Settings;
import framework.platform.SiteNavigatorEH;
import framework.platform.TemplatesEH;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * HtmlPageTest
 */
public class HtmlPageTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "HtmlPage", "C235443"})
	@TestRail(id = "C235443")
	public void verifyHtmlPageContent() {
		HtmlBasePage htmlPage = SiteNavigatorEH.goToPage(TemplatesEH.HTML_CALORIE_COUNTER, HtmlBasePage.class);
		verifyPageContent(htmlPage);
		htmlPage = SiteNavigatorEH.goToPage(TemplatesEH.HTML_DIABETES_MEAL_PLANNER, HtmlBasePage.class);
		verifyPageContent(htmlPage);
		htmlPage = SiteNavigatorEH.goToPage(TemplatesEH.HTML_MEAL_PLANNER, HtmlBasePage.class);
		verifyPageContent(htmlPage);
	}

	private void verifyPageContent(HtmlBasePage htmlPage) {
		if (!Settings.isMobile()) {
			assertTrue(htmlPage.isIntroImageVisible(), "Intro image is not visible");
			assertTrue(htmlPage.isIntroTitleVisible(), "Intro title is not visible");
			assertTrue(htmlPage.isIntroTextVisible(), "Intro text is not visible");
		}
		assertTrue(htmlPage.isRegistrationFormVisible(), "Registraion form is not visible");
		assertTrue(htmlPage.isTipSectionBlockVisible(), "Tip section is not visible");
		int tipCount = htmlPage.getTipSectionsCount();
		for (int elementNumber = 1; elementNumber <= tipCount; elementNumber++) {
			assertTrue(htmlPage.isTipTitleNumberVisible(elementNumber), "Tip title is not visible for element " + elementNumber);
			assertTrue(htmlPage.isTipImageNumberVisible(elementNumber), "Tip image is not visible for element " + elementNumber);
			assertTrue(htmlPage.isTipDescriptionNumberVisible(elementNumber), "Tip description is not visible for element " + elementNumber);
		}
		assertTrue(htmlPage.isCallOutSectionVisible(), "Call out section is not visible");
		assertTrue(htmlPage.isCallOutTitleVisible(), "Call out title is not visible");
		assertTrue(htmlPage.isCallOutButtonVisible(), "Call out button is not visible");
		assertTrue(htmlPage.isCalloutButtonHrefValueValidURL(), "Call out button href is not correct");
		assertTrue(htmlPage.isFeaturesSectionVisible(), "Features section is not visible");
	}
}