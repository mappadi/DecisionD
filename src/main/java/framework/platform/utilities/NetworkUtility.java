package framework.platform.utilities;

import static org.testng.Assert.fail;
import framework.Logger;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class NetworkUtility {

	public static boolean testResponseCode(String url) {
		try {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection con;
			con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod("HEAD");
			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			fail("The test method testFrontEnd failed -- Malformed URL " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			fail("The test method testFrontEnd failed " + e.getMessage());
		}

		return false;

	}
	
	public static URLConnection openURLConnection(String url) {
		Logger.info("Opening a connection to: " + url);
		try {
			return new URL(url).openConnection();
		} catch (Exception e) {
			e.printStackTrace();
			fail("The URL connection failed: " +e.getMessage());
			return null;
		}
	}
	
	public static Document parseXML(URLConnection connection) {
		DocumentBuilderFactory objDocumentBuilderFactory = null;
		DocumentBuilder objDocumentBuilder = null;
		Document doc = null;
		
		try {
			objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
			objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();
			doc = objDocumentBuilder.parse(connection.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			fail("The method failed to parse XML input stream " + e.getMessage());
		}
		return doc;
	}

}
