package mayoclinicdiet.pages;

import org.openqa.selenium.WebDriver;

public class TheExpertsPage extends MainPublicPageMCD {

	public TheExpertsPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "theExpertsPage";
		String CLASS_NAME = "TheExpertsPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}
}
