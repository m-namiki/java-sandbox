package jp.co.shantery.sandbox.util;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * {@link DateUtils}のテストケースです。
 * 
 * @author pcuser
 * 
 */
public class DateUtilsTest {

	/**
	 * {@link DateUtils#getSystemDateString(String)}のテストケースです。
	 */
	@Test
	public void getSystemDateString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		assertThat(format.format(new Date()),
				is(DateUtils.getSystemDateString("yyyyMMdd")));

		format = new SimpleDateFormat("yyyy-MM-dd");
		assertThat(format.format(new Date()),
				is(DateUtils.getSystemDateString("yyyy-MM-dd")));

		format = new SimpleDateFormat("yyyy/MM/dd");
		assertThat(format.format(new Date()),
				is(DateUtils.getSystemDateString("yyyy/MM/dd")));
	}

	/**
	 * {@link DateUtils#formatDateToString(Date, String)}のテストケースです。
	 */
	@Test
	public void formatDateToString() {
		DateTime dateTime = new DateTime(2012, 7, 1, 12, 0, 0);
		assertThat("2012-07-01", is(DateUtils.formatDateToString(
				dateTime.toDate(), "yyyy-MM-dd")));

		assertThat("2012-07-01 12:00:00", is(DateUtils.formatDateToString(
				dateTime.toDate(), "yyyy-MM-dd HH:mm:ss")));
	}

	/**
	 * {@link DateUtils#parseDate(String, String)}のテストケースです。
	 */
	@Test
	public void parseDate_日付が正しい場合() {
		Date date = DateUtils.parseDate("2012-07-01", "yyyy-MM-dd");
		DateTime dateTime = new DateTime(date);
		assertThat(dateTime.toString("yyyy-MM-dd"), is("2012-07-01"));
	}

	/**
	 * {@link DateUtils#parseDate(String, String)}のテストケースです。
	 */
	@Test
	public void parseDate_日付が正しくない場合() {
		assertThat(DateUtils.parseDate("2012-07-aa", "yyyy-MM-dd"), nullValue());
		assertThat(DateUtils.parseDate("2011-07-01", "yyyy/MM/dd"), nullValue());
	}

	/**
	 * {@link DateUtils#isDate(String, String)}のテストケースです。
	 */
	@Test
	public void isDate() {
		assertThat(DateUtils.isDate("2012-07-01", "yyyy-MM-dd"), is(true));
		assertThat(DateUtils.isDate("2012/07/01", "yyyy/MM/dd"), is(true));
		assertThat(DateUtils.isDate("2012-07-aa", "yyyy-MM-dd"), is(false));
		assertThat(DateUtils.isDate("", "yyyy-MM-dd"), is(false));
		assertThat(DateUtils.isDate(null, "yyyy-MM-dd"), is(false));
	}
	
}
