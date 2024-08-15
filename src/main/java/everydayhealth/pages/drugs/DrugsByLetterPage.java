package everydayhealth.pages.drugs;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * DrugsByLetterPage
 */
public class DrugsByLetterPage extends DrugsBasePage {

	public DrugsByLetterPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "drugs";
		String CLASS_NAME = "DrugsByLetterPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject drugsByLetterSection;
	protected WebObject drugsByLetterSectionItems;
	protected WebObject classesByLetterSection;
	protected WebObject classesByLetterSectionItems;
	protected WebObject browseDrugsSection;
	protected WebObject browseDrugsSectionLetter;
	protected WebObject browseDrugsSectionLetterLink;

	@Override
	public void waitForPageToLoad() {
		drugsByLetterSection.waitUntilVisibleOnPage(this);
	}

	public boolean isDrugsByLetterSectionVisible() {
		Logger.info("Check if 'Drugs by letter' section is visible");
		return drugsByLetterSection.isVisible();
	}

	public boolean isClassesByLetterSectionVisible() {
		Logger.info("Check if 'Classes by letter' section is visible");
		return classesByLetterSection.isVisible();
	}

	public boolean isBrowseDrugsSectionVisible() {
		Logger.info("Check if 'Browse drugs' section is visible");
		return browseDrugsSection.isVisible();
	}

	public int getNumberOfClassesByLetter() {
		Logger.info("Get number of classes by letter");
		return classesByLetterSectionItems.getNumberOfVisibleAndClickableElements();
	}

	public String getClassUrl(int classNumber) {
		Logger.info("Get class url #" + classNumber);
		return classesByLetterSectionItems.getHrefOfElementNumber(classNumber);
	}

	public String getClassTitle(int classNumber) {
		Logger.info("Get class url title #" + classNumber);
		return classesByLetterSectionItems.getTextFromElementNumber(classNumber);
	}

	public int getNumberOfElementsInBrowseDrugsSection() {
		Logger.info("Get number of elements in 'Browse drugs' section");
		return browseDrugsSectionLetter.getNumberOfVisibleAndClickableElements();
	}

	public int getNumberOfLinksInBrowseDrugsSection() {
		Logger.info("Get number of links in 'Browse drugs' section");
		return browseDrugsSectionLetterLink.getNumberOfVisibleAndClickableElements();
	}

	public String getSymbolFromBrowseDrugsSection(int elementNumber) {
		Logger.info("Get symbol #" + elementNumber);
		return browseDrugsSectionLetterLink.getTextFromElementNumber(elementNumber);
	}

	public String getLinkFromSymbolInBrowseDrugsSection(int elementNumber) {
		Logger.info("Get 'href' attribute of #" + elementNumber);
		return browseDrugsSectionLetterLink.getHrefOfElementNumber(elementNumber);
	}

	public int getNumberOfLinksInDrugsByLetterSection() {
		Logger.info("Get number of links in 'Drugs by letter' section");
		return drugsByLetterSectionItems.getElementsCount();
	}

	public String getDrugTitleFromDrugsByLetterSection(int elementNumber) {
		return drugsByLetterSectionItems.getTextFromElementNumber(elementNumber);
	}

	public String getLinkFromTitleInDrugsByLetterSection(int elementNumber) {
		return drugsByLetterSectionItems.getHrefOfElementNumber(elementNumber);
	}
}
