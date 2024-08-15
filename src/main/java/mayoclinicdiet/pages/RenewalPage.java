package mayoclinicdiet.pages;

import framework.Logger;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class RenewalPage extends BasicPage {

	public RenewalPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "renewal";
		String CLASS_NAME = "RenewalPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject timeToRenewHeader;
	protected WebObject accountInfo;
	protected WebObject renewButton;

	public RenewalPage checkRenewalUrl() {
		Logger.info("Check 'Renewal' url");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/diet/account/renew"), "URL doesn't contain '/diet/account/renew'");
		return this;
	}

	public RenewalPage checkRenewalHeader() {
		Logger.info("Check 'Time to Renew!' header is displayed");
		boolean isRenewalHeaderDisplayed =
				timeToRenewHeader
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isRenewalHeaderDisplayed, "Time to Renew!' header is not displayed");
		return this;
	}

	public RenewalPage checkAccountInfoDisplayed() {
		Logger.info("Check Users account details are displayed");
		boolean isAccountInfoDisplayed =
				accountInfo
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isAccountInfoDisplayed, "Users account details are not displayed");
		return this;
	}

	public HomePage clickRenewButton() {
		Logger.info("Click on 'Renew' button");
		renewButton
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, HomePage.class);
	}

	@Override
	public void waitForPageToLoad() {
		renewButton.waitUntilVisible();
	}
}
