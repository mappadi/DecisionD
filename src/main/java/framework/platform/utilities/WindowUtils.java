package framework.platform.utilities;

import org.openqa.selenium.Keys;

import framework.Logger;
import framework.adapters.WebDriverManager;

import java.util.Set;

import static org.testng.Assert.fail;

/**
 * WindowUtils
 */
public class WindowUtils {

	public static void switchToLastOpenedWindow() {
		Utils.waitFor(5000);
		try {
			String currentWindow = WebDriverManager.getDriver()
					.getWindowHandle();
			Set<String> windows = WebDriverManager.getDriver()
					.getWindowHandles();
			if (windows.size() > 1) {
				for (String window : windows) {
					WebDriverManager.getDriver().switchTo().window(window);
					if (!WebDriverManager.getDriver().getWindowHandle()
							.equals(currentWindow)) {
						WebDriverManager.getDriver().switchTo().window(window);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem switching windows " + e.getMessage());
		}
	}

	public static void switchToMainWindow() {
		try {
			String currentWindow = WebDriverManager.getDriver()
					.getWindowHandle();
			Set<String> windows = WebDriverManager.getDriver()
					.getWindowHandles();
			String mainWindow = null;
			if (windows.size() > 1) {
				for (String window : windows) {
					WebDriverManager.getDriver().switchTo().window(window);
					if (WebDriverManager.getDriver().getWindowHandle().equals(currentWindow)) {
						if (WebDriverManager.getDriver().getCurrentUrl().contains("chrome://print/")) {
							//Use keyboard escape key to close print dialog on chrome browser
							Utils.sendKeysToBrowser(Keys.ESCAPE);
						} else {
							WebDriverManager.getDriver().close();
						}
					} else {
						mainWindow = WebDriverManager.getDriver().getWindowHandle();
					}
					WebDriverManager.getDriver().switchTo().window(mainWindow);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail("Problem switching back to main window " + e.getMessage());
		}
	}

	public static void printWindowsHandles() {
		int windowCounter = 0;
		for (String winHandle : WebDriverManager.getDriver().getWindowHandles()) {
			windowCounter++;
			Logger.info(windowCounter + " window handle: " + winHandle);
		}
	}

	public static int getTabsCount() {
		Logger.info("Get tabs count");
		int tabsCount = WebDriverManager.getDriver().getWindowHandles().size();
		Logger.info("Tabs count is - " + tabsCount);
		return tabsCount;
	}
}