package framework.platform.web;

import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * A simple factory of {@link Page} objects
 */
public class PageFactory {
	protected static Gson jsonParser = new Gson();

	private PageFactory() {
		// Utility class. So hide the constructor
	}

	/**
	 * Creates a instance of a {@link Page}.
	 */
	static Page getPage(InputStream in) throws IOException {
		String jsonTxt = IOUtils.toString(in, Charset.defaultCharset());
		Page page = jsonParser.fromJson(jsonTxt, Page.class);

		try {
			in.close();
		} catch (IOException e) {
			// NOSONAR Do Nothing
		}

		return page;
	}
}
