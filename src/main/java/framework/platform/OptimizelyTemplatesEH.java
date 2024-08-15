package framework.platform;


public enum OptimizelyTemplatesEH {

	TEMPLATE2("/lifestyle/beauty/"),
	TEMPLATE3("/type-2-diabetes/2/"),
	TEMPLATE4("/gallbladder/guide/symptoms/");

	private String url;
	
	OptimizelyTemplatesEH(String url) {
		this.url = url;
	}
	
	public String getOptimizelyTemplateURL() {
		return url;
	}
}
