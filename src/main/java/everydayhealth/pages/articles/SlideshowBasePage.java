package everydayhealth.pages.articles;

import framework.Logger;
import framework.Settings;
import framework.platform.html.WebObject;
import org.openqa.selenium.WebDriver;

/**
 * SlideshowBase page Items
 */
public class SlideshowBasePage extends ArticleNewTemplatePage {

	public SlideshowBasePage(WebDriver driver) {
		super(driver);
		basedriver = driver;
		String DOMAIN_NAME = "articles";
		String CLASS_NAME = "SlideshowBasePage";
		super.initPage(DOMAIN_NAME, CLASS_NAME);
		loadObjectMap();
		initializeHtmlObjects(this, this.objectMap);
		waitForPageToLoad();
	}

	protected WebObject triggerGridView;
	protected WebObject nextSlideArrow;
	protected WebObject prevSlideArrow;
	protected WebObject prevSlideArrowDisabled;
	protected WebObject pinterestIcon;
	protected WebObject gridView;
	protected WebObject slideImage;
	protected WebObject interstialAd2;
	protected WebObject backToGallery;
	protected WebObject gridImages;
	protected WebObject gridImageTitle;
	protected WebObject nextSlideshowArrow;
	protected WebObject nextSlideshowThumbnail;
	protected WebObject nextSlideshowName;
	protected WebObject activeSlide;
	protected WebObject totalSlides;
	protected WebObject slideCopy;
	protected WebObject slideHeadline;
	protected WebObject slideHeadlineTablet;
	protected WebObject slideLastUpdatedDate;
	protected WebObject cusoSlideLastUpdatedDate;
	protected WebObject skipAdLink;
	protected WebObject slideInfo;

	@Override
	public void waitForPageToLoad() {
		title.waitUntilVisibleOnPage(this);
	}

	public boolean isNextSlideArrowVisible() {
		Logger.info("Verify next slide arrow is visible");
		return nextSlideArrow.isVisible();
	}

	public boolean isPrevSlideArrowVisible() {
		Logger.info("Verify previous slide arrow is visible");
		return !prevSlideArrowDisabled.getAttribute("class").contains("disabled");
	}

	public boolean isPinterestVisible() {
		Logger.info("Verify pinterest is visible");
		return pinterestIcon.isVisible();
	}

	public boolean isGridViewVisible() {
		Logger.info("Verify Grid View is visible");
		return gridView.isVisible();
	}

	public int getNumberOfClickableGridViewImages() {
		Logger.info("Verify Grid image is clickable");
		return gridImages.getNumberOfVisibleAndClickableElements();
	}

	public int getGridTriggerElement() {
		Logger.info("Get clickable grid trigger");
		return triggerGridView.getFirstVisibleAndClickableElement();
	}

	public boolean isTriggerGridViewVisible() {
		Logger.info("Verify trigger Grid View is visible");
		return triggerGridView.getVisibleElementsCount() > 0;
	}

	public void clickTriggerGridView() {
		Logger.info("Clicking on trigger grid view");
		triggerGridView.clickOnElementNumber(getGridTriggerElement());
		gridView.waitUntilVisible();
		waitForAjaxRequestToBeFinished();
	}

	public void clickGridImage(int gridImageNumber) {
		Logger.info("Click Grid View image");
		gridImages.clickOnElementNumber(gridImageNumber);
		waitForAjaxRequestToBeFinished();
	}

	public boolean isSlideImageVisible() {
		Logger.info("Verify slide Image is visible");
		return slideImage.isVisible();
	}

	public int getSlideshowImageXCoordinate() {
		return slideImage.getElement().getLocation().x;
	}

	public boolean isInterstialAd2Visible() {
		Logger.info("Verify interstialAd2 is visible");
		return interstialAd2.isVisible();
	}

	public void waitForSlideshowView() {
		Logger.info("Wait for Slideshow to be visible");
		backToGallery.waitUntilInvisible();
	}

	public void skipInterstialAd() {
		Logger.info("Skip interstial ad");
		nextSlideArrow.waitUntilVisible();
		nextSlideArrow.waitUntilClickable();
		if (Settings.isMobile()) {
			nextSlideArrow.click();
		} else {
			nextSlideArrow.actionClick();
		}
		waitForAjaxRequestToBeFinished();
	}

	public void skipCusoInterstialAd() {
		Logger.info("Skip interstial ad");
		skipAdLink.waitUntilVisible();
		skipAdLink.clickOnElementNumber(1);
		waitForAjaxRequestToBeFinished();
	}

	public void clickPreviousSlideArrow() {
		Logger.info("Clicking on previous slide arrow");
		prevSlideArrow.waitUntilClickable();
		prevSlideArrow.click();
		waitForAjaxRequestToBeFinished();
	}

	public void clickBackToGallery() {
		Logger.info("Clicking on back To Gallery");
		backToGallery.scrollToElement();
		backToGallery.click();
		waitForAjaxRequestToBeFinished();
	}

	public int getGridViewImagesVisibleCount() {
		Logger.info("Get grid view images visible count");
		gridImages.scrollToElement();
		backToGallery.scrollToElement();
		gridImages.waitUntilVisibilityOfAllElements();
		return gridImages.getVisibleElementsCount();
	}

	public int getGridImageTitlesVisibleCount() {
		Logger.info("Get grid view image titles visible count");
		return gridImageTitle.getVisibleElementsCount();
	}

	public int getCurrentSlideNumber() {
		waitFor(2000);// Wait for slide to load
		Logger.info("Get slide number: " + getActiveSlideIndex());
		return getActiveSlideIndex();
	}

	private int getActiveSlideIndex() {
		activeSlide.scrollToElement();
		return Integer.parseInt(activeSlide.getAttribute("data-id"));
	}

	public String getActiveSlideId() {
		Logger.info("Get active slide id");
		return activeSlide.getAttribute("data-id");
	}

	public boolean isFirstSlide() {
		return getActiveSlideIndex() == 1;
	}

	public int getTotalSlideCount() {
		return totalSlides.getElementsCount();
	}

	public boolean isLastSlide() {
		return getActiveSlideIndex() == getTotalSlideCount();
	}

	public boolean isSlideNumber(int slideNumber) {
		return getActiveSlideIndex() == slideNumber;
	}

	public boolean isSlideHeadlineVisible() {
		Logger.info("Verify slide headline is visible");
		return slideHeadline.isVisible();
	}

	public boolean isSlideCopyVisible(int slideNumber) {
		Logger.info("Verify if slide copy is visible");
		return slideCopy.isElementNumberVisible(slideNumber);
	}

	public boolean isSlideHeadlineForTabletVisible() {
		Logger.info("Verify slide headline is visible");
		return slideHeadlineTablet.isVisible();
	}

	public void clickNextSlideArrow() {
		Logger.info("Clicking on next slide arrow");
		try {
			int index = getActiveSlideIndex();
			while (getActiveSlideIndex() <= index) {
				nextSlideArrow.waitUntilClickable();
				nextSlideArrow.click();
				waitForAjaxRequestToBeFinished();
			}
		} catch (Exception e) {
			if (nextSlideshowArrow.isVisible()) {
				Logger.info("This is last slide");
			}
		}
	}

	public boolean isSlideLastUpdatedDateVisible() {
		Logger.info("Verify 'Last Updated Date' visible");
		return slideLastUpdatedDate.isVisible();
	}

	public boolean isCusoSlideLastUpdatedDateVisible() {
		Logger.info("Verify 'Last Updated Date' visible");
		return cusoSlideLastUpdatedDate.isVisible();
	}

	public boolean isNextSlideshowThumbnailVisible() {
		Logger.info("Verify next slideshow thumbnail visible");
		nextSlideshowArrow.mouseHover();
		return nextSlideshowThumbnail.isVisible();
	}

	public boolean isNextSlideshowTitleVisible() {
		Logger.info("Verify next slideshow title visible");
		return nextSlideshowName.isVisible();
	}

	public String getNextSlideshowLink() {
		Logger.info("Get next slideshow URL");
		return nextSlideshowArrow.getAttribute("href");
	}

	public void clickNextSlideshowLink() {
		Logger.info("Click on next slideshow link");
		nextSlideshowArrow.click();
		if (!Settings.isDesktop()) {
			waitFor(2000);//Wait for page to start load on device
		}
		waitForAjaxRequestToBeFinished();
	}

	public boolean isPreInterstialSlide() {
		return isSlideNumber(4) || isSecondLastSlide();
	}

	public boolean isSecondLastSlide() {
		return getCurrentSlideNumber() == getTotalSlideCount() - 1;
	}

	public boolean isInterstialAdVisible() {
		if (isSlideNumber(5)) {
			waitForAjaxRequestToBeFinished();
			return isAdDiv7Visible();
		} else {
			waitForAjaxRequestToBeFinished();
			return isInterstialAd2Visible();
		}
	}

	public String getSlideCount() {
		Logger.info("Get current slide number");
		return slideInfo.getText();
	}
}