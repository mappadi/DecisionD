package everydayhealth.pages.recipes;

import everydayhealth.pages.articles.ArticleNewTemplatePage;
import everydayhealth.pages.login.LoginPageEH;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * RecipesPage
 */
public class RecipesPage extends ArticleNewTemplatePage {

	public RecipesPage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "recipes";
		String CLASS_NAME = "RecipesPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject recipeArticle;
	protected WebObject addToMealPlanButton;
	protected WebObject addToJournalButton;
	protected WebObject makeRecipeFavoriteButton;
	protected WebObject makeRecipeFavoriteButtonTablet;

	@Override
	public void waitForPageToLoad() {
		recipeArticle.waitUntilVisibleOnPage(this);
	}

	public boolean isAddToMealPlanButtonVisible() {
		Logger.info("Check if 'Add to Meal Plan' button is visible");
		return addToMealPlanButton.isVisible();
	}

	public boolean isAddToJournalButtonVisible() {
		Logger.info("Check if 'Add to Journal' button is visible");
		return addToJournalButton.isVisible();
	}

	public boolean isFavoriteButtonVisible() {
		Logger.info("Check if Favorite '*' button is visible");
		if (Settings.isTablet()) {
			return makeRecipeFavoriteButtonTablet.isVisible();
		}
		return makeRecipeFavoriteButton.isVisible();
	}

	public LoginPageEH clickAddToMealPlanButton() {
		Logger.info("Click on 'Add to Meal Plan' button");
		addToMealPlanButton.click();
		return PageFactory.initElements(basedriver, LoginPageEH.class);
	}

	public LoginPageEH clickAddToJournalButton() {
		Logger.info("Click on 'Add to Journal' button");
		addToJournalButton.click();
		return PageFactory.initElements(basedriver, LoginPageEH.class);
	}

	public LoginPageEH clickFavoriteButton() {
		Logger.info("Click on Favorite '*' button");
		if (Settings.isTablet()) {
			makeRecipeFavoriteButtonTablet.click();
		} else {
			makeRecipeFavoriteButton.click();
		}
		return PageFactory.initElements(basedriver, LoginPageEH.class);
	}
}
