package mayoclinicdiet.pages;

import org.openqa.selenium.WebDriver;

public class SampleMealPlanPage extends MainPublicPageMCD {

	public SampleMealPlanPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "sampleMealPlanPage";
		String CLASS_NAME = "SampleMealPlanPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}
}
