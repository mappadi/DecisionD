package mayoclinicdiet.pages;

import framework.Logger;
import framework.components.BasicPage;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * OrderPage
 */
public class OrderPage extends BasicPage {

	public OrderPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "welcome";
		String CLASS_NAME = "OrderPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject orderDetails;
	protected WebObject cardInformationBlock;
	protected WebObject cardInformationLine;
	protected WebObject shippingInformaitonBlock;
	protected WebObject productDetailsItems;
	protected WebObject productDetailsItemName;
	protected WebObject orderDetailsBlock;
	protected WebObject orderValue;

	@Override
	public void waitForPageToLoad() {
		orderDetails.waitUntilVisibleOnPage(this);
	}

	public boolean isCardInformationVisible() {
		Logger.info("Verify if card information is visible");
		return cardInformationBlock.isVisible();
	}

	public boolean isShippingInformationVisible() {
		Logger.info("Verify if shipping information is visible");
		return shippingInformaitonBlock.isVisible();
	}

	public boolean isProductDetailsBlockVisible() {
		Logger.info("Verify if product details block is visible");
		return productDetailsItems.isVisible();
	}

	public boolean isOrderSummaryVisible() {
		Logger.info("Verify if order summary is visible");
		return orderDetailsBlock.isVisible();
	}

	public String getCardDetailLineNumber(int lineNumber) {
		Logger.info("Get card information from line #" + lineNumber);
		System.out.println(cardInformationLine.getTextFromElementNumber(lineNumber));
		return cardInformationLine.getTextFromElementNumber(lineNumber);
	}

	public String getProductName() {
		Logger.info("Get product name");
		return productDetailsItemName.getText();
	}

	public String getPrice() {
		Logger.info("Get product price");
		return orderValue.getText();
	}
}