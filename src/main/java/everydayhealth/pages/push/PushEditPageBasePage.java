package everydayhealth.pages.push;

import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import framework.platform.utilities.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * PushEditPageBasePage
 */
public class PushEditPageBasePage extends BasicPage {

	public PushEditPageBasePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "push";
		String CLASS_NAME = "PushEditPageBasePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}
	
	protected WebObject topPanel;
	protected WebObject topPanelSaveDraftButton;
	protected WebObject topPanelPublishButton;
	protected WebObject sharebar;
	protected WebObject pageInformationBlock;
	protected WebObject pageTemplateDropdown;
	protected WebObject pageTemplateDropdownOption;
	protected WebObject pageTemplateDropdownChosenOption;
	protected WebObject pageNameInput;
	protected WebObject pageNameError;
	protected WebObject pageURL;
	protected WebObject pageURLError;
	protected WebObject editURLButton;
	protected WebObject categorizationBlock;
	protected WebObject categoryDropdown;
	protected WebObject categoryError;
	protected WebObject categoryDropdownOption;
	protected WebObject categoryDropdownOptionSelected;
	protected WebObject categoryDropdownOptionWithText;
	protected WebObject subcategoryDropdown;
	protected WebObject subcategoryError;
	protected WebObject subcategoryDropdownOption;
	protected WebObject subcategoryDropdownOptionSelected;
	protected WebObject subcategoryDropdownOptionWithText;
	protected WebObject isNewsBlock;
	protected WebObject isNewsError;
	protected WebObject isNewsDropdown;
	protected WebObject isNewsDropdownOption;
	protected WebObject pageContentSection;
	protected WebObject pageContentSectionTab;
	protected WebObject errorAlert;
	protected WebObject errorAlertMessage;
	protected WebObject successAlert;
	protected WebObject successAlertMessage;
	protected WebObject topicsSection;
	protected WebObject topicsInput;
	protected WebObject topicsChoices;
	protected WebObject adTaxonomiesSection;
	protected WebObject taxonomiesTree;
	protected WebObject taxonomiesTreeConditionPlusSign;
	protected WebObject taxonomiesTreeConditionChoice;
	protected WebObject taxonomiesTreeConditionChoiceAdd;
	protected WebObject taxonomiesTreeChosenCondition;
	protected WebObject templateContentSection;
	protected WebObject templateContentSectionTabs;
	protected WebObject headlineInput;
	protected WebObject headlineError;
	protected WebObject deckInput;
	protected WebObject bodyIFrame;
	protected WebObject bodyInput;
	protected WebObject lastUpdatedInput;
	protected WebObject lastUpdatedError;
	protected WebObject datepicker;
	protected WebObject datepickerDayNumber;
	protected WebObject datepickerDayNumberActive;
	protected WebObject datepickerTime;
	protected WebObject datepickerTimeActive;
	protected WebObject datepickerMinute;
	protected WebObject datepickerMinuteActive;
	protected WebObject saveArticleButton;
	protected WebObject seoPanel;
	protected WebObject publishConfirmationPopUp;
	protected WebObject changeTypeDropdownOption;
	protected WebObject notesInput;
	protected WebObject continueButton;
	protected WebObject textBlockTab;
	protected WebObject addEmbedButton;
	protected WebObject embedDropdown;
	protected WebObject enterNameInput;
	protected WebObject imageUrlInput;
	protected WebObject descriptionInput;
	protected WebObject linkInput;
	protected WebObject imageUrlTwoInput;
	protected WebObject descriptionTwoInput;
	protected WebObject linkTwoInput;
	protected WebObject embedSaveButton;
	protected WebObject shortCodeLink;
	protected WebObject widgetEdit;
	protected WebObject widgetDelete;
	protected WebObject copyIFrame;
	protected WebObject titleInputText;
	protected WebObject mediaTab;
	protected WebObject videosTab;
	protected WebObject insertVideosButton;
	protected WebObject videoIdInput;
	protected WebObject videoProviderDropdown;
	protected WebObject mediaTagDropdown;
	protected WebObject mediaSavebutton;
	protected WebObject videoThumbnail;
	protected WebObject deleteButton;
	protected WebObject yesButton;
	protected WebObject thumbnailUrlInput;
	protected WebObject stillUrlInput;

	@Override
	public void waitForPageToLoad() {
		topPanel.waitUntilVisibleOnPage(this);
	}

	public <T> T clickSaveDraftButton(Class<T> expectedPage) {
		Logger.info("Click 'Save Draft' button");
		topPanelSaveDraftButton.click();
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public PushEditPageBasePage clickSaveDraftButton() {
		Logger.info("Click 'Save Draft' button");
		waitForAjaxRequestToBeFinished();
		topPanelSaveDraftButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isSaveDraftButtonVisible() {
		Logger.info("Verify if 'Save Draft' button is visible");
		return topPanelSaveDraftButton.isVisible();
	}

	public void clickPublishButton() {
		Logger.info("Click 'Publish' button");
		topPanelPublishButton.click();
		waitForAjaxRequestToBeFinished(1500);
	}

	public boolean isPublishButtonVisible() {
		Logger.info("Verify if 'Publish' button is visible");
		return topPanelPublishButton.isVisible();
	}

	public boolean isShareBarVisible() {
		Logger.info("Verify if share bar panel is visible");
		return sharebar.isVisible();
	}

	public boolean isPageInfoBlockVisible() {
		Logger.info("Verify if 'Page information' block is visible");
		return pageInformationBlock.isVisible();
	}

	public boolean isTemplateDropdownVisible() {
		Logger.info("Verify if 'Page Template' dropdown is visible");
		return pageTemplateDropdown.isVisible();
	}

	public PushEditPageBasePage chooseTemplateFromDropdown(String template) {
		Logger.info("Choose template from dropdown");
		pageTemplateDropdownOption.clickOnElementWithValue(template);
		return this;
	}

	public String getChosenTemplateText() {
		Logger.info("Get chosen template text");
		return pageTemplateDropdownChosenOption.getText();
	}

	public boolean isPageNameInputVisible() {
		Logger.info("Verify if 'Page Name' input is visible");
		return pageNameInput.isVisible();
	}

	public PushEditPageBasePage typePageName(String pageName) {
		Logger.info("Type page name into 'Page Name' input");
		pageNameInput.type(pageName);
		return this;
	}

	public void clearPageNameInput() {
		Logger.info("Clear 'Page Name' input");
		pageNameInput.clear();
	}

	public String getPageName() {
		Logger.info("Get page name data");
		return pageNameInput.getValue();
	}

	public boolean isPageNameErrorMessageVisible() {
		Logger.info("Verify if page name error message is visible");
		return pageNameError.isVisible();
	}

	public boolean isPageURLVisible() {
		Logger.info("Verify if page 'URL' is visible");
		return pageURL.isVisible();
	}

	public String getPageURLText() {
		Logger.info("Get page 'URL' text");
		return pageURL.getText();
	}

	public boolean isEditURLButtonVisible() {
		Logger.info("Verify if 'Edit' button is visible near URL");
		return editURLButton.isVisible();
	}

	public boolean isCategorizationBlockVisible() {
		Logger.info("Verify if 'Categorization' block is visible");
		return categorizationBlock.isVisible();
	}

	public boolean isCategoryDropdownVisible() {
		Logger.info("Verify if 'Category' dropdown is visible");
		return categoryDropdown.isVisible();
	}

	public PushEditPageBasePage chooseCategoryFromDropdown(String category) {
		Logger.info("Choose category from dropdown");
		categoryDropdownOptionWithText.clickOnElementNumberWithText(1, category);
		waitForAjaxRequestToBeFinished(1500);
		return this;
	}

	public String getCategoryText(int categoryNumber) {
		Logger.info("Get category text");
		return categoryDropdownOption.getTextFromElementNumber(categoryNumber);
	}

	public String getChosenCategoryText() {
		Logger.info("Get chosen category text");
		return categoryDropdownOptionSelected.getText();
	}

	public boolean isSubcategoryDropdownVisible() {
		Logger.info("Verify if 'Subcategory' dropdown is visible");
		return subcategoryDropdown.isVisible();
	}

	public String getSubcategoryText(int subcategoryNumber) {
		Logger.info("Get subcategory text");
		return subcategoryDropdownOption.getTextFromElementNumber(subcategoryNumber);
	}

	public String getChosenSubcategoryText() {
		Logger.info("Get chosen subcategory text");
		return subcategoryDropdownOptionSelected.getText();
	}

	public PushEditPageBasePage chooseSubcategoryFromDropdown(String subcategory) {
		Logger.info("Choose subcategory from dropdown");
		subcategoryDropdownOptionWithText.clickOnElementNumberWithText(1, subcategory);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isBlockIsNewsVisible() {
		Logger.info("Verify if 'Is News' block is visible");
		return isNewsBlock.isVisible();
	}

	public boolean isIsNewsDropdownVisible() {
		Logger.info("Verify if 'Is News' dropdown is visible");
		return isNewsDropdown.isVisible();
	}

	public PushEditPageBasePage chooseIsNewsOption(String option) {
		Logger.info("Choose option from 'Is News' dropdown");
		isNewsDropdownOption.clickOnElementWithValue(option);
		return this;
	}

	public boolean isPageContentSectionVisible() {
		Logger.info("Verify if page content section is visible");
		return pageContentSection.isVisible();
	}

	public int getNumberOfTabsInPageContentSection() {
		Logger.info("Get number of tabs in page content section");
		return pageContentSectionTab.getNumberOfVisibleAndClickableElements();
	}

	public boolean isErrorAlertVisible() {
		Logger.info("Verify if error alert is visible");
		return errorAlert.isVisible();
	}

	public int getNumberOfErrorAlerts() {
		Logger.info("Get number of error alerts displayed");
		return errorAlert.getVisibleElementsCount();
	}

	public String getErrorAlertText() {
		Logger.info("Get error alert message");
		return errorAlertMessage.getText();
	}

	public String getErrorAlertText(int alertNumber) {
		Logger.info("Get error alert message");
		return errorAlertMessage.getTextFromElementNumber(alertNumber);
	}

	public boolean isSuccessAlertVisible() {
		Logger.info("Verify if success alert is visible");
		return successAlert.isVisible();
	}

	public String getSuccessAlertText() {
		Logger.info("Get success alert text");
		return successAlertMessage.getText();
	}

	public boolean isTopicsSectionVisible() {
		Logger.info("Verify if Topics section is visible");
		return topicsSection.isVisible();
	}

	public PushEditPageBasePage clickTopicsInput() {
		Logger.info("Click 'Topics' input");
		waitForAjaxRequestToBeFinished();
		categorizationBlock.scrollIntoView();
		topicsInput.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public PushEditPageBasePage clickChooseTopic(String topic) {
		Logger.info("Choose topic - " + topic);
		topicsChoices.clickOnElementNumberWithText(1, topic);
		return this;
	}

	public boolean isAdTaxonomiesSectionVisible() {
		Logger.info("Verify if Ad Taxonomies section is visible");
		return adTaxonomiesSection.isVisible();
	}

	public boolean isTaxonomiesTreeVisible() {
		Logger.info("Verify if taxonomy tree is visible");
		return taxonomiesTree.isVisible();
	}

	public PushEditPageBasePage clickTaxonomiesTree() {
		Logger.info("Click on taxonomies tree");
		adTaxonomiesSection.scrollIntoView();
		taxonomiesTree.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public PushEditPageBasePage clickConditionPlusSign() {
		Logger.info("Click '+' sign for 'Condition'");
		taxonomiesTreeConditionPlusSign.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public PushEditPageBasePage clickConditionNumber(int number) {
		Logger.info("Choose condition #" + number);
		taxonomiesTreeConditionChoice.clickOnElementNumber(number);
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public void addCondition() {
		Logger.info("Click '+' sign to add condition");
		taxonomiesTreeConditionChoiceAdd.click();
		waitForAjaxRequestToBeFinished();
	}

	public String getChosenTaxonomiesTreeConditionText() {
		Logger.info("Get chosen condition text from taxonomies tree");
		if (!taxonomiesTreeChosenCondition.isVisible()) {
			clickTaxonomiesTree();
		}
		return taxonomiesTreeChosenCondition.getText();
	}

	public boolean isContentSectionVisible() {
		Logger.info("Verify if content section is visible");
		return templateContentSection.isVisible();
	}

	public int getNumberOfTemplateContentSectionTabs() {
		Logger.info("Get number of tabs in template content section");
		return templateContentSectionTabs.getNumberOfVisibleAndClickableElements();
	}

	public String getTemplateContentSectionTabText(int tabNumber) {
		Logger.info("Get text from template content section tab #" + tabNumber);
		return templateContentSectionTabs.getTextFromElementNumber(tabNumber);
	}

	public void clickTemplateContentSectionTab(int tabNumber) {
		Logger.info("Click template content section tab #" + tabNumber);
		categorizationBlock.scrollIntoView();
		templateContentSectionTabs.clickOnElementNumber(tabNumber);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isHeadlineInputVisible() {
		Logger.info("Verify if 'Headline' input is visible");
		return headlineInput.isVisible();
	}

	public PushEditPageBasePage typeHeadline(String headlineText) {
		Logger.info("Type headline text");
		headlineInput.type(headlineText);
		return this;
	}

	public void clearHeadlineInput() {
		Logger.info("Clear 'Headline' input");
		headlineInput.clear();
	}

	public boolean isHeadlineErrorVisible() {
		Logger.info("Verify if error message is visible under 'Headline' input");
		return headlineError.isVisible();
	}

	public boolean isDeckInputVisible() {
		Logger.info("Verify if 'Deck' input is visible");
		return deckInput.isVisible();
	}

	public PushEditPageBasePage typeDeck(String deckText) {
		Logger.info("Type deck text");
		deckInput.type(deckText);
		return this;
	}

	public boolean isBodyTextareaVisible() {
		Logger.info("Verify if 'Body' textarea is visible");
		return bodyIFrame.isVisible();
	}

	public PushEditPageBasePage typeBody(String bodyText) {
		Logger.info("Type body text");
		WebDriverManager.getDriver().switchTo().frame(bodyIFrame.getElement());
		bodyInput.type(bodyText);
		WebDriverManager.getDriver().switchTo().defaultContent();
		return this;
	}

	public boolean isLastUpdatedInputVisible() {
		Logger.info("Verify if 'Last Updated' input is visible");
		return lastUpdatedInput.isVisible();
	}

	public void clearLastUpdatedInput() {
		Logger.info("Clear 'Last Updated' input");
		lastUpdatedInput.clear();
		topPanel.click(); //to make input inactive
	}

	public boolean isLastUpdatedErrorVisible() {
		Logger.info("Verify if error message is visible under 'Last updated' input");
		return lastUpdatedError.isVisible();
	}

	public PushEditPageBasePage clickLastUpdated() {
		Logger.info("Click 'Last updated' input");
		if (bodyIFrame.isVisible()) {
			bodyIFrame.scrollIntoView();
		}
		lastUpdatedInput.click();
		waitForAjaxRequestToBeFinished(1500);
		return this;
	}

	public String getLastUpdatedInputValue() {
		Logger.info("Get value from 'Last Updated' input");
		return lastUpdatedInput.getValue();
	}

	public PushEditPageBasePage clickDatePickerActiveDay() {
		Logger.info("Click active day in datepicker");
		datepicker.scrollIntoView();
		datepickerDayNumberActive.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public PushEditPageBasePage clickDatePickerActiveHour() {
		Logger.info("Click active hour in datepicker");
		datepicker.scrollIntoView();
		datepickerTimeActive.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public PushEditPageBasePage clickDatePickerActiveMinute() {
		Logger.info("Click active minute in datepicker");
		datepicker.scrollIntoView();
		datepickerMinuteActive.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public PushEditPageBasePage clickSaveArticleButton() {
		Logger.info("Click 'Save Article' button");
		lastUpdatedInput.scrollIntoView();
		saveArticleButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isPublishConfirmationPopUpVisible() {
		Logger.info("Verify if publish confirmation pop up is visible");
		return publishConfirmationPopUp.isVisible();
	}

	public void waitForConfirmationPopUpDisappear() {
		Logger.info("Waiting for confirmation pop up to disappear");
		publishConfirmationPopUp.waitUntilInvisible();
	}

	public PushEditPageBasePage chooseChangeType(String type) {
		Logger.info("Choose change type from 'Change type' dropdown");
		changeTypeDropdownOption.clickOnElementWithValue(type);
		return this;
	}

	public PushEditPageBasePage typeConfirmationNotes(String noteText) {
		Logger.info("Type confirmation note into 'Notes' input");
		notesInput.type(noteText);
		return this;
	}

	public void clickConfirmationContinueButton() {
		Logger.info("Click 'Continue' button on confirmation pop up");
		continueButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isCategoryErrorVisible() {
		Logger.info("Verify if category error message is visible");
		return categoryError.isVisible();
	}

	public boolean isSubcategoryErrorVisible() {
		Logger.info("Verify if subcategory error message is visible");
		return subcategoryError.isVisible();
	}

	public boolean isIsNewsErrorVisible() {
		Logger.info("Verify if 'is news' error is visible");
		return isNewsError.isVisible();
	}

	public PushEditPageBasePage addItemToTaxonomiesTree() {
		Logger.info("Add condition in taxonomies tree");
		int condition = StringUtils.generateRandomIntInRange(1, 10);
		clickTaxonomiesTree()
				.clickConditionPlusSign()
				.clickConditionNumber(condition)
				.addCondition();
		return this;
	}

	public PushEditPageBasePage chooseLastUpdatedDateTime() {
		if (!datepicker.isVisible()) {
			clickLastUpdated();
		}
		clickDatePickerActiveDay().clickDatePickerActiveHour().clickDatePickerActiveMinute();
		topPanel.click(); //to make input inactive
		return this;
	}

	public void clickTextBlockTab() {
		Logger.info("Click Text Block tab");
		textBlockTab.click();
	}

	public boolean isEmbedButtonVisible() {
		Logger.info("Verify if add embed button is visible");
		waitForAjaxRequestToBeFinished();
		return addEmbedButton.isVisible();
	}

	public void clickAddEmbedButton() {
		Logger.info("Click Add Embed Button");
		addEmbedButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public void selectInlineContentCard() {
		Logger.info("Select Inline Content Card");
		embedDropdown.selectByVisibleText("Inline Content Card");
	}

	public void selectRelatedContentCard() {
		Logger.info("Select Related Content Card");
		embedDropdown.selectByVisibleText("Inline Related Content");
	}

	public void selectEcommerceModule() {
		Logger.info("Select Ecommerce Module");
		embedDropdown.selectByVisibleText("Ecommerce Module");
	}

	public boolean isImageUrlInputVisible() {
		Logger.info("Verify Image Url input is visible");
		return imageUrlInput.isVisible();
	}

	public boolean isDescriptionInputVisible() {
		Logger.info("Verify Description input is visible");
		return descriptionInput.isVisible();
	}

	public boolean isLinkInputVisible() {
		Logger.info("Verify Link input is visible");
		return linkInput.isVisible();
	}

	public void fillEnterNameInput(String input) {
		Logger.info("Fill enter name input");
		enterNameInput.type(input);
	}

	public void fillImageUrlInput(String input) {
		Logger.info("Fill image url input");
		imageUrlInput.type(input);
	}

	public void fillDescriptionUrlInput(String input) {
		Logger.info("Fill description input");
		descriptionInput.type(input);
	}

	public void fillLinkInput(String input) {
		Logger.info("Fill link input");
		linkInput.type(input);
	}

	public void fillImageUrlTwoInput(String input) {
		Logger.info("Fill image two url input");
		imageUrlTwoInput.type(input);
	}

	public void fillDescriptionUrlTwoInput(String input) {
		Logger.info("Fill description two input");
		descriptionTwoInput.type(input);
	}

	public void fillLinkTwoInput(String input) {
		Logger.info("Fill link two input");
		linkTwoInput.type(input);
	}

	public void clickEmbedSaveButton() {
		Logger.info("Click Save button");
		embedSaveButton.click();
	}

	public boolean isShortCodeLinkVisible() {
		Logger.info("Verify short code is visible");
		WebDriverManager.getDriver().switchTo().frame(copyIFrame.getElement());
		return shortCodeLink.isVisible();
	}

	public void clickDeleteWidget() {
		Logger.info("Click Delete button on Widget");
		widgetDelete.click();
		WebDriverManager.getDriver().switchTo().defaultContent();
	}

	public String getTitleInputText() {
		Logger.info("Get title input text is visible");
		return titleInputText.getText();
	}

	public void clickMediaTab() {
		Logger.info("Click Media tab");
		mediaTab.click();
	}

	public void clickVideoTab() {
		Logger.info("Click Video tab");
		videosTab.click();
	}

	public void clickInsertVideosButton() {
		Logger.info("Click Insert Videos Button");
		insertVideosButton.click();
	}

	public void fillInputVideoId(String input) {
		Logger.info("Input video ID");
		videoIdInput.type(input);
		videoIdInput.sendKeys(Keys.TAB);
	}

	public void selectIGNVideoProvider() {
		Logger.info("Select IGN video provider");
		videoProviderDropdown.selectByValue("IGN");
		waitForAjaxRequestToBeFinished();
	}

	public void selectMediaTag() {
		Logger.info("Select Media Tag");
		mediaTagDropdown.selectByVisibleText("Primary");
	}

	public void clickMediaSaveButton() {
		Logger.info("Click Save Button");
		mediaSavebutton.click();
	}

	public boolean isVideoThumbVisible() {
		Logger.info("Verify video thumb is visible");
		return videoThumbnail.isVisible();
	}

	public void hoverOverVideoThumb() {
		Logger.info("Hover over video thumbnail");
		videoThumbnail.mouseHover();
	}

	public void clickDeleteButton() {
		Logger.info("Click Delete Button");
		deleteButton.click();
	}

	public void clickYesButton() {
		Logger.info("Click Yes Button");
		yesButton.click();
	}

	public String getThumbUrlAutoPopulatedUrl() {
		Logger.info("Get autopopulated thumbnail url");
		return thumbnailUrlInput.getAttribute("value");

	}

	public String getStillUrlAutoPopulatedUrl() {
		Logger.info("Get autopopulated still url");
		return stillUrlInput.getAttribute("value");
	}
}
