package org.everydayhealth.tests;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.testrail.framework.platform.annotations.TestRail;
import everydayhealth.pages.articles.IGNPlayerPage;
import everydayhealth.pages.push.PushDashboardPage;
import framework.Logger;
import framework.Settings;
import framework.adapters.WebDriverManager;
import framework.platform.Environment;
import framework.platform.SiteNavigatorBase;
import framework.platform.SiteNavigatorEH;
import framework.platform.utilities.CSVparser;
import framework.platform.utilities.JsonUtils;
import framework.platform.utilities.StringUtils;
import framework.platform.utilities.Utils;
import jlibs.core.lang.Ansi;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.testng.Assert.*;

/**
 * LinkCheckerTest
 */
public class LinkCheckerTest {

	private static int linksCount = 0;
	private static int connectionErrorCounter = 0;
	private static int pageSourceContentCounter = 0;
	private static String publisherStatic = "{\"@type\":\"Organization\",\"name\":\"Everyday Health\",\"logo\":{\"@type\":\"ImageObject\",\"width\":200,\"url\":\"http://images.agoramedia.com/everydayhealth/logos/eh%20logo.png\",\"height\":50}}";

	private static Ansi ansiOut = new Ansi(Ansi.Attribute.BRIGHT, Ansi.Color.GREEN, Ansi.Color.WHITE);
	private static Ansi ansiBlue = new Ansi(Ansi.Attribute.BRIGHT, Ansi.Color.BLUE, Ansi.Color.WHITE);
	private static Ansi ansiErr = new Ansi(Ansi.Attribute.BRIGHT, Ansi.Color.RED, Ansi.Color.WHITE);

	File directory = new File(".");
	private static Map<String, Object[]> data = new LinkedHashMap<>();

	@Test(groups = {"VerifyPageLoading"})
	@TestRail(id = "VerifyPageLoading")
	public void verifyPageLoaded() {
		List<String> links = new CSVparser().getLinksFromCSV();
		linksCount = links.size();
		for (String url : links) {
			try {
				Logger.info("Check URL: " + url);
				WebDriverManager.getDriver().navigate().to(url);
				new WebDriverWait(WebDriverManager.getDriver(), 15).until((ExpectedCondition<Boolean>) wd ->
						((Boolean) ((JavascriptExecutor) wd).executeScript("return document.readyState == 'complete' && window.jQuery != undefined && jQuery.active == 0")));
				ansiOut.outln("Page: " + url + " loaded successfully");
			} catch (Exception exception) {
				connectionErrorCounter++;
				ansiErr.outln("Connection to URL: " + url + " failed");
			}
		}

		ansiOut.outln("Total amount of links checked: " + linksCount);
		ansiOut.outln("Successful checks: " + (linksCount - connectionErrorCounter));
		ansiErr.outln("Connections failed: " + connectionErrorCounter);
	}

	@Test(groups = {"VerifyPageContent"})
	@TestRail(id = "VerifyPageContent")
	public void verifyTextOnPage() {
		List<String> links = new CSVparser().getLinksFromCSV();
		linksCount = links.size();
		for (String urls : links) {
			String[] pairs = urls.split(",");
			StringBuilder pageSource = new StringBuilder();
			try {
				Logger.info("Check URL: " + pairs[0] + " for text: " + pairs[1]);
				HttpURLConnection connection = (HttpURLConnection) new URL(pairs[0]).openConnection();
				InputStream inputStreamFromURL = new BufferedInputStream(connection.getInputStream());
				Reader readerOfInputStream = new InputStreamReader(inputStreamFromURL);
				int counter;
				while ((counter = readerOfInputStream.read()) != -1) {
					pageSource.append(String.valueOf((char) counter));
				}
			} catch (IOException exception) {
				Logger.debug(exception.getLocalizedMessage());
				connectionErrorCounter++;
				ansiErr.outln("Connection to URL: " + pairs[0] + " FAILED!");
				continue;
			}
			try {
				checkPageForErrors(pairs[0], pageSource);
				assertTrue(pageSource.toString().contains(pairs[1]), "Page should contain given text");
				ansiOut.outln("URL: " + pairs[0] + " contains no errors and given text is present in page source");
			} catch (AssertionError e) {
				Logger.debug(e.getLocalizedMessage());
				pageSourceContentCounter++;
				ansiErr.outln("URL: " + pairs[0] + " does not contain given text or error message was shown");
			}
		}

		ansiOut.outln("Total amount of links checked: " + linksCount);
		ansiErr.outln("Connections failed: " + connectionErrorCounter);
		ansiErr.outln("Page content failures: " + pageSourceContentCounter);
		ansiOut.outln("Successful checks: " + (linksCount - connectionErrorCounter - pageSourceContentCounter));
	}

	@Test(groups = {"VerifyPageHttpsLinks"})
	@TestRail(id = "VerifyPageHttpsLinks")
	public void verifyPageHttpsLinks() {
		List<String> links = new CSVparser().getLinksFromCSV();
		linksCount = links.size();
		data.put("0", new Object[]{"Original URL", "http links"});
		int totalCounter = 1;
		for (String url : links) {
			totalCounter++;
			StringBuilder pageSource = new StringBuilder();
			try {
				Logger.info("Check URL: " + url + " for https links");
				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
				InputStream inputStreamFromURL = new BufferedInputStream(connection.getInputStream());
				Reader readerOfInputStream = new InputStreamReader(inputStreamFromURL);
				int counter;
				while ((counter = readerOfInputStream.read()) != -1) {
					pageSource.append(String.valueOf((char) counter));
				}
			} catch (IOException exception) {
				Logger.debug(exception.getLocalizedMessage());
				connectionErrorCounter++;
				ansiErr.outln("Connection to URL: " + url + " FAILED!");
				continue;
			}
			List<String> httpLinks = new ArrayList<>();
			try {
				String[] splitLinks = pageSource.toString().split("href=\"http://");
				for (String link : splitLinks) {
					if (!link.contains("<!DOCTYPE html>") && !link.contains("/groups") && !link.contains("/forums")) {
						httpLinks.add(link.split("\"")[0]);
					}
				}
				data.put(String.valueOf(totalCounter + 1), new Object[]{url, httpLinks.toString()});
				assertTrue(httpLinks.size() == 0, "There are " + httpLinks.size() + " http links on the page " + url + " : " + httpLinks);
				ansiOut.outln("URL: " + url + " contains no errors and all links are https");
			} catch (AssertionError e) {
				Logger.debug(e.getLocalizedMessage());
				pageSourceContentCounter++;
				ansiErr.outln("URL: " + url + " does not contain https links: " + httpLinks);
			}
		}

		generateXLSXReport();

		ansiOut.outln("Total amount of links checked: " + linksCount);
		ansiErr.outln("Connections failed: " + connectionErrorCounter);
		ansiErr.outln("Page https failures: " + pageSourceContentCounter);
		ansiOut.outln("Successful checks: " + (linksCount - connectionErrorCounter - pageSourceContentCounter));
	}

	private void checkPageForErrors(String url, StringBuilder pageSource) {
		if (url.contains("medpagetoday.com")) {
			assertFalse(pageSource.toString().contains("We cannot find the page you are seeking."), "Page should not contain error messages");
		} else if (url.contains("everydayhealth.com")) {
			assertFalse(pageSource.toString().contains("Oops, that page seems \\n to be on sick leave!"), "Page should not contain error messages");
		} else if (url.contains("whattoexpect.com")) {
			assertFalse(pageSource.toString().contains("Whoops! How did that happen?"), "Page should not contain error messages");
		}
	}

	@Test(groups = {"VerifyLinksStatuses"})
	@TestRail(id = "C0003")
	public void verifyPageStatuses() {
		List<String> links = new CSVparser().getLinksFromCSV();
		Map<Integer, Integer> responseCodeMap = new HashMap<Integer, Integer>();
		linksCount = links.size();
		int totalCounter = 1;
		data.put("0", new Object[]{"Original URL", "Returned URL(May or May not be redirected)", "Response code", "Number of redirects"});
		for (String url : links) {
			try {
				Logger.info("URL Number: " + totalCounter);
				Logger.info("Verifying page: " + url);
				totalCounter++;
				if (url.startsWith("~")) {
					url = url.replace("~", Settings.getDefaultUrl());
				}

				HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
				connection.setInstanceFollowRedirects(false);
				int numberOfRedir = 0;
				int status = connection.getResponseCode();
				String openedPageUrl = connection.getURL().toString();
				if (status == HttpURLConnection.HTTP_MOVED_PERM || status == HttpURLConnection.HTTP_MOVED_TEMP || status == HttpURLConnection.HTTP_SEE_OTHER) {
					Logger.info("This URL is redirected");
					numberOfRedir = 1;
					incrementResponseCodeInMap(responseCodeMap, status);
					while (status == 301) {
						openedPageUrl = connection.getHeaderField("Location");
						if (openedPageUrl.startsWith("/")) {
							openedPageUrl = Settings.getDefaultUrl() + openedPageUrl;
						}
						connection = (HttpURLConnection) new URL(openedPageUrl).openConnection();
						connection.setInstanceFollowRedirects(false);
						status = connection.getResponseCode();
						openedPageUrl = connection.getURL().toString();
						if (status == 301) {
							numberOfRedir++;
						}
						if (numberOfRedir > 4) {
							break;
						}
					}
				} else {
					ansiOut.outln("Response Code is: " + status);
					incrementResponseCodeInMap(responseCodeMap, status);
				}
				data.put(String.valueOf(totalCounter + 1), new Object[]{url, openedPageUrl, String.valueOf(status), String.valueOf(numberOfRedir)});
			} catch (Exception e) {
				data.put(String.valueOf(totalCounter + 1), new Object[]{url, "Connection ERROR"});
				Logger.debug(e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
		System.out.println("-----------------------------------");
		Logger.info("Summary is as follows:");
		Logger.info("Total amount of links checked: " + linksCount);
		SortedSet<Integer> keys = new TreeSet<Integer>(responseCodeMap.keySet());
		for (Integer key : keys) {
			Logger.info("Total Number of URLs with " + key + " status code:  " + responseCodeMap.get(key));
		}
		generateXLSXReport();
	}

	private void incrementResponseCodeInMap(Map<Integer, Integer> responseCodeMap, Integer status) {
		int frequencyOfError = responseCodeMap.containsKey(status) ? responseCodeMap.get(status) : 0;
		responseCodeMap.put(status, frequencyOfError + 1);
	}

	@Test(groups = {"VerifyDataSchemaForArticlePages"})
	@TestRail(id = "C0004")
	public void verifyDataSchemaArticle() {
		List<String> links = new CSVparser().getLinksFromCSV();
		linksCount = links.size();
		Document doc = null;
		String protocol = "https://";
		for (String url : links) {
			try {
				url = url.replace("~", Settings.getDefaultUrl());
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + url + " FAILED!");
				continue;
			}
			try {
				Element element = doc.select("script[type=application/ld+json]").first();
				JsonUtils.setStringJson(element.data());
				checkStaticValuesOnPage(url, protocol);
				checkNonStaticValuesOnPage(doc);
				verifyImageURLandWidth(doc);

			} catch (AssertionError | NullPointerException | DateTimeParseException exception) {
				Logger.info("Schema mismatch found for URL: " + url);
				Logger.info(exception.getLocalizedMessage());
				pageSourceContentCounter++;
			}
		}
		System.out.println("-----------------------------------");
		Logger.info("Summary is as follows:");
		Logger.info("Total amount of links checked: " + linksCount);
		Logger.info("Connection errors: " + connectionErrorCounter);
		Logger.info("Schema mismatch errors: " + pageSourceContentCounter);
		Logger.info("Successful checks: " + (linksCount - connectionErrorCounter - pageSourceContentCounter));
	}

	@Test(groups = {"VerifyVideoPages"})
	@TestRail(id = "C0005")
	public void verifyIGNPlayerFunctionality() {
		List<String> links = new CSVparser().getLinksFromCSV();
		linksCount = links.size();
		int totalCounter = 1;
		data.put("0", new Object[]{"URL", "Number of non-agnostic URLs"});
		for (String url : links) {
			try {
				totalCounter++;
				if (totalCounter % 20 == 0) {
					createNewTabAndSwitch(WebDriverManager.getDriver());
				}
				IGNPlayerPage articleVideoPage = SiteNavigatorBase.openPage(url, IGNPlayerPage.class);
				Utils.captureScreenShot(StringUtils.generateRandomNumeric(20) + ".png");
				assertTrue(articleVideoPage.isIGNPlayerVisible(), "Video module (IGN player) should be visible");
				assertTrue(articleVideoPage.isIGNVideoHeaderTitleVisible(), "Video header should be visible");
				articleVideoPage.scrollVideoPlayerIntoView();
				articleVideoPage.clickIGNPlayButton();
				assertFalse(articleVideoPage.isIGNVideoPaused(), "Video should play after click on 'Play' button");
				articleVideoPage.clickIGNPauseButton();
				assertTrue(articleVideoPage.isIGNVideoPaused(), "Video should be paused after click on 'Pause' button");
				articleVideoPage.clickIGNPauseButton();
				assertFalse(articleVideoPage.isIGNVideoPaused(), "Video should play after click on 'Play' (on control bar) button");
				articleVideoPage.clickIGNPauseButton();

				articleVideoPage.clickIGNMuteButton();
				assertTrue(articleVideoPage.isIGNVideoMuted(), "Video should be muted after click on volume button");
				articleVideoPage.clickIGNMuteButton();
				assertFalse(articleVideoPage.isIGNVideoMuted(), "Video should be muted after click on volume button");

				articleVideoPage.clickIGNFullscreenButton();
				assertTrue(articleVideoPage.isIGNVideoInFullscreenMode(), "Video should be in fullscreen mode after click on 'Fullscreen' button");
				articleVideoPage.clickIGNFullscreenButton();
				assertFalse(articleVideoPage.isIGNVideoInFullscreenMode(), "Video should not be in fullscreen mode after click on 'Fullscreen' button");
			} catch (AssertionError | Exception e) {
				connectionErrorCounter++;
				data.put(String.valueOf(totalCounter), new Object[]{url, e.getMessage()});
			}
			data.put(String.valueOf(totalCounter), new Object[]{url, "PASSED"});
		}
		System.out.println("-----------------------------------");
		Logger.info("Summary is as follows:");
		Logger.info("Total amount of links checked: " + linksCount);
		Logger.info("Page with errors: " + connectionErrorCounter);
		generateXLSXReport();
	}

	@Test(groups = {"VerifyEmbeddedRedirects"})
	@TestRail(id = "C0006")
	public void testEmbeddedRedirects() {
		List<String> data = new CSVparser().getLinksFromCSV();
		linksCount = data.size();
		Document doc = null;
		int totalCounter = 1;
		for (String line : data) {
			Logger.info("URL Number: " + totalCounter);
			totalCounter++;
			String[] lineWithDelimiters = line.split(",");
			String url = lineWithDelimiters[0];
			String anchorText = lineWithDelimiters[1];
			String urlToCompare = lineWithDelimiters[2];
			String linkText = "";
			try {
				url = url.replace("~", Settings.getDefaultUrl());
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + url + " FAILED!");
				continue;
			}
			try {
				linkText = anchorText.replace("|", ",");
				Element element = doc.select(String.format("a:containsOwn(%s)", linkText)).first();
				assertEquals(element.attr("abs:href"), urlToCompare, "FAILED! Incorrect URL"); //'abs:href' means absolute url 'http://www.everydayhealth.com/news/' instead of relative '/news'
				Logger.info("PASSED! Correct link for '" + anchorText + "' on page " + url);
			} catch (AssertionError | NullPointerException | IllegalArgumentException exception) {
				Logger.info(exception.getLocalizedMessage() + " URL for '" + linkText + "' link on page " + url);
				pageSourceContentCounter++;
			}
		}
		System.out.println("-----------------------------------");
		Logger.info("Summary is as follows:");
		Logger.info("Total amount of links checked: " + linksCount);
		Logger.info("Connection errors: " + connectionErrorCounter);
		Logger.info("Number of incorrect links: " + pageSourceContentCounter);
		Logger.info("Successful checks: " + (linksCount - connectionErrorCounter - pageSourceContentCounter));
	}

	@Test(groups = {"VerifyDrugsContent"})
	@TestRail(id = "C0007")
	public void verifyDrugsContent() {
		Document doc = null;
		Document doc1 = null;
		List<String> links = new CSVparser().getLinksFromCSV();
		int totalCounter = 1;
		data.put("0", new Object[]{"Drug name", "Test result", ""});
		String qa1 = Settings.isQA() ? ".qa1" : "";
		for (String link : links) {
			Logger.info("URL Number: " + totalCounter + ". Drug - " + link);
			totalCounter++;
			String urlDrugsApi = "http://services" + qa1 + ".everydayhealth.com/ContentAPI/api/Content/V1/277/getPage?maskUrl=~/drugs/" + link;
			String urlDrugsServices = "http://services" + qa1 + ".waterfrontmedia.com/drugsservice/Drug.svc/Profile/" + link;
			try {
				doc = Jsoup.connect(urlDrugsServices).ignoreContentType(true).timeout(15000).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + urlDrugsServices + " FAILED!");
				Logger.info("---------------------------------------------------");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "Connection to URL: " + urlDrugsServices + " FAILED!"});
				continue;
			}
			try {
				doc1 = Jsoup.connect(urlDrugsApi).ignoreContentType(true).timeout(15000).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + urlDrugsApi + " FAILED!");
				Logger.info("---------------------------------------------------");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "Connection to URL: " + urlDrugsApi + " FAILED!"});
				continue;
			}
			try {
				linksCount++;
				JsonParser jsonParserApi = new JsonParser();
				if (doc1.body().text().equals("null")) {
					data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "No data for this drug in API"});
					continue;
				}
				JsonArray locationsArray = jsonParserApi.parse(doc1.body().text()).getAsJsonObject().get("Content").getAsJsonObject().getAsJsonArray("Locations");
				String basicsText = locationsArray.get(0).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				String sideEffectsText = locationsArray.get(1).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				String interactionText = locationsArray.get(2).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				String dosageText = locationsArray.get(3).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				JsonArray faqArray = locationsArray.get(4).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("AttributeList");
				StringBuilder faqText = new StringBuilder();
				int faqArraySize = faqArray.size();
				for (int arrayItem = 0; arrayItem < faqArraySize; arrayItem++) {
					JsonElement questionText = faqArray.get(arrayItem).getAsJsonArray().get(0).getAsJsonObject().get("Value");
					JsonElement answerText = faqArray.get(arrayItem).getAsJsonArray().get(1).getAsJsonObject().get("Value");
					faqText.append(questionText.getAsString()).append(answerText.getAsString());
				}

				JsonParser jsonParserDrugsService = new JsonParser();
				JsonElement drugProfileContent = jsonParserDrugsService.parse(doc.body().text()).getAsJsonObject().get("DrugProfile");
				if (drugProfileContent.equals("null")) {
					data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "No data for this drug in DrugsServices"});
					continue;
				}
				JsonElement basicsSectionContent = drugProfileContent.getAsJsonObject().get("Basics");
				JsonArray whatIsSection = basicsSectionContent.getAsJsonObject().getAsJsonArray("WhatIs");
				JsonArray importantSection = basicsSectionContent.getAsJsonObject().getAsJsonArray("Important");
				JsonArray notTakeSection = basicsSectionContent.getAsJsonObject().getAsJsonArray("NotTake");
				JsonArray sideEffectsSectionContent = drugProfileContent.getAsJsonObject().get("SideEffects").getAsJsonObject().getAsJsonArray("Content");
				JsonElement interactionContent = drugProfileContent.getAsJsonObject().get("Interactions");
				JsonArray avoidSectionContent = interactionContent.getAsJsonObject().getAsJsonArray("Avoid");
				JsonArray drugsSectionContent = interactionContent.getAsJsonObject().getAsJsonArray("Drugs");
				JsonElement dosageContent = drugProfileContent.getAsJsonObject().get("Dosage");
				JsonArray howToTakeContent = dosageContent.getAsJsonObject().getAsJsonArray("HowToTake");
				JsonArray missDoseContent = dosageContent.getAsJsonObject().getAsJsonArray("MissDose");
				JsonArray overDoseContent = dosageContent.getAsJsonObject().getAsJsonArray("OverDose");
				JsonArray faqContent = drugProfileContent.getAsJsonObject().get("Faqs").getAsJsonObject().getAsJsonArray("QuestionAnswers");

				Logger.info("Verify 'Basics' section content is present in Drugs API");
				verifyStringContainsJsonArrayElements(basicsText, whatIsSection);
				verifyStringContainsJsonArrayElements(basicsText, importantSection);
				verifyStringContainsJsonArrayElements(basicsText, notTakeSection);
				Logger.info("Verify 'Side Effects' section content is present in Drugs API");
				verifyStringContainsJsonArrayElements(sideEffectsText, sideEffectsSectionContent);
				Logger.info("Verify 'Interactions' section content is present in Drugs API");
				verifyStringContainsJsonArrayElements(interactionText, avoidSectionContent);
				verifyStringContainsJsonArrayElements(interactionText, drugsSectionContent);
				Logger.info("Verify 'Dosage' section content is present in Drugs API");
				verifyStringContainsJsonArrayElements(dosageText, howToTakeContent);
				verifyStringContainsJsonArrayElements(dosageText, missDoseContent);
				verifyStringContainsJsonArrayElements(dosageText, overDoseContent);

				Logger.info("Verify 'FAQ' section content is present in Drugs API");
				int faqContentArraySize = faqContent.size();
				for (int itemNumber = 0; itemNumber < faqContentArraySize; itemNumber++) {
					String questionText = faqContent.get(itemNumber).getAsJsonObject().get("Question").getAsString();
					Logger.info("Verify question '" + questionText + "' is present in Drugs API");
					String answerText = faqContent.get(itemNumber).getAsJsonObject().get("Answer").getAsString().replace("</a>", "");
					Logger.info("Verify answer '" + answerText + "' is present in Drugs API");
					assertTrue(faqText.toString().contains(questionText), "Question is not present in Drugs API");
					assertTrue(faqText.toString().contains(answerText), "Answer is not present in Drugs API");
				}
				Logger.info("Verification successfull for drug: " + link);
				pageSourceContentCounter++;
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "PASSED", ""});
				Logger.info("---------------------------------------------------");
			} catch (AssertionError e) {
				Logger.info("Content from DrugsServices is not present in Drugs API for drug - '" + link);
				String errorMessage = e.getMessage();
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", errorMessage.substring(0, errorMessage.indexOf("expected"))});
				continue;
			} catch (Exception e) {
				Logger.info("JSON Structure differs from given for drug - " + link);
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "JSON structure differs from given"});
			}
		}
		System.out.println("-----------------------------------");
		Logger.info("Summary is as follows:");
		Logger.info("Total amount of links checked: " + linksCount);
		Logger.info("Connection errors: " + connectionErrorCounter);
		Logger.info("Successful checks: " + pageSourceContentCounter);
		Logger.info("Failed checks: " + (linksCount - connectionErrorCounter - pageSourceContentCounter));
		generateXLSXReport();
	}

	@Test(groups = {"VerifyDrugsPageContent"})
	@TestRail(id = "C0008")
	public void verifyDrugsPageContent() {
		Document docQA1 = null;
		Document docPROD = null;
		List<String> links = new CSVparser().getLinksFromCSV();
		int totalCounter = 1;
		data.put("0", new Object[]{"Drug name", "Test result", "Error message (if present)"});
		for (String link : links) {
			Logger.info("URL Number: " + totalCounter + ". Drug - " + link);
			totalCounter++;
			String qa1URL = "http://qa1.everydayhealth.com/drugs/" + link;
			String prodURL = "http://www.everydayhealth.com/drugs/" + link;
			try {
				docPROD = Jsoup.connect(prodURL).ignoreContentType(true).userAgent("Mozilla/5.0").timeout(15000).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + prodURL + " FAILED!");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "Connection to URL: " + prodURL + " FAILED!"});
				Logger.info("---------------------------------------------------");
				continue;
			}

			try {
				docQA1 = Jsoup.connect(qa1URL).ignoreContentType(true).userAgent("Mozilla/5.0").timeout(15000).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + qa1URL + " FAILED!");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "Connection to URL: " + qa1URL + " FAILED!"});
				Logger.info("---------------------------------------------------");
				continue;
			}
			try {
				Element breadcrumbPROD = docPROD.select("ul.breadcrumb").first();
				Element breadcrumbQA1 = docQA1.select("ul.breadcrumb").first();
				assertEquals(breadcrumbQA1.text(), breadcrumbPROD.text(), "Breadcrumbs should be equal for QA1 and PROD environments");

				Elements navigationMenuPROD = docPROD.select("ul.navigation>li");
				Elements navigationMenuQA1 = docQA1.select("ul.navigation>li");
				assertEquals(navigationMenuQA1.size(), navigationMenuPROD.size(), "Number of elements in navigation menu should be equal for QA1 and PROD environments");

				Element drugNamePROD = docPROD.select("#top-bar h1").first();
				Element drugNameQA1 = docQA1.select("#top-bar h1").first();
				assertEquals(drugNameQA1.text(), drugNamePROD.text(), "Drug name should be equal for QA1 and PROD environments");

				Element reviewsCounterPROD = docPROD.select(".review-links a").first();
				Element reviewsCounterQA1 = docQA1.select(".review-links a").first();
				if (reviewsCounterPROD == null && reviewsCounterQA1 == null) {
					Logger.info("Reviews are not available for drug - " + link);
				} else if (reviewsCounterPROD != null && reviewsCounterQA1 != null) {
					assertEquals(reviewsCounterQA1.text(), reviewsCounterPROD.text(), "Number of reviews should be equal for QA1 and PROD environments");
				} else {
					Logger.info("Reviews are available only on one of the environments for drug - " + link);
				}

				Elements basicsParagraphsPROD = docPROD.select("#basics>.section_content p");
				Elements basicsParagraphsQA1 = docQA1.select("#basics>.section_content p");
				assertEquals(basicsParagraphsQA1.size(), basicsParagraphsPROD.size(), "Number of paragraphs in 'Basics' section should be equal for QA1 and PROD environments");

				Element basicsSectionPROD = docPROD.select("#basics>.section_content").first();
				Element basicsSectionQA1 = docQA1.select("#basics>.section_content").first();
				assertEquals(basicsSectionQA1.text(), basicsSectionPROD.text().replace(" Back to Top", ""), "'Basics' section content should be equal for QA1 and PROD environments");

				Elements sideEffectsParagraphsPROD = docPROD.select("#sideeffects>.section_content p");
				Elements sideEffectsParagraphsQA1 = docQA1.select("#sideeffects>.section_content p");
				assertEquals(sideEffectsParagraphsQA1.size(), sideEffectsParagraphsPROD.size(), "Number of paragraphs in 'Side Effects' section should be equal for QA1 and PROD environments");

				Element sideEffectsSectionPROD = docPROD.select("#sideeffects>.section_content").first();
				Element sideEffectsSectionQA1 = docQA1.select("#sideeffects>.section_content").first();
				assertEquals(sideEffectsSectionQA1.text(), sideEffectsSectionPROD.text().replace(" Back to Top", ""), "'Side Effects' section content should be equal for QA1 and PROD environments");

				Elements interactionsParagraphsPROD = docPROD.select("#interactions>.section_content p");
				Elements interactionsParagraphsQA1 = docQA1.select("#interactions>.section_content p");
				assertEquals(interactionsParagraphsQA1.size(), interactionsParagraphsPROD.size(), "Number of paragraphs in 'Interactions' section should be equal for QA1 and PROD environments");

				Element interactionsSectionPROD = docPROD.select("#interactions>.section_content").first();
				Element interactionsSectionQA1 = docQA1.select("#interactions>.section_content").first();
				assertEquals(interactionsSectionQA1.text(), interactionsSectionPROD.text().replace(" Back to Top", ""), "'Interactions' section content should be equal for QA1 and PROD environments");

				Elements dosageParagraphsPROD = docPROD.select("#dosage>.section_content p");
				Elements dosageParagraphsQA1 = docQA1.select("#dosage>.section_content p");
				assertEquals(dosageParagraphsQA1.size(), dosageParagraphsPROD.size(), "Number of paragraphs in 'Dosage' section should be equal for QA1 and PROD environments");

				Element dosageSectionPROD = docPROD.select("#dosage>.section_content").first();
				Element dosageSectionQA1 = docQA1.select("#dosage>.section_content").first();
				assertEquals(dosageSectionQA1.text(), dosageSectionPROD.text().replace(" Back to Top", ""), "'Dosage' section content should be equal for QA1 and PROD environments");

				Element faqSectionPROD = docPROD.select("#faq>.section_content").first();
				Element faqSectionQA1 = docQA1.select("#faq>.section_content").first();
				if (faqSectionPROD == null && faqSectionQA1 == null) {
					Logger.info("FAQ section is not present for drug - " + link);
				} else {
					assertEquals(faqSectionQA1.text(), faqSectionPROD.text(), "'FAQ' section content should be equal for QA1 and PROD environments");
				}
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "PASSED", ""});
				Logger.info("-----------------------------------------------------------");
			} catch (AssertionError e) {
				Logger.info("Test failed");
				String errorMessage = e.getMessage();
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", errorMessage.substring(0, errorMessage.indexOf("expected"))});
			} catch (NullPointerException e) {
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "Reviews are present only on one of the environments."});
			}
		}
		generateXLSXReport();
	}

	@Test(groups = {"ParseDrugsPageContent"})
	@TestRail(id = "C0009")
	public void parseDrugsPageContent() {
		Document doc = null;
		List<String> links = new CSVparser().getLinksFromCSV();
		int totalCounter = 1;
		data.put("0", new Object[]{"Breadcrumb text", "Number of menu items in navigation", "Drug name", "Number of reviews", "Basics text", "Side effects text", "Interactions text", "Dosage text", "FAQ", "FAQ", "FAQ", "FAQ"});
		for (String link : links) {
			Logger.info("URL Number: " + totalCounter + ", drug - " + link);
			totalCounter++;
			String URL = Settings.getDefaultUrl() + "/drugs/" + link;
			Logger.info(URL);
			try {
				doc = Jsoup.connect(URL).ignoreContentType(true).userAgent("Mozilla/5.0").timeout(15000).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + URL + " FAILED!");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "Connection to URL: " + URL + " FAILED!"});
				Logger.info("---------------------------------------------------");
				continue;
			}
			try {
				String breadcrumbText = doc.select("ul.breadcrumb").first().text();
				int navigationMenuElementsCount = doc.select("ul.navigation>li").size();
				String drugNameText = doc.select("#top-bar h1").first().text();
				String reviewsCounter = "";
				try {
					reviewsCounter = doc.select(".review-links a").first().text();
				} catch (NullPointerException e) {
					reviewsCounter = "No reviews for this drug";
				}
				String basicsSectionContent = doc.select("#basics>.section_content").first().text();
				String sideEffectsSectionContent = doc.select("#sideeffects>.section_content").first().text();
				String interactionsSectionContent = doc.select("#interactions>.section_content").first().text();
				String dosageSectionContent = doc.select("#dosage>.section_content").first().text();
				String faqSectionContent = "";
				String faqSectionContent1 = "";
				String faqSectionContent2 = "";
				String faqSectionContent3 = "";
				try {
					String faqText = doc.select("#faq>.section_content").first().text();
					int faqTextLength = faqText.length();
					System.out.println(faqTextLength);
					if (faqTextLength > 32000 && faqTextLength < 64000) {
						faqSectionContent = faqText.substring(0, 31999);
						faqSectionContent1 = faqText.substring(32000, faqTextLength);
					} else if (faqTextLength > 64000 && faqTextLength < 96000) {
						faqSectionContent = faqText.substring(0, 31999);
						faqSectionContent1 = faqText.substring(32000, 63999);
						faqSectionContent2 = faqText.substring(64000, faqTextLength);
					} else if (faqTextLength > 96000) {
						faqSectionContent = faqText.substring(0, 31999);
						faqSectionContent1 = faqText.substring(32000, 63999);
						faqSectionContent2 = faqText.substring(64000, 95999);
						faqSectionContent3 = faqText.substring(96000, faqTextLength);
					} else {
						faqSectionContent = faqText;
					}
				} catch (NullPointerException e) {
					faqSectionContent = "'FAQ' section is not present for this drug";
				}
				data.put(String.valueOf(totalCounter + 1), new Object[]{breadcrumbText, String.valueOf(navigationMenuElementsCount), drugNameText, reviewsCounter, basicsSectionContent, sideEffectsSectionContent, interactionsSectionContent, dosageSectionContent, faqSectionContent, faqSectionContent1, faqSectionContent2, faqSectionContent3});
				Logger.info("Data for drug - '" + link + "' is parsed into Ecxel file");
				Logger.info("-----------------------------------------------------------");
			} catch (NullPointerException e) {
				Logger.info("Data is missing for drug - " + link);
			}
		}
		generateXLSXReport();
	}

	@Test(groups = {"PushArticlesSave"})
	@TestRail(id = "C0010")
	public void pushSaveArticleTest() {
		List<String> links = new CSVparser().getLinksFromCSV();
		WebDriver webDriver = WebDriverManager.getDriver();
		PushDashboardPage pushPage = SiteNavigatorEH.goToPushSelectProductPage().chooseEHProject().clickSelectButton();
		int linksCounter = 1;
		for (String link : links) {
			String url = link;
			Logger.info("URL #" + linksCounter + " - " + url);
			if (linksCounter % 20 == 0) {
				createNewTabAndSwitch(webDriver);
			}
			linksCounter++;
			try {
				webDriver.get(url);
				pushPage.waitForEditPageToLoad();
			} catch (Exception e) {
				Logger.info("Page did not load. URL: " + url);
				continue;
			}
			try {
				pushPage.clickSaveArticleButton();
			} catch (Exception e) {
				Logger.info("'Save article' button is missing for URL: " + url);
				continue;
			}
		}
	}

	@Test(groups = {"ParseDataFromPages"})
	@TestRail(id = "C0011")
	public void parseDataFromPages() {
		Document doc = null;
		List<String> links = new CSVparser().getLinksFromCSV();
		int totalCounter = 1;
		data.put("0", new Object[]{"URL", "data-zone", "Canonical URL", "h1", "h2", "p1"});
		for (String link : links) {
			Logger.info("URL Number: " + totalCounter + ", URL - " + link);
			totalCounter++;
			try {
				doc = Jsoup.connect(link).ignoreContentType(true).timeout(15000).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + link + " FAILED!");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "Connection to URL: " + link + " FAILED!"});
				Logger.info("---------------------------------------------------");
				continue;
			}
			String dataZone = "";
			String canonicalURL = "";
			String h1Text = "";
			String h2Text = "";
			String p1Text = "";
			try {
				dataZone = doc.select("body").attr("data-zone");
				canonicalURL = doc.select("link[rel='canonical']").attr("href");
				h1Text = doc.select("h1").first().text();
				h2Text = doc.select("h2[class*=deck]").first().text();
				p1Text = doc.select(".article-body p").first().text();
			} catch (NullPointerException e) {
			}
			data.put(String.valueOf(totalCounter + 1), new Object[]{link, dataZone, canonicalURL, h1Text, h2Text, p1Text});
		}
		generateXLSXReport();
	}

	@Test(groups = {"ParseDrugsAPIData"})
	@TestRail(id = "C0012")
	public void parseDrugsAPIData() {
		Document doc1 = null;
		List<String> links = new CSVparser().getLinksFromCSV();
		int totalCounter = 1;
		data.put("0", new Object[]{"Drug name", "Basics", "Side Effects", "Interactions", "Dosage", "AdZone", "FAQ"});
		String qa1 = Settings.isQA() ? ".qa1" : "";
		for (String link : links) {
			Logger.info("URL Number: " + totalCounter + ". Drug - " + link);
			totalCounter++;
			String urlDrugsApi = "http://services" + qa1 + ".everydayhealth.com/ContentAPI/api/Content/V1/277/getPage?maskUrl=~/drugs/" + link;
			try {
				doc1 = Jsoup.connect(urlDrugsApi).ignoreContentType(true).timeout(15000).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + urlDrugsApi + " FAILED!");
				Logger.info("---------------------------------------------------");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "Connection to URL: " + urlDrugsApi + " FAILED!"});
				continue;
			}
			try {
				linksCount++;
				JsonParser jsonParserApi = new JsonParser();
				if (doc1.body().text().equals("null")) {
					data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "No data for this drug in API"});
					continue;
				}
				String adZoneText = jsonParserApi.parse(doc1.body().text()).getAsJsonObject().get("AdZoneSettings").getAsJsonObject().get("AdZone").getAsString();
				JsonArray locationsArray = jsonParserApi.parse(doc1.body().text()).getAsJsonObject().get("Content").getAsJsonObject().getAsJsonArray("Locations");
				String basicsText = locationsArray.get(0).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				String sideEffectsText = locationsArray.get(1).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				String interactionText = locationsArray.get(2).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				String dosageText = locationsArray.get(3).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				JsonArray faqArray = locationsArray.get(4).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("AttributeList");
				StringBuilder faqText = new StringBuilder();
				int faqArraySize = faqArray.size();
				for (int arrayItem = 0; arrayItem < faqArraySize; arrayItem++) {
					JsonElement questionText = faqArray.get(arrayItem).getAsJsonArray().get(0).getAsJsonObject().get("Value");
					JsonElement answerText = faqArray.get(arrayItem).getAsJsonArray().get(1).getAsJsonObject().get("Value");
					faqText.append(questionText.getAsString()).append(answerText.getAsString());
				}
				System.out.println(basicsText.length());
				System.out.println(sideEffectsText.length());
				System.out.println(interactionText.length());
				System.out.println(dosageText.length());
				System.out.println(faqText.length());
				System.out.println(adZoneText);
				System.out.println("------------------------");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, basicsText, sideEffectsText, interactionText, dosageText, adZoneText, faqText.toString()});
			} catch (Exception e) {
				//ignore
			}
		}
		generateXLSXReport();
	}

	@Test(groups = {"ParseDrugsAPIImportedData"})
	@TestRail(id = "C0013")
	public void parseDrugsAPIImportedData() {
		Document doc1 = null;
		List<String> links = new CSVparser().getLinksFromCSV();
		int totalCounter = 1;
		data.put("0", new Object[]{"Drug name", "Basics", "Side Effects", "Interactions", "Dosage", "AdZone", "FAQ"});
		String qa1 = Settings.isQA() ? ".qa1" : "";
		for (String link : links) {
			Logger.info("URL Number: " + totalCounter + ". Drug - " + link);
			totalCounter++;
			String urlDrugsApi = "http://services" + qa1 + ".everydayhealth.com/ContentAPI/api/Content/V1/0/getImportedPage?maskUrl=~/drugs/" + link;
			try {
				doc1 = Jsoup.connect(urlDrugsApi).ignoreContentType(true).timeout(15000).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + urlDrugsApi + " FAILED!");
				Logger.info("---------------------------------------------------");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "Connection to URL: " + urlDrugsApi + " FAILED!"});
				continue;
			}
			try {
				linksCount++;
				JsonParser jsonParserApi = new JsonParser();
				if (doc1.body().text().equals("null")) {
					data.put(String.valueOf(totalCounter + 1), new Object[]{link, "FAILED", "No data for this drug in API"});
					continue;
				}
				JsonArray locationsArray = jsonParserApi.parse(doc1.body().text()).getAsJsonObject().get("Content").getAsJsonObject().getAsJsonArray("Locations");
				String adZoneText = jsonParserApi.parse(doc1.body().text()).getAsJsonObject().get("AdZoneSettings").getAsJsonObject().get("AdZone").getAsString();
				String basicsText = locationsArray.get(0).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				String sideEffectsText = locationsArray.get(1).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				String interactionText = locationsArray.get(2).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				String dosageText = locationsArray.get(3).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("Attributes").get(1).getAsJsonObject().get("Value").getAsString();
				JsonArray faqArray = locationsArray.get(4).getAsJsonObject().getAsJsonArray("Sections").get(0).getAsJsonObject().getAsJsonArray("AttributeList");
				StringBuilder faqText = new StringBuilder();
				int faqArraySize = faqArray.size();
				for (int arrayItem = 0; arrayItem < faqArraySize; arrayItem++) {
					JsonElement questionText = faqArray.get(arrayItem).getAsJsonArray().get(0).getAsJsonObject().get("Value");
					JsonElement answerText = faqArray.get(arrayItem).getAsJsonArray().get(1).getAsJsonObject().get("Value");
					faqText.append(questionText.getAsString()).append(answerText.getAsString());
				}
				System.out.println(basicsText.length());
				System.out.println(sideEffectsText.length());
				System.out.println(interactionText.length());
				System.out.println(dosageText.length());
				System.out.println(faqText.length());
				System.out.println(adZoneText);
				System.out.println("------------------------");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, basicsText, sideEffectsText, interactionText, dosageText, adZoneText, faqText.toString()});
			} catch (Exception e) {
				//ignore
			}
		}
		generateXLSXReport();
	}

	@Test(groups = {"ParseBlogArticlesDataForAWSMigration"})
	@TestRail(id = "C0014")
	public void parseBlogsArticle() {
		Document doc1 = null;
		List<String> links = new CSVparser().getLinksFromCSV();
		int totalCounter = 1;
		int postsCounter = 1;
		data.put("0", new Object[]{"URL", "Canonical URL", "Category", "Subcategory", "SEO Title", "SEO Description", "BLOG Article Headline", "BLOG Article Author", "BLOG Article p1"});
		for (String link : links) {
			try {
				doc1 = Jsoup.connect(link).timeout(15000).userAgent("Mozilla/5.0").get();
			} catch (IOException e) {
				e.printStackTrace();
				Logger.info("Connection to URL: " + link + " FAILED!");
				Logger.info("---------------------------------------------------");
				totalCounter++;
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "Connection to URL: " + link + " FAILED!"});
				continue;
			}
			try {
				Logger.info(link);
				totalCounter++;
				String canonicalURL = doc1.select("link[rel='canonical']").first().attr("href");
				String category = doc1.select("body").attr("data-category-name");
				String subCategory = doc1.select("body").attr("data-condition-name");
				String seoTitle = doc1.select("meta[property='og:title']").first().attr("content").trim();
				String seoDescription = doc1.select("meta[property='og:description']").first().attr("content").trim();
				String blogHeadline = doc1.select("h1").first().text();
				String blogAuthor = "";
				try {
					blogAuthor = doc1.select("h3.byline_text").first().text();
				} catch (NullPointerException e) {
					//ignore
				}
				String blogContent = "";
				try {
					blogContent = doc1.select(".article-body").first().text();
					if (blogContent.length() > 250) {
						blogContent = blogContent.substring(0, 250);
					}
				} catch (IndexOutOfBoundsException e) {
					//ignore
				}
				data.put(String.valueOf(totalCounter), new Object[]{link, canonicalURL, category, subCategory, seoTitle, seoDescription, blogHeadline, blogAuthor, blogContent});
			} catch (Exception e) {
				e.printStackTrace();
				data.put(String.valueOf(totalCounter + postsCounter), new Object[]{link});
			}
		}
		generateXLSXReport();
	}

	@Test(groups = {"ParseBlogsNewsletterDataForAWSMigration"})
	@TestRail(id = "C0015")
	public void parseNewsletterIdAndText() {
		Document doc1 = null;
		List<String> links = new CSVparser().getLinksFromCSV();
		int totalCounter = 1;
		data.put("0", new Object[]{"URL", "Newsletter Text", "Newsletter ID"});
		for (String link : links) {
			try {
				doc1 = Jsoup.connect(link).ignoreContentType(true).timeout(15000).get();
			} catch (IOException e) {
				totalCounter++;
				Logger.info("Connection to URL: " + link + " FAILED!");
				Logger.info("---------------------------------------------------");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "Connection to URL: " + link + " FAILED!"});
				continue;
			}
			Logger.info(link);
			totalCounter++;
			String newsletterText;
			String newsletterId;
			if (Settings.isEnvironment(Environment.QA)) {
				newsletterText = doc1.select("body").attr("data-newsletter-text");
				newsletterId = doc1.select("body").attr("data-newsletter-id");
			} else {
				newsletterText = doc1.select(".newsletter-signup p").text();
				newsletterId = doc1.select("form#eh-newsletter-form").attr("data-nlid");
				if (newsletterText.contains("free")) {
					newsletterText = newsletterText.replace("Sign up for the free", "");
				} else {
					newsletterText = newsletterText.replace("Sign up for the", "");
				}
				newsletterText = newsletterText.replace(" newsletter!", "");
			}
			data.put(String.valueOf(totalCounter), new Object[]{link, newsletterText, newsletterId});
		}
		generateXLSXReport();
	}

	@Test(groups = {"ParsePostsOrderForAWSMigration"})
	@TestRail(id = "C0016")
	public void parsePostsOrderOnBlogsLandingPages() {
		Document doc1 = null;
		List<String> links = new CSVparser().getLinksFromCSV();
		int totalCounter = 1;
		int postsCounter = 1;
		data.put("0", new Object[]{"URL", "BLOG ARTICLE Title", "BLOG ARTICLE URL", "BLOG ARTICLE Last Updated", "BLOG ARTICLE Deck"});
		for (String link : links) {
			try {
				doc1 = Jsoup.connect(link).ignoreContentType(true).timeout(15000).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + link + " FAILED!");
				Logger.info("---------------------------------------------------");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "Connection to URL: " + link + " FAILED!"});
				continue;
			}
			try {
				Logger.info(link);
				Elements postItems = doc1.select(".card-recommendation:not(.eh-popular-topics-wrapper)");
				int numberOfPostsOnPage = postItems.size();
				for (int post = 0; post < numberOfPostsOnPage; post++) {
					Element headline = doc1.select(".card-recommendation:not(.eh-popular-topics-wrapper) h3 a").get(post);
					String cardHeadlineText = headline.text();
					String cardHeadlineURL = headline.attr("href");
					String lastUpdate = doc1.select(".card-recommendation:not(.eh-popular-topics-wrapper) .card__post-caption").get(post).text();
					Element deck = doc1.select(".card-recommendation:not(.eh-popular-topics-wrapper) .card__desc").get(post);
					String deckText = deck.text();
					if (deckText.length() > 250) {
						deckText = deckText.substring(0, 250);
					}
					data.put(String.valueOf(totalCounter + postsCounter), new Object[]{link, cardHeadlineText, cardHeadlineURL, lastUpdate, deckText});
					postsCounter++;
				}
			} catch (Exception e) {
				e.printStackTrace();
				data.put(String.valueOf(totalCounter + postsCounter), new Object[]{link});
			}
		}
		generateXLSXReport();
	}

	@Test(groups = {"ParseAvailableBlogLandingPagesForAWSMigration"})
	@TestRail(id = "C0017")
	public void parseBlogsLandingPagination() {
		WebDriver webDriver = WebDriverManager.getDriver();
		List<String> links = new CSVparser().getLinksFromCSV();
		linksCount = links.size();
		int totalCounter = 1;
		int pageCounter = 1;
		data.put("0", new Object[]{"URL"});
		for (String url : links) {
			data.put(String.valueOf(totalCounter + pageCounter), new Object[]{url});
			webDriver.get(url);
			pageCounter++;
			try {
				WebElement webElementPagination = webDriver.findElement(By.cssSelector(".pagination-btn-next"));
				while (webElementPagination != null) {
					webDriver.get(url);
					webElementPagination = webDriver.findElement(By.cssSelector(".pagination-btn-next"));
					url = webElementPagination.getAttribute("href");
					data.put(String.valueOf(totalCounter + pageCounter), new Object[]{url});
					pageCounter++;
				}
			} catch (Exception e) {
				//ignore
				continue;
			}
		}
		generateXLSXReport();
	}

	@Test(groups = {"ParseBlogsLandingDataForAWSMigration"})
	@TestRail(id = "C0018")
	public void parseBlogsLandingData() {
		Document doc1 = null;
		List<String> links = new CSVparser().getLinksFromCSV();
		int totalCounter = 1;
		data.put("0", new Object[]{"URL", "Canonical URL", "Category", "Subcategory", "SEO Title", "SEO Description", "BLOG Headline", "BLOG Description"});
		for (String link : links) {
			try {
				doc1 = Jsoup.connect(link).ignoreContentType(true).timeout(15000).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + link + " FAILED!");
				Logger.info("---------------------------------------------------");
				data.put(String.valueOf(totalCounter + 1), new Object[]{link, "Connection to URL: " + link + " FAILED!"});
				continue;
			}
			try {
				System.out.println(link);
				totalCounter++;
				String canonicalURL = doc1.select("link[rel='canonical']").first().attr("href");
				String seoTitle = doc1.select("meta[property='og:title']").first().attr("content");
				String seoDescription = doc1.select("meta[property='og:description']").first().attr("content");
				String blogHeadline = doc1.select("h1").first().text();
				String blogDescription = doc1.select("h1+h2").first().text();
				String category = doc1.select("body").attr("data-category-name");
				String subCategory = doc1.select("body").attr("data-condition-name");
				data.put(String.valueOf(totalCounter), new Object[]{link, canonicalURL, category, subCategory, seoTitle, seoDescription, blogHeadline, blogDescription});
			} catch (Exception e) {
				e.printStackTrace();
				data.put(String.valueOf(totalCounter), new Object[]{link});
			}
		}
		generateXLSXReport();
	}

	@Test(groups = {"ParseAllURLSOnPage"})
	@TestRail(id = "C0019")
	public void parsePageURLs() {
		List<String> links = new CSVparser().getLinksFromCSV();
		linksCount = links.size();
		Document doc = null;
		int totalCounter = 1;
		data.put("0", new Object[]{"URL", "Number of non-agnostic URLs"});
		for (String url : links) {
			try {
				if (url.contains("~")) {
					url = url.replace("~", Settings.getDefaultUrl());
				}
				Logger.info("Connecting to URL - " + url);
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + url + " FAILED!");
				data.put(String.valueOf(totalCounter + 1), new Object[]{url, "Connection FAILED!"});
				continue;
			}
			try {
				totalCounter++;
				int incorrectURLsCount = 0;
				Elements pageLinks = doc.select("a");
				for (Element e : pageLinks) {
					String href = e.attr("href");
					if (href.contains("everydayhealth.com") || href.contains("agoramedia.com")) {
						if (href.startsWith("http")) {
							incorrectURLsCount++;
						}
					}
				}
				Elements imageSrcs = doc.select("img");
				for (Element e : imageSrcs) {
					String href = e.attr("src");
					if (href.contains("everydayhealth.com") || href.contains("agoramedia.com")) {
						if (href.startsWith("http")) {
							incorrectURLsCount++;
						}
					}
				}
				data.put(String.valueOf(totalCounter), new Object[]{url, String.valueOf(incorrectURLsCount)});
			} catch (Exception exception) {
				Logger.info(exception.getLocalizedMessage());
			}
		}
		generateXLSXReport();
	}

	@Test(groups = {"ParseBrightcoveVideoIDs"})
	@TestRail(id = "C0020")
	public void parseBrightcoveVideoIDs() {
		List<String> links = new CSVparser().getLinksFromCSV();
		linksCount = links.size();
		Document doc = null;
		int totalCounter = 1;
		data.put("0", new Object[]{"URL", "Brightcove video ID"});
		for (String url : links) {
			try {
				if (url.contains("~")) {
					url = url.replace("~", Settings.getDefaultUrl());
				}
				Logger.info("Connecting to URL - " + url);
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				connectionErrorCounter++;
				Logger.info("Connection to URL: " + url + " FAILED!");
				data.put(String.valueOf(totalCounter + 1), new Object[]{url, "Connection FAILED!"});
				continue;
			}
			try {
				totalCounter++;
				String videoId = doc.body().select("div#video-responsive-block").attr("data-video-id");
				if (videoId.isEmpty()) {
					Logger.info("This is Cuso Platform template");
					if (!doc.body().toString().contains("CuSo.Videologues.Data = ")) {
						data.put(String.valueOf(totalCounter), new Object[]{url, "NONE"});
					} else {
						String cusoVideologuesData = doc.body().toString().split("CuSo.Videologues.Data = ")[1];
						cusoVideologuesData = cusoVideologuesData.substring(0, cusoVideologuesData.lastIndexOf(";"));
						JsonParser jsonParser = new JsonParser();
						JsonArray jsonArray = jsonParser.parse(cusoVideologuesData).getAsJsonObject().getAsJsonArray("Slots");
						int arraySize = jsonArray.size();
						for (int arrayElement = 0; arrayElement < arraySize; arrayElement++) {
							videoId = jsonArray.get(arrayElement).getAsJsonObject().get("VideoId").getAsString();
							data.put(String.valueOf(totalCounter), new Object[]{url, String.valueOf(videoId)});
							Logger.info("Video ID - " + videoId);
							totalCounter++;
						}
					}
				} else {
					data.put(String.valueOf(totalCounter), new Object[]{url, String.valueOf(videoId)});
					Logger.info("Video ID - " + videoId);
				}
			} catch (Exception exception) {
				Logger.info(exception.getLocalizedMessage());
			}
		}
		generateXLSXReport();
	}

	private void createNewTabAndSwitch(WebDriver webDriver) {
		Logger.info("Open new tab and close the previous one");
		((JavascriptExecutor) webDriver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs.get(tabs.size() - 1));
		String activeTab = webDriver.getWindowHandle();
		for (String tab : tabs) {
			if (!tab.equals(activeTab)) {
				webDriver.switchTo().window(tab).close();
			}
		}
		webDriver.switchTo().window(activeTab);
	}

	private void generateXLSXReport() {
		try {
			File reportFile = new File(directory.getCanonicalPath() + "/LinkCheckerReport.xlsx");
			Workbook myWorkBook = WorkbookFactory.create(new FileInputStream(reportFile));
			myWorkBook.removeSheetAt(0);
			myWorkBook.createSheet("Report");
			Sheet mySheet = myWorkBook.getSheetAt(0);
			int rownum = mySheet.getTopRow();
			for (String rowNumber : data.keySet()) {
				Row row = mySheet.createRow(rownum++);
				Object[] objArray = data.get(rowNumber);
				int cellNumber = 0;
				for (Object obj : objArray) {
					Cell cell = row.createCell(cellNumber++);
					if (obj.toString().length() > 32000) {
						obj = obj.toString().substring(0, 32000);
					}
					cell.setCellValue((String) obj);
				}
			}
			mySheet.autoSizeColumn(0);
			mySheet.autoSizeColumn(1);
			mySheet.autoSizeColumn(2);
			mySheet.autoSizeColumn(3);
			FileOutputStream fos = new FileOutputStream(reportFile);
			myWorkBook.write(fos);
			System.out.println("Report file is generated");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String removeEncodingIssues(String pageTitle) {
		if (pageTitle.contains("&#39;")) {
			pageTitle = pageTitle.replace("&#39;", "'");
		}
		return pageTitle;
	}

	private void checkStaticValuesOnPage(String url, String protocol) {
		Logger.info("Check static data in page source for URL: " + url);
		assertEquals(JsonUtils.getJsonObjectValue("@context"), protocol + "schema.org", "'@context' object should have 'http://schema.org' value");
		if (!JsonUtils.getJsonObjectValue("@type").equals("Article")) {
			assertEquals(JsonUtils.getJsonObjectValue("@type"), "NewsArticle", "'@type' object should have 'NewsArticle' value");
		}
		assertEquals(JsonUtils.getJsonObjectValue("audience"), "Patients", "'audience' object should have 'Patients' value");
		assertEquals(JsonUtils.getJsonObjectValue("mainEntityOfPage", "@type"), "WebPage", "'@type' parameter of 'mainEntityOfPage' object should have 'WebPage' value");
		assertEquals(JsonUtils.getJsonObjectValue("image", "@type"), "ImageObject", "'@type' parameter of 'image' object should have 'ImageObject' value");
		assertEquals(JsonUtils.getJsonObjectValue("image", "height"), "406", "'height' parameter of 'image' object should have '406' value");
		assertEquals(JsonUtils.getJsonObjectValue("publisher"), publisherStatic, "Wrong value of 'publisher' object");
		assertEquals(JsonUtils.getJsonObjectValue("interactionStatistic", "@type"), "InteractionCounter", "'@type' parameter of 'interactionStatistic' object should have 'InteractionCounter' value");
		assertEquals(JsonUtils.getJsonObjectValue("interactionStatistic", "interactionType"), protocol + "schema.org/CommentAction", "'interactionType' parameter of 'interactionStatistic' object should have 'http://schema.org/CommentAction' value");
	}

	private void checkNonStaticValuesOnPage(Document doc) {
		Logger.info("Get 'data-author' attribute from page source");
		String dataAuthor = doc.select("body").first().attr("data-author");
		assertFalse(dataAuthor.isEmpty(), "'data-author' attribute should not be empty");
		if (JsonUtils.getJsonObjectValue("author").contains(",")) {
			String authorInScript = JsonUtils.getJsonObjectValue("author").split(",")[0];
			assertTrue(dataAuthor.contains(authorInScript.split(" ")[0].trim()), "'data-author' attribute should contain author's name");
			assertTrue(dataAuthor.contains(authorInScript.split(" ")[1].trim()), "'data-author' attribute should contain author's surname");
		} else {
			assertTrue(dataAuthor.contains(JsonUtils.getJsonObjectValue("author").split(" ")[0].trim()), "'data-author' attribute should contain author's name");
			assertTrue(dataAuthor.contains(JsonUtils.getJsonObjectValue("author").split(" ")[1].trim()), "'data-author' attribute should contain author's surname");
		}

		Logger.info("Get 'link' attribute from page source");
		assertEquals(doc.select("body").first().attr("data-page-url"), JsonUtils.getJsonObjectValue("url"), "'url' attribute differs from data in page source");

		Logger.info("Get 'data-page-title' attribute from page source");
		assertEquals(doc.select("meta[property=og:title]").first().attr("content"), removeEncodingIssues(JsonUtils.getJsonObjectValue("name")), "'name' attribute differs from data in page source");

		Logger.info("Get 'link' attribute from page source");
		assertEquals(doc.select("body").first().attr("data-page-url"), JsonUtils.getJsonObjectValue("mainEntityOfPage", "@id"), "'@id' parameter of 'mainEntityOfPage' object differs from data in page source");

		Logger.info("Check 'datePublished' attribute from script");
		String datePublished = JsonUtils.getJsonObjectValue("datePublished");
		assertFalse(datePublished.isEmpty(), "'datePublished' should have some value");
		LocalDateTime.parse(datePublished.substring(0, 19), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

		Logger.info("Check 'dateModified' attribute from script");
		String dateModified = JsonUtils.getJsonObjectValue("dateModified");
		assertFalse(dateModified.isEmpty(), "'dateModified' should have some value");
		LocalDateTime.parse(dateModified.substring(0, 19), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

		Logger.info("Get meta[property=og:title] 'content' attribute from page source");
		assertEquals(doc.select("meta[property=og:title]").first().attr("content"), removeEncodingIssues(JsonUtils.getJsonObjectValue("headline")), "'headline' attribute differs from data in page source");
	}

	private void verifyImageURLandWidth(Document doc) {
		Logger.info("Get 'data-social-share-img-default' attribute from page source");
		String scriptImgURL = JsonUtils.getJsonObjectValue("image", "url");
		String allElements = doc.getAllElements().toString();
		String width = "width=" + JsonUtils.getJsonObjectValue("image", "width");

		if (doc.select("body").first().attr("data-social-share-img-default").equals(scriptImgURL)) {
			Logger.info("'url' parameter of 'image' object equals to 'data-social-share-img-default' attribute. Checking 'width' parameter.");
			assertTrue(doc.select(".content.guide-image").first().attr("src").contains(width), "'width' parameter of 'image' object should be a part of url");
		} else if (allElements.contains("class=\"tertiary_img\"")) {
			Logger.info("'url' parameter of 'image' object is not equal to 'data-social-share-img-default' attribute. Checking tertiary image url.");
			String tertiaryImgLink = doc.select(".tertiary_img").first().child(0).attr("src");
			assertTrue(tertiaryImgLink.contains(scriptImgURL), "'url' parameter of 'image' object differs from data in page source - tertiary image link");
			assertTrue(tertiaryImgLink.contains(width), "'width' parameter of 'image' object should be a part of url");
		} else if (allElements.contains("class=\"secondary-image\"")) {
			Logger.info("'url' parameter of 'image' object is not equal to 'data-social-share-img-default' attribute. Checking secondary image url.");
			String secondaryImgLink = doc.select(".secondary-image").first().child(0).attr("src");
			assertTrue(secondaryImgLink.contains(scriptImgURL), "'url' parameter of 'image' object differs from data in page source - secondary image link");
			assertTrue(secondaryImgLink.contains(width), "'width' parameter of 'image' object should be a part of url");
		}
	}

	private void verifyStringContainsJsonArrayElements(String text, JsonArray jsonArray) {
		int arraySize = jsonArray.size();
		for (int itemNumber = 0; itemNumber < arraySize; itemNumber++) {
			String itemText = jsonArray.get(itemNumber).getAsJsonObject().get("Content").getAsString();
			Logger.info("Verify DrugsAPI contains '" + itemText + "'");
			assertTrue(text.contains(itemText), "DrugsAPI element should contain data from DrugsService");
		}
	}
}
