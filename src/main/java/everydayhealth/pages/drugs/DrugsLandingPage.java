package everydayhealth.pages.drugs;

import org.openqa.selenium.WebDriver;

/**
 * DrugsLandingPage
 */
public class DrugsLandingPage extends DrugsBasePage {

	public DrugsLandingPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "drugs";
		String CLASS_NAME = "DrugsLandingPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	@Override
	public void waitForPageToLoad() {
		drugsHeadline.waitUntilVisibleOnPage(this);
	}
}
