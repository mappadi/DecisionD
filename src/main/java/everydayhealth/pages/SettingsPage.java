package everydayhealth.pages;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * SettingsPage
 */
public class SettingsPage extends BasicPageEH {

	public SettingsPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "";
		String CLASS_NAME = "SettingsPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject settingsForm;
	protected WebObject editEmailButton;
	protected WebObject verifyPasswordInputField;
	protected WebObject newEmailInputField;
	protected WebObject confirmNewEmailInputField;
	protected WebObject updateEmailButton;
	protected WebObject saveChangesButton;

	@Override
	public void waitForPageToLoad() {
		settingsForm.waitUntilVisibleOnPage(this);
	}

	public SettingsPage clickEditEmailButton() {
		Logger.info("Click 'Edit' button near 'Email' field");
		editEmailButton.click();
		waitForAjaxRequestToBeFinished();
		verifyPasswordInputField.waitUntilVisible();
		return this;
	}

	public SettingsPage typePassword(String password) {
		Logger.info("Type password");
		verifyPasswordInputField.type(password);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public SettingsPage typeNewEmail(String newEmail) {
		Logger.info("Type new email");
		newEmailInputField.type(newEmail);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public SettingsPage typeConfirmNewEmail(String confirmNewEmail) {
		Logger.info("Type new email (confirm)");
		confirmNewEmailInputField.type(confirmNewEmail);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public SettingsPage clickUpdateEmailButton() {
		Logger.info("Click 'Update Email' button");
		updateEmailButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public void clickSaveChangesButton() {
		Logger.info("Click 'Save changes' button");
		saveChangesButton.click();
		waitForAjaxRequestToBeFinished();
	}
}
