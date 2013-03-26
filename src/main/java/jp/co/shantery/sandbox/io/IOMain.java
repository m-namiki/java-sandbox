/**
 * 
 */
package jp.co.shantery.sandbox.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Java7のAutoCloseableのサンプルクラスです。
 * 
 * @author pcuser
 * 
 */
public class IOMain {

	private static final String PATH = "C:\\tmp\\auto_closeable.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File file = new File(PATH);

		// ファイルの書き出し
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write("aaaaa");
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ファイルの読み込み
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			System.out.println(reader.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 自前のオブジェクト
		try (MyResource myResource = new MyResource()) {
			System.out.println(myResource.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("finish");
	}
}
