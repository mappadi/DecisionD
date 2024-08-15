package everydayhealth.pages.articles;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * ArticleBasePage
 */
public class ArticleBasePage extends ArticleNewTemplatePage {

	public ArticleBasePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "ArticleBasePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject contentCardNativeAd;
	protected WebObject articleBodyBox1Ad;
	protected WebObject articleBodyNative2Ad;
	protected WebObject articleBodyBox2Ad;
	protected WebObject articleBodyBoxExtraAd;
	protected WebObject adBlockBelowArticle;
	protected WebObject adBlockBelowNewsletterModule;

	@Override
	public void waitForPageToLoad() {
		title.waitUntilVisibleOnPage(this);
	}

	public boolean isContentCardNativeAdVisible() {
		Logger.info("Verify if content card native ad is visible");
		contentCardNativeAd.scrollIntoView();
		waitForAjaxRequestToBeFinished();
		return contentCardNativeAd.isVisible();
	}

	public int getContentCardNativeAdWidth() {
		Logger.info("Get width value for content card native ad");
		return contentCardNativeAd.getElementWidth();
	}

	public int getContentCardNativeAdHeight() {
		Logger.info("Get height value for content card native ad");
		return contentCardNativeAd.getElementHeight();
	}

	public boolean isBox1AdVisible(String paragraphNumber) {
		Logger.info("Verify if box1 ad is visible below paragraph #" + paragraphNumber);
		scrollDownThePage();
		return articleBodyBox1Ad.isElementWithTextVisible(paragraphNumber);
	}

	public boolean isBox2AdVisible(String paragraphNumber) {
		Logger.info("Verify if box2 ad is visible below paragraph #" + paragraphNumber);
		return articleBodyBox2Ad.isElementWithTextVisible(paragraphNumber);
	}

	public boolean isBoxExtraAdVisible(String paragraphNumber) {
		Logger.info("Verify if boxextra ad is visible below paragraph #" + paragraphNumber);
		return articleBodyBoxExtraAd.isElementWithTextVisible(paragraphNumber);
	}

	public boolean isNative2AdVisible(String paragraphNumber) {
		Logger.info("Verify if native2 ad is visible below paragraph #" + paragraphNumber);
		return articleBodyNative2Ad.isElementWithTextVisible(paragraphNumber);
	}

	public boolean isAdVisibleBelowArticle(String adBlock) {
		Logger.info("Verify if ad - " + adBlock + " is visible below article content");
		return adBlockBelowArticle.isElementWithTextVisible(adBlock);
	}

	public boolean isAdVisibleBelowNewslettersModule(String adBlock) {
		Logger.info("Verify if ad - " + adBlock + " is visible below newsletters module");
		return adBlockBelowNewsletterModule.isElementWithTextVisible(adBlock);
	}
}
