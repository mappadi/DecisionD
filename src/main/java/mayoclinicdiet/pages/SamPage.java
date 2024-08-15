package mayoclinicdiet.pages;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

public class SamPage extends ProfileSettingsPage {

	public SamPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "sam";
		String CLASS_NAME = "SamPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject valueInputField;
	protected WebObject findButton;
	protected WebObject mayoClinicDietOption;
	protected WebObject userAccountDetails;
	protected WebObject rowsOfAccountInfo;
	protected static int rowsAmount;
	protected static int rowsAmountAfter;

	public SamPage typeValueForNewUser() {
		Logger.info("Enter value on the SAM site");
		valueInputField
				.waitElementsReady()
				.type(rememberEmailAddress);
		return this;
	}

	public SamPage typeValueForOldUser(String email) {
		Logger.info("Enter value on the SAM site");
		valueInputField
				.waitElementsReady()
				.type(email);
		return this;
	}

	public SamPage clickFindButton() {
		Logger.info("Click on 'Find' button");
		findButton
				.waitElementsReady()
				.click();
		return this;
	}

	public SamPage chooseMayoOption() {
		Logger.info("Choose 'Mayo Clinic Diet' option from 'Search by Product' dropdown");
		mayoClinicDietOption
				.waitElementsReady()
				.click();
		return this;
	}

	public SamPage checkUserAccountDetailsDisplayed() {
		Logger.info("Check the account details are displayed");
		boolean isAccountDetailsDisplayed =
				userAccountDetails
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isAccountDetailsDisplayed, "The Account details are not displayed");
		return this;
	}

	public SamPage checkRowsAmountBeforeRenewalInSam() {
		Logger.info("Check amount of rows before renewal");
		rowsAmount = rowsOfAccountInfo.getElementsCount();
		return this;
	}

	public SamPage checkRenewalInSam() {
		Logger.info("Check Renewal has been happened");
		rowsAmountAfter = rowsOfAccountInfo.getElementsCount();
		assertNotEquals(rowsAmount, rowsAmountAfter, "Renewal details are not presented");
		return this;
	}

}
