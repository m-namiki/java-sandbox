/**
 * 
 */
package jp.co.shantery.sandbox.cipher;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import jp.co.shantery.sandbox.exception.CipherException;

/**
 * ファイルの暗号化、復号化を行うユーティリティクラスです。
 * 
 * @author m2-namiki
 * 
 */
public class CipherUtils {

	// ------------------------------------------------------- [Public methods]

	/**
	 * 指定されたファイルを、指定された鍵を利用して暗号化します。
	 * 
	 * @param file
	 *            ファイル
	 * @param argorism
	 *            アルゴリズム名
	 * @param secretKey
	 *            鍵
	 * @return 暗号化したバイトの配列
	 */
	public static byte[] encrypt(File file, String argorism, String secretKey) {

		byte[] data = null;

		try {
			Cipher cipher = createCipher(Cipher.ENCRYPT_MODE, argorism,
					secretKey);

			byte[] array = convertImageToByteArray(file);

			data = cipher.doFinal(array);

		} catch (Exception e) {
			throw new CipherException(e);
		}
		return data;
	}

	/**
	 * 指定されたバイトデータを復号化してファイルに出力します。
	 * 
	 * @param destFile
	 *            出力先ファイル
	 * @param array
	 *            バイトデータ
	 * @param argorism
	 *            アルゴリズム名
	 * @param secretKey
	 *            キー
	 * @return ファイル
	 */
	public static File decrypt(File destFile, byte[] array, String argorism,
			String secretKey) {
		try {
			Cipher cipher = createCipher(Cipher.DECRYPT_MODE, argorism,
					secretKey);
			byte[] data = cipher.doFinal(array);

			try (BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(destFile))) {
				out.write(data);
				out.flush();
			}
		} catch (Exception e) {
			throw new CipherException(e);
		}
		return destFile;
	}

	// ------------------------------------------------------ [Private methods]

	/**
	 * 指定されたモードとキーから暗号化制御用のオブジェクトを作成します。
	 * 
	 * @param mode
	 *            モード
	 * @param argorism
	 *            アルゴリズム名
	 * @param secretKey
	 *            キー
	 * @return 暗号化制御用オブジェクト
	 * @throws GeneralSecurityException
	 *             暗号化制御の作成に失敗した場合
	 */
	private static Cipher createCipher(int mode, String argorism,
			String secretKey) throws GeneralSecurityException {

		Cipher cipher = null;
		cipher = Cipher.getInstance(argorism);
		cipher.init(mode, new SecretKeySpec(secretKey.getBytes(), argorism));

		return cipher;

	}

	/**
	 * 指定されたファイルを読み込みバイト配列に変換します。
	 * 
	 * @param target
	 *            対象ファイル
	 * @return バイト配列
	 * @throws IOException
	 *             ファイルの読み込みに失敗した場合
	 */
	private static byte[] convertImageToByteArray(File target)
			throws IOException {
		byte[] data = null;
		try (BufferedInputStream in = new BufferedInputStream(
				new FileInputStream(target))) {
			data = new byte[(int) target.length()];
			while (true) {
				int len = in.read(data);
				if (len < 0) {
					break;
				}
			}
		}
		return data;
	}

}
