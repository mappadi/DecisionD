package everydayhealth.pages.columns;

import everydayhealth.pages.articles.ArticleNewTemplatePage;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * BlogLandingPage
 */
public class BlogLandingPage extends ArticleNewTemplatePage {

	public BlogLandingPage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "columns";
		String CLASS_NAME = "BlogLandingPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject head;
	protected WebObject blogTitle;
	protected WebObject blogDescription;
	protected WebObject aboutAuthorSection;
	protected WebObject aboutAuthorLabel;
	protected WebObject aboutAuthorImage;
	protected WebObject aboutAuthorBioShort;
	protected WebObject aboutAuthorBioReadMore;
	protected WebObject relatedTopicsSection;
	protected WebObject relatedTopicsSectionHeadline;
	protected WebObject morePersonalTakesLink;
	protected WebObject cards;
	protected WebObject cardDatePublished;
	protected WebObject pagination;
	protected WebObject paginationPrevArrow;
	protected WebObject paginationPageData;
	protected WebObject paginationNextArrow;

	@Override
	public void waitForPageToLoad() {
		head.waitUntilVisibleOnPage(this);
	}

	public boolean isRelatedTopicsSectionVisible() {
		Logger.info("Verify if 'Related Topics' section is visible");
		return relatedTopicsSection.isVisible();
	}

	public boolean isRelatedTopicsHeadlineVisible() {
		Logger.info("Verify if 'Related Topics' section headline is visibile");
		return relatedTopicsSectionHeadline.isVisible();
	}

	public boolean isAboutThisAuthorSectionVisible() {
		Logger.info("Verify if 'About this author' section is visible");
		return aboutAuthorSection.isVisible();
	}

	public boolean isAboutThisAuthorLabelVisible() {
		Logger.info("Verify if 'About The Author' label is visible");
		return aboutAuthorLabel.isVisible() && aboutAuthorLabel.getText().equals("About The Author");
	}

	public boolean isAboutThisAuthorImageVisible() {
		Logger.info("Verify if author avatar is visible in 'About this author' section");
		return aboutAuthorImage.isVisible();
	}

	public boolean isAboutThisAuthorInfoVisible() {
		Logger.info("Verify if 'About this author' information is visible (short version)");
		return aboutAuthorBioShort.isVisible();
	}

	public boolean isReadMoreLinkVisibleInAboutThisAuthorSection() {
		Logger.info("Verify if 'read more' link is visible in 'About this author' section");
		return aboutAuthorBioReadMore.isVisible();
	}

	public String getReadMoreLinkHref() {
		Logger.info("Get 'read more' link 'href' attribute value");
		return aboutAuthorBioReadMore.getAttribute("href");
	}

	public boolean isBrowseMorePersonalTakesLinkVisible() {
		Logger.info("Verify if 'Browse More Personal Takes' link is visible");
		return morePersonalTakesLink.isVisible();
	}

	public String getBrowserMorePersonalTakesLinkHrefValue() {
		Logger.info("Get 'Browse More Personal Takes' link 'href' attribute value");
		return morePersonalTakesLink.getAttribute("href");
	}

	public boolean isNewsletterWidgetInPositionNumber(int position) {
		Logger.info("Verify if Newsletter widget is in " + position + "th slot");
		return cards.getAttributeOfElementNumber(position, "class").contains("newsletter");
	}

	public boolean isBlogTitleVisible() {
		Logger.info("Verify if blog title is visible");
		return blogTitle.isVisible();
	}

	public boolean isBlogDescriptionVisible() {
		Logger.info("Verify if blog description is visible");
		return blogDescription.isVisible();
	}

	public boolean isPaginationBlockVisible() {
		Logger.info("Verify if pagination block is visible");
		return pagination.isVisible();
	}

	public boolean isNextPageArrowVisible() {
		Logger.info("Verify if 'Next' page block is visible");
		return paginationNextArrow.isVisible();
	}

	public BlogLandingPage clickNextArrow() {
		Logger.info("Click 'Next' arrow link");
		paginationNextArrow.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isPreviousPageArrowVisible() {
		Logger.info("Verify if 'Previous' page block is visible");
		pagination.scrollToElement();
		return paginationPrevArrow.isVisible();
	}

	public BlogLandingPage clickPreviousArrow() {
		Logger.info("Click 'Previous' arrow link");
		paginationPrevArrow.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public String getPaginationData() {
		Logger.info("Get page number data");
		paginationPageData.waitUntilVisible();
		return paginationPageData.getText();
	}

	public int getNumberOfTimestamps() {
		Logger.info("Get number of timestamps on blog article cards");
		return cardDatePublished.getVisibleElementsCount();
	}
}
