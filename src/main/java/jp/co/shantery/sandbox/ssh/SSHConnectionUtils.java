/**
 * 
 */
package jp.co.shantery.sandbox.ssh;

import java.io.File;
import java.io.IOException;

import jp.co.shantery.sandbox.exception.IORuntimeException;
import ch.ethz.ssh2.Connection;

/**
 * SSH接続を行うユーティリティクラスです。
 * 
 * @author m-namiki
 * 
 */
public class SSHConnectionUtils {

	/**
	 * 指定されたアドレスにSSH接続します。<br>
	 * このメソッドでは公開鍵認証でサーバに接続します。
	 * 
	 * @param ipAddress
	 *            接続先アドレス
	 * @return コネクション
	 * @throws IOException
	 *             接続時にIO例外が発生した場合
	 */
	public static Connection getConnection(String ipAddress) throws IOException {
		Connection conn = new Connection(ipAddress);
		conn.connect();
		if (!conn.authenticateWithPublicKey(SSHProperties.get("SSH_USER_ID"),
				new File(SSHProperties.get("PRIVATE_KEY_PATH")),
				SSHProperties.get("PASSPHRESE"))) {
			throw new IORuntimeException(new IOException(
					"SSH Connection failure."));
		}
		return conn;
	}

	/**
	 * 指定されたコネクションをクローズします。
	 * 
	 * @param conn
	 *            コネクション
	 */
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			conn.close();
		}
	}
}
