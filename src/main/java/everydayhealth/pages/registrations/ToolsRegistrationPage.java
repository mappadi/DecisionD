package everydayhealth.pages.registrations;

import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.PublicHeaderEH;
import framework.Logger;
import framework.platform.UserEH;
import framework.platform.html.WebObject;
import framework.platform.utilities.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ToolsRegistrationPage extends BasicPageEH {

	public ToolsRegistrationPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "registrations";
		String CLASS_NAME = "ToolsRegistrationPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject introContent;
	protected WebObject genderRadio;
	protected WebObject weightCurrent;
	protected WebObject weightGoal;
	protected WebObject heightFt;
	protected WebObject heightIn;
	protected WebObject email;
	protected WebObject submitButton;
	protected WebObject tips;
	protected WebObject features;
	protected WebObject featuresImage; //desktop & tablet only

	@Override
	public void waitForPageToLoad() {
		waitForAjaxRequestToBeFinished();
		introContent.waitUntilVisibleOnPage(this);
	}

	public PublicHeaderEH onHeader() {
		return new PublicHeaderEH(basedriver, "ToolsHeader");
	}

	public boolean isSubmitButtonVisible() {
		Logger.info("Verifying the form 'submit' button is visible on the 'tools' registration page");
		return submitButton.isVisible();
	}

	public boolean isIntroContentVisible() {
		Logger.info("Verifying the registration intro content is visible");
		return introContent.isVisible();
	}

	public int getNumberOfTips() {
		Logger.info("Getting the number of visible tips");
		return tips.getVisibleElementsCount();
	}

	public boolean areFeaturesVisible() {
		Logger.info("Verifying the features section is visible");
		return features.isVisible();
	}

	public boolean isFeatureImageVisible() {
		Logger.info("Verifying the feature section image is visible");
		features.scrollToElement();
		return featuresImage.isVisible();
	}

	public void selectGender() {
		Logger.info("Clicking on gender radio button");
		int selection = StringUtils.generateRandomInt(1);
		genderRadio.clickOnElementNumber(selection);
	}

	public void setCurrentWeight(String weightC) {
		Logger.info("Setting current weight field");
		weightCurrent.type(weightC);
	}

	public void setGoalWeight(String weightG) {
		Logger.info("Setting goal weight field");
		weightGoal.type(weightG);
	}

	public void setHeightFt() {
		Logger.info("Setting the user's height 'feet'");
		heightFt.selectByText("05");
	}

	public void setHeightIn() {
		Logger.info("Setting the user's height 'inches'");
		heightIn.selectByText("08");
	}

	public void setEmail(String value) {
		Logger.info("Entering new user's email");
		email.type(value);
	}

	public void clickSubmit() {
		Logger.info("Clicking the 'start now' button");
		submitButton.click();
	}

	public MainRegistrationStepOne completeToolsRegistration(UserEH newUser, String weightC, String weightG, String newUserEmail) {
		Logger.info("Completing the tools registration page");
		selectGender();
		setCurrentWeight(weightC);
		setGoalWeight(weightG);
		setHeightFt();
		setHeightIn();
		setEmail(newUserEmail);
		clickSubmit();
		return PageFactory.initElements(basedriver, MainRegistrationStepOne.class);
	}

}
