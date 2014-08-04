/**
 * 
 */
package jp.co.shantery.sandbox.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * 非同期処理を実行するメインクラスです。
 * 
 * @author m2-namiki
 * 
 */
public class ConcurrentMain implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConcurrentMain self = new ConcurrentMain();
		self.run();
	}

	@Override
	public void run() {

		List<Callable<Integer>> tasks = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			tasks.add(new ConcurrentTask(i));
		}

		try {
			AsyncProcessor.execute(tasks);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
