package everydayhealth.pages.drugs;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class DrugsReviewsPage extends DrugsProfilePage {

	public DrugsReviewsPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "drugs";
		String CLASS_NAME = "DrugsReviewsPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject starRating;
	protected WebObject reviewThisDrugPlus;
	protected WebObject showAll;
	protected WebObject showHighest;
	protected WebObject showLowest;
	protected WebObject moreButton;
	protected WebObject readPrevious;
	protected WebObject reviewItem;
	protected WebObject reviewForm;
	protected WebObject reviewSection;
	protected WebObject rateSectionElements;
	protected WebObject rateSectionStar;
	protected WebObject rateSectionRequiredLabel;
	protected WebObject reasonDropdown;
	protected WebObject reasonDropdownItems;
	protected WebObject experienceTextField;
	protected WebObject termsOfServiceCheckbox;
	protected WebObject termsOfServiceRequiredLabel;
	protected WebObject captcha;
	protected WebObject cancelButton;
	protected WebObject submitButton;
	protected WebObject loadingIndicator;
	protected WebObject pageInfo;
	protected WebObject previousArrow;
	protected WebObject nextArrow;

	public boolean isRatingVisible() {
		Logger.info("Check if review rating is visible");
		return starRating.isVisible();
	}

	public boolean isReviewThisDrugButtonVisible() {
		Logger.info("Check if 'Review this drug +' button is visible");
		return reviewThisDrugPlus.isVisible();
	}

	public void clickReviewThisDrugButton() {
		Logger.info("Click 'Review this drug +' button");
		reviewThisDrugPlus.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isShowAllButtonVisible() {
		Logger.info("Check if Show: 'All' button is visible");
		return showAll.isVisible();
	}

	public boolean isShowHighestButtonVisible() {
		Logger.info("Check if Show: 'Highest' button is visible");
		return showHighest.isVisible();
	}

	public boolean isShowLowestButtonVisible() {
		Logger.info("Check if Show: 'Lowest' button is visible");
		return showLowest.isVisible();
	}

	public boolean isReadPreviousNavigationVisible() {
		Logger.info("Check if read previous navigation is visible");
		return readPrevious.isVisible();
	}

	public int getNumberOfVisibleReviews() {
		Logger.info("Get number of visible reviews on page");
		return reviewItem.getVisibleElementsCount();
	}

	public boolean isReviewSectionVisible() {
		Logger.info("Check if review section is visible");
		return reviewSection.isVisible();
	}

	public boolean isReviewFormVisible() {
		Logger.info("Check if review form is visible");
		return reviewForm.isVisible();
	}

	public int getNumberOfVisibleRateFields() {
		Logger.info("Get number of visible rate fields");
		return rateSectionElements.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfRateFieldsRequiredLabels() {
		Logger.info("Get number of rate fields 'required' labels");
		return rateSectionRequiredLabel.getNumberOfVisibleAndClickableElements();
	}

	public boolean isReasonDropdownVisible() {
		Logger.info("Check if 'Reason for taking Ibuprofen' dropdown is visible");
		return reasonDropdown.isVisible();
	}

	public void clickReasonDropdown() {
		Logger.info("Click on 'Reason for taking...' dropdown");
		reasonDropdown.click();
		waitForAjaxRequestToBeFinished();
	}

	public void chooseReasonNumber(int reasonNumber) {
		Logger.info("Choose random reason");
		reasonDropdownItems.clickOnElementNumber(reasonNumber);
	}

	public boolean isShareYouExperienceTextFieldVisible() {
		Logger.info("Check if 'Share your experience' textfield is visible");
		return experienceTextField.isVisible();
	}

	public void enterTextIntoTextField(String text) {
		Logger.info("Enter text into 'Share your experience' textfield");
		experienceTextField.type(text);
	}

	public String getTextFromTextField() {
		Logger.info("Get text from 'Share your experience' textfield");
		return experienceTextField.getAttribute("value");
	}

	public boolean isTermsOfServiceCheckboxVisible() {
		Logger.info("Check if 'Terms of service' checkbox is visible");
		return termsOfServiceCheckbox.isVisible();
	}

	public void clickTermsOfServiceCheckbox() {
		Logger.info("Click terms of service checkbox");
		termsOfServiceCheckbox.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isTermsOfServiceRequiredLabelVisible() {
		Logger.info("Check if 'Terms of service' has 'required' label");
		return termsOfServiceRequiredLabel.isVisible();
	}

	public boolean isCaptchaVisible() {
		Logger.info("Check if captcha is visible");
		return captcha.isVisible();
	}

	public boolean isCancelButtonVisible() {
		Logger.info("Check if 'Cancel' button is visible");
		return cancelButton.isVisible();
	}

	public boolean isSubmitButtonVisible() {
		Logger.info("Check if 'Submit' button is visible");
		return submitButton.isVisible();
	}

	public boolean isSubmitButtonActive() {
		Logger.info("Check if 'Submit' button is active");
		return !submitButton.getAttribute("class").contains("disabled");
	}

	public void rateQuestion(int question, int stars) {
		Logger.info("Set " + stars + " stars on question #" + question);
		rateSectionStar.clickOnElementNumberWithText(stars, String.valueOf(question));
		waitForAjaxRequestToBeFinished();
	}

	public String getStarClassAttribute(int question, int stars) {
		Logger.info("Check if selected star is highlighted");
		return rateSectionStar.getAttributeOfElementNumberWithText(stars, "class", String.valueOf(question));
	}

	public String getCurrentPageNumber() {
		Logger.info("Get current page number");
		return pageInfo.getText().split(" ")[0];
	}

	public boolean isPageCounterPresent() {
		Logger.info("Verify if page counter is visible");
		return pageInfo.isVisible();
	}

	public boolean isNextNavigationArrowVisible() {
		Logger.info("Verify if 'Next' navigation arrow is visible");
		return nextArrow.isVisible();
	}

	public void clickNextArrow() {
		Logger.info("Click 'Next' navigation arrow");
		nextArrow.click();
		loadingIndicator.waitUntilInvisible();
	}

	public void clickPreviousArrow() {
		Logger.info("Click 'Previous' navigation arrow");
		previousArrow.click();
		loadingIndicator.waitUntilInvisible();
	}

	public boolean isPreviousNavigationArrowVisible() {
		Logger.info("Verify if 'Previous' navigation arrow is visible");
		return previousArrow.isVisible();
	}

	public String getHrefValueOfNextArrow() {
		Logger.info("Get 'href' attribute value of 'Next' arrow");
		return nextArrow.getAttribute("href");
	}

	public String getHrefValueOfPreviousArrow() {
		Logger.info("Get 'href' attribute value of 'Previous' arrow");
		return previousArrow.getAttribute("href");
	}
}
