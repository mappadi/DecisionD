package mayoclinicdiet.pages;

import org.openqa.selenium.WebDriver;

public class ArticlePage extends PublicHeaderMCD {


	public ArticlePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "article";
		String CLASS_NAME = "ArticlePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}


}
