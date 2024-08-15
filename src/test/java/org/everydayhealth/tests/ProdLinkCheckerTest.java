package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import framework.Logger;
import framework.platform.utilities.CSVparser;
import jlibs.core.lang.Ansi;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static org.testng.Assert.fail;

/**
 * ProdLinkCheckerTest
 */
public class ProdLinkCheckerTest {

	private static Ansi ansiOut = new Ansi(Ansi.Attribute.BRIGHT, Ansi.Color.GREEN, Ansi.Color.WHITE);
	private static Ansi ansiErr = new Ansi(Ansi.Attribute.BRIGHT, Ansi.Color.RED, Ansi.Color.WHITE);

	@Test(groups = {"verifyProdUrls"})
	@TestRail(id = "verifyProdUrls")
	public void verifyProdURLSResponseCodes() {
		List<String> links = new CSVparser().getLinksFromCSV();
		int linksCount = links.size();
		int totalCounter = 1;
		int errorCounter = 0;
		for (String line : links) {
			try {
				String URL = line.split(",")[0];
				String template = line.split(",")[1];
				Logger.info("URL Number: " + totalCounter);
				Logger.info("Verifying page: " + URL + ". Template - " + template);
				totalCounter++;

				HttpURLConnection connection = (HttpURLConnection) new URL(URL).openConnection();
				int status = connection.getResponseCode();
				if (status == HttpURLConnection.HTTP_BAD_REQUEST || status == HttpURLConnection.HTTP_FORBIDDEN || status == HttpURLConnection.HTTP_NOT_FOUND) {
					ansiErr.outln("CLIENT ERROR. CODE: " + status);
					errorCounter++;
				} else if (status == HttpURLConnection.HTTP_INTERNAL_ERROR || status == HttpURLConnection.HTTP_UNAVAILABLE || status == HttpURLConnection.HTTP_BAD_GATEWAY) {
					ansiErr.outln("SERVER ERROR. CODE: " + status);
					errorCounter++;
				} else if (status == HttpURLConnection.HTTP_OK) {
					ansiOut.outln("RESPONSE CODE IS 200");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("-----------------------------------");
		Logger.info("Summary is as follows:");
		Logger.info("Total amount of links checked: " + linksCount);
		Logger.info("Error counter: " + errorCounter);
		if (errorCounter > 0) {
			fail("Some pages did not respond with 200.");
		}
	}
}
