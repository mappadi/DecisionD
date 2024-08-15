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
 * Header Page for Condition Center (CCR)
 */

public class PublicHeaderCCR extends BasicPageEH {

	public PublicHeaderCCR(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "";
		String CLASS_NAME = "PublicHeaderCCR";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject header;
	protected WebObject headerLogo;
	protected WebObject headerSearchIcon;
	protected WebObject headerExplore;
	protected WebObject headerCloseExplore;
	protected WebObject headerLogin;
	protected WebObject headerLoginIcon;
	protected WebObject profileOverlayTools;
	protected WebObject myProfile;
	protected WebObject headerLoginIconAfterLogin;
	protected WebObject headerLoginMobile;
	protected WebObject logoutLink;

	@Override
	public void waitForPageToLoad() {
		headerLogo.waitUntilVisibleOnPage(this);
	}

	public boolean isHeaderLogoVisible() {
		Logger.info("Verifying header logo is visible");
		return headerLogo.isVisible();
	}

	public void moveToLogo() {
		Logger.info("Move mouse pointer to EH logo");
		headerLogo.mouseHover();
	}

	public boolean isSearchIconVisible() {
		Logger.info("Verifying search icon is visible");
		return headerSearchIcon.isVisible();
	}

	public boolean isExploreLinkVisible() {
		Logger.info("Verifying Explore link is visible on: " + Settings.getPlatform());
		return headerExplore.isVisible();
	}

	public boolean isLoginLinkVisible() {
		Logger.info("Verifying Login link is visible on: " + Settings.getPlatform());
		return headerLogin.isVisible();
	}

	public boolean isLoginIconVisible() {
		Logger.info("Verifying Login Icon visible");
		return headerLoginIcon.isVisible();
	}

	public <T> T loginWithUserAndOpenPage(UserEH user, Class<T> expectedPage) {
		try {
			openLoginPage().enterCredentialsAndSubmitForm(user);
		} catch (Exception e) {
			fail("Login action failed: " + WebDriverManager.getDriver().getCurrentUrl(), e);
		}
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public LoginPageEH openLoginPage() {
		Logger.info("Opening Login Page from header");
		headerLoginIcon.click();
		return PageFactory.initElements(WebDriverManager.getDriver(), LoginPageEH.class);
	}

	public SearchOverlay clickOnSearchIcon() {
		Logger.info("Clicking on search icon");
		headerSearchIcon.click();
		waitForAjaxRequestToBeFinished();
		return PageFactory.initElements(WebDriverManager.getDriver(), SearchOverlay.class);
	}

	public void mouseHoverMyProfile() {
		Logger.info("Mouse hover on My profile");
		myProfile.mouseHover();
		waitForAjaxRequestToBeFinished();
	}

	public LoginPageEH clickLogin() {
		Logger.info("Clicking Login link");
		if (Settings.isMobile()) {
			headerLoginMobile.click();
		} else {
			headerLogin.click();
		}
		return PageFactory.initElements(WebDriverManager.getDriver(), LoginPageEH.class);
	}

	public ArticleSavePage clickElementOnMyProfileMenu(int elementNumber) {
		Logger.info("Clicking element " + elementNumber + " under My profile menu");
		if (Settings.isDesktop()) {
			mouseHoverMyProfile();
		}
		profileOverlayTools.clickOnElementNumber(elementNumber);
		return PageFactory.initElements(WebDriverManager.getDriver(), ArticleSavePage.class);
	}

	public boolean isLoggedIn() {
		Logger.info("Check if user is logged in");
		return !headerLoginIcon.isVisible();
	}

	public void userLogOut() {
		Logger.info("Logging user out");
		if(Settings.isDesktop()) {
			mouseHoverMyProfile();
		} else {
			myProfile.click();
		}
		logoutLink.click();
		if (!Settings.isDesktop()) {
			waitFor(2000);//Wait for page to start load on device
		}
		waitForAjaxRequestToBeFinished();
	}
}
