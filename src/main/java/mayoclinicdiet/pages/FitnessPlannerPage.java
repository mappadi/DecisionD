package mayoclinicdiet.pages;

import framework.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class FitnessPlannerPage extends PublicHeaderMCD {

	public FitnessPlannerPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "fitnessPlanner";
		String CLASS_NAME = "FitnessPlannerPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	public FitnessPlannerPage checkFitnessPlannerUrl() {
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/diet/members/fitness-planner"), "URL doesn't contain '/diet/members/fitness-planner'");
		Logger.info("Check 'Fitness Planner' page url");
		return this;
	}
}
