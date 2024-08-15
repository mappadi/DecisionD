package everydayhealth.pages.guides;

import everydayhealth.pages.articles.ArticleNewTemplatePage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import everydayhealth.pages.landingpages.MasterLandingPage;
import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GuidesBasePage extends ArticleNewTemplatePage {

	public GuidesBasePage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "guides";
		String CLASS_NAME = "GuidesBasePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject guideArticle;
	protected WebObject guideBranding;
	protected WebObject guideCondition;
	protected WebObject guideNavigationDropdown;
	protected WebObject guideNavigationLinks;
	protected WebObject guideNavigationLinkText;
	protected WebObject nextNavigationBlock;
	protected WebObject previousNavigationBlock;
	protected WebObject nextNavigationArticle;
	protected WebObject previousNavigationArticle;
	protected WebObject nextArrow;
	protected WebObject previousArrow;
	protected WebObject nextNavigationLabel;
	protected WebObject previousNavigationLabel;
	protected WebObject activeArticleNumber;
	protected WebObject socialShareBar;
	protected WebObject socialShareButton;
	protected WebObject facebookShareButton;
	protected WebObject twitterShareButton;
	protected WebObject pinterestShareButton;
	protected WebObject emailShareButton;
	protected WebObject printShareButton;
	protected WebObject sourcesHeader;
	protected WebObject sourcesSection;
	protected WebObject sourcesSectionLinks;
	protected WebObject guidesArticleContent;
	protected WebObject guideNavigationBlock;
	protected WebObject activeGuideNavigationLink;
	protected WebObject relatedNews;
	protected WebObject moreButton;
	protected WebObject publishDate;
	protected WebObject guideButton;

	@Override
	public void waitForPageToLoad() {
		guideArticle.waitUntilVisibleOnPage(this);
	}

	public boolean isGuideArticleVisible() {
		Logger.info("Verify guide article is visible");
		return guideArticle.isVisible();
	}

	public boolean isGuideNavigationBlockVisible() {
		Logger.info("Check if Guides navigation block is visible");
		if (Settings.isMobile() || Settings.isTablet()) {
			guideNavigationDropdown.click();
		}
		return guideNavigationBlock.isVisible();
	}

	public String getActiveLinkText() {
		Logger.info("Get text of active link");
		if (Settings.isMobile() && !guideNavigationBlock.isVisible()) {
			guideNavigationDropdown.click();
		}
		return activeGuideNavigationLink.getText();
	}

	public int getNumberOfRelatedNews() {
		Logger.info("Get number of related news");
		return relatedNews.getVisibleElementsCount();
	}

	public boolean isValidHyperlink(int linkNumber) {
		String hrefValue = relatedNews.getHrefOfElementNumber(linkNumber);
		if (hrefValue.contains("/assessment")) {
			return hrefValue.startsWith("http://");
		}
		return hrefValue.startsWith("https://");
	}

	public void clickMoreButton() {
		Logger.info("Click 'More' button");
		if (Settings.isMobile() && guideNavigationBlock.isVisible()) {
			guideNavigationDropdown.click();
		}
		moreButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfTimestamps() {
		Logger.info("Get number of timestamps");
		return publishDate.getVisibleElementsCount();
	}

	public boolean isGuideBrandingVisible() {
		Logger.info("Verify branding is visible");
		return guideBranding.isVisible();
	}

	public boolean isGuideConditionVisible() {
		Logger.info("Verify condition name is visible");
		return guideCondition.isVisible();
	}

	public void scrollToNextNavigationBlock() {
		Logger.info("Scroll to next navigation block");
		nextNavigationBlock.scrollToElement();
	}

	public boolean isNextNavigationBlockVisible() {
		Logger.info("Verify next navigation block is visible");
		if (Settings.isMobile() && guideNavigationDropdown.isVisible()) {
			guideNavigationDropdown.click();
		}
		return nextNavigationBlock.isVisible();
	}

	public boolean isPreviousNavigationBlockVisible() {
		Logger.info("Verify previous navigation block is visible");
		return previousNavigationBlock.isVisible();
	}

	public boolean isNextNavigationArrowVisible() {
		Logger.info("Verify next arrow is visible");
		return nextArrow.isVisible();
	}

	public boolean isPreviousNavigationArrowVisible() {
		Logger.info("Verify previous arrow is visible");
		return previousArrow.isVisible();
	}

	public boolean isNextNavigationLabelVisible() {
		Logger.info("Verify next navigation label is visible");
		return nextNavigationLabel.isVisible();
	}

	public boolean isPreviousNavigationLabelVisible() {
		Logger.info("Verify previous navigation label is visible");
		return previousNavigationLabel.isVisible();
	}

	public String getNextNavigationArticle() {
		String nextArticleText = nextNavigationArticle.getText();
		Logger.info("Get next navigation article text :" + nextArticleText);
		return nextArticleText;
	}

	public String getPreviousNavigationArticle() {
		String previousArticleText = previousNavigationArticle.getText();
		Logger.info("Get previous navigation article text :" + previousArticleText);
		return previousArticleText;
	}

	public int getActiveArticleNumber() {
		Logger.info("Get active article number");
		String article;
		int activeArticle;
		if (Settings.isDesktop()) {
			article = activeArticleNumber.getText();
			activeArticle = Integer.parseInt(article.substring(0, article.length() - 1));
		} else {
			article = guideNavigationDropdown.getText();
			activeArticle = Integer.parseInt(article.substring(0, article.indexOf(" of")));
		}
		Logger.info("Active article number is :" + activeArticle);
		return activeArticle;
	}

	public int getGuideNavigationLinks() {
		Logger.info("Get guide navigation links count");
		if (!Settings.isDesktop()) {
			if (!guideNavigationLinks.isVisible()) {
				guideNavigationDropdown.click();
				guideNavigationLinks.waitUntilVisible();
			}
			int linkCount = guideNavigationLinks.getElementsCount();
			guideNavigationDropdown.click();
			return linkCount;
		} else {
			return guideNavigationLinks.getElementsCount();
		}
	}

	public int getNumberOfGuideNavigationLinks() {
		Logger.info("Get number of guide navigation links");
		return guideNavigationLinks.getNumberOfVisibleAndClickableElements();
	}

	public boolean isGuideNavigationHrefEmpty(int link) {
		Logger.info("Verify if 'href' attribute is empty for guide navigation link #" + link);
		return guideNavigationLinks.getHrefOfElementNumber(link).isEmpty();
	}

	public String getGuideNavigationArticle(int articleNumber) {
		Logger.info("Get article title of article number :" + articleNumber);
		String articleText;
		if (!Settings.isDesktop()) {
			articleText = guideNavigationLinkText.getAttributeOfElementNumber(articleNumber, "title");
		} else {
			articleText = guideNavigationLinkText.getTextFromElementNumber(articleNumber);
		}
		Logger.info("Article title of article number: " + articleText);
		return articleText;
	}

	public void clickNextNavigation() {
		Logger.info("Click on next navigation");
		nextNavigationBlock.click();
		waitFor(2000);//wait for page load for element not in cache exception
		waitForAjaxRequestToBeFinished();
	}

	public boolean isFirstGuidePage() {
		Logger.info("Verify if current page is first guide article");
		return getActiveArticleNumber() == 1;
	}

	public boolean isLastGuidePage() {
		Logger.info("Verify if current page is last guide article");
		return getActiveArticleNumber() == getGuideNavigationLinks();
	}

	public String getTwitterShareLink() {
		Logger.info("Get 'Twitter' share button link");
		return twitterShareButton.getAttribute("href");
	}

	public String getFacebookShareLink() {
		Logger.info("Get 'Facebook' share button link");
		return facebookShareButton.getAttribute("href");
	}

	public String getPinterestShareLink() {
		Logger.info("Get 'Pinterest' share button link");
		return pinterestShareButton.getAttribute("href");
	}

	public boolean isSocialShareBarVisible() {
		Logger.info("Check if social bar is visible");
		return socialShareBar.isVisible();
	}

	public boolean isFacebookShareButtonVisible() {
		Logger.info("Check if 'Facebook' share button is visible");
		return facebookShareButton.isVisible();
	}

	public boolean isTwitterShareButtonVisible() {
		Logger.info("Check if 'Twitter' share button is visible");
		return twitterShareButton.isVisible();
	}

	public boolean isPinterestShareButtonVisible() {
		Logger.info("Check if 'Pinterest' share button is visible");
		return pinterestShareButton.isVisible();
	}

	public boolean isEmailShareButtonVisible() {
		Logger.info("Check if 'Email' share button is visible");
		return emailShareButton.isVisible();
	}

	public boolean isPrintShareButtonVisible() {
		Logger.info("Check if 'Print' share button is visible");
		return printShareButton.isVisible();
	}

	public void clickFacebookShareButton() {
		Logger.info("Click on 'Facebook' share button");
		facebookShareButton.click();
	}

	public void clickTwitterShareButton() {
		Logger.info("Click on 'Twitter' share button");
		twitterShareButton.actionClick();
	}

	public void clickPinterestShareButton() {
		Logger.info("Click on 'Pinterest' share button");
		pinterestShareButton.actionClick();
	}

	public void clickPrintShareButton() {
		Logger.info("Click on 'Print' share button");
		printShareButton.click();
	}

	public ShareViaEmailPopUp clickEmailShareButton() {
		Logger.info("Click on email share button");
		if (facebookShareButton.isVisible()) {
			articleBodyHover();
		}
		emailShareButton.click();
		return PageFactory.initElements(basedriver, ShareViaEmailPopUp.class);
	}

	public void shareButtonHover() {
		Logger.info("Mouseover on share button");
		socialShareButton.mouseHover();
		waitForAjaxRequestToBeFinished();
	}

	public void articleBodyHover() {
		Logger.info("Mouseover on article to hide share icons");
		guideArticle.mouseHover();
	}

	public boolean isSourcesHeaderVisible() {
		Logger.info("Checking for Sources Header is visible");
		return sourcesHeader.isVisible();
	}

	public boolean isSourcesSectionVisible() {
		Logger.info("Checking the Sources section is visible");
		return sourcesSection.isVisible();
	}

	public int getCountOfSourceSectionLinks() {
		Logger.info("Getting the count of Source section links");
		return sourcesSectionLinks.getElementsCount();
	}

	public String getSourceSectionHref(int elementNumber) {
		String sourceHrefValue = sourcesSectionLinks.getAttributeOfElementNumber(elementNumber, "href");
		Logger.info("Link associated with Link Text " + "'" + sourcesSectionLinks.getTextFromElementNumber(elementNumber) + "'" + " is " + sourceHrefValue);
		return sourceHrefValue;
	}

	public boolean isNewsSectionVisible() {
		Logger.info("Verify guides news section is visible");
		return guidesArticleContent.isVisible();
	}

	public MasterLandingPage clickGuideButton() {
		Logger.info("Click 'Guide' button");
		guideButton.click();
		return PageFactory.initElements(basedriver, MasterLandingPage.class);
	}

	public boolean isGuideButtonVisible() {
		Logger.info("Check if 'Guide' button is visible");
		guideButton.waitUntilVisible();
		return guideButton.isVisible();
	}
}