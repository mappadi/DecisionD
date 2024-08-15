package mayoclinicdiet.pages;

import framework.Logger;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class FAQsSiteAndToolsPage extends BasicPage {

	public FAQsSiteAndToolsPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "faqsSiteAndToolsPage";
		String CLASS_NAME = "FAQsSiteAndToolsPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject header;

	@Override
	public void waitForPageToLoad() {
		header.waitUntilVisible();
	}

	public FAQsSiteAndToolsPage checkFAQsSiteAndToolsPageUrl() {
		Logger.info("Check FAQs: Site and Tools page url");
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/diet/members/about-the-diet/faqs-site-and-tools"), "URL doesn't contain '/diet/members/about-the-diet/faqs-site-and-tools'");
		return this;
	}
}
