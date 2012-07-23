/**
 *
 */
package org.suren.dao;

import java.util.Date;

import org.springframework.stereotype.Service;
import org.suren.entity.Visitor;

/**
 * @author suren
 *
 */
@Service
public class VisitorDaoIpmi extends BaseDao<Visitor> implements VisitorDao
{

	@Override
	public void saveModule(Visitor visitor)
	{
		if(visitor != null)
		{
			visitor.setDate(new Date());

			this.save(visitor);
		}
	}

	@Override
	public Class<?> setClass()
	{
		return Visitor.class;
	}

}
