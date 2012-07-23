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
public abstract interface SuRenFilter extends Filter {
	static final Logger LOG = Logger.getLogger(SuRenFilter.class);
}
