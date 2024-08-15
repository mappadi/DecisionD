package framework.platform;

import everydayhealth.pages.BasicPageEH;
import framework.DebugMode;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.MailinatorUtils;
import framework.platform.utilities.Utils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * SiteNavigatorBase
 */
public class SiteNavigatorBase {

	public static void openPage(String url) {
		openPage(url, "");
	}

	public static <T> T openPage(String url, Class<T> expectedPage) {
		openPage(url, "");
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public static void openPage(String url, String subDomain) {
		String environment = Settings.getModifiedUrl(subDomain) + url;
		Logger.info("Environment: " + environment);
		WebDriverManager.getDriver().navigate().to(environment);
		try {
			if (Settings.config.getProject().toLowerCase().equals("everydayhealth")) {
				CookiesManager.setCookieValue(CookieName.QSI_SI_cDdVag8OOLcZ2bX_intercept, "true");
				CookiesManager.setCookieValue(CookieName.QSI_HistorySession, "http://qa1.everydayhealth.com/solutions/ra-management-selector-tool/~1475768621526");
			}
		} catch (Exception ignored) {
			Logger.err("Cookies were not set");
			ignored.printStackTrace();
		}
		if (Settings.isDesktop()) {
			WebDriverManager.getDriver().manage().window().setPosition(new Point(0, 0));
			WebDriverManager.getDriver().manage().window().maximize();
		}
		Settings.setDefaultImplicityWait();
	}

	protected static <T> T goToPage(String page, Class<T> expectedPage) {
		Logger.info("Opening page " + expectedPage.getSimpleName());
		if (page.contains("?")) {
			openPage(page + "&isautomation=true");
		} else {
			openPage(page + "?isautomation=true");
		}
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public static <T> T goToGADebugMode(TemplatesEH url, Class<T> expectedPage) {
		String urlToOpen = Settings.getDefaultUrl() + url.getTemplateURL() + "?isautomation=true";
		if (urlToOpen.contains("?")) {
			if (urlToOpen.contains("#")) {
				WebDriverManager.getDriver().get(urlToOpen.split("#")[0] + "&debugGTM=1");
			} else {
				WebDriverManager.getDriver().get(urlToOpen + "&debugGTM=1");
			}
		} else {
			WebDriverManager.getDriver().get(urlToOpen + "?debugGTM=1");
		}
		if (Settings.isDesktop()) {
			WebDriverManager.getDriver().manage().window().setPosition(new Point(0, 0));
			WebDriverManager.getDriver().manage().window().maximize();
		}
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public static DebugMode goToDebugMode(boolean testAdsMode) {
		Logger.info("Opening debug page");
		String url = WebDriverManager.getDriver().getCurrentUrl();
		if (url.contains("?")) {
			if (url.contains("#")) {
				WebDriverManager.getDriver().get(url.split("#")[0] + "&debugadcode");
			} else {
				WebDriverManager.getDriver().get(url + "&debugadcode");
			}
		}
		if (!WebDriverManager.getDriver().getCurrentUrl().contains("debugadcode")) {
			if (url.contains("#")) {
				WebDriverManager.getDriver().get(url.split("#")[0] + "?debugadcode");
			} else {
				WebDriverManager.getDriver().get(url + "?debugadcode");
			}
		}
		if (testAdsMode) {
			url = WebDriverManager.getDriver().getCurrentUrl();
			if (url.contains("#")) {
				WebDriverManager.getDriver().get(url.split("#")[0] + "&test_ads=logo");
			} else {
				WebDriverManager.getDriver().get(url + "&test_ads=logo");
			}
		}
		return PageFactory.initElements(WebDriverManager.getDriver(), DebugMode.class);
	}

	public static BasicPageEH goToTestAdMode() {
		String url = WebDriverManager.getDriver().getCurrentUrl();
		if (url.contains("#")) {
			WebDriverManager.getDriver().get(url.split("#")[0] + "&test_ads=logo");
		} else {
			WebDriverManager.getDriver().get(url + "?test_ads=logo");
		}
		return PageFactory.initElements(WebDriverManager.getDriver(), BasicPageEH.class);
	}

	public static <T> T openLastMailinatorEmailForUser(String email, Class<T> expectedPage) {
		Utils.waitFor(85000); //We need to wait before letter will appear in mailbox
		MailinatorUtils.openMailinatorLandingPage();
		MailinatorUtils.openMailinatorBoxForEmail(email);
		MailinatorUtils.openLastEmail();
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public static void goToNoAdsMode() {
		Logger.info("Opening the webpage in No Ads mode");
		String url = WebDriverManager.getDriver().getCurrentUrl();
		if (url.toLowerCase().contains("?debugadcode")) {
			WebDriverManager.getDriver().get(url.replace("?debugadcode", "?no_ads"));
		} else {
			WebDriverManager.getDriver().get(url + "&?no_ads");
		}
	}

	public static String sendGetRequest(String url) {
		return sendRequest(new HttpGet(url));
	}

	public static String sendRequest(HttpUriRequest request) {
		Logger.info("Sending request " + request.toString());
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			CloseableHttpResponse response = client.execute(request);
			return new BasicResponseHandler().handleResponse(response);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
