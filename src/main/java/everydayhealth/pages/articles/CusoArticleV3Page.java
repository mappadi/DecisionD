package everydayhealth.pages.articles;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * CusoArticleV3Page
 */
public class CusoArticleV3Page extends IGNPlayerPage {

	public CusoArticleV3Page(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "CusoArticleV3Page";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject medicalReview;
	protected WebObject headlineSection;
	protected WebObject promoWidget;

	@Override
	public void waitForPageToLoad() {
		title.waitUntilVisibleOnPage(this);
	}

	public boolean isMedicalReviewVisible() {
		Logger.info("Verify if medical review is visible");
		return medicalReview.isVisible();
	}

	public int getHeadlineBlockYCoordinateValue() {
		Logger.info("Get headlineSection section Y coordinate value");
		return headlineSection.getYCoordinate();
	}

	public boolean isPromoWidgetVisible() {
		Logger.info("Verify Promo widget is visible");
		return promoWidget.isVisible();
	}
}
