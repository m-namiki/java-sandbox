/**
 * 
 */
package jp.co.shantery.sandbox.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Properties;

import jp.co.shantery.sandbox.exception.IORuntimeException;

import org.junit.Test;

/**
 * {@link PropertiesUtils}のテストケースです。
 * 
 * @author m-namiki
 * 
 */
public class PropertiesUtilsTest {

	/**
	 * {@link PropertiesUtils#loadProperties(String)}のテストケースです。
	 */
	@Test
	public void testLoadProperties_ファイルが存在する場合() {
		Properties prop = PropertiesUtils.loadProperties("test.properties");
		assertThat(prop, notNullValue());
		assertThat(prop.getProperty("APP_NAME"), is("java-sandbox"));
	}

	/**
	 * {@link PropertiesUtils#loadProperties(String)}のテストケースです。
	 */
	@Test(expected = IORuntimeException.class)
	public void testLoadProperties_ファイルが存在しない場合() {
		PropertiesUtils.loadProperties("nonexist.properties");
	}
}
