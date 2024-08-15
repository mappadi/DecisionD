package everydayhealth.pages;

import framework.Logger;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

/**
 * PublicFooterZD
 */
public class PublicFooterZD extends BasicPageEH {

	public PublicFooterZD(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "";
		String CLASS_NAME = "PublicFooterZD";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject footer;
	protected WebObject footerLogo;
	protected WebObject footerText;
	protected WebObject socialBar;
	protected WebObject facebookButton;
	protected WebObject twitterButton;
	protected WebObject instagramButton;
	protected WebObject pinterestButton;
	protected WebObject googleplusButton;
	protected WebObject ehLinksInColumns;
	protected WebObject ehLinks;
	protected WebObject adChoiceIcon;
	protected WebObject footerBorderLine;
	protected WebObject honCodeSection;
	protected WebObject honCodeImage;
	protected WebObject honCodeImageLink;
	protected WebObject honCodeText;
	protected WebObject honCodeVerifyHereLink;
	protected WebObject footerCopyright;
	protected WebObject ziffDavisLinksContainer;
	protected WebObject ziffDavisLinksDescription;
	protected WebObject ziffDavisLinks;

	@Override
	public void waitForPageToLoad() {
		footer.waitUntilVisibleOnPage(this);
	}

	public boolean isFooterVisible() {
		Logger.info("Verify if footer is visible");
		return footer.isVisible();
	}

	public String getFooterBackgroundColor() {
		Logger.info("Get footer background color");
		return Utils.getHexColor(footer.getCssValue("background-color"));
	}

	public boolean isEHLogoVisible() {
		Logger.info("Verify if EH logo is visible");
		return footerLogo.isVisible();
	}

	public boolean isFooterTextVisible() {
		Logger.info("Verify if footer text is visible");
		return footerText.isVisible();
	}

	public String getFooterText() {
		Logger.info("Get footer text");
		return footerText.getText();
	}

	public String getFooterTextCSSAttribute(String cssAttr) {
		Logger.info("Get CSS attribute - '" + cssAttr + "' for logo text");
		return footerText.getCssValue(cssAttr).toLowerCase();
	}

	public boolean isSocialBarVisible() {
		Logger.info("Verify if social bar is visible in footer");
		return socialBar.isVisible();
	}

	public boolean isFacebookButtonVisible() {
		Logger.info("Verify if 'Facebook' button is visible");
		return facebookButton.isVisible();
	}

	public String getFacebookButtonHrefValue() {
		Logger.info("Get 'Facebook' button 'href' attribute value");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EH-6203");
		return facebookButton.getAttribute("href");
	}

	public boolean isTwitterButtonVisible() {
		Logger.info("Verify if 'Twitter' button is visible");
		return twitterButton.isVisible();
	}

	public String getTwitterButtonHrefValue() {
		Logger.info("Get 'Twitter' button 'href' attribute value");
		return twitterButton.getAttribute("href");
	}

	public boolean isInstagramButtonVisible() {
		Logger.info("Verify if 'Instagram' button is visible");
		return instagramButton.isVisible();
	}

	public String getInstagramButtonHrefValue() {
		Logger.info("Get 'Instagram' button 'href' attribute value");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EH-6046");
		return instagramButton.getAttribute("href");
	}

	public boolean isPinterestButtonVisible() {
		Logger.info("Verify if 'Pinterest' button is visible");
		return pinterestButton.isVisible();
	}

	public String getPinterestButtonHrefValue() {
		Logger.info("Get 'Pinterest' button 'href' attribute value");
		return pinterestButton.getAttribute("href");
	}

	public boolean isGooglePlusButtonVisible() {
		Logger.info("Verify if 'Google Plus' button is visible");
		return googleplusButton.isVisible();
	}

	public String getGooglePlusButtonHrefValue() {
		Logger.info("Get 'Google Plus' button 'href' attribute value");
		return googleplusButton.getAttribute("href");
	}

	public String getEHLinkTextFromColumn(int columnNumber, int linkNumber) {
		Logger.info("Get text from link # " + linkNumber + " in column #" + columnNumber);
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHF-4377");
		return ehLinksInColumns.getTextFromElementWithText(String.valueOf(columnNumber), linkNumber);
	}

	public String getEHLinkHrefFromColumn(int columnNumber, int linkNumber) {
		Logger.info("Get 'href' value from link # " + linkNumber + " in column #" + columnNumber);
		return ehLinksInColumns.getAttributeOfElementNumberWithText(linkNumber, "href", String.valueOf(columnNumber));
	}

	public int getNumberOfEHLinksInFooter() {
		Logger.info("Get total number of EH links in footer");
		return ehLinks.getNumberOfVisibleAndClickableElements();
	}

	public String getCSSAttributeForEHLink(int linkNumber, String cssAttr) {
		Logger.info("Get CSS attribute '" + cssAttr + "' for link #" + linkNumber);
		return ehLinks.getCssOfElementNumber(linkNumber, cssAttr).toLowerCase();
	}

	public boolean isAdChoiceLinkIconVisible() {
		Logger.info("Verify if AdChoice link icon is visible");
		return adChoiceIcon.isVisible();
	}

	public boolean isHONCodeSectionVisible() {
		Logger.info("Verify if HON Code section is visible");
		return honCodeSection.isVisible();
	}

	public boolean isHONCodeImageVisible() {
		Logger.info("Verify if HON Code image is visible");
		return honCodeImage.isVisible();
	}

	public String getHONCodeImageHrefValue() {
		Logger.info("Get HON Code image 'href' attribute value");
		return honCodeImageLink.getAttribute("href");
	}

	public String getHONCodeSectionText() {
		Logger.info("Get HON Code section text");
		return honCodeText.getText();
	}

	public boolean isHONCodeTextVisible() {
		Logger.info("Verify if HON Code section text is visible");
		return honCodeText.isVisible();
	}

	public String getHONCodeVerifyHereLinkHrefValue() {
		Logger.info("Get 'verify here' link 'href' attribute value");
		return honCodeVerifyHereLink.getAttribute("href");
	}

	public boolean isCopyrightTextVisible() {
		Logger.info("Verify if copyright text is visible");
		return footerCopyright.isVisible();
	}

	public String getCopyrightText() {
		Logger.info("Get copyright text");
		return footerCopyright.getText();
	}

	public String getCopyrightTextCSSAttribute(String cssAttr) {
		Logger.info("Get CSS attribute '" + cssAttr + "' for copyright text");
		return footerCopyright.getCssValue(cssAttr).toLowerCase();
	}

	public boolean isZiffDavisLinksBlockVisible() {
		Logger.info("Verify if Ziff Davis links block is visible");
		return ziffDavisLinksContainer.isVisible();
	}

	public String getZiffDavisLinksDescription() {
		Logger.info("Get description for links in Ziff Davis links container");
		return ziffDavisLinksDescription.getText();
	}

	public String getZiffDavisLinksDescriptionCSSAttribute(String cssAttr) {
		Logger.info("Get CSS attribute '" + cssAttr + "' for 'More From Ziff Davis' text");
		return ziffDavisLinksDescription.getCssValue(cssAttr).toLowerCase();
	}

	public String getTextFromZiffDavisLink(int linkNumber) {
		Logger.info("Get text from link #" + linkNumber);
		return ziffDavisLinks.getTextFromElementNumber(linkNumber);
	}

	public int getNumberOfZDLinks() {
		Logger.info("Get number of Ziff Davis links in footer");
		return ziffDavisLinks.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefValueForZiffDavisLink(int linkNumber) {
		Logger.info("Get 'href' attribute value for link #" + linkNumber);
		return ziffDavisLinks.getHrefOfElementNumber(linkNumber);
	}

	public String getCSSAttributeForZDLink(int linkNumber, String cssAttr) {
		Logger.info("Get CSS attribute '" + cssAttr + "' for ZD link #" + linkNumber);
		return ziffDavisLinks.getCssOfElementNumber(linkNumber, cssAttr).toLowerCase();
	}

	public boolean isFooterBorderVisible() {
		Logger.info("Verify if footer border is visible");
		return footerBorderLine.isVisible();
	}
}