package everydayhealth.pages.articles;

import framework.Logger;
import framework.platform.html.WebObject;
import framework.platform.utilities.StringUtils;
import org.openqa.selenium.WebDriver;

/**
 * FluMapPage
 */
public class FluMapPage extends ArticleNewTemplatePage {

	public FluMapPage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "FluMapPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject map;
	protected WebObject youMayLikeSection;
	protected WebObject mapLocation;
	protected WebObject chosenLocation;
	protected WebObject fluForecastFlyout;
	protected WebObject zipCodeInput;
	protected WebObject goButton;
	protected WebObject pharmacyLocationsLink;
	protected WebObject returnButton;
	protected WebObject zoomIn;
	protected WebObject zoomOut;
	protected WebObject symptomsLinks;
	protected WebObject youMayLikeLinks;
	protected WebObject scaleValue;
	protected WebObject flyoutCloseButton;
	protected WebObject navigationUnit;

	@Override
	public void waitForPageToLoad() {
		map.waitUntilVisibleOnPage(this);
	}

	public FluMapPage clickRandomLocation() {
		Logger.info("Click on random location on map");
		mapLocation.clickOnElementNumber(StringUtils.generateRandomInt(mapLocation.getElementsCount()));
		fluForecastFlyout.waitUntilVisible();
		return this;
	}

	public String getNavigationUnitTransformAttributeValue() {
		Logger.info("Get navigation unit 'transform' attribute");
		return navigationUnit.getAttribute("transform");
	}

	public boolean isMaximizeIconVisible() {
		Logger.info("Check if 'Maximize' icon visible on map");
		return zoomIn.isVisible();
	}

	public boolean isMinimizeIconVisible() {
		Logger.info("Check if 'Minimize' icon visible on map");
		return zoomOut.isVisible();
	}

	public void clickZoomInButton() {
		Logger.info("Click '+' icon");
		zoomIn.click();
		waitFor(1000); //wait until google map is zoomed in
	}

	public void clickZoomOutButton() {
		Logger.info("Click '-' icon");
		zoomOut.click();
		waitFor(1000); //wait until google map is zoomed out
	}

	public String getScaleValue() {
		Logger.info("Get scale value");
		return scaleValue.getAttribute("transform");
	}

	public void clickFlyoutCloseButton() {
		Logger.info("Close flyout");
		flyoutCloseButton.click();
		waitFor(1000); //wait until google map is zoomed out
	}

	public int getNumberOfYouMayLikeLinks() {
		Logger.info("Get number of links in 'You may like' section");
		return youMayLikeLinks.getNumberOfVisibleAndClickableElements();
	}

	public String getHrefOfYouMayLikeLink(int linkNumber) {
		Logger.info("Get 'href' attribute value of link #" + linkNumber + " in 'You May Like' section");
		String url = youMayLikeLinks.getHrefOfElementNumber(linkNumber);
		Logger.info("URL of link #" + linkNumber + " - " + url);
		return url;
	}

	public int getNumberOfSymptomsLinks() {
		Logger.info("Get number of symptoms links");
		return symptomsLinks.getNumberOfVisibleAndClickableElements();
	}

	public boolean isRelatedLink(int linkNumber) {
		Logger.info("Check is link #" + linkNumber + " is related to 'Flu'");
		return symptomsLinks.getHrefOfElementNumber(linkNumber).contains("flu");
	}

	public boolean isReturnButtonVisible() {
		Logger.info("Check if 'Return to Flu Map' button is visible");
		return returnButton.isVisible();
	}

	public FluMapPage typeZipCode(String zipCode) {
		Logger.info("Type zip code " + zipCode);
		zipCodeInput.type(zipCode);
		return this;
	}

	public boolean isPharmacyLocationsLinkVisible() {
		Logger.info("Check if 'Pharmacy locations' link is visible");
		return pharmacyLocationsLink.isVisible();
	}

	public FluMapPage clickPharmacyLocationsLink() {
		Logger.info("Click 'Pharmacy locations' link");
		pharmacyLocationsLink.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public FluMapPage clickGoButton() {
		Logger.info("Click 'Go' button");
		goButton.click();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isLocationInFocus() {
		Logger.info("Check if chosen location is in focus");
		return chosenLocation.isVisible();
	}

	public boolean isFluForecastFlyoutVisible() {
		Logger.info("Check if flu forecast information is visible");
		return fluForecastFlyout.isVisible();
	}

	public boolean isFluMapVisible() {
		Logger.info("Check if map is visible");
		return map.isVisible();
	}

	public boolean isYouMayLikeSectionVisible() {
		Logger.info("Check if 'You may like' section is visible");
		return youMayLikeSection.isVisible();
	}
}
