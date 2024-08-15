package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.share.SocialBarEH;
import everydayhealth.pages.articles.ArticleNewTemplatePage;
import everydayhealth.pages.share.ShareViaEmailPopUp;
import everydayhealth.pages.lifehack.LifehackPage;
import framework.Logger;
import framework.Settings;
import framework.platform.Environment;
import framework.platform.SiteNavigatorEH;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * LifehackTest
 */
public class LifehackTest extends WidgetsBaseTest {

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "LifehackTest", "C239725"})
	@TestRail(id = "C239725")
	public void verifyLifehackPageElements() {
		LifehackPage lifehackPage = SiteNavigatorEH.goToLifeHackPage();

		assertTrue(lifehackPage.isHeroImageVisible(), "Hero image should be visible");
		assertTrue(lifehackPage.isHeroMenuVisible(), "Hero menu should be visible");
		assertTrue(lifehackPage.isBreadcrumbLinkVisible(), "Breadcrumb link should be visible");
		assertTrue(lifehackPage.isBreadcrumbLinkValid(), "Breadcrumb link should not be empty");
		assertTrue(lifehackPage.isTitleVisible(), "Headline should be visible");
		assertTrue(lifehackPage.isDeckVisible(), "Deck should be visible");

		verifyATCWidgetFunctionality(lifehackPage, true, true);
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "LifehackTest", "C239726"})
	@TestRail(id = "C239726")
	public void verifyTipsWidget() {
		LifehackPage lifehackPage = SiteNavigatorEH.goToLifeHackPage();

		int numberOfTipCards = lifehackPage.getNumberOfTipCards();
		for (int tipNumber = 1; tipNumber <= numberOfTipCards; tipNumber++) {
			assertTrue(lifehackPage.isTipCardNumberVisible(tipNumber), "Tip card #" + tipNumber + " should be visible");
			if(lifehackPage.isTipCardAuthorNameNumberVisible(tipNumber)){
				Logger.info("Author name is visible for tip card #" + tipNumber);
			} else {
				Logger.info("Author name is not visible for tip card #" + tipNumber);
			}
			assertTrue(lifehackPage.isTipActionLinkNumberVisible(tipNumber), "Tip card #" + tipNumber + " action link should be visible");
			assertTrue(lifehackPage.isTipShareIconNumberVisible(tipNumber), "Tip card #" + tipNumber + " share link should be visible");
		}
		ArticleNewTemplatePage page = lifehackPage.clickOnTipActionLinkNumber(4, ArticleNewTemplatePage.class);
		assertTrue(page.isTitleVisible(), "Action link should lead to appropriate page");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "LifehackTest", "C240709"})
	@TestRail(id = "C240709")
	public void verifySocialBar() {
		LifehackPage lifehackPage = SiteNavigatorEH.goToLifeHackPage();

		SocialBarEH socialBarEH = lifehackPage.clickTipShareLink(1);
		assertTrue(lifehackPage.isTipCardNumberFlipped(1), "Front side of tip #1 should not be visible");
		lifehackPage.clickCloseShareBarIcon();
		assertFalse(lifehackPage.isTipCardNumberFlipped(1), "Front side of tip #1 should be visible");
		lifehackPage.clickTipShareLink(1);
		assertTrue(lifehackPage.isTipCardNumberFlipped(1), "Back side of tip #1 should be visible");
		if (Settings.isDesktop()) {
			socialBarEH.verifyAllPopUpsContainRespectiveDomain();
			ShareViaEmailPopUp shareViaEmailPopUp = socialBarEH.clickEmailShareButton();
			assertTrue(shareViaEmailPopUp.isYourEmailFieldVisible(), "'Your email' field should be visible");
			shareViaEmailPopUp.typeYourEmailFriendEmailAndSend(StringUtils.generateRandomEmail(), StringUtils.generateRandomEmail());
			assertTrue(shareViaEmailPopUp.isSuccessMessageVisible(), "Success message should be visible");
		}
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "LifehackTest", "C240710"})
	@TestRail(id = "C240710")
	public void verifySubmissionWidget() {
		LifehackPage lifehackPage = SiteNavigatorEH.goToLifeHackPage();

		assertTrue(lifehackPage.isSubmissionWidgetVisible(), "Submission widget should be visible");
		lifehackPage.clickShareYouLifehackButton();
		assertTrue(lifehackPage.isPopUpVisible(), "'Share you lifehack' pop up window should appear");
		assertTrue(lifehackPage.isEmailInputVisible(), "'Email' field should be visible");
		assertTrue(lifehackPage.getEmailInputText().isEmpty(), "'Email' field should be empty");
		assertEquals(lifehackPage.getDefaultEmailInputText(), "Your Email", "Placeholder in 'Email' field should be 'Your Email'");
		assertTrue(lifehackPage.isDefaultMessageVisible(), "Default message should be visible");
		assertTrue(lifehackPage.getTextAreaContent().isEmpty(), "Text area should be empty");
		assertEquals(lifehackPage.getTextAreaDefaultContent(), "Enter your Life Hack here ...", "Placeholder in text area should be 'Enter your Life Hack here ...'");
		assertTrue(lifehackPage.isSubscribeCheckBoxVisible(), "Newsletter checkbox should be visible");
		if (Settings.isDesktop()) {
			assertFalse(lifehackPage.isCheckboxChecked(), "Newsletter checkbox should be unchecked by default");
		}
		assertTrue(lifehackPage.isSubmitButtonVisible(), "'Submit' button should be visible");
		assertEquals(lifehackPage.getSubmitButtonText(), "Submit", "'Submit' button text should be 'Submit'");
		assertFalse(lifehackPage.isButtonEnabled(), "'Submit' button should not be enabled by default");
		lifehackPage.typeText(StringUtils.generateRandomStrAlphabetic(20));
		assertTrue(lifehackPage.isCharCounterVisible(), "Char counter should be visible");
		assertEquals(lifehackPage.getCharCounterValue().split("/")[1].trim(), "200", "Char limit should be '200'");
		assertFalse(lifehackPage.isButtonEnabled(), "'Submit' button should not be enabled if 'Email' field is empty");
		assertTrue(lifehackPage.isPrivacyLinkVisible(), "'Privacy' hyperlink should be visible");
		assertEquals(lifehackPage.getPrivacyLinkHrefAttributeValue(), "https://www.everydayhealth.com/privacyterms/#everyday_health_privacy_policy", "Incorrect 'Privacy' link url");
		lifehackPage.typeEmail(StringUtils.generateRandomEmail());
		assertFalse(lifehackPage.isButtonEnabled(), "'Submit' button should not be enabled if 'Terms of use' checkbox is not checked");
		assertTrue(lifehackPage.isTermsOfUseBlockVisible(), "'Terms of use' block should be visible");
		assertFalse(lifehackPage.getTermsOfUseLinkHrefValue().isEmpty(), "'Terms of Use' should be hyperlink");
		assertTrue(lifehackPage.getPrivacyPolicyLinkHrefValue().startsWith("https://"), "'Privacy policy' should be hyperlink");
		lifehackPage.clickTermsOfUseCheckbox();
		assertTrue(lifehackPage.isButtonEnabled(), "'Submit' button should be enabled");
		lifehackPage.clickSubmitButton();
		assertTrue(lifehackPage.isConfirmationMessageVisible(), "Confirmation message should be visible");
	}

	@Test(groups = {"EverydayHealthDesktop", "EverydayHealthTablet", "EverydayHealthMobile", "LifehackTest", "C240711"})
	@TestRail(id = "C240711")
	public void verifyOmnitureEvents() {
		LifehackPage lifehackPage = SiteNavigatorEH.goToLifeHackPage();

		assertTrue(MarketingPixels.isOmnitureEventPresent("events", "event19"));
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/bonesjoints/arthritisrheumatoid"), "eVar1 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Custom Solution: content-lifehackseditorial"), "eVar3 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc|/bonesjoints/arthritisrheumatoid"), "eVar6 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc|/bonesjoints/arthritisrheumatoid|309045|Rheumatoid Arthritis Life Hacks | Everyday Health"), "eVar8 is incorrect");
		verifyOmnitureEventsOnLifehackPage("Front-Load Your Fluids;Switch Your Shoes;Sleep Smarter;Curb Your Costs ;Boost Your Bottom;Stay Positive;Say Yes to Painless Sex");

		if (Settings.isDesktop()) {
			lifehackPage.openActionLinkInBackground();
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event37", "'event37 should fire'");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar1", "/bonesjoints/arthritisrheumatoid"), "eVar1 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar3", "Custom Solution: content-lifehackseditorial"), "eVar3 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar6", "cc|/bonesjoints/arthritisrheumatoid"), "eVar6 is incorrect");
			assertTrue(MarketingPixels.isOmnitureEventPresent("eVar8", "cc|/bonesjoints/arthritisrheumatoid|309045|Rheumatoid Arthritis Life Hacks | Everyday Health"), "eVar8 is incorrect");
			verifyOmnitureEventsOnLifehackPage("Front-Load Your Fluids");
		}

		SocialBarEH socialBarEH = lifehackPage.clickTipShareLink(1);
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event106", "'event106' should fire share link clicked");
		verifyOmnitureEventsOnLifehackPage("Front-Load Your Fluids");

		lifehackPage.clickShareYouLifehackButton();
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event14", "event14 should fire when 'Share you lifehack' button clicked");
		verifyOmnitureEventsOnLifehackPage("What’s your best tip for making Rheumatoid Arthritis easier to live with?");

		lifehackPage.typeEmail(StringUtils.generateRandomEmail());
		lifehackPage.typeText(StringUtils.generateRandomStrAlphabetic(20));
		lifehackPage.clickTermsOfUseCheckbox();
		assertTrue(lifehackPage.isButtonEnabled(), "'Submit' button should be enabled");
		lifehackPage.clickSubmitButton();
		assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event15", "'event4 and event15 should fire'");
		String eVar51Value = !Settings.isEnvironment(Environment.STAGE) ? "Share Your Life Hack for  Rheumatoid Arthritis Thank You for Sharing Your Life Hack!" : "Share Your Life Hack for  Rheumatoid Arthritis\n" +
				"                            Thank You for Sharing Your Life Hack!";
		verifyOmnitureEventsOnLifehackPage(eVar51Value);
		lifehackPage.clickClosePopUpButton();

		if (Settings.isDesktop()) {
			socialBarEH.clickOnFacebookShareButton();
			Utils.waitFor(1000); //wait for event to fire before check
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event93", "event93 should fire when 'Facebook' share icon clicked");
			socialBarEH.clickOnTwitterShareButton();
			Utils.waitFor(1000); //wait for event to fire before check
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event94", "event94 should fire when 'Twitter' share icon clicked");
			socialBarEH.clickOnPinterestShareButton();
			Utils.waitFor(1000); //wait for event to fire before check
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event96", "event96 should fire when 'Pinterest' share icon clicked");
			ShareViaEmailPopUp shareViaEmailPopUp = socialBarEH.clickEmailShareButton();
			shareViaEmailPopUp.closePopUp();
			assertEquals(MarketingPixels.getValue("linkTrackEvents"), "event92", "event92 should fire when 'Email' share icon clicked");
			verifyOmnitureEventsOnLifehackPage("Front-Load Your Fluids");
		}
	}

	private void verifyOmnitureEventsOnLifehackPage(String evar51) {
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar2", "cc"), "eVar2 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar5", "/bonesjoints/arthritisrheumatoid"), "eVar5 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar9", "/rheumatoid-arthritis/life-hacks/living-with-ra/2/"), "eVar9 is incorrect");
		assertTrue(MarketingPixels.isOmnitureAlphaNumericValue("eVar18"), "eVar18 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar30", "life hacks"), "eVar30 is incorrect");
		assertEquals(MarketingPixels.getValue("eVar51").trim(), evar51, "eVar51 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar67", "arthritis"), "eVar67 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar68", "rheumatoid arthritis"), "eVar68 is incorrect");
		assertTrue(MarketingPixels.isOmnitureEventPresent("eVar69", "symptoms,tips,living with"), "eVar69 is incorrect");
		assertTrue(MarketingPixels.isOmniturePublishedDate("eVar70"), "eVar70 is incorrect");
	}
}