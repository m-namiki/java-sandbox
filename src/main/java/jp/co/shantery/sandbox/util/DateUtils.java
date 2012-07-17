/**
 * 
 */
package jp.co.shantery.sandbox.util;

import org.joda.time.DateTime;

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

}
