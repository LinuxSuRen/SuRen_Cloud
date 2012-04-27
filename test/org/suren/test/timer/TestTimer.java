/**
 *
 */
package org.suren.test.timer;

import java.util.Timer;

import org.suren.task.ReportTask;

/**
 * @author suren
 *
 */
public class TestTimer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Timer timer = new Timer("test");

		timer.schedule(new ReportTask(), 1000, 30000);

		System.out.println(timer);
	}

}
