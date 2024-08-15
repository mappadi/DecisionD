package framework.platform.web;

import framework.Settings;

import java.io.IOException;

public class GuiMapReaderFactory {
	static Settings settings = new Settings();

	public static GuiMapReader getInstance(String pageDomain, String pageClassName) throws IOException {
		GuiMapReader dataProvider = null;
		String rawDataFile = null;
		String guiDataDir = settings.getGuiElementsPath();
		String pathToJson = null;
		if (pageDomain.isEmpty()) {
			pathToJson = pageClassName;
		} else {
			pathToJson = pageDomain + "/" + pageClassName;
		}
		if (!Settings.isDesktop()) {
			rawDataFile = guiDataDir.toLowerCase() + "/mobile/" + pathToJson;
		} else {
			rawDataFile = guiDataDir.toLowerCase() + "/main/" + pathToJson;
		}
		String jsonFile = rawDataFile + ".json";
		dataProvider = JsonReaderFactory.createInstance(jsonFile);
		return dataProvider;
	}
}
