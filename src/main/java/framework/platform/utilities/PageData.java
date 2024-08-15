package framework.platform.utilities;

/**
 * PageData
 */
public class PageData {

	private String productID;
	private String id;
	private String type;
	private String productName;
	private String url;
	private ContentData contentData;
	private String rnk;
	//private String sortorder;
	private String adZone;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRnk() {
		return rnk;
	}

	public void setRnk(String rnk) {
		this.rnk = rnk;
	}

	public ContentData getContentData() {
		return contentData;
	}

	public void setContentData(ContentData contentData) {
		this.contentData = contentData;
	}

	public String getProductID() {
		return productID;
	}

	public String getType() {
		return type;
	}

	public String getProductName() {
		return productName;
	}

	public String getUrl() {
		return url;
	}
	
	public String getAdZone() {
		if (adZone.isEmpty()) {
			adZone = "null";
		}
		return adZone;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setAdZone(String adZone) {
		this.adZone = adZone;
	}

}
