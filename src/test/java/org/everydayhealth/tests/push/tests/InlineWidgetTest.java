package org.everydayhealth.tests.push.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.push.PushEditPageBasePage;
import framework.platform.SiteNavigatorEH;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InlineWidgetTest {

    @Test(groups = {"PUSHTest", "C383687"})
    @TestRail(id = "C383687")
    public void verifyInlineWidget() {
        SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
        PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToMasterContentTestPage();
        pushCreateTestPage.clickTextBlockTab();
        assertTrue(pushCreateTestPage.isEmbedButtonVisible(), "Embed button should be visible");
        pushCreateTestPage.clickAddEmbedButton();
        pushCreateTestPage.selectInlineContentCard();
        assertTrue(pushCreateTestPage.isImageUrlInputVisible(), "Image Url input should be visible");
        assertTrue(pushCreateTestPage.isDescriptionInputVisible(), "Description input should be visible");
        assertTrue(pushCreateTestPage.isLinkInputVisible(), "Link input should be visible");
        pushCreateTestPage.fillEnterNameInput("Test");
        pushCreateTestPage.fillImageUrlInput("https://www.faketestingurl.com/");
        pushCreateTestPage.fillDescriptionUrlInput("https://www.faketestingurl.com/");
        pushCreateTestPage.fillLinkInput("https://www.faketestingurl.com/");
        pushCreateTestPage.clickEmbedSaveButton();
        pushCreateTestPage.isShortCodeLinkVisible();
        pushCreateTestPage.clickDeleteWidget();
        pushCreateTestPage.clickAddEmbedButton();
        pushCreateTestPage.selectRelatedContentCard();
        pushCreateTestPage.fillEnterNameInput("Test");
        pushCreateTestPage.fillImageUrlTwoInput("https://www.faketestingurl.com/");
        pushCreateTestPage.fillDescriptionUrlTwoInput("https://www.faketestingurl.com/");
        pushCreateTestPage.fillLinkTwoInput("https://www.faketestingurl.com/");
        pushCreateTestPage.clickEmbedSaveButton();
    }

    @Test(groups = {"PUSHTest", "C383730"})
    @TestRail(id = "C383730")
    public void verifyEcommerceModule() {
        SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
        PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToMasterContentTestPage();
        pushCreateTestPage.clickTextBlockTab();
        assertTrue(pushCreateTestPage.isEmbedButtonVisible(), "Embed button should be visible");
        pushCreateTestPage.clickAddEmbedButton();
        pushCreateTestPage.selectEcommerceModule();
        pushCreateTestPage.fillEnterNameInput("Test");
        assertEquals(pushCreateTestPage.getTitleInputText(), "Title");
    }
}
