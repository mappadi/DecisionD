package framework;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum BrowserType {
	FIREFOX,
	CHROME,
	CHROME_NO_GRID,
	SAFARI,
	IE,
	MOBILE_CHROME,
	MOBILE_SAFARI,
	FIREFOX_NO_GRID;

	private static Map<String, BrowserType> browsersMap = new HashMap<String, BrowserType>();

	static {
		browsersMap.put("mobilechrome", BrowserType.MOBILE_CHROME);
		browsersMap.put("mobilesafari", BrowserType.MOBILE_SAFARI);
		browsersMap.put("firefoxnogrid", BrowserType.FIREFOX_NO_GRID);
		browsersMap.put("firefox", BrowserType.FIREFOX);
		browsersMap.put("chromenogrid", BrowserType.CHROME_NO_GRID);
		browsersMap.put("chrome", BrowserType.CHROME);
		browsersMap.put("safari", BrowserType.SAFARI);
		browsersMap.put("ie", BrowserType.IE);
	}

	public static BrowserType browser(String name) {
		BrowserType browserType = null;
		if (name != null) {
			browserType = browsersMap.get(name.toLowerCase().trim());
			if (browserType == null) {
				throw new UnknownBrowserException("Unknown browser [" + name + "]. Use one of following: "
						+ StringUtils.join(browsersMap.keySet().toArray(), ", "));
			}
		}

		return browserType;
	}

}
