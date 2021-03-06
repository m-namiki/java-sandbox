/**
 * 
 */
package jp.co.shantery.sandbox.util;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * 日付情報を操作するユーティリティクラスです。
 * 
 * @author m-namiki
 * 
 */
public class DateUtils {

	/**
	 * システム日付を指定された形式の文字列で返却します。
	 * 
	 * @param pattern
	 *            日付形式
	 * @return 日付の文字列
	 */
	public static String getSystemDateString(String pattern) {
		return DateTime.now().toString(pattern);
	}

	/**
	 * 指定された日付を指定された形式の文字列で返却します。
	 * 
	 * @param date
	 *            日付
	 * @param pattern
	 *            日付形式
	 * @return 日付の文字列
	 */
	public static String formatDateToString(Date date, String pattern) {
		DateTime dateTime = new DateTime(date.getTime());
		return dateTime.toString(pattern);
	}

	/**
	 * 指定された日付文字列と形式をもとに日付情報に変換します。<br>
	 * 日付文字列が正しい日付でない場合は<code>null</code>を返却します。
	 * 
	 * @param str
	 *            日付文字列
	 * @param pattern
	 *            日付形式
	 * @return 日付情報
	 */
	public static Date parseDate(String str, String pattern) {
		DateTime dateTime = null;
		try {
			dateTime = DateTime.parse(str, DateTimeFormat.forPattern(pattern));
		} catch (IllegalArgumentException e) {
			return null;
		}
		return dateTime.toDate();
	}

	/**
	 * 指定された文字列が、正しい日付か判定します。<br>
	 * このメソッドでは日付を厳密に解釈するため、実際に存在しない日付（13月や2月30日）を指定した場合は<code>false</code>
	 * を返します。
	 * 
	 * @param value
	 *            文字列
	 * @return 日付として正しい場合は<code>true</code>、そうでない場合は<code>false</code>
	 */
	public static boolean isDate(String value, String pattern) {
		if (StringUtils.isBlank(value) || StringUtils.isBlank(pattern)) {
			return false;
		}
		if (parseDate(value, pattern) != null) {
			return true;
		}
		return false;
	}
}
