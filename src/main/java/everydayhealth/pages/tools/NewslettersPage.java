package everydayhealth.pages.tools;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class NewslettersPage extends BasicPageEH {

	public NewslettersPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "tools";
		String CLASS_NAME = "NewslettersPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject newslettersTitle;
	protected WebObject subscribeSteps;
	protected WebObject newslettersOptionsHeading;

	@Override
	public void waitForPageToLoad() {
		newslettersTitle.waitUntilVisibleOnPage(this);
	}

	public boolean isNewslettersTitleVisible() {
		Logger.info("Verifying the 'Newsletter' title is visible");
		return newslettersTitle.isVisible();
	}

	public int getNumberOfSteps() {
		Logger.info("Get number of subscribe steps");
		return subscribeSteps.getVisibleElementsCount();
	}

	public boolean isNewslettersOptionsHeadingVisible() {
		Logger.info("Verifying the 'Newsletters' options heading is visible");
		return newslettersOptionsHeading.isVisible();
	}
}
