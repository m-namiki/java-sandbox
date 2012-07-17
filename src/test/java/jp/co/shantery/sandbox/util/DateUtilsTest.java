package jp.co.shantery.sandbox.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;

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

}
