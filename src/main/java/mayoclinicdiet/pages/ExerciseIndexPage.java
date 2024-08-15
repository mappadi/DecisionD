package mayoclinicdiet.pages;

import framework.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class ExerciseIndexPage extends PublicHeaderMCD {

	public ExerciseIndexPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "exerciseIndex";
		String CLASS_NAME = "ExerciseIndexPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	public ExerciseIndexPage checkExchangeIndexUrl() {
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/diet/members/exercise/index/upper-body"), "URL doesn't contain '/diet/members/exercise/index/upper-body'");
		Logger.info("Check 'Exchange Index' page url");
		return this;
	}
}
