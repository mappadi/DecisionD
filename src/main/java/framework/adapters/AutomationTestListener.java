package framework.adapters;

import com.testrail.framework.TestInfo;
import com.testrail.framework.platform.annotations.TestRail;
import com.testrail.framework.rest.TestRailApi;
import framework.Logger;
import framework.Settings;
import framework.SoftAssertion;
import framework.platform.DatePatterns;
import framework.platform.Device;
import framework.platform.utilities.Utils;
import org.apache.commons.io.FileUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.joda.time.DateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.TestListenerAdapter;
import org.testng.xml.XmlSuite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class AutomationTestListener extends TestListenerAdapter implements IReporter, ISuiteListener {

	private static final String HTML_CAPTURE_PATH = "target/surefire-reports/failed/html";
	Settings settings = new Settings();
	private String screenFilePath;
	private String htmlFilePath;
	private Map ticket = new HashMap<String, String>();
	DateTime dateTime = new DateTime();
	private int knownIssueNumber = 0;

	@Override
	public void onTestSkipped(ITestResult tr) {
		if (Settings.config.needRerun() && Settings.getRetryNumber() == 0) {
			Logger.debug("Try #1");
			Logger.debug("First try for test - " + tr.getMethod() + " failed.");
			screenFilePath = new File("target/surefire-reports/failedFirstTime").getAbsolutePath() + "/";
			String screenshotPath = screenFilePath + getScreenshotFilename(tr);
			captureDefaultScreenShot(screenshotPath);
			tr.setStatus(ITestResult.FAILURE);
			tr.getTestContext().getFailedTests().addResult(tr, tr.getMethod());
			Settings.setRetryNumber(1);
			WebDriverManager.getDriver().quit();
		} else {
			tr.setStatus(ITestResult.SKIP);
		}
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		assertEquals(suites.size(), 1, "Multiple test suites are not supported");
		assertEquals(suites.get(0).getResults().size(), 1, "Multiple test results per suite are not supported");
		ITestContext testContext = suites.get(0).getResults().values().iterator().next().getTestContext();

		initVelocity();
		VelocityContext velocityContext = createVelocityContext(testContext);
		saveReport(velocityContext, new File(new File(outputDirectory), "custom-report.html"));
	}

	private void initVelocity() {
		Velocity.setProperty("resource.loader", "classpath");
		Velocity.setProperty("classpath.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		Velocity.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
		Velocity.setProperty("runtime.log.logsystem.log4j.logger", "velocity");
		Velocity.init();
	}

	private void saveReport(VelocityContext context, File outputFile) {
		Writer writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(outputFile));
			Velocity.mergeTemplate("report.html", "UTF-8", context, writer);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private Collection<TestInfosList> createTestInfos(Set<ITestResult> tests) {
		Map<String, TestInfosList> testInfosMap = new HashMap<String, TestInfosList>();

		for (ITestResult test : tests) {
			TestInfo testInfo = createTestInfo(test);
			if (testInfosMap.containsKey(test.getTestClass().getName())) {
				TestInfosList temp = testInfosMap.get(test.getTestClass().getName());
				temp.getTestInfos().add(testInfo);
			} else {
				TestInfosList temp = new TestInfosList(test.getTestClass().getName());
				temp.getTestInfos().add(testInfo);
				testInfosMap.put(temp.getClassName(), temp);
			}
		}
		return testInfosMap.values();
	}

	private TestInfo createTestInfo(ITestResult test) {
		TestRail attribute = null;
		try {
			attribute = AutomationTestListener.class
					.getClassLoader()
					.loadClass(test.getInstanceName())
					.getDeclaredMethod(test.getName())
					.getDeclaredAnnotation(TestRail.class);
		} catch (NoSuchMethodException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		TestInfo testInfo = new TestInfo();
		testInfo.setName(getMethodName(test));
		try {
			testInfo.setTicket(ticket.get(test.getMethod().getMethodName()).toString());
		} catch (NullPointerException ignored) {
			Logger.debug("No ticket for test " + test.getMethod().getMethodName());
		}
		testInfo.setDuration(String.format("%.3f", (test.getEndMillis() - test.getStartMillis()) / 1000.0));
		try {
			testInfo.parseDescription(test.getMethod().getMethodName() + " " + attribute.id());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		if (test.getThrowable() != null) {
			StringWriter writer = new StringWriter();
			test.getThrowable().printStackTrace(new PrintWriter(writer));
			testInfo.setStackTrace(writer.toString().replace("<", "[").replace(">", "]"));
			String buildURL = System.getenv("BUILD_URL");
			if (buildURL == null) {
				testInfo.setScreenshotUrl("file:///" + screenFilePath + getScreenshotFilename(test));
				testInfo.setHTMLUrl("file:///" + htmlFilePath + getMethodName(test) + ".html");
				testInfo.setCaseCommnet("Test failed");
			} else {
				testInfo.setScreenshotUrl(buildURL
						+ "../ws/target/surefire-reports/failed/"
						+ getScreenshotFilename(test));
				testInfo.setHTMLUrl(buildURL
						+ "../ws/target/surefire-reports/failed/html/"
						+ getMethodName(test)
						+ ".html");
				testInfo.setCaseCommnet("See Details: " + buildURL
						+ "../ws/target/surefire-reports/custom-report.html");
			}
		}
		testInfo.setLog(Logger.getTestInfoLogsList(test));
		return testInfo;
	}

	private static String getMethodName(ITestResult result) {
		String className = result.getTestClass().getName();
		return className.substring(className.lastIndexOf('.') + 1) + "." + result.getName();
	}

	private VelocityContext createVelocityContext(ITestContext testContext) {
		Set<ITestResult> failed = testContext.getFailedTests().getAllResults();
		for (ITestResult temp : failed) {
			ITestNGMethod method = temp.getMethod();
			if (testContext.getFailedTests().getResults(method).size() > 1) {
				failed.remove(temp);
			} else {
				if (testContext.getPassedTests().getResults(method).size() > 0) {
					failed.remove(temp);
				}
			}
		}

		Map<String, Object> templateParams = new HashMap<String, Object>();
		templateParams.put("timeStart", dateTime.toString(DatePatterns.MM_dd_yyyy_HH_mm.getPattern(), Locale.US));
		templateParams.put("testGroups", testContext.getIncludedGroups());
		templateParams.put("project", Settings.config.getProject());
		templateParams.put("environment", Settings.config.getEnvironment().toString());
		if (Settings.getPlatform().equals(Device.DESKTOP)) {
			templateParams.put("platformVersion", "");
		} else {
			templateParams.put("platformVersion", Settings.config.getPlatformVersion());
		}
		templateParams.put("reason", Settings.config.getReason());
		templateParams.put("platform", Settings.getPlatform().toString());
		templateParams.put("browser", Settings.browser.toString());
		templateParams.put("testPlan", Settings.config.getTestPlan());
		templateParams.put("testRun", Settings.config.getTestRun());
		templateParams.put("saucelabs", Settings.config.isSauceLabs());
		templateParams.put("numberOfFailed", testContext.getFailedTests());
		templateParams.put("numberOfSuccess", testContext.getPassedTests());
		templateParams.put("numberOfSkipped", testContext.getSkippedTests());
		templateParams.put("numberOfKnownIssue", getKnownIssueNumber());
		templateParams.put("numberOfOtherFailed", testContext.getFailedTests().size() - getKnownIssueNumber());
		templateParams.put("numberOfTests", testContext.getSkippedTests().size() + testContext.getFailedTests().size() + testContext.getPassedTests().size());
		templateParams.put("numberOfThreads", Settings.config.getThreadsCount());
		templateParams.put("duration", String.format("%.3f", (testContext.getEndDate().getTime() - testContext.getStartDate().getTime()) / 60000.0));
		templateParams.put("failedTests", createTestInfos(testContext.getFailedTests().getAllResults()));
		templateParams.put("failedConfigurations", createTestInfos(testContext.getFailedConfigurations().getAllResults()));
		templateParams.put("skippedTests", createTestInfos(testContext.getSkippedTests().getAllResults()));
		templateParams.put("passedTests", createTestInfos(testContext.getPassedTests().getAllResults()));
		String buildURL = System.getenv("BUILD_URL");
		if (buildURL == null) {
			templateParams.put("cssLocation", "../test-classes/style.css");
		} else {
			templateParams.put("cssLocation", buildURL.replaceAll("54.236.102.212", "34.202.176.241") + "../ws/target/test-classes/style.css");
		}
		return new VelocityContext(templateParams);
	}

	private int getKnownIssueNumber() {
		return knownIssueNumber;
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		TestRailApi testRailApi = new TestRailApi();
		System.out.println(String.format("Test %s passed", result.getName()));
		Logger.info(String.format("%s - Test %s passed", getCurrentTime(), result.getName()));

		try {
			TestRail attribute = AutomationTestListener.class
					.getClassLoader()
					.loadClass(result.getInstanceName())
					.getDeclaredMethod(result.getName())
					.getDeclaredAnnotation(TestRail.class);
			testRailApi.updateTestStatusInTestPlan(createTestInfo(result), result, attribute, settings.getTestPlan(), settings.getTestRun());
		} catch (NoSuchMethodException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		WebDriverManager.getDriver().quit();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TestRailApi testRailApi = new TestRailApi();
		String knownIssue = Logger.getTicketForFailedTest(result);

		try {
			Logger.debug(WebDriverManager.getDriver().manage().getCookies().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Logger.err("TEST " + result.getName() + " FAILED!");
		if ((Settings.config.getBrowser().equals("chrome"))) {
			try {
				Logger.err("IP:" + Utils.getIpAddress(Settings.config.getGrid(), Integer.valueOf(Settings.config.getPort()), WebDriverManager.getDriver().getSessionId()));
			} catch (Exception e) {
				Logger.debug("Can't get grid ip");
			}
		}
		Logger.err("REASON: " + result.getThrowable().getLocalizedMessage());
		try {
			Logger.err("CURRENT URL: " + WebDriverManager.getDriver().getCurrentUrl());
		} catch (Exception e) {
			Logger.debug("URL cannot be taken");
		}
		StringBuilder error = new StringBuilder();
		for (StackTraceElement element : result.getThrowable().getStackTrace()) {
			error.append(element.toString()).append("\n");
		}
		Logger.err("STACK TRACE:\n" + error);
		if (Settings.config.needRerun() && Settings.getRetryNumber() == 1) {
			Logger.debug("Try #2");
		}
		try {
			TestRail attribute = AutomationTestListener.class
					.getClassLoader()
					.loadClass(result.getInstanceName())
					.getDeclaredMethod(result.getName())
					.getDeclaredAnnotation(TestRail.class);
			testRailApi.updateTestStatusInTestPlan(createTestInfo(result), result, attribute, settings.getTestPlan(), settings.getTestRun());
		} catch (NoSuchMethodException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		result.setStatus(ITestResult.FAILURE);
		screenFilePath = new File("target/surefire-reports/failed").getAbsolutePath() + "/";
		String screenshotPath = screenFilePath + getScreenshotFilename(result);
		captureDefaultScreenShot(screenshotPath);
		savePageHTML(result);
		if (knownIssue.contains("http")) {
			ticket.put(result.getMethod().getMethodName(), "<a href=\"" + knownIssue + "\">" + knownIssue.split("/")[knownIssue.split("/").length - 1] + "</a>");
		} else {
			ticket.put(result.getMethod().getMethodName(), knownIssue);
		}
		if (!knownIssue.equals("N/A")) {
			knownIssueNumber++;
		}
		WebDriverManager.getDriver().quit();
	}

	private String getScreenshotFilename(ITestResult result) {
		return getMethodName(result) + ".png";
	}

	private void savePageHTML(ITestResult result) {
		htmlFilePath = savePageHtml(getMethodName(result));
	}

	public static String savePageHtml(String filename) {
		String htmlFilePath = new File(HTML_CAPTURE_PATH).getAbsolutePath() + "/";
		File htmlDirectoryPath = new File(HTML_CAPTURE_PATH);
		if (!htmlDirectoryPath.exists()) {
			if (!htmlDirectoryPath.mkdirs()) {
				throw new RuntimeException("Failed to create directory: " + htmlDirectoryPath + ".");
			}
		}
		try (FileWriter innerHTMLWriter = new FileWriter(htmlFilePath + filename + ".html")) {
			String innerHTML = WebDriverManager.getDriver().getPageSource();
			innerHTMLWriter.write(innerHTML);
		} catch (Exception e) {
			System.out.println("Failed to get or save HTML: " + e + ". See screenshot.");
		}
		return htmlFilePath;
	}

	private void captureDefaultScreenShot(String screenShotPath) {
		try {
			RemoteWebDriver driver = (RemoteWebDriver) new Augmenter().augment(WebDriverManager.getDriver());
			File scrFile = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(screenShotPath));
		} catch (Exception screenException) {
			Logger.debug("ScreenShot can not be saved.");
			screenException.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		SoftAssertion softAssertion = new SoftAssertion();
		softAssertion.resetAssertMap();
		try {
			TestRail testRailAttribute = AutomationTestListener.class
					.getClassLoader()
					.loadClass(result.getInstanceName())
					.getDeclaredMethod(result.getName())
					.getDeclaredAnnotation(TestRail.class);
			TestRailApi testRailApi = new TestRailApi();
			if (!testRailApi.checkIfTestExists(testRailAttribute.id(), settings.getTestPlan(), settings.getTestRun())) {
				throw new SkipException(String.format("Test %s skipped", result.getName()));
			}
			System.out.println(String.format("Test %s started", result.getName()));
			Logger.info(String.format("%s - Test %s started", getCurrentTime(), result.getName()));
		} catch (NoSuchMethodException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void reportLogScreenshot(String screenName) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		createScreenshot(screenName);
		String destFile = String.format("%s.png", screenName);
		String logImage = "<a href=../screenshots/" + destFile + "><img style=\"width:300px\" src=../screenshots/" + destFile + "></a>";
		Logger.debug(logImage);
		Reporter.setCurrentTestResult(null);
	}

	public void createScreenshot(String screenName) {
		try {
			File scrFile = WebDriverManager.getDriver().getScreenshotAs(OutputType.FILE);
			String destDir = "target/surefire-reports/screenshots";
			boolean isFolderExists = (new File(destDir).exists());

			if (!isFolderExists) {
				boolean isFolder = (new File(destDir).mkdirs());
				Assert.assertTrue(isFolder, "Folder was not created");
			}
			String destFile = String.format("%s/%s.png", destDir, screenName);
			FileUtils.copyFile(scrFile, new File(destFile));
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
			System.out.println("Screenshot was not created. Due to an error: " + e.getMessage());
		}
	}

	private String getCurrentTime() {
		DateTime currentTime = new DateTime();
		return currentTime.toString("E MMM, d hh:mm:ss", Locale.US);
	}

	@Override
	public void onStart(ISuite iSuite) {

	}

	@Override
	public void onFinish(ISuite iSuite) {
	}
}
