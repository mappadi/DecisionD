package org.mayoclinicdiet.tests;


import com.testrail.framework.platform.annotations.TestRail;
import framework.platform.SiteNavigatorMCD;
import mayoclinicdiet.pages.MainPublicPageMCD;
import mayoclinicdiet.pages.PublicHomePage;
import org.testng.annotations.Test;

public class PublicHomePageTest {

	@Test(groups = {"publicHome", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C2411")
	public void defaultView() {
		SiteNavigatorMCD.goToMainMCDPage()
				.checkGlobalHeaderDisplayed()
				.checkNavigationBarDisplayed();
	}

	@Test(groups = {"publicHome", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C2412")
	public void links() {
		SiteNavigatorMCD.goToMainMCDPage()
				.checkSignInLinkDisplayed()
				.checkRegisterNowLinkDisplayed();
	}

	@Test(groups = {"publicHome", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C2413")
	public void diagnosticSection() {
		SiteNavigatorMCD.goToMainMCDPage(PublicHomePage.class)
				.checkDiagnosticSectionDisplayed()
				.checkWeightFieldsInDiagnosticSectionDisplayed()
				.checkHeightFieldsInDiagnosticSectionDisplayed()
				.checkAgeFieldInDiagnosticSectionDisplayed()
				.checkEmailFieldInDiagnosticSectionDisplayed()
				.checkGenderRadioButtonsInDiagnosticSectionDisplayed()
				.checkStartFreeButtonInDiagnosticSectionDisplayed()
				.checkDefaultValueInDiagnosticSectionDisplayed();
	}

	@Test(groups = {"publicHome", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C2414")
	public void section() {
		SiteNavigatorMCD.goToMainMCDPage(PublicHomePage.class)
				.checkHowItWorksSectionDisplayed()
				.checkWhatYouGetSectionDisplayed()
				.checkSuccessStoriesSectionDisplayed()
				.checkTheMayoClinicDifferenceSectionDisplayed()
				.checkReadyToGetStartedSectionDisplayed();
	}

	@Test(groups = {"publicHome", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C2415")
	public void globalFooter() {
		SiteNavigatorMCD.goToMainMCDPage(PublicHomePage.class)
				.checkGlobalFooterDisplayed()
				.checkGlobalFooterEhLogoDisplayed()
				.checkGlobalFooterLinksDisplayed()
				.checkGlobalFooterTextBlockDisplayed()
				.checkGlobalFooterTextContainerDisplayed();
	}

	@Test(groups = {"publicHome", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C2416")
	public void navigationBar() {
		SiteNavigatorMCD.goToMainMCDPage(MainPublicPageMCD.class)
				.clickTheExpertLink()
				.checkDiagnosticSectionDisplayed()
				.checkGetTheFreeNewsletterDisplayed()
				.clickHowItWorksLink()
				.checkDiagnosticSectionDisplayed()
				.checkGetTheFreeNewsletterDisplayed()
				.clickSuccessStoriesLink()
				.checkDiagnosticSectionDisplayed()
				.checkGetTheFreeNewsletterDisplayed()
				.clickRecipesLink()
				.checkDiagnosticSectionDisplayed()
				.checkGetTheFreeNewsletterDisplayed()
				.clickSampleMealPlanLink()
				.checkDiagnosticSectionDisplayed()
				.checkGetTheFreeNewsletterDisplayed();
	}
}
