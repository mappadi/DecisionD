package framework.platform.utilities;

import framework.platform.DatePatterns;

import java.util.List;

/**
 * ContentData
 */
public class ContentData {

	private List<MediaData> mediaData;
	private String headline;
	private String lastUpdated;
	private String deck;


	public String getLastUpdated() {
		if (lastUpdated.isEmpty() || lastUpdated.equals("null")) {
			return "null";
		}
		try {
			return DateUtils.parseDateFromString(lastUpdated, DatePatterns.MM_dd_yyyy_HH_mm_ss_PM).toString();
		} catch (Exception e) {
			try {
				return DateUtils.parseDateFromString(lastUpdated, DatePatterns.MM_dd_yyyy_HH_mm_ss).toString();
			} catch (Exception ex) {
				return DateUtils.parseDateFromString(lastUpdated, DatePatterns.MM_dd_yyyy_HH_mm_sss).toString();
			}
		}
	}

	public List<MediaData> getMediaData() {
		return mediaData;
	}

	public void addMedia(MediaData mediaAttributes) {
		mediaData.add(mediaAttributes);
	}

	public String getHeadline() {
		if (headline == null || headline.isEmpty()) {
			return "null";
		}
		return headline.replaceAll("\\|"," ").replaceAll("\\n","");
	}
	
	/*public String getSortOrder() {
		return sortorder;
	}*/

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setMediaData(List<MediaData> mediaData) {
		this.mediaData = mediaData;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getDeck() {
		return deck.replaceAll("\\|","").replaceAll("\\n","");
	}

	public void setDeck(String deck) {
		this.deck = deck;
	}
	
	/*public void setSortOrder(String sortorder) {
		this.sortorder = sortorder;
	}*/

}
