package mayoclinicdiet.pages;

import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MotivateSupportPage extends PublicHeaderMCD {

	public MotivateSupportPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "motivateSupport";
		String CLASS_NAME = "MotivateSupportPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
	}

	protected WebObject articleSections;
	protected WebObject articleSummary;
	protected WebObject articleImages;
	protected WebObject articleTitle;
	protected WebObject articleReadMoreLink;
	protected WebObject breadcrumb;
	protected WebObject slideShowArticle;
	protected WebObject quizPage;
	protected WebObject articleModule;
	protected WebObject articleHeader;
	protected WebObject articleSubText;
	protected WebObject articleImg;
	protected WebObject articleContent;
	protected WebObject articleBreadcrumb;
	private final static String MOTIVATE_SUPPORT_BREADCRUMB = ".column.breadcrumb a[href='/diet/members/motivate/support']";
	private final static String ARTICLE_TITLE_CSS = ".landing-section-link-text.sub1>a";

	public MotivateSupportPage checkMotivateSupportUrl() {
		Logger.info("Check 'Support' page url");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/diet/members/motivate/support"), "URL doesn't contain '/diet/members/motivate/support'");
		return this;
	}

	public MotivateSupportPage checkArticleSectionsOnSupportPage() {
		Logger.info("Check Photo displays with Article headline, a summary of the article content and the link to that article on Support Page");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		articleSections.getElements().forEach(chr -> {
			chr.isDisplayed();
			articleImages.getElements();
			assertTrue(articleImages.isElementPresent(), "The images of the articles are not displayed");
			articleTitle.getElements();
			assertTrue(articleTitle.isElementPresent(), "The titles of the articles are not displayed");
			articleSummary.getElements();
			assertTrue(articleSummary.isElementPresent(), "The summaries of the articles are not displayed");
			articleReadMoreLink.getElements();
			assertTrue(articleReadMoreLink.isElementPresent(), "The 'Read More' link of the articles are not displayed");
		});
		return this;
	}

	public MotivateSupportPage checkSupportBreadcrumb() {
		Logger.info("Check the breadcrumb");
		String breadcrumbs = breadcrumb
				.waitElementsReady()
				.getText();
		assertEquals(breadcrumbs, "HOMEMOTIVATESUPPORT", "The breadcrumb is not correct");
		return this;
	}

	public MotivateSupportPage openArticleFromSupportPage() {
		Logger.info("Check the article page is loaded");
		for (int articleNumber = 0; articleNumber < 3; articleNumber++) {
			basedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement link = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS)).get(articleNumber);
			link.click();
			if (articleContent.isElementPresent()) {
				assertTrue(articleModule.isElementPresent(), "The article module is not displayed correctly");
				clickWithJs(MOTIVATE_SUPPORT_BREADCRUMB);
			} else {
				clickWithJs(MOTIVATE_SUPPORT_BREADCRUMB);
			}
		}
		return this;
	}

	public MotivateSupportPage checkArticleHeaderAndSubTextOnArticleSupportPage() {
		Logger.info("Check the article header and sub-text are displayed");
		for (int articleNumber = 0; articleNumber < 3; articleNumber++) {
			basedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement link = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS)).get(articleNumber);
			link.click();
			if (articleContent.isElementPresent()) {
				assertTrue(articleHeader.isElementPresent(), "The article header is not displayed");
				assertTrue(articleSubText.isElementPresent(), "The article sub text is not displayed");
				clickWithJs(MOTIVATE_SUPPORT_BREADCRUMB);
			} else {
				clickWithJs(MOTIVATE_SUPPORT_BREADCRUMB);
			}
		}
		return this;

	}

	public MotivateSupportPage checkArticleImageOnArticleSupportPage() {
		Logger.info("Check the article image is displayed");
		for (int articleNumber = 0; articleNumber < 3; articleNumber++) {
			basedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement link = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS)).get(articleNumber);
			link.click();
			if (articleContent.isElementPresent()) {
				assertTrue(articleImg.isElementPresent(), "The article image is not displayed");
				clickWithJs(MOTIVATE_SUPPORT_BREADCRUMB);
			} else {
				clickWithJs(MOTIVATE_SUPPORT_BREADCRUMB);
			}
		}
		return this;
	}

	public MotivateSupportPage checkArticleContentOnArticleSupportPage() {
		Logger.info("Check the article content is displayed");
		basedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for (int articleNumber = 0; articleNumber < 3; articleNumber++) {
			basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS)).get(articleNumber).click();
			if (slideShowArticle.isElementPresent()) {
				clickWithJs(MOTIVATE_SUPPORT_BREADCRUMB);
			} else if (quizPage.isElementPresent()) {
				clickWithJs(MOTIVATE_SUPPORT_BREADCRUMB);
			} else {
				assertTrue(articleContent.isElementPresent(), "The article content is not displayed");
				clickWithJs(MOTIVATE_SUPPORT_BREADCRUMB);
			}
		}
		return this;
	}

	public MotivateSupportPage checkArticleBreadcrumbOnArticleSupportPage() {
		Logger.info("Check the article breadcrumb is displayed");
		for (int articleNumber = 0; articleNumber < 3; articleNumber++) {
			basedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement link = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS)).get(articleNumber);
			link.click();
			if (articleContent.isElementPresent()) {
				assertTrue(articleBreadcrumb.isElementPresent(), "The article breadcrumb is not displayed");
				clickWithJs(MOTIVATE_SUPPORT_BREADCRUMB);
			} else {
				clickWithJs(MOTIVATE_SUPPORT_BREADCRUMB);
			}
		}
		return this;
	}
}
