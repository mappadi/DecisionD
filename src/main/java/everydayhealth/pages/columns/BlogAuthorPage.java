package everydayhealth.pages.columns;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class BlogAuthorPage extends BasicPageEH {

	public BlogAuthorPage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "columns";
		String CLASS_NAME = "BlogAuthorPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject authorName;
	protected WebObject authorImage;
	protected WebObject authorDescription;
	protected WebObject socialNetworkIcon;
	protected WebObject socialNetworkIconLink;

	@Override
	public void waitForPageToLoad() {
		authorName.waitUntilVisibleOnPage(this);
	}

	public boolean isAuthorNameVisible() {
		Logger.info("Verify if author name is visible");
		return authorName.isVisible();
	}

	public String getAuthorName() {
		Logger.info("Get author name");
		return authorName.getText();
	}

	public boolean isAuthorImageVisible() {
		Logger.info("Verify if author image is visible");
		return authorImage.isVisible();
	}

	public boolean isAuthorDescriptionVisible() {
		Logger.info("Verify if author description is visible");
		return authorDescription.isVisible();
	}

	public int getNumberOfSocialIcons() {
		Logger.info("Get number of social icons");
		return socialNetworkIcon.getNumberOfVisibleAndClickableElements();
	}

	public boolean isSocialIconVisible(int iconNumber) {
		Logger.info("Verify if social icon #" + iconNumber + " is visible");
		return socialNetworkIcon.isElementNumberVisible(iconNumber);
	}

	public String getSocialIconHrefValue(int iconNumber) {
		Logger.info("Get social icon 'href' attribute value");
		return socialNetworkIconLink.getHrefOfElementNumber(iconNumber);
	}
}