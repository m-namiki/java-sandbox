/**
 * 
 */
package jp.co.shantery.sandbox.ssh;

import java.util.Properties;

import jp.co.shantery.sandbox.util.PropertiesUtils;

/**
 * ssh.propertiesの内容を保持するクラスです。
 * 
 * @author m-namiki
 * 
 */
public class SSHProperties {

	/** プロパティファイル名です。 */
	private static final String FILE_NAME = "ssh.properties";

	/** 当クラスで保持するプロパティです。 */
	private static Properties prop;

	/**
	 * 指定されたキーに該当する値を返却します。
	 * 
	 * @param key
	 *            キー
	 * @return 値
	 */
	public static String get(String key) {
		return load().getProperty(key);
	}

	/**
	 * プロパティファイルをロードします。
	 * 
	 * @return プロパティ
	 */
	private static Properties load() {
		if (prop == null) {
			prop = PropertiesUtils.loadProperties(FILE_NAME);
		}
		return prop;
	}
}
