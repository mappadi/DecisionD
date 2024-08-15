package org.everydayhealth.tests;

import everydayhealth.pages.BasicPageEH;
import everydayhealth.pages.GlobalNavHeader;
import everydayhealth.pages.articles.ArticleBasePage;
import everydayhealth.pages.articles.ArticleNewTemplatePage;
import everydayhealth.pages.articles.ArticleSavePage;
import everydayhealth.pages.articles.CustomSolutionsTemplatePage;
import everydayhealth.pages.articles.IGNPlayerPage;
import everydayhealth.pages.registrations.InlineRegistration;
import everydayhealth.pages.share.SocialBarEH;
import framework.Logger;
import framework.Settings;
import framework.platform.Environment;
import framework.platform.UserCacheEH;
import framework.platform.utilities.MarketingPixels;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;

/**
 * WidgetsBaseTest
 */
public class WidgetsBaseTest {

	protected void verifyCusoHeaderWidget(CustomSolutionsTemplatePage cusoPage, boolean isHeaderClickable) {
		Logger.info("Verify 'CUSO header' widget");
		if (isHeaderClickable) {
			assertTrue(cusoPage.isCusoHeaderTitleVisible(), "Title should be visible");
			assertTrue(cusoPage.isCusoHeaderTitleClickable(), "Title should be clickable");
		} else {
			assertTrue(cusoPage.isHeaderVisible(), "Cuso header is not visible");
		}
		assertTrue(cusoPage.isCusoHeaderEyebrowVisible(), "Eyebrow should be visible");
		assertTrue(cusoPage.isCusoNavigationWidgetVisible(), "Cuso header should be visible");
		assertTrue(cusoPage.isCusoHeaderSubnavVisible(), "Subnavigation should be visible");
		cusoPage.clickSubnavMoreButton();
		int numberOfSubnavLinks = cusoPage.getNumberOfCusoHeaderSubnavLinks();
		assertTrue(numberOfSubnavLinks > 1, "More than one subnavigation link should be present");
		for (int linkNumber = 1; linkNumber <= numberOfSubnavLinks; linkNumber++) {
			assertFalse(cusoPage.getHrefValueOfCusoSubnavLinkNumber(linkNumber).isEmpty(), "Subnav link should be hyperlink");
		}
	}

	protected void verifyReadNextWidget(CustomSolutionsTemplatePage cusoPage) {
		Logger.info("Verify 'Read next' widget");
		assertTrue(cusoPage.isReadNextSectionVisible(), "Read next section should be visible");
		assertTrue(cusoPage.isReadNextHeaderVisible(), "Read next Header should be visible");
		int numberOfReadNextArticles = cusoPage.getNumberOfReadNextItems();
		assertTrue(numberOfReadNextArticles > 0, "At least one Read next link should be present");
		for (int linkNumber = 1; linkNumber <= numberOfReadNextArticles; linkNumber++) {
			assertTrue(cusoPage.isReadNextImageNumberVisible(linkNumber), "Read next article image should be visible");
			assertFalse(cusoPage.getReadNextImageNumberHrefValue(linkNumber).isEmpty(), "Read next article image should be hyperlink");
			assertTrue(cusoPage.isReadNextTitleNumberVisible(linkNumber), "Read next article title should be visible");
			assertFalse(cusoPage.getReadNextTitleNumberHrefValue(linkNumber).isEmpty(), "Read next article title should be hyperlink");
		}
	}

	protected void verifyPromoWidget(CustomSolutionsTemplatePage cusoPage) {
		Logger.info("Verify 'Promo' widget");
		assertTrue(cusoPage.isPromoSectionVisible(), "Promo widget should be visible");
		assertTrue(cusoPage.isPromoHeaderVisible(), "Promo widget header should be visible");
		int numberOfPromoArticles = cusoPage.getNumberOfPromoArticles();
		assertTrue(numberOfPromoArticles > 0, "At least one Promo article should be present");
		for (int linkNumber = 1; linkNumber <= numberOfPromoArticles; linkNumber++) {
			assertTrue(cusoPage.isPromoImageNumberVisible(linkNumber), "Promo article image should be visible");
			assertFalse(cusoPage.getPromoImageNumberHrefValue(linkNumber).isEmpty(), "Promo article image should be hyperlink");
			assertTrue(cusoPage.isPromoTitleNumberVisible(linkNumber), "Promo article title should be visible");
			assertFalse(cusoPage.getPromoTitleNumberHrefValue(linkNumber).isEmpty(), "Promo article title should be hyperlink");
		}
	}

	protected void verifyRelatedWidget(CustomSolutionsTemplatePage cusoPage) {
		Logger.info("Verify 'Related' widget");
		assertTrue(cusoPage.isRelatedHeaderVisible(), "Related widget header should be visible");
		int numberOfRelatedArticles = cusoPage.getNumberOfRelatedItems();
		assertTrue(numberOfRelatedArticles > 0, "At least one Related article should be present");
		for (int linkNumber = 1; linkNumber <= numberOfRelatedArticles; linkNumber++) {
			assertTrue(cusoPage.isRelatedImageNumberVisible(linkNumber), "Related article image should be visible");
			assertFalse(cusoPage.getRelatedImageNumberHrefValue(linkNumber).isEmpty(), "Related article image should be hyperlink");
			assertTrue(cusoPage.isRelatedTitleNumberVisible(linkNumber), "Related article title should be visible");
			assertFalse(cusoPage.getRelatedTitleNumberHrefValue(linkNumber).isEmpty(), "Related article title should be hyperlink");
		}
	}

	protected void verifyPatientSupportBar(CustomSolutionsTemplatePage cusoPage) {
		Logger.info("Verify 'Patient support' bar");
		assertTrue(cusoPage.isPatientSupportBarVisible(), "Patient support bar is not visible");
		assertTrue(cusoPage.getPatientSupportBarToggleText().contains("close"), "Patient support bar toggle text incorrect");
		assertTrue(cusoPage.isPatientSupportBarSocialShareIconsVisible(), "Patient support bar does not have share icons");
		cusoPage.clickPatientSupportBarCloseButton();
		assertTrue(cusoPage.getPatientSupportBarToggleText().contains("open"), "Patient support bar toggle text incorrect");
		assertFalse(cusoPage.isPatientSupportBarOpen(), "Patient support bar should be closed");
	}

	protected void verifyATCWidgetFunctionality(BasicPageEH basicPageEH, boolean isNewATC, boolean isTransparent) {
		Logger.info("Verify ATC widget functionality");
		assertTrue(basicPageEH.isATCWidgetVisible(), "ATC widget should be visible");
		assertTrue(basicPageEH.isATCAdditionalInfoLinkVisible(), "ATC widget more info link should be visible");
		if (isNewATC) {
			if (!isTransparent) {
				assertEquals(basicPageEH.getATCSectionBackgroundColor(), "#f6f6f6", "ATC banner should have grey background");
				assertEquals(basicPageEH.getATCWidgetLabelText().trim(), "About This Content", "Label text should be 'About This Content'");
			}
			assertTrue(basicPageEH.isATCWidgetLabelVisible(), "'About This Content' label should be visible in 'ATC' section");
			assertFalse(basicPageEH.isATCNewPopoverVisible(), "ATC popover should not be visible before click");
			basicPageEH.clickATCAdditionalInfoLink();
			assertTrue(basicPageEH.isATCNewPopoverVisible(), "ATC popover should be visible after click");
			assertTrue(basicPageEH.isATCClosePopoverLinkVisible(), "ATC popover close icon should be visible");
			assertTrue(basicPageEH.getATCWidgetMoreInfoText().toLowerCase().contains("content in this special section was created or selected by the everyday health"), "Flyout should contain mentioned text");
			basicPageEH.clickATCClosePopoverLink();
			assertFalse(basicPageEH.isATCNewPopoverVisible(), "ATC popover should not be visible before click");
		} else {
			assertFalse(basicPageEH.isATCPopoverVisible(), "ATC popover should not be visible before click");
			basicPageEH.clickATCAdditionalInfoLink();
			assertTrue(basicPageEH.isATCPopoverVisible(), "ATC popover should be visible after click");
			assertTrue(basicPageEH.isATCPopoverCloseIconVisible(), "ATC popover close icon should be visible");
			basicPageEH.clickAtcPopoverCloseIcon();
			assertFalse(basicPageEH.isATCPopoverVisible(), "ATC popover should not be visible before click");
		}
	}

	protected void verifyATCBrandedWidgetFunctionality(BasicPageEH basicPageEH) {
		Logger.info("Verify ATC branded widget functionality");
		assertTrue(MarketingPixels.getConsoleValue("eVar1").endsWith("/br"), "'Ad-zone' value should end with '/br' string");
		assertTrue(basicPageEH.isATCWidgetVisible(), "ATC widget should be visible");
		assertTrue(basicPageEH.isATCAdditionalInfoLinkVisible(), "ATC widget more info link should be visible");
		assertEquals(basicPageEH.getATCSectionBackgroundColor(), "#fdefc2", "ATC banner should have orange background");
		assertTrue(basicPageEH.getATCWidgetLabelText().contains("This special section was created by or on behalf of an advertising sponsor"), "Label text should be 'This special section was created by or on behalf of an advertising sponsor'");
		assertTrue(basicPageEH.isATCWidgetLabelVisible(), "'About This Content' label should be visible in 'ATC' section");
		assertFalse(basicPageEH.isATCNewPopoverVisible(), "ATC popover should not be visible before click");
		basicPageEH.clickATCAdditionalInfoLink();
		assertTrue(basicPageEH.isATCNewPopoverVisible(), "ATC popover should be visible after click");
		assertTrue(basicPageEH.isATCClosePopoverLinkVisible(), "ATC popover close icon should be visible");
		assertTrue(basicPageEH.getATCWidgetMoreInfoText().toLowerCase().contains("content in this special section was created by or on behalf of an advertising sponsor"), "Flyout should contain mentioned text");
		basicPageEH.clickATCClosePopoverLink();
		assertFalse(basicPageEH.isATCNewPopoverVisible(), "ATC popover should not be visible before click");
	}

	protected void verifyFormElements(BasicPageEH basicPageEH) {
		assertTrue(basicPageEH.isFormVisible(), "Form should be visible");
		assertTrue(basicPageEH.isFormIconVisible(), "Form icon should be visible");
		assertTrue(basicPageEH.isFormDeckVisible(), "Form deck should be visible");
		assertTrue(basicPageEH.isFormShareLinkVisible(), "Form 'Share here' link should be visible");
	}

	protected void verifyFormPopUpElements(BasicPageEH basicPageEH) {
		assertTrue(basicPageEH.isFormPopUpWindowVisible(), "Form pop up window should be visible");
		basicPageEH.clickFormPopUpCloseIcon();
		assertFalse(basicPageEH.isFormPopUpWindowVisible(), "Form pop up window should not be visible");
		basicPageEH.clickFormShareLink();
		assertTrue(basicPageEH.isFormPopUpHeadlineVisible(), "Form pop up window headline should be visible");
		assertTrue(basicPageEH.isFormPopUpCloseIconVisible(), "Form pop up window close icon [x] should be visible");
		assertTrue(basicPageEH.isFormPopUpFirstNameInputVisible(), "'First name' input should be visible");
		assertTrue(basicPageEH.isFormPopUpLastNameInputVisible(), "'Last name' input should be visible");
		assertTrue(basicPageEH.isFormPopUpEmailInputVisible(), "'Email' input should be visible");
		assertTrue(basicPageEH.isFormPopUpStoryTextareaVisible(), "'Share your story' textarea should be visible");
		assertTrue(basicPageEH.isFormPopUpTosCheckboxVisible(), "Form 'Terms of service' checkbox should be visible");
		assertTrue(basicPageEH.isFormPopUpTosLabelVisible(), "Form 'Terms of service' label should be visible");
		assertTrue(basicPageEH.getFormPopUpTosLinkHrefValue().startsWith("https://"), "'Terms of Use' label should be clickable and valid hyperlink");
		assertTrue(basicPageEH.getFormPopUpPrivacyLinkHrefValue().startsWith("https://"), "'Privacy Policy' label should be clickable and valid hyperlink");
		assertTrue(basicPageEH.isFormPopUpFormSubmitButtonVisible(), "'Submit' button should be visible");
	}

	protected void verifyFormPopUpStoryShare(BasicPageEH basicPageEH, String templateName) {
		basicPageEH.clickFormPopUpSubmitButton();
		assertTrue(basicPageEH.isFormPopUpErrorMessageVisible("Please add your first name."), "Error message for First name should be visible");
		assertTrue(basicPageEH.isFormPopUpErrorMessageVisible("Please add your last name."), "Error message for Last name should be visible");
		assertTrue(basicPageEH.isFormPopUpErrorMessageVisible("A valid email address is required."), "Error message for Email should be visible");
		assertTrue(basicPageEH.isFormPopUpErrorMessageVisible("Please enter a message."), "Error message for Story should be visible");
		assertTrue(basicPageEH.isFormPopUpErrorMessageVisible("You must agree to our terms."), "Error message for TOS checkbox should be visible");
		basicPageEH.typeFormFirstName(StringUtils.generateRandomStrAlphabetic(5)).clickFormPopUpSubmitButton();
		assertFalse(basicPageEH.isFormPopUpErrorMessageVisible("Please add your first name."), "Error message for First name should not be visible");
		basicPageEH.typeFormLastName(StringUtils.generateRandomStrAlphabetic(7)).clickFormPopUpSubmitButton();
		assertFalse(basicPageEH.isFormPopUpErrorMessageVisible("Please add your last name."), "Error message for Last name should not be visible");
		basicPageEH.typeFormEmailAddress(StringUtils.generateRandomEmail()).clickFormPopUpSubmitButton();
		assertFalse(basicPageEH.isFormPopUpErrorMessageVisible("A valid email address is required."), "Error message for Email should not be visible");
		basicPageEH.typeFormStory("Template - " + templateName + "\nEnvironment - " + Settings.config.getEnvironment()).clickFormPopUpSubmitButton();
		assertFalse(basicPageEH.isFormPopUpErrorMessageVisible("Please enter a message."), "Error message for Story should not be visible");
		assertTrue(basicPageEH.isFormPopUpCharCounterVisible(), "Char counter should be visible");
		assertNotEquals(basicPageEH.getFormPopUpCharCounterValue(), "0", "Char counter value should not be equal to '0'");
		assertTrue(basicPageEH.getFormPopUpTosLinkHrefValue().startsWith("https://"), "'Terms of Use' should be valid hyperlink");
		assertTrue(basicPageEH.getFormPopUpPrivacyLinkHrefValue().startsWith("https://"), "'Privacy Policy' should be valid hyperlink");
		basicPageEH.clickFormPopUpTosCheckbox().clickFormPopUpSubmitButton();
		assertTrue(basicPageEH.isFormPopUpThankYouMessageVisible(), "'Thank you' message should appear");
	}

	protected void verifySmartNewsletters(ArticleBasePage articlePage) {
		Logger.info("Verify Smart Newsletter module functionality");
		assertTrue(articlePage.isSmartNewsletterModuleVisible(), "Smart newsletter module should be visible");
		assertTrue(articlePage.isSmartNewsletterEmailInputVisible(), "'Email' input should be visible");
		assertTrue(articlePage.isSmartNewsletterSignUpButtonVisible(), "'Sign up' button should be visible");
		assertTrue(articlePage.isNewsletterModulePrivacyLinkVisible(), "'your privacy' hyperlink should be visible in newsletter module");
		assertTrue(articlePage.isNewsLetterModulePrivacyLinkValid(), "'your privacy' hyperlink should be valid URL");
		articlePage.scrollDownThePage();
		articlePage.typeSmartNewsletterEmailAddress("");
		articlePage.clickSmartNewsletterSignUpButton();
		assertTrue(articlePage.isSmartNewsletterWarningMessageVisible(), "Warning message should appear");
		articlePage.waitUntilSmartNLWarningMessageDisappears();
		articlePage.typeSmartNewsletterEmailAddress(StringUtils.generateRandomStrAlphabetic(6));
		articlePage.clickSmartNewsletterSignUpButton();
		assertTrue(articlePage.isSmartNewsletterWarningMessageVisible(), "Warning message should appear");
		articlePage.typeSmartNewsletterEmailAddress(StringUtils.generateRandomEmail());
		articlePage.clickSmartNewsletterSignUpButton();
		assertTrue(articlePage.isSmartNewsletterSuccessMessageVisible(), "Success message should be visible");
		assertTrue(articlePage.isSmartNewsletterExtraSectionVisible(), "Newsletter suggestions section should be visible");
		assertTrue(articlePage.getNumberOfExtraNewsletters() > 1, "More than 1 suggestion should appear");
		assertTrue(articlePage.isSmartNewsletterSignUpButtonVisible(), "'Sign up' button should be visible");
	}

	protected void verifyNewsletterWidgetFunctionality(BasicPageEH basicPageEH) {
		Logger.info("Verify newsletter widget functionality");
		assertTrue(basicPageEH.isNewsletterWidgetVisible(), "Newsletter widget should be visible");
		assertTrue(basicPageEH.isNewsLetterEmailBoxVisible(), "'Email' input should be visible");
		assertTrue(basicPageEH.isNewsLetterSubmitButtonVisible(), "'Sign up'/'Subscribe' button should be visible");
		assertTrue(basicPageEH.isNewsletterWidgetPrivacyLinkVisible(), "'your privacy' hyperlink should be visible");
		assertTrue(basicPageEH.isNewsLetterWidgetPrivacyLinkValid(), "'your privacy' hyperlink should be valid");
		basicPageEH.enterEmailAndSubmit("");
		assertTrue(basicPageEH.isNewsletterWarningMessageVisible(), "Warning message should appear");
		basicPageEH.waitUntilWarningMessageDisappear();
		basicPageEH.enterEmailAndSubmit(StringUtils.generateRandomStrAlphabetic(8));
		assertTrue(basicPageEH.isNewsletterWarningMessageVisible(), "Warning message should appear");
		basicPageEH.enterEmailAndSubmit(StringUtils.generateRandomEmail());
		assertTrue(basicPageEH.isNewsletterWidgetSuccessMessageVisible(), "Success message should appear");
	}

	protected void verifyNewsletterModuleFunctionality(BasicPageEH basicPageEH) {
		Logger.info("Verify newsletter module functionality");
		assertTrue(basicPageEH.isNewsletterModuleVisible(), "Newsletter module should be visible");
		assertTrue(basicPageEH.isNewsLetterEmailBoxVisible(), "'Email' input should be visible");
		assertTrue(basicPageEH.isNewsLetterSubmitButtonVisible(), "'Sign up'/'Subscribe' button should be visible");
		assertTrue(basicPageEH.isNewsletterModulePrivacyLinkVisible(), "'your privacy' hyperlink should be visible");
		assertTrue(basicPageEH.isNewsLetterModulePrivacyLinkValid(), "'your privacy' hyperlink should be valid");
		basicPageEH.enterEmailAndSubmit("");
		assertTrue(basicPageEH.isNewsletterWarningMessageVisible(), "Warning message should appear");
		basicPageEH.waitUntilWarningMessageDisappear();
		basicPageEH.enterEmailAndSubmit(StringUtils.generateRandomStrAlphabetic(8));
		assertTrue(basicPageEH.isNewsletterWarningMessageVisible(), "Warning message should appear");
		basicPageEH.enterEmailAndSubmit(StringUtils.generateRandomEmail());
		assertTrue(basicPageEH.isNewsletterModuleSuccessMessageVisible(), "Success message should appear");
	}

	protected void verifySaveButtonFunctionalityForNonLoggedInUser(ArticleNewTemplatePage articleNewTemplatePage) {
		Logger.info("Verify 'Save' button functionality for non logged in user");
		SocialBarEH socialBarEH = articleNewTemplatePage.onSocialBar();
		assertTrue(socialBarEH.isSaveLinkVisible(), "'Save' link should be visible");
		socialBarEH.clickSaveLink();
		InlineRegistration inlineRegistration = articleNewTemplatePage.onInlineRegistration();
		assertTrue(inlineRegistration.isInlineRegistrationSectionVisible(), "Inline registration should open");

		Logger.info("Verify email address requirements");
		assertFalse(inlineRegistration.isSignupButtonClickable(), "Signup button enabled");
		inlineRegistration.enterEmailAndTabOut("test1@mailinator.com");
		assertTrue(inlineRegistration.isWarningMessageWithTextVisible("This email address already exists."), "Warning message for existing email should have appeared");
		inlineRegistration.enterEmailAndTabOut(StringUtils.generateRandomStrAlphabetic(10));
		assertTrue(inlineRegistration.isWarningMessageWithTextVisible("You must enter a valid email address."), "Warning message for invalid email should have appeared");

		Logger.info("Verify password requirements");
		inlineRegistration.enterPassword(StringUtils.generateRandomStrAlphaNumeric(7));
		assertTrue(inlineRegistration.isPasswordRequirementsTipsVisible(), "Password requirements Box should be displayed");
		assertEquals(inlineRegistration.getRequirementsBoxHeaderText(), "Requirements", "Requirements should be visible");
		assertEquals(inlineRegistration.getPasswordRequirementsText(1), "8-10", "Requirements should be visible");
		assertEquals(inlineRegistration.getPasswordRequirementsText(2), "A", "Requirements should be visible");
		assertEquals(inlineRegistration.getPasswordRequirementsText(3), "a", "Requirements should be visible");
		assertEquals(inlineRegistration.getPasswordRequirementsText(4), "0-9 or !&?", "Requirements should be visible");
		inlineRegistration.enterPassword("abc123$5");
		assertTrue(inlineRegistration.isPasswordValidationPointRequired(2), "Capital letter validation should be enabled");
		inlineRegistration.enterPassword("ABcd12#");
		assertTrue(inlineRegistration.isPasswordValidationPointRequired(1), "8-10 validation should be enabled");
		inlineRegistration.enterPassword("ABCD12345");
		assertTrue(inlineRegistration.isPasswordValidationPointRequired(3), "Lowercase validation should be enabled");
		inlineRegistration.enterPassword("ABCDabcde");
		assertTrue(inlineRegistration.isPasswordValidationPointRequired(4), "Number or special character validation should be enabled");
		inlineRegistration.enterPassword("asdQWE123");
		int numberOfValidationPoints = inlineRegistration.getNumberOfPasswordValidations();
		for (int point = 1; point <= numberOfValidationPoints; point++) {
			assertFalse(inlineRegistration.isPasswordValidationPointRequired(point), "Password should meet requirement");
		}
		assertEquals(inlineRegistration.getRequirementsBoxHeaderText(), "Success!", "Password box header should have 'Success' text");

		Logger.info("Verify 'Terms & Conditions' and 'Privacy Policy' hyperlinks");
		assertTrue(inlineRegistration.getTermsAndConditionsLinkText(1).contains("Terms & Conditions"), "'Terms & Conditions' text should be a hyperlink");
		assertTrue(inlineRegistration.getTermsAndConditionsHrefValue().contains("terms-of-use"), "'Terms and conditions' link should lead to correct page");
		assertTrue(inlineRegistration.getTermsAndConditionsLinkText(2).contains("Privacy Policy"), "'Privacy Policy' text should be a hyperlink");
		assertTrue(inlineRegistration.getPrivacyPolicyHrefValue().contains("privacy-policy"), "'Privacy Policy' link should lead to correct page");

		Logger.info("Registering user with valid data");
		inlineRegistration.createNewInlineRegistration(StringUtils.generateRandomEmail(), "EHtopic11");
		assertTrue(inlineRegistration.onGlobalNavHeader().isLoggedIn(), "User is not registered");
	}

	protected void verifySaveButtonFunctionalityForLoggedInUser(ArticleNewTemplatePage articleNewTemplatePage) {
		Logger.info("Verify 'Save' button functionality for logged in user");
		GlobalNavHeader globalNavHeader = articleNewTemplatePage.onGlobalNavHeader();
		globalNavHeader.clickLogin().enterCredentialsAndSubmitForm(UserCacheEH.MAIN_USER.getEmail(), UserCacheEH.MAIN_USER.getPassword());
		assertTrue(globalNavHeader.isLoggedIn(), "User should be logged in");
		String articleTitle = articleNewTemplatePage.getTitleText();
		SocialBarEH socialBarEH = articleNewTemplatePage.onSocialBar();
		assertTrue(socialBarEH.isSaveLinkVisible(), "'Save' link should be visible");
		if (!socialBarEH.getSaveLinkText().equals("Saved")) {
			socialBarEH.clickSaveLink();
			assertTrue(MarketingPixels.isOmnitureEventPresent("linkTrackEvents", "event101"), "Incorrect event fired");
			assertEquals(socialBarEH.getSaveLinkText(), "Saved", "'Save' button should change text to 'Saved'");
		}
		globalNavHeader.clickMyProfileButton();
		ArticleSavePage articleSavePage = globalNavHeader.clickProfileOverlayItem("Saved Items");
		assertTrue(articleSavePage.isSubcategoryVisible(), "Subcategory link should be visible");
		int counter = 1;
		while (counter <= 7) {
			if (articleSavePage.isArticleTitleVisibleInList(articleTitle)) {
				break;
			}
			counter++;
			Utils.waitFor(4000);
			articleNewTemplatePage.refresh();
		}
		assertTrue(articleSavePage.isEditLinkVisible(), "Edit link not visible");
		articleSavePage.clickEditLink();
		articleSavePage.clickOnSavedArticleDeleteButton(1, articleTitle);
		articleSavePage.clickDoneLink();
		assertFalse(articleSavePage.isArticleTitleVisibleInList(articleTitle), "Breadcrumb link should not be visible");
	}

	protected void verifyBreadcrumbs(ArticleNewTemplatePage articlePage, String category, String subCategory) {
		assertTrue(articlePage.isBreadcrumbVisible(), "Breadcrumb is not visible");
		category = category.replace(" ", "-");
		subCategory = subCategory.replace(" ", "-");
		if (category.equals(subCategory)) {
			Logger.info("Category value equals to subcategory, breadcrumb should not contain subcategory item");
			assertEquals(articlePage.getNumberOfBreadcrumbLinks(), 2, "2 links should be present in breadcrumb");
			assertEquals(articlePage.getNumberOfBreadcrumbArrows(), 2, "2 arrows should be present in breadcrumb");
			assertEquals(articlePage.getBreadcrumbHrefAttributeValue(1),
					Settings.getDefaultUrl() + "/",
					"First breadcrumb item should lead to homepage");
			assertTrue(articlePage.getBreadcrumbHrefAttributeValue(2).contains(category.toLowerCase()),
					"Second breadcrumb item should lead to category page");
		} else {
			Logger.info("Category and subcategory values are different, standard breadcrumb structure");
			assertEquals(articlePage.getNumberOfBreadcrumbLinks(), 3, "3 links should be present in breadcrumb");
			assertEquals(articlePage.getNumberOfBreadcrumbArrows(), 3, "3 arrows should be present in breadcrumb");

			assertEquals(articlePage.getBreadcrumbHrefAttributeValue(1), Settings.getDefaultUrl() + "/", "1st level breadcrumb should lead to homepage");
			assertTrue(articlePage.getBreadcrumbHrefAttributeValue(2).contains(category), "2nd level should contain category in URL");
			assertTrue(articlePage.getBreadcrumbHrefAttributeValue(3).contains(subCategory), "3rd level should contain subcategory in URL");
		}
	}

	protected void verifyGoogleMatchedContent(BasicPageEH basicPageEH) {
		basicPageEH.scrollDownThePage();
		assertTrue(basicPageEH.isGoogleMatchedSectionVisible(), "Google Matched should be visible");
		if (Settings.isDesktop()) {
			assertEquals(basicPageEH.getGMCCardSectionTitle(), "Recommended For You", "'Recommended for you' headline should be visible");
			basicPageEH.switchToGMIFrame(); //To switch IFrames
			assertTrue(basicPageEH.isGMCAdIconVisible(), "Google matched ad icon should be visible");
			int numberOfGMCCards = basicPageEH.getNumberOfGMCCards();
			assertEquals(numberOfGMCCards, 8, "8 cards should be present in google match content/recomended for you section");

			for (int card = 1; card <= numberOfGMCCards; card++) {
				assertFalse(basicPageEH.getGMCCardHrefAttributeValue(card).isEmpty(), "GMC card/Recommended for you section cards should be clickable");
				assertTrue(basicPageEH.isGMCCardHeadlineVisible(card), "Every GMC card should have headline/title");
				assertTrue(basicPageEH.isGMCCardImageVisible(card), "Every GMC card should have image");
			}
		}
	}

	protected void verifyLatestArticlesModule(BasicPageEH basicPageEH) {
		assertTrue(basicPageEH.isLatestArticlesModuleVisible(), "Latest Articles module should be visible");
		assertTrue(basicPageEH.isLatestArticlesTitleVisible(), "Latest Articles module title should be visible");
		String subcategory = basicPageEH.getSubCategoryForPage();
		assertEquals(basicPageEH.getLatestArticlesModuleTitleText(), "The Latest in " + subcategory, "Incorrect title text");
		int numberOfCards = basicPageEH.getNumberOfCardsInLatestArticlesModule();
		assertTrue(numberOfCards >= 1 && numberOfCards <= 20, "At least one card should be present in module, but not more than 20");
		if (!Settings.isMobile()) {
			for (int card = 1; card <= numberOfCards; card++) {
				if (card % 4 == 0) {
					basicPageEH.scrollToCard(card); //required as images are lazy-loaded
				}
				assertTrue(basicPageEH.isLatestArticlesModuleCardTitleVisible(card),
						"Each card should have title");
				assertFalse(basicPageEH.getLatestArticlesModuleCardHrefValue(card).isEmpty(),
						"Each card should have non-empty 'href' value");
				assertTrue(basicPageEH.isLatestArticlesModuleCardSubcategoryLinkVisible(card),
						"Each card should have subcategory link");
				assertEquals(basicPageEH.getLatestArticlesModuleCardSubcategoryText(card),
						subcategory,
						"Incorrect subcategory value");
				if (!basicPageEH.isLatestArticlesModuleCardDeckVisible(card)) {
					Logger.info("Content card #" + card + " does not have deck");
				} else {
					Logger.info("Content card #" + card + " has deck");
				}
				if (!basicPageEH.isLatestArticlesModuleCardImageVisible(card)) {
					Logger.info("Content card #" + card + " does not have image");
				} else {
					Logger.info("Content card #" + card + " has image");
				}
			}
		}
		if (Settings.isMobile()) {
			assertEquals(basicPageEH.getNumberOfVisibleTitles(),
					numberOfCards,
					"Each card should have title");
			assertEquals(basicPageEH.getNumberOfVisibleSubcategoryLinks(),
					numberOfCards,
					"Each card should have subcategory link");
		}
	}

	protected void verifyECommerceModule(ArticleNewTemplatePage articleNewTemplatePage) {
		int numberOfEComWidgets = articleNewTemplatePage.getNumberOfECommerceWidgets();
		assertTrue(numberOfEComWidgets >= 1, "At least one E-Commerce module should display ");
		Logger.info("Number of E-commerce widgets on page - " + numberOfEComWidgets);
		for (int widgetNumber = 1; widgetNumber <= numberOfEComWidgets; widgetNumber++) {
			assertTrue(articleNewTemplatePage.isECommerceModuleVisible(widgetNumber), "E-Commerce Module displayed");
			assertTrue(articleNewTemplatePage.isECommerceModuleTitleVisible(widgetNumber), "Each E-Commerce Module should have title");
			assertTrue(articleNewTemplatePage.isECommerceProductImageVisible(widgetNumber), "Each E-Commerce Module should have image");
			assertTrue(articleNewTemplatePage.isECommerceProdcutDescriptionVisible(widgetNumber), "Each E-Commerce Module should have description");
			String eComProdTitle = articleNewTemplatePage.getECommerceProductTitle(widgetNumber);
			String eComProdPrice = articleNewTemplatePage.getECommerceProductPrice(widgetNumber);
			String eComProdVendorName = articleNewTemplatePage.getECommerceProductVendorName(widgetNumber);
			assertEquals(articleNewTemplatePage.getECommerceProductTitleText(widgetNumber), "Shop This: " + eComProdTitle + ", " + eComProdPrice + ", " + eComProdVendorName, "Incorrect title text");
			assertTrue(articleNewTemplatePage.isECommerceProductAffliateTextVisible(widgetNumber), "Each E-Commerce Module should have affilicate text");
			assertTrue(articleNewTemplatePage.isECommerceImageCaptionVisible(widgetNumber), "Each E-Commerce Module should have image caption");
		}
	}

	protected void verifyPromoBannerSection(BasicPageEH basicPage) {
		if (!Settings.isEnvironment(Environment.PROD)) {
			if (basicPage.getAdZoneForPage().startsWith("/cs")) {
				assertFalse(basicPage.isPromoBannerVisible(), "Promo banner section should not be visible in /cs ad-zone");
			} else {
				assertTrue(basicPage.isPromoBannerVisible(), "Promo banner section should be visible");
				assertTrue(basicPage.isPromoBannerTextVisible(), "Promo banner text should be visible");
				assertFalse(basicPage.getPromoBannerLinkHrefValue().isEmpty(), "Promo banner link 'href' value should not be empty");
			}
		}
	}

	protected void verifyAOLPlayerFunctionality(BasicPageEH basicPage) {
		assertTrue(basicPage.isAOLPLayerVisible(), "AOL Player should be visible on page");
		String videoID = basicPage.getAOLPlayerVideoID();
		Logger.info("Video ID - " + videoID);
		basicPage.switchToAOLPlayerIFrame();

		if (basicPage.isAOLPlayerSpinnerVisible()) {
			Logger.info("Wait until video loads");
			basicPage.waitUntilSpinnerDisappears();
		}
		if (basicPage.isAOLPlayerUnMuteIconVisible()) {
			Logger.info("Video is muted");
			assertEquals(basicPage.getAOLPlayerVolumeValue(videoID), "0", "Volume value should be 0%");
			basicPage.switchToAOLPlayerIFrame();
			basicPage.clickAOLPlayerUnMuteIcon();
			assertFalse(basicPage.isAOLPlayerUnMuteIconVisible(), "'Unmute' icon should not be visible");
			assertEquals(basicPage.getAOLPlayerVolumeValue(videoID), "1", "Volume value should be 100%");
		}

		basicPage.switchToAOLPlayerIFrame();
		basicPage.aolPlayerMouseHover();
		assertTrue(basicPage.isAOLPlayerControlBarVisible(), "Control bar should be visible");
		basicPage.aolPlayerMouseHover();
		assertTrue(basicPage.isAOLPlayerPlayButtonVisible(), "'Play' button should be visible");
		assertEquals(basicPage.getAOLPlayerStatus(videoID), "playing", "Video should play");
		basicPage.switchToAOLPlayerIFrame();
		basicPage.aolPlayerMouseHover();
		basicPage.clickAOLPlayerPlayButton();
		assertEquals(basicPage.getAOLPlayerStatus(videoID), "paused", "Video should be paused");

		basicPage.switchToAOLPlayerIFrame();
		basicPage.aolPlayerMouseHover();
		assertTrue(basicPage.isAOLPlayerMuteButtonVisible(), "'Mute' button should be visible");
		basicPage.aolPlayerMouseHover();
		assertTrue(basicPage.isAOLPlayerFullScreenButtonVisible(), "'Fullscreen' button should be visible");
		basicPage.aolPlayerMouseHover();
		assertTrue(basicPage.isAOLPlayerProgressBarVisible(), "Progress bar should be visible");

		assertEquals(basicPage.getAOLPlayerVolumeValue(videoID), "1", "Volume value should be 100%");
		basicPage.switchToAOLPlayerIFrame();
		basicPage.aolPlayerMouseHover();
		basicPage.clickAOLPlayerMuteButton();
		assertEquals(basicPage.getAOLPlayerVolumeValue(videoID), "0", "Volume value should be 0%");
		basicPage.switchToAOLPlayerIFrame();
		basicPage.aolPlayerMouseHover();
		basicPage.clickAOLPlayerPlayButton();
		assertEquals(basicPage.getAOLPlayerStatus(videoID), "playing", "Video should play");
	}

	protected void verifyISIWidgets(BasicPageEH basicPageEH) {
		assertTrue(basicPageEH.getRightRailISIWidgetLocation().equalsIgnoreCase("RightRail"), "Right rail ISI widget position is incorrect");
		assertTrue(basicPageEH.isRightRailISIWidgetVisible(), "Right rail ISI widget is not visible");
		assertFalse(basicPageEH.getRightRailISIHeaderName().isEmpty(), "Right rail ISI widget header should not be empty");
		assertFalse(basicPageEH.getRightRailISIFooterName().isEmpty(), "Right rail ISI widget footer should not be empty");
		assertEquals(basicPageEH.getRightRailISIWidgetHeight(), 300, "Right rail ISI widget height is incorrect");

		assertTrue(basicPageEH.isBodyISIWidgetVisible(), "Body ISI widget not visible");
		assertTrue(basicPageEH.getBodyISIWidgetLocation().equalsIgnoreCase("BottomOfCenterWell"), "Body ISI widget position is incorrect");
		assertFalse(basicPageEH.getBodyISIHeaderName().isEmpty(), "Body ISI widget header should not be empty");
		assertFalse(basicPageEH.getBodyISIFooterName().isEmpty(), "Body ISI widget footer should not be empty");
		assertEquals(basicPageEH.getBodyISIWidgetHeight(), 200, "Body ISI widget height is incorrect");
	}

	protected void verifyIGNSingleVideo(IGNPlayerPage ignPlayerPage) {
		assertTrue(ignPlayerPage.isIGNPlayerVisible(), "Video module (IGN player) should be visible");
		ignPlayerPage.clickIGNPlayButton();
		assertFalse(ignPlayerPage.isIGNVideoPaused(), "Video should play after click on 'Play' button");
		ignPlayerPage.clickIGNPauseButton();
		assertTrue(ignPlayerPage.isIGNVideoPaused(), "Video should be paused after click on 'Pause' button");
		ignPlayerPage.clickIGNMuteButton();
		assertTrue(ignPlayerPage.isIGNVideoMuted(), "Video should be muted after click on volume button");
		ignPlayerPage.clickIGNMuteButton();
		assertFalse(ignPlayerPage.isIGNVideoMuted(), "Video should be muted after click on volume button");
		ignPlayerPage.clickIGNFullscreenButton();
		assertTrue(ignPlayerPage.isIGNVideoInFullscreenMode(), "Video should be in fullscreen mode after click on 'Fullscreen' button");
		ignPlayerPage.clickIGNFullscreenButton();
		assertFalse(ignPlayerPage.isIGNVideoInFullscreenMode(), "Video should not be in fullscreen mode after click on 'Fullscreen' button");
		assertTrue(ignPlayerPage.isIGNVideoCreditVisible(), "IGN video credit should be visible");
		assertTrue(ignPlayerPage.isIGNVideoCaptionVisible(), "IGN video caption should be visible");
		assertFalse(ignPlayerPage.getIGNVideoCaptionHrefValue().isEmpty(), "IGN video caption 'href' attribute value should not be empty");
		assertFalse(ignPlayerPage.getIGNVideoCreditHrefValue().isEmpty(), "IGN video credit 'href' attribute value should not be empty");
	}

	protected void verifyIGNMultipleVideos(IGNPlayerPage ignPlayerPage) {
		assertTrue(ignPlayerPage.isIGNPlayerVisible(), "Video module (IGN player) should be visible");
		int videoCount = ignPlayerPage.getIGNVideosCount();
		for (int videoNo = 1; videoNo <= videoCount; videoNo++) {

			ignPlayerPage.scrollVideoPlayerIntoView(videoNo);
			ignPlayerPage.clickIGNPlayButton(videoNo - 1);
			assertFalse(ignPlayerPage.isIGNVideoPaused(videoNo - 1), "Each Video should play after click on 'Play' button");
			ignPlayerPage.clickIGNPauseButton(videoNo - 1);
			assertTrue(ignPlayerPage.isIGNVideoPaused(videoNo - 1), "Each Video should be paused after click on 'Pause' button");
			ignPlayerPage.clickIGNMuteButton(videoNo - 1);
			assertTrue(ignPlayerPage.isIGNVideoMuted(videoNo - 1), "Each Video should be muted after click on volume button");
			ignPlayerPage.clickIGNMuteButton(videoNo - 1);
			assertFalse(ignPlayerPage.isIGNVideoMuted(videoNo - 1), "Each Video should be muted after click on volume button");
			ignPlayerPage.clickIGNFullscreenButton(videoNo - 1);
			assertTrue(ignPlayerPage.isIGNVideoInFullscreenMode(videoNo - 1), "Each Video should be in fullscreen mode after click on 'Fullscreen' button");
			ignPlayerPage.clickIGNFullscreenButton(videoNo - 1);
			assertFalse(ignPlayerPage.isIGNVideoInFullscreenMode(videoNo - 1), "Each Video should not be in fullscreen mode after click on 'Fullscreen' button");
			assertTrue(ignPlayerPage.isIGNVideoCreditVisible(videoNo - 1), "Each IGN video credit should be visible");
			assertTrue(ignPlayerPage.isIGNVideoCaptionVisible(videoNo - 1), "Each IGN video caption should be visible");
			assertFalse(ignPlayerPage.getIGNVideoCaptionHrefValue(videoNo - 1).isEmpty(), "Each IGN video caption 'href' attribute value should not be empty");
			assertFalse(ignPlayerPage.getIGNVideoCreditHrefValue(videoNo - 1).isEmpty(), "Each IGN video credit 'href' attribute value should not be empty");
		}
	}

	protected void verifyIGNVideoWithQueryString(IGNPlayerPage ignPlayerPage) {
		ignPlayerPage.scrollVideoPlayerIntoView();
		assertFalse(ignPlayerPage.isIGNVideoPaused(), "Video should directly play if we use query string '&autoplay' ");
		ignPlayerPage.scrollPage(2000); // for page to scroll down to pause// video
		assertTrue(ignPlayerPage.isIGNVideoPaused(), "Video should be paused if video is not in view with query string '&autopause' ");
		Utils.waitFor(1000); // for page to scroll uo and video to play
		ignPlayerPage.scrollPage(0);
		assertFalse(ignPlayerPage.isIGNVideoPaused(), "Video should not be paused if video is in view");
		assertFalse(ignPlayerPage.isFullScreenButtonOnIGNVideo(), "Full screen button not display on Video if we query string '&hideFullScreen'");
	}
}
