package framework.platform.utilities;

import framework.Logger;
import framework.adapters.WebDriverManager;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * GAUtils
 */
public class GAUtils {

	public static Map<String, Map<String, String>> eventValues = new LinkedHashMap<>();

	public static Map<String, Map<String, String>> getConsoleOutput() {
		Utils.waitFor(1500);
		LogEntries logEntries = WebDriverManager.getDriver().manage().logs().get(LogType.BROWSER);
		List<LogEntry> all = logEntries.getAll();
		for (int i = 0; i < all.size() - 1; i++) {
			String logMessage = all.get(i).getMessage();
			if (logMessage.contains("google-analytics.com") &&
					logMessage.contains("Sent beacon")) {
				String eventName;
				String eventBeacon = logMessage.split("&t=")[1];
				String eventType = eventBeacon.split("&")[0];
				if (eventType.equalsIgnoreCase("pageview")) {
					Logger.info("Page load event - pageview");
					eventName = "pageview"; //page load event
				} else {
					//other events
					String eventCategory = eventBeacon.split("&ec=")[1];
					eventName = eventCategory.substring(0, eventCategory.indexOf("&"));
					String eventAction = eventBeacon.split("&ea=")[1];
					String action = eventAction.substring(0, eventAction.indexOf("&"));
					eventName = eventName + " " + action;
					if (eventName.contains("%20")) {
						eventName = eventName.replaceAll("%20", " ");
					}
					if (eventName.contains("%25")) {
						eventName = eventName.replaceAll("%25", "%");
					}
					if (eventName.equals("content item display")) {
						String eventLabel = eventBeacon.split("&el=")[1];
						String label = eventLabel.substring(0, eventLabel.indexOf("&"));
						eventName = eventName + " " + label;
					}
					Logger.info("Event on page - " + eventName);
				}
				eventValues.put(eventName, parseEventParameters(all.subList(i + 1, all.size() - 1)));
			}
		}
		return eventValues;
	}

	private static Map<String, String> parseEventParameters(List<LogEntry> list) {
		Map<String, String> dimensions = new HashMap<>();
		for (LogEntry entry : list) {
			String message = entry.getMessage();
			if (message.contains("google-analytics")) {
				Logger.debug(message);
				if (message.contains("Sent beacon") ||
						message.contains("Creating new tracker") ||
						message.contains("Expected a string value") ||
						message.contains("Setting throttling")) {
					break;
				} else {
					String dimension = message.substring(message.indexOf("\"") + 1, message.indexOf("(") - 1).trim();
					String value = message.substring(message.lastIndexOf(")") + 1, message.lastIndexOf("\"")).trim();
					dimensions.put(dimension, value);
				}
			}
		}
		return dimensions;
	}

	public static String getEventParameter(Map<String, String> cdValues, String event) {
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHF-4268");
		return cdValues.get(event);
	}
}

