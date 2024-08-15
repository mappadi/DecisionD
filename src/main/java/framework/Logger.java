package framework;

import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Logger
 */
public class Logger extends Reporter {

	protected final static org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);

	public static void info(String log) {
		logger.info(log);
		log(log + "</br>");
	}

	public static void err(String log) {
		logger.error(log);
	}

	public static void knownIssue(String log) {
		logger.debug("Possible issue: " + log);
		log("BUG:" + log + "</br>");
	}

	public static String getTicketForFailedTest(ITestResult result) {
		int num = getOutput(result).size();
		String reason = "";
		try {
			reason = getOutput(result).get(num - 1).split("BUG:")[1].split("</br>")[0];
		} catch (Exception e) {
			reason = "N/A";
		}
		return reason;
	}

	public static List<String> getTestInfoLogsList(ITestResult result) {
		return getOutput(result).stream().filter(u -> !u.contains("BUG")).collect(Collectors.toList());
	}

	public static void debug(String log) {
		logger.debug(log);
	}
}
