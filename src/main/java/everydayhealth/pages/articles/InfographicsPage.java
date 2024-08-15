package everydayhealth.pages.articles;

import framework.Logger;
import framework.platform.html.WebObject;

import org.openqa.selenium.WebDriver;

/**
 * Infographics page Items
 */
public class InfographicsPage extends ArticleNewTemplatePage {

	public InfographicsPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "InfographicsPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject infographicsModule;
	protected WebObject pinterest;
	protected WebObject relatedLinksHeading;
	protected WebObject relatedLinks;
	
	@Override
	public void waitForPageToLoad() {
		infographicsModule.waitUntilVisibleOnPage(this);
	}
	
	public boolean isPinterestVisible() {
		Logger.info("Verify pinterest is visible");
		infographicsModule.mouseHover();
		waitFor(2000);
		return pinterest.isVisible();
	}
	
	public String getRelatedLinksHeading() {
		Logger.info("Get 'Related Links Heading' text");
		return relatedLinksHeading.getText();
	}
	
	public int getVisibleRelatedLinksCount() {
		Logger.info("Get visible 'relatedLinks' count");
		return relatedLinks.getNumberOfVisibleAndClickableElements();
	}
}