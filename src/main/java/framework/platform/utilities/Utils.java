package framework.platform.utilities;

import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.DatePatterns;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.assertEquals;

/**
 * Utils
 */
public class Utils {

	public static void setFinalStatic(Field field, Object newValue) {
		try {
			field.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

			field.set(null, newValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void captureScreenShot(String fileName) {
		try {
			RemoteWebDriver driver = (RemoteWebDriver) new Augmenter().augment(WebDriverManager.getDriver());
			File scrFile = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(new File("target/surefire-reports/screenshots").getAbsolutePath() + "/" + fileName));
		} catch (Exception screenException) {
			Logger.debug("ScreenShot can not be saved.");
			screenException.printStackTrace();
		}
	}

	public static String getIpAddress(String hostName, int port, SessionId session) {
		String[] hostAndPort = new String[2];
		String errorMsg = "Failed to acquire remote webdriver node and port info. Root cause: ";

		try {
			HttpHost host = new HttpHost(hostName, port);
			HttpClient client = HttpClientBuilder.create().build();
			URL sessionURL = new URL("http://" + hostName + ":" + port + "/grid/api/testsession?session=" + session);
			BasicHttpEntityEnclosingRequest r = new BasicHttpEntityEnclosingRequest("POST", sessionURL.toExternalForm());
			HttpResponse response = client.execute(host, r);
			JSONObject object = extractObject(response);
			URL myURL = new URL(object.getString("proxyId"));
			if ((myURL.getHost() != null) && (myURL.getPort() != -1)) {
				hostAndPort[0] = myURL.getHost();
				hostAndPort[1] = Integer.toString(myURL.getPort());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(errorMsg, e);
		}
		return hostAndPort[0];
	}

	public static String getCurrentURL() {
		return WebDriverManager.getDriver().getCurrentUrl();
	}

	private static JSONObject extractObject(HttpResponse resp) throws IOException, JSONException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(resp.getEntity().getContent()));
		StringBuffer strbuffer = new StringBuffer();
		String line;
		while ((line = reader.readLine()) != null) {
			strbuffer.append(line);
		}
		reader.close();
		JSONObject objToReturn = new JSONObject(strbuffer.toString());
		return objToReturn;
	}

	public static void checkPageOpensWithoutError() {
		Logger.info("Check if advertisement page is opened without error");
		Set<String> windows = WebDriverManager.getDriver()
				.getWindowHandles();
		Logger.info("Number of opened windows is " + windows.size());
		if (windows.size() > 1) {
			WindowUtils.switchToLastOpenedWindow();
		}
		try {
			String url = WebDriverManager.getDriver().getCurrentUrl();
			Logger.info("Current URL is " + url);
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			assertEquals(con.getResponseCode(), 200, "An opened page is broken");
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (windows.size() > 1) {
			WindowUtils.switchToMainWindow();
		}
	}

	public static void executeJS(String jsScript) {
		JavascriptExecutor js = WebDriverManager.getDriver();
		js.executeScript(jsScript);
	}

	public static String getJSResult(String jsScript) {
		JavascriptExecutor js = WebDriverManager.getDriver();
		return js.executeScript(jsScript).toString();
	}

	public static void waitForJS(String js, boolean isBooleanExpected) {
		int sleepTime = 500;
		String value = "";
		JavascriptExecutor jse = (JavascriptExecutor) WebDriverManager.getDriver();
		for (int i = 0; i < 10000 / sleepTime; i++) {
			waitFor(sleepTime / 2);
			try {
				value = jse.executeScript("return " + js).toString();
			} catch (Exception e) {
				Logger.info("Wait for js to execute");
			}
			Logger.debug("js value: " + value);
			if (Boolean.parseBoolean(value) && isBooleanExpected) {
				return;
			} else if (!value.isEmpty() && !isBooleanExpected) {
				return;
			}
			waitFor(500);
		}
		Logger.info("Wait for ajax encountered an error, but trying to continue the test.");
	}

	public static void scrollPage(Integer y) {
		executeJS("scroll(0, " + y.toString() + ");");
		waitFor(1000); //to make sure page will be completely scrolled
	}

	public static boolean isPageSourceContains(String value, String issueID) {
		if (value.length() < 50) {
			Logger.debug("Verify " + value + " value (not) exists on page: " + WebDriverManager.getDriver().getCurrentUrl());
		}
		if (!issueID.isEmpty()) {
			Logger.knownIssue("https://everydayhealth.atlassian.net/browse/" + issueID);
		}
		return WebDriverManager.getDriver().getPageSource().toLowerCase().contains(value.toLowerCase());
	}

	public static boolean isPageSourceContains(String value) {
		return isPageSourceContains(value, "");
	}

	public static boolean isConnectionHTTPS() {
		Logger.debug("Verifying the current url contains: \"https://\"");
		String connection = WebDriverManager.getDriver().getCurrentUrl();
		return connection.contains("https://");
	}

	public static boolean isConnectionHTTP() {
		Logger.info("Verifying the current url contains: \"http://\"");
		String connection = WebDriverManager.getDriver().getCurrentUrl();
		return connection.contains("http://");
	}

	public static boolean currentUrlContains(String urlPart) {
		Logger.info("Verifying the current url contains: " + urlPart);
		String connection = WebDriverManager.getDriver().getCurrentUrl();
		return connection.toLowerCase().contains(urlPart);
	}

	public static boolean currentTitleContains(String titlePart) {
		Logger.info("Verifying the current title contains: " + titlePart);
		String title = WebDriverManager.getDriver().getTitle();
		Logger.debug("Page title: " + title);
		return title.contains(titlePart);
	}

	public static boolean isBlankScreenDisplayed() {
		Logger.info("Check if blank screen is displayed");
		return WebDriverManager.getDriver().getPageSource().contains("<body></body>");
	}

	public static void waitFor(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getHexColor(String rgb) {
		Logger.info("Get hex color code for rgb value");
		int i = Integer.parseInt((rgb.replace("rgba(", "")).replace(")", "").split(",")[0]);
		int j = Integer.parseInt((rgb.replace("rgba(", "")).replace(")", "").split(",")[1].trim());
		int k = Integer.parseInt((rgb.replace("rgba(", "")).replace(")", "").split(",")[2].trim());

		Color c = new Color(i, j, k);
		String hexValue = "#" + Integer.toHexString(c.getRGB() & 0x00ffffff);
		String colour = "";
		if (hexValue.equals("#333333")) {
			colour = "black";
		} else if (hexValue.equals("#999999")) {
			colour = "grey";
		}
		Logger.info("Hex color code for rgb " + rgb + " is " + hexValue + " " + colour);
		return hexValue;
	}

	public static void sendKeysToBrowser(CharSequence... keysToSend) {
		new Actions(WebDriverManager.getDriver()).sendKeys(keysToSend).perform();
	}

	public static int getHttpResponseCode(String URLName) {
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con =
					(HttpURLConnection) new URL(URLName).openConnection();
			con.setRequestMethod("HEAD");
			Logger.info("response code for " + URLName + " is " + con.getResponseCode());
			return con.getResponseCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static void rotateToLandscape() {
		((Rotatable) new Augmenter().augment(WebDriverManager.getDriver())).rotate(ScreenOrientation.LANDSCAPE);
	}

	public static ScreenOrientation getOrientation() {
		return ((Rotatable) new Augmenter().augment(WebDriverManager.getDriver())).getOrientation();
	}

	public static void backToPreviousPage() {
		WebDriverManager.getDriver().navigate().back();
	}

	public static void releasePhoneNumber(String response) {
		/*
		 * To make phone number available for PT registration POST request should be sent to /api/updatemobilenumber/
		 * 1 is added before the number until changes will be done for it to be added automatically
		 */
		if (response.equals("{\"success\":true}")) {
			Logger.info("Phone number now can be used for PT registration");
		} else {
			int tryNumber = 1;
			while (tryNumber <= 7 && !response.equals("{\"success\":true}")) {
				response = updatePhoneNumberViaPOSTRequest();
				tryNumber++;
			}
		}
	}

	public static String updatePhoneNumberViaPOSTRequest() {
		StringBuilder response = new StringBuilder();
		try {
			String urlText = Settings.getDefaultUrl() + "/api/updatemobilenumber/";
			URL url = new URL(urlText);
			Map<String, Object> params = new LinkedHashMap<>();
			params.put("oldNumber", "19292777091");
			params.put("newNumber", "1329" + StringUtils.generateRandomIntInRange(1000000, 9999999));

			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, Object> param : params.entrySet()) {
				if (postData.length() != 0) postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			conn.setDoOutput(true);
			conn.getOutputStream().write(postDataBytes);

			Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

			for (int c; (c = in.read()) >= 0; ) {
				response.append((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response.toString();
	}

	public static void sendPostRequestWithParameters(String keyword, String shortcode) {
		try {
			Logger.info("Sending POST request to API with keyword '" + keyword + "'");
			String urlText = Settings.getDefaultUrl() + "/api/textmessaging/saveresponse/";
			URL url = new URL(urlText);
			Map<String, Object> params = new LinkedHashMap<>();
			params.put("mobileNumber", "9292779467");
			params.put("keyword", keyword);
			params.put("shortcode", shortcode);
			params.put("timestamp", DateUtils.getCurrentDate(DatePatterns.MM_dd_yyyy_HH_mm_ss_PM));

			StringBuilder postData = new StringBuilder();
			for (Map.Entry<String, Object> param : params.entrySet()) {
				if (postData.length() != 0) postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
			byte[] postDataBytes = postData.toString().getBytes("UTF-8");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
			conn.setDoOutput(true);
			conn.getOutputStream().write(postDataBytes);
			Logger.debug("Response code/message: " + conn.getResponseCode() + "/" + conn.getResponseMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
