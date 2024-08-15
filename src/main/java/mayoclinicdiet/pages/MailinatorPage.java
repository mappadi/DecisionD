package mayoclinicdiet.pages;


import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class MailinatorPage extends ProfileSettingsPage {

	public MailinatorPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "mailinator";
		String CLASS_NAME = "MailinatorPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject inboxField;
	protected WebObject checkItButton;
	protected WebObject emailRow;
	protected WebObject fromInfo;
	protected WebObject subjectInfo;
	protected WebObject mailView;

	public MailinatorPage enterEmail() {
		Logger.info("Enter email address");
		inboxField
				.waitUntilVisible()
				// .type("pbwfm12eda@mailinator.com");
				.type(rememberEmailAddress);
		return this;
	}

	public MailinatorPage clickCheckItButton() {
		Logger.info("Click on 'Check it' button");
		checkItButton
				.waitElementsReady()
				.click();
		return this;
	}

	public MailinatorPage checkEmailDisplayed() {
		Logger.info("Check email is displayed in the Inbox");
		for (int i = 0; i < 5; i++) {
			if (emailRow.isElementPresent()) {
				return this;
			} else {
				basedriver.navigate().refresh();
				waitForAjaxRequestToBeFinished();
			}
		}
		return this;
	}

	public MailinatorPage checkConfirmationEmail() {
		Logger.info("Check the email is from Mayo Clinic Diet");
		assertEquals("Mayo Clinic Diet", fromInfo.getText(), "Email is not from Mayo Clinic Diet");
		Logger.info("Check the email is from Mayo Clinic Diet");
		assertEquals("The Mayo Clinic Diet’s Online Confirmation", subjectInfo.getText(), "Email is not from Mayo Clinic Diet");
		return this;
	}
}
