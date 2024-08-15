package framework.platform;

import framework.Logger;
import framework.adapters.WebDriverManager;
import mayoclinicdiet.pages.MailinatorPage;
import mayoclinicdiet.pages.MainPublicPageMCD;
import mayoclinicdiet.pages.ReActivation2499Page;
import mayoclinicdiet.pages.ReActivation999Page;
import mayoclinicdiet.pages.RegistrationPage;
import mayoclinicdiet.pages.SamPage;
import mayoclinicdiet.pages.TwoStepRegistrationPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

/**
 * SiteNavigatorMCD
 */
public class SiteNavigatorMCD extends SiteNavigatorBase {

	static ConfigProvider config = new ConfigProvider();

	public static MainPublicPageMCD goToMainMCDPage() {
		Logger.info("Opening main MCD page");
		openPage("");
		return PageFactory.initElements(WebDriverManager.getDriver(), MainPublicPageMCD.class);
	}

	public static <T> T goToMainMCDPage(Class<T> expectedPage) {
		openPage("");
		return PageFactory.initElements(WebDriverManager.getDriver(), expectedPage);
	}

	public static RegistrationPage openSharedRegistration() {
		openPage("/sharedregistration");
		return PageFactory.initElements(WebDriverManager.getDriver(), RegistrationPage.class);
	}

	public static ReActivation999Page navigateToReActivation999Page() {
		openPage("/diet/MCDSpecialOffer9?email=" + config.getAdminEmail() + "&promo=FA38A535-4A34-4557-B4E1-270C29342B65");
		return PageFactory.initElements(WebDriverManager.getDriver(), ReActivation999Page.class);
	}

	public static ReActivation2499Page navigateToReActivation2499Page() {
		openPage("/diet/MCDSpecialOffer24?email=" + config.getAdminEmail() + "&promo=554E1FA5-E9A7-49A8-8BED-032CACD3703E");
		return PageFactory.initElements(WebDriverManager.getDriver(), ReActivation2499Page.class);
	}

	public static MailinatorPage navigateToMailinator() {
		WebDriverManager.getDriver().navigate().to(new ConfigProvider().getMailinatorLink());
		WebDriverManager.getDriver().manage().window().setSize(new Dimension(1920, 1080));
		return PageFactory.initElements(WebDriverManager.getDriver(), MailinatorPage.class);
	}

	public static SamPage navigateToSam() {
		WebDriverManager.getDriver().navigate().to(new ConfigProvider().getSamLink());
		WebDriverManager.getDriver().manage().window().setSize(new org.openqa.selenium.Dimension(1600, 900));
		return PageFactory.initElements(WebDriverManager.getDriver(), SamPage.class);
	}

	public static TwoStepRegistrationPage navigateToRegistrationPage() {
		WebDriverManager.getDriver().get("https://register.diet.mayoclinic.org/test/epay/qa?signup=now");
		WebDriverManager.getDriver().manage().window().maximize();
		return PageFactory.initElements(WebDriverManager.getDriver(), TwoStepRegistrationPage.class);
	}
}
