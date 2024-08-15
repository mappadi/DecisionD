package everydayhealth.pages.share;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import framework.platform.utilities.WindowUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * SocialBarEH
 */
public class SocialBarEH extends BasicPageEH {

	public SocialBarEH(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "share";
		String CLASS_NAME = "SocialBarEH";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject socialBar;
	protected WebObject facebookShareButton;
	protected WebObject twitterShareButton;
	protected WebObject pinterestShareButton;
	protected WebObject emailShareButton;
	protected WebObject printShareButton;
	protected WebObject socialShareButtons;
	protected WebObject socialShareButtonsCuso;
	protected WebObject socialShareButtonsNew;
	protected WebObject socialShareCount;
	protected WebObject saveLink;
	protected WebObject saveLinkBookmark;

	@Override
	public void waitForPageToLoad() {
		if (legalText.isVisible()) {
			legalTextClose.click();
			waitForAjaxRequestToBeFinished();
		}
		waitForAjaxRequestToBeFinished();
	}

	public boolean isSocialBarVisible() {
		Logger.info("Verify social bar is visible");
		if (Settings.isDesktop()) { //Visible doesn't work on mobile
			return socialBar.isVisible();
		} else {
			return socialBar.isPresent();
		}
	}

	public boolean isFacebookShareButtonVisible() {
		Logger.info("Verify 'Facebook' share button is visible");
		if (Settings.isDesktop()) {
			return facebookShareButton.isVisible();
		} else {
			return socialBar.isPresent();
		}
	}

	public boolean isTwitterShareButtonVisible() {
		Logger.info("Verify 'Twitter' share button is visible");
		if (Settings.isDesktop()) {
			return twitterShareButton.isVisible();
		} else {
			return socialBar.isPresent();
		}
	}

	public boolean isPinterestShareButtonVisible() {
		Logger.info("Verify 'Pinterest' share button is visible");
		if (Settings.isDesktop()) {
			return pinterestShareButton.isVisible();
		} else {
			return socialBar.isPresent();
		}
	}

	public boolean isEmailShareButtonVisible() {
		Logger.info("Verify 'Email' share button is visible");
		if (Settings.isDesktop()) {
			return emailShareButton.isVisible();
		} else {
			return socialBar.isPresent();
		}
	}

	public boolean isPrintShareButtonVisible() {
		Logger.info("Verify 'Print' share button is visible");
		return printShareButton.isVisible();
	}

	public void clickOnFacebookShareButton() {
		Logger.info("Click on 'Facebook' share button");
		facebookShareButton.click();
	}

	public void clickOnTwitterShareButton() {
		Logger.info("Click on 'Twitter' share button");
		twitterShareButton.click();
	}

	public void clickOnPinterestShareButton() {
		Logger.info("Click on 'Pinterest' share button");
		pinterestShareButton.click();
	}

	public void verifyFacebookPopUpContainsFacebook() {
		Logger.info("Verify facebook pop up contains 'facebook'");
		WindowUtils.switchToLastOpenedWindow();
		assertTrue(Utils.currentUrlContains("facebook.com"), "Pop up URL must contain 'facebook.com'");
		WindowUtils.switchToMainWindow();
	}

	public void verifyTwitterPopUpContainsTwitter() {
		Logger.info("Verify twitter pop up contains 'twitter'");
		WindowUtils.switchToLastOpenedWindow();
		assertTrue(Utils.currentUrlContains("twitter.com"), "Pop up URL must contain 'twitter.com'");
		WindowUtils.switchToMainWindow();
	}

	public void verifyPinterestPopUpContainsPinterest() {
		Logger.info("Verify pinterest pop up contains 'pinterest'");
		WindowUtils.switchToLastOpenedWindow();
		assertTrue(Utils.currentUrlContains("pinterest.com"), "Pop up URL must contain 'pinterest.com'");
		WindowUtils.switchToMainWindow();
	}

	public void verifyAllPopUpsContainRespectiveDomain() {
		Logger.info("Verify all pop ups contain respective domains");
		clickOnFacebookShareButton();
		WindowUtils.switchToLastOpenedWindow();
		assertTrue(Utils.currentUrlContains("facebook.com"), "Pop up URL must contain 'facebook.com'");
		WindowUtils.switchToMainWindow();
		clickOnTwitterShareButton();
		WindowUtils.switchToLastOpenedWindow();
		assertTrue(Utils.currentUrlContains("twitter.com"), "Pop up URL must contain 'twitter.com'");
		WindowUtils.switchToMainWindow();
		clickOnPinterestShareButton();
		WindowUtils.switchToLastOpenedWindow();
		assertTrue(Utils.currentUrlContains("pinterest.com"), "Pop up URL must contain 'pinterest.com'");
		WindowUtils.switchToMainWindow();
	}

	public int getNumberOfShareButtonsWithShareCountAttribute() {
		Logger.info("Get number of share buttons with share count attribute");
		return socialShareButtons.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfShareButtons() {
		Logger.info("Get number of share buttons");
		return socialShareButtonsCuso.getNumberOfVisibleAndClickableElements();
	}

	public boolean isNewShareBarVisible() {
		Logger.info("Verify if new share bar is visible");
		return socialShareButtonsNew.isVisible();
	}

	public String getSumOfSharesFromSocialShareButtons(boolean inDisplayedFormat) {
		Logger.info("Get the sum of all shares: facebook, twitter, pinterest, email, print");
		int sumOfShares = 0;
		for (WebElement webElement : socialShareButtons.getElements()) {
			int sharesNumber = Integer.parseInt(webElement.getAttribute("data-count"));
			Logger.info("Get the count of shares: " + sharesNumber);
			sumOfShares += sharesNumber;
		}
		String sumOfSharesString = Integer.toString(sumOfShares);
		if (sumOfShares >= 1000 && inDisplayedFormat) {
			sumOfSharesString = Integer.toString(sumOfShares / 1000) + "K";
		}
		return sumOfSharesString;
	}

	public String getNumberOfShares() {
		Logger.info("Get number of total shares");
		if (socialShareCount.getText().equalsIgnoreCase("SHARE")) {
			return "0";
		}
		return socialShareCount.getText()
				.replaceAll("\nshares", "")
				.replaceAll("\nshare", "")
				.replaceAll("\nShare", "")
				.replaceAll("\nShares", "")
				.replaceAll(" Shares", "")
				.replaceAll("shares", "")
				.replaceAll(" Share", "")
				.replaceAll("Share", "")
				.replaceAll("share", "");
	}

	public String getTwitterShareLink() {
		Logger.info("Get twitter share link");
		return twitterShareButton.getAttribute("href");
	}

	public String getFacebookShareLink() {
		Logger.info("Get facebook share link");
		return facebookShareButton.getAttribute("href");
	}

	public String getPinterestShareLink() {
		Logger.info("Get pinterest share link");
		return pinterestShareButton.getAttribute("href");
	}

	public void clickPrintShareButton() {
		Logger.info("Click on print share button");
		((JavascriptExecutor) basedriver).executeScript("window.print=function(){};"); //disabling print dialog window
		printShareButton.click();
	}

	public void closePrintDialog() {
		Logger.info("Close print dialog by hitting ESC button");
		WindowUtils.switchToLastOpenedWindow();
		WindowUtils.switchToMainWindow();
	}

	public ShareViaEmailPopUp clickEmailShareButton() {
		Logger.info("Click on email share button");
		emailShareButton.click();
		return PageFactory.initElements(basedriver, ShareViaEmailPopUp.class);
	}

	public boolean isSocialShareCountVisible() {
		Logger.info("Check if social share count is visible");
		if (Settings.isDesktop()) {
			return socialShareCount.isVisible();
		} else {
			return socialShareCount.isPresent();
		}
	}

	public int getSocialShareBarXCoordinate() {
		return socialBar.getElement().getLocation().x;
	}

	public void verifyNumberOfSharesIncreasedAfterClick(SocialBarEH socialBar, String sharesNumberBeforeClicks) {
		if ((!Settings.isMobile() || !(socialBar.isNewShareBarVisible())) && (!sharesNumberBeforeClicks.contains("K"))) {
			Logger.info("Verify number total shares increased for 1 after click for article with < 1000 shares");
			int shareCount = Integer.parseInt(sharesNumberBeforeClicks) + 1;
			if (shareCount % 1000 == 0) {
				shareCount = shareCount / 1000;
				sharesNumberBeforeClicks = Integer.toString(shareCount) + "K";
			} else {
				sharesNumberBeforeClicks = Integer.toString(shareCount);
			}
			assertEquals(socialBar.getNumberOfShares(), sharesNumberBeforeClicks, "Share number is not increased for 1 after share");
		}
	}

	public boolean isSaveLinkVisible() {
		Logger.info("Check Save link is visible");
		return saveLink.isVisible();
	}

	public String getSaveLinkText() {
		Logger.info("Getting the text of Save/Saved link");
		return saveLink.getText();
	}

	public void clickSaveLink() {
		Logger.info("Clicking the 'Save' link");
		saveLink.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isSaveButtonOnLeftHandSideOfScreen() {
		Logger.info("Check if 'Save' button is on the left hand side of screen");
		int screenWidth = basedriver.manage().window().getSize().getWidth();
		int saveButtonXCoordinate = saveLink.getElement().getLocation().x;
		return (screenWidth / 2) > saveButtonXCoordinate;
	}
}