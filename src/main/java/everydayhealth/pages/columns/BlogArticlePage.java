package everydayhealth.pages.columns;

import everydayhealth.pages.articles.ArticleNewTemplatePage;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * BlogArticlePage
 */
public class BlogArticlePage extends ArticleNewTemplatePage {

	public BlogArticlePage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "columns";
		String CLASS_NAME = "BlogArticlePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject personalTakes;
	protected WebObject personalTakesIcon;
	protected WebObject articleAuthorImage;
	protected WebObject articleAuthorName;
	protected WebObject articleDisclaimer;
	protected WebObject articleDisclaimerShortened;
	protected WebObject articleDisclaimerExpanded;
	protected WebObject articleDisclaimerSeeMore;

	@Override
	public void waitForPageToLoad() {
		articleAuthorImage.waitUntilVisibleOnPage(this);
	}

	public boolean isPersonalTakesSectionVisible() {
		Logger.info("Verify if 'Personal takes' section is visible");
		return personalTakes.isVisible();
	}

	public boolean isPersonalTakesIconVisible() {
		Logger.info("Verify if 'Personal takes' icon is visible");
		return personalTakesIcon.isVisible();
	}

	public String getPersonalTakesHrefAttributeValue() {
		Logger.info("Get 'Personal Takes' 'href' attribute value");
		return personalTakes.getAttribute("href");
	}

	public boolean isArticleAuthorImageVisible() {
		Logger.info("Verify if article author image is visible");
		return articleAuthorImage.isVisible();
	}

	public boolean isArticleAuthorNameVisible() {
		Logger.info("Verify if article author name is visible");
		return articleAuthorName.isVisible();
	}

	public String getArticleAuthorNameHrefAttributeValue() {
		Logger.info("Get article author name 'href' attribute value");
		return articleAuthorName.getAttribute("href");
	}

	public boolean isArticleDisclaimerVisible() {
		Logger.info("Verify if article disclaimer is visible");
		articleDisclaimer.scrollToElement();
		return articleDisclaimer.isVisible();
	}

	public boolean isSeeMoreLinkVisibleInDisclaimer() {
		Logger.info("Verify if 'See more' link is visible in article disclaimer");
		return articleDisclaimerSeeMore.isVisible();
	}

	public BlogArticlePage clickSeeMoreLink() {
		Logger.info("Click 'See more' link in article disclaimer");
		articleDisclaimerSeeMore.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isExpandedDisclaimerVisible() {
		Logger.info("Verify if expanded version of article disclaimer is visible");
		return articleDisclaimerExpanded.isVisible();
	}

	public String getShortenedDisclaimerText() {
		Logger.info("Get disclaimer text");
		return articleDisclaimerShortened.getText();
	}
}