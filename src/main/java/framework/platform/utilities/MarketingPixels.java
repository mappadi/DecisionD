package framework.platform.utilities;

import framework.Logger;
import framework.adapters.WebDriverManager;


/**
 * Marketing pixels
 */
public class MarketingPixels {

	static String pattern1 = "[a-z0-9]{8}-[a-z0-9]{4}-[0-9a-z]{4}-[a-z0-9]{4}-[a-z0-9]{12}";
	static String pattern2 = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
	static String pattern3 = "[0-9]{8}";

	public static boolean isOmnitureEventFired(String eventToVerify) {
		try {
			String console = WebDriverManager.getDriver().executeScript("return s." + eventToVerify, new Object[0]).toString();
			Logger.info("existed value: " + console);
			return !console.isEmpty();
		} catch (NullPointerException e) {
			return false;
		}
	}

	public static boolean isOmnitureEventPresent(String eventToVerify, String expectedValue, String knownIssue) {
		String console = getConsoleValue(eventToVerify);
		Logger.info("existed value: " + console);
		Logger.knownIssue(knownIssue);
		return console.toLowerCase().contains(expectedValue.toLowerCase());
	}

	public static boolean isOmnitureEventPresent(String eventToVerify, String expectedValue) {
		String console = getConsoleValue(eventToVerify);
		if (console.equals("funded-atc")) {
			Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHOPY-1089");
		}
		return console.toLowerCase().contains(expectedValue.toLowerCase());
	}

	public static boolean isOmnitureAlphaNumericValue(String eventToVerify) {
		return getConsoleValue(eventToVerify).matches(pattern1);
	}

	public static boolean isOmniturePublishedDate(String eventToVerify) {
		return getConsoleValue(eventToVerify).matches(pattern2);
	}

	public static boolean isOmnitureNumberIsNumericId(String eventToVerify) {
		return getConsoleValue(eventToVerify).matches(pattern3);
	}

	public static String getValue(String eventToVerify) {
		String console = WebDriverManager.getDriver().executeScript("return s." + eventToVerify, new Object[0]).toString();
		if (console.isEmpty()) {
			Utils.waitFor(3000); //sometimes when page is not totally loaded we can get an empty result list.
			console = WebDriverManager.getDriver().executeScript("return s." + eventToVerify, new Object[0]).toString();
		}
		Logger.info("Event value " + console);
		return console;
	}

	public static String getConsoleValue(String eventToVerify) {
		Logger.info("Verify 'Omniture event', " + eventToVerify + " on page " + WebDriverManager.getDriver().getCurrentUrl());
		return getValue(eventToVerify);
	}

	public static boolean verifyUtpLoaded() {
		Logger.info("Verifying 'utp' returns 'p=37' and 'u='");
		String utp = Utils.getJSResult("return utp");
		return utp.contains("p=37") && utp.contains("u=");
	}

	public static boolean verifyGoogleAnalyticsLoaded() {
		Logger.info("Verifying Google Analytics is loaded");
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHII-6133");
		return Utils.getJSResult("return window.google_onload_fired").equalsIgnoreCase("true");
	}

	public static boolean verifyOptimizelyEnabled() {
		Logger.info("Verifying Optimizely is enabled");
		return Utils.getJSResult("return optimizely.data.state.enabled").equalsIgnoreCase("true");
	}

	public static boolean verifyOptimizelyAccount() {
		Logger.info("Verifying Everyday Health Optimizely Account ID");
		return Utils.getJSResult("return optimizely.getAccountId.call(status)").contentEquals("275071578");
	}

	public static String getEvents() {
		Logger.info("Verify Omniture events are present on page " + WebDriverManager.getDriver().getCurrentUrl());
		String console = WebDriverManager.getDriver().executeScript("return s.events", new Object[0]).toString();
		if (console.isEmpty()) {
			Utils.waitFor(5000); //sometimes when page is not totally loaded we can get an empty result list.
			console = WebDriverManager.getDriver().executeScript("return s.events", new Object[0]).toString();
		}
		Logger.info("Console value is " + console);
		return console;
	}

	public static String getGoogleAnalyticsCustomDimensionValue(String cdValue) {
		/*
			cd1 is equivalent of eVar1 omniture variable. Should contain detailed zone value.
			cd2 is equivalent of eVar3 omniture variable. Should contain TBD.
			cd3 is equivalent of eVar30 omniture variable. Should contain template name.
			cd4 is equivalent of eVar67 omniture variable. Should contain page category.
			cd5 is equivalent of eVar68 omniture variable. Should contain page subcategory.
			cd6 is equivalent of eVar5 omniture variable. Should contain adzone.
			cd7 Should contain page ID.
			cd8 is equivalent of eVar18 omniture variable. Should contain WFM user ID.
			cd10 is equivalent of eVar11 omniture variable. Should contain XID(session) - external tracking campaign code.
			cd12 is equivalent of eVar14 omniture variable. Should contain IID(session) - internal tracking campaign code (e.g. gnav_head_search).
			cd14 is equivalent of eVar39 omniture variable. Should contain feature title (part of page URL)
			cd18 Should contain 'isNews' attribute value (yes/no).
		*/
		Logger.info("Get custom dimension - " + cdValue + " value");
		switch (cdValue) {
			case "cd1":
				return Utils.getJSResult("return window.dataLayer[0].adZone");
			case "cd2":
				return Utils.getJSResult("return window.dataLayer[0].pageSource");
			case "cd3":
				return Utils.getJSResult("return window.dataLayer[0].templateName");
			case "cd4":
				return Utils.getJSResult("return window.dataLayer[0].category");
			case "cd5":
				return Utils.getJSResult("return window.dataLayer[0].subCategory");
			case "cd7":
				return Utils.getJSResult("return window.dataLayer[0].pageId");
			//TODO add code to get WFM user ID - cd8
			case "cd10":
				return Utils.getJSResult("return window.location.search");
			case "cd12":
				return Utils.getJSResult("return window.location.href.slice(window.location.href.indexOf('?') + 1).split('&')");
			case "cd14":
				return Utils.getJSResult("return window.location.pathname");
			case "cd18":
				String cd18Value = Utils.getJSResult("return window.dataLayer[0].isNews");
				Logger.info("cd18 value - " + cd18Value);
				return cd18Value;
			default:
				Logger.info("Incorrect custom dimension value");
				return "";
		}
	}
}
