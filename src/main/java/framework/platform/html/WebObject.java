package framework.platform.html;

import com.google.common.base.Optional;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.html.support.HtmlElementUtils;
import framework.platform.utilities.Utils;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class WebObject extends By {
	private final List<String> HTML_FORM_TAGS;
	protected ParentTraits parent;
	private String locator;
	private String controlName;
	private Map<String, String> propMap = new HashMap<String, String>();
	private Optional<String> expectedErrorMessage;
	private WebDriver driver;

	/**
	 * Constructs an AbstractElement with locator.
	 *
	 * @param locator
	 */
	public WebObject(WebDriver driver, String locator) {
		this.locator = locator;
		this.HTML_FORM_TAGS = Arrays.asList("input", "button", "select", "textarea", "link", "option");
		this.driver = driver;
	}

	/**
	 * Constructs an AbstractElement with locator and parent.
	 *
	 * @param parent  - A {@link ParentTraits} object that represents the parent element for this element.
	 * @param locator - A String that represents the means to locate this element (could be id/name/xpath/css locator).
	 */
	public WebObject(WebDriver driver, ParentTraits parent, String locator) {
		this.parent = parent;
		this.locator = locator;
		this.HTML_FORM_TAGS = Arrays.asList("input", "button", "select", "textarea", "link", "option");
		this.driver = driver;
	}

	/**
	 * Constructs an AbstractElement with locator and controlName.
	 *
	 * @param locator     the element locator
	 * @param controlName the control name used for logging
	 */
	public WebObject(WebDriver driver, String locator, String controlName) {
		this(driver, locator, controlName, null);
		this.driver = driver;
	}

	/**
	 * Constructs an AbstractElement with locator, parent, and controlName.
	 *
	 * @param locator     - A String that represents the means to locate this element (could be id/name/xpath/css locator).
	 * @param controlName - the control name used for logging
	 * @param parent      - A {@link ParentTraits} object that represents the parent element for this element.
	 */
	public WebObject(WebDriver driver, String locator, String controlName, ParentTraits parent) {
		this.locator = locator;
		this.parent = parent;
		this.controlName = controlName;
		this.expectedErrorMessage = Optional.absent();
		this.HTML_FORM_TAGS = Arrays.asList("input", "button", "select", "textarea", "link", "option");
		this.driver = driver;
	}

	/**
	 * Instance method used to call static class method locateElement.
	 *
	 * @return the web element found by locator
	 */
	public RemoteWebElement getElement() {
		RemoteWebElement foundElement = null;
		try {
			foundElement = HtmlElementUtils.locateElement(driver, getLocator());
		} catch (ParentNotFoundException p) {
			throw p;
		} catch (NoSuchElementException n) {
			addInfoForNoSuchElementException(n);
		}
		return foundElement;
	}

	/**
	 * Instance method used to call static class method locateElements.
	 *
	 * @return the list of web elements found by locator
	 */
	public List<WebElement> getElements() {
		return getElements("");
	}

	public List<WebElement> getElements(String value) {
		List<WebElement> foundElements = null;
		try {
			foundElements = HtmlElementUtils.locateElements(driver, String.format(locator, value, value));
		} catch (NoSuchElementException n) {
			addInfoForNoSuchElementException(n);
		}

		return foundElements;
	}

	public String getTextFromElementNumber(int elementNumber) {
		if (elementNumber == 0) {
			elementNumber = 1;
		}
		return getElements().get(elementNumber - 1).getText();
	}

	/**
	 * A utility method to provide additional information to the user when a NoSuchElementException is thrown.
	 *
	 * @param cause The associated cause for the exception.
	 */
	private void addInfoForNoSuchElementException(NoSuchElementException cause) {

		// Find if page exists: This part is reached after a valid page instance is assigned to page variable. So its
		// safe to proceed!

		boolean pageExists = false;

		if (!pageExists) {
			// ParentType: Page does not exist: Sending the cause along with it
//            throw new ParentNotFoundException(resolvedPageName + " : With Page Title {" + page.getActualPageTitle()
//                    + "} Not Found.", cause);
		}
		// The page exists. So lets prepare a detailed error message before throwing the exception.

		StringBuilder msg = new StringBuilder("Unable to find webElement ");

		if (this.controlName != null) {
			msg.append(this.controlName).append(" on ");
		}

		msg.append(" using the locator {").append(locator).append("}");
		throw new NoSuchElementException(msg.toString(), cause);
	}

	/**
	 * Retrieves the locator (id/name/xpath/css locator) for the current {@link WebObject} element.
	 *
	 * @return The value of locator.
	 */
	public String getLocator() {
		return locator;
	}

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Retrieves the control name for the current {@link WebObject} element.
	 *
	 * @return The value of controlName.
	 */
	public String getControlName() {
		return controlName;
	}

	/**
	 * Retrieves the parent element for the current {@link WebObject} element.
	 *
	 * @return A {@link ParentTraits} that represents the parent of the current {@link WebObject} element.
	 */
	public ParentTraits getParent() {
		return parent;
	}

	/**
	 * Finds element on the page and returns the visible (i.e. not hidden by CSS) innerText of this element, including
	 * sub-elements, without any leading or trailing whitespace.
	 *
	 * @return The innerText of this element.
	 */
	public String getText() {
		return getElement().getText();
	}

	public String getTextFromElementWithText(String text) {
		return HtmlElementUtils.locateElement(driver, String.format(locator, text, text)).getText();
	}

	public String getCSSValueFromElementWithText(String cssValue, String text) {
		return HtmlElementUtils.locateElement(driver, String.format(locator, text, text)).getCssValue(cssValue);
	}

	public String getTextFromElementWithText(String text, int elementNumber) {
		return HtmlElementUtils.locateElements(driver, String.format(locator, text, text)).get(elementNumber - 1).getText();
	}

	/**
	 * Checks if element is present in the html dom. An element that is present in the html dom does not mean it is
	 * visible. To check if element is visible, use {@link #getElement()} to get {@link WebElement} and then invoke
	 * {@link WebElement#isDisplayed()}.
	 *
	 * @return True if element is present, false otherwise.
	 */
	public boolean isElementPresent() {
		boolean returnValue = false;
		try {
			if (getElement() != null) {
				returnValue = true;
			}
		} catch (NoSuchElementException e) {
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * Is this element displayed or not? This method avoids the problem of having to parse an element's "style"
	 * attribute.
	 *
	 * @return Whether or not the element is displayed
	 */
	public boolean isVisible() {
		try {
			WebElement element = getElement();
			return element != null && element.isDisplayed();
		} catch (ElementNotVisibleException var1) {
			return false;
		} catch (NoSuchElementException var2) {
			return false;
		} catch (StaleElementReferenceException var3) {
			return false;
		}
	}

	public boolean isElementWithTextVisible(String text) {
		try {
			return HtmlElementUtils.locateElement(driver, String.format(locator, text, text)) != null && HtmlElementUtils.locateElement(driver, String.format(locator, text, text)).isDisplayed();
		} catch (ElementNotVisibleException var1) {
			return false;
		} catch (NoSuchElementException var2) {
			return false;
		} catch (StaleElementReferenceException var3) {
			return false;
		}
	}

	public boolean isElementWithTextVisible(String text, int elementNumber) {
		if (elementNumber == 0) {
			elementNumber = 1;
		}
		try {
			return HtmlElementUtils.locateElements(driver, String.format(locator, text, text)).get(elementNumber - 1) != null && HtmlElementUtils.locateElements(driver, String.format(locator, text, text)).get(elementNumber - 1).isDisplayed();
		} catch (ElementNotVisibleException var1) {
			return false;
		} catch (NoSuchElementException var2) {
			return false;
		} catch (StaleElementReferenceException var3) {
			return false;
		}
	}

	public boolean isCurrentlyEnabled() {
		return this.isEnabled();
	}

	public boolean isPresent() {
		return getElementsCount() > 0;
	}

	/**
	 * Is the element currently enabled or not? This will generally return true for everything but disabled input
	 * elements.
	 *
	 * @return True if element is enabled, false otherwise.
	 */
	public boolean isEnabled() {
		return getElement().isEnabled();
	}

	public boolean isAttributePresentForElementNumber(String attribute, int elementNumber) {
		if (elementNumber == 0) {
			elementNumber = 1;
		}
		try {
			return !getElements().get(elementNumber - 1).getAttribute(attribute).isEmpty();
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isSelected() {
		return getElement().isSelected();
	}

	public boolean isTextPresent(String text) {
		return getElement().getText().contains(text);
	}

	public boolean isAllEnabled() {
		try {
			return getElements().stream().anyMatch(WebElement::isDisplayed);
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public WebObject waitUntilVisible() {
		Logger.debug("Waiting for element " + getControlName());
		if (this.driverIsDisabled()) {
			return this;
		} else {
			try {
				this.waitForCondition().until(this.elementIsDisplayed());
			} catch (Throwable var2) {
				Logger.err(">>>>> ELEMENT " + getControlName() + " is not found <<<<<<");
				this.throwErrorWithCauseIfPresent(var2, var2.getMessage());
			}
			waitForJQueryComplete();

			return this;
		}
	}

	public WebObject waitUntilVisibleOnPage(Object page) {
		Logger.debug("Waiting for page " + page.getClass().getSimpleName() + " to load");
		if (this.driverIsDisabled()) {
			return this;
		} else {
			try {
				this.waitForCondition().until(elementIsDisplayed());
			} catch (Throwable var2) {
				Logger.err(">>>>> TEST WAS NOT ON EXPECTED PAGE - " + page.getClass().getSimpleName() + " <<<<<<");
				this.throwErrorWithCauseIfPresent(var2, var2.getMessage());
			}
			waitForJQueryComplete();

			return this;
		}
	}

	public WebObject waitUntilEnabled() {
		if (this.driverIsDisabled()) {
			return this;
		} else {
			try {
				this.waitForCondition().until(this.elementIsEnabled());
			} catch (Throwable var2) {
				this.throwErrorWithCauseIfPresent(var2, var2.getMessage());
			}
			waitForJQueryComplete();

			return this;
		}
	}

	public WebObject waitElementsReady() {
		if (this.driverIsDisabled()) {
			return this;
		} else {
			try {
				this.waitForCondition().until(this.allElementsEnabled());
			} catch (Throwable var2) {
				this.throwErrorWithCauseIfPresent(var2, var2.getMessage());
			}
			waitForJQueryComplete();

			return this;
		}
	}

	public Wait<WebDriver> waitForCondition() {
		return (new FluentWait(this.driver))
				.withTimeout(Duration.ofMillis(40000L))
				.pollingEvery(Duration.ofMillis(250L))
				.ignoring(NoSuchElementException.class, NoSuchFrameException.class);
	}

	public void selectByValue(String value) {
		new Select(getElement()).selectByValue(value);
	}

	public void selectByVisibleText(String value) {
		new Select(getElement()).selectByVisibleText(value);
	}

	public void selectByText(String text) {
		waitUntilEnabled();
		Select dropdown = new Select(getElement());
		dropdown.selectByVisibleText(text);
		waitForJQueryComplete();
	}

	public String getSelectedText() {
		waitUntilEnabled();
		Select dropdown = new Select(getElement());
		return dropdown.getFirstSelectedOption().getText();
	}

	public WebObject switchToFrame() {
		driver.switchTo().frame(getElement());
		return this;
	}

	/**
	 * Get the value of a the given attribute of the element. Will return the current value, even if this has been
	 * modified after the page has been loaded. More exactly, this method will return the value of the given attribute,
	 * unless that attribute is not present, in which case the value of the property with the same name is returned. If
	 * neither value is set, null is returned. The "style" attribute is converted as best can be to a text
	 * representation with a trailing semi-colon. The following are deemed to be "boolean" attributes, and will return
	 * either "true" or null: async, autofocus, autoplay, checked, compact, complete, controls, declare, defaultchecked,
	 * defaultselected, defer, disabled, draggable, ended, formnovalidate, hidden, indeterminate, iscontenteditable,
	 * ismap, itemscope, loop, multiple, muted, nohref, noresize, noshade, novalidate, nowrap, open, paused, pubdate,
	 * readonly, required, reversed, scoped, seamless, seeking, selected, spellcheck, truespeed, willvalidate. Finally,
	 * the following commonly mis-capitalized attribute/property names are evaluated as expected: class, readonly
	 *
	 * @param attributeName the attribute name to get current value
	 * @return The attribute's current value or null if the value is not set.
	 */
	public String getAttribute(String attributeName) {
		return getElement().getAttribute(attributeName);
	}

	/**
	 * Get the value of a the given css attribute of the element. Will return the current value, even if this has been
	 * modified after the page has been loaded.
	 */
	public String getCssValue(String cssValue) {
		return getElement().getCssValue(cssValue);
	}

	/**
	 * Gets the (whitespace-trimmed) value of an input field (or anything else with a value parameter). For
	 * checkbox/radio elements, the value will be "on" or "off" depending on whether the element is checked or not.
	 *
	 * @return the element value, or "on/off" for checkbox/radio elements
	 */
	public String getValue() {
		return getAttribute("value");
	}

	public WebObject and() {
		return this;
	}

	public WebObject then() {
		return this;
	}

	private boolean driverIsDisabled() {
		Stack<Boolean> webdriverSuspensions = new Stack<Boolean>();
		return !webdriverSuspensions.isEmpty();
	}

	public WebElement getFirstElementFromList() {
		int counter = 0;
		while (counter < 10) {
			try {
				return getElements()
						.stream()
						.findFirst()
						.get();
			} catch (StaleElementReferenceException | java.util.NoSuchElementException e) {
				counter++;
				System.out.print(String.format("Trying to recover after Exception %s", e.getMessage()));
			}
		}
		return null;
	}

	/**
	 * The click function and wait for page to load
	 */
	public void click() {
		waitForJQueryComplete();
		if (Settings.isDesktop()) {
			int elementY = getElement().getLocation().getY(); //Scrolling page up, to avoid click on new header wrapped over element
			Logger.debug("Element Y" + elementY);
			Utils.scrollPage(elementY - 500);
		}
		getElement().click();
	}

	public void doubleClick() {
		new Actions(driver).doubleClick(getElement()).build().perform();
	}

	public void actionClick() {
		new Actions(driver).click(getElement()).build().perform();
	}

	public void actionClickOnElementNumber(int number) {
		if (number == 0) {
			number = 1;
		}
		new Actions(driver).click(getElements().get(number - 1)).build().perform();
	}

	public void type(String value) {
		waitForJQueryComplete();
		RemoteWebElement element = getElement();
		element.clear();
		element.sendKeys(value);
		waitForJQueryComplete();
	}

	public void typeIntoElementWithText(String value, String elementText) {
		waitForJQueryComplete();
		RemoteWebElement element = HtmlElementUtils.locateElement(driver, String.format(locator, elementText, elementText));
		element.clear();
		element.sendKeys(value);
		waitForJQueryComplete();
	}

	public void sendKeys(CharSequence... keysToSend) {
		getElement().sendKeys(keysToSend);
	}

	public void clear() {
		RemoteWebElement element = getElement();
		element.clear();
		waitForJQueryComplete();
	}

	private ExpectedCondition elementIsDisplayed() {
		return driver -> WebObject.this.isVisible();
	}

	private ExpectedCondition elementIsEnabled() {
		return driver -> Boolean.valueOf(WebObject.this.isCurrentlyEnabled());
	}

	private ExpectedCondition allElementsEnabled() {
		return driver -> Boolean.valueOf(WebObject.this.isAllEnabled());
	}

	private void waitForJQueryComplete() {
		int sleepTime = 500;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		for (int i = 0; i < 5000 / sleepTime; i++) {
			waitFor(sleepTime / 2);
			String value = jse.executeScript("return document.readyState == 'complete' && window.jQuery != undefined").toString();
			Logger.debug("js value: " + value);
			if (Boolean.parseBoolean(value)) {
				return;
			}
			hardwait();
		}
	}

	private void hardwait() {
		try {
			Thread.sleep(500L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void throwErrorWithCauseIfPresent(Throwable timeout, String defaultMessage) {
		String timeoutMessage = timeout.getCause() != null ? timeout.getCause().getMessage() : timeout.getMessage();
		String finalMessage = StringUtils.isNotEmpty(timeoutMessage) ? timeoutMessage : defaultMessage;
		throw new ElementNotVisibleException(finalMessage, timeout);
	}

	public WebObject waitUntilClickable() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(getElement()));
		return this;
	}

	public void waitUntilInvisible() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			if (locator.contains("css=") || locator.contains("id=")) {
				String loc = locator.replaceAll("id=", "#").replaceAll("css=", "");
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(loc)));
			} else if (locator.contains("xpath=")) {
				String loc = locator.replaceAll("xpath=", "");
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(loc)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		waitForJQueryComplete();
	}

	public void waitUntilStalenessOfElement() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.stalenessOf(getElement()));
	}

	public void waitUntilElementIsVisible() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getElement()));
	}

	public void waitUntilVisibilityOfAllElements() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		String loc = locator.replaceAll("id=", "#").replaceAll("css=", "");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(loc)));
	}

	public void mouseHover() {
		new Actions(driver).moveToElement(getElement()).build().perform();
	}

	public void mouseHoverOnElementNumber(int number) {
		new Actions(driver).moveToElement(getElements().get(number - 1)).build().perform();
	}

	public int getElementsCount() {
		try {
			return getElements().size();
		} catch (NoSuchElementException ignored) {
			return 0;
		}
	}

	public int getElementsWithTextCount(String text) {
		try {
			return HtmlElementUtils.locateElements(driver, String.format(locator, text)).size();
		} catch (ElementNotVisibleException | NoSuchElementException var2) {
			return 0;
		}
	}

	public int getVisibleElementsCount() {
		int numberOfVisibleElements = 0;
		int totalNumber = getElementsCount();
		for (int elementNumber = 1; elementNumber <= totalNumber; elementNumber++) {

			if (isElementNumberVisible(elementNumber)) {
				numberOfVisibleElements++;
			}
		}
		return numberOfVisibleElements;
	}

	public boolean isElementNumberVisible(int elementNumber) {
		if (elementNumber == 0) {
			elementNumber = 1;
		}
		WebElement element = getElements().get(elementNumber - 1);
		try {
			if (!element.getAttribute("style").contains("display: none;") && element.isDisplayed()) {
				String size = element.getSize().toString();
				if (!size.startsWith("(0,") && !size.endsWith(", 0)")) {
					return true;
				}
			}
		} catch (Exception ignored) {
			Logger.info("Element number " + elementNumber + " not visible");
		}
		return false;
	}

	public int getNumberOfVisibleAndClickableElements() {
		Logger.debug("Getting number of clickable and visible elements");
		int numberOfVisibleElements = 0;
		try {
			for (WebElement element : getElements()) {
				try {
					WebDriverWait wait = new WebDriverWait(driver, 1);
					wait.until(ExpectedConditions.elementToBeClickable(element));
					numberOfVisibleElements++;
				} catch (TimeoutException ignored) {
					Logger.debug("element is not visible");
				}
			}
		} catch (Exception e) {
			Logger.debug("element is not visible");
		}
		Logger.debug("Number of visible elements: " + numberOfVisibleElements);
		return numberOfVisibleElements;
	}

	public int getFirstVisibleAndClickableElement() {
		Logger.info("Getting current first clickable element");
		int elementNumber = 1;
		WebDriverManager.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //need that to avoid waiting for 10 seconds in try each time
		for (WebElement element : getElements()) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 1);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				Logger.info("First Clickable element number is " + elementNumber);
				WebDriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				return elementNumber;
			} catch (TimeoutException ignored) {
				elementNumber++;
			}
		}
		Settings.setDefaultImplicityWait();
		return -1; //will not get here
	}

	public void clickOnElementNumber(int number) {
		if (number == 0) {
			number = 1;
		}
		if (Settings.config.getProject().equalsIgnoreCase("everydayhealth") && Settings.isDesktop()) {
			//Scrolling page up, to avoid click on new header wrapped over element
			int elementY = getElements().get(number - 1).getLocation().getY();
			Utils.scrollPage(elementY - 500);
			scrollToElementNumber(number);
		}
		getElements().get(number - 1).click();
	}

	public void clickOnElementNumberWithText(int number, String text) {
		List<WebElement> foundElements = null;

		if (number == 0) {
			number = 1;
		}

		foundElements = HtmlElementUtils.locateElements(driver, String.format(locator, text, text));
		if (Settings.config.getProject().equalsIgnoreCase("everydayhealth") && Settings.isDesktop()) {
			//Scrolling page up, to avoid click on new header wrapped over element
			int elementY = foundElements.get(number - 1).getLocation().getY();
			Utils.scrollPage(elementY - 500);
		}
		foundElements.get(number - 1).click();
	}

	public void clickOnElementWithValue(String value) {
		for (int number = 0; number <= getElementsCount(); ) {
			if (getElements().get(number).getAttribute("value").equalsIgnoreCase(value)) {
				clickOnElementNumber(number + 1);
				break;
			} else {
				number++;
			}
		}
	}

	public String getAttributeOfElementNumber(int number, String attribute) {
		if (number == 0) {
			number = 1;
		}
		return getElements().get(number - 1).getAttribute(attribute);
	}

	public String getAttributeOfElementNumberWithText(int elementNumber, String attribute, String text) {
		List<WebElement> foundElements = null;

		if (elementNumber == 0) {
			elementNumber = 1;
		}

		foundElements = HtmlElementUtils.locateElements(driver, String.format(locator, text, text));
		return foundElements.get(elementNumber - 1).getAttribute(attribute);
	}

	public void clickWithJS() {
		waitForJQueryComplete();
		waitFor(500);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String loc = locator.replaceAll("id=", "#").replaceAll("css=", "");
		jse.executeScript("document.querySelector(\"" + loc + "\").click();");
	}

	public void scrollToElement() {
		try {
			scrollToElementNumber(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scrollToElementNumber(int number) {
		if (number == 0) {
			number = 1;
		}
		int elementY = getElements().get(number - 1).getLocation().getY();
		int currentLocation = Integer.parseInt(Utils.getJSResult("return document.body.scrollTop;"));
		int visibleY = (Settings.isDesktop()) ? 800 : 500;
		Logger.debug("elementY: " + elementY);
		Logger.debug("currentLocation: " + currentLocation);
		if (elementY > visibleY || currentLocation > 10) {
			Utils.scrollPage(elementY - 450);
			waitFor(500);
		}
	}

	public void waitFor(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void openLinkInBackgroundTab() {
		Logger.info("Opening link in background tab");
		new Actions(WebDriverManager.getDriver()).keyDown(Keys.CONTROL).click(getElement()).keyUp(Keys.CONTROL).build().perform();
	}

	@Override
	public List<WebElement> findElements(SearchContext context) {
		return null;
	}

	public void longClickWebObject() {
		int n = 5;
		for (int i = 1; i <= n; i++) {
			try {
				getElement().click();
				break;
			} catch (WebDriverException driverException) {
				System.out.println("Click on element failed. Attempt: " + i + "/" + n);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (i == n) {
				Assert.fail("Failed to click " + n + " times");
			}
		}
	}

	public void longClickWebElement(int elementNumber) {
		int n = 5;
		for (int i = 1; i <= n; i++) {
			try {
				getElements().get(elementNumber).click();
				break;
			} catch (WebDriverException driverException) {
				System.out.println("Click on element failed. Attempt: " + i + "/" + n);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (i == n) {
				Assert.fail("Failed to click " + n + " times");
			}
		}
	}

	public void moveSlider(int xOffset, int yOffset) {
		new Actions(driver).dragAndDropBy(getElement(), xOffset, yOffset).build().perform();
	}

	public boolean isInViewPort() {
		waitForJQueryComplete();
		this.waitUntilVisible();
		waitFor(500);
		String locator = this.getLocator().split("=", 2)[1];
		return Utils.getJSResult("return $('" + locator + "').is(':in-viewPort')").equalsIgnoreCase("true");
	}

	public boolean isElementWithTextInViewPort(String text) {
		waitForJQueryComplete();
		String locator = String.format(this.getLocator(), text, text).replace("css=", "");
		return Utils.getJSResult("return $('" + locator + "').is(':in-viewPort')").equalsIgnoreCase("true");
	}

	public int getElementWidth() {
		return getElement().getSize().getWidth();
	}

	public int getElementHeight() {
		return getElement().getSize().getHeight();
	}

	public String getHrefOfElementNumber(int element) {
		if (element == 0) {
			element = 1;
		}
		return getElements().get(element - 1).getAttribute("href");
	}

	public String getCssOfElementNumber(int element, String property) {
		if (element == 0) {
			element = 1;
		}
		return getElements().get(element - 1).getCssValue(property);
	}

	public String getColor() {
		return getElement().getCssValue("color");
	}

	public String getFontFamily() {
		return getElement().getCssValue("font-family");
	}

	public String getFontSize() {
		return getElement().getCssValue("font-size");
	}

	public int getXCoordinate() {
		return getElement().getLocation().x;
	}

	public int getYCoordinate() {
		return getElement().getLocation().y;
	}

	public String getColorFromElementNumber(int elementNumber) {
		if (elementNumber == 0) {
			elementNumber = 1;
		}
		return getElements().get(elementNumber - 1).getCssValue("color");
	}

	public void scrollIntoView() {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", getElement());
		waitFor(1000);
	}

	public void scrollIntoView(int elementNumber) {
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", getElements().get(elementNumber - 1));
		waitFor(1000);
	}
}
