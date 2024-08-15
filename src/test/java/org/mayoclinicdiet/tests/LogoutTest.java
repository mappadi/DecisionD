package org.mayoclinicdiet.tests;


import com.testrail.framework.platform.annotations.TestRail;
import framework.platform.SiteNavigatorMCD;
import mayoclinicdiet.pages.LoginPage;
import org.testng.annotations.Test;

public class LogoutTest {

	@Test(groups = {"logout", "MayoClinicDiet", "smokeSet", "smokeForProd", "regressionSet", "prodRegression"})
	@TestRail(id = "C7912")
	public void logoutPageLoad() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.submitLogin()
				.checkLogoutHeaderPresent()
				.clickLogOutHeader()
				.checkLogoutUrl()
				.checkLogoutPage();
	}

	@Test(groups = {"logout", "MayoClinicDiet", "smokeSet", "regressionSet", "prodRegression"})
	@TestRail(id = "C7913")
	public void overallPageAlignment() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.submitLogin()
				.checkLogoutHeaderPresent()
				.clickLogOutHeader()
				.checkLogoutUrl()
				.checkHeaderAlignment()
				.checkTextAlignment()
				.checkPromoBannerAlignment();
	}

	@Test(groups = {"logout", "MayoClinicDiet", "smokeSet", "regressionSet", "prodRegression"})
	@TestRail(id = "C7914")
	public void logInAgainButtonCss() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.submitLogin()
				.checkLogoutHeaderPresent()
				.clickLogOutHeader()
				.checkLogInAgainButtonCss();
	}

	@Test(groups = {"logout", "MayoClinicDiet", "smokeSet", "regressionSet", "prodRegression"})
	@TestRail(id = "C7915")
	public void loginAgainButtonDefaultColour() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.submitLogin()
				.checkLogoutHeaderPresent()
				.clickLogOutHeader()
				.checkLogInAgainButtonColour();
	}

	@Test(groups = {"logout", "MayoClinicDiet", "smokeSet", "regressionSet", "prodRegression"})
	@TestRail(id = "C7916")
	public void loginAgainButtonColourChange() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.submitLogin()
				.checkLogoutHeaderPresent()
				.clickLogOutHeader()
				.hoverMouseOverLogInAgainButton()
				.checkHoverOverLogInAgainButtonColour();
	}

	@Test(groups = {"logout", "MayoClinicDiet", "smokeSet", "smokeForProd", "regressionSet", "prodRegression"})
	@TestRail(id = "C7917")
	public void loginAgainFunctionality() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.submitLogin()
				.checkLogoutHeaderPresent()
				.clickLogOutHeader()
				.clickLogInAgainButton()
				.checkLoginTitlePresent();
	}

	@Test(groups = {"logout", "MayoClinicDiet", "smokeSet", "regressionSet", "prodRegression"})
	@TestRail(id = "C7918")
	public void backGroundImage() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.submitLogin()
				.checkLogoutHeaderPresent()
				.clickLogOutHeader()
				.checkLogoutUrl()
				.checkBackgroundImage();
	}

	@Test(groups = {"logout", "MayoClinicDiet", "smokeSet", "regressionSet", "prodRegression"})
	@TestRail(id = "C7919")
	public void text() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.submitLogin()
				.checkLogoutHeaderPresent()
				.clickLogOutHeader()
				.checkLogoutUrl()
				.checkFirstTextRow()
				.checkSecondTextRow();
	}

	@Test(groups = {"logout", "MayoClinicDiet", "smokeSet", "smokeForProd", "regressionSet", "prodRegression"})
	@TestRail(id = "C7920")
	public void backButtonAfterLogout() {
		SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.checkLoginTitlePresent()
				.submitLogin()
				.checkLogoutHeaderPresent()
				.clickLogOutHeader()
				.checkLogoutUrl()
				.clickBackBrowserButton(LoginPage.class)
				.checkLoginTitlePresent();
	}
}
