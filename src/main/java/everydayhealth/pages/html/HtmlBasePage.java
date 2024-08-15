package everydayhealth.pages.html;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class HtmlBasePage extends BasicPageEH {

	public HtmlBasePage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "html";
		String CLASS_NAME = "HtmlBasePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject introImage;
	protected WebObject introTitle;
	protected WebObject introText;
	protected WebObject registrationForm;
	protected WebObject tipsSectionBlock;
	protected WebObject tipSection;
	protected WebObject tipTitle;
	protected WebObject tipImage;
	protected WebObject tipDescription;
	protected WebObject callOutSection;
	protected WebObject callOutTitle;
	protected WebObject callOutButton;
	protected WebObject featureSection;

	@Override
	public void waitForPageToLoad() {
		introImage.waitUntilVisibleOnPage(this);
	}

	public boolean isIntroImageVisible() {
		Logger.info("Verify intro image is visible");
		return introImage.isVisible();
	}

	public boolean isIntroTitleVisible() {
		Logger.info("Verify Intro Title is visible");
		return introTitle.isVisible();
	}

	public boolean isIntroTextVisible() {
		Logger.info("Verify Intro Text is visible");
		return introText.isVisible();
	}

	public boolean isRegistrationFormVisible() {
		Logger.info("Verify Registration Form is visible");
		return registrationForm.isVisible();
	}

	public boolean isTipSectionBlockVisible() {
		Logger.info("Verify Tip Section block is visible");
		return tipsSectionBlock.isVisible();
	}

	public int getTipSectionsCount() {
		Logger.info("Get Tip section count");
		return tipSection.getVisibleElementsCount();
	}

	public boolean isTipTitleNumberVisible(int elementNumber) {
		Logger.info("Verify tip title #" + elementNumber + " is visible");
		return tipTitle.isElementNumberVisible(elementNumber);
	}

	public boolean isTipImageNumberVisible(int elementNumber) {
		Logger.info("Verify tip image #" + elementNumber + " is visible");
		return tipImage.isElementNumberVisible(elementNumber);
	}

	public boolean isTipDescriptionNumberVisible(int elementNumber) {
		Logger.info("Verify tip description #" + elementNumber + " is visible");
		return tipDescription.isElementNumberVisible(elementNumber);
	}

	public boolean isCallOutSectionVisible() {
		Logger.info("Verify Call out section is visible");
		return callOutSection.isVisible();
	}

	public boolean isCallOutTitleVisible() {
		Logger.info("Verify Call out title is visible");
		return callOutTitle.isVisible();
	}

	public boolean isCallOutButtonVisible() {
		Logger.info("Verify Call out button is visible");
		return callOutButton.isVisible();
	}

	public boolean isCalloutButtonHrefValueValidURL() {
		Logger.info("Verify Call out button href");
		return callOutButton.getAttribute("href").startsWith("https://");
	}

	public boolean isFeaturesSectionVisible() {
		Logger.info("Verify features section is visible");
		return featureSection.isVisible();
	}
}