package everydayhealth.pages.registrations;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OffersPage extends BasicPageEH {

	public OffersPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "registrations";
		String CLASS_NAME = "OffersPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject skipOffer;

	@Override
	public void waitForPageToLoad() {
		skipOffer.waitUntilVisibleOnPage(this);
	}

	public MainRegistrationStepTwo clickSkipOffer() {
		Logger.info("Clicking 'Skip Offer' from the offers page");
		if (Settings.isMobile()) {
			skipOffer.scrollToElement();
		}
		skipOffer.click();
		if(!Settings.isDesktop()) {
			waitFor(2000); //Wait for page to start load on device
		}
		waitForAjaxRequestToBeFinished();
		if (isSkipOfferButtonVisible()) {
			skipOffer.click();
			if(!Settings.isDesktop()) {
				waitFor(2000); //Wait for page to start load on device
			}
			waitForAjaxRequestToBeFinished();
		}
		return PageFactory.initElements(basedriver, MainRegistrationStepTwo.class);
	}

	public boolean isSkipOfferButtonVisible() {
		Logger.info("Checking if 'Skip Offer' button visible");
		if (Settings.isMobile()) {
			skipOffer.scrollToElement();
		}
		return skipOffer.isVisible();
	}

}
