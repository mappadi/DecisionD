package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.CusoManagementSelectorPage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import framework.BrowserType;
import framework.Logger;
import framework.Settings;
import framework.platform.CookieName;
import framework.platform.SiteNavigatorEH;
import framework.platform.UserCacheEH;
import framework.platform.utilities.CookiesManager;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

/**
 * Cuso Management Selector Test
 */
public class CusoManagementSelectorTest extends WidgetsBaseTest{

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoManagementSelectorTest", "C216278"})
	@TestRail(id = "C216278")
	public void verifyCusoManagementSelectorContent() {
		CusoManagementSelectorPage cusoPage = SiteNavigatorEH.goToCusoManagementSelectorPage();
		assertTrue(cusoPage.isHeadlineVisible(), "Headline is not visible");
		assertTrue(cusoPage.isBreadcrumbVisible(), "Breadcrumb is not visible");
		assertTrue(cusoPage.isDeckVisible(), "Deck is not visible");
		assertTrue(cusoPage.isLastUpdatedDateVisible(), "Last updated date is not visible");

		assertTrue(cusoPage.isReadMoreBeforeVisible(), "Read more before clicking is not visible");
		assertTrue(cusoPage.isReadMoreLinkVisible(), "Read more link is not visible");
		assertTrue(cusoPage.getReadMoreTextBeforeClick().contains("Everyday Solutions are created by Everyday Health on behalf of our partners. Read more"), "Given text should be displayed before click");
		cusoPage.clickReadMoreLink();
		assertFalse(cusoPage.isReadMoreLinkVisible(), "Read more link should not be visible");
		assertTrue(cusoPage.isReadMoreTextAfterClickVisible(), "Read more after clicking is not visible");
		if (Settings.isDesktop()) {
			//TODO - Issues with Appium when retrieving a cookie by its name. Will be fixed once appium fix it.
			Logger.info("Verify domain of cookie 'GWFM' is correct");
			assertEquals(CookiesManager.getCookieDomain(CookieName.GWFM), ".everydayhealth.com", "Domain of cookie 'GWFM' is incorrect");
		}
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoManagementSelectorTest", "C234672"})
	@TestRail(id = "C234672")
	public void verifyCusoManagementSelectorIsiWidget() {
		CusoManagementSelectorPage cusoPage = SiteNavigatorEH.goToCusoManagementSelectorPage();
		verifyISIWidgets(cusoPage);
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoManagementSelectorTest", "C234681"})
	@TestRail(id = "C234681")
	public void verifyCusoManagementSelectorIframeWidget() {
		CusoManagementSelectorPage cusoPage = SiteNavigatorEH.goToCusoManagementSelectorPage();

		assertTrue(cusoPage.getRightRailIframeWidgetLocation().equalsIgnoreCase("RightRail"), "Right rail iframe widget position is incorrect");
		assertTrue(cusoPage.isRightRailIframeWidgetVisible(), "Right rail iframe widget is not visible");

		assertEquals(cusoPage.getRightRailIframeWidgetHeight(), 250, "Right rail iframe widget height is incorrect");
		assertEquals(cusoPage.getRightRailIframeWidgetWidth(), 300, "Right rail iframe widget width is incorrect");
		Logger.info("Verify right rail iFrame widget appears below adDiv3");
		assertTrue(cusoPage.getGoogleAd5YCoordinate() < cusoPage.getIframeWidgetYCoordinate(), "Iframe widget is not below Google ad 5");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoManagementSelectorTest", "C216471"})
	@TestRail(id = "C216471")
	public void verifySocialShareBar() {
		CusoManagementSelectorPage cusoPage = SiteNavigatorEH.goToCusoManagementSelectorPage();
		SocialBarEH socialBar = cusoPage.onSocialBar();
		assertTrue(socialBar.isSocialBarVisible(), "Social share bar is not visible");
		assertTrue(socialBar.isFacebookShareButtonVisible(), "Facebook share button is not visible");
		assertTrue(socialBar.isTwitterShareButtonVisible(), "Twitter share button is not visible");
		assertTrue(socialBar.isPinterestShareButtonVisible(), "Pinterest share button is not visible");
		assertTrue(socialBar.isEmailShareButtonVisible(), "Email share button is not visible");

		int expectedNumberOfCountableShareButtons = (Settings.isDesktop()) ? 5 : 4;
		assertEquals(socialBar.getNumberOfShareButtons(), expectedNumberOfCountableShareButtons, "Number of countable share buttons is incorrect");

		if (Settings.isDesktop()) {
			assertTrue(socialBar.isPrintShareButtonVisible(), "Print share button is not visible");
			socialBar.clickOnFacebookShareButton();
			socialBar.verifyFacebookPopUpContainsFacebook();
			socialBar.clickOnTwitterShareButton();
			socialBar.verifyTwitterPopUpContainsTwitter();
			socialBar.clickOnPinterestShareButton();
			socialBar.verifyPinterestPopUpContainsPinterest();
			if (Settings.browser.equals(BrowserType.CHROME)) {
				socialBar.clickPrintShareButton();
			}
		} else {
			assertTrue(socialBar.getFacebookShareLink().contains("facebook"), "Facebook button link does not contain 'facebook'");
			assertTrue(socialBar.getTwitterShareLink().contains("twitter"), "Twitter button link does not contain 'twitter'");
			assertTrue(socialBar.getPinterestShareLink().contains("pinterest"), "Pinterest button link does not contain 'pinterest'");
		}

		ShareViaEmailPopUp shareViaEmailPopUp = socialBar.clickEmailShareButton();
		shareViaEmailPopUp.typeYourEmailFriendEmailAndSend(UserCacheEH.MAIN_USER.getEmail(), StringUtils.generateRandomEmail());
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks! Your email was sent"), "Sent email message is not visible");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyVisible(), "'Privacy Policy' is not visible");
		assertEquals(shareViaEmailPopUp.getPrivacyPolicyLinkText(), "Privacy Policy", "'Privacy Policy' text is not present");
		assertTrue(shareViaEmailPopUp.isPrivacyPolicyLinkPresent(), "'Privacy Policy' link is not present");
		shareViaEmailPopUp.clickSignUpButton();
		assertTrue(shareViaEmailPopUp.getTitle().contains("Thanks for signing up!"), "Sent email message is not visible");
		shareViaEmailPopUp.closePopUp();
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoManagementSelectorTest", "C216306"})
	@TestRail(id = "C216306")
	public void verifyCusoManagementQuestionnaire() {
		CusoManagementSelectorPage cusoPage = SiteNavigatorEH.goToCusoManagementSelectorPage();
		assertTrue(cusoPage.getProgressBarElementsCount() > 1, "Progress bar should contain more than 1 element");
		assertTrue(cusoPage.isProgressBarElementNumberEnabled(1), "Progress bar element #1 should be enabled");
		cusoPage.clickOnAnswer(1, 1);

		Logger.info("Verify order of answers in result page is correct by selecting different answers");
		List<String> options = cusoPage.getOptionsText();
		int optionNumber = 1;
		Logger.debug(CookiesManager.getCookieValue(CookieName.QSI_SI_cDdVag8OOLcZ2bX_intercept));
		while (optionNumber < options.size()) {
			String currentAnswer = cusoPage.getSelectedOptionText(optionNumber);
			cusoPage.clickOnOption(optionNumber);
			assertTrue(cusoPage.isResultHeadlineVisible(), "Result headline is not visible");
			assertEquals(currentAnswer, cusoPage.getResultHeadline(), "Selected answer and result headline mismatch");
			assertTrue(cusoPage.isResultDescriptionVisible(), "Result description is not visible");
			assertTrue(cusoPage.isResultSubDescriptionVisible(), "Result sub-description is not visible");
			assertTrue(cusoPage.isResultContentHeadlineVisible(), "Result content headline is not visible");
			assertTrue(cusoPage.isResultContentVisible(), "Result content is not visible");
			assertTrue(cusoPage.isStartOverLinkVisible(), "Start over link is not visible");
			Logger.info("Verify 'Next Answer' are in same order in result pages, as displayed in options page");
			int selectedOptionIndex = optionNumber - 1;
			int answerPage = 0;
			while (answerPage < options.size()) {
				if (selectedOptionIndex == answerPage) {
					answerPage++;
				}
				assertEquals(options.get(answerPage), cusoPage.getNextAnswerText(), "Next answer and options order mismatch");
				cusoPage.clickNextAnswerLink();
				assertTrue(cusoPage.isPreviousLinkVisible(), "'Previous link' is not visible");
				answerPage++;
			}
			optionNumber++;
			Logger.info("Go to first page and restart selector test");
			cusoPage.clickStartOverLink();
			cusoPage.clickOnAnswer(1, 1);
		}
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoManagementSelectorTest", "C216323"})
	@TestRail(id = "C216323")
	public void verifyCusoManagementPreviousLinkNavigation() {
		CusoManagementSelectorPage cusoPage = SiteNavigatorEH.goToCusoManagementSelectorPage();

		cusoPage.clickOnAnswer(1, 1);
		List<String> options = cusoPage.getOptionsText();
		String currentAnswer = cusoPage.getSelectedOptionText(1);

		Logger.info("Go to last result page by selecting 1st option in answer page");
		cusoPage.clickOnOption(1);
		int resultPage = 1;
		Logger.debug(CookiesManager.getCookieValue(CookieName.QSI_SI_cDdVag8OOLcZ2bX_intercept));
		while (resultPage < options.size()) {
			assertEquals(options.get(resultPage), cusoPage.getNextAnswerText(), "Next answer and options order mismatch");
			cusoPage.clickNextAnswerLink();
			assertTrue(cusoPage.isPreviousLinkVisible(), "'Previous link' is not visible");
			resultPage++;
		}

		Logger.info("Verify 'Previous Link' functionality");
		while (resultPage > 1) {
			if (resultPage == options.size()) {
				assertFalse(cusoPage.isNextAnswerVisible(), "'Next Answer' should not be visible on last result page");
			} else {
				assertEquals(options.get(resultPage), cusoPage.getNextAnswerText(), "Next answer and options order mismatch");
			}
			cusoPage.clickPreviousLink();
			resultPage--;
		}
		Logger.info("Verify after finishing 'Previous Link' functionality, user is on first result page");
		assertEquals(currentAnswer, cusoPage.getResultHeadline(), "Selected answer and result headline mismatch");
	}

	@Test(groups = {"CusoSolutionsDesktop", "CusoSolutionsTablet", "CusoSolutionsMobile", "CusoManagementSelectorTest", "C315160"})
	@TestRail(id = "C315160")
	public void verifyOmnitureEventsForQuestionnaries() {
		CusoManagementSelectorPage cusoPage = SiteNavigatorEH.goToCusoManagementSelectorPage();

		int answer1 = StringUtils.generateRandomIntInRange(1, cusoPage.getNumberOfAnswers(1));
		String answer1Text = cusoPage.getAnwerText(1, answer1);
		cusoPage.clickOnAnswer(1, answer1);
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event14,event21", "'event14' and 'event21' should fire");
		verifyEvarValues(answer1Text);
		int answer2 = StringUtils.generateRandomIntInRange(1, cusoPage.getNumberOfAnswers(2));
		String answer2Text = cusoPage.getAnwerText(2, answer2);
		cusoPage.clickOnAnswer(2, answer2);
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event15,event21", "'event15' and 'event21' should fire");
		verifyEvarValues(answer2Text);
		String nextText = cusoPage.getNextAnswerText();
		cusoPage.clickNextAnswerLink();
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event42", "'event42' should fire");
		verifyEvarValues(nextText);
		cusoPage.clickStartOverLink();
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event40", "'event40' should fire");
		verifyEvarValues("");
	}

	private void verifyEvarValues(String eVar60) {
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/cs/test"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/cs/test"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc|/cs/test"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc|/cs/test"), "eVar8 is incorrect");
		String url = Utils.getCurrentURL().split(".com")[1].split("#")[0].replace("?isautomation=true", "");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", url), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "management selector"), "eVar30 is incorrect");
		if (!eVar60.isEmpty()) {
			assertEquals(MarketingPixels.getValue("eVar60").trim(), eVar60.toLowerCase(), "eVar60 should contain chosen answer");
		}
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "arthritis"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "rheumatoid arthritis"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "basics"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
	}
}