package everydayhealth.pages.landingpages;

import everydayhealth.pages.conditions.ConditionCenterLandingPage;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * CategoryLandingPage
 */
public class NewsLandingPage extends ConditionCenterLandingPage {

	public NewsLandingPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "landingpages";
		String CLASS_NAME = "NewsLandingPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject descriptionContactUs;
	protected WebObject healthDayWidget;
	protected WebObject healthDayWidgetTitle;
	protected WebObject healthDayWidgetCard;
	protected WebObject healthDayWidgetCardTitle;
	protected WebObject healthDayWidgetCardTypeIcon;
	protected WebObject healthDayWidgetCardByline;
	protected WebObject healthDayWidgetCardTimestamp;
	protected WebObject healthDayWidgetCardImage;
	protected WebObject healthDayWidgetCardDescription;
	protected WebObject contentCardTimestamp;
	protected WebObject contentCardBylineHyperlinked;
	protected WebObject newsletterWidgetPosition;

	public String getContactUsHrefValue() {
		Logger.info("Get 'Contact Us' link 'href' attribute value");
		return descriptionContactUs.getAttribute("href");
	}

	public boolean isContactUsLinkVisibleInDescription() {
		Logger.info("Verify if 'Contact Us' link is visible in description");
		return descriptionContactUs.isVisible();
	}

	public boolean isHealthDayWidgetVisible() {
		Logger.info("Verify if HealthDay Widget is visible");
		healthDayWidget.scrollToElement();
		return healthDayWidget.isVisible();
	}

	public boolean isHealthDayWidgetHealineVisible() {
		Logger.info("Verify if HealthDay Widget headline is visible");
		return healthDayWidgetTitle.isVisible();
	}

	public String getHealthDayWidgetHeadlineText() {
		Logger.info("Get HealthDay Widget headline text");
		return healthDayWidgetTitle.getText();
	}

	public String getHealthDayWidgetHeadlineCssAttribute(String attr) {
		Logger.info("Get '" + attr + "' css attribute value for HealthDay Widget headline");
		return healthDayWidgetTitle.getCssValue(attr);
	}

	public int getNumberOfHealthDayWidgetCards() {
		Logger.info("Get number of HealthDay Widget cards");
		return healthDayWidgetCard.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfHealthDayWidgetCardTitles() {
		Logger.info("Get number of HealthDay Widget card titles");
		return healthDayWidgetCardTitle.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfHealthDayWidgetCardTypeIcons() {
		Logger.info("Get number of HealthDay Widget card type icons");
		return healthDayWidgetCardTypeIcon.getVisibleElementsCount();
	}

	public int getNumberOfHealthDayWidgetCardBylines() {
		Logger.info("Get number of HealthDay Widget card bylines");
		return healthDayWidgetCardByline.getVisibleElementsCount();
	}

	public int getNumberOfHealthDayWidgetCardTimestamps() {
		Logger.info("Get number of HealthDay Widget card timestamps");
		return healthDayWidgetCardTimestamp.getVisibleElementsCount();
	}

	public int getNumberOfHealthDayWidgetCardImages() {
		Logger.info("Get number of HealthDay Widget card images");
		return healthDayWidgetCardImage.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfHealthDayWidgetCardDescriptions() {
		Logger.info("Get number of HealthDay Widget card descriptions");
		return healthDayWidgetCardDescription.getVisibleElementsCount();
	}

	public void scrollToHealthDayWidgetCard(int cardNumber) {
		Logger.info("Scroll to HealthDay Widget card #" + cardNumber + " (lazy load)");
		healthDayWidgetCard.scrollToElementNumber(cardNumber);
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfHyperlinkedBylines() {
		Logger.info("Get number of bylines where author name is hyperlink");
		return contentCardBylineHyperlinked.getNumberOfVisibleAndClickableElements();
	}

	public String getCardTimestamp(int cardNumber) {
		Logger.info("Get content card #" + cardNumber + " timestamp");
		return contentCardTimestamp.getTextFromElementNumber(cardNumber);
	}

	public boolean isNewsletterWidgetInPosition(int position) {
		Logger.info("Verify if newsletter widget is in " + position + "th position");
		return newsletterWidgetPosition.isElementWithTextVisible(String.valueOf(position));
	}
}
