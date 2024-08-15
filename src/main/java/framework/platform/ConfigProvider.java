package framework.platform;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ConfigProvider
 */
public class ConfigProvider {

	private final Properties properties = new Properties();

	private final String devPublicSiteUrl;
	private final String qaPublicSiteUrl;
	private final String stagePublicSiteUrl;
	private final String staging1PublicSiteUrl;
	private final String staging2PublicSiteUrl;
	private final String staging3PublicSiteUrl;
	private final String previewPublicSiteUrl;
	private final String prodPublicSiteUrl;
	private final String localPublicSiteUrl;
	private final String grid;
	private final String port;
	private final String platformVersion;
	private final String device;
	private final String browser;
	private final String guiElementsPath;
	private final String environment;
	private final String project;
	private final String testRun;
	private final String testPlan;
	private final String mailinatorLink;
	private final String samLink;
	private final String adminEmail;
	private final String adminPassword;
	private final String isSauceLabs;
	private final String sauceUserName;
	private final String sauceAccessKey;
	private final String defaultUserPassword;
	private final String mainUser;
	private final String adsUser;
	private final String ptUser;
	private final String ptUserPassword;
	private final String appiumUrl;
	private final String appPath;
	private final String browserStackUserName;
	private final String browserStackAccessKey;
	private final String isBrowserStack;
	private final String isRealMobileDevice;
	private final String threadsCount;
	private final String txtPath;
	private final String testLink;
	private final String isWordPress;
	private final String devCouchBaseUrl;
	private final String qaCouchBaseUrl;
	private final String stageCouchBaseUrl;
	private final String prodCouchBaseUrl;
	private final String mailinatorBox;
	private final String mailBoxPassword;
	private final String rerun;
	private final String reason;
	private final String qa2PublicSiteUrl;
	private final String linksList;
	private final String showNetworkLog;
	private final String showBrowserLog;
	private final String trafficIdentifier;
	private final String isHttps;

	public ConfigProvider() {
		try (InputStream propertyStream = ConfigProvider.class.getResourceAsStream("/selenium.properties")) {
			properties.load(propertyStream);
		} catch (IOException e) {
			throw new RuntimeException("An error occurred while loading selenium.properties", e);
		}
		devPublicSiteUrl = getConfigParameter("dev.public.site.url");
		qaPublicSiteUrl = getConfigParameter("qa.public.site.url");
		qa2PublicSiteUrl = getConfigParameter("qa2.public.site.url", "");
		stagePublicSiteUrl = getConfigParameter("stage.public.site.url");
		staging1PublicSiteUrl = getConfigParameter("staging1.public.site.url");
		staging2PublicSiteUrl = getConfigParameter("staging2.public.site.url");
		staging3PublicSiteUrl = getConfigParameter("staging3.public.site.url");
		previewPublicSiteUrl = getConfigParameter("preview.public.site.url", "");
		prodPublicSiteUrl = getConfigParameter("prod.public.site.url");
		localPublicSiteUrl = getConfigParameter("local.public.site.url", "localhost");
		devCouchBaseUrl = getConfigParameter("dev.couchbase.url", "");
		qaCouchBaseUrl = getConfigParameter("qa.couchbase.url", "");
		stageCouchBaseUrl = getConfigParameter("stage.couchbase.url", "");
		prodCouchBaseUrl = getConfigParameter("prod.couchbase.url", "");
		grid = getConfigParameter("selenium.grid", "172.27.51.48");
		appiumUrl = getConfigParameter("appium.url", "http://localhost:4723/wd/hub");
		port = getConfigParameter("selenium.grid.port", "4444");
		platformVersion = getConfigParameter("platform.version", "10.3");
		device = getConfigParameter("device", "iPhone 7");
		testPlan = getConfigParameter("testrail.test.plan", "0");
		testRun = getConfigParameter("testrail.test.run", "0");
		project = getConfigParameter("project");
		environment = getConfigParameter("environment", "qa");
		browser = getConfigParameter("selenium.browser");
		adminEmail = getConfigParameter("eh.admin.email");
		mainUser = getConfigParameter("main.user", "User");
		adsUser = getConfigParameter("ads.user", "AdsUser");
		ptUser = getConfigParameter("pt.user", "");
		ptUserPassword = getConfigParameter("pt.user.password", "");
		defaultUserPassword = getConfigParameter("user.password", "Testpassword1");
		mailinatorLink = getConfigParameter("mailinator.link", "");
		samLink = getConfigParameter("sam.link", "");
		adminPassword = getConfigParameter("eh.admin.password", "");
		guiElementsPath = getConfigParameter("gui.elements.location", "src/test/resources/" + project);
		isSauceLabs = getConfigParameter("sauce.labs", "false");
		sauceUserName = getConfigParameter("sauce.labs.user", "tsheehan");
		sauceAccessKey = getConfigParameter("sauce.labs.key", "63b973cc-dfe4-4819-a2ac-ddeaa3091732");
		linksList = getConfigParameter("linksList", "");
		showNetworkLog = getConfigParameter("show.network.log", "false");
		showBrowserLog = getConfigParameter("show.browser.log", "false");
		appPath = getConfigParameter("app.path", "");
		isBrowserStack = getConfigParameter("browser.stack", "false");
		isRealMobileDevice = getConfigParameter("realMobile", "false");
		browserStackUserName = getConfigParameter("browser.stack.user", "ehqa1");
		browserStackAccessKey = getConfigParameter("browser.stack.key", "5zzszSwBEqhzA4d1e8Ly");
		threadsCount = getConfigParameter("thread.count", "1");
		txtPath = getConfigParameter("txt.path", "");
		testLink = getConfigParameter("test.link", "");
		isWordPress = getConfigParameter("wordpress", "true");
		mailinatorBox = getConfigParameter("mailinator", "testuserEHStasy@mailinator.com");
		mailBoxPassword = getConfigParameter("mailbox.pass", "qwerty123qwerty");
		rerun = getConfigParameter("rerun", "false");
		reason = getConfigParameter("reason", "Cron job nightly run");
		trafficIdentifier = getConfigParameter("traffic", "default");
		isHttps = getConfigParameter("https", "true");
	}

	public boolean needRerun() {
		return Boolean.parseBoolean(rerun);
	}

	public String getMailBox() {
		return mailinatorBox;
	}

	public String getReason() {
		if (reason.isEmpty()) {
			return "Cron job nightly run";
		} else {
			return reason;
		}
	}

	public boolean isHttps() {
		return Boolean.parseBoolean(isHttps);
	}

	public String getTrafficIdentifier() {
		return trafficIdentifier;
	}

	public String getMailBoxPassword() {
		return mailBoxPassword;
	}

	public String getTxtPath() {
		return txtPath;
	}

	public String getDevCouchBaseUrl() {
		return devCouchBaseUrl;
	}

	public String getQaCouchBaseUrl() {
		return qaCouchBaseUrl;
	}

	public String getStageCouchBaseUrl() {
		return stageCouchBaseUrl;
	}

	public String getProdCouchBaseUrl() {
		return prodCouchBaseUrl;
	}

	public String getBrowserStackUserName() {
		return browserStackUserName;
	}

	public String getBrowserStackAccessKey() {
		return browserStackAccessKey;
	}

	public String getLinksList() {
		return linksList;
	}

	public boolean getShowNetworkLog() {
		return Boolean.parseBoolean(showNetworkLog);
	}

	public boolean getShowBrowserLog() {
		return Boolean.parseBoolean(showBrowserLog);
	}

	public boolean isBrowserStack() {
		return Boolean.parseBoolean(isBrowserStack);
	}

	public boolean isRealMobileDevice() {
		return Boolean.parseBoolean(isRealMobileDevice);
	}

	public boolean isWordPress() {
		return Boolean.parseBoolean(isWordPress);
	}

	public String getApplicationPath() {
		return appPath;
	}

	public String getSauceUserName() {
		return sauceUserName;
	}

	public String getAppiumUrl() {
		return appiumUrl;
	}

	public String getMainUserName() {
		return mainUser;
	}

	public String getAdsUserName() {
		return adsUser;
	}

	public String getPtUserName() {
		return ptUser;
	}

	public String getPtUserPassword() {
		return ptUserPassword;
	}

	public String getSauceAccessKey() {
		return sauceAccessKey;
	}

	public boolean isSauceLabs() {
		return Boolean.parseBoolean(isSauceLabs);
	}

	public String getDefaultUserPassword() {
		return defaultUserPassword;
	}

	public String getQaPublicSiteUrl() {
		return qaPublicSiteUrl;
	}

	public String getQa2PublicSiteUrl() {
		return qa2PublicSiteUrl;
	}

	public String getStagePublicSiteUrl() {
		return stagePublicSiteUrl;
	}

	public String getStaging1PublicSiteUrl() {
		return staging1PublicSiteUrl;
	}

	public String getStaging2PublicSiteUrl() {
		return staging2PublicSiteUrl;
	}

	public String getStaging3PublicSiteUrl() {
		return staging3PublicSiteUrl;
	}

	public String getPreviewPublicSiteUrl() {
		return previewPublicSiteUrl;
	}

	public String getDevPublicSiteUrl() {
		return devPublicSiteUrl;
	}

	public String getProdPublicSiteUrl() {
		return prodPublicSiteUrl;
	}

	public String getLocalPublicSiteUrl() {
		return localPublicSiteUrl;
	}

	public String getBrowser() {
		return browser;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	private String getConfigParameter(String key) {
		return getConfigParameter(key, null);
	}

	private String getConfigParameter(String key, String defaultValue) {
		String value = System.getProperty(key);
		if (value == null) {
			if (properties.getProperty(key) != null) {
				return properties.getProperty(key);
			} else if (defaultValue != null) {
				return defaultValue;
			}
			throw new RuntimeException("Configuration value not found for key '" + key + "'");
		}
		return value;
	}

	public String getTestRun() {
		return testRun;
	}

	public String getProject() {
		return project;
	}

	public String getTestPlan() {
		return testPlan;
	}

	public String getGuiElementsPath() {
		return guiElementsPath;
	}

	public Environment getEnvironment() {
		return Environment.valueOf(environment.toUpperCase());
	}

	public String getGrid() {
		return grid;
	}

	public String getPort() {
		return port;
	}

	public String getPlatformVersion() {
		return platformVersion;
	}

	public String getDevice() {
		return device;
	}

	public String getMailinatorLink() {
		return mailinatorLink;
	}

	public String getSamLink() {
		return samLink;
	}

	public String getThreadsCount() {
		return threadsCount;
	}
}
