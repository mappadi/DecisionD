package framework.components;

import framework.platform.web.GuiMapReader;
import framework.platform.web.GuiMapReaderFactory;
import framework.PageLoader;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public abstract class AbstractPage implements PageLoader {
	// Initialization state of WebPage
	/**
	 * The page initialized.
	 */
	protected boolean pageInitialized;
	// Object map queue for loading
	/**
	 * The map queue.
	 */
	protected Queue<String[]> mapQueue;
	// used to determine our locale (e.g. US, UK, DE, etc.)
	/**
	 * The site.
	 */
	protected String site;
	/**
	 * The page title.
	 */
	protected String pageUrl;

	/**
	 * Map to store our GUI object map content.
	 */
	protected Map<String, String> objectMap;

	/**
	 * The UNKNOWN_PAGE_TITLE.
	 */
	private static final String UNKNOWN_PAGE_TITLE = "unknown-url";

	/**
	 * Map to store our GUI object map content for all Containers
	 */
	protected Map<String, Map<String, String>> objectContainerMap = new HashMap<String, Map<String, String>>();

	protected AbstractPage() {
		pageUrl = UNKNOWN_PAGE_TITLE;
		mapQueue = new LinkedList<String[]>();
		pageInitialized = false;
	}

	public void initPage(String pageDomain, String pageClassName) {
		mapQueue.add(new String[]{pageDomain, pageClassName});
	}

	/**
	 * Load object map.
	 */
	protected void loadObjectMap() {
		while (mapQueue.size() > 0) {
			String[] map = mapQueue.poll();
			String pageDomain = map[0];
			String pageClassName = map[1];
			Map<String, String> currentObjectMap;
			try {

				GuiMapReader dataProvider = GuiMapReaderFactory.getInstance(pageDomain, pageClassName);
				currentObjectMap = dataProvider.getGuiMap(site);

				if (objectMap != null) {
					objectMap.putAll(currentObjectMap);
				} else {
					objectMap = currentObjectMap;
				}
			} catch (Exception e) {
				throw new RuntimeException("Unable to initialize page data for " + pageDomain + "/" + pageClassName
						+ ". Root cause:" + e, e);
			}
		}
		pageInitialized = true;
	}

	public void initPage(String pageDomain, String pageClassName, String siteLocale) {
		initPage(pageDomain, pageClassName);
		site = siteLocale;
	}

	public boolean isInitialized() {
		return pageInitialized;
	}


}
