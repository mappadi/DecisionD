package org.mayoclinicdiet.tests;

import com.testrail.framework.platform.annotations.TestRail;
import framework.platform.SiteNavigatorMCD;
import framework.platform.utilities.Utils;
import framework.platform.utilities.WindowUtils;
import mayoclinicdiet.pages.GlobalFooterPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainFooterTest {

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432239"})
	@TestRail(id = "C432239")
	public void verifyAboutUsLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isAboutUsLinkVisible(), "'About us' link is not Visible");
		globalFooterPage.clickAboutUsLink();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "http://corporate.everydayhealth.com/Home/default.aspx", "Current URL did not match the Expected URL");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432240"})
	@TestRail(id = "C432240")
	public void verifyMayoClinicLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isMayoClinicLinkVisible(), "Mayo Clinic Link is not Visible");
		globalFooterPage.clickMayoClinicLink();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "http://diet.mayoclinic.org/diet/the-experts","Current URL did not match the Expected URL");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432241"})
	@TestRail(id = "C432241")
	public void verifyContactUsLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isContactUsLinkVisible(), "Contact Use Link is not Visible");
		globalFooterPage.clickContactUsLink();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "http://diet.mayoclinic.org/diet/contact-us","Current URL did not match the Expected URL");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432242"})
	@TestRail(id = "C432242")
	public void verifyNeedHelpLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isNeedHelpLinkVisible(), "Need Help link is not Visible");
		globalFooterPage.clickNeedHelpLink();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "http://diet.mayoclinic.org/diet/need-help","Current URL did not match the Expected URL");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432243"})
	@TestRail(id = "C432243")
	public void verifyTermsOfUseLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isTermsOfUseLinkVisible(), "Terms Of Use link is not Visible");
		globalFooterPage.clickTermsOfUseLink();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "http://diet.mayoclinic.org/diet/terms-of-use","Current URL did not match the Expected URL");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432244"})
	@TestRail(id = "C432244")
	public void verifyPrivacyPolicyLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isPrivacyPolicyFooterLinkVisible(), "Privacy Policy link is not Visible");
		globalFooterPage.clickPrivacyPolicyFooterLink();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "http://diet.mayoclinic.org/diet/privacy-policy","Current URL did not match the Expected URL");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432245"})
	@TestRail(id = "C432245")
	public void verifyAdvertisingPolicyLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isAdvertisingPolicyLinkVisible(), "Advertising Policy link is not Visible");
		globalFooterPage.clickAdvertisingPolicyLink();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "https://www.mayoclinic.org/about-this-site/advertising-sponsorship-policy","Current URL did not match the Expected URL");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432246"})
	@TestRail(id = "C432246")
	public void verifyBecomeAnAffiliateLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isBecomeAnAffiliateLinkVisible(), "Become an Affiliate link is not Visible");
		globalFooterPage.clickBecomeAnAffiliate();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "http://diet.mayoclinic.org/diet/affiliate-program","Current URL did not match the Expected URL");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432247"})
	@TestRail(id = "C432247")
	public void verifySignUpLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isSignUpLinkVisiable(), "Sign Up link is not Visible");
		globalFooterPage.clickSignUpLink();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "https://register.diet.mayoclinic.org/","Current URL did not match the Expected URL");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432248"})
	@TestRail(id = "C432248")
	public void verifyAdChoicesLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isAdChoicesLinkVisible(), "AdChoices link is not Visible");
		globalFooterPage.clickAdChoices();
		assertTrue(globalFooterPage.isAdChoicesPopUpVisible(), "AdChoices Popup is not Visible");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432249"})
	@TestRail(id = "C432249")
	public void verifyCopyRightText() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isEverydayHealthLogoVisible(), "EveryDayHealth Logo is not Visible");
		assertEquals(globalFooterPage.getCopyRightText(), "© 2018 Mayo Foundation for Medical Education and Research. All rights reserved.");
		assertEquals(globalFooterPage.getTextDisclaimer(), "The material on this web site is provided for educational purposes only, and is not to be used for medical advice, diagnosis or treatment. See additional information . Use of this site is subject to our terms of use and privacy policy.");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432250"})
	@TestRail(id = "C432250")
	public void verifyTermsOfUseSecondLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isTermsOfUseSecondLinkVisible(), "Terms Of Use second link is not Visible");
		globalFooterPage.clickTermsOfUseSecondLink();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "http://diet.mayoclinic.org/diet/terms-of-use","Current URL did not match the Expected URL");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432251"})
	@TestRail(id = "C432251")
	public void verifyPrivacyPolicySecondLink() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isPrivacyPolicyLink(), "Privacy Policy Second Link is not Visible");
		globalFooterPage.clickPrivacyPolicyLink();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "http://diet.mayoclinic.org/diet/privacy-policy","Current URL did not match the Expected URL");
	}

	@Test(groups = {"GlobalFooterPage", "MayoClinicDiet", "C432252"})
	@TestRail(id = "C432252")
	public void verifySeeAdditionalInformation() {
		GlobalFooterPage globalFooterPage = SiteNavigatorMCD.goToMainMCDPage(GlobalFooterPage.class);
		assertTrue(globalFooterPage.isSeeAdditionalInformationLink(), "See additional information Link is not Visible");
		globalFooterPage.clickSeeAdditionalInformationLink();
		WindowUtils.switchToLastOpenedWindow();
		assertEquals(Utils.getCurrentURL(), "http://diet.mayoclinic.org/diet/additional-information");
	}
}