package framework.platform.web;

import java.io.IOException;

public class JsonReaderFactory {

	public static AbstractJsonReader createInstance(String fileName) throws IOException {
		return new JsonReader(fileName);
	}
}
