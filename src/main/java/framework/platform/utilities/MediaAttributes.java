package framework.platform.utilities;

/**
 * MediaAttributes
 */
public class MediaAttributes {

	private String value;
	private String key;

	public String getValue() {
		if (!value.isEmpty()) {
			return value.replaceAll(" \\| ", " ").replaceAll(" \\|", " ");
		} else {
			return "null";
		}
	}

	public String getKey() {
		return key;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
