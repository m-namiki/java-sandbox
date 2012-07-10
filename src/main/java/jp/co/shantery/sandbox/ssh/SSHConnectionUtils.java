/**
 * 
 */
package jp.co.shantery.sandbox.ssh;

import java.io.IOException;

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

		return conn;
	}

}
