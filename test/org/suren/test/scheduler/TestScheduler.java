/**
 *
 */
package org.suren.test.scheduler;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author suren
 *
 */
public class TestScheduler {

	/**
	 * @param args
	 * @throws SchedulerException
	 */
	public static void main(String[] args) throws SchedulerException {
//		SchedulerFactory sf = new StdSchedulerFactory();
//
//		Scheduler scheduler = sf.getScheduler();
//
//		JobDetail job = org.quartz.JobBuilder.newJob(org.suren.job.MyJob.class).withIdentity("firstJob", "jobGroup").build();
//
//		Trigger trigger = org.quartz.TriggerBuilder.newTrigger().withIdentity("firstTrigger", "triggerGroup").startNow().build();
//
//		scheduler.scheduleJob(job, trigger);
//
//		scheduler.start();
	}
}
