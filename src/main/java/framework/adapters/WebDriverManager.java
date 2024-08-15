package framework.adapters;

import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager {
	private static ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<>();

	public static RemoteWebDriver getDriver() {
		return webDriver.get();
	}

	public static void setWebDriver(RemoteWebDriver driver) {
		webDriver.set(driver);
	}
}
