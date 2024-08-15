package framework.platform;

import framework.Settings;
import mayoclinicdiet.pages.HomePage;

public class UserActionsMCD {


	public static HomePage registerNewUser() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			return SiteNavigatorMCD.openSharedRegistration()
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
					.selectYear("2019")
					.selectCountry("Canada")
					.enterZipCode("12345")
					.termsOfUseCheck()
					.submitRegistration()
					.clickGetStartedButton()
					.closePopupButton();
		} else {
			return loginWithUser(UserCacheMCD.USER_TWO);
		}
	}

	public static HomePage registerNewUserQuiz() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			return SiteNavigatorMCD.openSharedRegistration()
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
					.clickGetStartedButton();
		} else {
			return loginWithUser(UserCacheMCD.USER_TWO)
					.checkIfCurrentPhaseIsLoseIt()
					.clickWhyYouShouldTrackYourHabitsLink();
		}
	}

	public static HomePage registerNewUserHabitTracker() {
		if (!Settings.isEnvironment(Environment.PROD)) {
			return SiteNavigatorMCD.openSharedRegistration()
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
					.closePopupButton();
		} else {
			return loginWithUser(UserCacheMCD.USER_TWO)
					.checkIfCurrentPhaseIsLoseIt();
		}
	}

	public static HomePage loginWithUser(UserMCD user) {
		return SiteNavigatorMCD.goToMainMCDPage()
				.openSignInPage()
				.submitLogin(user);
	}
}
