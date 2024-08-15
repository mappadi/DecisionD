package org.everydayhealth.tests.push.tests;

import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.push.PushEditPageBasePage;
import framework.platform.SiteNavigatorEH;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IGNVideoTest {

	@Test(groups = {"PUSHTest", "C383785"})
	@TestRail(id = "C383785")
	public void verifyIGNVideoUpload() {
		SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
		PushEditPageBasePage pushCreateTestPage = SiteNavigatorEH.goToMasterContentTestPage();
		pushCreateTestPage.clickMediaTab();
		pushCreateTestPage.clickVideoTab();
		pushCreateTestPage.clickInsertVideosButton();
		pushCreateTestPage.fillInputVideoId("d0e0566a50c1431c75c6a983b7e52388");
		pushCreateTestPage.selectIGNVideoProvider();
		assertEquals(pushCreateTestPage.getThumbUrlAutoPopulatedUrl(), "https://assets1.ignimgs.com/thumbs/userUploaded/2018/3/23/godofwardirectorcommentsyoutube-1521764846108_small.jpg");
		assertEquals(pushCreateTestPage.getStillUrlAutoPopulatedUrl(), "https://assets1.ignimgs.com/thumbs/userUploaded/2018/3/23/godofwardirectorcommentsyoutube-1521764846108_embed.jpg");
		pushCreateTestPage.selectMediaTag();
		pushCreateTestPage.clickMediaSaveButton();
		assertTrue(pushCreateTestPage.isVideoThumbVisible(), "Video thumbnail should be visible");
		pushCreateTestPage.hoverOverVideoThumb();
		pushCreateTestPage.clickDeleteButton();
		pushCreateTestPage.clickYesButton();
	}
}
