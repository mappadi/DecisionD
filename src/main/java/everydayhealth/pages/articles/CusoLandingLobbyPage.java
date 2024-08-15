package everydayhealth.pages.articles;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

public class CusoLandingLobbyPage extends CustomSolutionsTemplatePage {

	public CusoLandingLobbyPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "CusoLandingLobbyPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject relatedWidgetItemTitle;
	protected WebObject lobbySection;
	protected WebObject relatedWidgetItemImage;
	protected WebObject smallGridTitle;
	protected WebObject smallGridItem;
	protected WebObject smallGridArticlesImageLinks;
	protected WebObject smallGridArticlesTitle;
	protected WebObject gridTables;
	protected WebObject gridItem;
	protected WebObject gridArticlesTitle;
	protected WebObject gridArticlesImage;
	protected WebObject gridArticlesImageLinks;
	protected WebObject smallCarousalTitle;
	protected WebObject smallCarousalArticlesTitle;
	protected WebObject smallCarousalArticlesImage;
	protected WebObject smallCarousalArticlesImageLinks;
	protected WebObject prevSmallCarouselButton;
	protected WebObject nextSmallCarouselButton;
	protected WebObject primaryCarousalArticlesTitle;
	protected WebObject primaryCarousalItems;
	protected WebObject primaryCarousalArticlesImage;
	protected WebObject primaryCarousalArticlesImageLink;
	protected WebObject nextPrimaryCarouselButton;
	protected WebObject prevPrimaryCarouselButton;
	protected WebObject relatedListWidget;
	protected WebObject relatedListHeader;

	@Override
	public void waitForPageToLoad() {
		lobbySection.waitUntilVisibleOnPage(this);
	}

	public void clickNextSmallCarouselButton() {
		Logger.info("Click Next Small Carousel Button");
		nextSmallCarouselButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public void clickPrevSmallCarouselButton() {
		Logger.info("Click Prev Small Carousel Button");
		prevSmallCarouselButton.click();
		waitForAjaxRequestToBeFinished();
	}

	public void clickNextPrimaryCarouselButton() {
		Logger.info("Click Next Primary Carousel Button");
		primaryCarousalArticlesImage.mouseHover();
		nextPrimaryCarouselButton.click();
	}

	public void clickPrevPrimaryCarouselButton() {
		Logger.info("Click Prev Primary Carousel Button");
		primaryCarousalArticlesImage.mouseHover();
		prevPrimaryCarouselButton.click();
	}

	public int getNumberOfGridTables() {
		Logger.info("Get Number Of Grid Tables");
		gridTables.scrollToElement();
		return gridTables.getNumberOfVisibleAndClickableElements();
	}

	public boolean isSmallGridTitlePresent() {
		Logger.info("Verify Small Grid Title Present");
		return !smallGridTitle.getText().isEmpty();
	}

	public boolean isSmallCarouselTitlePresent() {
		Logger.info("Verify Small Carousal Title Present");
		return !smallCarousalTitle.getText().isEmpty();
	}

	public int getNumberOfRelatedWidgetTitles(){
		Logger.info("Get number of titles on Related widget");
		return relatedWidgetItemTitle.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfRelatedWidgetImages(){
		Logger.info("Get number of images on Related widget");
		return relatedWidgetItemImage.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefValueOfRelatedWidgetImageNumber(int elementNumber){
		Logger.info("Get Related widget image #" + elementNumber + " 'href' value");
		return relatedWidgetItemImage.getHrefOfElementNumber(elementNumber);
	}

	public String getHrefValueOfRelatedWidgetTitleNumber(int elementNumber){
		Logger.info("Get Related widget title #" + elementNumber + " 'href' value");
		return relatedWidgetItemTitle.getHrefOfElementNumber(elementNumber);
	}

	public int getNumberOfRelatedWidgetItems() {
		Logger.info("Get number of items in related widget");
		return relatedWidgetItemTitle.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfVisibleSmallGridItems() {
		Logger.info("Get number of visible small grid items");
		return smallGridItem.getVisibleElementsCount();
	}

	public int getNumberOfVisibleSmallGridTitles() {
		Logger.info("Get number of small grid item titles");
		return smallGridArticlesTitle.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfVisibleSmallGridImages() {
		Logger.info("Get number of small grid item images");
		return smallGridArticlesImageLinks.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefValueOfSmallGridTitleNumber(int itemNumber) {
		Logger.info("Get 'href' value of small grid title #" + itemNumber);
		return smallGridArticlesTitle.getHrefOfElementNumber(itemNumber);
	}

	public String getHrefValueOfSmallGridImageNumber(int itemNumber) {
		Logger.info("Get 'href' value of small grid image #" + itemNumber);
		return smallGridArticlesImageLinks.getHrefOfElementNumber(itemNumber);
	}

	public void scrollToSmallGrid() {
		Logger.info("Scrolling to small grid");
		smallGridItem.scrollToElement();
	}

	public int getNumberOfGridImages() {
		Logger.info("Get number of grid images");
		return gridArticlesImage.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefOfGridItemImageNumber(int itemNumber) {
		Logger.info("Get 'href' value of grid image #" + itemNumber);
		return gridArticlesImageLinks.getHrefOfElementNumber(itemNumber);
	}

	public int getNumberOfGridTitles() {
		Logger.info("Get number of grid titles");
		return gridArticlesTitle.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefOfGridItemTitleNumber(int itemNumber) {
		Logger.info("Get 'href' value of grid title #" + itemNumber);
		return gridArticlesTitle.getHrefOfElementNumber(itemNumber);
	}

	public int getNumberOfGridItems() {
		Logger.info("Get total number of grid items");
		return gridItem.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfSmallCarouselTitles() {
		Logger.info("Get number of small carousel titles");
		return smallCarousalArticlesTitle.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefOfSmallCarouselTitleNumber(int itemNumber) {
		Logger.info("Get 'href' value of small carousel title #" + itemNumber);
		return smallCarousalArticlesTitle.getHrefOfElementNumber(itemNumber);
	}

	public int getNumberOfSmallCarouselImages() {
		Logger.info("Get number of small carousel images");
		return smallCarousalArticlesImage.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefOfSmallCarouselImageNumber(int itemNumber) {
		Logger.info("Get 'href' value of small carousel image #" + itemNumber);
		return smallCarousalArticlesImageLinks.getHrefOfElementNumber(itemNumber);
	}

	public int getFirstVisibleSmallCarouselArticleNumber() {
		Logger.info("Getting first visible Small Carousel Article number");
		return smallCarousalArticlesTitle.getFirstVisibleAndClickableElement();
	}

	public int getNumberOfVisibleSmallCarouselArticles() {
		Logger.info("Getting number of visible SmallCarousel Articles");
		return smallCarousalArticlesTitle.getNumberOfVisibleAndClickableElements();
	}

	public String getArticeNameForSmallCarousel(int articleNumber) {
		Logger.info("Get Visible Artice Name For Small Carousel");
		return smallCarousalArticlesTitle.getTextFromElementNumber(articleNumber);
	}

	public boolean isRelatedListWidgetVisible() {
		Logger.info("Verify related list widget is Visible");
		return relatedListWidget.isVisible();
	}

	public int getNumberOfVisibleLargeCarouselImages() {
		Logger.info("Get number of visible large carousel images");
		return primaryCarousalArticlesImage.getVisibleElementsCount();
	}

	public int getNumberOfVisibleLargeCarouselTitles() {
		Logger.info("Get number of visible large carousel titles");
		return primaryCarousalArticlesTitle.getVisibleElementsCount();
	}

	public int getTotalNumberOfLargeCarouselItems() {
		Logger.info("Get total number of large carousel items");
		return primaryCarousalItems.getElementsCount();
	}

	public String getHrefValueOfLargeCarouselImage(int elementNumber) {
		Logger.info("Get 'href' value of large carousel image #" + elementNumber);
		return primaryCarousalArticlesImageLink.getHrefOfElementNumber(elementNumber);
	}

	public String getHrefValueOfLargeCarouselTitle(int elementNumber) {
		Logger.info("Get 'href' value of large carousel title #" + elementNumber);
		return primaryCarousalArticlesTitle.getHrefOfElementNumber(elementNumber);
	}

	public boolean isRelatedListHeaderHrefEmpty() {
		Logger.info("Verify related list header has href");
		return relatedListHeader.getHrefOfElementNumber(1).isEmpty();
	}
}