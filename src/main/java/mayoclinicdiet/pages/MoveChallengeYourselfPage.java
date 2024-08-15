package mayoclinicdiet.pages;

import framework.BrowserType;
import framework.Logger;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MoveChallengeYourselfPage extends PublicHeaderMCD {

	public MoveChallengeYourselfPage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "challengeYourself";
		String CLASS_NAME = "MoveChallengeYourselfPage";
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
	protected WebObject firstSlide;
	protected WebObject firstSlideImage;
	protected WebObject firstSlideText;
	protected WebObject thumbnails;
	protected WebObject slidesQuantity;
	protected WebObject prevArrow;
	protected WebObject nextArrow;
	protected WebObject backwardArrowDisable;
	protected WebObject forwardArrowOrange;
	protected WebObject backwardArrowOrange;
	protected WebObject forwardArrowDisable;
	private final static String CHALLENGE_YOURSELF_BREADCRUMB = ".column.breadcrumb a[href='/diet/members/move/challenge-yourself']";
	private final static String ARTICLE_NAME = "10 exercise barriers: Tips to overcome them";
	private final static String SLIDES_COUNT = ".bx-pager-spec-wrapper .bx-pager-li .bxslide-img";
	private final static String ARTICLE_TITLE_CSS = ".landing-section-link-text.sub1>a";

	public MoveChallengeYourselfPage checkChallengeYourselfUrl() {
		Logger.info("Check 'Challenge Yourself' page url");
		basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String currentUrl = basedriver.getCurrentUrl();
		assertTrue(currentUrl.contains("/diet/members/move/challenge-yourself"), "URL doesn't contain '/diet/members/move/challenge-yourself'");
		return this;
	}

	public MoveChallengeYourselfPage checkArticleSectionsOnChallengeYourselfPage() {
		Logger.info("Check Photo displays with Article headline, a summary of the article content and the link to that article on Challenge Yourself Page");
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

	public MoveChallengeYourselfPage checkMoveChallengeYourselfBreadcrumb() {
		Logger.info("Check the breadcrumb");
		String breadcrumbs = breadcrumb
				.waitElementsReady()
				.getText();
		assertEquals(breadcrumbs, "HOMEMOVECHALLENGE YOURSELF", "The breadcrumb is not correct");
		return this;
	}

	public MoveChallengeYourselfPage openArticleFromChallengeYourselfPage() {
		Logger.info("Check the article page is loaded");
		for (int articleNumber = 0; articleNumber < 3; articleNumber++) {
			basedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement link = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS)).get(articleNumber);
			link.click();
			if (articleContent.isElementPresent()) {
				assertTrue(articleModule.isElementPresent(), "The article module is not displayed correctly");
				clickWithJs(CHALLENGE_YOURSELF_BREADCRUMB);
			} else {
				clickWithJs(CHALLENGE_YOURSELF_BREADCRUMB);
			}
		}
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public MoveChallengeYourselfPage checkArticleHeaderAndSubTextOnArticleChallengeYourselfPage() {
		Logger.info("Check the article header and sub-text are displayed");
		for (int articleNumber = 0; articleNumber < 3; articleNumber++) {
			basedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement link = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS)).get(articleNumber);
			link.click();
			if (articleContent.isElementPresent()) {
				assertTrue(articleHeader.isElementPresent(), "The article header is not displayed");
				assertTrue(articleSubText.isElementPresent(), "The article sub text is not displayed");
				clickWithJs(CHALLENGE_YOURSELF_BREADCRUMB);
			} else {
				clickWithJs(CHALLENGE_YOURSELF_BREADCRUMB);
			}
		}
		return this;
	}

	public MoveChallengeYourselfPage checkArticleImageOnArticleChallengeYourselfPage() {
		Logger.info("Check the article image is displayed");
		for (int articleNumber = 0; articleNumber < 3; articleNumber++) {
			basedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement link = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS)).get(articleNumber);
			link.click();
			if (articleContent.isElementPresent()) {
				assertTrue(articleImg.isElementPresent(), "The article image is not displayed");
				clickWithJs(CHALLENGE_YOURSELF_BREADCRUMB);
			} else {
				clickWithJs(CHALLENGE_YOURSELF_BREADCRUMB);
			}
		}
		return this;
	}

	public MoveChallengeYourselfPage checkArticleContentOnArticleChallengeYourselfPage() {
		Logger.info("Check the article content is displayed");
		basedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		for (int articleNumber = 0; articleNumber < 3; articleNumber++) {
			basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS)).get(articleNumber).click();
			if (slideShowArticle.isElementPresent()) {
				clickWithJs(CHALLENGE_YOURSELF_BREADCRUMB);
			} else if (quizPage.isElementPresent()) {
				clickWithJs(CHALLENGE_YOURSELF_BREADCRUMB);
			} else {
				assertTrue(articleContent.isElementPresent(), "The article content is not displayed");
				clickWithJs(CHALLENGE_YOURSELF_BREADCRUMB);
			}
		}
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public MoveChallengeYourselfPage checkArticleBreadcrumbOnArticleChallengeYourselfPage() {
		Logger.info("Check the article breadcrumb is displayed");
		for (int articleNumber = 0; articleNumber < 3; articleNumber++) {
			basedriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement link = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS)).get(articleNumber);
			link.click();
			if (articleContent.isElementPresent()) {
				assertTrue(articleBreadcrumb.isElementPresent(), "The article breadcrumb is not displayed");
				clickWithJs(CHALLENGE_YOURSELF_BREADCRUMB);
			} else {
				clickWithJs(CHALLENGE_YOURSELF_BREADCRUMB);
			}
		}
		return this;
	}

	public MoveChallengeYourselfPage openSlideShowFromChallengeYourselfPage() {
		Logger.info("Check the slide show page is loaded");
		basedriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> article = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS));
		for (int articleNumber = 0; articleNumber < article.size(); articleNumber++) {
			String articleTitle = article.get(articleNumber).getText();
			if (articleTitle.equals(ARTICLE_NAME)) {
				WebElement articleName = basedriver.findElement(By.linkText(ARTICLE_NAME));
				((JavascriptExecutor) basedriver).executeScript("arguments[0].scrollIntoView(true);", articleName);
				articleName.click();
				basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				assertTrue(articleModule.isElementPresent(), "The slide show page is not displayed correctly");
				break;
			}
		}
		return this;
	}

	public MoveChallengeYourselfPage checkSlideShowHeaderAndSubTextFromChallengeYourselfPage() {
		Logger.info("Check the slide show header and sub-text are displayed");
		basedriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> article = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS));
		for (int articleNumber = 0; articleNumber < article.size(); articleNumber++) {
			String articleTitle = article.get(articleNumber).getText();
			if (articleTitle.equals(ARTICLE_NAME)) {
				WebElement articleName = basedriver.findElement(By.linkText(ARTICLE_NAME));
				((JavascriptExecutor) basedriver).executeScript("arguments[0].scrollIntoView(true);", articleName);
				articleName.click();
				basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				assertTrue(articleHeader.isElementPresent(), "The slide show header is not displayed correctly");
				assertTrue(articleSubText.isElementPresent(), "The slide show sub text is not displayed correctly");
				break;
			}
		}
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public MoveChallengeYourselfPage checkSlideShowContentFromChallengeYourselfPage() {
		Logger.info("Check the slide is displayed correctly");
		basedriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> article = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS));
		for (int articleNumber = 0; articleNumber < article.size(); articleNumber++) {
			String articleTitle = article.get(articleNumber).getText();
			if (articleTitle.equals(ARTICLE_NAME)) {
				WebElement articleName = basedriver.findElement(By.linkText(ARTICLE_NAME));
				((JavascriptExecutor) basedriver).executeScript("arguments[0].scrollIntoView(true);", articleName);
				articleName.click();
				basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				assertTrue(firstSlide.isElementPresent(), "The first slide is not displayed");
				if (BrowserType.IE == null) {
					assertEquals(firstSlide.getAttribute("style"), "list-style: none; width: 660px; float: left; position: relative;", "The style of slide is not correct");
				}
				if (BrowserType.FIREFOX == null) {
					assertEquals(firstSlide.getAttribute("style"), "float: left; list-style: outside none none; position: relative; width: 660px;", "The style of slide is not correct");
				}
				if (BrowserType.CHROME == null) {
					assertEquals(firstSlide.getAttribute("style"), "float: left; list-style: none; position: relative; width: 660px;", "The style of slide is not correct");
				}
				assertTrue(firstSlideImage.isElementPresent(), "The first slide image is not displayed");
				assertTrue(firstSlideText.isElementPresent(), "The first slide text is not displayed");
				break;
			}
		}
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public MoveChallengeYourselfPage checkSlideShowBreadcrumbFromChallengeYourselfPage() {
		Logger.info("Check the slide show page breadcrumb");
		basedriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> article = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS));
		for (int articleNumber = 0; articleNumber < article.size(); articleNumber++) {
			String articleTitle = article.get(articleNumber).getText();
			if (articleTitle.equals(ARTICLE_NAME)) {
				WebElement articleName = basedriver.findElement(By.linkText(ARTICLE_NAME));
				((JavascriptExecutor) basedriver).executeScript("arguments[0].scrollIntoView(true);", articleName);
				articleName.click();
				basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				assertTrue(articleBreadcrumb.isElementPresent(), "The slide show breadcrumb is not displayed");
				break;
			}
		}
		return this;
	}

	public MoveChallengeYourselfPage checkSlideShowThumbnailsFromChallengeYourselfPage() {
		Logger.info("Check the slide show page thumbnails along with forward and backward arrows for navigation are displayed ");
		basedriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> article = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS));
		for (int articleNumber = 0; articleNumber < article.size(); articleNumber++) {
			String articleTitle = article.get(articleNumber).getText();
			if (articleTitle.equals(ARTICLE_NAME)) {
				WebElement articleName = basedriver.findElement(By.linkText(ARTICLE_NAME));
				((JavascriptExecutor) basedriver).executeScript("arguments[0].scrollIntoView(true);", articleName);
				articleName.click();
				basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				String slides = slidesQuantity.getText();
				assertTrue(thumbnails.isElementPresent(), "The thumbnails are not displayed");
				Integer slidesCount = basedriver.findElements(By.cssSelector(SLIDES_COUNT)).size();
				assertEquals(slides, slidesCount.toString(), "Thumbnails are not displayed for each slide in the slideshow");
				assertTrue(prevArrow.isElementPresent(), "The backward arrow is not displayed");
				assertTrue(nextArrow.isElementPresent(), "The forward arrow is not displayed");
				break;
			}
		}
		waitForAjaxRequestToBeFinished();
		return this;
	}

	public MoveChallengeYourselfPage checkSlideShowNavigationArrowsFromChallengeYourselfPage() {
		Logger.info("Check Navigation Arrows in the Slide Show Page.");
		basedriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		List<WebElement> article = basedriver.findElements(By.cssSelector(ARTICLE_TITLE_CSS));
		for (int articleNumber = 0; articleNumber < article.size(); articleNumber++) {
			String articleTitle = article.get(articleNumber).getText();
			if (articleTitle.equals(ARTICLE_NAME)) {
				WebElement articleName = basedriver.findElement(By.linkText(ARTICLE_NAME));
				((JavascriptExecutor) basedriver).executeScript("arguments[0].scrollIntoView(true);", articleName);
				articleName.click();
				basedriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				assertTrue(backwardArrowDisable.isElementPresent(), "The slide show backward arrow is not disable and Grey for the first slide");
				assertTrue(forwardArrowOrange.isElementPresent(), "The slide show forward arrow is not enable and Orange correctly for the first slide");
				List<WebElement> slides = basedriver.findElements(By.cssSelector(SLIDES_COUNT));
				for (int slideNumber = 0; slideNumber < slides.size(); slideNumber++) {
					waitFor(1000);
					forwardArrowOrange.click();
				}
				assertTrue(backwardArrowOrange.isElementPresent(), "The slide show backward arrow is not enable and Orange for the last slide");
				assertTrue(forwardArrowDisable.isElementPresent(), "The slide show forward arrow is not disable and Grey correctly for the last slide");
				break;
			}
		}
		waitForAjaxRequestToBeFinished();
		return this;
	}
}
