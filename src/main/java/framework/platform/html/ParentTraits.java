package framework.platform.html;

import framework.components.BasicPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;

/**
 * A generic interface for outlining the Parent traits of an HTML entity.<br>
 * By Default, A Page is the parent to {@link WebObject}. A parent
 */
public interface ParentTraits {

	/**
	 * Returns the child element denoted by the locator
	 *
	 * @param locator
	 */
	RemoteWebElement locateChildElement(String locator);

	/**
	 * Returns the {@link List} of WebElements {@link WebElement} denoted by the locator
	 *
	 * @param locator
	 */
	List<WebElement> locateChildElements(String locator);

	/**
	 * Returns the current page {@link BasicPage}
	 */
	BasicPage getCurrentPage();
}
