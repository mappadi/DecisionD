package mayoclinicdiet.pages;

import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class ProfileSettingsPage extends PublicHeaderMCD {

	public ProfileSettingsPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "profile";
		String CLASS_NAME = "ProfileSettingsPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject profileSettingsHeader;
	protected Settings settings;
	protected WebObject liveItCheckbox;
	protected WebObject expandAccountInformation;
	protected WebObject emailHolder;
	protected static String rememberEmailAddress;
	protected WebObject saveChangesButton;
	protected WebObject loseItCheckbox;
	protected WebObject firstNameInput;
	protected WebObject lastNameInput;
	protected WebObject screenNameInput;

	public ProfileSettingsPage verifyProfileSettingsHeaderPresence() {
		Logger.info("Check 'Profile Setting' header is presented");
		boolean isProfileSettingsHeaderPresent =
				profileSettingsHeader
						.waitUntilVisible()
						.then()
						.isElementPresent();
		assertTrue(isProfileSettingsHeaderPresent, "User isn't taken to the Profile Settings Page. Header is absent!");
		return this;
	}

	public ProfileSettingsPage clickLiveItRadioButton() {
		Logger.info("Click 'Live It!' radio button");
		liveItCheckbox.waitUntilVisible().click();
		return this;
	}

	public ProfileSettingsPage clickLoseItRadioButton() {
		Logger.info("Click 'Lose It!' radio button");
		loseItCheckbox.waitUntilVisible().click();
		return this;
	}

	public ProfileSettingsPage expandAccountInformation() {
		Logger.info("Expand the account information");
		expandAccountInformation.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public ProfileSettingsPage rememberValues() {
		rememberEmailAddress = emailHolder.getText();
		return this;
	}

	public ProfileSettingsPage clickSaveChangesButton() {
		Logger.info("Click 'Save Changes' button");
		saveChangesButton.clickWithJS();
		waitFor(2000);
		return this;
	}

	public String getEmail() {
		Logger.info("Get email");
		return emailHolder.getText();
	}

	public String getFirstName() {
		Logger.info("Get 'First Name' input text");
		return firstNameInput.getValue();
	}

	public String getLastName() {
		Logger.info("Get 'Last Name' input text");
		return lastNameInput.getValue();
	}

	public String getScreenName() {
		Logger.info("Get 'Screen name' input text");
		return screenNameInput.getValue();
	}
}
