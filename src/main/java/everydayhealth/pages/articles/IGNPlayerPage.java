package everydayhealth.pages.articles;

import framework.Logger;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

public class IGNPlayerPage extends ArticleNewTemplatePage {

	public IGNPlayerPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "IGNPlayerPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject ignVideoModule;
	protected WebObject screen;
	protected WebObject ignPlayVideoButton;
	protected WebObject ignPauseVideoButton;
	protected WebObject ignVolumeButton;
	protected WebObject ignFullscreenButton;
	protected WebObject ignVideoCaption;
	protected WebObject ignVideoCredit;
	protected WebObject ignHeadLine;

	@Override
	public void waitForPageToLoad() {
		ignVideoModule.waitUntilVisibleOnPage(this);
	}

	public void mouseHoverVideo() {
		Logger.info("Mouse hover over video module");
		if (!ignVolumeButton.isVisible()) {
			screen.mouseHover();
		}
	}

	public boolean isIGNPlayerVisible() {
		Logger.info("Check if IGN player is visible");
		ignVideoModule.waitUntilVisible();
		Utils.scrollPage(ignVideoModule.getYCoordinate() - 100);
		return ignVideoModule.isVisible();
	}

	public int getVideoModuleLocation() {
		Logger.info("Get video module location");
		return ignVideoModule.getElement().getLocation().y;
	}

	public void clickIGNPlayButton() {
		Logger.info("Click 'Play' button");
		mouseHoverVideo();
		ignPlayVideoButton.actionClick();
		waitForAjaxRequestToBeFinished();
	}

	public void scrollVideoPlayerIntoView() {
		ignVideoModule.scrollIntoView();
	}

	public int getIGNPlayerWidth() {
		Logger.info("Get IGN player width value");
		return ignVideoModule.getElementWidth();
	}

	public boolean isIGNVideoPaused() {
		Logger.info("Check if video is paused");
		waitForAjaxRequestToBeFinished();
		return Utils.getJSResult("return EDH.video.player.getPaused();").equals("true");
	}

	public void clickIGNPauseButton() {
		Logger.info("Click 'Pause' button");
		mouseHoverVideo();
		ignPauseVideoButton.actionClick();
		waitForAjaxRequestToBeFinished();
	}

	public void clickIGNMuteButton() {
		Logger.info("Click 'Mute' button");
		mouseHoverVideo();
		ignVolumeButton.actionClick();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isIGNVideoMuted() {
		Logger.info("Check if video is muted");
		return Utils.getJSResult("return EDH.video.player.getMuted();").equals("true");
	}

	public void clickIGNFullscreenButton() {
		Logger.info("Click 'Fullscreen' button");
		mouseHoverVideo();
		ignFullscreenButton.actionClick();
	}

	public boolean isIGNVideoInFullscreenMode() {
		Logger.info("Check if video is in fullscreen mode");
		waitForAjaxRequestToBeFinished();
		return Utils.getJSResult("return EDH.video.player.getFullscreen();").equals("true");
	}

	public boolean isFullScreenButtonOnIGNVideo() {
		Logger.info("Check if full screen button is visible on video");
		mouseHoverVideo();
		return ignFullscreenButton.isVisible();
	}

	public boolean isIGNVideoCreditVisible() {
		Logger.info("Check if IGN video credit is visible");
		return ignVideoCredit.isVisible();
	}

	public boolean isIGNVideoCreditVisible(int videoNo) {
		Logger.info("Check if IGN video credit is visible for player number " + videoNo);
		return ignVideoCredit.isElementNumberVisible(videoNo);
	}

	public boolean isIGNVideoCaptionVisible() {
		Logger.info("Check if IGN video caption is visible");
		return ignVideoCaption.isVisible();
	}

	public boolean isIGNVideoCaptionVisible(int videoNo) {
		Logger.info("Check if IGN video caption is visible for player number " + videoNo);
		return ignVideoCaption.isElementNumberVisible(videoNo);
	}

	public String getIGNVideoCreditHrefValue() {
		Logger.info("Get IGN video credit 'href' attribute value");
		return ignVideoCredit.getAttribute("href");
	}

	public String getIGNVideoCreditHrefValue(int videoNo) {
		Logger.info("Get IGN video credit 'href' attribute value for IGN video number " + videoNo);
		return ignVideoCredit.getHrefOfElementNumber(videoNo);
	}

	public String getIGNVideoCaptionHrefValue() {
		Logger.info("Get IGN video caption 'href' attribute value");
		return ignVideoCaption.getAttribute("href");
	}

	public String getIGNVideoCaptionHrefValue(int videoNo) {
		Logger.info("Get IGN video caption 'href' attribute value for IGN video number " + videoNo);
		return ignVideoCaption.getHrefOfElementNumber(videoNo);
	}

	public boolean isIGNVideoHeaderTitleVisible() {
		Logger.info("Check if ign player has header title visible");
		return ignHeadLine.isVisible();
	}


	public int getIGNVideosCount() {
		Logger.info("Get number of IGN videos on page");
		return ignVideoModule.getVisibleElementsCount();
	}

	public void scrollVideoPlayerIntoView(int videoNo) {
		Logger.info("Scroll page until videos visible for player number " + videoNo);
		ignVideoModule.scrollToElementNumber(videoNo);
	}

	public void clickIGNPlayButton(int videoNo) {
		Logger.info("Click 'Play' button on player number " + videoNo);
		ignPlayVideoButton.actionClickOnElementNumber(videoNo);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isIGNVideoPaused(int videoNo) {
		Logger.info("Check if video is paused for player number " + videoNo);
		waitForAjaxRequestToBeFinished();
		return Utils.getJSResult("return EDH.video" + videoNo + ".player.getPaused();").equals("true");
	}

	public void clickIGNPauseButton(int videoNo) {
		Logger.info("Click 'Pause' button on player number " + videoNo);
		mouseHoverVideo();
		ignPauseVideoButton.actionClickOnElementNumber(videoNo);
		waitForAjaxRequestToBeFinished();
	}

	public void clickIGNMuteButton(int videoNo) {
		Logger.info("Click 'Mute' button on player number " + videoNo);
		mouseHoverVideo();
		ignVolumeButton.actionClickOnElementNumber(videoNo);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isIGNVideoMuted(int videoNo) {
		Logger.info("Check if video is muted for player number " + videoNo);
		return Utils.getJSResult("return EDH.video" + videoNo + ".player.getMuted();").equals("true");
	}

	public void clickIGNFullscreenButton(int videoNo) {
		Logger.info("Click 'Fullscreen' button on player " + videoNo);
		mouseHoverVideo();
		ignFullscreenButton.actionClickOnElementNumber(videoNo);
	}

	public boolean isIGNVideoInFullscreenMode(int videoNo) {
		Logger.info("Check if video is in fullscreen mode for player number " + videoNo);
		waitForAjaxRequestToBeFinished();
		return Utils.getJSResult("return EDH.video" + videoNo + ".player.getFullscreen();").equals("true");
	}
}
