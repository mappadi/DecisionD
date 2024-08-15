package everydayhealth.pages.conditions;

import everydayhealth.pages.articles.ArticleNewTemplatePage;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * CategoryLandingPage
 */
public class CategoryLandingPage extends ArticleNewTemplatePage {

	public CategoryLandingPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "conditionpages";
		String CLASS_NAME = "CategoryLandingPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject headline;
	protected WebObject allArticlesWidget;
	protected WebObject allArticlesWidgetTypes;
	protected WebObject allArticlesWidgetArticlesLink;
	protected WebObject subcategorySectionHeadline;
	protected WebObject subcategorySectionBlocks;
	protected WebObject subcategorySectionBlocksAccordion;
	protected WebObject subcategorySectionBlockTitle;
	protected WebObject subcategorySectionBlockTitleHyperlink;
	protected WebObject subcategorySectionBlockDescription;
	protected WebObject subcategorySectionBlockArticlesListTitle;
	protected WebObject subcategorySectionBlockArticlesListLink;
	protected WebObject subcategorySectionBlockReadAbout;
	protected WebObject subcategorySectionBlockReadAboutTopics;
	protected WebObject newsletterModule;
	protected WebObject promoWidget;
	protected WebObject promoWidgetTitle;
	protected WebObject promoWidgetLearnMoreLink;
	protected WebObject promoWidgetDescription;
	protected WebObject promoWidgetThumbnailImage;

	@Override
	public void waitForPageToLoad() {
		headline.waitUntilVisibleOnPage(this);
	}

	public boolean isHeadlineVisible() {
		Logger.info("Verify if headline is visible");
		return headline.isVisible();
	}

	public String getHeadlineText() {
		Logger.info("Get headline text");
		return headline.getText();
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

	public String getAllArticlesLink() {
		Logger.info("Get 'href' value of 'All Articles' link");
		return allArticlesWidgetArticlesLink.getAttribute("href");
	}

	public boolean isSubcategorySectionHeadlineVisible() {
		Logger.info("Verify if subcategory section headline is visible");
		return subcategorySectionHeadline.isVisible();
	}

	public String getSubcategorySectionHeadlineText() {
		Logger.info("Get text of subcategory section headline");
		return subcategorySectionHeadline.getText();
	}

	public int getNumberOfSubcategorySectionElements() {
		Logger.info("Get number of subcategory section elements");
		return subcategorySectionBlocks.getElementsCount();
	}

	public int getNumberOfSubcategorySectionOpenAccordions() {
		Logger.info("Get number of accordion elements (in open state)");
		return subcategorySectionBlocksAccordion.getElementsCount();
	}

	public String getAccordionState(int elementNumber) {
		Logger.info("Get accordion state value");
		return subcategorySectionBlocksAccordion.getAttributeOfElementNumber(elementNumber, "class");
	}

	public boolean isSectionTitleVisible(int sectionNumber) {
		Logger.info("Verify if subcategory section element title #" + sectionNumber + " is visible");
		return subcategorySectionBlockTitle.isElementWithTextVisible(String.valueOf(sectionNumber));
	}

	public boolean isSectionTitleHyperlinked(int sectionNumber) {
		Logger.info("Verify if subcategory section element title #" + sectionNumber + " is hyperlinked");
		return subcategorySectionBlockTitleHyperlink.isElementWithTextVisible(String.valueOf(sectionNumber));
	}

	public String getSectionTitleHrefValue(int sectionNumber) {
		Logger.info("Get section element title #" + sectionNumber + " 'href' attribute value");
		return subcategorySectionBlockTitleHyperlink.getAttributeOfElementNumberWithText(1, "href", String.valueOf(sectionNumber));
	}

	public boolean isSectionDescriptionVisible(int sectionNumber) {
		Logger.info("Verify if section element #" + sectionNumber + " description is visible");
		return subcategorySectionBlockDescription.isElementWithTextVisible(String.valueOf(sectionNumber));
	}

	public boolean isSectionArticlesListVisible(int sectionNumber) {
		Logger.info("Verify if section element #" + sectionNumber + " 'More in' title is visible");
		return subcategorySectionBlockArticlesListTitle.isElementWithTextVisible(String.valueOf(sectionNumber));
	}

	public int getNumberOfArticlesInList(int sectionNumber) {
		Logger.info("Get number of articles in section #" + sectionNumber + " 'More in'");
		return subcategorySectionBlockArticlesListLink.getElementsWithTextCount(String.valueOf(sectionNumber));
	}

	public String getHrefValueOfArticleInList(int sectionNumber, int articleNumber) {
		Logger.info("Get article link #" + articleNumber + " 'href' attribute value for subcategory section element #" + sectionNumber);
		return subcategorySectionBlockArticlesListLink.getAttributeOfElementNumberWithText(articleNumber, "href", String.valueOf(sectionNumber));
	}

	public boolean isReadAboutVisible(int sectionNumber) {
		Logger.info("Verify if 'Read about' is visible in section #" + sectionNumber);
		return subcategorySectionBlockReadAbout.isElementWithTextVisible(String.valueOf(sectionNumber));
	}

	public String getHrefValueForReadAboutTopic(int sectionNumber, int topicNumber) {
		Logger.info("Get topic #" + topicNumber + " 'href' attribute value in section #" + sectionNumber);
		return subcategorySectionBlockReadAboutTopics.getAttributeOfElementNumberWithText(topicNumber, "href", String.valueOf(sectionNumber));
	}

	public int getNumberOfTopicsInReadAbout(int sectionNumber) {
		Logger.info("Get number of topics in 'Read about' for section #" + sectionNumber);
		return subcategorySectionBlockReadAboutTopics.getElementsWithTextCount(String.valueOf(sectionNumber));
	}

	public boolean isNewsletterPlacedAfterSection(int sectionNumber) {
		Logger.info("Verify if newsletter module is placed after section #" + sectionNumber);
		return newsletterModule.isElementWithTextVisible(String.valueOf(sectionNumber));
	}

	public boolean isPromoWidgetVisible() {
		Logger.info("Verify if promo widget is visible");
		return promoWidget.isVisible();
	}

	public boolean isPromoWidgetTitleVisible() {
		Logger.info("Verify if promo widget title is visible");
		return promoWidgetTitle.isVisible();
	}

	public String getPromoWidgetTitleHref() {
		Logger.info("Get promo widget title 'href' attribute value");
		return promoWidgetTitle.getAttribute("href");
	}

	public boolean isPromoWidgetDescriptionVisible() {
		Logger.info("Verify if promo widget description is visible");
		return promoWidgetDescription.isVisible();
	}

	public boolean isPromoWidgetLearnMoreLinkVisible() {
		Logger.info("Verify if promo widget learn more link is visible");
		return promoWidgetLearnMoreLink.isVisible();
	}

	public String getPromoWidgetLearnMoreLinkHref() {
		Logger.info("Get 'Learn more about %category_name%' link 'href' attribute value");
		return promoWidgetLearnMoreLink.getAttribute("href");
	}

	public boolean isPromoWidgetThumbnailImageVisible() {
		Logger.info("Verify if promo widget thumbnail image is visible");
		return promoWidgetThumbnailImage.isVisible();
	}
}
