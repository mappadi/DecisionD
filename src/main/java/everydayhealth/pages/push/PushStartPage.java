package everydayhealth.pages.push;

import framework.Logger;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * PushStartPage
 */

public class PushStartPage extends BasicPage {

	protected WebObject productSelectForm;
	protected WebObject productDropdownOption;
	protected WebObject selectButton;

	public PushStartPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "push";
		String CLASS_NAME = "PushStartPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	@Override
	public void waitForPageToLoad() {
		productSelectForm.waitUntilVisibleOnPage(this);
	}

	public PushStartPage chooseEHProject() {
		Logger.info("Choose 'EverydayHealth 2.0' product from dropdown");
		productDropdownOption.selectByVisibleText("EverydayHealth 2.0");
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public PushDashboardPage clickSelectButton() {
		Logger.info("Click 'Select' button");
		selectButton.click();
		return new PushDashboardPage(basedriver);
	}

	public boolean isProductSelectFormVisible() {
		Logger.info("Verify if product select form is visible");
		return productSelectForm.isVisible();
	}

	public boolean isSelectButtonVisible() {
		Logger.info("Verify if 'Select' button is visible");
		return selectButton.isVisible();
	}
}
