/**
 *
 */
package org.suren.task;

import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 * @author suren
 *
 */
public abstract class Task  extends TimerTask{
	protected static final Logger log = Logger.getLogger(Task.class);

	abstract String getName();
	abstract String desc();
}
