package everydayhealth.pages.drugs;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * DrugsByClassPage
 */
public class DrugsByClassPage extends DrugsBasePage {

	public DrugsByClassPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "drugs";
		String CLASS_NAME = "DrugsByClassPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject drugsByClassSection;
	protected WebObject drugsByClassDrugTitle;
	protected WebObject drugsByClassListItem;

	@Override
	public void waitForPageToLoad() {
		drugsByClassSection.waitUntilVisibleOnPage(this);
	}

	public boolean isDrugsByClassSectionVisible() {
		Logger.info("Check if 'Drugs by class' section is visible");
		return drugsByClassSection.isVisible();
	}

	public String getDrugsClass() {
		Logger.info("Get drugs class title");
		return drugsByClassDrugTitle.getText().split("-")[1].trim();
	}

	public String getDrugTitleNumber(int drugNumber) {
		return drugsByClassListItem.getTextFromElementNumber(drugNumber);
	}

	public String getDrugURLNumber(int drugNumber) {
		return drugsByClassListItem.getHrefOfElementNumber(drugNumber);
	}

	public int getNumberOfDrugsInDrugsByClassSection() {
		Logger.info("Get number of drugs in 'Drugs by class' section");
		return drugsByClassListItem.getElementsCount();
	}
}
