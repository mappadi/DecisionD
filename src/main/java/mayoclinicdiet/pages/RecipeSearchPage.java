package mayoclinicdiet.pages;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class RecipeSearchPage extends PublicHeaderMCD {
	public RecipeSearchPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "recipeSearchPage";
		String CLASS_NAME = "RecipeSearchPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject recipeCount;

	public RecipeSearchPage checkRecipeSearchUrl() {
		Logger.info("Check 'Recipe Search' page url");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/food-fitness/recipe/recipesearch"), "URL doesn't contain '/food-fitness/recipe/recipesearcht'");
		return this;
	}

	public RecipeSearchPage checkRecipeCountDisplayed() {
		Logger.info("The recipe count is displayed");
		boolean isHeaderDisplayed = recipeCount
				.waitUntilVisible()
				.isPresent();
		assertTrue(isHeaderDisplayed, "The recipe count is not displayed");
		return this;
	}
}
