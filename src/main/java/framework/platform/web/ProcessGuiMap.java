package framework.platform.web;

import java.io.IOException;
import java.io.InputStream;

public interface ProcessGuiMap {
	/**
	 * @return - <code>true</code> if the processing of {@link FileSystemResource} was successful.
	 */
	boolean processed();

	/**
	 * Process a file represented by {@link FileSystemResource}
	 *
	 * @param resource - A {@link FileSystemResource} object.
	 * @throws IOException
	 */
	void processPage(InputStream resource) throws IOException;
}
