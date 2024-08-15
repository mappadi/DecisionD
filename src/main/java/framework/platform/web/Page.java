package framework.platform.web;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Page {
	private Map<String, String> elements = new HashMap<String, String>();

	public void setElements(Map<String, String> elements) {
		this.elements = new HashMap<String, String>();
		this.elements.putAll(elements);
	}

	public Map<String, String> getElements() {
		return Collections.unmodifiableMap(this.elements);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("elements: ").append(this.elements.size()).append("\n");
		return sb.toString();
	}
}
