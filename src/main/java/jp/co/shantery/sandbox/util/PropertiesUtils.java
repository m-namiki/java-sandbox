/**
 * 
 */
package jp.co.shantery.sandbox.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

import jp.co.shantery.sandbox.exception.IORuntimeException;

/**
 * {@link Properties}用のユーティリティクラスです。
 * 
 * @author m-namiki
 * 
 */
public class PropertiesUtils {

	/**
	 * 指定された名称のプロパティファイルをロードします。<br>
	 * クラスパス内にプロパティファイルが見つからない、または読み込みに失敗した場合は{@link IORuntimeException}をスローします。
	 * 
	 * @param name
	 *            ファイル名
	 * @return プロパティ
	 */
	public static Properties loadProperties(String name) {
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource(name);
		try {
			if (url == null) {
				throw new FileNotFoundException(name
						+ " is not found in this classpath.");
			}
			URLConnection urlConn = url.openConnection();
			urlConn.setUseCaches(true);
			prop.load(urlConn.getInputStream());
		} catch (IOException e) {
			throw new IORuntimeException(e.getMessage(), e);
		}
		return prop;
	}

}
