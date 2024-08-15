package mayoclinicdiet.pages;

import framework.Logger;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class FAQsPage extends BasicPage {

	public FAQsPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "faqsPage";
		String CLASS_NAME = "FAQsPage";
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

	public FAQsPage checkFAQsPageUrl() {
		Logger.info("Check FAQs page url");
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/diet/members/about-the-diet/faqs"), "URL doesn't contain '/diet/members/about-the-diet/faqs'");
		return this;
	}
}
