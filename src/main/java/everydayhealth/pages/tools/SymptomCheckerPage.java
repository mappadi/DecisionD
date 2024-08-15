package everydayhealth.pages.tools;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class SymptomCheckerPage extends BasicPageEH {

	public SymptomCheckerPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "tools";
		String CLASS_NAME = "SymptomCheckerPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject symptomCheckerTitle;

	@Override
	public void waitForPageToLoad() {
		symptomCheckerTitle.waitUntilVisibleOnPage(this);
	}

	public boolean isSymptomCheckerTitleVisible() {
		Logger.info("Verifying the 'Symptom Checker' title is visible");
		return symptomCheckerTitle.isVisible();
	}
}
