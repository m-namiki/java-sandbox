/**
 * 
 */
package jp.co.shantery.sandbox.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

/**
 * 非同期で実行されるタスクを表すクラスです。
 * 
 * @author m2-namiki
 * 
 */
public class ConcurrentTask implements Callable<Integer> {

	private int number;

	public ConcurrentTask(int number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {

		DateTime startTime = DateTime.now();

		TimeUnit.MILLISECONDS.sleep(1000L);

		DateTime finishTime = DateTime.now();

		System.out.println("[" + number + "] "
				+ startTime.toString("HH:mm:ss.SSS") + " - "
				+ finishTime.toString("HH:mm:ss.SSS"));
		return number;
	}

}
