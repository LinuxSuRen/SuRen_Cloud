/**
 *
 */
package org.suren.servcie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suren.dao.VisitorDao;
import org.suren.entity.Visitor;

/**
 * @author suren
 *
 */
@Service
public class VisitorServiceIpml implements VisitorService
{
	@Autowired
	private VisitorDao dao;

	@Override
	public void save(Visitor visitor)
	{
		dao.saveModule(visitor);
	}

	@Override
	public List<Visitor> find(Visitor visitor)
	{
		return dao.findVisitors(visitor);
	}

}
