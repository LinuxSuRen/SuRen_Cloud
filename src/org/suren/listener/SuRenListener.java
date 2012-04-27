/**
 *
 */
package org.suren.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

/**
 * @author suren
 *
 */
public class SuRenListener implements ServletContextListener {

	protected static final Logger log = Logger.getLogger(SuRenListener.class);

	private Timer timer;

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		log.debug("context destroyed");

//		timer.cancel();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		log.debug("context contextInitialized");

//		SchedulerFactory sf = new StdSchedulerFactory();
//
//		try {
//			Scheduler scheduler = sf.getScheduler();
//
//			JobDetail job = JobBuilder.newJob(MyJob.class).build();
//
//			Trigger trigger = TriggerBuilder.newTrigger().startNow().build();
//
//			scheduler.scheduleJob(job, trigger);
//
//			scheduler.start();
//		} catch (SchedulerException e) {
//			log.error(e.getMessage());
//		}
	}

}
