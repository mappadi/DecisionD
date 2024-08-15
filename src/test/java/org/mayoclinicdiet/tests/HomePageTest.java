package org.mayoclinicdiet.tests;

import com.testrail.framework.platform.annotations.TestRail;
import framework.platform.SiteNavigatorMCD;
import framework.platform.UserActionsMCD;
import mayoclinicdiet.pages.HomePage;
import org.testng.annotations.Test;


public class HomePageTest {

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet"})
	@TestRail(id = "C2418")
	public void defaultLoad() {
		SiteNavigatorMCD.openSharedRegistration()
				.enterFirstName("Test")
				.enterLastName("Name")
				.enterNewEmail()
				.confirmEmailAddress()
				.enterNewPassword("Password1")
				.confirmNewPassword("Password1")
				.selectCreditCard("visa")
				.enterCardNumber("4111111111111111")
				.enterSecurityCode("123")
				.selectMonth("05 - May")
				.selectYear("2017")
				.selectCountry("Canada")
				.enterZipCode("12345")
				.termsOfUseCheck()
				.submitRegistration()
				.clickGetStartedButton()
				.checkLoseItPageLoading();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "C2419"})
	@TestRail(id = "C2419")
	public void lightBoxLoseIt() {
		SiteNavigatorMCD.openSharedRegistration()
				.enterFirstName("Test")
				.enterLastName("Name")
				.enterNewEmail()
				.confirmEmailAddress()
				.enterNewPassword("Password1")
				.confirmNewPassword("Password1")
				.selectCreditCard("visa")
				.enterCardNumber("4111111111111111")
				.enterSecurityCode("123")
				.selectMonth("05 - May")
				.selectYear("2017")
				.selectCountry("Canada")
				.enterZipCode("12345")
				.termsOfUseCheck()
				.submitRegistration()
				.clickGetStartedButton()
				.checkLoseItPopUpDisplayed()
				.closePopupButton();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C2420")
	public void habitTrackerSection() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.checkHabitTrackerDisplayed();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C2421")
	public void otherSectionsLoseIt() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.checkPracticeTheHabitsSectionDisplayed()
				.checkInspirationCenterSectionDisplayed();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C2426")
	public void welcomeTextLoseIt() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.checkWelcomeTextDisplayed();
	}


	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd", "C34588"})
	@TestRail(id = "C34588")
	public void pageLoad() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLiveIt()
				.checkLiveItPageLoading();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression", "C34589"})
	@TestRail(id = "C34589")
	public void lightBoxLiveIt() {
		UserActionsMCD.registerNewUser()
				.checkIfCurrentPhaseIsLoseIt()
				.clickOnSettingLink()
				.clickLiveItRadioButton()
				.clickSaveChangesButton()
				.clickOnHomeLink()
				.checkLiveItPopUpDisplayed();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression", "C34590"})
	@TestRail(id = "C34590")
	public void howIsYourDayGoingSection() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLiveIt()
				.checkHowIsYourDayGoingSectionDisplayed();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd", "C34591"})
	@TestRail(id = "C34591")
	public void otherSectionsLiveIt() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLiveIt()
				.checkWeeklySpotlightEatingTriggersSectionDisplayed()
				.checkHealthyLivingSectionDisplayed()
				.checkInspirationCenterSectionDisplayed();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression", "smokeForProd"})
	@TestRail(id = "C34596")
	public void welcomeTextLiveIt() {
		UserActionsMCD.registerNewUser()
				.checkIfCurrentPhaseIsLiveIt()
				.checkWelcomeTextDisplayed();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C118733")
	public void memberSiteTopNavFAQLinkLoseIt() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.checkFAQLinkPresent();

	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C118734")
	public void FAQSublinkLoseIt() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.checkSiteAndToolsLinkDisplay();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C118735")
	public void memberSiteTopNavFAQLinkOnclickLoseIt() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFAQLink()
				.checkFAQsPageUrl();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C118736")
	public void memberSiteTopNavFAQSubLinkOnclickLoseIt() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLoseIt()
				.clickFAQSiteAndToolsLink()
				.checkFAQsSiteAndToolsPageUrl();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression"})
	@TestRail(id = "C118737")
	public void memberSiteTopNavFAQLinkLiveIt() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLiveIt()
				.checkFAQLinkPresent();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression", "C118738"})
	@TestRail(id = "C118738")
	public void FAQSublinkLiveIt() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLiveIt()
				.checkSiteAndToolsLinkDisplay();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression", "C118739"})
	@TestRail(id = "C118739")
	public void memberSiteTopNavFAQLinkOnclickLiveIt() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLiveIt()
				.clickFAQLink()
				.checkFAQsPageUrl();
	}

	@Test(groups = {"home", "MayoClinicDiet", "regressionSet", "prodRegression", "C118740"})
	@TestRail(id = "C118740")
	public void memberSiteTopNavFAQSubLinkOnclickLiveIt() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(HomePage.class)
				.checkIfCurrentPhaseIsLiveIt()
				.clickFAQSiteAndToolsLink()
				.checkFAQsSiteAndToolsPageUrl();
	}
}
