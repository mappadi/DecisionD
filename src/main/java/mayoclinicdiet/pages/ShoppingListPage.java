package mayoclinicdiet.pages;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.testng.Assert.assertTrue;

public class ShoppingListPage extends PublicHeaderMCD {

	public ShoppingListPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "shopping.list";
		String CLASS_NAME = "ShoppingListPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject header;
	protected WebObject shoppingList;
	protected WebObject subHeader;

	public ShoppingListPage checkHeaderDisplayed() {
		Logger.info("Check 'Shopping List' header is displayed");
		boolean isHeaderDisplayed = header
				.waitUntilVisible()
				.isPresent();
		assertTrue(isHeaderDisplayed, "'Shopping List' header is not displayed");
		return this;
	}

	public ShoppingListPage checkShoppingListDisplayed() {
		Logger.info("Check Shopping List is displayed");
		boolean isShoppingListDisplayed = shoppingList
				.waitUntilVisible()
				.isPresent();
		assertTrue(isShoppingListDisplayed, "Shopping List is not displayed");
		return this;
	}

	public ShoppingListPage verifyShoppingListDate() {
		Logger.info("Check today's date corresponds date on the header");
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String currMonth = new SimpleDateFormat("MMMM", Locale.US).format(date.getTime());
		assertTrue(subHeader.getText().contains(currMonth), "Displayed month is incorrect ");
		String currDate = new SimpleDateFormat("dd", Locale.US).format(date.getTime());
		//will fail if test starts before 01 am
		assertTrue(subHeader.getText().contains(currDate), "Displayed date is incorrect ");
		return this;
	}

	public ShoppingListPage verifyShoppingListDateRange() {
		Logger.info("Check shopping list date range corresponds date range on weekly meal planner");
		assertTrue(subHeader.getText().contains(WeeklyMealPlannerPage.splited[1]), "Shopping list date range is incorrect ");
		assertTrue(subHeader.getText().contains(WeeklyMealPlannerPage.splited[2]), "Shopping list date range is incorrect ");
		assertTrue(subHeader.getText().contains(WeeklyMealPlannerPage.splited[5]), "Shopping list date range is incorrect ");
		assertTrue(subHeader.getText().contains(WeeklyMealPlannerPage.splited[6]), "Shopping list date range is incorrect ");
		return this;
	}
}
