package framework.platform.utilities;

import framework.Settings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVParser
 */
public class CSVparser {

	public List<String> getLinksFromCSV() {
		List<String> links = new ArrayList<>();
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(getClass().getClassLoader().getResource(Settings.config.getLinksList()).getFile()));
			while ((line = br.readLine()) != null) {
				links.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return links;
	}
}
