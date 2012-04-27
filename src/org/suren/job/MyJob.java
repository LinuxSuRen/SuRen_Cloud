/**
 *
 */
package org.suren.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suren.task.WeatherTask;

/**
 * @author suren
 *
 */
@Service
public class MyJob implements Job {

	@Autowired
	private WeatherTask task;

	/* (non-Javadoc)
	 * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("jobj......." + task);
	}

}
