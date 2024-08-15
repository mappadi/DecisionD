package everydayhealth.pages.registrations;

import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.PublicHeaderEH;
import everydayhealth.pages.tools.DashboardPage;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object for registration page - step two
 */
public class MainRegistrationStepTwo extends BasicPageEH {

	public MainRegistrationStepTwo(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "registrations";
		String CLASS_NAME = "MainRegistrationStepTwo";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject newsletterRecommendationTitle;
	protected WebObject mainSuggestions;
	protected WebObject mainSuggestionChecked;
	protected WebObject moreSuggestions;
	protected WebObject moreSuggestionChecked;
	protected WebObject dashboardButton;

	@Override
	public void waitForPageToLoad() {
		waitForAjaxRequestToBeFinished();
		dashboardButton.waitUntilVisibleOnPage(this);
	}

	public PublicHeaderEH onHeader() {
		return new PublicHeaderEH(basedriver, "ToolsHeader");
	}

	public boolean isNewsletterRecommendationTitleVisible() {
		Logger.info("Check recommended newsletters title is visible");
		return newsletterRecommendationTitle.isVisible();
	}

	public void selectMainSuggestedNewsletter() {
		Logger.info("Clicking on one main newsletter");
		waitForAjaxRequestToBeFinished();
		if(Settings.isMobile()){
			mainSuggestions.click();
		} else {
			mainSuggestions.actionClick();
		}
	}

	public void selectMoreSuggestedNewsletter() {
		Logger.info("Clicking on one more suggested newsletter");
		moreSuggestions.click();
	}

	public int getNumberOfSuggestedNewsletterChecks() {
		Logger.info("Counting total number of subscribed checks");
		return mainSuggestionChecked.getVisibleElementsCount() + moreSuggestionChecked.getVisibleElementsCount();
	}

	public DashboardPage clickGoToDashboardButton() {
		Logger.info("Click 'go to dashboard' button to proceed to user dashboard");
		dashboardButton.click();
		waitForAjaxRequestToBeFinished();
		waitFor(2000);//need to load page
		return PageFactory.initElements(basedriver, DashboardPage.class);
	}
}
