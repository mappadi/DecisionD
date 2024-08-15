package framework.platform.utilities;

import framework.Logger;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static framework.platform.utilities.Utils.waitFor;

/**
 * Basic Authentication Utils
 */
public class AuthenticationUtils {

	public static void performAuthentication(String username, String password) {
		try {
			waitFor(5000);//need to load authentication pop up
			Robot robot = new Robot();

			Logger.info("Enter username " + username);
			setClipboardData(username);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(2000);

			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(2000);

			Logger.info("Enter password " + password);
			setClipboardData(password);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(2000);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(5000);
		} catch (AWTException e) {
			Logger.info("Cannot run robot");
			e.printStackTrace();
		}
	}

	private static void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

}
