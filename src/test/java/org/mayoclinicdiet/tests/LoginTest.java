package org.mayoclinicdiet.tests;


import com.testrail.framework.platform.annotations.TestRail;
import framework.Settings;
import framework.platform.SiteNavigatorMCD;
import org.testng.annotations.Test;

public class LoginTest {

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet", "smokeForProd", "regressionSet", "prodRegression"})
	@TestRail(id = "C2539")
	public void loginPageLoad() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.checkEmailFieldPresent()
				.checkPasswordFieldPresent()
				.checkLogInButtonPresent()
				.checkForgotYourPasswordLinkPresent()
				.checkRememberMeCheckboxPresent();
	}

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet", "regressionSet", "prodRegression"})
	@TestRail(id = "C2541")
	public void verifyEmailIdTextBox() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkEmailFieldPresent()
				.typeEmail(Settings.config.getAdminEmail())
				.checkTextInEmailField();
	}

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet", "regressionSet", "prodRegression"})
	@TestRail(id = "C2542")
	public void verifyPasswordEncryption() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkPasswordFieldPresent()
				.typePassword("password")
				.checkTextInPasswordField();
	}

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet", "smokeForProd", "regressionSet", "prodRegression"})
	@TestRail(id = "C2543")
	public void incorrectPasswordTest() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.typeEmail(Settings.config.getAdminEmail())
				.typePassword("password11")
				.clickLoginButtonAndStayOnTheSamePage()
				.checkErrorMessagePresent();
	}

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet", "smokeForProd", "regressionSet", "prodRegression"})
	@TestRail(id = "C2544")
	public void incorrectEmailTest() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.typeEmail("kogan@gmail.com")
				.typePassword(Settings.config.getAdminPassword())
				.clickLoginButtonAndStayOnTheSamePage()
				.checkErrorMessagePresent();
	}

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet", "smokeForProd", "regressionSet", "prodRegression"})
	@TestRail(id = "C2545")
	public void blankEmailAndPasswordFieldsTest() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.clickLoginButtonAndStayOnTheSamePage()
				.checkErrorMessagePresent();
	}

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet", "smokeForProd", "regressionSet", "prodRegression"})
	@TestRail(id = "C2546")
	public void incorrectEmailAndPasswordFieldsTest() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.typeEmail("kogan@gmail.com")
				.typePassword("password11")
				.clickLoginButtonAndStayOnTheSamePage()
				.checkErrorMessagePresent();
	}

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet", "smokeForProd", "regressionSet", "prodRegression"})
	@TestRail(id = "C2547")
	public void correctEmailAndPasswordFieldsTest() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.typeEmail(Settings.config.getAdminEmail())
				.typePassword(Settings.config.getAdminPassword())
				.clickLoginButtonAndGoToMainPage()
				.checkLogoutHeaderPresent();
	}

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet", "regressionSet", "prodRegression"})
	@TestRail(id = "C2550")
	public void logInButtonColourChange() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLogInButtonPresent()
				.hoverMouseOverLogInButton()
				.checkHoverOverLogInButtonColour();
	}

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet", "regressionSet", "prodRegression"})
	@TestRail(id = "C2551")
	public void logInButtonCss() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLogInButtonPresent()
				.checkLoginButtonCss();
	}

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C2552")
	public void checkDefaultColourOfLogInButton() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLogInButtonPresent()
				.checkLogInButtonDefaultColour();
	}

	@Test(groups = {"login", "MayoClinicDiet", "smokeSet"})
	@TestRail(id = "C2553")
	public void verifyHttpsStatusTest() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.checkHttpsStatusConnection();
	}
}
