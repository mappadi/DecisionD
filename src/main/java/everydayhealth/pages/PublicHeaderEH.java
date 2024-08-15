package everydayhealth.pages;

import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * PublicHeaderEH
 */

public class PublicHeaderEH extends BasicPageEH {

	public PublicHeaderEH(WebDriver driver, String jsonName) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "";
		super.initPage(DOMAIN_NAME, jsonName);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject header;
	protected WebObject menuBar;
	protected WebObject logoEH;
	protected WebObject loginLink;
	protected WebObject userIconSprite; //desktop only
	protected WebObject profileName;
	protected WebObject drugs;
	protected WebObject siteSearchBox;
	protected WebObject siteSearchButton;

	public boolean isLogoVisible() {
		Logger.info("Check Logo visibility");
		return logoEH.isVisible();
	}

	public void clickHeaderMenuBar() {
		Logger.info("Click on header menu bar");
		menuBar.click();
	}

	public boolean isLoggedIn() {
		Logger.info("Check if user is logged in");
		if (Settings.isDesktop()) {
			return userIconSprite.isVisible();
		} else {
			clickOnHamburgerMenu();
			return profileName.isVisible();
		}
	}

	public PublicHeaderEH clickOnHamburgerMenu() {
		Logger.info("Click on hamburger menu");
		menuBar.click();
		return this;
	}

	public boolean isSiteSearchBoxVisible() {
		Logger.info("Verifying if the search box is visible");
		return siteSearchBox.isVisible();
	}

	public boolean isSearchButtonVisible() {
		Logger.info("Verifying if the search button is visible");
		return siteSearchButton.isVisible();
	}

	public boolean isLoginLinkVisible() {
		Logger.info("Verifying if the Login link is visible");
		return loginLink.isVisible();
	}
}