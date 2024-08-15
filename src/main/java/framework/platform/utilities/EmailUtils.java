package framework.platform.utilities;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import framework.Logger;

/**
 * EmailUtils
 */
public class EmailUtils {

	static String API_BASE_URL = "https://api.mailgun.net/v3/";
	static String DOMAIN = "sandbox90d0c18f25a24172b4f8882a8e9c3e95.mailgun.org";
	static String API_KEY = "key-986b7dadc61e15b7bcea7cef2c0477e1";

	public static String getEmailURL(String recipientEmail) {
		Logger.info("Get email body");
		String url = "";
		try {
			HttpResponse<JsonNode> request = Unirest.get(API_BASE_URL + DOMAIN + "/events")
					.basicAuth("api", API_KEY)
					.queryString("event", "stored")
					.queryString("to", recipientEmail)
					.asJson();

			url = request.getBody().getObject().getJSONArray("items").getJSONObject(0).getJSONObject("storage").getString("url");
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return url;
	}

	public static String getMessageBodyByUrl(String url) {
		Logger.info("Get message body text");
		String messageBodyText = "";
		try {
			HttpResponse<JsonNode> request1 = Unirest.get(url)
					.basicAuth("api", API_KEY)
					.asJson();
			messageBodyText = request1.getBody().getObject().getString("body-plain");
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		return messageBodyText;
	}

	public static String generateRandomMailGunEmailAddress() {
		Logger.info("Generate random email address for mailgun service");
		String email = ("Automation" + StringUtils.generateRandomStrAlphaNumeric(8) + "@" + DOMAIN).toLowerCase();
		Logger.info("Email - " + email);
		return email;
	}
}
