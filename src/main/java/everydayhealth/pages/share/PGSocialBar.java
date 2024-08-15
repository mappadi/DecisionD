package everydayhealth.pages.share;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * PGSocialBar
 */
public class PGSocialBar extends BasicPageEH {

	public PGSocialBar(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "share";
		String CLASS_NAME = "PGSocialBar";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject shareBarContainer;
	protected WebObject shareBarFacebookButton;
	protected WebObject shareBarTwitterButton;
	protected WebObject shareBarPinterestButton;
	protected WebObject shareBarEmailButton;
	protected WebObject shareBarPrintButton;
	protected WebObject twitterShareMessageTextArea;
	protected WebObject shareBarExtend;
	protected WebObject bottomShareBar;
	protected WebObject bottomShareBarFacebookButton;
	protected WebObject bottomShareBarTwitterButton;
	protected WebObject bottomShareBarPinterestButton;
	protected WebObject bottomShareBarEmailButton;

	@Override
	public void waitForPageToLoad() {
		if (Settings.isMobile()) {
			shareBarExtend.waitUntilVisibleOnPage(this);
		} else {
			shareBarFacebookButton.waitUntilVisibleOnPage(this);
		}
	}

	public boolean isShareBarVisible() {
		Logger.info("Verify if share bar is visible");
		if (Settings.isMobile()) {
			shareBarExtend.click();
			waitForAjaxRequestToBeFinished();
		}
		return shareBarContainer.isVisible();
	}

	public boolean isFacebookShareButtonVisible() {
		Logger.info("Verify if 'Facebook' share button is visible");
		return shareBarFacebookButton.isVisible();
	}

	public void clickFacebookShareButton() {
		Logger.info("Click 'Facebook' share button");
		shareBarFacebookButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isTwitterShareButtonVisible() {
		Logger.info("Verify if 'Twitter' share button is visible");
		return shareBarTwitterButton.isVisible();
	}

	public void clickTwitterShareButton() {
		Logger.info("Click 'Twitter' share button");
		shareBarTwitterButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isPinterestShareButtonVisible() {
		Logger.info("Verify if 'Pinterest' share button is visible");
		return shareBarPinterestButton.isVisible();
	}

	public boolean isEmailShareButtonVisible() {
		Logger.info("Verify if 'Email' share button is visible");
		return shareBarEmailButton.isVisible();
	}

	public ShareViaEmailPopUp clickEmailShareButton() {
		Logger.info("Click 'Email' share button");
		shareBarEmailButton.click();
		waitForAjaxRequestToBeFinished();
		return new ShareViaEmailPopUp(basedriver);
	}

	public boolean isPrintShareButtonVisible() {
		Logger.info("Verify if 'Print' share button is visible");
		return shareBarPrintButton.isVisible();
	}

	public void clickPrintShareButton() {
		Logger.info("Click 'Print' share button");
		shareBarPrintButton.click();
	}

	public String getTwitterStatusText() {
		Logger.info("Get Twitter status");
		String status = twitterShareMessageTextArea.getText();
		Logger.info("Shared tweet - " + status);
		return status;
	}

	public boolean isBottomShareBarVisible() {
		Logger.info("Verify if bottom share bar is visible");
		bottomShareBar.scrollIntoView();
		return bottomShareBar.isVisible();
	}

	public boolean isBottomShareBarFacebookButtonVisible() {
		Logger.info("Verify if 'Facebook' button is visible on bottom share bar");
		return bottomShareBarFacebookButton.isVisible();
	}

	public boolean isBottomShareBarTwitterButtonVisible() {
		Logger.info("Verify if 'Twitter' button is visible on bottom share bar");
		return bottomShareBarTwitterButton.isVisible();
	}

	public boolean isBottomShareBarPinterestButtonVisible() {
		Logger.info("Verify if 'Pinterest' button is visible on bottom share bar");
		return bottomShareBarPinterestButton.isVisible();
	}

	public boolean isBottomShareBarEmailButtonVisible() {
		Logger.info("Verify if 'Email' button is visible on bottom share bar");
		return bottomShareBarEmailButton.isVisible();
	}
}
