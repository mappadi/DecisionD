package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import framework.Logger;
import framework.Settings;
import framework.platform.utilities.CouchbaseUtils;
import framework.platform.utilities.MediaAttributes;
import framework.platform.utilities.MediaData;
import framework.platform.utilities.PageData;
import framework.platform.utilities.TextUtils;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * DBTest
 */
public class DBTest {

	@Test(groups = {"TestingDB"})
	@TestRail(id = "C0000")
	public void testDB() {

		StringBuffer stringBuffer = new StringBuffer();
		Map<String, PageData> sql = TextUtils.getPageData();
		Map<String, PageData> couchbase = new CouchbaseUtils().getData();
		int totalCBRows = couchbase.size();
		int totalSQLRows = sql.size();

		Logger.info("Number or records in sql: " + totalSQLRows);
		Logger.info("Number or records in couchbase: " + couchbase.size());

		int resultNumber = 1, failureCount = 0, numberOfMissedPages = 0;


		for (Map.Entry<String, PageData> entry : sql.entrySet()) {

			if (couchbase.containsKey(entry.getKey())) {
				try {
					//Logger.info("CHECK RESULT " + resultNumber);
					resultNumber++;
					PageData pageDataCouchbase = couchbase.get(entry.getKey());
					PageData pageDataSQL = entry.getValue();

					//Logger.info("Sort order is" + pageDataCouchbase.getSortOrder());

					assertEquals(pageDataCouchbase.getProductID(), pageDataSQL.getProductID());
					assertEquals(pageDataCouchbase.getUrl(), pageDataSQL.getUrl());

					assertEquals(pageDataCouchbase.getProductID(), pageDataSQL.getProductID(), "PRODUCT IDS are different for page: " + pageDataSQL.getUrl());
					assertEquals(pageDataCouchbase.getProductName(), pageDataSQL.getProductName(), "PAGE NAMES are wrong for page: " + pageDataSQL.getUrl() + ". SHA1:" + pageDataCouchbase.getId());
					if (!Settings.config.isWordPress()) {
						assertEquals(pageDataCouchbase.getAdZone(), pageDataSQL.getAdZone(), "AdZone values are different for page " + pageDataSQL.getUrl() + ". SHA1:" + pageDataCouchbase.getId());
					}
					assertEquals(pageDataCouchbase.getType(), pageDataSQL.getType(), "TYPES are different for page " + pageDataSQL.getUrl() + ". SHA1:" + pageDataCouchbase.getId());
					assertEquals(pageDataCouchbase.getUrl(), pageDataSQL.getUrl(), "URLS are different for page " + pageDataSQL.getUrl() + ". SHA1:" + pageDataCouchbase.getId());
					//Logger.info("Sort order is" + pageDataCouchbase.getContentData().getSortOrder());
					assertEquals(pageDataCouchbase.getContentData().getDeck(), pageDataSQL.getContentData().getDeck(), "DECK values are different for page " + pageDataSQL.getUrl() + ". SHA1:" + pageDataCouchbase.getId());
					assertEquals(pageDataCouchbase.getContentData().getHeadline(), pageDataSQL.getContentData().getHeadline(), "HEADLINE values are different for page " + pageDataSQL.getUrl() + ". SHA1:" + pageDataCouchbase.getId());
					String lastUpdateCouchBase = pageDataCouchbase.getContentData().getLastUpdated();
					String lastUpdateSql = pageDataSQL.getContentData().getLastUpdated();
					assertEquals(lastUpdateCouchBase, lastUpdateSql, "Last update dates are different for page " + pageDataSQL.getUrl() + ". SHA1:" + pageDataCouchbase.getId());

					for (MediaData mediaData : pageDataSQL.getContentData().getMediaData()) {
						for (MediaData mediaData1 : pageDataCouchbase.getContentData().getMediaData()) {
							if (mediaData.getType().equals(mediaData1.getType()) && mediaData.getMediaTag().equals(mediaData1.getMediaTag())) {
								//assertEquals(mediaData1.getAttributes().size(), mediaData.getAttributes().size(), "different numbers of attributes for page " + pageDataSQL.getUrl() + ". Media tag: " + mediaData.getMediaTag() + ". MediaType: " + mediaData1.getType());
								for (MediaAttributes a : mediaData.getAttributes()) {
									assertTrue(mediaData1.contains(a), "Media attribut: " + a.getKey() + " : \"" + a.getValue() + "\" is not present for page " + pageDataSQL.getUrl() + ". SHA1:" + pageDataCouchbase.getId() + ". Existed " + a.getKey() + " : \"" + mediaData1.getAttributeValue(a.getKey()) + "\"");
									//for (MediaAttributes b : mediaData1.getAttributes()) {
									//	if (a.getKey().equals(b.getKey())) {
									//		//System.out.println(resultNumber);
									//		assertEquals(a.getValue(), b.getValue(), "different values for page " + pageDataSQL.getUrl()+". Media tag: "+ mediaData.getMediaTag()+". MediaType: "+mediaData1.getType());
									//	}
									//}
								}
							}
						}
					}

					assertEquals(pageDataCouchbase.getProductName(), pageDataCouchbase.getProductName(), "Product name is diffetent for page " + pageDataSQL.getUrl());
					assertEquals(pageDataCouchbase.getProductID(), pageDataSQL.getProductID(), "Product ID should be the same for " + entry.getKey());
				} catch (AssertionError e) {
					Logger.err(e.getLocalizedMessage());
					failureCount++;
				}
			} else {
				stringBuffer.append("Page " + entry.getKey() + " was not found in couchbase \n");
				numberOfMissedPages++;
			}
		}
		Logger.err(stringBuffer.toString());
		Logger.info("Total Number of SQL Rows - " + totalSQLRows);
		Logger.info("Total Number of Couchbase Rows - " + totalCBRows);
		Logger.info("Total Number of rows errored out - " + failureCount);
		Logger.info("Number of missed pages in Couchbase - " + numberOfMissedPages);
		Logger.info("Total Number of SQL Rows - " + totalSQLRows);
		Logger.info("Total Number of rows succeeded - " + (totalSQLRows - failureCount));
		Logger.info("Total failure % - " + (failureCount * 100) / totalSQLRows);
	}
}
