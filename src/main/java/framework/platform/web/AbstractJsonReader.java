package framework.platform.web;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractJsonReader implements GuiMapReader, ProcessGuiMap {
	private Page pageJson;
	private boolean processed = false;

	private List<Object> allObjects = new ArrayList<Object>();

	final void setPage(Page page) {
		this.pageJson = page;
	}

	final void appendObject(Object obj) {
		allObjects.add(obj);
	}

	final void setAllObjects(List<Object> allObjects) {
		this.allObjects.addAll(allObjects);
	}

	final List<Object> getAllObjects() {
		List<Object> objects = new ArrayList<Object>();
		objects.addAll(this.allObjects);
		return objects;
	}

	@Override
	public boolean processed() {
		return processed;
	}

	final void setProcessed(boolean flag) {
		processed = flag;
	}
}
