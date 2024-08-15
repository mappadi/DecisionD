package everydayhealth.pages.push;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * PushEditSlideshowPage
 */
public class PushEditSlideshowPage extends PushEditPageBasePage {

	public PushEditSlideshowPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "push";
		String CLASS_NAME = "PushEditSlideshowPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject slideTabAddSlideButton;
	protected WebObject slidePropertiesWindow;
	protected WebObject slideIconHDD;
	protected WebObject slideHed;
	protected WebObject saveSlideshowButton;
	protected WebObject slideImageURLInput;
	protected WebObject slideImageError;
	protected WebObject slideImageURLError;
	protected WebObject slideAltTextInput;
	protected WebObject slideAltTextError;
	protected WebObject slideSaveChangesButton;
	protected WebObject slidesPreview;
	protected WebObject slideItem;
	protected WebObject slideItemEdit;
	protected WebObject slideItemRemove;
	protected WebObject slideItemRemoveConfirm;

	public void clickAddSlideButton() {
		Logger.info("Click 'Add slide' button");
		slideTabAddSlideButton.click();
		waitForAjaxRequestToBeFinished();
		slidePropertiesWindow.waitUntilVisible();
	}

	public boolean isSlidePropertiesWindowVisible() {
		Logger.info("Verify if slide properties window is visible");
		return slidePropertiesWindow.isVisible();
	}

	public boolean isAddSlideButtonVisible() {
		Logger.info("Verify if 'Add Slide' button is visible");
		return slideTabAddSlideButton.isVisible();
	}

	public boolean isSlideHedInputVisible() {
		Logger.info("Verify if slide 'Hed' input is visible");
		return slideHed.isVisible();
	}

	public void typeSlideHed(String hedText) {
		Logger.info("Type hed text");
		slideHed.type(hedText);
	}

	public boolean isSlideImageURLInputVisible() {
		Logger.info("Verify if slide image 'URL' input is visible");
		return slideImageURLInput.isVisible();
	}

	public void typeSlideImageURL(String imageURL) {
		Logger.info("Type image 'URL'");
		slideImageURLInput.type(imageURL);
		slideIconHDD.click();
		waitForAjaxRequestToBeFinished();
	}

	public PushEditSlideshowPage clearUrlInput() {
		Logger.info("Clear 'Url' input");
		slideImageURLInput.clear();
		slideIconHDD.click();
		return this;
	}

	public boolean isImageURLFormatErrorMessageVisible() {
		Logger.info("Verify if URL format error message is visible");
		return slideImageURLError.isVisible();
	}

	public boolean isImageURLErrorMessageVisible() {
		Logger.info("Verify if URL error message (URL required)");
		return slideImageError.isVisible();
	}

	public boolean isAltTextInputVisible() {
		Logger.info("Verify if 'Alt Text' input is visible");
		return slideAltTextInput.isVisible();
	}

	public void typeAltText(String altText) {
		Logger.info("Type alt text");
		slideAltTextInput.type(altText);
	}

	public boolean isAltTextErrorVisible() {
		Logger.info("Verify if error message is visible below 'Alt text' input");
		return slideAltTextError.isVisible();
	}

	public void clickSaveChangesButton() {
		Logger.info("Click 'Save Changes' button");
		slideSaveChangesButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isSlidesPreviewBlockVisible() {
		Logger.info("Verify if slides preview block is visible");
		return slidesPreview.isVisible();
	}

	public int getNumberOfVisibleSlidesInPreview() {
		Logger.info("Get number of slides in preview block");
		return slideItem.getNumberOfVisibleAndClickableElements();
	}

	public void mouseHoverSlide(int slideNumber) {
		Logger.info("Mouse hover slide #" + slideNumber);
		slideItem.mouseHoverOnElementNumber(slideNumber);
	}

	public void clickSlideEditButton(int slideNumber) {
		Logger.info("Click 'Edit' icon on slide #" + slideNumber);
		slideItemEdit.clickOnElementNumber(slideNumber);
		waitForAjaxRequestToBeFinished();
	}

	public void clickSlideRemoveButton(int slideNumber) {
		Logger.info("Click 'Remove' icon on slide #" + slideNumber);
		slideItemRemove.clickOnElementNumber(slideNumber);
		waitForAjaxRequestToBeFinished();
	}

	public PushEditSlideshowPage clickSaveSlideshowButton() {
		Logger.info("Click 'Save' button on 'Hed, Dek, Byline' tab");
		saveSlideshowButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}
}
