package mayoclinicdiet.pages;

import org.openqa.selenium.WebDriver;

public class HowItWorksPage extends MainPublicPageMCD {

	public HowItWorksPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "howItWorksPage";
		String CLASS_NAME = "HowItWorksPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}
}
