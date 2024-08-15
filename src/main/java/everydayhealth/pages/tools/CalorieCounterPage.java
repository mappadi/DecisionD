package everydayhealth.pages.tools;

import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.PublicHeaderEH;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class CalorieCounterPage extends BasicPageEH {

	public CalorieCounterPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "tools";
		String CLASS_NAME = "CalorieCounterPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject activeCalorieCounter;
	protected WebObject headingTitle;
	protected WebObject datePicker;
	protected WebObject datePickerLeftArrow;
	protected WebObject datePickerRightArrow;

	@Override
	public void waitForPageToLoad() {
		activeCalorieCounter.waitUntilVisibleOnPage(this);
	}

	public PublicHeaderEH onHeader() {
		return new PublicHeaderEH(basedriver, "ToolsHeader");
	}

	public boolean isCalorieCounterTitleVisible() {
		Logger.info("Verifying the 'calorie counter' title is visible");
		return headingTitle.isVisible();
	}

	public boolean isDatePickerVisible() {
		Logger.info("Verifying the 'date picker' selector is visible");
		return datePicker.isVisible();
	}

	public boolean isDatePickerNavLeftVisible() {
		Logger.info("Verifying the 'date picker' left arrow is visible");
		return datePickerLeftArrow.isVisible();
	}

	public boolean isDatePickerNavRightVisible() {
		Logger.info("Verifying the 'date picker' right arrow is visible");
		return datePickerRightArrow.isVisible();
	}

}
