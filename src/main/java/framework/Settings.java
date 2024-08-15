package framework;

import framework.adapters.WebDriverManager;
import framework.platform.ConfigProvider;
import framework.platform.Device;
import framework.platform.Environment;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static org.testng.Assert.fail;

public class Settings {
	public static BrowserType browser;
	public static ConfigProvider config;
	private static int retry;

	public Settings() {
		loadSettings();
	}

	private void loadSettings() {
		config = new ConfigProvider();
		browser = BrowserType.browser(config.getBrowser());
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
	}

	public static int getRetryNumber() {
		return retry;
	}

	public static void setRetryNumber(int retryNumber) {
		retry = retryNumber;
	}

	public static void setDefaultImplicityWait() {
		if (browser.equals(BrowserType.IE)) {
			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} else {
			WebDriverManager.getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		}
	}

	public static Device getPlatform() {
		if (isMobile()) {
			return Device.MOBILE;
		}
		if (isDesktop()) {
			return Device.DESKTOP;
		} else {
			return Device.TABLET;
		}
	}

	public String getTestPlan() {
		return config.getTestPlan();
	}

	public String getTestRun() {
		return config.getTestRun();
	}

	public static boolean isMobile() {
		return (browser.equals(BrowserType.MOBILE_CHROME) || browser.equals(BrowserType.MOBILE_SAFARI)) && !isTablet();
	}

	public static boolean isDesktop() {
		return !isMobile() && !isTablet();
	}

	public static Boolean isSauceLabs() {
		return config.isSauceLabs();
	}

	public static boolean isTablet() {
		return config.getDevice().toLowerCase().contains("ipad")
				|| config.getDevice().equalsIgnoreCase("Nexus 7")
				|| config.getDevice().equalsIgnoreCase("Nexus 9");
	}

	public static boolean isNotWebView() {
		return config.getApplicationPath().isEmpty();
	}

	public String getGuiElementsPath() {
		return config.getGuiElementsPath();
	}

	public static RemoteWebDriver createInstance() {
		if (!isDesktop()) { //for debug
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return getDriver(browser);
	}

	public static Boolean isBrowserStack() {
		return config.isBrowserStack();
	}

	private static URL getRemoteURL() {
		try {
			if (isSauceLabs()) {
				return new URL(String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub", config.getSauceUserName(), config.getSauceAccessKey()));
			} else if (isBrowserStack()) {
				return new URL(String.format("http://%s:%s@hub.browserstack.com/wd/hub", config.getBrowserStackUserName(), config.getBrowserStackAccessKey()));
			} else {
				return new URL(String.format("http://%s:%s/wd/hub", config.getGrid(), config.getPort()));
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			fail("There was an error. Please see log");
			return null;
		}
	}

	private static RemoteWebDriver getDriver(BrowserType browserType) {
		DesiredCapabilities capabilities;
		Logger.info("Hub URL: " + getRemoteURL());
		String appPath = config.getApplicationPath();
		switch (browserType) {
			case FIREFOX:
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", false);
				return new RemoteWebDriver(getRemoteURL(), capabilities);
			case FIREFOX_NO_GRID:
				System.setProperty("webdriver.firefox.marionette", ".//target//test-classes//geckodriver.exe");
				FirefoxOptions options2 = new FirefoxOptions();
				options2.setCapability("marionette", true);
				return new RemoteWebDriver(options2);
			case CHROME:
				ChromeOptions options = new ChromeOptions();
				options.addArguments("disable-notifications");
				LoggingPreferences loggingPreferences = new LoggingPreferences();
				if (config.getShowBrowserLog()) {
					loggingPreferences.enable(LogType.BROWSER, Level.INFO);
				}
				if (config.getShowNetworkLog()) {
					loggingPreferences.enable(LogType.PERFORMANCE, Level.ALL);
				}
				options.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);
				return new RemoteWebDriver(getRemoteURL(), options);
			case CHROME_NO_GRID:
				System.setProperty("webdriver.chrome.driver", ".//target//test-classes//chromedriver.exe");
				ChromeOptions optionsNoGrid = new ChromeOptions();
				if (config.getProject().equals("mayoclinicdiet")) {
					optionsNoGrid.addArguments("--allow-running-insecure-content");
				}
				LoggingPreferences loggingPreferencesNoGrid = new LoggingPreferences();
				if (config.getShowBrowserLog()) {
					loggingPreferencesNoGrid.enable(LogType.BROWSER, Level.INFO);
				}
				if (config.getShowNetworkLog()) {
					loggingPreferencesNoGrid.enable(LogType.PERFORMANCE, Level.ALL);
				}
				optionsNoGrid.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferencesNoGrid);
				return new ChromeDriver(optionsNoGrid);
			case SAFARI:
				capabilities = DesiredCapabilities.safari();
				return new RemoteWebDriver(getRemoteURL(), capabilities);
			case IE:
				capabilities = DesiredCapabilities.internetExplorer();
//				capabilities.setCapability("nativeEvents", false);
//				capabilities.setCapability("timeoutInSeconds", 300);
//				//capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//				System.setProperty("webdriver.ie.driver", ".//target//test-classes//IEDriverServer.exe");
//				try {
//					Utils.setFinalStatic(HttpClientFactory.class.getDeclaredField("TIMEOUT_THREE_HOURS"), (int) SECONDS.toMillis(45));
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				return new InternetExplorerDriver(capabilities);
				if (!isEnvironment(Environment.PROD)) {
					capabilities.setCapability("browserstack.local", "true");
				}
				capabilities.setCapability("browserstack.debug", "true");
				capabilities.setCapability("browser", "IE");
				capabilities.setCapability("browser_version", "10.3");
				capabilities.setCapability("os", "Windows");
				capabilities.setCapability("os_version", "10");
				capabilities.setCapability("resolution", "1920x1080");
				return new RemoteWebDriver(getRemoteURL(), capabilities);
			case MOBILE_CHROME:
				capabilities = DesiredCapabilities.android();
				if (appPath.isEmpty()) {
					Logger.info("Run tests in browser");
					capabilities.setCapability("browserName", "chrome");
				} else {
					Logger.info("Run tests in app");
					capabilities.setCapability("app", appPath);
				}
				capabilities.setCapability("newCommandTimeout", 180);
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("deviceName", config.getDevice());
				if (isBrowserStack()) {
					capabilities.setCapability("browserstack.debug", "true");
					capabilities.setCapability("browserName", "android");
					capabilities.setCapability("platform", "ANDROID");
					capabilities.setCapability("device", config.getDevice());
					capabilities.setCapability("project", config.getProject());
					capabilities.setCapability("realMobile", config.isRealMobileDevice());
				}
				return new AndroidDriver(getRemoteURL(), capabilities);
			case MOBILE_SAFARI:
				capabilities = DesiredCapabilities.iphone();
				if (appPath.isEmpty()) {
					Logger.info("Run tests in browser");
					capabilities.setCapability("browserName", "safari");
					capabilities.setCapability("safariIgnoreFraudWarning", true);
				} else {
					Logger.info("Run tests in app");
					capabilities.setCapability("app", appPath);
					capabilities.setCapability("browserName", "");
				}

				if (isBrowserStack()) {
					capabilities.setCapability("browserstack.debug", "true");
					capabilities.setCapability("browserName", "iPhone");
					capabilities.setCapability("platform", "MAC");
					capabilities.setCapability("device", config.getDevice());
					capabilities.setCapability("project", config.getProject());
					capabilities.setCapability("realMobile", config.isRealMobileDevice());
				} else {
					capabilities.setCapability("automationName", "XCUITest");
//					capabilities.setCapability("useNewWDA", "true");
//					capabilities.setCapability("waitForQuiescence", "false");
					capabilities.setCapability("device", "iPhone 7");
					capabilities.setCapability("platformName", "iOS");
					capabilities.setCapability("platformVersion", config.getPlatformVersion());
					capabilities.setCapability("deviceName", config.getDevice());
				}
				capabilities.setCapability("newCommandTimeout", 180);
				capabilities.setCapability("autoAcceptAlerts", true);
				return new IOSDriver(getRemoteURL(), capabilities);
			default:
				throw new UnknownBrowserException("Cannot create driver for unknown browser type");
		}
	}

	public static String getDefaultUrl() {
		return getModifiedUrl("");
	}

	public static String getModifiedUrl(String subDomain) {
		return getConnectionType() + subDomain + getUrl();
	}

	public static String getConnectionType() {
		String connectionType = "http://";
		if (Settings.config.isHttps()) {
			connectionType = "https://";
		}
		return connectionType;
	}


	public static String getUrl() {
		String publicUrl = "";
		switch (config.getEnvironment()) {
			case DEV:
				publicUrl = config.getDevPublicSiteUrl();
				break;
			case QA:
				publicUrl = config.getQaPublicSiteUrl();
				break;
			case STAGE:
				publicUrl = config.getStagePublicSiteUrl();
				break;
			case STAGING1:
				publicUrl = config.getStaging1PublicSiteUrl();
				break;
			case STAGING2:
				publicUrl = config.getStaging2PublicSiteUrl();
				break;
			case STAGING3:
				publicUrl = config.getStaging3PublicSiteUrl();
				break;
			case PREVIEW:
				publicUrl = config.getPreviewPublicSiteUrl();
				break;
			case PROD:
				publicUrl = config.getProdPublicSiteUrl();
				break;
			case LOCAL:
				publicUrl = config.getLocalPublicSiteUrl();
				break;
		}
		return publicUrl;
	}

	public static String getCouchbaseUrl() {
		switch (config.getEnvironment()) {
			case DEV:
				return config.getDevCouchBaseUrl();
			case QA:
				return config.getQaCouchBaseUrl();
			case STAGE:
				return config.getStageCouchBaseUrl();
			case PROD:
				return config.getProdCouchBaseUrl();
			default:
				return "";
		}
	}

	public static boolean isEnvironment(Environment environment) {
		return config.getEnvironment().equals(environment);
	}

	public static boolean isQA() {
		return isEnvironment(Environment.QA);
	}

	public static boolean isPROD() {
		return isEnvironment(Environment.PROD);
	}

	public static boolean isDEV() {
		return isEnvironment(Environment.DEV);
	}

}
