package framework.platform.utilities;

import framework.Logger;
import framework.Settings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * TextUtils
 */
public class TextUtils {


	public static Map<String, PageData> getPageData() {
		BufferedReader read = null;
		String filename = Settings.config.getTxtPath();
		Map<String, PageData> pageDataList = new TreeMap<>();

		try {
			read = new BufferedReader(new FileReader(filename));
			String line;
			int start = 0;
			int lineNumber = 0;
			while ((line = read.readLine()) != null) {
				//Logger.info("Line number: " + start);
				line = line.replaceAll("\\|\\|\\|\\|", "||null||");
				line = line.replaceAll("\\|\\|\\|\\|", "||null||");
				line = line.replaceAll(" \\| ", " ");
				line = line.replaceAll(" \\|T", " T");
				/*Logger.debug("Index: " + line.lastIndexOf("||"));
				Logger.debug("length: " + line.length());*/
				if (line.lastIndexOf("||") == line.length() - 2) {
					line = line + "null";
				}

				StringTokenizer st = new StringTokenizer(line, "||");
				//for (String s : line.split("\\|\\|")) {
				//Logger.debug("VALUE: " + s);
				//}

				start++;
				List<MediaAttributes> mediaAttributes = new ArrayList<>();
				List<MediaData> mediaDatas = new ArrayList<>();

				while (st.hasMoreTokens()) {
					lineNumber++;
					String url = "";

					try {
						PageData pageData = new PageData();
						MediaData mediaData = new MediaData();
						ContentData contentData = new ContentData();
						MediaAttributes attributes = new MediaAttributes();
						if (!Settings.config.isWordPress()) {
							st.nextToken(); //Skip page ID
						}
						String productId = st.nextToken();
						url = st.nextToken();
						if (!pageDataList.containsKey(productId + url)) {
							pageData.setProductID(productId);
							pageData.setUrl(url);
							contentData.setHeadline(st.nextToken());
							contentData.setDeck(st.nextToken());
							pageData.setType(st.nextToken());
							contentData.setLastUpdated(st.nextToken());
							String mediaTag = st.nextToken();
							String type = st.nextToken();
							String key = st.nextToken();
							String value = st.nextToken();

							mediaData.setMediaTag(mediaTag);
							mediaData.setType(type);
							attributes.setKey(key);
							attributes.setValue(value);
							pageData.setProductName(st.nextToken());

							if (!Settings.config.isWordPress()) {
								pageData.setRnk(st.nextToken());
							}


							mediaAttributes.add(attributes);
							mediaData.setAttributes(mediaAttributes);

							if (!mediaData.getType().equals("null")) {
								mediaDatas.add(mediaData);
							}
							if (!Settings.config.isWordPress()) {
								pageData.setAdZone(st.nextToken());
							}
							contentData.setMediaData(mediaDatas);
							pageData.setContentData(contentData);
						} else {
							st.nextToken();
							st.nextToken();
							st.nextToken();
							st.nextToken();


							String tag = st.nextToken();
							String type = st.nextToken();
							String key = st.nextToken();
							String value = st.nextToken();
							st.nextToken(); //Product
							if (!Settings.config.isWordPress()) {
								pageData.setRnk(st.nextToken());
								String adZone = st.nextToken();
							}
							pageData = pageDataList.get(url);
							boolean isPresent = false;
							int dataNumber = 0;
							for (MediaData mediaData1 : pageDataList.get(productId + url).getContentData().getMediaData()) {
								if (mediaData1.getMediaTag().equals(tag) && mediaData1.getType().equals(type)) {
									//for (MediaAttributes att : pageDataList.get(productId + url).getContentData().getMediaData().get(dataNumber).getAttributes()) {

									//if ((!att.getValue().equals(value)) && (!att.getKey().equals(key))) {
									MediaAttributes mediaAttributes1 = new MediaAttributes();
									mediaAttributes1.setKey(key);
									mediaAttributes1.setValue(value);

									pageDataList.get(productId + url).getContentData().getMediaData().get(dataNumber).addAttributes(mediaAttributes1);

									isPresent = true;
									//}
									//}
								}
								dataNumber++;
							}

							if (!isPresent) {
								MediaData mediaData2 = new MediaData();
								mediaData2.setType(type);
								mediaData2.setMediaTag(tag);

								MediaAttributes mediaAttributes1 = new MediaAttributes();
								mediaAttributes1.setKey(key);
								mediaAttributes1.setValue(value);
								mediaAttributes.add(mediaAttributes1);
								mediaData2.setAttributes(mediaAttributes);

								if (!mediaData2.getType().equals("null")) {
									pageDataList.get(productId + url).getContentData().addMedia(mediaData2);
								}
								break;
							}

						}

						if (pageData != null) {
							pageDataList.put(pageData.getProductID() + pageData.getUrl(), pageData);
						}
					} catch (Exception e) {
						//e.printStackTrace();
						Logger.err("Line Number " + lineNumber + " has an error " + e.getLocalizedMessage() + " : " + url);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pageDataList;
	}

}
