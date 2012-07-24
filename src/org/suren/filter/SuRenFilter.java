/**
 *
 */
package org.suren.filter;

import javax.servlet.Filter;

import org.apache.log4j.Logger;

/**
 * @author suren
 *
 */
public abstract class SuRenFilter implements Filter {
	protected static final Logger LOG = Logger.getLogger(SuRenFilter.class);

	protected String initLogMsg()
	{
		return getClass().getSimpleName() + " is completed.";
	}

	protected String destroyLogMsg()
	{
		return getClass().getSimpleName() + " had destroyed.";
	}

}
