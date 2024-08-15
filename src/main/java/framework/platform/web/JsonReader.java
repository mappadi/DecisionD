package framework.platform.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.fail;

public class JsonReader extends AbstractJsonReader {

	public JsonReader(String fileName) {
		try {
			File file = new File(fileName);
			processPage(new FileInputStream(file));
		} catch (IOException | RuntimeException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getGuiMap(String locale) {

		Map<String, String> instanceMap = new HashMap<String, String>();
		List<Object> allObj = getAllObjects();

		for (Object temp : allObj) {
			Map<String, String> map = (Map<String, String>) temp;
			if (map == null) {
				continue;
			}
			String value = map.get(CONTAINER);
			if (value == null) {
			}
			instanceMap.put(map.get(KEY), value);
		}

		return instanceMap;
	}

	/**
	 * The user needs to provide the locale for which data needs to be read. After successfully reading the data from
	 * the input stream, it is placed in the hash map and returned to the users.
	 *
	 * @param containerKey The containerKey to get values
	 * @param locale       Signifies the language or site language to read.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, String> getGuiMapForContainer(String containerKey, String locale) {

		Map<String, String> instanceMap = new HashMap<String, String>();
		List<Object> allObj = getAllObjects();

		for (Object temp : allObj) {
			Map<String, Object> map = (Map<String, Object>) temp;
			if (map == null) {
				continue;
			}

			if (!map.get(KEY).equals(containerKey)) {
				continue;
			}

			// Add child elements of Container
			if (map.containsKey(ELEMENTS)) {
				List<Map<String, String>> elementList = (ArrayList<Map<String, String>>) map.get(ELEMENTS);
				for (Map<String, String> eachElementMap : elementList) {
					String value = eachElementMap.get(locale);
					if (value == null) {
					}
					instanceMap.put(eachElementMap.get(KEY), value);
				}
			} else if (map.containsKey(ELEMENTSv2)) {
				Map<String, Map<String, String>> elementMap = (Map<String, Map<String, String>>) map.get(ELEMENTSv2);
				for (Map.Entry<String, Map<String, String>> eachElement : elementMap.entrySet()) {
					String value = eachElement.getValue().get(locale);
					if (value == null) {

					}
					String key = eachElement.getValue().get(KEY);
					if (key == null) {
						key = eachElement.getKey();
					}
					instanceMap.put(key, value);
				}
			}

		}
		// can this be changed to put try outside the loop

		return instanceMap;
	}

	public void processPage(InputStream resource) throws IOException {
		try (InputStream input = resource) {
			Page page = PageFactory.getPage(input);

			Map<Object, Object> map;
//            map.put(KEY, "pageUrl");
//            map.put(CONTAINER, page.getPageUrl());
//            appendObject(map);

			for (Map.Entry<String, String> eachElement : page.getElements().entrySet()) {
				map = new HashMap<Object, Object>();
				map.put(KEY, eachElement.getKey());
				map.put(CONTAINER, eachElement.getValue());
				appendObject(map);
			}

			setProcessed(true);
			setPage(page);
		} catch (Exception ex) { // NOSONAR
			fail("Please check JSON file! REASON: " + ex.getMessage());
		}
	}
}
