package framework.platform.utilities;

import framework.Logger;
import framework.platform.DatePatterns;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {
	private static DateTime currentDate = new DateTime();

	public static String getCurrentDateString() {
		return currentDate.toString(DatePatterns.EEEE_MMMMMMMMM_d.getPattern(), Locale.US);
	}

	public static String getCurrentDate(DatePatterns datePattern) {
		return new DateTime().toString(datePattern.getPattern(), Locale.US);
	}

	public static Date getCurrentDate() {
		GregorianCalendar now = new GregorianCalendar();
		return now.getTime();
	}

	public static Date parseDateFromString(String dateAsString, DatePatterns datePatterns) {
		Logger.debug("Parsing date from string " + dateAsString + " with expected date pattern " + datePatterns.getPattern() + ".");
		try {
			return new SimpleDateFormat(datePatterns.getPattern(), Locale.US).parse(dateAsString);
		} catch (ParseException ignored) {
			throw new RuntimeException("Date could not be parsed.");
		}
	}

	public static String getDateInFuture(int days, DatePatterns pattern) {
		return currentDate.plusDays(days).toString(pattern.getPattern(), Locale.US);
	}

	public static String getDateInFuture(int days) {
		return getDateInFuture(days, DatePatterns.EEEE_MMMMMMMMM_d);
	}

	public static String getDayInFuture(int days) {
		return currentDate.plusDays(days).toString("d", Locale.US);
	}

	public static String getDateInPast(int days) {
		return getDateInPast(days, DatePatterns.EEEE_MMMMMMMMM_d);
	}

	public static String getDateInPast(int days, DatePatterns pattern) {
		return currentDate.minusDays(days).toString(pattern.getPattern(), Locale.US);
	}

	public static String getDayInPast(int days) {
		return currentDate.minusDays(days).toString("d", Locale.US);
	}

	public static int getIntDayInPast(int days) {
		return Integer.parseInt(currentDate.minusDays(days).toString("d", Locale.US));
	}

	public static DateTime getPastDate(int month) {
		return currentDate.minusMonths(month);
	}

	public static DateTime getFutureDate(int month) {
		return currentDate.plusMonths(month);
	}

	public static Date addDaysToDate(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); //minus number would decrement the days
		return cal.getTime();
	}

	public static int getCurrentHours(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(cal.HOUR_OF_DAY);
	}

	public static boolean isWeekEndsInTheSameMonth(String weekDates) {
		boolean inOneMonth = true;
		String weekEnd = weekDates.split("-")[1].trim();
		if (Character.isLetter(weekEnd.charAt(0))) {
			inOneMonth = false;
		}
		return inOneMonth;
	}
}
