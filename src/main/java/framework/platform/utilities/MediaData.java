package framework.platform.utilities;

import java.util.List;

/**
 * ContentData
 */
public class MediaData {

	private String mediaTag;
	private String type;
	private List<MediaAttributes> attributes;

	public String getType() {
		return type;
	}

	public String getMediaTag() {
		return mediaTag;
	}

	public List<MediaAttributes> getAttributes() {
		return attributes;
	}

	public String getAttributeValue(String key) {
		for (MediaAttributes attribute : attributes) {
			if (attribute.getKey().equals(key)) {
				return attribute.getValue();
			}
		}
		return "";
	}

	public void addAttributes(MediaAttributes mediaAttributes) {
		attributes.add(mediaAttributes);
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setMediaTag(String mediaTag) {
		this.mediaTag = mediaTag;
	}

	public void setAttributes(List<MediaAttributes> attributes) {
		this.attributes = attributes;
	}


	public boolean contains(MediaAttributes mediaAttributes) {
		for (MediaAttributes attribute : attributes) {
			if (attribute.getKey().equals(mediaAttributes.getKey()) && attribute.getValue().equals(mediaAttributes.getValue())) {
				return true;
			}
		}
		return false;
	}

}
