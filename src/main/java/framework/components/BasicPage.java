package framework.components;

import framework.DebugMode;
import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.platform.SiteNavigatorBase;
import framework.platform.html.ParentTraits;
import framework.platform.html.WebObject;
import framework.platform.html.support.HtmlElementUtils;
import framework.platform.utilities.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * A Base class from which all page classes should be derived.
 * <p/>
 * It contains the code to initialize {$project}.pages, load values to the "ObjectMap", and interact in various ways with the
 * page(s).
 */
public abstract class BasicPage extends AbstractPage implements ParentTraits {
	private static final String EHA_COMPONENTS = "framework.platform.html";
	public WebDriver basedriver;

	public DebugMode inDebugMode() {
		SiteNavigatorBase.goToDebugMode(false);
		waitForAjaxRequestToBeFinished();
		return new DebugMode(basedriver);
	}

	public BasicPage scrollDownThePage() {
		scrollPage(2000);
		waitForAjaxRequestToBeFinished();
		waitFor(1000);
		return this;
	}

	public String getPageSource() {
		return basedriver.getPageSource();
	}

	public BasicPage(WebDriver driver) {
		super();
	}

	protected void waitForAjaxRequestToBeFinished() {
		waitForAjaxRequestToBeFinished(5000);
	}

	protected void waitForAjaxRequestToBeFinished(int timeoutInMilliseconds) {
		int sleepTime = 500;
		JavascriptExecutor jse = (JavascriptExecutor) basedriver;
		try {
			for (int i = 0; i < timeoutInMilliseconds / sleepTime; i++) {
				waitFor(sleepTime / 2);
				if ((Boolean) jse.executeScript(
						"return document.readyState == 'complete' && window.jQuery != undefined && jQuery.active == 0")) {
					return;
				}
				waitFor(sleepTime / 2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForPageLoad(int timeoutInMilliseconds) {
		int sleepTime = 500;
		JavascriptExecutor jse = (JavascriptExecutor) basedriver;
		for (int i = 0; i < timeoutInMilliseconds / sleepTime; i++) {
			waitFor(sleepTime / 2);
			if ((Boolean) jse.executeScript(
					"return document.readyState == 'complete'")) {
				return;
			}
			waitFor(sleepTime / 2);
		}
	}

	public void waitFor(int miliseconds) {
		try {
			Thread.sleep(miliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void initializeHtmlObjects(Object whichClass, Map<String, String> objectMap) {
		ArrayList<Field> fields = new ArrayList<Field>();
		Class<?> incomingClass = whichClass.getClass();

		// If the class type is a container then adding the fields related to the container.
//        if (incomingClass.getSuperclass().equals(Container.class)) {
//            fields.addAll(Arrays.asList(incomingClass.getDeclaredFields()));
//        } else {
		// This definitely a page object and so proceeding with loading all the fields
		Class<?> tempIncomingClass = incomingClass;
		do {
			fields.addAll(Arrays.asList(tempIncomingClass.getDeclaredFields()));
			tempIncomingClass = tempIncomingClass.getSuperclass();
		} while (tempIncomingClass != null);

//        }

		String errorDesc = " while initializing HTML fields from the object map. Root cause:";
		try {
			// proceed further only if the data member and the key in the .xls file match with each other
// below condition checks for this one to one mapping presence
			for (Field field : fields)
				if (objectMap.containsKey(field.getName())) {
					field.setAccessible(true);

					String packageName = field.getType().getPackage().getName();

					// We need to skip for any other objects such String, custom Classes etc.
					if (packageName.equals(EHA_COMPONENTS)) {
						// Checking if the superClass/Parent is also a container. If so its not allowed.

						Class<?> dataMemberClass = Class.forName(field.getType().getName());
						Class<?> parameterTypes[] = new Class[4];

						parameterTypes[0] = WebDriver.class;
						parameterTypes[1] = String.class;
						parameterTypes[2] = String.class;
						parameterTypes[3] = ParentTraits.class;
						Constructor<?> constructor = dataMemberClass.getDeclaredConstructor(parameterTypes);

						String locatorValue = objectMap.get(field.getName());
						if (locatorValue == null) {
							continue;
						}
						Object[] constructorArgList = new Object[4];

						constructorArgList[0] = basedriver;
						constructorArgList[1] = new String(locatorValue);
						constructorArgList[2] = new String(field.getName());
						constructorArgList[3] = whichClass;
						Object retobj = constructor.newInstance(constructorArgList);
						field.set(whichClass, retobj);
					} else
//                    if (field.getType().getSuperclass().equals(Container.class))
					{
						Class<?> dataMemberClass = Class.forName(field.getType().getName());
						Class<?> parameterTypes[] = new Class[3];

						parameterTypes[0] = field.getType().getDeclaringClass();
						parameterTypes[1] = String.class;
						parameterTypes[2] = String.class;
						Constructor<?> constructor = dataMemberClass.getDeclaredConstructor(parameterTypes);

						String locatorValue = objectMap.get(field.getName());
						if (locatorValue == null) {
							continue;
						}
						Object[] constructorArgList = new Object[3];
						constructorArgList[0] = whichClass;
						constructorArgList[1] = new String(locatorValue);
						constructorArgList[2] = new String(field.getName());
						Object retobj = constructor.newInstance(constructorArgList);
						// Associating a parent type here itself! Kind of an hack
//                        Container createdContainer = (Container) retobj;
//                        createdContainer.setParentForContainer((ParentTraits) whichClass);
						field.set(whichClass, retobj);

						// Calling it recursively to load the elements in the container
						initializeHtmlObjects(retobj, objectContainerMap.get(field.getName()));
					}
				}
		} catch (ClassNotFoundException exception) {
			throw new RuntimeException("Class not found" + errorDesc + exception, exception);
		} catch (IllegalArgumentException exception) {
			throw new RuntimeException("An illegal argument was encountered" + errorDesc + exception, exception);
		} catch (InstantiationException exception) {
			throw new RuntimeException("Could not instantantiate object" + errorDesc + exception, exception);
		} catch (IllegalAccessException exception) {
			throw new RuntimeException("Could not access data member" + errorDesc + exception, exception);
		} catch (InvocationTargetException exception) {
			throw new RuntimeException("Invocation error occured" + errorDesc + exception, exception);
		} catch (SecurityException exception) {
			throw new RuntimeException("Security error occured" + errorDesc + exception, exception);
		} catch (NoSuchMethodException exception) {
			throw new RuntimeException("Method specified not found" + errorDesc + exception, exception);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 */
	public List<WebElement> locateChildElements(String locator) {
		return HtmlElementUtils.locateElements(basedriver, locator);
	}

	/*
	 * (non-Javadoc)
	 *
	 */
	public RemoteWebElement locateChildElement(String locator) {
		return new RemoteWebElement(); //HtmlElementUtils.locateElement(locator);
	}

	/*
	 * (non-Javadoc)
	 *
	 */
	public BasicPage getCurrentPage() {
		return this;
	}

	public Actions withActions() {
		return new Actions(basedriver);
	}

	public BasicPage clickWithJs(String cssSelector) {
		WebElement element = basedriver.findElement(By.cssSelector(cssSelector));
		JavascriptExecutor executor = (JavascriptExecutor) basedriver;
		executor.executeScript("arguments[0].click();", element);
		return this;
	}

	public void scrollPage(Integer y) {
		JavascriptExecutor jse = (JavascriptExecutor) basedriver;
		jse.executeScript("scroll(0, " + y.toString() + ");");
	}

	public void scrollRight(Integer x) {
		JavascriptExecutor jse = (JavascriptExecutor) basedriver;
		jse.executeScript("scroll(" + x.toString() + ", 0);");
	}

	public void switchToFrame(WebObject element) {
		basedriver.switchTo().frame(element.getElement());
	}

	public void switchToDefaultContent() {
		basedriver.switchTo().defaultContent();
	}

	public static <T> T clickBackBrowserButton(Class<T> expectedPage) {
		Logger.info("Click 'Back' browser button");
		WebDriverManager.getDriver().navigate().back();
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public BasicPage refresh() {
		Logger.info("Refresh page");
		WebDriverManager.getDriver().navigate().refresh();
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public boolean isInViewPort(String locator) {
		waitForAjaxRequestToBeFinished();
		Logger.info("Checking locator " + locator + " is in viewport");
		return Utils.getJSResult("return $('" + locator + "').is(':in-viewPort')").equalsIgnoreCase("true");
	}

	public void acceptAlert() {
		Alert alert = WebDriverManager.getDriver().switchTo().alert();
		Logger.info("Accept Alert with text: " + alert.getText());
		alert.accept();
	}
}
