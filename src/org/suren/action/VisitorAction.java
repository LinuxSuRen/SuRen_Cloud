/**
 *
 */
package org.suren.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.suren.entity.Visitor;
import org.suren.servcie.VisitorService;

/**
 * @author suren
 *
 */
public class VisitorAction extends BaseAction
{

	private static final long	serialVersionUID	= 1L;

	@Autowired
	private VisitorService service;

	private List<Visitor> visitors;

	@Override
	public String execute()
	{
		visitors = service.find(null);

		return SUCCESS;
	}

	/**
	 * @return the visitors
	 */
	public List<Visitor> getVisitors()
	{
		return visitors;
	}
}
