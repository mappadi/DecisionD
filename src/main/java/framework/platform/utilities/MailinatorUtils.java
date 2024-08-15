package framework.platform.utilities;

import framework.Logger;
import framework.adapters.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * MailinatorUtils
 *
 * As it is Utils class and we are not going to use WebObjects
 */
public class MailinatorUtils {

	public static void openMailinatorLandingPage() {
		Logger.info("Open mailinator landing page");
		WebDriverManager.getDriver().get("http://mailinator.com");
	}

	public static void openMailinatorBoxForEmail(String email) {
		Logger.info("Open mailinator box for email: " + email);
		WebDriverManager.getDriver().findElement(By.id("inboxfield")).sendKeys(email, Keys.ENTER);
		Utils.waitFor(5000); // wait for page to load
	}

	public static void openLastEmail() {
		Logger.info("Open last email");
		WebDriverManager.getDriver().findElement(By.xpath("//div[contains(@id,'row_public')]//div[contains(text(),'Password Recovery Notification')][1]")).click();
		Utils.waitFor(5000); // wait for page to load
	}
}
