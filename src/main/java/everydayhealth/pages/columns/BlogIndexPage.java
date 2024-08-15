package everydayhealth.pages.columns;

import everydayhealth.pages.BasicPageEH;
import framework.Logger;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;

/**
 * BlogIndexPage
 */

public class BlogIndexPage extends BasicPageEH {


	public BlogIndexPage(WebDriver driver) {
		super(driver);
		String DOMAIN_NAME = "columns";
		String CLASS_NAME = "BlogIndexPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject heroSection;
	protected WebObject heroSectionImage;
	protected WebObject heroSectionHeadline;
	protected WebObject heroSectionDeck;
	protected WebObject sectionDivider;
	protected WebObject section;
	protected WebObject sectionHeading;
	protected WebObject sectionCards;
	protected WebObject sectionFranchiseCards;
	protected WebObject franchiseCardAuthorAvatar;
	protected WebObject franchiseCardAuthorAvatarImage;
	protected WebObject franchiseCardTitle;
	protected WebObject franchiseCardAuthor;
	protected WebObject franchiseCardImageLink;
	protected WebObject franchiseCardImage;
	protected WebObject newsletterWidgetTitle;

	@Override
	public void waitForPageToLoad() {
		heroSection.waitUntilVisibleOnPage(this);
	}

	public boolean isHeroSectionVisible() {
		Logger.info("Verify if hero section is visible");
		return heroSection.isVisible();
	}

	public int getNumberOfSections() {
		Logger.info("Get number of sections on blog index page");
		return section.getVisibleElementsCount();
	}

	public boolean isHeroSectionHeadingVisible() {
		Logger.info("Verify if hero section heading is visible");
		return heroSectionHeadline.isVisible();
	}

	public String getHeroSectionHeadingText() {
		Logger.info("Get hero section heading text (in h1 tag)");
		return heroSectionHeadline.getText();
	}

	public boolean isHeroSectionIconVisible() {
		Logger.info("Verify if hero section icon is visible");
		return heroSectionImage.isVisible();
	}

	public boolean isHeroSectionDeckVisible() {
		Logger.info("Verify if hero section deck is visible (in h3 tag)");
		return heroSectionDeck.isVisible();
	}

	public String getHeroSectionDeckText() {
		Logger.info("Get hero section deck text");
		return heroSectionDeck.getText();
	}

	public int getHeroSectionYCoordinateValue() {
		Logger.info("Get hero section Y coordinate value");
		return heroSection.getYCoordinate();
	}

	public int getLeader1AdYCoordinateValue() {
		Logger.info("Get leader1 ad Y coordinate value");
		return leader1Ad.getYCoordinate();
	}

	public int getNumberOfSectionDividers() {
		Logger.info("Get number of section dividers");
		return sectionDivider.getVisibleElementsCount();
	}

	public String getColorValueForSectionDivider(int dividerNumber) {
		Logger.info("Get color for section divider");
		return Utils.getHexColor(sectionDivider.getCssOfElementNumber(dividerNumber, "border-bottom-color"));
	}

	public int getNumberOfSectionHeadings() {
		Logger.info("Get number of visible section headings");
		return sectionHeading.getVisibleElementsCount();
	}

	public String getSectionHeadingText(int headingNumber) {
		Logger.info("Verify if section heading is visible");
		return sectionHeading.getTextFromElementNumber(headingNumber);
	}

	public boolean isAdBlockPlacedAfterSecondFranchiseCard(int sectionNumber) {
		Logger.info("Verify if ad block is placed after second franchise card in section #" + sectionNumber);
		return sectionCards.getAttributeOfElementNumberWithText(3, "class", String.valueOf(sectionNumber)).contains("ad-content");
	}

	public int getNumberOfFranchiseCardsInSection(int sectionNumber) {
		Logger.info("Get number of franchise cards in section #" + sectionNumber);
		return sectionFranchiseCards.getElementsWithTextCount(String.valueOf(sectionNumber));
	}

	public int getNumberOfAuthorAvatars(int sectionNumber) {
		Logger.info("Get number of avatars in section #" + sectionNumber);
		return franchiseCardAuthorAvatar.getElementsWithTextCount(String.valueOf(sectionNumber));
	}

	public boolean isAvatarImageVisible(int sectionNumber, int avatarNumber) {
		Logger.info("Verify if avatar image #" + avatarNumber + " is visible in section #" + sectionNumber);
		return franchiseCardAuthorAvatarImage.isElementWithTextVisible(String.valueOf(sectionNumber), avatarNumber);
	}

	public boolean isFranchiseCardTitleVisible(int sectionNumber, int cardNumber) {
		Logger.info("Verify if franchise card #" + cardNumber + " title is visible in section #" + sectionNumber);
		return franchiseCardTitle.isElementWithTextVisible(String.valueOf(sectionNumber), cardNumber);
	}

	public String getFranchiseCardTitleText(int sectionNumber, int cardNumber) {
		Logger.info("Get franchise card " + cardNumber + " title text in section #" + sectionNumber);
		return franchiseCardTitle.getTextFromElementWithText(String.valueOf(sectionNumber), cardNumber);
	}

	public String getFranchiseCardTitleHrefValue(int sectionNumber, int cardNumber) {
		Logger.info("Get 'href' value for card #" + cardNumber + " title in section #" + sectionNumber);
		return franchiseCardTitle.getAttributeOfElementNumberWithText(cardNumber, "href", String.valueOf(sectionNumber));
	}

	public boolean isFranchiseCardAuthorNameVisible(int sectionNumber, int cardNumber) {
		Logger.info("Verify if author name is visible on card number #" + cardNumber + " in section #" + sectionNumber);
		return franchiseCardAuthor.isElementWithTextVisible(String.valueOf(sectionNumber), cardNumber);
	}

	public String getFranchiseCardAuthorNameHrefValue(int sectionNumber, int cardNumber) {
		Logger.info("Get 'href' attribute value for author name on card #" + cardNumber + " in section #" + sectionNumber);
		return franchiseCardAuthor.getAttributeOfElementNumberWithText(cardNumber, "href", String.valueOf(sectionNumber));
	}

	public boolean isFranchiseCardImageVisible(int sectionNumber, int cardNumber) {
		Logger.info("Verify if image is visible on card number #" + cardNumber + " in section #" + sectionNumber);
		return franchiseCardImage.isElementWithTextVisible(String.valueOf(sectionNumber), cardNumber);
	}

	public String getFranchiseCardImageHrefValue(int sectionNumber, int cardNumber) {
		Logger.info("Get 'href' attribute value for image on card #" + cardNumber + " in section #" + sectionNumber);
		return franchiseCardImageLink.getAttributeOfElementNumberWithText(cardNumber, "href", String.valueOf(sectionNumber));
	}

	public boolean isNewsletterWidgetTitleVisible() {
		Logger.info("Verify if newsletter widget title is visible");
		return newsletterWidgetTitle.isVisible();
	}

	public void waitUntilWarningMessageDisappears() {
		Logger.info("Wait until warning message disappears");
		newsletterWarningMessage.waitUntilInvisible();
	}

	public boolean isNewsletterWidgetWarningMessageVisible() {
		Logger.info("Verify if warning messag is visible on newsletter widget");
		return newsletterWarningMessage.isVisible();
	}

	public boolean isNewsletterWidgetSuccessMessageVisible() {
		Logger.info("Verify if success message is visible");
		return newsletterWidgetSuccessMessage.isVisible();
	}

	public void waitUntilSuccessMessageAppears() {
		Logger.info("Wait until success message appears");
		newsletterWidgetSuccessMessage.waitUntilVisible();
	}
}
