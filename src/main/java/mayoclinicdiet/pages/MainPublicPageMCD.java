package mayoclinicdiet.pages;


import framework.BrowserType;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.html.WebObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MainPublicPageMCD extends PublicHeaderMCD {

	public MainPublicPageMCD(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "mainpublicpage";
		String CLASS_NAME = "MainPublicPage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject signInLink;
	protected WebObject globalHeader;
	protected WebObject navigationBar;
	protected WebObject registerNowLink;
	protected WebObject theExpertsLink;
	protected WebObject howItWorksLink;
	protected WebObject successStoriesLink;
	protected WebObject recipesLink;
	protected WebObject sampleMealPlanLink;
	protected WebObject diagnosticSection;
	protected WebObject getTheFreeNewsletter;
	protected WebObject ageFieldInDiagnosticSection;
	protected WebObject heightFeetFieldInDiagnosticSection;
	protected WebObject heightInchFieldInDiagnosticSection;
	protected WebObject weightFieldInDiagnosticSection;
	protected WebObject goalWeightFieldInDiagnosticSection;
	protected WebObject genderRadioButtonsInDiagnosticSection;
	protected WebObject emailInputFieldInDiagnosticSection;
	protected WebObject startFreeButtonInDiagnosticSection;
	protected WebObject footer;
	protected WebObject footerLinks;
	protected WebObject footerTextBlock;
	protected WebObject ehLogo;
	protected WebObject footerTextContainer;

	public LoginPage openSignInPage() {
		Logger.info("Click 'Sign In' link");
		WebDriverManager.getDriver().manage().window().setSize(new Dimension(1920, 1080));
		if (Settings.browser.equals(BrowserType.IE)) {
			WebElement signInLink = basedriver.findElement(By.cssSelector("#logIn_header a"));
			signInLink.isDisplayed();
			withActions().doubleClick(signInLink).build().perform();
		} else {
			signInLink
					.waitUntilVisible()
					.then()
					.click();
		}
		return PageFactory.initElements(basedriver, LoginPage.class);
	}

	public MainPublicPageMCD checkGlobalHeaderDisplayed() {
		Logger.info("Check the Global Header is displayed");
		boolean isGlobalHeaderDisplayed =
				globalHeader
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isGlobalHeaderDisplayed, "The Global Header is not displayed");
		return this;
	}

	public MainPublicPageMCD checkNavigationBarDisplayed() {
		Logger.info("Check the Navigation Bar is displayed");
		boolean isNavigationBarDisplayed =
				navigationBar
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isNavigationBarDisplayed, "The Navigation Bar is not displayed");
		return this;
	}

	public MainPublicPageMCD checkSignInLinkDisplayed() {
		Logger.info("Check the Sign In link  is displayed");
		boolean isSignInLinkDisplayed =
				signInLink
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isSignInLinkDisplayed, "The Sign In link is not displayed");
		return this;
	}

	public MainPublicPageMCD checkRegisterNowLinkDisplayed() {
		Logger.info("Check the Register Now link  is displayed");
		boolean isRegisterNowLinkDisplayed =
				registerNowLink
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isRegisterNowLinkDisplayed, "The Register Now link is not displayed");
		return this;
	}

	public MainPublicPageMCD checkWeightFieldsInDiagnosticSectionDisplayed() {
		Logger.info("The 'Weight' and 'Goal Weight' fields are displayed in the Diagnostic Section");
		boolean areWeightFieldsInDiagnosticSectionDisplayed =
				weightFieldInDiagnosticSection
						.waitElementsReady()
						.isElementPresent();
		goalWeightFieldInDiagnosticSection
				.waitElementsReady()
				.isElementPresent();
		assertTrue(areWeightFieldsInDiagnosticSectionDisplayed, "The 'Weight' and 'Goal Weight' fields are not displayed in the Diagnostic Section");
		return this;
	}

	public MainPublicPageMCD checkHeightFieldsInDiagnosticSectionDisplayed() {
		Logger.info("The Height fields are displayed in the Diagnostic Section");
		boolean areHeightFieldsInDiagnosticSectionDisplayed =
				heightFeetFieldInDiagnosticSection
						.waitElementsReady()
						.isElementPresent();
		heightInchFieldInDiagnosticSection
				.waitElementsReady()
				.isElementPresent();
		assertTrue(areHeightFieldsInDiagnosticSectionDisplayed, "The Height fields are not displayed in the Diagnostic Section");
		return this;
	}

	public MainPublicPageMCD checkAgeFieldInDiagnosticSectionDisplayed() {
		Logger.info("Check The 'Age' field is displayed in the Diagnostic Section");
		boolean isAgeFieldInDiagnosticSectionDisplayed =
				ageFieldInDiagnosticSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isAgeFieldInDiagnosticSectionDisplayed, "The 'Age' field is not displayed in the Diagnostic Section");
		return this;
	}

	public MainPublicPageMCD checkGenderRadioButtonsInDiagnosticSectionDisplayed() {
		Logger.info("Check The Gender radio buttons are displayed in the Diagnostic Section");
		boolean areGenderRadioButtonsInDiagnosticSectionDisplayed =
				genderRadioButtonsInDiagnosticSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(areGenderRadioButtonsInDiagnosticSectionDisplayed, "The Gender radio buttons are not displayed in the Diagnostic Section");
		return this;
	}

	public MainPublicPageMCD checkEmailFieldInDiagnosticSectionDisplayed() {
		Logger.info("Check The Email field is displayed in the Diagnostic Section");
		boolean isEmailFieldInDiagnosticSectionDisplayed =
				emailInputFieldInDiagnosticSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isEmailFieldInDiagnosticSectionDisplayed, "The Email field is not displayed in the Diagnostic Section");
		return this;
	}

	public MainPublicPageMCD checkStartFreeButtonInDiagnosticSectionDisplayed() {
		Logger.info("Check The 'Start Free' button is displayed in the Diagnostic Section");
		boolean isStartFreeButtonInDiagnosticSectionDisplayed =
				startFreeButtonInDiagnosticSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isStartFreeButtonInDiagnosticSectionDisplayed, "The 'Start Free' button is not displayed in the Diagnostic Section");
		return this;
	}

	public MainPublicPageMCD checkDefaultValueInDiagnosticSectionDisplayed() {
		Logger.info("Check default values of Fields in the Diagnostic Section");
		String weightPlaceholder =
				weightFieldInDiagnosticSection
						.getAttribute("data-placeholder");
		assertEquals(weightPlaceholder, "150", "Default value of Weight field is not correct");
		String goalWeightPlaceholder =
				goalWeightFieldInDiagnosticSection
						.getAttribute("data-placeholder");
		assertEquals(goalWeightPlaceholder, "130", "Default value of Goal Weight field is not correct");
		String heightFtPlaceholder =
				heightFeetFieldInDiagnosticSection
						.getAttribute("data-placeholder");
		assertEquals(heightFtPlaceholder, "5", "Default value of Height FT field is not correct");
		String heightInPlaceholder =
				heightInchFieldInDiagnosticSection
						.getAttribute("data-placeholder");
		assertEquals(heightInPlaceholder, "5", "Default value of Height IN field is not correct");
		String agePlaceholder =
				ageFieldInDiagnosticSection
						.getAttribute("data-placeholder");
		assertEquals(agePlaceholder, "35", "Default value of Age field is not correct");
		return this;
	}

	public TheExpertsPage clickTheExpertLink() {
		Logger.info("Click 'The Experts' link");
		theExpertsLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, TheExpertsPage.class);
	}

	public HowItWorksPage clickHowItWorksLink() {
		Logger.info("Click 'How It Works' link");
		howItWorksLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, HowItWorksPage.class);
	}

	public SuccessStoriesPage clickSuccessStoriesLink() {
		Logger.info("Click 'Success Stories' link");
		successStoriesLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, SuccessStoriesPage.class);
	}

	public RecipesPage clickRecipesLink() {
		Logger.info("Click 'Recipes' link");
		recipesLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, RecipesPage.class);
	}

	public SampleMealPlanPage clickSampleMealPlanLink() {
		Logger.info("Click 'Sample Meal Plan' link");
		Actions action = new Actions(basedriver);
		WebElement recipesLink = basedriver.findElement(By.cssSelector(".body1>a[href='/diet/mayo-clinic-diet-recipes']"));
		action.moveToElement(recipesLink).build().perform();
		sampleMealPlanLink
				.waitElementsReady()
				.click();
		return PageFactory.initElements(basedriver, SampleMealPlanPage.class);
	}

	public MainPublicPageMCD checkDiagnosticSectionDisplayed() {
		Logger.info("Check The Diagnostic Section is displayed");
		boolean isDiagnosticSectionDisplayed =
				diagnosticSection
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isDiagnosticSectionDisplayed, "The Diagnostic Section is not displayed");
		return this;
	}

	public MainPublicPageMCD checkGetTheFreeNewsletterDisplayed() {
		Logger.info("Check 'Get the free newsletter' section is displayed");
		boolean isGetTheFreeNewsletterDisplayed =
				getTheFreeNewsletter
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isGetTheFreeNewsletterDisplayed, "'Get the free newsletter' section is not displayed");
		return this;
	}

	public MainPublicPageMCD checkGlobalFooterDisplayed() {
		Logger.info("Check the Global Footer is displayed");
		boolean isGlobalFooterDisplayed =
				footer
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isGlobalFooterDisplayed, "The Global Footer is not displayed");
		return this;
	}

	public MainPublicPageMCD checkGlobalFooterLinksDisplayed() {
		Logger.info("Check the Global Footer links are displayed");
		boolean areGlobalFooterLinksDisplayed =
				footerLinks
						.waitElementsReady()
						.isElementPresent();
		assertTrue(areGlobalFooterLinksDisplayed, "The Global Footer links are not displayed");
		return this;
	}

	public MainPublicPageMCD checkGlobalFooterTextBlockDisplayed() {
		Logger.info("Check the '© 2015 Mayo Foundation for Medical Education and Research. All rights reserved.' text is displayed");
		boolean isGlobalFooterTextBlockDisplayed =
				footerTextBlock
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isGlobalFooterTextBlockDisplayed, "The '© 2015 Mayo Foundation for Medical Education and Research. All rights reserved.' text is not displayed");
		return this;
	}

	public MainPublicPageMCD checkGlobalFooterEhLogoDisplayed() {
		Logger.info("Check the Global Footer EH Logo is displayed");
		boolean isGlobalFooterEhLogoDisplayed =
				ehLogo
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isGlobalFooterEhLogoDisplayed, "The Global Footer EH Logo is not displayed");
		return this;
	}

	public MainPublicPageMCD checkGlobalFooterTextContainerDisplayed() {
		Logger.info("Check the Global Footer text container  is displayed");
		boolean isGlobalFooterTextContainerDisplayed =
				footerTextContainer
						.waitElementsReady()
						.isElementPresent();
		assertTrue(isGlobalFooterTextContainerDisplayed, "The Global Footer text container is not displayed");
		return this;
	}

	@Override
	public void waitForPageToLoad() {
		mainLogo.waitUntilVisible();
	}
}
