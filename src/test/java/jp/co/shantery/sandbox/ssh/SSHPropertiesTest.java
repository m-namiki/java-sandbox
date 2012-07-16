/**
 * 
 */
package jp.co.shantery.sandbox.ssh;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * {@link SSHProperties}のテストケースです。
 * 
 * @author m-namiki
 * 
 */
public class SSHPropertiesTest {

	/**
	 * {@link SSHProperties#get(String)}のテストケースです。
	 */
	@Test
	public void testGet() {
		assertThat(SSHProperties.get("SSH_USER_ID"), is("m_namiki"));
		assertThat(SSHProperties.get("PRIVATE_KEY_PATH"),
				is("/path/to/privatekey"));
		assertThat(SSHProperties.get("PASSPHRESE"), is("passphrese"));
	}

}
