package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.login.ForgotPasswordPage;
import everydayhealth.pages.login.LoginPageEH;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.CookieName;
import framework.platform.SiteNavigatorEH;
import framework.platform.UserCacheEH;
import framework.platform.UserEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Login Test Positive and Negative
 */
public class LoginTest {

	UserEH user = UserCacheEH.MAIN_USER;
	private final String SUPPORT_EMAIL = "support@EverydayHealth.com";
	private final String SUPPORT_PHONE = "(888) 795-4719";

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "EverydayHealthSmoke", "LoginLogout", "C187473"})
	@TestRail(id = "C187473")
	public void loginPositive() {
		Logger.info("Verifying the login page with user positive scenario");
		LoginPageEH loginPageEH = SiteNavigatorEH.goToMainPageEH().onGlobalNavHeader().clickLogin();
		assertTrue(Utils.isConnectionHTTPS(), "Connection is not https");
		loginPageEH.enterCredentialsAndSubmitForm(user);
		assertTrue(loginPageEH.onGlobalNavHeader().isLoggedIn(), "Main User should be logged in");
		assertTrue(Utils.isConnectionHTTPS(), "Login should redirect to homepage 'https:'");
		assertTrue(Utils.getCurrentURL().replace("?isautomation=true", "").endsWith("/"), "'/' should be the last character");
		String cookieValue = CookiesManager.getCookieValue(CookieName.Profile);
		assertTrue(!cookieValue.isEmpty(), "Cookie value for cookie 'Profile' not available");
		Logger.info("Value of the cookie 'Profile' is " + cookieValue);
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "EverydayHealthSmoke", "LoginLogout", "C187474"})
	@TestRail(id = "C187474")
	public void loginNegative() {
		Logger.info("Verifying the login modal form field validation");
		LoginPageEH loginPageEH = SiteNavigatorEH.goToMainPageEH().onGlobalNavHeader().clickLogin();
		Logger.info("Verifying the submit button is disabled without field data");
		assertTrue(loginPageEH.isSubmitButtonDisabled(), "Submit button should be disabled without data in fields");
		Logger.info("Verifying the submit button is disabled with only email data");
		loginPageEH.setEmail(user.getEmail());
		assertTrue(loginPageEH.isSubmitButtonDisabled(), "Submit button should be disabled without data in fields");
		Logger.info("Verifying the submit button is disabled with only password data");
		loginPageEH.setEmail("");
		loginPageEH.setPassword(user.getPassword());
		assertTrue(loginPageEH.isSubmitButtonDisabled(), "Submit button should be disabled without data in fields");
		Logger.info("Verifying the error messaging permutations: invalid email address");
		loginPageEH.setEmail("testusermain@mail");
		loginPageEH.setPassword(user.getPassword());
		loginPageEH.clickSubmitButton();
		assertTrue(loginPageEH.waitForErrorMessageVisible().isErrorMessageVisible(), "Error message should be visible");
		Logger.info("Verifying the error messaging permutations: wrong password");
		loginPageEH.setEmail(user.getEmail());
		loginPageEH.setPassword("123");
		loginPageEH.clickSubmitButton();
		assertTrue(loginPageEH.waitForErrorMessageVisible().isErrorMessageVisible(), "Error message should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "EverydayHealthSmoke", "LoginLogout", "C187475"})
	@TestRail(id = "C187475")
	public void forgotPassword() {
		Logger.info("Verifying the forgot password feature on the login page");
		ForgotPasswordPage forgotPasswordPage = SiteNavigatorEH.goToMainPageEH().onGlobalNavHeader().clickLogin().clickForgotPassword();
		assertTrue(WebDriverManager.getDriver().getCurrentUrl().contains("forgot-password"), "User should be taken to the '/forgot-password/' URL");
		assertTrue(Utils.isConnectionHTTPS(), "'/forgot-password/' page should be 'HTTPS' connection");
		assertTrue(forgotPasswordPage.isForgotPasswordTitleVisible(), "Forgot password title should be visible");
		Logger.info("Validating forgot password email field inline validation and submit button is disabled");
		forgotPasswordPage.enterForgotPasswordEmail("testusermain@mail");
		assertTrue(forgotPasswordPage.isForgotPasswordInputValidationErrorVisible(), "Forgot password field inline error validation should be visible");
		assertFalse(forgotPasswordPage.isForgotPasswordSubmitButtonEnabled(), "Submit button should be disabled with invalid data");
		Logger.info("Validating forgot password email field inline validation and submit button is correctly enabled");
		forgotPasswordPage.enterForgotPasswordEmail(user.getEmail());
		assertTrue(forgotPasswordPage.isForgotPasswordInputValidationSuccessVisible(), "Forgot password field inline success validation should be visible");
		Logger.info("Validating forgot password email successful submit and messaging");
		forgotPasswordPage.clickForgotPasswordSubmitButton();
		assertTrue(forgotPasswordPage.isForgotPasswordSuccssMessageCorrect(), "Forgot password success messaging is incorrect");
		assertTrue(forgotPasswordPage.isForgotPasswordSuccessMessageVisible(), "Forgot password success message should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "EverydayHealthSmoke", "LoginLogout", "C191086"})
	@TestRail(id = "C191086")
	public void forgotPasswordNegative() {
		Logger.info("Verifying the forgot password feature on the login page by submitting an unregistered email account");
		ForgotPasswordPage forgotPasswordPage = SiteNavigatorEH.goToMainPageEH().onGlobalNavHeader().clickLogin().clickForgotPassword();
		assertTrue(WebDriverManager.getDriver().getCurrentUrl().contains("forgot-password"), "User should be taken to the '/forgot-password/' URL");
		assertTrue(Utils.isConnectionHTTPS(), "'/forgot-password/' page should be 'HTTPS' connection");
		forgotPasswordPage.enterForgotPasswordEmail(StringUtils.generateRandomEmail());
		forgotPasswordPage.clickForgotPasswordSubmitButton();
		assertTrue(forgotPasswordPage.isForgotPasswordErrorMessageVisible(), "Forgot password error message should be visible");
		assertTrue(forgotPasswordPage.isForgotPasswordErrorMessageCorrect(), "Forgot password error message contain contact support help messaging");
		assertEquals(forgotPasswordPage.getForgotPasswordErrorMessageContacts(), 2, "There should be two methods of contact support: email and phone");
		assertEquals(forgotPasswordPage.getForgotPasswordErrorMessageContactLinks(1), SUPPORT_EMAIL, "Support email address is not " + SUPPORT_EMAIL);
		assertEquals(forgotPasswordPage.getForgotPasswordErrorMessageContactLinks(2), SUPPORT_PHONE, "Support email address is not " + SUPPORT_PHONE);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "EverydayHealthSmoke", "LoginLogout", "C187476"})
	@TestRail(id = "C187476")
	public void logoutUser() {
		Logger.info("Validating the user logout action");
		LoginPageEH loginPageEH = SiteNavigatorEH.goToMainPageEH().onGlobalNavHeader().clickLogin();
		assertTrue(Utils.isConnectionHTTPS(), "Connection is not https");
		loginPageEH.enterCredentialsAndSubmitForm(user);
		loginPageEH.onGlobalNavHeader().userLogOut();
		assertTrue(loginPageEH.onGlobalNavHeader().isEhLogoVisible(), "Everyday Health logo should be visible");
		assertFalse(loginPageEH.onGlobalNavHeader().isLoggedIn(), "User should be logged out");
	}
}