package framework.platform.web;

import java.util.Map;

public interface GuiMapReader {
	String KEY = "Key";
	String CONTAINER = "Container";
	String ELEMENTS = "Elements";
	String ELEMENTSv2 = "containerElements";

	Map<String, String> getGuiMap(String locale);

	Map<String, String> getGuiMapForContainer(String containerKey, String locale);
}
