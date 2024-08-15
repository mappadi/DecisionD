package mayoclinicdiet.pages;

import org.openqa.selenium.WebDriver;

public class RecipesPage extends MainPublicPageMCD {

	public RecipesPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "recipesPage";
		String CLASS_NAME = "RecipesPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}
}
