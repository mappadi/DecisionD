package mayoclinicdiet.pages;

import org.openqa.selenium.WebDriver;

public class SuccessStoriesPage extends MainPublicPageMCD {

	public SuccessStoriesPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "successStoriesPage";
		String CLASS_NAME = "SuccessStoriesPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}
}
