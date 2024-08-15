package framework.platform.utilities;


import framework.Logger;
import framework.platform.DatePatterns;
import org.apache.commons.lang.RandomStringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class StringUtils {

	public static String getOnlyNumbers(String inputString) {
		return inputString.replaceAll("\\D+", "");
	}

	public static String generateRandomStrAlphabetic(int length) {
		return RandomStringUtils.randomAlphabetic(length);
	}

	public static String generateRandomNumeric(int length) {
		return RandomStringUtils.randomNumeric(length);
	}

	public static String generateRandomStrAlphaNumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public static int generateRandomInt(int maxNumber) {
		return new Random().nextInt(maxNumber);
	}

	public static int generateRandomIntInRange(int lowerBound, int upperBound) {
		return ThreadLocalRandom.current().nextInt(lowerBound, upperBound);
	}

	public static synchronized String generateRandomEmail() {
		return (DateUtils.getCurrentDate(DatePatterns.MM_dd_HH_mm_ss) + StringUtils.generateRandomStrAlphaNumeric(7) + "@mailinator.com").toLowerCase();
	}

	private static Set<String> uniqueEmails = new HashSet<>();

	public static synchronized String generateMPTQATimestampEmail() {
		String email = mptEmail();
		while (uniqueEmails.contains(email)) {
			Utils.waitFor(1000);
			email = mptEmail();
		}
		uniqueEmails.add(email);
		return email;
	}

	private static String mptEmail() {
		return ("MPTQA_" + DateUtils.getCurrentDate(DatePatterns.MMDDYYYYHHmmss) + "@mailinator.com").toLowerCase();
	}

	public static boolean isAtLeastOneWordPresentInSentence(String word, String sentence){
		boolean isPartPresent = false;
		for (String part : word.split(" ")) {
			if (sentence.contains(part)) {
				isPartPresent = true;
				break;
			}
		}
		return isPartPresent;
	}

	public static boolean isSortedAsc(String firstStr, String secondStr) {
		String digitsString = "1234567890";
		firstStr = firstStr.toLowerCase().replace(" ", "");
		secondStr = secondStr.toLowerCase().replace(" ", "");
		if (digitsString.contains(firstStr.substring(0, 1))) {
			if (!digitsString.contains(secondStr.substring(0, 1))) {
				return true; //digit is greater, than other character in postgres
			}
		}
		if (!digitsString.contains(firstStr.substring(0, 1))) {
			if (digitsString.contains(secondStr.substring(0, 1))) {
				return false; //digit is greater, than other character in postgres
			}
		}
		for (int i = 0; i < (Math.min(firstStr.length(), secondStr.length())); i++) {
			if (firstStr.charAt(i) == ' ') {
				if (secondStr.charAt(i) != ' ') {
					return false; //space is greater, than other character in postgres
				}
			}
			if (firstStr.charAt(i) != secondStr.charAt(i)) {
				return firstStr.charAt(i) < secondStr.charAt(i); //different chars on one position
			}
		}
		return firstStr.length() <= secondStr.length(); //one of strings contains another
	}

	public static boolean isSortedAscLexicographically(String firstStr, String secondStr) {
		Logger.knownIssue("https://everydayhealth.atlassian.net/browse/EHF-4187");
		return firstStr.compareToIgnoreCase(secondStr) <= 0; // second word is equal or lexicographically follows firstStr
	}

	public static ArrayList<String> getAlphabetCharacters() {
		ArrayList<String> alphabetCharacters = new ArrayList<>();
		for (char letter = 'A'; letter <= 'Z'; letter++) {
			alphabetCharacters.add(String.valueOf(letter));
		}
		return alphabetCharacters;
	}

	public static String decodeString(String decodeStr) {
		String firstStr = null;
		try {
			firstStr = java.net.URLDecoder.decode(decodeStr, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String secondStr = null;
		try {
			secondStr = java.net.URLDecoder.decode(firstStr, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return secondStr;
	}

	public static String convertToSha1Hash(String data) {
		byte[] sha1hash = new byte[40];
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(data.getBytes("UTF8"), 0, data.length());
			sha1hash = md.digest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toHexString(sha1hash);
	}

	private static String toHexString(byte[] bytes) {
		Formatter formatter = new Formatter();

		for (byte b : bytes) {
			formatter.format("%02x", b);
		}

		return formatter.toString();
	}

	public static String getLastCharacterOfString(String text) {
		String lastChar = (text.substring(text.length() - 1));
		return lastChar;
	}

	public static int countSubstring(String subStr, String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i).startsWith(subStr)) {
				count++;
			}
		}
		return count;
	}
}
