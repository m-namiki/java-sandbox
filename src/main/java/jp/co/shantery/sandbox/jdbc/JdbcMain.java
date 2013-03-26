/**
 * 
 */
package jp.co.shantery.sandbox.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBCのサンプルクラスです。
 * 
 * @author pcuser
 * 
 */
public class JdbcMain implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JdbcMain self = new JdbcMain();
		self.run();
	}

	@Override
	public void run() {

		try (Connection conn = getConnection();
				PreparedStatement pst = conn.prepareStatement("");
				ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private Connection getConnection() {
		return null;
	}

}
