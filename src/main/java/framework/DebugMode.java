package framework;

import framework.components.BasicPage;
import framework.platform.html.WebObject;
import framework.platform.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Debug Mode Page
 */
public class DebugMode extends BasicPage {

	public DebugMode(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "";
		String CLASS_NAME = "DebugMode";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject debugAdsBlocks;
	protected WebObject debugValue;

	@Override
	public void waitForPageToLoad() {
		Logger.info("Waiting for DebugMode");
		waitForAjaxRequestToBeFinished();
		debugAdsBlocks.waitUntilVisibleOnPage(this);
		waitForAjaxRequestToBeFinished();
	}

	public int getNumberOfDebugAdBlocks() {
		waitFor(2000); //for debug
		int visibleBlocks = debugAdsBlocks.getElementsCount();
		Logger.info("Visible debug blocks : " + visibleBlocks);
		if (Utils.getCurrentURL().contains("/columns/")) {
			Logger.knownIssue("https://everydayhealth.atlassian.net/browse/TR-614");
		}
		return visibleBlocks;
	}

	public void verifyAllDebugUnitsAreEquals(GoogleAdValue googleAdValue, String issueID) {
		Logger.info("Verify All Debug Units Are Equals: " + googleAdValue);
		if (!issueID.isEmpty()) {
			Logger.knownIssue("https://everydayhealth.atlassian.net/browse/" + issueID);
		}
		ArrayList<String> correlators = new ArrayList<String>();
		List<WebElement> correlatorsElements = debugValue.getElements(googleAdValue.getGoogleAdString());

		for (WebElement element : correlatorsElements) {
			String chosenCorrelator = element.getText();
			correlators.add(chosenCorrelator);
			for (String correlator : correlators) {
				assertEquals(correlator, chosenCorrelator, "values are not equal");
			}
		}
	}

	public void verifyAllDebugUnitsAreEquals(GoogleAdValue googleAdValue) {
		verifyAllDebugUnitsAreEquals(googleAdValue, "EHF-4041");
	}

	public void verifyAllDebugUnitsEqualsValue(GoogleAdValue elementValue, String value) {
		Logger.info("Verify All Debug Units '" + elementValue.getGoogleAdString() + "' Are Equals Value: " + value);
		int elementNumber = 1;
		List<WebElement> tagElements = debugValue.getElements(elementValue.getGoogleAdString());
		for (WebElement element : tagElements) {
			assertEquals(element.getText(), value, "values are not equal, element " + elementNumber);
			elementNumber++;
		}
	}

	public void verifyAllDebugUnitsContainValue(GoogleAdValue elementValue, String value1, String value2) {
		Logger.info("Verify All Debug Units contains Value: " + value1 + " OR " + value2 + " for element " + elementValue);
		int elementNumber = 1;
		List<WebElement> tagElements = debugValue.getElements(elementValue.getGoogleAdString());
		for (WebElement element : tagElements) {
			String inviewValue = element.getText();
			assertTrue(inviewValue.contentEquals(value1) || inviewValue.contentEquals(value2), "Debug units does not contain Value: " + value1 + " OR " + value2 + " for " + elementNumber);
			elementNumber++;
		}
	}

	public String getValueOfDebugAd(GoogleAdValue value) {
		String textValue = debugValue.getTextFromElementWithText(value.getGoogleAdString());
		Logger.info("Value " + value + " from Debug Ad is " + textValue);
		return getValueOfDebugAd(value, 1);
	}

	public String getValueOfDebugAd(GoogleAdValue value, int adNumber) {
		String textValue = debugValue.getTextFromElementWithText(value.getGoogleAdString(), adNumber);
		Logger.info("Value " + value + " from Debug Ad Number " + adNumber + " is " + textValue);
		if (Utils.getCurrentURL().contains("/columns/")) {
			Logger.knownIssue("https://everydayhealth.atlassian.net/browse/TR-614");
		}
		return textValue;
	}

	public BasicPage scrollDownUntilNumberOfDebugAdsPresent(int numberOfAds) {
		int scrollFor = 500;
		int scrollForLimit = Settings.isMobile() ? 8000 : 15000;
		if (Utils.getCurrentURL().contains("photogallery") || Utils.getCurrentURL().contains("photo-gallery")) {
			scrollForLimit = 32000;
		}
		while (getNumberOfDebugAdBlocks() < numberOfAds && scrollFor < scrollForLimit) {
			scrollPage(scrollFor);
			waitForAjaxRequestToBeFinished();
			waitFor(500);
			scrollFor = scrollFor + 450;
		}
		return this;
	}

	public int getValueOfAdReplaceTime(String adDiv) {
		String slotReplaceTime = Utils.getJSResult("return window.EH.FASTconfig.slots." + adDiv + ".slotReplaceTime");
		Logger.info("Getting the time in milliseconds for ad refresh on slot: " + adDiv + " : " + slotReplaceTime);
		int adReplaceTime = Integer.parseInt(slotReplaceTime);
		return adReplaceTime;
	}

	public boolean isParameterPresentInBlockNumber(GoogleAdValue value, int blockNumber) {
		Logger.info("Check if parameter " + value.getGoogleAdString() + " present in adBlock");
		String[] pairs = debugAdsBlocks.getTextFromElementNumber(blockNumber).split("\\r?\\n");
		ArrayList<String> listOfParameters = new ArrayList<>();
		for (String parameter : pairs) {
			listOfParameters.add(parameter.split(":")[0]);
		}
		return listOfParameters.contains(value.getGoogleAdString());
	}
}
