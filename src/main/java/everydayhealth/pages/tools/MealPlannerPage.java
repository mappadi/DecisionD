package everydayhealth.pages.tools;

import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.PublicHeaderEH;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class MealPlannerPage extends BasicPageEH {

	public MealPlannerPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "tools";
		String CLASS_NAME = "MealPlannerPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject activeMealPlanner;
	protected WebObject headingTitle;
	protected WebObject datePicker;
	protected WebObject datePickerLeftArrow;
	protected WebObject datePickerRightArrow;
	protected WebObject viewByDay;
	protected WebObject viewByWeek;

	@Override
	public void waitForPageToLoad() {
		activeMealPlanner.waitUntilVisibleOnPage(this);
	}

	public PublicHeaderEH onHeader() {
		return new PublicHeaderEH(basedriver, "ToolsHeader");
	}

	public boolean isMealPlannerTitleVisible() {
		Logger.info("Verifying the 'Meal Planner' title is visible");
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

	public boolean isViewByDayVisible() {
		Logger.info("Verifying the 'view by day' text is visible");
		return viewByDay.isVisible();
	}

	public boolean isViewByWeekVisible() {
		Logger.info("Verifying the 'view by week' link is visible");
		return viewByWeek.isVisible();
	}

}
