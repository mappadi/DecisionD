package everydayhealth.pages.drugs;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * DrugsCouponsPage
 */
public class DrugsCouponsPage extends DrugsProfilePage {

	public DrugsCouponsPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "drugs";
		String CLASS_NAME = "DrugsCouponsPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject couponsContainer;
	protected WebObject zipInput;
	protected WebObject zipSearchButton;
	protected WebObject dosageInfo;
	protected WebObject editDosageQtyButton;
	protected WebObject resultContainer;
	protected WebObject resultItem;
	protected WebObject resultItemName;
	protected WebObject resultItemAddress;
	protected WebObject resultItemPrice;
	protected WebObject getFreeCouponButton;
	protected WebObject editDosageModal;
	protected WebObject closeIcon;
	protected WebObject typeFilterSection;
	protected WebObject typeFilterItem;
	protected WebObject typeFilterCheckedItem;
	protected WebObject formFilterSection;
	protected WebObject formFilterItem;
	protected WebObject formFilterCheckedItem;
	protected WebObject dosageFilterSection;
	protected WebObject dosageFilterChosenOption;
	protected WebObject dosageFilterDropdown;
	protected WebObject dosageFilterDropdownOption;
	protected WebObject quantityFilterSection;
	protected WebObject quantityFilterChosenOption;
	protected WebObject quantityFilterDropdown;
	protected WebObject quantityFilterDropdownOption;
	protected WebObject cancelButton;
	protected WebObject applyButton;
	protected WebObject registrationModal;
	protected WebObject registrationModalCloseIcon;
	protected WebObject registrationModalDrugName;
	protected WebObject registrationModalPrice;
	protected WebObject registrationModalFNameInput;
	protected WebObject registrationModalFNameInputError;
	protected WebObject registrationModalLNameInput;
	protected WebObject registrationModalLNameInputError;
	protected WebObject registrationModalEmailInput;
	protected WebObject registrationModalEmailInputError;
	protected WebObject registrationModalSignUpButton;
	protected WebObject registrationModalLegalText;
	protected WebObject registrationModalLegalTextLink;
	protected WebObject newsletterSignUpModal;
	protected WebObject newsletterSignUpModalOptions;
	protected WebObject newsletterSignUpModalCaptcha;
	protected WebObject newsletterSignUpModalSkipButton;
	protected WebObject getCouponModal;
	protected WebObject getCouponModalThankYouMessage;
	protected WebObject getCouponModalDeliveryOptions;
	protected WebObject getCouponModalEmailButton;
	protected WebObject getCouponModalTextButton;
	protected WebObject getCouponModalPrintButton;
	protected WebObject getCouponModalDeliverySetup;
	protected WebObject getCouponModalEmailInput;
	protected WebObject getCouponModalSendButton;
	protected WebObject getCouponModalNotification;

	@Override
	public void waitForPageToLoad() {
		couponsContainer.waitUntilVisibleOnPage(this);
	}

	public void switchIntoCouponsIFrame() {
		Logger.info("Switch into coupons iFrame");
		couponsContainer.switchToFrame();
	}

	public boolean isZipInputVisible() {
		Logger.info("Verify if location (zip) input is visible");
		return zipInput.isVisible();
	}

	public void typeZip(String zipValue) {
		Logger.info("Type zip - " + zipValue);
		zipInput.type(zipValue);
	}

	public void clickZipSearchButton() {
		Logger.info("Click 'Search' button near zip input");
		zipSearchButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isZipSearchButtonVisible() {
		Logger.info("Verify if 'Search' button near zip input is visible");
		return zipSearchButton.isVisible();
	}

	public boolean isDosageInfoVisible() {
		Logger.info("Verify if dosage info is visible");
		return dosageInfo.isVisible();
	}

	public String getDosageInfo() {
		Logger.info("Get dosage info");
		return dosageInfo.getText();
	}

	public boolean isEditDosageQuantityButtonVisible() {
		Logger.info("Verify if 'Edit dosage/qty' button is visible");
		return editDosageQtyButton.isVisible();
	}

	public void clickEditDosageQuantityButton() {
		Logger.info("Click 'Edit dosage/qty' button");
		editDosageQtyButton.click();
		editDosageModal.waitUntilVisible();
	}

	public boolean isSearchResultContainerVisible() {
		Logger.info("Verify if search result container is visible");
		return resultContainer.isVisible();
	}

	public int getNumberOfSearchResultItems() {
		Logger.info("Get number of search result items");
		return resultItem.getNumberOfVisibleAndClickableElements();
	}

	public boolean isResultItemNameVisible(int itemNumber) {
		Logger.info("Verify if name is visible for result item #" + itemNumber);
		return resultItemName.isElementNumberVisible(itemNumber);
	}

	public boolean isResultItemAddressVisible(int itemNumber) {
		Logger.info("Verify if address is visible for result item #" + itemNumber);
		return resultItemAddress.isElementNumberVisible(itemNumber);
	}

	public String getResultItemAddress(int itemNumber) {
		Logger.info("Get result item #" + itemNumber + " address value");
		return resultItemAddress.getTextFromElementNumber(itemNumber);
	}

	public boolean isResultItemPriceVisible(int itemNumber) {
		Logger.info("Verify if price is visible for result item #" + itemNumber);
		return resultItemPrice.isElementNumberVisible(itemNumber);
	}

	public String getResultItemPriceValue(int itemNumber) {
		Logger.info("Get price value for result item #" + itemNumber);
		return resultItemPrice.getTextFromElementNumber(itemNumber);
	}

	public boolean isResultItemGetCouponButtonVisible(int itemNumber) {
		Logger.info("Verify if 'Get free coupon' button is visible for result item #" + itemNumber);
		return getFreeCouponButton.isElementNumberVisible(itemNumber);
	}

	public void clickGetCouponButton(int itemNumber) {
		Logger.info("Click 'Get free coupon' button #" + itemNumber);
		getFreeCouponButton.clickOnElementNumber(itemNumber);
		waitForAjaxRequestToBeFinished();
		registrationModal.waitUntilVisible();
	}

	public boolean isEditDosageQuantityModalVisible() {
		Logger.info("Verify if 'Edit dosage/qty' modal window is visible");
		return editDosageModal.isVisible();
	}

	public boolean isCloseIconVisibleOnModal() {
		Logger.info("Verify if close icon [x] is visible on modal window");
		return closeIcon.isVisible();
	}

	public boolean isTypeFilterSectionVisible() {
		Logger.info("Verify if 'Type' section is visible");
		return typeFilterSection.isVisible();
	}

	public void clickTypeFilterItem(int itemNumber) {
		Logger.info("Click 'Type' filter item #" + itemNumber);
		typeFilterItem.clickOnElementNumber(itemNumber);
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfTypeFilterItems() {
		Logger.info("Get number of available options in 'Type' section");
		return typeFilterItem.getNumberOfVisibleAndClickableElements();
	}

	public String getChosenTypeFilterItemText() {
		Logger.info("Get text of chosen option in 'Type' section");
		return typeFilterCheckedItem.getText();
	}

	public boolean isFormFilterSectionVisible() {
		Logger.info("Verify if 'Form' section is visible");
		return formFilterSection.isVisible();
	}

	public void clickFormFilterItem(int itemNumber) {
		Logger.info("Click 'Form' filter item #" + itemNumber);
		formFilterItem.clickOnElementNumber(itemNumber);
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfFormFilterItems() {
		Logger.info("Get number of available options in 'Form' section");
		return formFilterItem.getNumberOfVisibleAndClickableElements();
	}

	public String getChosenFormFilterItemText() {
		Logger.info("Get text of chosen option in 'Form' section");
		return formFilterCheckedItem.getText();
	}

	public boolean isDosageFilterSectionVisible() {
		Logger.info("Verify if 'Dosage' section is visible");
		return dosageFilterSection.isVisible();
	}

	public void chooseDosageOption(int optionNumber) {
		Logger.info("Choose 'Dosage' option #" + optionNumber);
		if (isLegalTextMessageVisible()) {
			clickCloseIconOnLegalTextMessage();
		}
		dosageFilterSection.scrollIntoView();
		dosageFilterDropdown.click();
		waitForAjaxRequestToBeFinished();
		dosageFilterDropdownOption.clickOnElementNumber(optionNumber);
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfDosageOptions() {
		Logger.info("Get number of available 'Dosage' options");
		return dosageFilterDropdownOption.getElementsCount();
	}

	public String getChosenDosageOptionText() {
		Logger.info("Get chosen 'Dosage' option text");
		return dosageFilterChosenOption.getText();
	}

	public boolean isQuantityFilterSectionVisible() {
		Logger.info("Verify if 'Quantity' section is visible");
		return quantityFilterSection.isVisible();
	}

	public void chooseQuantityOption(int optionNumber) {
		Logger.info("Choose 'Quantity' option #" + optionNumber);
		quantityFilterSection.scrollIntoView();
		quantityFilterDropdown.click();
		waitForAjaxRequestToBeFinished();
		quantityFilterDropdownOption.clickOnElementNumber(optionNumber);
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfQuantityOptions() {
		Logger.info("Get number of available 'Quantity' options");
		return quantityFilterDropdownOption.getElementsCount();
	}

	public String getChosenQuantityOptionText() {
		Logger.info("Get chosen 'Quantity' option text");
		return quantityFilterChosenOption.getText();
	}

	public boolean isCancelButtonVisible() {
		Logger.info("Verify if 'Cancel' button is visible");
		return cancelButton.isVisible();
	}

	public void clickCancelButton() {
		Logger.info("Click 'Cancel' button");
		cancelButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isApplyButtonVisible() {
		Logger.info("Verify if 'Apply' button is visible");
		return applyButton.isVisible();
	}

	public void clickApplyButton() {
		Logger.info("Click 'Apply' button");
		applyButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isRegistrationModalVisible() {
		Logger.info("Verify if registration modal window is visible");
		return registrationModal.isVisible();
	}

	public boolean isCloseIconVisibleOnRegistrationModal() {
		Logger.info("Verify if 'Close' icon [x] is visible on registration modal");
		return registrationModalCloseIcon.isVisible();
	}

	public boolean isDrugNameVisibleOnRegistrationModal() {
		Logger.info("Verify if drug name is visible on registration modal");
		return registrationModalDrugName.isVisible();
	}

	public String getRegistrationModalDrugName() {
		Logger.info("Get drug name from registration modal");
		String drug = registrationModalDrugName.getText();
		Logger.info("Drug - " + drug);
		return drug;
	}

	public boolean isPriceVisibleOnRegistrationModal() {
		Logger.info("Verify if price is visible on registration modal");
		return registrationModalPrice.isVisible();
	}

	public String getDrugPriceFromRegistrationModal() {
		Logger.info("Get drug price from registration modal");
		return registrationModalPrice.getText();
	}

	public boolean isRegistrationModalFirstNameInputVisible() {
		Logger.info("Verify if 'First name' input is visible on registration modal");
		return registrationModalFNameInput.isVisible();
	}

	public void typeFirstName(String firstName) {
		Logger.info("Type first name - " + firstName);
		registrationModalFNameInput.type(firstName);
	}

	public boolean isFirstNameInputErrorMessageVisible() {
		Logger.info("Verify if error message is visible for 'First name' input");
		return registrationModalFNameInputError.isVisible();
	}

	public boolean isRegistrationModalLastNameInputVisible() {
		Logger.info("Verify if 'Last name' input is visible");
		return registrationModalLNameInput.isVisible();
	}

	public void typeLastName(String lastName) {
		Logger.info("Type last name - " + lastName);
		registrationModalLNameInput.type(lastName);
	}

	public boolean isLastNameInputErrorMessageVisible() {
		Logger.info("Verify if error message is visible for 'Last name' input");
		return registrationModalLNameInputError.isVisible();
	}

	public boolean isRegistrationModalEmailInputVisible() {
		Logger.info("Verify if 'Email' input is visible on registration modal");
		return registrationModalEmailInput.isVisible();
	}

	public void typeEmailAddress(String email) {
		Logger.info("Type email - " + email);
		registrationModalEmailInput.type(email);
	}

	public boolean isEmailInputErrorMessageVisible() {
		Logger.info("Verify if error message is visible for 'Email' input");
		return registrationModalEmailInputError.isVisible();
	}

	public boolean isRegistrationModalSignUpButtonVisible() {
		Logger.info("Verify if 'Sign up' button is visible on registration modal");
		return registrationModalSignUpButton.isVisible();
	}

	public void clickRegistrationModalSignUpButton() {
		Logger.info("Click 'Sign up' button on registration modal");
		registrationModalSignUpButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isRegistrationModalLegalTextVisible() {
		Logger.info("Verify if legal text is visible on registration modal");
		return registrationModalLegalText.isVisible();
	}

	public String getRegistrationModalLegalText() {
		Logger.info("Get legal text");
		return registrationModalLegalText.getText();
	}

	public int getNumberOfLinksInLegalText() {
		Logger.info("Get number of links in legal text");
		return registrationModalLegalTextLink.getNumberOfVisibleAndClickableElements();
	}

	public String getLegalTextLinkHrefAttributeValue(int linkNumber) {
		Logger.info("Get 'href' attribute value for legal text link #" + linkNumber);
		return registrationModalLegalTextLink.getHrefOfElementNumber(linkNumber);
	}

	public boolean isNewsletterModalWindowVisible() {
		Logger.info("Verify if newsletter modal window is visible");
		return newsletterSignUpModal.isVisible();
	}

	public int getNumberOfNewsletterSignUpOptions() {
		Logger.info("Get number of newsletter sign up options");
		return newsletterSignUpModalOptions.getNumberOfVisibleAndClickableElements();
	}

	public boolean isNewsletterModalCaptchaVisible() {
		Logger.info("Verify if captcha visible on newsletter modal");
		return newsletterSignUpModalCaptcha.isVisible();
	}

	public boolean isNewsletterModalSkipButtonVisible() {
		Logger.info("Verify if 'Skip' button is visible on newsletter modal window");
		return newsletterSignUpModalSkipButton.isVisible();
	}

	public void clickNewsletterModalSkipButton() {
		Logger.info("Click 'Skip' button on newsletter modal");
		newsletterSignUpModalSkipButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isThankYouMessageVisible() {
		Logger.info("Verify if 'Thanks for signing up!' message is visible");
		return getCouponModalThankYouMessage.isVisible();
	}

	public boolean isGetCouponModalWindowVisible() {
		Logger.info("Verify if modal window with delivery options is visible");
		return getCouponModal.isVisible();
	}

	public boolean isEmailButtonVisibleOnDeliveryModal() {
		Logger.info("Verify if 'Email' button is visible on delivery modal");
		return getCouponModalEmailButton.isVisible();
	}

	public void clickDeliveryModalEmailButton() {
		Logger.info("Click 'Email' button on delivery modal");
		getCouponModalEmailButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isTextButtonVisibleOnDeliveryModal() {
		Logger.info("Verify if 'Text' button is visible on delivery modal");
		return getCouponModalTextButton.isVisible();
	}

	public boolean isPrintButtonVisibleOnDeliveryModal() {
		Logger.info("Verify if 'Print' button is visible on delivery modal");
		return getCouponModalPrintButton.isVisible();
	}

	public boolean isDeliverySetupModalVisible() {
		Logger.info("Verify if email delivery modal window is visible");
		return getCouponModalDeliverySetup.isVisible();
	}

	public boolean isEmailInputVisibleOnDeliveryModal() {
		Logger.info("Verify if 'Email' input is visible on delivery modal");
		return getCouponModalEmailInput.isVisible();
	}

	public void typeEmailAddressOnDeliveryModal(String emailAddress) {
		Logger.info("Type email address - " + emailAddress + " on delivery modal window");
		getCouponModalEmailInput.type(emailAddress);
	}

	public boolean isSendButtonVisibleOnDeliveryModal() {
		Logger.info("Verify if 'Send' button is visible on delivery modal");
		return getCouponModalSendButton.isVisible();
	}

	public void clickDeliveryModalSendButton() {
		Logger.info("Click 'Send' button on delivery modal");
		getCouponModalSendButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isDeliveryNotificationMessageVisible() {
		Logger.info("Verify if delivery notification message is visible");
		return getCouponModalNotification.isVisible();
	}

	public String getDeliveryNotificationText() {
		Logger.info("Get delivery notification text");
		return getCouponModalNotification.getText();
	}
}
