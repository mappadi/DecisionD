package mayoclinicdiet.pages;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class PublicHomePage extends MainPublicPageMCD {

	public PublicHomePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "publicHomePage";
		String CLASS_NAME = "PublicHomePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject howItWorksSection;
	protected WebObject whatYouGetSection;
	protected WebObject successStorySection;
	protected WebObject theMayoClinicDifferenceSection;
	protected WebObject readyToGetStartedSection;

	public PublicHomePage checkHowItWorksSectionDisplayed() {
		Logger.info("'How It Works' section is displayed");
		boolean isHowItWorksSectionDisplayed =
				howItWorksSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isHowItWorksSectionDisplayed, "'How It Works' section is not displayed");
		return this;
	}

	public PublicHomePage checkWhatYouGetSectionDisplayed() {
		Logger.info("'What You Get' section is displayed");
		boolean isWhatYouGetSectionDisplayed =
				whatYouGetSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isWhatYouGetSectionDisplayed, "'What You Get' section is not displayed");
		return this;
	}

	public PublicHomePage checkSuccessStoriesSectionDisplayed() {
		Logger.info("'Success Stories' section is displayed");
		boolean isSuccessStoriesSectionDisplayed =
				successStorySection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isSuccessStoriesSectionDisplayed, "'Success Stories' section is not displayed");
		return this;
	}

	public PublicHomePage checkTheMayoClinicDifferenceSectionDisplayed() {
		Logger.info("'The Mayo Clinic Difference' section is displayed");
		boolean isTheMayoClinicSectionDisplayed =
				theMayoClinicDifferenceSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isTheMayoClinicSectionDisplayed, "'The Mayo Clinic Difference' section is not displayed");
		return this;
	}

	public PublicHomePage checkReadyToGetStartedSectionDisplayed() {
		Logger.info("'Ready to get started?' section is displayed");
		boolean isReadyToGetStartedSectionDisplayed =
				readyToGetStartedSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isReadyToGetStartedSectionDisplayed, "'Ready to get started?' section is not displayed");
		return this;
	}
}
