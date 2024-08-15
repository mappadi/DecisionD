package mayoclinicdiet.pages;

import framework.Logger;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import framework.platform.utilities.WindowUtils;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class GlobalFooterPage extends BasicPage {

	public GlobalFooterPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "footer";
		String CLASS_NAME = "MainFooter";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject aboutUsLink;
	protected WebObject mayoClinicLink;
	protected WebObject contactUsLink;
	protected WebObject needHelpLink;
	protected WebObject termsOfUseLink;
	protected WebObject advertisingPolicyLink;
	protected WebObject becomeAnAffiliateLink;
	protected WebObject signUpLink;
	protected WebObject adChoicesLink;
	protected WebObject adChoicesPopUp;
	protected WebObject everydayHealthLogo;
	protected WebObject copyRightText;
	protected WebObject textDisclaimer;
	protected WebObject termsOfUseSecondLink;
	protected WebObject privacyPolicyFooterLink;
	protected WebObject privacyPolicyLink;
	protected WebObject seeAdditionalInformationLink;

	public void waitForPageToLoad() {
		copyRightText.waitUntilVisible();
	}

	public boolean isAboutUsLinkVisible() {
		Logger.info("Verify About Us Link is visible");
		return aboutUsLink.isVisible();
	}

	public void clickAboutUsLink() {
		Logger.info("Click 'About us' link");
		aboutUsLink.click();
	}

	public boolean isMayoClinicLinkVisible() {
		Logger.info("Verify Mayo Clinic Link is visible");
		return mayoClinicLink.isVisible();
	}

	public void clickMayoClinicLink() {
		Logger.info("Click 'Mayo Clinic' link");
		mayoClinicLink.click();
	}

	public boolean isContactUsLinkVisible() {
		Logger.info("Verify Contact Us Link is visible");
		return contactUsLink.isVisible();
	}

	public void clickContactUsLink() {
		Logger.info("Click 'Contact Us' link");
		contactUsLink.click();
	}

	public boolean isNeedHelpLinkVisible() {
		Logger.info("Verify Need Help link is visible");
		return needHelpLink.isVisible();
	}

	public void clickNeedHelpLink() {
		Logger.info("Click 'Need Help' link");
		needHelpLink.click();
	}

	public boolean isTermsOfUseLinkVisible() {
		Logger.info("Verify Terms Of Use link is visible");
		return termsOfUseLink.isVisible();
	}

	public void clickTermsOfUseLink() {
		Logger.info("Click 'Terms Of Use' link");
		termsOfUseLink.click();
	}

	public boolean isPrivacyPolicyFooterLinkVisible() {
		Logger.info("Verify Privacy policy is visible");
		return privacyPolicyFooterLink.isVisible();
	}

	public void clickPrivacyPolicyFooterLink() {
		Logger.info("Click Privacy Policy link");
		privacyPolicyFooterLink.click();
	}

	public boolean isAdvertisingPolicyLinkVisible() {
		Logger.info("Verify Advertising policy is visible");
		return advertisingPolicyLink.isVisible();
	}

	public void clickAdvertisingPolicyLink() {
		Logger.info("Click Advertising Policy link");
		advertisingPolicyLink.click();
	}

	public boolean isBecomeAnAffiliateLinkVisible() {
		Logger.info("Verify Become an Affiliate is visible");
		return becomeAnAffiliateLink.isVisible();
	}

	public void clickBecomeAnAffiliate() {
		Logger.info("Click Become an Affiliate Link");
		becomeAnAffiliateLink.click();
	}

	public boolean isSignUpLinkVisiable() {
		Logger.info("Verify Sign Up Link is visible");
		return signUpLink.isVisible();
	}

	public void clickSignUpLink() {
		Logger.info("Click Sign Up Link");
		signUpLink.click();
	}

	public boolean isAdChoicesLinkVisible() {
		Logger.info("Verify AdChoices is visible");
		return adChoicesLink.isVisible();
	}

	public void clickAdChoices() {
		Logger.info("Click the Adchoices Link");
		adChoicesLink.click();
	}

	public boolean isAdChoicesPopUpVisible() {
		Logger.info("Verify Adchoices popup is visible");
		return adChoicesPopUp.isVisible();
	}

	public boolean isEverydayHealthLogoVisible() {
		Logger.info("Verify Everydayhealth Logo is visible");
		return everydayHealthLogo.isVisible();
	}

	public String getCopyRightText() {
		Logger.info("Get Copyright text ");
		return copyRightText.getText();
	}

	public String getTextDisclaimer() {
		Logger.info("Get text content ");
		return textDisclaimer.getText();
	}

	public boolean isTermsOfUseSecondLinkVisible() {
		Logger.info("Verify Terms of Use second link is visible");
		return termsOfUseSecondLink.isVisible();
	}

	public void clickTermsOfUseSecondLink() {
		Logger.info("Click Terms Of Use Link");
		termsOfUseSecondLink.click();
	}

	public boolean isPrivacyPolicyLink() {
		Logger.info("Verify Privacy policy second link is visible");
		return privacyPolicyLink.isVisible();
	}

	public void clickPrivacyPolicyLink() {
		Logger.info("Click Terms Of Use Link");
		privacyPolicyLink.click();
	}

	public boolean isSeeAdditionalInformationLink() {
		Logger.info("Verify See Additional Information link is visible");
		return seeAdditionalInformationLink.isVisible();
	}

	public void clickSeeAdditionalInformationLink() {
		Logger.info("Click See Additional Information link");
		seeAdditionalInformationLink.click();
	}
}