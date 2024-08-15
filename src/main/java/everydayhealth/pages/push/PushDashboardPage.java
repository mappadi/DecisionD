package everydayhealth.pages.push;

import framework.Logger;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

/**
 * PushDashboardPage
 */
public class PushDashboardPage extends BasicPage {

	public PushDashboardPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "push";
		String CLASS_NAME = "PushDashboardPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject dashboard;
	protected WebObject dashboardNavigation;
	protected WebObject dashboardNavigationItem;
	protected WebObject quickLaunchBar;
	protected WebObject editIcon;
	protected WebObject saveArticleButton;

	@Override
	public void waitForPageToLoad() {
		dashboard.waitUntilVisibleOnPage(this);
	}

	public void clickSaveArticleButton() {
		Logger.info("Click 'Save Article' button");
		saveArticleButton.click();
		Utils.waitFor(1200); //as per task
	}

	public void waitForEditPageToLoad() {
		Logger.info("Wait for Edit page to load");
		editIcon.waitUntilVisible();
	}

	public boolean isLeftNavMenuVisible() {
		Logger.info("Verify if left navigation menu bar is visible");
		return dashboardNavigation.isVisible();
	}

	public String getLeftNavBarItemText(int itemNumber) {
		Logger.info("Get left navigation menu item text");
		dashboardNavigation.mouseHover();
		waitForAjaxRequestToBeFinished();
		return dashboardNavigationItem.getTextFromElementNumber(itemNumber);
	}

	public boolean isQuickLaunchBarVisible() {
		Logger.info("Verify if quick launch bar is visible");
		return quickLaunchBar.isVisible();
	}
}
