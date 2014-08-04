/**
 * 
 */
package jp.co.shantery.sandbox.concurrent;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 指定されたタスクを非同期実行するためのクラスです。
 * 
 * @author m2-namiki
 * 
 */
public class AsyncProcessor {

	public static void execute(List<Callable<Integer>> tasks)
			throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(200);
		executor.invokeAll(tasks);
		executor.shutdown();

	}

}
