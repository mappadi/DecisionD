package mayoclinicdiet.pages;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends ProfileSettingsPage {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "forgotPassword";
		String CLASS_NAME = "ForgotPasswordPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject emailInputField;
	protected WebObject submitButton;

	public ForgotPasswordPage typeEmail() {
		Logger.info("Enter email");
		emailInputField
				.waitUntilVisible()
				.then()
				.type(rememberEmailAddress);
		return this;
	}

	public ForgotPasswordPage clickSubmitButton() {
		Logger.info("Click on Submit button");
		submitButton
				.waitElementsReady()
				.click();
		return this;
	}
}
