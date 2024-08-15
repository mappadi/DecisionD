package everydayhealth.pages.share;

import framework.Logger;
import framework.Settings;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * ShareViaEmailPopUp
 */
public class ShareViaEmailPopUp extends BasicPage {

	public ShareViaEmailPopUp(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "share";
		String CLASS_NAME = "ShareViaEmailPopUp";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject popUpTitle;
	protected WebObject yourEmailTextField;
	protected WebObject friendsEmailTextField;
	protected WebObject sendButton;
	protected WebObject closeButton;
	protected WebObject signUpButton;
	protected WebObject privacyPolicyLink;
	protected WebObject successMessage;

	@Override
	public void waitForPageToLoad() {
		popUpTitle.waitUntilVisibleOnPage(this);
	}

	public void typeYourEmailFriendEmailAndSend(String yourEmail, String friendsEmail) {
		typeYourEmail(yourEmail);
		typeFriendsEmail(friendsEmail);
		clickSendButton();
		waitForAjaxRequestToBeFinished();
		successMessage.waitUntilVisible();
		signUpButton.waitUntilVisible();
	}

	public void clickSendButton() {
		Logger.info("Click 'Send' button");
		sendButton.click();
	}

	public void typeFriendsEmail(String friendsEmail) {
		Logger.info("Type email of user's friend");
		friendsEmailTextField.type(friendsEmail);
	}

	public void typeYourEmail(String yourEmail) {
		Logger.info("Type user's email");
		yourEmailTextField.type(yourEmail);
	}

	public boolean isYourEmailFieldVisible() {
		Logger.info("Check if 'Your email' field is visible");
		return yourEmailTextField.isVisible();
	}

	public String getTitle() {
		Logger.info("Get pop up title");
		waitForAjaxRequestToBeFinished();
		waitFor(1000);//need this time to update pop up title
		return popUpTitle.getText();
	}

	public void closePopUp() {
		Logger.info("Click 'Close' pop up button");
		waitForAjaxRequestToBeFinished();
		closeButton.click();
	}

	public ShareViaEmailPopUp clickSignUpButton() {
		Logger.info("Click on 'Sign up now!' button");
		signUpButton.click();
		if (!Settings.isDesktop()) {
			Utils.waitFor(5000); //needed for page to load on mobile platform
		}
		signUpButton.waitUntilInvisible();
		return PageFactory.initElements(basedriver, ShareViaEmailPopUp.class);
	}

	public boolean isPrivacyPolicyVisible() {
		Logger.info("Check if 'Privacy Policy' link is visible");
		return privacyPolicyLink.isVisible();
	}

	public String getPrivacyPolicyLinkText() {
		Logger.info("Get 'Privacy Policy' text");
		return privacyPolicyLink.getText();
	}

	public boolean isPrivacyPolicyLinkPresent() {
		Logger.info("Check if 'Privacy Policy' link is present");
		return privacyPolicyLink.getAttribute("href").startsWith("https://");
	}

	public boolean isSuccessMessageVisible() {
		Logger.info("Check if success message is visible");
		return successMessage.isVisible();
	}
}
