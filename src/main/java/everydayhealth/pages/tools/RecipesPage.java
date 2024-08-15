package everydayhealth.pages.tools;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class RecipesPage extends BasicPageEH {

	public RecipesPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "tools";
		String CLASS_NAME = "RecipesPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject recipesTitle;

	@Override
	public void waitForPageToLoad() {
		recipesTitle.waitUntilVisibleOnPage(this);
	}

	public boolean isRecipesTitleVisible() {
		Logger.info("Verifying the 'Recipes' title is visible");
		return recipesTitle.isVisible();
	}

}
