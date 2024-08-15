package everydayhealth.pages.landingpages;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * MasterContentPage
 */
public class MasterContentPage extends MasterLandingPage {

	public MasterContentPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "landingpages";
		String CLASS_NAME = "MasterContentPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject trustedSources;
	protected WebObject trustedSourcesTitle;
	protected WebObject trustedSourcesSeeMoreLink;
	protected WebObject trustedSourcesContent;

	public boolean isSourcesElementVisible() {
		Logger.info("Verify if 'Editorial Sources and Fact-Checking' element is visible");
		return trustedSources.isVisible();
	}

	public boolean isSourcesSeeMoreLinkVisible() {
		Logger.info("Verify if 'See more' link is visible");
		return trustedSourcesSeeMoreLink.isVisible();
	}

	public void clickSourcesSeeMoreLink() {
		Logger.info("Click 'See more' link under sources element");
		trustedSourcesSeeMoreLink.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isSourcesTitleVisible() {
		Logger.info("Verify if sources title is visible");
		return trustedSourcesTitle.isVisible();
	}

	public String getSourcesTitleText() {
		Logger.info("Get sources title text");
		return trustedSourcesTitle.getText();
	}

	public boolean isSourcesContentVisible() {
		Logger.info("Verify if sources content is visible");
		return trustedSourcesContent.isVisible();
	}

	public String getSourcesContentText() {
		Logger.info("Get sources content text");
		return trustedSourcesContent.getText();
	}
}
