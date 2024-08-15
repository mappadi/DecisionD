package framework.platform.utilities;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.testng.Assert.assertEquals;

/**
 * CouchbaseUtils
 */
public class CouchbaseUtils {

	public Map<String, PageData> getData() {
		WebDriverManager.getDriver().get(Settings.getCouchbaseUrl());
		CouchbaseEnvironment env = DefaultCouchbaseEnvironment.builder()
				.queryPort(8091)
				.connectTimeout(1000000).disconnectTimeout(1000000).managementTimeout(1000000).queryTimeout(1000000).socketConnectTimeout(1000000)
				.queryEnabled(true)
				.build();
		String ip;
		Logger.info("Creating cluster");
		Cluster cluster = CouchbaseCluster.create(env, Settings.getCouchbaseUrl().split("@")[1].split(":")[0]);
		cluster.clusterManager("Administrator", "waterfront");//use this for other environments
		Logger.info("End of  cluster");
		
		Bucket bucket = cluster.openBucket("EH");
		Map<String, PageData> list = new TreeMap<>();
		try {
			JSONArray msg = new JSONArray(WebDriverManager.getDriver().findElement(By.xpath("//body")).getText().split("\"rows\":")[1]);

			int jobNumber = 0;
//msg.length()

			while (jobNumber < msg.length()) {
				//System.out.println(jobNumber);
				JSONObject object = (JSONObject) msg.get(jobNumber);
				String id = object.getString("id");
				jobNumber++;
				PageData pageData = new PageData();
				ContentData contentData = new ContentData();

				List<MediaData> mediaDatas = new ArrayList<>();

				JsonObject jsonObject = bucket.get(id).content();
				String productId = jsonObject.get("productID").toString();

				pageData.setProductID(productId);
				pageData.setType(jsonObject.get("contentType").toString());
				pageData.setProductName(jsonObject.get("productName").toString());
				String deck = jsonObject.getObject("content").get("deck").toString();
				if (deck.isEmpty()) {
					deck = "null";
				}
				contentData.setDeck(deck);
				String url = jsonObject.get("url").toString();
				pageData.setUrl(url);
				pageData.setId(id);
				/*if (jsonObject.get("adZone") != null) {
					pageData.setAdZone(jsonObject.get("adZone").toString());
				}
				else {
					//Logger.info("adzone is missing for " + url);
				}*/
				//Logger.info("URL is " +url);
				try {
					String adZone = jsonObject.get("adZone").toString();
					pageData.setAdZone(adZone);
				} catch (Exception e) {
					pageData.setAdZone("null");
				}
				//Logger.info("Value of AdZone is " + jsonObject.get("adZone").toString());

				if (!Settings.config.isWordPress()) {
					try {
						assertEquals(id.replaceAll("PageMetaData_", "").toLowerCase(), StringUtils.convertToSha1Hash(url).toLowerCase(), "Sha1 encoding incorrect for page " + url);
					} catch (AssertionError e) {
						WebDriverManager.getDriver().get("http://passwordsgenerator.net/sha1-hash-generator/");
						WebDriverManager.getDriver().findElement(By.id("txt1")).sendKeys(url);
						Utils.waitFor(500);
						String text = WebDriverManager.getDriver().findElement(By.id("txt2")).getAttribute("value");
						if (!text.equalsIgnoreCase(id.replaceAll("PageMetaData_", ""))) {
							Logger.err("Error message is " + e.getLocalizedMessage());
							Logger.err("URL is " + url);
						}
					}
				}
				contentData.setLastUpdated(jsonObject.getObject("content").get("lastUpdated").toString());
				contentData.setHeadline(jsonObject.getObject("content").get("headline").toString().replaceAll(" \\| ", " "));
				if ((!jsonObject.getObject("content").toString().contains("\"media\":null")) && (!jsonObject.getObject("content").toString().contains("\"media\":[]"))) {
					String media = jsonObject.getObject("content").get("media").toString();
					for (int start = 0; start < jsonObject.getObject("content").getArray("media").size(); start++) {

						JSONArray mediaJson = new JSONArray(media);
						JSONObject objectJson = (JSONObject) mediaJson.get(start);
						String type = objectJson.get("type").toString();
						String tag = objectJson.get("mediaTag").toString();

						List<MediaAttributes> attributesList = new ArrayList<>();
						JSONArray attributeJson = objectJson.getJSONArray("attributes");

						boolean add = true;
						int mediaNumber = 0;
						for (int tryNumber = 0; tryNumber < mediaDatas.size(); tryNumber++) {
							if (mediaDatas.get(tryNumber).getMediaTag().equals(tag) && mediaDatas.get(tryNumber).getType().equals(type)) {
								add = false;
								mediaNumber = tryNumber;
							}
						}

						if (add) {
							MediaData mediaData = new MediaData();
							mediaData.setMediaTag(tag);
							mediaData.setType(type);
							for (int i = 0; i < attributeJson.length(); i++) {
								objectJson = (JSONObject) attributeJson.get(i);
								MediaAttributes mediaAttributes = new MediaAttributes();
								mediaAttributes.setKey(objectJson.getString("key"));
								mediaAttributes.setValue(objectJson.getString("value"));
								attributesList.add(mediaAttributes);
							}

							mediaData.setAttributes(attributesList);
							mediaDatas.add(mediaData);
						} else {
							for (int i = 0; i < attributeJson.length(); i++) {
								objectJson = (JSONObject) attributeJson.get(i);
								MediaAttributes mediaAttributes = new MediaAttributes();
								mediaAttributes.setKey(objectJson.getString("key"));
								mediaAttributes.setValue(objectJson.getString("value"));
								mediaDatas.get(mediaNumber).getAttributes().add(mediaAttributes);
								//attributesList.add(mediaAttributes);
							}

						}

					}
				}

				//if (attributesList.size() == 0) {
				//	attributesList.add(new MediaAttributes());
				//}
				//if (mediaDatas.size() == 0) {
				//	mediaDatas.add(new MediaData());
				//}

				contentData.setMediaData(mediaDatas);
				pageData.setContentData(contentData);

				list.put(pageData.getProductID() + url, pageData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
