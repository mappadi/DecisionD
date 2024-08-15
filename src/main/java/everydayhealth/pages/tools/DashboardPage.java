package everydayhealth.pages.tools;

import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.PublicHeaderEH;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasicPageEH {

	public DashboardPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "tools";
		String CLASS_NAME = "DashboardPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject welcomeDate;

	@Override
	public void waitForPageToLoad() {
		welcomeDate.waitUntilVisibleOnPage(this);
	}

	public PublicHeaderEH onHeader() {
		return new PublicHeaderEH(basedriver, "ToolsHeader");
	}

}
