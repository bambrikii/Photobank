package org.bambrikii.photobank.business.tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.bambrikii.photobank.business.managers.imageprocessing.AbstractImageManagerHandler;
import org.junit.Test;

public class FileName2DateParserTests {
	@Test
	public void test1() {
		Date dateNow = new Date();

		SimpleDateFormat dateformatYYYYMMDD = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dateformatMMDDYYYY = new SimpleDateFormat("MMddyyyy");

		StringBuilder nowYYYYMMDD = new StringBuilder(
				dateformatYYYYMMDD.format(dateNow));
		StringBuilder nowMMDDYYYY = new StringBuilder(
				dateformatMMDDYYYY.format(dateNow));

		System.out.println("DEBUG: Today in YYYYMMDD: '" + nowYYYYMMDD + "'");
		System.out.println("DEBUG: Today in MMDDYYYY: '" + nowMMDDYYYY + "'");

	}

	@Test
	public void parseTest1() throws ParseException {
		System.out.printf("%s\n",
				AbstractImageManagerHandler.parseDate("00", "00", "00"));
		System.out.printf("%s\n",
				AbstractImageManagerHandler.parseDate("10", "10", "20"));
	}

	private class DateAggregate {
		private Integer year;
		private Integer month;
		private Integer day;

		public DateAggregate(Integer year, Integer month, Integer day) {
			setYear(year);
			setMonth(month);
			setDay(day);
		}

		private void setYear(Integer year) {
			this.year = year;
		}

		public String getYearStr() {
			if (year == 1) {
				return AbstractImageManagerHandler.ZERO_TIME;
			}
			Integer year2 = year - year
					/ AbstractImageManagerHandler.YEAR_LIMIT
					* AbstractImageManagerHandler.YEAR_LIMIT;
			return String.format("%02d", year2);
		}

		private void setMonth(Integer month) {
			this.month = month;
		}

		public String getMonthStr() {
			return String.format("%02d", month);
		}

		private void setDay(Integer day) {
			this.day = day;
		}

		public String getDayStr() {
			if (day == 1) {
				return AbstractImageManagerHandler.ZERO_TIME;
			}
			return String.format("%02d", day);
		}

		public String toAggrString() {
			return String.format("%02d %02d %02d", year, month, day);
		}

		public Calendar parseAndGetCalendar() throws ParseException {
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(AbstractImageManagerHandler.parseDate(getYearStr(),
					getMonthStr(), getDayStr()));
			return cal2;
		}
	}

	@Test
	public void testZeroTimeCalendars() throws ParseException {

		Calendar cal1 = Calendar.getInstance();
		cal1.set(1, 0, 1, 0, 0, 0);

		DateAggregate dateAggr = new DateAggregate(cal1.get(Calendar.YEAR),
				cal1.get(Calendar.MONTH), cal1.get(Calendar.DAY_OF_MONTH));
		System.out.printf("	Source date: %s\n", dateAggr.toAggrString());

		Calendar cal2 = dateAggr.parseAndGetCalendar();
		System.out.printf("%s\n", cal2.getTime());

		assertCompareDates(cal1, cal2);
	}

	@Test
	public void testOverCurrentTimeCalendars() throws ParseException {
		Calendar currTime = Calendar.getInstance();

		Calendar cal1 = Calendar.getInstance();
		cal1.set(currTime.get(Calendar.YEAR) + 1, currTime.get(Calendar.MONTH),
				currTime.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

		DateAggregate dateAggr = new DateAggregate(cal1.get(Calendar.YEAR),
				cal1.get(Calendar.MONTH) + 1, cal1.get(Calendar.DAY_OF_MONTH));
		System.out.printf("	Source date: %s\n", dateAggr.toAggrString());

		Calendar cal2 = dateAggr.parseAndGetCalendar();

		cal1.set(Calendar.YEAR, cal1.get(Calendar.YEAR)
				- AbstractImageManagerHandler.YEAR_LIMIT);
		assertCompareDates(cal1, cal2);
	}

	@Test
	public void testEqualCalendars() throws ParseException {
		Calendar currTime = Calendar.getInstance();

		Calendar cal1 = Calendar.getInstance();
		cal1.set(currTime.get(Calendar.YEAR), currTime.get(Calendar.MONTH),
				currTime.get(Calendar.DAY_OF_MONTH), 0, 0, 0);

		DateAggregate dateAggr = new DateAggregate(cal1.get(Calendar.YEAR),
				cal1.get(Calendar.MONTH) + 1, cal1.get(Calendar.DAY_OF_MONTH));
		System.out.printf("	Source date: %s\n", dateAggr.toAggrString());

		Calendar cal2 = dateAggr.parseAndGetCalendar();

		assertCompareDates(cal1, cal2);
	}

	private void assertCompareDates(Calendar cal1, Calendar cal2) {
		System.out.printf("	%s\n	%s\n", cal1.getTime(), cal2.getTime());
		Assert.assertEquals(cal1.get(Calendar.YEAR), cal2.get(Calendar.YEAR));
		Assert.assertEquals(cal1.get(Calendar.MONTH), cal2.get(Calendar.MONTH));
		Assert.assertEquals(cal1.get(Calendar.DAY_OF_MONTH),
				cal2.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(cal1.get(Calendar.HOUR), cal2.get(Calendar.HOUR));
		Assert.assertEquals(cal1.get(Calendar.MINUTE),
				cal2.get(Calendar.MINUTE));
		Assert.assertEquals(cal1.get(Calendar.SECOND),
				cal2.get(Calendar.SECOND));
	}

	@Test
	public void yearTest1() {
		System.out.printf("%s\n",
				(int) Calendar.getInstance().get(Calendar.YEAR) / 100);
	}
}
