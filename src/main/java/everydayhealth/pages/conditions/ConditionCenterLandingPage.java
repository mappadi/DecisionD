package everydayhealth.pages.conditions;

import everydayhealth.pages.articles.ArticleNewTemplatePage;
import framework.Logger;
import framework.platform.TemplatesEH;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class ConditionCenterLandingPage extends ArticleNewTemplatePage {

	public ConditionCenterLandingPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "conditionpages";
		String CLASS_NAME = "ConditionCenterLandingPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject landingPageMainImage;
	protected WebObject heroSection;
	protected WebObject guideButton;
	protected WebObject guideHref;
	protected WebObject heroTitle;
	protected WebObject description;
	protected WebObject conditionTopicTag;
	protected WebObject conditionTopicMoreButton;
	protected WebObject conditionTopicLabel;
	protected WebObject contentCardBlock;
	protected WebObject paginationBlock;
	protected WebObject paginationPrevLink;
	protected WebObject paginationNextLink;
	protected WebObject paginationInfo;
	protected WebObject allArticlesWidget;
	protected WebObject allArticlesWidgetTypes;
	protected WebObject allArticlesWidgetArticlesLink;
	protected WebObject newsletterWidgetCard;

	@Override
	public void waitForPageToLoad() {
		heroSection.waitUntilVisibleOnPage(this);
	}

	public String getContentCardBlockClassAttributeValue(int cardNumber) {
		Logger.info("Get content card #" + cardNumber + " 'class' attribute");
		return contentCardBlock.getAttributeOfElementNumber(cardNumber, "class");
	}

	public boolean isContentCardNumberVisible(int cardNumber) {
		Logger.info("Check if content card #" + cardNumber + " is visible");
		return contentCardBlock.isElementNumberVisible(cardNumber);
	}

	public boolean isHeroImageVisible() {
		Logger.info("Verifying the Hero image");
		return landingPageMainImage.isVisible();
	}

	public int getHeroImageHeight() {
		Logger.info("Get hero image height value");
		int heroImageHeight = landingPageMainImage.getElementHeight();
		Logger.info("Height is - " + heroImageHeight);
		return heroImageHeight;
	}

	public boolean isHeroImageGuideButtonContainsGuideHref(TemplatesEH ccrLandingPage) {
		Logger.info("Verifying Guides URL contained in Hero Title/Hero Image/Guides button :" + ccrLandingPage.getTemplateURL());
		return guideHref.getAttribute("href").endsWith("/guide/");
	}

	public boolean isGuideButtonVisible() {
		Logger.info("Verifying Guide button is visible on landing page");
		return guideButton.isVisible();
	}

	public boolean isHeroTitleVisible() {
		Logger.info("Verifying Hero title is visible");
		return heroTitle.isVisible();
	}

	public String getHeadlineText() {
		Logger.info("Get headline title text");
		return heroTitle.getText();
	}

	public String getHeadlineCssAttribute(String attr) {
		Logger.info("Get '" + attr + "' css attribute value for headline");
		return heroTitle.getCssValue(attr);
	}

	public boolean isDescriptionVisible() {
		Logger.info("Verify if description is visible");
		return description.isVisible();
	}

	public String getDescriptionCssAttribute(String attr) {
		Logger.info("Get '" + attr + "' css attribute value for description");
		return description.getCssValue(attr);
	}

	public boolean isConditionTopicMoreButtonVisible() {
		Logger.info("Verifying Condition topic more button is visible");
		return conditionTopicMoreButton.isVisible();
	}

	public int getTopicTagsCount() {
		Logger.info("Getting the count of Condition Topics");
		return conditionTopicTag.getVisibleElementsCount();
	}

	public void clickConditionTopicMoreButton() {
		Logger.info("Clicking the condition topic 'More' button");
		conditionTopicMoreButton.click();
	}

	public String getTagHrefAttributeValue(int conditionTopicNumber) {
		Logger.info("Get topic tag #" + conditionTopicNumber + " 'href' attribute value");
		return conditionTopicTag.getHrefOfElementNumber(conditionTopicNumber);
	}

	public boolean isConditionTopicLabelVisible() {
		Logger.info("Verifying the Condition topic label is present");
		return conditionTopicLabel.isVisible();
	}

	public boolean isPaginationBlockVisible() {
		Logger.info("Verify if pagination block is visible");
		return paginationBlock.isVisible();
	}

	public String getPaginationInfo() {
		Logger.info("Get pagination info");
		paginationBlock.waitUntilVisible();
		return paginationInfo.getText();
	}

	public boolean isPaginationNextLinkVisible() {
		Logger.info("Verify if pagination 'Next' link is visible");
		return paginationNextLink.isVisible();
	}

	public ConditionCenterLandingPage clickPaginationNextLink() {
		Logger.info("Click 'Next' pagination link");
		paginationBlock.scrollIntoView();
		paginationNextLink.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isPaginationPreviousLinkVisible() {
		Logger.info("Verify if pagination 'Previous' link is visible");
		return paginationPrevLink.isVisible();
	}

	public ConditionCenterLandingPage clickPaginationPreviousLink() {
		Logger.info("Click 'Previous' pagination link");
		paginationBlock.scrollIntoView();
		paginationPrevLink.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isAllArticlesWidgetVisible() {
		Logger.info("Verify if All Articles widget is visible");
		return allArticlesWidget.isVisible();
	}

	public boolean isAllArticlesTypesTabVisible() {
		Logger.info("Verify if 'Types' tab is visible in All Articles widget");
		return allArticlesWidgetTypes.isVisible();
	}

	public boolean isAllArticlesLinkVisible() {
		Logger.info("Verify if 'All Articles' tab is visible on widget");
		return allArticlesWidgetArticlesLink.isVisible();
	}

	public String getTypesLink() {
		Logger.info("Get 'href' value of 'Types' link");
		return allArticlesWidgetTypes.getAttribute("href");
	}

	public boolean isNewsletterWidgetPlacedAfterCard(int cardNumber) {
		Logger.info("Verify if newsletter widget is placed after card #" + cardNumber);
		return newsletterWidgetCard.isElementWithTextVisible(String.valueOf(cardNumber));
	}

	public boolean isHeroSectionVisible() {
		Logger.info("Verify if hero section is visible");
		return heroSection.isVisible();
	}
}
