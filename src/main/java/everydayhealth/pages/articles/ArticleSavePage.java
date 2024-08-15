package everydayhealth.pages.articles;

import org.openqa.selenium.WebDriver;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.platform.html.WebObject;

public class ArticleSavePage extends BasicPageEH {

	public ArticleSavePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "ArticleSavePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	@Override
	public void waitForPageToLoad() {
		savedItemsHeader.waitUntilVisibleOnPage(this);
	}

	protected WebObject editLink;
	protected WebObject savedArticleDeleteButton;
	protected WebObject savedItemsHeader;
	protected WebObject doneLink;
	protected WebObject subcategoryLink;
	protected WebObject breadcrumbLink;

	public void clickEditLink() {
		Logger.info("Click on Edit link");
		editLink.waitUntilClickable();
		editLink.click();
		waitForAjaxRequestToBeFinished();
	}

	public boolean isEditLinkVisible() {
		Logger.info("Checking if Edit link is visible");
		return editLink.isVisible();
	}

	public ArticleSavePage clickDoneLink() {
		Logger.info("Click 'Done' link");
		doneLink.click();
		return this;
	}

	public void clickOnSavedArticleDeleteButton(int elementNumber, String text) {
		Logger.info("Clicking on the Saved article delete button");
		savedArticleDeleteButton.clickOnElementNumberWithText(elementNumber, text);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isSubcategoryVisible() {
		Logger.info("Check if subcategory link is visible");
		return subcategoryLink.isVisible();
	}

	public boolean isArticleTitleVisibleInList(String text) {
		Logger.info("Check if article title link is visible");
		return breadcrumbLink.isElementWithTextVisible(text);
	}
}
