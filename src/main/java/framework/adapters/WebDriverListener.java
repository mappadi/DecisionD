package framework.adapters;

import framework.BrowserType;
import framework.Logger;
import framework.Settings;
import framework.platform.utilities.Utils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebDriverListener implements IInvokedMethodListener {

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		if (!method.getTestMethod().getMethodName().contains("testRepeater")
				&& !method.getTestMethod().getMethodName().contains("softAssertSetup")
				&& !(System.getProperty("groups").contains("WTEServices"))) {
			RemoteWebDriver driver = Settings.createInstance();
			int seconds = (Settings.browser.equals(BrowserType.IE)) ? 300 : 120;
			driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(seconds, TimeUnit.SECONDS);
			WebDriverManager.setWebDriver(driver);
			Settings.setDefaultImplicityWait();
			Logger.info("Session id - " + driver.getSessionId());
			if (!Settings.config.getApplicationPath().isEmpty()) {
				AppiumDriver appiumDriver = ((AppiumDriver) driver);
				WebElement textField = appiumDriver.findElement(By.xpath("//UIAWindow[1]/UIATextField[1]"));
				textField.clear();
				textField.sendKeys(Settings.getDefaultUrl());
				appiumDriver.findElement(By.xpath("//UIAWindow[1]/UIAButton[1]")).click();
				Utils.waitFor(3000);//need to open next view
				Set contextNames = appiumDriver.getContextHandles();
				for (Object contextName : contextNames) {
					Logger.debug("Context name: " + contextName);
					appiumDriver.context(contextName.toString());
					Logger.debug(appiumDriver.getPageSource());
				}
			}
		}
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if (!method.isTestMethod()) {
			try {
				WebDriverManager.getDriver().quit();
			} catch (Exception ignored) {
				Logger.debug("Can not quit driver");
			}
		}
	}
}
