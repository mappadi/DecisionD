package framework.platform.utilities;


import framework.Logger;
import framework.adapters.WebDriverManager;
import framework.platform.CookieName;

import org.openqa.selenium.Cookie;

import java.util.Date;
import java.util.Set;

/**
 * CookiesManager
 */
public class CookiesManager {

	/**
	 * @param cookie verify a cookie <name> has an empty <value>
	 * @return
	 */
	public static boolean isCookieEmpty(CookieName cookie) {
		Cookie cookieValue = WebDriverManager.getDriver().manage().getCookieNamed(cookie.toString());
		String cookie_val = cookieValue.getValue();
		Logger.info("Cookie value: " + cookie_val);
		return cookie_val.isEmpty();
	}

	public static String getCookieValue(CookieName cookie) {
		Cookie cookieValue = WebDriverManager.getDriver().manage().getCookieNamed(cookie.toString());
		String cookie_val = cookieValue.getValue();
		Logger.info("Cookie value: " + cookie_val);
		return cookie_val;
	}

	public static String getCookieDomain(CookieName cookie) {
		Logger.info("Get domain of cookie " + cookie + "");
		return WebDriverManager.getDriver().manage().getCookieNamed(cookie.toString()).getDomain();
	}

	public static void setCookieValue(CookieName cookie, String value) {
		Cookie ck = new Cookie(cookie.toString(), value);
		WebDriverManager.getDriver().manage().addCookie(ck);
	}

	public static void setCookieValueForDomain(CookieName cookie, String value, String domain) {
		Cookie ck = new Cookie(cookie.toString(), value, domain, "/", DateUtils.addDaysToDate(new Date(), 10));
		WebDriverManager.getDriver().manage().addCookie(ck);
	}

	public static boolean isCorrectValue(CookieName cookie, String value) {
		Cookie cookieValue = WebDriverManager.getDriver().manage().getCookieNamed(cookie.toString());
		String cookie_val = cookieValue.getValue();
		Logger.info("Cookie " + cookie + " value is " + cookie_val);
		return cookie_val.equalsIgnoreCase(value);
	}

	/**
	 * @param cookie verify a cookie <name> is not in cookie manager
	 * @return
	 */
	public static boolean isCookiePresent(CookieName cookie) {
		Cookie nullCookie = new Cookie(cookie.toString(), null);
		return WebDriverManager.getDriver().manage().getCookies().contains(nullCookie.equals(null));
	}

	public static void deleteAllCookies() {
		WebDriverManager.getDriver().manage().deleteAllCookies();
	}

	public static void printCookies() {
		Set<Cookie> allCookies = WebDriverManager.getDriver().manage().getCookies();
		for (Cookie loadedCookie : allCookies) {
			System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
		}
	}

	public static Set<Cookie> getCookies(){
		return WebDriverManager.getDriver().manage().getCookies();
	}
}
