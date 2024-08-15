package everydayhealth.pages.personalizedTracker;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * PersonalizedTrackerPage
 */
public class CrohnsPersonalizedTrackerPage extends PersonalizedTrackerPage {

	public CrohnsPersonalizedTrackerPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "personalizedTracker";
		String CLASS_NAME = "CrohnsPersonalizedTrackerPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject dailyBowelMovementModule;
	protected WebObject dailyBowelMovementModuleEditMode;
	protected WebObject dailyBowelMovementDropdown;
	protected WebObject dailyBowelMovementDropdownOptions;
	protected WebObject dailyBowelMovementModuleData;
	protected WebObject weeklyBowelMovementModule;
	protected WebObject weeklyBowelMovementModuleResult;
	protected WebObject weeklyBowelMovementModulePoomoji;

	public boolean isBowelMovementModuleVisibleInDailyView() {
		Logger.info("Verify if bowel movement module is visible in Daily view");
		return dailyBowelMovementModule.isVisible();
	}

	public boolean isBowelMovementInEditMode() {
		Logger.info("Verify if bowel movement module is in Edit mode");
		return dailyBowelMovementModuleEditMode.isVisible();
	}

	public boolean isBowelMovementModuleEditModeDropdownVisible() {
		Logger.info("Verify if bowel movement module dropdown is visible");
		return dailyBowelMovementDropdown.isVisible();
	}

	public String getBowelMovementDropdownOptionText(int optionNumber) {
		Logger.info("Get text from bowel movement dropdown #" + optionNumber);
		return dailyBowelMovementDropdownOptions.getTextFromElementNumber(optionNumber);
	}

	public CrohnsPersonalizedTrackerPage clickBowelMovementModuleDropdownOptionWithValue(String value) {
		Logger.info("Click on bowel movement module dropdown option '" + value + "'");
		dailyBowelMovementDropdown.selectByValue(value);
		waitForAjaxRequestToBeFinished(1500);
		return this;
	}

	public String getDailyBowelMovementModuleData() {
		Logger.info("Get text from daily bowel movement module");
		String savedResult = dailyBowelMovementModuleData.getText();
		Logger.info("Saved result for daily bowel movement - " + savedResult);
		return savedResult;
	}

	public boolean isDailyBowelMovementSavedDataVisible() {
		Logger.info("Verify if chosen value is saved");
		dailyBowelMovementModule.scrollToElement();
		return dailyBowelMovementModuleData.isVisible();
	}

	public boolean isWeeklyBowelMovementModuleVisible() {
		Logger.info("Verify if weekly bowel movement module is visible");
		weeklyBowelMovementModule.scrollToElement();
		return weeklyBowelMovementModule.isVisible();
	}

	public boolean isWeeklyBowelMovementResultTextVisible() {
		Logger.info("Verify if weekly bowel movement module result text is visible");
		return weeklyBowelMovementModuleResult.isVisible() && weeklyBowelMovementModuleResult.getText().startsWith("You had");
	}

	public boolean isWeeklyBowelMovementPoomojiVisible() {
		Logger.info("Verify if weekly bowel movement module poomoji is visible");
		return weeklyBowelMovementModulePoomoji.isVisible();
	}
}
