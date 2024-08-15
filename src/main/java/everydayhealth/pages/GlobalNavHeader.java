package everydayhealth.pages;

import everydayhealth.pages.articles.ArticleSavePage;
import everydayhealth.pages.login.LoginPageEH;
import everydayhealth.pages.search.SearchOverlay;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.UserEH;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.fail;

/**
 * GlobalNavHeader
 */
public class GlobalNavHeader extends BasicPageEH {

	public GlobalNavHeader(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "";
		String CLASS_NAME = "GlobalNavHeader";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject header;
	protected WebObject ehLogo;
	protected WebObject hamburgerMenuButton;
	protected WebObject hamburgerMenuIcon;
	protected WebObject hamburgerMenuLabel;
	protected WebObject menuDrawer;
	protected WebObject menuDrawerCCRSection;
	protected WebObject menuDrawerCCR;
	protected WebObject menuDrawerConditionsHeadline;
	protected WebObject menuDrawerConditions;
	protected WebObject menuDrawerConditionsTools;
	protected WebObject menuDrawerHealthyLivingHeadline;
	protected WebObject menuDrawerHealthyLiving;
	protected WebObject menuDrawerHealthToolsHeadline;
	protected WebObject menuDrawerHealthTools;
	protected WebObject menuDrawerHeader;
	protected WebObject menuDrawerHeaderWithText;
	protected WebObject menuDrawerSubscribeLink;
	protected WebObject subscribeButton;
	protected WebObject subscribeButtonIcon;
	protected WebObject subscribeButtonLabel;
	protected WebObject myProfileButton;
	protected WebObject profileOverlayTools;
	protected WebObject profileOverlayTool;
	protected WebObject logInButton;
	protected WebObject logInLabel;
	protected WebObject myProfileLabel;
	protected WebObject logInButtonIcon;
	protected WebObject myProfileIcon;
	protected WebObject searchButton;
	protected WebObject searchLabel;
	protected WebObject searchIcon;
	protected WebObject profileMenu;
	protected WebObject hamburgerMenuCloseIcon;
	protected WebObject myProfileCloseIcon;
	protected WebObject searchCloseIcon;
	protected WebObject searchOverlay;

	private String GREEN_COLOR_RGBA = "rgba(103, 138, 0, 1)";

	@Override
	public void waitForPageToLoad() {
		hamburgerMenuButton.waitUntilVisibleOnPage(this);
	}

	public boolean isGlobalNavHeaderVisible() {
		Logger.info("Check if header is visible");
		return header.isVisible();
	}

	public boolean isEhLogoVisible() {
		Logger.info("Check if 'Everyday Health' logo is visible");
		return ehLogo.isVisible();
	}

	public EHPublicPage clickEhLogo() {
		Logger.info("Click on 'Everyday Health' logo");
		ehLogo.click();
		return new EHPublicPage(basedriver);
	}

	public boolean isHamburgerMenuIconVisible() {
		Logger.info("Check if hamburger menu icon is visible");
		return hamburgerMenuIcon.isVisible();
	}

	public boolean isHamburgerMenuLabelVisible() {
		Logger.info("Check if hamburger 'Menu' label is visible");
		return hamburgerMenuLabel.isVisible();
	}

	public boolean isMenuDrawerVisible() {
		Logger.info("Check if menu drawer is visible");
		return menuDrawer.isVisible();
	}

	public boolean isSubscribeIconVisible() {
		Logger.info("Check if 'Subscribe' button icon is visible");
		return subscribeButtonIcon.isVisible();
	}

	public boolean isSubscribeLabelVisible() {
		Logger.info("Check if 'Subscribe' label is visible");
		return subscribeButtonLabel.isVisible();
	}

	public boolean isLogInLabelVisible() {
		Logger.info("Check if 'Login' label is visible");
		return logInLabel.isVisible();
	}

	public boolean isMyProfileLabelVisible() {
		Logger.info("Check if 'My Profile' label is visible");
		return myProfileLabel.isVisible();
	}

	public boolean isMyProfileIconVisible() {
		Logger.info("Check if 'My profile' icon is visible");
		return myProfileIcon.isVisible();
	}

	public boolean isLoginIconVisible() {
		Logger.info("Check if 'Login' button icon is visible");
		return logInButtonIcon.isVisible();
	}

	public boolean isSearchLabelVisible() {
		Logger.info("Check if 'Search' label is visible");
		return searchLabel.isVisible();
	}

	public boolean isSearchIconVisible() {
		Logger.info("Check if 'Search' button icon is visible");
		return searchIcon.isVisible();
	}

	public int getEhLogoXCoordinate() {
		Logger.info("Get 'Everyday Health' logo X coordinate");
		return ehLogo.getXCoordinate();
	}

	public int getHamburgerMenuButtonXCoordinate() {
		Logger.info("Get hamburger 'Menu' button X coordinate");
		return hamburgerMenuButton.getXCoordinate();
	}

	public int getSubscribeButtonXCoordinate() {
		Logger.info("Get 'Subscribe' button X coordinate");
		return subscribeButtonIcon.getXCoordinate();
	}

	public int getLoginButtonXCoordinate() {
		Logger.info("Get 'Login' button X coordinate");
		return logInButtonIcon.getXCoordinate();
	}

	public int getMyProfileButtonXCoordinate() {
		Logger.info("Get 'My Profile' button X coordinate");
		return myProfileIcon.getXCoordinate();
	}

	public int getSearchButtonXCoordinate() {
		Logger.info("Get 'Search' button X coordinate");
		return searchIcon.getXCoordinate();
	}

	public void menuButtonClick() {
		Logger.info("Click on hamburger 'Menu' button");
		if (Settings.isDesktop()) {
			hamburgerMenuButton.actionClick();
			waitForAjaxRequestToBeFinished();
		} else {
			hamburgerMenuButton.click();
		}
		waitForAjaxRequestToBeFinished();
	}

	public String getSubscribeButtonHrefValue() {
		Logger.info("Get 'Subscribe' button 'href' attribute value");
		return subscribeButton.getAttribute("href");
	}

	public String getLoginButtonHrefValue() {
		Logger.info("Get 'Login' button 'href' attribute value");
		return logInButton.getAttribute("href");
	}

	public SearchOverlay clickSearchButton() {
		Logger.info("Click on 'Search' button");
		searchButton.click();
		if (!searchOverlay.isVisible()) {
			searchCloseIcon.waitUntilVisible();
		}
		return new SearchOverlay(basedriver);
	}

	public void clickMyProfileButton() {
		Logger.info("Click 'My profile' button");
		myProfileButton.click();
		if (!profileMenu.isVisible()) {
			myProfileCloseIcon.waitUntilVisible();
		}
	}

	public boolean isProfileOverlayItemVisible(String itemText) {
		Logger.info("Check if Profile overlay item '" + itemText + "' is visible");
		if (!profileMenu.isVisible()) {
			myProfileButton.click();
			profileMenu.waitUntilVisible();
		}
		if (Settings.isMobile()) {
			profileOverlayTool.scrollToElementNumber(6);
		}
		return profileOverlayTools.isElementWithTextVisible(itemText);
	}

	public ArticleSavePage clickProfileOverlayItem(String itemText) {
		Logger.info("Click on overlay item '" + itemText + "' under My Profile");
		if (!profileMenu.isVisible()) {
			myProfileButton.click();
			profileMenu.waitUntilVisible();
		}
		profileOverlayTools.clickOnElementNumberWithText(1, itemText);
		return new ArticleSavePage(basedriver);
	}

	public String getProfileOverlayItemHref(int number, String itemText) {
		Logger.info("Get profile overlay " + itemText + " 'href' attribute value");
		if (!profileMenu.isVisible()) {
			myProfileButton.click();
			profileMenu.waitUntilVisible();
		}
		return profileOverlayTools.getAttributeOfElementNumberWithText(number, "href", itemText);
	}

	public LoginPageEH clickLogin() {
		Logger.info("Clicking Login link");
		logInButtonIcon.click();
		return new LoginPageEH(basedriver);
	}

	public <T> T loginWithUserAndOpenPage(UserEH user, Class<T> expectedPage) {
		try {
			onGlobalNavHeader().clickLogin().enterCredentialsAndSubmitForm(user);
		} catch (Exception e) {
			fail("Login action failed: " + WebDriverManager.getDriver().getCurrentUrl(), e);
		}
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public void userLogOut() {
		Logger.info("Logging user out");
		if (!profileMenu.isVisible()) {
			myProfileButton.click();
			profileMenu.waitUntilVisible();
		}
		profileOverlayTools.clickOnElementNumberWithText(1, "Logout");
		if (!Settings.isDesktop()) {
			waitFor(2000);//Wait for page to start load on device
		}
		waitForAjaxRequestToBeFinished();
	}

	public boolean isMenuDrawerCCRSectionVisible() {
		Logger.info("Check if CCR Section is visible on menu drawer");
		return menuDrawerCCRSection.isVisible();
	}

	public int getNumberOfCCRLinks() {
		Logger.info("Get number of CCR links in menu drawer");
		return menuDrawerCCR.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefOfCCRLink(int number) {
		Logger.info("Get 'href' attribute value of CCR link #" + number);
		return menuDrawerCCR.getAttributeOfElementNumber(number, "href");
	}

	public int getNumberOfConditionLinks() {
		Logger.info("Get number of condition links");
		return menuDrawerConditions.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefOfCConditionLink(int number) {
		Logger.info("Get 'href' attribute value of condition link #" + number);
		return menuDrawerConditions.getAttributeOfElementNumber(number, "href");
	}

	public String getConditionText(int number) {
		Logger.info("Get condition text");
		return menuDrawerConditions.getTextFromElementNumber(number);
	}

	public int getNumberOfHLLinks() {
		Logger.info("Get number of Healthy living links");
		return menuDrawerHealthyLiving.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefOfHLLink(int number) {
		Logger.info("Get 'href' attribute value of healthy living link #" + number);
		return menuDrawerHealthyLiving.getAttributeOfElementNumber(number, "href");
	}

	public String getHLText(int number) {
		Logger.info("Get healthy living text");
		return menuDrawerHealthyLiving.getTextFromElementNumber(number);
	}

	public int getNumberOfToolsLinks() {
		Logger.info("Get number of Tools links");
		return menuDrawerHealthTools.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefOfToolsLink(int number) {
		Logger.info("Get 'href' attribute value of tools link #" + number);
		return menuDrawerHealthTools.getAttributeOfElementNumber(number, "href");
	}

	public String getToolText(int number) {
		Logger.info("Get tool text");
		return menuDrawerHealthTools.getTextFromElementNumber(number);
	}

	public String getMenuHeaderText(int menuNumber) {
		Logger.info("Get menu header text");
		return menuDrawerHeader.getTextFromElementNumber(menuNumber);
	}

	public boolean isMenuHeaderVisible(String headerText) {
		Logger.info("Check if menu header with text '" + headerText + "' is visible");
		return menuDrawerHeaderWithText.isElementWithTextVisible(headerText);
	}

	public boolean isMenuHeaderVisible(int menuNumber) {
		Logger.info("Check if menu header is visible");
		return menuDrawerHeader.isElementNumberVisible(menuNumber);
	}

	public boolean isMenuDrawerSubscribeLinkVisible() {
		Logger.info("Check if 'Subscribe' link is visible on menu drawer");
		menuDrawerSubscribeLink.scrollToElement();
		return menuDrawerSubscribeLink.isVisible();
	}

	public boolean isLoggedIn() {
		Logger.info("Verify user is logged in");
		return myProfileButton.isVisible();
	}

	public String getConditionsHeadlineBorderColor() {
		Logger.info("Get 'Conditions' section border color");
		return menuDrawerConditionsHeadline.getCssValue("border-color");
	}

	public String getHealthyLivingHeadlineBorderColor() {
		Logger.info("Get 'Healthy Living' section border color");
		return menuDrawerHealthyLivingHeadline.getCssValue("border-color");
	}

	public String getHealthToolsBorderColor() {
		Logger.info("Get 'Health Tools' section border color");
		return menuDrawerHealthToolsHeadline.getCssValue("border-color");
	}

	public boolean isConditionToolFontBold(String tool) {
		Logger.info("Verify condition tool - " + tool + " font is bold");
		String fontWeightValue = menuDrawerConditionsTools.getCSSValueFromElementWithText("font-weight", tool);
		Logger.debug(fontWeightValue);
		return fontWeightValue.equals("700") || fontWeightValue.equals("bold"); //700 is bold, 100 is normal
	}

	public String getHrefOfConditionToolsLink(int element, String tool) {
		Logger.info("Get 'href' attribute value of condition tools - " + tool);
		return menuDrawerConditionsTools.getAttributeOfElementNumberWithText(element, "href", tool);
	}

	public boolean isConditionToolVisible(String tool) {
		Logger.info("Check if condition tool - " + tool + " is visible");
		return menuDrawerConditionsTools.isElementWithTextVisible(tool);
	}

	public boolean isMenuCloseIconVisible() {
		Logger.info("Verify if 'Menu' 'Close' (X) icon is visible");
		return hamburgerMenuCloseIcon.isVisible();
	}

	public boolean isMenuCloseIconGreen() {
		Logger.info("Verify 'Menu' 'Close' (X) icon is green");
		return hamburgerMenuCloseIcon.getColor().equals(GREEN_COLOR_RGBA);
	}

	public void clickMenuCloseIcon() {
		Logger.info("Click 'Menu' 'Close' (X) icon");
		hamburgerMenuCloseIcon.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isMyProfileCloseIconVisible() {
		Logger.info("Verify if 'My Profile' 'Close' (X) icon is visible");
		return myProfileCloseIcon.isVisible();
	}

	public boolean isMyProfileCloseIconGreen() {
		Logger.info("Verify 'My Profile' 'Close' (X) icon is green");
		return myProfileCloseIcon.getColor().equals(GREEN_COLOR_RGBA);
	}

	public void clickMyProfileCloseIcon() {
		Logger.info("Click 'My Profile' 'Close' (X) icon");
		myProfileCloseIcon.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isSearchCloseIconVisible() {
		Logger.info("Verify if 'Search' 'Close' (X) icon is visible");
		return searchCloseIcon.isVisible();
	}

	public boolean isSearchCloseIconGreen() {
		Logger.info("Verify 'Search' 'Close' (X) icon is green");
		return searchCloseIcon.getColor().equals(GREEN_COLOR_RGBA);
	}

	public void clickSearchCloseIcon() {
		Logger.info("Click 'Search' 'Close' (X) icon");
		searchCloseIcon.click();
		searchOverlay.waitUntilInvisible();
	}

	public boolean isSearchOverlayVisible() {
		Logger.info("Verify if search overlay is visible");
		return searchOverlay.isVisible();
	}
}
