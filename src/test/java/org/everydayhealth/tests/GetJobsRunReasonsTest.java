package org.everydayhealth.tests;

import com.testrail.framework.platform.annotations.TestRail;
import framework.Logger;
import framework.adapters.WebDriverManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileWriter;

public class GetJobsRunReasonsTest {

	@Test(groups = {"GetJobsRunReasonsTest"})
	@TestRail(id = "C11111")
	public void getReasons() {
		WebDriverManager.getDriver().get("http://10.133.122.231:8080/api/json");
		StringBuilder html = new StringBuilder();
		html.append("<table border=\"1\">");
		try {
			JSONArray jobsList = new JSONArray(getJsonText().split("\"jobs\":")[1]); //get all jobs
			int jobNumber = 0;
			while (jobNumber < jobsList.length()) { //for each job
				JSONObject jobObject = (JSONObject) jobsList.get(jobNumber);
				String jobName = jobObject.getString("url");
				WebDriverManager.getDriver().get(jobName + "/api/json"); //open job json page
				JSONArray build = new JSONArray(getJsonText().split("\"builds\":")[1]); //get list of builds
				int buildNumber = 0;
				String reason;
				String job;
				String person;
				String date;
				while (buildNumber < build.length()) { //for each build
					JSONObject buildObject = (JSONObject) build.get(buildNumber);
					String jobBuild = buildObject.getString("url");
					WebDriverManager.getDriver().get(jobBuild + "/api/json"); //open build json page
					reason = "";
					job = jobBuild;
					person = "";
					date = "";
					try {
						reason = getJsonText().split("\"NotesForTestRuns\",\"value\":\"")[1].split("\"}")[0];
						person = getJsonText().split("userName\":\"")[1].split("\"}")[0];
						job = getJsonText().split("\"fullDisplayName\":\"")[1].split("\",")[0];
						date = getJsonText().split("\"date\":\"")[1].split("T")[0];
					} catch (Exception e) {
						Logger.info("no reason for build " + jobBuild);
					}
					if (!reason.isEmpty() && !job.isEmpty() && !person.toLowerCase().contains("sirota") && !person.toLowerCase().contains("kulikov")
							&& !person.toLowerCase().contains("reshetnyak") && !person.toLowerCase().contains("bilogrud")) {
						html.append("<tr>"); //for each existing record create a new raw
						html.append("<td>").append(date).append("<td>").append(person).append("<td>").append(job).append("<td>").append(reason).append("</td></td></td>"); //add info into table
					}
					html.append("</tr>");
					buildNumber++;
				}
				jobNumber++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		html.append("</table>");
		saveHTML(html.toString());
	}

	private String getJsonText() {
		return WebDriverManager.getDriver().findElement(By.xpath("//pre")).getText();
	}

	private void saveHTML(String html) {
		String htmlFilePath = new File("target/surefire-reports").getAbsolutePath() + "/Reasons.html";
		File htmlDirectoryPath = new File("target/surefire-reports");
		if (!htmlDirectoryPath.exists()) {
			if (!htmlDirectoryPath.mkdirs()) {
				throw new RuntimeException("Failed to create directory: " + htmlDirectoryPath + ".");
			}
		}
		try (FileWriter innerHTMLWriter = new FileWriter(htmlFilePath)) {
			innerHTMLWriter.write(html);
		} catch (Exception e) {
			Logger.info("Failed to get or save HTML: " + e + ". See screenshot.");
		}
	}

}
